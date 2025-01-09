package com.devbeans.io.chat.adapters.viewholders

import android.media.MediaPlayer
import android.net.Uri
import android.os.Handler
import android.view.View
import android.view.View.*
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.adapter
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.adapters.MessageAdapter
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.audio.AudioPlayer
import com.devbeans.io.chat.utils.components.AudioView
import com.devbeans.io.chat.utils.components.AudioView.Callbacks
import com.stfalcon.chatkit.messages.MessageHolders.OutcomingTextMessageViewHolder
import java.io.File
import java.io.IOException

class OutgoingVoiceMessageViewHolder(itemView: View, payload: Any?) :
    OutcomingTextMessageViewHolder<Messages>(itemView, payload), Callbacks {
    private var tvTime: TextView? = null
    var disappearIcon: ImageView? = null
    private var mPlayer: AudioPlayer? = null
    private var mAudioPrgs: SeekBar? = null
    private var mPlayButton: ImageView? = null
    var isPlay = false
    var isStarted = false
    private var updateSeekbar: Runnable? = null
    private var seekbarHandler: Handler? = null
    var mMessage: Messages? = null
    var backgroundLayout: RelativeLayout? = null
    var tick: ImageView? = null
    var file: File? = null
    private var tvTimeSent: TextView? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null
    private var audioView: AudioView? = null

    private fun init(itemView: View) {
        tvTime = itemView.findViewById(R.id.textview_time_sent)
        tvTimeSent = itemView.findViewById(R.id.tv_audio_time)
        mAudioPrgs = itemView.findViewById(R.id.seekBar_audio)
        mPlayButton = itemView.findViewById(R.id.iv_file_play_pause)
        tick = itemView.findViewById(R.id.text_sendTick)
        backgroundLayout = itemView.findViewById(R.id.sendingTextMessageLayout)
        disappearIcon = itemView.findViewById(R.id.audio_disappear_sent)
        bubbleView = itemView.findViewById(R.id.outgoing_layout_bubble)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_sent_audio)
//        audioView = itemView.findViewById(R.id.attachment_audio)
        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
//            backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.blue_10))
            getInstance()!!.onLongClick(mMessage!!, adapterPosition, bubbleView!!)
            false
        })

    }

    var playing_position = -1

    override fun onBind(message: Messages) {
        super.onBind(message)
        mMessage = message

        tvTimeSent!!.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)
        disappearIcon!!.visibility = if (message.payload.isExpire) View.VISIBLE else View.GONE
        forwardLayout!!.visibility = if (message.payload.isForwarded) VISIBLE else GONE

        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))

        if (message.payload.status != null) {
            when {
                (message.payload.status.equals(
                    Constants.NOT_DELIVERED, ignoreCase = true
                )) -> {
                    tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_not_sent))
                    tick!!.setPadding(8, 8, 8, 8)
                }
                (message.payload.status.equals(
                    Constants.SENT, ignoreCase = true
                )) -> {
                    tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_tick))
                    tick!!.setPadding(10, 10, 10, 10)
                }
                (message.payload.status.equals(
                    Constants.DELIVERED, ignoreCase = true
                )) -> {
                    tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_delivered))
                    tick!!.setPadding(3, 0, 0, 3)
                }
                (message.payload.status.equals(
                    Constants
                        .SEEN,
                    ignoreCase = true
                )
                        ) -> {
                    tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_seen))
                    tick!!.setPadding(3, 0, 0, 3)
                }
            }
        }


        mPlayer = adapter!!.mediaPlayer
        file = File(mMessage!!.payload.filePath)
        when {
            (file!!.exists()) -> {
                tvTime!!.text = Utills.getDuration(getInstance(), file!!.absolutePath)
            }

        }

        messagesMutableLiveData.observe((MessageAdapter.context as LifecycleOwner)) { prevMessage: Messages? ->
            if (prevMessage != null) {
                if (!prevMessage.payload.messageId.equals(
                        mMessage!!.payload.messageId, ignoreCase = true
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
        IncomingVoiceMessageViewHolder.messagesMutableLiveData.observe((MessageAdapter.context as LifecycleOwner),
            Observer { prevMessage: Messages? ->
                prevMessage?.let {
                    handlePrevMessage(prevMessage)
                }
            })
        mPlayButton!!.setOnClickListener {
            handlePlayClick(absoluteAdapterPosition)
        }
    }

    private fun handlePlayClick(absoluteAdapterPosition: Int) {
        if (!isStarted) {
            playing_position = if (mMessage!!.isPlaying) {
                mPlayer!!.stop()
                stopAudio()
                messagesMutableLiveData.postValue(mPrev)
                playAudio(mAudioPrgs, updateSeekbar)
                absoluteAdapterPosition
            } else {
                playAudio(mAudioPrgs, updateSeekbar)
                absoluteAdapterPosition
            }
            return
        }
        if (isStarted) {
            if (isPlay) {
                pauseAudio()
            } else {
                resumeAudio()
            }
        }
    }

    private fun handlePrevMessage(prevMessage: Messages) {
        if (!prevMessage.payload.messageId.equals(
                mMessage!!.payload.messageId, ignoreCase = true
            )
        ) {
            mPlayButton!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_play))
            reset()
            if (file!!.exists()) {
                tvTime!!.text = Utills.getDuration(getInstance(), file!!.absolutePath)
            }
        }
    }

    @Throws(Exception::class)
    private fun updateRunnable() {
        if (mPlayer != null && mMessage!!.isPlaying && seekbarHandler != null) {
            updateSeekbar = object : Runnable {
                override fun run() {
                    try {
                        mAudioPrgs!!.progress = mPlayer!!.currentPosition
                        tvTime!!.text =
                            DateTimeUtil.milliSecondsToTimer(mPlayer!!.currentPosition.toLong())
                        if (seekbarHandler != null) seekbarHandler!!.postDelayed(this, 500)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
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
        isPlay = true
        if (isPlay) {
            mPlayer!!.setOnCompletionListener { mp: MediaPlayer? -> stopAudio() }
            mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_pause_media))
            mAudioPrgs!!.max = mPlayer!!.duration
            mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_pause_media))
            isStarted = true
            val seekbarHandler = Handler()
            this.mAudioPrgs!!.setOnSeekBarChangeListener(null)
//            this.mAudioPrgs!!.isFocusableInTouchMode=false
//            this.mAudioPrgs!!.isEnabled=false
            this.seekbarHandler = seekbarHandler
            this.mAudioPrgs = mAudioPrgs

            try {
                updateRunnable()
            } catch (e: Exception) {
                e.printStackTrace()
            }


            seekbarHandler?.let {
                seekbarHandler.postDelayed(this.updateSeekbar!!, 500)
            }
            try {
                seekbarChangeListener = object : OnSeekBarChangeListener {
                    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                        //was essential to over ride

                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {
                        seekbarHandler?.let {
                            if (isPlay) pauseAudio()
                        }

                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {
                        seekbarHandler?.let {
                            val progress = p0!!.progress
                            mPlayer!!.seekTo(progress)
                            if (!isPlay) resumeAudio()
                        }
                    }

                }

                mAudioPrgs.setOnSeekBarChangeListener(seekbarChangeListener)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    private fun stopAudio() {
        //Stop The Audio
//        mAudioPrgs.setProgress(0);
        isStarted = false
        isPlay = false
        mMessage!!.isPlaying = false
        mPlayer!!.stop()
        mPlayer!!.reset()
        mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_play))
        if (seekbarHandler != null) {
            seekbarHandler!!.sendEmptyMessageDelayed(1845, 500)
            seekbarHandler = null
//            mAudioPrgs!!.setOnSeekBarChangeListener(null)
//            mAudioPrgs!!.isFocusableInTouchMode=false
//            mAudioPrgs!!.isEnabled=false
            if (file!!.exists()) {
                tvTime!!.text = Utills.getDuration(getInstance(), file!!.absolutePath)
            }
        }
    }

    private fun reset() {
        isStarted = false
        isPlay = false
        mMessage!!.isPlaying = false
        mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_play))
        mAudioPrgs?.setOnSeekBarChangeListener(null)
        if (seekbarHandler != null) {
            seekbarHandler!!.sendEmptyMessageDelayed(1845, 500)
            seekbarHandler = null
        }
        if (file!!.exists()) {
            tvTime!!.text = Utills.getDuration(getInstance(), file!!.absolutePath)
        }
    }

    private fun pauseAudio() {
        mPlayer!!.pause()
        isPlay = false
        mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_play))

        try {
            if (seekbarHandler != null) seekbarHandler!!.removeCallbacks(updateSeekbar!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun resumeAudio() {
        mPlayer!!.start()
        isPlay = true
        mPlayButton!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_pause_media))

        try {
            updateRunnable()
        } catch (e: Exception) {
            e.printStackTrace()
        }


        try {
            if (seekbarHandler != null) seekbarHandler!!.postDelayed(updateSeekbar!!, 500)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {
        private var mPrev: Messages? = null
        var seekbarChangeListener: OnSeekBarChangeListener? = null;
        var messagesMutableLiveData = MutableLiveData<Messages?>()
    }

    init {
        init(itemView)
    }

    override fun onPlay(audioUri: Uri, progress: Double) {

//        Log.e("TAG","Playing")
    }

    override fun onPause(audioUri: Uri) {

        //was essential to over ride

    }

    override fun onSeekTo(audioUri: Uri, progress: Double) {

        //was essential to over ride

    }

    override fun onStopAndReset(audioUri: Uri) {

        //was essential to over ride

    }

    override fun onSpeedChanged(speed: Float, isPlaying: Boolean) {

        //was essential to over ride

    }

    override fun onProgressUpdated(durationMillis: Long, playheadMillis: Long) {

        //was essential to over ride

    }
}