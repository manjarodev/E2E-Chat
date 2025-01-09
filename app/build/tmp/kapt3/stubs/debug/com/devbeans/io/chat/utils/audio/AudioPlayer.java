package com.devbeans.io.chat.utils.audio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0016J\"\u0010\u0018\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\"\u0010\u001b\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006."}, d2 = {"Lcom/devbeans/io/chat/utils/audio/AudioPlayer;", "Landroid/media/MediaPlayer;", "Landroid/media/MediaPlayer$OnBufferingUpdateListener;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Landroid/media/MediaPlayer$OnInfoListener;", "Landroid/media/MediaPlayer$OnPreparedListener;", "()V", "value", "Lcom/devbeans/io/chat/utils/audio/AudioPlayer$AudioPlayerState;", "playerState", "getPlayerState", "()Lcom/devbeans/io/chat/utils/audio/AudioPlayer$AudioPlayerState;", "setPlayerState", "(Lcom/devbeans/io/chat/utils/audio/AudioPlayer$AudioPlayerState;)V", "getCurrentPosition", "", "isPlaying", "", "onBufferingUpdate", "", "mp", "percent", "onCompletion", "onError", "what", "extra", "onInfo", "onPrepared", "pause", "prepare", "prepareAsync", "release", "reset", "seekTo", "msec", "", "mode", "setDataSource", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "start", "stop", "AudioPlayerState", "app_debug"})
public final class AudioPlayer extends android.media.MediaPlayer implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.utils.audio.AudioPlayer.AudioPlayerState playerState;
    
    public AudioPlayer() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.utils.audio.AudioPlayer.AudioPlayerState getPlayerState() {
        return null;
    }
    
    public final void setPlayerState(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.audio.AudioPlayer.AudioPlayerState value) {
    }
    
    @java.lang.Override
    public void setDataSource(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    @java.lang.Override
    public void prepare() {
    }
    
    @java.lang.Override
    public void prepareAsync() {
    }
    
    @java.lang.Override
    public void start() {
    }
    
    @java.lang.Override
    public void stop() {
    }
    
    @java.lang.Override
    public void pause() {
    }
    
    @java.lang.Override
    public void seekTo(int msec) {
    }
    
    @java.lang.Override
    public void seekTo(long msec, int mode) {
    }
    
    @java.lang.Override
    public int getCurrentPosition() {
        return 0;
    }
    
    @java.lang.Override
    public boolean isPlaying() {
        return false;
    }
    
    @java.lang.Override
    public void reset() {
    }
    
    @java.lang.Override
    public void release() {
    }
    
    @java.lang.Override
    public void onPrepared(@org.jetbrains.annotations.Nullable
    android.media.MediaPlayer mp) {
    }
    
    @java.lang.Override
    public boolean onInfo(@org.jetbrains.annotations.Nullable
    android.media.MediaPlayer mp, int what, int extra) {
        return false;
    }
    
    @java.lang.Override
    public boolean onError(@org.jetbrains.annotations.Nullable
    android.media.MediaPlayer mp, int what, int extra) {
        return false;
    }
    
    @java.lang.Override
    public void onCompletion(@org.jetbrains.annotations.Nullable
    android.media.MediaPlayer mp) {
    }
    
    @java.lang.Override
    public void onBufferingUpdate(@org.jetbrains.annotations.Nullable
    android.media.MediaPlayer mp, int percent) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/utils/audio/AudioPlayer$AudioPlayerState;", "", "(Ljava/lang/String;I)V", "IDLE", "INITIALIZED", "PREPARING", "PREPARED", "STARTED", "STOPPED", "PAUSED", "PLAYBACK_COMPLETED", "ERROR", "END", "app_debug"})
    public static enum AudioPlayerState {
        /*public static final*/ IDLE /* = new IDLE() */,
        /*public static final*/ INITIALIZED /* = new INITIALIZED() */,
        /*public static final*/ PREPARING /* = new PREPARING() */,
        /*public static final*/ PREPARED /* = new PREPARED() */,
        /*public static final*/ STARTED /* = new STARTED() */,
        /*public static final*/ STOPPED /* = new STOPPED() */,
        /*public static final*/ PAUSED /* = new PAUSED() */,
        /*public static final*/ PLAYBACK_COMPLETED /* = new PLAYBACK_COMPLETED() */,
        /*public static final*/ ERROR /* = new ERROR() */,
        /*public static final*/ END /* = new END() */;
        
        AudioPlayerState() {
        }
    }
}