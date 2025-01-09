package com.devbeans.io.chat.activities


import android.Manifest.permission.*
import android.annotation.SuppressLint
import android.app.Activity
import android.content.*
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.OpenableColumns
import android.text.TextUtils
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.util.Pair
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.BuildConfig
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.MainActivity.Companion.isSocketConnected
import com.devbeans.io.chat.adapters.MessageAdapter
import com.devbeans.io.chat.adapters.viewholders.*
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.callBacks.ListenableFuture
import com.devbeans.io.chat.camera.CameraActivity
import com.devbeans.io.chat.databinding.*
import com.devbeans.io.chat.dependencies.ApplicationDependencies
import com.devbeans.io.chat.extensions.*
import com.devbeans.io.chat.ffmpeg.FFmpegOperations
import com.devbeans.io.chat.models.*
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.requestbody.CreateConversationRequest
import com.devbeans.io.chat.network.serializers.requestbody.LeaveGroupRequest
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.GetProfileResponse
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse
import com.devbeans.io.chat.network.serializers.response.UploadMediaResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.Constants.KEYS.INTENT_FILE_SELECTED
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.components.menu.ChatContextMenu
import com.devbeans.io.chat.utils.downloaders.DownloaderAnonymousGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderOneToOne
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.utils.revealable.ViewOnceMessageActivity
import com.devbeans.io.chat.utils.views.*
import com.devbeans.io.chat.verifypin.BaseActivity
import com.devbeans.io.chat.viewmodels.ChatViewModel
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.mpatric.mp3agic.InvalidDataException
import com.mpatric.mp3agic.Mp3File
import com.mpatric.mp3agic.NotSupportedException
import com.mpatric.mp3agic.UnsupportedTagException
import com.otaliastudios.cameraview.CameraView.PERMISSION_REQUEST_CODE
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.messages.MessageHolders.ContentChecker
import com.stfalcon.chatkit.messages.MessageInput.*
import com.stfalcon.chatkit.messages.MessagesListAdapter
import com.stfalcon.chatkit.messages.MessagesListAdapter.OnMessageViewClickListener
import com.vanniktech.emoji.EmojiPopup
import com.vanniktech.emoji.search.NoSearchEmoji
import com.virgilsecurity.keyknox.utils.Serializer.Companion.gson
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.IOException
import java.util.*
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis


//************************************************************
class ChatActivity : BaseActivity(), MessagesListAdapter.OnLoadMoreListener, InputListener,
    AttachmentsListener, ContentChecker<Messages>, DialogInterface.OnClickListener,
    OnNetworkResponse, OnMessageViewClickListener<Messages>,
    ConversationReactionOverlay.OnActionSelectedListener,
    ConversationReactionOverlay.OnHideListener, MicrophoneRecorderView.Listener, ExpiryCallback
//************************************************************
{
    private var viewOnce: Boolean = false
    private var canSendAudio: Boolean = true
    private var payloadToForward: Payload? = null
    var senderId = AppSession.getUser().chatUserId
    protected var imageLoader: ImageLoader? = null
    private var mCreateDialog: AlertDialog? = null
    private var lastLoadedDate: Date? = null
    private var isToggle = false
    private var menuBinding: CustomMenuBinding? = null
    private var mPop: PopupWindow? = null
    private var conversation_pk = 0
    private var loader: Loading? = null
    private lateinit var recordingContainer: ConstraintLayout
    private lateinit var recordTime: RecordTime
    private lateinit var slideToCancel: SlideToCancel
    private lateinit var audioRecorder: AudioRecorder
    private lateinit var voiceRecorderWakeLock: VoiceRecorderWakeLock
    private val REQUEST_CODE = 1012


    @JvmField
    var conversation: Conversation? = null
    var file: File? = null
    var filePath: String? = null
    var mediaType: String? = null
    var type: String? = null
    var mName: String? = null
    var groupName: String? = null
    var isBlocked = false
    var isForwarded = false
    var isFromForwardUpload = false
    var mBinding: ActivityChatBinding? = null
    var mViewModel: ChatViewModel? = null
    var mRoom: ChatRoom? = null
    private lateinit var mPopup: EmojiPopup
    var messageList: List<Message> = ArrayList()
    var groupMembers: List<Contact>? = ArrayList()
    private var mContact: Contact? = Contact()
    private var NewContact: Contact? = null
    private var mIsContact = false
    private var mUser: User? = null
    private var contactAdded = false
    var editingMessage: Messages? = null

    //    private File apkFile, finalFile;
    private var mFile: File? = null
    private var img_file: File? = null

    private val UNBLOCK = "Unblock"
    private val BLOCK = "Block"
    private val DELETE = "Delete"
    private val CLEAR = "Clear"
    private val LEAVE_GROUP = "Leave Group"
    private val DELETE_GROUP = "Delete Group"
    private val CHANGE_OWNER = "Change Owner"


    // The class to detect swipes and drags
    private lateinit var itemTouchHelper: ItemTouchHelper

    //Default Disappearing time 30 minutes
    private var selected_time = 1800000

    //for Handling long press reaction of on each conversation for popWindow
    private lateinit var reactionDelegate: ConversationReactionDelegate

    //for other member info
    private var member: ConversationMember? = null

    private var activeContextMenu: ChatContextMenu? = null

    private val mCommandReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get extra data included in the Intent
            val stopwatch = Stopwatch("Recieved in Chat Main Screen")
            stopwatch.split("Deserealizing Payload")
            val message = intent.getStringExtra("payload")
            val gson = Gson()
            val data = gson.fromJson(message, Payload::class.java)
            Log.e(TAG, "Received data $data")
            stopwatch.split("sent to View Payload")
            stopwatch.stop(Stopwatch.TAG)
            loadMessage(data)
        }
    }


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onResume() {
        listeners()

        if (Utills.isNetworkAvailable() && isSocketConnected.value != null && !isSocketConnected.value!!) {
            MainActivity.instance!!.initiateSocketConnection("Chat activity")
        }
        MainApp.appContext!!.currentActivity = this
        MainApp.appContext?.setNotifyExpiry(this)
        if (conversation != null) conversation = conversationsDao.getConversation(
            conversation!!.conversationId
        )
//        initAdapter()
        initViews()
        setMembersName()
        super.onResume()
    }


    /**
     * Initializes views and sets up the chat screen.
     */
    fun initViews() {
        mBinding?.let { binding ->

            // Set the color of the chat background
            setColorChatBackground()
            // Set the chat screen background
            setChatScreenBackground()

            setTopMenu(binding)

            // Set up the chat menu toggle
            setChatMenuToggle(binding)
            conversation?.apply {
                // Check the conversation type and set up views accordingly
                when (this.conversationType) {
                    Constants.TYPES.CONVERSATION_GROUP -> {
                        // Hide the disappear icon for group conversations
                        binding.ivDisappearIcon.visibility = GONE
                        // Set the group name as the title of the chat screen
                        groupName = conversation!!.name
                        binding.tvName.text = groupName

                        // Load the group photo into the chat image view using Glide
                        Glide.with(MainApp.appContext!!).load(
                            if (!this.photo.isNullOrEmpty() && !this.conversationPhoto.isNullOrEmpty() && !this.photo.equals(
                                    Constants.KEYS.DUMMY_IMAGE, ignoreCase = true
                                )
                            ) {
                                val file = File(this.conversationPhoto!!)
                                if (file.exists()) conversation!!.conversationPhoto else Utills.customImageIcon(
                                    groupName, "0D6EFD"
                                )
                            } else {
                                Utills.getNameDrawable(groupName, AvatarColor.GROUP)
                            }
                        ).into(binding.ivChatImage)

                    }

                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                        // Show and set the disappear icon for anonymous group conversations
                        binding.ivDisappearIcon.visibility = VISIBLE
                        binding.ivDisappearIcon.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_group_anonymous_indicator_new))
                    }

                    Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                        // Hide the disappear icon for one-to-one conversations
                        binding.ivDisappearIcon.visibility = GONE
                    }
                }
            }

            // Find and initialize views for recording audio messages
            recordingContainer = findViewById<ConstraintLayout>(R.id.recording_container)
            val textview = recordingContainer.findViewById<TextView>(R.id.record_time_mic)
            val microphone = recordingContainer.findViewById<AppCompatImageView>(R.id.microphone)
            mBinding?.recorderView?.setListener(this)
            recordTime = RecordTime(textview, microphone, TimeUnit.HOURS.toSeconds(1)) {
                mBinding?.recorderView?.cancelAction()
            }
            val slideToCancelView = recordingContainer.findViewById<TextView>(R.id.slide_to_cancel)
            slideToCancel = SlideToCancel(slideToCancelView)
            audioRecorder = AudioRecorder(this@ChatActivity)
            voiceRecorderWakeLock = VoiceRecorderWakeLock(this@ChatActivity)


        }
    }

    private fun setTopMenu(binding: ActivityChatBinding) {


        // Set up the click listener for the menu icon
        binding.ivMenu.setOnClickListener {
            if (activeContextMenu!=null)
                return@setOnClickListener
            val items = getMenuItems()
            activeContextMenu = ChatContextMenu.Builder(binding.ivMenu, binding.nestedScrollView)
                .offsetX(ViewUtil.dpToPx(2))
                .onDismiss {
                    // Set activeContextMenu to null when context menu is dismissed
                    activeContextMenu = null
                }.preferredVerticalPosition(ChatContextMenu.VerticalPosition.BELOW)
                .preferredHorizontalPosition(ChatContextMenu.HorizontalPosition.END)
                .show(items)
        }

//        // Inflate the custom menu layout
//        val v = LayoutInflater.from(this@ChatActivity).inflate(
//            R.layout.custom_menu, null
//        )


//
//        // Bind the custom menu layout
//        menuBinding = CustomMenuBinding.bind(v)
//        menuBinding?.apply {
//            // Initialize the PopupWindow with the custom menu layout
//            mPop = with(
//                PopupWindow(
//                    this.root,
//                    ActionBar.LayoutParams.WRAP_CONTENT,
//                    ActionBar.LayoutParams.WRAP_CONTENT,
//                    true
//                )
//            ) {
//                // Set the animation style for the PopupWindow
//                animationStyle = android.R.style.Animation_Dialog
//                // Set the elevation for the PopupWindow
//                elevation = 30f
//                this
//            }
//        }
    }

    /**
     * Get menu items based on the conversation type and conditions.
     *
     * @return MutableList<ActionItem> - A list of action items for the menu.
     */
    private fun getMenuItems(): MutableList<ActionItem> {
        return conversation?.let { con ->
            mutableListOf<ActionItem>().apply {
                // Add Action Item for Details
                add(
                    ActionItem(
                        0,
                        AndroidUtil.getString(
                            when (con.conversationType) {
                                Constants.TYPES.CONVERSATION_ONE_TO_ONE -> R.string.view_details
                                else -> R.string.group_details
                            }
                        )
                    ) { startChatDetails() }
                )

                // Add Action Item for Empty Chat
                add(
                    ActionItem(
                        0,
                        AndroidUtil.getString(R.string.empty_chat)
                    ) {  showCustomDialog(4) }
                )

                // Add Action Item for Adding to Contacts
                mIsContact || !con.conversationType?.equals(
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                )?.let { _ ->
                    add(
                        ActionItem(
                            0,
                            AndroidUtil.getString(R.string.add_to_contacts)
                        ) {  handleAddContactOption() }
                    )
                }!!

                // Add Action Item for Media Gallery
                if (!messagesDao.getAllDownloadedMediaMessages(con.conversationId).isNullOrEmpty()) {
                    add(
                        ActionItem(
                            0,
                            AndroidUtil.getString(R.string.media_gallery)
                        ) { startMediaDetailsActivity() }
                    )
                }

                // Add Action Item for Disappearing Messages
                when {
                    con.conversationType.equals(
                        Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                    ) || (con.owner.equals(senderId, ignoreCase = true) && !con.isRemoved) -> {
                        add(
                            ActionItem(
                                0,
                                AndroidUtil.getString(R.string.disappearing_messages)
                            ) {  handleDisappearOption()}
                        )
                    }
                }

                // Add Action Items for Blocking and Unblocking
                if (con.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true)) {
                    if (!isBlocked) {
                        add(
                            ActionItem(
                                0,
                                AndroidUtil.getString(R.string.blocked_user)
                            ) { handleBlockOption() }
                        )
                    } else {
                        add(
                            ActionItem(
                                0,
                                AndroidUtil.getString(R.string.unblock_user)
                            ) { handleUnBlockOption() }
                        )
                    }
                }

                // Add Action Item for Exiting Group
                if (!con.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true)) {
                    if (!con.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true) && !con.isRemoved) {
                        add(
                            ActionItem(
                                0,
                                AndroidUtil.getString(R.string.exit_group)
                            ) { showCustomDialog(5) }
                        )
                    }
                } else if (!con.owner.equals(senderId, ignoreCase = true) && !con.isRemoved) {
                    add(
                        ActionItem(
                            0,
                            AndroidUtil.getString(R.string.exit_group)
                        ) { showCustomDialog(5) }
                    )
                }
                // Add Action Item for Deleting Group
                if (!con.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true) && con.isRemoved) {
                    add(
                        ActionItem(
                            0,
                            AndroidUtil.getString(R.string.delete_group)
                        ) { showCustomDialog(6)}
                    )
                }
            }
        } ?: mutableListOf() // return an empty list if conversation is null
    }


                /**
     * Set up the chat menu toggle functionality.
     *
     * @param binding The ActivityChatBinding object.
     */
    @SuppressLint("RtlHardcoded")
    private fun setChatMenuToggle(binding: ActivityChatBinding) {
        // Locate the view where the menu icon is located
        val location = AndroidUtil.locateView(binding.ivMenu)

        // If there is an active conversation, update the chat menu accordingly
        conversation?.let { con ->
            menuBinding?.apply {
                // Set the text of the "Details" option based on whether it is a one-to-one or group chat
                tvDetails.text = if (con.conversationType.equals(
                        Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                        ignoreCase = true
                    )
                )
                    AndroidUtil.getString(R.string.view_details) else AndroidUtil.getString(R.string.group_details)
                tvMuteNotification.visibility = View.GONE
            }
        }



        // Set up the click listeners for the options in the chat menu
        setMenuOptionListeners()
    }


    private fun handleMenuVisibility(customMenuBinding: CustomMenuBinding) {
        customMenuBinding.apply {
            tvAddContact.visibility = menuAddContact()
            tvMediaGallery.visibility = menuMediaGallery()
            tvDisappearingMessage.visibility = menuDisappearingMessage()
            tvBlock.visibility = menuBlock()
            tvUnblock.visibility = menuUnblock()
            tvExit.visibility = menuExitLeave()
            tvDeleteGroup.visibility = menuDelete()
        }
    }

    private fun menuDelete(): Int {
        return if (!conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
            ) && conversation!!.isRemoved
        ) VISIBLE else GONE

    }

    private fun menuExitLeave(): Int {
        return if (!conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
            )
        ) {
            if (!conversation!!.conversationType.equals(
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                ) && !conversation!!.isRemoved
            ) VISIBLE else GONE
        } else {
            if (!conversation!!.owner.equals(
                    senderId, ignoreCase = true
                ) && !conversation!!.isRemoved
            ) VISIBLE else GONE
        }

    }

    private fun menuUnblock(): Int {
        return if (conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
            ) && isBlocked
        ) VISIBLE else GONE

    }

    private fun menuBlock(): Int {
        return if (conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
            ) && !isBlocked
        ) VISIBLE else GONE

    }

    private fun menuDisappearingMessage(): Int {
        return when {
            conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
            ) -> VISIBLE

            conversation!!.owner.equals(
                senderId, ignoreCase = true
            ) && !conversation!!.isRemoved -> VISIBLE

            else -> GONE
        }

    }

    private fun menuMediaGallery(): Int {
        return if (!messagesDao.getAllDownloadedMediaMessages(conversation!!.conversationId)
                .isNullOrEmpty()
        ) VISIBLE else GONE

    }

    private fun menuAddContact(): Int {
        return if (mIsContact || !conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
            )
        ) GONE else VISIBLE

    }

    /**
     * Set listeners for options menu.
     */
    private fun setMenuOptionListeners() {
        menuBinding?.let { binding ->
            binding.apply {
                tvAddContact.setOnClickListener {
                    handleAddContactOption()
                }
                tvDetails.setOnClickListener {
                    startChatDetails()
                    mPop?.dismiss()
                }
                tvDisappearingMessage.setOnClickListener {
                    handleDisappearOption()
                }
                tvExit.setOnClickListener {
                    showCustomDialog(5)
                    mPop?.dismiss()
                }
                tvBlock.setOnClickListener {
                    handleBlockOption()
                }
                tvUnblock.setOnClickListener {
                    handleUnBlockOption()
                }
                tvDeleteGroup.setOnClickListener {
                    showCustomDialog(6)
                    mPop?.dismiss()
                }
                tvMediaGallery.setOnClickListener {
                    startMediaDetailsActivity()
                    mPop?.dismiss()
                }
                tvEmptyChat.setOnClickListener {
                    showCustomDialog(4)
                    mPop?.dismiss()
                }
            }
        }
    }


    private fun handleUnBlockOption() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        showCustomDialog(2)

    }

    private fun handleBlockOption() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        showCustomDialog(1)
    }

    private fun handleDisappearOption() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        startDisappearingActivity()

    }

    private fun handleAddContactOption() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }

        if (Utills.isNetworkAvailable()) {
            profileData

            return
        }
        showAddContactDialog()

    }

    private fun setChatScreenBackground() {
        if (SettingsValues.getDefaultChatWallpaperSet() || SettingsValues.getDefaultChatWallpaperFileSet()) {
            if (SettingsValues.getDefaultChatWallpaperSet()) {
                mBinding?.rootView?.setBackgroundDrawable(AndroidUtil.getDrawable(SettingsValues.getDefaultChatWallpaper()))
            } else if (SettingsValues.getDefaultChatWallpaperFileSet()) {
                mBinding?.rootView?.setBackgroundDrawable(Drawable.createFromPath(SettingsValues.getDefaultChatWallpaperFile()!!))
//                mBinding?.rootView?.background=File(SettingsValues.getDefaultChatWallpaperFile()!!)
            }
        }
    }

    private fun setColorChatBackground() {
        if (SettingsValues.getDefaultChatColorsSet()) {
            val unwrappedDrawable = AppCompatResources.getDrawable(this, R.drawable.bg_send_message)
            val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
            DrawableCompat.setTint(wrappedDrawable, SettingsValues.getDefaultChatColor())
        }
    }

    fun setConversation(conversation: Conversation?) {
        this.conversation = conversation
        if (conversation?.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE) && !conversation!!.conversationMembers.isNullOrEmpty()) {
            for (members in conversation.conversationMembers!!) {
                if (!members.memberId.equals(AppSession.getUser().chatUserId)) {
                    member = members
                    break
                }
            }

        }
        handleNewConSendConfidentialMessage()
    }

    //************************************************************
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?)
    //************************************************************
    {
        super.onCreate(savedInstanceState)
        instance = this
        MainApp.appContext!!.currentActivity = this
        LocalBroadcastManager.getInstance(this).registerReceiver(
            mCommandReceiver, IntentFilter("message-receive")
        )
        MainApp.appContext?.setNotifyExpiry(this)
        if (Utills.isNetworkAvailable() && isSocketConnected.value != null && !isSocketConnected.value!!) {
            MainActivity.instance!!.initiateSocketConnection("chat activity")
        }

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        mViewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
//        imageLoader = ImageLoader { imageView: ImageView?, url: String?, payload: Any? ->
//            Glide.with(AndroidUtil.getContext()).load(url).into(
//                (imageView)!!
//            )
//        }
        setToolBar(mBinding!!.toolbar)
        mBinding!!.input.setInputListener(this)
        mBinding!!.input.setAttachmentsListener(this)
        handleEnterToSent()

        initializeEmoji()
        roomData
        setRoomData()
        initAdapter()
        loadMessages()
        mBinding!!.input.inputEditText.setPadding(45, 35, 35, 35)
        mBinding!!.input.inputEditText.setIncognitoKeyboardEnabled(true)
//        mBinding!!.input.button.rotation = 25F
        handleReaction()
        observers()
        handleSendConfidentialMessage()
//        this@ChatActivity.recordTime =
//        recordTime!!.display()

    }

    override fun onStart() {
        super.onStart()
//        setUnreadBadge(conversation)
    }


    fun handleSendConfidentialMessage() {

        if (conversation?.isConfidential ?: false) {
            mBinding?.apply {
                input.inputEditText.hint = AndroidUtil.getString(R.string.send_confidential_message)
            }
        }

    }

    fun handleNewConSendConfidentialMessage() {
        if (intent.hasExtra(Constants.KEYS.INTENT_NEW_CONVERSATION) && conversation?.isConfidential!!) {

            mBinding?.apply {
                input.inputEditText.hint = AndroidUtil.getString(R.string.send_confidential_message)
            }

        }
    }

    private fun handleEnterToSent() {
        if (SettingsValues.getEnterKeySends()) {
            mBinding!!.input.inputEditText.imeOptions = EditorInfo.IME_ACTION_SEND
            mBinding!!.input.inputEditText.isSingleLine = true
            Log.e(TAG, "Options ${mBinding!!.input.inputEditText.imeOptions}")
            mBinding!!.input.inputEditText.setOnEditorActionListener { _, actionId, _ ->
                return@setOnEditorActionListener when (actionId) {
                    EditorInfo.IME_ACTION_SEND -> {
//                    sendMessage()
                        if (!mBinding!!.input.inputEditText.text.isNullOrEmpty()) {
                            onSubmit(mBinding!!.input.inputEditText.text)
                            mBinding!!.input.inputEditText.text.clear()
                        }
                        Log.e(TAG, "Send clicked")
                        true
                    }

                    else -> false
                }
            }
        }
    }

    private fun handleReaction() {
        val reactionOverlayStub: Stub<ConversationReactionOverlay> =
            ViewUtil.findStubById(mBinding!!.root, R.id.conversation_reaction_scrubber_stub)
        reactionDelegate = ConversationReactionDelegate(reactionOverlayStub)

    }

    /**
     * Loads a message into the conversation's chat view by adding it to the adapter and sending an "ack_read" payload to
     * indicate that the message has been read.
     *
     * @param payload The message payload to load.
     */
    fun loadMessage(payload: Payload) {
        // Check if the payload is valid for this conversation
        if (checkPayloadWithConversation(payload)) {
            // Schedule the message to expire if necessary
            scheduleExpiry(payload)

            conversation?.let {// Check if the payload is for the current conversation
                if (payload.conversationId.equals(
                        conversation!!.conversationId,
                        ignoreCase = true
                    )
                ) {
                    // Check if the conversation is one-to-one or group
                    var isOneToOne = conversation!!.conversationType.equals(
                        Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                        ignoreCase = true
                    )
                    // Check if the sender is a contact
                    var isContact = checkIsContact(isOneToOne, payload)

                    // Wrap the payload in a Message object for the adapter
                    val messages = messageWrapper(payload)

                    // Add the message to the adapter and update the UI
                    adapter!!.addToStart(messages, true)

                    // Send an "ack_read" payload to indicate that the message has been read
                    Handler(Looper.getMainLooper()).postDelayed({
                        val payload1 = Payload()
                        payload1.type = "ack_read"
                        payload1.conversationId = payload.conversationId
                        payload1.conversationType = payload.conversationType
                        payload1.messageId = payload.messageId
                        payload1.createdAt = payload.createdAt
                        payload1.senderId = payload.senderId
                        payload1.ack_id = Utills.getRandomString(5)
                        payload1.userChatId = this@ChatActivity.senderId



                        conversation?.let{ con ->
                            if (EncryptionUtils.checkSentMessage(con)) { // Check if the conversation is group and the message is not from the current user
                                Log.e(TAG, "Load Message $payload1")
                                if (!isOneToOne && Utills.checkPayloadRead(payload)) {
                                    // Send offline acks to all members except the current user
                                    EncryptionUtils.sendOfflineAcks(payload1)
                                }
                                // Check if the message has unknown read receipts or the sender is a contact
                                else if (SettingsValues.getMessageReadReceiptsUnknown() || isContact) {
                                    // Send offline acks to all members
                                    EncryptionUtils.sendOfflineAcks(payload1)
                                }
                            }
                        }


                        // Update the message status to "seen" in the local database
                        messagesDao.updateMessage(Constants.SEEN, payload1.messageId)
                    }, 1500)
                }
            }
        }
    }


    private fun checkIsContact(oneToOne: Boolean, payload: Payload): Boolean {
        return if (oneToOne) {
            if (Utills.checkPayloadRead(payload)) {
                var receiverId: String? = null
                val member = conversation?.conversationMembers?.find { member ->
                    !member.memberId.equals(AppSession.getUser().chatUserId)
                }
                receiverId = if (member != null) {
                    member.memberId
                } else {
                    null
                }
                checkContactNull(receiverId) != null
            } else {

                false
            }
        } else false
    }

    private fun messageWrapper(payload: Payload): Messages? {
        val messages = Messages()
        val user = User()
        user.chatUserId = payload.userChatId
        user.chatNickName = ""
        user.profileImage = null
        messages.createdAt = Date()
        messages.payload = payload
        messages.user = user
        return messages
    }

    private fun checkPayloadWithConversation(payload: Payload): Boolean {
        return payload != null && conversation != null
    }

    fun loadNotifyMessage(payload: Payload?) {
        if (payload != null && conversation != null) {
            Log.d("TAG", "mutable payload " + payload.messageId)
            if (payload.conversationId.equals(conversation!!.conversationId, ignoreCase = true)) {
                val messages = Messages()
                val user = User()
                user.chatUserId = payload.userChatId
                user.chatNickName = ""
                user.profileImage = null
                messages.createdAt = Date()
                messages.payload = payload
                messages.user = user
                adapter!!.addToStart(messages, true)
            }
        }
    }


    //************************************************************
    private fun initializeEmoji()
    //************************************************************
    {
        mPopup = EmojiPopup(
            mBinding!!.rootView,
            mBinding!!.input.inputEditText,
            searchEmoji = NoSearchEmoji,
            onEmojiPopupShownListener = {
                MessageInputChat.getInstance().attachmentButton.setImageDrawable(
                    AndroidUtil.getDrawable(R.drawable.ic_keyboard)
                )
            },
            onEmojiPopupDismissListener = {
                MessageInputChat.getInstance().attachmentButton.setImageDrawable(
                    AndroidUtil.getDrawable(R.drawable.ic_emoji)
                )
            },
            keyboardAnimationStyle = R.style.emoji_fade_animation_style,
        )
//            .Builder
//            .fromRootView(
//                findViewById(R.id.rootView)
//            )
//            .build(mBinding!!.input.inputEditText)
    }

    //************************************************************
    @RequiresApi(Build.VERSION_CODES.R)
    private fun listeners()
    //************************************************************
    {
        mBinding?.apply {
            ivChatImage.setOnClickListener { startChatDetails() }
            tvName.setOnClickListener { startChatDetails() }
            groupMembers.setOnClickListener { startChatDetails() }
            ivDelete.setOnClickListener { showDeleteDialog() }
            ivShare.setOnClickListener { startShareToActivity() }
            btnAddContact.setOnClickListener {

            }

            ivEmoji.setOnClickListener {


                handleAttachmentPopup()

            }
            input.setTypingListener(object : TypingListener {
                override fun onStartTyping() {
//                ViewUtil.fadeOut(
//                    mBinding!!.ivEmoji,
//                    600
//                )
                    handleOnStartTyping()
                }

                override fun onStopTyping() {
//                ViewUtil.fadeIn(
//                    mBinding!!.ivEmoji,
//                   500
//                )
                    handleOnStopTyping()
                }
            })
            input.button?.isEnabled = true
            recorderView.setTouchView(mBinding?.input?.button!!)
            input.inputEditText.setOnClickListener {
                if (Utills.isSubscriptionExpired()) {
                    Utills.showSubscriptionEnd()
                    return@setOnClickListener
                }
                if (mPopup.isShowing) {
                    isToggle = false
                    MessageInputChat.getInstance().attachmentButton.setImageDrawable(
                        AndroidUtil.getDrawable(
                            R.drawable.ic_emoji
                        )
                    )
                    mPopup.dismiss()
                }
            }
            ivEdit.setOnClickListener {

                handlePastClick()

            }
            ivCopy.setOnClickListener { _: View? ->
                handleCopyClick()
            }
            fabSendMessage.setOnClickListener {
                if (Utills.isSubscriptionExpired()) {
                    Utills.showSubscriptionEnd()
                    return@setOnClickListener
                }
                resetAllModes()
            }
        }
    }

    private fun handleCopyClick() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        val clipboardManager: ClipboardManager =
            getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clipData: ClipData = ClipData.newPlainText(
            "text whatever you want", editingMessage!!.payload.data
        )
        clipboardManager.setPrimaryClip(clipData)
        Notify.Toast("Text Copied")
        resetAllModes()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handlePastClick() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }

        val clipmanager = ServiceUtil.getClipboardManager(this@ChatActivity)
        if (clipmanager.hasPrimaryClip()) {

            val item = clipmanager.primaryClip!!.getItemAt(0)

            val pasteUri: Uri? = item.uri

            if (pasteUri != null) {
                if (pasteUri.scheme == ContentResolver.SCHEME_CONTENT) {
                    file = FilePath.fileFromContentUri(this@ChatActivity, pasteUri)
                }


                if (file != null && file!!.exists()) {
                    mediaType = "image"
//                            file = File(payloadToForward.filePath)
                    filePath = file!!.path
                    uploadFile()
                    val clipboardManager = ServiceUtil.getClipboardManager(this@ChatActivity)
                    clipboardManager.setPrimaryClip(
                        ClipData.newPlainText(
                            this@ChatActivity.getString(
                                R.string.app_name
                            ), " "
                        )
                    )
                    mBinding!!.ivEdit.visibility = GONE
                } else {
                    mBinding!!.ivEdit.visibility = GONE
                    Notify.Toast(Constants.FILE_NOT_EXIST)
                }


            }
        }
    }

    private fun handleOnStopTyping() {
        if (!mBinding?.input?.inputEditText?.text.isNullOrEmpty()) {
            mBinding?.input?.button?.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_send_chat))
