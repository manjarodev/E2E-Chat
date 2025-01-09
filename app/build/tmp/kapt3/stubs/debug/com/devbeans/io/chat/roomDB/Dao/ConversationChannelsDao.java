package com.devbeans.io.chat.roomDB.Dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\'J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\'J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\'J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\nH\'J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\'J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\'J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\'J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\'J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001eH\'J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\'J\u0018\u0010&\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020\u001eH\'\u00a8\u0006("}, d2 = {"Lcom/devbeans/io/chat/roomDB/Dao/ConversationChannelsDao;", "", "countChannels", "", "Lcom/devbeans/io/chat/models/ConversationChannels;", "identifier", "", "deleteConversationChannel", "", "exist", "", "flipRatchetDirection", "direction", "", "getConversationChannel", "incrementReceiveCount", "incrementSenderCount", "insert", "conversationchannel", "update", "channel", "updateChannelDecrypting", "isDHRacthetEnable", "updateDhRatchet", "dHRatchet", "Lcom/devbeans/io/chat/encryption/EK;", "updateFriendDHKey", "friendDHKey", "updateReceiverRatchet", "receiverRatchet", "Lcom/devbeans/io/chat/encryption/SymmRatchet;", "updateRecipientPubKey", "recipientPubKey", "updateRootRatchet", "rootRatchet", "updateSecretKey", "secretKey", "Lcom/devbeans/io/chat/models/SecretKey;", "updateSenderRatchet", "sendRatchet", "app_debug"})
public abstract interface ConversationChannelsDao {
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM conversation_channels WHERE channelIdentifier = :identifier)")
    public abstract boolean exist(@org.jetbrains.annotations.Nullable
    java.lang.String identifier);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.ConversationChannels conversationchannel);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM conversation_channels WHERE channelIdentifier LIKE :identifier")
    public abstract java.util.List<com.devbeans.io.chat.models.ConversationChannels> countChannels(@org.jetbrains.annotations.NotNull
    java.lang.String identifier);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM conversation_channels WHERE channelIdentifier LIKE :identifier")
    public abstract com.devbeans.io.chat.models.ConversationChannels getConversationChannel(@org.jetbrains.annotations.Nullable
    java.lang.String identifier);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET sk = :secretKey WHERE channelIdentifier = :identifier")
    @androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.SecretKeyConverterSimple.class})
    public abstract void updateSecretKey(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.SecretKey secretKey);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET SendRatchet = :sendRatchet WHERE channelIdentifier = :identifier")
    @androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.SymmRatchetConverterSimple.class})
    public abstract void updateSenderRatchet(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.encryption.SymmRatchet sendRatchet);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET RecvRatchet = :receiverRatchet WHERE channelIdentifier = :identifier")
    @androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.SymmRatchetConverterSimple.class})
    public abstract void updateReceiverRatchet(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.encryption.SymmRatchet receiverRatchet);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET RootRatchet = :rootRatchet WHERE channelIdentifier = :identifier")
    @androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.SymmRatchetConverterSimple.class})
    public abstract void updateRootRatchet(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.encryption.SymmRatchet rootRatchet);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET RecipientPubKey = :recipientPubKey WHERE channelIdentifier = :identifier")
    public abstract void updateRecipientPubKey(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    java.lang.String recipientPubKey);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET FriendDHKey = :friendDHKey WHERE channelIdentifier = :identifier")
    public abstract void updateFriendDHKey(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    java.lang.String friendDHKey);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET isDHRacthetEnable = :isDHRacthetEnable WHERE channelIdentifier = :identifier")
    public abstract void updateChannelDecrypting(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, boolean isDHRacthetEnable);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET DHRatchet = :dHRatchet WHERE channelIdentifier = :identifier")
    @androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.EKConverterSimple.class})
    public abstract void updateDhRatchet(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.encryption.EK dHRatchet);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET SendCounter = SendCounter + 1 WHERE channelIdentifier = :identifier")
    public abstract void incrementSenderCount(@org.jetbrains.annotations.NotNull
    java.lang.String identifier);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET ReceiveCounter = ReceiveCounter + 1 WHERE channelIdentifier = :identifier")
    public abstract void incrementReceiveCount(@org.jetbrains.annotations.NotNull
    java.lang.String identifier);
    
    @androidx.room.Query(value = "UPDATE conversation_channels SET FlipRatchetDirection = :direction WHERE channelIdentifier = :identifier")
    public abstract void flipRatchetDirection(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, int direction);
    
    @androidx.room.Query(value = "Delete from conversation_channels WHERE channelIdentifier = :identifier")
    public abstract void deleteConversationChannel(@org.jetbrains.annotations.NotNull
    java.lang.String identifier);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.ConversationChannels channel);
}