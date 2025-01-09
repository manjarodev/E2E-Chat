package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 82\u00020\u0001:\u00018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\nH\u0002J \u0010!\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010$\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J*\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0000J\u0018\u00106\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0003J\u0010\u00107\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/ArchiveViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ItemArchiveBinding;", "mRequestManager", "Lcom/bumptech/glide/RequestManager;", "callback", "Lcom/devbeans/io/chat/callBacks/ArchiveRoomsListCallback;", "(Lcom/devbeans/io/chat/databinding/ItemArchiveBinding;Lcom/bumptech/glide/RequestManager;Lcom/devbeans/io/chat/callBacks/ArchiveRoomsListCallback;)V", "action", "", "actionOn", "color", "id", "isContact", "", "()Z", "setContact", "(Z)V", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ItemArchiveBinding;", "mContact", "Lcom/devbeans/io/chat/models/Contact;", "name", "sender", "checkAndHandleHide", "", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "senderId", "checkContact", "memberID", "checkContactNull", "getActionOn", "splits", "getConversationSender", "getSender", "handleConversationIcon", "handleDeleteClick", "handleGroupLastMessage", "handleGroups", "handleHideLastMessage", "handleKeepChatAndDisappear", "handleLongPress", "handleOneToOne", "handleRowClick", "handleSimpleLastMessage", "handleUnread", "setData", "mContext", "Landroid/content/Context;", "position", "", "holder", "showLastMessage", "showLastMessageContent", "Companion", "app_debug"})
public final class ArchiveViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.databinding.ItemArchiveBinding mBinding = null;
    private final com.bumptech.glide.RequestManager mRequestManager = null;
    private final com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback callback = null;
    private java.lang.String name = "null";
    private com.devbeans.io.chat.models.Contact mContact;
    private java.lang.String color = "null";
    private boolean isContact = false;
    private java.lang.String id;
    private java.lang.String sender = "";
    private java.lang.String action = "";
    private java.lang.String actionOn = "";
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.adapters.viewholders.ArchiveViewHolder.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public ArchiveViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.databinding.ItemArchiveBinding mBinding, @org.jetbrains.annotations.NotNull
    com.bumptech.glide.RequestManager mRequestManager, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback callback) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.databinding.ItemArchiveBinding getMBinding() {
        return null;
    }
    
    public final boolean isContact() {
        return false;
    }
    
    public final void setContact(boolean p0) {
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation conversation, int position, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.adapters.viewholders.ArchiveViewHolder holder) {
    }
    
    private final void handleLongPress(com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback callback, com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleDeleteClick(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleRowClick(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void showLastMessageContent(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void checkAndHandleHide(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final void handleConversationIcon(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final java.lang.String getConversationSender(com.devbeans.io.chat.models.Conversation conversation) {
        return null;
    }
    
    private final void handleKeepChatAndDisappear(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleUnread(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleHideLastMessage(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final void handleGroups(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleOneToOne(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final java.lang.String checkContact(java.lang.String memberID) {
        return null;
    }
    
    private final com.devbeans.io.chat.models.Contact checkContactNull(java.lang.String memberID) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void showLastMessage(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final java.lang.String getSender(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
        return null;
    }
    
    private final void handleSimpleLastMessage(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleGroupLastMessage(com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final java.lang.String getActionOn(com.devbeans.io.chat.models.Conversation conversation, java.lang.String splits, java.lang.String senderId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/ArchiveViewHolder$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}