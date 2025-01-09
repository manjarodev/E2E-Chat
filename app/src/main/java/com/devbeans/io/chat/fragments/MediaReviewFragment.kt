package com.devbeans.io.chat.fragments

import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ViewSwitcher
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.MediaReviewFragmentPagerAdapter
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.OnDataPass
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Media
import com.devbeans.io.chat.utils.*
import java.util.*

/**
 * Allows the user to view and edit selected media.
 */
class MediaReviewFragment : Fragment(R.layout.v2_media_review_fragment) {

//    private val sharedViewModel: MediaSelectionViewModel by viewModels(
//        ownerProducer = { requireActivity() }
//    )

//    private lateinit var callback: Callback

    lateinit var dataPasser: OnDataPass
    private var parsedUri: Uri? = null
    private lateinit var drawToolButton: View
    private lateinit var cropAndRotateButton: View
    private lateinit var qualityButton: ImageView
    private lateinit var editedImage: ImageView
    private lateinit var limitLessView: ImageView
    private lateinit var viewOnceView: ImageView
    private lateinit var saveButton: View
    private lateinit var sendButton: View
    private lateinit var addMediaButton: View
    private lateinit var viewOnceButton: ViewSwitcher
    private lateinit var viewOnceMessage: TextView
    private lateinit var addMessageButton: TextView
    private lateinit var addMessageEntry: TextView
    private lateinit var recipientDisplay: TextView
    private lateinit var pager: ViewPager2
    private lateinit var controls: ConstraintLayout
    private lateinit var selectionRecycler: RecyclerView
    private lateinit var controlsShade: View
    private lateinit var progress: ProgressBar
    private lateinit var progressWrapper: TouchInterceptingFrameLayout
    private lateinit var layoutCon: ConstraintLayout

    private var isEdit: Boolean = false
    private var fromImage: Boolean = false
    private var file_path: String? = null
    public var data: Data = Data()

//    private val navigator = MediaSelectionNavigator(
//        toGallery = R.id.action_mediaReviewFragment_to_mediaGalleryFragment,
//    )

    private var animatorSet: AnimatorSet? = null

    //    private var disposables: CompositeDisposable? = null
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return LayoutInflater.from(requireContext()).inflate(R.layout.v2_media_review_fragment, container, false)
//    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val uri = requireArguments().getString(Constants.KEYS.INTENT_MEDIA_URI)
        val conversation =
            requireArguments().getSerializable(Constants.KEYS.INTENT_CONVERSATION) as Conversation
        drawToolButton = view.findViewById(R.id.draw_tool)
        cropAndRotateButton = view.findViewById(R.id.crop_and_rotate_tool)
        qualityButton = view.findViewById(R.id.quality_selector)
        saveButton = view.findViewById(R.id.save_to_media)
        sendButton = view.findViewById(R.id.send)
        recipientDisplay = view.findViewById(R.id.recipient)
        editedImage = view.findViewById(R.id.editedImage)
        limitLessView = view.findViewById(R.id.view_limitless)
        viewOnceView = view.findViewById(R.id.view_once)
        layoutCon = view.findViewById(R.id.layout_con)
        layoutCon.visibility= VISIBLE
        if (conversation != null && conversation.name != null) {
            recipientDisplay.text = conversation.name
        }
        instance = this
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(
            CommandReceiver,
            IntentFilter("image_edit_command_receive")
        )
        parsedUri = Uri.parse(uri)
        var media: Media? = null
        recipientDisplay.visibility = VISIBLE
        if (MediaUtil.isVideo(MediaUtil.getMimeType(requireActivity(), parsedUri))) {
            fromImage = false
            drawToolButton.visibility = GONE
            cropAndRotateButton.visibility = GONE
            qualityButton.visibility = GONE
            saveButton.visibility = GONE

            val videoSize = MediaUtil.getVideoSize(appContext, parsedUri)
            media = Media(
                Uri.parse(uri),
                MediaUtil.getMimeType(requireActivity(), parsedUri).toString(),
                System.currentTimeMillis(),
                videoSize.width,
                videoSize.height,
                MediaUtil.getMediaSize(requireActivity(), parsedUri),
                videoSize.duration,
                false,
                false,
                Optional.empty(),
                Optional.empty()
            )
        }