//                mBinding!!.input?.button?.rotation = 25F
//                mBinding?.input?.button?.
            canSendAudio = false
            mBinding?.recorderView?.removeTouchView(mBinding?.input?.button!!)

        } else {
            mBinding?.input?.button?.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_audio_chat))
//                mBinding!!.input?.button?.rotation = 0F
            canSendAudio = true
            mBinding?.recorderView?.setTouchView(mBinding?.input?.button!!)
        }
        mBinding?.input?.button?.isEnabled = true
    }

    private fun handleOnStartTyping() {
        if (!mBinding?.input?.inputEditText?.text.isNullOrEmpty()) {
            mBinding?.input?.button?.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_send_chat))
//                mBinding!!.input?.button?.rotation = 25F
//                mBinding?.input?.button?.
            canSendAudio = false
            mBinding?.recorderView?.removeTouchView(mBinding?.input?.button!!)
            mBinding?.input?.inputEditText?.isEnabled = true

        } else {
            mBinding?.input?.button?.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_audio_chat))
//                mBinding!!.input?.button?.rotation = 0F
            canSendAudio = true;
            mBinding?.recorderView?.setTouchView(mBinding?.input?.button!!)
        }
        mBinding?.input?.button?.isEnabled = true
    }

    private fun handleAttachmentPopup() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        if (mPopup.isShowing) {
            isToggle = false
            MessageInputChat.getInstance().attachmentButton.setImageDrawable(
                AndroidUtil.getDrawable(
                    R.drawable.ic_emoji
                )
            )
            mPopup.dismiss()
        }

        val v: View = LayoutInflater.from(this@ChatActivity).inflate(
            R.layout.attachement_sent, null
        )

        val attachementbinding = AttachementSentBinding.bind(v)

        val mPop = PopupWindow(
            attachementbinding.root,
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.WRAP_CONTENT,
            true
        )
        mPop.animationStyle = android.R.style.Animation_Dialog

        val location: Rect = AndroidUtil.locateView(mBinding!!.input)


        //Minimizing the softInput keyboard
        mPop.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED
        mPop.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE



        mPop.showAtLocation(
            mBinding?.input, Gravity.BOTTOM, 0, location.height() + 50
        )

        attachementbinding.layoutImage.setOnClickListener {
            Permissions.with(this@ChatActivity).request(
                READ_EXTERNAL_STORAGE
            ).ifNecessary()
//                    .withPermanentDenialDialog(getString(R.string.VerifyIdentityActivity_chat_needs_the_camera_permission_in_order_to_scan_a_qr_code_but_it_has_been_permanently_denied))
                .onAllGranted {
                    ImagePicker.with(this@ChatActivity).galleryMimeTypes(
                        Constants.image
                    ).galleryOnly().start(RequestCodes.PICKFILE_RESULT_CODE)
                    mPop.dismiss()
                }.onAnyDenied {
                    mPop.dismiss()

                }.onAnyPermanentlyDenied {
                    Notify.Toast(Constants.GRANT_PERMISSION)
                    mPop.dismiss()
                }.execute()

        }

        attachementbinding.layoutAudio.setOnClickListener {
            Permissions.with(this@ChatActivity).request(
                READ_EXTERNAL_STORAGE
            ).ifNecessary()
//                    .withPermanentDenialDialog(getString(R.string.VerifyIdentityActivity_chat_needs_the_camera_permission_in_order_to_scan_a_qr_code_but_it_has_been_permanently_denied))
                .onAllGranted {
                    ImagePicker.with(this@ChatActivity).galleryMimeTypes(
                        Constants.audio
                    ).galleryOnly().start(RequestCodes.PICKFILE_RESULT_CODE)
                    mPop.dismiss()
                }.onAnyDenied {
                    Notify.Toast(Constants.GRANT_PERMISSION)
                    mPop.dismiss()

                }.onAnyPermanentlyDenied {
                    Notify.Toast(Constants.GRANT_PERMISSION)
                    mPop.dismiss()
                }.execute()

        }

        attachementbinding.layoutFiles.setOnClickListener {
            Permissions.with(this@ChatActivity).request(
                READ_EXTERNAL_STORAGE
            ).ifNecessary()
//                    .withPermanentDenialDialog(getString(R.string.VerifyIdentityActivity_chat_needs_the_camera_permission_in_order_to_scan_a_qr_code_but_it_has_been_permanently_denied))
                .onAllGranted {
                    ImagePicker.with(this@ChatActivity).galleryMimeTypes(
                        Constants.file
                    ).galleryOnly().start(RequestCodes.PICKFILE_RESULT_CODE)
                    mPop.dismiss()
                }.onAnyDenied {
                    Notify.Toast(Constants.GRANT_PERMISSION)
                    mPop.dismiss()

                }.onAnyPermanentlyDenied {
                    Notify.Toast(Constants.GRANT_PERMISSION)
                    mPop.dismiss()
                }.execute()
        }

        attachementbinding.layoutVideo.setOnClickListener {
            startActivityForResult(
                Intent(
                    this@ChatActivity, CameraActivity::class.java
                ).putExtra(Constants.KEYS.INTENT_CONVERSATION, conversation),
                RequestCodes.MEDIA_EDIT_SHOW
            )
            mPop.dismiss()
        }


        mPop.setOnDismissListener {
            if (!Utills.isSubscriptionExpired()) {
                mBinding!!.input.inputEditText.requestFocus()
            }
        }
    }

    private fun fadeIn(v: View) {
        v.animate().alpha(1f).setDuration(150L).start()

    }

    private fun fadeOut(v: View) {
        v.animate().alpha(0f).setDuration(150L).start()
    }

    //************************************************************
    private fun showAddContactDialog()
    //************************************************************
    {
        val alertCustomdialog =
            LayoutInflater.from(this).inflate(R.layout.custom_dailog_add_contact, null)
        //initialize alert builder
        val mCreateDialogBinding = CustomDailogAddContactBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(this)
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(mCreateDialogBinding.root)
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mUser?.apply {
            if (!TextUtils.isEmpty(this.chatNickName!!.trim { it <= ' ' })) {
                mCreateDialogBinding.etNewContact1.setText(mUser!!.chatNickName)
            }
        }
        mCreateDialogBinding.tvPriveId.text = member!!.memberId
        mCreateDialogBinding.etNewContact1.requestFocus()
        mBinding!!.btnAddContact.visibility = View.GONE
        //finally show the dialog box in android all
        mCreateDialog!!.show()
        mCreateDialogBinding.btnCancel.setOnClickListener { mCreateDialog!!.dismiss() }
        mCreateDialogBinding.btnAddContact.setOnClickListener {
            handleAddContactDialogButton(mCreateDialogBinding)
        }
    }

    private fun handleAddContactDialogButton(mCreateDialogBinding: CustomDailogAddContactBinding) {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        if (!TextUtils.isEmpty(
                mCreateDialogBinding.etNewContact1.text.toString().trim { it <= ' ' })
        ) {
            val contact = Contact()
            contact.chatUserId = mUser!!.chatUserId
            contact.name = mCreateDialogBinding.etNewContact1.text.toString()
            contact.color = Utills.colors.get(Utills.rnd.nextInt(Utills.colors.size))
            contact.avatarColor = AvatarColor.random()
            mUser?.let {
                if (mUser!!.chatNickName!!.trim().isNotEmpty()) {
                    contact.alias = mUser!!.chatNickName!!
                }
            }
            val contacts: List<Contact>? = contactsDao.allContacts
            var hasContact = false
            var existedContact = Contact()
            if (contacts != null && contacts.isNotEmpty()) {
                hasContact = contacts.any { contactInDb ->
                    contactInDb.chatUserId.equals(
                        contact.chatUserId, ignoreCase = true
                    )
                }
                handleUpdatingContact(contact, hasContact, existedContact, mCreateDialogBinding)
            } else {
                handleNewContactAdding(contact)
            }
            mContact?.let {
                if (!TextUtils.isEmpty(mContact!!.name)) {
                    conversation!!.name = mContact!!.name
                    MainApp.appContext?.conversationsDao?.updateName(
                        conversation!!.conversationId, conversation!!.name
                    )
                }
            }

            mCreateDialog!!.dismiss()


        } else {
            Notify.Toast("Please Enter NickName ")
        }
    }

    private fun handleNewContactAdding(contact: Contact) {
        contactsDao.insert(contact)
        mContact!!.name = contact.name
        mContact!!.chatUserId = (contact.chatUserId)
        mContact!!.color = (contact.color)
        mContact!!.avatarColor = (contact.avatarColor)
        mUser?.let {
            if (mUser!!.chatNickName!!.trim().isNotEmpty()) {
                mContact!!.alias = mUser!!.chatNickName
            }
        }
        mIsContact = true
        mBinding!!.tvName.text = (contact.name)
        Glide.with(this).load(
            Utills.getNameDrawable(contact.name, contact.avatarColor!!)
        ).into(mBinding!!.ivChatImage)
        contactAdded = true
        mBinding!!.btnAddContact.visibility = View.GONE
        Notify.Toast("New contact added")
    }

    private fun handleUpdatingContact(
        contact: Contact,
        hasContact: Boolean,
        existedContact: Contact,
        mCreateDialogBinding: CustomDailogAddContactBinding
    ) {
        if (hasContact) {
            existedContact.name = (mCreateDialogBinding.etNewContact1.text.toString())
            mUser?.let {
                if (mUser!!.chatNickName!!.trim().isNotEmpty()) {
                    existedContact.alias = mUser!!.chatNickName
                    mContact!!.alias = mUser!!.chatNickName
                }
            }
            contactsDao.insert(existedContact)
            mContact!!.name = (contact.name)
            mContact!!.chatUserId = (contact.chatUserId)
            mContact!!.color = (contact.color)
            mContact!!.avatarColor = (contact.avatarColor)

            mIsContact = true
            mBinding!!.tvName.text = contact.name
            Glide.with(this).load(
                Utills.getNameDrawable(contact.name, contact.avatarColor!!)
            ).into(mBinding!!.ivChatImage)
            contactAdded = true
            mBinding!!.btnAddContact.visibility = View.GONE
            Notify.Toast("Contact updated")
        } else {
            contactsDao.insert(contact)
            mUser?.let {
                if (mUser!!.chatNickName!!.trim().isNotEmpty()) {
                    mContact!!.alias = mUser!!.chatNickName
                }
            }
            mContact!!.name = (contact.name)
            mContact!!.chatUserId = (contact.chatUserId)
            mContact!!.color = (contact.color)
            mContact!!.avatarColor = (contact.avatarColor)
            mIsContact = true
            mBinding!!.tvName.text = (contact.name)
            Glide.with(this).load(
                Utills.getNameDrawable(contact.name, contact.avatarColor!!)
            ).into(mBinding!!.ivChatImage)
            contactAdded = true
            mBinding!!.btnAddContact.visibility = View.GONE
            Notify.Toast("New contact added")
        }
    }

    //************************************************************
    private fun startShareToActivity()
    //************************************************************
    {
        startActivity(Intent(this@ChatActivity, ShareToActivity::class.java))
    }

    private fun startChatDetails() {

        val intent: Intent =
            Intent(this@ChatActivity, ChatDetailsActivity::class.java).putExtra("contact", mContact)
                .putExtra("conversation", conversation).putExtra("isContact", mIsContact)

        val bundle: Bundle = ChatDetailsActivity.createTransitionBundle(
            this, mBinding!!.ivChatImage
        )!!

        ActivityCompat.startActivity(this@ChatActivity, intent, bundle)
    }

    //************************************************************
    private fun startMediaDetailsActivity()
    //************************************************************
    {
        startActivity(
            Intent(
                this, MediaDetailsActivity::class.java
            ).putExtra(Constants.KEYS.INTENT_CONVERSATION, conversation)
        )
    }

    //************************************************************
    private fun startDisappearingActivity()
    //************************************************************
    {
        startActivity(
            Intent(
                this@ChatActivity, DisappearingMsgActivity::class.java
            ).putExtra(Constants.KEYS.INTENT_CONVERSATION, conversation)
        )
    }


    //************************************************************
    private val profileData: Unit
        get()
        //************************************************************
        {
            Log.d(
                TAG,
                "ChatActivity getProfileData: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_PROFILE + Constants.REQUEST + "chat_user_id= " + mName
            )
            ApiHelper.with()?.profileData(AppSession.getUser().chatUserId, member!!.memberId, this)

        }

    //************************************************************
    private fun observers()
    //************************************************************
    {
        //Is used for observers if used any in class

    }

    //************************************************************
    private fun clearConversationChat()
    //************************************************************
    {
        val mediaMessage = messagesDao.getAllMediaMessages(conversation!!.conversationId)
        //Getting all the media files of the conversation for them to delete
        if (mediaMessage != null && mediaMessage.size > 0) {
            //If there are any media files delete them one by one
            for (payload: Payload in mediaMessage) {
                if (payload.filePath != null) {
                    val file = File(payload.filePath!!)
                    //if the file exist delete it from the file path
                    if (file.exists()) {
                        file.delete()
                        messagesDao.deleteByMessageId(payload.messageId)
                    }
                }
            }
        }
        //Delete all messages of the conversation from local Database
        messagesDao.deleteConversationMessages(conversation!!.conversationId)

        //Removing View of shared Media
//        showMedia()

        //Removing last message of the conversation
        if (conversation!!.lastMessage != null) {
            conversation!!.lastMessage = null
            try {
                conversationsDao.update(conversation)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
        //Removing last message of the conversation
        clearChat()

    }

    fun clearChat() {
        if (adapter != null) {
            adapter!!.clear()
        }
    }


    fun deleteExpiryMessage(id: String?) {
        mBinding?.let {
            if (adapter != null) {
                adapter!!.deleteById(id)
            }
        }
    }

    //************************************************************
    private val roomData: Unit
        @RequiresApi(Build.VERSION_CODES.O) get() {
            if (intent.extras != null) {
                if (intent.hasExtra(Constants.KEYS.INTENT_TYPE)) {
                    type = intent.getStringExtra(Constants.KEYS.INTENT_TYPE)

                }
                //            mRoom = (ChatRoom) bundle.getSerializable("room");

                //If the User is coming from Forward/ShareToActivity
                if (intent.hasExtra(Constants.KEYS.INTENT_FROM_FORWARD)) {
                    //Get Current Conversation
                    conversation =
                        intent.getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation?

                    //updating in conversation
                    updateInConversation()
                    conversation_pk = conversation!!.uid
                    val isGroup = conversation!!.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP, ignoreCase = true
                    ) || conversation!!.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                    )
                    if (conversation!!.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE) && !conversation!!.conversationMembers.isNullOrEmpty()) {
                        for (members in conversation!!.conversationMembers!!) {
                            if (!members.memberId.equals(AppSession.getUser().chatUserId)) {
                                member = members
                                break
                            }
                        }
                    }

                    //Check if the other member is blocked

                    if (!isGroup && !conversation!!.conversationMembers.isNullOrEmpty()) {
                        isBlocked = conversation!!.conversationMembers?.any { members ->
                            AppSession.getUser().blockUsers!!.contains(members.memberId)
                        } ?: false
                    }


                    //If we are removed or we left from this conversation remove sending UI
                    if (conversation!!.isRemoved) {
                        mBinding!!.input.visibility = View.GONE
                        mBinding!!.ivEmoji.visibility = View.GONE
                        mBinding!!.tvCanNotSend.visibility = View.VISIBLE
                    }
                    //Get Name if we are coming from Home Fragment or the conversation is not a contact
                    if (intent.hasExtra("name")) {
                        mName = intent.getStringExtra("name")
                        mContact!!.name = mName
                        mBinding!!.tvName.text = mName
                        //Check for handling if the we have a non contact conversation
                        if (intent.hasExtra("isContact")) {
                            mIsContact = intent.getBooleanExtra("isContact", false)
                            if (mIsContact) {
                                val id = intent.getStringExtra("chatID")
                                if (!id.equals("null", ignoreCase = true)) {
                                    mContact!!.chatUserId = id
                                }
                                mContact!!.id = intent.getIntExtra("ContactID", 0)
                            }
                            //setting the visibility if the Add contact button for it is used in Adding contact to contact list
                            mBinding!!.btnAddContact.visibility = GONE
                            if (intent.hasExtra("color")) mContact!!.color =
                                intent.getStringExtra("color")

                            //Gliding the image if conversation is group and have an image
                            if (isGroup && conversation!!.photo != null && !conversation!!.photo.equals(
                                    Constants.KEYS.DUMMY_IMAGE, ignoreCase = true
                                ) && conversation!!.conversationPhoto != null && conversation!!.conversationPhoto!!.isNotEmpty()
                            ) {
                                val file = File(conversation!!.conversationPhoto!!)
                                Glide.with(this).load(
                                    if (file.exists()) conversation!!.conversationPhoto else Utills.getNameDrawable(
                                        mName, AvatarColor.GROUP
                                    )
                                ).into(mBinding!!.ivChatImage)
                            } else {
                                if (mIsContact) {
                                    val contact = contactsDao.getContact(mContact!!.chatUserId)
                                    if (contact != null) {
                                        //Essential for setting Drawable of conversation
                                        mContact!!.avatarColor = contact.avatarColor
                                        Glide.with(this).load(
                                            if (!isGroup) Utills.getNameDrawable(
                                                contact.name, contact.avatarColor!!
                                            ) else R.drawable.ic_unknown
                                        ).into(mBinding!!.ivChatImage)
                                    } else {
                                        Glide.with(this).load(
                                            R.drawable.ic_unknown
                                        ).into(mBinding!!.ivChatImage)
                                    }
                                } else {
                                    Glide.with(this).load(
                                        if (isGroup) Utills.getNameDrawable(
                                            mName, AvatarColor.GROUP
                                        ) else R.drawable.ic_unknown
                                    ).into(mBinding!!.ivChatImage)
                                }

                            }
                        }
                    }
                    if (intent.hasExtra(Constants.KEYS.INTENT_CONTACT)) {
                        mContact =
                            intent.getSerializableExtra(Constants.KEYS.INTENT_CONTACT) as Contact?
                        mBinding!!.tvName.text = mContact!!.name
                        mBinding!!.btnAddContact.visibility = View.GONE
                        mIsContact = true
                        Glide.with(this@ChatActivity)
                            .load(Utills.getNameDrawable(mContact!!.name, mContact!!.avatarColor!!))
                            .into(
                                mBinding!!.ivChatImage
                            )
                    }
                    if (conversation!!.conversationType.equals(
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                        )
                    ) {
                        mBinding!!.groupMembers.visibility = View.GONE
                    } else {
                        mBinding!!.groupMembers.visibility = View.VISIBLE
                        setMembersName()
                        mBinding!!.btnAddContact.visibility = View.GONE
                    }

                    //getting payload to be sent from froward action
                    if (intent.hasExtra("payload")) {

                        //Setting sender id on which basis we distinguish the message is on left or right side
                        if (conversation!!.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS)) {
                            if (conversation!!.myMoniker != null) {
                                senderId = conversation!!.myMoniker
                            } else {
                                if (!conversation!!.conversationMembers.isNullOrEmpty()) {
                                    for (member: ConversationMember in conversation!!.conversationMembers!!) {
                                        if (member.isMe) {
                                            senderId = member.moniker
                                            conversationsDao.updateMyMoniker(
                                                conversation!!.conversationId, member.moniker
                                            )
                                            break
                                        }
                                    }
                                }
                            }
                        } else {
                            senderId = AppSession.getUser().chatUserId
                        }

                        //Actual payload to be sent
                        payloadToForward = intent!!.getSerializableExtra("payload") as Payload
                        if (payloadToForward != null && !Utills.isSubscriptionExpired()) {

                            ThreadUtil.runOnMainDelayed({
                                if (payloadToForward!!.type.equals("text", ignoreCase = true)) {
                                    if (!isBlocked) {

                                        val payload = Payload()
                                        payload.data = payloadToForward!!.data
                                        //                payload.userChatId = AppSession.getUser().chatUserId
                                        payload.userChatId = senderId
                                        //                payload.senderId = AppSession.getUser().chatUserId
                                        payload.senderId = senderId

                                        payload.conversationId = conversation!!.conversationId
                                        //            Notify.Toast("Type in On submit"+ type);
                                        Log.d("TAG", "onSubmit: $type")
                                        payload.type = "text"
                                        payload.messageId = Utills.getRandomString(15)
                                        payload.createdAt = DateTime.getCurrentDateTime()
                                        payload.received_at = payload.createdAt

                                        payload.isForwarded = payloadToForward!!.isForwarded
                                        payload.isExpire =
                                            conversation != null && conversation!!.conversationExpiryTime >= 0
                                        payload.isViewOnce =
                                            conversation != null && conversation!!.conversationExpiryTime == 0L

                                        payload.isCanShareForward = conversation!!.isCanShareForward
                                        payload.msgExpiryTime =
                                            conversation!!.conversationExpiryTime
                                        Log.d(
                                            "TAG",
                                            "mesagetime: " + payload.createdAt + " " + payload.data
                                        )
                                        payload.conversationType = conversation!!.conversationType
                                        payload.readReceipts =
                                            getReadReceipt()

                                        if (Utills.isNetworkAvailable() && isSocketConnected.value != null && isSocketConnected.value!!) {
                                            Log.e(TAG, "Message Id: ${payload.messageId}")
                                            EncryptionUtils.encryptMessage(
                                                payload.data!!, payload, this
                                            )
                                        } else {
                                            val offlineMessage = OfflineMessage()
                                            EncryptionUtils.offlineMessageConcept(
                                                payload.data!!, payload, offlineMessage, this
                                            )
                                        }
                                        payload.data = payloadToForward!!.data
                                        conversation!!.lastMessage = payload
                                        conversation!!.sequenceOfConversation =
                                            System.currentTimeMillis()
                                        conversationsDao.update(conversation)
                                        val messages = Messages()
                                        messages.user = AppSession.getUser()
                                        messages.user.chatUserId = payload.userChatId
                                        messages.payload = payload
                                        messages.createdAt = Date()
                                        messagesDao.insert(payload)
                                    } else {
                                        showBlockUserDialog()
                                    }
                                } else {
                                    filePath = payloadToForward!!.filePath
                                    file = File(payloadToForward!!.filePath!!)
                                    isForwarded = payloadToForward!!.isForwarded
                                    if (file!!.exists()) {
                                        mediaType = payloadToForward!!.type
                                        uploadForwardFile()
                                    } else {
                                        Notify.Toast(Constants.FILE_NOT_EXIST)
                                    }
                                }
                            }, 500)


                        } else if (Utills.isSubscriptionExpired()) {
                            Notify.Toast(AndroidUtil.getString(R.string.subscription_ended))
                        }
                    }

                } else if (intent.hasExtra(Constants.KEYS.INTENT_CONVERSATION)) {
                    conversation =
                        intent.getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation?

                    //updating in conversation
                    updateInConversation()

                    conversation_pk = conversation!!.uid
                    val isGroup = conversation!!.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP, ignoreCase = true
                    ) || conversation!!.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                    )


                    if (conversation!!.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE) && !conversation!!.conversationMembers.isNullOrEmpty()) {
                        for (members in conversation!!.conversationMembers!!) {
                            if (!members.memberId.equals(AppSession.getUser().chatUserId)) {
                                member = members
                                break
                            }
                        }
                    }


                    if (!isGroup && !conversation!!.conversationMembers.isNullOrEmpty()) {
                        for (members in conversation!!.conversationMembers!!) {
                            if (AppSession.getUser().blockUsers!!.contains(members.memberId)) {
                                isBlocked = true
                            }
                        }
                    }

                    if (conversation!!.isRemoved) {
                        mBinding!!.input.visibility = View.GONE
                        mBinding!!.ivEmoji.visibility = View.GONE
                        mBinding!!.tvCanNotSend.visibility = View.VISIBLE
                    }
                    if (intent.hasExtra("name")) {
                        mName = intent.getStringExtra("name")
                        mContact!!.name = mName
                        mBinding!!.tvName.text = mName
                        if (intent.hasExtra("isContact")) {
                            mIsContact = intent.getBooleanExtra("isContact", false)
                            if (mIsContact) {
                                val id = intent.getStringExtra("chatID")
                                if (!id.equals("null", ignoreCase = true)) {
                                    mContact!!.chatUserId = id
                                }
                                mContact!!.id = intent.getIntExtra("ContactID", 0)
                            }
                            mBinding!!.btnAddContact.visibility = GONE
                            if (intent.hasExtra("color")) mContact!!.color =
                                intent.getStringExtra("color")
                            if (isGroup && conversation!!.photo != null && !conversation!!.photo.equals(
                                    Constants.KEYS.DUMMY_IMAGE, ignoreCase = true
                                ) && conversation!!.conversationPhoto != null && conversation!!.conversationPhoto!!.isNotEmpty()
                            ) {
                                val file = File(conversation!!.conversationPhoto)
                                Glide.with(this).load(
                                    if (file.exists()) conversation!!.conversationPhoto else Utills.getNameDrawable(
                                        mName, AvatarColor.GROUP
                                    )
                                ).into(mBinding!!.ivChatImage)
                            } else {
                                if (mIsContact) {
                                    val contact = contactsDao.getContact(mContact!!.chatUserId)
                                    if (contact != null) {
                                        mContact!!.avatarColor = contact.avatarColor
                                        Glide.with(this).load(
                                            if (!isGroup) Utills.getNameDrawable(
                                                contact.name, contact.avatarColor!!
                                            ) else R.drawable.ic_unknown
                                        ).into(mBinding!!.ivChatImage)
                                    } else {
                                        Glide.with(this).load(
                                            R.drawable.ic_unknown
                                        ).into(mBinding!!.ivChatImage)
                                    }
                                } else {
                                    Glide.with(this).load(
                                        if (isGroup) Utills.getNameDrawable(
                                            mName, AvatarColor.GROUP
                                        ) else R.drawable.ic_unknown
                                    ).into(mBinding!!.ivChatImage)
                                }

                            }
                        }
                    }
                    if (intent.hasExtra(Constants.KEYS.INTENT_CONTACT)) {
                        mContact =
                            intent.getSerializableExtra(Constants.KEYS.INTENT_CONTACT) as Contact?
                        mBinding!!.tvName.text = mContact!!.name
                        mBinding!!.btnAddContact.visibility = View.GONE
                        mIsContact = true
                        Glide.with(this@ChatActivity)
                            .load(Utills.getNameDrawable(mContact!!.name, mContact!!.avatarColor!!))
                            .into(
                                mBinding!!.ivChatImage
                            )
                    }
                    if (conversation!!.conversationType.equals(
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                        )
                    ) {
                        mBinding!!.groupMembers.visibility = View.GONE
                    } else {
                        mBinding!!.groupMembers.visibility = View.VISIBLE
                        setMembersName()
                        mBinding!!.btnAddContact.visibility = View.GONE
                    }
                } else if (intent.hasExtra(Constants.KEYS.INTENT_NEW_CONVERSATION)) {
                    //if the conversation is coming from new message activity and we need to create the conversation first
                    //Hit the Create New Conversation API for creating the conversation either it is one-to-one or group
                    if (type.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true)) {
                        if (intent.hasExtra(Constants.KEYS.INTENT_CONTACT)) {
                            NewContact =
                                intent.getSerializableExtra(Constants.KEYS.INTENT_CONTACT) as Contact?
                            if (intent.hasExtra(Constants.KEYS.INTENT_FILE_PATH)) mFile =
                                File(intent.getStringExtra(Constants.KEYS.INTENT_FILE_PATH)!!)
                            mBinding!!.tvName.text = NewContact!!.name
                            mContact = NewContact
                            mIsContact = true
                            Glide.with(this).load(
                                Utills.getNameDrawable(
                                    NewContact!!.name, NewContact!!.avatarColor!!
                                )
                            ).into(
                                mBinding!!.ivChatImage
                            )
                            val members: MutableList<String> = ArrayList()
                            members.add(AppSession.getUser().chatUserId!!)
                            NewContact!!.chatUserId?.let { members.add(it) }
                            val memberslist: MutableList<String> = ArrayList()
                            for (s in members) {
                                memberslist.add("\"" + s + "\"")
                            }
                            if (AppSession.getUser().blockUsers!!.contains(NewContact!!.chatUserId!!)) {
                                isBlocked = true
                            }
                            //                    CreateConversationRequest request = new CreateConversationRequest();
//                    request.setType(type);
//                    request.setDescription("one-to-one");
//                    request.setName("one-to-one");
//                    request.setUserChatId(AppSession.getUser().getChatUserId());
//                    request.setMembers(members);

                            //Creating new conversation without Image upload
                            //Default Timer is 30 minutes
                            createNewConversation(
                                type.toString(),
                                memberslist.toString(),
                                AppSession.getUser().chatUserId!!,
                                Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                                Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                                SettingsValues.getUniversalExpireTimer()
                            )
                        } else if (intent.hasExtra(Constants.KEYS.INTENT_NO_CONTACT)) {
                            mName = intent.getStringExtra(Constants.KEYS.INTENT_NO_CONTACT)
                            mContact!!.name = mName
                            mBinding!!.tvName.text = mName
                            if (intent.hasExtra(Constants.KEYS.INTENT_FILE_PATH)) mFile =
                                File(intent.getStringExtra(Constants.KEYS.INTENT_FILE_PATH)!!)
                            mIsContact = false
                            val members: MutableList<String?> = ArrayList()
                            members.add(AppSession.getUser().chatUserId)
                            members.add(mName)
                            val memberslist: MutableList<String> = ArrayList()
                            for (s in members) {
                                memberslist.add("\"" + s + "\"")
                            }
                            if (AppSession.getUser().blockUsers!!.contains(mName!!)) {
                                isBlocked = true
                            }
                            //                    CreateConversationRequest request = new CreateConversationRequest();
//                    request.setType(type);
//                    request.setDescription("one-to-one");
//                    request.setName("one-to-one");
//                    request.setUserChatId(AppSession.getUser().getChatUserId());
//                    request.setMembers(members);

                            //Creating conversation with no image upload
                            //Default Time 30 minutes
                            createNewConversation(
                                type.toString(),
                                memberslist.toString(),
                                AppSession.getUser().chatUserId!!,
                                Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                                Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                                SettingsValues.getUniversalExpireTimer()
                            )
                        }

                    } else if (type.equals(Constants.TYPES.CONVERSATION_GROUP, ignoreCase = true)) {
                        mBinding!!.btnAddContact.visibility = View.GONE
                        groupMembers = intent.getSerializableExtra("members") as List<Contact>?
                        groupName = intent.extras!!.getString("groupName")
                        val isFileSelected = intent!!.extras!!.getBoolean(INTENT_FILE_SELECTED)
                        if (intent.hasExtra(Constants.KEYS.INTENT_FILE_PATH)) mFile =
                            File(intent.getStringExtra(Constants.KEYS.INTENT_FILE_PATH)!!)
                        mBinding!!.tvName.text = groupName
                        mContact!!.name = groupName
                        mIsContact = false
                        Glide.with(this).load(Utills.getNameDrawable(groupName, AvatarColor.GROUP))
                            .into(mBinding!!.ivChatImage)
                        //need to change member to format ["member one","member two"]
                        val members: MutableList<String> = ArrayList()
                        members.add(AppSession.getUser().chatUserId!!)
                        if (groupMembers != null && !groupMembers!!.isEmpty()) {
                            for (contact in groupMembers!!) {
                                contact.chatUserId?.let { members.add(it) }
                            }
                        }
                        val memberslist: MutableList<String> = ArrayList()
                        for (s in members) {
                            memberslist.add("\"" + s + "\"")
                        }
                        mBinding!!.groupMembers.visibility = View.VISIBLE
                        setMembersName()
                        mBinding!!.btnAddContact.visibility = View.GONE
                        val request = CreateConversationRequest()
                        request.type = type
                        request.description = Constants.TYPES.CONVERSATION_GROUP
                        request.name = groupName
                        request.userChatId = AppSession.getUser().chatUserId
                        request.members = members

                        selected_time =
                            intent.getIntExtra(Constants.KEYS.INTENT_CONVERSATION_EXPIRY, 1800000)

                        if (isFileSelected) {                        //changing the API to flow of Upload file at creation
                            createNewConversation(
                                FileUpload.uploadCreateConversationMedia(
                                    type,
                                    memberslist.toString(),
                                    AppSession.getUser().chatUserId,
                                    Constants.TYPES.CONVERSATION_GROUP,
                                    groupName,
                                    SettingsValues.getUniversalExpireTimer()
                                )
                            )
                        } else {
                            //default disapearing time 30 minutes
                            createNewConversation(
                                type.toString(),
                                memberslist.toString(),
                                AppSession.getUser().chatUserId!!,
                                Constants.TYPES.CONVERSATION_GROUP,
                                groupName.toString(),
                                SettingsValues.getUniversalExpireTimer()
                            )

                        }
                    } else if (type.equals(
                            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                        )
                    ) {
                        mBinding!!.btnAddContact.visibility = View.GONE
                        groupMembers = intent.getSerializableExtra("members") as List<Contact>?
                        groupName = intent.extras!!.getString("groupName")
                        val isFileSelected = intent!!.extras!!.getBoolean(INTENT_FILE_SELECTED)
                        if (intent.hasExtra(Constants.KEYS.INTENT_FILE_PATH)) mFile =
                            File(intent.getStringExtra(Constants.KEYS.INTENT_FILE_PATH)!!)
                        mBinding!!.tvName.text = groupName
                        mContact!!.name = groupName
                        mIsContact = false
                        Glide.with(this).load(Utills.getNameDrawable(groupName, AvatarColor.GROUP))
                            .into(mBinding!!.ivChatImage)
                        //need to change member to format ["member one","member two"]
                        val members: MutableList<String> = ArrayList()
                        members.add(AppSession.getUser().chatUserId!!)
                        if (groupMembers != null && !groupMembers!!.isEmpty()) {
                            for (contact in groupMembers!!) {
                                contact.chatUserId?.let { members.add(it) }
                            }
                        }
                        val memberslist: MutableList<String> = ArrayList()
                        for (s in members) {
                            memberslist.add("\"" + s + "\"")
                        }
                        mBinding!!.groupMembers.visibility = View.VISIBLE
//                        setMembersName()
                        mBinding!!.btnAddContact.visibility = View.GONE

                        selected_time =
                            intent.getIntExtra(Constants.KEYS.INTENT_CONVERSATION_EXPIRY, 1800000)

                        if (isFileSelected) {                        //changing the API to flow of Upload file at creation
                            createAnonymousNewConversation(
                                FileUpload.uploadCreateConversationMedia(
                                    type,
                                    memberslist.toString(),
                                    AppSession.getUser().chatUserId,
                                    Constants.TYPES.CONVERSATION_GROUP,
                                    groupName,
                                    SettingsValues.getUniversalExpireTimer()
                                )
                            )
                        } else {
                            createAnonymousNewConversation(
                                type.toString(),
                                memberslist.toString(),
                                AppSession.getUser().chatUserId!!,
                                Constants.TYPES.CONVERSATION_GROUP,
                                groupName.toString(),
                                SettingsValues.getUniversalExpireTimer()
                            )

                        }
                    }
                }
                return
            }
            Log.d("Error", "getRoomData: The Get Intent is Null")
        }

    /**
     * Get the Read receipts keeping in mind the
     * General Read receipts and also read receipts of current conversation
     */
    private fun getReadReceipt(): Boolean {
        return SettingsValues.getMessageReadReceipts() && conversation?.conReadReceipts ?: false
    }

    /**
     * Update that user is in particular converastion and also update other conversation
     */
    private fun updateInConversation() {
        //Update that user is in particular converastion and also update other conversation
    }

    fun setMembersName() {
        mBinding?.let {

            mBinding!!.groupMembers.text = ""
            conversation?.let { con ->
                con.conversationMembers?.let { conMembers ->

                    when (con.conversationType) {
                        Constants.TYPES.CONVERSATION_ONE_TO_ONE, Constants.TYPES.CONVERSATION_GROUP -> {
                            handleGroupMember(conMembers)
                        }

                        else -> {
                            handleGroupMemberAnon(conMembers)
                        }
                    }


                }

            }

        }
    }

    private fun handleGroupMemberAnon(
        conMembers: MutableList<ConversationMember>
    ) {
        var me: ConversationMember? = null
        conMembers.forEach { member ->
            if (!member.moniker.equals(
                    senderId, ignoreCase = true
                )
            ) {
                val contact = contactsDao.getContact(member.moniker)
                if (mBinding!!.groupMembers.text.toString().isEmpty()) {
                    handlingGroupText(member, contact)
                } else {
                    handlingGroupTextOne(member, contact)
                }
            } else {
                me = member
            }
        }


        if (conMembers.size > 1 && conMembers.any {
                it.memberId.equals(
                    senderId, ignoreCase = true
                )
            }) mBinding!!.groupMembers.append(", " + "You")

    }

    private fun handlingGroupTextOne(member: ConversationMember, contact: Contact?) {
        if (contact != null) {
            mBinding!!.groupMembers.append(", " + contact.name)
        } else if (!conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS
            )
        ) {
            if (!member.chatNickName.isNullOrEmpty() && member.chatNickName!!.trim().isNotEmpty()) {
                mBinding!!.groupMembers.append(", " + member.chatNickName)
            } else {
                mBinding!!.groupMembers.append(", " + member.memberId)
            }
        } else {
            mBinding!!.groupMembers.append(", " + member.memberId)
        }

    }

    private fun handlingGroupText(member: ConversationMember, contact: Contact?) {
        if (contact != null) {
            mBinding!!.groupMembers.append(contact.name)
        } else if (!conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS
            )
        ) {
            if (!member.chatNickName.isNullOrEmpty() && member.chatNickName!!.trim().isNotEmpty()) {
                mBinding!!.groupMembers.append(member.chatNickName)
            } else {
                mBinding!!.groupMembers.append(member.moniker)
            }
        } else {
            mBinding!!.groupMembers.append(member.moniker)
        }
    }

    private fun handleGroupMember(
        conMembers: MutableList<ConversationMember>
    ) {
        var me: ConversationMember? = null
        conMembers.forEach { member ->
            if (!member.memberId.equals(
                    senderId, ignoreCase = true
                )
            ) {
                val contact = contactsDao.getContact(member.memberId)
                if (mBinding!!.groupMembers.text.toString().isEmpty()) {
                    handlingGroupTextSeconds(member, contact)
                } else {
                    handlingGroupTextThird(member, contact)
                }
            } else {
                me = member
            }
        }


        if (conMembers.size > 1 && conMembers.any {
                it.memberId.equals(
                    senderId, ignoreCase = true
                )
            }) mBinding!!.groupMembers.append(", " + "You")

    }

    private fun handlingGroupTextThird(member: ConversationMember, contact: Contact?) {
        if (contact != null) {
            mBinding!!.groupMembers.append(", " + contact.name)
        } else if (!conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS
            )
        ) {
            if (!member.chatNickName.isNullOrEmpty() && member.chatNickName!!.trim().isNotEmpty()) {
                mBinding!!.groupMembers.append(", " + member.chatNickName)
            } else {
                mBinding!!.groupMembers.append(", " + member.memberId)
            }
        } else {
            mBinding!!.groupMembers.append(", " + member.memberId)
        }
    }

    private fun handlingGroupTextSeconds(member: ConversationMember, contact: Contact?) {
        if (contact != null) {
            mBinding!!.groupMembers.append(contact.name)
        } else if (!conversation!!.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS
            )
        ) {
            if (!member.chatNickName.isNullOrEmpty() && member.chatNickName!!.trim().isNotEmpty()) {
                mBinding!!.groupMembers.append(member.chatNickName)
            } else {
                mBinding!!.groupMembers.append(member.memberId)
            }
        } else {
            mBinding!!.groupMembers.append(member.memberId)
        }
    }

    //************************************************************
    private fun setRoomData()
    //************************************************************
    {
        if (mRoom != null) {
//            mBinding!!.tvName.text = mRoom!!.chatName
            return
        }
        Log.d("Error", "setRoomData: The Room Object is Null")
    }

    //************************************************************
    private fun setToolBar(toolbar: Toolbar)
    //************************************************************
    {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    // ******************************************************************
    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    // ******************************************************************
    {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //************************************************************
    private fun showDeleteDialog()
    //************************************************************
    {
        val alertCustomdialog =
            LayoutInflater.from(this).inflate(R.layout.custom_delete_message, null)
        //initialize alert builder
        val deleteDialogBinding = CustomDeleteMessageBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(this)
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(deleteDialogBinding.root)
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //finally show the dialog box in android all
        mCreateDialog!!.show()
        deleteDialogBinding.btnDeleteForEveryone.visibility =
            if ((editingMessage!!.payload.userChatId.equals(
                    senderId, ignoreCase = true
                ) && !isBlocked && !editingMessage!!.payload.isDeleted && !editingMessage!!.payload.isConfidential && !editingMessage!!.payload.isViewOnce)
            ) View.VISIBLE else View.GONE
        deleteDialogBinding.btnDeleteForMe.setOnClickListener {
            if (adapter!!.mediaPlayer != null && adapter!!.mediaPlayer.isPlaying) {
                adapter!!.mediaPlayer.stop()
            }
            deleteMessage("me")
            mCreateDialog!!.dismiss()
        }
        deleteDialogBinding.btnDeleteForEveryone.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }
            if (adapter!!.mediaPlayer != null && adapter!!.mediaPlayer.isPlaying) {
                adapter!!.mediaPlayer.stop()
            }
            deleteMessage("everyone")
            mCreateDialog!!.dismiss()
        }
        deleteDialogBinding.btnCancel.setOnClickListener { mCreateDialog!!.dismiss() }
    }

    /**
     * Show a custom dialog based on the given integer parameter.
     *
     * @param i the integer that determines which dialog to show
     */
    private fun showCustomDialog(i: Int) {
        val alertCustomDialog =
            LayoutInflater.from(this).inflate(R.layout.custom_block_dailog, null)
        val dialogBinding = CustomBlockDailogBinding.bind(alertCustomDialog)

        // Create an alert dialog builder
        val alertDialogBuilder = AlertDialog.Builder(this)

        // Set our custom alert dialog to the alertDialogBuilder
        alertDialogBuilder.setView(dialogBinding.root)

        // Create the dialog
        val dialog = alertDialogBuilder.create()

        // Remove app bar from dialog and make it transparent
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Set the dialog's text and button based on the integer parameter
        when (i) {
            0 -> {
                dialogBinding.tvTitle.text =
                    String.format(AndroidUtil.getString(R.string.delete_contact), mContact!!.name)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.delete_alert)
                dialogBinding.btnBlock.text = DELETE
            }

            1 -> {
                dialogBinding.tvTitle.text = String.format(
                    AndroidUtil.getString(R.string.block_alert_dialog),
                    AndroidUtil.getString(R.string.blocked_user)
                )
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.block_alert)
                dialogBinding.btnBlock.text = BLOCK
            }

            2 -> {
                dialogBinding.tvTitle.text = String.format(
                    AndroidUtil.getString(R.string.block_alert_dialog),
                    AndroidUtil.getString(R.string.unblock_user)
                )
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.unblock_alert)
                dialogBinding.btnBlock.text = UNBLOCK
            }

            4 -> {
                dialogBinding.tvTitle.text = String.format(
                    AndroidUtil.getString(R.string.conversation_clear),
                    conversation!!.name
                )
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.clear_alert)
                dialogBinding.btnBlock.text = CLEAR
            }

            5 -> {
                handleLeaveGroup(dialogBinding)
            }

            6 -> {
                dialogBinding.tvTitle.text = String.format(
                    AndroidUtil.getString(R.string.delete_alert_dialog),
                    conversation!!.name
                )
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.delete_group_alert)
                dialogBinding.btnBlock.text = DELETE_GROUP
            }
        }

        // Show the dialog
        dialog.show()

        // Set the click listener for the dialog button
        dialogBinding.btnBlock.setOnClickListener {
            when (i) {
                1 -> {
                    dialog.dismiss()
                    handleBlockDialog()
                }

                2 -> {
                    dialog.dismiss()
                    handleUnBlockDialog()
                }

                4 -> {
                    dialog.dismiss()
                    clearConversationChat()
                }

                5 -> {
                    if (!Utills.isSubscriptionExpired()) {
                        if (conversation != null && conversation!!.owner.equals(
                                senderId,
                                ignoreCase = true
                            )
                        ) {
                            leaveGroup(0)
                        } else {
                            leaveGroup(1)
                        }
                    } else {
                        Utills.showSubscriptionEnd()
                    }
                }

                6 -> {
                    clearConversationChat()
                    conversationsDao.delete(conversation)
                    finish()
                }
            }
        }

        // Set the click listener for the cancel button
        dialogBinding.btnCancel.setOnClickListener { dialog.dismiss() }
    }


    private fun handleUnBlockDialog() {
        if (!Utills.isSubscriptionExpired()) {
            unblock()
        } else {
            Utills.showSubscriptionEnd()
        }
    }

    private fun handleBlockDialog() {
        if (!Utills.isSubscriptionExpired()) {
            blockUser();
        } else {
            Utills.showSubscriptionEnd()
        }
    }

    private fun handleLeaveGroup(dialogBinding: CustomBlockDailogBinding) {
        if (conversation != null && conversation!!.owner.equals(
                senderId, ignoreCase = true
            )
        ) {
            dialogBinding.tvTitle.text = String.format("Leave %s ?", conversation!!.name)
            dialogBinding.tvDeleteNotification.text =
                AndroidUtil.getString(R.string.owner_change_alert)
            dialogBinding.btnBlock.text = CHANGE_OWNER
        } else {
            dialogBinding.tvTitle.text = String.format("Leave  %s ?", conversation!!.name)
            dialogBinding.tvDeleteNotification.text =
                AndroidUtil.getString(R.string.leave_group_alert)
            dialogBinding.btnBlock.text = LEAVE_GROUP
        }
    }

    /**
     * Unblocks the user by calling the API to unblock the user and logs the request details.
     */
    private fun unblock() {
        // Find the ID of the member to unblock
        val unblockId =
            conversation?.conversationMembers?.find { it.memberId != AppSession.getUser().chatUserId }?.memberId

        // Call the API to unblock the user
        ApiHelper.with()?.unBlockUser(unblockId, this, this@ChatActivity)

        // Log the details of the unblock request
        Log.d(
            BaseActivity.TAG,
            "${Constants.CONTACTS_DETAILS_ACTIVITY}${Constants.END_POINT}${RequestCodes.API_END_POINTS.UNBLOCK_USER} Request: chatUserId=${AppSession.getUser().chatUserId} blockId=${mContact?.chatUserId ?: ""}"
        )
    }


    /**
     * Block the current user from the chat with the other user in the conversation
     */
    private fun blockUser() {
        // Find the chatUserId of the other user in the conversation
        val blockId = conversation?.conversationMembers
            ?.firstOrNull { member -> member.memberId != AppSession.getUser().chatUserId }
            ?.memberId

        // Call the blockUser API to block the user
        ApiHelper.with()?.blockUser(blockId, this, this@ChatActivity)

        // Log the block user API request
        Log.d(
            BaseActivity.TAG,
            "${Constants.CONTACTS_DETAILS_ACTIVITY}${Constants.END_POINT}${RequestCodes.API_END_POINTS.BLOCK_USER} Request: chatUserid=${AppSession.getUser().chatUserId} block id=$blockId"
        )
    }


    private fun checkContactNull(memberID: String?): Contact? {
        return if (memberID != null) contactsDao.getContact(memberID) else null
    }


    /**
     * Delete the currently editing message from the chat screen.
     *
     * @param deletionType The type of deletion - "me" for deleting only the current user's message,
     * or "everyone" for deleting the message for everyone in the conversation.
     */
    private fun deleteMessage(deletionType: String) {
        editingMessage?.let { message ->
            try {
                when (deletionType) {
                    "me" -> {
                        message.payload.type = "text"
                        messagesDao.delete(message.payload)
                        adapter?.delete(message)
                        deleteMessageFile(message.payload)
                        resetAllModes()
                    }

                    "everyone" -> {
                        val payload = message.payload
                        deleteMessageFile(payload)
                        payload.filePath = null
                        payload.data = "This message was deleted."
                        payload.type = "delete"
                        if (Utills.isNetworkAvailable()) {
                            EncryptionUtils.sendDeletePayload(payload)
                        } else {
                            val offlineMessage = OfflineMessage().apply {
                                data = payload.data
                                userChatId = payload.userChatId
                                conversationId = payload.conversationId
                                type = payload.type
                                messageId = payload.messageId
                                senderId = payload.senderId
                                createdAt = payload.createdAt
                                conversationType = payload.conversationType
                            }
                            offlineMessagesDao.insert(offlineMessage)
                        }
                        messagesDao.updateMessage(payload)
                        resetAllModes()
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error deleting file in ChatActivity", e)
            }
        }
    }

    /**
     * Deletes the file associated with the given message payload.
     *
     * @param payload The message payload containing the file path to delete.
     */
    private fun deleteMessageFile(payload: Payload) {
        payload.filePath?.let { filePath ->
            val file = File(filePath)
            if (file.exists()) {
                try {
                    if (file.delete()) {
                        Log.e(TAG, "File deleted successfully: $filePath")
                    } else {
                        Log.e(TAG, "Failed to delete file: $filePath")
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Error deleting file: $filePath", e)
                }
            }
        }
    }

    //************************************************************
    private fun leaveGroup(i: Int)
    //************************************************************
    {
        when (i) {
            0 -> startActivity(
                Intent(this, MembersActivity::class.java).putExtra("conversation", conversation)
                    .putExtra("fromChangeOwner", "fromChangeOwner")
            )

            1 -> {
                val request = LeaveGroupRequest()
                request.user_chat_id = AppSession.getUser().chatUserId
                ApiHelper.with()
                    ?.leaveGroup(conversation!!.conversationId, request, this, this@ChatActivity)
            }
        }
    }

    /**
     * Resets all the modes of the chat UI such as edit, delete, etc. and updates the adapter accordingly.
     */
    private fun resetAllModes() {
        if (editingMessage != null && mBinding != null) {
            // Hide edit, delete, and copy buttons
            mBinding!!.ivDelete.visibility = View.GONE
            mBinding!!.ivEdit.visibility = View.GONE
            mBinding!!.ivCopy.visibility = View.GONE

            // Reset mode flags
            isEditMode = false
            isDeleteMode = false

            // Update adapter with the edited message
            adapter!!.update(editingMessage)

            // Clear editing message
            editingMessage = null

            // Fade in emoji button
            ViewUtil.fadeIn(mBinding!!.ivEmoji, 300)

            // Fade out send button
            ViewUtil.fadeOut(mBinding!!.fabSendMessage, 300)
        }
    }


    override fun onLoadMore(page: Int, totalItemsCount: Int) {
        Log.i("TAG", "onLoadMore: $page $totalItemsCount")
    }

    /**
     * Loads messages for the current conversation.
     */
    fun loadMessages() {
        conversation?.let { conversation ->
            var isOneToOne = false
            var isContact = false
            if (conversation.conversationType.equals(
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                )
            ) {
                isOneToOne = true
                var receiverId: String? = null
                val member = conversation.conversationMembers?.find { members ->
                    !members.memberId.equals(AppSession.getUser().chatUserId)
                }
                receiverId = member?.memberId

                checkContactNull(receiverId)?.let {
                    isContact = true
                }
            }

            // Limitation of internet connection
            Handler(Looper.getMainLooper()).postDelayed({
                val messages: MutableList<Messages?> = ArrayList()
                val payloads = messagesDao.getMessages(conversation.conversationId)
                if (!payloads.isNullOrEmpty()) {
                    var isOneToOne = false
                    var isContact = false
                    if (conversation.conversationType.equals(
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                        )
                    ) {
                        isOneToOne = true
                        var receiverId: String? = null
                        val member = conversation.conversationMembers?.find { members ->
                            !members.memberId.equals(AppSession.getUser().chatUserId)
                        }
                        receiverId = member?.memberId

                        checkContactNull(receiverId)?.let {
                            isContact = true
                        }
                    }
                    payloads.forEach { payload ->
                        val message = Messages()
                        message.payload = payload
                        val user = User()
                        user.chatUserId = payload.userChatId
                        user.profileImage = null
                        user.chatNickName = ""
                        message.user = user
                        message.createdAt = DateTime.stringToDate()
                        messages.add(message)
                    }

                    if (messages.isNotEmpty()) {
                        messages.reverse()
                        lastLoadedDate = messages.last()!!.createdAt
                    }
                    // Removing last message of the conversation
                    clearChat()
                    adapter?.addToEnd(messages, false)
                    handleReadAcks(payloads, isOneToOne, isContact)
                }
            }, 500)
        }
    }


    /**
     * Handles read acks for the given payloads. Updates the message status to SEEN and schedules message expiry
     * for the delivered messages that are not sent by the current user.
     *
     * @param payloads The list of payloads for which read acks need to be handled.
     * @param isOneToOne A boolean flag indicating if the conversation is one-to-one.
     * @param isContact A boolean flag indicating if the conversation is with a contact.
     */
    private fun handleReadAcks(
        payloads: MutableList<Payload>,
        isOneToOne: Boolean,
        isContact: Boolean
    ) {
        conversation?.let{// Loop through each payload in the list of payloads.
            payloads.forEach { payload ->

                // If the conversation is not anonymous group, handle read acks for delivered messages that are not sent by the current user.
                if (!conversation!!.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                        ignoreCase = true
                    )
                ) {
                    // Check if the payload has status DELIVERED and was not sent by the current user.
                    payload.status?.let {
                        if (payload.status.equals(
                                Constants.DELIVERED,
                                ignoreCase = true
                            ) && !payload.userChatId.equals(
                                AppSession.getUser().chatUserId,
                                ignoreCase = true
                            )
                        ) {

                            // Schedule message expiry for the delivered message and create a new payload for sending read ack.
                            scheduleExpiry(payload)
                            val payload1 = Payload().apply {
                                type = "ack_read"
                                conversationId = payload.conversationId
                                conversationType = payload.conversationType
                                messageId = payload.messageId
                                createdAt = payload.createdAt
                                senderId = payload.senderId
                                ack_id = Utills.getRandomString(5)
                                userChatId = this@ChatActivity.senderId
                            }
                            // Send the read ack to the server and update the message status to SEEN in the local database.
                            sendOfflineAckTwo(isOneToOne, isContact, payload1, payload)
                            messagesDao.updateMessage(Constants.SEEN, payload1.messageId)
                        }
                    }
                } else {

                    // If the conversation is anonymous group, handle read acks for delivered messages that are not sent by the current user.
                    payload.status?.let { status ->
                        if (status.equals(
                                Constants.DELIVERED,
                                ignoreCase = true
                            ) && !payload.userChatId.equals(
                                senderId,
                                ignoreCase = true
                            )
                        ) {

                            // Schedule message expiry for the delivered message and create a new payload for sending read ack.
                            scheduleExpiry(payload)
                            val payload1 = Payload().apply {
                                type = "ack_read"
                                conversationId = payload.conversationId
                                conversationType = payload.conversationType
                                messageId = payload.messageId
                                createdAt = payload.createdAt
                                senderId = payload.senderId
                                ack_id = Utills.getRandomString(5)
                                userChatId = this@ChatActivity.senderId
                            }
                            // Send the read ack to the server and update the message status to SEEN in the local database.
                            sendOfflineAck(isOneToOne, isContact, payload1, payload)
                            messagesDao.updateMessage(Constants.SEEN, payload1.messageId)
                        }
                    }
                }
            }
        }
    }


    /**
     * Sends an offline acknowledgement for the given payload if necessary.
     *
     * @param isOneToOne Whether the conversation is one-to-one.
     * @param isContact Whether the conversation is with a contact.
     * @param payload1 The payload to send as an acknowledgement.
     * @param payload The original payload that was sent.
     */
    private fun sendOfflineAckTwo(
        isOneToOne: Boolean,
        isContact: Boolean,
        payload1: Payload?,
        payload: Payload
    ) {
        // Check if the sent message should be acknowledged
        if (EncryptionUtils.checkSentMessage(conversation!!)) {
            // Check if read receipts are enabled and the payload requires read receipts
            if (!isOneToOne && SettingsValues.getMessageReadReceipts() && payload.readReceipts) {
                EncryptionUtils.sendOfflineAcks(payload1!!)
            } else if (SettingsValues.getMessageReadReceipts() && payload.readReceipts && (SettingsValues.getMessageReadReceiptsUnknown() || isContact)) {
                // Check if read receipts for unknown contacts are enabled or if the conversation is with a contact
                EncryptionUtils.sendOfflineAcks(payload1!!)
            }
        }
    }

    /**
     * Sends an offline acknowledgement for the given payload if necessary.
     *
     * @param isOneToOne Whether the conversation is one-to-one.
     * @param isContact Whether the conversation is with a contact.
     * @param payload1 The payload to send as an acknowledgement.
     * @param payload The original payload that was sent.
     */
    private fun sendOfflineAck(
        isOneToOne: Boolean,
        isContact: Boolean,
        payload1: Payload?,
        payload: Payload
    ) {
        // Check if the sent message should be acknowledged
        if (EncryptionUtils.checkSentMessage(conversation!!)) {
            // Check if read receipts are enabled and the payload requires read receipts
            if (!isOneToOne && SettingsValues.getMessageReadReceipts() && payload.readReceipts) {
                EncryptionUtils.sendOfflineAcks(payload1!!)
            } else if (SettingsValues.getMessageReadReceiptsUnknown() || isContact) {
                // Check if read receipts for unknown contacts are enabled or if the conversation is with a contact
                EncryptionUtils.sendOfflineAcks(payload1!!)
            }
        }
    }


    /**
     * Schedules the expiry of the given payload if necessary.
     *
     * @param payload1 The payload to schedule for expiry.
     */
    private fun scheduleExpiry(payload1: Payload) {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.e(EncryptionUtils.TAG, "CoroutineExceptionHandler got $exception")
        }
        CoroutineScope(Dispatchers.IO).launch(handler) {
            // Check if the payload should expire
            if (payload1.isExpire) {
                // Check if the payload's expiry has not started
                if (payload1.expireStarted == -1L) {
                    // Set the payload's expiry start time
                    payload1.expireStarted = System.currentTimeMillis()
                    messagesDao.updateExpireInTime(payload1.messageId, payload1.expireStarted)
                }
                val expirationManager = ApplicationDependencies.getExpiringMessageManager()
                // Schedule the payload for deletion
                expirationManager.scheduleDeletion(payload1)
            }
        }
    }

    override fun onBackPressed() {

        if (reactionDelegate.isShowing) {
            reactionDelegate.hide()
            adapter!!.unselectAllItems()
            if (editingMessage != null) {
                resetAllModes()
                return
            }

        } else {
            super.onBackPressed()
//            supportFinishAfterTransition()
            overridePendingTransition(0, R.anim.slide_fade_to_bottom)

        }


    }


    override fun onClick(dialogInterface: DialogInterface, i: Int) {
        //not being used by the interface but is essential to be overridden

    }

    override fun onAddAttachments() {
        if (!Utills.isSubscriptionExpired()) {
            mPopup.toggle()
        } else {
            Utills.showSubscriptionEnd()
        }
    }

    /**
     * This method will be responsible for sending the File type according to its extension
     *
     * @param requestCode this is the code which is requested on start of activity intent gallery
     * @param resultCode  this is the result code which is gotten in the response of activity start
     * @param data        this is the data which is gotten after activity intent we will evaluate only URI
     */
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.let {
            if (!isBlocked) {
                if (resultCode == RESULT_OK && requestCode == RequestCodes.PICKFILE_RESULT_CODE) {
                    if (data.data != null) {
                        val extension = AndroidUtil.getMimeType(this, data.data)

                        val uri = data.data
                        val mediaSizeInBytes = MediaUtil.getMediaSize(MainApp.appContext, uri)
                        val mediaSizeInMB = ByteUnit.BYTES.toMegabytes(mediaSizeInBytes)
                        if (mediaSizeInMB <= 20) {

                            @SuppressLint("Range") var path:  //            String filename = c.getString(c.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                            //            Messages messages=new Messages()
                                    String? = ""
                            when (extension) {
                                "png", "jpg", "jpeg" -> {
                                    path = PathUtil.getPath(this, uri, Build.VERSION.SDK_INT, true)
                                    filePath = path
                                    file = File(path!!)
                                    if (file!!.exists()) {
                                        mediaType = "image"
//                                        uploadFile()
                                    }

                                    startActivityForResult(
                                        Intent(
                                            this@ChatActivity, MediaSelectionActivity::class.java
                                        ).putExtra(Constants.KEYS.INTENT_MEDIA_URI, uri).putExtra(
                                            Constants.KEYS.INTENT_MEDIA_PATH, filePath
                                        ).putExtra(
                                            Constants.KEYS.INTENT_CONVERSATION, conversation
                                        ), RequestCodes.MEDIA_EDIT_SHOW
                                    )
                                }

                                "mp3" -> {
                                    path = PathUtil.getPath(this, uri, Build.VERSION.SDK_INT, true)
                                    filePath = path
                                    file = File(path)
                                    if (file!!.exists()) {

                                        Log.e(TAG, "File existed")
                                        mediaType = "audio"
                                        loader = Loading.make(this).setMessage("Compressing...")
                                            .setCancelable(false)
                                        loader?.show()
                                        val outputPathCompress = File(
                                            MainApp.appContext!!.filesDir.path + "/" + "OutputFileCompress" + "." + AndroidUtil.getMimeType(
                                                MainApp.appContext, uri
                                            )
                                        )
                                        val pathToRemoveTag =
                                            MainApp.appContext!!.filesDir.path + "/" + "OutputRemovingTagFile" + "." + "mp3"

                                        val fileToRemoveTag = File(pathToRemoveTag)
                                        if (fileToRemoveTag.exists()) {
                                            fileToRemoveTag.delete()
                                        }
                                        try {
                                            val mp3file = Mp3File(file?.absolutePath)
                                            if (mp3file.hasId3v1Tag()) {
                                                mp3file.removeId3v1Tag()
                                            }
                                            if (mp3file.hasId3v2Tag()) {
                                                mp3file.removeId3v2Tag()
                                            }
                                            if (mp3file.hasCustomTag()) {
                                                mp3file.removeCustomTag()
                                            }
                                            mp3file.save(pathToRemoveTag)

                                        } catch (e: IOException) {
                                            e.printStackTrace()
                                        } catch (e: UnsupportedTagException) {
                                            e.printStackTrace()
                                        } catch (e: InvalidDataException) {
                                            e.printStackTrace()
                                        } catch (e: NotSupportedException) {
                                            e.printStackTrace()
                                        }

                                        if (outputPathCompress.exists()) {
                                            outputPathCompress.delete()
                                        }


                                        val ffmpegCallback =
                                            object : FFmpegOperations.FFmpegOperationsCallback {
                                                override fun onSuccessCompress() {
                                                    filePath = outputPathCompress.path
                                                    file = outputPathCompress
                                                    uploadFile()
                                                }
                                            }

                                        FFmpegOperations.compressAudio(
                                            inputPath = pathToRemoveTag,
                                            outputPath = outputPathCompress.toString(),
                                            callback = ffmpegCallback
                                        )

                                    }
                                }

                                "mp4" -> {
//                                    path = FilePath.getPath(this, uri)
                                    path = PathUtil.getPath(this, uri, Build.VERSION.SDK_INT, true)
                                    filePath = path
                                    file = File(path!!)
                                    if (file!!.exists()) {
                                        mediaType = "video"
                                        startActivityForResult(
                                            Intent(
                                                this@ChatActivity,
                                                MediaSelectionActivity::class.java
                                            ).putExtra(Constants.KEYS.INTENT_MEDIA_URI, uri)
                                                .putExtra(
                                                    Constants.KEYS.INTENT_MEDIA_PATH, filePath
                                                ).putExtra(
                                                    Constants.KEYS.INTENT_CONVERSATION, conversation
                                                ), RequestCodes.MEDIA_EDIT_SHOW
                                        )
//                            uploadFile()
                                    }
                                }

                                "pdf" -> {
                                    val c = this.contentResolver.query(
                                        data.data!!, null, null, null, null
                                    )
                                    c?.moveToFirst()
                                    @SuppressLint("Range") val filename =
                                        c!!.getString(c.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                                    path = FileWriter.getFilePathFromURI(this, uri, filename)
                                    filePath = path
                                    file = File(path)
                                    if (file!!.exists()) {
                                        mediaType = "file"
                                        uploadFile()
                                    }
                                }
                            }
                        } else {
                            Notify.Toast("File Size can only be max 20 mb ")
                        }
                    }
                } else if (resultCode == RequestCodes.MEDIA_EDIT_SHOW && requestCode == RequestCodes.MEDIA_EDIT_SHOW) {
                    Log.e(TAG, "${data?.extras}")
                    val json = data?.getStringExtra(Constants.KEYS.INTENT_FILE_PATH)
                    val mediaData =
                        gson.fromJson(json, MediaSelectionActivity.MediaData::class.java)
                    viewOnce = mediaData!!.intent_view_once_chat ?: false
                    val path = mediaData!!.filePath
                    if (path != null) {
                        filePath = path
                        file = File(path)
                        if (file!!.exists()) {
                            if (!file!!.extension.isNullOrEmpty()) {
                                when (file!!.extension) {
                                    "mp4" -> mediaType = "video"
                                    "jpg", "jpeg" -> mediaType = "image"
                                }
                            }
                            uploadFile()
                        }
                    }


                }

            } else {
                showBlockUserDialog()
            }
        }
    }

    fun CreateMainSymmeticHandshake(
        conversation_id: String, sentMessage: CharSequence?, messagePayload: Payload?
    ) {
        //this method was being used for SIR
    }


    override fun onSubmit(input: CharSequence): Boolean {
        if (input.isNotEmpty()) {
            if (!isBlocked && !Utills.isSubscriptionExpired()) {
                if (isEditMode) {
                    handleEditPayload(input)
                } else {
                    handleNormalPayload(input)
                }
            } else if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
            } else {
                showBlockUserDialog()
            }
        }
        if (!Utills.isSubscriptionExpired()) {
            handleVoiceNoteViews()
        }
        return true
    }

    private fun handleVoiceNoteViews() {
        mBinding?.input?.button?.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_audio_chat))
