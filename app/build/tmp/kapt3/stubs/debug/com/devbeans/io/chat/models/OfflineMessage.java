package com.devbeans.io.chat.models;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.DeliverListConverter.class})
@androidx.room.Entity
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B]\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0010\"\u0004\b(\u0010\u0012R \u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R \u00107\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R \u0010:\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R>\u0010=\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020?\u0018\u00010>j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020?\u0018\u0001`@8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001c\"\u0004\bG\u0010\u001eR\u001e\u0010H\u001a\u00020I8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010J\"\u0004\bK\u0010LR\u001e\u0010M\u001a\u00020I8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010J\"\u0004\bN\u0010LR\u001e\u0010O\u001a\u00020I8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010J\"\u0004\bP\u0010LR\u001e\u0010Q\u001a\u00020I8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010J\"\u0004\bR\u0010LR\u001e\u0010S\u001a\u00020I8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010J\"\u0004\bT\u0010LR\u001e\u0010U\u001a\u00020I8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010J\"\u0004\bV\u0010LR\u001e\u0010W\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001c\"\u0004\bY\u0010\u001eR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0010\"\u0004\b[\u0010\u0012R\u001e\u0010\\\u001a\u00020]8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR&\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u00101\"\u0004\bd\u00103R&\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u00101\"\u0004\bh\u00103R \u0010i\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0010\"\u0004\bk\u0010\u0012R \u0010l\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0010\"\u0004\bn\u0010\u0012R \u0010o\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0010\"\u0004\bq\u0010\u0012R \u0010r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0010\"\u0004\bt\u0010\u0012R \u0010u\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0010\"\u0004\bw\u0010\u0012R \u0010x\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0010\"\u0004\bz\u0010\u0012R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0010\"\u0004\b|\u0010\u0012R \u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0010\"\u0004\b~\u0010\u0012\u00a8\u0006\u007f"}, d2 = {"Lcom/devbeans/io/chat/models/OfflineMessage;", "Ljava/io/Serializable;", "()V", "data", "", "type", "messageId", "createdAt", "conversationId", "conversationType", "userChatId", "deliveredList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "NextDHKey", "getNextDHKey", "()Ljava/lang/String;", "setNextDHKey", "(Ljava/lang/String;)V", "aVRatchetKeyMaterial", "getAVRatchetKeyMaterial", "setAVRatchetKeyMaterial", "ack_id", "getAck_id", "setAck_id", "chainIndex", "", "getChainIndex", "()I", "setChainIndex", "(I)V", "chat_nick_data", "getChat_nick_data", "setChat_nick_data", "chat_nick_user_chat_id", "getChat_nick_user_chat_id", "setChat_nick_user_chat_id", "getConversationId", "setConversationId", "getConversationType", "setConversationType", "conversation_Type", "getConversation_Type", "setConversation_Type", "getCreatedAt", "setCreatedAt", "getData", "setData", "getDeliveredList", "()Ljava/util/List;", "setDeliveredList", "(Ljava/util/List;)V", "file_path", "getFile_path", "setFile_path", "fingerprint", "getFingerprint", "setFingerprint", "fingerprint2", "getFingerprint2", "setFingerprint2", "hashmap", "Ljava/util/HashMap;", "Lcom/devbeans/io/chat/encryption/MappedPayload;", "Lkotlin/collections/HashMap;", "getHashmap", "()Ljava/util/HashMap;", "setHashmap", "(Ljava/util/HashMap;)V", "id", "getId", "setId", "isCanShareForward", "", "()Z", "setCanShareForward", "(Z)V", "isDeleted", "setDeleted", "isEdited", "setEdited", "isExpire", "setExpire", "isForwarded", "setForwarded", "isSelected", "setSelected", "messageCounter", "getMessageCounter", "setMessageCounter", "getMessageId", "setMessageId", "msg_expiry_time", "", "getMsg_expiry_time", "()J", "setMsg_expiry_time", "(J)V", "public_key_list", "getPublic_key_list", "setPublic_key_list", "readList", "", "getReadList", "setReadList", "received_at", "getReceived_at", "setReceived_at", "recipientPubKeyFingerprint", "getRecipientPubKeyFingerprint", "setRecipientPubKeyFingerprint", "secretModel", "getSecretModel", "setSecretModel", "senderId", "getSenderId", "setSenderId", "senderPubKey", "getSenderPubKey", "setSenderPubKey", "status", "getStatus", "setStatus", "getType", "setType", "getUserChatId", "setUserChatId", "app_debug"})
public final class OfflineMessage implements java.io.Serializable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "ackId")
    private java.lang.String ack_id;
    @org.jetbrains.annotations.Nullable
    @androidx.room.Ignore
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "hashmap")
    private java.util.HashMap<java.lang.String, com.devbeans.io.chat.encryption.MappedPayload> hashmap;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversationType")
    private java.lang.String conversation_Type;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isEdited")
    private boolean isEdited = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isDeleted")
    private boolean isDeleted = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "readList")
    private java.util.List<java.lang.String> readList;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "fingerprint")
    private java.lang.String fingerprint;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "public_key_list")
    private java.util.List<java.lang.String> public_key_list;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "secretModel")
    private java.lang.String secretModel;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "received_at")
    private java.lang.String received_at;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chatNickUserChatId")
    private java.lang.String chat_nick_user_chat_id;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chatNickData")
    private java.lang.String chat_nick_data;
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
    private java.lang.String NextDHKey;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "messageCounter")
    private int messageCounter = 0;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chainIndex")
    private int chainIndex = 0;
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
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    private java.lang.String createdAt;
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
    private java.lang.String file_path;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "deliveredList")
    private java.util.List<java.lang.String> deliveredList;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isExpire")
    private boolean isExpire = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isForwarded")
    private boolean isForwarded = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "senderId")
    private java.lang.String senderId;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "msgExpiryTime")
    private long msg_expiry_time = -1L;
    @androidx.room.ColumnInfo(name = "payload_canShareForward")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "payload_canShareForward")
    private boolean isCanShareForward = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "public_key_list")
    private java.lang.String fingerprint2;
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
    public final java.lang.String getAck_id() {
        return null;
    }
    
    public final void setAck_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.HashMap<java.lang.String, com.devbeans.io.chat.encryption.MappedPayload> getHashmap() {
        return null;
    }
    
    public final void setHashmap(@org.jetbrains.annotations.Nullable
    java.util.HashMap<java.lang.String, com.devbeans.io.chat.encryption.MappedPayload> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getConversation_Type() {
        return null;
    }
    
    public final void setConversation_Type(@org.jetbrains.annotations.Nullable
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
    public final java.util.List<java.lang.String> getReadList() {
        return null;
    }
    
    public final void setReadList(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFingerprint() {
        return null;
    }
    
    public final void setFingerprint(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getPublic_key_list() {
        return null;
    }
    
    public final void setPublic_key_list(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSecretModel() {
        return null;
    }
    
    public final void setSecretModel(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReceived_at() {
        return null;
    }
    
    public final void setReceived_at(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChat_nick_user_chat_id() {
        return null;
    }
    
    public final void setChat_nick_user_chat_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChat_nick_data() {
        return null;
    }
    
    public final void setChat_nick_data(@org.jetbrains.annotations.Nullable
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
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable
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
    public final java.lang.String getUserChatId() {
        return null;
    }
    
    public final void setUserChatId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFile_path() {
        return null;
    }
    
    public final void setFile_path(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getDeliveredList() {
        return null;
    }
    
    public final void setDeliveredList(@org.jetbrains.annotations.Nullable
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
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSenderId() {
        return null;
    }
    
    public final void setSenderId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final long getMsg_expiry_time() {
        return 0L;
    }
    
    public final void setMsg_expiry_time(long p0) {
    }
    
    public final boolean isCanShareForward() {
        return false;
    }
    
    public final void setCanShareForward(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFingerprint2() {
        return null;
    }
    
    public final void setFingerprint2(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAVRatchetKeyMaterial() {
        return null;
    }
    
    public final void setAVRatchetKeyMaterial(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public OfflineMessage() {
        super();
    }
    
    public OfflineMessage(@org.jetbrains.annotations.Nullable
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
}