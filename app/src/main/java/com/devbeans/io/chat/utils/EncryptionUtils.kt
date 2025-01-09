package com.devbeans.io.chat.utils

import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Base64.NO_WRAP
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import at.favre.lib.crypto.HKDF
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.box
import com.devbeans.io.chat.app.MainApp.Companion.ls
import com.devbeans.io.chat.crypto.encryptor.EncryptorAesGcmPasswordFile
import com.devbeans.io.chat.dependencies.ApplicationDependencies
import com.devbeans.io.chat.encryption.*
import com.devbeans.io.chat.extensions.*
import com.devbeans.io.chat.models.*
import com.devbeans.io.chat.models.SecretKey
import com.devbeans.io.chat.network.APIInterface
import com.devbeans.io.chat.network.EncryptedModel
import com.devbeans.io.chat.network.RetrofitClient
import com.devbeans.io.chat.network.serializers.response.KeyResponse
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import com.goterl.lazysodium.LazySodiumAndroid
import com.goterl.lazysodium.SodiumAndroid
import com.goterl.lazysodium.exceptions.SodiumException
import com.goterl.lazysodium.interfaces.SecretBox
import com.goterl.lazysodium.utils.Key
import com.goterl.lazysodium.utils.KeyPair
import com.virgilsecurity.keyknox.utils.Serializer.Companion.gson
import com.virgilsecurity.sdk.crypto.VirgilCrypto
import kotlinx.coroutines.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.security.*
import java.security.spec.InvalidKeySpecException
import java.security.spec.InvalidParameterSpecException
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.crypto.*
import javax.crypto.spec.PBEKeySpec
import kotlin.system.measureTimeMillis


@OptIn(DelicateCoroutinesApi::class)
object EncryptionUtils {
    var executor: Executor = Executors.newSingleThreadExecutor()
    var handler = Handler(Looper.getMainLooper())
    val TAG = Log.tag(EncryptionUtils::class.java)
    val mutableChannels by lazy { MutableLiveData<List<ConversationChannels>>() }
    val arrayListForSending = ArrayList<MappedPayload>()
    private const val ENCRYPT_ALGO = "AES/GCM/NoPadding"
    val payloadList = mutableListOf<Payload>()


    /**
     * Method which is used to Assymetric encrypt every message and send it to the server
     * and will be decrypted by the receiver only by #SIR (Session Initiation Request)
     */
    @OptIn(DelicateCoroutinesApi::class)
    fun encryptMessage(input: CharSequence?, payload: Payload, context: Context? = null) {
        MainApp.stopwatchOverAll = Stopwatch("Sending Encryption Time")
        MainApp.stopwatchOverAll?.split("Encryption started")
        if (!Utills.isSubscriptionExpired()) {
            ChatExecutors.SEND.execute {
                if (arrayListForSending.isNotEmpty()) {
                    arrayListForSending.clear()
                }

                val senderCallback = object : SenderCallback {
                    override fun returnChannels(channels: List<ConversationChannels>) {

                        val time = measureTimeMillis {
                            for (i in channels) {

                                sendMessage(payload.data!!, i, payload.aVRatchetKeyMaterial)
                            }
                        }
                        Log.e("Time", "After Payload Encryption time $time")
                        try {


                            payload.senderList = arrayListForSending


                            val time = measureTimeMillis {
                                val encPayload = encryptPayload(payload)!!
                                MainActivity.chatWebSocket?.sendMessage(encPayload)
                                MainApp.stopwatchOverAll?.split("Send WebSocket")
                                if (payload.isExpire) {

                                    if (payload.expireStarted == -1L) {
                                        payload.expireStarted = System.currentTimeMillis()
                                        MainApp.appContext?.messagesDao
                                            ?.updateMessage(Constants.SENT, payload.messageId)
                                        MainApp.appContext?.messagesDao?.updateExpireInTime(
                                            payload.messageId,
                                            payload.expireStarted
                                        )
                                    }

                                    val expirationManager =
                                        ApplicationDependencies.getExpiringMessageManager()
                                    expirationManager.scheduleDeletion(
                                        payload
                                    )
                                }
                            }
                            Log.e(
                                "Time",
                                "After encrypting for socket and sending socket time $time"
                            )
                            payload.status = Constants.SENT

                        } catch (e: Exception) {
                            Log.e(
                                TAG,
                                "Exception ${e.message} StackTrace ${e.printStackTrace()} Coroutine Exception ${e!!.message}"
                            )
                        }


                    }

                }

                Log.e(TAG, "Making Channels")
                Log.e("Time", "Making Channels")
                if (!Utills.isSubscriptionExpired()) {
                    makeChannels(payload, senderCallback)
                }

            }
        } else {
            Utills.showSubscriptionEnd()
        }

    }


    private fun sendMessage(
        message: String,
        channel: ConversationChannels,
        avRatchetKeyMaterial: String? = null
    ) {
        var channel = channel
        if (channel.ReceiveCounter == 0) {
            sendPreKeyMessage(channel, message, avRatchetKeyMaterial)
            return
        }
        Log.e(TAG, "\nChannel before sending ${gson.toJson(channel)}\n")
        Log.e(TAG, "\n Channel DHRachet before encrypt ${gson.toJson(channel?.DHRatchet)} \n")
        Log.e(
            TAG,
            "\n Channel DHRachet Pub Key before encrypt ${gson.toJson(channel?.DHRatchet!!.pubKey)} \n"
        )
        Log.e(
            TAG,
            "\n Channel DHRachet Prive Key before encrypt ${gson.toJson(channel.DHRatchet.privKey)} \n"
        )
        Log.e(TAG, "\n Channel Friend DH Key before encrypt ${gson.toJson(channel.FriendDHKey)} \n")

        val session = ChatSessionCipher(ReentrantSessionLock.INSTANCE, channel);
        channel = session.encrypt()
        val sendRatchet = channel.SendRatchet!!
        var (key, iv) = sendRatchet.nextKey()
        channel.SendRatchet = sendRatchet
        MainApp.appContext!!.conversationChannelsDao
            .updateSenderRatchet(channel.channelIdentifier!!, sendRatchet)
        val ciphertext = AESEncrypt(key, iv, message)!!
        key = "".toByteArray()
        iv = "".toByteArray()
        Log.e(TAG, "\nChannel after sending ${gson.toJson(channel)}\n")
        Log.e(TAG, "\n Channel DHRachet after encrypt ${gson.toJson(channel?.DHRatchet)} \n")
        Log.e(
            TAG,
            "\n Channel DHRachet Pub Key after encrypt ${gson.toJson(channel?.DHRatchet!!.pubKey)} \n"
        )
        Log.e(
            TAG,
            "\n Channel DHRachet Prive Key after encrypt ${gson.toJson(channel.DHRatchet.privKey)} \n"
        )
        Log.e(TAG, "\n Channel Friend DH Key after encrypt ${gson.toJson(channel.FriendDHKey)} \n")
        arrayListForSending.add(
            MappedPayload(
                recipientId = channel.channelWith!!,
                messageCipher = ciphertext!!,
                chainIndex = sendRatchet.chain_index,
                nextDHKey = channel.DHRatchet.pubKey!!,
                aVRatchetKeyMaterial = avRatchetKeyMaterial?.let { avRatchetKeyMaterial } ?: ""
            ))
//        hashmap[channel.channelWith!!] = MappedPayload(
//            messageCipher = ciphertext!!,
//            chainIndex = sendRatchet.chain_index,
//            nextDHKey = channel.DHRatchet.pubKey!!,
//            aVRatchetKeyMaterial = avRatchetKeyMaterial?.let { avRatchetKeyMaterial } ?: ""
//        )
        channel.SendCounter += 1
        MainApp.appContext!!.conversationChannelsDao
            .incrementSenderCount(channel.channelIdentifier!!)


    }


