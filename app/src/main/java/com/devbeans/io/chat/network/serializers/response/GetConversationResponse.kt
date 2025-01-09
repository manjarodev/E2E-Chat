package com.devbeans.io.chat.network.serializers.response

import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.utils.Constants
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetConversationResponse {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName(Constants.KEYS.CONVERSATION_OBJ)
    @Expose
    var conversationList: Conversation? = null

    @SerializedName("imageBucketLink")
    @Expose
    var image_bucket_link: String? = null
    override fun toString(): String {
        return "GetConversationResponse{" +
                "status='" + status + '\'' +
                ", conversationList=" + conversationList +
                ", imageBucketLink='" + image_bucket_link + '\'' +
                '}'
    }
}