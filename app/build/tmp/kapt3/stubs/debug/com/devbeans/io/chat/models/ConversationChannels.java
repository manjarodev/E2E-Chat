package com.devbeans.io.chat.models;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.SecretKeyConverterSimple.class, com.devbeans.io.chat.roomDB.TypeConverters.SymmRatchetConverterSimple.class, com.devbeans.io.chat.roomDB.TypeConverters.EKConverterSimple.class, com.devbeans.io.chat.roomDB.TypeConverters.HashMapTypeConverter.class})
@androidx.room.Entity(tableName = "conversation_channels")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010N\u001a\u00020*2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0003J\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020SJ\u000e\u0010U\u001a\u00020*2\u0006\u00102\u001a\u000203J\u0006\u0010V\u001a\u00020SJ\u0006\u0010W\u001a\u00020SJ\u000e\u0010X\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u0003J\b\u0010Z\u001a\u00020\u0003H\u0016R:\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR \u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010 \"\u0004\b(\u0010\"R \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R \u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR \u0010;\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R \u0010>\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R\u001e\u0010A\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001dR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R \u0010F\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\u001e\u0010I\u001a\u00020J8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010K\"\u0004\bL\u0010M\u00a8\u0006["}, d2 = {"Lcom/devbeans/io/chat/models/ConversationChannels;", "", "channelIdentifier", "", "FlipRatchetDirection", "", "(Ljava/lang/String;I)V", "CacheFriendDHKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getCacheFriendDHKey", "()Ljava/util/HashMap;", "setCacheFriendDHKey", "(Ljava/util/HashMap;)V", "CacheRachet", "Lcom/devbeans/io/chat/encryption/EK;", "getCacheRachet", "()Lcom/devbeans/io/chat/encryption/EK;", "setCacheRachet", "(Lcom/devbeans/io/chat/encryption/EK;)V", "DHRatchet", "getDHRatchet", "setDHRatchet", "EK", "getEK", "setEK", "getFlipRatchetDirection", "()I", "setFlipRatchetDirection", "(I)V", "FriendDHKey", "getFriendDHKey", "()Ljava/lang/String;", "setFriendDHKey", "(Ljava/lang/String;)V", "ReceiveCounter", "getReceiveCounter", "setReceiveCounter", "RecipientPubKey", "getRecipientPubKey", "setRecipientPubKey", "RecvRatchet", "Lcom/devbeans/io/chat/encryption/SymmRatchet;", "getRecvRatchet", "()Lcom/devbeans/io/chat/encryption/SymmRatchet;", "setRecvRatchet", "(Lcom/devbeans/io/chat/encryption/SymmRatchet;)V", "RootRatchet", "getRootRatchet", "setRootRatchet", "SK", "Lcom/devbeans/io/chat/models/SecretKey;", "getSK", "()Lcom/devbeans/io/chat/models/SecretKey;", "setSK", "(Lcom/devbeans/io/chat/models/SecretKey;)V", "SendCounter", "getSendCounter", "setSendCounter", "SendRatchet", "getSendRatchet", "setSendRatchet", "cacheRatchet", "getCacheRatchet", "setCacheRatchet", "channelId", "getChannelId", "setChannelId", "getChannelIdentifier", "setChannelIdentifier", "channelWith", "getChannelWith", "setChannelWith", "isDHRacthetEnable", "", "()Z", "setDHRacthetEnable", "(Z)V", "DHRatchetLocal", "keypair", "Lcom/devbeans/io/chat/encryption/SecretEk;", "friendDH", "DHRatchetNext", "", "initRatchets", "initRatchetsLocal", "preCacheRatchet", "preDHRatchet", "preFriendCacheRatchet", "id", "toString", "app_debug"})
public final class ConversationChannels {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.SerializedName(value = "channelId")
    private int channelId = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "channelIdentifier")
    private java.lang.String channelIdentifier;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "channelWith")
    private java.lang.String channelWith;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "SK")
    private com.devbeans.io.chat.models.SecretKey SK;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "RootRatchet")
    private com.devbeans.io.chat.encryption.SymmRatchet RootRatchet;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "SendRatchet")
    private com.devbeans.io.chat.encryption.SymmRatchet SendRatchet;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "RecvRatchet")
    private com.devbeans.io.chat.encryption.SymmRatchet RecvRatchet;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "cacheRatchet")
    private com.devbeans.io.chat.encryption.SymmRatchet cacheRatchet;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "RecipientPubKey")
    private java.lang.String RecipientPubKey;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "FriendDHKey")
    private java.lang.String FriendDHKey;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "CacheFriendDHKey")
    private java.util.HashMap<java.lang.String, java.lang.String> CacheFriendDHKey;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "DHRatchet")
    private com.devbeans.io.chat.encryption.EK DHRatchet;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "CacheRachet")
    private com.devbeans.io.chat.encryption.EK CacheRachet;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "EK")
    private com.devbeans.io.chat.encryption.EK EK;
    @com.google.gson.annotations.SerializedName(value = "SendCounter")
    private int SendCounter = 0;
    @com.google.gson.annotations.SerializedName(value = "ReceiveCounter")
    private int ReceiveCounter = 0;
    @com.google.gson.annotations.SerializedName(value = "FlipRatchetDirection")
    private int FlipRatchetDirection;
    @com.google.gson.annotations.SerializedName(value = "isDHRacthetEnable")
    private boolean isDHRacthetEnable = false;
    
    public ConversationChannels(@org.jetbrains.annotations.NotNull
    java.lang.String channelIdentifier, int FlipRatchetDirection) {
        super();
    }
    
    public final int getChannelId() {
        return 0;
    }
    
    public final void setChannelId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChannelIdentifier() {
        return null;
    }
    
    public final void setChannelIdentifier(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChannelWith() {
        return null;
    }
    
    public final void setChannelWith(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.SecretKey getSK() {
        return null;
    }
    
    public final void setSK(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.SecretKey p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.encryption.SymmRatchet getRootRatchet() {
        return null;
    }
    
    public final void setRootRatchet(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.encryption.SymmRatchet p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.encryption.SymmRatchet getSendRatchet() {
        return null;
    }
    
    public final void setSendRatchet(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.encryption.SymmRatchet p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.encryption.SymmRatchet getRecvRatchet() {
        return null;
    }
    
    public final void setRecvRatchet(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.encryption.SymmRatchet p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.encryption.SymmRatchet getCacheRatchet() {
        return null;
    }
    
    public final void setCacheRatchet(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.encryption.SymmRatchet p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRecipientPubKey() {
        return null;
    }
    
    public final void setRecipientPubKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFriendDHKey() {
        return null;
    }
    
    public final void setFriendDHKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, java.lang.String> getCacheFriendDHKey() {
        return null;
    }
    
    public final void setCacheFriendDHKey(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.encryption.EK getDHRatchet() {
        return null;
    }
    
    public final void setDHRatchet(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.encryption.EK p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.encryption.EK getCacheRachet() {
        return null;
    }
    
    public final void setCacheRachet(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.encryption.EK p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.encryption.EK getEK() {
        return null;
    }
    
    public final void setEK(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.encryption.EK p0) {
    }
    
    public final int getSendCounter() {
        return 0;
    }
    
    public final void setSendCounter(int p0) {
    }
    
    public final int getReceiveCounter() {
        return 0;
    }
    
    public final void setReceiveCounter(int p0) {
    }
    
    public final int getFlipRatchetDirection() {
        return 0;
    }
    
    public final void setFlipRatchetDirection(int p0) {
    }
    
    public final boolean isDHRacthetEnable() {
        return false;
    }
    
    public final void setDHRacthetEnable(boolean p0) {
    }
    
    public final void initRatchets() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.encryption.SymmRatchet initRatchetsLocal(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.SecretKey SK) {
        return null;
    }
    
    public final void DHRatchetNext() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.encryption.SymmRatchet DHRatchetLocal(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.encryption.SecretEk keypair, @org.jetbrains.annotations.NotNull
    java.lang.String friendDH) {
        return null;
    }
    
    public final void preDHRatchet() {
    }
    
    public final void preCacheRatchet() {
    }
    
    public final void preFriendCacheRatchet(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}