    private fun sendPreKeyMessage(
        channel: ConversationChannels,
        message: String,
        avRatchetKeyMaterial: String? = null
    ) {
        channel.SendCounter += 1
        Log.e(
            TAG,
            "Secret Sender Key: ${channel.SK!!.secretKey}  channel with ${channel.channelWith}"
        )
        MainApp.appContext!!.conversationChannelsDao
            .incrementSenderCount(channel.channelIdentifier!!)
        val sendRatchet = channel.SendRatchet
        var (key, iv) = sendRatchet!!.nextKey()
        channel.SendRatchet = sendRatchet
        MainApp.appContext!!.conversationChannelsDao
            .updateSenderRatchet(channel.channelIdentifier!!, sendRatchet)
        val ciphertext = AESEncrypt(key, iv, message)
        key = "".toByteArray()
        iv = "".toByteArray()

        //Sending without DHRatchet
//        hashmap[channel.channelWith!!] = MappedPayload(
//            messageCipher = ciphertext!!,
//            senderPubKey = channel.EK!!.pubKey!!,
//            recipientPubKeyFingerprint = channel.RecipientPubKey!!,
//            chainIndex = sendRatchet.chain_index
//        )

        //Sending with DHRatchet
        //Use property isDHRatchetEnable
        arrayListForSending.add(
            MappedPayload(
                recipientId = channel.channelWith!!,
                messageCipher = ciphertext!!,
                senderPubKey = channel.EK!!.pubKey!!,
                recipientPubKeyFingerprint = channel.RecipientPubKey!!,
                chainIndex = sendRatchet.chain_index,
                nextDHKey = channel.DHRatchet.pubKey!!,
                aVRatchetKeyMaterial = avRatchetKeyMaterial?.let { avRatchetKeyMaterial } ?: ""
            )
        )

//        hashmap[channel.channelWith!!] = MappedPayload(
//            messageCipher = ciphertext!!,
//            senderPubKey = channel.EK!!.pubKey!!,
//            recipientPubKeyFingerprint = channel.RecipientPubKey!!,
//            chainIndex = sendRatchet.chain_index,
//            nextDHKey = channel.DHRatchet.pubKey!!,
//            aVRatchetKeyMaterial = avRatchetKeyMaterial?.let { avRatchetKeyMaterial } ?: ""
//        )

        Log.e(
            TAG,
            "Hashhh  " + arrayListForSending.find { it.recipientId == channel.channelWith }
                .toString()
        )

    }

    /**
     * The Method for encrypting plain text into cipher text
     */
    @Throws(
        NoSuchAlgorithmException::class,
        NoSuchPaddingException::class,
        InvalidKeyException::class,
        InvalidParameterSpecException::class,
        IllegalBlockSizeException::class,
        BadPaddingException::class,
        UnsupportedEncodingException::class,
        SodiumException::class
    )
    fun AESEncrypt(key: ByteArray, iv: ByteArray, data: String): String? {
        /* Encrypt the message. */

        val sk = Key.fromBytes(key)
        return ls.cryptoSecretBoxEasy(data, iv, sk)
    }

