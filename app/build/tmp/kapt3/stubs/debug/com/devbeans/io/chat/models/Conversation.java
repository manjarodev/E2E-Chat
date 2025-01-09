package com.devbeans.io.chat.models;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.ConversationMemberListConverter.class, com.devbeans.io.chat.roomDB.TypeConverters.MessagesListConverter.class})
@androidx.room.Entity
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010a\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR&\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR \u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR \u0010%\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b\'\u0010\u000eR\u001e\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001e\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001e\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001e\u00101\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001e\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001e\u00105\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001e\u00107\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001e\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR \u0010=\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\f\"\u0004\b?\u0010\u000eR \u0010@\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER&\u0010F\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010\u001eR \u0010I\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\f\"\u0004\bK\u0010\u000eR \u0010L\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\f\"\u0004\bN\u0010\u000eR \u0010O\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\f\"\u0004\bQ\u0010\u000eR \u0010R\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\f\"\u0004\bT\u0010\u000eR\u001e\u0010U\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0012\"\u0004\bW\u0010\u0014R\u001e\u0010X\u001a\u00020Y8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010^\u001a\u00020Y8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010[\"\u0004\b`\u0010]\u00a8\u0006b"}, d2 = {"Lcom/devbeans/io/chat/models/Conversation;", "Ljava/io/Serializable;", "()V", "conReadReceipts", "", "getConReadReceipts", "()Z", "setConReadReceipts", "(Z)V", "con_createdAt", "", "getCon_createdAt", "()Ljava/lang/String;", "setCon_createdAt", "(Ljava/lang/String;)V", "conversationExpiryTime", "", "getConversationExpiryTime", "()J", "setConversationExpiryTime", "(J)V", "conversationId", "getConversationId", "setConversationId", "conversationMembers", "", "Lcom/devbeans/io/chat/models/ConversationMember;", "getConversationMembers", "()Ljava/util/List;", "setConversationMembers", "(Ljava/util/List;)V", "conversationPhoto", "getConversationPhoto", "setConversationPhoto", "conversationType", "getConversationType", "setConversationType", "description", "getDescription", "setDescription", "hasSentMessage", "getHasSentMessage", "setHasSentMessage", "isArchived", "setArchived", "isAutoSaveVault", "setAutoSaveVault", "isCanShareForward", "setCanShareForward", "isConfidential", "setConfidential", "isInConversation", "setInConversation", "isMediaShareRestrict", "setMediaShareRestrict", "isPinned", "setPinned", "isRemoved", "setRemoved", "isViewOnce", "setViewOnce", "keepChatDate", "getKeepChatDate", "setKeepChatDate", "lastMessage", "Lcom/devbeans/io/chat/models/Payload;", "getLastMessage", "()Lcom/devbeans/io/chat/models/Payload;", "setLastMessage", "(Lcom/devbeans/io/chat/models/Payload;)V", "messages", "getMessages", "setMessages", "myMoniker", "getMyMoniker", "setMyMoniker", "name", "getName", "setName", "owner", "getOwner", "setOwner", "photo", "getPhoto", "setPhoto", "sequenceOfConversation", "getSequenceOfConversation", "setSequenceOfConversation", "uid", "", "getUid", "()I", "setUid", "(I)V", "unreadCount", "getUnreadCount", "setUnreadCount", "toString", "app_debug"})
public final class Conversation implements java.io.Serializable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.SerializedName(value = "uid")
    private int uid = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "description")
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable
    @androidx.room.ColumnInfo(name = "_conversation_id")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversationId")
    private java.lang.String conversationId;
    @org.jetbrains.annotations.Nullable
    @androidx.room.ColumnInfo(name = "_conversation_type")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversationType")
    private java.lang.String conversationType;
    @org.jetbrains.annotations.Nullable
    @androidx.room.ColumnInfo(name = "_conversationMembers")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversationMembers")
    private java.util.List<com.devbeans.io.chat.models.ConversationMember> conversationMembers;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "messages")
    private java.util.List<com.devbeans.io.chat.models.Payload> messages;
    @org.jetbrains.annotations.Nullable
    @androidx.room.Embedded
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "lastMessage")
    private com.devbeans.io.chat.models.Payload lastMessage;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "owner")
    private java.lang.String owner;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    private java.lang.String con_createdAt;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "keepChatDate")
    private java.lang.String keepChatDate;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isRemoved")
    private boolean isRemoved = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isArchived")
    private boolean isArchived = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "inConversation")
    private boolean isInConversation = false;
    @androidx.room.ColumnInfo(name = "_isViewOnce")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isViewOnce")
    private boolean isViewOnce = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "photo")
    private java.lang.String photo;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversationPhoto")
    private java.lang.String conversationPhoto;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "myMoniker")
    private java.lang.String myMoniker;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversationExpiryTime")
    private long conversationExpiryTime = -1L;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "canShareForward")
    private boolean isCanShareForward = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "autoSaveVault")
    private boolean isAutoSaveVault = false;
    @androidx.room.ColumnInfo(name = "_isConfidential")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isConfidential")
    private boolean isConfidential = false;
    @androidx.room.ColumnInfo(name = "_isMediaShareRestrict")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isMediaShareRestrict")
    private boolean isMediaShareRestrict = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "sequenceOfConversation")
    private long sequenceOfConversation = 0L;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isPinned")
    private boolean isPinned = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "hasSentMessage")
    private boolean hasSentMessage = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conReadReceipts")
    private boolean conReadReceipts = true;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "unreadCount")
    private int unreadCount = 0;
    
    public Conversation() {
        super();
    }
    
    public final int getUid() {
        return 0;
    }
    
    public final void setUid(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getConversationId() {
        return null;
    }
    
    public final void setConversationId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getConversationType() {
        return null;
    }
    
    public final void setConversationType(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.devbeans.io.chat.models.ConversationMember> getConversationMembers() {
        return null;
    }
    
    public final void setConversationMembers(@org.jetbrains.annotations.Nullable
    java.util.List<com.devbeans.io.chat.models.ConversationMember> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.devbeans.io.chat.models.Payload> getMessages() {
        return null;
    }
    
    public final void setMessages(@org.jetbrains.annotations.Nullable
    java.util.List<com.devbeans.io.chat.models.Payload> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Payload getLastMessage() {
        return null;
    }
    
    public final void setLastMessage(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOwner() {
        return null;
    }
    
    public final void setOwner(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCon_createdAt() {
        return null;
    }
    
    public final void setCon_createdAt(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getKeepChatDate() {
        return null;
    }
    
    public final void setKeepChatDate(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isRemoved() {
        return false;
    }
    
    public final void setRemoved(boolean p0) {
    }
    
    public final boolean isArchived() {
        return false;
    }
    
    public final void setArchived(boolean p0) {
    }
    
    public final boolean isInConversation() {
        return false;
    }
    
    public final void setInConversation(boolean p0) {
    }
    
    public final boolean isViewOnce() {
        return false;
    }
    
    public final void setViewOnce(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPhoto() {
        return null;
    }
    
    public final void setPhoto(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getConversationPhoto() {
        return null;
    }
    
    public final void setConversationPhoto(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMyMoniker() {
        return null;
    }
    
    public final void setMyMoniker(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final long getConversationExpiryTime() {
        return 0L;
    }
    
    public final void setConversationExpiryTime(long p0) {
    }
    
    public final boolean isCanShareForward() {
        return false;
    }
    
    public final void setCanShareForward(boolean p0) {
    }
    
    public final boolean isAutoSaveVault() {
        return false;
    }
    
    public final void setAutoSaveVault(boolean p0) {
    }
    
    public final boolean isConfidential() {
        return false;
    }
    
    public final void setConfidential(boolean p0) {
    }
    
    public final boolean isMediaShareRestrict() {
        return false;
    }
    
    public final void setMediaShareRestrict(boolean p0) {
    }
    
    public final long getSequenceOfConversation() {
        return 0L;
    }
    
    public final void setSequenceOfConversation(long p0) {
    }
    
    public final boolean isPinned() {
        return false;
    }
    
    public final void setPinned(boolean p0) {
    }
    
    public final boolean getHasSentMessage() {
        return false;
    }
    
    public final void setHasSentMessage(boolean p0) {
    }
    
    public final boolean getConReadReceipts() {
        return false;
    }
    
    public final void setConReadReceipts(boolean p0) {
    }
    
    public final int getUnreadCount() {
        return 0;
    }
    
    public final void setUnreadCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}