package com.devbeans.io.chat.models

import com.google.gson.annotations.SerializedName


data class VideoSize(
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("duration")
    val duration: Long
)
