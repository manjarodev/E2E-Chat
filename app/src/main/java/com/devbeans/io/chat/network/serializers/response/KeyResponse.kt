package com.devbeans.io.chat.network.serializers.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KeyResponse(
    @SerializedName("ek")
    @Expose
    var ek: String? = null,
    @SerializedName("ik")
    @Expose
    var ik: String? = null,
    @SerializedName("chatUserId")
    @Expose
    var chat_user_id: String? = null,
    @SerializedName("keyFingerprint")
    @Expose
    var keyFingerprint: String? = null
)