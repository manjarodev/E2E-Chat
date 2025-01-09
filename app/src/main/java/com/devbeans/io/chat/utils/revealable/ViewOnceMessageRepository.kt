package com.devbeans.io.chat.utils.revealable

import android.content.Context
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.roomDB.Dao.ConversationsDao
import com.devbeans.io.chat.roomDB.Dao.MessagesDao
import com.devbeans.io.chat.utils.ChatExecutors
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.util.*

internal class ViewOnceMessageRepository(context: Context) {
    private val mmsDatabase: MessagesDao
    private val conversationDatabase: ConversationsDao
    private var conversationId: String

    init {
        mmsDatabase = context.messagesDao
        conversationDatabase = context.conversationsDao
        conversationId = ""
    }

    fun getMessage(messageId: String?, callback: Callback<Optional<Payload>>) {
        ChatExecutors.BOUNDED.execute {
            try {
                val record = mmsDatabase.getMessage(messageId) as Payload
                conversationId = record.conversationId!!
                callback.onComplete(Optional.ofNullable(record))
            } catch (e: Exception) {
                callback.onComplete(Optional.empty())
                conversationId = ""
            }
        }
    }

    fun getConversation(): Conversation? {
        return if (!conversationId.equals("", ignoreCase = true)) {
            conversationDatabase.getConversation(conversationId)
        } else {
            null
        }
    }

    fun getMessageToSendAck(messageId: String): Payload? {
        return if (messageId != "") {
            val record = mmsDatabase.getMessage(messageId)
            if (record.filePath != null) {
                mmsDatabase.updateMessageViewed(record.messageId, true)
            }
            record
        } else {
            null
        }
    }

    fun deleteMessageData(messageId: String) {
        val record = getMessageToSendAck(messageId)
        if (record != null) {
            if (record.filePath != null) {
                val file = File(record.filePath!!)
                if (file.exists()) {
                    try {
                        file.delete()
                    } catch (e: Exception) {
                        Log.e(TAG, "Exception deleting data $e")
                    }
                }

            }

        }
    }

    internal interface Callback<T> {
        fun onComplete(result: T)
    }

    companion object {
        private val TAG = Log.tag(
            ViewOnceMessageRepository::class.java
        )
    }
}