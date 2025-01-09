package com.devbeans.io.chat.adapters.viewholders

import android.media.MediaPlayer
import android.os.Handler
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
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
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.models.MetaData
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.audio.AudioPlayer
import com.devbeans.io.chat.utils.downloaders.Downloader
import com.devbeans.io.chat.utils.downloaders.DownloaderAnonymousGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderGroup
import com.devbeans.io.chat.utils.downloaders.DownloaderOneToOne
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import com.stfalcon.chatkit.messages.MessageHolders
import java.io.File
import java.io.IOException
import java.util.*

class IncomingVoiceMessageViewHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingTextMessageViewHolder<Messages>(itemView, payload) {
    private val tvDuration: TextView? = null
    private var tvTime: TextView? = null
    private var userName: TextView? = null
    private var mPlayer: AudioPlayer? = null
    private var mAudioPrgs: SeekBar? = null
    private var tvTimeSent: TextView? = null
    private var mPlayButton: ImageView? = null
    private var downloadButton: ImageView? = null
    var disappearIcon: ImageView? = null
    var progressBar: ProgressBar? = null
    var isPlay = false
    var isStarted = false
    private var updateSeekbar: Runnable? = null
    private var seekbarHandler: Handler? = null
    var mMessage: Messages? = null
    var prevMessage: Messages? = null
    var cardView: CardView? = null
    var file: File? = null
    var mediaPlayer = adapter!!.mediaPlayer
    var timerClass = Timer()
    var backgroundLayout: RelativeLayout? = null
    var bubbleText: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null


