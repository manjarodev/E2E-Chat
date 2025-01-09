package com.devbeans.io.chat.camera

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Size
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.*
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.core.util.Consumer
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abedelazizshe.lightcompressorlibrary.CompressionListener
import com.abedelazizshe.lightcompressorlibrary.VideoCompressor
import com.abedelazizshe.lightcompressorlibrary.VideoQuality
import com.abedelazizshe.lightcompressorlibrary.config.Configuration
import com.abedelazizshe.lightcompressorlibrary.config.StorageConfiguration
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.MediaSelectionActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Permissions
import com.devbeans.io.chat.utils.RequestCodes
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import com.google.common.util.concurrent.ListenableFuture
import com.otaliastudios.cameraview.VideoResult
import hk.ids.gws.android.sclick.SClick
import hk.ids.gws.android.sclick.helper.SafeClick
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


class CameraActivity : BaseActivity(), ExpiryCallback { //, OptionView.Callback

    private val adapter = CameraTypeModeAdapter(this)
    private var isrecording: Boolean = false
    private var flashMode: Int = ImageCapture.FLASH_MODE_OFF
    private var cameraIndex = 0

    private var condition = 0
    private var recording: Recording? = null


    private lateinit var close_btn: ImageView
    private lateinit var camerax: Camera
    private lateinit var outAnimation: Animation
    private lateinit var inAnimation: Animation
    private lateinit var texT: String
    private lateinit var cameraProvider: ListenableFuture<ProcessCameraProvider>
    private lateinit var videoCapture: androidx.camera.video.VideoCapture<Recorder>
    private lateinit var imageCapture: ImageCapture
    private lateinit var camera_clicker: ImageView
    private lateinit var flash_toggle: ImageView
    private lateinit var camera_switch: ImageView
    private lateinit var video_clicker: ImageView
    private lateinit var tv_sub: TextView
    private lateinit var camera_mode_recycler: RecyclerView
    private lateinit var cameraPreview: PreviewView
    private lateinit var recordTime: TextView
    private lateinit var recordingState: VideoRecordEvent
    private lateinit var outputFile: File


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        MainApp.appContext?.setNotifyExpiry(this)
        close_btn = findViewById(R.id.close_btn)
        camera_clicker = findViewById(R.id.camera_clicker)
        flash_toggle = findViewById(R.id.flash_toggle)
        camera_switch = findViewById(R.id.camera_switch)
        video_clicker = findViewById(R.id.video_clicker)
        camera_mode_recycler = findViewById(R.id.camera_mode_recycler)
        cameraPreview = findViewById(R.id.cameraPreview)
        recordTime = findViewById(R.id.record_time)
        tv_sub = findViewById(R.id.tvSubsCamera)



        Permissions.with(this)
            .request(Manifest.permission.CAMERA)
            .ifNecessary()
            .withRationaleDialog(
                getString(R.string.ConversationActivity_to_capture_photos_and_video_allow_chat_access_to_the_camera),
                R.drawable.ic_camera
            )
//            .withPermanentDenialDialog(getString(R.string.ConversationActivity_signal_needs_the_camera_permission_to_take_photos_or_video))
            .onAllGranted {
                initiateCameraX();
            }
            .onAnyDenied {
                Toast.makeText(
                    this,
                    R.string.ConversationActivity_signal_needs_camera_permissions_to_take_photos_or_video,
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
            .execute()


    }


    @SuppressLint("ClickableViewAccessibility")
    private fun initiateCameraX() {
        try {//initiating cameraX with surface and useCases
            cameraProvider = ProcessCameraProvider.getInstance(this@CameraActivity)
            cameraProvider.addListener({
                try {
                    val cameraProvider = cameraProvider.get()
                    startCameraX(cameraProvider, 1)
                } catch (e: ExecutionException) {
                    e.printStackTrace()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }, getExecutor())

            //essential for flash toggle
            condition = 0


            val arrayList = ArrayList<String>()
            arrayList.add("Photo")
            arrayList.add("Video")

            camera_mode_recycler.setHasFixedSize(true)
            camera_mode_recycler.layoutManager =
                LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            camera_mode_recycler.adapter = adapter

            adapter.updateData(object : OnCameraModeChanged {
                override fun onCameraMode(value: String) {
                    if (value == "Video") {
                        if (!canRecordAudio()) {
                            displayAudioRecordingPermissionsDialog()
                        } else {
                            video_clicker.visibility = VISIBLE
                            camera_clicker.visibility = View.INVISIBLE
                        }


                    } else if (value == "Photo") {
                        video_clicker.visibility = View.INVISIBLE
                        camera_clicker.visibility = VISIBLE

                    }
                }

            }, arrayList)


            SafeClick.getDefault().setInterval(1000)

            close_btn.setOnClickListener { onBackPressed() }
            camera_clicker.setOnClickListener {
                if (!SClick.check(SClick.BUTTON_CLICK)) return@setOnClickListener
                capturePicture()
            }

            inAnimation = AnimationUtils.loadAnimation(this@CameraActivity, R.anim.fade_in)
            outAnimation = AnimationUtils.loadAnimation(this@CameraActivity, R.anim.fade_out)
            video_clicker.setOnClickListener {
                handleClickButton()
            }

            flash_toggle.setOnClickListener { toggleFlashCondition() }
            camera_switch.setOnClickListener { toggleCamera() }


            //For zoom of camera view pinch to zoom
            val listener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    val scale =
                        camerax.cameraInfo.zoomState.value!!.zoomRatio * detector.scaleFactor
                    camerax.cameraControl.setZoomRatio(scale)
                    return true
                }
            }
            val scaleGestureDetector = ScaleGestureDetector(this@CameraActivity, listener)
            cameraPreview.setOnTouchListener { _, event ->
                scaleGestureDetector.onTouchEvent(event)
                return@setOnTouchListener true
            }
        } catch (e: Exception) {
            Log.e(TAG, "${e.printStackTrace()}")
        }
    }

