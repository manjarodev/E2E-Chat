package com.devbeans.io.chat.utils.views;


import android.Manifest;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.VideoCapture;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.util.Executors;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.camera.ChatCameraView;
import com.devbeans.io.chat.utils.Permissions;
import com.devbeans.io.chat.utils.Util;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.VideoUtil;
import com.devbeans.io.chat.utils.logging.Log;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

@RequiresApi(26)
public class CameraXVideoCaptureHelper implements CameraButtonView.VideoCaptureListener {

    private static final String TAG = CameraXVideoCaptureHelper.class.getName();
    private static final String VIDEO_DEBUG_LABEL = "video-capture";
    private static final long VIDEO_SIZE = (long) 10 * (long) 1024 * (long) 1024;

    private final @NonNull
    Fragment fragment;
    private final @NonNull
    ChatCameraView camera;
    private final @NonNull
    Callback callback;
    private final @NonNull
    MemoryFileDescriptor memoryFileDescriptor;
    private final @NonNull
    ValueAnimator updateProgressAnimator;

    private boolean isRecording;
    private ValueAnimator cameraMetricsAnimator;

    private final VideoCapture.OnVideoSavedCallback videoSavedListener = new VideoCapture.OnVideoSavedCallback() {
        @SuppressLint("RestrictedApi")
        @Override
        public void onVideoSaved(@NonNull VideoCapture.OutputFileResults outputFileResults) {
            try {
                isRecording = false;
                camera.setZoomRatio(camera.getMinZoomRatio());
                memoryFileDescriptor.seek(0);
                callback.onVideoSaved(memoryFileDescriptor.getFileDescriptor());
            } catch (Exception e) {
                callback.onVideoError(e);
            }
        }

        @SuppressLint("RestrictedApi")
        @Override
        public void onError(int videoCaptureError, @NonNull String message, @Nullable Throwable cause) {
            isRecording = false;
            callback.onVideoError(cause);
        }
    };

