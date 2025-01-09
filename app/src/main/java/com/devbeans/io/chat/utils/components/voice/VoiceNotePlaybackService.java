package com.devbeans.io.chat.utils.components.voice;

import android.os.Bundle;
import android.os.Process;
import android.support.v4.media.MediaBrowserCompat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media.MediaBrowserServiceCompat;

import com.devbeans.io.chat.utils.logging.Log;

import java.util.Collections;
import java.util.List;

public class VoiceNotePlaybackService extends MediaBrowserServiceCompat {

    private static final String TAG                 = Log.tag(VoiceNotePlaybackService.class);
    private static final String EMPTY_ROOT_ID       = "empty-root-id";
    private static final int    LOAD_MORE_THRESHOLD = 2;
    public static final String ACTION_NEXT_PLAYBACK_SPEED = "com.devbeans.chat.utils.components.voice.VoiceNotePlaybackService.action.next_playback_speed";
    public static final String ACTION_SET_AUDIO_STREAM    = "com.devbeans.chat.utils.components.voice.VoiceNotePlaybackService.action.set_audio_stream";


    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        if (clientUid == Process.myUid()) {
            return new BrowserRoot(EMPTY_ROOT_ID, null);
        } else {
            return null;
        }
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.sendResult(Collections.emptyList());
    }
}
