package com.devbeans.io.chat.adapters.viewholders

import android.content.Intent
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.adapter
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.activities.ScreenShowingActivity
import com.devbeans.io.chat.adapters.MessageAdapter
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
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
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.messages.MessageHolders
import java.io.File

class IncomingVideoMessageViewHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingImageMessageViewHolder<Messages>(itemView, payload) {
    var imageView: ImageView? = null
    var playButton: ImageView? = null
    var disappearIcon: ImageView? = null
    var downloadButton: LinearLayout? = null
    var time: TextView? = null
    var userNAme: TextView? = null
    var dataSize: TextView? = null
    var videoTime: TextView? = null
    var progressBar: ProgressBar? = null
    var file: File? = null
    var hasFile = false
    var messages: Messages? = null
    var backgroundLayout: RelativeLayout? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null

    override fun getImageLoader(): ImageLoader {
        return super.getImageLoader()
    }

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
        time.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)

        disappearIcon!!.visibility =
            if (message.payload.isExpire) View.VISIBLE else View.GONE

        forwardLayout!!.visibility = if (message.payload.isForwarded) View.VISIBLE else View.GONE

        var con: Conversation? = null
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


        if (message.payload.conversationType != null) {
            if (message.payload.conversationType.equals("one-to-one", ignoreCase = true)) {
                userNAme!!.visibility = View.GONE
            } else {
                val contact = appContext?.contactsDao?.getContact(message.payload.senderId)
                if (contact != null) {
                    userNAme!!.text = contact.name
                } else userNAme!!.text = message.payload.senderId
            }
        }
        handleDownloading(message)
    }

    private fun handleDownloading(message: Messages) {
        val currentString = message.payload.data
        currentString?.let {
            val separated = currentString!!.split("@@".toRegex()).toTypedArray()
            val data = separated[0] // this will contain "Fruit"
            val gson = Gson()
            val metaData = gson.fromJson(separated[1], MetaData::class.java)
            file = File(MainApp.videoPathReceive + "/" + data)
//        file = File(appContext!!.filesDir.path + data)
            handleOtherDownload(message)
            if (file!!.exists() && file!!.isFile) {
               handleHasFile(message)
            } else {
                hasFile = false
                downloadButton!!.visibility =
                    if (!message.payload?.isDownloading!!) View.VISIBLE else View.GONE
                progressBar!!.visibility =
                    if (message.payload?.isDownloading!!) View.VISIBLE else View.GONE
//                downloadButton!!.visibility = View.VISIBLE
                dataSize!!.text =
                    Utills.getSize(metaData.size.toLong()) + " - " + metaData.extention
            }
            downloadButton!!.setOnClickListener {
                handleDownloadClick(message, data)
            }
            handleDownloader(message)
        } ?: run {
            Log.e(IncomingVideoMessageViewHolder::class.java.simpleName, "Data was empty")
        }
    }

    private fun handleHasFile(message: Messages) {
        hasFile = true
        Glide.with(appContext!!).load(file).into(imageView!!)
        if (message.payload.filePath == null) {
            message.payload.filePath = file!!.path
            appContext?.messagesDao?.updateFilePath(message.payload.messageId, file!!.path)
        }
        downloadButton!!.visibility = View.GONE
        playButton!!.visibility = View.VISIBLE
        if (file!!.length() > 0) videoTime!!.text =
            Utills.getDuration(appContext, file!!.path)
    }

    private fun handleDownloader(message: Messages) {
        Downloader.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    if (file!!.absolutePath.equals(file1.absolutePath, ignoreCase = true)) {
                        val con =
                            appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }
                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            playButton!!.visibility = View.VISIBLE
//                                Notify.Toast("" + message.payload.type)
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            Glide.with(appContext!!).load(file1).into(imageView!!)
                            message.payload.filePath = file1.path
                            adapter!!.notifyItemChanged(adapterPosition)
                            hasFile = true
                        }
                    }
                }
            }
        }

        handleAutoDownload(message)
    }

    private fun handleAutoDownload(message: Messages) {

        MessageAdapter.context?.let {
            if (SettingsValues.getAutoDownload()) {
                when (message.payload?.conversationType) {
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                        handleOneToOneDownload(message)
                    }
                    Constants.TYPES.CONVERSATION_GROUP -> {
                        handleGroupDownload(message)
                    }
                    Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                        handleAnonymousDownload(message)
                    }
                }
            }
        }
    }

    private fun handleAnonymousDownload(message: Messages) {
        DownloaderAnonymousGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
                        val con =
                            appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }
                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            playButton!!.visibility = View.VISIBLE
