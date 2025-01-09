package com.devbeans.io.chat.activities

import android.graphics.RenderEffect
import android.graphics.Shader
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityMessageDetailsBinding
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.MetaData
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.VideoPlayer.PlayerCallback
import com.devbeans.io.chat.utils.downloaders.Downloader
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import java.io.File
import java.util.*

class MessageDetailsActivity : AppCompatActivity(), ExpiryCallback {


    //    var mBinding: ActivityMessageDetailsBinding? = null
    private var _binding: ActivityMessageDetailsBinding? = null

    // This property is only valid between onCreate and
    // onDestroy.
    private val binding get() = _binding!!

    private val tag = Log.tag(MessageDetailsActivity::class.java)

    private lateinit var payload: Payload

    private lateinit var conversation: Conversation

    private lateinit var senderID: String

    private lateinit var inflater: LayoutInflater

    private lateinit var data: String
    private lateinit var mView: View
    private lateinit var mPlayer: MediaPlayer
    private lateinit var mTime: TextView
    private lateinit var mAudioPrgs: SeekBar
    private lateinit var mPausePlayBtn: ImageView
    private lateinit var blurEffect: RenderEffect
    private var check: Boolean = false
    private val runnable = Runnable { updateSeekBar() }
    private var seekBarHandler: Handler? = null
    private var isOwnMessage = false
    private var file: File? = null
    private var player: VideoPlayer? = null
    private var playbackControlsContainer: ViewGroup? = null
    private var imageView: ImageView? = null

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_message_details)
        getConversationData
        inflater = AndroidUtil.getContext()
            .getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        setToolBar(binding.toolbar)
        initViews()
        listeners()
        observers()

