package com.devbeans.io.chat.services


import android.content.ContentValues
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.util.*


/**
 * Timer class to run in background for viewonce feature and check every second
 *  {@link Conversation}
 */
class TimerSenderViewClass : TimerTask() {
    override fun run() {
        //was being used for view once
    }
}