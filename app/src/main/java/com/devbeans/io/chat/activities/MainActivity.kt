package com.devbeans.io.chat.activities

import android.Manifest.permission
import android.annotation.SuppressLint
import android.content.*
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.*
import android.os.Build.VERSION
import android.provider.Settings
import android.view.*
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityMainBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationChannelsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.*
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.RetrofitClient.Companion.getUnsafeOkHttpClient
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.GetConversationResponse
import com.devbeans.io.chat.receiver.WebSocketConnectReceiver
import com.devbeans.io.chat.services.BackgroundService
import com.devbeans.io.chat.services.KeyDeficiencyService
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.components.voice.VoiceNoteMediaController
import com.devbeans.io.chat.utils.components.voice.VoiceNoteMediaControllerOwner
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import com.devbeans.io.chat.verifypin.DialogReceiver
import com.devbeans.io.chat.websocket.ChatWebSocket
import com.devbeans.io.chat.websocket.WebSocketConnectionState
import com.devbeans.io.chat.websocket.WebSocketStateChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.virgilsecurity.keyknox.utils.Serializer.Companion.gson
import kotlinx.coroutines.*
import okhttp3.*
import retrofit2.Call
import java.io.File
import kotlin.system.measureTimeMillis


//*************************************************
class MainActivity : BaseActivity(), VoiceNoteMediaControllerOwner, ExpiryCallback,
    WebSocketStateChangeListener
