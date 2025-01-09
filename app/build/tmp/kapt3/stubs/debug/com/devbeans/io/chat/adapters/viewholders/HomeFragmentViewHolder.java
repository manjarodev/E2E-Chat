package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0001:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\bH\u0002J \u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0002J\u0018\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010(\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010*\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010+\u001a\u00020\'2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010-\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010.\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010/\u001a\u00020\'2\u0006\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u00102\u001a\u00020\'2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0018\u00103\u001a\u00020\'2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0018\u00104\u001a\u00020\'2\u0006\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u00105\u001a\u00020\'2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u00106\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u00107\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u00108\u001a\u00020\'2\u0006\u0010 \u001a\u00020!2\u0006\u00100\u001a\u000201J\u0018\u00109\u001a\u00020\'2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/HomeFragmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ItemChatsBinding;", "mRequestManager", "Lcom/bumptech/glide/RequestManager;", "(Lcom/devbeans/io/chat/databinding/ItemChatsBinding;Lcom/bumptech/glide/RequestManager;)V", "action", "", "actionOn", "color", "fromAdmin", "getFromAdmin", "()Ljava/lang/String;", "setFromAdmin", "(Ljava/lang/String;)V", "id", "isContact", "", "()Z", "setContact", "(Z)V", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ItemChatsBinding;", "mContact", "Lcom/devbeans/io/chat/models/Contact;", "name", "sender", "checkContact", "memberID", "checkContactNull", "getActionOn", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "senderId", "splits", "getSender", "getSenderByConv", "handleConfidentialLastMessage", "", "handleDeleteClick", "handleGroupActions", "handleGroupName", "handleHideMessages", "handleIconDisappear", "handleKeepChatAndDisappear", "handleLastMessageContent", "handleLongPress", "callback", "Lcom/devbeans/io/chat/callBacks/RoomsListCallback;", "handleMessage", "handleOneToOne", "handleRowClick", "handleSimpleLastMessage", "handleUnreadCount", "handleViewOnceLastMessage", "setData", "showLastMessage", "Companion", "app_debug"})
public final class HomeFragmentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.databinding.ItemChatsBinding mBinding = null;
    private final com.bumptech.glide.RequestManager mRequestManager = null;
    private java.lang.String name = "null";
    private com.devbeans.io.chat.models.Contact mContact;
    private java.lang.String color = "null";
    private boolean isContact = false;
    private java.lang.String id;
    private java.lang.String sender = "";
    private java.lang.String action = "";
    private java.lang.String actionOn = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String fromAdmin = "";
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.adapters.viewholders.HomeFragmentViewHolder.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public HomeFragmentViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.databinding.ItemChatsBinding mBinding, @org.jetbrains.annotations.NotNull
    com.bumptech.glide.RequestManager mRequestManager) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.databinding.ItemChatsBinding getMBinding() {
        return null;
    }
    
    public final boolean isContact() {
        return false;
    }
    
    public final void setContact(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFromAdmin() {
        return null;
    }
    
    public final void setFromAdmin(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation conversation, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.RoomsListCallback callback) {
    }
    
    private final void handleLongPress(com.devbeans.io.chat.callBacks.RoomsListCallback callback, com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleDeleteClick(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleRowClick(com.devbeans.io.chat.callBacks.RoomsListCallback callback, com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleLastMessageContent(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleUnreadCount(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleHideMessages(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final void handleIconDisappear(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleGroupName(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleOneToOne(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final void handleKeepChatAndDisappear(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final java.lang.String getSenderByConv(com.devbeans.io.chat.models.Conversation conversation) {
        return null;
    }
    
    private final void showLastMessage(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final void handleSimpleLastMessage(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final void handleMessage(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final void handleViewOnceLastMessage(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleConfidentialLastMessage(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleGroupActions(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final java.lang.String getActionOn(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId, java.lang.String splits) {
        return null;
    }
    
    private final java.lang.String getSender(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
        return null;
    }
    
    private final java.lang.String checkContact(java.lang.String memberID) {
        return null;
    }
    
    private final com.devbeans.io.chat.models.Contact checkContactNull(java.lang.String memberID) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/HomeFragmentViewHolder$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}