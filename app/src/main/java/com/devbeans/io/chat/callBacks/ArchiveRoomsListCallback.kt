package com.devbeans.io.chat.callBacks

import android.view.View
import com.devbeans.io.chat.models.Conversation

interface ArchiveRoomsListCallback {
    fun onRoomClick(
        room: Conversation?,
        name: String?,
        id: String?,
        i: Int,
        color: String?,
        isContact: Boolean
    )

    fun onRoomLongClick(
        room: Conversation?,
        name: String?,
        id: String?,
        i: Int,
        color: String?,
        isContact: Boolean,
        view: View,
        anchor: View
    ) {
    }
}