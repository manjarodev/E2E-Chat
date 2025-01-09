package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.adapter
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.adapters.MessageAdapter
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.models.MetaData
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.downloaders.Downloader
import com.devbeans.io.chat.utils.downloaders.DownloaderAnonymousGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderOneToOne
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import com.stfalcon.chatkit.messages.MessageHolders
import java.io.File

class IncomingFileMessageViewHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingTextMessageViewHolder<Messages>(itemView, payload) {
    var imageView: ImageView? = null
    var downloadButton: ImageView? = null
    var disappearIcon: ImageView? = null
    var progressBar: ProgressBar? = null
    var time: TextView? = null
    var fileName: TextView? = null
    var fileSize: TextView? = null
    var userName: TextView? = null
    var file: File? = null
    var messages: Messages? = null
    var backgroundLayout: RelativeLayout? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        time.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)
        disappearIcon!!.visibility = if (message.payload.isExpire) View.VISIBLE else View.GONE
        forwardLayout!!.visibility = if (message.payload.isForwarded) View.VISIBLE else View.GONE


        fileName!!.text = "File"

        var me: ConversationMember? = null

        if (!message.payload.conversationId.isNullOrEmpty())

            MainApp.appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                ?.let { con ->
                    me = con.conversationMembers?.find { members ->
                        message.payload.senderId.equals(members.memberId)
                    }
                }

        handleNickName(message, me)


