package com.devbeans.io.chat.camera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0003cdeB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u000207H\u0002J\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\fJ\b\u0010?\u001a\u000203H\u0002J0\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020B2\u0006\u0010!\u001a\u00020\u001eH\u0002J\b\u0010F\u001a\u000203H\u0003J\b\u0010G\u001a\u000203H\u0016J\"\u0010H\u001a\u0002032\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00072\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J\b\u0010M\u001a\u000203H\u0016J\u0012\u0010N\u001a\u0002032\b\u0010O\u001a\u0004\u0018\u00010PH\u0015J-\u0010Q\u001a\u0002032\u0006\u0010I\u001a\u00020\u00072\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0S2\u0006\u0010T\u001a\u00020UH\u0017\u00a2\u0006\u0002\u0010VJ\b\u0010W\u001a\u000203H\u0014J0\u0010X\u001a\u0002032\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010Y\u001a\u0002032\b\u0010\n\u001a\u0004\u0018\u00010\f2\u0006\u0010Z\u001a\u00020\u0007H\u0003J\b\u0010[\u001a\u000203H\u0003J\b\u0010\\\u001a\u000203H\u0002J\b\u0010]\u001a\u000203H\u0002J\u0010\u0010^\u001a\u0002032\u0006\u0010_\u001a\u00020\u0016H\u0002J \u0010`\u001a\u000203*\u00020B2\u000e\b\u0004\u0010a\u001a\b\u0012\u0004\u0012\u0002030bH\u0086\b\u00f8\u0001\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006f"}, d2 = {"Lcom/devbeans/io/chat/camera/CameraActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "adapter", "Lcom/devbeans/io/chat/camera/CameraActivity$CameraTypeModeAdapter;", "cameraIndex", "", "cameraPreview", "Landroidx/camera/view/PreviewView;", "cameraProvider", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "camera_clicker", "Landroid/widget/ImageView;", "camera_mode_recycler", "Landroidx/recyclerview/widget/RecyclerView;", "camera_switch", "camerax", "Landroidx/camera/core/Camera;", "captureListener", "Landroidx/core/util/Consumer;", "Landroidx/camera/video/VideoRecordEvent;", "close_btn", "condition", "flashMode", "flash_toggle", "imageCapture", "Landroidx/camera/core/ImageCapture;", "inAnimation", "Landroid/view/animation/Animation;", "isrecording", "", "outAnimation", "outputFile", "Ljava/io/File;", "recordTime", "Landroid/widget/TextView;", "recording", "Landroidx/camera/video/Recording;", "recordingState", "texT", "", "tv_sub", "videoCapture", "Landroidx/camera/video/VideoCapture;", "Landroidx/camera/video/Recorder;", "video_clicker", "allPermissionGranted", "canRecordAudio", "capturePicture", "", "capturesVideo", "displayAudioRecordingPermissionsDialog", "getExecutor", "Ljava/util/concurrent/Executor;", "getResolutions", "", "Landroidx/camera/video/Quality;", "Landroid/util/Size;", "selector", "Landroidx/camera/core/CameraSelector;", "provider", "handleClickButton", "hideAndDisableControlsForVideoRecording", "flashButton", "Landroid/view/View;", "flipButton", "closeButton", "recyclerView", "initiateCameraX", "notifyExpiry", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "showAndEnableControlsAfterVideoRecording", "startCameraX", "index", "stopVideo", "toggleCamera", "toggleFlashCondition", "updateUI", "event", "afterMeasured", "block", "Lkotlin/Function0;", "CameraTypeModeAdapter", "Companion", "OnCameraModeChanged", "app_debug"})
public final class CameraActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.ExpiryCallback {
    private final com.devbeans.io.chat.camera.CameraActivity.CameraTypeModeAdapter adapter = null;
    private boolean isrecording = false;
    private int flashMode = androidx.camera.core.ImageCapture.FLASH_MODE_OFF;
    private int cameraIndex = 0;
    private int condition = 0;
    private androidx.camera.video.Recording recording;
    private android.widget.ImageView close_btn;
    private androidx.camera.core.Camera camerax;
    private android.view.animation.Animation outAnimation;
    private android.view.animation.Animation inAnimation;
    private java.lang.String texT;
    private com.google.common.util.concurrent.ListenableFuture<androidx.camera.lifecycle.ProcessCameraProvider> cameraProvider;
    private androidx.camera.video.VideoCapture<androidx.camera.video.Recorder> videoCapture;
    private androidx.camera.core.ImageCapture imageCapture;
    private android.widget.ImageView camera_clicker;
    private android.widget.ImageView flash_toggle;
    private android.widget.ImageView camera_switch;
    private android.widget.ImageView video_clicker;
    private android.widget.TextView tv_sub;
    private androidx.recyclerview.widget.RecyclerView camera_mode_recycler;
    private androidx.camera.view.PreviewView cameraPreview;
    private android.widget.TextView recordTime;
    private androidx.camera.video.VideoRecordEvent recordingState;
    private java.io.File outputFile;
    private final androidx.core.util.Consumer<androidx.camera.video.VideoRecordEvent> captureListener = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.camera.CameraActivity.Companion Companion = null;
    private static final java.lang.String TAG = null;
    private static final int REQUEST_CODE_PERMISSIONS = 10;
    private static final java.lang.String[] REQUIRED_PERMISSIONS = null;
    
    public CameraActivity() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void initiateCameraX() {
    }
    
    private final void handleClickButton() {
    }
    
    private final void displayAudioRecordingPermissionsDialog() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    /**
     * inline function for tap to focus feature in cameraX
     */
    public final void afterMeasured(@org.jetbrains.annotations.NotNull
    android.view.View $this$afterMeasured, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> block) {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    private final void startCameraX(androidx.camera.lifecycle.ProcessCameraProvider cameraProvider, int index) {
    }
    
    private final java.util.concurrent.Executor getExecutor() {
        return null;
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void toggleFlashCondition() {
    }
    
    private final void capturePicture() {
    }
    
    private final boolean canRecordAudio() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<androidx.camera.video.Quality, android.util.Size> getResolutions(@org.jetbrains.annotations.NotNull
    androidx.camera.core.CameraSelector selector, @org.jetbrains.annotations.NotNull
    androidx.camera.lifecycle.ProcessCameraProvider provider) {
        return null;
    }
    
    @java.lang.Override
    @java.lang.Deprecated
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    private final void capturesVideo() {
    }
    
    private final void updateUI(androidx.camera.video.VideoRecordEvent event) {
    }
    
    private final boolean allPermissionGranted() {
        return false;
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    private final void stopVideo() {
    }
    
    private final void toggleCamera() {
    }
    
    private final void hideAndDisableControlsForVideoRecording(android.view.View flashButton, android.view.View flipButton, android.view.View closeButton, android.view.View recyclerView, android.view.animation.Animation outAnimation) {
    }
    
    private final void showAndEnableControlsAfterVideoRecording(android.view.View flashButton, android.view.View flipButton, android.view.View closeButton, android.view.View recyclerView, android.view.animation.Animation inAnimation) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/camera/CameraActivity$OnCameraModeChanged;", "", "onCameraMode", "", "value", "", "app_debug"})
    public static abstract interface OnCameraModeChanged {
        
        public abstract void onCameraMode(@org.jetbrains.annotations.NotNull
        java.lang.String value);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\'B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016H\u0016J&\u0010%\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`&R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006("}, d2 = {"Lcom/devbeans/io/chat/camera/CameraActivity$CameraTypeModeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/camera/CameraActivity$CameraTypeModeAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "arrayList", "Ljava/util/ArrayList;", "", "getArrayList", "()Ljava/util/ArrayList;", "setArrayList", "(Ljava/util/ArrayList;)V", "callback", "Lcom/devbeans/io/chat/camera/CameraActivity$OnCameraModeChanged;", "getCallback", "()Lcom/devbeans/io/chat/camera/CameraActivity$OnCameraModeChanged;", "setCallback", "(Lcom/devbeans/io/chat/camera/CameraActivity$OnCameraModeChanged;)V", "getContext", "()Landroid/content/Context;", "selected", "", "getSelected", "()I", "setSelected", "(I)V", "changeSelector", "", "position", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "Lkotlin/collections/ArrayList;", "ViewHolder", "app_debug"})
    public static final class CameraTypeModeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.camera.CameraActivity.CameraTypeModeAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull
        private final android.content.Context context = null;
        @org.jetbrains.annotations.Nullable
        private com.devbeans.io.chat.camera.CameraActivity.OnCameraModeChanged callback;
        @org.jetbrains.annotations.NotNull
        private java.util.ArrayList<java.lang.String> arrayList;
        private int selected = 0;
        
        public CameraTypeModeAdapter(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.camera.CameraActivity.OnCameraModeChanged getCallback() {
            return null;
        }
        
        public final void setCallback(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.camera.CameraActivity.OnCameraModeChanged p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<java.lang.String> getArrayList() {
            return null;
        }
        
        public final void setArrayList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<java.lang.String> p0) {
        }
        
        public final void updateData(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.camera.CameraActivity.OnCameraModeChanged callback, @org.jetbrains.annotations.NotNull
        java.util.ArrayList<java.lang.String> arrayList) {
        }
        
        public final int getSelected() {
            return 0;
        }
        
        public final void setSelected(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.camera.CameraActivity.CameraTypeModeAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.camera.CameraActivity.CameraTypeModeAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        public final void changeSelector(int position) {
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/camera/CameraActivity$CameraTypeModeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "item_name", "Landroid/widget/TextView;", "getItem_name", "()Landroid/widget/TextView;", "app_debug"})
        public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView item_name = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View itemView) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getItem_name() {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/chat/camera/CameraActivity$Companion;", "", "()V", "REQUEST_CODE_PERMISSIONS", "", "REQUIRED_PERMISSIONS", "", "", "[Ljava/lang/String;", "TAG", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}