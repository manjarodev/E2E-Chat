package com.devbeans.io.chat.models

import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import com.google.gson.annotations.SerializedName

/**
 * Contains information on a single selected conversation item. This is used when transitioning
 * between selected and unselected states.
 */
data class SelectedConversationModel(
    @SerializedName("bitmap") val bitmap: Bitmap,
    @SerializedName("itemX") val itemX: Float,
    @SerializedName("itemY") val itemY: Float,
    @SerializedName("bubbleX") val bubbleX: Float,
    @SerializedName("bubbleY") val bubbleY: Float,
    @SerializedName("bubbleWidth") val bubbleWidth: Int,
    @SerializedName("audioUri") val audioUri: Uri? = null,
    @SerializedName("isOutgoing") val isOutgoing: Boolean,
    @SerializedName("focusedView") val focusedView: View?,
)