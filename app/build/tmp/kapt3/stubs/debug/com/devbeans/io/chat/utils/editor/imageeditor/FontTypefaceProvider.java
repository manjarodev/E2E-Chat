package com.devbeans.io.chat.utils.editor.imageeditor;

import java.lang.System;

/**
 * RenderContext TypefaceProvider that provides typefaces using TextFont.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/imageeditor/FontTypefaceProvider;", "Lcom/devbeans/io/chat/utils/RendererContext$TypefaceProvider;", "()V", "cachedLocale", "Ljava/util/Locale;", "cachedTypeface", "Landroid/graphics/Typeface;", "getSelectedTypeface", "context", "Landroid/content/Context;", "renderer", "Lcom/devbeans/io/chat/utils/Renderer;", "invalidate", "Lcom/devbeans/io/chat/utils/RendererContext$Invalidate;", "getTypeface", "app_debug"})
public final class FontTypefaceProvider implements com.devbeans.io.chat.utils.RendererContext.TypefaceProvider {
    private android.graphics.Typeface cachedTypeface;
    private java.util.Locale cachedLocale;
    
    public FontTypefaceProvider() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.graphics.Typeface getSelectedTypeface(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.Renderer renderer, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.RendererContext.Invalidate invalidate) {
        return null;
    }
    
    private final android.graphics.Typeface getTypeface() {
        return null;
    }
}