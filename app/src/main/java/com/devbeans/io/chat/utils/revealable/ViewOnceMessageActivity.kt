package com.devbeans.io.chat.utils.revealable

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.EncryptionUtils
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.VideoPlayer
import com.devbeans.io.chat.utils.VideoPlayer.PlayerStateCallback
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import java.util.*
import java.util.concurrent.TimeUnit

class ViewOnceMessageActivity : BaseActivity(), PlayerStateCallback, ExpiryCallback {
    private lateinit var record: Payload
    private var image: ImageView? = null
    private var video: VideoPlayer? = null
    private var closeButton: View? = null
    private var duration: TextView? = null
    private var viewModel: ViewOnceMessageViewModel? = null
    private var filePath: String? = null
    private val handler = Handler(Looper.getMainLooper())
    private val durationUpdateRunnable = Runnable {
        val timeLeft = TimeUnit.MILLISECONDS.toSeconds(video!!.duration - video!!.playbackPosition)
        val minutes = timeLeft / 60
        val seconds = timeLeft % 60
        duration!!.text =
            getString(R.string.ViewOnceMessageActivity_video_duration, minutes, seconds)
        scheduleDurationUpdate()
    }

    override fun attachBaseContext(newBase: Context) {
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        super.attachBaseContext(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        setContentView(R.layout.view_once_message_activity)
        image = findViewById(R.id.view_once_image)
        video = findViewById(R.id.view_once_video)
        duration = findViewById(R.id.view_once_duration)
        closeButton = findViewById(R.id.view_once_close_button)
        filePath = intent.getStringExtra(KEY_FILE_PATH)
        closeButton?.setOnClickListener { finish() }
        record = messagesDao.getMessage(intent.getStringExtra(KEY_MESSAGE_ID))
        sendOpenedAck()
        initViewModel(
            if (intent.getStringExtra(KEY_MESSAGE_ID) != null) intent.getStringExtra(
                KEY_MESSAGE_ID
            ) else "", filePath!!
        )

    }

    override fun onResume() {
        appContext?.setNotifyExpiry(this)
        super.onResume()
    }

    private fun sendOpenedAck() {
        try {
            if (::record.isInitialized) {
                EncryptionUtils.sendOpenedAck(
                    record,
                    conversationsDao.getConversation(record?.conversationId)
                )
            }
        } catch (e: Exception) {
            Log.e(TAG,"Got exception in sending opened ack $e")
        }
    }

    override fun onStop() {
        super.onStop()
        cancelDurationUpdate()
        video!!.cleanup()
        viewModel?.deleteMessageData()
        finish()
    }

    override fun onPlayerReady() {
        handler.post(durationUpdateRunnable)
    }

    private fun initViewModel(messageId: String?, filePath: String) {
        if (!messageId.equals("", ignoreCase = true)) {
            val repository = ViewOnceMessageRepository(this)
            viewModel = ViewModelProvider(
                this,
                ViewOnceMessageViewModel.Factory(messageId!!, repository)
            ).get(
                ViewOnceMessageViewModel::class.java
            )
            viewModel!!.getMessage().observe(this) { message: Optional<Payload> ->
                if (message.isPresent) {
                    displayMedia(filePath, message.get().type)
                } else {
                    image!!.setImageDrawable(null)
                    finish()
                }
            }
        }
    }


    private fun displayMedia(filePath: String, type: String?) {
        if (type.equals(Constants.TYPES.VIDEO, ignoreCase = true)) {
            displayVideo(filePath)
        } else {
            displayImage(filePath)
        }
    }

    private fun displayVideo(filePath: String) {
        video!!.visibility = View.VISIBLE
        image!!.visibility = View.GONE
        duration!!.visibility = View.VISIBLE

//        VideoSlide videoSlide = new VideoSlide(this, uri, 0, false);
        video!!.setWindow(window)
        video!!.setPlayerStateCallbacks(this)
        val parsedUri = Uri.parse(filePath)
        video!!.setVideoSource(parsedUri, true)
        video!!.hideControls()
        video!!.loopForever()
    }

    private fun displayImage(filePath: String) {
        video!!.visibility = View.GONE
        image!!.visibility = View.VISIBLE
        duration!!.visibility = View.GONE
        Glide.with(this).load(filePath).into(image!!)
    }

    private fun scheduleDurationUpdate() {
        handler.postDelayed(durationUpdateRunnable, 100)
    }

    private fun cancelDurationUpdate() {
        handler.removeCallbacks(durationUpdateRunnable)
    }

    private inner class ViewOnceGestureListener private constructor(private val view: View) :
        SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            view.performClick()
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            finish()
            return true
        }
    }

    companion object {
        private val TAG = Log.tag(
            ViewOnceMessageActivity::class.java
        )
        private const val KEY_MESSAGE_ID = "message_id"
        private const val KEY_FILE_PATH = "file_path"
        fun getIntent(context: Context, messageId: String?, filePath: String): Intent {
            val intent = Intent(context, ViewOnceMessageActivity::class.java)
            intent.putExtra(KEY_MESSAGE_ID, messageId)
            intent.putExtra(KEY_FILE_PATH, filePath)
            return intent
        }
    }

    override fun notifyExpiry() {
        if (image != null) {
            Utills.showSubscriptionBanner(image?.rootView)
        }
    }
}