    private fun handleClickButton() {
        if (!isrecording) {
            video_clicker.setImageResource(R.drawable.ic_pause)
            capturesVideo()
            hideAndDisableControlsForVideoRecording(
                flash_toggle,
                camera_switch,
                close_btn,
                camera_mode_recycler,
                outAnimation
            )
        } else {
            isrecording = false
            video_clicker.setImageResource(R.drawable.ic_camera_red)
            stopVideo()
            showAndEnableControlsAfterVideoRecording(
                flash_toggle,
                camera_switch,
                close_btn,
                camera_mode_recycler,
                inAnimation
            )
        }
    }


    private fun displayAudioRecordingPermissionsDialog() {
        Permissions.with(this)
            .request(Manifest.permission.RECORD_AUDIO)
            .ifNecessary()
            .withRationaleDialog(
                getString(R.string.ConversationActivity_enable_the_microphone_permission_to_capture_videos_with_sound),
                R.drawable.ic_mic_solid_24
            ).onAllGranted {
                video_clicker.visibility = VISIBLE
                camera_clicker.visibility = View.INVISIBLE
            }
//            .withPermanentDenialDialog(getString(R.string.ConversationActivity_chat_needs_the_recording_permissions_to_capture_video))
            .onAnyDenied {
                Toast.makeText(
                    this,
                    R.string.ConversationActivity_chat_needs_recording_permissions_to_capture_video,
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
            .execute()
    }

    override fun onBackPressed() {
        if (recording != null) {
            recording!!.stop()
            recording = null
        }
        super.onBackPressed()
    }


    /** inline function for tap to focus feature in cameraX**/
    inline fun View.afterMeasured(crossinline block: () -> Unit) {
        if (measuredWidth > 0 && measuredHeight > 0) {
            block()
        } else {
            viewTreeObserver.addOnGlobalLayoutListener(object :
                ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (measuredWidth > 0 && measuredHeight > 0) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this)
                        block()
                    }
                }
            })
        }
    }

    @SuppressLint("RestrictedApi")
    private fun startCameraX(cameraProvider: ProcessCameraProvider?, index: Int) {
        cameraIndex = index
        //Unbind previous instance of camera
        cameraProvider!!.unbindAll()


        val cameraSelector =
//            getCameraSelector(cameraIndex)
            CameraSelector.Builder().requireLensFacing(index).build()

        //preview user camera
        val preview = androidx.camera.core.Preview.Builder().build().also {
            it.setSurfaceProvider(cameraPreview.surfaceProvider)
        }


        //Image Capture
        imageCapture =
            ImageCapture.Builder().setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                .setFlashMode(flashMode)
                .build()


        //Add a FallbackStrategy to the existing QualitySelector creation.
        // This allows CameraX to pick up a supported resolution
        // if the required Quality.LOWEST is not supportable with the imageCapture use case.

        val recorder = Recorder.Builder()
            .setQualitySelector(
                QualitySelector.from(
                    Quality.LOWEST,
                    //Add a FallbackStrategy to the existing QualitySelector creation.
                    // This allows CameraX to pick up a supported resolution
                    // if the required Quality.HIGHEST is not supportable with the imageCapture use case.
                    FallbackStrategy.higherQualityOrLowerThan(Quality.SD)
                )
            )
            .build()

        //Video Capture Use Case
        videoCapture =
            androidx.camera.video.VideoCapture.withOutput(recorder)



        try {
            // Unbind use case before rebinding


            // Bind use cases to camera

            camerax = cameraProvider.bindToLifecycle(
                this@CameraActivity as LifecycleOwner,
                cameraSelector,
                preview,
                imageCapture,
                videoCapture
            )

            //for auto focus after every 2 seconds
            cameraPreview.afterMeasured {
                val autoFocusPoint = SurfaceOrientedMeteringPointFactory(1f, 1f)
                    .createPoint(.5f, .5f)
                try {
                    val autoFocusAction = FocusMeteringAction.Builder(
                        autoFocusPoint,
                        FocusMeteringAction.FLAG_AF
                    ).apply {
                        //start auto-focusing after 2 seconds
                        setAutoCancelDuration(2, TimeUnit.SECONDS)
                    }.build()
                    camerax.cameraControl.startFocusAndMetering(autoFocusAction)
                } catch (e: CameraInfoUnavailableException) {
                    Log.d("ERROR", "cannot access camera", e)
                }
            }

        } catch (e: Exception) {
            Log.e(TAG, "Use case binding failed", e)
        }


    }

    // This returns an Executor that runs on the main thread.
    private fun getExecutor(): Executor {
        return ContextCompat.getMainExecutor(this@CameraActivity)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.let {
            if (resultCode == RequestCodes.MEDIA_EDIT_SHOW && requestCode == RequestCodes.MEDIA_EDIT_SHOW) {
                setResult(
                    RequestCodes.MEDIA_EDIT_SHOW,
                    Intent().apply {
                        putExtra(
                            Constants.KEYS.INTENT_FILE_PATH,
                            data.getStringExtra(Constants.KEYS.INTENT_FILE_PATH)
                        )
                    }
                )
                finish()
            }
        }


    }

    private fun toggleFlashCondition() {
        if (camerax.cameraInfo.hasFlashUnit()) {
            when (condition) {
                0 -> {
                    condition = 1
                    findViewById<ImageView>(R.id.flash_toggle).setImageResource(R.drawable.ic_flash_auto)
                    camerax.cameraControl.enableTorch(true)


                }
                1 -> {
                    condition = 2
                    findViewById<ImageView>(R.id.flash_toggle).setImageResource(R.drawable.ic_cancel_flash)
                    camerax.cameraControl.enableTorch(false)
                }
                2 -> {
                    findViewById<ImageView>(R.id.flash_toggle).setImageResource(R.drawable.ic_flash_icon)
                    condition = 0
                    camerax.cameraControl.enableTorch(true)

                }
            }
        }
    }


    private fun capturePicture() {

        val photo = File("${MainApp.imagesPathCaptured}/${System.currentTimeMillis()}.jpeg")

        imageCapture.takePicture(ImageCapture.OutputFileOptions.Builder(photo).build(),
            getExecutor(),
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    Log.e("tag", "ImageCaptured")
                    startActivityForResult(
                        Intent(
                            this@CameraActivity,
                            MediaSelectionActivity::class.java
                        ).putExtra(
                            Constants.KEYS.INTENT_MEDIA_URI,
                            Uri.fromFile(photo)
                        )
                            .putExtra(
                                Constants.KEYS.INTENT_MEDIA_PATH,
                                photo.path
                            ).putExtra(
                                Constants.KEYS.INTENT_CONVERSATION,
                                intent.getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation
                            ).putExtra(
                                Constants.KEYS.INTENT_FROM_CAMERA,
                                Constants.KEYS.INTENT_FROM_CAMERA
                            ),
                        RequestCodes.MEDIA_EDIT_SHOW
                    )

                }

                override fun onError(exception: ImageCaptureException) {

                    //was essential to over ride

                }

            })
    }

    private fun canRecordAudio(): Boolean {
        return Permissions.hasAll(this, Manifest.permission.RECORD_AUDIO)
    }

    fun getResolutions(
        selector: CameraSelector,
        provider: ProcessCameraProvider
    ): Map<Quality, Size> {
        return selector.filter(provider.availableCameraInfos).firstOrNull()
            ?.let { camInfo ->
                QualitySelector.getSupportedQualities(camInfo)
                    .associateWith { quality ->
                        QualitySelector.getResolution(camInfo, quality)!!
                    }
            } ?: emptyMap()
    }

    //Callback for the result from requesting permissions.
    // This method is invoked for every call on requestPermissions(String[], int).
    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        Permissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE_PERMISSIONS -> {
                if (allPermissionGranted()) {
                    initiateCameraX()
                } else {
                    Toast.makeText(
                        this@CameraActivity,
                        "Permission not granted by the user.",
                        Toast.LENGTH_SHORT
                    ).show()
                    this.finish()
                }
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }


    private fun capturesVideo() {
        //Check if the VideoCapture use case has been created: if not, do nothing.7
        val videoCapture = videoCapture ?: return
        val video = File("${MainApp.videoPathCaptured}/${System.currentTimeMillis()}.mp4")

        //If there is an active recording in progress, stop it and release the current recording.
        // We will be notified when the captured video file is ready to be used by our application.
        val currentRecording = recording
        if (currentRecording != null) {
            currentRecording.stop()
            recording = null
            return
        }

        // we create our intended MediaStore video content object,
        // with system timestamp as the display name(so we could capture multiple videos).
        val name = "captured_video"
        //ContentValue class is used to store a set of values that the ContentResolver can process.
        // ContentResolver class provides applications access to the content model.
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4")
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                put(MediaStore.Video.Media.RELATIVE_PATH, "Movies/SplashApp-Videos")
            }
        }

        //Create a MediaStoreOutputOptions.Builder with the external content option.
        //MediaStoreOutputOptions class providing options for storing output to MediaStore.
        val mediaStoreOutputOptions = MediaStoreOutputOptions.Builder(
            this.contentResolver, MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        )//Set the created video contentValues to the MediaStoreOutputOptions.Builder, and build our MediaStoreOutputOptions instance.
            .setContentValues(contentValues).build()


        //for saving in an internal file of app
        outputFile = File(MainApp.videoPathCaptured, "captured_video.mp4")
        if (outputFile.exists()) {
            outputFile.delete()
            outputFile.createNewFile()
        } else {
            outputFile.createNewFile()
        }

        val fileOutputOptions = FileOutputOptions.Builder(outputFile).build()

        //Configure the output option to the Recorder of VideoCapture<Recorder> and enable audio recording
        recording = videoCapture.output
            .prepareRecording(this, fileOutputOptions).apply {
                if (PermissionChecker.checkSelfPermission(
                        this@CameraActivity,
                        Manifest.permission.RECORD_AUDIO
                    )
                    == PermissionChecker.PERMISSION_GRANTED
                ) {
                    withAudioEnabled()
                }
            }//Start this new recording, and register a lambda VideoRecordEvent listener.
            .start(getExecutor(), captureListener)
    }

    private val captureListener = Consumer<VideoRecordEvent> { event ->
        // cache the recording state
        if (event !is VideoRecordEvent.Status)
            recordingState = event

        updateUI(event)




        if (event is VideoRecordEvent.Finalize) {
            Log.e(TAG, ": ended ")



        }
    }

    private fun updateUI(event: VideoRecordEvent) {
        val inAnimation = AnimationUtils.loadAnimation(this@CameraActivity, R.anim.fade_in)
        val state = if (event is VideoRecordEvent.Status) recordingState
        else event
        when (state) {
            is VideoRecordEvent.Status -> {
                // placeholder: we update the UI with new status after this when() block,
                // nothing needs to do here.
            }
            is VideoRecordEvent.Start -> {
                isrecording = true



            }
            is VideoRecordEvent.Finalize -> {


                isrecording = false
                recordTime.text = ""
                if (!state.hasError()) {
                    val msg =
                        "Video Capture Succeed: " + "${state.outputResults.outputUri}"

                    Log.d("TAG", msg)
                    recordTime.text = ""
//                            MediaSelectionActivity.Companion.isFrom = true
                    startActivityForResult(
                        Intent(
                            this@CameraActivity,
                            MediaSelectionActivity::class.java
                        ).putExtra(
                            Constants.KEYS.INTENT_MEDIA_URI,
                            Uri.fromFile(outputFile)
                        )
                            .putExtra(
                                Constants.KEYS.INTENT_MEDIA_PATH,
                                outputFile.path
                            )
                            .putExtra(
                                Constants.KEYS.INTENT_CONVERSATION,
                                intent.getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation
                            ),
                        RequestCodes.MEDIA_EDIT_SHOW
                    )


                } else {
                    recording?.close()
                    recording = null
                    isrecording = false
                    Log.e(
                        "TAG",
                        "Video Capture Ends with an Error: " + "${state.error}"
                    )
                }
            }
//            is VideoRecordEvent.Pause -> {
//                captureViewBinding.captureButton.setImageResource(androidx.camera.video.R.drawable.ic_resume)
//            }
//            is VideoRecordEvent.Resume -> {
//                captureViewBinding.captureButton.setImageResource(androidx.camera.video.R.drawable.ic_pause)
//            }
        }

        val stats = event.recordingStats
        val size = stats.numBytesRecorded / 1000
        val time = TimeUnit.NANOSECONDS.toSeconds(stats.recordedDurationNanos)
        texT = ""
        when {
            time < 10 -> texT = "00:0$time"
            time in 10..28 -> texT = "00:$time"
//            time >= 30 -> {
//                texT = ""
//                if (recording != null) {
//                    recording!!.stop()
//                    recording = null
//                }
//            }
        }

        if (time >= 29) {

            texT = ""
            stopVideo()
        }
        if (time <= 29)
            recordTime.text = texT
        if (event is VideoRecordEvent.Finalize) {
//            text = "${text}\nFile saved to: ${event.outputResults.outputUri}"
        }

        Log.e(TAG, "recording event: $texT")
    }

    //     Send Permission To access to camera
    private fun allPermissionGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(this@CameraActivity, it) ==
                PackageManager.PERMISSION_GRANTED
    }

    override fun onResume() {
        MainApp.appContext!!.currentActivity = this
        MainApp.appContext?.setNotifyExpiry(this)
        super.onResume()
    }


    @SuppressLint("RestrictedApi")
    private fun stopVideo() {

        if (recording != null) {
            showAndEnableControlsAfterVideoRecording(
                flash_toggle,
                camera_switch,
                close_btn,
                camera_mode_recycler,
                inAnimation
            )
            texT = ""
            isrecording = false
            recording!!.stop()
            recording = null
            recordTime.text = ""
        }

    }


    private fun toggleCamera() {

        if (recording != null) {
            recording!!.stop()
            recording = null
        }
        if (cameraIndex == 0) {
            val cameraProvider = cameraProvider.get()
            startCameraX(cameraProvider, 1)
        } else {
            val cameraProvider = cameraProvider.get()
            startCameraX(cameraProvider, 0)
        }


    }

    private fun hideAndDisableControlsForVideoRecording(
        flashButton: View,
        flipButton: View,
        closeButton: View,
        recyclerView: View,
        outAnimation: Animation
    ) {
        arrayOf(flashButton, flipButton, closeButton, recyclerView).forEach {
            it.startAnimation(outAnimation)
            it.visibility = GONE
        }
        recordTime.visibility = VISIBLE
        video_clicker.setImageResource(R.drawable.ic_pause)

    }

    private fun showAndEnableControlsAfterVideoRecording(
        flashButton: View,
        flipButton: View,
        closeButton: View,
        recyclerView: View,
        inAnimation: Animation
    ) {


        arrayOf(flashButton, flipButton, closeButton, recyclerView).forEach {
            it.startAnimation(inAnimation)
            it.visibility = VISIBLE
        }
        recordTime.visibility = GONE
        video_clicker.setImageResource(R.drawable.ic_camera_red)

    }


    interface OnCameraModeChanged {
        fun onCameraMode(value: String)
    }


    class CameraTypeModeAdapter(val context: Context) :
        RecyclerView.Adapter<CameraTypeModeAdapter.ViewHolder>() {


        var callback: OnCameraModeChanged? = null
        var arrayList = ArrayList<String>()
        fun updateData(callback: OnCameraModeChanged, arrayList: ArrayList<String>) {
            this.callback = callback
            this.arrayList = arrayList
        }

        var selected = 0

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val item_name: TextView = itemView.findViewById(R.id.item_name)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_camera_mode, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            Log.e("camTAG", "onBindViewHolder: $position")
            Log.e("camTAG", "onBindViewHolder: $selected")

            holder.item_name.text = arrayList[position]
            holder.itemView.setOnClickListener {
                val previousItem: Int = selected
                selected = position

                notifyItemChanged(previousItem)
                notifyItemChanged(position)
            }

            callback!!.onCameraMode(arrayList[selected])

            if (selected == position) {
                holder.item_name.setTextColor(context.resources.getColor(R.color.dark_red))
            } else {
                holder.item_name.setTextColor(context.resources.getColor(R.color.white))
            }

        }

        override fun getItemCount(): Int {
            return arrayList.size
        }

        fun changeSelector(position: Int) {
            selected = position
            notifyDataSetChanged()
        }


    }

    companion object {
        private val TAG = Log.tag(CameraActivity::class.java)

        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf(
                Manifest.permission.CAMERA,
//                Manifest.permission.RECORD_AUDIO
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    override fun notifyExpiry() {
        if (::tv_sub.isInitialized) {
            Utills.showSubscriptionBanner(tv_sub)
        }
    }

}
