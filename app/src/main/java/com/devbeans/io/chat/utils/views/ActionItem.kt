package com.devbeans.io.chat.utils.views

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

/**
 * Represents an action to be rendered via [SignalContextMenu] or [SignalBottomActionBar]
 */
data class ActionItem(
    @SerializedName("iconRes")
    @DrawableRes val iconRes: Int,
    @SerializedName("title") val title: CharSequence,
    @SerializedName("action") val action: Runnable
)