    fun makeChannels(payload: Payload, senderCallback: SenderCallback) {


        val channelList = mutableListOf<ConversationChannels>()
        var checkAllMembersChannels = false
        val time = measureTimeMillis {
            if (!payload.conversationId.isNullOrEmpty() && !Utills.isSubscriptionExpired()) {
                val conversation =
                    MainApp.appContext?.conversationsDao?.getConversation(payload.conversationId)

                if (conversation != null && !Utills.isSubscriptionExpired()) {

                    if (!conversation.conversationMembers.isNullOrEmpty()) {
                        val memberslist: MutableList<String> = ArrayList()
                        val haveChannel: MutableList<String> = ArrayList()
                        for (s in conversation.conversationMembers!!) {
                            if (!MainApp.appContext!!.conversationChannelsDao
                                    .exist(Utills.getHash("${conversation.conversationId}&&${s.memberId}"))
                            ) {
                                checkAllMembersChannels = false
                                if (conversation.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS)) {
                                    if (!s.memberId.equals(
                                            conversation.myMoniker,
                                            ignoreCase = true
                                        )
                                    ) {
                                        memberslist.add("\"" + s.memberId + "\"")
                                    }
                                } else {
                                    if (!s.memberId.equals(
                                            AppSession.getUser().chatUserId,
                                            ignoreCase = true
                                        )
                                    ) {
                                        memberslist.add("\"" + s.memberId + "\"")
                                    }
                                }
                            } else {
                                checkAllMembersChannels = true
                                channelList.add(
                                    MainApp.appContext!!.conversationChannelsDao
                                        .getConversationChannel(Utills.getHash("${conversation.conversationId}&&${s.memberId}"))!!
                                )
                                haveChannel.add(s.memberId!!)

                            }
                        }

                        if (memberslist.isNotEmpty() && !Utills.isSubscriptionExpired()) {
                            val retrofitClient =
                                RetrofitClient.createRetroCLient()
                                    .create(APIInterface::class.java)
                            if (!conversation.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS)) {
                                val getEK = retrofitClient.getEK(
                                    AppSession.getUser().chatUserId!!,
                                    memberslist.toString(),
                                    conversation.conversationId!!
                                )
                                Log.e(TAG, "Getting EK IK Request ${getEK.request()} ")
                                getEK.enqueue(object : Callback<EncryptedModel> {
                                    override fun onResponse(
                                        call: Call<EncryptedModel>,
                                        response: Response<EncryptedModel>
                                    ) {
                                        try {
                                            Log.e(TAG, "Response : $response")
                                            if (response.code() == 200) {
                                                val res = response.body()
                                                val plainText = decryptRequest(res!!.data!!)
                                                val array: JSONArray = JSONArray(plainText)
                                                val keyResponseList = ArrayList<KeyResponse>()
                                                val gson = Gson()
                                                for (k in 0 until array.length()) {
                                                    keyResponseList.add(
                                                        gson.fromJson(
                                                            array[k].toString(),
                                                            KeyResponse::class.java
                                                        )
                                                    )
                                                }
                                                Log.e(
                                                    TAG,
                                                    "Key Response List $keyResponseList"
                                                )



                                                if (keyResponseList.isNotEmpty()) {
                                                    for (members in conversation.conversationMembers!!) {
                                                        val recipient = keyResponseList.find {
                                                            it.chat_user_id.equals(
                                                                members.memberId,
                                                                ignoreCase = true
                                                            )
                                                        }

                                                        if (recipient != null) {
                                                            if (haveChannel.isNotEmpty() && !haveChannel.contains(
                                                                    recipient.chat_user_id!!.toString()
                                                                )
                                                            ) {
                                                                val identifier =
                                                                    Utills.getHash("${conversation.conversationId}&&${members.memberId}")!!

                                                                if (!MainApp.appContext!!.conversationChannelsDao
                                                                        .exist(identifier)
                                                                ) {
                                                                    var channel =
                                                                        ConversationChannels(
                                                                            identifier,
                                                                            0
                                                                        )

                                                                    val time =
                                                                        measureTimeMillis {
                                                                            channel = DHKX(
                                                                                username = recipient.chat_user_id!!,
                                                                                recipient = recipient,
                                                                                channel = channel
                                                                            )
                                                                        }
                                                                    Log.e(
                                                                        "Time",
                                                                        "Time for each channel $time"
                                                                    )

                                                                    MainApp.appContext!!.conversationChannelsDao
                                                                        .insert(channel)
                                                                    channelList.add(channel)
                                                                }
                                                            } else if (haveChannel.isEmpty()) {
                                                                val identifier =
                                                                    Utills.getHash("${conversation.conversationId}&&${members.memberId}")!!

                                                                if (!MainApp.appContext!!.conversationChannelsDao
                                                                        .exist(identifier)
                                                                ) {
                                                                    var channel =
                                                                        ConversationChannels(
                                                                            identifier,
                                                                            0
                                                                        )

                                                                    val time =
                                                                        measureTimeMillis {
                                                                            channel = DHKX(
                                                                                username = recipient.chat_user_id!!,
                                                                                recipient = recipient,
                                                                                channel = channel
                                                                            )
                                                                        }
                                                                    Log.e(
                                                                        "Time",
                                                                        "Time after each channel $time"
                                                                    )
                                                                    MainApp.appContext!!.conversationChannelsDao
                                                                        .insert(channel)
                                                                    channelList.add(channel)
                                                                }
                                                            } else {
                                                                Log.e(
                                                                    TAG,
                                                                    "Was having channel ek ik for ${recipient.chat_user_id}"
                                                                )
                                                            }
//                                                        checkAllMembersChannels = false
                                                        } else {
                                                            Log.e(
                                                                TAG,
                                                                "recipient was null ${members.memberId}"
                                                            )
                                                        }
                                                    }
                                                    if (channelList.isNotEmpty()) {
                                                        senderCallback.returnChannels(
                                                            channelList
                                                        )
                                                        Log.e(TAG, "made channels")
                                                    } else {
                                                        Log.e(TAG, "channels list was empty")
                                                    }

                                                } else {

                                                    Log.e(TAG, "keyResponseList was empty")
                                                }
                                            } else {

                                                Log.e(TAG, "API failed")
                                                Log.e(TAG, response.toString())
                                            }
                                        } catch (e: Exception) {
                                            Log.e(
                                                TAG,
                                                "Exception in Response/Request Get EK/IK"
                                            )
                                            e.printStackTrace()
                                        }
                                    }

                                    override fun onFailure(
                                        call: Call<EncryptedModel>,
                                        t: Throwable
                                    ) {
                                        Log.e(TAG, "Exception in Response/Request Get EK/IK")
                                        t.printStackTrace()
                                    }
                                })
                            } else {

                                val getMonikerEK = retrofitClient.getMonikerEK(
                                    AppSession.getUser().chatUserId!!,
                                    memberslist.toString(),
                                    conversation.conversationId!!
                                )
                                Log.e(
                                    TAG,
                                    "Getting Moniker EK IK Request ${getMonikerEK.request()} "
                                )

                                getMonikerEK.enqueue(object : Callback<EncryptedModel> {
                                    override fun onResponse(
                                        call: Call<EncryptedModel>,
                                        response: Response<EncryptedModel>
                                    ) {
                                        try {
                                            Log.e(TAG, "Moniker Response : $response")
                                            if (response.code() == 200) {

                                                val res = response.body()

                                                val plainText = decryptRequest(res!!.data!!)
                                                val array: JSONArray = JSONArray(plainText)

                                                val keyResponseList = ArrayList<KeyResponse>()
                                                val gson = Gson()

                                                for (k in 0 until array.length()) {
                                                    keyResponseList.add(
                                                        gson.fromJson(
                                                            array[k].toString(),
                                                            KeyResponse::class.java
                                                        )
                                                    )
                                                }
                                                Log.e(
                                                    TAG,
                                                    "Key Response List $keyResponseList"
                                                )


                                                if (keyResponseList.isNotEmpty()) {
                                                    for (members in conversation.conversationMembers!!) {
                                                        val recipient = keyResponseList.find {
                                                            it.chat_user_id.equals(
                                                                members.memberId,
                                                                ignoreCase = true
                                                            )
                                                        }

                                                        if (recipient != null) {

                                                            if (haveChannel.isNotEmpty() && !haveChannel.contains(
                                                                    recipient.chat_user_id!!.toString()
                                                                )
                                                            ) {
                                                                val identifier =
                                                                    Utills.getHash("${conversation.conversationId}&&${members.memberId}")!!

                                                                if (!MainApp.appContext!!.conversationChannelsDao
                                                                        .exist(identifier)
                                                                ) {
                                                                    var channel =
                                                                        ConversationChannels(
                                                                            identifier,
                                                                            0
                                                                        )

                                                                    val time =
                                                                        measureTimeMillis {
                                                                            channel = DHKX(
                                                                                username = recipient.chat_user_id!!,
                                                                                recipient = recipient,
                                                                                channel = channel
                                                                            )
                                                                        }

                                                                    Log.e(
                                                                        "Time",
                                                                        "Time after each channel $time"
                                                                    )

                                                                    MainApp.appContext!!.conversationChannelsDao
                                                                        .insert(channel)
                                                                    channelList.add(channel)
                                                                }
                                                            } else if (haveChannel.isEmpty()) {
                                                                val identifier =
                                                                    Utills.getHash("${conversation.conversationId}&&${members.memberId}")!!

                                                                if (!MainApp.appContext!!.conversationChannelsDao
                                                                        .exist(identifier)
                                                                ) {
                                                                    var channel =
                                                                        ConversationChannels(
                                                                            identifier,
                                                                            0
                                                                        )

                                                                    val time =
                                                                        measureTimeMillis {
                                                                            channel = DHKX(
                                                                                username = recipient.chat_user_id!!,
                                                                                recipient = recipient,
                                                                                channel = channel
                                                                            )
                                                                        }
                                                                    Log.e(
                                                                        "Time",
                                                                        "Time after each channel $time"
                                                                    )
                                                                    MainApp.appContext!!.conversationChannelsDao
                                                                        .insert(channel)
                                                                    channelList.add(channel)
                                                                }
                                                            } else {
                                                                Log.e(
                                                                    TAG,
                                                                    "Was having channel ek ik for ${recipient.chat_user_id}"
                                                                )
                                                            }


//                                                        checkAllMembersChannels = false
                                                        } else {
                                                            Log.e(
                                                                TAG,
                                                                "recipient was null for ${members.memberId}"
                                                            )
                                                        }
                                                    }
                                                    if (channelList.isNotEmpty()) {
                                                        Log.e(
                                                            TAG,
                                                            "made channels ${
                                                                gson.toJson(
                                                                    channelList
                                                                )
                                                            }"
                                                        )
                                                        senderCallback.returnChannels(
                                                            channelList
                                                        )
                                                    } else {
                                                        Log.e(
                                                            TAG,
                                                            "channels were empty moniker"
                                                        )
                                                    }
                                                } else {
                                                    Log.e(TAG, "Key Response Moniker was null")
                                                }
                                            } else {
                                                Log.e(TAG, "API failed")
                                                Log.e(TAG, response.toString())
                                            }
                                        } catch (e: Exception) {
                                            Log.e(
                                                TAG,
                                                "Exception in Response/Request Get Moniker EK/IK"
                                            )
                                            Log.e(
                                                TAG,
                                                "${e.message}"
                                            )
                                            e.printStackTrace()
                                        }
                                    }

                                    override fun onFailure(
                                        call: Call<EncryptedModel>,
                                        t: Throwable
                                    ) {
                                        Log.e(
                                            TAG,
                                            "Exception in Response/Request Get Moniker EK/IK"
                                        )
                                        t.printStackTrace()
                                    }
                                })

                            }

                        } else {
//                           was being used recently
                        }

                        if (channelList.isNotEmpty() && memberslist.isEmpty() && !Utills.isSubscriptionExpired()) {
                            senderCallback.returnChannels(channelList)

                        } else {
                            Log.e(TAG, "channels were empty")
                        }
                    } else {
                        Log.e(TAG, "Conversation members were null in Database")
                    }

                } else {
                    Log.e(TAG, "Conversation was null in Database")
                }
            } else {
                Log.e(TAG, "Conversation did not have Con Id")
            }
        }
        Log.e("Time", "After Making Channels time $time")
    }