//                mBinding!!.input?.button?.rotation = 0F
        canSendAudio = true;
        mBinding?.input?.button?.isEnabled = true
        mBinding?.recorderView?.setTouchView(mBinding?.input?.button!!)
    }

    private fun handleNormalPayload(input: CharSequence) {
        //If the user is in normal mode to send message
        val payload = Payload()
        payload.data = input.toString()
        payload.userChatId = senderId
        payload.senderId = senderId

        payload.conversationId = conversation!!.conversationId
        //            Notify.Toast("Type in On submit"+ type);
        Log.d("TAG", "onSubmit: $type")
        payload.type = "text"
        payload.messageId = Utills.getRandomString(15)
        payload.createdAt = DateTime.getCurrentDateTime()
        payload.received_at = payload.createdAt
        payload.isExpire = conversation != null && conversation!!.conversationExpiryTime >= 0
        payload.isViewOnce = conversation != null && conversation!!.conversationExpiryTime == 0L

        payload.isCanShareForward = conversation!!.isCanShareForward

        payload.msgExpiryTime = conversation!!.conversationExpiryTime
        Log.d("TAG", "mesagetime: " + payload.createdAt + " " + payload.data)
        payload.conversationType = type
        payload.isConfidential = conversation?.isConfidential!!
        payload.readReceipts = getReadReceipt()
        if (Utills.isNetworkAvailable() && isSocketConnected.value != null && isSocketConnected.value!!) {
            Log.e(TAG, "Message Id: ${payload.messageId}")
            EncryptionUtils.encryptMessage(input, payload, this)
        } else {
            val offlineMessage = OfflineMessage()
            EncryptionUtils.offlineMessageConcept(input, payload, offlineMessage, this)
        }
        payload.data = input.toString()
        messagesDao.insert(payload)
        conversation!!.lastMessage = payload
        conversation!!.sequenceOfConversation = System.currentTimeMillis()
        conversationsDao.update(conversation)
        val messages = Messages()
        messages.user = AppSession.getUser()
        messages.user.chatUserId = payload.userChatId
        messages.payload = payload
        messages.createdAt = Date()
        adapter!!.addToStart(messages, true)

        if (mPopup.isShowing) {
            isToggle = false
            MessageInputChat.getInstance().attachmentButton.setImageDrawable(
                AndroidUtil.getDrawable(
                    R.drawable.ic_emoji
                )
            )
            mPopup.dismiss()
        }
    }

    private fun handleEditPayload(input: CharSequence) {
        val payload = editingMessage!!.payload
        payload.filePath = null
        payload.data = input.toString()
        payload.type = "edit"
        payload.isEdited = true
        payload.isExpire = conversation != null && conversation!!.conversationExpiryTime >= 0
        payload.isViewOnce = conversation != null && conversation!!.conversationExpiryTime == 0L
        payload.msgExpiryTime = if (payload.isExpire) {
            conversation!!.conversationExpiryTime
        } else {
            -1
        }
        payload.isConfidential = editingMessage?.payload!!.isConfidential
        payload.readReceipts = editingMessage!!.payload!!.readReceipts
        handleSendPayload(input, payload)
        payload.data = input.toString()
        payload.status = editingMessage!!.payload.status
        messagesDao.insert(payload)
        isEditMode = false
        mBinding!!.ivEdit.visibility = View.GONE
        resetAllModes()
    }

    private fun handleSendPayload(input: CharSequence, payload: Payload) {
        if (Utills.isNetworkAvailable() && isSocketConnected.value != null && isSocketConnected.value!!) {
            EncryptionUtils.encryptMessage(input, payload, this)
        } else {
            val offlineMessage = OfflineMessage()
            EncryptionUtils.offlineMessageConcept(input, payload, offlineMessage, this)
        }
    }

    private fun showBlockUserDialog() {
        // Inflate the layout using View Binding
        val dialogBinding = CustomDailogBlockBinding.inflate(layoutInflater)

        // Create an AlertDialog using the AlertDialog Builder
        val alert = AlertDialog.Builder(this)
            .setView(dialogBinding.root) // Set the custom dialog layout to the AlertDialog
            .create()

        // Set the text in the TextView to display the name of the contact being blocked
        dialogBinding.tvViewBlock.text = getString(R.string.blocked_user_message, mContact!!.name)

        // Set the OnClickListener for the OK button to dismiss the dialog when it is clicked
        dialogBinding.btnOk.setOnClickListener {
            alert.dismiss()
        }

        // Show the AlertDialog
        alert.show()
    }


    override fun hasContentFor(message: Messages, type: Byte): Boolean {

        val stopwatch = Stopwatch("Has Content for")
        stopwatch.split("checking")

        stopwatch.split("returned from checked")
        stopwatch.stop(Stopwatch.TAG)
        return false
    }

    //    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_delete:
