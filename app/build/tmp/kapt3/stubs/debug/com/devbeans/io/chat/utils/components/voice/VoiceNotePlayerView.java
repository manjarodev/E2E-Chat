package com.devbeans.io.chat.utils.components.voice;

import java.lang.System;

/**
 * Renders a bar at the top of Conversation list and in a conversation to allow
 * playback manipulation of voice notes.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002*+B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u000fJ\u0006\u0010\'\u001a\u00020\u001eJ\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlayerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeButton", "Landroid/view/View;", "durationView", "Landroid/widget/TextView;", "infoView", "lastState", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlayerView$State;", "listener", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlayerView$Listener;", "getListener", "()Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlayerView$Listener;", "setListener", "(Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlayerView$Listener;)V", "lottieDirection", "playPauseToggleView", "Lcom/airbnb/lottie/LottieAnimationView;", "playerVisible", "", "speedView", "Lcom/devbeans/io/chat/utils/components/PlaybackSpeedToggleTextView;", "animateToggleToPause", "", "animateToggleToPlay", "formatDuration", "", "duration", "", "hide", "setState", "state", "show", "startLottieAnimation", "direction", "Listener", "State", "app_debug"})
public final class VoiceNotePlayerView extends androidx.constraintlayout.widget.ConstraintLayout {
    private final com.airbnb.lottie.LottieAnimationView playPauseToggleView = null;
    private final android.widget.TextView infoView = null;
    private final android.widget.TextView durationView = null;
    private final com.devbeans.io.chat.utils.components.PlaybackSpeedToggleTextView speedView = null;
    private final android.view.View closeButton = null;
    private com.devbeans.io.chat.utils.components.voice.VoiceNotePlayerView.State lastState;
    private boolean playerVisible = false;
    private int lottieDirection = 0;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.utils.components.voice.VoiceNotePlayerView.Listener listener;
    
    @kotlin.jvm.JvmOverloads
    public VoiceNotePlayerView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public VoiceNotePlayerView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public VoiceNotePlayerView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.utils.components.voice.VoiceNotePlayerView.Listener getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.components.voice.VoiceNotePlayerView.Listener p0) {
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.components.voice.VoiceNotePlayerView.State state) {
    }
    
    public final void show() {
    }
    
    public final void hide() {
    }
    
    private final java.lang.String formatDuration(long duration) {
        return null;
    }
    
    private final void animateToggleToPlay() {
    }
    
    private final void animateToggleToPause() {
    }
    
    private final void startLottieAnimation(int direction) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0011H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\bH\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003Jw\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001J\u0013\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u000201H\u00d6\u0001J\t\u00102\u001a\u00020\nH\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u00a8\u00063"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlayerView$State;", "", "uri", "Landroid/net/Uri;", "messageId", "", "threadId", "isPaused", "", "senderId", "", "threadRecipientId", "messagePositionInThread", "messageTimestamp", "playbackPosition", "playbackDuration", "playbackSpeed", "", "(Landroid/net/Uri;JJZLjava/lang/String;Ljava/lang/String;JJJJF)V", "()Z", "getMessageId", "()J", "getMessagePositionInThread", "getMessageTimestamp", "getPlaybackDuration", "getPlaybackPosition", "getPlaybackSpeed", "()F", "getSenderId", "()Ljava/lang/String;", "getThreadId", "getThreadRecipientId", "getUri", "()Landroid/net/Uri;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class State {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "uri")
        private final android.net.Uri uri = null;
        @com.google.gson.annotations.SerializedName(value = "messageId")
        private final long messageId = 0L;
        @com.google.gson.annotations.SerializedName(value = "threadId")
        private final long threadId = 0L;
        @com.google.gson.annotations.SerializedName(value = "isPaused")
        private final boolean isPaused = false;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "senderId")
        private final java.lang.String senderId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "threadRecipientId")
        private final java.lang.String threadRecipientId = null;
        @com.google.gson.annotations.SerializedName(value = "messagePositionInThread")
        private final long messagePositionInThread = 0L;
        @com.google.gson.annotations.SerializedName(value = "messageTimestamp")
        private final long messageTimestamp = 0L;
        @com.google.gson.annotations.SerializedName(value = "playbackPosition")
        private final long playbackPosition = 0L;
        @com.google.gson.annotations.SerializedName(value = "playbackDuration")
        private final long playbackDuration = 0L;
        @com.google.gson.annotations.SerializedName(value = "playbackSpeed")
        private final float playbackSpeed = 0.0F;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.components.voice.VoiceNotePlayerView.State copy(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, long messageId, long threadId, boolean isPaused, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.NotNull
        java.lang.String threadRecipientId, long messagePositionInThread, long messageTimestamp, long playbackPosition, long playbackDuration, float playbackSpeed) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public State(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, long messageId, long threadId, boolean isPaused, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.NotNull
        java.lang.String threadRecipientId, long messagePositionInThread, long messageTimestamp, long playbackPosition, long playbackDuration, float playbackSpeed) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.net.Uri component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.net.Uri getUri() {
            return null;
        }
        
        public final long component2() {
            return 0L;
        }
        
        public final long getMessageId() {
            return 0L;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final long getThreadId() {
            return 0L;
        }
        
        public final boolean component4() {
            return false;
        }
        
        public final boolean isPaused() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getThreadRecipientId() {
            return null;
        }
        
        public final long component7() {
            return 0L;
        }
        
        public final long getMessagePositionInThread() {
            return 0L;
        }
        
        public final long component8() {
            return 0L;
        }
        
        public final long getMessageTimestamp() {
            return 0L;
        }
        
        public final long component9() {
            return 0L;
        }
        
        public final long getPlaybackPosition() {
            return 0L;
        }
        
        public final long component10() {
            return 0L;
        }
        
        public final long getPlaybackDuration() {
            return 0L;
        }
        
        public final float component11() {
            return 0.0F;
        }
        
        public final float getPlaybackSpeed() {
            return 0.0F;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0016"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlayerView$Listener;", "", "onCloseRequested", "", "uri", "Landroid/net/Uri;", "onNavigateToMessage", "threadId", "", "threadRecipientId", "", "senderId", "messageSentAt", "messagePositionInThread", "onPause", "onPlay", "messageId", "position", "", "onSpeedChangeRequested", "speed", "", "app_debug"})
    public static abstract interface Listener {
        
        public abstract void onPlay(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, long messageId, double position);
        
        public abstract void onPause(@org.jetbrains.annotations.NotNull
        android.net.Uri uri);
        
        public abstract void onCloseRequested(@org.jetbrains.annotations.NotNull
        android.net.Uri uri);
        
        public abstract void onSpeedChangeRequested(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, float speed);
        
        public abstract void onNavigateToMessage(long threadId, @org.jetbrains.annotations.NotNull
        java.lang.String threadRecipientId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, long messageSentAt, long messagePositionInThread);
    }
}