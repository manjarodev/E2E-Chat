package com.devbeans.io.chat.network.serializers.requestbody

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateRestrictMediaShareRequest(
    @SerializedName("isMediaShareRestrict")
    @Expose var isMediaShareRestrict: Boolean = false,

    @SerializedName("conversationId")
    @Expose var conversationId: String = "",

    @SerializedName("type")
    @Expose var type: String = "",

    )
