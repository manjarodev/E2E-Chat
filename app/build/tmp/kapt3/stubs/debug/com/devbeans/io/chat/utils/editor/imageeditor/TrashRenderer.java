package com.devbeans.io.chat.utils.editor.imageeditor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001*B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u001aJ\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/imageeditor/TrashRenderer;", "Lcom/devbeans/io/chat/utils/editor/InvalidateableRenderer;", "Lcom/devbeans/io/chat/utils/Renderer;", "Landroid/os/Parcelable;", "()V", "bounds", "Landroid/graphics/RectF;", "buttonCenter", "", "diameterLarge", "", "diameterSmall", "interpolator", "Landroid/view/animation/Interpolator;", "isExpanding", "", "outlinePaint", "Landroid/graphics/Paint;", "padBottom", "shadePaint", "startTime", "", "trashSize", "", "describeContents", "expand", "", "getInterpolatedDiameter", "timeElapsed", "hitTest", "x", "y", "interpolateFromFraction", "fraction", "render", "rendererContext", "Lcom/devbeans/io/chat/utils/RendererContext;", "shrink", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "Companion", "app_debug"})
public final class TrashRenderer extends com.devbeans.io.chat.utils.editor.InvalidateableRenderer implements com.devbeans.io.chat.utils.Renderer, android.os.Parcelable {
    private final android.graphics.Paint outlinePaint = null;
    private final android.graphics.Paint shadePaint = null;
    private final android.graphics.RectF bounds = null;
    private final float diameterSmall = 0.0F;
    private final float diameterLarge = 0.0F;
    private final int trashSize = 0;
    private final float padBottom = 0.0F;
    private final android.view.animation.Interpolator interpolator = null;
    private long startTime = 0L;
    private boolean isExpanding = false;
    private final float[] buttonCenter = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.editor.imageeditor.TrashRenderer.Companion Companion = null;
    private static final long DURATION = 150L;
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmField
    public static final android.os.Parcelable.Creator<com.devbeans.io.chat.utils.editor.imageeditor.TrashRenderer> CREATOR = null;
    
    public TrashRenderer() {
        super();
    }
    
    @java.lang.Override
    public void render(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.RendererContext rendererContext) {
    }
    
    private final float getInterpolatedDiameter(long timeElapsed) {
        return 0.0F;
    }
    
    private final float interpolateFromFraction(float fraction) {
        return 0.0F;
    }
    
    public final void expand() {
    }
    
    public final void shrink() {
    }
    
    @java.lang.Override
    public boolean hitTest(float x, float y) {
        return false;
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel dest, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/imageeditor/TrashRenderer$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/devbeans/io/chat/utils/editor/imageeditor/TrashRenderer;", "DURATION", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}