package com.devbeans.io.chat.utils;


import android.content.Context;
import android.content.res.Resources;
import android.media.MediaFormat;
import android.util.DisplayMetrics;
import android.util.Size;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.concurrent.TimeUnit;

public final class VideoUtil {



    public static long MAX_VIDEO_DURATION_MILLIS = TimeUnit.SECONDS.toMillis(30);
    private static final int KB = 1024;
    private static final int MB = 1024 * KB;

    public static final int AUDIO_BIT_RATE   = 192_000;
    public static final int VIDEO_FRAME_RATE = 30;
    public static final int VIDEO_BIT_RATE   = 2_000_000;

    static final int VIDEO_SHORT_WIDTH = 720;

    private static final int VIDEO_LONG_WIDTH          = 1280;
    private static final int VIDEO_MAX_RECORD_LENGTH_S = 60;
    private static final int VIDEO_MAX_UPLOAD_LENGTH_S = (int) TimeUnit.MINUTES.toSeconds(10);

    private static final int TOTAL_BYTES_PER_SECOND = (VIDEO_BIT_RATE / 8) + (AUDIO_BIT_RATE / 8);

    @RequiresApi(21)
    public static final String VIDEO_MIME_TYPE = MediaFormat.MIMETYPE_VIDEO_AVC;
    public static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";

    public static final String RECORDED_VIDEO_CONTENT_TYPE = MediaUtil.VIDEO_MP4;

    private VideoUtil() { }

    @RequiresApi(21)
    public static Size getVideoRecordingSize() {
        return isPortrait(screenSize())
                ? new Size(VIDEO_SHORT_WIDTH, VIDEO_LONG_WIDTH)
                : new Size(VIDEO_LONG_WIDTH, VIDEO_SHORT_WIDTH);
    }

    public static int getMaxVideoRecordDurationInSeconds(@NonNull Context context, @NonNull int allowedSize) {
//        int allowedSize = mediaConstraints.getCompressedVideoMaxSize(context);
        int duration    = (int) Math.floor((float) allowedSize / TOTAL_BYTES_PER_SECOND);

        return Math.min(duration, VIDEO_MAX_RECORD_LENGTH_S);
    }

    public static int getMaxVideoUploadDurationInSeconds() {
        return VIDEO_MAX_UPLOAD_LENGTH_S;
    }

    @RequiresApi(21)
    private static Size screenSize() {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return new Size(metrics.widthPixels, metrics.heightPixels);
    }

    @RequiresApi(21)
    private static boolean isPortrait(Size size) {
        return size.getWidth() < size.getHeight();
    }


    public static int getVideoMaxSize(Context context) {
        return 20 * MB;
    }

    public static int getCompressedVideoMaxSize(Context context) {
        return getVideoMaxSize(context);
    }



}
