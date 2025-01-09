package com.devbeans.io.chat.models;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.DeliverListConverter.class})
@androidx.room.Entity
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B]\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0085\u0001\u001a\u00020\u0004H\u0016R \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b\'\u0010\u0012R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001e\u00107\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001bR\u001e\u0010:\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R\u001e\u0010A\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\u001e\u0010C\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R\u001e\u0010E\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010<\"\u0004\bF\u0010>R\u001e\u0010G\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010<\"\u0004\bH\u0010>R\u001e\u0010I\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R\u001e\u0010K\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010<\"\u0004\bL\u0010>R\u001e\u0010M\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010<\"\u0004\bN\u0010>R\u001e\u0010O\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010<\"\u0004\bP\u0010>R\u001e\u0010Q\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010<\"\u0004\bR\u0010>R\u001e\u0010S\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0019\"\u0004\bU\u0010\u001bR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0010\"\u0004\bW\u0010\u0012R\u001e\u0010X\u001a\u00020/8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u00101\"\u0004\bZ\u00103R \u0010[\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R&\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010+\"\u0004\b`\u0010-R&\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010+\"\u0004\bd\u0010-R&\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010+\"\u0004\bg\u0010-R\u001e\u0010h\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010<\"\u0004\bj\u0010>R \u0010k\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0010\"\u0004\bm\u0010\u0012R \u0010n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0010\"\u0004\bp\u0010\u0012R \u0010q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0010\"\u0004\bs\u0010\u0012R&\u0010t\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010u8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR \u0010{\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0010\"\u0004\b}\u0010\u0012R!\u0010~\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0010\"\u0005\b\u0080\u0001\u0010\u0012R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0010\"\u0005\b\u0082\u0001\u0010\u0012R\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0010\"\u0005\b\u0084\u0001\u0010\u0012\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/devbeans/io/chat/models/Payload;", "Ljava/io/Serializable;", "()V", "data", "", "type", "messageId", "createdAt", "conversationId", "conversationType", "userChatId", "deliveredList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "aVRatchetKeyMaterial", "getAVRatchetKeyMaterial", "()Ljava/lang/String;", "setAVRatchetKeyMaterial", "(Ljava/lang/String;)V", "ack_id", "getAck_id", "setAck_id", "chainIndex", "", "getChainIndex", "()I", "setChainIndex", "(I)V", "chatNickData", "getChatNickData", "setChatNickData", "chatNickUserChatId", "getChatNickUserChatId", "setChatNickUserChatId", "getConversationId", "setConversationId", "getConversationType", "setConversationType", "getCreatedAt", "setCreatedAt", "getData", "setData", "getDeliveredList", "()Ljava/util/List;", "setDeliveredList", "(Ljava/util/List;)V", "expireStarted", "", "getExpireStarted", "()J", "setExpireStarted", "(J)V", "filePath", "getFilePath", "setFilePath", "id", "getId", "setId", "isCanShareForward", "", "()Z", "setCanShareForward", "(Z)V", "isConfidential", "setConfidential", "isDeleted", "setDeleted", "isDownloading", "setDownloading", "isEdited", "setEdited", "isExpire", "setExpire", "isForwarded", "setForwarded", "isOpened", "setOpened", "isSelected", "setSelected", "isViewOnce", "setViewOnce", "isViewed", "setViewed", "messageCounter", "getMessageCounter", "setMessageCounter", "getMessageId", "setMessageId", "msgExpiryTime", "getMsgExpiryTime", "setMsgExpiryTime", "nextDHKey", "getNextDHKey", "setNextDHKey", "openedList", "getOpenedList", "setOpenedList", "public_key_list", "", "getPublic_key_list", "setPublic_key_list", "readList", "getReadList", "setReadList", "readReceipts", "getReadReceipts", "setReadReceipts", "received_at", "getReceived_at", "setReceived_at", "recipientPubKeyFingerprint", "getRecipientPubKeyFingerprint", "setRecipientPubKeyFingerprint", "senderId", "getSenderId", "setSenderId", "senderList", "Ljava/util/ArrayList;", "Lcom/devbeans/io/chat/encryption/MappedPayload;", "getSenderList", "()Ljava/util/ArrayList;", "setSenderList", "(Ljava/util/ArrayList;)V", "senderPubKey", "getSenderPubKey", "setSenderPubKey", "status", "getStatus", "setStatus", "getType", "setType", "getUserChatId", "setUserChatId", "toString", "app_debug"})
public final class Payload implements java.io.Serializable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.lang.String data;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "type")
    private java.lang.String type;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "messageId")
    private java.lang.String messageId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "senderId")
    private java.lang.String senderId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    private java.lang.String createdAt;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "ackId")
    private java.lang.String ack_id;
    @org.jetbrains.annotations.Nullable
    @androidx.room.Ignore
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "hashmap")
    private java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> senderList;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversationId")
    private java.lang.String conversationId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversationType")
    private java.lang.String conversationType;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "userChatId")
    private java.lang.String userChatId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "filePath")
    private java.lang.String filePath;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isEdited")
    private boolean isEdited = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isDeleted")
    private boolean isDeleted = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "deliveredList")
    private java.util.List<java.lang.String> deliveredList;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "readList")
    private java.util.List<java.lang.String> readList;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "openedList")
    private java.util.List<java.lang.String> openedList;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isExpire")
    private boolean isExpire = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isForwarded")
    private boolean isForwarded = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isConfidential")
    private boolean isConfidential = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isViewOnce")
    private boolean isViewOnce = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isViewed")
    private boolean isViewed = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isDownloading")
    private boolean isDownloading = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "readReceipts")
    private boolean readReceipts = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isOpened")
    private boolean isOpened = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "msgExpiryTime")
    private long msgExpiryTime = -1L;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "expireStarted")
    private long expireStarted = -1L;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "public_key_list")
    private java.util.List<java.lang.String> public_key_list;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "received_at")
    private java.lang.String received_at;
    @androidx.room.ColumnInfo(name = "payloadCanShareForward")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "payloadCanShareForward")
    private boolean isCanShareForward = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chatNickUserChatId")
    private java.lang.String chatNickUserChatId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chatNickData")
    private java.lang.String chatNickData;
    @androidx.room.Ignore
    private boolean isSelected = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "senderPubKey")
    private java.lang.String senderPubKey;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "recipientPubKeyFingerprint")
    private java.lang.String recipientPubKeyFingerprint;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "nextDHKey")
    private java.lang.String nextDHKey;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "messageCounter")
    private int messageCounter = 0;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chainIndex")
    private int chainIndex = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "aVRatchetKeyMaterial")
    private java.lang.String aVRatchetKeyMaterial;
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMessageId() {
        return null;
    }
    
    public final void setMessageId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSenderId() {
        return null;
    }
    
    public final void setSenderId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAck_id() {
        return null;
    }
    
    public final void setAck_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> getSenderList() {
        return null;
    }
    
    public final void setSenderList(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> p0) {
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
    public final java.lang.String getUserChatId() {
        return null;
    }
    
    public final void setUserChatId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFilePath() {
        return null;
    }
    
    public final void setFilePath(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isEdited() {
        return false;
    }
    
    public final void setEdited(boolean p0) {
    }
    
    public final boolean isDeleted() {
        return false;
    }
    
    public final void setDeleted(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getDeliveredList() {
        return null;
    }
    
    public final void setDeliveredList(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getReadList() {
        return null;
    }
    
    public final void setReadList(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getOpenedList() {
        return null;
    }
    
    public final void setOpenedList(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    public final boolean isExpire() {
        return false;
    }
    
    public final void setExpire(boolean p0) {
    }
    
    public final boolean isForwarded() {
        return false;
    }
    
    public final void setForwarded(boolean p0) {
    }
    
    public final boolean isConfidential() {
        return false;
    }
    
    public final void setConfidential(boolean p0) {
    }
    
    public final boolean isViewOnce() {
        return false;
    }
    
    public final void setViewOnce(boolean p0) {
    }
    
    public final boolean isViewed() {
        return false;
    }
    
    public final void setViewed(boolean p0) {
    }
    
    public final boolean isDownloading() {
        return false;
    }
    
    public final void setDownloading(boolean p0) {
    }
    
    public final boolean getReadReceipts() {
        return false;
    }
    
    public final void setReadReceipts(boolean p0) {
    }
    
    public final boolean isOpened() {
        return false;
    }
    
    public final void setOpened(boolean p0) {
    }
    
    public final long getMsgExpiryTime() {
        return 0L;
    }
    
    public final void setMsgExpiryTime(long p0) {
    }
    
    public final long getExpireStarted() {
        return 0L;
    }
    
    public final void setExpireStarted(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getPublic_key_list() {
        return null;
    }
    
    public final void setPublic_key_list(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReceived_at() {
        return null;
    }
    
    public final void setReceived_at(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isCanShareForward() {
        return false;
    }
    
    public final void setCanShareForward(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChatNickUserChatId() {
        return null;
    }
    
    public final void setChatNickUserChatId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChatNickData() {
        return null;
    }
    
    public final void setChatNickData(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isSelected() {
        return false;
    }
    
    public final void setSelected(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSenderPubKey() {
        return null;
    }
    
    public final void setSenderPubKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRecipientPubKeyFingerprint() {
        return null;
    }
    
    public final void setRecipientPubKeyFingerprint(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNextDHKey() {
        return null;
    }
    
    public final void setNextDHKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final int getMessageCounter() {
        return 0;
    }
    
    public final void setMessageCounter(int p0) {
    }
    
    public final int getChainIndex() {
        return 0;
    }
    
    public final void setChainIndex(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAVRatchetKeyMaterial() {
        return null;
    }
    
    public final void setAVRatchetKeyMaterial(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public Payload() {
        super();
    }
    
    public Payload(@org.jetbrains.annotations.Nullable
    java.lang.String data, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String messageId, @org.jetbrains.annotations.Nullable
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    java.lang.String conversationType, @org.jetbrains.annotations.Nullable
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> deliveredList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}