        if (MediaUtil.isImage(MediaUtil.getMimeType(requireActivity(), parsedUri))) {
            fromImage = true
            media = Media(
                Uri.parse(uri),
                MediaUtil.getMimeType(requireActivity(), parsedUri).toString(),
                System.currentTimeMillis(),
                768,
                1024,
                MediaUtil.getMediaSize(requireActivity(), parsedUri),
                0,
                false,
                false,
                Optional.empty(),
                Optional.empty()
            )
        }

//        postponeEnterTransition()
//
//        callback = requireListener()
//


//        addMediaButton = view.findViewById(R.id.add_media)
        viewOnceButton = view.findViewById(R.id.view_once_toggle)
//        addMessageButton = view.findViewById(R.id.add_a_message)
//        addMessageEntry = view.findViewById(R.id.add_a_message_entry)

        pager = view.findViewById(R.id.media_pager)
        controls = view.findViewById(R.id.controls)
//        selectionRecycler = view.findViewById(R.id.selection_recycler)
        controlsShade = view.findViewById(R.id.controls_shade)
//        viewOnceMessage = view.findViewById(R.id.view_once_message)
//        progress = view.findViewById(R.id.progress)
        progressWrapper = view.findViewById(R.id.progress_wrapper)
//
//        DrawableCompat.setTint(progress.indeterminateDrawable, Color.WHITE)

        controlsShade.visibility = GONE
        progressWrapper.setOnInterceptTouchEventListener { true }
//
        val pagerAdapter = MediaReviewFragmentPagerAdapter(this)

//        disposables = CompositeDisposable()
//        disposables?.add(
//            sharedViewModel.hudCommands.subscribe {
//                when (it) {
//                    HudCommand.ResumeEntryTransition -> startPostponedEnterTransition()
//                    else -> Unit
//                }
//            }
//        )

        pager.adapter = pagerAdapter
        pager.isUserInputEnabled = false
        pager.setCurrentItem(0, false)
        pagerAdapter.submitMedia(media = listOf(media!!))

        drawToolButton.setOnClickListener {
//            sharedViewModel.sendCommand(HudCommand.StartDraw)
            hideComponenets(GONE)
            sendCommand("Draw")
        }

        cropAndRotateButton.setOnClickListener {
//            sharedViewModel.sendCommand(HudCommand.StartCropAndRotate)
            sendCommand("cropAndRotate")
            hideComponenets(GONE)
        }

        qualityButton.setOnClickListener {
//            QualitySelectorBottomSheetDialog.show(parentFragmentManager)
            sendCommand("quality")
        }

        saveButton.setOnClickListener {
//            sharedViewModel.sendCommand(HudCommand.SaveMedia)
        }
//
//        setFragmentResultListener(MultiselectForwardFragment.RESULT_KEY) { _, bundle ->
//            val parcelizedKeys: List<ContactSearchKey.ParcelableRecipientSearchKey> = bundle.getParcelableArrayList(MultiselectForwardFragment.RESULT_SELECTION)!!
//            val contactSearchKeys = parcelizedKeys.map { it.asRecipientSearchKey() }
//            performSend(contactSearchKeys)
//        }