    public CameraXVideoCaptureHelper(@NonNull Fragment fragment,
                                     @NonNull CameraButtonView captureButton,
                                     @NonNull ChatCameraView camera,
                                     @NonNull MemoryFileDescriptor memoryFileDescriptor,
                                     int maxVideoDurationSec,
                                     @NonNull Callback callback) {
        this.fragment = fragment;
        this.camera = camera;
        this.memoryFileDescriptor = memoryFileDescriptor;
        this.callback = callback;
        this.updateProgressAnimator = ValueAnimator.ofFloat(0f, 1f).setDuration((long) maxVideoDurationSec * (long) 1000);

        updateProgressAnimator.setInterpolator(new LinearInterpolator());
        updateProgressAnimator.addUpdateListener(anim -> captureButton.setProgress(anim.getAnimatedFraction()));
        updateProgressAnimator.addListener(new AnimationEndCallback() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (isRecording) onVideoCaptureComplete();
            }
        });
    }

    @Override
    public void onVideoCaptureStarted() throws IOException {
        Log.d(TAG, "onVideoCaptureStarted");

        if (canRecordAudio()) {
            isRecording = true;
            beginCameraRecording();
        } else {
            displayAudioRecordingPermissionsDialog();
        }
    }

    private boolean canRecordAudio() {
        return Permissions.hasAll(fragment.requireContext(), Manifest.permission.RECORD_AUDIO);
    }

    private void displayAudioRecordingPermissionsDialog() {
        Permissions.with(fragment)
                .request(Manifest.permission.RECORD_AUDIO)
                .ifNecessary()
                .withRationaleDialog(fragment.getString(R.string.ConversationActivity_enable_the_microphone_permission_to_capture_videos_with_sound), R.drawable.ic_mic_solid_24)
//                .withPermanentDenialDialog(fragment.getString(R.string.ConversationActivity_chat_needs_the_recording_permissions_to_capture_video))
                .onAnyDenied(() -> Toast.makeText(fragment.requireContext(), R.string.ConversationActivity_chat_needs_recording_permissions_to_capture_video, Toast.LENGTH_LONG).show())
                .execute();
    }

    @SuppressLint("RestrictedApi")
    private void beginCameraRecording() throws IOException {
        this.camera.setZoomRatio(this.camera.getMinZoomRatio());
        callback.onVideoRecordStarted();
        shrinkCaptureArea();
        File file = new File(MainApp.Companion.getCachePath(), "recording.mp4");
        if (file.exists()) {
            Utills.INSTANCE.handleFileDelete("CameraXVieoCapture",
                    file.delete()
            );
            Utills.INSTANCE.handleFileDelete("CameraXVieoCapture",
                    file.createNewFile()
            );

        } else {
            Utills.INSTANCE.handleFileDelete("CameraXVieoCapture",
                    file.createNewFile()
            );
        }

        VideoCapture.OutputFileOptions options = new VideoCapture.OutputFileOptions.Builder(file).build();

        camera.startRecording(options, Executors.mainThreadExecutor(), videoSavedListener);
        updateProgressAnimator.start();
    }

    private void shrinkCaptureArea() {
        Size screenSize = getScreenSize();
        Size videoRecordingSize = VideoUtil.getVideoRecordingSize();
        float scale = getSurfaceScaleForRecording();
        float targetWidthForAnimation = videoRecordingSize.getWidth() * scale;
        float scaleX = targetWidthForAnimation / screenSize.getWidth();

        if (scaleX == 1f) {
            float targetHeightForAnimation = videoRecordingSize.getHeight() * scale;

            if (screenSize.getHeight() == targetHeightForAnimation) {
                return;
            }

            cameraMetricsAnimator = ValueAnimator.ofFloat(screenSize.getHeight(), targetHeightForAnimation);
        } else {

            if (screenSize.getWidth() == targetWidthForAnimation) {
                return;
            }

            cameraMetricsAnimator = ValueAnimator.ofFloat(screenSize.getWidth(), targetWidthForAnimation);
        }

        ViewGroup.LayoutParams params = camera.getLayoutParams();
        cameraMetricsAnimator.setInterpolator(new LinearInterpolator());
        cameraMetricsAnimator.setDuration(200);
        cameraMetricsAnimator.addUpdateListener(animation -> {
            if (scaleX == 1f) {
                params.height = Math.round((float) animation.getAnimatedValue());
            } else {
                params.width = Math.round((float) animation.getAnimatedValue());
            }
            camera.setLayoutParams(params);
        });
        cameraMetricsAnimator.start();
    }

    private Size getScreenSize() {
        DisplayMetrics metrics = camera.getResources().getDisplayMetrics();
        return new Size(metrics.widthPixels, metrics.heightPixels);
    }

    private float getSurfaceScaleForRecording() {
        Size videoRecordingSize = VideoUtil.getVideoRecordingSize();
        Size screenSize = getScreenSize();
        return Math.min(screenSize.getHeight(), screenSize.getWidth()) / (float) Math.min(videoRecordingSize.getHeight(), videoRecordingSize.getWidth());
    }

    @Override
    public void onVideoCaptureComplete() {
        isRecording = false;
        if (!canRecordAudio()) return;

        Log.d(TAG, "onVideoCaptureComplete");
        camera.stopRecording();

        if (cameraMetricsAnimator != null && cameraMetricsAnimator.isRunning()) {
            cameraMetricsAnimator.reverse();
        }

        updateProgressAnimator.cancel();
    }

    @Override
    public void onZoomIncremented(float increment) {
        float range = camera.getMaxZoomRatio() - camera.getMinZoomRatio();
        camera.setZoomRatio((range * increment) + camera.getMinZoomRatio());
    }

    public static MemoryFileDescriptor createFileDescriptor(@NonNull Context context) throws MemoryFileDescriptor.MemoryFileException {
        return MemoryFileDescriptor.newMemoryFileDescriptor(
                context,
                VIDEO_DEBUG_LABEL,
                VIDEO_SIZE
        );
    }

    private static abstract class AnimationEndCallback implements Animator.AnimatorListener {

        @Override
        public final void onAnimationStart(Animator animation) {

        }

        @Override
        public final void onAnimationCancel(Animator animation) {

        }

        @Override
        public final void onAnimationRepeat(Animator animation) {

        }
    }

    public interface Callback {
        void onVideoRecordStarted();

        void onVideoSaved(@NonNull FileDescriptor fd);

        void onVideoError(@Nullable Throwable cause);
    }
}
