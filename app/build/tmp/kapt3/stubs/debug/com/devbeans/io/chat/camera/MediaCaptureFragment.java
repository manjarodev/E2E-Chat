package com.devbeans.io.chat.camera;

import java.lang.System;

/**
 * Fragment which displays the proper camera fragment.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J-\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\t2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0016\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0012H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\u0010\u0010\'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016Jn\u0010/\u001a\u0004\u0018\u00010\u000e\"\u0004\b\u0000\u001002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u000205042\"\u00106\u001a\u001e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u000205\u0012\b\u0012\u000609R\u000208072\u0006\u0010:\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002J@\u0010;\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012042\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001202J0\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020)2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012042\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001202R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/devbeans/io/chat/camera/MediaCaptureFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/camera/CameraFragment$Controller;", "()V", "captureChildFragment", "Lcom/devbeans/io/chat/camera/CameraFragment;", "navigator", "Lcom/devbeans/io/chat/camera/MediaSelectionNavigator;", "getDisplayRotation", "", "getMaxVideoDuration", "getMostRecentMediaItem", "Landroidx/lifecycle/LiveData;", "Ljava/util/Optional;", "Lcom/devbeans/io/chat/models/Media;", "isFirst", "", "onCameraCountButtonClicked", "", "onCameraError", "onGalleryClicked", "onImageCaptured", "data", "", "width", "height", "onMediaRenderFailed", "onMediaRendered", "media", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onVideoCaptureError", "onVideoCaptured", "fd", "Ljava/io/FileDescriptor;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "renderCaptureToMedia", "T", "dataSupplier", "Lkotlin/Function0;", "getLength", "Lkotlin/Function1;", "", "createBlobBuilder", "Lkotlin/Function3;", "Lcom/devbeans/io/chat/utils/editor/BlobProvider;", "Lcom/devbeans/io/chat/utils/editor/BlobProvider$BlobBuilder;", "mimeType", "renderImageToMedia", "onFailedToRender", "renderVideoToMedia", "fileDescriptor", "Companion", "app_debug"})
public final class MediaCaptureFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.camera.CameraFragment.Controller {
    private com.devbeans.io.chat.camera.CameraFragment captureChildFragment;
    private com.devbeans.io.chat.camera.MediaSelectionNavigator navigator;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.camera.MediaCaptureFragment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CAPTURE_RESULT = "capture_result";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CAPTURE_RESULT_OK = "capture_result_ok";
    
    public MediaCaptureFragment() {
        super();
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onCameraError() {
    }
    
    @java.lang.Override
    public void onImageCaptured(@org.jetbrains.annotations.NotNull
    byte[] data, int width, int height) {
    }
    
    @java.lang.Override
    public void onVideoCaptured(@org.jetbrains.annotations.NotNull
    java.io.FileDescriptor fd) {
    }
    
    private final void onMediaRendered(com.devbeans.io.chat.models.Media media) {
    }
    
    private final void onMediaRenderFailed() {
    }
    
    @java.lang.Override
    public void onVideoCaptureError() {
    }
    
    @java.lang.Override
    public void onGalleryClicked() {
    }
    
    @java.lang.Override
    public int getDisplayRotation() {
        return 0;
    }
    
    @java.lang.Override
    public void onCameraCountButtonClicked() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.lifecycle.LiveData<java.util.Optional<com.devbeans.io.chat.models.Media>> getMostRecentMediaItem() {
        return null;
    }
    
    @java.lang.Override
    public int getMaxVideoDuration() {
        return 0;
    }
    
    private final boolean isFirst() {
        return false;
    }
    
    public final void renderImageToMedia(@org.jetbrains.annotations.NotNull
    byte[] data, int width, int height, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.models.Media, kotlin.Unit> onMediaRendered, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onFailedToRender) {
    }
    
    public final void renderVideoToMedia(@org.jetbrains.annotations.NotNull
    java.io.FileDescriptor fileDescriptor, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.models.Media, kotlin.Unit> onMediaRendered, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onFailedToRender) {
    }
    
    private final <T extends java.lang.Object>com.devbeans.io.chat.models.Media renderCaptureToMedia(kotlin.jvm.functions.Function0<? extends T> dataSupplier, kotlin.jvm.functions.Function1<? super T, java.lang.Long> getLength, kotlin.jvm.functions.Function3<? super com.devbeans.io.chat.utils.editor.BlobProvider, ? super T, ? super java.lang.Long, ? extends com.devbeans.io.chat.utils.editor.BlobProvider.BlobBuilder> createBlobBuilder, java.lang.String mimeType, int width, int height) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/camera/MediaCaptureFragment$Companion;", "", "()V", "CAPTURE_RESULT", "", "CAPTURE_RESULT_OK", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}