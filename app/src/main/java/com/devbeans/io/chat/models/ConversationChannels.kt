package com.devbeans.io.chat.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.devbeans.io.chat.encryption.EK
import com.devbeans.io.chat.encryption.KeyExchange
import com.devbeans.io.chat.encryption.SecretEk
import com.devbeans.io.chat.encryption.SymmRatchet
import com.devbeans.io.chat.roomDB.TypeConverters.*
import com.devbeans.io.chat.utils.EncryptionUtils
import com.devbeans.io.chat.utils.KeyPairGenerator
import com.devbeans.io.chat.utils.Stopwatch
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.annotations.SerializedName
import com.virgilsecurity.keyknox.utils.Serializer.Companion.gson

@Entity(tableName = "conversation_channels")
@TypeConverters(
    SecretKeyConverterSimple::class,
    SymmRatchetConverterSimple::class,
    EKConverterSimple::class,
    HashMapTypeConverter::class
)
class ConversationChannels(channelIdentifier: String, FlipRatchetDirection: Int) {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("channelId")
    var channelId: Int = 0

    @SerializedName("channelIdentifier")
    var channelIdentifier: String? = channelIdentifier

    @SerializedName("channelWith")
    var channelWith: String? = null

    @SerializedName("SK")
    var SK: SecretKey? = SecretKey(channelIdentifier)

    @SerializedName("RootRatchet")
    var RootRatchet: SymmRatchet? = null

    @SerializedName("SendRatchet")
    var SendRatchet: SymmRatchet? = null

    @SerializedName("RecvRatchet")
    var RecvRatchet: SymmRatchet? = null

    @SerializedName("cacheRatchet")
    var cacheRatchet: SymmRatchet? = SymmRatchet(byteArrayOf(5, 5, 5, 5, 5, 5, 5), "MessageRatchet")

    @SerializedName("RecipientPubKey")
    var RecipientPubKey: String? = null

    @SerializedName("FriendDHKey")
    var FriendDHKey: String? = null

    @SerializedName("CacheFriendDHKey")
    var CacheFriendDHKey: HashMap<String, String> = hashMapOf()

    @SerializedName("DHRatchet")
    var DHRatchet: EK

    @SerializedName("CacheRachet")
    var CacheRachet: EK

    @SerializedName("EK")
    var EK: EK? = null

    @SerializedName("SendCounter")
    var SendCounter: Int = 0

    @SerializedName("ReceiveCounter")
    var ReceiveCounter: Int = 0

    @SerializedName("FlipRatchetDirection")
    var FlipRatchetDirection: Int = FlipRatchetDirection

    @SerializedName("isDHRacthetEnable")
    var isDHRacthetEnable: Boolean = false

    init {
        val keypairGenerator = KeyPairGenerator()
        DHRatchet = keypairGenerator.generateDHNextKeyPair(channelIdentifier)
        CacheRachet = DHRatchet
    }

    fun initRatchets() {
        val stopwatch = Stopwatch("Setting all Ratchets")
        stopwatch.split("Setting all Ratchet Start")
        stopwatch.split("Getting root racthet")
        this@ConversationChannels.RootRatchet = SymmRatchet(
            EncryptionUtils.getDecodedBytes(this@ConversationChannels.SK!!.secretKey!!),
            "RootRatchet"
        )
        stopwatch.split("root racthet done")
        if (this@ConversationChannels.FlipRatchetDirection != 0) {
            stopwatch.split("Getting Send Racthet start")
            this@ConversationChannels.SendRatchet =
                this@ConversationChannels.RootRatchet?.nextKey()
                    ?.let { SymmRatchet(it.first, "MessageRatchet") }
            stopwatch.split("Send Racthet done")
            stopwatch.split("Getting Recv Racthet start")
            this@ConversationChannels.RecvRatchet =
                this@ConversationChannels.RootRatchet?.nextKey()
                    ?.let { SymmRatchet(it.first, "MessageRatchet") }
            stopwatch.split(" Recv Racthet done")

        } else {
            stopwatch.split("Getting Recv Racthet start")
            this@ConversationChannels.RecvRatchet =
                this@ConversationChannels.RootRatchet?.nextKey()
                    ?.let { SymmRatchet(it.first, "MessageRatchet") }
            stopwatch.split(" Recv Racthet done")
            stopwatch.split("Getting Send Racthet start")
            this@ConversationChannels.SendRatchet =
                this@ConversationChannels.RootRatchet?.nextKey()
                    ?.let { SymmRatchet(it.first, "MessageRatchet") }
            stopwatch.split("Send Racthet done")
        }

        stopwatch.split("Setting all Ratchet done")
        stopwatch.stop(Stopwatch.TAG)
    }

    fun initRatchetsLocal(SK: SecretKey): SymmRatchet {
        val RootRatchet = SymmRatchet(
            EncryptionUtils.getDecodedBytes(SK.secretKey!!),
            "RootRatchet"
        )

        if (this@ConversationChannels.FlipRatchetDirection != 0) {
            val SendRatchet =
                RootRatchet.nextKey()
                    ?.let { SymmRatchet(it.first, "MessageRatchet") }
            val RecvRatchet =
                RootRatchet?.nextKey()
                    ?.let { SymmRatchet(it.first, "MessageRatchet") }
            return RecvRatchet!!
        } else {
            val RecvRatchet =
                RootRatchet?.nextKey()
                    ?.let { SymmRatchet(it.first, "MessageRatchet") }
            val SendRatchet =
                RootRatchet?.nextKey()
                    ?.let { SymmRatchet(it.first, "MessageRatchet") }
            return RecvRatchet!!
        }

    }

