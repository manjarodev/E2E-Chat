package com.devbeans.io.chat.models

import com.google.gson.annotations.SerializedName

data class DownloadMedia(
    @SerializedName("path")
    val path: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("payload")
    val payload: Payload? = null,
    @SerializedName("conversationId")
    val conversationId: String = "",
    @SerializedName("name")
    val name: String = ""
)