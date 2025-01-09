package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u00106\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u00108\u001a\u00020\u0014H\u0002J\b\u00109\u001a\u00020\u0014H\u0002J\b\u0010:\u001a\u00020\u0014H\u0002J\b\u0010;\u001a\u00020\u0014H\u0002J\b\u0010<\u001a\u00020\u0014H\u0003J\b\u0010=\u001a\u00020\u0014H\u0002J\b\u0010>\u001a\u00020\u0014H\u0003J\b\u0010?\u001a\u00020\u0014H\u0016J\b\u0010@\u001a\u00020\u0014H\u0002J\u0012\u0010A\u001a\u00020\u00142\b\u0010B\u001a\u0004\u0018\u00010CH\u0015J\b\u0010D\u001a\u00020\u0014H\u0014J\u0010\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020GH\u0017J\b\u0010H\u001a\u00020\u0014H\u0014J\b\u0010I\u001a\u00020\u0014H\u0014J\b\u0010J\u001a\u00020\u0014H\u0002J\u0010\u0010K\u001a\u00020\u00142\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u00100\u001a\n 1*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006O"}, d2 = {"Lcom/devbeans/io/chat/activities/MessageDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "_binding", "Lcom/devbeans/io/chat/databinding/ActivityMessageDetailsBinding;", "binding", "getBinding", "()Lcom/devbeans/io/chat/databinding/ActivityMessageDetailsBinding;", "blurEffect", "Landroid/graphics/RenderEffect;", "check", "", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "data", "", "file", "Ljava/io/File;", "getConversationData", "", "getGetConversationData", "()Lkotlin/Unit;", "imageView", "Landroid/widget/ImageView;", "inflater", "Landroid/view/LayoutInflater;", "isOwnMessage", "mAudioPrgs", "Landroid/widget/SeekBar;", "mPausePlayBtn", "mPlayer", "Landroid/media/MediaPlayer;", "mTime", "Landroid/widget/TextView;", "mView", "Landroid/view/View;", "payload", "Lcom/devbeans/io/chat/models/Payload;", "playbackControlsContainer", "Landroid/view/ViewGroup;", "player", "Lcom/devbeans/io/chat/utils/VideoPlayer;", "runnable", "Ljava/lang/Runnable;", "seekBarHandler", "Landroid/os/Handler;", "senderID", "tag", "kotlin.jvm.PlatformType", "getDownloadVisibility", "", "getTapToRevealText", "", "handleReceivedSide", "handleTapToRevealClicked", "initAudioViews", "initImage", "initPlayer", "initVideoViews", "initViews", "invalidateImage", "listeners", "notifyExpiry", "observers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onResume", "playVideo", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "updateSeekBar", "app_debug"})
public final class MessageDetailsActivity extends androidx.appcompat.app.AppCompatActivity implements com.devbeans.io.chat.callBacks.ExpiryCallback {
    private com.devbeans.io.chat.databinding.ActivityMessageDetailsBinding _binding;
    private final java.lang.String tag = null;
    private com.devbeans.io.chat.models.Payload payload;
    private com.devbeans.io.chat.models.Conversation conversation;
    private java.lang.String senderID;
    private android.view.LayoutInflater inflater;
    private java.lang.String data;
    private android.view.View mView;
    private android.media.MediaPlayer mPlayer;
    private android.widget.TextView mTime;
    private android.widget.SeekBar mAudioPrgs;
    private android.widget.ImageView mPausePlayBtn;
    private android.graphics.RenderEffect blurEffect;
    private boolean check = false;
    private final java.lang.Runnable runnable = null;
    private android.os.Handler seekBarHandler;
    private boolean isOwnMessage = false;
    private java.io.File file;
    private com.devbeans.io.chat.utils.VideoPlayer player;
    private android.view.ViewGroup playbackControlsContainer;
    private android.widget.ImageView imageView;
    
    public MessageDetailsActivity() {
        super();
    }
    
    private final com.devbeans.io.chat.databinding.ActivityMessageDetailsBinding getBinding() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.S)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final kotlin.Unit getGetConversationData() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.S)
    private final void initViews() {
    }
    
    private final java.lang.CharSequence getTapToRevealText(com.devbeans.io.chat.databinding.ActivityMessageDetailsBinding binding) {
        return null;
    }
    
    private final void handleReceivedSide(com.devbeans.io.chat.databinding.ActivityMessageDetailsBinding binding) {
    }
    
    private final int getDownloadVisibility() {
        return 0;
    }
    
    private final void invalidateImage() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.S)
    private final void listeners() {
    }
    
    private final void handleTapToRevealClicked(com.devbeans.io.chat.databinding.ActivityMessageDetailsBinding binding) {
    }
    
    private final void observers() {
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    private final void initImage() {
    }
    
    private final void initVideoViews() {
    }
    
    private final void playVideo() {
    }
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void initAudioViews() {
    }
    
    private final void initPlayer() {
    }
    
    private final void updateSeekBar() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
}