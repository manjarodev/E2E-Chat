package com.devbeans.io.chat.utils.qr;

import java.lang.System;

/**
 * View for starting up a camera and scanning a QR-Code. Safe to use on an API version and
 * will delegate to legacy camera APIs or CameraX APIs when appropriate.
 *
 * QR-code data is emitted via [qrData] observable.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/QrScannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qrData", "Lio/reactivex/rxjava3/core/Observable;", "", "getQrData", "()Lio/reactivex/rxjava3/core/Observable;", "qrDataPublish", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "scannerView", "Lcom/devbeans/io/chat/utils/qr/ScannerView;", "initScannerView", "", "forceLegacy", "", "start", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Companion", "app_debug"})
public final class QrScannerView extends android.widget.FrameLayout {
    private com.devbeans.io.chat.utils.qr.ScannerView scannerView;
    private final io.reactivex.rxjava3.subjects.PublishSubject<java.lang.String> qrDataPublish = null;
    @org.jetbrains.annotations.NotNull
    private final io.reactivex.rxjava3.core.Observable<java.lang.String> qrData = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.qr.QrScannerView.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    @kotlin.jvm.JvmOverloads
    public QrScannerView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public QrScannerView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public QrScannerView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.rxjava3.core.Observable<java.lang.String> getQrData() {
        return null;
    }
    
    private final void initScannerView(boolean forceLegacy) {
    }
    
    @kotlin.jvm.JvmOverloads
    public final void start(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
    
    @kotlin.jvm.JvmOverloads
    public final void start(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner lifecycleOwner, boolean forceLegacy) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/QrScannerView$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}