//                                            Notify.Toast("" + message.payload.type)
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            Glide.with(appContext!!).load(file1).into(imageView!!)
                            message.payload.filePath = file1.path
                            adapter!!.notifyItemChanged(adapterPosition)
                            hasFile = true
                        }
                    }
                }
            }
        }
    }

    private fun handleGroupDownload(message: Messages) {
        DownloaderGroup.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
                        val con =
                            appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }
                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            playButton!!.visibility = View.VISIBLE
//                                            Notify.Toast("" + message.payload.type)
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            Glide.with(appContext!!).load(file1).into(imageView!!)
                            message.payload.filePath = file1.path
                            adapter!!.notifyItemChanged(adapterPosition)
                            hasFile = true
                        }
                    }
                }
            }
        }
    }

    private fun handleOneToOneDownload(message: Messages) {
        DownloaderOneToOne.instance!!.fileMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { file1: File? ->
            file1?.let {
                file?.let {
                    if (file!!.absolutePath.equals(
                            file1.absolutePath,
                            ignoreCase = true
                        )
                    ) {
                        val con =
                            appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }
                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            playButton!!.visibility = View.VISIBLE
//                                            Notify.Toast("" + message.payload.type)
                            appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            Glide.with(appContext!!).load(file1).into(imageView!!)
                            message.payload.filePath = file1.path
                            adapter!!.notifyItemChanged(adapterPosition)
                            hasFile = true
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
        if (!hasFile) {
            appContext?.messagesDao?.updateMessageDownloading(
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
        } else {
            showVideo(message)
        }
    }

    private fun handleOtherDownload(message: Messages) {
        if (!AppSession.getDownloadingFiles().isNullOrEmpty()
        ) {
            val messages = AppSession.getDownloadingFiles()
            if (messages.contains(message)) {
                progressBar!!.visibility = View.VISIBLE
                playButton!!.visibility = View.GONE
            } else {
                progressBar!!.visibility = View.GONE
//                    playButton!!.visibility = View.VISIBLE
            }
        }
    }

    private fun init(itemView: View) {
        imageView = itemView.findViewById(R.id.sentTxt)
        videoTime = itemView.findViewById(R.id.textview_time_video)
        time = itemView.findViewById(R.id.textview_time_sent)
        userNAme = itemView.findViewById(R.id.tv_group_member_name)
        downloadButton = itemView.findViewById(R.id.download)
        progressBar = itemView.findViewById(R.id.loading)
        dataSize = itemView.findViewById(R.id.tv_size)
        playButton = itemView.findViewById(R.id.play_button)
        backgroundLayout = itemView.findViewById(R.id.mainlayout)
        disappearIcon = itemView.findViewById(R.id.video_disappear_receive)
        bubbleView = itemView.findViewById(R.id.receiving_image_layout_bubble)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_receive_video)


        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            true
        })
        backgroundLayout!!.setOnClickListener(View.OnClickListener {
            getInstance()!!.onMessageViewClick(
                itemView,
                messages!!
            )
        })
    }

    private fun showVideo(message: Messages) {
        if (!message.payload.type.equals("text", ignoreCase = true)) {
            val file = File(appContext!!.filesDir.path + message.payload.data)
            if (file.exists()) {
                if (message.payload.type.equals("file", ignoreCase = true)) {
                    Notify.Toast("Coming soon")
                    return
                }
                getInstance()!!
                    .startActivity(
                        Intent(
                            appContext,
                            ScreenShowingActivity::class.java
                        ).putExtra("message", message)
                    )
            } else Notify.Toast("Please download first")
        }
    }

    init {
        init(itemView)
    }
}