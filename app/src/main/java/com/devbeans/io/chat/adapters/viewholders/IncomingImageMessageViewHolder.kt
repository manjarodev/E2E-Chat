package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import android.view.View.*
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.adapter
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

//************************************************************
class IncomingImageMessageViewHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingImageMessageViewHolder<Messages>(
        itemView, payload
    ) //************************************************************
{
    //    public ItemImageBinding mBinding;
    var imageView: ImageView? = null
    var disappearIcon: ImageView? = null
    var downloadButton: LinearLayout? = null
    var progressBar: ProgressBar? = null
    var time: TextView? = null
    var userName: TextView? = null
    var dataSize: TextView? = null
    var file: File? = null
    var hasFile = false
    var metaData: MetaData? = null
    var backgroundLayout: RelativeLayout? = null
    var messages: Messages? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null
    val TAG = Log.tag(IncomingImageMessageViewHolder::class.java)

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        time.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)
        forwardLayout!!.visibility = if (message.payload.isForwarded) VISIBLE else GONE
        disappearIcon!!.visibility = if (message.payload.isExpire) VISIBLE else GONE
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))

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

        handleNickName(message, me)

//        if (message.payload.conversationType != null) {
//            if (message.payload.conversationType.equals("one-to-one", ignoreCase = true)) {
//                userName!!.visibility = View.GONE
//            } else {
//                val contact = MainApp.appContext?.contactsDao?
//                    .getContact(message.payload.senderId)
//                if (contact != null) {
//                    userName!!.text = contact.name
//                } else userName!!.text = message.payload.senderId
//            }
//        }
        handleDownloading(message)
    }

    private fun handleDownloading(message: Messages) {
        val currentString = message.payload.data
        currentString?.let {
            val separated = currentString!!.split("@@".toRegex()).toTypedArray()
            val data = separated[0] // this will contain "Fruit"
            if (separated.size > 1) {
                val gson = Gson()
                metaData = gson.fromJson(separated[1], MetaData::class.java)
            }
            file = File(MainApp.imagesPathReceive + "/" + data)
            if (file!!.exists() && file!!.isFile) {
                handleHasFile(message)
            } else {
                hasFile = false
                downloadButton!!.visibility =
                    if (!message.payload?.isDownloading!!) VISIBLE else GONE
                progressBar!!.visibility = if (message.payload?.isDownloading!!) VISIBLE else GONE

                dataSize!!.text =
                    Utills.getSize(metaData!!.size.toLong()) + " - " + metaData!!.extention
            }
            downloadButton!!.setOnClickListener {
                handleDownloadClick(message, data)
            }
            handleDownloader(message)
        } ?: run {
            Log.e(IncomingImageMessageViewHolder::class.java.simpleName, "Data was empty")
        }
    }

    private fun handleDownloader(message: Messages) {
        handleSimpleDownloader(message)

        handleAutoDownloader(message)
    }

    private fun handleAutoDownloader(message: Messages) {

        MessageAdapter.context?.let {
            if (SettingsValues.getAutoDownload()) {
                when (message.payload?.conversationType) {
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                        handleOneToOneDownloader(message)
                    }
                    Constants.TYPES.CONVERSATION_GROUP -> {
                        handleGroupDownloader(message)
                    }
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                        handleAnonymousDownloader(message)
                    }
                }

            }
        }
    }

    private fun handleAnonymousDownloader(message: Messages) {
        DownloaderAnonymousGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    hasFile = true

                    message.payload.type = "image"
                    if (file!!.absolutePath.equals(
                            file1.absolutePath, ignoreCase = true
                        )
                    ) {
                        Log.e(TAG, Constants.DOWNLOADER_ONE_TO_ONE)
                        val con = appContext?.conversationsDao?.getConversation(
                            message.payload.conversationId
                        )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }

                        if (progressBar!!.visibility == VISIBLE) {
                            progressBar!!.visibility = GONE
                            downloadButton!!.visibility = GONE
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId, file1.path
                            )
                            messages!!.payload.filePath = file1.path
                            Glide.with(appContext!!).load(file1).into(imageView!!)
                            adapter!!.notifyItemChanged(adapterPosition)
                        }
                    }
                }
            }
        }
    }

    private fun handleGroupDownloader(message: Messages) {
        DownloaderGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    hasFile = true

                    message.payload.type = "image"
                    if (file!!.absolutePath.equals(
                            file1.absolutePath, ignoreCase = true
                        )
                    ) {
                        Log.e(TAG, Constants.DOWNLOADER_ONE_TO_ONE)
                        val con = appContext?.conversationsDao?.getConversation(
                            message.payload.conversationId
                        )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }

                        if (progressBar!!.visibility == VISIBLE) {
                            progressBar!!.visibility = GONE
                            downloadButton!!.visibility = GONE
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId, file1.path
                            )
                            messages!!.payload.filePath = file1.path
                            Glide.with(appContext!!).load(file1).into(imageView!!)
                            adapter!!.notifyItemChanged(adapterPosition)
                        }
                    }
                }
            }
        }
    }

    private fun handleOneToOneDownloader(message: Messages) {
        DownloaderOneToOne.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    hasFile = true

                    message.payload.type = "image"
                    if (file!!.absolutePath.equals(
                            file1.absolutePath, ignoreCase = true
                        )
                    ) {
                        Log.e(TAG, Constants.DOWNLOADER_ONE_TO_ONE)
                        val con = appContext?.conversationsDao?.getConversation(
                            message.payload.conversationId
                        )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }

                        if (progressBar!!.visibility == VISIBLE) {
                            progressBar!!.visibility = GONE
                            downloadButton!!.visibility = GONE
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId, file1.path
                            )
                            messages!!.payload.filePath = file1.path
                            Glide.with(appContext!!).load(file1).into(imageView!!)
                            adapter!!.notifyItemChanged(adapterPosition)
                        }
                    }
                }
            }
        }
    }

    private fun handleSimpleDownloader(message: Messages) {
        Downloader.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    hasFile = true
                    message.payload.type = "image"
                    if (file!!.absolutePath.equals(file1.absolutePath, ignoreCase = true)) {
                        val con =
                            appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }

                        if (progressBar!!.visibility == VISIBLE) {
                            progressBar!!.visibility = GONE
                            downloadButton!!.visibility = GONE
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId, file1.path
                            )
                            messages!!.payload.filePath = file1.path
                            Glide.with(appContext!!).load(file1).into(imageView!!)
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
        appContext?.messagesDao?.updateMessageDownloading(
            message.payload.messageId, true
        )
        downloadButton!!.visibility = GONE
        progressBar!!.visibility = VISIBLE
        message.filePath = file!!.absolutePath
        val cipherData = EncryptionUtils.encryptDataDownload(data)
        Downloader.instance!!.download(
            file!!.absolutePath,
            Configurations.uploadsUrl + cipherData + "&chatAppId=" + AppSession.getUser().chatUserId + "&download=true",
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

    private fun handleHasFile(message: Messages) {
        hasFile = true
        Glide.with(appContext!!).load(file).into(imageView!!)

        if (message.payload.filePath == null) {
            message.payload.filePath = file!!.path
            appContext?.messagesDao?.updateFilePath(
                message.payload.messageId, file!!.path
            )
        }

        downloadButton!!.visibility = GONE
    }

    private fun handleNickName(message: Messages, me: ConversationMember?) {
        message.payload.conversationType?.let {
            when {
                (message.payload.conversationType.equals("one-to-one", ignoreCase = true)) -> {
                    userName!!.visibility = GONE
                }
                (message.payload.conversationType.equals(
                    Constants.TYPES.CONVERSATION_GROUP, ignoreCase = true
                )) -> {
                    appContext?.contactsDao?.getContact(message.payload.senderId)?.let { contact ->
                        contact.let {
                            userName!!.text = contact.name
                        }
                    } ?: run {
                        me?.let {
                            if (!me.chatNickName.isNullOrEmpty()) {
                                if (me.chatNickName!!.trim().isNotEmpty()) {
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
                else -> {
                    userName!!.text = message.payload.senderId
                }

            }

        }
    }

    private fun init(itemView: View) {
        imageView = itemView.findViewById(R.id.image)
        time = itemView.findViewById(R.id.textview_time_sent)
        userName = itemView.findViewById(R.id.tv_group_member_name)
        downloadButton = itemView.findViewById(R.id.download)
        progressBar = itemView.findViewById(R.id.loading)
        dataSize = itemView.findViewById(R.id.tv_size)
        backgroundLayout = itemView.findViewById(R.id.mainlayout)
        disappearIcon = itemView.findViewById(R.id.image_disappear_receive)
        bubbleView = itemView.findViewById(R.id.receiving_image_layout_bubble)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_receive_image)
        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {

            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            true
        })
        backgroundLayout!!.setOnClickListener(View.OnClickListener {
            getInstance()!!.onMessageViewClick(
                itemView, messages!!
            )
        })
    }

    init {
        init(itemView)
    }
}