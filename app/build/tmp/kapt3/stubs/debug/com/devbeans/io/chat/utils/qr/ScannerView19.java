package com.devbeans.io.chat.utils.qr;

import java.lang.System;

/**
 * API19 version of QR scanning. Uses deprecated camera APIs.
 */
@android.annotation.SuppressLint(value = {"ViewConstructor"})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/ScannerView19;", "Landroid/widget/FrameLayout;", "Lcom/devbeans/io/chat/utils/qr/ScannerView;", "context", "Landroid/content/Context;", "scanListener", "Lcom/devbeans/io/chat/utils/qr/kitkat/ScanListener;", "(Landroid/content/Context;Lcom/devbeans/io/chat/utils/qr/kitkat/ScanListener;)V", "cameraView", "Lcom/devbeans/io/chat/utils/qr/kitkat/QrCameraView;", "scanningThread", "Lcom/devbeans/io/chat/utils/qr/kitkat/ScanningThread;", "start", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "app_debug"})
public final class ScannerView19 extends android.widget.FrameLayout implements com.devbeans.io.chat.utils.qr.ScannerView {
    private final com.devbeans.io.chat.utils.qr.kitkat.ScanListener scanListener = null;
    private com.devbeans.io.chat.utils.qr.kitkat.ScanningThread scanningThread;
    private final com.devbeans.io.chat.utils.qr.kitkat.QrCameraView cameraView = null;
    
    public ScannerView19(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.qr.kitkat.ScanListener scanListener) {
        super(null);
    }
    
    @java.lang.Override
    public void start(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
}