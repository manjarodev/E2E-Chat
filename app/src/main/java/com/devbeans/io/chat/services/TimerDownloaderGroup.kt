package com.devbeans.io.chat.services

import com.devbeans.io.chat.activities.ChatActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.downloaders.DownloaderGroup
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.util.*

class TimerDownloaderGroup : TimerTask() {
    private val tag = Log.tag(TimerDownloaderGroup::class.java)

    override fun run() {
//        Log.e(tag, "Downloader task running")
        if (SettingsValues.getAutoDownload() && !AppSession.getUser()?.chatUserId.isNullOrEmpty()) {
            val messageDao = MainApp.appContext?.messagesDao
            val allGroupMedia = messageDao?.getConSpecificAllMediaMessages(
                AppSession.getUser().chatUserId,
                Constants.TYPES.CONVERSATION_GROUP
            )
            if (!allGroupMedia.isNullOrEmpty()) {
                allGroupMedia.removeIf {
                    Utills.checkMediaPayload(it.type)
                }

                if (allGroupMedia.isNotEmpty()) {
                    allGroupMedia.forEach { mediaPayload ->
                        messageDao.updateMessageDownloading(mediaPayload?.messageId, true)
                        handleInChatActivity(mediaPayload)
                        try {
                            sendToDownloader(mediaPayload)
                        } catch (e: Exception) {
                            Log.e(
                                tag,
                                "Got Exception ${e.printStackTrace()} message ${e.message}"
                            )
                        }
                    }

                }
            }
        }

    }

    private fun sendToDownloader(mediaPayload: Payload?) {
        val currentString = mediaPayload?.data
        currentString?.let {
            val separated = it.split("@@".toRegex()).toTypedArray()
            val data = separated[0] // this will contain "Fruit"
            val file = File(
                when (mediaPayload.type) {
                    Constants.TYPES.IMAGE -> {
                        MainApp.imagesPathReceive + "/" + data
                    }
                    Constants.TYPES.VIDEO -> {
                        MainApp.videoPathReceive + "/" + data
                    }
                    Constants.TYPES.FILE -> {
                        MainApp.filesPathReceive + "/" + data
                    }
                    Constants.TYPES.AUDIO -> {
                        MainApp.audioPathReceive + "/" + data
                    }
                    else -> {
                        when (mediaPayload.type) {
                            Constants.TYPES.IMAGE -> {
                                MainApp.imagesPathReceive + "/" + data
                            }
                            Constants.TYPES.VIDEO -> {
                                MainApp.videoPathReceive + "/" + data
                            }
                            Constants.TYPES.FILE -> {
                                MainApp.filesPathReceive + "/" + data
                            }
                            Constants.TYPES.AUDIO -> {
                                MainApp.audioPathReceive + "/" + data
                            }
                            else -> {
                                ""
                            }
                        }

                    }
                }
            )
            if (!file.exists()) {
                val cipherData = EncryptionUtils.encryptDataDownload(data)

                DownloaderGroup.instance!!.download(
                    file.absolutePath,
                    Configurations.uploadsUrl + cipherData + "&chatAppId=" + AppSession.getUser().chatUserId +
                            "&download=true",
                    mediaPayload
                )

            }
        }
    }

    private fun handleInChatActivity(mediaPayload: Payload?) {
        ThreadUtil.postToMain {
            mediaPayload?.isDownloading = true

            if (ChatActivity.getInstance() != null && ChatActivity.getInstance()!!.conversation != null && ChatActivity.getInstance()!!.conversation!!.conversationId.equals(
                    mediaPayload?.conversationId,
                    ignoreCase = true
                )
            ) {
                ChatActivity.getInstance()?.updateMessage(mediaPayload)
            }
        }
    }
}