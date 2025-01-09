package com.devbeans.io.chat.camera

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.devbeans.io.chat.R
import com.devbeans.io.chat.models.Media
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.editor.BlobProvider
import com.devbeans.io.chat.utils.logging.Log
import java.io.FileDescriptor
import java.io.FileInputStream
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

private val TAG = Log.tag(MediaCaptureFragment::class.java)

/**
 * Fragment which displays the proper camera fragment.
 */
class MediaCaptureFragment : Fragment(R.layout.fragment_container), CameraFragment.Controller {

//    private val sharedViewModel: MediaSelectionViewModel by viewModels(
//        ownerProducer = { requireActivity() }
//    )

//    private val viewModel: MediaCaptureViewModel by viewModels(
//        factoryProducer = { MediaCaptureViewModel.Factory(MediaCaptureRepository(requireContext())) }
//    )

    private lateinit var captureChildFragment: CameraFragment
    private lateinit var navigator: MediaSelectionNavigator

//    private val lifecycleDisposable = LifecycleDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        captureChildFragment = CameraFragment.newInstance() as CameraFragment

//        navigator = MediaSelectionNavigator(
//            toGallery = R.id.action_mediaCaptureFragment_to_mediaGalleryFragment
//        )

        childFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, captureChildFragment as Fragment)
            .commitNowAllowingStateLoss()

//        viewModel.events.observe(viewLifecycleOwner) { event ->
//            @Exhaustive
//            when (event) {
//                MediaCaptureEvent.MediaCaptureRenderFailed -> {
//                    Log.w(TAG, "Failed to render captured media.")
//                    Toast.makeText(requireContext(), R.string.MediaSendActivity_camera_unavailable, Toast.LENGTH_SHORT).show()
//                }
//                is MediaCaptureEvent.MediaCaptureRendered -> {
//                    if (isFirst()) {
//                        sharedViewModel.addCameraFirstCapture(event.media)
//                    } else {
//                        sharedViewModel.addMedia(event.media)
//                    }
//
//                    navigator.goToReview(findNavController())
//                }
//            }
//        }

//        sharedViewModel.state.observe(viewLifecycleOwner) { state ->
//            captureChildFragment.presentHud(state.selectedMedia.size)
//        }
//
//        lifecycleDisposable.bindTo(viewLifecycleOwner)
//        lifecycleDisposable += sharedViewModel.hudCommands.subscribe { command ->
//            if (command == HudCommand.GoToText) {
//                findNavController().safeNavigate(R.id.action_mediaCaptureFragment_to_textStoryPostCreationFragment)
//            }
//        }

        if (isFirst()) {
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        requireActivity().finish()
                    }
                }
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        Permissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
    }

    override fun onResume() {
        super.onResume()
        captureChildFragment.fadeInControls()
    }

    override fun onCameraError() {
        Log.w(TAG, "Camera Error.")

        val context = this.context
        if (context != null) {
            Toast.makeText(context, R.string.MediaSendActivity_camera_unavailable, Toast.LENGTH_SHORT).show()
        } else {
            Log.w(TAG, "Could not post toast, fragment not attached to a context.")
        }
    }

    override fun onImageCaptured(data: ByteArray, width: Int, height: Int) {
        renderImageToMedia(data, width, height, this::onMediaRendered, this::onMediaRenderFailed)
    }

    override fun onVideoCaptured(fd: FileDescriptor) {
        renderVideoToMedia(fd, this::onMediaRendered, this::onMediaRenderFailed)
    }
    private fun onMediaRendered(media: Media) {
//        internalEvents.postValue(MediaCaptureEvent.MediaCaptureRendered(media))
    }

    private fun onMediaRenderFailed() {
//        internalEvents.postValue(MediaCaptureEvent.MediaCaptureRenderFailed)
    }

    override fun onVideoCaptureError() {
        Log.w(TAG, "Video capture error.")
        Toast.makeText(requireContext(), R.string.MediaSendActivity_camera_unavailable, Toast.LENGTH_SHORT).show()
    }

    override fun onGalleryClicked() {
//        val controller = findNavController()
//        requestPermissionsForGallery {
//            captureChildFragment.fadeOutControls {
//                navigator.goToGallery(controller)
//            }
//        }
    }

    override fun getDisplayRotation(): Int {
        return if (Build.VERSION.SDK_INT >= 30) {
            requireContext().display?.rotation ?: 0
        } else {
            @Suppress("DEPRECATION")
            requireActivity().windowManager.defaultDisplay.rotation
        }
    }

    override fun onCameraCountButtonClicked() {
//        val controller = findNavController()
//        captureChildFragment.fadeOutControls {
//            navigator.goToReview(controller)
//        }
    }

    override fun getMostRecentMediaItem(): LiveData<Optional<Media>> {
        return DefaultValueLiveData(Optional.empty())
    }

//    override fun getMediaConstraints(): MediaConstraints {
//        return sharedViewModel.getMediaConstraints()
//    }

    override fun getMaxVideoDuration(): Int {
        return TimeUnit.MILLISECONDS.toSeconds(30).toInt()
    }

    private fun isFirst(): Boolean {
        return arguments?.getBoolean("first") == true
    }


    fun renderImageToMedia(data: ByteArray, width: Int, height: Int, onMediaRendered: (Media) -> Unit, onFailedToRender: () -> Unit) {
        ChatExecutors.BOUNDED.execute {
            val media: Media? = renderCaptureToMedia(
                dataSupplier = { data },
                getLength = { data.size.toLong() },
                createBlobBuilder = { blobProvider, bytes, _ -> blobProvider.forData(bytes) },
                mimeType = MediaUtil.IMAGE_JPEG,
                width = width,
                height = height
            )

            if (media != null) {
                onMediaRendered(media)
            } else {
                onFailedToRender()
            }
        }
    }

    fun renderVideoToMedia(fileDescriptor: FileDescriptor, onMediaRendered: (Media) -> Unit, onFailedToRender: () -> Unit) {
        ChatExecutors.BOUNDED.execute {
            val media: Media? = renderCaptureToMedia(
                dataSupplier = { FileInputStream(fileDescriptor) },
                getLength = { it.channel.size() },
                createBlobBuilder = BlobProvider::forData,
                mimeType = VideoUtil.RECORDED_VIDEO_CONTENT_TYPE,
                width = 0,
                height = 0
            )

            if (media != null) {
                onMediaRendered(media)
            } else {
                onFailedToRender()
            }
        }
    }

    private fun <T> renderCaptureToMedia(
        dataSupplier: () -> T,
        getLength: (T) -> Long,
        createBlobBuilder: (BlobProvider, T, Long) -> BlobProvider.BlobBuilder,
        mimeType: String,
        width: Int,
        height: Int
    ): Media? {
        return try {
            val data: T = dataSupplier()
            val length: Long = getLength(data)
            val uri: Uri = createBlobBuilder(BlobProvider.getInstance(), data, length)
                .withMimeType(mimeType)
                .createForSingleSessionOnDisk(requireContext())

            Media(
                uri,
                mimeType,
                System.currentTimeMillis(),
                width,
                height,
                length,
                0,
                false,
                false,
                Optional.empty(),
                Optional.empty()
            )
        } catch (e: IOException) {
            return null
        }
    }

    companion object {
        const val CAPTURE_RESULT = "capture_result"
        const val CAPTURE_RESULT_OK = "capture_result_ok"
    }
}
