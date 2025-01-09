package com.devbeans.io.chat.utils.editor;

import java.lang.System;

/**
 * One stop shop to turn an AppCompatSeekBar into an HSV Color Slider.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0016\u001a\u00020\u0004H\u0007J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\f\u0010\u001c\u001a\u00020\u0013*\u00020\u0013H\u0002J\n\u0010\u001d\u001a\u00020\u0004*\u00020\u001eJ\u0012\u0010\u001f\u001a\u00020 *\u00020\u001e2\u0006\u0010!\u001a\u00020\u0004JD\u0010\"\u001a\u00020 *\u00020\u001e2\b\b\u0001\u0010#\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 0%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020 0\'J\u0014\u0010)\u001a\u00020\u000b*\u00020*2\u0006\u0010+\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/HSVColorSlider;", "", "()V", "BLACK_DIVISIONS", "", "COLOR_DIVISIONS", "EVALUATOR", "Landroid/animation/FloatEvaluator;", "MAX_HUE", "MAX_SEEK_DIVISIONS", "STANDARD_LIGHTNESS", "", "WHITE_DIVISIONS", "colors", "", "calculateLightness", "hue", "valueFor60To80", "createColorProgressDrawable", "Landroid/graphics/drawable/Drawable;", "createThumbDrawable", "borderColor", "getLastColor", "interpolate", "point1", "Landroid/graphics/PointF;", "point2", "x", "forSeekBar", "getColor", "Landroidx/appcompat/widget/AppCompatSeekBar;", "setColor", "", "color", "setUpForColor", "thumbBorderColor", "onColorChanged", "Lkotlin/Function1;", "onDragStart", "Lkotlin/Function0;", "onDragEnd", "toHue", "", "max", "ThumbDrawable", "app_debug"})
public final class HSVColorSlider {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.editor.HSVColorSlider INSTANCE = null;
    private static final int MAX_HUE = 360;
    private static final int COLOR_DIVISIONS = 1023;
    private static final int BLACK_DIVISIONS = 175;
    private static final int WHITE_DIVISIONS = 125;
    private static final int MAX_SEEK_DIVISIONS = 1323;
    private static final float STANDARD_LIGHTNESS = 0.4F;
    private static final android.animation.FloatEvaluator EVALUATOR = null;
    private static final int[] colors = null;
    
    private HSVColorSlider() {
        super();
    }
    
    @androidx.annotation.ColorInt
    public final int getLastColor() {
        return 0;
    }
    
    public final int getColor(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatSeekBar $this$getColor) {
        return 0;
    }
    
    public final void setColor(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatSeekBar $this$setColor, int color) {
    }
    
    public final void setUpForColor(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatSeekBar $this$setUpForColor, @androidx.annotation.ColorInt
    int thumbBorderColor, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onColorChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDragStart, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDragEnd) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.drawable.Drawable createThumbDrawable(@androidx.annotation.ColorInt
    int borderColor) {
        return null;
    }
    
    private final android.graphics.drawable.Drawable createColorProgressDrawable() {
        return null;
    }
    
    private final float calculateLightness(float hue, float valueFor60To80) {
        return 0.0F;
    }
    
    private final float interpolate(android.graphics.PointF point1, android.graphics.PointF point2, float x) {
        return 0.0F;
    }
    
    private final float toHue(java.lang.Number $this$toHue, java.lang.Number max) {
        return 0.0F;
    }
    
    private final android.graphics.drawable.Drawable forSeekBar(android.graphics.drawable.Drawable $this$forSeekBar) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\b\b\u0001\u0010\u0018\u001a\u00020\u0003J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/HSVColorSlider$ThumbDrawable;", "Landroid/graphics/drawable/Drawable;", "borderColor", "", "(I)V", "borderPaint", "Landroid/graphics/Paint;", "borderWidth", "innerRadius", "", "paint", "thumbInnerSize", "thumbRadius", "thumbSize", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "setAlpha", "alpha", "setColor", "color", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Companion", "app_debug"})
    static final class ThumbDrawable extends android.graphics.drawable.Drawable {
        private final android.graphics.Paint borderPaint = null;
        private final android.graphics.Paint paint = null;
        private final int borderWidth = 0;
        private final int thumbInnerSize = 0;
        private final float innerRadius = 0.0F;
        private final float thumbSize = 0.0F;
        private final float thumbRadius = 0.0F;
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.editor.HSVColorSlider.ThumbDrawable.Companion Companion = null;
        @androidx.annotation.Dimension(unit = androidx.annotation.Dimension.DP)
        private static final int THUMB_INNER_SIZE = 8;
        @androidx.annotation.Dimension(unit = androidx.annotation.Dimension.DP)
        private static final int THUMB_MARGIN = 24;
        
        public ThumbDrawable(@androidx.annotation.ColorInt
        int borderColor) {
            super();
        }
        
        @java.lang.Override
        public int getIntrinsicHeight() {
            return 0;
        }
        
        @java.lang.Override
        public int getIntrinsicWidth() {
            return 0;
        }
        
        public final void setColor(@androidx.annotation.ColorInt
        int color) {
        }
        
        @java.lang.Override
        public void draw(@org.jetbrains.annotations.NotNull
        android.graphics.Canvas canvas) {
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
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/HSVColorSlider$ThumbDrawable$Companion;", "", "()V", "THUMB_INNER_SIZE", "", "THUMB_MARGIN", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}