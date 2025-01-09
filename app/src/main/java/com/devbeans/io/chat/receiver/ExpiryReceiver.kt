package com.devbeans.io.chat.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.devbeans.io.chat.BuildConfig
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.utils.DownloaderImage
import com.devbeans.io.chat.utils.SettingsValues
import com.devbeans.io.chat.utils.ThreadUtil
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.downloaders.Downloader
import com.devbeans.io.chat.utils.downloaders.DownloaderAnonymousGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderOneToOne
import com.devbeans.io.chat.utils.logging.Log
import com.goterl.lazysodium.exceptions.SodiumException
import kotlinx.coroutines.*


class ExpiryReceiver : BroadcastReceiver() {
    private val TAG = ExpiryReceiver::class.java.simpleName
    private val data = "data"
    private val name = "name"
    private val expire = "expire"
    private val grace = "grace"
    private val retreat = "retreat"
    private val MDM_PKG = "com.dev.io.mdm"
    private var context: Context? = null
    private var action = BuildConfig.APPLICATION_ID + ".license"

    override fun onReceive(context: Context?, intent: Intent?) {

        val nameHash = MainApp.ls.cryptoHashSha256(MDM_PKG)
        try {
            if (intent?.hasExtra(name)!! && MainApp.ls.cryptoHashSha256(intent.getStringExtra(name))
                    .equals(nameHash)
            ) {
                this.context = context
                handleExpiry(intent)

            }
        } catch (e: SodiumException) {
            Log.e(TAG, "Got exception in hash $e")
        } catch (e: Exception) {
            Log.e(TAG, "Got exception $e")
        }

    }

    private fun handleExpiry(intent: Intent) {
        Log.e(TAG, "Got Expiry Intent")
        if (intent.hasExtra(data)) {
            val handler = CoroutineExceptionHandler { _, exception ->
                Log.e(TAG, "CoroutineExceptionHandler got $exception")
            }
            CoroutineScope(Dispatchers.IO).launch(handler) {
                Log.e(TAG, "Got ${intent.getStringExtra(data)}")
                when (intent.getStringExtra(data)) {
                    retreat -> {
                        handleSubscriptionRenew()
                    }
                    grace -> {
                        if (!SettingsValues.getSubscriptionGraceSet()) {
                            handleGracePeriodStart()
                        } else {
                            sendReceivedAck(grace)
                        }
                    }
                    expire -> {
                        if (!SettingsValues.getSubscriptionEndSet()) {
                            handleSubscriptionEnd()
                        } else {
                            sendReceivedAck(expire)
                        }
                    }
                }
                delay(2000)
            }


        }
    }

    private fun sendReceivedAck(data: String) {
        try {
            val sendMessage = Intent()
            sendMessage.putExtra(this.name, MainApp.appContext!!.packageName)
            sendMessage.putExtra(this.data, data)
            sendMessage.action = action
            sendMessage.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            MainApp.appContext!!.sendBroadcast(sendMessage)
        } catch (e: Exception) {
            Log.e(TAG, "Error in sending action $e ")
        }
    }

    private fun handleSubscriptionEnd() {


        SettingsValues.setSubscriptionEndSet(true)
        SettingsValues.setSubscriptionGraceSet(false)
//        MainActivity.isSocketConnected.value?.let {
//            if (it) {


//            }
//        }

        try {
            ThreadUtil.runOnMain {
                MainActivity.isSocketConnected.postValue(false)
                if (MainActivity.webSocket != null) {
                    MainActivity.webSocket!!.close(1000, null)
                    MainActivity.webSocket!!.cancel()
                    MainActivity.chatWebSocket?.webSocket = null
                }
            }
            DownloaderImage.instance?.clearDownloadingData()
            Downloader.instance?.clearDownloadingData()
            DownloaderAnonymousGroup.instance?.clearDownloadingData()
            DownloaderGroup.instance?.clearDownloadingData()
            DownloaderOneToOne.instance?.clearDownloadingData()
            MainApp.appContext?.notifyViewExpiry()
            sendReceivedAck(expire)
        } catch (e: Exception) {
            Log.e(TAG, "Error ${e.message}")
        }

    }

    private fun handleGracePeriodStart() {
        try {
            SettingsValues.setSubscriptionGraceSet(true)
            SettingsValues.setSubscriptionEndSet(false)
            if (Utills.isNetworkAvailable()) {
                MainActivity.INSTANCE?.reInitiateSocketConnection("Expiry Service")
            }
            MainApp.appContext?.notifyViewExpiry()
            sendReceivedAck(grace)

        } catch (e: Exception) {
            Log.e(TAG, "Exception $e ")
        }

    }

    private fun handleSubscriptionRenew() {
        try {
            SettingsValues.setSubscriptionEndSet(false)
            SettingsValues.setSubscriptionGraceSet(false)
//            MainActivity.isSocketConnected.value?.let {
//                if (!it) {
//                    Utills.checkChatServerConnected(object : NetworkCallback {
//                        override fun onResponse(network: Boolean) {
//                            if (network) {

            if (Utills.isNetworkAvailable()) {
                MainActivity.INSTANCE?.reInitiateSocketConnection("Expiry Service")
            }
            MainApp.appContext?.notifyViewExpiry()
            sendReceivedAck(retreat)
//                            }
//                        }
//                    })
//                }
//            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception $e")
        }


    }


}