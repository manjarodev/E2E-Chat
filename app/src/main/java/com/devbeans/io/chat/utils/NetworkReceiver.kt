package com.devbeans.io.chat.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Handler
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.activities.MainActivity.Companion.instance
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.NetworkCallback
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.extensions.offlineMessagesDao
import com.devbeans.io.chat.models.OfflineMessage
import com.devbeans.io.chat.network.APIInterface
import com.devbeans.io.chat.network.RetrofitClient
import com.devbeans.io.chat.network.serializers.requestbody.UploadKeyRequest
import com.devbeans.io.chat.network.serializers.response.UploadKeysModel
import com.devbeans.io.chat.utils.EncryptionUtils.encryptMessage
import com.devbeans.io.chat.utils.Utills.isConnectedChat
import com.devbeans.io.chat.utils.Utills.isConnectedKds
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.websocket.WebSocketConnectionState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class NetworkReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = (activeNetwork != null && activeNetwork.isConnectedOrConnecting)
        if (isConnected) {

            CheckOnlineStatus().execute()
            Utills.checkChatServerConnected(object : NetworkCallback {
                override fun onResponse(network: Boolean) {
                    if (network) {
                        if (!Utills.isSubscriptionExpired()) {
                            checkAndUploadKeys()
                            Handler().postDelayed(
                                { instance!!.reInitiateSocketConnection("Network reciver") },
                                2 * 1000
                            )

                            Handler().postDelayed({ sendOfflineMessages() }, 7000)
                            Handler().postDelayed({
                                MainApp.appContext?.scheduleNextRevealableMessageManager(
                                    TAG
                                )
                            }, 1000 * 2)
                        }
                    } else {
                        Log.e(TAG, "Server was not available")
                    }
                }

            })

        } else {
            ThreadUtil.runOnMain {
                MainActivity.chatWebSocket?.state = WebSocketConnectionState.FAILED
                MainActivity.chatWebSocket?.webSocket = null
                MainActivity.isSocketConnected.postValue(false)
            }
        }
    }

    private fun checkAndUploadKeys() {
        Thread {
            val retrofitClient =
                RetrofitClient.createRetroCLient().create(APIInterface::class.java)
            if (!SettingsValues.getKeysUploadRequest().isNullOrEmpty()) {
                val requestToUpload = SettingsValues.getKeysUploadRequest()
                val gson = Gson()
                val type = object : TypeToken<UploadKeyRequest>() {}.type
                val requests: UploadKeyRequest = gson.fromJson(requestToUpload, type)
                val data = requests.data!!
                val chatId = requests.chatId
                val signature = requests.signature
                val uploadKey = retrofitClient.uploadKeys(
                    data, chatId, signature
                )
                if (!Utills.isSubscriptionExpired()) {
                    uploadKey!!.enqueue(object : Callback<UploadKeysModel?> {
                        override fun onResponse(
                            call: Call<UploadKeysModel?>,
                            response: Response<UploadKeysModel?>
                        ) {
                            if (response.isSuccessful) {
                                SettingsValues.setKeyUploaded(true)
                                Log.e(TAG, "KEYS UPLOADED")
                            } else {
                                SettingsValues.setKeyUploaded(false)
                                val request = UploadKeyRequest()
                                request.data = data
                                request.chatId = chatId
                                request.signature = signature
                                SettingsValues.setKeysUploadRequest(gson.toJson(request))
                                Log.e(TAG, "KEYS DID NOT UPLOADED")
                            }
                        }

                        override fun onFailure(
                            call: Call<UploadKeysModel?>, t: Throwable
                        ) {
                            t.printStackTrace()
                            SettingsValues.setKeyUploaded(false)
                            Log.e(TAG, "onFailure KEYS DID NOT UPLOADED")
                            val request = UploadKeyRequest()
                            request.data = data
                            request.chatId = chatId
                            request.signature = signature
                            SettingsValues.setKeysUploadRequest(gson.toJson(request))
                        }
                    })
                }

            }
        }.start()
    }

    private fun sendOfflineMessages() {
        Handler().postDelayed({
            val offlineMessages = MainApp.database!!.offlineMessagesDao()!!.allMessages
            if (offlineMessages != null && !offlineMessages.isEmpty()) {
                val sentMessages: MutableList<OfflineMessage> = ArrayList()
                if (MainActivity.isSocketConnected.value != null && MainActivity.isSocketConnected.value!!) {
                    val gson = Gson()
                    offlineMessages.forEach { messages ->
                        sentMessages.add(messages)

                        val payload =
                            MainApp.appContext?.messagesDao?.getMessage(messages.messageId)
                        //                            String createdAtTime = payload.getCreatedAt();
//                            payload.setCreatedAt(DateTime.INSTANCE.getCurrentDateTime());
                        payload?.let {
                            payload.status = Constants.SENT
                            MainApp.appContext?.messagesDao?.updateMessage(payload)
                            getInstance()!!.updateMessage(payload)
                        }

                        Handler().postDelayed({
                            payload?.let {
                                encryptMessage(payload.data, payload, null)
                                //                                    String encPayload = EncryptionUtils.INSTANCE.encryptOfflinePayload(messages);
//                                    MainActivity.webSocket.send(encPayload);
                            }
                        }, 300)


                    }
                    if (sentMessages.isNotEmpty()) {
                        MainApp.appContext!!.offlineMessagesDao.delete(sentMessages)
                    }

                }
            }
        }, 500)
    }

    private inner class CheckOnlineStatus : AsyncTask<Void?, Int?, Boolean>() {


        override fun onPostExecute(result: Boolean) {
            //Here you will receive your result from doInBackground
            //This is on the UI Thread
        }

        val isOnline: Boolean
            get() {
                val runtime = Runtime.getRuntime()
                try {
                    val ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8")
                    val exitValue = ipProcess.waitFor()
                    return exitValue == 0
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                return false
            }

        override fun doInBackground(vararg p0: Void?): Boolean {
            //This is a background thread, when it finishes executing will return the result from your function.
            val isOnline = isOnline
            if (isOnline) {
                // can use for being when device is connected
            } else Log.d("doInBackground", "offline: ")
            return isOnline
        }
    }

    companion object {
        val TAG = NetworkReceiver::class.java.simpleName
    }
}