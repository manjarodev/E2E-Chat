package com.devbeans.io.chat.adapters.viewholders


import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.adapters.MessageAdapter
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.downloaders.Downloader
import com.devbeans.io.chat.utils.downloaders.DownloaderAnonymousGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderOneToOne
import com.devbeans.io.chat.utils.logging.Log
import com.stfalcon.chatkit.messages.MessageHolders
import java.io.File

class IncomingConfidentialTextMessageViewHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingTextMessageViewHolder<Messages>(itemView, payload) {
    var textMessage: TextView? = null
    var tvTime: TextView? = null
    var name: TextView? = null
    var edited: TextView? = null
    var backgroundLayout: RelativeLayout? = null
    var messages: Messages? = null
    var disappearIcon: ImageView? = null
    var viewOnceIcon: ImageView? = null
    var bubbleView: ConstraintLayout? = null
    var downloadButton: LinearLayout? = null
    var progressBar: ProgressBar? = null
    var hasFile = false
//    var forwardLayout: LinearLayout? = null

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
        handleEditedDeleted(message)
        tvTime!!.text =
            DateTime.getFormattedTimeOnly(message.payload.createdAt)
        var me: ConversationMember? = null

        if (!message.payload.conversationId.isNullOrEmpty())

            appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                ?.let { con ->
                    me = con.conversationMembers?.find { members ->
                        message.payload.senderId.equals(
                            members.memberId
                        )
                    }
                }


        message.payload.conversationType?.let {
            handlePayloadName(message, me)
        }

        val currentString = message.payload.data
        val separated = currentString?.split("@@".toRegex())?.toTypedArray()!!
        val data = separated[0]

        textMessage?.text =
            AndroidUtil.getString(
                if (message.payload.isViewOnce && message.payload.isOpened) R.string.opened else R.string.tap_to_reveal
            )
        val file = when (message.payload.type) {
            Constants.TYPES.VIDEO -> {
                MainApp.videoPathReceive
            }
            Constants.TYPES.FILE -> MainApp.filesPathReceive
            Constants.TYPES.AUDIO -> MainApp.audioPathReceive
            Constants.TYPES.IMAGE -> MainApp.imagesPathReceive
            else -> {
                MainApp.cachePath
            }
        }?.let { File("$it/$data") }

