package com.devbeans.io.chat.models

import androidx.room.*
import com.devbeans.io.chat.encryption.MappedPayload
import com.devbeans.io.chat.roomDB.TypeConverters.DeliverListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
@TypeConverters(DeliverListConverter::class)
class Payload : Serializable {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id = 0

    @SerializedName("data")
    @Expose
    var data: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("messageId")
    @Expose
    var messageId: String? = null

    @SerializedName("senderId")
    @Expose
    var senderId: String? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

    @SerializedName("ackId")
    @Expose
    var ack_id: String? = null

    @Ignore
    @SerializedName("hashmap")
    @Expose
    var senderList: java.util.ArrayList<MappedPayload>? = null

    @SerializedName("conversationId")
    @Expose
    var conversationId: String? = null

    @SerializedName("conversationType")
    @Expose
    var conversationType: String? = null

//    @SerializedName("conversationType")
//    @Expose
//    var conversation_Type: String? = null

    @SerializedName("userChatId")
    @Expose
    var userChatId: String? = null

    @SerializedName("filePath")
    @Expose
    var filePath: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("isEdited")
    @Expose
    var isEdited = false

    @SerializedName("isDeleted")
    @Expose
    var isDeleted = false

    @SerializedName("deliveredList")
    @Expose
    var deliveredList: MutableList<String>? = null

    @SerializedName("readList")
    @Expose
    var readList: MutableList<String>? = null


    @SerializedName("openedList")
    @Expose
    var openedList: MutableList<String>? = null

    @SerializedName("isExpire")
    @Expose
    var isExpire = false

    @SerializedName("isForwarded")
    @Expose
    var isForwarded = false

    @SerializedName("isConfidential")
    @Expose
    var isConfidential = false

    @SerializedName("isViewOnce")
    @Expose
    var isViewOnce = false

    @SerializedName("isViewed")
    @Expose
    var isViewed = false

    @SerializedName("isDownloading")
    @Expose
    var isDownloading = false

    @SerializedName("readReceipts")
    @Expose
    var readReceipts = false


    @SerializedName("isOpened")
    @Expose
    var isOpened = false

    @SerializedName("msgExpiryTime")
    @Expose
    var msgExpiryTime: Long = -1

    @SerializedName("expireStarted")
    @Expose
    var expireStarted: Long = -1


    //    @SerializedName("encrypted_data")
    //    @Expose
    //    byte[] encrypted_data;
//    @SerializedName("fingerprint")
//    @Expose
//    var fingerprint: String? = null

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
//    @SerializedName("secretModel")
//    @Expose
//    var secretModel: String? = null

    @SerializedName("received_at")
    @Expose
    var received_at: String? = null

    //Essential for checking each message which is sent
    @ColumnInfo(name = "payloadCanShareForward")
    @SerializedName("payloadCanShareForward")
    @Expose
    var isCanShareForward = false

    @SerializedName("chatNickUserChatId")
    @Expose
    var chatNickUserChatId: String? = null

    @SerializedName("chatNickData")
    @Expose
    var chatNickData: String? = null

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
    var nextDHKey: String? = null

    @SerializedName("messageCounter")
    @Expose
    var messageCounter: Int = 0

    @SerializedName("chainIndex")
    @Expose
    var chainIndex: Int = 0

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
        deliveredList: MutableList<String>?
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

    override fun toString(): String {
        return "Payload{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", type='" + type + '\'' +
                ", messageId='" + messageId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", ackId='" + ack_id + '\'' +
                ", conversationId='" + conversationId + '\'' +
                ", conversationType='" + conversationType + '\'' +
                ", userChatId='" + userChatId + '\'' +
                ", filePath='" + filePath + '\'' +
                ", status='" + status + '\'' +
                ", isEdited=" + isEdited +
                ", isDeleted=" + isDeleted +
                ", deliveredList=" + deliveredList +
                ", readList=" + readList +
                ", isExpire=" + isExpire +
                '}'
    }
}