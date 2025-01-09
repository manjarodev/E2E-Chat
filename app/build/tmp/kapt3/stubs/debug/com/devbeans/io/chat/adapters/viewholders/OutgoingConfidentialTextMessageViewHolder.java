package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0002H\u0002J\u0010\u0010Q\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010R\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001c\u0010,\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001c\u0010/\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0019\u00104\u001a\n 6*\u0004\u0018\u00010505\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\u001c\u0010<\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010&\"\u0004\b>\u0010(R\u001c\u0010?\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R\u001c\u0010B\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0017\"\u0004\bD\u0010\u0019R\u001c\u0010E\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001d\"\u0004\bG\u0010\u001fR\u001c\u0010H\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001d\"\u0004\bJ\u0010\u001fR\u001c\u0010K\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u0019\u00a8\u0006S"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/OutgoingConfidentialTextMessageViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$OutcomingTextMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "backgroundLayout", "Landroid/widget/RelativeLayout;", "getBackgroundLayout", "()Landroid/widget/RelativeLayout;", "setBackgroundLayout", "(Landroid/widget/RelativeLayout;)V", "bubbleView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBubbleView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBubbleView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "disappearIcon", "Landroid/widget/ImageView;", "getDisappearIcon", "()Landroid/widget/ImageView;", "setDisappearIcon", "(Landroid/widget/ImageView;)V", "edited", "Landroid/widget/TextView;", "getEdited", "()Landroid/widget/TextView;", "setEdited", "(Landroid/widget/TextView;)V", "editedCon", "getEditedCon", "setEditedCon", "forwardLayout", "Landroid/widget/LinearLayout;", "getForwardLayout", "()Landroid/widget/LinearLayout;", "setForwardLayout", "(Landroid/widget/LinearLayout;)V", "messageText", "getMessageText", "setMessageText", "messageTextCon", "getMessageTextCon", "setMessageTextCon", "messages", "getMessages", "()Lcom/devbeans/io/chat/models/Messages;", "setMessages", "(Lcom/devbeans/io/chat/models/Messages;)V", "tag", "", "kotlin.jvm.PlatformType", "getTag", "()Ljava/lang/String;", "textTimeAndTickLayout", "getTextTimeAndTickLayout", "setTextTimeAndTickLayout", "textTimeAndTickLayoutCon", "getTextTimeAndTickLayoutCon", "setTextTimeAndTickLayoutCon", "tick", "getTick", "setTick", "tickCon", "getTickCon", "setTickCon", "tvTime", "getTvTime", "setTvTime", "tvTimeCon", "getTvTimeCon", "setTvTimeCon", "viewOnceIcon", "getViewOnceIcon", "setViewOnceIcon", "handleTicks", "", "message", "init", "onBind", "app_debug"})
public final class OutgoingConfidentialTextMessageViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.OutcomingTextMessageViewHolder<com.devbeans.io.chat.models.Messages> {
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView tvTime;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView edited;
    private final java.lang.String tag = null;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView messageText;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView tick;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView disappearIcon;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView viewOnceIcon;
    @org.jetbrains.annotations.Nullable
    private android.widget.RelativeLayout backgroundLayout;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages messages;
    @org.jetbrains.annotations.Nullable
    private androidx.constraintlayout.widget.ConstraintLayout bubbleView;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout forwardLayout;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout textTimeAndTickLayout;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView tvTimeCon;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView messageTextCon;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView editedCon;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView tickCon;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout textTimeAndTickLayoutCon;
    
    public OutgoingConfidentialTextMessageViewHolder(@org.jetbrains.annotations.NotNull
    android.view.View itemView, @org.jetbrains.annotations.Nullable
    java.lang.Object payload) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTvTime() {
        return null;
    }
    
    public final void setTvTime(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getEdited() {
        return null;
    }
    
    public final void setEdited(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    public final java.lang.String getTag() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getMessageText() {
        return null;
    }
    
    public final void setMessageText(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
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
    public final android.widget.ImageView getViewOnceIcon() {
        return null;
    }
    
    public final void setViewOnceIcon(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
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
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.LinearLayout getTextTimeAndTickLayout() {
        return null;
    }
    
    public final void setTextTimeAndTickLayout(@org.jetbrains.annotations.Nullable
    android.widget.LinearLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTvTimeCon() {
        return null;
    }
    
    public final void setTvTimeCon(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getMessageTextCon() {
        return null;
    }
    
    public final void setMessageTextCon(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getEditedCon() {
        return null;
    }
    
    public final void setEditedCon(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getTickCon() {
        return null;
    }
    
    public final void setTickCon(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.LinearLayout getTextTimeAndTickLayoutCon() {
        return null;
    }
    
    public final void setTextTimeAndTickLayoutCon(@org.jetbrains.annotations.Nullable
    android.widget.LinearLayout p0) {
    }
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleTicks(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void init(android.view.View itemView) {
    }
}