//                messagesAdapter.deleteSelectedMessages();
//                break;
//            case R.id.action_copy:
//                messagesAdapter.copySelectedMessagesText(this, getMessageStringFormatter(), true);
//                AppUtils.showToast(this, R.string.copied_message, true);
//                break;
//        }
//        return true;

    fun initAdapter() {
        val holders = ChatMessageHolders().setIncomingTextConfig(
            IncomingTextMessageViewHolder::class.java, R.layout.item_message_receive_new
        ).setOutcomingTextConfig(
            OutgoingTextMessageViewHolder::class.java, R.layout.item_message_sent_new
        )
        mBinding!!.messagesList.setItemViewCacheSize(100)
        mBinding?.messagesList?.recycledViewPool?.setMaxRecycledViews(0, 100)
        if (conversation != null && conversation!!.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS)) {
            if (conversation!!.myMoniker != null) {
                senderId = conversation!!.myMoniker
            }
        } else {
            senderId = AppSession.getUser().chatUserId
//            senderId = "0"
        }
        adapter = MessageAdapter(this, senderId, holders, imageLoader)
        adapter!!.setLoadMoreListener(this)
        mBinding!!.input.inputEditText.isFocusableInTouchMode = true
        adapter!!.setOnMessageViewClickListener(this)
        mBinding!!.messagesList.setAdapter(adapter)
    }

    fun deleteById(id: String) {
        if (mBinding != null) {
            adapter?.apply {
                deleteById(id)
            }
        }
    }

    fun createNewConversation(map: Map<String?, RequestBody?>) {
        Log.d(
            TAG,
            "ChatActivity createNewConversation: " + Constants.END_POINT + RequestCodes.API_END_POINTS.CREATE_NEW_CONVERSATION + Constants.REQUEST + map.toString()
        )


        ApiHelper.with()?.createNewConversation(map, mFile, this, this@ChatActivity)
    }


    fun createNewConversation(
        type: String,
        member: String,
        userChatId: String,
        description: String,
        name: String,
        selectedTime: Long
    ) {


        ApiHelper.with()?.createNewConversation(
            type, member, userChatId, description, name, selectedTime, this, this@ChatActivity
        )
    }

    fun createAnonymousNewConversation(map: Map<String?, RequestBody?>) {
        Log.d(
            TAG,
            "ChatActivity createAnonymousNewConversation: " + Constants.END_POINT + RequestCodes.API_END_POINTS.CREATE_NEW_CONVERSATION + Constants.REQUEST + map.toString()
        )


        ApiHelper.with()?.createAnonymousNewConversation(map, mFile, this, this@ChatActivity)
    }


    fun createAnonymousNewConversation(
        type: String,
        member: String,
        userChatId: String,
        description: String,
        name: String,
        selectedTime: Long
    ) {

        ApiHelper.with()?.createAnonymousNewConversation(
            type, member, userChatId, description, name, selectedTime, this, this@ChatActivity
        )
        Log.e(TAG, "sender Id: $senderId")
    }

    var uploadingSecreteFingerprint: ByteArray? = null
    var avRatchetKeyMaterial: String? = null

    //    var ivParameterByte: ByteArray? = null
    @RequiresApi(Build.VERSION_CODES.O)
    private fun uploadFile() {
        if (loader != null && loader?.isVisible!!) {
            loader?.cancel()
        }
        if (Utills.isNetworkAvailable()) {
            isFromForwardUpload = false
            val memberslist: MutableList<String> = ArrayList()
            for (conversationMember in conversation!!.conversationMembers!!) {
                memberslist.add("\"" + conversationMember.memberId + "\"" + ":" + "\"" + conversationMember.signatureKey + "\"")
            }
            var members = memberslist.toString()
            members = members.replace("[", "{")
            members = members.replace("]", "}")
            Log.d(
                TAG,
                "ChatActivity uploadFile: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPLOAD_MEDIA + Constants.REQUEST + "conversation_id= " + conversation!!.conversationId + " members= " + members + "media=" + file.toString()
            )


            val keyPairGenerator = KeyPairGenerator()
            avRatchetKeyMaterial = keyPairGenerator.getAVSecretKey()

            val fileToWrite = "${getExternalFilesDir("chatApp")!!.absolutePath}/temp/${
                FilePath.generateOutputFileNames(
                    file!!.extension, System.currentTimeMillis()
                )
            }"
            val fileDir = File("${getExternalFilesDir("chatApp")!!.absolutePath}/temp")
            if (!fileDir.exists()) {
                fileDir.mkdir()
                fileDir.mkdirs()
            }
            val time = measureTimeMillis {
                EncryptionUtils.encryptFile(
                    file!!.path, fileToWrite, avRatchetKeyMaterial
                )
            }
            Log.e("Time", "Time after Encryption File $time")

            val encryptedFileToUpload = File(fileToWrite)

            val mediaSizeInBytes = MediaUtil.getMediaSize(
                MainApp.appContext, Uri.fromFile(File(encryptedFileToUpload.path))
            )
            val mediaSizeInMB = ByteUnit.BYTES.toMegabytes(mediaSizeInBytes)
            Log.e(TAG, "mediaSizeInMB sending $mediaSizeInMB")

            if (encryptedFileToUpload.exists()) {
                ApiHelper.with()?.uploadMediaInConversation(
                    conversation!!.conversationId,
                    members,
                    encryptedFileToUpload,
                    this,
                    this@ChatActivity
                )
            } else {
                Log.e(TAG, "File was not created ")
            }
        } else {
            Notify.Toast("Internet not Available")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun uploadForwardFile() {
        if (Utills.isNetworkAvailable()) {
            isFromForwardUpload = true
            val memberslist: MutableList<String> = ArrayList()
            for (conversationMember in conversation!!.conversationMembers!!) {
                memberslist.add("\"" + conversationMember.memberId + "\"" + ":" + "\"" + conversationMember.signatureKey + "\"")
            }
            var members = memberslist.toString()
            members = members.replace("[", "{")
            members = members.replace("]", "}")
            Log.d(
                TAG,
                "ChatActivity uploadFile: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPLOAD_MEDIA + Constants.REQUEST + "conversation_id= " + conversation!!.conversationId + " members= " + members + "media=" + file.toString()
            )


            val keyPairGenerator = KeyPairGenerator()
            avRatchetKeyMaterial = keyPairGenerator.getAVSecretKey()

            val fileToWrite = "${getExternalFilesDir("chatApp")!!.absolutePath}/temp/${
                FilePath.generateOutputFileNames(
                    file!!.extension, System.currentTimeMillis()
                )
            }"
            val fileDir = File("${getExternalFilesDir("chatApp")!!.absolutePath}/temp")
            if (!fileDir.exists()) {
                fileDir.mkdir()
                fileDir.mkdirs()
            }

            EncryptionUtils.encryptFile(file!!.path, fileToWrite, avRatchetKeyMaterial)

            val encryptedFileToUpload = File(fileToWrite)

            if (encryptedFileToUpload.exists()) {
                ApiHelper.with()?.forwardMediaInConversation(
                    conversation!!.conversationId,
                    members,
                    encryptedFileToUpload,
                    this,
                    this@ChatActivity
                )
            } else {
                Log.e(TAG, "File was not created forward ")
            }


        } else {
            Notify.Toast("Internet not Available")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag as Int == RequestCodes.API.CREATE_NEW_CONV) {
            if (response.code() == 200) {
                val res = response.body() as NewConversationResponse?
                res?.let {
                    Log.d(
                        TAG,
                        ("ChatActivity createNewConversation: " + Constants.END_POINT + RequestCodes.API_END_POINTS.CREATE_NEW_CONVERSATION + Constants.RESPONSE + res.toString())
                    )
                    res.conversation?.let {
                        conversationsDao.insert(res.conversation)
                        conversationsDao.updateMyMoniker(
                            res.conversation!!.conversationId, AppSession.getUser().chatUserId
                        )
                        //updating conversation
                        updateInConversation()
                        conversation_pk =
                            conversationsDao.getConversation(res.conversation!!.conversationId)!!.uid
                        Log.d("TAG", "onSuccess: " + res.conversation!!.conversationType)
                        if (!res.conversation!!.conversationType.equals(
                                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                            )
                        ) {
                            if ((res.imageBucketLink.isNotEmpty()) && (res!!.conversation!!.photo != null) && !res!!.conversation!!.photo.equals(
                                    Constants.KEYS.DUMMY_IMAGE, ignoreCase = true
                                )
                            ) {
                                img_file =
                                    File(MainApp.appContext!!.filesDir.path + "/" + res!!.conversation!!.photo)
                                DownloaderImage.instance!!.download(
                                    img_file!!.absolutePath,
                                    res.imageBucketLink!!,
                                    res.conversation!!.conversationId!!,
                                    res!!.conversation!!.photo!!
                                )
                                DownloaderImage.fileImageMutableLiveData.observe(
                                    (this@ChatActivity as LifecycleOwner)
                                ) { file1: File? ->
                                    if (img_file != null && file1 != null) {
                                        Log.e(
                                            TAG,
                                            "onSuccess: File 1 path : " + file1.absolutePath + "  Img_file path: " + img_file!!.absolutePath
                                        )
                                        if (img_file!!.absolutePath.equals(
                                                file1.absolutePath, ignoreCase = true
                                            )
                                        ) {
                                            conversationsDao.updateFilePath(
                                                res!!.conversation!!.conversationId, file1.path
                                            )
                                            mBinding?.let {
                                                Glide.with(MainApp.appContext!!).load(file1).into(
                                                    mBinding!!.ivChatImage
                                                )
                                            }
                                        }
                                    }

                                }
                            } else {
                                Glide.with(this)
                                    .load(Utills.getNameDrawable(groupName, AvatarColor.GROUP))
                                    .into(
                                        mBinding!!.ivChatImage
                                    )
                            }
                        } else {
                            Glide.with(MainApp.appContext!!).load(
                                if (mIsContact) Utills.getNameDrawable(
                                    NewContact!!.name, NewContact!!.avatarColor!!
                                ) else R.drawable.ic_unknown
                            ).into(
                                mBinding!!.ivChatImage
                            )
                        }


                        mBinding!!.ivDisappearIcon.visibility = GONE
                        //                        }


//                        this.conversation = res.getConversation();
                    }
                    Handler().postDelayed({

                        //Updating time of the conversation when it is created according to the respective device time
                        conversationsDao.updateConversationSequenceTime(
                            res.conversation!!.conversationId, System.currentTimeMillis()
                        )

                        val conversation =
                            conversationsDao?.getConversation(res!!.conversation!!.conversationId)


                        if (conversation!!.conversationType.equals(
                                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                            ) && mContact != null && !TextUtils.isEmpty(mContact!!.name)
                        ) {
                            conversation.name = mContact!!.name
                            MainApp.appContext?.conversationsDao?.updateName(
                                conversation.conversationId, conversation.name
                            )
                        }



                        conversation?.let { setConversation(it) }
                        if (intent.hasExtra(Constants.KEYS.INTENT_IS_FROM_VAULT) && intent.hasExtra(
                                "payload"
                            )
                        ) {
                            //Actual payload to be sent
                            payloadToForward = intent!!.getSerializableExtra("payload") as Payload
                            if (payloadToForward != null) {
                                file = File(payloadToForward!!.filePath!!)
                                filePath = payloadToForward!!.filePath
                                isForwarded = payloadToForward!!.isForwarded
                                if (file!!.exists()) {
                                    mediaType = payloadToForward!!.type
                                    uploadForwardFile()
                                } else {
                                    Log.e(TAG, Constants.FILE_NOT_EXIST)
                                }
                            } else {
                                Log.e(TAG, "Payload from vault was null")
                            }
                        }

                    }, 500)
                } ?: finish()
            } else Notify.Toast(Constants.NO_DATA_FOUND)
            //            }
        } else if (tag == RequestCodes.API.CREATE_ANONYMOUS_NEW_CONV) {
            if (response.code() == 200) {
                val res = response.body() as NewConversationResponse?
                if (res != null) {
                    Log.d(
                        TAG,
                        ("ChatActivity createAnonymousNewConversation: " + Constants.END_POINT + RequestCodes.API_END_POINTS.CREATE_ANONYMOUS_NEW_CONVERSATION + Constants.RESPONSE + res.toString())
                    )
                    if (res.conversation != null) {
                        conversationsDao.insert(res.conversation)
                        //updating conversation
                        updateInConversation()

                        conversation_pk =
                            conversationsDao.getConversation(res!!.conversation!!.conversationId)!!.uid
                        for (conversationMember in res!!.conversation!!.conversationMembers!!) {
                            if (conversationMember.isMe) {
                                conversationsDao.updateMyMoniker(
                                    res.conversation!!.conversationId, conversationMember.moniker
                                )
                                senderId = conversationMember.moniker
                                break
                            }
                        }
                        Log.d("TAG", "onSuccess: " + res!!.conversation!!.conversationType)
                        if (!res!!.conversation!!.conversationType.equals(
                                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                            )
                        ) {
                            if ((res.imageBucketLink.isNotEmpty()) && (res!!.conversation!!.photo != null) && !res!!.conversation!!.photo.equals(
                                    Constants.KEYS.DUMMY_IMAGE, ignoreCase = true
                                )
                            ) {
                                img_file =
                                    File(MainApp.appContext!!.filesDir.path + "/" + res.conversation!!.photo)
                                DownloaderImage.instance!!.download(
                                    img_file!!.absolutePath,
                                    res.imageBucketLink!!,
                                    res.conversation?.conversationId!!,
                                    res.conversation!!.photo!!
                                )

                                DownloaderImage.fileImageMutableLiveData.observe(
                                    (this@ChatActivity as LifecycleOwner)
                                ) { file1: File? ->
                                    file1?.let {
                                        img_file?.let {
                                            Log.e(
                                                TAG,
                                                "onSuccess: File 1 path : " + file1.absolutePath + "  Img_file path: " + img_file!!.absolutePath
                                            )
                                            if (img_file!!.absolutePath.equals(
                                                    file1.absolutePath, ignoreCase = true
                                                )
                                            ) {
                                                conversationsDao.updateFilePath(
                                                    res.conversation!!.conversationId,
                                                    file1.path
                                                )
                                                if (mBinding != null) Glide.with(MainApp.appContext!!)
                                                    .load(file1).into(
                                                        mBinding!!.ivChatImage
                                                    )
                                            }
                                        }
                                    }
                                }
                            } else {
                                Glide.with(this)
                                    .load(Utills.getNameDrawable(groupName, AvatarColor.GROUP))
                                    .into(
                                        mBinding!!.ivChatImage
                                    )
                            }
                        }
                        mBinding!!.ivDisappearIcon.visibility = VISIBLE
                        mBinding!!.ivDisappearIcon.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_group_anonymous_indicator_new))
                        //                        }


//                        this.conversation = res.getConversation();
                    }
                    Handler().postDelayed(object : Runnable {
                        override fun run() {
                            //Updating time of the conversation when it is created according to the respective device time
                            conversationsDao.updateConversationSequenceTime(
                                res.conversation!!.conversationId, System.currentTimeMillis()
                            )

                            val conversation =
                                conversationsDao?.getConversation(res.conversation!!.conversationId)

                            //Updating time of the conversation when it is created according to the respective device time
                            conversation!!.sequenceOfConversation = System.currentTimeMillis()
                            conversationsDao.updateConversationSequenceTime(
                                conversation.conversationId, conversation.sequenceOfConversation
                            )


                            conversation?.let { setConversation(it) }
                            initAdapter()
                        }
                    }, 500)
                } else finish()
            } else Notify.Toast(Constants.NO_DATA_FOUND)
            //            }
        } else if (tag == RequestCodes.API.UPLOAD_MEDIA) {
            if (response.code() == 200) {
                val res = response.body() as UploadMediaResponse?
                if (res != null && res.status.equals("Success", ignoreCase = true)) {
                    Log.d(
                        TAG,
                        ("ChatActivity uploadMedia: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPLOAD_MEDIA + Constants.RESPONSE + res.toString())
                    )
                    val payload = Payload()
                    val gson = Gson()
                    payload.data = res.media.toString() + "@@" + gson.toJson(res.metaData)
                    payload.userChatId = senderId
                    payload.senderId = senderId

                    payload.conversationId = conversation!!.conversationId
                    payload.type = mediaType
                    payload.conversationType = conversation!!.conversationType
                    payload.messageId = Utills.getRandomString(15)
                    payload.createdAt = DateTime.getCurrentDateTime()
                    payload.conversationType = type

                    payload.isExpire =
                        conversation != null && conversation!!.conversationExpiryTime >= 0

                    if (mediaType.equals(Constants.TYPES.VIDEO) || mediaType.equals(Constants.TYPES.IMAGE)) {
                        payload.isViewOnce = viewOnce
                    } else {
                        payload.isViewOnce = false
                    }

                    payload.isCanShareForward = conversation!!.isCanShareForward
                    Log.e(TAG, "${conversation!!.conversationExpiryTime}")
                    payload.msgExpiryTime = conversation!!.conversationExpiryTime
                    payload.isForwarded = isForwarded

                    isForwarded = false
                    payload.isConfidential = conversation?.isConfidential!!
                    payload.readReceipts = getReadReceipt()
                    if (Utills.isNetworkAvailable() && (isSocketConnected.value != null) && isSocketConnected.value!!) {
//                        payload.fingerprint = uploadingSecreteFingerprint!!.contentToString()
                        payload.aVRatchetKeyMaterial = avRatchetKeyMaterial
                        if (Utills.isNetworkAvailable() && isSocketConnected.value != null && isSocketConnected.value!!) {
                            EncryptionUtils.encryptMessage(null, payload, null)

                            payload.status = Constants.SENT
                        } else {
                            payload.status = Constants.NOT_DELIVERED
                            val offlineMessage = OfflineMessage()
                            offlineMessage.userChatId = AppSession.getUser().chatUserId
                            offlineMessage.conversationId = conversation!!.conversationId
                            offlineMessage.type = mediaType
                            offlineMessage.senderId = payload.senderId
                            offlineMessage.messageId = payload.messageId
                            offlineMessage.createdAt = DateTime.getCurrentDateTime()
                            offlineMessage.conversationType = type
                            offlineMessage.aVRatchetKeyMaterial = payload.aVRatchetKeyMaterial
                            offlineMessage.isExpire = true
                            offlineMessagesDao.insert(offlineMessage)
                        }
                        //Will move file to Internal storage after Successful upload
                        val uriOfFile = Util.getFileUri(this, filePath)
                        //copy file to Internal
                        if (uriOfFile != null) {
                            val internalFile = FilePath.fileFromContentUri(this, uriOfFile)
                            payload.filePath = internalFile.path

                            val con = conversationsDao.getConversation(payload.conversationId)
                            if (con.isAutoSaveVault) {
                                getInstance()!!.autoSaveToVault(internalFile.path)
                            }
                        } else {
                            payload.filePath = filePath
                        }
                        messagesDao.insert(payload)
                        conversation!!.lastMessage = payload
                        conversation!!.sequenceOfConversation = System.currentTimeMillis()
                        conversationsDao.update(conversation)
                        val messages = Messages()
                        messages.user = AppSession.getUser()
                        messages.user.chatUserId = senderId
                        messages.payload = payload
                        messages.createdAt = Date()
                        adapter!!.addToStart(messages, true)

                    }
                }
            }
        } else if (tag == RequestCodes.API.UPLOAD_FORWARD_MEDIA_ONLY) {
            if (response.code() == 200) {
                val res = response.body() as UploadMediaResponse?
                if (res != null && res.status.equals("Success", ignoreCase = true)) {
                    isFromForwardUpload = false
                    Log.d(
                        TAG,
                        ("ChatActivity uploadForwardMedia: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPLOAD_MEDIA + Constants.RESPONSE + res.toString())
                    )
                    val payload = Payload()
                    val gson = Gson()
                    payload.data = res.media.toString() + "@@" + gson.toJson(res.metaData)
                    payload.userChatId = senderId
                    payload.senderId = senderId
                    payload.conversationId = conversation!!.conversationId
                    payload.type = mediaType

                    payload.conversationType = conversation!!.conversationType
                    payload.messageId = Utills.getRandomString(15)
                    payload.createdAt = DateTime.getCurrentDateTime()
                    payload.conversationType = type

                    payload.isExpire =
                        conversation != null && conversation!!.conversationExpiryTime >= 0
                    payload.isViewOnce =
                        conversation != null && conversation!!.conversationExpiryTime == 0L
                    payload.isCanShareForward = conversation!!.isCanShareForward

                    payload.msgExpiryTime = conversation!!.conversationExpiryTime
                    payload.isForwarded = isForwarded
                    isForwarded = false
                    payload.aVRatchetKeyMaterial = avRatchetKeyMaterial
                    payload.isConfidential = conversation?.isConfidential!!
                    payload.readReceipts = getReadReceipt()
                    if (Utills.isNetworkAvailable() && (isSocketConnected.value != null) && isSocketConnected.value!!) {

                        EncryptionUtils.encryptMessage(null, payload, null)
                        payload.status = Constants.SENT

                    } else {
                        payload.status = Constants.NOT_DELIVERED
                        val offlineMessage = OfflineMessage()
                        offlineMessage.userChatId = AppSession.getUser().chatUserId
                        offlineMessage.conversationId = conversation!!.conversationId
                        offlineMessage.type = mediaType
                        offlineMessage.senderId = payload.senderId
                        offlineMessage.messageId = payload.messageId
                        offlineMessage.createdAt = DateTime.getCurrentDateTime()
                        offlineMessage.conversationType = type
                        offlineMessage.isExpire =
                            conversation != null && conversation!!.conversationExpiryTime >= 0

                        offlineMessage.isCanShareForward = payload.isCanShareForward

                        offlineMessage.msg_expiry_time = conversation!!.conversationExpiryTime
                        offlineMessage.isForwarded = payload.isForwarded
                        offlineMessage.aVRatchetKeyMaterial = payload.aVRatchetKeyMaterial

                        offlineMessagesDao.insert(offlineMessage)
                    }
                    //Will move file to Internal storage after Successful upload
                    val uriOfFile = Util.getFileUri(this, filePath)
                    //copy file to Internal
                    if (uriOfFile != null && !intent.hasExtra(Constants.KEYS.INTENT_IS_FROM_VAULT)) {
                        val internalFile = FilePath.fileFromContentUri(this, uriOfFile)
                        payload.filePath = internalFile.path
                        val con = conversationsDao.getConversation(payload.conversationId)
                        if (con.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(internalFile.path)
                        }
                    } else {
                        payload.filePath = filePath
                    }
                    conversation!!.lastMessage = payload
                    conversation!!.sequenceOfConversation = System.currentTimeMillis()
                    conversationsDao.update(conversation)
                    try {
                        val messages: Messages
                        messages = Messages()
                        messages.user = AppSession.getUser()
                        messages.user.chatUserId = senderId
                        messages.payload = payload
                        messages.createdAt = Date()
                        messagesDao.insert(payload)

                        ThreadUtil.runOnMainDelayed({
                            Log.e(TAG, "Was added in adapter")
                            adapter!!.addToStart(messages, true)

                        }, 500)
                    } catch (e: Exception) {
                        Log.e(TAG, "Error ${e.message}")
                    }
                    Log.e(TAG, "Was added in database")

                }
            }
        } else if (tag == RequestCodes.API.GET_PROFILE) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                if ((res != null) && (res.user != null)) {
                    Log.d(
                        TAG,
                        ("ChatActivity getprofile: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_PROFILE + Constants.RESPONSE + res.toString())
                    )
                    mUser = User()
                    mUser = res.user
                    showAddContactDialog()
                } else Notify.Toast(Constants.NO_DATA_FOUND)
            }
        } else if (tag == RequestCodes.API.BLOCK_USER) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                if (res != null && res.user != null) {
                    isBlocked = true
                    Log.d(
                        BaseActivity.TAG,
                        Constants.CONTACTS_DETAILS_ACTIVITY + Constants.END_POINT + RequestCodes.API_END_POINTS.BLOCK_USER + Constants.RESPONSE + res.toString()
                    )
                    var mUser: User? = User()
                    mUser = res.user
                    AppSession.saveUser(mUser)
//                    initViews()
                } else Notify.Toast(Constants.NO_DATA_FOUND)
            }

        } else if (tag == RequestCodes.API.UNBLOCK_USER) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                if (res != null && res.user != null) {
                    Log.d(
                        BaseActivity.TAG,
                        "ContactDetailActivity unBlock: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UNBLOCK_USER + Constants.RESPONSE + res.toString()
                    )
                    var mUser: User? = User()
                    mUser = res.user
                    AppSession.saveUser(mUser)
                    isBlocked = false
//                    initViews()
                } else Notify.Toast(Constants.NO_DATA_FOUND)
            }
        } else if (tag == RequestCodes.API.LEAVE_GROUP && response.code() == 200) {
            val res = response.body() as NewConversationResponse?
            if (res != null) {
                if (mCreateDialog != null && mCreateDialog!!.isShowing) mCreateDialog!!.dismiss()
                if (res.conversation != null) {
                    Log.d(
                        ChatDetailsActivity.TAG,
                        ("Chat Details Activity Leave Group: " + Constants.END_POINT + RequestCodes.API_END_POINTS.LEAVE_GROUP + Constants.RESPONSE + res.toString())
                    )
                    val moniker: String
                    if (conversation!!.myMoniker != null && conversation!!.conversationType.equals(
                            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                        )
                    ) moniker = conversation!!.myMoniker!! else {
                        moniker = AppSession.getUser().chatUserId!!
                    }
                    conversation = res.conversation
                    conversation!!.uid = conversation_pk
                    conversation!!.isRemoved = true
                    conversation!!.myMoniker = moniker
                    conversation!!.sequenceOfConversation = System.currentTimeMillis()
                    conversationsDao.update(conversation)
                    if (conversation!!.conversationType.equals(
                            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                        )
                    ) {

                        conversation?.let {
                            conversation?.conversationMembers?.forEach { member ->
                                if (!member.moniker.isNullOrEmpty()) {
                                    conversationChannelsDao.deleteConversationChannel(
                                        Utills.getHash("${it.conversationId}&&${member.moniker}")!!
                                    )
                                }
                            }
                        }
                        conversationsDao.updateMyMoniker(
                            conversation!!.conversationId, moniker
                        )
                    } else {
                        conversationsDao.updateMyMoniker(
                            conversation!!.conversationId, AppSession.getUser().chatUserId
                        )
                    }
                    removedFromConvo(conversation!!.conversationId!!)
                    setMembersName()
                    initViews()
                }
            } else Notify.Toast(Constants.NO_DATA_FOUND)

        }
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        Notify.Toast(response.message)
        finish()
    }

    //************************************************************
    override fun onMessageViewClick(
        view: View, message: Messages
    ) //************************************************************
    {
        if (!message.payload?.isConfidential!!) {
            if (!message.user.chatUserId.equals(senderId, ignoreCase = true)) {
                if (checkViewClickPayload(message)) {
                    return
                } else if (!message.payload.type.equals("text", ignoreCase = true)) {
                    handlingMediaPayloadClick(message)
                }
            } else {
                handleReceiverMediaPayload(message)
            }
        } else {

            Log.e(TAG, "Confidential Message")

        }
    }

    private fun handleReceiverMediaPayload(message: Messages) {
        if (message.payload.type.equals("audio", ignoreCase = true)) {
            return
        } else if (message.payload.type.equals("file", ignoreCase = true)) {
            Notify.Toast("Coming soon")
        } else if (message.payload.type.equals(
                "image", ignoreCase = true
            ) || message.payload.type.equals("video", ignoreCase = true)
        ) {
            startActivity(
                Intent(this, ScreenShowingActivity::class.java).putExtra(
                    "message", message
                )
            )
        } else {
//                startActivity(new Intent(this, ScreenShowingActivity.class).putExtra("message", message));
        }
    }

    private fun handlingMediaPayloadClick(message: Messages) {
        val currentString = message.payload.data
        val separated = currentString!!.split("@@").toTypedArray()
        val data = separated[0]
        if (message.payload != null && message.payload.filePath != null) {
            var file = File(message.payload.filePath)
            if (file.exists()) {
                if (message.payload.type.equals("file", ignoreCase = true)) {
                    Notify.Toast("Coming soon")
                    return
                } else {
                    file = File(message.payload.filePath)
                    if (file.exists()) {
                        message.payload.data = data
                        startActivity(
                            Intent(
                                this, ScreenShowingActivity::class.java
                            ).putExtra("message", message)
                        )
                    }
                }
            } else Notify.Toast("Please download first")
        } else Notify.Toast("Please download first")
    }

    private fun checkViewClickPayload(message: Messages): Boolean {
        return message.payload.type.equals(
            "audio", ignoreCase = true
        ) || message.payload.type.equals(
            Constants.TYPES.EXPIRE_MSG, ignoreCase = true
        ) || message.payload.type.equals(
            "member_added", ignoreCase = true
        ) || message.payload.type.equals(
            "admin_assigned", ignoreCase = true
        ) || message.payload.type.equals(
            "admin_removed", ignoreCase = true
        ) || message.payload.type.equals(
            "member_removed", ignoreCase = true
        ) || message.payload.type.equals(
            "member_leave", ignoreCase = true
        ) || message.payload.type.equals(
            "change_owner", ignoreCase = true
        ) || message.payload.type.equals(
            Constants.TYPES.GROUP_NAME_CHANGE, ignoreCase = true
        ) || message.payload.type.equals(
            Constants.TYPES.GROUP_DES_CHANGE, ignoreCase = true
        ) || message.payload.type.equals(
            Constants.TYPES.GROUP_ICON_CHANGE, ignoreCase = true
        ) || message.payload.type.equals(
            Constants.TYPES.GROUP_IS_CONFIDENTIAL_CHANGE, ignoreCase = true
        ) || message.payload.type.equals(
            Constants.TYPES.GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE, ignoreCase = true
        )
    }

    override fun onStop() {
        if (adapter?.mediaPlayer != null) {
            adapter!!.mediaPlayer.stop()
        }
        super.onStop()
    }


    fun updateMessage(payload: Payload?) {
        if (payload != null && conversation != null && conversation!!.conversationId.equals(
                payload.conversationId, ignoreCase = true
            )
        ) {
            val messages = Messages()
            val user = User()
            user.chatUserId = payload.userChatId
            messages.user = user
            messages.payload = payload
            messages.createdAt = Date()
            adapter!!.update(messages)
            Log.d("TAG", "updateMessage123: ")
        }
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mCommandReceiver)
        if (conversation != null && conversation!!.conversationId != null) {
            instance = null

            when (conversation?.conversationType) {
                Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                    if (DownloaderOneToOne.instance?.fileMutableLiveData?.hasObservers() == true) {
                        DownloaderOneToOne.instance?.fileMutableLiveData?.removeObservers(this@ChatActivity)
                    }
                }

                Constants.TYPES.CONVERSATION_GROUP -> {
                    if (DownloaderGroup.instance?.fileMutableLiveData?.hasObservers() == true) {
                        DownloaderGroup.instance?.fileMutableLiveData?.removeObservers(this@ChatActivity)
                    }
                }

                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                    if (DownloaderAnonymousGroup.instance?.fileMutableLiveData?.hasObservers() == true) {
                        DownloaderAnonymousGroup.instance?.fileMutableLiveData?.removeObservers(this@ChatActivity)
                    }
                }

            }

        }


        conversation = null

        super.onDestroy()
    }

    fun onLongClick(messages: Messages, adapterPosition: Int, view: View) {
        if (!Utills.isSubscriptionExpired()) {
            editingMessage = messages
            if (!messages.payload.senderId.equals(senderId, ignoreCase = true)) {
                view.background = AndroidUtil.getDrawable(R.drawable.bg_receive_message_white)
            }

            var bitmap: Bitmap = Util.getBitmapFromView(view)
            if (!messages.payload.senderId.equals(senderId, ignoreCase = true)) {
                view.background = AndroidUtil.getDrawable(R.drawable.bg_receive_message)
            }

            val view1 = this.currentFocus
            if (view1 != null) ViewUtil.hideKeyboard(this, view1)

            mBinding!!.reactionsShade.visibility = View.VISIBLE
            val selectedConversationModel: SelectedConversationModel = SelectedConversationModel(
                bitmap,
                view.getX(),
                view.getY() + mBinding!!.messagesList.getTranslationY(),
                view.getX(),
                view.getY(),
                view.getWidth(),
                null,
                editingMessage!!.payload.senderId.equals(senderId, ignoreCase = true),
                view.rootView.findFocus()
            )

            reactionDelegate.setOnActionSelectedListener(this@ChatActivity)
            reactionDelegate.setOnHideListener(this@ChatActivity)
            reactionDelegate.show(
                this, conversation!!, messages!!.payload, true, selectedConversationModel
            )
        } else {
            Utills.showSubscriptionEnd()
        }


    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        return reactionDelegate.applyTouchEvent(ev!!) || super.dispatchTouchEvent(ev)
    }

    fun conversationRemoved() {
        if (mBinding != null) mBinding!!.input.visibility = View.GONE
    }

    fun removedFromConvo(actualPayload: Payload) {
        mBinding?.let {
            if (actualPayload.conversationId.equals(
                    conversation!!.conversationId, ignoreCase = true
                )
            ) {
                mBinding!!.input.visibility = View.GONE
                mBinding!!.ivEmoji.visibility = View.GONE
                mBinding!!.tvCanNotSend.visibility = View.VISIBLE
            }
        }
    }

    fun removedFromConvo(conversationId: String) {
        mBinding?.let {
            if (conversationId.equals(
                    conversation!!.conversationId, ignoreCase = true
                )
            ) {
                mBinding!!.input.visibility = View.GONE
                mBinding!!.ivEmoji.visibility = View.GONE
                mBinding!!.fabSendMessage.visibility = View.GONE
                mBinding!!.tvCanNotSend.visibility = View.VISIBLE
            }
        }
    }

    fun addedInConversation() {
        if (mBinding != null) {
            mBinding!!.input.visibility = View.VISIBLE
            mBinding!!.ivEmoji.visibility = View.VISIBLE
            mBinding!!.tvCanNotSend.visibility = View.GONE
        }
    }

    fun startObserver(img_file: File?) {
        DownloaderImage.fileImageMutableLiveData.observe(
            (this@ChatActivity as LifecycleOwner),
            object : Observer<File?> {
                override fun onChanged(file: File?) {
                    file?.let {
                        img_file?.let {
                            if (img_file.absolutePath.equals(
                                    file.absolutePath, ignoreCase = true
                                )
                            ) {
                                conversationsDao?.updateFilePath(
                                    conversation!!.conversationId,
                                    file.path
                                )
                                conversationsDao.updateConversationIcon(
                                    conversation!!.conversationId, file.path, conversation!!.photo
                                )
                                conversation = conversationsDao.getConversation(
                                    conversation!!.conversationId
                                )
                                initViews()
                                DownloaderImage.fileImageMutableLiveData.removeObservers(
                                    this@ChatActivity
                                )

                            }
                        }
                    }
                }
            })
    }

    fun autoSaveToVault(path: String) {
        val uri = FileProvider.getUriForFile(
            getInstance()!!, BuildConfig.APPLICATION_ID + Constants.PROVIDER, File(path)
        )
        grantUriPermission(
            "com.devbeans.io.vault",
            uri,
            Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
        )
        val intent = Intent("com.save.vault")
        intent.putExtra("payload", uri.toString() + "")
        sendBroadcast(intent)
    }

    companion object {
        private const val TOTAL_MESSAGES_COUNT = 10
        var adapter: MessageAdapter<Messages>? = null
        private const val CONTENT_TYPE_VOICE: Byte = 1
        private const val CONTENT_TYPE_FILE: Byte = 2
        private const val CONTENT_TYPE_VIDEO: Byte = 3
        private const val CONTENT_TYPE_IMAGE: Byte = 4
        private const val CONTENT_TYPE_NOTIFY: Byte = 5
        private const val CONTENT_TYPE_CONFIDENTIAL: Byte = 6
        private const val CONTENT_TYPE_VIEW_ONCE: Byte = 7
        private const val CONTENT_TYPE_IS_SELF_EXPIRY: Byte = 8

        @JvmField
        var instance: ChatActivity? = null
        private var isEditMode = false
        private var isDeleteMode = false
        val TAG = ChatActivity::class.java.simpleName

        @JvmStatic
        fun getInstance(): ChatActivity? {
            val stopwatch = Stopwatch("Getting Instance")
            stopwatch.split("Creating Instance")
            if (instance == null) {
                instance = ChatActivity()
            }
            stopwatch.split("Instance created and sent")
            stopwatch.stop(Stopwatch.TAG)
            return instance
        }

        @JvmStatic
        fun getChatInstance(): ChatActivity? {
            return instance
        }

        fun containMessage(list: List<Messages>, messageID: String?): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                list.stream().anyMatch { o: Messages ->
                    o.payload.messageId!!.contains(
                        (messageID)!!
                    )
                }
            } else false
        }

        fun createTransitionBundle(context: Context, avatar: View, windowContent: View): Bundle? {
            return if (context is Activity) {
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    context,
                    Pair.create(avatar, "avatar"),
                    Pair.create(windowContent, "window_content")
                ).toBundle()
            } else {
                null
            }
        }


    }

    override fun onActionSelected(action: ConversationReactionOverlay.Action) {

        editingMessage?.let {
            when (action) {
                ConversationReactionOverlay.Action.REPLY -> {
                    //will be used for reply option selected
                }

                ConversationReactionOverlay.Action.FORWARD -> {

                    editingMessage!!.payload.isForwarded =
                        !editingMessage!!.payload.senderId.equals(
                            senderId, ignoreCase = true
                        ) || editingMessage!!.payload.isForwarded

                    val intent: Intent = Intent(
                        this@ChatActivity, ShareToActivity::class.java
                    ).putExtra("payload", editingMessage!!.payload)
                        .putExtra("conversation", conversation)
                    startActivity(intent)


                }

                ConversationReactionOverlay.Action.RESEND -> {
                    //this will be used when selected option of resend
                }

                ConversationReactionOverlay.Action.DOWNLOAD -> {
                    editingMessage!!.payload.filePath?.let {
                        val PERMISSION_TOKEN = "com.vault.file"
                        if (ContextCompat.checkSelfPermission(
                                this@ChatActivity,
                                PERMISSION_TOKEN
                            ) == PackageManager.PERMISSION_GRANTED
                        ) {
                            val uri = FileProvider.getUriForFile(
                                this@ChatActivity,
                                BuildConfig.APPLICATION_ID + Constants.PROVIDER,
                                File(editingMessage!!.payload.filePath!!)
                            )
                            grantUriPermission(
                                "com.devbeans.io.vault",
                                uri,
                                Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
                            )
                            val intent = Intent("com.save.vault")
                            intent.putExtra("payload", uri.toString() + "")
                            sendBroadcast(intent)

                        } else {
                            ActivityCompat.requestPermissions(
                                this@ChatActivity,
                                arrayOf(PERMISSION_TOKEN),
                                REQUEST_CODE
                            )
                        }


                    }
                }

                ConversationReactionOverlay.Action.COPY -> {
                    if (editingMessage?.payload?.type.equals(
                            "text", ignoreCase = true
                        )
                    ) {
                        Util.copyToClipboard(this@ChatActivity, editingMessage!!.payload.data!!)
                        Notify.Toast("Text Copied to Clipboard")
                    } else {
                        if (Util.copyImageToClipBoard(
                                this@ChatActivity, editingMessage!!.payload.filePath
                            )
                        ) {
                            mBinding!!.ivEdit.visibility = VISIBLE
                            Notify.Toast("Image Copied to Clipboard")
                        } else {
                            Notify.Toast("Image Not Copied to Clipboard")
                        }
                    }

                }

                ConversationReactionOverlay.Action.MULTISELECT -> {
                    //this will be used when multi select is selected
                }

                ConversationReactionOverlay.Action.VIEW_INFO -> {
                    //this will be used when view message info is selected
                }

                ConversationReactionOverlay.Action.DELETE -> {
                    showDeleteDialog()
                }

                ConversationReactionOverlay.Action.SHARE -> {

                    val mediaType: String = when {
                        editingMessage!!.payload.type.equals("image", ignoreCase = true) -> "image"
                        editingMessage!!.payload.type.equals("video", ignoreCase = true) -> "video"
                        editingMessage!!.payload.type.equals("audio", ignoreCase = true) -> "audio"
                        editingMessage!!.payload.type.equals("file", ignoreCase = true) -> "file"
                        else -> {
                            "file"
                        }
                    }

                    val file: File = File(editingMessage!!.payload.filePath!!)
                    val swatchImageUri = FileProvider.getUriForFile(
                        this, BuildConfig.APPLICATION_ID + Constants.PROVIDER, file
                    )

                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.putExtra(
                        Intent.EXTRA_STREAM, swatchImageUri
                    )
                    shareIntent.type = "$mediaType/*"
                    startActivity(Intent.createChooser(shareIntent, null))

                }

                ConversationReactionOverlay.Action.EDIT -> {
                    isEditMode = true
                    mBinding!!.input.inputEditText.setText(editingMessage!!.payload.data)

                    mBinding!!.input.inputEditText.setSelection(mBinding!!.input.inputEditText.text.length)
                    ViewUtil.fadeOut(
                        mBinding!!.ivEmoji, 300
                    )
                    ViewUtil.fadeIn(
                        mBinding!!.fabSendMessage, 300
                    )

                    ViewUtil.focusAndMoveCursorToEndAndOpenKeyboard(mBinding!!.input.inputEditText)

                }
            }
        }
    }

    override fun startHide() {

        adapter!!.unselectAllItems()
//        mBinding!!.reactionsShade.visibility=View.GONE
        ViewUtil.fadeOut(
            mBinding!!.reactionsShade,
            resources.getInteger(R.integer.reaction_scrubber_hide_duration),
            GONE
        )

    }

    override fun onHide() {
//is used when view is hidden on

    }

    private fun onRecordHideEvent(tag: String): Long {
//        recordLockCancel.setVisibility(GONE)
//        val future = slideToCancel.hide()
//        //        future.addListener(object : AssertedSuccessListener<Void?>() {
////            fun onSuccess(result: Void?) {
////                if (voiceNoteDraftView.getDraft() == null) {
////                    fadeInNormalComposeViews()
////                }
////            }
////        })

        Log.e(TAG, "Got from $tag")
        slideToCancel.hide()


        return recordTime.hide()
    }


    @RequiresApi(Build.VERSION_CODES.R)
    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                RECORD_AUDIO,
                CAMERA,
                READ_EXTERNAL_STORAGE,
                MANAGE_EXTERNAL_STORAGE,
                WRITE_EXTERNAL_STORAGE
            ), PERMISSION_REQUEST_CODE
        )

    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        Permissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {

                if (grantResults.isNotEmpty()) {
                    if (checkPermission()) {
                        Snackbar.make(
                            mBinding!!.input, "Permission Granted.", Snackbar.LENGTH_LONG
                        ).show()
                    } else {
                        Snackbar.make(
                            mBinding!!.input, "Permission Not Granted", Snackbar.LENGTH_LONG
                        ).show()
                    }

                }
            }


        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(this@ChatActivity, CAMERA)
        val result1 = ContextCompat.checkSelfPermission(this@ChatActivity, RECORD_AUDIO)
        val result2 = ContextCompat.checkSelfPermission(this@ChatActivity, READ_EXTERNAL_STORAGE)
        val result3 = ContextCompat.checkSelfPermission(this@ChatActivity, MANAGE_EXTERNAL_STORAGE)
        val result4 = ContextCompat.checkSelfPermission(this@ChatActivity, WRITE_EXTERNAL_STORAGE)
        return result == PackageManager.PERMISSION_GRANTED
