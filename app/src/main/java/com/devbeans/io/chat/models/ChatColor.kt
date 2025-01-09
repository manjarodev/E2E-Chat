package com.devbeans.io.chat.models

import com.google.gson.annotations.SerializedName

data class ChatColor(
    @SerializedName("chatColor")
    var chatColor: Int = 0,
    @SerializedName("isSelected")
    var isSelected: Boolean = false
)