//    fun encryptMessage(
//        secreteKeyModel: SecreteKeyModel,
//        input: CharSequence,
//        payload: Payload,
//        context: Context
//    ) {
//
//        val time = System.currentTimeMillis()
//        val conversationExpiryTime = secreteKeyModel.expiry
//        val date1 = Date(time)
//        val date2 = Date(conversationExpiryTime)
//
//        secreteKeyModel.isExpired = date1.after(date2)
//
//        if (!secreteKeyModel.isExpired) {
//            val singleKey = secreteKeyModel.secreteKey
//            val secretKey = FileEncryptionUtils().reGererateKey(singleKey)
//
//            val rnd = SecureRandom()
//            val iv = ByteArray(12)
//            rnd.nextBytes(iv)
//            val ivParameter = IvParameterSpec(Constants.SALT_SYMMETRIC_PARAM)
//
//            val encryptedMessage = MessageEncrptionUtils.encryptMsg(
//                input.toString(),
//                secretKey,
//                ivParameter
//            )
////            payload.encrypted_data = encryptedMessage
//            payload.data = getEncodedString(encryptedMessage!!)
//            payload.secretModel = secreteKeyModel.identifier
////            payload.setIvByte(iv)
//            val encPayload = EncryptionUtils.encryptPayload(payload)!!
//            MainActivity.webSocket!!.send(encPayload)
//            payload.status = Constants.SENT
//            MainApp.appContext?.messagesDao?
//                .updateMessage(Constants.SENT, payload.messageId)
//        } else {
//            MainApp.database!!.SecreteKeyDao()!!.update(secreteKeyModel.secreteKey)
//            executor.execute {
//                if (context is ChatActivity) {
//                    context.CreateMainSymmeticHandshake(
//                        payload.conversationId!!,
//                        input,
//                        payload
//                    )
//                }
//            }
//        }
//
//
//    }


    fun offlineMessageConcept(
        input: CharSequence,
        payload: Payload,
        offlineMessage: OfflineMessage, context: Context
    ) {

        payload.status = Constants.NOT_DELIVERED

        offlineMessage.data = payload.data
        offlineMessage.userChatId = payload.userChatId
        offlineMessage.conversationId = payload.conversationId
        offlineMessage.type = payload.type
        offlineMessage.senderId = payload.senderId
        offlineMessage.messageId = payload.messageId
        offlineMessage.createdAt = payload.createdAt
        offlineMessage.createdAt = payload.createdAt
        offlineMessage.isExpire = payload.isExpire
        offlineMessage.conversationType = payload.conversationType
        offlineMessage.isCanShareForward =
            payload.isCanShareForward
        offlineMessage.isExpire =
            payload.isExpire
        offlineMessage.msg_expiry_time =
            payload.msgExpiryTime
        offlineMessage.isForwarded = payload.isForwarded


//        if (secreteKeyModel.isNotEmpty()) {
        MainApp.appContext!!.offlineMessagesDao.insert(offlineMessage)
//                payload.status = Constants.SENT
//        } else {

//            executor.execute {
//                if (context is ChatActivity) {
//                    context.CreateMainSymmeticHandshake(
//                        payload.conversationId!!,
//                        input,
//                        payload
//                    )
//                }
//            }
//        }
    }


    public fun getDecodedBytes(encodedString: String): ByteArray {
        return android.util.Base64.decode(
            encodedString,
            android.util.Base64.DEFAULT
        )
    }

    fun getEncodedString(decodedBytes: ByteArray): String {
        return android.util.Base64.encodeToString(decodedBytes, NO_WRAP)
    }

    /**
     * Will encrypt the payload [payloadToEncrypt] to sent to server
     * which is given top the user on the time of register user in [com.devbeans.io.chat.activities.CustomSplashActivity]
     */
    fun encryptPayload(payloadToEncrypt: Payload): String? {
        return try {
            val gson = Gson()
            val data = PayloadFilter.getPayLoad(payloadToEncrypt!!)


            val hsm = HSM.with();
            val keypair = KeyPair(
                Key.fromBase64String(AppSession.getUser().publicKey),
                Key.fromBase64String(hsm.secretX25519ServerIdentityKeyPair().privKey)
            )

            val cipher = box.cryptoBoxEasy(data, Constants.NONCE, keypair)
            val encryptedPaulod = EncryptedPayload()
            encryptedPaulod.data = cipher
            encryptedPaulod.fake = AppSession.getUser().chatUserId
            gson.toJson(encryptedPaulod)
        } catch (e: Exception) {
            Log.e(TAG, "${e.printStackTrace()}")
            null
        }
    }


    /**
     * Will encrypt the payload [requestToEncrypt] to sent to server
     * which is given top the user on the time of API call [com.devbeans.io.chat.network.ApiHelper]
     */
    fun encryptRequest(requestToEncrypt: String): String? {
        return try {
            val hsm = HSM.with();
            val keypair = KeyPair(
                Key.fromBase64String(AppSession.getUser().publicKey),
                Key.fromBase64String(hsm.secretX25519ServerIdentityKeyPair().privKey)
            )
            val cipher = box.cryptoBoxEasy(requestToEncrypt, Constants.NONCE, keypair)
            cipher
        } catch (e: Exception) {
            Log.e(TAG, "${e.printStackTrace()}")
            null
        }
    }


    fun decryptRequest(encryptedPayload: EncryptedPayload): String? {
        return try {
            val time = measureTimeMillis {
                if (encryptedPayload.data != null) {
                    val gson = Gson()


                    val cipher = ls.sodiumBin2Hex(getDecodedBytes(encryptedPayload.data))
                    val hsm = HSM.with()
                    val keypair = KeyPair(
                        Key.fromBase64String(AppSession.getUser().publicKey),
                        Key.fromBase64String(hsm.secretX25519ServerIdentityKeyPair().privKey)
                    )

                    val plaintext = box.cryptoBoxOpenEasy(
                        cipher,
                        Constants.NONCE,
                        keypair
                    )
                    val identityKeyPair =
                        MainApp.appContext!!.identityKeyPairDao
                            .allKeys


                    return plaintext
                }
            }
            Log.e("Time", "After decrypting request time $time")
            return null
        } catch (e: Exception) {
            Log.e(TAG, e.message)
            return null
        }

    }

    /**
     * Will encrypt the payload [payloadToEncrypt] to sent to server
     * which is given top the user on the time of register user in [com.devbeans.io.chat.activities.CustomSplashActivity]
     */
    fun encryptOfflinePayload(payloadToEncrypt: OfflineMessage): String? {
        return try {
            val gson = Gson()
            val data = gson.toJson(payloadToEncrypt)
            val virgilCrypto = VirgilCrypto()
            val virgilPublicKey =
                virgilCrypto.importPublicKey(getDecodedBytes(AppSession.getUser().publicKey!!))
            val byte = data.toByteArray()
            val thk = virgilCrypto.encrypt(byte, virgilPublicKey)
            getEncodedString(thk)
            val encryptedPayload = EncryptedPayload()

            val hsm = HSM.with();
            val keypair = KeyPair(
                Key.fromBase64String(AppSession.getUser().publicKey),
                Key.fromBase64String(hsm.secretIdentityKeyPair().privKey)
            )
            //TODO
            val cipher = box.cryptoBoxEasy(data, Constants.NONCE, keypair)
            encryptedPayload.data = getEncodedString(thk)
            encryptedPayload.fake = AppSession.getUser().chatUserId
            gson.toJson(encryptedPayload)
        } catch (e: Exception) {
            Log.e(MainApp.TAG, "${e.printStackTrace()}")
            null
        }
    }

    @Throws(
        GeneralSecurityException::class,
        IllegalArgumentException::class,
        Exception::class
    )
    fun hkdf(inp: String, length: Int?, salt: String = ""): ByteArray {
        val stopwatch = Stopwatch("HKDF Key")
        stopwatch.split("Hkdf start")
        val hkdf = HKDF.fromHmacSha256()

        //if salt is not given will add empty string as salt
        val saltInp = salt.ifEmpty { "" }
        val lengthInp = if (length != null && length > 0) length else 80
        val info = ""

        //extract the "raw" data to create output with concentrated entropy
        val pseudoRandomKey = hkdf.extract(
            saltInp.toByteArray(StandardCharsets.UTF_8),
            inp.toByteArray(StandardCharsets.UTF_8)
        )

        //Returning particular length derivated key with Hmac Algorithm
        stopwatch.split("Hkdf returning hkdf done")
        stopwatch.stop(Stopwatch.TAG)
        return hkdf.expand(
            pseudoRandomKey,
            info.toByteArray(StandardCharsets.UTF_8),
            lengthInp
        )
    }


    fun signSignature(message: String, secret: Key): String {
        return ls.cryptoSignDetached(message, secret)
    }

    fun verifySignSignature(data: String, signature: String, pubKey: Key): Boolean {
        return ls.cryptoSignVerifyDetached(signature, data, pubKey)
    }

    /**
     * Will decrypt the payload[encryptedPayload] given from Server
     * on the basis of identity key
     */
    fun decryptPayload(encryptedPayload: String, ReceiverCallback: ReceiverCallback) {

        return try {
            val stopwatchInDecrypt = Stopwatch("Decrypting server to client")
            stopwatchInDecrypt.split("Decryption Started")
            val gson = Gson()
            val data = gson.fromJson(encryptedPayload, EncryptedPayload::class.java)


            val cipher = ls.sodiumBin2Hex(getDecodedBytes(data.data))
            val hsm = HSM.with()

            val hsmPrivateKey = hsm.secretX25519ServerIdentityKeyPair().privKey
            val keypair = KeyPair(
                Key.fromBase64String(AppSession.getUser().publicKey),
                Key.fromBase64String(hsmPrivateKey)
            )
            //TODO
            val plaintext = box.cryptoBoxOpenEasy(
                cipher,
                Constants.NONCE,
                keypair
            )


            val decryptedPayload = gson.fromJson(
                plaintext,
                Payload::class.java
            )
            stopwatchInDecrypt.split("Plain Text Payload Done")
            Log.e(MainActivity.TAG, " Decrypted Plain Text $plaintext")


//            CoroutineScope(Dispatchers.IO).launch(handler) {
            if (checkTextPayload(decryptedPayload)) {
                payloadList.add(decryptedPayload)
                val time = measureTimeMillis {
                    checkChannelEstablished(
                        decryptedPayload,
                        ReceiverCallback
                    )
                    stopwatchInDecrypt.split("Sent to Checking Channel")
                    stopwatchInDecrypt.stop(Stopwatch.TAG)
                }
                Log.e("Time", "Time after creating for receiving channel $time")
//                Log.e(
//                    TAG, "Payload List Size${
//                        payloadList
//                            .size
//                    }"
//                )
            } else {
                ReceiverCallback.returnPayload(decryptedPayload)
            }

        } catch (e: Exception) {
            Log.e(TAG, "Received Exception ")
            Log.e(TAG, e.message)
            ReceiverCallback.returnPayload(null)
        }
    }

    private fun checkChannelEstablished(
        decryptedPayload: Payload,
        ReceiverCallback: ReceiverCallback
    ) {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.e(TAG, "CoroutineExceptionHandler got $exception")
            ReceiverCallback.returnPayload(null)
        }
        if (decryptedPayload.userChatId != null && decryptedPayload.conversationId != null && decryptedPayload.conversationType != null) {
//            GlobalScope.launch(handler) {
            checkChannel(
                channel_identifier = Utills.getHash("${decryptedPayload.conversationId}&&${decryptedPayload.userChatId}"),
                channel_with = decryptedPayload.userChatId!!,
                conversation_type = decryptedPayload.conversationType!!,
                conversation_id = decryptedPayload.conversationId!!,
                payload = decryptedPayload,
                ReceiverCallback = ReceiverCallback
            )
//            }
        } else {
            ReceiverCallback.returnPayload(null)
        }
    }

    fun checkTextPayload(actualPayload: Payload): Boolean {
        return (actualPayload.type != null && (actualPayload.type.equals(
            Constants.TYPES.TEXT, ignoreCase = true
        ) || actualPayload.type.equals(
            Constants.TYPES.FILE, ignoreCase = true
        ) || actualPayload.type.equals(
            Constants.TYPES.AUDIO, ignoreCase = true
        ) || actualPayload.type.equals(
            Constants.TYPES.VIDEO, ignoreCase = true
        ) || actualPayload.type.equals(
            Constants.TYPES.IMAGE, ignoreCase = true
        ) || actualPayload.type.equals(
            Constants.TYPES.EDIT, ignoreCase = true
        )))
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(java.lang.Exception::class)
    fun encryptFile(fromFile: String?, toFile: String?, key: String?) {

        // read a normal txt file
        val fileContent: ByteArray = Files.readAllBytes(Paths.get(File(fromFile!!).toURI()))

        // encrypt with a password
//        AESEncrypt(key,Constants.NONCE,fileContent)
        val password: javax.crypto.SecretKey = getSecretKey(key)!!
        val encryptedText = EncryptorAesGcmPasswordFile.encrypt(fileContent, password)


        // save a file
        val path: Path = Paths.get(toFile)

//        Path output = Files.write(path, encryptedText);
        Files.write(path, encryptedText)

    }


    fun getSecretKey(secretKey: String?): javax.crypto.SecretKey? {
        val hash = ls.toHexStr(getDecodedBytes(secretKey!!))
        val spec =
            PBEKeySpec(
                hash.toCharArray(),
                Constants.IVSALT,
                1,
                AES.AES_KEY_SIZE
            )
        var secKey: javax.crypto.SecretKey? = null
        try {
            secKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(spec)
        } catch (e: InvalidKeySpecException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return secKey
    }


    private fun checkChannel(
        channel_identifier: String?,
        channel_with: String,
        conversation_type: String,
        conversation_id: String,
        payload: Payload,
        ReceiverCallback: ReceiverCallback
    ) {
        if (!MainApp.appContext!!.conversationChannelsDao.exist(channel_identifier)) {

            val membersList: MutableList<String> = ArrayList()
            membersList.add("\"" + channel_with + "\"")
            val retrofitClient =
                RetrofitClient.createRetroCLient().create(APIInterface::class.java)
            if (!conversation_type.equals(
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                    ignoreCase = true
                )
            ) {
                val getIK = retrofitClient.getIK(
                    AppSession.getUser().chatUserId!!,
                    membersList.toString(),
                    conversation_id
                )
                getIK.enqueue(object : Callback<EncryptedModel> {
                    override fun onResponse(
                        call: Call<EncryptedModel>,
                        response: Response<EncryptedModel>
                    ) {
                        try {

                            if (response.code() == 200) {

                                val res = response.body()

                                val plainText = decryptRequest(res!!.data!!)
                                val array: JSONArray = JSONArray(plainText)

                                val keyResponseList = ArrayList<KeyResponse>()
                                val gson = Gson()

                                for (k in 0 until array.length()) {
                                    keyResponseList.add(
                                        gson.fromJson(
                                            array[k].toString(),
                                            KeyResponse::class.java
                                        )
                                    )
                                }
                                Log.e(
                                    TAG,
                                    "Identity Key Response List $keyResponseList"
                                )


                                if (keyResponseList.isNotEmpty()) {
                                    Log.e(TAG, "ajshcvjahc")
                                    val recipient = keyResponseList.find {
                                        it.chat_user_id.equals(
                                            channel_with,
                                            ignoreCase = true
                                        )
                                    }

                                    if (recipient != null) {
                                        var channel = ConversationChannels(
                                            channel_identifier!!,
                                            1
                                        )

                                        channel = DHKX(
                                            username = recipient.chat_user_id!!,
                                            EK = payload.senderPubKey,
                                            EP = payload.recipientPubKeyFingerprint,
                                            recipient = recipient,
                                            channel = channel
                                        )

                                        MainApp.appContext!!.conversationChannelsDao
                                            .insert(channel)

                                        Log.e(
                                            TAG,
                                            "Channel which is Generated ${Gson().toJson(channel)}"
                                        )
                                        ReceiverCallback.returnPayload(payload)

                                    } else {
                                        Log.e(TAG, "ajshcvjahc")
                                    }

                                }
                            } else {
                                Log.e(TAG, "failed")
                                Log.e(TAG, response.toString())
                                ReceiverCallback.returnPayload(null)
                            }

                        } catch (e: Exception) {
                            e.printStackTrace()
                            ReceiverCallback.returnPayload(null)
                        }
                    }

                    override fun onFailure(
                        call: Call<EncryptedModel>,
                        t: Throwable
                    ) {
                        t.printStackTrace()
                        ReceiverCallback.returnPayload(null)
                    }
                })
            } else {

                val getMonikerIk = retrofitClient.getMonikerIK(
                    AppSession.getUser().chatUserId!!,
                    membersList.toString(),
                    conversation_id
                )
                getMonikerIk.enqueue(object : Callback<EncryptedModel> {
                    override fun onResponse(
                        call: Call<EncryptedModel>,
                        response: Response<EncryptedModel>
                    ) {
                        try {

                            if (response.code() == 200) {

                                val res = response.body()

                                val plainText = decryptRequest(res!!.data!!)
                                val array: JSONArray = JSONArray(plainText)

                                val keyResponseList = ArrayList<KeyResponse>()
                                val gson = Gson()

                                for (k in 0 until array.length()) {
                                    keyResponseList.add(
                                        gson.fromJson(
                                            array[k].toString(),
                                            KeyResponse::class.java
                                        )
                                    )
                                }
                                Log.e(
                                    TAG,
                                    "Moniker Key Response List $keyResponseList"
                                )


                                if (keyResponseList.isNotEmpty()) {
                                    Log.e(TAG, "ajshcvjahc")
                                    val recipient = keyResponseList.find {
                                        it.chat_user_id.equals(
                                            channel_with,
                                            ignoreCase = true
                                        )
                                    }

                                    if (recipient != null) {
                                        var channel = ConversationChannels(
                                            channel_identifier!!,
                                            1
                                        )


                                        channel = DHKX(
                                            username = recipient.chat_user_id!!,
                                            EK = payload.senderPubKey,
                                            EP = payload.recipientPubKeyFingerprint,
                                            recipient = recipient,
                                            channel = channel
                                        )

                                        MainApp.appContext!!.conversationChannelsDao
                                            .insert(channel)

                                        ReceiverCallback.returnPayload(payload)
                                    } else {
                                        Log.e(TAG, "ajshcvjahc")
                                    }

                                }
                            } else {
                                Log.e(TAG, "failed")
                                Log.e(TAG, response.toString())
                                ReceiverCallback.returnPayload(null)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                            ReceiverCallback.returnPayload(null)
                        }
                    }

                    override fun onFailure(
                        call: Call<EncryptedModel>,
                        t: Throwable
                    ) {
                        t.printStackTrace()
                        ReceiverCallback.returnPayload(null)
                    }
                })

            }


        } else {
            val stopwatch = Stopwatch("Checked channel in DB")
            stopwatch.split("Checking channel")
            ReceiverCallback.returnPayload(payload)
            stopwatch.stop(Stopwatch.TAG)
        }
    }


    /**
     * Will decrypt the payload[encryptedPayload] given from Server
     * on the basis of identity key
     */
    fun decryptRequest(encryptedPayload: String): String? {

        return try {
            val gson = Gson()
            val cipher = ls.sodiumBin2Hex(getDecodedBytes(encryptedPayload))
            val hsm = HSM.with()
            val privateKeyFromHsm = hsm.secretX25519ServerIdentityKeyPair().privKey
            val keypair = KeyPair(
                Key.fromBase64String(AppSession.getUser().publicKey),
                Key.fromBase64String(privateKeyFromHsm)
            )

            //TODO
            val plaintext = box.cryptoBoxOpenEasy(
                cipher,
                Constants.NONCE,
                keypair
            )


            return plaintext
        } catch (e: Exception) {
            Log.e(TAG, e.message)
            return null
        }
    }

    fun DHKX(
        username: String,
        EP: String? = null,
        EK: String? = null,
        recipient: KeyResponse,
        channel: ConversationChannels
    ): ConversationChannels {

        val hsm = HSM.with()
        val keypairGenerator = KeyPairGenerator()
        val sender_identity_key = hsm.secretIdentityKeyPair()

        channel.channelWith = username

        //OPK in case of Receving
        val sender_ephemeral_key = EP?.let {
            hsm.secretKeyPair(EP)
        } ?: keypairGenerator.generateKeyPair(channel.channelIdentifier!!)

        if (EP.isNullOrEmpty()) {
            val ek = EK(
                sender_ephemeral_key.identifier
            )
            ek.pubKey = sender_ephemeral_key.pubKey
            ek.privKey = sender_ephemeral_key.privKey
            channel.EK = ek
        }
        //Getting IK of who sent message from KDS
        val recepient_identity_pubkey = recipient.ik

        val recepient_opk_pubkey = recipient.ek?.let {
            recipient.ek
        } ?: EK

        channel.RecipientPubKey = recipient.keyFingerprint

        val dh1 = KeyExchange.exchange(
            sender_identity_key.privKey,
            recepient_opk_pubkey!!
        )
        val dh2 = KeyExchange.exchange(
            sender_ephemeral_key.privKey,
            recepient_identity_pubkey!!
        )
        val dh3 = KeyExchange.exchange(
            sender_ephemeral_key.privKey,
            recepient_opk_pubkey
        )

        val sk: ByteArray = if (channel.FlipRatchetDirection == 1) {
            hkdf(getEncodedString(dh2 + dh1 + dh3), 32)
        } else {
            hkdf(getEncodedString(dh1 + dh2 + dh3), 32)
        }

        val secretKey = SecretKey(channel.channelIdentifier!!)
        secretKey.secretKey = getEncodedString(sk)
        Log.e(TAG, "Secret Key: ${getEncodedString(sk)}")
        channel.SK = secretKey
        channel.initRatchets()
        channel.cacheRatchet = channel.RecvRatchet
        return channel
    }

    fun decryptPayloadWithChannel(
        decryptedPayload: Payload,
        callback: ReceiverCallback?
    ): Payload? {
        try {
            if (checkTextPayload(decryptedPayload)) {

                if (payloadCheckChannelMaterial(decryptedPayload)) {
                    val stopwatch = Stopwatch("Decrypting with Channel")
                    stopwatch.split("checked channel start")
                    val channel_identifier =
                        Utills.getHash("${decryptedPayload.conversationId}&&${decryptedPayload.userChatId}")
                    if (MainApp.appContext!!.conversationChannelsDao.exist(channel_identifier)) {
                        stopwatch.split("checked channel done")
                        var channel = MainApp.appContext!!.conversationChannelsDao
                            .getConversationChannel(channel_identifier)
                        stopwatch.split("got channel from DB")
                        Log.e(TAG, "Channel checked ${gson.toJson(channel)} \n")
                        Log.e(
                            TAG,
                            "\n Channel DHRachet before decrypt ${gson.toJson(channel?.DHRatchet)} \n"
                        )
                        Log.e(
                            TAG,
                            "\n Channel DHRachet Pub Key before decrypt ${gson.toJson(channel?.DHRatchet!!.pubKey)} \n"
                        )
                        Log.e(
                            TAG,
                            "\n Channel DHRachet Prive Key before decrypt ${gson.toJson(channel.DHRatchet.privKey)} \n"
                        )
                        Log.e(
                            TAG,
                            "\n Channel Friend DH Key before decrypt ${gson.toJson(channel.FriendDHKey)} \n"
                        )
                        stopwatch.split("Checking counters start")
                        if (channel!!.ReceiveCounter == 0 && channel.SendCounter == 0) {
                            channel.ReceiveCounter += 1
                            MainApp.appContext!!.conversationChannelsDao
                                .incrementReceiveCount(channel_identifier!!)
                            return receivePreKeyMessage(channel, decryptedPayload!!)
                        }
                        stopwatch.split("Checking counters done")
                        if (!decryptedPayload.nextDHKey.isNullOrEmpty()) {
                            val session = ChatSessionCipher(ReentrantSessionLock.INSTANCE, channel);
                            channel = session.decrypt(decryptedPayload.nextDHKey!!)

                        }

                        val ciphertext = decryptedPayload.data
                        val recvRatchet = channel?.RecvRatchet
                        var (key, iv) = recvRatchet!!.nextKey()
                        var message = AESDecrypt(key, iv, ciphertext)
                        stopwatch.split("Cipher decrypted")
                        key = "".toByteArray()
                        iv = "".toByteArray()
                        Log.e(
                            TAG,
                            "\n \n[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ Message = $message ]]]]]]]]]]]]]]]]]]]]]]]]\n \n "
                        )

                        if (message != null) {
                            MainApp.appContext!!.conversationChannelsDao.update(channel)
                            stopwatch.split("Channel updated in DB")
                        } else {
                            Log.e(
                                TAG,
                                "The Index was not same payload index: ${decryptedPayload.chainIndex} rachet index: ${recvRatchet.chain_index}"
                            )
                            channel?.preCacheRatchet()

                            val ciphertext = decryptedPayload.data
                            val recvRatchet = channel?.RecvRatchet
                            var (key, iv) = recvRatchet!!.nextKey()
                            message = AESDecrypt(key, iv, ciphertext)
                            key = "".toByteArray()
                            iv = "".toByteArray()
                            Log.e(TAG, "preCacheRatchet")
                            if (message != null) {

                                MainApp.appContext!!.conversationChannelsDao
                                    .updateReceiverRatchet(
                                        channel?.channelIdentifier!!,
                                        recvRatchet
                                    )
                                channel.RecvRatchet = recvRatchet
                                channel.ReceiveCounter += 1
                                MainApp.appContext!!.conversationChannelsDao
                                    .incrementReceiveCount(channel_identifier!!)
                            } else {


                                Log.e(TAG, "\nCould not decrypt ${gson.toJson(channel)}\n")
                            }


                        }

                        decryptedPayload.data = message


                        Log.e(TAG, "\n Channel after decrypt ${gson.toJson(channel)} \n")
                        Log.e(
                            TAG,
                            "\n Channel DHRachet after decrypt ${gson.toJson(channel?.DHRatchet)} \n"
                        )
                        Log.e(
                            TAG,
                            "\n Channel DHRachet Pub Key after decrypt ${gson.toJson(channel?.DHRatchet?.pubKey)} \n"
                        )
                        Log.e(
                            TAG,
                            "\n Channel DHRachet Prive Key after decrypt ${gson.toJson(channel?.DHRatchet?.privKey)} \n"
                        )
                        Log.e(
                            TAG,
                            "\n Channel Friend DH Key after decrypt ${gson.toJson(channel?.FriendDHKey)} \n"
                        )
                        stopwatch.split("Returned to Handling message")
                        stopwatch.stop(Stopwatch.TAG)
                        return decryptedPayload
                    } else {
                        Log.e(TAG, "Did not had Channel")
                        val handler = CoroutineExceptionHandler { _, exception ->
                            Log.e(TAG, "CoroutineExceptionHandler got $exception")
                        }
//                    CoroutineScope(Dispatchers.IO).launch(handler) {
                        if (callback != null) {
                            CoroutineScope(Dispatchers.IO).launch(handler) {
                                checkChannel(
                                    channel_identifier = channel_identifier,
                                    channel_with = decryptedPayload.userChatId!!,
                                    conversation_type = decryptedPayload.conversationType!!,
                                    conversation_id = decryptedPayload.conversationId!!,
                                    payload = decryptedPayload,
                                    ReceiverCallback = callback
                                )
                            }
                        }
//                    }
                    }
                } else {
                    Log.e(TAG, "Did not had Channel material in PAYLOAD")
                }
            }

            return decryptedPayload
        } catch (e: Exception) {
            Log.e(TAG, "Going in Exception ${e.printStackTrace()} ${e.message}")
            return null
        }
    }

    fun payloadCheckChannelMaterial(decryptedPayload: Payload): Boolean =
        decryptedPayload.userChatId != null && decryptedPayload.conversationId != null && decryptedPayload.conversationType != null

    private fun receivePreKeyMessage(channel: ConversationChannels, payload: Payload): Payload {
        val ciphertext = payload.data
        val recvRatchet = channel.RecvRatchet
        var (key, iv) = recvRatchet!!.nextKey()
        var message = AESDecrypt(key, iv, ciphertext)
        key = "".toByteArray()
        iv = "".toByteArray()
        Log.e(
            TAG,
            "\n \n[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ Message = $message ]]]]]]]]]]]]]]]]]]]]]]]]\n \n "
        )
        if (message != null) {
            MainApp.appContext!!.conversationChannelsDao
                .updateReceiverRatchet(channel.channelIdentifier!!, recvRatchet)
            channel.RecvRatchet = recvRatchet
        } else {
            Log.e(
                TAG,
                "The Index was not same payload index: ${payload.chainIndex} rachet index: ${recvRatchet.chain_index}"
            )
            if (payload.chainIndex > recvRatchet.chain_index) {
                var (key, iv) = kotlin.Pair(byteArrayOf(), byteArrayOf())
                for (i in recvRatchet.chain_index until payload.chainIndex) {
                    val (fKey, fIv) = recvRatchet.nextKey()
                    key = fKey
                    iv = fIv
                }
                Log.e(
                    TAG,
                    "The Index is same payload index: ${payload.chainIndex} rachet index: ${recvRatchet.chain_index}"
                )
                message = AESDecrypt(key, iv, ciphertext)
                key = "".toByteArray()
                iv = "".toByteArray()


            }
        }
        if (!payload.nextDHKey.isNullOrEmpty()) {
            if (channel.FriendDHKey == null || !payload.nextDHKey.equals(
                    channel.FriendDHKey,
                    ignoreCase = true
                )
            ) {
                channel.FriendDHKey = payload.nextDHKey
                MainApp.appContext!!.conversationChannelsDao
                    .updateFriendDHKey(channel.channelIdentifier!!, channel.FriendDHKey!!)
                Log.e(TAG, "PreReceive Previous Friend DH Key ${channel.FriendDHKey}")
                Log.e(TAG, "PreReceive Next DH Key ${payload.nextDHKey}")
            } else {
                Log.e(TAG, "check Failed Friend DH Key ${payload.nextDHKey}")
            }
        } else {
            Log.e(TAG, "check Failed NextDhKey ${payload.nextDHKey}")
        }
        payload.data = message
        return payload
    }

    /**
     * Method for decrypting ciphertext ByteArray into Plaintext String
     */
    @Throws(
        NoSuchPaddingException::class,
        NoSuchAlgorithmException::class,
        InvalidParameterSpecException::class,
        InvalidAlgorithmParameterException::class,
        InvalidKeyException::class,
        BadPaddingException::class,
        IllegalBlockSizeException::class,
        UnsupportedEncodingException::class
    )
    fun AESDecrypt(
        key: ByteArray,
        iv: ByteArray,
        ciphertext: String?
    ): String? {
        /* Decrypt the message, given derived encContentValues and initialization vector. */
        return try {

            val ls = LazySodiumAndroid(SodiumAndroid())
            val box = ls as SecretBox.Lazy
            val sk = Key.fromBytes(key)

            val decrypted: String = ls.cryptoSecretBoxOpenEasy(ciphertext, iv, sk)
            decrypted
        } catch (e: Exception) {
            e.printStackTrace()
            android.util.Log.e(TAG, e.message.toString())
            null
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(java.lang.Exception::class)
    fun decryptFile(fromFile: String, avRatchetKeyMaterial: String): Boolean {

        var isDecrypted = false
        try {       // read a normal txt file
            val fileEncryptedContent: ByteArray =
                Files.readAllBytes(Paths.get(File(fromFile).toURI()))

            val password: javax.crypto.SecretKey = getSecretKey(avRatchetKeyMaterial)!!
            val encryptedText = EncryptorAesGcmPasswordFile.decryptFile(fromFile, password)


            // save a file
            val path: Path = Paths.get(fromFile)

            Files.write(path, encryptedText)

            isDecrypted = true
        } catch (e: Exception) {
            isDecrypted = false
            Log.e(
                TAG,
                "Error in Decrypting a file ${e.message} error trace ${e.printStackTrace()}"
            )

        }

        return isDecrypted
    }

    fun encryptDataDownload(data: String): String {

        val hsm = HSM.with();
        val keypair = KeyPair(
            Key.fromBase64String(AppSession.getUser().publicKey),
            Key.fromBase64String(hsm.secretX25519ServerIdentityKeyPair().privKey)
        )

        val cipher = box.cryptoBoxEasy(data, Constants.NONCE, keypair)

        return cipher?.let { cipher } ?: ""
    }

    fun sendDeletePayload(payload: Payload) {
        val conversation =
            MainApp.appContext?.conversationsDao?.getConversation(payload.conversationId)
        val arrayListDelete = ArrayList<MappedPayload>()
        conversation?.let {
            conversation.conversationMembers?.let {
                val members = conversation.conversationMembers
                if (conversation.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS)) {
                    members?.forEach { member ->
                        if (!member.memberId.equals(conversation.myMoniker)) {
                            arrayListDelete.add(
                                MappedPayload(
                                    recipientId = member.memberId!!,
                                    messageCipher = "This message was deleted.",
                                    chainIndex = 0,
                                    nextDHKey = "",
                                    aVRatchetKeyMaterial = ""
                                )
                            )
                        }
                    }
                } else {
                    members?.forEach { member ->
                        if (!member.memberId.equals(AppSession.getUser().chatUserId)) {

                            arrayListDelete.add(
                                MappedPayload(
                                    recipientId = member.memberId!!,
                                    messageCipher = "This message was deleted.",
                                    chainIndex = 0,
                                    nextDHKey = "",
                                    aVRatchetKeyMaterial = ""
                                )
                            )

                        }
                    }

                }
//                payload.hashmap = hashMapDelete

                payload.senderList = arrayListDelete
                val encPayload = encryptPayload(payload)
                MainActivity.chatWebSocket?.sendMessage(encPayload)
            } ?: run {
                Log.e(TAG, "members check failed")
            }
        } ?: {
            Log.e(TAG, "Conversation Check failed")
        }
    }

    fun sendOpenedAck(message: Payload?, conversation: Conversation?) {
        Log.e(TAG, "Sending View Once Ack")

        message?.let {
            conversation?.let {
                if (!conversation.isRemoved) {
                    var isOneToOne = false
                    var isContact = false
                    if (conversation!!.conversationType.equals(
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
                        )
                    ) {
                        isOneToOne = true
                        var receiverId: String? = null
                        val receiver = conversation?.conversationMembers?.find { member ->
                            !member.memberId.equals(AppSession.getUser().chatUserId)
                        }
                        receiver?.let {
                            receiverId = it.memberId
                        }
                        Utills.checkContactNull(receiverId)?.let {
                            isContact = true
                        }

                    }
                    val payload1 = Payload()
                    payload1.type = Constants.TYPES.ACK_IS_VIEW_ONCE
                    payload1.conversationId = message.conversationId
                    payload1.conversationType = message.conversationType
                    payload1.messageId = message.messageId
                    payload1.createdAt = message.createdAt
//                    payload1.data = payload.encrypted_data.contentToString()
                    payload1.senderId = message.senderId
                    payload1.ack_id = Utills.getRandomString(5)
                    payload1.userChatId = conversation.myMoniker

                    checkAndSend(isContact, isOneToOne, message, payload1)
                }
            }
        }
    }

    private fun checkAndSend(
        isContact: Boolean,
        isOneToOne: Boolean,
        message: Payload,
        payload1: Payload
    ) {
        if (!isOneToOne && SettingsValues.getMessageReadReceipts() && message.readReceipts) {
            checkInternetAndSend(payload1)
        } else if (SettingsValues.getMessageReadReceipts() && message.readReceipts) {
            if (isContact) {
                checkInternetAndSend(payload1)
            } else {
                Log.e(TAG, "Sending View ACk to unknown contact in else ")
            }
        } else {
            Log.e(TAG, "Sending View ACk else")
        }
    }

    var counter = 0
    val ackDao = MainApp.appContext?.offlineAckDao!!
    fun sendOfflineAcks(payload: Payload) {
        if (MainActivity.isSocketConnected.value != null && MainActivity.isSocketConnected.value!!) {
            val encPayload = encryptPayload(payload)!!
            counter++
            Log.e(Utills.TAG, "Counter $counter")

            if (ackDao.getAllAck().isEmpty()) {
                counter = 0
            }
            if (MainActivity.chatWebSocket?.sendMessage(encPayload)!!) {
                removeFromDB(payload, "sendOfflineAcks")
            } else {
                saveInDB(payload, "sendOfflineAcks")
            }


        } else {
            Log.e(Utills.TAG, "Counter $counter")
            saveInDB(payload, "sendOfflineAcks")
        }

    }

    /**
     * Checks the internet connection and sends the given payload.
     *
     * @param payload The payload to send.
     */
    fun checkInternetAndSend(payload: Payload) {
        // Check if the device has an internet connection and the socket is connected
        if (Utills.isNetworkAvailable() && MainActivity.isSocketConnected.value == true) {
            val encPayload = encryptPayload(payload) ?: return
            // Send the encrypted payload
            if (MainActivity.chatWebSocket?.sendMessage(encPayload) == true) {
                // Remove the payload from the database if it was sent successfully
                removeFromDB(payload, "checkInternetAndSend")
            } else {
                // Save the payload in the database if it was not sent successfully
                saveInDB(payload, "checkInternetAndSend")
            }
        } else {
            // Save the payload in the database if there is no internet connection or the socket is not connected
            saveInDB(payload, "checkInternetAndSend")
        }
    }

    /**
     * Saves the given payload in the database if it doesn't already exist.
     *
     * @param payload The payload to save in the database.
     * @param method The method that called this function.
     */
    private fun saveInDB(payload: Payload, method: String) {
        val offlineAck = MainApp.appContext?.offlineAckDao
        val messageId = payload.messageId

        // Check if the payload doesn't already exist in the database
        if (messageId != null && offlineAck?.exist(messageId) == false) {
            val offlineAckToSave = OfflineAck(
                offlineAckId = messageId,
                payload = payload
            )
            Log.e(Utills.TAG, "\n $method Saving in DB $payload \n")
            // Insert the payload into the database
            offlineAck.insert(offlineAckToSave)
        }
    }

    /**
     * Removes the given payload from the database if it exists.
     *
     * @param payload The payload to remove from the database.
     * @param method The method that called this function.
     */
    private fun removeFromDB(payload: Payload, method: String) {
        val offlineAck = MainApp.appContext?.offlineAckDao
        val messageId = payload.messageId

        // Check if the payload exists in the database
        if (messageId != null && offlineAck?.exist(messageId) == true) {
            Log.e(Utills.TAG, "\n $method Removing from DB $payload \n")
            // Delete the payload from the database
            offlineAck.deleteAckById(messageId)
        }
    }

    /**
     * Checks if any member of a conversation has a non-zero send counter value and updates the hasSentMessage property accordingly.
     *
     * @param conversation The conversation to check and update.
     * @return True if any member has a non-zero send counter value or if the conversation has a sent message, false otherwise.
     */
    fun checkSentMessage(conversation: Conversation): Boolean {

        //if the General read receipts are OFF then return with false state meaning that the receipts will not be sent
        if (!SettingsValues.getMessageReadReceipts()) {
            return false
        }

        //if the General read receipts are OFF then return with false state meaning that the receipts will not be sent for this specific conversation
        if (!conversation.conReadReceipts) {
            return false
        }

        //if the value of privacy is set to true in General settings then proceed
        if (!SettingsValues.getMessageReadReceiptsPrivacy()) {
            return true
        }

        // If the conversation has a sent message, return true
        if (conversation.hasSentMessage) {
            return true
        }

        // Check if any member has a send counter value of 0
        val conversationChannelsDao = MainApp.appContext!!.conversationChannelsDao


        val hasNonZeroSendCounter = conversation.conversationMembers?.any { member ->
            val hash = Utills.getHash("${conversation.conversationId}&&${member.memberId}")
            conversationChannelsDao.exist(hash) && conversationChannelsDao.getConversationChannel(
                hash
            )?.SendCounter != 0
        } ?: false

        if (hasNonZeroSendCounter) {
            //Update the conversation value in Database
            MainApp.appContext?.conversationsDao?.updateHasSentMessage(
                conversation.conversationId,
                true
            )
        }

        return hasNonZeroSendCounter
    }


    fun saveAcknowledgment(payload: Payload) {
        val ackList = AppSession.getOfflineAcknowledgments()
        if (ackList != null && ackList.isNotEmpty()) {
            if (ackList.find { payload.messageId == it.messageId } == null)
                ackList.add(payload)
            AppSession.saveOfflineAcknowledgments(ackList)
        } else {
            val newAckList = mutableListOf<Payload>()
            newAckList.add(payload)
            AppSession.saveOfflineAcknowledgments(newAckList)
        }
    }

    interface ReceiverCallback {
        fun returnPayload(decryptedPayload: Payload?)
    }


    interface SenderCallback {
        fun returnChannels(channels: List<ConversationChannels>)
    }

}
