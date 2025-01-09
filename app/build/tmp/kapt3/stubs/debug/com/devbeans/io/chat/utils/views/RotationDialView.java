package com.devbeans.io.chat.utils.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0005+,-./B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0017J\u000e\u0010*\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/devbeans/io/chat/utils/views/RotationDialView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "angleIndicatorPaint", "Landroid/graphics/Paint;", "canvasBounds", "Landroid/graphics/Rect;", "centerMostIndicatorRect", "Landroid/graphics/RectF;", "degrees", "", "dimensions", "Lcom/devbeans/io/chat/utils/views/RotationDialView$Dimensions;", "gestureDetector", "Landroid/view/GestureDetector;", "indicatorRect", "isInGesture", "", "listener", "Lcom/devbeans/io/chat/utils/views/RotationDialView$Listener;", "getListener", "()Lcom/devbeans/io/chat/utils/views/RotationDialView$Listener;", "setListener", "(Lcom/devbeans/io/chat/utils/views/RotationDialView$Listener;)V", "snapDegrees", "textPaint", "calculateSnapDegrees", "drawText", "", "canvas", "Landroid/graphics/Canvas;", "getDialDegrees", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDegrees", "Colors", "Companion", "Dimensions", "GestureListener", "Listener", "app_debug"})
public final class RotationDialView extends android.view.View {
    private final android.graphics.Rect canvasBounds = null;
    private final android.graphics.RectF centerMostIndicatorRect = null;
    private final android.graphics.RectF indicatorRect = null;
    private final com.devbeans.io.chat.utils.views.RotationDialView.Dimensions dimensions = null;
    private float snapDegrees = 0.0F;
    private float degrees = 0.0F;
    private boolean isInGesture = false;
    private final android.view.GestureDetector gestureDetector = null;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.utils.views.RotationDialView.Listener listener;
    private final android.graphics.Paint textPaint = null;
    private final android.graphics.Paint angleIndicatorPaint = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.views.RotationDialView.Companion Companion = null;
    private static final float MAX_DEGREES = 44.99999F;
    private static final float MIN_DEGRESS = -44.99999F;
    
