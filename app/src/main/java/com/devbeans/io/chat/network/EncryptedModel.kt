package com.devbeans.io.chat.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EncryptedModel {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("data")
    @Expose
    var data: String? = null

    @SerializedName("keyFingerprint")
    @Expose
    var fingerPrint: String? = null
}