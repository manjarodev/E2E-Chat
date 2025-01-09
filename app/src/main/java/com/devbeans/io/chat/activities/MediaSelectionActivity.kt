package com.devbeans.io.chat.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.NavHostFragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.OnDataPass
import com.devbeans.io.chat.ffmpeg.FFmpegOperations
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.DateTimeUtil.convertSecondsToHMmSs
import com.devbeans.io.chat.utils.Loading
import com.devbeans.io.chat.utils.RequestCodes.MEDIA_EDIT_SHOW
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import com.virgilsecurity.keyknox.utils.Serializer.Companion.gson
import java.io.File


class MediaSelectionActivity : BaseActivity(), OnDataPass {
    private var filepath: String? = null
    private var uri: Uri? = null
    private var conversation: Conversation? = null
    private var isFromCamera: Boolean = false
    private val CommandReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getStringExtra("command")
            val viewOnce = intent.getBooleanExtra(Constants.KEYS.INTENT_VIEW_ONCE, false)
//            editedImage.setImageURI(Uri.parse(message))
            val outputPathCompress =
                File(
                    MainApp.appContext!!.filesDir.path + "/" + "OutputFileCompress" + "." + AndroidUtil.getMimeType(
                        MainApp.appContext,
                        uri
                    )
                )

            if (outputPathCompress.exists()) {
                outputPathCompress.delete()
            }
            val ffmpegCallback = object : FFmpegOperations.FFmpegOperationsCallback {
                override fun onSuccessCompress() {
                    val mediaData = MediaData(
                        outputPathCompress.toString(),
                        viewOnce
                    )
                    val intent = Intent()
                    intent.putExtra(Constants.KEYS.INTENT_FILE_PATH, gson.toJson(mediaData))

                    setResult(
                        MEDIA_EDIT_SHOW,
                        intent
                    )
                    finish()
                }
            }

            Loading.make(this@MediaSelectionActivity).setMessage("Compressing...").show()
            if (message!!.equals("cancel_edit", ignoreCase = true)) {
                if (isFromCamera) {
                    Log.e(TAG, "rotate")
                    FFmpegOperations.compressImageWithRotate(
                        inputPath = filepath!!,
                        outputPath = outputPathCompress.toString(),
                        callback = ffmpegCallback
                    )
                } else {
                    FFmpegOperations.compressImage(
                        inputPath = filepath!!,
                        outputPath = outputPathCompress.toString(),
                        callback = ffmpegCallback
                    )
                }

            } else {

                FFmpegOperations.compressImage(
                    inputPath = message,
                    outputPath = outputPathCompress.toString(),
                    callback = ffmpegCallback
                )

            }

//            Log.e(TAG, message.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(CommandReceiver)
        isFrom = false;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_selection)
        LocalBroadcastManager.getInstance(this).registerReceiver(
            CommandReceiver,
            IntentFilter("image_edit_command_activity")
        )
        isFromCamera = intent.hasExtra(Constants.KEYS.INTENT_FROM_CAMERA)
        //        MainApp.Companion.getAppContext().setCurrentActivity(this);
//        NavHostFragment navHostFragment = NavHostFragment.create(R.navigation.media);
        uri = intent.getParcelableExtra<Uri>(Constants.KEYS.INTENT_MEDIA_URI)
        filepath = intent.getStringExtra(Constants.KEYS.INTENT_MEDIA_PATH)
        conversation =
            intent.getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation


        val navHostFragment = NavHostFragment.create(R.navigation.media)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, navHostFragment, NAV_HOST_TAG)
            .commitNowAllowingStateLoss()
        navigateToStartDestination(navHostFragment)


    }


    private fun navigateToStartDestination(navHostFragment: NavHostFragment? = null): Boolean {
        val hostFragment: NavHostFragment = navHostFragment
            ?: supportFragmentManager.findFragmentByTag(NAV_HOST_TAG) as NavHostFragment

        val startDestination: Int = R.id.action_directly_to_mediaReviewFragment
        return if (startDestination > 0) {
            hostFragment.navController.navigate(
                startDestination,
                Bundle().apply {
                    putBoolean("first", true)
                    putString(Constants.KEYS.INTENT_MEDIA_URI, uri.toString())
                    putSerializable(Constants.KEYS.INTENT_CONVERSATION, conversation)
                }
            )

            true
        } else {
            false
        }
    }


    companion object {
        private const val NAV_HOST_TAG = "NAV_HOST"
        private val TAG = Log.tag(MediaSelectionActivity::class.java)
        public var isFrom = false;
    }

    override fun onDataPass(
        isDurationEdited: Boolean,
        totalDurationUs: Long,
        startTimeUs: Long,
        endTimeUs: Long,
        viewOnce: Boolean
    ) {

        val startTime = convertSecondsToHMmSs(startTimeUs / 1000)
        val endTime = convertSecondsToHMmSs(endTimeUs / 1000)
        val outputPath =
            File(
                MainApp.appContext!!.filesDir.path + "/" + "OutputFile" + "." + AndroidUtil.getMimeType(
                    MainApp.appContext,
                    uri
                )
            )
        if (outputPath.exists()) {
            outputPath.delete()
        }

        if (isFrom) {
            isFrom = false;
            val mediaData = MediaData(
                filepath,
                viewOnce
            )

            setResult(
                MEDIA_EDIT_SHOW,
                Intent().apply {
                    putExtra(Constants.KEYS.INTENT_FILE_PATH, gson.toJson(mediaData))
                }
            )
            finish()
        } else {

            Loading.make(this).setMessage("Compressing...").show()
            val ffmpegCallback = object : FFmpegOperations.FFmpegOperationsCallback {
                override fun onSuccessCompress() {
                    val mediaData = MediaData(
                        outputPath.toString(),
                        viewOnce
                    )
                    setResult(
                        MEDIA_EDIT_SHOW,
                        Intent().apply {
                            putExtra(Constants.KEYS.INTENT_FILE_PATH, gson.toJson(mediaData))
                        }
                    )
                    finish()
                }

            }

            FFmpegOperations.cutVideoWithCompress(
                inputPath = filepath!!,
                startTime = startTime,
                endTime = endTime,
                outputPath = outputPath.toString(),
                uri = uri!!,
                callback = ffmpegCallback
            )


        }


//        finish()
    }

    data class MediaData(var filePath: String? = null, var intent_view_once_chat: Boolean? = null) :
        java.io.Serializable

}
