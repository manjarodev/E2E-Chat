package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001rB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0002H\u0002J\u0010\u0010_\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0002H\u0002J\u0018\u0010`\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00022\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0002H\u0002J\u0010\u0010d\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0002H\u0002J\u0010\u0010e\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0002H\u0002J\b\u0010f\u001a\u00020]H\u0002J\u0010\u0010g\u001a\u00020]2\u0006\u0010D\u001a\u00020\u0002H\u0002J\u0010\u0010h\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0002H\u0002J\u0010\u0010i\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0002H\u0002J\u0010\u0010j\u001a\u00020]2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010k\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0002H\u0016J\b\u0010l\u001a\u00020]H\u0002J\u001c\u0010m\u001a\u00020]2\b\u00104\u001a\u0004\u0018\u0001052\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0002J\b\u0010n\u001a\u00020]H\u0002J\b\u0010o\u001a\u00020]H\u0002J\b\u0010p\u001a\u00020]H\u0002J\b\u0010q\u001a\u00020]H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010>\u001a\n ?*\u0004\u0018\u00010=0=X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00108\"\u0004\bF\u0010:R\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020PX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010VX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010VX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010VX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006s"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/IncomingVoiceMessageViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$IncomingTextMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "backgroundLayout", "Landroid/widget/RelativeLayout;", "getBackgroundLayout", "()Landroid/widget/RelativeLayout;", "setBackgroundLayout", "(Landroid/widget/RelativeLayout;)V", "bubbleText", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBubbleText", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBubbleText", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "cardView", "Landroidx/cardview/widget/CardView;", "getCardView", "()Landroidx/cardview/widget/CardView;", "setCardView", "(Landroidx/cardview/widget/CardView;)V", "disappearIcon", "Landroid/widget/ImageView;", "getDisappearIcon", "()Landroid/widget/ImageView;", "setDisappearIcon", "(Landroid/widget/ImageView;)V", "downloadButton", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "forwardLayout", "Landroid/widget/LinearLayout;", "getForwardLayout", "()Landroid/widget/LinearLayout;", "setForwardLayout", "(Landroid/widget/LinearLayout;)V", "isPlay", "", "()Z", "setPlay", "(Z)V", "isStarted", "setStarted", "mAudioPrgs", "Landroid/widget/SeekBar;", "mMessage", "getMMessage", "()Lcom/devbeans/io/chat/models/Messages;", "setMMessage", "(Lcom/devbeans/io/chat/models/Messages;)V", "mPlayButton", "mPlayer", "Lcom/devbeans/io/chat/utils/audio/AudioPlayer;", "mediaPlayer", "kotlin.jvm.PlatformType", "getMediaPlayer", "()Lcom/devbeans/io/chat/utils/audio/AudioPlayer;", "setMediaPlayer", "(Lcom/devbeans/io/chat/utils/audio/AudioPlayer;)V", "prevMessage", "getPrevMessage", "setPrevMessage", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "seekbarHandler", "Landroid/os/Handler;", "timerClass", "Ljava/util/Timer;", "getTimerClass", "()Ljava/util/Timer;", "setTimerClass", "(Ljava/util/Timer;)V", "tvDuration", "Landroid/widget/TextView;", "tvTime", "tvTimeSent", "updateSeekbar", "Ljava/lang/Runnable;", "userName", "handleAnonymousDownload", "", "message", "handleAutoDownload", "handleDownloadClick", "data", "", "handleDownloader", "handleGroupDownload", "handleOneToOneDownload", "handlePlayClick", "handlePrevMessage", "handleSimpleDownload", "handleViews", "init", "onBind", "pauseAudio", "playAudio", "reset", "resumeAudio", "stopAudio", "updateRunnable", "Companion", "app_debug"})
public final class IncomingVoiceMessageViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.IncomingTextMessageViewHolder<com.devbeans.io.chat.models.Messages> {
    private final android.widget.TextView tvDuration = null;
    private android.widget.TextView tvTime;
    private android.widget.TextView userName;
    private com.devbeans.io.chat.utils.audio.AudioPlayer mPlayer;
    private android.widget.SeekBar mAudioPrgs;
    private android.widget.TextView tvTimeSent;
    private android.widget.ImageView mPlayButton;
    private android.widget.ImageView downloadButton;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView disappearIcon;
    @org.jetbrains.annotations.Nullable
    private android.widget.ProgressBar progressBar;
    private boolean isPlay = false;
    private boolean isStarted = false;
    private java.lang.Runnable updateSeekbar;
    private android.os.Handler seekbarHandler;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages mMessage;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages prevMessage;
    @org.jetbrains.annotations.Nullable
    private androidx.cardview.widget.CardView cardView;
    @org.jetbrains.annotations.Nullable
    private java.io.File file;
    private com.devbeans.io.chat.utils.audio.AudioPlayer mediaPlayer;
    @org.jetbrains.annotations.NotNull
    private java.util.Timer timerClass;
    @org.jetbrains.annotations.Nullable
    private android.widget.RelativeLayout backgroundLayout;
    @org.jetbrains.annotations.Nullable
    private androidx.constraintlayout.widget.ConstraintLayout bubbleText;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout forwardLayout;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.adapters.viewholders.IncomingVoiceMessageViewHolder.Companion Companion = null;
    private static com.devbeans.io.chat.models.Messages mPrev;
    @org.jetbrains.annotations.NotNull
    private static androidx.lifecycle.MutableLiveData<com.devbeans.io.chat.models.Messages> messagesMutableLiveData;
    
    public IncomingVoiceMessageViewHolder(@org.jetbrains.annotations.NotNull
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
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ProgressBar getProgressBar() {
        return null;
    }
    
    public final void setProgressBar(@org.jetbrains.annotations.Nullable
    android.widget.ProgressBar p0) {
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
    public final com.devbeans.io.chat.models.Messages getPrevMessage() {
        return null;
    }
    
    public final void setPrevMessage(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Messages p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.cardview.widget.CardView getCardView() {
        return null;
    }
    
    public final void setCardView(@org.jetbrains.annotations.Nullable
    androidx.cardview.widget.CardView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
    }
    
    public final com.devbeans.io.chat.utils.audio.AudioPlayer getMediaPlayer() {
        return null;
    }
    
    public final void setMediaPlayer(com.devbeans.io.chat.utils.audio.AudioPlayer p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Timer getTimerClass() {
        return null;
    }
    
    public final void setTimerClass(@org.jetbrains.annotations.NotNull
    java.util.Timer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.RelativeLayout getBackgroundLayout() {
        return null;
    }
    
    public final void setBackgroundLayout(@org.jetbrains.annotations.Nullable
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.constraintlayout.widget.ConstraintLayout getBubbleText() {
        return null;
    }
    
    public final void setBubbleText(@org.jetbrains.annotations.Nullable
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
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleViews(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloadClick(com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handlePlayClick() {
    }
    
    private final void handleSimpleDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleAutoDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleAnonymousDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleGroupDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleOneToOneDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handlePrevMessage(com.devbeans.io.chat.models.Messages prevMessage) {
    }
    
    private final void updateRunnable() {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/IncomingVoiceMessageViewHolder$Companion;", "", "()V", "mPrev", "Lcom/devbeans/io/chat/models/Messages;", "messagesMutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "getMessagesMutableLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setMessagesMutableLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
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