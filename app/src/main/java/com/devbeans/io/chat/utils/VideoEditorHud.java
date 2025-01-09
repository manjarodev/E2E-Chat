package com.devbeans.io.chat.utils;


import android.animation.Animator;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.utils.logging.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * The HUD (heads-up display) that contains all of the tools for editing video.
 */
public final class VideoEditorHud extends LinearLayout {

    @SuppressWarnings("unused")
    private static final String TAG = Log.tag(VideoEditorHud.class);

    private VideoThumbnailsRangeSelectorView videoTimeLine;
    private EventListener eventListener;
    private View playOverlay;

    private static final int VIDEO_MAX_UPLOAD_LENGTH_S = (int) TimeUnit.MINUTES.toSeconds(10);

    public VideoEditorHud(@NonNull Context context) {
        super(context);
        initialize();
    }

    public VideoEditorHud(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public VideoEditorHud(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        View root = inflate(getContext(), R.layout.video_editor_hud, this);
        setOrientation(VERTICAL);

        videoTimeLine = root.findViewById(R.id.video_timeline);
        playOverlay = root.findViewById(R.id.play_overlay);

        playOverlay.setOnClickListener(v -> eventListener.onPlay());
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    @RequiresApi(api = 23)
    public void setVideoSource(@NonNull Uri slide, @NonNull VideoBitRateCalculator videoBitRateCalculator, long maxSendSize)
            throws IOException {


        videoTimeLine.setInput(new MediaInput.UriMediaInput(getContext(), slide));

        long size = tryGetUriSize(getContext(), slide, Long.MAX_VALUE);

        if (size > maxSendSize) {
            videoTimeLine.setTimeLimit(getMaxVideoUploadDurationInSeconds(), TimeUnit.SECONDS);
        }

        videoTimeLine.setOnRangeChangeListener(new VideoThumbnailsRangeSelectorView.OnRangeChangeListener() {

            @Override
            public void onPositionDrag(long position) {
                if (eventListener != null) {
                    eventListener.onSeek(position, false);
                }
            }

            @Override
            public void onEndPositionDrag(long position) {
                if (eventListener != null) {
                    eventListener.onSeek(position, true);
                }
            }

            @Override
            public void onRangeDrag(long minValueUs, long maxValueUs, long durationUs, VideoThumbnailsRangeSelectorView.Thumb thumb) {
                if (eventListener != null) {
                    eventListener.onEditVideoDuration(durationUs, minValueUs, maxValueUs, thumb == VideoThumbnailsRangeSelectorView.Thumb.MIN, false);
                }
            }

            @Override
            public void onRangeDragEnd(long minValueUs, long maxValueUs, long durationUs, VideoThumbnailsRangeSelectorView.Thumb thumb) {
                if (eventListener != null) {
                    eventListener.onEditVideoDuration(durationUs, minValueUs, maxValueUs, thumb == VideoThumbnailsRangeSelectorView.Thumb.MIN, true);
                }
            }

            @Override
            public VideoThumbnailsRangeSelectorView.Quality getQuality(long clipDurationUs, long totalDurationUs) {
                int inputBitRate = VideoBitRateCalculator.bitRate(size, TimeUnit.MICROSECONDS.toMillis(totalDurationUs));

                VideoBitRateCalculator.Quality targetQuality = videoBitRateCalculator.getTargetQuality(TimeUnit.MICROSECONDS.toMillis(clipDurationUs), inputBitRate);
                return new VideoThumbnailsRangeSelectorView.Quality(targetQuality.getFileSizeEstimate(), (int) (100 * targetQuality.getQuality()));
            }
        });
    }

    private int getMaxVideoUploadDurationInSeconds() {
        return VIDEO_MAX_UPLOAD_LENGTH_S;
    }

    public void showPlayButton() {
        playOverlay.setVisibility(VISIBLE);
        playOverlay.animate()
                .setListener(null)
                .alpha(1)
                .scaleX(1).scaleY(1)
                .setInterpolator(new OvershootInterpolator())
                .start();
    }

    public void fadePlayButton() {
        playOverlay.animate()
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        playOverlay.setVisibility(GONE);
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                        // was essential to over ride

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        // was essential to over ride

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        // was essential to over ride

                    }
                })
                .alpha(0)
                .scaleX(0.8f).scaleY(0.8f)
                .start();
    }

    public void hidePlayButton() {
        playOverlay.setVisibility(GONE);
        playOverlay.setAlpha(0);
        playOverlay.setScaleX(0.8f);
        playOverlay.setScaleY(0.8f);
    }

    @RequiresApi(api = 23)
    public void setDurationRange(long totalDuration, long fromDuration, long toDuration) {
        videoTimeLine.setRange(fromDuration, toDuration);
    }

    @RequiresApi(api = 23)
    public void setPosition(long playbackPositionUs) {
        videoTimeLine.setActualPosition(playbackPositionUs);
    }

    public interface EventListener {

        void onEditVideoDuration(long totalDurationUs, long startTimeUs, long endTimeUs, boolean fromEdited, boolean editingComplete);

        void onPlay();

        void onSeek(long position, boolean dragComplete);
    }

    private long tryGetUriSize(@NonNull Context context, @NonNull Uri uri, long defaultValue) {
        try {
            return getSize(context, uri);
        } catch (IOException e) {
            Log.w(TAG, e);
            return defaultValue;
        }
    }

    private static long getSize(@NonNull Context context, @NonNull Uri uri) throws IOException {
        long size = 0;

        try (Cursor cursor = context.getContentResolver().query(uri, null, null, null, null)) {
            if (cursor != null && cursor.moveToFirst() && cursor.getColumnIndex(OpenableColumns.SIZE) >= 0) {
                size = cursor.getLong(cursor.getColumnIndexOrThrow(OpenableColumns.SIZE));
            }
        }

        if (size <= 0) {
            size = getMediaSize(context, uri);
        }

        return size;
    }

    public static long getMediaSize(Context context, Uri uri) throws IOException {

        try (
                InputStream in = context.getContentResolver().openInputStream(uri);
        ) {

            if (in == null) throw new IOException("Couldn't obtain input stream.");

            long size = 0;
            byte[] buffer = new byte[4096];
            int read;

            while ((read = in.read(buffer)) != -1) {
                size += read;
            }
            in.close();

            return size;
        }
    }


}
