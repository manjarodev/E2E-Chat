package com.devbeans.io.chat.models

import androidx.room.*
import com.devbeans.io.chat.roomDB.TypeConverters.ConversationMemberListConverter
import com.devbeans.io.chat.roomDB.TypeConverters.MessagesListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
@TypeConverters(ConversationMemberListConverter::class, MessagesListConverter::class)
class Conversation : Serializable {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("uid")
    var uid = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("conversationId")
    @Expose
    @ColumnInfo(name = "_conversation_id")
    var conversationId: String? = null

    @ColumnInfo(name = "_conversation_type")
    @SerializedName("conversationType")
    @Expose
    var conversationType: String? = null

    @SerializedName("conversationMembers")
    @Expose
    @ColumnInfo(name = "_conversationMembers")
    var conversationMembers: MutableList<ConversationMember>? = null

    @SerializedName("messages")
    @Expose
    var messages: MutableList<Payload>? = null

    @SerializedName("lastMessage")
    @Expose
    @Embedded
    var lastMessage: Payload? = null

    //    @SerializedName("createdAt")
    //    @Expose
    //    private String createdAt;
    @SerializedName("owner")
    @Expose
    var owner: String? = null

    @SerializedName("createdAt")
    @Expose
    var con_createdAt: String? = null

    @SerializedName("keepChatDate")
    @Expose
    var keepChatDate: String? = null

    @SerializedName("isRemoved")
    @Expose
    var isRemoved = false

    @SerializedName("isArchived")
    @Expose
    var isArchived = false

    @SerializedName("inConversation")
    @Expose
    var isInConversation = false

    @ColumnInfo(name = "_isViewOnce")
    @SerializedName("isViewOnce")
    @Expose
    var isViewOnce = false

    @SerializedName("photo")
    @Expose
    var photo: String? = null

    @SerializedName("conversationPhoto")
    @Expose
    var conversationPhoto: String? = null

    @SerializedName("myMoniker")
    @Expose
    var myMoniker: String? = null

    @SerializedName("conversationExpiryTime")
    @Expose
    var conversationExpiryTime: Long = -1

    //Essential for restriction of Share and Forward each time the conversation object is retrieved
    @SerializedName("canShareForward")
    @Expose
    var isCanShareForward = false

    //Essential for auto save to vault each time the conversation object is retrieved
    @SerializedName("autoSaveVault")
    @Expose
    var isAutoSaveVault = false

    @ColumnInfo(name = "_isConfidential")
    @SerializedName("isConfidential")
    @Expose
    var isConfidential = false

    @ColumnInfo(name = "_isMediaShareRestrict")
    @SerializedName("isMediaShareRestrict")
    @Expose
    var isMediaShareRestrict = false


    @SerializedName("sequenceOfConversation")
    @Expose
    var sequenceOfConversation: Long = 0


    @SerializedName("isPinned")
    @Expose
    var isPinned: Boolean = false

    @SerializedName("hasSentMessage")
    @Expose
    var hasSentMessage: Boolean = false

    @SerializedName("conReadReceipts")
    @Expose
    var conReadReceipts: Boolean = true


    @SerializedName("unreadCount")
    @Expose
    var unreadCount: Int = 0


    override fun toString(): String {
        return "Conversation{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", conversationId='" + conversationId + '\'' +
                ", conversationType='" + conversationType + '\'' +
                ", conversationMembers=" + conversationMembers +
                ", messages=" + messages +
                ", lastMessage=" + lastMessage +
                ", owner='" + owner + '\'' +
                ", con_createdAt='" + con_createdAt + '\'' +
                ", isRemoved=" + isRemoved +
                ", photo='" + photo + '\'' +
                ", conversationPhoto='" + conversationPhoto + '\'' +
                ", conversationExpiryTime=" + conversationExpiryTime +
                '}'
    }
}