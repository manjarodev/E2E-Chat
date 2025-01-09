package com.devbeans.io.chat.utils.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001)B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0017J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0015J\u0012\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/devbeans/io/chat/utils/components/PlaybackSpeedToggleTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentSpeedIndex", "labels", "", "", "[Ljava/lang/String;", "playbackSpeedListener", "Lcom/devbeans/io/chat/utils/components/PlaybackSpeedToggleTextView$PlaybackSpeedListener;", "getPlaybackSpeedListener", "()Lcom/devbeans/io/chat/utils/components/PlaybackSpeedToggleTextView$PlaybackSpeedListener;", "setPlaybackSpeedListener", "(Lcom/devbeans/io/chat/utils/components/PlaybackSpeedToggleTextView$PlaybackSpeedListener;)V", "requestedSpeed", "", "Ljava/lang/Float;", "speeds", "", "clearRequestedSpeed", "", "getCurrentLabel", "getCurrentSpeed", "getNextSpeedIndex", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setCurrentSpeed", "speed", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "zoomIn", "zoomOut", "PlaybackSpeedListener", "app_debug"})
public final class PlaybackSpeedToggleTextView extends androidx.appcompat.widget.AppCompatTextView {
    private final int[] speeds = null;
    private final java.lang.String[] labels = null;
    private int currentSpeedIndex = 0;
    private java.lang.Float requestedSpeed;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.utils.components.PlaybackSpeedToggleTextView.PlaybackSpeedListener playbackSpeedListener;
    
    @kotlin.jvm.JvmOverloads
    public PlaybackSpeedToggleTextView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public PlaybackSpeedToggleTextView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public PlaybackSpeedToggleTextView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.utils.components.PlaybackSpeedToggleTextView.PlaybackSpeedListener getPlaybackSpeedListener() {
        return null;
    }
    
    public final void setPlaybackSpeedListener(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.components.PlaybackSpeedToggleTextView.PlaybackSpeedListener p0) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable
    android.view.MotionEvent event) {
        return false;
    }
    
    public final void clearRequestedSpeed() {
    }
    
    public final void setCurrentSpeed(float speed) {
    }
    
    private final int getNextSpeedIndex() {
        return 0;
    }
    
    private final float getCurrentSpeed() {
        return 0.0F;
    }
    
    private final java.lang.String getCurrentLabel() {
        return null;
    }
    
    private final void zoomIn() {
    }
    
    private final void zoomOut() {
    }
    
    @java.lang.Override
    public void setOnClickListener(@org.jetbrains.annotations.Nullable
    android.view.View.OnClickListener l) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/components/PlaybackSpeedToggleTextView$PlaybackSpeedListener;", "", "onPlaybackSpeedChanged", "", "speed", "", "app_debug"})
    public static abstract interface PlaybackSpeedListener {
        
        public abstract void onPlaybackSpeedChanged(float speed);
    }
}