//        setContentView(R.layout.activity_message_details)
    }


    private val getConversationData: Unit
        get() {
            intent?.apply {
                if (hasExtra(Constants.KEYS.INTENT_CONVERSATION)) {
                    conversation =
                        getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation
                } else {
                    Log.e(tag, "Didn't got Conversation from activity")
                }
                if (hasExtra(Constants.KEYS.INTENT_PAYLOAD)) {
                    payload =
                        getSerializableExtra(Constants.KEYS.INTENT_PAYLOAD) as Payload
                } else {
                    Log.e(tag, "Didn't got Payload from activity")
                }
                if (hasExtra(Constants.KEYS.INTENT_SENDER_ID)) {
                    senderID = getStringExtra(Constants.KEYS.INTENT_SENDER_ID) as String
                } else {
                    Log.e(tag, "Didn't got Sender Id from activity")
                }

                Log.e(tag, "Sender Id $senderID \n Conversation $conversation \n Payload $payload ")

            }


        }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun initViews() {
        binding.apply {
            blurEffect = RenderEffect.createBlurEffect(50F, 50F, Shader.TileMode.MIRROR)
            if (!payload.type?.equals(Constants.TYPES.TEXT)!!) {
                confidentialFrameLayout.visibility = VISIBLE
                confidentialFrameLayout.setRenderEffect(blurEffect)
            } else {
                confidentialMessageText.text = payload.data
                confidentialFrameLayout.visibility = GONE
            }
//            confidentialFrameLayout.foreground = AndroidUtil.getDrawable(R.drawable.ic_blur)
//            confidentialFrameLayout.foreground.alpha = 220
//                .setBackgroundColor(AndroidUtil.getColor(R.color.faded_black_30))
            check = payload.filePath != null && File(payload.filePath!!).exists()
            isOwnMessage = payload.userChatId.equals(senderID)

            download.visibility = getDownloadVisibility()


            tvTapToReveal.visibility =
                if (check && !payload.type.equals(Constants.TYPES.TEXT)) VISIBLE else GONE

            if (download.visibility == VISIBLE) {
                handleReceivedSide(this)
            }


            tvTapToReveal.text = getTapToRevealText(this)

        }
    }

    private fun getTapToRevealText(binding: ActivityMessageDetailsBinding): CharSequence? {
        return AndroidUtil.getString(
            when (payload.type) {
                Constants.TYPES.TEXT -> {
                    binding.confidentialMessageText.visibility = VISIBLE
                    binding.confidentialFrameLayout.visibility = GONE
                    R.string.tap_to_reveal_text
                }
                Constants.TYPES.IMAGE -> {

                    binding.confidentialMessageText.visibility = GONE
                    binding.confidentialFrameLayout.visibility = VISIBLE
                    mView = inflater.inflate(R.layout.item_image_screen, null)
                    imageView = mView.findViewById<ImageView>(R.id.iv_image_screen)
                    binding.confidentialFrameLayout.addView(mView)
                    if (check)
                        initImage()
                    else {
                        invalidateImage()
                    }
                    R.string.tap_to_reveal_image
                }
                Constants.TYPES.AUDIO -> {
                    if (check) {
                        binding.confidentialMessageText.visibility = GONE
                        binding.confidentialFrameLayout.visibility = VISIBLE
                        mView = inflater.inflate(R.layout.item_audio_screen, null)
                        binding.confidentialFrameLayout.addView(mView)
                    }
                    R.string.tap_to_reveal_audio
                }
                Constants.TYPES.VIDEO -> {
                    if (check) {
                        binding.confidentialMessageText.visibility = GONE
                        binding.confidentialFrameLayout.visibility = VISIBLE
                        mView = inflater.inflate(R.layout.item_video_screen, null)
                        binding.confidentialFrameLayout.addView(mView)
                        initVideoViews()
                    }
                    R.string.tap_to_reveal_video
                }
                Constants.TYPES.FILE -> {
                    if (check) {
                        binding.confidentialMessageText.visibility = GONE
                        binding.tvTapToRevealPDF.visibility = VISIBLE
                        binding.activityMainPdfView.visibility = VISIBLE
                        binding.activityMainPdfView.setRenderEffect(blurEffect)
                        binding.activityMainPdfView.fromFile(
                            File(payload.filePath!!)
                        ).show()

                    }
                    R.string.tap_to_reveal_file
                }
                else -> {
                    R.string.tap_to_reveal
                }
            }
        )
    }

    private fun handleReceivedSide(binding: ActivityMessageDetailsBinding) {
        binding.apply {
            val metaData: MetaData
            val currentString = payload.data
            if (currentString != null) {
                val separated = currentString.split("@@".toRegex()).toTypedArray()
                data = separated[0]
                file = File(MainApp.imagesPathReceive + "/" + data)

                if (file!!.exists() && file!!.isFile) {
                    if (payload.filePath == null) {
                        payload.filePath = file!!.path
                        messagesDao
                            .updateFilePath(payload.messageId, file!!.path)
                    }
                    initViews()
                    download.visibility = GONE
                }
                if (separated.size > 1) {
                    val gson = Gson()
                    metaData = gson.fromJson(separated[1], MetaData::class.java)
                    tvSize.text =
                        String.format(
                            Locale.getDefault(),
                            "%s",
                            Utills.getSize(metaData.size.toLong()) + AndroidUtil.getString(R.string.dash) + metaData.extention
                        )

                }

            }
        }
    }

    private fun getDownloadVisibility(): Int {
        return if (!isOwnMessage && !check && !payload.type.equals(Constants.TYPES.TEXT)) VISIBLE else GONE
    }

    private fun invalidateImage() {
        imageView?.setImageResource(0);
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun listeners() {
        binding.apply {
            download.setOnClickListener {
                download.visibility = GONE
                loading.visibility = VISIBLE
                val filePath = file!!.absolutePath
                val cipherData = EncryptionUtils.encryptDataDownload(data)
                Downloader.instance!!.download(
                    file!!.absolutePath,
                    Configurations.uploadsUrl + cipherData + "&chatAppId=" + AppSession.getUser().chatUserId +
                            "&download=true",
                    payload
                )
            }


            tvTapToReveal.setOnClickListener {
                handleTapToRevealClicked(this)
            }

            tvTapToRevealPDF.setOnClickListener {
                blurEffect = RenderEffect.createBlurEffect(1F, 0F, Shader.TileMode.MIRROR)
                when (payload.type) {
                    Constants.TYPES.TEXT -> {
                        //this is used for text effect if in future added any
                    }
                    Constants.TYPES.IMAGE -> {
                        //this is used for image effect if in future added any
                    }
                    Constants.TYPES.VIDEO -> {
                        if (check) {
                            playVideo()
//                            initVideoViews()
                        }
                    }
                    Constants.TYPES.FILE -> {
                        activityMainPdfView.setRenderEffect(blurEffect)
                    }
                    Constants.TYPES.AUDIO -> {
                        if (check) {
                            initAudioViews()
                        }
                    }
                }
                tvTapToRevealPDF.visibility = GONE
                confidentialFrameLayout.setRenderEffect(blurEffect)
            }


//        if (imageView != null)
//            imageView.setOnClickListener(view -> hideToolBar());

//        mBinding.frameLayout.setOnClickListener(view -> hideToolBar());

        }
    }

    private fun handleTapToRevealClicked(binding: ActivityMessageDetailsBinding) {
        binding.apply {

            blurEffect = RenderEffect.createBlurEffect(1F, 0F, Shader.TileMode.MIRROR)
            when (payload.type) {
                Constants.TYPES.TEXT -> {
                    //this is used for text effect if in future added any
                }
                Constants.TYPES.IMAGE -> {
                    if (check)
                        initImage()
                }
                Constants.TYPES.VIDEO -> {
                    if (check) {
                        playVideo()
//                            initVideoViews()
                    }
                }
                Constants.TYPES.FILE -> {
                    //this was being used for file initially but for file was changed view
                }
                Constants.TYPES.AUDIO -> {
                    if (check) {
                        initAudioViews()
                    }
                }
            }
            tvTapToReveal.visibility = GONE
            confidentialFrameLayout.setRenderEffect(blurEffect)

        }
    }

    private fun observers() {
        Downloader.instance!!.fileMutableLiveData.observe(this@MessageDetailsActivity) { file1: File? ->
            if (file1 != null) {
                if (file != null) {
                    if (file!!.absolutePath.equals(file1.absolutePath, ignoreCase = true)) {
                        if (binding.loading.visibility == VISIBLE) {
                            binding.loading.visibility = GONE
                            binding.download.visibility = GONE
                            messagesDao
                                .updateFilePath(payload.messageId, file1.path)
                            payload.filePath = file1.path
                            ChatActivity.getInstance()?.updateMessage(payload)
                            initViews()
                        }
                    }
                }
            }
        }
    }


    private fun setToolBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initImage() {
        if (isOwnMessage) {
            imageView = mView.findViewById<ImageView>(R.id.iv_image_screen)
//            Glide.with(imageView!!).clear(imageView!!)
//            imageView?.setImageResource(0);
            Glide.with(this)
                .load(payload.filePath)
                .dontAnimate()
                .into(imageView!!)
//            mBinding.tvFileTitle.setText(mMessages.getPayload().data)
        } else {
            imageView = mView.findViewById<ImageView>(R.id.iv_image_screen)
//            imageView?.setImageResource(0);
            Glide.with(imageView!!).clear(imageView!!)

            Glide.with(this)
                .load(payload.filePath)
                .dontAnimate()
                .into(imageView!!)
//            mBinding.tvFileTitle.setText(mMessages.getPayload().data)
        }
//        if (payload.filePath != null) {
//            val file = File(payload.filePath)
//            if (file.exists()) {
//                mBinding.tvFileTitle.setText(file.name)
//                imageView = findViewById<ImageView>(R.id.iv_image_screen)
//                Glide.with(this)
//                    .load(file)
//                    .into(imageView)
//            }
//        }
    }


    private fun initVideoViews() {
//        mVideoView = mView.findViewById(R.id.vv_screen);
//        mVideoPlayer = new MediaController(ScreenShowingActivity.this);
//        mVideoPlayer.setAnchorView(mVideoView);
        player = mView.findViewById(R.id.video_player)
        playbackControlsContainer =
            findViewById<ViewGroup>(R.id.media_preview_playback_controls_container)
        player?.setWindow(window)
        val playbackControls = player?.controlView
        if (playbackControls != null) {
            val params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            playbackControls.layoutParams = params
            if (playbackControlsContainer != null) {
                playbackControlsContainer?.removeAllViews()
                playbackControlsContainer?.addView(playbackControls)
            }
        }
        player?.setPlayerCallback(object : PlayerCallback {
            override fun onReady() {
//                    controller.onPlayerReady();
            }

            override fun onPlaying() {
//                    hud.fadePlayButton();
            }

            override fun onStopped() {

//                    hud.showPlayButton();
            }

            override fun onError() {
//                    controller.onPlayerError();
            }
        })

//        setDimension();

    }

    private fun playVideo() {
//        if (payload.filePath != null) {
//            val file: File = File(payload.filePath!!)
//            if (file.exists()) {
////                mBinding.tvFileTitle.setText(file.name)
//                if (isOwnMessage) {
//                    val uri = Uri.parse(payload.filePath)
//                    player!!.setVideoSource(uri, false)
//                    player!!.play()
//
//
//                    //            mVideoView.setVideoPath(mMessages.getPayload().getFilePath());
//                    //            mDuration = getDuration(uri);
//                    //            mVideoView.requestFocus();
//
//                    //            mVideoView.setMediaController(mVideoPlayer);
//                    //            mVideoView.start();
//                } else {
//                    val uri = Uri.parse(payload.filePath)
//                    //            mVideoView.setVideoPath(MainApp.Companion.getAppContext().getFilesDir().getPath() + mMessages.getPayload().getData());
//                    player!!.setVideoSource(uri, false)
//                    player!!.play()
//                    //            mDuration = getDuration(uri);
//                    //            mVideoView.requestFocus();
//                    //            mBinding.tvFileTitle.setText(Constants.TITLE);
//                    //            mVideoView.setMediaController(mVideoPlayer);
//                    //            mVideoView.start();
//                }
//            }
//        }
        if (payload.filePath != null) {
            val file = File(payload.filePath!!)
            if (file.exists()) {
//                    mBinding.tvFileTitle.setText(file.name)
                val uri = Uri.parse(payload.filePath)
                player!!.setVideoSource(uri, false)
                player!!.play()
            }
        }
    }

    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
//            onBackPressed()
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initAudioViews() {
        mPlayer = MediaPlayer()
        mTime = mView.findViewById<TextView>(R.id.tv_audio_time)
        mAudioPrgs = mView.findViewById<SeekBar>(R.id.seekBar_audio)
        mPausePlayBtn = mView.findViewById<ImageView>(R.id.iv_play_pause_audio)
        initPlayer()
        updateSeekBar()
        mPlayer.setOnCompletionListener {
            mAudioPrgs.progress = 0
            mPausePlayBtn.setImageDrawable(
                ContextCompat.getDrawable(
                    this@MessageDetailsActivity,
                    R.drawable.ic_play
                )
            )
            seekBarHandler?.removeCallbacksAndMessages(null)
            finish()
        }
        mAudioPrgs.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //this is used for stop tracking touch
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //this is used when user start touch the seekbar
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mPlayer.seekTo(progress)
                }
            }
        })
    }


    private fun initPlayer() {
        payload.filePath?.let {
            val file = File(payload.filePath!!)
            if (file.exists()) {
                mPlayer = MediaPlayer.create(this, Uri.parse(file.absolutePath))
                mAudioPrgs.max = mPlayer.duration
                if (this@MessageDetailsActivity::mPausePlayBtn.isInitialized) {
                    mPausePlayBtn.setOnClickListener {
                        if (mPlayer.isPlaying) {
                            mPlayer.pause()
                            mPausePlayBtn.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this@MessageDetailsActivity,
                                    R.drawable.ic_play
                                )
                            )
                            updateSeekBar()
                            return@setOnClickListener
                        }
                        if (!mPlayer.isPlaying) mPlayer.start()
                        mPausePlayBtn.setImageDrawable(
                            ContextCompat.getDrawable(
                                this@MessageDetailsActivity,
                                R.drawable.ic_pause_media
                            )
                        )
                        updateSeekBar()
                    }
                }

            }
        }
    }


    private fun updateSeekBar() {
        try {
            mAudioPrgs.progress = mPlayer.currentPosition
            mTime.text = DateTimeUtil.milliSecondsToTimer(mPlayer.currentPosition.toLong())
            seekBarHandler = Handler()
            if (mPlayer.isPlaying) mPausePlayBtn.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_pause_media))
            seekBarHandler?.postDelayed(runnable, 100)
        } catch (e: Exception) {
            Log.e(tag, "updateSeekBar: " + e.message)
        }
    }

    override fun onResume() {
        if (this@MessageDetailsActivity::mPlayer.isInitialized) {
            mPlayer.start()
        }
        MainApp.appContext?.setNotifyExpiry(this)
        super.onResume()
    }

    override fun onPause() {
        if (this@MessageDetailsActivity::mPlayer.isInitialized && mPlayer.isPlaying) {
            mPlayer.pause()
        }
        super.onPause()
    }

    override fun onDestroy() {
        _binding = null
//        if (player != null) {
//            player.cleanup()
//        }

        Downloader.instance!!.fileMutableLiveData.removeObservers(this@MessageDetailsActivity)
        if (this@MessageDetailsActivity::mPlayer.isInitialized) {
            if (mPlayer.isPlaying) {
                mPlayer.stop()
            }
            mPlayer.release()
        }
        super.onDestroy()
    }

    override fun notifyExpiry() {
        binding.let {
            Utills.showSubscriptionBanner(binding.tvSubs)
        }
    }
}