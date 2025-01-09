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
import com.devbeans.io.chat.activities.ChatActivity.Companion.TAG
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

class IncomingViewOnceTextMessageViewHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingTextMessageViewHolder<Messages>(itemView, payload) {
    var textMessage: TextView? = null
    var tvTime: TextView? = null
    var name: TextView? = null
    var edited: TextView? = null
    var backgroundLayout: RelativeLayout? = null
    var messages: Messages? = null
    var disappearIcon: ImageView? = null
    var bubbleView: ConstraintLayout? = null
    var downloadButton: LinearLayout? = null
    var progressBar: ProgressBar? = null
    var hasFile = false
//    var forwardLayout: LinearLayout? = null

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
        disappearIcon!!.visibility =
            if (message.payload.isExpire) View.VISIBLE else View.GONE
        if (message.payload.isEdited) {
            edited!!.visibility = View.VISIBLE
        } else edited!!.visibility = View.GONE
        if (message.payload.isDeleted) {
            textMessage!!.setTypeface(textMessage!!.typeface, Typeface.ITALIC)
            textMessage!!.setTextColor(appContext!!.resources.getColor(R.color.faded_black_30))
        } else {
            textMessage!!.setTypeface(textMessage!!.typeface, Typeface.NORMAL)
        }
        tvTime!!.text =
            DateTime.getFormattedTimeOnly(message.payload.createdAt)

        var me: ConversationMember? = null

        if (!message.payload.conversationId.isNullOrEmpty())

            me = appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                ?.let { con ->
                    con.conversationMembers?.find { members ->
                        message.payload.senderId.equals(
                            members.memberId
                        )
                    }
                }

        message.payload.conversationType?.let {
            handleNickName(message, me)
        }

