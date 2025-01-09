package com.devbeans.io.chat.models;

import java.lang.System;

/**
 * Contains information on a single selected conversation item. This is used when transitioning
 * between selected and unselected states.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010\'\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003Jg\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001J\u0013\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\nH\u00d6\u0001J\t\u0010-\u001a\u00020.H\u00d6\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019\u00a8\u0006/"}, d2 = {"Lcom/devbeans/io/chat/models/SelectedConversationModel;", "", "bitmap", "Landroid/graphics/Bitmap;", "itemX", "", "itemY", "bubbleX", "bubbleY", "bubbleWidth", "", "audioUri", "Landroid/net/Uri;", "isOutgoing", "", "focusedView", "Landroid/view/View;", "(Landroid/graphics/Bitmap;FFFFILandroid/net/Uri;ZLandroid/view/View;)V", "getAudioUri", "()Landroid/net/Uri;", "getBitmap", "()Landroid/graphics/Bitmap;", "getBubbleWidth", "()I", "getBubbleX", "()F", "getBubbleY", "getFocusedView", "()Landroid/view/View;", "()Z", "getItemX", "getItemY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class SelectedConversationModel {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "bitmap")
    private final android.graphics.Bitmap bitmap = null;
    @com.google.gson.annotations.SerializedName(value = "itemX")
    private final float itemX = 0.0F;
    @com.google.gson.annotations.SerializedName(value = "itemY")
    private final float itemY = 0.0F;
    @com.google.gson.annotations.SerializedName(value = "bubbleX")
    private final float bubbleX = 0.0F;
    @com.google.gson.annotations.SerializedName(value = "bubbleY")
    private final float bubbleY = 0.0F;
    @com.google.gson.annotations.SerializedName(value = "bubbleWidth")
    private final int bubbleWidth = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "audioUri")
    private final android.net.Uri audioUri = null;
    @com.google.gson.annotations.SerializedName(value = "isOutgoing")
    private final boolean isOutgoing = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "focusedView")
    private final android.view.View focusedView = null;
    
    /**
     * Contains information on a single selected conversation item. This is used when transitioning
     * between selected and unselected states.
     */
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.models.SelectedConversationModel copy(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap, float itemX, float itemY, float bubbleX, float bubbleY, int bubbleWidth, @org.jetbrains.annotations.Nullable
    android.net.Uri audioUri, boolean isOutgoing, @org.jetbrains.annotations.Nullable
    android.view.View focusedView) {
        return null;
    }
    
    /**
     * Contains information on a single selected conversation item. This is used when transitioning
     * between selected and unselected states.
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Contains information on a single selected conversation item. This is used when transitioning
     * between selected and unselected states.
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Contains information on a single selected conversation item. This is used when transitioning
     * between selected and unselected states.
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public SelectedConversationModel(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap, float itemX, float itemY, float bubbleX, float bubbleY, int bubbleWidth, @org.jetbrains.annotations.Nullable
    android.net.Uri audioUri, boolean isOutgoing, @org.jetbrains.annotations.Nullable
    android.view.View focusedView) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.Bitmap component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.Bitmap getBitmap() {
        return null;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    public final float getItemX() {
        return 0.0F;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final float getItemY() {
        return 0.0F;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    public final float getBubbleX() {
        return 0.0F;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    public final float getBubbleY() {
        return 0.0F;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getBubbleWidth() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.net.Uri component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.net.Uri getAudioUri() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isOutgoing() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.view.View component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.view.View getFocusedView() {
        return null;
    }
}