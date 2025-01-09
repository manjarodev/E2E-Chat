package com.devbeans.io.chat.utils;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A set of {@link android.os.Build#MODEL} that are known to both benefit from
 *
 * @link androidx.camera.core.ImageCapture.CaptureMode#MAX_QUALITY and execute it quickly.
 */
public class FastCameraModels {


    private static final String[] MODELS_TO_ADD = new String[]{
            "Pixel 2",
            "Pixel 2 XL",
            "Pixel 3",
            "Pixel 3 XL",
            "Pixel 3a",
            "Pixel 3a XL"

    };
    private static final Set<String> MODELS = new HashSet<String>(Arrays.asList(MODELS_TO_ADD));

    /**
     * @param model Should be a {@link android.os.Build#MODEL}.
     */
    public static boolean contains(@NonNull String model) {
        return MODELS.contains(model);
    }
}
