package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/utils/AudioRecorderFocusManagerLegacy;", "Lcom/devbeans/io/chat/utils/AudioRecorderFocusManager;", "context", "Landroid/content/Context;", "changeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "(Landroid/content/Context;Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "getChangeListener", "()Landroid/media/AudioManager$OnAudioFocusChangeListener;", "abandonAudioFocus", "", "requestAudioFocus", "app_debug"})
final class AudioRecorderFocusManagerLegacy extends com.devbeans.io.chat.utils.AudioRecorderFocusManager {
    @org.jetbrains.annotations.NotNull
    private final android.media.AudioManager.OnAudioFocusChangeListener changeListener = null;
    
    public AudioRecorderFocusManagerLegacy(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.media.AudioManager.OnAudioFocusChangeListener changeListener) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.media.AudioManager.OnAudioFocusChangeListener getChangeListener() {
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