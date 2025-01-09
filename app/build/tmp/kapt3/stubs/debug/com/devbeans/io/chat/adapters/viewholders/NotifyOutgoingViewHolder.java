package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0002H\u0002J$\u00108\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010;\u001a\u0004\u0018\u00010\t2\b\u0010<\u001a\u0004\u0018\u00010\t2\u0006\u00107\u001a\u00020\u0002H\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\t2\u0006\u00105\u001a\u000206H\u0002J\u001c\u0010>\u001a\u0004\u0018\u00010\t2\u0006\u00107\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010?\u001a\u00020@2\u0006\u00107\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010A\u001a\u00020@2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010B\u001a\u00020@2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010C\u001a\u00020@2\u0006\u00107\u001a\u00020\u0002H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001c\u0010(\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010\'R\u001c\u0010+\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010\'R\u001c\u0010.\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010\'\u00a8\u0006D"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/NotifyOutgoingViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$OutcomingTextMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "action", "", "actionOn", "disappearTime", "disappearTimeInInt", "", "isContact", "", "()Z", "setContact", "(Z)V", "ivNotificationImage", "Landroid/widget/ImageView;", "getIvNotificationImage", "()Landroid/widget/ImageView;", "setIvNotificationImage", "(Landroid/widget/ImageView;)V", "layoutActionOn", "Landroid/widget/LinearLayout;", "getLayoutActionOn", "()Landroid/widget/LinearLayout;", "setLayoutActionOn", "(Landroid/widget/LinearLayout;)V", "sender", "senderId", "textMessage", "Landroid/widget/TextView;", "tvAdmin", "getTvAdmin", "()Landroid/widget/TextView;", "setTvAdmin", "(Landroid/widget/TextView;)V", "tvNotificationAction", "getTvNotificationAction", "setTvNotificationAction", "tvNotificationActionOn", "getTvNotificationActionOn", "setTvNotificationActionOn", "tvNotificationName", "getTvNotificationName", "setTvNotificationName", "checkContactNull", "Lcom/devbeans/io/chat/models/Contact;", "memberID", "checkConversation", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "message", "getActionOn", "splits", "my_sender_id", "getActionSender", "mySenderId", "getMySenderId", "getSender", "handleGroupActions", "", "handleOwnerSender", "initNotifyViewHolder", "onBind", "app_debug"})
public final class NotifyOutgoingViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.OutcomingTextMessageViewHolder<com.devbeans.io.chat.models.Messages> {
    private final android.widget.TextView textMessage = null;
    private java.lang.String sender;
    private java.lang.String action;
    private java.lang.String actionOn;
    private java.lang.String disappearTime;
    private java.lang.String senderId;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView tvNotificationName;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView tvNotificationAction;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView tvNotificationActionOn;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView tvAdmin;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView ivNotificationImage;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout layoutActionOn;
    private boolean isContact = false;
    private long disappearTimeInInt = -1L;
    
    public NotifyOutgoingViewHolder(@org.jetbrains.annotations.NotNull
    android.view.View itemView, @org.jetbrains.annotations.Nullable
    java.lang.Object payload) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTvNotificationName() {
        return null;
    }
    
    public final void setTvNotificationName(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTvNotificationAction() {
        return null;
    }
    
    public final void setTvNotificationAction(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTvNotificationActionOn() {
        return null;
    }
    
    public final void setTvNotificationActionOn(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTvAdmin() {
        return null;
    }
    
    public final void setTvAdmin(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getIvNotificationImage() {
        return null;
    }
    
    public final void setIvNotificationImage(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.LinearLayout getLayoutActionOn() {
        return null;
    }
    
    public final void setLayoutActionOn(@org.jetbrains.annotations.Nullable
    android.widget.LinearLayout p0) {
    }
    
    public final boolean isContact() {
        return false;
    }
    
    public final void setContact(boolean p0) {
    }
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleOwnerSender(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Messages message, java.lang.String my_sender_id) {
    }
    
    private final java.lang.String getActionSender(java.lang.String mySenderId, com.devbeans.io.chat.models.Messages message) {
        return null;
    }
    
    private final void handleGroupActions(com.devbeans.io.chat.models.Messages message, java.lang.String my_sender_id) {
    }
    
    private final java.lang.String getSender(com.devbeans.io.chat.models.Messages message, java.lang.String my_sender_id) {
        return null;
    }
    
    private final boolean checkConversation(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Messages message) {
        return false;
    }
    
    private final java.lang.String getMySenderId(com.devbeans.io.chat.models.Conversation conversation) {
        return null;
    }
    
    private final java.lang.String getActionOn(java.lang.String splits, com.devbeans.io.chat.models.Messages message, java.lang.String my_sender_id) {
        return null;
    }
    
    private final void initNotifyViewHolder(android.view.View itemView) {
    }
    
    private final com.devbeans.io.chat.models.Contact checkContactNull(java.lang.String memberID) {
        return null;
    }
}