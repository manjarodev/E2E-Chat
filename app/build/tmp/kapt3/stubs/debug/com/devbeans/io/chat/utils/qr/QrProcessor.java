package com.devbeans.io.chat.utils.qr;

import java.lang.System;

/**
 * Wraps [QRCodeReader] for use from API19 or API21+.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/QrProcessor;", "", "()V", "previousHeight", "", "previousWidth", "reader", "Lcom/google/zxing/qrcode/QRCodeReader;", "getScannedData", "", "proxy", "Landroidx/camera/core/ImageProxy;", "source", "Lcom/google/zxing/LuminanceSource;", "data", "", "width", "height", "Companion", "app_debug"})
public final class QrProcessor {
    private final com.google.zxing.qrcode.QRCodeReader reader = null;
    private int previousHeight = 0;
    private int previousWidth = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.qr.QrProcessor.Companion Companion = null;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.Nullable
    private static kotlin.jvm.functions.Function1<? super com.google.zxing.LuminanceSource, kotlin.Unit> listener;
    
    public QrProcessor() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.annotation.RequiresApi(value = 21)
    public final java.lang.String getScannedData(@org.jetbrains.annotations.NotNull
    androidx.camera.core.ImageProxy proxy) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getScannedData(@org.jetbrains.annotations.NotNull
    byte[] data, int width, int height) {
        return null;
    }
    
    private final java.lang.String getScannedData(com.google.zxing.LuminanceSource source) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/QrProcessor$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "listener", "Lkotlin/Function1;", "Lcom/google/zxing/LuminanceSource;", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final kotlin.jvm.functions.Function1<com.google.zxing.LuminanceSource, kotlin.Unit> getListener() {
            return null;
        }
        
        public final void setListener(@org.jetbrains.annotations.Nullable
        kotlin.jvm.functions.Function1<? super com.google.zxing.LuminanceSource, kotlin.Unit> p0) {
        }
    }
}