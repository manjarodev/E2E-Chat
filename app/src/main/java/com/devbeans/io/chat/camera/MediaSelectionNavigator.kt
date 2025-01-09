package com.devbeans.io.chat.camera

import android.Manifest
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.devbeans.io.chat.R
import com.devbeans.io.chat.utils.Permissions


class MediaSelectionNavigator(
    private val toCamera: Int = -1,
    private val toGallery: Int = -1
) {
    fun goToReview(navController: NavController) {
        navController.popBackStack(R.id.mediaReviewFragment, false)
    }

    fun goToCamera(navController: NavController) {
        if (toCamera == -1) return

        navController.navigate(toCamera)
    }

    fun goToGallery(navController: NavController) {
        if (toGallery == -1) return

        navController.navigate(toGallery)
    }

    companion object {
        fun Fragment.requestPermissionsForCamera(
            onGranted: () -> Unit
        ) {
            Permissions.with(this)
                .request(Manifest.permission.CAMERA)
                .ifNecessary()
                .withRationaleDialog(getString(R.string.ConversationActivity_to_capture_photos_and_video_allow_chat_access_to_the_camera), R.drawable.ic_camera)
                .withPermanentDenialDialog(getString(R.string.ConversationActivity_signal_needs_the_camera_permission_to_take_photos_or_video))
                .onAllGranted(onGranted)
                .onAnyDenied { Toast.makeText(requireContext(), R.string.ConversationActivity_signal_needs_camera_permissions_to_take_photos_or_video, Toast.LENGTH_LONG).show() }
                .execute()
        }

//        fun Fragment.requestPermissionsForGallery(
//            onGranted: () -> Unit
//        ) {
//            Permissions.with(this)
//                .request(Manifest.permission.READ_EXTERNAL_STORAGE)
//                .ifNecessary()
//                .withPermanentDenialDialog(getString(R.string.AttachmentKeyboard_Signal_needs_permission_to_show_your_photos_and_videos))
//                .onAllGranted(onGranted)
//                .onAnyDenied { Toast.makeText(this.requireContext(), R.string.AttachmentKeyboard_Signal_needs_permission_to_show_your_photos_and_videos, Toast.LENGTH_LONG).show() }
//                .execute()
//        }
    }
}
