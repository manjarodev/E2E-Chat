package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\'\u0018\u0000 t2\u00020\u0001:\u0003tuvB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010=\u001a\u00020>H\u0002J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001b0@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J(\u0010B\u001a\u00020>2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010E\u001a\u00020>H\u0002J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001b0@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J(\u0010G\u001a\u00020>2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010H\u001a\u00020>H\u0002J\b\u0010I\u001a\u00020>H\u0002J\b\u0010J\u001a\u00020>H\u0002J\u000e\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020\"J\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u00020PJ\u0006\u0010R\u001a\u00020\"J\u0006\u0010S\u001a\u00020>J\u0006\u0010T\u001a\u00020>J\b\u0010U\u001a\u00020>H\u0002J\b\u0010V\u001a\u00020>H\u0002J\b\u0010W\u001a\u00020>H\u0002J\b\u0010X\u001a\u00020>H\u0002J\b\u0010Y\u001a\u00020>H\u0002J\b\u0010Z\u001a\u00020>H\u0002J\b\u0010[\u001a\u00020>H\u0002J\b\u0010\\\u001a\u00020>H\u0002J\u000e\u0010]\u001a\u00020>2\u0006\u0010^\u001a\u00020PJ\u000e\u0010_\u001a\u00020>2\u0006\u0010`\u001a\u00020*J\u000e\u0010a\u001a\u00020>2\u0006\u0010b\u001a\u00020PJ\u000e\u0010c\u001a\u00020>2\u0006\u0010d\u001a\u00020PJ\u0014\u0010e\u001a\u00020>2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020P0\bJ\u000e\u0010g\u001a\u00020>2\u0006\u0010h\u001a\u00020NJ\u0010\u0010i\u001a\u00020>2\b\u0010j\u001a\u0004\u0018\u00010,J\u000e\u0010k\u001a\u00020>2\u0006\u0010L\u001a\u00020\"J\u0018\u0010k\u001a\u00020>2\u0006\u0010L\u001a\u00020\"2\u0006\u0010l\u001a\u00020*H\u0002J\u000e\u0010m\u001a\u00020>2\u0006\u00108\u001a\u00020*J\u0006\u0010n\u001a\u00020>J\b\u0010o\u001a\u00020>H\u0003J\u0006\u0010p\u001a\u00020>J\u0006\u0010q\u001a\u00020>J\u000e\u0010r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010s\u001a\u00020>H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006w"}, d2 = {"Lcom/devbeans/io/chat/fragments/ImageEditorHudV2;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allModeTools", "", "Landroid/view/View;", "blurButton", "blurHelpText", "blurToast", "blurToggle", "Lcom/google/android/material/switchmaterial/SwitchMaterial;", "blurToggleContainer", "blurTools", "bottomGuideline", "Landroidx/constraintlayout/widget/Guideline;", "brushPreview", "Lcom/devbeans/io/chat/utils/views/BrushWidthPreviewView;", "brushToggle", "Landroid/widget/ImageView;", "cancelButton", "clearAllButton", "colorIndicator", "colorIndicatorAlphaAnimator", "Landroid/animation/Animator;", "cropAspectLockButton", "cropButtonRow", "cropFlipButton", "cropRotateButton", "cropTools", "currentMode", "Lcom/devbeans/io/chat/fragments/ImageEditorHudV2$Mode;", "doneButton", "drawButton", "drawButtonRow", "drawSeekBar", "Landroidx/appcompat/widget/AppCompatSeekBar;", "drawTools", "isAvatarEdit", "", "listener", "Lcom/devbeans/io/chat/fragments/ImageEditorHudV2$EventListener;", "modeAnimatorSet", "Landroid/animation/AnimatorSet;", "rotationDial", "Lcom/devbeans/io/chat/utils/views/RotationDialView;", "selectableSet", "stickerButton", "textButton", "textStyleToggle", "toastDebouncer", "Lcom/devbeans/io/chat/utils/Debouncer;", "undoAnimatorSet", "undoAvailability", "undoButton", "undoTools", "viewsToSlide", "widthSeekBar", "animateInUndoTools", "", "animateInViewSet", "", "viewSet", "animateModeChange", "inSet", "outSet", "animateOutUndoTools", "animateOutViewSet", "animateUndoChange", "animateWidthSeekbarIn", "animateWidthSeekbarOut", "clearSelection", "enterMode", "mode", "getActiveBrushWidth", "", "getActiveColor", "", "getColorIndex", "getMode", "hideBlurToast", "initializeViews", "presentModeBlur", "presentModeCrop", "presentModeDelete", "presentModeDraw", "presentModeHighlight", "presentModeMoveSticker", "presentModeNone", "presentModeText", "setActiveColor", "color", "setBlurFacesToggleEnabled", "enabled", "setBottomOfImageEditorView", "bottom", "setColorIndex", "index", "setColorPalette", "colors", "setDialRotation", "degrees", "setEventListener", "eventListener", "setMode", "notify", "setUndoAvailability", "setUpForAvatarEditing", "setupWidthSeekBar", "showBlurHudTooltip", "showBlurToast", "undoToolsIfAvailable", "updateColorIndicator", "Companion", "EventListener", "Mode", "app_debug"})
public final class ImageEditorHudV2 extends android.widget.FrameLayout {
    private com.devbeans.io.chat.fragments.ImageEditorHudV2.EventListener listener;
    private com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode currentMode = com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode.NONE;
    private boolean undoAvailability = false;
    private boolean isAvatarEdit = false;
    private final android.view.View undoButton = null;
    private final android.view.View clearAllButton = null;
    private final android.view.View cancelButton = null;
    private final android.view.View drawButton = null;
    private final android.view.View textButton = null;
    private final android.view.View stickerButton = null;
    private final android.view.View blurButton = null;
    private final android.view.View doneButton = null;
    private final androidx.appcompat.widget.AppCompatSeekBar drawSeekBar = null;
    private final android.widget.ImageView brushToggle = null;
    private final androidx.appcompat.widget.AppCompatSeekBar widthSeekBar = null;
    private final android.view.View cropRotateButton = null;
    private final android.view.View cropFlipButton = null;
    private final android.widget.ImageView cropAspectLockButton = null;
    private final android.view.View blurToggleContainer = null;
    private final com.google.android.material.switchmaterial.SwitchMaterial blurToggle = null;
    private final android.view.View blurToast = null;
    private final android.view.View blurHelpText = null;
    private final android.widget.ImageView colorIndicator = null;
    private final androidx.constraintlayout.widget.Guideline bottomGuideline = null;
    private final com.devbeans.io.chat.utils.views.BrushWidthPreviewView brushPreview = null;
    private final android.widget.ImageView textStyleToggle = null;
    private final com.devbeans.io.chat.utils.views.RotationDialView rotationDial = null;
    private final java.util.Set<android.view.View> selectableSet = null;
    private final java.util.Set<android.view.View> undoTools = null;
    private final java.util.Set<android.view.View> drawTools = null;
    private final java.util.Set<android.view.View> blurTools = null;
    private final java.util.Set<android.view.View> cropTools = null;
    private final java.util.Set<android.view.View> drawButtonRow = null;
    private final java.util.Set<android.view.View> cropButtonRow = null;
    private final java.util.Set<android.view.View> allModeTools = null;
    private final java.util.Set<android.view.View> viewsToSlide = null;
    private final com.devbeans.io.chat.utils.Debouncer toastDebouncer = null;
    private android.animation.Animator colorIndicatorAlphaAnimator;
    private android.animation.AnimatorSet modeAnimatorSet;
    private android.animation.AnimatorSet undoAnimatorSet;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.ImageEditorHudV2.Companion Companion = null;
    private static final long ANIMATION_DURATION = 250L;
    private static final java.util.Map<com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode, kotlin.Pair<java.lang.Float, java.lang.Float>> DRAW_WIDTH_BOUNDARIES = null;
    