//                && result1 == PackageManager.PERMISSION_GRANTED
    }

    fun onConfidentialClick(
        messages: Messages, adapterPosition: Int, bubbleView: ConstraintLayout
    ) {

        if (messages.payload != null && this@ChatActivity.conversation != null) {
            startActivity(
                Intent(
                    this@ChatActivity, MessageDetailsActivity::class.java
                ).putExtra(Constants.KEYS.INTENT_PAYLOAD, messages.payload)
                    .putExtra(Constants.KEYS.INTENT_CONVERSATION, this@ChatActivity.conversation)
                    .putExtra(Constants.KEYS.INTENT_SENDER_ID, this@ChatActivity.senderId)
            )
        }
    }

    fun onViewOnceClicked(message: Messages) {
        if (!message.payload.isOpened) {
            startActivity(
                ViewOnceMessageActivity.getIntent(
                    this, message.payload.messageId, message.payload.filePath!!
                )
            )
            messagesDao.updateMessageOpened(message.payload.messageId, true)
        } else {
            Notify.Toast("Message Already Opened")
        }
    }

    override fun onRecordPressed() {
        Log.e(TAG, "Pressed ")
        if (!isBlocked) {

            val vibrator = ServiceUtil.getVibrator(this@ChatActivity)
            vibrator.vibrate(20)
            this@ChatActivity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            this@ChatActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
            mBinding?.recorderView?.visibility = VISIBLE
            mBinding?.input?.inputEditText?.isEnabled = false
            mBinding!!.ivEmoji.isEnabled = false
            mBinding?.input?.attachmentButton?.isEnabled = false
            mBinding?.input?.inputEditText?.clearFocus();
            if (!Utills.isSubscriptionExpired()) {
                recordTime.display()
                slideToCancel.display()
                try {
                    audioRecorder.startRecording()
                } catch (e: Exception) {
                    Log.e(javaClass.simpleName, "Got Exception in recording media $e")
                }
                fadeOut(mBinding?.input!!)
                fadeOut(mBinding!!.ivEmoji)
            } else {
                Utills.showSubscriptionEnd()
            }

        } else {
            showBlockUserDialog()
        }
//        if (mediaController)


    }

    override fun onRecordReleased() {
        val vibrator = ServiceUtil.getVibrator(this@ChatActivity)
        vibrator.vibrate(20)
        val elapsedTime = onRecordHideEvent("onRecordReleased")
        ThreadUtil.runOnMainDelayed({

            mBinding?.recorderView?.visibility = GONE
            fadeIn(mBinding?.ivEmoji!!)
            fadeIn(mBinding?.input!!)
            onRecordHideEvent("onRecordReleased two")
            mBinding?.input?.button?.isEnabled = true
            mBinding?.input?.inputEditText?.isEnabled = true
            mBinding?.input?.attachmentButton?.isEnabled = true
            mBinding?.ivEmoji?.isEnabled = true
            mBinding?.recorderView?.setTouchView(mBinding?.input?.button!!)
        }, 150)

        this@ChatActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        Log.e(TAG, "Elapsed Time $elapsedTime")
        if (elapsedTime > 1000 && !Utills.isSubscriptionExpired()) {
            val future: ListenableFuture<VoiceNoteDraft> = audioRecorder.stopRecording()
            future.addListener(object : ListenableFuture.Listener<VoiceNoteDraft> {
                override fun onSuccess(result: VoiceNoteDraft) {

                    file = File(
                        MainApp.audioPathSent + "/rec.aac"
                    )
//                    filePath = path
                    if (file!!.exists()) {
                        filePath = file?.path
                        Log.e(TAG, "File existed")
                        mediaType = "audio"
                        loader = Loading.make(this@ChatActivity).setMessage("Compressing...")
                        loader?.show()
                        filePath = file?.path
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            uploadFile()
                        }

                    }

                }

                override fun onFailure(e: ExecutionException?) {
                    Log.e(TAG, "Exception in Recorder $e \n")
                    Toast.makeText(
                        this@ChatActivity,
                        R.string.ConversationActivity_unable_to_record_audio,
                        Toast.LENGTH_LONG
                    ).show()
                    releaseAudioPlayer()
                }

            })
//            onRecorderFinished()
        } else if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            stopRecording()
        } else {
            Toast.makeText(
                this@ChatActivity,
                R.string.InputPanel_tap_and_hold_to_record_a_voice_message_release_to_send,
                Toast.LENGTH_LONG
            ).show()
            stopRecording()
        }


    }

    private fun releaseAudioPlayer() {
//        try {
//            val recorderPrevious = MediaRecorder()
//            recorderPrevious.release()
//        } catch (e: java.lang.Exception) {
//            Log.e(TAG, "Exception in releasing MediaRecorder")
//            e.printStackTrace()
//        }
    }

    private fun stopRecording() {
        try {

            val future: ListenableFuture<VoiceNoteDraft> = audioRecorder.stopRecording()
            releaseAudioPlayer()
            Log.e(TAG, "Recorder released ")
            future.addListener(object : ListenableFuture.Listener<VoiceNoteDraft> {
                override fun onSuccess(result: VoiceNoteDraft) {

                    val tmpFile = File(
                        MainApp.audioPathSent + "/rec.aac"
                    )
//                    filePath = path
                    if (tmpFile.exists()) {
//                        filePath = file?.path
                        Log.e(TAG, "File existed ${tmpFile.length()}")

                    }

                }

                override fun onFailure(e: ExecutionException?) {
                    Log.e(TAG, "Exception in Recorder $e \n")
                    Toast.makeText(
                        this@ChatActivity,
                        R.string.ConversationActivity_unable_to_record_audio,
                        Toast.LENGTH_LONG
                    ).show()
                }

            })

        } catch (e: Exception) {
            Log.e(TAG, "Exception in recording stopped ")
        }
    }

    override fun onRecordCanceled() {

        val vibrator = ServiceUtil.getVibrator(this@ChatActivity)
        vibrator.vibrate(50)

        this@ChatActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val future = audioRecorder.stopRecording()
//        onRecordHideEvent("onRecordCanceled")
        ThreadUtil.runOnMainDelayed({
            mBinding?.recorderView?.visibility = GONE
            fadeIn(mBinding?.ivEmoji!!)
            fadeIn(mBinding?.input!!)
            onRecordHideEvent("onRecordCanceled two")
            mBinding?.input?.button?.isEnabled = true
            mBinding?.input?.inputEditText?.isEnabled = true
            mBinding?.input?.attachmentButton?.isEnabled = true
            mBinding?.ivEmoji?.isEnabled = true
            mBinding?.recorderView?.setTouchView(mBinding?.input?.button!!)
        }, 150)

        if (lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
            future.addListener(DeleteCanceledVoiceNoteListener())
        } else {
            //is used when lifecycle is not resumed
        }
    }

    override fun onRecordLocked() {
//        this@ChatActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

    }

    override fun onRecordMoved(offsetX: Float, absoluteX: Float) {
        slideToCancel.moveTo(offsetX)

        val position = absoluteX / recordingContainer.width

        if (ViewUtil.isLtr(this) && position <= 0.5 || ViewUtil.isRtl(this) && position >= 0.6) {
            mBinding?.recorderView?.cancelAction()
        }
    }

    override fun onRecordPermissionRequired() {
        Permissions.with(this).request(RECORD_AUDIO).ifNecessary().withRationaleDialog(
            getString(R.string.ConversationActivity_to_send_audio_messages_allow_chat_access_to_your_microphone),
            R.drawable.ic_mic_solid_24
        )
//            .withPermanentDenialDialog(getString(R.string.ConversationActivity_chat_requires_the_microphone_permission_in_order_to_send_audio_messages))
            .execute();

    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}
