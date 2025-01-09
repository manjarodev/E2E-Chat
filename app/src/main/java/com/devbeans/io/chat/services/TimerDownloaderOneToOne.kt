package com.devbeans.io.chat.services

import com.devbeans.io.chat.activities.ChatActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.downloaders.DownloaderOneToOne
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.util.*

class TimerDownloaderOneToOne : TimerTask() {
    private val tag = Log.tag(TimerDownloaderOneToOne::class.java)

    override fun run() {
        if (SettingsValues.getAutoDownload() && !AppSession.getUser()?.chatUserId.isNullOrEmpty()) {
            val messageDao = MainApp.appContext?.messagesDao
            val allOneToOneMedia = messageDao?.getConSpecificAllMediaMessages(
                AppSession.getUser().chatUserId,
                Constants.TYPES.CONVERSATION_ONE_TO_ONE
            )

            if (!allOneToOneMedia.isNullOrEmpty()) {
                allOneToOneMedia.removeIf {
                    Utills.checkMediaPayload(it.type)
                }
                if (allOneToOneMedia.isNotEmpty()) {

                    allOneToOneMedia.forEach { mediaPayload ->
                        messageDao.updateMessageDownloading(mediaPayload?.messageId, true)
                        handleInChatActivity(mediaPayload)
                        try {
                            handleSendToDownloader(mediaPayload)
                        } catch (e: Exception) {
                            Log.e(tag, "Got Exception ${e.printStackTrace()} message ${e.message}")
                        }
                    }

                }
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

    private fun handleSendToDownloader(mediaPayload: Payload?) {
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

                DownloaderOneToOne.instance!!.download(
                    file.absolutePath,
                    Configurations.uploadsUrl + cipherData + "&chatAppId=" + AppSession.getUser().chatUserId +
                            "&download=true",
                    mediaPayload
                )

            }
        }
    }


}