//*************************************************
{
    private var check: Boolean = false
    var mBinding: ActivityMainBinding? = null
    var conversations = conversationsDao.allConversations
    var networkBroadcast: NetworkReceiver? = null
    var mediaController: VoiceNoteMediaController? = null

    val GET_UPDATED_CONVERSATION = "MainActivity getUpdatedConversation: "


    //*************************************************

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?)
    //*************************************************
    {
        super.onCreate(savedInstanceState)
        INSTANCE = this
//        permissions
        networkBroadcast = NetworkReceiver()
        mediaController = VoiceNoteMediaController(this@MainActivity)
        WindowUtil.setStatusBarColor(window,AndroidUtil.getColor(R.color.bg_window_fill_color))
        registerNetworkReceiver()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding!!.bottomNav.itemIconTintList = null
        addUpdateBadge()
        try {
            runService()
        } catch (e: Exception) {
            Log.e(TAG, "Exception in starting service ${e.printStackTrace()}")
        }



        if (AppSession.getBoolean(Constants.FIRST_RUN, true)) {
            if (VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                Permissions.with(this@MainActivity).request(
                    permission.CAMERA,
                    permission.READ_EXTERNAL_STORAGE,
                    permission.MANAGE_EXTERNAL_STORAGE,
                    permission.WRITE_EXTERNAL_STORAGE,
                    permission.RECORD_AUDIO,
                    permission.SCHEDULE_EXACT_ALARM
                ).ifNecessary().onAllGranted {
                    //                    runService()
                }.onAnyDenied {
                    Log.e(TAG, "Permission Denied")
                }.execute()
            }

            AppSession.put(Constants.FIRST_RUN, false)
        }
        val navController = Navigation.findNavController(this, R.id.fl_container)
        NavigationUI.setupWithNavController(mBinding!!.bottomNav, navController)
        MainApp.appContext!!.currentActivity = this
        MainApp.appContext?.setNotifyExpiry(this)


    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        Permissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    /**
     * Extension fun for bottom nav setting Badge Layout and count
     */
    fun BottomNavigationView.setBadge(tabResId: Int, badgeValue: Int) {
        getOrCreateBadge(this, tabResId)?.let { badge ->
            badge.visibility = if (badgeValue > 0) {
                badge.text = "$badgeValue"
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun getOrCreateBadge(bottomBar: View, tabResId: Int): TextView? {
        val parentView = bottomBar.findViewById<ViewGroup>(tabResId)
        return parentView?.let {
            var badge = parentView.findViewById<TextView>(R.id.menuItemBadge)
            if (badge == null) {
                LayoutInflater.from(parentView.context)
                    .inflate(R.layout.item_badge, parentView, true)
                badge = parentView.findViewById(R.id.menuItemBadge)
            }
            badge
        }
    }

    /**
     * add badge(notification dot) to bottom bar
     * @param position to get badge container
     */
    @SuppressLint("PrivateResource")
    fun addUpdateBadge() {


        if (!conversationsDao.liveConversations?.hasActiveObservers()!!) {
            conversationsDao.liveConversations?.observe(this@MainActivity) { conversations: MutableList<Conversation?>? ->
                var count = 0
                conversations?.forEach { conversation ->
                    var messages = messagesDao.getUnReadMessages(
                        conversation?.conversationId, Constants.DELIVERED, conversation?.myMoniker
                    )
                    count += messages?.size ?: 0
                    messages = null
                }

                setCount(count, TAG)
                count = 0
            }
        }
    }

    fun setCount(count: Int, s: String) {
        getBottomNav()?.setBadge(R.id.homeFragment, count)
    }


    fun getBottomNav(): BottomNavigationView? = mBinding?.bottomNav

    fun getMediaControl(): VoiceNoteMediaController {
        return VoiceNoteMediaController(this@MainActivity)
    }

    /**
     * Connect or Reconnect [WebSocket] when lifecycle event [onResume] is called
     */
    override fun onResume() {

        MainApp.appContext!!.currentActivity = this
        MainApp.appContext?.setNotifyExpiry(this)
        LocalBroadcastManager.getInstance(this@MainActivity)
            .registerReceiver(DialogReceiver(), IntentFilter("com.chat.verify.pin"))
        LocalBroadcastManager.getInstance(this@MainActivity)
            .registerReceiver(WebSocketConnectReceiver(), IntentFilter("com.socket.connect"))

        addUpdateBadge()
        if (Utills.isNetworkAvailable() && isSocketConnected.value != null && !isSocketConnected.value!!) {
            initiateSocketConnection("MainActivity")
        }
        super.onResume()
    }


    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(this@MainActivity).unregisterReceiver(DialogReceiver())
        LocalBroadcastManager.getInstance(this@MainActivity)
            .unregisterReceiver(WebSocketConnectReceiver())
    }

    override fun onDestroy() {
        unregisterNetworkReceiver()
        LocalBroadcastManager.getInstance(this@MainActivity).unregisterReceiver(DialogReceiver())
        LocalBroadcastManager.getInstance(this@MainActivity)
            .unregisterReceiver(WebSocketConnectReceiver())
        conversationsDao.liveConversations?.removeObservers(this@MainActivity)
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return false
    }


    fun initiateSocketConnection(tag: String) {

        if (!check && AppSession.getUser() != null && !AppSession.getUser().chatUserId.isNullOrEmpty() && !Utills.isSubscriptionExpired()) {
            val url = Configurations.webSocketURL + AppSession.getUser().chatUserId
            val client = getUnsafeOkHttpClient()
            val request = Request.Builder().url(url).build()


            Log.e(TAG, "socket connect $tag")

            webSocket = client!!.newWebSocket(request, SocketListener())
            chatWebSocket = ChatWebSocket(webSocket, WebSocketConnectionState.CONNECTING)
        }

        check = true
    }

    fun reInitiateSocketConnection(tag: String) {

        if (AppSession.getUser() != null && !AppSession.getUser().chatUserId.isNullOrEmpty() && !Utills.isSubscriptionExpired() && !isSocketConnected.value!!) {
            val url = Configurations.webSocketURL + AppSession.getUser().chatUserId
            val client = getUnsafeOkHttpClient()
            val request = Request.Builder().url(url).build()


            Log.e(TAG, "reInitiateSocketConnection socket connect $tag")

            webSocket = client!!.newWebSocket(request, SocketListener())
            chatWebSocket = ChatWebSocket(webSocket, WebSocketConnectionState.CONNECTED)
        }
    }


    private val permissions: Unit
        @RequiresApi(Build.VERSION_CODES.R) get() {
            if (!checkPermission()) {
                requestPermission()
            }
            ActivityCompat.requestPermissions(
                this@MainActivity, arrayOf(
                    permission.READ_EXTERNAL_STORAGE,
//                    permission.MANAGE_EXTERNAL_STORAGE,
                    permission.WRITE_EXTERNAL_STORAGE
                ), 1
            )
        }

    private fun checkPermission(): Boolean {
        return if (VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else {
            val result = ContextCompat.checkSelfPermission(
                applicationContext, permission.READ_EXTERNAL_STORAGE
            )
            val result1 = ContextCompat.checkSelfPermission(
                applicationContext, permission.WRITE_EXTERNAL_STORAGE
            )
            result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun requestPermission() {
        if (VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                intent.addCategory("android.intent.category.DEFAULT")
                intent.data = Uri.parse(String.format("package:%s", applicationContext.packageName))
                startActivityForResult(intent, 2296)
            } catch (e: Exception) {
                val intent = Intent()
                intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                startActivityForResult(intent, 2296)
            }
        } else {
            //below android 11
            ActivityCompat.requestPermissions(
                this, arrayOf(permission.WRITE_EXTERNAL_STORAGE), RequestCodes.WRITE_PERMISSION
            )
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun registerNetworkReceiver() {
        if (VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(
                networkBroadcast, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
        }
        if (VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(
                networkBroadcast, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
        }
    }

    protected fun unregisterNetworkReceiver() {
        try {
            unregisterReceiver(networkBroadcast)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    private fun sendAnonymousConfirmMember(
        actualPayload: Payload, conversation: Conversation
    ) {


        //If this payload is not sent the user will keep recieving acknowledgement of the particular actualPayload.getType()
        val payload2 = Payload()
        payload2.type = Constants.TYPES.CONFIRM_ANONYMOUS_GROUP_CONV_CREATED
        payload2.conversationId = actualPayload.conversationId
        payload2.conversationType = actualPayload.conversationType
        payload2.messageId = actualPayload.messageId
        payload2.senderId = conversation.myMoniker
        payload2.createdAt = actualPayload.createdAt
        payload2.data = actualPayload.data
        payload2.ack_id = actualPayload.messageId
        payload2.userChatId = conversation.myMoniker

        //was sending this with delay but due to multiple message being received delay was removed
        val encPayload = EncryptionUtils.encryptPayload(payload2)!!
        chatWebSocket?.sendMessage(encPayload)


    }


    private fun sendConfirmMember(actualPayload: Payload, type: String) {


        //If this payload is not sent the user will keep recieving acknowledgement of the particular actualPayload.getType()
        val payload2 = Payload()
        payload2.type = type
        payload2.conversationId = actualPayload.conversationId
        if (type.equals(
                "confirm_ack_block", ignoreCase = true
            ) || type.equals("confirm_ack_unblock", ignoreCase = true)
        ) {
            payload2.conversationId = " "
            payload2.conversationId = " "
        }
        payload2.conversationType = actualPayload.conversationType
        payload2.messageId = actualPayload.messageId
        payload2.senderId = actualPayload.senderId
        payload2.createdAt = actualPayload.createdAt
        payload2.data = actualPayload.data
        payload2.ack_id = actualPayload.messageId
        payload2.userChatId = AppSession.getUser().chatUserId

        var conversation: Conversation? = null
        if (!actualPayload.conversationId.isNullOrEmpty()) conversation =
            conversationsDao.getConversation(actualPayload.conversationId)

        conversation?.let {
            if (conversation.conversationType.equals(
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                )
            ) {
                conversation.myMoniker?.let {
                    payload2.userChatId = conversation.myMoniker
                } ?: run {
                    val member = conversation.conversationMembers?.find {
                        it.isMe
                    }
                    member?.let {
                        conversationsDao.updateMyMoniker(
                            conversation.conversationId, member.moniker
                        )
                        payload2.userChatId = member.moniker
                    }

                }
            }
        }


        //was sending this with delay but due to multiple message being received delay was removed
        if (checkAckPayload(conversation, actualPayload, type)) {
            Log.e(TAG, "Sending Confirm Ack== $payload2")
            val encPayload = EncryptionUtils.encryptPayload(payload2)!!
            chatWebSocket?.sendMessage(encPayload)
        }

    }

    private fun checkAckPayload(
        conversation: Conversation?, actualPayload: Payload, type: String
    ): Boolean {
        return conversation != null || actualPayload.type.equals(
            Constants.TYPES.GROUP_CONV_CREATED, ignoreCase = true
        ) || actualPayload.type.equals(
            Constants.TYPES.VIEW_ONCE, ignoreCase = true
        ) || actualPayload.type.equals(
            Constants.TYPES.DESTROY_GROUP, ignoreCase = true
        ) || type.equals(
            "confirm_ack_block", ignoreCase = true
        ) || type.equals("confirm_ack_unblock", ignoreCase = true) || (type.equals(
            "confirm_ack_leave_group", ignoreCase = true
        ) && actualPayload.conversationType.equals(
            Constants.TYPES.CONVERSATION_GROUP, ignoreCase = true
        )) || (type.equals(
            Constants.TYPES.CONFIRM_ACK_IS_VIEW_ONCE, ignoreCase = true
        ) && actualPayload.conversationType.equals(
            Constants.TYPES.CONVERSATION_GROUP, ignoreCase = true
        )) || (type.equals(
            Constants.TYPES.CONFIRM_ACK_IS_CONFIDENTIAL_CHANGE, ignoreCase = true
        ) && actualPayload.conversationType.equals(
            Constants.TYPES.CONVERSATION_GROUP, ignoreCase = true
        )) || (type.equals(
            Constants.TYPES.CONFIRM_ACK_IS_MEDIA_SHARE_RESTRICT_CHANGE, ignoreCase = true
        ) && actualPayload.conversationType.equals(
            Constants.TYPES.CONVERSATION_GROUP, ignoreCase = true
        ))
    }

    private fun sendAck(actualPayload: Payload, type: String) {

//        Handler(Looper.getMainLooper()).postDelayed({
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.e(EncryptionUtils.TAG, "CoroutineExceptionHandler got $exception")
        }

        CoroutineScope(Dispatchers.IO).launch(handler) {
            delay(500)
            val payload1 = Payload()
            payload1.type = type
            payload1.conversationId = actualPayload.conversationId
            payload1.conversationType = actualPayload.conversationType
            payload1.messageId = actualPayload.messageId
            payload1.senderId = actualPayload.senderId
            payload1.createdAt = actualPayload.createdAt
//            payload1.data = actualPayload.encrypted_data.contentToString()
//            payload1.data = actualPayload.data
            payload1.ack_id = Utills.getRandomString(5)
            if (type.equals(Constants.TYPES.CONFIRM_ACK_BLOCK_UNKNOWN, ignoreCase = true)) {
                payload1.ack_id = actualPayload.messageId
            }
            payload1.userChatId = AppSession.getUser().chatUserId
            if (actualPayload.conversationType.equals(
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                ) && conversationsDao.getConversation(actualPayload.conversationId) != null
            ) {
                payload1.userChatId =
                    conversationsDao.getConversation(actualPayload.conversationId).myMoniker.toString()
            }

            val encPayload = EncryptionUtils.encryptPayload(payload1)!!
            Log.e(TAG, "Sending  Ack== $payload1")
            chatWebSocket?.sendMessage(encPayload)
        }


//            if (actualPayload!!.secretModel != null) {
//                try {
//                    val secrete =
//                        MainApp.database!!.SecreteKeyDao()!!.getKey(actualPayload!!.secretModel)
//                    if (secrete != null) {
//                        val ivParameter =
//                            IvParameterSpec(Constants.SALT_SYMMETRIC_PARAM)
//                        val secretKey =
//                            FileEncryptionUtils().reGererateKey(secrete.secreteKey)
//                        val encryptedMessage =
//                            MessageEncrptionUtils.decryptMsg(
//                                actualPayload.encrypted_data,
//                                secretKey,
//                                ivParameter
//                            )
//                        actualPayload.data = encryptedMessage
//                        payload1.data = encryptedMessage
//                    } else {
//                        Log.e(TAG, "Secrete Key Not Found")
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            } else {
//                Log.e(TAG, "Secret Model is null")
//            }
//        }, 500)
    }

    //************************************************************
    private fun checkContactNull(memberID: String): Contact?
    //************************************************************
    {
        return contactsDao.getContact(memberID)
    }


    private fun sendAckConfirmation(actualPayload: Payload, type: String) {
        val payload1 = Payload()
        payload1.type = type
        payload1.conversationId = actualPayload.conversationId
        payload1.conversationType = actualPayload.conversationType
        payload1.messageId = actualPayload.messageId
        payload1.createdAt = actualPayload.createdAt
        payload1.senderId = actualPayload.senderId
//        payload1.data = actualPayload.data
//        payload1.data = actualPayload.encrypted_data.contentToString()
        payload1.ack_id = actualPayload.ack_id
        payload1.userChatId = AppSession.getUser().chatUserId

        if (actualPayload.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
            )
        ) {
            val con = conversationsDao.getConversation(actualPayload.conversationId)
            if (con != null) {
                payload1.userChatId = con.myMoniker
            }
        }
        val encPayload = EncryptionUtils.encryptPayload(payload1)!!
        chatWebSocket?.sendMessage(encPayload)

    }

    fun sendKeyDeficiencyAckConfirmation(actualPayload: Payload) {
        val payload1 = Payload()
        payload1.type = Constants.TYPES.CONFIRM_ACK_KEY_DEFICIENCY
        payload1.messageId = actualPayload.messageId
        payload1.senderId = actualPayload.userChatId
        payload1.ack_id = actualPayload.messageId
        payload1.userChatId = AppSession.getUser().chatUserId
        val encPayload = EncryptionUtils.encryptPayload(payload1)!!
        chatWebSocket?.sendMessage(encPayload)

    }


    /**
     * Inner class for liseting to socket every time [onMessage] event is called
     */
    private inner class SocketListener : WebSocketListener(), OnNetworkResponse {
        var payload: Payload? = null
        private var conversation: Conversation? = null
        private var conId = 0

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosed(webSocket, code, reason)
            chatWebSocket?.state = WebSocketConnectionState.DISCONNECTED
            check = false
            Log.e(TAG, "web socket closed")
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosing(webSocket, code, reason)
            chatWebSocket?.state = WebSocketConnectionState.DISCONNECTED
            check = false
            Log.e(TAG, "onClosing: ")
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            super.onFailure(webSocket, t, response)
            check = false
            Log.e(TAG, t.message)
            chatWebSocket?.state = WebSocketConnectionState.FAILED
            runOnUiThread {
                isSocketConnected.postValue(false)
                if (Companion.webSocket != null) {
                    Companion.webSocket!!.close(1000, null)
                    Companion.webSocket!!.cancel()
                }
            }
        }

        override fun onOpen(webSocket: WebSocket, response: Response) {
            super.onOpen(webSocket, response)
            runOnUiThread {
                chatWebSocket?.state = WebSocketConnectionState.CONNECTED
                isSocketConnected.postValue(true)
                try {
                    MainApp.appContext?.scheduleNextRevealableMessageManager(TAG)
                } catch (e: Exception) {
                    Log.e(TAG, "Error ${e.message}")
                }
            }
        }

        /**
         * This method is called when a message is received from the WebSocket.
         * @param webSocket The WebSocket instance
         * @param data The message received from the WebSocket
         */
        @RequiresApi(Build.VERSION_CODES.O)
        override fun onMessage(webSocket: WebSocket, data: String) {
            super.onMessage(webSocket, data)
            // Start overall stopwatch
            MainApp.stopwatchOverAll = Stopwatch("StopwatchOverAll")
            MainApp.stopwatchOverAll?.split("Message Started")
            // Start stopwatch for this message
            val stopwatch = Stopwatch("Got Message and Sending for Decrypt from Websocket")
            stopwatch.split("Got Message")
            if (data.isNotEmpty()) {
                if (data == Constants.TYPES.PONG) {
                    // Stop WebSocket state check listener
                    BackgroundService.context?.webSocketStateCheckListener?.stop()
                    chatWebSocket?.state = WebSocketConnectionState.CONNECTED
                } else {
                    // Handle non-empty data
                    handleData(data)
                }
            }
        }

        /**
         * Handles the given data by decrypting the payload and processing it accordingly.
         *
         * @param data The data to be handled.
         */
        @RequiresApi(Build.VERSION_CODES.O)
        private fun handleData(data: String) {
            var plainPayload: Payload? = null

            val channelCallBack = object : EncryptionUtils.ReceiverCallback {
                override fun returnPayload(decryptedPayload: Payload?) {

                    decryptedPayload?.let {
                        //Check is for decrypting only text message it can be changed if other type of payloads needs encryption
                        when (EncryptionUtils.checkTextPayload(decryptedPayload)) {
                            true -> {
                                ChatExecutors.RECEIVE.execute {
                                    handlePrevDecryptPayload(prevEncryptedPayload, decryptedPayload)
                                }
                            }
                            false -> {
                                plainPayload = decryptedPayload
                                handleMessage(plainPayload)
                            }

                        }

                    } ?: run {
                        Log.e(TAG, "initial Payload was null after decrypting from SIK ")
                    }
                }
            }

            val callback = object : EncryptionUtils.ReceiverCallback {
                override fun returnPayload(decryptedPayload: Payload?) {

                    decryptedPayload?.let {
                        val stopwatchChannelCheckedMade = Stopwatch("Got in Channel Exist/Made")
                        stopwatchChannelCheckedMade.split("Channel made/exist")
                        //Check is for decrypting only text message it can be changed if other type of payloads needs encryption
                        ChatExecutors.RECEIVE.execute {
                            when (EncryptionUtils.checkTextPayload(decryptedPayload)) {
                                true -> {
                                    stopwatchChannelCheckedMade.split("Sent to Decrypt with Channel")
//                            ChatExecutors.SERIAL.execute {
                                    prevEncryptedPayload?.let {
                                        if (checkPrevPayload(
                                                prevEncryptedPayload!!,
                                                decryptedPayload
                                            )
                                        ) {
                                            prevEncryptedPayload = decryptedPayload
                                        } else {
                                            prevEncryptedPayload = decryptedPayload
                                            plainPayload =
                                                EncryptionUtils.decryptPayloadWithChannel(
                                                    decryptedPayload, channelCallBack
                                                )
                                            handleMessage(plainPayload)
                                        }
                                    } ?: run {
                                        prevEncryptedPayload = decryptedPayload
                                        val payload = EncryptionUtils.decryptPayloadWithChannel(
                                            decryptedPayload, channelCallBack
                                        )
                                        handleMessage(payload)
                                    }

//                            }
                                    stopwatchChannelCheckedMade.stop(Stopwatch.TAG)

                                }
                                false -> {
                                    plainPayload = decryptedPayload
                                    handleMessage(plainPayload)
                                }


                            }
                        }
                    } ?: run {
                        Log.e(TAG, "initial Payload was null after decrypting from SIK ")
                    }

                }

            }

            val time = measureTimeMillis {
                Log.e(TAG, "sent to simple decrypt payload from server")
                Log.e(TAG, "Sent for decrypting $data")
                EncryptionUtils.decryptPayload(data, callback)

            }
            Log.e("Time", "Time after complete decrypt $time")
        }

        private fun checkPrevPayload(
            prevEncryptedPayload: Payload,
            decryptedPayload: Payload
        ): Boolean {
            return prevEncryptedPayload!!.messageId.equals(
                decryptedPayload.messageId, ignoreCase = true
            ) && !(decryptedPayload.type.equals(Constants.TYPES.EDIT) || decryptedPayload.type.equals(
                Constants.TYPES.DELETE
            ))
        }

        /**
         * Handles the previous decrypted payload by checking its properties and processing it accordingly.
         *
         * @param prevEncryptedPayload The previous encrypted payload.
         * @param decryptedPayload The decrypted payload to be handled.
         */
        @RequiresApi(Build.VERSION_CODES.O)
        private fun handlePrevDecryptPayload(
            prevEncryptedPayload: Payload?, decryptedPayload: Payload
        ) {
            if (prevEncryptedPayload == null ||
                !prevEncryptedPayload.messageId.equals(
                    decryptedPayload.messageId,
                    ignoreCase = true
                ) ||
                decryptedPayload.type.equals(Constants.TYPES.EDIT) ||
                decryptedPayload.type.equals(Constants.TYPES.DELETE)
            ) {
                handlePrevPayload(decryptedPayload)
            } else {
                Companion.prevEncryptedPayload = decryptedPayload
            }
        }

        @RequiresApi(Build.VERSION_CODES.O)
        private fun handlePrevPayload(decryptedPayload: Payload) {
            prevEncryptedPayload = decryptedPayload

            val plainPayload = EncryptionUtils.decryptPayloadWithChannel(
                decryptedPayload, null
            )

            handleMessage(plainPayload)

        }


        /**
         * Handles the given payload by checking its properties and processing it accordingly.
         *
         * @param plainPayload The payload to be handled.
         */
        @RequiresApi(Build.VERSION_CODES.O)
        fun handleMessage(plainPayload: Payload?) {
            // Run the code on the UI thread
            runOnUiThread {
                try {
                    // Check if the payload type is not null and not equal to KEY_DEFICIENCY
                    if (plainPayload?.type != null && plainPayload.type != Constants.TYPES.KEY_DEFICIENCY) {
                        // Check if the payload is valid
                        if (checkPayload(plainPayload)) {
                            // Handle text payload
                            handleTextPayload(plainPayload)
                        } else {
                            // Handle other types of messages
                            handleOtherMessages(plainPayload)
                        }
                    } else {
                        // Handle key deficiency
                        handleKeyDef(plainPayload)
                    }
                } catch (e: Exception) {
                    // Log any exceptions that occur
                    Log.e(TAG, "onMessage: =======" + e.message)
                    Log.e(TAG, "onMessage: =======${plainPayload.toString()}")
                }
            }
        }

        private fun handleKeyDef(plainPayload: Payload?) {
            if (plainPayload?.type != null && plainPayload.type.equals(
                    Constants.TYPES.KEY_DEFICIENCY
                )
            ) {
                handleKeyDeficiencyPayload(plainPayload)
            } else {
                Log.e(TAG, "Payload not decrypted")
            }
        }

        /**
         * Handles other types of messages by checking the payload type and processing it accordingly.
         *
         * @param actualPayload The payload to be handled.
         */
        private fun handleOtherMessages(actualPayload: Payload) {
            // Check the payload type and handle it accordingly
            when (actualPayload.type?.lowercase()) {
                // Handle edit payload
                "edit" -> handleEditPayload(actualPayload)
                // Send confirmation for ACK_EDIT
                Constants.TYPES.ACK_EDIT.lowercase() -> sendAckConfirmation(
                    actualPayload, Constants.TYPES.CONFIRM_ACK_EDIT
                )
                // Handle delete payload
                "delete" -> handleDeletePayload(actualPayload)
                // Send confirmation for ACK_DELETE
                Constants.TYPES.ACK_DELETE.lowercase() -> sendAckConfirmation(
                    actualPayload, Constants.TYPES.CONFIRM_ACK_DELETE
                )
                // Handle deliver payload
                Constants.TYPES.ACK_DELIVER.lowercase() -> handleDeliverPayload(actualPayload)
                // Handle read payload
                Constants.TYPES.ACK_READ.lowercase() -> handleReadPayload(actualPayload)
                // Handle view once ACK payload
                Constants.TYPES.ACK_IS_VIEW_ONCE.lowercase() -> handleViewOnceAckPayload(actualPayload)
                // Handle group and block messages
                else -> handleGroupAndBlockMessage(actualPayload)
            }
        }

        private fun handleGroupAndBlockMessage(actualPayload: Payload) {
            if (actualPayload.type.equals(
                    Constants.TYPES.GROUP_IS_CONFIDENTIAL_CHANGE, ignoreCase = true
                )
            ) {
                handleGroupConfidentialPayload(actualPayload)
            } else if (actualPayload.type.equals(
                    Constants.TYPES.GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE, ignoreCase = true
                )
            ) {
                handleGroupMediaRstrictPayload(actualPayload)
            } else if (actualPayload.type.equals(
                    "member_removed", ignoreCase = true
                )
            ) {
                handleMemberRemovePayload(actualPayload)
            } else if (actualPayload.type.equals(
                    "member_added", ignoreCase = true
                )
            ) {
                handleMemberAddedPayload(actualPayload)

            } else if (actualPayload.type.equals(
                    "admin_assigned", ignoreCase = true
                )
            ) {
                handleAdminAssignedPayload(actualPayload)
            } else if (actualPayload.type.equals(
                    "admin_removed", ignoreCase = true
                )
            ) {
                handleAdminRemovedPayload(actualPayload)
            } else if (actualPayload.type.equals(
                    Constants.TYPES.MEMBER_LEAVE, ignoreCase = true
                )
            ) {
                handleMemberLeavePayload(actualPayload)
            } else if (actualPayload.type.equals(
                    "change_owner", ignoreCase = true
                )
            ) {
                handleChangeOwnerPayload(actualPayload)
            } else if (actualPayload.type.equals(
                    Constants.TYPES.GROUP_ICON_CHANGE, ignoreCase = true
                )
            ) {
                handleGroupIconChangePayload(actualPayload)
            } else if (actualPayload.type.equals(
                    Constants.TYPES.GROUP_NAME_CHANGE, ignoreCase = true
                )
            ) {
                handleGroupNameChangePayload(actualPayload)
            } else if (actualPayload.type.equals(
                    Constants.TYPES.GROUP_DES_CHANGE, ignoreCase = true
                )
            ) {
                handleGroupDesChangePayload(actualPayload)
            } else if (actualPayload.type.equals(
                    Constants.TYPES.EXPIRE_MSG, ignoreCase = true
                )
            ) {
                handleExpireChangePayload(actualPayload)
            } else if (actualPayload.type.equals(
                    Constants.TYPES.GROUP_CONV_CREATED, ignoreCase = true
                )
            ) {

                sendConfirmMember(
                    actualPayload, Constants.TYPES.CONFIRM_ACK_GROUP_CONV_CREATED
                )
            } else if (actualPayload.type.equals(
                    Constants.TYPES.ANONYMOUS_GROUP_CONV_CREATED, ignoreCase = true
                )
            ) {
                handleAnonymousConvPayload(actualPayload)
            } else {
                handleBlockUnblockGroup(actualPayload)
            }
        }

        private fun handleBlockUnblockGroup(actualPayload: Payload) {
            if (actualPayload.type.equals(
                    Constants.TYPES.UNBLOCK, ignoreCase = true
                )
            ) {
                sendConfirmMember(
                    actualPayload, Constants.TYPES.CONFIRM_ACK_UNBLOCK
                )
            } else if (actualPayload.type.equals(
                    Constants.TYPES.BLOCK, ignoreCase = true
                )
            ) {
                sendConfirmMember(
                    actualPayload, Constants.TYPES.CONFIRM_ACK_BLOCK
                )
            } else if (actualPayload.type.equals(
                    Constants.TYPES.SIR, ignoreCase = true
                )
            ) {
                //this was being used for SIR
            } else if (actualPayload.type.equals(
                    Constants.TYPES.DESTROY_GROUP, ignoreCase = true
                )
            ) {
                handleGroupDestroyPayload(actualPayload)
            } else if (actualPayload.type.equals(
                    Constants.TYPES.VIEW_ONCE, ignoreCase = true
                )
            ) {
                handleViewOncePayload(actualPayload)
            }
        }

        private fun handleKeyDeficiencyPayload(plainPayload: Payload) {
//Check if previously keys are uploaded
            if (SettingsValues.getKeyUploaded()) {

                if (!KeyDeficiencyService.isRunning) {
                    val intent = Intent(this@MainActivity, KeyDeficiencyService::class.java)
                    val payload = gson.toJson(plainPayload)
                    intent.putExtra(Constants.KEYS.INTENT_PAYLOAD, payload)

                    this@MainActivity.startService(intent)
                }


                Log.e(TAG, "Keys were initially uploaded")
            }
            Log.e(TAG, "Payload KEY DEFICIENCY")
        }

        private fun handleViewOncePayload(actualPayload: Payload) {

            if (conversationsDao!!.getConversation(actualPayload.conversationId) != null) {
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                val viewOnce = splits[0].toBooleanStrict()
                conversationsDao.updateViewOnce(actualPayload.conversationId, viewOnce)
            }
            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_VIEW_ONCE
            )
        }

        private fun handleGroupDestroyPayload(actualPayload: Payload) {
            if (conversationsDao!!.getConversation(actualPayload.conversationId) != null) {
                conversationsDao.updateRemovedConversation(actualPayload.conversationId)
                if (getInstance() != null && getInstance()?.conversation != null) {
                    getInstance()?.removedFromConvo(actualPayload.conversationId!!)
                }
            }

            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_DESTROY_GROUP
            )
        }

        private fun handleAnonymousConvPayload(actualPayload: Payload) {

            payload = actualPayload
            if (conversationsDao!!.getConversation(actualPayload.conversationId) != null) {
                sendAnonymousConfirmMember(
                    actualPayload, conversationsDao.getConversation(actualPayload.conversationId)
                )
            } else {
                getConversation(actualPayload.conversationId!!)
            }

        }

        private fun handleExpireChangePayload(actualPayload: Payload) {
            payload = actualPayload
            if (messagesDao!!.getMessage(actualPayload.messageId) == null) try {
                messagesDao!!.insert(actualPayload)
                if (!actualPayload.userChatId.equals(
                        AppSession.getUser().chatUserId, ignoreCase = true
                    )
                ) {
                    updateExpiryConversation(actualPayload)
                } else {
                    getInstance()?.loadNotifyMessage(actualPayload)
                }
            } catch (e: Exception) {
                Log.e(
                    TAG, Constants.MESSAGE + Constants.TYPES.CONFIRM_ACK_GROUP_NAME_CHANGE, e
                )
            }
            sendConfirmMember(
                actualPayload, Constants.TYPES.ACK_CON_EX_CHANGE
            )
        }

        private fun updateExpiryConversation(actualPayload: Payload) {
            if (conversationsDao!!.getConversation(actualPayload.conversationId) != null) {
                val expiryTime: Long
                try {
                    val splits = actualPayload.data!!.split("&&").toTypedArray()
                    expiryTime = Utills.getDisappearingOptionsString(splits[0])
                    conversationsDao.updateExpireTime(
                        actualPayload.conversationId, expiryTime
                    )
                    val conversation =
                        conversationsDao.getConversation(actualPayload.conversationId)
                    if (ChatDetailsActivity.getDetailsInstance()!!.mConversation != null && ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                            conversation!!.conversationId, ignoreCase = true
                        )
                    ) {
                        ChatDetailsActivity.getDetailsInstance()!!.mConversation = conversation
                        ChatDetailsActivity.getDetailsInstance()!!.initViews()
                    }
                    if (getInstance()?.conversation != null && getInstance()?.conversation!!.conversationId.equals(
                            conversation!!.conversationId, ignoreCase = true
                        )
                    ) {
                        getInstance()?.conversation = conversation
                        getInstance()?.initViews()
                    }
                } catch (e: Exception) {
                    Log.e(
                        TAG, Constants.MESSAGE + Constants.TYPES.GROUP_DES_CHANGE, e
                    )
                }
                getInstance()?.loadNotifyMessage(actualPayload)
            } else {
                getConversation(actualPayload.conversationId!!)
            }

        }

        private fun handleGroupDesChangePayload(actualPayload: Payload) {
            payload = actualPayload
            var groupName: String? = null
            try {
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                groupName = splits[0]
            } catch (e: Exception) {
                Log.e(
                    TAG, Constants.MESSAGE + Constants.TYPES.GROUP_DES_CHANGE, e
                )
            }
            getInstance()?.loadNotifyMessage(actualPayload)
            if (conversationsDao.getConversation(actualPayload.conversationId) != null && groupName != null) {
                conversationsDao.updateConversationDes(
                    payload!!.conversationId, groupName
                )
            }
            val conversation = conversationsDao.getConversation(actualPayload.conversationId)
            if (conversation != null) {
                updateGroupDesConversation(conversation, actualPayload)
            } else {
                getConversation(actualPayload.conversationId!!)
            }
            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_GROUP_DES_CHANGE
            )
        }

        private fun updateGroupDesConversation(conversation: Conversation, actualPayload: Payload) {
            if (messagesDao!!.getMessage(actualPayload.messageId) == null) {
                try {
                    messagesDao!!.insert(actualPayload)
                    if (ChatDetailsActivity.getDetailsInstance()!!.mConversation != null && ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                            conversation.conversationId, ignoreCase = true
                        )
                    ) {
                        ChatDetailsActivity.getDetailsInstance()!!.mConversation = conversation
                        ChatDetailsActivity.getDetailsInstance()!!.initViews()
                    }
                    if (getInstance()?.conversation != null && getInstance()?.conversation!!.conversationId.equals(
                            conversation.conversationId, ignoreCase = true
                        )
                    ) {
                        getInstance()?.conversation = conversation
                        getInstance()?.initViews()
                    }
                } catch (e: Exception) {
                    Log.e(
                        TAG, Constants.MESSAGE + Constants.TYPES.CONFIRM_ACK_GROUP_NAME_CHANGE, e
                    )
                }
            }
        }

        private fun handleGroupNameChangePayload(actualPayload: Payload) {
            payload = actualPayload
            var groupName: String? = null
            try {
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                groupName = splits[0]
            } catch (e: Exception) {
                Log.e(
                    TAG, Constants.MESSAGE + Constants.TYPES.GROUP_NAME_CHANGE, e
                )
            }
            getInstance()?.loadNotifyMessage(actualPayload)
            updateGroupNameConversation(actualPayload, groupName)
            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_GROUP_NAME_CHANGE
            )

        }

        private fun updateGroupNameConversation(actualPayload: Payload, groupName: String?) {
            conversationsDao.getConversation(actualPayload.conversationId)?.let {
                groupName?.let {

                    val nam = NameUtil.getAbbreviation(
                        conversationsDao.getConversation(actualPayload.conversationId)!!.name!!
                    )
                    nam?.let {
                        val file =
                            File(MainApp.imagesPathConv + "/" + nam + AvatarColor.GROUP.serialize() + ".jpg")
                        if (file.exists()) {
                            file.delete()
                        }
                    }

                    conversationsDao.updateConversationName(
                        payload!!.conversationId, groupName
                    )
                }
            }
            val conversation = conversationsDao.getConversation(actualPayload.conversationId)
            conversation?.let {
                checkMessageInDb(conversation, actualPayload)
            } ?: run {
                getConversation(actualPayload.conversationId!!)
            }
        }

        private fun checkMessageInDb(conversation: Conversation, actualPayload: Payload) {
            if (messagesDao.getMessage(actualPayload.messageId) == null) {
                try {
                    messagesDao!!.insert(actualPayload)

                    ChatDetailsActivity.getDetailsInstance()!!.mConversation?.let {
                        if (ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                                conversation.conversationId, ignoreCase = true
                            )
                        ) {
                            ChatDetailsActivity.getDetailsInstance()!!.mConversation = conversation
                            ChatDetailsActivity.getDetailsInstance()!!.initViews()
                        }
                    }


                    getInstance()?.conversation?.let {
                        if (getInstance()?.conversation!!.conversationId.equals(
                                conversation.conversationId, ignoreCase = true
                            )
                        ) {
                            getInstance()?.conversation = conversation
                            getInstance()?.initViews()
                        }
                    }
                } catch (e: Exception) {
                    Log.e(
                        TAG, Constants.MESSAGE + Constants.TYPES.CONFIRM_ACK_GROUP_NAME_CHANGE, e
                    )
                }
            }
        }

        private fun handleGroupIconChangePayload(actualPayload: Payload) {
            payload = actualPayload
            if (messagesDao.getMessage(actualPayload.messageId) == null) try {
                messagesDao!!.insert(actualPayload)
                if (!actualPayload.userChatId.equals(
                        AppSession.getUser().chatUserId, ignoreCase = true
                    )
                ) {
                    if (conversationsDao.getConversation(actualPayload.conversationId) != null) {
                        getChangedIconConversationLink(actualPayload)
                        getInstance()?.loadNotifyMessage(actualPayload)
                    } else {
                        getConversation(actualPayload.conversationId!!)
                    }
                } else {
                    getInstance()?.loadNotifyMessage(actualPayload)
                }
            } catch (e: Exception) {
                Log.e(
                    TAG, Constants.MESSAGE + Constants.TYPES.CONFIRM_ACK_GROUP_NAME_CHANGE, e
                )
            }
            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_GROUP_ICON_CHANGE
            )
        }

        private fun handleChangeOwnerPayload(actualPayload: Payload) {
            payload = actualPayload
            getInstance()?.loadNotifyMessage(actualPayload)
            val conversation = conversationsDao.getConversation(actualPayload.conversationId)
            conversation?.let {
                checkOwnerMessageInDb(conversation, actualPayload)
            } ?: run {
                getConversation(actualPayload.conversationId!!)
            }
            sendConfirmMember(actualPayload, "confirm_ack_leave_group")
        }

        private fun checkOwnerMessageInDb(conversation: Conversation, actualPayload: Payload) {
            if (messagesDao.getMessage(actualPayload.messageId) == null) {
                messagesDao!!.insert(actualPayload)
                val pm_key = conversation.uid
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                val owner = conversation.owner
                conversation.owner = splits[1]
                val member: ConversationMember
                val memberToChange = conversation.conversationMembers?.find { memberInCon ->
                    splits[1].equals(
                        memberInCon.memberId, ignoreCase = true
                    )
                }
                memberToChange?.let {
                    memberToChange.type = "owner"
                    val i = conversation.conversationMembers?.indexOfFirst {
                        memberToChange.memberId.equals(it.memberId)
                    }
                    conversation.conversationMembers?.removeIf {
                        memberToChange.memberId.equals(
                            it.memberId
                        )
                    }
                    conversation.conversationMembers?.add(i!!, memberToChange)
                }

                conversation.conversationMembers?.removeIf { member ->
                    member.memberId.equals(
                        owner
                    )
                }
                actualPayload.createdAt = DateTime.formatServerTimeStamp(actualPayload.createdAt!!)
                conversation.lastMessage = actualPayload
                conversation.uid = pm_key
                conversation.sequenceOfConversation = System.currentTimeMillis()
                conversationsDao.update(conversation)
                when (conversation.conversationType) {
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                        val conversationMember =
                            conversation.conversationMembers?.find { conversationMember ->
                                conversationMember.isMe
                            }
                        conversationMember?.let {
                            conversationsDao.updateMyMoniker(
                                conversation.conversationId, conversationMember.moniker
                            )
                        }
                    }
                    else -> {
                        conversationsDao.updateMyMoniker(
                            conversation.conversationId, AppSession.getUser().chatUserId
                        )
                    }

                }

                val conversation = conversationsDao.getConversation(conversation.conversationId)
                ChatDetailsActivity.getDetailsInstance()!!.mConversation?.let {
                    if (ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                            conversation!!.conversationId, ignoreCase = true
                        )
                    ) {
                        ChatDetailsActivity.getDetailsInstance()!!.mConversation = conversation
                        ChatDetailsActivity.getDetailsInstance()!!.adminMemberChange()
                    }
                }

                getInstance()?.conversation?.let {
                    if (getInstance()?.conversation!!.conversationId.equals(
                            conversation!!.conversationId, ignoreCase = true
                        )
                    ) {
                        getInstance()?.conversation = conversation
                    }
                }

                MembersActivity.getInstance()?.mConversation?.let {
                    if (!MembersActivity.getInstance()?.fromOwnerChange!! && MembersActivity.getInstance()?.mConversation!!.conversationId.equals(
                            conversation!!.conversationId, ignoreCase = true
                        )
                    ) {
                        MembersActivity.getInstance()?.mConversation = conversation
                        MembersActivity.getInstance()?.populateRecyclerView()
                    }
                }
            }
        }

        private fun handleMemberLeavePayload(actualPayload: Payload) {

            payload = actualPayload
            getInstance()?.loadNotifyMessage(actualPayload)
            val conversation = conversationsDao.getConversation(actualPayload.conversationId)
            conversation?.let {
                checkMemberLeaveinDb(conversation, actualPayload)
            } ?: run {
                getConversation(actualPayload.conversationId!!)
            }
            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_LEAVE_GROUP
            )
        }

        private fun checkMemberLeaveinDb(conversation: Conversation, actualPayload: Payload) {
            if (messagesDao.getMessage(actualPayload.messageId) == null) {
                messagesDao!!.insert(actualPayload)
                val pm_key = conversation.uid
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                for (i in conversation.conversationMembers!!.indices) {
                    if (splits[1].equals(
                            conversation.conversationMembers!![i].memberId, ignoreCase = true
                        )
                    ) {
                        conversation.conversationMembers!!.removeAt(i)
                        if (splits[1].equals(
                                AppSession.getUser().chatUserId, ignoreCase = true
                            )
                        ) conversation.isRemoved = true
                        break
                    }
                }
                actualPayload.createdAt = DateTime.formatServerTimeStamp(actualPayload.createdAt!!)
                conversation.lastMessage = actualPayload
                conversation.uid = pm_key
                conversation.sequenceOfConversation = System.currentTimeMillis()
                conversationsDao.update(conversation)

                if (conversation.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                    )
                ) {
                    val conversationMember =
                        conversation.conversationMembers?.find { conversationMember ->
                            conversationMember.isMe
                        }

                    conversationMember?.let {
                        conversationsDao.updateMyMoniker(
                            conversation.conversationId, conversationMember.moniker
                        )
                    }
                } else {
                    conversationsDao.updateMyMoniker(
                        conversation.conversationId, AppSession.getUser().chatUserId
                    )
                }
                val conversation = conversationsDao.getConversation(conversation.conversationId)
                updateConversationInOthers(conversation)
            }
        }

        private fun handleAdminRemovedPayload(actualPayload: Payload) {

            payload = actualPayload
            getInstance()?.loadNotifyMessage(actualPayload)
            val conversation = conversationsDao.getConversation(actualPayload.conversationId)
            conversation?.let {
                checkAdminRemoveinDb(conversation, actualPayload)
            } ?: run {
                getConversation(actualPayload.conversationId!!)
            }
            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_ADMIN_REMOVED
            )
        }

        private fun checkAdminRemoveinDb(conversation: Conversation, actualPayload: Payload) {
            if (messagesDao.getMessage(actualPayload.messageId) == null) {
                messagesDao.insert(actualPayload)
                val pm_key = conversation.uid
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                val member: ConversationMember
                for (i in conversation.conversationMembers!!.indices) {
                    if (splits[1].equals(
                            conversation.conversationMembers!![i].memberId, ignoreCase = true
                        )
                    ) {
                        member = conversation.conversationMembers!![i]
                        member.type = "member"
                        conversation.conversationMembers!!.removeAt(i)
                        conversation.conversationMembers!!.add(
                            i, member
                        )
                        break
                    }
                }
                actualPayload.createdAt = DateTime.formatServerTimeStamp(actualPayload.createdAt!!)
                conversation.lastMessage = actualPayload
                conversation.uid = pm_key
                conversation.sequenceOfConversation = System.currentTimeMillis()
                conversationsDao.update(conversation)

                when (conversation.conversationType) {
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                        val conversationMember =
                            conversation.conversationMembers?.find { conversationMember ->
                                conversationMember.isMe
                            }

                        conversationMember?.let {
                            conversationsDao.updateMyMoniker(
                                conversation.conversationId, conversationMember.moniker
                            )
                        }
                    }
                    else -> {
                        conversationsDao.updateMyMoniker(
                            conversation.conversationId, AppSession.getUser().chatUserId
                        )
                    }
                }
                val conversation = conversationsDao.getConversation(conversation.conversationId)

                updateConversationInOthers(conversation)
            }
        }

        private fun updateConversationInOthers(conversation: Conversation?) {
            ChatDetailsActivity.getDetailsInstance()!!.mConversation?.let {
                if (ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                        conversation!!.conversationId, ignoreCase = true
                    )
                ) {
                    ChatDetailsActivity.getDetailsInstance()!!.mConversation = conversation
                    ChatDetailsActivity.getDetailsInstance()!!.adminMemberChange()
                }
            }

            getInstance()?.conversation?.let {
                if (getInstance()?.conversation!!.conversationId.equals(
                        conversation!!.conversationId, ignoreCase = true
                    )
                ) getInstance()?.conversation = conversation
            }

            MembersActivity.getInstance()?.mConversation?.let {
                if (!MembersActivity.getInstance()?.fromOwnerChange!! && MembersActivity.getInstance()?.mConversation?.conversationId.equals(
                        conversation!!.conversationId, ignoreCase = true
                    )
                ) {
                    MembersActivity.getInstance()?.mConversation = conversation
                    MembersActivity.getInstance()?.populateRecyclerView()
                }
            }
        }

        private fun handleAdminAssignedPayload(actualPayload: Payload) {

            payload = actualPayload
            getInstance()?.loadNotifyMessage(actualPayload)
            val conversation = conversationsDao.getConversation(actualPayload.conversationId)
            conversation?.let {
                checkAdminAssignInDb(conversation, actualPayload)
            } ?: run {
                getConversation(actualPayload.conversationId!!)
            }
            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_ADMIN_ASSIGNED
            )
        }

        private fun checkAdminAssignInDb(conversation: Conversation, actualPayload: Payload) {
            if (messagesDao.getMessage(actualPayload.messageId) == null) {
                messagesDao.insert(actualPayload)
                val pm_key = conversation.uid
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                val member: ConversationMember
                for (i in conversation.conversationMembers!!.indices) {
                    if (splits[1].equals(
                            conversation.conversationMembers!![i].memberId, ignoreCase = true
                        )
                    ) {
                        member = conversation.conversationMembers!![i]
                        member.type = "admin"
                        conversation.conversationMembers!!.removeAt(i)
                        conversation.conversationMembers!!.add(
                            i, member
                        )
                        break
                    }
                }
                actualPayload.createdAt = DateTime.formatServerTimeStamp(actualPayload.createdAt!!)
                conversation.lastMessage = actualPayload
                conversation.uid = pm_key
                conversation.sequenceOfConversation = System.currentTimeMillis()
                conversationsDao.update(conversation)
                if (conversation.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                    )
                ) {

                    val conversationMember =
                        conversation.conversationMembers?.find { conversationMember ->
                            conversationMember.isMe
                        }
                    conversationMember?.let {
                        conversationsDao.updateMyMoniker(
                            conversation.conversationId, conversationMember.moniker
                        )
                    }
                } else {
                    conversationsDao.updateMyMoniker(
                        conversation.conversationId, AppSession.getUser().chatUserId
                    )
                }
                val conversation = conversationsDao.getConversation(
                    conversation.conversationId
                )

                updateConversationInOthers(conversation)
            }
        }

        private fun handleMemberAddedPayload(actualPayload: Payload) {
            payload = actualPayload
            getInstance()?.loadNotifyMessage(actualPayload)
            val conversation = conversationsDao.getConversation(actualPayload.conversationId)
            conversation?.let {
                if (messagesDao.getMessage(actualPayload.messageId) == null) {
                    messagesDao.insert(actualPayload)
                    //this is essential as after the && the we get the chat user id which will be operated on
                    val splits = actualPayload.data!!.split("&&").toTypedArray()
                    when (splits[1]) {
                        AppSession.getUser().chatUserId -> {
                            Log.e(TAG, "Got in own ")
                            if (conversation.isRemoved) {
                                //will be here if the user was previously removed from conversation
                                conId = conversation.uid
                                getUpdatedConversation(conversation.conversationId!!)
                            }
                        }
                        else -> {
                            Log.e(TAG, "Got in else ")
                            //will be here if the user was not removed from conversation and a new user is added
                            conId = conversation.uid
                            getUpdatedConversation(conversation.conversationId!!)
                        }
                    }

                }

                when (conversation.conversationType) {
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                        conId = conversation.uid
                        getUpdatedConversation(conversation.conversationId!!)
                    }
                    else -> {
                        sendConfirmMember(
                            actualPayload, Constants.TYPES.CONFIRM_ACK_MEMBER_ADD
                        )
                    }
                }
            } ?: run {
                //will be here if there is not conversation in the local Database Room
                getConversation(actualPayload.conversationId!!)

                actualPayload.conversationType?.let {
                    if (!actualPayload.conversationType.equals(
                            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                        )
                    ) {
                        sendConfirmMember(
                            actualPayload, Constants.TYPES.CONFIRM_ACK_MEMBER_ADD
                        )
                    }
                }
            }
        }

        private fun handleMemberRemovePayload(actualPayload: Payload) {
            Log.e(TAG, "Member removed ack")
            payload = actualPayload
            getInstance()?.loadNotifyMessage(actualPayload)
            val conversation = conversationsDao.getConversation(actualPayload.conversationId)
            conversation?.let {
                checkMemberRemoveInDb(conversation, actualPayload)
            } ?: run {
                getConversation(actualPayload.conversationId!!)
            }
            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_MEMBER_REMOVE
            )
        }

        private fun checkMemberRemoveInDb(conversation: Conversation, actualPayload: Payload) {
            if (messagesDao.getMessage(actualPayload.messageId) == null) {
                messagesDao.insert(actualPayload)
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                if (conversation.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS
                    )
                ) {
                    if (splits[1].equals(
                            conversation.myMoniker, ignoreCase = true
                        )
                    ) {
                        deleteConversationChannels(conversation)
                        conversation.isRemoved = true
                        getInstance()?.removedFromConvo(actualPayload)
                    }
                } else {
                    if (splits[1].equals(
                            AppSession.getUser().chatUserId, ignoreCase = true
                        )
                    ) {
                        conversation.isRemoved = true
                        getInstance()?.removedFromConvo(actualPayload)
                    }
                }

                for (i in conversation.conversationMembers!!.indices) {
                    if (conversation.conversationMembers!![i].memberId.equals(
                            splits[1], ignoreCase = true
                        )
                    ) {
                        conversation.conversationMembers!!.removeAt(i)
                        break
                    }
                }
                actualPayload.createdAt = DateTime.formatServerTimeStamp(actualPayload.createdAt!!)
                conversation.lastMessage = actualPayload
                conversation.sequenceOfConversation = System.currentTimeMillis()
                conversationsDao.update(conversation)

                updateConversationInOthers(conversation)
            }
        }

        private fun deleteConversationChannels(conversation: Conversation) {
            conversation.let {
                it.conversationMembers?.forEach { member ->
                    if (!member.moniker.isNullOrEmpty()) {
                        conversationChannelsDao.deleteConversationChannel(
                            Utills.getHash("${it.conversationId}&&${member.moniker}")!!
                        )
                    }
                }
            }
        }

        private fun handleGroupMediaRstrictPayload(actualPayload: Payload) {
            val message = messagesDao.getMessage(actualPayload.messageId)

            if (message == null && actualPayload.data?.contains("&&")!!) {
                messagesDao.insert(actualPayload)
                val splits = actualPayload.data!!.split("&&").toTypedArray()
                val mediaShareRestrict = splits[0].toBooleanStrict()
                conversationsDao.updateCanShareForward(
                    actualPayload.conversationId, mediaShareRestrict
                )
                if (ChatDetailsActivity.getDetailsInstance()!!.mConversation != null && ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                        actualPayload.conversationId, ignoreCase = true
                    )
                ) {
                    ChatDetailsActivity.getDetailsInstance()!!.mConversation?.isCanShareForward =
                        mediaShareRestrict
                    ChatDetailsActivity.getDetailsInstance()!!.adminMemberChange()
                }
                if (getInstance()?.conversation != null && getInstance()?.conversation!!.conversationId.equals(
                        actualPayload.conversationId, ignoreCase = true
                    )
                ) {
                    getInstance()?.conversation?.isCanShareForward = mediaShareRestrict
                }
                getInstance()?.loadNotifyMessage(actualPayload)
            }



            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_IS_MEDIA_SHARE_RESTRICT_CHANGE
            )
        }

        private fun handleGroupConfidentialPayload(actualPayload: Payload) {
            val message = messagesDao.getMessage(actualPayload.messageId)
            if (message == null) {

                Log.e(TAG, "$actualPayload")
                if (actualPayload.data?.contains("&&")!!) {
                    messagesDao.insert(actualPayload)
                    val splits = actualPayload.data!!.split("&&").toTypedArray()
                    val confidential = splits[0].toBooleanStrict()
                    conversationsDao.updateIsConfidential(
                        actualPayload.conversationId, confidential
                    )
                    if (ChatDetailsActivity.getDetailsInstance()!!.mConversation != null && ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                            actualPayload.conversationId, ignoreCase = true
                        )
                    ) {
                        ChatDetailsActivity.getDetailsInstance()!!.mConversation?.isConfidential =
                            confidential
                        ChatDetailsActivity.getDetailsInstance()!!.adminMemberChange()
                    }
                    if (getInstance()?.conversation != null && getInstance()?.conversation!!.conversationId.equals(
                            actualPayload.conversationId, ignoreCase = true
                        )
                    ) {
                        getInstance()?.conversation?.isConfidential = confidential
                        getInstance()?.handleSendConfidentialMessage()
                    }
                    getInstance()?.loadNotifyMessage(actualPayload)
                }
            }

            sendConfirmMember(
                actualPayload, Constants.TYPES.CONFIRM_ACK_IS_CONFIDENTIAL_CHANGE
            )
        }

        private fun handleViewOnceAckPayload(actualPayload: Payload) {

            val message = messagesDao!!.getMessage(actualPayload.messageId)
            if (message != null) {

                if (message.openedList != null) {
                    message.openedList!!.add(actualPayload.userChatId!!)
                } else {
                    val list: MutableList<String> = ArrayList()
                    list.add(actualPayload.userChatId!!)
                    message.openedList = list
                }
            }
            Log.e(TAG, "View Once GOT ACk")
            checkOpenedToAll(message)
            sendAckConfirmation(
                actualPayload, Constants.TYPES.CONFIRM_ACK_IS_VIEW_ONCE
            )
        }

        private fun handleReadPayload(actualPayload: Payload) {
            val message = messagesDao!!.getMessage(actualPayload.messageId)
            if (message != null) {
                Log.e(
                    TAG, "Got Ack read"
                )
                if (message.readList != null) {
                    message.readList!!.add(actualPayload.userChatId!!)
                } else {
                    val list: MutableList<String> = ArrayList()
                    list.add(actualPayload.userChatId!!)
                    message.readList = list
                }
            }
            checkReadToAll(message)
            sendAckConfirmation(
                actualPayload, Constants.TYPES.CONFIRM_ACK_READ
            )
        }

        /**
         * Handles the deliver payload by checking its properties and processing it accordingly.
         *
         * @param actualPayload The payload to be handled.
         */
        private fun handleDeliverPayload(actualPayload: Payload) {
            // Get the message from the database
            val message = messagesDao.getMessage(actualPayload.messageId)
            message?.let {
                // Get or create the delivered list
                val deliveredList = it.deliveredList ?: mutableListOf()
                // Add the user chat ID to the delivered list if it is not already present
                actualPayload.userChatId?.let { userChatId ->
                    if (!deliveredList.contains(userChatId)) {
                        deliveredList.add(userChatId)
                    }
                }
                // Update the delivered list
                it.deliveredList = deliveredList
            }
            // Check if the message has been delivered to all recipients
            checkDeliveredToAll(message)
            // Send confirmation for ACK_DELIVER
            sendAckConfirmation(
                actualPayload, Constants.TYPES.CONFIRM_ACK_DELIVER
            )
        }

        private fun handleDeletePayload(actualPayload: Payload) {

            if (checkPayloadDelete(actualPayload)) {
                val message = messagesDao.getMessage(actualPayload.messageId)
                message?.let {
                    if (!message.type.equals("text", ignoreCase = true)) {
                        try {
                            message.filePath?.let {
                                val file = File(message.filePath!!)
                                if (file.exists()) {
                                    file.delete()
                                }
                            }
                        } catch (e: java.lang.Exception) {
                            Log.e(
                                ContentValues.TAG, " Delete file run: ", e
                            )
                        }
                    }
                    message.data = actualPayload.data
                    message.isDeleted = true
                    message.type = "text"
                    messagesDao.updateMessage(message)
                    getInstance()?.updateMessage(message)
                }
            }
            sendAck(actualPayload, Constants.TYPES.ACK_DELETE)
        }

        private fun checkPayloadDelete(actualPayload: Payload): Boolean {
            return !(AppSession.getUser() != null && !AppSession.getUser().chatUserId!!.isEmpty() && AppSession.getUser().blockUsers!!.isNotEmpty() && AppSession.getUser().blockUsers!!.contains(
                actualPayload.userChatId!!
            ) && actualPayload.conversationType.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
            ))
        }

        private fun handleEditPayload(actualPayload: Payload) {
            if (!(AppSession.getUser() != null && !AppSession.getUser().chatUserId!!.isEmpty() && AppSession.getUser().blockUsers!!.size > 0 && AppSession.getUser().blockUsers!!.contains(
                    actualPayload.userChatId!!
                ) && actualPayload.conversationType.equals(
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                ))
            ) {
                val message = messagesDao.getMessage(actualPayload.messageId)
                if (message != null) {
                    message.data = actualPayload.data
                    message.isEdited = true
                    messagesDao.insert(message)
                    getInstance()?.updateMessage(message)
                    handleLastMessageConversation(actualPayload)
                }

            }
            sendAck(actualPayload, Constants.TYPES.ACK_EDIT)
        }

        private fun handleLastMessageConversation(actualPayload: Payload) {
            conversationsDao.getConversation(actualPayload.conversationId)?.let { conversation ->
                conversation.lastMessage?.let { last ->
                    if (last.messageId?.equals(actualPayload.messageId, ignoreCase = true)!!) {
                        val prevPayload = conversation.lastMessage
                        prevPayload?.data = actualPayload.data
                        conversation.lastMessage = prevPayload
                        conversationsDao.update(conversation)
                    }
                }
            }
        }

        private fun handleTextPayload(actualPayload: Payload) {
            val stopwatch = Stopwatch("Adding in DB")
            stopwatch.split("Adding in Room")
            if (checkHandleTextPayload(actualPayload)) {
                actualPayload.status = Constants.DELIVERED
                sendAck(
                    actualPayload, Constants.TYPES.CONFIRM_ACK_BLOCK_UNKNOWN
                )
            } else if (SettingsValues.getBlockUnknownContact() && checkContactNull(
                    actualPayload.userChatId!!
                ) == null && actualPayload.conversationType.equals(
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                )
            ) {
                actualPayload.status = Constants.DELIVERED
                sendAck(
                    actualPayload, Constants.TYPES.CONFIRM_ACK_BLOCK_UNKNOWN
                )
            } else {
                payload = actualPayload
                actualPayload.status = Constants.DELIVERED
                if (prevPayload == null) {
                    prevPayload = actualPayload
                    getInstance()?.loadMessage(actualPayload)

//                                            sendPayload(actualPayload)
                    val conversation =
                        conversationsDao.getConversation(actualPayload.conversationId)
                    if (messagesDao.getMessage(actualPayload.messageId) == null) {
                        messagesDao.insert(actualPayload)
                        conversation?.let {
                            conversation.lastMessage = actualPayload
                            conversation.sequenceOfConversation = System.currentTimeMillis()
                            conversationsDao.update(conversation)

                        } ?: run {
                            getConversation(actualPayload.conversationId!!)
                        }

                    }

//                                            } else {
//                                                Log.e(TAG, "Secrete Key Not Found")
//                                            }
                    //                            sendConfirmMember(actualPayload);

                    sendAck(actualPayload, Constants.TYPES.ACK_DELIVER)
                } else if (prevPayload!!.messageId.equals(
                        actualPayload.messageId, ignoreCase = true
                    )
                ) {
                    prevPayload = actualPayload
                    sendAck(actualPayload, Constants.TYPES.ACK_DELIVER)
                } else {
                    prevPayload = actualPayload
                    actualPayload.status = Constants.DELIVERED
                    getInstance()?.loadMessage(actualPayload)
                    val conversation =
                        conversationsDao.getConversation(actualPayload.conversationId)
                    if (messagesDao.getMessage(actualPayload.messageId) == null) {
                        messagesDao.insert(actualPayload)
                        conversation?.let {
                            conversation.lastMessage = actualPayload
                            conversation.sequenceOfConversation = System.currentTimeMillis()
                            conversationsDao.update(conversation)

                        } ?: run {
                            getConversation(actualPayload.conversationId!!)
                        }
                    }
                    stopwatch.split("Sent to Sending Ack")
                    stopwatch.stop(Stopwatch.TAG)
                    sendAck(actualPayload, Constants.TYPES.ACK_DELIVER)
                }
            }

        }

        /**
         * Checks if the text payload should be handled based on the user's properties and the payload's properties.
         *
         * @param actualPayload The payload to be checked.
         * @return True if the payload should be handled, false otherwise.
         */
        private fun checkHandleTextPayload(actualPayload: Payload): Boolean {
            val user = AppSession.getUser()
            return user != null &&
                    !user.chatUserId.isNullOrEmpty() &&
                    !user.blockUsers.isNullOrEmpty() &&
                    user.blockUsers?.contains(actualPayload.userChatId)!! &&
                    actualPayload.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true)
        }


        /**
         * Checks if the message has been delivered to all conversation members.
         *
         * @param message The message to be checked.
         */
        private fun checkDeliveredToAll(message: Payload?) {
            message?.let {
                val members = mutableListOf<String>()
                val conversation = conversationsDao.getConversation(message.conversationId)
                conversation?.let {
                    // Check the conversation type
                    when (conversation.conversationType) {
                        // Handle anonymous group conversations
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                            conversation.conversationMembers?.forEach { member ->
                                if (!member.memberId.equals(conversation.myMoniker, ignoreCase = true)) {
                                    members.add(member.memberId!!)
                                }
                            }
                        }
                        // Handle other types of conversations
                        else -> {
                            conversation.conversationMembers?.forEach { member ->
                                if (!member.memberId.equals(AppSession.getUser().chatUserId, ignoreCase = true)) {
                                    members.add(member.memberId!!)
                                }
                            }
                        }
                    }

                    // Update the message status
                    message.status = updateStatus(members, message)
                }
                // Update the message in the database
                updateMessageInDb(message)
            }
        }

        /**
         * Updates the status of the message based on its properties and the given list of members.
         *
         * @param members The list of members to check against.
         * @param message The message to be updated.
         * @return The updated status of the message.
         */
        private fun updateStatus(members: MutableList<String>, message: Payload): String? {
            return if (message.deliveredList?.containsAll(members) == true) {
                when {
                    message.status == null || !message.status.equals("3", ignoreCase = true) -> Constants.DELIVERED
                    else -> Constants.SEEN
                }
            } else {
                message.status
            }
        }



        /**
         * Updates the message in the database with the given payload.
         *
         * @param message The payload to be used to update the message.
         */
        private fun updateMessageInDb(message: Payload) {
            // Get the message from the database
            val payload = messagesDao?.getMessage(message.messageId)
            // Update the message properties
            payload?.status = message.status
            payload?.deliveredList = message.deliveredList
            // Update the message in the database
            messagesDao?.updateMessage(payload)
            // Update the message in the instance
            getInstance()?.updateMessage(payload)
        }


        /**
         * Checks if a message has been read by all members of a conversation and updates its status accordingly.
         *
         * @param message The message to be checked.
         */
        private fun checkReadToAll(message: Payload?) {
            message?.let {
                val conversation = conversationsDao.getConversation(message.conversationId)
                val members: MutableList<String> = ArrayList()
                conversation?.let {
                    // Get the list of members in the conversation
                    val conMember = when (conversation.conversationType) {
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                            // If the conversation is an anonymous group chat
                            conversation.conversationMembers?.filter { member ->
                                !member.memberId.equals(conversation.myMoniker, ignoreCase = true)
                            }
                        }
                        else -> {
                            // For other types of conversations
                            conversation.conversationMembers?.filter { member ->
                                !member.memberId.equals(AppSession.getUser().chatUserId, ignoreCase = true)
                            }
                        }
                    }
                    // Add the member IDs to the list
                    conMember?.forEach { member ->
                        members.add(member.memberId!!)
                    }

                    // Check if all members have read the message
                    if (message.readList!!.containsAll(members)) {
                        message.status = Constants.SEEN
                    }
                }
                // Update the message in the database and on the server
                messagesDao!!.updateMessage(message)
                getInstance()?.updateMessage(message)
            }
        }

        /**
         * Checks if a message has been opened by all members of a conversation and updates its status accordingly.
         *
         * @param message The message to be checked.
         */
        private fun checkOpenedToAll(message: Payload?) {
            message?.let {
                val conversation = conversationsDao.getConversation(message.conversationId)
                var members: MutableList<String> = ArrayList()
                conversation?.let {
                    when (conversation.conversationType) {
                        Constants.TYPES.CONVERSATION_GROUP -> {
                            Log.e(TAG, "View Once GOT CONVERSATION_GROUP ACk")

                            // Get the list of members in the conversation
                            val conMembers = conversation.conversationMembers?.filter { member ->
                                !member.memberId.equals(
                                    AppSession.getUser().chatUserId, ignoreCase = true
                                )
                            }
                            // Add the member IDs to the list
                            conMembers?.forEach { member ->
                                members.add(member.memberId!!)
                            }
                        }
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                            // If the conversation is an anonymous group chat
                            Log.e(TAG, "View Once GOT CONVERSATION_GROUP_ANONYMOUS ACk")

                            // Get the list of members in the conversation
                            val conMember = conversation.conversationMembers?.filter { member ->
                                !member.memberId.equals(
                                    conversation.myMoniker, ignoreCase = true
                                )
                            }
                            // Add the member IDs to the list
                            conMember?.forEach { member ->
                                members.add(member.memberId!!)
                            }
                        }
                        else -> {
                            Log.e(TAG, "View Once GOT one to one  ACk")
                            members = mutableListOf()
                            message.isOpened = true
                        }
                    }

                    // Check if all members have opened the message
                    if (message.openedList!!.containsAll(members)) {
                        message.isOpened = true
                    }
                }

                // Update the message in the database and on the server
                messagesDao.updateMessage(message)
                getInstance()?.updateMessage(message)
            }
        }


        fun getConversation(id: String) {
            Log.d(
                TAG,
                "MainActivity getConversation: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_CONVERSATION + Constants.REQUEST + Constants.CONVERSATION_ID + id
            )
            ApiHelper.with()?.getConversation(id, this)

        }

        fun getUpdatedConversation(id: String) {
            Log.d(
                TAG,
                GET_UPDATED_CONVERSATION + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_CONVERSATION + Constants.REQUEST + Constants.CONVERSATION_ID + id
            )

            ApiHelper.with()?.getUpdatedConversation(id, this)
        }

        fun getChangedIconConversationLink(actualPayload: Payload) {
            Log.d(
                TAG,
                "MainActivity getUpdatedConversation: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_CONVERSATION + Constants.REQUEST + Constants.CONVERSATION_ID + actualPayload.conversationId
            )

            ApiHelper.with()?.getChangedIconConversationLink(actualPayload.conversationId, this)
        }

        /**
         * Handles successful API responses.
         *
         * @param call The call that was made.
         * @param response The response received from the server.
         * @param tag The tag associated with the call.
         */
        override fun onSuccess(call: Call<*>?, response: retrofit2.Response<*>, tag: Any) {
            if (response.code() == 200) {
                val res = response.body() as GetConversationResponse?
                when (tag as Int) {
                    RequestCodes.API.GET_CONVERSATION -> handleGetConversationResponse(res)
                    RequestCodes.API.UPDATED_CONVERSATION -> handleUpdateConversationResponse(res)
                    RequestCodes.API.GET_GROUP_ICON -> handleGetGroupIconResponse(res)
                }
            }
        }

        private fun handleGetGroupIconResponse(res: GetConversationResponse?) {
            res?.conversationList?.let {
                Log.d(
                    TAG,
                    "MainActivity getChangedIconConversationLink: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_CONVERSATION + Constants.RESPONSE + res
                )
                val conversation = res.conversationList

                val conversation1 = conversationsDao.getConversation(conversation?.conversationId)
                conversation1?.let {
                    if (!res.image_bucket_link.isNullOrEmpty()) {
                        res.conversationList?.photo?.let {
                            val img_file =
                                File(MainApp.appContext!!.filesDir.path + "/" + res.conversationList?.photo)
                            DownloaderImage.instance!!.download(
                                img_file.absolutePath,
                                res.image_bucket_link!!,
                                conversation1?.conversationId!!,
                                res.conversationList?.photo!!
                            )
                            updateConvWithImg(img_file, conversation1)
                            DownloaderImage.fileImageMutableLiveData.observe(
                                (this@MainActivity as LifecycleOwner)
                            ) { file1: File? ->
                                file1?.let {
                                    if (img_file.absolutePath.equals(
                                            file1.absolutePath, ignoreCase = true
                                        )
                                    ) {
                                        conversationsDao.updateFilePath(
                                            res.conversationList?.conversationId, file1.path
                                        )
                                        conversationsDao.updateConversationIcon(
                                            res.conversationList?.conversationId,
                                            file1.path,
                                            res.conversationList?.photo
                                        )
                                        val conversation2 =
                                            conversationsDao.getConversation(conversation1.conversationId)
                                        updateConvWithPayload(payload, conversation2)
                                    }
                                }
                            }
                        }
                    }
                }
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }

        private fun updateConvWithPayload(payload: Payload?, conversation2: Conversation?) {
            if (ChatDetailsActivity.getDetailsInstance()!!.mConversation != null && ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                    conversation2!!.conversationId, ignoreCase = true
                )
            ) {
                ChatDetailsActivity.getDetailsInstance()!!.mConversation = conversation2
                ChatDetailsActivity.getDetailsInstance()!!.initViews()
            }
            if (getInstance()?.conversation != null && getInstance()?.conversation!!.conversationId.equals(
                    conversation2!!.conversationId, ignoreCase = true
                )
            ) {
                getInstance()?.conversation = conversation2
                payload!!.status = Constants.DELIVERED
                if (messagesDao.getMessage(
                        payload?.messageId
                    ) == null
                ) {
                    messagesDao.insert(payload)
                }
                getInstance()?.initViews()
            }
        }

        private fun updateConvWithImg(imgFile: File, conversation1: Conversation) {
            if (getInstance()?.conversation != null && getInstance()?.conversation!!.conversationId.equals(
                    conversation1.conversationId, ignoreCase = true
                )
            ) {
                getInstance()?.conversation = conversation1
                getInstance()?.startObserver(imgFile)
                getInstance()?.initViews()
            }
            if (ChatDetailsActivity.getDetailsInstance()!!.mConversation != null && ChatDetailsActivity.getDetailsInstance()!!.mConversation!!.conversationId.equals(
                    conversation1.conversationId, ignoreCase = true
                )
            ) {
                ChatDetailsActivity.getDetailsInstance()!!.mConversation = conversation1
                ChatDetailsActivity.getDetailsInstance()!!.startObserver(imgFile)
                ChatDetailsActivity.getDetailsInstance()!!.initViews()
            }
        }

        private fun handleUpdateConversationResponse(res: GetConversationResponse?) {
            res?.conversationList?.let {
                Log.d(
                    TAG,
                    GET_UPDATED_CONVERSATION + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_CONVERSATION + Constants.RESPONSE + res
                )
                val oldPhoto: String?
                oldPhoto = conversation?.conversationPhoto

                conversation = res.conversationList
                payload!!.createdAt = DateTime.formatServerTimeStamp(
                    payload!!.createdAt!!
                )
                conversation!!.lastMessage = payload
                conversation!!.isRemoved = false
                conversation!!.uid = conId
                conversation?.let {
                    conversation!!.isRemoved = false
                    getInstance()?.addedInConversation()
                    getInstance()?.setMembersName()
                    conversation!!.sequenceOfConversation = System.currentTimeMillis()
                    conversationsDao.update(conversation)
                    if (conversation!!.conversationType.equals(
                            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                        )
                    ) {
                        val conversationMember =
                            conversation!!.conversationMembers?.find { conversationMember -> conversationMember.isMe }

                        conversationMember?.let {
                            conversationsDao.updateMyMoniker(
                                conversation!!.conversationId, conversationMember.moniker
                            )
                            getInstance()?.conversation?.let {
                                if (getInstance()?.conversation!!.conversationId.equals(
                                        conversation!!.conversationId, ignoreCase = true
                                    )
                                ) {
                                    getInstance()?.initAdapter()
                                    getInstance()?.loadMessages()
                                }
                            }
                        }
                    } else {
                        conversationsDao.updateMyMoniker(
                            conversation!!.conversationId, AppSession.getUser().chatUserId
                        )
                    }
                    val conversation =
                        conversationsDao.getConversation(conversation!!.conversationId)
                    if (!res.image_bucket_link.isNullOrEmpty()) {
                        val img_file =
                            File(MainApp.appContext!!.filesDir.path + "/" + res.conversationList?.photo)
                        DownloaderImage.instance!!.download(
                            img_file.absolutePath,
                            res.image_bucket_link!!,
                            conversation?.conversationId!!,
                            res.conversationList?.photo!!
                        )
                        DownloaderImage.fileImageMutableLiveData.observe(
                            (INSTANCE!!)
                        ) { file1: File? ->
                            file1?.let {
                                img_file.let {
                                    conversation!!.conversationPhoto?.let {
                                        if (oldPhoto != null) {
                                            val oldPhotoFile = File(oldPhoto)
                                            if (oldPhotoFile.exists()) {
                                                Utills.handleFileDelete(
                                                    TAG, oldPhotoFile.delete()
                                                )
                                            }
                                        }
                                    }
                                    if (img_file.absolutePath.equals(
                                            file1.absolutePath, ignoreCase = true
                                        )
                                    ) {
                                        conversationsDao.updateFilePath(
                                            res.conversationList?.conversationId, file1.path
                                        )
                                    }
                                }
                            }
                        }
                    }
                    updateConversationInOthers(conversation)
                }
                payload?.let {
                    payload?.conversationType?.let {
                        if (payload!!.type.equals(
                                "member_added", ignoreCase = true
                            ) && payload!!.conversationType.equals(
                                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS
                            )
                        ) {
                            sendConfirmMember(payload!!, Constants.TYPES.CONFIRM_ACK_MEMBER_ADD)
                        }
                    }
                }

            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }

        private fun handleGetConversationResponse(res: GetConversationResponse?) {
            res?.conversationList?.let {
                Log.d(
                    TAG,
                    "MainActivity getConversation: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_CONVERSATION + Constants.RESPONSE + res
                )
                val conversation = res.conversationList

                payload?.let {
                    payload?.status = getPayloadStatus(payload!!)
                }
                conversation?.let {
                    val expiryPayload = Payload()
                    expiryPayload.data = "${conversation!!.conversationExpiryTime}&&"
                    expiryPayload.type = Constants.TYPES.EXPIRE_MSG_SELF
                    expiryPayload.messageId = Utills.getRandomString(15)
                    expiryPayload.senderId = Utills.getRandomString(8)
                    expiryPayload.createdAt = DateTime.getCurrentDateMinusOneMinute()
                    expiryPayload.conversationId = conversation.conversationId
                    expiryPayload.conversationType = conversation.conversationType
                    expiryPayload.userChatId = expiryPayload.senderId
                    expiryPayload.isConfidential = conversation.isConfidential
                    expiryPayload.isCanShareForward = conversation.isMediaShareRestrict
                    if (messagesDao!!.getExpirySelfMessages(conversation.conversationId)
                            .isNullOrEmpty() && messagesDao!!.getExpiryMessages(conversation.conversationId)
                            .isNullOrEmpty()
                    ) {
                        messagesDao!!.insert(expiryPayload)
                        val messages = messagesDao?.getMessages(conversation.conversationId)
                        //Changing the Payload position to first of conversation
                        if (messages?.size!! > 1) {
                            val firstPayload = messages?.first()
                            val expiryPayload =
                                messages?.find { it?.type == Constants.TYPES.EXPIRE_MSG_SELF }
                            val tempPK = firstPayload?.id
                            firstPayload?.id = expiryPayload?.id!!
                            expiryPayload.id = tempPK!!
                            messagesDao.updateMessage(firstPayload)
                            messagesDao.updateMessage(expiryPayload)
                        }


                    }
                }


                payload?.messageId?.let {
                    addPayloadInDb(payload!!)
                }

                payload?.let {
                    if (!conversation?.conversationType.equals(
                            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                        ) && !payload!!.type.equals(Constants.TYPES.ANONYMOUS_GROUP_CONV_CREATED)
                    ) conversation?.lastMessage = payload
                }

                handleConversationFromDb(conversation, res)
                if (conversationsDao.getConversation(payload!!.conversationId)!!.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                    ) && payload != null && payload!!.type.equals(Constants.TYPES.ANONYMOUS_GROUP_CONV_CREATED)
                ) sendAnonymousConfirmMember(
                    payload!!, conversationsDao.getConversation(payload!!.conversationId)
                )
                sendConfirmAckForAnon(payload)
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }

        private fun getPayloadStatus(payload: Payload): String? {
            if (checkNotifyPayload(payload!!)) {
                payload!!.status = Constants.DELIVERED
            }

            return payload.status

        }

        private fun addPayloadInDb(payload: Payload) {
            if (messagesDao.getMessage(
                    payload.messageId
                ) == null && !payload.type.equals(
                    Constants.TYPES.ANONYMOUS_GROUP_CONV_CREATED
                )
            ) {
                messagesDao.insert(payload)
            }
        }

        private fun handleConversationFromDb(
            conversation: Conversation?,
            res: GetConversationResponse
        ) {
            val conversation1 = conversationsDao.getConversation(conversation?.conversationId)
            if (conversation1 == null) {
                conversation?.sequenceOfConversation = System.currentTimeMillis()
                conversationsDao.insert(conversation)
                if (conversation?.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                    )
                ) {
                    val conversationMember =
                        conversation?.conversationMembers?.find { conversationMember -> conversationMember.isMe }
                    conversationMember?.let {
                        if (conversationMember.isMe) {
                            conversationsDao.updateMyMoniker(
                                conversation.conversationId, conversationMember.moniker
                            )
                            getInstance()?.conversation?.let {
                                if (getInstance()?.conversation!!.conversationId.equals(
                                        conversation.conversationId, ignoreCase = true
                                    )
                                ) {
                                    getInstance()?.initAdapter()
                                    getInstance()?.loadMessages()
                                }
                            }
                        }
                    }
                } else {
                    conversationsDao.updateMyMoniker(
                        conversation?.conversationId, AppSession.getUser().chatUserId
                    )
                }
                payload?.let {
                    if (payload!!.type.equals(
                            Constants.TYPES.EXPIRE_MSG, ignoreCase = true
                        )
                    ) {
                        try {
                            val splits = payload!!.data!!.split("&&").toTypedArray()
                            conversationsDao.updateExpireTime(
                                payload!!.conversationId, Utills.getDisappearingOptionsString(
                                    splits[0]
                                )
                            )
                            runService()
                        } catch (e: Exception) {
                            Log.e(TAG, Constants.MESSAGE, e)
                        }
                    }
                }
                if (!res.image_bucket_link.isNullOrEmpty() && res.conversationList?.photo != null) {
                    val img_file =
                        File(MainApp.appContext!!.filesDir.path + "/" + res.conversationList?.photo)
                    DownloaderImage.instance!!.download(
                        img_file.absolutePath,
                        res.image_bucket_link!!,
                        conversation?.conversationId!!,
                        res.conversationList?.photo!!
                    )
//                                if (DownloaderImage.getInstance().fileImageMutableLiveData.hasObservers()) {
                    DownloaderImage.fileImageMutableLiveData.observe(
                        (this@MainActivity as LifecycleOwner)
                    ) { file1: File? ->
                        file1?.let {
                            img_file?.let {
                                if (img_file.absolutePath.equals(
                                        file1.absolutePath, ignoreCase = true
                                    )
                                ) {
                                    conversationsDao.updateFilePath(
                                        res.conversationList?.conversationId, file1.path
                                    )

                                }
                            }
                        }
                    }
//                                }
                }
            } else {
                if (conversation1.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                    )
                ) {
                    val conversationMember =
                        conversation?.conversationMembers?.find { conversationMember ->
                            conversationMember.isMe
                        }

                    conversationMember?.let {
                        if (conversationMember.isMe) {
                            conversationsDao.updateMyMoniker(
                                conversation1.conversationId, conversationMember.moniker
                            )

                        }
                    }

                } else {
                    conversationsDao.updateMyMoniker(
                        conversation1.conversationId, AppSession.getUser().chatUserId
                    )
                }

                if (!conversation1.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                    ) && payload != null && !payload!!.type.equals(Constants.TYPES.ANONYMOUS_GROUP_CONV_CREATED)
                ) conversation1.lastMessage = payload
                conversation1!!.sequenceOfConversation = System.currentTimeMillis()
                conversationsDao.update(conversation1)
            }
        }

        private fun sendConfirmAckForAnon(payload: Payload?) {
            payload?.let {
                payload?.conversationType?.let {
                    if (payload!!.type.equals(
                            "member_added", ignoreCase = true
                        ) && payload!!.conversationType.equals(
                            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS
                        )
                    ) {
                        sendConfirmMember(payload!!, Constants.TYPES.CONFIRM_ACK_MEMBER_ADD)
                    }
                }
            }
        }

        override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
            Notify.Toast(response.message)
        }
    }

    fun sendPayload(payload: Payload) {
        val intent = Intent("message-receive")
        // You can also include some extra data.


        intent.putExtra("payload", gson.toJson(payload))
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }


    /**
     * if the [actualPayload] is not in between these types
     * it means it needs to be handled with decryption
     */
    private fun checkPayload(actualPayload: Payload): Boolean {
        return !actualPayload.type.equals(
            Constants.TYPES.ACK_DELIVER, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.CONFIRM_ACK_DELIVER, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.ACK_READ, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.ACK_IS_VIEW_ONCE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.CONFIRM_ACK_IS_VIEW_ONCE, ignoreCase = true
        )

                && !actualPayload.type.equals(
            Constants.TYPES.CONFIRM_ACK_READ, ignoreCase = true
        ) && !actualPayload.type.equals(
            "edit", ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.ACK_EDIT, ignoreCase = true
        ) && !actualPayload.type.equals(
            "delete", ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.ACK_DELETE, ignoreCase = true
        ) && !actualPayload.type.equals(
            "member_added", ignoreCase = true
        ) && !actualPayload.type.equals(
            "member_removed", ignoreCase = true
        ) && !actualPayload.type.equals(
            "block", ignoreCase = true
        ) && !actualPayload.type.equals("unblock", ignoreCase = true) && !actualPayload.type.equals(
            "admin_assigned", ignoreCase = true
        ) && !actualPayload.type.equals(
            "admin_removed", ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.MEMBER_LEAVE, ignoreCase = true
        ) && !actualPayload.type.equals(
            "change_owner", ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_ICON_CHANGE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_DES_CHANGE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_NAME_CHANGE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.EXPIRE_MSG, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_CONV_CREATED, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.ANONYMOUS_GROUP_CONV_CREATED, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.SIR, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.DESTROY_GROUP, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.VIEW_ONCE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_IS_CONFIDENTIAL_CHANGE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE, ignoreCase = true
        )
    }

    fun checkNotifyPayload(actualPayload: Payload): Boolean {
        return (!actualPayload.type.equals(
            "member_added", ignoreCase = true
        ) && !actualPayload.type.equals(
            "member_removed", ignoreCase = true
        ) && !actualPayload.type.equals(
            "block", ignoreCase = true
        ) && !actualPayload.type.equals("unblock", ignoreCase = true) && !actualPayload.type.equals(
            "admin_assigned", ignoreCase = true
        ) && !actualPayload.type.equals(
            "admin_removed", ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.MEMBER_LEAVE, ignoreCase = true
        ) && !actualPayload.type.equals(
            "change_owner", ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_ICON_CHANGE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_DES_CHANGE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_NAME_CHANGE, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.EXPIRE_MSG, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.GROUP_CONV_CREATED, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.ANONYMOUS_GROUP_CONV_CREATED, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.SIR, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.DESTROY_GROUP, ignoreCase = true
        ) && !actualPayload.type.equals(
            Constants.TYPES.VIEW_ONCE, ignoreCase = true
        ))

    }


    companion object {
        @JvmField
        var webSocket: WebSocket? = null

        @JvmField
        var chatWebSocket: ChatWebSocket? = null


        val TAG = Log.tag(MainActivity::class.java)

        @JvmField
        var isSocketConnected = MutableLiveData<Boolean>(false)
        var INSTANCE: MainActivity? = null
        var prevPayload: Payload? = null
        var prevEncryptedPayload: Payload? = null

        @JvmStatic
        val instance: MainActivity?
            get() {
                if (INSTANCE == null) {
                    INSTANCE = MainActivity()
                }
                return INSTANCE
            }

        @JvmStatic
        fun runService() {
            try {
                if (BackgroundService.isRunning) {
                    Log.e(TAG, "Do nothing")
                } else {

                    val service = Intent(this@Companion.instance, BackgroundService::class.java)
                    if (service != null) {
                        if (VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            Permissions.with(INSTANCE!!).request(permission.SCHEDULE_EXACT_ALARM)
                                .ifNecessary().onAllGranted {
                                    this@Companion.instance?.startForegroundService(service)
                                }.onAnyDenied {
                                    Log.e(TAG, "Permission Denied")
                                }.execute()
                        } else {
                            this@Companion.instance?.startService(service)
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception in starting MQTT")
            }
        }
    }

    override val voiceNoteMediaController: VoiceNoteMediaController
        get() = mediaController!!


    inline fun <T> MutableList<T>.moveItemToFirstPosition(predicate: (T) -> Boolean) {
        for (element in this.withIndex()) {
            if (predicate(element.value)) {
                removeAt(element.index)
                add(0, element.value)
                break
            }
        }
    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }

    override fun onStateChange(state: WebSocketConnectionState) {
        webSocket?.let {

        }
    }
//    override  var voiceNoteMediaController: VoiceNoteMediaController= VoiceNoteMediaController(this@MainActivity)
}

