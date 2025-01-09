package com.devbeans.io.chat.models

import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
class ConversationMember : Serializable {
    @SerializedName("memberId")
    @Expose
    var memberId: String? = null

    @SerializedName("signatureKey")
    @Expose
    var signatureKey: String? = null

    @SerializedName("moniker")
    @Expose
    var moniker: String? = null

    @SerializedName("me")
    @Expose
    var isMe = false

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("chatNickName")
    @Expose
    var chatNickName: String? = null

    @SerializedName("memberChatId")
    @Expose
    var memberChatId: String? = null

    @Ignore
    var isSelected = false
}