    @kotlin.jvm.JvmOverloads
    public ImageEditorHudV2(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public ImageEditorHudV2(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final void initializeViews() {
    }
    
    public final void setDialRotation(float degrees) {
    }
    
    public final void setBottomOfImageEditorView(int bottom) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void setupWidthSeekBar() {
    }
    
    private final void animateWidthSeekbarIn() {
    }
    
    private final void animateWidthSeekbarOut() {
    }
    
    public final void setUpForAvatarEditing() {
    }
    
    public final void setColorPalette(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.Integer> colors) {
    }
    
    public final int getActiveColor() {
        return 0;
    }
    
    public final int getColorIndex() {
        return 0;
    }
    
    public final void setColorIndex(int index) {
    }
    
    public final void setActiveColor(int color) {
    }
    
    public final float getActiveBrushWidth() {
        return 0.0F;
    }
    
    public final void setBlurFacesToggleEnabled(boolean enabled) {
    }
    
    public final void showBlurHudTooltip() {
    }
    
    public final void showBlurToast() {
    }
    
    public final void hideBlurToast() {
    }
    
    public final void setEventListener(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.fragments.ImageEditorHudV2.EventListener eventListener) {
    }
    
    public final void enterMode(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode mode) {
    }
    
    public final void setMode(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode mode) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode getMode() {
        return null;
    }
    
    public final void setUndoAvailability(boolean undoAvailability) {
    }
    
    private final void setMode(com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode mode, boolean notify) {
    }
    
    private final void presentModeNone() {
    }
    
    private final void presentModeCrop() {
    }
    
    private final void presentModeDraw() {
    }
    
    private final void presentModeHighlight() {
    }
    
    private final void presentModeBlur() {
    }
    
    private final void presentModeText() {
    }
    
    private final void presentModeMoveSticker() {
    }
    
    private final void presentModeDelete() {
    }
    
    private final void clearSelection() {
    }
    
    private final void updateColorIndicator() {
    }
    
    private final void animateModeChange(java.util.Set<? extends android.view.View> inSet, java.util.Set<? extends android.view.View> outSet) {
    }
    
    private final void animateUndoChange(java.util.Set<? extends android.view.View> inSet, java.util.Set<? extends android.view.View> outSet) {
    }
    
    private final java.util.List<android.animation.Animator> animateInViewSet(java.util.Set<? extends android.view.View> viewSet) {
        return null;
    }
    
    private final java.util.List<android.animation.Animator> animateOutViewSet(java.util.Set<? extends android.view.View> viewSet) {
        return null;
    }
    
    private final void animateInUndoTools() {
    }
    
    private final void animateOutUndoTools() {
    }
    
    private final java.util.Set<android.view.View> undoToolsIfAvailable() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/fragments/ImageEditorHudV2$Mode;", "", "(Ljava/lang/String;I)V", "NONE", "CROP", "TEXT", "DRAW", "HIGHLIGHT", "BLUR", "MOVE_STICKER", "MOVE_TEXT", "DELETE", "INSERT_STICKER", "app_debug"})
    public static enum Mode {
        /*public static final*/ NONE /* = new NONE() */,
        /*public static final*/ CROP /* = new CROP() */,
        /*public static final*/ TEXT /* = new TEXT() */,
        /*public static final*/ DRAW /* = new DRAW() */,
        /*public static final*/ HIGHLIGHT /* = new HIGHLIGHT() */,
        /*public static final*/ BLUR /* = new BLUR() */,
        /*public static final*/ MOVE_STICKER /* = new MOVE_STICKER() */,
        /*public static final*/ MOVE_TEXT /* = new MOVE_TEXT() */,
        /*public static final*/ DELETE /* = new DELETE() */,
        /*public static final*/ INSERT_STICKER /* = new INSERT_STICKER() */;
        
        Mode() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\u0006H&J\b\u0010\u0016\u001a\u00020\u0006H&J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0006H&J\b\u0010\u001f\u001a\u00020\u0006H&J\b\u0010 \u001a\u00020\u0006H&J\b\u0010!\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\""}, d2 = {"Lcom/devbeans/io/chat/fragments/ImageEditorHudV2$EventListener;", "", "isCropAspectLocked", "", "()Z", "onBlurFacesToggled", "", "enabled", "onBrushWidthChange", "onCancel", "onClearAll", "onColorChange", "color", "", "onCropAspectLock", "onDelete", "onDialRotationChanged", "degrees", "", "onDialRotationGestureFinished", "onDialRotationGestureStarted", "onDone", "onFlipHorizontal", "onModeStarted", "mode", "Lcom/devbeans/io/chat/fragments/ImageEditorHudV2$Mode;", "previousMode", "onRequestFullScreen", "fullScreen", "hideKeyboard", "onRotate90AntiClockwise", "onSave", "onTextStyleToggle", "onUndo", "app_debug"})
    public static abstract interface EventListener {
        
        public abstract void onModeStarted(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode mode, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.fragments.ImageEditorHudV2.Mode previousMode);
        
        public abstract void onColorChange(int color);
        
        public abstract void onBrushWidthChange();
        
        public abstract void onBlurFacesToggled(boolean enabled);
        
        public abstract void onUndo();
        
        public abstract void onClearAll();
        
        public abstract void onDelete();
        
        public abstract void onSave();
        
        public abstract void onFlipHorizontal();
        
        public abstract void onRotate90AntiClockwise();
        
        public abstract void onCropAspectLock();
        
        public abstract void onTextStyleToggle();
        
        public abstract void onDialRotationGestureStarted();
        
        public abstract void onDialRotationChanged(float degrees);
        
        public abstract void onDialRotationGestureFinished();
        
        public abstract boolean isCropAspectLocked();
        
        public abstract void onRequestFullScreen(boolean fullScreen, boolean hideKeyboard);
        
        public abstract void onDone();
        
        public abstract void onCancel();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/fragments/ImageEditorHudV2$Companion;", "", "()V", "ANIMATION_DURATION", "", "DRAW_WIDTH_BOUNDARIES", "", "Lcom/devbeans/io/chat/fragments/ImageEditorHudV2$Mode;", "Lkotlin/Pair;", "", "withHighlighterAlpha", "", "color", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final int withHighlighterAlpha(int color) {
            return 0;
        }
    }
}