        handleMedia(file, message, data)
    }

    private fun handleMedia(file: File?, message: Messages, data: String) {
        if (file!!.exists() && file!!.isFile) {
            textMessage?.setCompoundDrawablesWithIntrinsicBounds(
                if (message.payload.isViewOnce && message.payload.isOpened) R.drawable.ic_view_once_opened_receive else if (message.payload.isViewOnce) R.drawable.ic_view_once_receive else R.drawable.ic_confidentiality_receive,
                0,
                0,
                0
            )
            downloadButton!!.visibility = View.GONE
        } else {
            handleDownloadMedia(file, message, data)

        }
    }

    private fun handleDownloadMedia(file: File, message: Messages, data: String) {
        downloadButton!!.visibility =
            if (!message.payload?.isDownloading!! && !message.payload.isOpened && !message.payload?.type.equals(
                    Constants.TYPES.TEXT
                )
            ) View.VISIBLE else View.GONE
        if (message.payload.isViewOnce && message?.payload?.isViewed!!) {
            textMessage?.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_view_once_opened_receive,
                0,
                0,
                0
            )
        }

        if (message.payload?.type.equals(
                Constants.TYPES.TEXT
            )
        ) {
            textMessage?.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_confidentiality_receive,
                0,
                0,
                0
            )
        }

        progressBar!!.visibility =
            if (message.payload?.isDownloading!! && !message.payload.isOpened && !message.payload?.type.equals(
                    Constants.TYPES.TEXT
                )
            ) View.VISIBLE else View.GONE

        downloadButton?.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            downloadButton!!.visibility = View.GONE
            progressBar!!.visibility = View.VISIBLE
            appContext?.messagesDao?.updateMessageDownloading(
                message.payload.messageId,
                true
            )

            message.filePath = file.absolutePath
            val cipherData = EncryptionUtils.encryptDataDownload(data)
            Downloader.instance!!.download(
                file.absolutePath,
                Configurations.uploadsUrl + cipherData + "&chatAppId=" + AppSession.getUser().chatUserId +
                        "&download=true",
                message.payload
            )
            val messagesList: MutableList<Messages> = ArrayList()
            val downloadingFiles = AppSession.getDownloadingFiles()
            if (downloadingFiles != null && !downloadingFiles.isEmpty()) {
                messagesList.addAll(downloadingFiles)
                messagesList.add(message)
            } else {
                messagesList.add(message)
                AppSession.saveDownloadingFiles(messagesList)
            }
        }

        handleDownloader(file, message, data)

    }

    private fun handleDownloader(file: File, message: Messages, data: String) {
        if (!message.payload.isOpened) {
            Downloader.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
                file1?.let {
                    file?.let {
                        if (file.absolutePath.equals(
                                file1.absolutePath,
                                ignoreCase = true
                            )
                        ) {
                            val con =
                                appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            if (progressBar!!.visibility == View.VISIBLE) {
                                progressBar!!.visibility = View.GONE
                                downloadButton!!.visibility = View.GONE
                                appContext?.messagesDao?.updateFilePath(
                                    message.payload.messageId,
                                    file1.path
                                )
                                messages!!.payload.filePath = file1.path
                                ChatActivity.adapter!!.notifyItemChanged(adapterPosition)
                            }


                        }
                    }
                }
            }

            handleAutoDownload(file, message, data)
        }
    }

    private fun handleAutoDownload(file: File, message: Messages, data: String) {
        if (MessageAdapter.context != null && SettingsValues.getAutoDownload()) {
            when (message.payload?.conversationType) {
                Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                    handleOneToOneDownload(file, message, data)
                }
                Constants.TYPES.CONVERSATION_GROUP -> {
                    handleGroupDownload(file, message, data)
                }
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                    handeAnonymousDownload(file, message, data)
                }
            }

        }
    }

    private fun handeAnonymousDownload(file: File, message: Messages, data: String) {
        DownloaderAnonymousGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    hasFile = true
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
                        Log.e(ChatActivity.TAG, Constants.DOWNLOADER_ONE_TO_ONE)
                        val con =
                            appContext?.conversationsDao?.getConversation(
                                message.payload.conversationId
                            )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }

                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            downloadButton!!.visibility = View.GONE
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            messages!!.payload.filePath = file1.path
                            ChatActivity.adapter!!.notifyItemChanged(
                                adapterPosition
                            )
                        }
                    }
                }
            }
        }
    }

    private fun handleGroupDownload(file: File, message: Messages, data: String) {
        DownloaderGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    hasFile = true
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
                        Log.e(ChatActivity.TAG, Constants.DOWNLOADER_ONE_TO_ONE)
                        val con =
                            appContext?.conversationsDao?.getConversation(
                                message.payload.conversationId
                            )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }

                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            downloadButton!!.visibility = View.GONE
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            messages!!.payload.filePath = file1.path
                            ChatActivity.adapter!!.notifyItemChanged(
                                adapterPosition
                            )
                        }
                    }
                }
            }
        }
    }

    private fun handleOneToOneDownload(file: File, message: Messages, data: String) {
        DownloaderOneToOne.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    hasFile = true
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
                        Log.e(ChatActivity.TAG, Constants.DOWNLOADER_ONE_TO_ONE)
                        val con =
                            appContext?.conversationsDao?.getConversation(
                                message.payload.conversationId
                            )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }

                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            downloadButton!!.visibility = View.GONE
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            messages!!.payload.filePath = file1.path
                            ChatActivity.adapter!!.notifyItemChanged(
                                adapterPosition
                            )
                        }
                    }
                }
            }
        }
    }

    private fun handlePayloadName(message: Messages, me: ConversationMember?) {
        if (message.payload.conversationType.equals("one-to-one", ignoreCase = true)) {
            name!!.visibility = View.GONE
        } else if (message.payload.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP,
                ignoreCase = true
            )
        ) {
            val contact = appContext?.contactsDao?.getContact(message.payload.senderId)
            contact?.let {
                name!!.text = contact.name
            } ?: run {
                me?.let {
                    if (!me!!.chatNickName.isNullOrEmpty()) {
                        if (me!!.chatNickName!!.trim().isNotEmpty()) {
                            name!!.text = "~${me!!.chatNickName}"
                        } else {
                            name!!.text = message.payload.senderId
                        }
                    } else {
                        name!!.text = message.payload.senderId
                    }
                } ?: run {
                    name!!.text = message.payload.senderId
                }
            }
        } else {
            name!!.text = message.payload.senderId
        }
    }

    private fun handleEditedDeleted(message: Messages) {
        disappearIcon!!.visibility =
            if (message.payload.isExpire) View.VISIBLE else View.GONE
        if (message.payload.isEdited) {
            edited!!.visibility = View.VISIBLE
        } else edited!!.visibility = View.GONE
        if (message.payload.isDeleted) {
            textMessage!!.setTypeface(textMessage!!.typeface, Typeface.ITALIC)
            textMessage!!.setTextColor(appContext!!.resources.getColor(R.color.gray_variant))
        } else {
            textMessage!!.setTypeface(textMessage!!.typeface, Typeface.NORMAL)
        }
    }

    private fun init(itemView: View) {
        textMessage = itemView.findViewById(R.id.messageText1)

        val checkFontSize = SettingsValues.getMessageFontSize()
        val checkEmojiSize = SettingsValues.getMessageEmojiSize()
        val fontSize = when {
            checkFontSize <= 22 -> {
                com.intuit.ssp.R.dimen._12ssp
            }
            else -> {
                com.intuit.ssp.R.dimen._42ssp
            }
        }
        val emojiSize = when {
            checkEmojiSize <= 22 -> {
                com.intuit.sdp.R.dimen._22sdp
            }
            checkEmojiSize <= 42 -> {
                com.intuit.sdp.R.dimen._42sdp
            }

            else -> {
                com.intuit.sdp.R.dimen._62sdp
            }
        }

        textMessage!!.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            appContext!!.resources.getDimension(fontSize)
        )
