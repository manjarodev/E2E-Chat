package com.devbeans.io.chat.network.serializers.requestbody

import com.google.gson.annotations.SerializedName

data class EncryptedRequest(
    @SerializedName("body")
    var body: String = ""
)