    fun DHRatchetNext() {

        val keyPairGenerator = KeyPairGenerator()
//        this@ConversationChannels.CacheRachet = this@ConversationChannels.DHRatchet
        this@ConversationChannels.DHRatchet =
            keyPairGenerator.generateDHNextKeyPair(this@ConversationChannels.channelIdentifier!!)
        Log.e(
            EncryptionUtils.TAG,
            " DHRatchet sending in model ${gson.toJson(this@ConversationChannels.DHRatchet)}\n"
        )
        Log.e(
            EncryptionUtils.TAG,
            " DHRatchet sending Pub Key key model ${gson.toJson(this@ConversationChannels.DHRatchet.pubKey)}\n DHRatchet sending prive key model ${
                gson.toJson(
                    this@ConversationChannels.DHRatchet.privKey
                )
            }\n"
        )
        Log.e(
            EncryptionUtils.TAG,
            "Friend DH key sending in model ${this@ConversationChannels.FriendDHKey}\n"
        )
        val sk = KeyExchange.exchange(
            this@ConversationChannels.DHRatchet.privKey!!,
            this@ConversationChannels.FriendDHKey!!
        )


        val secretKey = SecretKey(this@ConversationChannels.channelIdentifier!!)
        secretKey.secretKey = EncryptionUtils.getEncodedString(sk)
        Log.e(
            EncryptionUtils.TAG,
            "After Ticked Secret Key: ${EncryptionUtils.getEncodedString(sk)}"
        )
        this@ConversationChannels.SK = secretKey
//            Log.e(TAG, "${this@User.name} Secret Key: ${b64(this@User.SK!!)}")
//        this@ConversationChannels.cacheRatchet = this@ConversationChannels.RecvRatchet
        this@ConversationChannels.cacheRatchet = this@ConversationChannels.RecvRatchet
        this@ConversationChannels.initRatchets()
    }

    fun DHRatchetLocal(keypair: SecretEk, friendDH: String): SymmRatchet {


        val sk = KeyExchange.exchange(
            keypair.ek!!.privKey!!,
            friendDH
        )


        val secretKey = SecretKey(this@ConversationChannels.channelIdentifier!!)
        secretKey.secretKey = EncryptionUtils.getEncodedString(sk)

        return initRatchetsLocal(secretKey)
    }

    fun preDHRatchet() {
        val stopwatch = Stopwatch("Updating Ratchet")
        stopwatch.split("Starting")
        Log.e(
            EncryptionUtils.TAG,
            "DHRatchet Private Key When Receiving in model ${gson.toJson(this@ConversationChannels.DHRatchet.privKey)}\nDHRatchet FriendDHKey When Receiving in model ${
                gson.toJson(
                    this@ConversationChannels.FriendDHKey
                )
            }\n"
        )
        stopwatch.split("Exchanging Key")
        val sk = KeyExchange.exchange(
            this@ConversationChannels.DHRatchet.privKey!!,
            this@ConversationChannels.FriendDHKey!!
        )
        stopwatch.split("Exchanging Key Done")
        val secretKey = SecretKey(this@ConversationChannels.channelIdentifier!!)
        secretKey.secretKey = EncryptionUtils.getEncodedString(sk)
        this@ConversationChannels.SK = secretKey
        Log.e(
            EncryptionUtils.TAG,
            "preDHRatchet Secret Key: in model ${EncryptionUtils.getEncodedString(sk)}"
        )
        this@ConversationChannels.cacheRatchet = this@ConversationChannels.RecvRatchet
        stopwatch.split("sent to Initiating all Racthet")
        stopwatch.stop(Stopwatch.TAG)
        initRatchets()
    }

    fun preCacheRatchet() {
        Log.e(
            EncryptionUtils.TAG,
            "DHRatchet Private Key When Receiving in model ${gson.toJson(this@ConversationChannels.CacheRachet.privKey)}\nDHRatchet FriendDHKey When Receiving in model ${
                gson.toJson(
                    this@ConversationChannels.FriendDHKey
                )
            }\n"
        )

        val sk = KeyExchange.exchange(
            this@ConversationChannels.CacheRachet.privKey!!,
            this@ConversationChannels.FriendDHKey!!
        )

        val secretKey = SecretKey(this@ConversationChannels.channelIdentifier!!)
        secretKey.secretKey = EncryptionUtils.getEncodedString(sk)
        this@ConversationChannels.SK = secretKey
        Log.e(
            EncryptionUtils.TAG,
            "preCacheRatchet Secret Key: in model ${EncryptionUtils.getEncodedString(sk)}"
        )
        this@ConversationChannels.cacheRatchet = this@ConversationChannels.RecvRatchet
        initRatchets()
    }


    fun preFriendCacheRatchet(id: String) {
        Log.e(
            EncryptionUtils.TAG,
            "CacheRachet Private Key When Receiving in model ${gson.toJson(this@ConversationChannels.CacheRachet.privKey)}\nDHRatchet CacheFriendDHKey When Receiving in model ${
                gson.toJson(
                    this@ConversationChannels.CacheFriendDHKey
                )
            }\n"
        )

        val sk = KeyExchange.exchange(
            this@ConversationChannels.CacheFriendDHKey?.get(id)!!,
            this@ConversationChannels.FriendDHKey!!
        )

        val secretKey = SecretKey(this@ConversationChannels.channelIdentifier!!)
        secretKey.secretKey = EncryptionUtils.getEncodedString(sk)
        this@ConversationChannels.SK = secretKey
        Log.e(
            EncryptionUtils.TAG,
            "preFriendCacheRatchet Secret Key: in model ${EncryptionUtils.getEncodedString(sk)}"
        )
        this@ConversationChannels.cacheRatchet = this@ConversationChannels.RecvRatchet
        initRatchets()
    }

    override fun toString(): String {
        return super.toString()
    }
}