//        textMessage!!.setEmojiSize(appContext!!.resources.getDimensionPixelSize(emojiSize))


//        textMessage!!.setEmojiSize(appContext!!.resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._66sdp))
        tvTime = itemView.findViewById(R.id.text_textview_time_received)
        name = itemView.findViewById(R.id.text_tv_group_member_name)
        edited = itemView.findViewById(R.id.editedText)
        backgroundLayout = itemView.findViewById(R.id.mainlayout)
        disappearIcon = itemView.findViewById(R.id.text_disappear_receive)
        viewOnceIcon = itemView.findViewById(R.id.text_view_once_receive)
        bubbleView = itemView.findViewById(R.id.text_incoming_layout_bubble_receive)
        downloadButton = itemView.findViewById(R.id.download)
        progressBar = itemView.findViewById(R.id.loading)
//        forwardLayout = itemView.findViewById(R.id.layout_forwarded_receive_text)

        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
//            backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.blue_10))
            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            true
        })

        backgroundLayout?.setOnClickListener {
            if (!messages?.payload?.type?.equals(Constants.TYPES.TEXT)!! && messages?.payload?.filePath != null) {
                if (!messages?.payload?.isViewOnce!!) {
                    getInstance()?.onConfidentialClick(messages!!, adapterPosition, bubbleView!!)
                } else {
                    getInstance()?.onViewOnceClicked(messages!!)
                    messages!!.payload.isOpened = true
                    ChatActivity.adapter!!.notifyItemChanged(adapterPosition)
                }

            } else if (messages?.payload?.type?.equals(Constants.TYPES.TEXT)!!) {
                getInstance()?.onConfidentialClick(messages!!, adapterPosition, bubbleView!!)
            }
        }
    }

    init {
        init(itemView)
    }
}