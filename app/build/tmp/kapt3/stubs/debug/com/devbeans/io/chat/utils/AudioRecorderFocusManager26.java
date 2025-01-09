package com.devbeans.io.chat.utils;

import java.lang.System;

@androidx.annotation.RequiresApi(value = 26)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/devbeans/io/chat/utils/AudioRecorderFocusManager26;", "Lcom/devbeans/io/chat/utils/AudioRecorderFocusManager;", "context", "Landroid/content/Context;", "changeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "(Landroid/content/Context;Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "getAudioFocusRequest", "()Landroid/media/AudioFocusRequest;", "abandonAudioFocus", "", "requestAudioFocus", "app_debug"})
final class AudioRecorderFocusManager26 extends com.devbeans.io.chat.utils.AudioRecorderFocusManager {
    @org.jetbrains.annotations.NotNull
    private final android.media.AudioFocusRequest audioFocusRequest = null;
    
    public AudioRecorderFocusManager26(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.media.AudioManager.OnAudioFocusChangeListener changeListener) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.media.AudioFocusRequest getAudioFocusRequest() {
        return null;
    }
    
    @java.lang.Override
    public int requestAudioFocus() {
        return 0;
    }
    
    @java.lang.Override
    public int abandonAudioFocus() {
        return 0;
    }
}