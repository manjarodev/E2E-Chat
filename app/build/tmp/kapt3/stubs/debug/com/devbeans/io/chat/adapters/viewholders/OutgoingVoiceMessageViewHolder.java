package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001hB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020;H\u0002J\u0010\u0010M\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0002H\u0002J\u0010\u0010O\u001a\u00020K2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010P\u001a\u00020K2\u0006\u0010Q\u001a\u00020\u0002H\u0016J\u0010\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020TH\u0016J\u0018\u0010U\u001a\u00020K2\u0006\u0010S\u001a\u00020T2\u0006\u0010V\u001a\u00020WH\u0016J\u0018\u0010X\u001a\u00020K2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020ZH\u0016J\u0018\u0010\\\u001a\u00020K2\u0006\u0010S\u001a\u00020T2\u0006\u0010V\u001a\u00020WH\u0016J\u0018\u0010]\u001a\u00020K2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020*H\u0016J\u0010\u0010a\u001a\u00020K2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010b\u001a\u00020KH\u0002J\u001c\u0010c\u001a\u00020K2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\b\u0010d\u001a\u00020KH\u0002J\b\u0010e\u001a\u00020KH\u0002J\b\u0010f\u001a\u00020KH\u0002J\b\u0010g\u001a\u00020KH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010B\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001a\"\u0004\bD\u0010\u001cR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010FX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006i"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/OutgoingVoiceMessageViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$OutcomingTextMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "Lcom/devbeans/io/chat/utils/components/AudioView$Callbacks;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "audioView", "Lcom/devbeans/io/chat/utils/components/AudioView;", "backgroundLayout", "Landroid/widget/RelativeLayout;", "getBackgroundLayout", "()Landroid/widget/RelativeLayout;", "setBackgroundLayout", "(Landroid/widget/RelativeLayout;)V", "bubbleView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBubbleView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBubbleView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "disappearIcon", "Landroid/widget/ImageView;", "getDisappearIcon", "()Landroid/widget/ImageView;", "setDisappearIcon", "(Landroid/widget/ImageView;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "forwardLayout", "Landroid/widget/LinearLayout;", "getForwardLayout", "()Landroid/widget/LinearLayout;", "setForwardLayout", "(Landroid/widget/LinearLayout;)V", "isPlay", "", "()Z", "setPlay", "(Z)V", "isStarted", "setStarted", "mAudioPrgs", "Landroid/widget/SeekBar;", "mMessage", "getMMessage", "()Lcom/devbeans/io/chat/models/Messages;", "setMMessage", "(Lcom/devbeans/io/chat/models/Messages;)V", "mPlayButton", "mPlayer", "Lcom/devbeans/io/chat/utils/audio/AudioPlayer;", "playing_position", "", "getPlaying_position", "()I", "setPlaying_position", "(I)V", "seekbarHandler", "Landroid/os/Handler;", "tick", "getTick", "setTick", "tvTime", "Landroid/widget/TextView;", "tvTimeSent", "updateSeekbar", "Ljava/lang/Runnable;", "handlePlayClick", "", "absoluteAdapterPosition", "handlePrevMessage", "prevMessage", "init", "onBind", "message", "onPause", "audioUri", "Landroid/net/Uri;", "onPlay", "progress", "", "onProgressUpdated", "durationMillis", "", "playheadMillis", "onSeekTo", "onSpeedChanged", "speed", "", "isPlaying", "onStopAndReset", "pauseAudio", "playAudio", "reset", "resumeAudio", "stopAudio", "updateRunnable", "Companion", "app_debug"})
public final class OutgoingVoiceMessageViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.OutcomingTextMessageViewHolder<com.devbeans.io.chat.models.Messages> implements com.devbeans.io.chat.utils.components.AudioView.Callbacks {
    private android.widget.TextView tvTime;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView disappearIcon;
    private com.devbeans.io.chat.utils.audio.AudioPlayer mPlayer;
    private android.widget.SeekBar mAudioPrgs;
    private android.widget.ImageView mPlayButton;
    private boolean isPlay = false;
    private boolean isStarted = false;
    private java.lang.Runnable updateSeekbar;
    private android.os.Handler seekbarHandler;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages mMessage;
    @org.jetbrains.annotations.Nullable
    private android.widget.RelativeLayout backgroundLayout;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView tick;
    @org.jetbrains.annotations.Nullable
    private java.io.File file;
    private android.widget.TextView tvTimeSent;
    @org.jetbrains.annotations.Nullable
    private androidx.constraintlayout.widget.ConstraintLayout bubbleView;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout forwardLayout;
    private com.devbeans.io.chat.utils.components.AudioView audioView;
    private int playing_position = -1;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.adapters.viewholders.OutgoingVoiceMessageViewHolder.Companion Companion = null;
    private static com.devbeans.io.chat.models.Messages mPrev;
    @org.jetbrains.annotations.Nullable
    private static android.widget.SeekBar.OnSeekBarChangeListener seekbarChangeListener;
    @org.jetbrains.annotations.NotNull
    private static androidx.lifecycle.MutableLiveData<com.devbeans.io.chat.models.Messages> messagesMutableLiveData;
    
