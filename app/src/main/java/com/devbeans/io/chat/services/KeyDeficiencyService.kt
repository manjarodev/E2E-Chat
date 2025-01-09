package com.devbeans.io.chat.services

import android.app.Service
import android.content.Intent
import android.media.MediaCodec
import android.os.IBinder
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.extensions.chatKeyPairDao
import com.devbeans.io.chat.models.ChatKeyPair
import com.devbeans.io.chat.models.ManifestModel
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.network.APIInterface
import com.devbeans.io.chat.network.RetrofitClient
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

class KeyDeficiencyService : Service() {
    val TAG = Log.tag(KeyDeficiencyService::class.java)


    override fun onCreate() {
        isRunning = true
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            val hsm = HSM()
            val gson = Gson()
            var list: ArrayList<ChatKeyPair>
            val payloadIntent = intent?.getStringExtra(Constants.KEYS.INTENT_PAYLOAD)
            val payloadType = object : TypeToken<Payload>() {}.type
            val payload: Payload = gson.fromJson(payloadIntent, payloadType)

            val keyPairGenerator = KeyPairGenerator()
            val sik: ChatKeyPair = hsm.secretServerIdentityKeyPair()
            val sikX: ChatKeyPair = hsm.secretX25519ServerIdentityKeyPair()
            val ik: ChatKeyPair = hsm.secretIdentityKeyPair()
            val chatId = AppSession.getUser().chatUserId
            keyPairGenerator.generateKeys(object : KeyPairGenerator.keysGenerated {
                override fun onKeysGenerated() {
                    list = keyPairGenerator.keyPairList
                    saveAllKeys(list, chatId, sik, sikX, ik, payload)
                }
            })
//            val list: ArrayList<ChatKeyPair> = gson.fromJson(listOfKeysGson, type)


        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun saveAllKeys(
        allKeys: ArrayList<ChatKeyPair>,
        chatId: String?,
        sik: ChatKeyPair,
        sikX: ChatKeyPair,
        ik: ChatKeyPair,
        payload: Payload
    ) {
        val model = ManifestModel()
        val keyPairGenerator = KeyPairGenerator()
        Log.e(TAG, "Keys Size ${allKeys.size}")
        Log.e(TAG, "SIK Key $sik")
        Log.e(TAG, "IK Key $ik")
        Log.e(TAG, "SIKx $sikX")

//        model.identityPubKey = ik.pubKey
//        model.identityPriKey = "test"
//        model.fingerprintPubKey = ik.identifier
//        model.expiry = 30
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
            TAG, "Private Key :::::" + hsm.secretKeyPair(allKeys[12].identifier)
        )

        try {
            callNetworkingAPI(chatId!!, model, sik, payload)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, " Exception in saving HSM ${e.printStackTrace()}")
        }

    }

    private fun callNetworkingAPI(
        chatId: String,
        model: ManifestModel,
        sik: ChatKeyPair,
        payload: Payload
    ) {
        uploadKeys(model, chatId, sik, payload)
    }


    private fun uploadKeys(
        model: ManifestModel,
        chatId: String,
        sik: ChatKeyPair,
        payload: Payload
    ) {

        val gson = Gson()
        val data = gson.toJson(model)


        val signature = EncryptionUtils.signSignature(
            data, Key.fromBase64String(sik.privKey)
        )

        val retrofitClient = RetrofitClient.createRetroCLient().create(APIInterface::class.java)
        val uploadOnKeyDeficiency = retrofitClient.uploadOnKeyDeficiency(
            data, chatId, signature
        )
        Log.e(TAG, "Signature:  $signature")
        if (!Utills.isSubscriptionExpired()) {
            if (Utills.isConnectedKds())
                uploadOnKeyDeficiency!!.enqueue(object : Callback<UploadKeysModel?> {
                    override fun onResponse(
                        call: Call<UploadKeysModel?>, response: Response<UploadKeysModel?>
                    ) {
                        if (response.isSuccessful) {
//                        SettingsValues.setKeyUploaded(true)
                            Log.e(TAG, "KEYS DEFICIENCY UPLOADED")
                            MainActivity.INSTANCE?.sendKeyDeficiencyAckConfirmation(payload)
                            ThreadUtil.runOnMainDelayed(
                                {
                                    stopSelf()
                                }, 1000

                            )
                        } else {
//                        SettingsValues.setKeyUploaded(false)
//                        val request = UploadKeyRequest()
//                        request.data = data
//                        request.chatId = chatId
//                        request.signature = signature
//                        SettingsValues.setKeysUploadRequest(gson.toJson(request))
//                        Log.e(TAG, "KEYS DID NOT UPLOADED")
                            stopSelf()
                        }
                    }

                    override fun onFailure(call: Call<UploadKeysModel?>, t: Throwable) {
                        t.printStackTrace()
//                    SettingsValues.setKeyUploaded(false)
                        Log.e(TAG, "onFailure KEYS DID NOT UPLOADED")
//                    val request = UploadKeyRequest()
//                    request.data = data
//                    request.chatId = chatId
//                    request.signature = signature
//                    SettingsValues.setKeysUploadRequest(gson.toJson(request))
                        stopSelf()
                    }
                })
            else {
//            SettingsValues.setKeyUploaded(false)
                Log.e(TAG, "Internet was not available")
//            val request = UploadKeyRequest()
//            request.data = data
//            request.chatId = chatId
//            request.signature = signature
//            SettingsValues.setKeysUploadRequest(gson.toJson(request))
            }
        }

    }


    override fun onBind(intent: Intent?): IBinder? {

        return null
    }

    override fun onDestroy() {
        isRunning = false
        super.onDestroy()
    }

    companion object {
        var isRunning = false


    }

}