package com.devbeans.io.chat.utils.editor.imageeditor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/imageeditor/SelectedElementGuideRenderer;", "Lcom/devbeans/io/chat/utils/Renderer;", "()V", "allPointsInLocalCords", "", "allPointsOnScreen", "circlePaint", "Landroid/graphics/Paint;", "circleRadius", "", "guidePaint", "path", "Landroid/graphics/Path;", "describeContents", "", "hitTest", "", "x", "y", "performRender", "", "rendererContext", "Lcom/devbeans/io/chat/utils/RendererContext;", "render", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "app_debug"})
public final class SelectedElementGuideRenderer implements com.devbeans.io.chat.utils.Renderer {
    private final float[] allPointsOnScreen = null;
    private final float[] allPointsInLocalCords = {com.devbeans.io.chat.utils.views.Bounds.LEFT, com.devbeans.io.chat.utils.views.Bounds.TOP, com.devbeans.io.chat.utils.views.Bounds.RIGHT, com.devbeans.io.chat.utils.views.Bounds.TOP, com.devbeans.io.chat.utils.views.Bounds.RIGHT, com.devbeans.io.chat.utils.views.Bounds.BOTTOM, com.devbeans.io.chat.utils.views.Bounds.LEFT, com.devbeans.io.chat.utils.views.Bounds.BOTTOM};
    private final float circleRadius = 0.0F;
    private final android.graphics.Paint guidePaint = null;
    private final android.graphics.Paint circlePaint = null;
    private final android.graphics.Path path = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.editor.imageeditor.SelectedElementGuideRenderer.CREATOR CREATOR = null;
    
    public SelectedElementGuideRenderer() {
        super();
    }
    
    /**
     * Draw self to the context.
     *
     * @param rendererContext The context to draw to.
     */
    @java.lang.Override
    public void render(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.RendererContext rendererContext) {
    }
    
    @java.lang.Override
    public boolean hitTest(float x, float y) {
        return false;
    }
    
    private final void performRender(com.devbeans.io.chat.utils.RendererContext rendererContext) {
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/imageeditor/SelectedElementGuideRenderer$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/devbeans/io/chat/utils/editor/imageeditor/SelectedElementGuideRenderer;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/devbeans/io/chat/utils/editor/imageeditor/SelectedElementGuideRenderer;", "app_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.devbeans.io.chat.utils.editor.imageeditor.SelectedElementGuideRenderer> {
        
        private CREATOR() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.utils.editor.imageeditor.SelectedElementGuideRenderer createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.utils.editor.imageeditor.SelectedElementGuideRenderer[] newArray(int size) {
            return null;
        }
    }
}