    public OutgoingVoiceMessageViewHolder(@org.jetbrains.annotations.NotNull
    android.view.View itemView, @org.jetbrains.annotations.Nullable
    java.lang.Object payload) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getDisappearIcon() {
        return null;
    }
    
    public final void setDisappearIcon(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    public final boolean isPlay() {
        return false;
    }
    
    public final void setPlay(boolean p0) {
    }
    
    public final boolean isStarted() {
        return false;
    }
    
    public final void setStarted(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Messages getMMessage() {
        return null;
    }
    
    public final void setMMessage(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Messages p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.RelativeLayout getBackgroundLayout() {
        return null;
    }
    
    public final void setBackgroundLayout(@org.jetbrains.annotations.Nullable
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getTick() {
        return null;
    }
    
    public final void setTick(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.constraintlayout.widget.ConstraintLayout getBubbleView() {
        return null;
    }
    
    public final void setBubbleView(@org.jetbrains.annotations.Nullable
    androidx.constraintlayout.widget.ConstraintLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.LinearLayout getForwardLayout() {
        return null;
    }
    
    public final void setForwardLayout(@org.jetbrains.annotations.Nullable
    android.widget.LinearLayout p0) {
    }
    
    private final void init(android.view.View itemView) {
    }
    
    public final int getPlaying_position() {
        return 0;
    }
    
    public final void setPlaying_position(int p0) {
    }
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handlePlayClick(int absoluteAdapterPosition) {
    }
    
    private final void handlePrevMessage(com.devbeans.io.chat.models.Messages prevMessage) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
    private final void updateRunnable() throws java.lang.Exception {
    }
    
    private final void playAudio(android.widget.SeekBar mAudioPrgs, java.lang.Runnable updateSeekbar) {
    }
    
    private final void stopAudio() {
    }
    
    private final void reset() {
    }
    
    private final void pauseAudio() {
    }
    
    private final void resumeAudio() {
    }
    
    @java.lang.Override
    public void onPlay(@org.jetbrains.annotations.NotNull
    android.net.Uri audioUri, double progress) {
    }
    
    @java.lang.Override
    public void onPause(@org.jetbrains.annotations.NotNull
    android.net.Uri audioUri) {
    }
    
    @java.lang.Override
    public void onSeekTo(@org.jetbrains.annotations.NotNull
    android.net.Uri audioUri, double progress) {
    }
    
    @java.lang.Override
    public void onStopAndReset(@org.jetbrains.annotations.NotNull
    android.net.Uri audioUri) {
    }
    
    @java.lang.Override
    public void onSpeedChanged(float speed, boolean isPlaying) {
    }
    
    @java.lang.Override
    public void onProgressUpdated(long durationMillis, long playheadMillis) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/OutgoingVoiceMessageViewHolder$Companion;", "", "()V", "mPrev", "Lcom/devbeans/io/chat/models/Messages;", "messagesMutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "getMessagesMutableLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setMessagesMutableLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "seekbarChangeListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "getSeekbarChangeListener", "()Landroid/widget/SeekBar$OnSeekBarChangeListener;", "setSeekbarChangeListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.SeekBar.OnSeekBarChangeListener getSeekbarChangeListener() {
            return null;
        }
        
        public final void setSeekbarChangeListener(@org.jetbrains.annotations.Nullable
        android.widget.SeekBar.OnSeekBarChangeListener p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.lifecycle.MutableLiveData<com.devbeans.io.chat.models.Messages> getMessagesMutableLiveData() {
            return null;
        }
        
        public final void setMessagesMutableLiveData(@org.jetbrains.annotations.NotNull
        androidx.lifecycle.MutableLiveData<com.devbeans.io.chat.models.Messages> p0) {
        }
    }
}