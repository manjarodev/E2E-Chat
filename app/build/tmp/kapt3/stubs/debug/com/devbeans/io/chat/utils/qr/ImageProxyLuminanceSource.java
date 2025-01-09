package com.devbeans.io.chat.utils.qr;

import java.lang.System;

/**
 * Luminance source that gets data via an [ImageProxy]. The main reason for this is because
 * the Y-Plane provided by the camera framework can have a row stride (number of bytes that make up a row)
 * that is different than the image width.
 *
 * An image width can be reported as 1080 but the row stride may be 1088. Thus when representing a row-major
 * 2D array as a 1D array, the math can go sideways if width is used instead of row stride.
 */
@androidx.annotation.RequiresApi(value = 21)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/ImageProxyLuminanceSource;", "Lcom/google/zxing/LuminanceSource;", "image", "Landroidx/camera/core/ImageProxy;", "(Landroidx/camera/core/ImageProxy;)V", "yData", "", "getYData", "()[B", "getMatrix", "getRow", "y", "", "row", "render", "", "app_debug"})
public final class ImageProxyLuminanceSource extends com.google.zxing.LuminanceSource {
    @org.jetbrains.annotations.NotNull
    private final byte[] yData = null;
    
    public ImageProxyLuminanceSource(@org.jetbrains.annotations.NotNull
    androidx.camera.core.ImageProxy image) {
        super(0, 0);
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getYData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public byte[] getRow(int y, @org.jetbrains.annotations.Nullable
    byte[] row) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public byte[] getMatrix() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final int[] render() {
        return null;
    }
}