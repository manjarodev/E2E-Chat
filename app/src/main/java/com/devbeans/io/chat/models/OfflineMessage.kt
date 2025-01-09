package com.devbeans.io.chat.models

import androidx.room.*
import com.devbeans.io.chat.encryption.MappedPayload
import com.devbeans.io.chat.roomDB.TypeConverters.DeliverListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
@TypeConverters(DeliverListConverter::class)
class OfflineMessage : Serializable {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id = 0


    @SerializedName("ackId")
    @Expose
    var ack_id: String? = null

    @Ignore
    @SerializedName("hashmap")
    @Expose
    var hashmap: HashMap<String, MappedPayload>? = null

    @SerializedName("conversationType")
    @Expose
    var conversation_Type: String? = null



    @SerializedName("isEdited")
    @Expose
    var isEdited = false

    @SerializedName("isDeleted")
    @Expose
    var isDeleted = false


    @SerializedName("readList")
    @Expose
    var readList: MutableList<String>? = null


    //    @SerializedName("encrypted_data")
    //    @Expose
    //    byte[] encrypted_data;
    @SerializedName("fingerprint")
    @Expose
    var fingerprint: String? = null

    //    public byte[] getIvByte() {
    //        return ivByte;
    //    }
    //
    //    public void setIvByte(byte[] ivByte) {
    //        this.ivByte = ivByte;
    //    }
    @SerializedName("public_key_list")
    @Expose
    var public_key_list: List<String>? = null

    //    @SerializedName("ivByte")
    //    @Expose
    //    public byte[] ivByte;
    @SerializedName("secretModel")
    @Expose
    var secretModel: String? = null

    @SerializedName("received_at")
    @Expose
    var received_at: String? = null


    @SerializedName("chatNickUserChatId")
    @Expose
    var chat_nick_user_chat_id: String? = null

    @SerializedName("chatNickData")
    @Expose
    var chat_nick_data: String? = null

    @Ignore
    var isSelected = false

    @SerializedName("senderPubKey")
    @Expose
    var senderPubKey: String? = null

    @SerializedName("recipientPubKeyFingerprint")
    @Expose
    var recipientPubKeyFingerprint: String? = null

    @SerializedName("nextDHKey")
    @Expose
    var NextDHKey: String? = null

    @SerializedName("messageCounter")
    @Expose
    var messageCounter: Int = 0

    @SerializedName("chainIndex")
    @Expose
    var chainIndex: Int = 0



    @SerializedName("data")
    @Expose
    var data: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("messageId")
    @Expose
    var messageId: String? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

    @SerializedName("conversationId")
    @Expose
    var conversationId: String? = null

    @SerializedName("conversationType")
    @Expose
    var conversationType: String? = null

    @SerializedName("userChatId")
    @Expose
    var userChatId: String? = null

    @SerializedName("filePath")
    @Expose
    var file_path: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("deliveredList")
    @Expose
    var deliveredList: List<String>? = null

    @SerializedName("isExpire")
    @Expose
    var isExpire = false

    @SerializedName("isForwarded")
    @Expose
    var isForwarded = false

    @SerializedName("senderId")
    @Expose
    var senderId: String? = null

    @SerializedName("msgExpiryTime")
    @Expose
    var msg_expiry_time: Long = -1

    //Essential for checking each message which is sent
    @ColumnInfo(name = "payload_canShareForward")
    @SerializedName("payload_canShareForward")
    @Expose
    var isCanShareForward = false



    @SerializedName("public_key_list")
    @Expose
    var fingerprint2: String? = null

    @SerializedName("aVRatchetKeyMaterial")
    @Expose
    var aVRatchetKeyMaterial: String? = null




    constructor() {}
    constructor(
        data: String?,
        type: String?,
        messageId: String?,
        createdAt: String?,
        conversationId: String?,
        conversationType: String?,
        userChatId: String?,
        deliveredList: List<String>?
    ) {
        this.data = data
        this.type = type
        this.messageId = messageId
        this.createdAt = createdAt
        this.conversationId = conversationId
        this.conversationType = conversationType
        this.userChatId = userChatId
        this.deliveredList = deliveredList
    }
}