package com.devbeans.io.chat.utils.revealable;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002+,B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010\'\u001a\u00020\u0018H\u0014J\b\u0010(\u001a\u00020\u0018H\u0014J\b\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020\u0018H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/utils/VideoPlayer$PlayerStateCallback;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "closeButton", "Landroid/view/View;", "duration", "Landroid/widget/TextView;", "durationUpdateRunnable", "Ljava/lang/Runnable;", "filePath", "", "handler", "Landroid/os/Handler;", "image", "Landroid/widget/ImageView;", "record", "Lcom/devbeans/io/chat/models/Payload;", "video", "Lcom/devbeans/io/chat/utils/VideoPlayer;", "viewModel", "Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageViewModel;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "cancelDurationUpdate", "displayImage", "displayMedia", "type", "displayVideo", "initViewModel", "messageId", "notifyExpiry", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPlayerReady", "onResume", "onStop", "scheduleDurationUpdate", "sendOpenedAck", "Companion", "ViewOnceGestureListener", "app_debug"})
public final class ViewOnceMessageActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.utils.VideoPlayer.PlayerStateCallback, com.devbeans.io.chat.callBacks.ExpiryCallback {
    private com.devbeans.io.chat.models.Payload record;
    private android.widget.ImageView image;
    private com.devbeans.io.chat.utils.VideoPlayer video;
    private android.view.View closeButton;
    private android.widget.TextView duration;
    private com.devbeans.io.chat.utils.revealable.ViewOnceMessageViewModel viewModel;
    private java.lang.String filePath;
    private final android.os.Handler handler = null;
    private final java.lang.Runnable durationUpdateRunnable = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.revealable.ViewOnceMessageActivity.Companion Companion = null;
    private static final java.lang.String TAG = null;
    private static final java.lang.String KEY_MESSAGE_ID = "message_id";
    private static final java.lang.String KEY_FILE_PATH = "file_path";
    
    public ViewOnceMessageActivity() {
        super();
    }
    
    @java.lang.Override
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull
    android.content.Context newBase) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void sendOpenedAck() {
    }
    
    @java.lang.Override
    protected void onStop() {
    }
    
    @java.lang.Override
    public void onPlayerReady() {
    }
    
    private final void initViewModel(java.lang.String messageId, java.lang.String filePath) {
    }
    
    private final void displayMedia(java.lang.String filePath, java.lang.String type) {
    }
    
    private final void displayVideo(java.lang.String filePath) {
    }
    
    private final void displayImage(java.lang.String filePath) {
    }
    
    private final void scheduleDurationUpdate() {
    }
    
    private final void cancelDurationUpdate() {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageActivity$ViewOnceGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "view", "Landroid/view/View;", "(Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageActivity;Landroid/view/View;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onSingleTapConfirmed", "app_debug"})
    final class ViewOnceGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
        private final android.view.View view = null;
        
        private ViewOnceGestureListener(android.view.View view) {
            super();
        }
        
        @java.lang.Override
        public boolean onDown(@org.jetbrains.annotations.NotNull
        android.view.MotionEvent e) {
            return false;
        }
        
        @java.lang.Override
        public boolean onSingleTapConfirmed(@org.jetbrains.annotations.NotNull
        android.view.MotionEvent e) {
            return false;
        }
        
        @java.lang.Override
        public boolean onFling(@org.jetbrains.annotations.NotNull
        android.view.MotionEvent e1, @org.jetbrains.annotations.NotNull
        android.view.MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageActivity$Companion;", "", "()V", "KEY_FILE_PATH", "", "KEY_MESSAGE_ID", "TAG", "kotlin.jvm.PlatformType", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "messageId", "filePath", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Intent getIntent(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.Nullable
        java.lang.String messageId, @org.jetbrains.annotations.NotNull
        java.lang.String filePath) {
            return null;
        }
    }
}