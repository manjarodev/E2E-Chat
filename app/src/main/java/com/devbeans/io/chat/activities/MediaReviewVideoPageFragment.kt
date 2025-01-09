package com.devbeans.io.chat.activities

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.fragments.MediaReviewFragment
import com.devbeans.io.chat.fragments.VideoEditorFragment
import com.devbeans.io.chat.utils.VideoUtil

private const val VIDEO_EDITOR_TAG = "video.editor.fragment"

/**
 * Page fragment which displays a single editable video (non-gif) to the user. Has an embedded MediaSendVideoFragment
 * and adds some extra support for saving and restoring state, as well as saving a video to disk.
 */
class MediaReviewVideoPageFragment : Fragment(R.layout.fragment_container),
    VideoEditorFragment.Controller {

//    private val sharedViewModel: MediaSelectionViewModel by viewModels(ownerProducer = { requireActivity() })

    private lateinit var videoEditorFragment: VideoEditorFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        videoEditorFragment = ensureVideoEditorFragment()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        restoreVideoEditorState()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveEditorState()
    }

    private fun saveEditorState() {
        val saveState = videoEditorFragment.saveState()
        if (saveState != null) {
//            sharedViewModel.setEditorState(requireUri(), saveState)
        }
    }


    override fun onPlayerReady() {
//        sharedViewModel.sendCommand(HudCommand.ResumeEntryTransition)
    }

    override fun onPlayerError() {
//        sharedViewModel.sendCommand(HudCommand.ResumeEntryTransition)
    }

    override fun onTouchEventsNeeded(needed: Boolean) {
//        sharedViewModel.setTouchEnabled(!needed)
    }

    override fun onVideoBeginEdit(uri: Uri) {
//        sharedViewModel.onVideoBeginEdit(uri)
    }

    override fun onVideoEndEdit(uri: Uri) {
        saveEditorState()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onVideoEditComplete(data: VideoEditorFragment.Data?) {
        if (data != null) {
            MediaReviewFragment.instance!!.data.totalDurationUs=data.totalDurationUs
            MediaReviewFragment.instance!!.data.endTimeUs=data.endTimeUs
            MediaReviewFragment.instance!!.data.startTimeUs=data.startTimeUs
            MediaReviewFragment.instance!!.data.isDurationEdited=data.isDurationEdited
//            Log.e(tag, MediaReviewFragment.instance!!.data.toString())
        }
    }


    private fun restoreVideoEditorState() {
//        val data = sharedViewModel.getEditorState(requireUri()) as? VideoEditorFragment.Data
        val data = null

        if (data != null) {
            videoEditorFragment.restoreState(data!!)
        }
    }

    private fun ensureVideoEditorFragment(): VideoEditorFragment {
        val fragmentInManager: VideoEditorFragment? =
            childFragmentManager.findFragmentByTag(VIDEO_EDITOR_TAG) as? VideoEditorFragment

        return if (fragmentInManager != null) {
            fragmentInManager
        } else {
            val videoEditorFragment = VideoEditorFragment.newInstance(
                requireUri(),
                requireMaxCompressedVideoSize(),
                requireMaxAttachmentSize(),
                requireIsVideoGif(),
                requireMaxVideoDuration()
            )

            childFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    videoEditorFragment,
                    VIDEO_EDITOR_TAG
                )
                .commitAllowingStateLoss()

            videoEditorFragment
        }
    }

    private fun requireUri(): Uri = requireNotNull(requireArguments().getParcelable(ARG_URI))
    private fun requireMaxCompressedVideoSize(): Long =
        VideoUtil.getCompressedVideoMaxSize(requireContext()).toLong()

    private fun requireMaxAttachmentSize(): Long =
        VideoUtil.getVideoMaxSize(requireContext()).toLong()

    private fun requireIsVideoGif(): Boolean =
        requireNotNull(requireArguments().getBoolean(ARG_IS_VIDEO_GIF))

    //    private fun requireMaxVideoDuration(): Long = if (sharedViewModel.isStory()) Stories.MAX_VIDEO_DURATION_MILLIS else Long.MAX_VALUE
    private fun requireMaxVideoDuration(): Long = VideoUtil.MAX_VIDEO_DURATION_MILLIS

    companion object {
        private const val ARG_URI = "arg.uri"
        private const val ARG_IS_VIDEO_GIF = "arg.is.video.gif"

        fun newInstance(uri: Uri, isVideoGif: Boolean): Fragment {
            return MediaReviewVideoPageFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_URI, uri)
                    putBoolean(ARG_IS_VIDEO_GIF, isVideoGif)
                }
            }
        }
    }
}