        sendButton.setOnClickListener {

//            if (sharedViewModel.isContactSelectionRequired) {
//                val args = MultiselectForwardFragmentArgs(false, title = R.string.MediaReviewFragment__send_to)
//                MultiselectForwardFragment.showFullScreen(parentFragmentManager, args)
//            } else {
//                performSend()
//            }

            val viewOnce = viewOnceButton.currentView == viewOnceView
            if (fromImage) {
                if (isEdit)
                    sendCommandActivity(file_path!!,viewOnce)
                else {
                    sendCommandActivity("cancel_edit",viewOnce)
                }
            } else {
                if (dataPasser != null) {
                    dataPasser.onDataPass(
                        data.isDurationEdited,
                        data.totalDurationUs,
                        data.startTimeUs,
                        data.endTimeUs,
                        viewOnce
                    )
                    progressWrapper.visibility = View.VISIBLE
                    progressWrapper.animate()
                        .setStartDelay(300)
                        .setInterpolator(MediaAnimations.interpolator)
                        .alpha(1f)
                } else {
                    dataPasser = context as OnDataPass
                    dataPasser.onDataPass(
                        data.isDurationEdited,
                        data.totalDurationUs,
                        data.startTimeUs,
                        data.endTimeUs,
                        viewOnce
                    )
                    progressWrapper.animate()
                        .setStartDelay(300)
                        .setInterpolator(MediaAnimations.interpolator)
                        .alpha(1f)
                }
            }
        }
//
//        addMediaButton.setOnClickListener {
//            launchGallery()
//        }
//
        viewOnceButton.setOnClickListener {
            viewOnceButton.showPrevious()
//            MediaReviewAnimatorController.getFadeInAnimator(viewOnceButton)
//            sharedViewModel.incrementViewOnceState()
        }
//
//        addMessageButton.setOnClickListener {
//            AddMessageDialogFragment.show(parentFragmentManager, sharedViewModel.state.value?.message)
//        }
//
//        addMessageEntry.setOnClickListener {
//            AddMessageDialogFragment.show(parentFragmentManager, sharedViewModel.state.value?.message)
//        }
//
//        if (sharedViewModel.isReply) {
//            addMessageButton.setText(R.string.MediaReviewFragment__add_a_reply)
//        }
//
//        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                sharedViewModel.setFocusedMedia(position)
//            }
//        })
//
//        val selectionAdapter = MappingAdapter()
//        MediaReviewAddItem.register(selectionAdapter) {
//            launchGallery()
//        }
//        MediaReviewSelectedItem.register(selectionAdapter) { media, isSelected ->
//            if (isSelected) {
//                sharedViewModel.removeMedia(media)
//            } else {
//                sharedViewModel.setFocusedMedia(media)
//            }
//        }
//        selectionRecycler.adapter = selectionAdapter
//        ItemTouchHelper(MediaSelectionItemTouchHelper(sharedViewModel)).attachToRecyclerView(selectionRecycler)
//
//        sharedViewModel.state.observe(viewLifecycleOwner) { state ->
//            pagerAdapter.submitMedia(state.selectedMedia)
//
//            selectionAdapter.submitList(
//                state.selectedMedia.map { MediaReviewSelectedItem.Model(it, state.focusedMedia == it) } + MediaReviewAddItem.Model
//            )
//
//            presentSendButton(state.transportOption)
//            presentPager(state)
//            presentAddMessageEntry(state.message)
//            presentImageQualityToggle(state.quality)
//
//            viewOnceButton.displayedChild = if (state.viewOnceToggleState == MediaSelectionState.ViewOnceToggleState.ONCE) 1 else 0
//
//            computeViewStateAndAnimate(state)
//        }
//
//        sharedViewModel.mediaErrors.observe(viewLifecycleOwner, this::handleMediaValidatorFilterError)
//
//        requireActivity().onBackPressedDispatcher.addCallback(
//            viewLifecycleOwner,
//            object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    callback.onPopFromReview()
//                }
//            }
//        )
    }

    private fun hideComponenets(visibility: Int) {
        drawToolButton.visibility = visibility
        cropAndRotateButton.visibility = visibility
        sendButton.visibility = visibility
        viewOnceButton.visibility = visibility
        recipientDisplay.visibility = visibility


    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(CommandReceiver)
        super.onDestroy()
    }

    private val CommandReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getStringExtra("command")
//            editedImage.setImageURI(Uri.parse(message))

            if (message.equals("cancel_edit", ignoreCase = true)) {
                isEdit = false
            } else {
                file_path = message
                isEdit = true
            }
            hideComponenets(VISIBLE)


//            Log.e(TAG, message.toString())
        }
    }

    private fun sendCommand(command: String) {

//        Log.d("sender", "Broadcasting message")
        val intent = Intent("image_edit_command")
        // You can also include some extra data.
        intent.putExtra("command", command)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

    }

    private fun sendCommandActivity(command: String,viewOnce:Boolean) {

//        Log.d("sender", "Broadcasting message")
        val intent = Intent("image_edit_command_activity")
        intent.putExtra(Constants.KEYS.INTENT_VIEW_ONCE,viewOnce)
        // You can also include some extra data.
        intent.putExtra("command", command)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass
    }

    override fun onResume() {
        super.onResume()
//        sharedViewModel.kick()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
//        Permissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
    }

    override fun onDestroyView() {
//        disposables?.dispose()
        super.onDestroyView()
    }

