package com.devbeans.io.chat.worker

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.devbeans.io.chat.activities.ChatActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.DateTime
import com.devbeans.io.chat.utils.SettingsValues
import com.devbeans.io.chat.utils.ThreadUtil
import java.io.File

class DisappearWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    val TAG = DisappearWorker::class.java.simpleName
    private val MILLIS_IN_A_DAY = (1000 * 60 * 60 * 24).toLong()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {


        val allConversations = MainApp.appContext?.conversationsDao?.allConversations
        if (!allConversations.isNullOrEmpty()) {
            allConversations.forEach { conversation ->
                conversation.keepChatDate?.let {
                    val dateOfServer = DateTime.convertToDate(conversation.keepChatDate)
                    //Checking if the KeepchatTime with addition to Keepchat time in Days of The conversation is greater than the current time
                    if (System.currentTimeMillis() - (dateOfServer!!.time + (SettingsValues.getKeepChatTime() * MILLIS_IN_A_DAY)) >= 0) {

                        deleteMediaMessage(conversation)

                        //Delete all messages of the conversation from local Database
                        MainApp.appContext?.messagesDao?.deleteConversationMessages(conversation.conversationId)

                        //Get new date on which the conversation is deleted so the conversation is deleted after that new keep chat time + Default keep chat days
                        val modifiedDate =
                            DateTime.getTimeStampFromMillis((dateOfServer!!.time + (SettingsValues.getKeepChatTime() * MILLIS_IN_A_DAY)))

                        handleLastMessage(conversation)

                        //Update the keepchat in local DB
                        MainApp.appContext?.conversationsDao?.updateKeepChatTime(
                            conversation.conversationId,
                            modifiedDate
                        )

                        ThreadUtil.postToMain {

                            //If the Conversation is being used clear it also
                            if (ChatActivity.getInstance() != null && ChatActivity.getInstance()!!.conversation != null && ChatActivity.getInstance()!!.conversation!!.conversationId.equals(
                                    conversation.conversationId,
                                    ignoreCase = true
                                )
                            ) {
                                ChatActivity.getInstance()!!.clearChat()
                            }
                        }
                    }
                }
            }
        }

        return Result.success()
    }

    private fun handleLastMessage(conversation: Conversation?) {
//Removing last message of the conversation
        if (conversation?.lastMessage != null) {
            conversation.lastMessage = null
            try {
                MainApp.appContext?.conversationsDao?.update(conversation)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun deleteMediaMessage(conversation: Conversation?) {
        //Getting all the media files of the conversation for them to delete
        val mediaMessage =
            MainApp.appContext?.messagesDao?.getAllMediaMessages(conversation?.conversationId)
        //If there are any media files delete them one by one
        if (mediaMessage != null && mediaMessage.size > 0) {
            for (payload: Payload in mediaMessage) {
                if (payload.filePath != null) {
                    val file = File(payload.filePath)
                    //if the file exist delete it from the file path
                    if (file.exists()) {
                        file.delete()
                        MainApp.appContext?.messagesDao?.deleteByMessageId(payload.messageId)
                    }
                }
            }
        }
    }

}