    private fun init(itemView: View) {
        tvTimeSent = itemView.findViewById(R.id.textview_time_sent)
        tvTime = itemView.findViewById(R.id.tv_audio_time_receive)
        mAudioPrgs = itemView.findViewById(R.id.seekBar_audio_receive)
        mPlayButton = itemView.findViewById(R.id.iv_file_play_pause_receive)
        downloadButton = itemView.findViewById(R.id.iv_download_receive_audio)
        progressBar = itemView.findViewById(R.id.loading_receive)
        cardView = itemView.findViewById(R.id.cv_file_receive)
        mAudioPrgs!!.setTag(adapterPosition)
        userName = itemView.findViewById(R.id.tv_group_member_name)
        backgroundLayout = itemView.findViewById(R.id.sendingTextMessageLayout)
        disappearIcon = itemView.findViewById(R.id.audio_disappear_receive)
        this.bubbleText = itemView.findViewById(R.id.outgoing_layout_bubble)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_receive_audio)

        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
            getInstance()!!.onLongClick(mMessage!!, adapterPosition, bubbleText!!)
            false
        })
    }

    override fun onBind(message: Messages) {
        super.onBind(message)
        tvTimeSent!!.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)
        disappearIcon!!.visibility = if (message.payload.isExpire) View.VISIBLE else View.GONE
        forwardLayout!!.visibility = if (message.payload.isForwarded) View.VISIBLE else View.GONE

        Log.d("TAG", "IncomingVoiceMessageViewHolder: ")
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
        if (message.payload.conversationType != null) {
            if (message.payload.conversationType.equals("one-to-one", ignoreCase = true)) {
                userName!!.visibility = View.GONE
            } else {
                userName!!.visibility = View.VISIBLE
                MainApp.appContext?.contactsDao?.getContact(message.payload.senderId)
                    ?.let { contact ->
                        userName!!.text = contact.name
                    } ?: run {
                    userName!!.text = message.payload.senderId
                }
            }
        }
        mMessage = message
        mPlayer = adapter!!.mediaPlayer
        handleDownloader(message)
    }

    private fun handleDownloader(message: Messages) {
        val currentString = message.payload.data
        currentString?.let {
            val separated = currentString!!.split("@@".toRegex()).toTypedArray()
            val data = separated[0] // this will contain "Fruit"
            val gson = Gson()
            val metaData = gson.fromJson(separated[1], MetaData::class.java)
//        file = File(appContext!!.filesDir.path + data)
            file = File(MainApp.audioPathReceive + "/" + data)
            if (file!!.exists()) {
                tvTime!!.text = Utills.getDuration(getInstance(), file!!.absolutePath)
            }
            handleViews(message)
            downloadButton!!.setOnClickListener {
                handleDownloadClick(message, data)
            }
            handleSimpleDownload(message)
            messagesMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { prevMessage: Messages? ->
                prevMessage?.let {
                    handlePrevMessage(prevMessage)
                }
            }
            OutgoingVoiceMessageViewHolder.messagesMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { prevMessage: Messages? ->
                prevMessage?.let {
                    if (!prevMessage.payload.messageId.equals(
                            mMessage!!.payload.messageId,
                            ignoreCase = true
                        )
                    ) {
                        mPlayButton!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_play))
                        reset()
                        if (file!!.exists()) {
                            tvTime!!.text = Utills.getDuration(getInstance(), file!!.absolutePath)
                        }
                    }
                }
            }
            mPlayButton!!.setOnClickListener {
                handlePlayClick()
            }
        } ?: run {
            Log.e(IncomingVoiceMessageViewHolder::class.java.simpleName, "Data was empty")
        }
    }

    private fun handleViews(message: Messages) {
        if (file!!.exists() && file!!.isFile) {
            if (message.payload.filePath == null) {
                message.payload.filePath = file!!.path
                MainApp.appContext?.messagesDao?.updateFilePath(
                    message.payload.messageId,
                    file!!.path
                )
            }

            cardView!!.visibility = View.VISIBLE
            mPlayButton!!.visibility = View.VISIBLE
        } else {
            cardView!!.visibility = View.GONE
            downloadButton!!.visibility =
                if (!message.payload?.isDownloading!!) View.VISIBLE else View.GONE
            progressBar!!.visibility =
                if (message.payload?.isDownloading!!) View.VISIBLE else View.GONE
//                downloadButton!!.visibility = View.VISIBLE
            mPlayButton!!.visibility = View.GONE

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

    private fun handlePlayClick() {

        if (!isStarted) {
            if (mMessage!!.isPlaying) {
                mPlayer!!.stop()
                stopAudio()
                messagesMutableLiveData.postValue(mPrev)
                playAudio(mAudioPrgs, updateSeekbar)
            } else {
                playAudio(mAudioPrgs, updateSeekbar)

            }
            return
        }
        if (isStarted) {
            if (isPlay) {
                pauseAudio()
            } else {
                //Check Here if The Data is not null of Audio
                resumeAudio()
            }
        }

    }

    private fun handleSimpleDownload(message: Messages) {
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
                            mPlayButton!!.visibility = View.VISIBLE
                            cardView!!.visibility = View.VISIBLE
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            message.payload.filePath = file1.path
                            adapter!!.notifyItemChanged(adapterPosition)
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
                            MainApp.appContext?.conversationsDao?.getConversation(
                                message.payload.conversationId
                            )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }
                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            downloadButton!!.visibility = View.GONE
                            mPlayButton!!.visibility = View.VISIBLE
                            cardView!!.visibility = View.VISIBLE
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            message.payload.filePath = file1.path
                            adapter!!.notifyItemChanged(adapterPosition)
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
                            MainApp.appContext?.conversationsDao?.getConversation(
                                message.payload.conversationId
                            )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }
                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            downloadButton!!.visibility = View.GONE
                            mPlayButton!!.visibility = View.VISIBLE
                            cardView!!.visibility = View.VISIBLE
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            message.payload.filePath = file1.path
                            adapter!!.notifyItemChanged(adapterPosition)
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
                            MainApp.appContext?.conversationsDao?.getConversation(
                                message.payload.conversationId
                            )
                        if (con!!.isAutoSaveVault) {
                            getInstance()!!.autoSaveToVault(file1.path)
                        }
                        if (progressBar!!.visibility == View.VISIBLE) {
                            progressBar!!.visibility = View.GONE
                            downloadButton!!.visibility = View.GONE
                            mPlayButton!!.visibility = View.VISIBLE
                            cardView!!.visibility = View.VISIBLE
                            MainApp.appContext?.messagesDao?.updateFilePath(
                                message.payload.messageId,
                                file1.path
                            )
                            message.payload.filePath = file1.path
                            adapter!!.notifyItemChanged(adapterPosition)
                        }
                    }
                }
            }
        }
    }

    private fun handlePrevMessage(prevMessage: Messages) {
        if (!prevMessage.payload.messageId.equals(
                mMessage!!.payload.messageId,
                ignoreCase = true
            )
        ) {
            mPlayButton!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_play))
            reset()
            if (file!!.exists()) {
                tvTime!!.text = Utills.getDuration(getInstance(), file!!.absolutePath)
            }
        }
    }

    private fun updateRunnable() {
        if (mPlayer != null && mMessage!!.isPlaying && seekbarHandler != null) {
            updateSeekbar = object : Runnable {
                override fun run() {
                    mAudioPrgs!!.progress = mPlayer!!.currentPosition
                    tvTime!!.text =
                        DateTimeUtil.milliSecondsToTimer(mPlayer!!.currentPosition.toLong())
                    if (seekbarHandler != null) seekbarHandler!!.postDelayed(this, 500)
                }
            }
        }
    }

    private fun playAudio(mAudioPrgs: SeekBar?, updateSeekbar: Runnable?) {
        mPrev = mMessage
        val my = Messages()
        my.id = mMessage!!.payload.messageId
        AppSession.setPrevMessage(my)
        if (mPrev != null) messagesMutableLiveData.postValue(mPrev)
        mMessage!!.isPlaying = true
        try {
            mPlayer!!.reset()
            mPlayer!!.setDataSource(file!!.absolutePath)
            mPlayer!!.prepare()
            mPlayer!!.start()

        } catch (e: IOException) {
            e.printStackTrace()
        }
        //Play the audio
        isPlay = true
        if (isPlay) {
            mPlayer!!.setOnCompletionListener {
                stopAudio()
                if (file!!.exists()) {
                    tvTime!!.text = Utills.getDuration(getInstance(), file!!.absolutePath)
                }
            }
            mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_pause_media))
            mAudioPrgs!!.max = mPlayer!!.duration
            mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_pause_media))
            isStarted = true
            val seekbarHandler = Handler()
            this.seekbarHandler = seekbarHandler
            this.mAudioPrgs = mAudioPrgs
            updateRunnable()
            seekbarHandler.postDelayed(this.updateSeekbar!!, 500)
            mAudioPrgs.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    // was essential for over ride
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    if (isPlay) pauseAudio()
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    val progress = seekBar.progress
                    mPlayer!!.seekTo(progress)
                    if (!isPlay) resumeAudio()
                }
            })
        }
    }

    private fun stopAudio() {
        //Stop The Audio
        mAudioPrgs!!.progress = 0
        isStarted = false
        isPlay = false
        mMessage!!.isPlaying = false
        mPlayer!!.stop()
        mPlayer!!.reset()
        mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_play))
        if (seekbarHandler != null) {
            seekbarHandler!!.sendEmptyMessageDelayed(1845, 500)
            seekbarHandler = null
        }
    }

    private fun reset() {
        //Stop The Audio
        mAudioPrgs!!.progress = 0
        mAudioPrgs?.setOnSeekBarChangeListener(null)
        isStarted = false
        isPlay = false
        mMessage!!.isPlaying = false
        mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_play))
        if (seekbarHandler != null) {
            seekbarHandler!!.sendEmptyMessageDelayed(1845, 500)
            seekbarHandler = null
        }
        mAudioPrgs!!.progress = 0
        mAudioPrgs?.setOnSeekBarChangeListener(null)
    }

    private fun pauseAudio() {
        mPlayer!!.pause()
        isPlay = false
        mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_play))
        seekbarHandler!!.removeCallbacks(updateSeekbar!!)
    }

    private fun resumeAudio() {
        try {
            mPlayer!!.start()
            isPlay = true
            mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_pause_media))
            updateRunnable()
            seekbarHandler!!.postDelayed(updateSeekbar!!, 500)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        private var mPrev: Messages? = null
        var messagesMutableLiveData = MutableLiveData<Messages?>()
    }

    init {
        init(itemView)
    }
}