//            }
//        }
        val path = Configurations.uploadsUrl + message.payload.data + "&download=false"
        handleDownloader(message)
    }

    private fun handleDownloader(message: Messages) {
        val currentString = message.payload.data
        currentString?.let {
            val separated = currentString!!.split("@@".toRegex()).toTypedArray()
            val data = separated[0] // this will contain "Fruit"
            val gson = Gson()
            val metaData = gson.fromJson(separated[1], MetaData::class.java)
            fileName!!.text = metaData.name
            fileSize!!.visibility = View.VISIBLE
            fileSize!!.text = Utills.getSize(metaData.size.toLong()) + " - " + metaData.extention
//        file = File(appContext!!.filesDir.path + data)
            file = File(MainApp.filesPathReceive + "/" + data)
            if (file!!.exists() && file!!.isFile) {
                if (message.payload.filePath == null) {
                    message.payload.filePath = file!!.path
                    MainApp.appContext?.messagesDao?.updateFilePath(
                        message.payload.messageId,
                        file!!.path
                    )
                }
            } else {
                downloadButton!!.visibility =
                    if (!message.payload?.isDownloading!!) View.VISIBLE else View.GONE
                progressBar!!.visibility =
                    if (message.payload?.isDownloading!!) View.VISIBLE else View.GONE
//                downloadButton!!.visibility = View.VISIBLE
            }
            downloadButton!!.setOnClickListener {
                handleDownloadClick(message, data)
            }
            handleSimpleDownload(message, metaData)
            handleAutoDownloads(message, metaData)
        } ?: run {
            Log.e(IncomingFileMessageViewHolder::class.java.simpleName, "Data was empty")
        }
    }

    private fun handleSimpleDownload(message: Messages, metaData: MetaData?) {
        Downloader.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    if (file!!.absolutePath.equals(file1.absolutePath, ignoreCase = true)) {
                        val con =
                            MainApp.appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }
                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            downloadButton!!.visibility = View.GONE
                            fileSize!!.visibility = View.VISIBLE
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            fileSize!!.text =
                                Utills.getSize(metaData?.size?.toLong()!!) + "-" + metaData.sizeUnit
                            adapter!!.notifyItemChanged(adapterPosition)
                        }
                    }
                }
            }
        }
    }

    private fun handleDownloadClick(message: Messages, data: String) {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        MainApp.appContext?.messagesDao?.updateMessageDownloading(
            message.payload.messageId,
            true
        )
        downloadButton!!.visibility = View.GONE
        progressBar!!.visibility = View.VISIBLE
        message.filePath = file!!.absolutePath
        val cipherData = EncryptionUtils.encryptDataDownload(data)
        Downloader.instance!!.download(
            file!!.absolutePath,
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

    private fun handleAutoDownloads(message: Messages, metaData: MetaData) {
        if (MessageAdapter.context != null && SettingsValues.getAutoDownload()) {
            when (message.payload?.conversationType) {
                Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                    handleOneToOneDownload(message, metaData)
                }
                Constants.TYPES.CONVERSATION_GROUP -> {
                    handleGroupDownload(message, metaData)
                }
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                    handelAnonymousDownload(message, metaData)
                }
            }
        }
    }

    private fun handelAnonymousDownload(message: Messages, metaData: MetaData) {
        DownloaderAnonymousGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
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
                            fileSize!!.visibility = View.VISIBLE
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            fileSize!!.text =
                                Utills.getSize(metaData.size.toLong()) + "-" + metaData.sizeUnit

                            adapter!!.notifyItemChanged(adapterPosition)
                        }
                    }
                }
            }
        }
    }

    private fun handleGroupDownload(message: Messages, metaData: MetaData) {
        DownloaderGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
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
                            fileSize!!.visibility = View.VISIBLE
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            fileSize!!.text =
                                Utills.getSize(metaData.size.toLong()) + "-" + metaData.sizeUnit

                            adapter!!.notifyItemChanged(adapterPosition)
                        }
                    }
                }
            }
        }
    }

    private fun handleOneToOneDownload(message: Messages, metaData: MetaData) {
        DownloaderOneToOne.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
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
                            fileSize!!.visibility = View.VISIBLE
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            fileSize!!.text =
                                Utills.getSize(metaData.size.toLong()) + "-" + metaData.sizeUnit
                            adapter!!.notifyItemChanged(adapterPosition)
                        }
                    }
                }
            }
        }
    }

    private fun handleNickName(message: Messages, me: ConversationMember?) {
        message.payload.conversationType?.let {
            if (message.payload.conversationType.equals("one-to-one", ignoreCase = true)) {
                userName!!.visibility = View.GONE
            } else if (message.payload.conversationType.equals(
                    Constants.TYPES.CONVERSATION_GROUP,
                    ignoreCase = true
                )
            ) {
                handleNickNameGroup(message, me)
            } else {
                userName!!.text = message.payload.senderId
            }
        }
    }

    private fun handleNickNameGroup(message: Messages, me: ConversationMember?) {
        val contact = MainApp.appContext?.contactsDao?.getContact(message.payload.senderId)
        contact?.let {
            userName!!.text = contact.name
        } ?: run {
            me?.let {
                if (!me!!.chatNickName.isNullOrEmpty()) {
                    if (me!!.chatNickName!!.trim().isNotEmpty()) {
                        userName!!.text = "~${me!!.chatNickName}"
                    } else {
                        userName!!.text = message.payload.senderId
                    }
                } else {
                    userName!!.text = message.payload.senderId
                }
            } ?: run {
                userName!!.text = message.payload.senderId
            }
        }
    }

    private fun init(itemView: View) {
        time = itemView.findViewById(R.id.textview_time_sent)
        fileName = itemView.findViewById(R.id.tv_file_name)
        fileSize = itemView.findViewById(R.id.tv_file_size)
        downloadButton = itemView.findViewById(R.id.iv_download)
        progressBar = itemView.findViewById(R.id.loading)
        userName = itemView.findViewById(R.id.tv_group_member_name)
        backgroundLayout = itemView.findViewById(R.id.sendingTextMessageLayout)
        bubbleView = itemView.findViewById(R.id.outgoing_layout_bubble)
        disappearIcon = itemView.findViewById(R.id.file_disappear_receive)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_receive_file)
        backgroundLayout!!.setOnLongClickListener {
            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            false
        }
    }

    init {
        init(itemView)
    }
}