    @kotlin.jvm.JvmOverloads
    public RotationDialView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public RotationDialView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public RotationDialView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.utils.views.RotationDialView.Listener getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.views.RotationDialView.Listener p0) {
    }
    
    public final void setDegrees(float degrees) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull
    android.view.MotionEvent event) {
        return false;
    }
    
    @java.lang.Override
    protected void onDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    private final void drawText(android.graphics.Canvas canvas) {
    }
    
    private final float getDialDegrees(float degrees) {
        return 0.0F;
    }
    
    private final float calculateSnapDegrees() {
        return 0.0F;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/utils/views/RotationDialView$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/devbeans/io/chat/utils/views/RotationDialView;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "app_debug"})
    final class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
        
        public GestureListener() {
            super();
        }
        
        @java.lang.Override
        public boolean onDown(@org.jetbrains.annotations.Nullable
        android.view.MotionEvent e) {
            return false;
        }
        
        @java.lang.Override
        public boolean onScroll(@org.jetbrains.annotations.Nullable
        android.view.MotionEvent e1, @org.jetbrains.annotations.Nullable
        android.view.MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004R\u0018\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\b\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\b\n\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\b\r\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\b\u0010\u001a\u0004\b\u000f\u0010\u0006R\u0018\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\b\u0013\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/devbeans/io/chat/utils/views/RotationDialView$Dimensions;", "", "()V", "angleIndicatorWidth", "", "getAngleIndicatorWidth", "()I", "angleIndicatorWidth$1", "majorAngleIndicatorHeight", "getMajorAngleIndicatorHeight", "majorAngleIndicatorHeight$1", "minorAngleIndicatorHeight", "getMinorAngleIndicatorHeight", "minorAngleIndicatorHeight$1", "spaceBetweenAngleIndicators", "getSpaceBetweenAngleIndicators", "spaceBetweenAngleIndicators$1", "textPaddingBottom", "getTextPaddingBottom", "textPaddingBottom$1", "getHeightForDegree", "degree", "Companion", "app_debug"})
    static final class Dimensions {
        @androidx.annotation.Px
        private final int spaceBetweenAngleIndicators$1 = 0;
        @androidx.annotation.Px
        private final int angleIndicatorWidth$1 = 0;
        @androidx.annotation.Px
        private final int minorAngleIndicatorHeight$1 = 0;
        @androidx.annotation.Px
        private final int majorAngleIndicatorHeight$1 = 0;
        @androidx.annotation.Px
        private final int textPaddingBottom$1 = 0;
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.views.RotationDialView.Dimensions.Companion Companion = null;
        @androidx.annotation.Dimension(unit = androidx.annotation.Dimension.DP)
        private static final int spaceBetweenAngleIndicators = 12;
        @androidx.annotation.Dimension(unit = androidx.annotation.Dimension.DP)
        private static final int angleIndicatorWidth = 1;
        @androidx.annotation.Dimension(unit = androidx.annotation.Dimension.DP)
        private static final int minorAngleIndicatorHeight = 12;
        @androidx.annotation.Dimension(unit = androidx.annotation.Dimension.DP)
        private static final int majorAngleIndicatorHeight = 32;
        @androidx.annotation.Dimension(unit = androidx.annotation.Dimension.DP)
        private static final int textPaddingBottom = 8;
        
        public Dimensions() {
            super();
        }
        
        public final int getSpaceBetweenAngleIndicators() {
            return 0;
        }
        
        public final int getAngleIndicatorWidth() {
            return 0;
        }
        
        public final int getMinorAngleIndicatorHeight() {
            return 0;
        }
        
        public final int getMajorAngleIndicatorHeight() {
            return 0;
        }
        
        public final int getTextPaddingBottom() {
            return 0;
        }
        
        public final int getHeightForDegree(int degree) {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/utils/views/RotationDialView$Dimensions$Companion;", "", "()V", "angleIndicatorWidth", "", "majorAngleIndicatorHeight", "minorAngleIndicatorHeight", "spaceBetweenAngleIndicators", "textPaddingBottom", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/devbeans/io/chat/utils/views/RotationDialView$Colors;", "", "()V", "majorAngleIndicatorColor", "", "getMajorAngleIndicatorColor", "()I", "minorAngleIndicatorColor", "getMinorAngleIndicatorColor", "modFiveIndicatorColor", "getModFiveIndicatorColor", "textColor", "getTextColor", "colorForCenterDegree", "degree", "colorForOtherDegree", "app_debug"})
    static final class Colors {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.views.RotationDialView.Colors INSTANCE = null;
        @androidx.annotation.ColorInt
        private static final int textColor = android.graphics.Color.WHITE;
        @androidx.annotation.ColorInt
        private static final int majorAngleIndicatorColor = -10295174;
        @androidx.annotation.ColorInt
        private static final int modFiveIndicatorColor = android.graphics.Color.WHITE;
        @androidx.annotation.ColorInt
        private static final int minorAngleIndicatorColor = -2130706433;
        
        private Colors() {
            super();
        }
        
        public final int getTextColor() {
            return 0;
        }
        
        public final int getMajorAngleIndicatorColor() {
            return 0;
        }
        
        public final int getModFiveIndicatorColor() {
            return 0;
        }
        
        public final int getMinorAngleIndicatorColor() {
            return 0;
        }
        
        public final int colorForCenterDegree(int degree) {
            return 0;
        }
        
        public final int colorForOtherDegree(int degree) {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/utils/views/RotationDialView$Listener;", "", "onDegreeChanged", "", "degrees", "", "onGestureEnd", "onGestureStart", "app_debug"})
    public static abstract interface Listener {
        
        public abstract void onDegreeChanged(float degrees);
        
        public abstract void onGestureStart();
        
        public abstract void onGestureEnd();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/views/RotationDialView$Companion;", "", "()V", "MAX_DEGREES", "", "MIN_DEGRESS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}