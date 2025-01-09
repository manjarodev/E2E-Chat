package com.devbeans.io.chat.utils.avatar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J$\u0010\u000e\u001a\u00020\u000f*\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/TextAvatarDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "avatar", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Text;", "inverted", "", "size", "", "synchronous", "(Landroid/content/Context;Lcom/devbeans/io/chat/utils/avatar/Avatar$Text;ZIZ)V", "textPaint", "Landroid/text/TextPaint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "getStartX", "", "layout", "Landroid/text/StaticLayout;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Landroid/text/Layout;", "x", "y", "app_debug"})
public final class TextAvatarDrawable extends android.graphics.drawable.Drawable {
    private final android.content.Context context = null;
    private final com.devbeans.io.chat.utils.avatar.Avatar.Text avatar = null;
    private final int size = 0;
    private final boolean synchronous = false;
    private final android.text.TextPaint textPaint = null;
    
    public TextAvatarDrawable(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.Avatar.Text avatar, boolean inverted, int size, boolean synchronous) {
        super();
    }
    
    @java.lang.Override
    public void draw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    private final float getStartX(android.text.StaticLayout layout) {
        return 0.0F;
    }
    
    @java.lang.Override
    public void setAlpha(int alpha) {
    }
    
    @java.lang.Override
    public void setColorFilter(@org.jetbrains.annotations.Nullable
    android.graphics.ColorFilter colorFilter) {
    }
    
    @java.lang.Override
    public int getOpacity() {
        return 0;
    }
    
    private final void draw(android.text.Layout $this$draw, android.graphics.Canvas canvas, float x, float y) {
    }
}