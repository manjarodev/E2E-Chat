package com.devbeans.io.chat.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.utils.logging.Log
import java.util.concurrent.TimeUnit


private const val IMAGE_EDITOR_TAG = "image.editor.fragment"

private val MODE_DELAY = TimeUnit.MILLISECONDS.toMillis(300)

/**
 * Displays the chosen image within the image editor. Also manages the "touch enabled" state of the shared
 * view model. We utilize delays here to help with Animation choreography.
 */
class MediaReviewImagePageFragment : Fragment(R.layout.fragment_container),
    ImageEditorFragment.Controller {

    private lateinit var imageEditorFragment: ImageEditorFragment

//    private val sharedViewModel: MediaSelectionViewModel by viewModels(ownerProducer = { requireActivity() })
//    private lateinit var hudCommandDisposable: Disposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imageEditorFragment = ensureImageEditorFragment()
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(
            CommandReceiver,
            IntentFilter("image_edit_command")
        )
    }

    override fun onPause() {
        super.onPause()

//        hudCommandDisposable.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(CommandReceiver)

    }

    private val CommandReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getStringExtra("command")
            when {
                message.equals("draw", ignoreCase = true) -> {
                    requireView().postDelayed(
                        {
                            imageEditorFragment.setMode(ImageEditorHudV2.Mode.DRAW)
                        },
                        MODE_DELAY
                    )
                }
                message.equals("cropAndRotate", ignoreCase = true) -> {
                    requireView().postDelayed(
                        {
                            imageEditorFragment.setMode(ImageEditorHudV2.Mode.CROP)
                        },
                        MODE_DELAY
                    )

                }
                message.equals("quality", ignoreCase = true) -> {
                    requireView().postDelayed(
                        {
                            imageEditorFragment.setMode(ImageEditorHudV2.Mode.NONE)
                        },
                        MODE_DELAY
                    )

                }
            }

//            Log.e(TAG, message.toString())
        }
    }

    override fun onResume() {
        super.onResume()
//        hudCommandDisposable = sharedViewModel.hudCommands.subscribe { command ->
//            if (isResumed) {
//                when (command) {
//                    HudCommand.StartDraw -> {
//                        sharedViewModel.setTouchEnabled(false)
//                        requireView().postDelayed(
//                            {
//                                imageEditorFragment.setMode(ImageEditorHudV2.Mode.DRAW)
//                            },
//                            MODE_DELAY
//                        )
//                    }
//                    HudCommand.StartCropAndRotate -> {
//                        sharedViewModel.setTouchEnabled(false)
//                        requireView().postDelayed(
//                            {
//                                imageEditorFragment.setMode(ImageEditorHudV2.Mode.CROP)
//                            },
//                            MODE_DELAY
//                        )
//                    }
//                    HudCommand.SaveMedia -> imageEditorFragment.onSave()
//                    else -> Unit
//                }
//            }
//        }

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        restoreImageEditorState()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

//        sharedViewModel.setEditorState(requireUri(), requireNotNull(imageEditorFragment.saveState()))
    }

    private fun ensureImageEditorFragment(): ImageEditorFragment {
        val fragmentInManager: ImageEditorFragment? =
            childFragmentManager.findFragmentByTag(IMAGE_EDITOR_TAG) as? ImageEditorFragment

        return if (fragmentInManager != null) {
//            sharedViewModel.sendCommand(HudCommand.ResumeEntryTransition)
            fragmentInManager
        } else {
            val imageEditorFragment = ImageEditorFragment.newInstance(
                requireUri()
            )

            childFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    imageEditorFragment,
                    IMAGE_EDITOR_TAG
                )
                .commitAllowingStateLoss()

            imageEditorFragment
        }
    }

    private fun requireUri(): Uri = requireNotNull(requireArguments().getParcelable(ARG_URI))

    override fun onTouchEventsNeeded(needed: Boolean) {
        if (isResumed) {
            if (!needed) {
//                requireView().postDelayed(
//                    {
//                        sharedViewModel.setTouchEnabled(!needed)
//                    },
//                    MODE_DELAY
//                )
            } else {
//                sharedViewModel.setTouchEnabled(!needed)
            }
        }
    }

    override fun onRequestFullScreen(fullScreen: Boolean, hideKeyboard: Boolean) = Unit

    override fun onDoneEditing() {
        imageEditorFragment.setMode(ImageEditorHudV2.Mode.NONE)
        imageEditorFragment.saveState()
        val uri: String =imageEditorFragment.renderToSingleUseBlob()
        sendCommand(uri)
        if (isResumed) {
            Log.e(TAG, "URI ${requireUri()} Edited URI {${uri}}")
        }
    }

    override fun onCancelEditing() {
        restoreImageEditorState()
        sendCommand("cancel_edit")
    }

    override fun onMainImageLoaded() {
//        sharedViewModel.sendCommand(HudCommand.ResumeEntryTransition)
    }

    override fun onMainImageFailedToLoad() {
//        sharedViewModel.sendCommand(HudCommand.ResumeEntryTransition)
    }

    private fun restoreImageEditorState() {
//        val data = sharedViewModel.getEditorState(requireUri()) as? ImageEditorFragment.Data
        val data = getEditorState(requireUri()) as? ImageEditorFragment.Data
        if (data != null) {
            imageEditorFragment.restoreState(data)
        } else {
            imageEditorFragment.onClearAll()
        }
    }

    private fun getEditorState(uri: Uri): Any? {
        return uri
    }

    private fun sendCommand(command: String) {

//        Log.d("sender", "Broadcasting message")
        val intent = Intent("image_edit_command_receive")
        // You can also include some extra data.
        intent.putExtra("command", command)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

    }



    companion object {
        private const val ARG_URI = "arg.uri"
        private val TAG = Log.tag(MediaReviewImagePageFragment::class.java)

        fun newInstance(uri: Uri): Fragment {
            return MediaReviewImagePageFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_URI, uri)
                }
            }
        }
    }
}
