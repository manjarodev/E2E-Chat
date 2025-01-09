package com.devbeans.io.chat.utils;


import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;

import androidx.annotation.NonNull;

import com.devbeans.io.chat.activities.ChatActivity;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.callBacks.ListenableFuture;
import com.devbeans.io.chat.callBacks.Recorder;
import com.devbeans.io.chat.utils.editor.BlobProvider;
import com.devbeans.io.chat.utils.logging.Log;
import com.devbeans.io.chat.utils.views.SettableFuture;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class AudioRecorder {

    private static final String TAG = Log.tag(AudioRecorder.class);

    private static final ExecutorService executor = ChatExecutors.newCachedSingleThreadExecutor("chat-AudioRecorder");

    private final Context context;
    private final AudioRecorderFocusManager audioFocusManager;

    private Recorder recorder;
    private Uri captureUri;

    public AudioRecorder(@NonNull Context context) {
        this.context = context;
        audioFocusManager = AudioRecorderFocusManager.create(context, focusChange -> stopRecording());
    }

    public void startRecording() {
        Log.i(TAG, "startRecording()");

        executor.execute(() -> {
            Log.i(TAG, "c startRecording() + " + Thread.currentThread().getId());
            try {
                if (recorder != null) {
                    Log.e(TAG, new AssertionError("We can only record once at a time."));
                    recorder.stop();
                    return;
                }

                ParcelFileDescriptor fds[] = ParcelFileDescriptor.createPipe();
                AtomicBoolean error = new AtomicBoolean(false);
                captureUri = BlobProvider.getInstance()
                        .forData(new ParcelFileDescriptor.AutoCloseInputStream(fds[0]), 0)
                        .withMimeType(MediaUtil.AUDIO_AAC)
                        .createDataForDraftAttachmentAsync(context, () -> {
                            error.set(false);
                            Log.i(TAG, "Write successful.");
                        }, e -> {
                            error.set(true);
                            Log.w(TAG, "Error during recording", e);
                        });

                if (error.get()) {
                    Log.e(TAG, new AssertionError("Error in writing"));
                    recorder.stop();
                    return;
                }

                File tempFile = new File(MainApp.Companion.getAudioPathSent() + "/rec.aac");
                if (tempFile.exists()) {
                    Log.e(TAG, "Content" + tempFile.getPath());
                }
                Log.e(TAG, "Conetnt" + captureUri.getPath());
                recorder = Build.VERSION.SDK_INT >= 26 ? new MediaRecorderWrapper() : new AudioCodec();
                int focusResult = audioFocusManager.requestAudioFocus();
                if (focusResult != AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Log.w(TAG, "Could not gain audio focus. Received result code " + focusResult);
                }
                recorder.start(fds[1]);
            } catch (IOException e) {
                Log.w(TAG, e);
            }
        });
    }

    public @NonNull
    ListenableFuture<VoiceNoteDraft> stopRecording() {
        Log.i(ChatActivity.class.getSimpleName(), "stopRecording()");

        final SettableFuture<VoiceNoteDraft> future = new SettableFuture<>();

        executor.execute(() -> {
            Log.e(ChatActivity.class.getSimpleName(), "stopRecording() + " + Thread.currentThread().getId());
            if (recorder == null) {
                sendToFuture(future, new IOException("MediaRecorder was never initialized successfully!"));
                return;
            }

            audioFocusManager.abandonAudioFocus();
            recorder.stop();

            try {
                Log.e(TAG, "URI " + captureUri.toString());
                Log.e(ChatActivity.class.getSimpleName(), "URI " + captureUri.toString());
//                long s=MediaUtil.getFileSize(captureUri,context);
//                File file=new File(captureUri.getPath());
//                Log.e(TAG,"file "+file.getAbsolutePath());
//                long size = MediaUtil.getAttachmentMediaSize(context, captureUri);
                Log.w(TAG, "ioe.getMessage()");
                sendToFuture(future, new VoiceNoteDraft(captureUri, 0));
            } catch (Exception ioe) {
                Log.w(TAG, ioe);
                Log.e(ChatActivity.class.getSimpleName(), ioe);
                sendToFuture(future, ioe);
            }

            recorder = null;
            captureUri = null;
        });

        return future;
    }

    private <T> void sendToFuture(final SettableFuture<T> future, final Exception exception) {
        ThreadUtil.runOnMain(() -> future.setException(exception));
    }

    private <T> void sendToFuture(final SettableFuture<T> future, final T result) {
        ThreadUtil.runOnMain(() -> future.set(result));
    }
}
