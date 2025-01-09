package com.devbeans.io.chat.utils

import com.devbeans.io.chat.encryption.MappedPayload
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.Constants.TYPES
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

object PayloadFilter {
    val TAG = Log.tag(PayloadFilter::class.java)

    fun getPayLoad(actualPayload: Payload): String {
        var payload = ""
        val gson = Gson()
        if (actualPayload != null && !actualPayload.type.isNullOrEmpty()) {
            when (actualPayload.type) {
                TYPES.CONFIRM_ACK_BLOCK,
                TYPES.CONFIRM_ACK_UNBLOCK,
                TYPES.CONFIRM_ACK_LEAVE_GROUP,
                TYPES.CONFIRM_ACK_MEMBER_REMOVE,
                TYPES.CONFIRM_ACK_DESTROY_GROUP,
                TYPES.CONFIRM_ACK_KEY_DEFICIENCY -> {
                    val confirmAckPayload = ConfirmAckPayload(
                        ackId = actualPayload.ack_id!!,
                        senderId = actualPayload.userChatId!!,
                        type = actualPayload.type!!
                    )
                    payload = gson.toJson(confirmAckPayload)
                }
                TYPES.CONFIRM_ACK_MEMBER_ADD,
                TYPES.CONFIRM_ACK_ADMIN_ASSIGNED,
                TYPES.CONFIRM_ACK_ADMIN_REMOVED,
                TYPES.CONFIRM_ACK_GROUP_ICON_CHANGE,
                TYPES.CONFIRM_ACK_GROUP_NAME_CHANGE,
                TYPES.CONFIRM_ACK_GROUP_DES_CHANGE,
                TYPES.CONFIRM_ACK_GROUP_CONV_CREATED,
                TYPES.CONFIRM_ANONYMOUS_GROUP_CONV_CREATED,
                TYPES.CONFIRM_ACK_DELIVER,
                TYPES.CONFIRM_ACK_READ,
                TYPES.CONFIRM_ACK_EDIT,
                TYPES.CONFIRM_ACK_DELETE,
                TYPES.CONFIRM_ACK_VIEW_ONCE,
                TYPES.CONFIRM_ACK_BLOCK_UNKNOWN,
                TYPES.CONFIRM_ACK_IS_MEDIA_SHARE_RESTRICT_CHANGE,
                TYPES.CONFIRM_ACK_IS_CONFIDENTIAL_CHANGE,
                TYPES.ACK_CON_EX_CHANGE -> {
                    val confirmAckPayloadWithConv = ConfirmAckPayloadWithConv(
                        ackId = actualPayload.ack_id!!,
                        senderId = actualPayload.userChatId!!,
                        type = actualPayload.type!!,
                        conversationId = actualPayload.conversationId!!
                    )
                    payload = gson.toJson(confirmAckPayloadWithConv)
                }
                TYPES.ACK_EDIT,
                TYPES.ACK_DELETE,
                TYPES.ACK_DELIVER,
                TYPES.ACK_READ,
                TYPES.ACK_IS_VIEW_ONCE -> {
                    val ackPayload = AckPayload(
                        ackId = actualPayload.ack_id!!,
                        conversationId = actualPayload.conversationId!!,
                        conversationType = actualPayload.conversationType!!,
                        messageId = actualPayload.messageId!!,
                        type = actualPayload.type!!,
                        userChatId = actualPayload.userChatId!!,
                        senderId = actualPayload.senderId!!
                    )
                    payload = gson.toJson(ackPayload)
                }
                TYPES.DELETE -> {
                    val deletePayload = DeletePayload(
                        data = actualPayload.senderList!!,
                        messageId = actualPayload.messageId!!,
                        type = actualPayload.type!!,
                        conversationId = actualPayload.conversationId!!,
                        createdAt = actualPayload.createdAt!!,
                        conversationType = actualPayload.conversationType!!,
                        userChatId = actualPayload.userChatId!!,
                        senderId = actualPayload.senderId!!,
                        messageCipher = "This message was deleted.",
                        chainIndex = 0,
                        nextDHKey = "",
                        aVRatchetKeyMaterial = ""
                    )
                    payload = gson.toJson(deletePayload)
                    Log.e(TAG, "Delete Payload $payload")
                }
//                TYPES.EDIT -> {
//                    val editPayload = EditPayload(
//                        data = actualPayload.data!!,
//                        messageId = actualPayload.messageId!!,
//                        type = actualPayload.type!!,
//                        conversationId = actualPayload.conversationId!!,
//                        createdAt = actualPayload.createdAt!!,
//                        conversationType = actualPayload.conversationType!!,
//                        userChatId = actualPayload.userChatId!!,
//                        secretModel = actualPayload.secretModel!!,
//                        senderId = actualPayload.senderId!!,
//                    )
//                    payload = gson.toJson(editPayload)
//                }
//                TYPES.SIR -> {
//                    val sirPayload = SirPayload(
//                        data = actualPayload.data!!,
//                        messageId = actualPayload.messageId!!,
//                        type = actualPayload.type!!,
//                        conversationId = actualPayload.conversationId!!,
//                        createdAt = actualPayload.createdAt!!,
//                        userChatId = actualPayload.userChatId!!,
//                        secretModel = actualPayload.secretModel!!,
//                        public_key_list = actualPayload.public_key_list!!,
//                        senderId = actualPayload.senderId!!
//                    )
//                    payload = gson.toJson(sirPayload)
//                }
                TYPES.TEXT,
                TYPES.FILE,
                TYPES.AUDIO,
                TYPES.VIDEO,
                TYPES.IMAGE,
                TYPES.EDIT -> {

                    val toSendPayload = ToSendPayload(
                        payloadCanShareForward = actualPayload.isCanShareForward,
                        conversationId = actualPayload.conversationId!!,
                        conversationType = actualPayload.conversationType!!,
                        createdAt = actualPayload.createdAt!!,
                        data = actualPayload.senderList!!,
//                        secretModel = actualPayload.secretModel,
                        isExpire = actualPayload.isExpire,
                        isForwarded = actualPayload.isForwarded,
                        messageId = actualPayload.messageId!!,
                        msgExpiryTime = actualPayload.msgExpiryTime,
                        type = actualPayload.type!!,
                        userChatId = actualPayload.userChatId!!,
                        senderId = actualPayload.senderId!!,
                        isConfidential = actualPayload.isConfidential,
                        readReceipts = actualPayload.readReceipts,
                        isViewOnce = actualPayload.isViewOnce
                    )

                    payload = gson.toJson(toSendPayload)
                }

                else -> {
                    payload = gson.toJson(actualPayload)
                }
            }
        }
//        Log.e(TAG, "$payload \n")
        return payload
    }


