package com.devbeans.io.chat.utils.editor;

import java.lang.System;

/**
 * Class which wraps a given drawable to perform some custom drawing / masking / whatever.
 *
 * We extend LayerDrawable here to take advantage of it's overrides and mechanisms, but explicitly
 * abstract out the draw method to allow overrides to do whatever they want.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R>\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/CustomDrawWrapper;", "Landroid/graphics/drawable/LayerDrawable;", "wrapped", "Landroid/graphics/drawable/Drawable;", "drawFn", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/graphics/Canvas;", "canvas", "", "(Landroid/graphics/drawable/Drawable;Lkotlin/jvm/functions/Function2;)V", "draw", "app_debug"})
final class CustomDrawWrapper extends android.graphics.drawable.LayerDrawable {
    private final android.graphics.drawable.Drawable wrapped = null;
    private final kotlin.jvm.functions.Function2<android.graphics.drawable.Drawable, android.graphics.Canvas, kotlin.Unit> drawFn = null;
    
    public CustomDrawWrapper(@org.jetbrains.annotations.NotNull
    android.graphics.drawable.Drawable wrapped, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super android.graphics.drawable.Drawable, ? super android.graphics.Canvas, kotlin.Unit> drawFn) {
        super(null);
    }
    
    @java.lang.Override
    public void draw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
}