package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001fR\u001c\u00104\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u0019R\u001c\u00107\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001d\"\u0004\b9\u0010\u001f\u00a8\u0006>"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/OutgoingVideoMessageViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$OutcomingImageMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "backgroundLayout", "Landroid/widget/RelativeLayout;", "getBackgroundLayout", "()Landroid/widget/RelativeLayout;", "setBackgroundLayout", "(Landroid/widget/RelativeLayout;)V", "bubbleView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBubbleView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBubbleView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "disappearIcon", "Landroid/widget/ImageView;", "getDisappearIcon", "()Landroid/widget/ImageView;", "setDisappearIcon", "(Landroid/widget/ImageView;)V", "duration", "Landroid/widget/TextView;", "getDuration", "()Landroid/widget/TextView;", "setDuration", "(Landroid/widget/TextView;)V", "forwardLayout", "Landroid/widget/LinearLayout;", "getForwardLayout", "()Landroid/widget/LinearLayout;", "setForwardLayout", "(Landroid/widget/LinearLayout;)V", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "getImageView", "()Lcom/google/android/material/imageview/ShapeableImageView;", "setImageView", "(Lcom/google/android/material/imageview/ShapeableImageView;)V", "messages", "getMessages", "()Lcom/devbeans/io/chat/models/Messages;", "setMessages", "(Lcom/devbeans/io/chat/models/Messages;)V", "name", "getName", "setName", "tick", "getTick", "setTick", "time", "getTime", "setTime", "init", "", "onBind", "message", "app_debug"})
public final class OutgoingVideoMessageViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.OutcomingImageMessageViewHolder<com.devbeans.io.chat.models.Messages> {
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.imageview.ShapeableImageView imageView;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView tick;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView disappearIcon;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView time;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView duration;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView name;
    @org.jetbrains.annotations.Nullable
    private android.widget.RelativeLayout backgroundLayout;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages messages;
    @org.jetbrains.annotations.Nullable
    private androidx.constraintlayout.widget.ConstraintLayout bubbleView;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout forwardLayout;
    
    public OutgoingVideoMessageViewHolder(@org.jetbrains.annotations.NotNull
    android.view.View itemView, @org.jetbrains.annotations.Nullable
    java.lang.Object payload) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.imageview.ShapeableImageView getImageView() {
        return null;
    }
    
    public final void setImageView(@org.jetbrains.annotations.Nullable
    com.google.android.material.imageview.ShapeableImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getTick() {
        return null;
    }
    
    public final void setTick(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getDisappearIcon() {
        return null;
    }
    
    public final void setDisappearIcon(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getDuration() {
        return null;
    }
    
    public final void setDuration(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.RelativeLayout getBackgroundLayout() {
        return null;
    }
    
    public final void setBackgroundLayout(@org.jetbrains.annotations.Nullable
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Messages getMessages() {
        return null;
    }
    
    public final void setMessages(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Messages p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.constraintlayout.widget.ConstraintLayout getBubbleView() {
        return null;
    }
    
    public final void setBubbleView(@org.jetbrains.annotations.Nullable
    androidx.constraintlayout.widget.ConstraintLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.LinearLayout getForwardLayout() {
        return null;
    }
    
    public final void setForwardLayout(@org.jetbrains.annotations.Nullable
    android.widget.LinearLayout p0) {
    }
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void init(android.view.View itemView) {
    }
}