    data class ConfirmAckPayload(
        @SerializedName("ackId") val ackId: String,
        @SerializedName("senderId") val senderId: String,
        @SerializedName("type") val type: String,
    )

    data class ConfirmAckPayloadWithConv(
        @SerializedName("ackId") val ackId: String,
        @SerializedName("senderId") val senderId: String,
        @SerializedName("type") val type: String,
        @SerializedName("conversationId") val conversationId: String,
    )

    data class AckPayload(
        @SerializedName("ackId") val ackId: String,
        @SerializedName("type") val type: String,
        @SerializedName("conversationId") val conversationId: String,
        @SerializedName("userChatId") val userChatId: String,
        @SerializedName("senderId") val senderId: String,
        @SerializedName("conversationType") val conversationType: String,
        @SerializedName("messageId") val messageId: String,
    )

    data class DeletePayload(

        @SerializedName("type") val type: String,
        @SerializedName("conversationId") val conversationId: String,
        @SerializedName("userChatId") val userChatId: String,
        @SerializedName("conversationType") val conversationType: String,
        @SerializedName("messageId") val messageId: String,
        @SerializedName("createdAt") val createdAt: String,
        @SerializedName("data") val data: java.util.ArrayList<MappedPayload>,
        @SerializedName("senderId") val senderId: String,
        @SerializedName("senderPubKey") val senderPubKey: String? = "",
        @SerializedName("recipientPubKeyFingerprint") val recipientPubKeyFingerprint: String? = "",
        @SerializedName("nextDHKey") val nextDHKey: String? = "",
        @SerializedName("messageCounter") val messageCounter: Int = 0,
        @SerializedName("chainIndex") val chainIndex: Int = 0,
        @SerializedName("aVRatchetKeyMaterial") val aVRatchetKeyMaterial: String? = "",
        @SerializedName("messageCipher") val messageCipher: String? = ""
    )

    data class EditPayload(
        @SerializedName("type") val type: String,
        @SerializedName("conversationId") val conversationId: String,
        @SerializedName("userChatId") val userChatId: String,
        @SerializedName("conversationType") val conversationType: String,
        @SerializedName("messageId") val messageId: String,
        @SerializedName("createdAt") val createdAt: String,
        @SerializedName("data") val data: String,
        @SerializedName("senderId") val senderId: String,
    )

//    data class SirPayload(
//        @SerializedName("type") val type: String,
//        @SerializedName("conversationId") val conversationId: String,
//        @SerializedName("userChatId") val userChatId: String,
//        @SerializedName("messageId") val messageId: String,
//        @SerializedName("createdAt") val createdAt: String,
//        @SerializedName("data") val data: String,
//        @SerializedName("secretModel") val secretModel: String,
//        @SerializedName("public_key_list") val public_key_list: List<String>,
//        @SerializedName("senderId") val senderId: String,
//    )


    data class ToSendPayload(
        @SerializedName("payloadCanShareForward") val payloadCanShareForward: Boolean,
        @SerializedName("conversationId") val conversationId: String,
        @SerializedName("conversationType") val conversationType: String,
        @SerializedName("createdAt") val createdAt: String,
        @SerializedName("data") val data: java.util.ArrayList<MappedPayload>,
        @SerializedName("isExpire") val isExpire: Boolean,
        @SerializedName("isForwarded") val isForwarded: Boolean,
        @SerializedName("isConfidential") val isConfidential: Boolean,
        @SerializedName("messageId") val messageId: String,
        @SerializedName("msgExpiryTime") val msgExpiryTime: Long,
        @SerializedName("type") val type: String,
        @SerializedName("userChatId") val userChatId: String,
        @SerializedName("senderId") val senderId: String,
        @SerializedName("senderPubKey") val senderPubKey: String? = "",
        @SerializedName("secretModel") val secretModel: String? = "",
        @SerializedName("recipientPubKeyFingerprint") val recipientPubKeyFingerprint: String? = "",
        @SerializedName("nextDHKey") val NextDHKey: String? = "",
        @SerializedName("messageCounter") val messageCounter: Int = 0,
        @SerializedName("chainIndex") val chainIndex: Int = 0,
        @SerializedName("aVRatchetKeyMaterial") val aVRatchetKeyMaterial: String? = "",
        @SerializedName("readReceipts") val readReceipts: Boolean = false,
        @SerializedName("isViewOnce") val isViewOnce: Boolean = false
    )
}