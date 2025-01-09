package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0014\u0010/\u001a\u0004\u0018\u00010\u00182\b\u00100\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u00101\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\tH\u0002J\u0018\u00106\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\tH\u0002J \u00107\u001a\u0002082\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0012H\u0002J\u0018\u0010:\u001a\u0002082\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0012H\u0002J\u0018\u0010;\u001a\u0002082\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0012H\u0002J\u001e\u0010<\u001a\u0002082\u0006\u00104\u001a\u00020\u00122\u0006\u0010=\u001a\u0002032\u0006\u0010>\u001a\u00020\tJ\u0018\u0010?\u001a\u0002082\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0012H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006@"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/GroupMemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ItemMemberBinding;", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "isChatDetails", "", "onLongMemberCallback", "Lcom/devbeans/io/chat/callBacks/OnLongMemberCallback;", "(Lcom/devbeans/io/chat/databinding/ItemMemberBinding;Lcom/devbeans/io/chat/models/Conversation;Lcom/bumptech/glide/RequestManager;ZLcom/devbeans/io/chat/callBacks/OnLongMemberCallback;)V", "getConversation", "()Lcom/devbeans/io/chat/models/Conversation;", "setConversation", "(Lcom/devbeans/io/chat/models/Conversation;)V", "conversationMember", "Lcom/devbeans/io/chat/models/ConversationMember;", "getConversationMember", "()Lcom/devbeans/io/chat/models/ConversationMember;", "setConversationMember", "(Lcom/devbeans/io/chat/models/ConversationMember;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setChatDetails", "(Z)V", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ItemMemberBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ItemMemberBinding;)V", "name", "getName", "setName", "getOnLongMemberCallback", "()Lcom/devbeans/io/chat/callBacks/OnLongMemberCallback;", "setOnLongMemberCallback", "(Lcom/devbeans/io/chat/callBacks/OnLongMemberCallback;)V", "getRequestManager", "()Lcom/bumptech/glide/RequestManager;", "setRequestManager", "(Lcom/bumptech/glide/RequestManager;)V", "checkContact", "memberID", "getSenderFromConv", "getVisibilityAdmin", "", "s", "isOwner", "getVisibilityOwner", "handleClickChatDetails", "", "my_sender_id", "handleNickName", "handleNickNameNotOwner", "setData", "position", "changeOwner", "setNickName", "app_debug"})
public final class GroupMemberViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.databinding.ItemMemberBinding mBinding;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.models.Conversation conversation;
    @org.jetbrains.annotations.NotNull
    private com.bumptech.glide.RequestManager requestManager;
    private boolean isChatDetails;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.OnLongMemberCallback onLongMemberCallback;
    @org.jetbrains.annotations.Nullable
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable
    private java.lang.String id;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.ConversationMember conversationMember;
    
    public GroupMemberViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.databinding.ItemMemberBinding mBinding, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation conversation, @org.jetbrains.annotations.NotNull
    com.bumptech.glide.RequestManager requestManager, boolean isChatDetails, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnLongMemberCallback onLongMemberCallback) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.databinding.ItemMemberBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.databinding.ItemMemberBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.models.Conversation getConversation() {
        return null;
    }
    
    public final void setConversation(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.bumptech.glide.RequestManager getRequestManager() {
        return null;
    }
    
    public final void setRequestManager(@org.jetbrains.annotations.NotNull
    com.bumptech.glide.RequestManager p0) {
    }
    
    public final boolean isChatDetails() {
        return false;
    }
    
    public final void setChatDetails(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.OnLongMemberCallback getOnLongMemberCallback() {
        return null;
    }
    
    public final void setOnLongMemberCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnLongMemberCallback p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.ConversationMember getConversationMember() {
        return null;
    }
    
    public final void setConversationMember(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.ConversationMember p0) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.ConversationMember s, int position, boolean changeOwner) {
    }
    
    private final void handleNickNameNotOwner(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.ConversationMember s) {
    }
    
    private final void handleNickName(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.ConversationMember s) {
    }
    
    private final int getVisibilityAdmin(com.devbeans.io.chat.models.ConversationMember s, boolean isOwner) {
        return 0;
    }
    
    private final int getVisibilityOwner(com.devbeans.io.chat.models.ConversationMember s, boolean isOwner) {
        return 0;
    }
    
    private final void handleClickChatDetails(com.devbeans.io.chat.models.Conversation conversation, java.lang.String my_sender_id, com.devbeans.io.chat.models.ConversationMember s) {
    }
    
    private final java.lang.String getSenderFromConv(com.devbeans.io.chat.models.Conversation conversation) {
        return null;
    }
    
    private final void setNickName(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.ConversationMember s) {
    }
    
    private final java.lang.String checkContact(java.lang.String memberID) {
        return null;
    }
}