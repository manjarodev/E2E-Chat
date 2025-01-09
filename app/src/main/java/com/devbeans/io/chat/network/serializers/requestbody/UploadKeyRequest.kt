package com.devbeans.io.chat.network.serializers.requestbody

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UploadKeyRequest {
    @SerializedName("data")
    @Expose
    var data: String? = null

    @SerializedName("chatId")
    @Expose
    var chatId: String? = null

    @SerializedName("signature")
    @Expose
    var signature: String? = null
}