//    private fun handleMediaValidatorFilterError(error: MediaValidator.FilterError) {
//        @Exhaustive
////        when (error) {
////            MediaValidator.FilterError.ItemTooLarge -> Toast.makeText(requireContext(), R.string.MediaReviewFragment__one_or_more_items_were_too_large, Toast.LENGTH_SHORT).show()
////            MediaValidator.FilterError.ItemInvalidType -> Toast.makeText(requireContext(), R.string.MediaReviewFragment__one_or_more_items_were_invalid, Toast.LENGTH_SHORT).show()
////            MediaValidator.FilterError.TooManyItems -> Toast.makeText(requireContext(), R.string.MediaReviewFragment__too_many_items_selected, Toast.LENGTH_SHORT).show()
////            is MediaValidator.FilterError.NoItems -> {
////                if (error.cause != null) {
////                    handleMediaValidatorFilterError(error.cause)
////                } else {
////                    Toast.makeText(requireContext(), R.string.MediaReviewFragment__one_or_more_items_were_invalid, Toast.LENGTH_SHORT).show()
////                }
////                callback.onNoMediaSelected()
////            }
////        }
//    }

//    private fun launchGallery() {
//        val controller = findNavController()
//        requestPermissionsForGallery {
//            navigator.goToGallery(controller)
//        }
//    }

//    private fun performSend(selection: List<ContactSearchKey> = listOf()) {
//        progressWrapper.visible = true
//        progressWrapper.animate()
//            .setStartDelay(300)
//            .setInterpolator(MediaAnimations.interpolator)
//            .alpha(1f)
//
//        sharedViewModel
//            .send(selection.filterIsInstance(ContactSearchKey.RecipientSearchKey::class.java))
//            .subscribe(
//                { result -> callback.onSentWithResult(result) },
//                { error -> callback.onSendError(error) },
//                { callback.onSentWithoutResult() }
//            )
//    }

