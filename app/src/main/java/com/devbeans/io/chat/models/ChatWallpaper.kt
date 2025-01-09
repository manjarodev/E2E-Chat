package com.devbeans.io.chat.models

import com.google.gson.annotations.SerializedName

data class ChatWallpaper(
    @SerializedName("chatWallpaper")
    var chatWallpaper: Int = 0,
    @SerializedName("isSelected") var isSelected: Boolean = false
)
