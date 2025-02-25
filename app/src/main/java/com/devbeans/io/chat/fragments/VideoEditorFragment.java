package com.devbeans.io.chat.fragments;


import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.callBacks.MediaSendPageFragment;
import com.devbeans.io.chat.utils.Throttler;
import com.devbeans.io.chat.utils.VideoBitRateCalculator;
import com.devbeans.io.chat.utils.VideoEditorHud;
import com.devbeans.io.chat.utils.VideoPlayer;
import com.devbeans.io.chat.utils.logging.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VideoEditorFragment extends Fragment implements VideoEditorHud.EventListener,
        MediaSendPageFragment {

    private static final String TAG = Log.tag(VideoEditorFragment.class);

    private static final String KEY_URI = "uri";
    private static final String KEY_MAX_OUTPUT = "max_output_size";
    private static final String KEY_MAX_SEND = "max_send_size";
    private static final String KEY_IS_VIDEO_GIF = "is_video_gif";
    private static final String KEY_MAX_DURATION = "max_duration";

    private final Throttler videoScanThrottle = new Throttler(150);
    private final Handler handler = new Handler(Looper.getMainLooper());

    private Controller controller;
    private Data data = new Data();
    private Uri uri;
    private boolean isVideoGif;
    private VideoPlayer player;
    @Nullable
    private VideoEditorHud hud;
    private Runnable updatePosition;
    private boolean isInEdit;
    private boolean wasPlayingBeforeEdit;
    private long maxVideoDurationUs;

    public static VideoEditorFragment newInstance(@NonNull Uri uri, long maxCompressedVideoSize, long maxAttachmentSize, boolean isVideoGif, long maxVideoDuration) {
        Bundle args = new Bundle();
        args.putParcelable(KEY_URI, uri);
        args.putLong(KEY_MAX_OUTPUT, maxCompressedVideoSize);
        args.putLong(KEY_MAX_SEND, maxAttachmentSize);
        args.putBoolean(KEY_IS_VIDEO_GIF, isVideoGif);
        args.putLong(KEY_MAX_DURATION, maxVideoDuration);

        VideoEditorFragment fragment = new VideoEditorFragment();
        fragment.setArguments(args);
        fragment.setUri(uri);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof Controller) {
            controller = (Controller) getActivity();
        } else if (getParentFragment() instanceof Controller) {
            controller = (Controller) getParentFragment();
        } else {
            throw new IllegalStateException("Parent must implement Controller interface.");
        }
    }

    @Override
    public @Nullable
    View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mediasend_video_fragment, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        player = view.findViewById(R.id.video_player);

        uri = requireArguments().getParcelable(KEY_URI);
        isVideoGif = requireArguments().getBoolean(KEY_IS_VIDEO_GIF);
        maxVideoDurationUs = TimeUnit.MILLISECONDS.toMicros(requireArguments().getLong(KEY_MAX_DURATION));

        long maxOutput = requireArguments().getLong(KEY_MAX_OUTPUT);
        long maxSend = requireArguments().getLong(KEY_MAX_SEND);
        boolean autoplay = isVideoGif;

        player.setWindow(requireActivity().getWindow());
        player.setVideoSource(uri, autoplay);



        if (true) {
            hud = view.findViewById(R.id.video_editor_hud);
            hud.setEventListener(this);
            clampToMaxVideoDuration(data, true);
            updateHud(data);
            if (data.durationEdited) {
                player.clip(data.startTimeUs, data.endTimeUs, autoplay);
            }
            try {
                hud.setVideoSource(uri, new VideoBitRateCalculator(maxOutput), maxSend);
                hud.setVisibility(View.VISIBLE);
                startPositionUpdates();
            } catch (IOException e) {
                Log.w(TAG, e);
            }

            player.setOnClickListener(v -> {
                player.pause();
                hud.showPlayButton();
            });

            player.setPlayerCallback(new VideoPlayer.PlayerCallback() {

                @Override
                public void onReady() {
                    controller.onPlayerReady();
                }

                @Override
                public void onPlaying() {
                    hud.fadePlayButton();
                }

                @Override
                public void onStopped() {
                    hud.showPlayButton();
                }

                @Override
                public void onError() {
                    controller.onPlayerError();
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (player != null) {
            player.cleanup();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        notifyHidden();

        stopPositionUpdates();
    }

    @Override
    public void onResume() {
        super.onResume();
        startPositionUpdates();

        if (player != null && isVideoGif) {
            player.play();
        }
    }

    private void startPositionUpdates() {
        if (hud != null && Build.VERSION.SDK_INT >= 23) {
            stopPositionUpdates();
            updatePosition = new Runnable() {
                @Override
                public void run() {
                    hud.setPosition(player.getPlaybackPositionUs());
                    handler.postDelayed(this, 100);
                }
            };
            handler.post(updatePosition);
        }
    }

    private void stopPositionUpdates() {
        handler.removeCallbacks(updatePosition);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (hidden) {
            notifyHidden();
        }
    }

    @Override
    public void setUri(@NonNull Uri uri) {
        this.uri = uri;
    }

    @Override
    public @NonNull
    Uri getUri() {
        return uri;
    }

    @Override
    public @Nullable
    View getPlaybackControls() {
        if (hud != null && hud.getVisibility() == View.VISIBLE) return null;
        else if (isVideoGif) return null;
        else if (player != null) return player.getControlView();
        else return null;
    }

    @Override
    public @Nullable
    Object saveState() {
        return data;
    }

    @Override
    public void restoreState(@NonNull Object state) {
        if (state instanceof Data) {
            data = (Data) state;
            if (Build.VERSION.SDK_INT >= 23) {
                updateHud(data);
            }
        } else {
            Log.w(TAG, "Received a bad saved state. Received class: " + state.getClass().getName());
        }
    }

    @RequiresApi(api = 23)
    private void updateHud(Data data) {
        if (hud != null && data.totalDurationUs > 0 && data.durationEdited) {
            hud.setDurationRange(data.totalDurationUs, data.startTimeUs, data.endTimeUs);
        }
    }

    @Override
    public void notifyHidden() {
        pausePlayback();
    }

    public void pausePlayback() {
        if (player != null) {
            player.pause();
            if (hud != null) {
                hud.showPlayButton();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onEditVideoDuration(long totalDurationUs, long startTimeUs, long endTimeUs, boolean fromEdited, boolean editingComplete) {
        controller.onTouchEventsNeeded(!editingComplete);

        handlePlayButton();

        final long clampedStartTime = Math.max(startTimeUs, 0);

        boolean wasEdited = data.durationEdited;
        boolean durationEdited = clampedStartTime > 0 || endTimeUs < totalDurationUs;
        boolean endMoved = data.endTimeUs != endTimeUs;

        data.durationEdited = durationEdited;
        data.totalDurationUs = totalDurationUs;
        data.startTimeUs = clampedStartTime;
        data.endTimeUs = endTimeUs;

        clampToMaxVideoDuration(data, !endMoved);

        handleEditingComplete(editingComplete);

        videoScanThrottle.publish(() -> {
            player.pause();
            if (!editingComplete) {
                player.removeClip(false);
            }
            player.setPlaybackPosition(fromEdited || editingComplete ? clampedStartTime / 1000 : endTimeUs / 1000);
            if (editingComplete) {
                if (durationEdited) {
                    player.clip(clampedStartTime, endTimeUs, wasPlayingBeforeEdit);
                } else {
                    player.removeClip(wasPlayingBeforeEdit);
                }

                if (!wasPlayingBeforeEdit) {
                    hud.showPlayButton();
                }
            }
        });

        handleController(wasEdited, durationEdited);

        handleEditingControllerComplete(editingComplete);
    }

    private void handleEditingControllerComplete(boolean editingComplete) {
        if (editingComplete) {
            controller.onVideoEndEdit(uri);
            controller.onVideoEditComplete(data);
        }
    }

    private void handlePlayButton() {
        if (hud != null) {
            hud.hidePlayButton();
        }
    }

    private void handleController(boolean wasEdited, boolean durationEdited) {
        if (!wasEdited && durationEdited) {
            controller.onVideoBeginEdit(uri);
        }
    }

    private void handleEditingComplete(boolean editingComplete) {
        if (editingComplete) {
            isInEdit = false;
            videoScanThrottle.clear();
        } else if (!isInEdit) {
            isInEdit = true;
            wasPlayingBeforeEdit = player.isPlaying();
        }
    }

    @Override
    public void onPlay() {
        player.play();
    }

    @Override
    public void onSeek(long position, boolean dragComplete) {
        if (dragComplete) {
            videoScanThrottle.clear();
        }

        videoScanThrottle.publish(() -> {
            player.pause();
            player.setPlaybackPosition(position);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void clampToMaxVideoDuration(@NonNull Data data, boolean clampEnd) {


        if ((data.endTimeUs - data.startTimeUs) <= maxVideoDurationUs) {
            return;
        }

        data.durationEdited = true;

        if (clampEnd) {
            data.endTimeUs = data.startTimeUs + maxVideoDurationUs;
        } else {
            data.startTimeUs = data.endTimeUs - maxVideoDurationUs;
        }

        updateHud(data);
    }

    public static class Data implements Parcelable {
        boolean durationEdited;
        long totalDurationUs;
        long startTimeUs;
        long endTimeUs;

        protected Data(Parcel in) {
            durationEdited = in.readByte() != 0;
            totalDurationUs = in.readLong();
            startTimeUs = in.readLong();
            endTimeUs = in.readLong();
        }

        public static final Creator<Data> CREATOR = new Creator<Data>() {
            @Override
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            @Override
            public Data[] newArray(int size) {
                return new Data[size];
            }
        };

        public Data() {

        }

        public boolean isDurationEdited() {
            return durationEdited;
        }

        public long getTotalDurationUs() {
            return totalDurationUs;
        }

        public void setTotalDurationUs(long totalDurationUs) {
            this.totalDurationUs = totalDurationUs;
        }

        public long getStartTimeUs() {
            return startTimeUs;
        }

        public void setStartTimeUs(long startTimeUs) {
            this.startTimeUs = startTimeUs;
        }

        public long getEndTimeUs() {
            return endTimeUs;
        }

        public void setEndTimeUs(long endTimeUs) {
            this.endTimeUs = endTimeUs;
        }

        public @NonNull
        Bundle getBundle() {
            Bundle bundle = new Bundle();
            bundle.putByte("EDITED", (byte) (durationEdited ? 1 : 0));
            bundle.putLong("TOTAL", totalDurationUs);
            bundle.putLong("START", startTimeUs);
            bundle.putLong("END", endTimeUs);

            return bundle;
        }

        public static @NonNull
        Data fromBundle(@NonNull Bundle bundle) {
            Data data = new Data();
            data.durationEdited = bundle.getByte("EDITED") == (byte) 1;
            data.totalDurationUs = bundle.getLong("TOTAL");
            data.startTimeUs = bundle.getLong("START");
            data.endTimeUs = bundle.getLong("END");

            return data;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeByte((byte) (durationEdited ? 1 : 0));
            parcel.writeLong(totalDurationUs);
            parcel.writeLong(startTimeUs);
            parcel.writeLong(endTimeUs);
        }
    }

    public interface Controller {

        void onPlayerReady();

        void onPlayerError();

        void onTouchEventsNeeded(boolean needed);

        void onVideoBeginEdit(@NonNull Uri uri);

        void onVideoEndEdit(@NonNull Uri uri);

        void onVideoEditComplete(Data data);
    }
}
