package com.devbeans.io.chat.utils.qr;

import java.lang.System;

/**
 * API21+ version of QR scanning view. Uses camerax APIs.
 */
@androidx.annotation.RequiresApi(value = 21)
@android.annotation.SuppressLint(value = {"ViewConstructor"})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/ScannerView21;", "Landroid/widget/FrameLayout;", "Lcom/devbeans/io/chat/utils/qr/ScannerView;", "context", "Landroid/content/Context;", "listener", "Lcom/devbeans/io/chat/utils/qr/kitkat/ScanListener;", "(Landroid/content/Context;Lcom/devbeans/io/chat/utils/qr/kitkat/ScanListener;)V", "analyzerExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "camera", "Landroidx/camera/core/Camera;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "previewView", "Landroidx/camera/view/PreviewView;", "qrProcessor", "Lcom/devbeans/io/chat/utils/qr/QrProcessor;", "onCameraProvider", "", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "start", "lifecycleOwner", "Companion", "app_debug"})
public final class ScannerView21 extends android.widget.FrameLayout implements com.devbeans.io.chat.utils.qr.ScannerView {
    private final com.devbeans.io.chat.utils.qr.kitkat.ScanListener listener = null;
    private final java.util.concurrent.ExecutorService analyzerExecutor = null;
    private androidx.camera.lifecycle.ProcessCameraProvider cameraProvider;
    private androidx.camera.core.Camera camera;
    private androidx.camera.view.PreviewView previewView;
    private final com.devbeans.io.chat.utils.qr.QrProcessor qrProcessor = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.qr.ScannerView21.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public ScannerView21(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.qr.kitkat.ScanListener listener) {
        super(null);
    }
    
    @java.lang.Override
    public void start(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
    
    private final void onCameraProvider(androidx.lifecycle.LifecycleOwner lifecycle, androidx.camera.lifecycle.ProcessCameraProvider cameraProvider) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/ScannerView21$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}