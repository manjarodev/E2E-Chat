package com.devbeans.io.chat.network.serializers.response

import androidx.room.Embedded
import com.devbeans.io.chat.models.Conversation
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewConversationResponse {
    @SerializedName("status")
    @Expose
    var status: String = ""

    @SerializedName("message")
    @Expose
    var message: String = ""

    @SerializedName("conversation")
    @Expose
    @Embedded
    var conversation: Conversation? = null

    @SerializedName("imageBucketLink")
    @Expose
    var imageBucketLink: String = ""

    @SerializedName("data")
    @Expose
    private val encData: String = ""


    override fun toString(): String {
        return "NewConversationResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", conversation=" + conversation +
                ", imageBucketLink='" + imageBucketLink + '\'' +
                '}'
    }
}