//    private fun presentAddMessageEntry(message: CharSequence?) {
//        addMessageEntry.setText(message, TextView.BufferType.SPANNABLE)
//    }
//
//    private fun presentImageQualityToggle(quality: SentMediaQuality) {
//        qualityButton.setImageResource(
//            when (quality) {
//                SentMediaQuality.STANDARD -> R.drawable.ic_sq_36
//                SentMediaQuality.HIGH -> R.drawable.ic_hq_36
//            }
//        )
//    }
//
//    private fun presentSendButton(transportOption: TransportOption) {
//        val sendButtonTint = if (transportOption.type == TransportOption.Type.TEXTSECURE) {
//            R.color.core_ultramarine
//        } else {
//            R.color.core_grey_50
//        }
//
//        ViewCompat.setBackgroundTintList(sendButton, ColorStateList.valueOf(ContextCompat.getColor(requireContext(), sendButtonTint)))
//    }
//
//    private fun presentPager(state: MediaSelectionState) {
//        pager.isUserInputEnabled = state.isTouchEnabled
//
//        val indexOfSelectedItem = state.selectedMedia.indexOf(state.focusedMedia)
//
//        if (pager.currentItem == indexOfSelectedItem) {
//            return
//        }
//
//        if (indexOfSelectedItem != -1) {
//            pager.setCurrentItem(indexOfSelectedItem, false)
//        } else {
//            pager.setCurrentItem(0, false)
//        }
//    }
//
//    private fun computeViewStateAndAnimate(state: MediaSelectionState) {
//        this.animatorSet?.cancel()
//
//        val animators = mutableListOf<Animator>()
//
//        animators.addAll(computeAddMessageAnimators(state))
//        animators.addAll(computeViewOnceButtonAnimators(state))
//        animators.addAll(computeAddMediaButtonsAnimators(state))
//        animators.addAll(computeSendButtonAnimators(state))
//        animators.addAll(computeSaveButtonAnimators(state))
//        animators.addAll(computeQualityButtonAnimators(state))
//        animators.addAll(computeCropAndRotateButtonAnimators(state))
//        animators.addAll(computeDrawToolButtonAnimators(state))
//        animators.addAll(computeRecipientDisplayAnimators(state))
//        animators.addAll(computeControlsShadeAnimators(state))
//
//        val animatorSet = AnimatorSet()
//        animatorSet.playTogether(animators)
//        animatorSet.interpolator = MediaAnimations.interpolator
//        animatorSet.start()
//
//        this.animatorSet = animatorSet
//    }
//
//    private fun computeControlsShadeAnimators(state: MediaSelectionState): List<Animator> {
//        return if (state.isTouchEnabled) {
//            listOf(MediaReviewAnimatorController.getFadeInAnimator(controlsShade))
//        } else {
//            listOf(MediaReviewAnimatorController.getFadeOutAnimator(controlsShade))
//        }
//    }
//
//    private fun computeAddMessageAnimators(state: MediaSelectionState): List<Animator> {
//        return when {
//            !state.isTouchEnabled -> {
//                listOf(
//                    MediaReviewAnimatorController.getFadeOutAnimator(viewOnceMessage),
//                    MediaReviewAnimatorController.getFadeOutAnimator(addMessageButton),
//                    MediaReviewAnimatorController.getFadeOutAnimator(addMessageEntry)
//                )
//            }
//            state.viewOnceToggleState == MediaSelectionState.ViewOnceToggleState.ONCE -> {
//                listOf(
//                    MediaReviewAnimatorController.getFadeInAnimator(viewOnceMessage),
//                    MediaReviewAnimatorController.getFadeOutAnimator(addMessageButton),
//                    MediaReviewAnimatorController.getFadeOutAnimator(addMessageEntry)
//                )
//            }
//            state.message.isNullOrEmpty() -> {
//                listOf(
//                    MediaReviewAnimatorController.getFadeOutAnimator(viewOnceMessage),
//                    MediaReviewAnimatorController.getFadeInAnimator(addMessageButton),
//                    MediaReviewAnimatorController.getFadeOutAnimator(addMessageEntry)
//                )
//            }
//            else -> {
//                listOf(
//                    MediaReviewAnimatorController.getFadeOutAnimator(viewOnceMessage),
//                    MediaReviewAnimatorController.getFadeInAnimator(addMessageEntry),
//                    MediaReviewAnimatorController.getFadeOutAnimator(addMessageButton)
//                )
//            }
//        }
//    }
//
//    private fun computeViewOnceButtonAnimators(state: MediaSelectionState): List<Animator> {
//        return if (state.isTouchEnabled && state.selectedMedia.size == 1 && !state.isStory) {
//            listOf(MediaReviewAnimatorController.getFadeInAnimator(viewOnceButton))
//        } else {
//            listOf(MediaReviewAnimatorController.getFadeOutAnimator(viewOnceButton))
//        }
//    }
//
//    private fun computeAddMediaButtonsAnimators(state: MediaSelectionState): List<Animator> {
//        return when {
//            !state.isTouchEnabled || state.viewOnceToggleState == MediaSelectionState.ViewOnceToggleState.ONCE -> {
//                listOf(
//                    MediaReviewAnimatorController.getFadeOutAnimator(addMediaButton),
//                    MediaReviewAnimatorController.getFadeOutAnimator(selectionRecycler)
//                )
//            }
//            state.selectedMedia.size > 1 -> {
//                listOf(
//                    MediaReviewAnimatorController.getFadeOutAnimator(addMediaButton),
//                    MediaReviewAnimatorController.getFadeInAnimator(selectionRecycler)
//                )
//            }
//            else -> {
//                listOf(
//                    MediaReviewAnimatorController.getFadeInAnimator(addMediaButton),
//                    MediaReviewAnimatorController.getFadeOutAnimator(selectionRecycler)
//                )
//            }
//        }
//    }
//
//    private fun computeSendButtonAnimators(state: MediaSelectionState): List<Animator> {
//
//        val slideIn = listOf(
//            MediaReviewAnimatorController.getSlideInAnimator(sendButton),
//        )
//
//        return slideIn + if (state.isTouchEnabled) {
//            listOf(
//                MediaReviewAnimatorController.getFadeInAnimator(sendButton, state.canSend),
//            )
//        } else {
//            listOf(
//                MediaReviewAnimatorController.getFadeOutAnimator(sendButton, state.canSend),
//            )
//        }
//    }
//
//    private fun computeSaveButtonAnimators(state: MediaSelectionState): List<Animator> {
//
//        val slideIn = listOf(
//            MediaReviewAnimatorController.getSlideInAnimator(saveButton)
//        )
//
//        return slideIn + if (state.isTouchEnabled && !MediaUtil.isVideo(state.focusedMedia?.mimeType)) {
//            listOf(
//                MediaReviewAnimatorController.getFadeInAnimator(saveButton)
//            )
//        } else {
//            listOf(
//                MediaReviewAnimatorController.getFadeOutAnimator(saveButton)
//            )
//        }
//    }
//
//    private fun computeQualityButtonAnimators(state: MediaSelectionState): List<Animator> {
//        val slide = listOf(MediaReviewAnimatorController.getSlideInAnimator(qualityButton))
//
//        return slide + if (state.isTouchEnabled && state.selectedMedia.any { MediaUtil.isImageType(it.mimeType) }) {
//            listOf(MediaReviewAnimatorController.getFadeInAnimator(qualityButton))
//        } else {
//            listOf(MediaReviewAnimatorController.getFadeOutAnimator(qualityButton))
//        }
//    }
//
//    private fun computeCropAndRotateButtonAnimators(state: MediaSelectionState): List<Animator> {
//        val slide = listOf(MediaReviewAnimatorController.getSlideInAnimator(cropAndRotateButton))
//
//        return slide + if (state.isTouchEnabled && MediaUtil.isImageAndNotGif(state.focusedMedia?.mimeType ?: "")) {
//            listOf(MediaReviewAnimatorController.getFadeInAnimator(cropAndRotateButton))
//        } else {
//            listOf(MediaReviewAnimatorController.getFadeOutAnimator(cropAndRotateButton))
//        }
//    }
//
//    private fun computeDrawToolButtonAnimators(state: MediaSelectionState): List<Animator> {
//        val slide = listOf(MediaReviewAnimatorController.getSlideInAnimator(drawToolButton))
//
//        return slide + if (state.isTouchEnabled && MediaUtil.isImageAndNotGif(state.focusedMedia?.mimeType ?: "")) {
//            listOf(MediaReviewAnimatorController.getFadeInAnimator(drawToolButton))
//        } else {
//            listOf(MediaReviewAnimatorController.getFadeOutAnimator(drawToolButton))
//        }
//    }
//
//    private fun computeRecipientDisplayAnimators(state: MediaSelectionState): List<Animator> {
//        return if (state.isTouchEnabled && state.recipient != null) {
//            recipientDisplay.text = if (state.recipient.isSelf) requireContext().getString(R.string.note_to_self) else state.recipient.getDisplayName(requireContext())
//            listOf(MediaReviewAnimatorController.getFadeInAnimator(recipientDisplay))
//        } else {
//            listOf(MediaReviewAnimatorController.getFadeOutAnimator(recipientDisplay))
//        }
//    }
//
//    interface Callback {
//        fun onSentWithResult(mediaSendActivityResult: MediaSendActivityResult)
//        fun onSentWithoutResult()
//        fun onSendError(error: Throwable)
//        fun onNoMediaSelected()
//        fun onPopFromReview()
//    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmField
        var instance: MediaReviewFragment? = null

        @JvmStatic
        fun getInstance(): MediaReviewFragment? {
            if (instance == null) {
                instance = MediaReviewFragment()
            }
            return instance
        }

    }

}

public class Data {
    var isDurationEdited = false
    var totalDurationUs: Long = 0
    var startTimeUs: Long = 0
    var endTimeUs: Long = 0
    val bundle: Bundle
        get() {
            val bundle = Bundle()
            bundle.putByte("EDITED", (if (isDurationEdited) 1 else 0).toByte())
            bundle.putLong("TOTAL", totalDurationUs)
            bundle.putLong("START", startTimeUs)
            bundle.putLong("END", endTimeUs)
            return bundle
        }

    companion object {
        fun fromBundle(bundle: Bundle): Data {
            val data = Data()
            data.isDurationEdited = bundle.getByte("EDITED") == 1.toByte()
            data.totalDurationUs = bundle.getLong("TOTAL")
            data.startTimeUs = bundle.getLong("START")
            data.endTimeUs = bundle.getLong("END")
            return data
        }
    }
}


