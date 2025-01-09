package com.devbeans.io.chat.camera;

import android.annotation.SuppressLint;
import android.content.res.Configuration;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import com.devbeans.io.chat.models.Media;
import com.devbeans.io.chat.utils.views.CameraXUtil;

import java.io.FileDescriptor;
import java.util.Optional;

public interface CameraFragment {

    float PORTRAIT_ASPECT_RATIO = 9 / 16f;

    @SuppressLint("RestrictedApi")
    static Fragment newInstance() {
        return CameraXFragment.newInstance();

    }

    @SuppressLint("RestrictedApi")
    static Fragment newInstanceForAvatarCapture() {
        if (CameraXUtil.isSupported()) {
            return CameraXFragment.newInstanceForAvatarCapture();
        } else {
            return CameraXFragment.newInstance();
        }
    }

    static float getAspectRatioForOrientation(int orientation) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            return PORTRAIT_ASPECT_RATIO;
        } else {
            return 1f / PORTRAIT_ASPECT_RATIO;
        }
    }

    void presentHud(int selectedMediaCount);

    void fadeOutControls(@NonNull Runnable onEndAction);

    void fadeInControls();

    public interface Controller {
        void onCameraError();

        void onImageCaptured(@NonNull byte[] data, int width, int height);

        void onVideoCaptured(@NonNull FileDescriptor fd);

        void onVideoCaptureError();

        void onGalleryClicked();

        int getDisplayRotation();

        void onCameraCountButtonClicked();

        @NonNull
        LiveData<Optional<Media>> getMostRecentMediaItem();

        //        @NonNull MediaConstraints getMediaConstraints();
        int getMaxVideoDuration();
    }
}