        handleDownloader(message)
    }

    private fun handleDownloader(message: Messages) {
        val currentString = message.payload.data
        currentString?.let {
            val separated = currentString!!.split("@@".toRegex()).toTypedArray()
            val data = separated[0] // this will contain "Fruit"


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

            textMessage?.text =
                AndroidUtil.getString(
                    if (message.payload.isOpened) R.string.opened else if (message.payload.type.equals(
                            Constants.TYPES.VIDEO
                        )
                    ) R.string.video else R.string.image
                )

            if (file!!.exists() && file!!.isFile) {
                textMessage?.setCompoundDrawablesWithIntrinsicBounds(
                    if (message.payload.isOpened) R.drawable.ic_view_once_opened_receive else R.drawable.ic_view_once_receive,
                    0,
                    0,
                    0
                )
                downloadButton!!.visibility = View.GONE
            } else {
                handleSimpleDownload(message, data, file)
            }


        }
    }

    private fun handleSimpleDownload(message: Messages, data: String, file: File) {
        downloadButton!!.visibility =
            if (!message.payload?.isDownloading!! && !message.payload.isOpened) View.VISIBLE else View.GONE
        if (message?.payload?.isViewed!!) {
            textMessage?.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_view_once_opened_receive,
                0,
                0,
                0
            )
        }
        progressBar!!.visibility =
            if (message.payload?.isDownloading!! && !message.payload.isOpened) View.VISIBLE else View.GONE

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

        handleSimpleDownloads(message, file)

    }

    private fun handleSimpleDownloads(message: Messages, file: File) {
        if (!message.payload.isOpened) {
            Downloader.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
                file1?.let {
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
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            messages!!.payload.filePath = file1.path
                            ChatActivity.adapter!!.notifyItemChanged(adapterPosition)
                        }


                    }
                }
            }

            handleAutoDownload(message, file)
        }
    }

    private fun handleAutoDownload(message: Messages, file: File) {
        MessageAdapter.context?.let {
            if (SettingsValues.getAutoDownload()) {
                when (message.payload?.conversationType) {
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                        handleOneToOneDownload(message, file)
                    }
                    Constants.TYPES.CONVERSATION_GROUP -> {
                        handleGroupDownload(message, file)
                    }
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                        handleAnonymousDownload(message, file)
                    }
                }

            }
        }
    }

    private fun handleAnonymousDownload(message: Messages, file: File) {
        DownloaderAnonymousGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                hasFile = true

                message.payload.type = "image"
                if (file!!.absolutePath.equals(
                        file1.absolutePath,
                        ignoreCase = true
                    )
                ) {
                    Log.e(TAG, "Downloader One to One")
                    val con =
                        MainApp.appContext?.conversationsDao?.getConversation(
                            message.payload.conversationId
                        )
                    if (con!!.isAutoSaveVault) {
                        getInstance()!!.autoSaveToVault(file1.path)
                    }

                    if (progressBar!!.visibility == View.VISIBLE) {
                        progressBar!!.visibility = View.GONE
                        downloadButton!!.visibility = View.GONE
                        MainApp.appContext?.messagesDao?.updateFilePath(
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

    private fun handleGroupDownload(message: Messages, file: File) {
        DownloaderGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                hasFile = true

                if (file!!.absolutePath.equals(
                        file1.absolutePath,
                        ignoreCase = true
                    )
                ) {
                    Log.e(TAG, "Downloader One to One")
                    val con =
                        MainApp.appContext?.conversationsDao?.getConversation(
                            message.payload.conversationId
                        )
                    if (con!!.isAutoSaveVault) {
                        getInstance()!!.autoSaveToVault(file1.path)
                    }

                    if (progressBar!!.visibility == View.VISIBLE) {
                        progressBar!!.visibility = View.GONE
                        downloadButton!!.visibility = View.GONE
                        MainApp.appContext?.messagesDao?.updateFilePath(
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

    private fun handleOneToOneDownload(message: Messages, file: File) {
        DownloaderOneToOne.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                hasFile = true

                if (file!!.absolutePath.equals(
                        file1.absolutePath,
                        ignoreCase = true
                    )
                ) {
                    Log.e(TAG, Constants.DOWNLOADER_ONE_TO_ONE)
                    val con =
                        MainApp.appContext?.conversationsDao?.getConversation(
                            message.payload.conversationId
                        )
                    if (con!!.isAutoSaveVault) {
                        getInstance()!!.autoSaveToVault(file1.path)
                    }

                    if (progressBar!!.visibility == View.VISIBLE) {
                        progressBar!!.visibility = View.GONE
                        downloadButton!!.visibility = View.GONE
                        MainApp.appContext?.messagesDao?.updateFilePath(
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

    private fun handleNickName(message: Messages, me: ConversationMember?) {
        if (message.payload.conversationType.equals("one-to-one", ignoreCase = true)) {
            name!!.visibility = View.GONE
        } else if (message.payload.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP,
                ignoreCase = true
            )
        ) {
            appContext?.contactsDao?.getContact(message.payload.senderId)?.let { contact ->
                name!!.text = contact.name
            } ?: run {
                me?.let {
                    if (!me.chatNickName.isNullOrEmpty()) {
                        if (me.chatNickName!!.trim().isNotEmpty()) {
                            name!!.text = "~${me.chatNickName}"
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

        tvTime = itemView.findViewById(R.id.text_textview_time_received)
        name = itemView.findViewById(R.id.text_tv_group_member_name)
        edited = itemView.findViewById(R.id.editedText)
        backgroundLayout = itemView.findViewById(R.id.mainlayout)
        disappearIcon = itemView.findViewById(R.id.text_disappear_receive)
        bubbleView = itemView.findViewById(R.id.text_incoming_layout_bubble_receive)
        downloadButton = itemView.findViewById(R.id.download)
        progressBar = itemView.findViewById(R.id.loading)
//        forwardLayout = itemView.findViewById(R.id.layout_forwarded_receive_text)

        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            true
        })



        backgroundLayout?.setOnClickListener {


            if (messages?.payload?.filePath != null) {
                getInstance()?.onViewOnceClicked(messages!!)
                messages!!.payload.isOpened = true
                ChatActivity.adapter!!.notifyItemChanged(adapterPosition)
            }

        }
    }

    init {
        init(itemView)
    }
}