package com.devbeans.io.chat.services


//import com.devbeans.io.chat.extensions.APIInterfaceNew
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaCodec
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.extensions.chatKeyPairDao
import com.devbeans.io.chat.models.ChatKeyPair
import com.devbeans.io.chat.models.ManifestModel
import com.devbeans.io.chat.network.APIInterface
import com.devbeans.io.chat.network.RetrofitClient
import com.devbeans.io.chat.network.serializers.requestbody.UploadKeyRequest
import com.devbeans.io.chat.network.serializers.response.UploadKeysModel
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.goterl.lazysodium.utils.Key
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class SavingKeysService : Service() {
    val TAG = Log.tag(SavingKeysService::class.java)


    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            val listOfKeysGson = intent!!.getStringExtra("dataList")
            val chatId = intent.getStringExtra("chatId")
            val intentSik = intent.getStringExtra(Constants.KEYS.INTENT_SIK)
            val intentSikX = intent.getStringExtra(Constants.KEYS.INTENT_SIK_X)
            val intentIk = intent.getStringExtra(Constants.KEYS.INTENT_IK)
            val gson = Gson()
            val type = object : TypeToken<ArrayList<ChatKeyPair>>() {}.type
            val sikType = object : TypeToken<ChatKeyPair>() {}.type
            val list: ArrayList<ChatKeyPair> = gson.fromJson(listOfKeysGson, type)
            val sik: ChatKeyPair = gson.fromJson(intentSik, sikType)
            val sikX: ChatKeyPair = gson.fromJson(intentSikX, sikType)
            val ik: ChatKeyPair = gson.fromJson(intentIk, sikType)
            saveAllKeys(list, chatId, sik, sikX, ik)
        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun saveAllKeys(
        allKeys: ArrayList<ChatKeyPair>,
        chatId: String?,
        sik: ChatKeyPair,
        sikX: ChatKeyPair,
        ik: ChatKeyPair
    ) {
        val model = ManifestModel()
        val keyPairGenerator = KeyPairGenerator()
        Log.e(TAG, "Keys Size ${allKeys.size}")
        Log.e(TAG, "SIK Key $sik")
        Log.e(TAG, "IK Key $ik")
        Log.e(TAG, "SIKx $sikX")

        model.identityPubKey = ik.pubKey
        model.identityPriKey = "test"
        model.fingerprintPubKey = ik.identifier
        model.expiry = 30
        val x25519KeyPairList = java.util.ArrayList<ChatKeyPair>()

        for (i in allKeys.indices) {

            val x25519KeyPair = keyPairGenerator.convertCurveToX25519(allKeys[i])!!
            x25519KeyPairList.add(
                x25519KeyPair
            )
            model.chatKeyClass.add(
                ManifestModel.ChatKeyClass(
                    x25519KeyPair.identifier,
                    x25519KeyPair.pubKey,
                    30
                )
            )
        }

        //store key HSM
        val hsm = HSM.with()

        //updating pair fruits one by one
        for (i in x25519KeyPairList.indices) {
            try {
                hsm.storeKey(
                    x25519KeyPairList[i], x25519KeyPairList[i].identifier
                )
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: MediaCodec.CryptoException) {
                e.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


        chatKeyPairDao.insertAll(allKeys)
        Log.e(
            TAG, "Identity Private Key :::::" + hsm.secretIdentityKeyPair().toString()
        )

        Log.e(
            TAG, "Server Identity Private Key :::::" + hsm.secretServerIdentityKeyPair().toString()
        )

        Log.e(
            TAG,
            "Server X25519 Identity Private Key :::::" + hsm.secretX25519ServerIdentityKeyPair()
                .toString()
        )

        Log.e(
            TAG, "Private Key ::::: ${hsm.secretKeyPair(allKeys[12].identifier)} "
        )

        try {
            callNetworkingAPI(chatId!!, model, sik)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, " Exception in saving HSM ${e.printStackTrace()}")
        }

    }

    private fun callNetworkingAPI(chatId: String, model: ManifestModel, sik: ChatKeyPair) {
        uploadKeys(model, chatId, sik)
    }


    private fun uploadKeys(model: ManifestModel, chatId: String, sik: ChatKeyPair) {

        val gson = Gson()
        val data = gson.toJson(model)


        val signature = EncryptionUtils.signSignature(
            data, Key.fromBase64String(sik.privKey)
        )

        val retrofitClient = RetrofitClient.createRetroCLient().create(APIInterface::class.java)
        val uploadKey = retrofitClient.uploadKeys(
            data, chatId, signature
        )
        Log.e(TAG, "Signature:  $signature")
        if (!Utills.isSubscriptionExpired()) {
            if (Utills.isConnectedKds())
                uploadKey!!.enqueue(object : Callback<UploadKeysModel?> {
                    override fun onResponse(
                        call: Call<UploadKeysModel?>, response: Response<UploadKeysModel?>
                    ) {
                        if (response.isSuccessful) {
                            AppSession.keysUploaded(true)
                            SettingsValues.setKeyUploaded(true)
                            Log.e(TAG, "KEYS UPLOADED")
                            stopSelf()
                        } else {
                            SettingsValues.setKeyUploaded(false)
                            val request = UploadKeyRequest()
                            request.data = data
                            request.chatId = chatId
                            request.signature = signature
                            SettingsValues.setKeysUploadRequest(gson.toJson(request))
                            Log.e(TAG, "KEYS DID NOT UPLOADED")
                            stopSelf()
                        }
                    }

                    override fun onFailure(call: Call<UploadKeysModel?>, t: Throwable) {
                        t.printStackTrace()
                        SettingsValues.setKeyUploaded(false)
                        Log.e(TAG, "onFailure KEYS DID NOT UPLOADED")
                        val request = UploadKeyRequest()
                        request.data = data
                        request.chatId = chatId
                        request.signature = signature
                        SettingsValues.setKeysUploadRequest(gson.toJson(request))
                        stopSelf()
                    }
                })
            else {
                SettingsValues.setKeyUploaded(false)
                Log.e(TAG, "Internet was not available")
                val request = UploadKeyRequest()
                request.data = data
                request.chatId = chatId
                request.signature = signature
                SettingsValues.setKeysUploadRequest(gson.toJson(request))
            }
        }

    }


    override fun onBind(intent: Intent?): IBinder? {

        return null
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {


        @RequiresApi(api = Build.VERSION_CODES.O)
        fun createNotificationChannel(notificationManager: NotificationManager): String {
            val channelId = "my_key_service_channelid"
            val channelName = "My Foreground Key Service"
            val channel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            // omitted the LED color
            channel.importance = NotificationManager.IMPORTANCE_NONE
            channel.lockscreenVisibility = Notification.VISIBILITY_SECRET
            notificationManager.createNotificationChannel(channel)
            return channelId
        }
    }
}
