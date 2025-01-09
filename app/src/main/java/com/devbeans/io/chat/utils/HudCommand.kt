package com.devbeans.io.chat.utils

import android.view.KeyEvent
import com.google.gson.annotations.SerializedName

sealed class HudCommand {
    object StartDraw : HudCommand()
    object StartCropAndRotate : HudCommand()
    object SaveMedia : HudCommand()

    object GoToText : HudCommand()
    object GoToCapture : HudCommand()

    object ResumeEntryTransition : HudCommand()

    object OpenEmojiSearch : HudCommand()
    object CloseEmojiSearch : HudCommand()
    data class EmojiInsert(@SerializedName("emoji") val emoji: String?) : HudCommand()
    data class EmojiKeyEvent(@SerializedName("keyEvent") val keyEvent: KeyEvent?) :
        HudCommand()
}
