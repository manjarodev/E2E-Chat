package com.devbeans.io.chat.utils.views;


import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;

import com.devbeans.io.chat.camera.ChatCameraView;

@RequiresApi(21)
public final class CameraXSelfieFlashHelper {

    private static final float MAX_SCREEN_BRIGHTNESS    = 1f;
    private static final float MAX_SELFIE_FLASH_ALPHA   = 0.75f;
    private static final long  SELFIE_FLASH_DURATION_MS = 250;

    private final Window window;
    private final ChatCameraView camera;
    private final View selfieFlash;

    private float   brightnessBeforeFlash;
    private boolean inFlash;

    public CameraXSelfieFlashHelper(@NonNull Window window,
                                    @NonNull ChatCameraView camera,
                                    @NonNull View selfieFlash)
    {
        this.window      = window;
        this.camera      = camera;
        this.selfieFlash = selfieFlash;
    }

    public void startFlash() {
        if (inFlash || !shouldUseViewBasedFlash()) return;
        inFlash = true;

        WindowManager.LayoutParams params = window.getAttributes();

        brightnessBeforeFlash   = params.screenBrightness;
        params.screenBrightness = MAX_SCREEN_BRIGHTNESS;
        window.setAttributes(params);

        selfieFlash.animate()
                .alpha(MAX_SELFIE_FLASH_ALPHA)
                .setDuration(SELFIE_FLASH_DURATION_MS);
    }

    public void endFlash() {
        if (!inFlash) return;

        WindowManager.LayoutParams params = window.getAttributes();

        params.screenBrightness = brightnessBeforeFlash;
        window.setAttributes(params);

        selfieFlash.animate()
                .alpha(0f)
                .setDuration(SELFIE_FLASH_DURATION_MS);

        inFlash = false;
    }

    private boolean shouldUseViewBasedFlash() {
        Integer cameraLensFacing = camera.getCameraLensFacing();

        return camera.getFlash() == ImageCapture.FLASH_MODE_ON &&
                !camera.hasFlash()                              &&
                cameraLensFacing != null                        &&
                cameraLensFacing == CameraSelector.LENS_FACING_FRONT;
    }
}
