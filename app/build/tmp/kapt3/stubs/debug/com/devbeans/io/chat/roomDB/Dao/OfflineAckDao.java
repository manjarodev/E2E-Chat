package com.devbeans.io.chat.roomDB.Dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\'J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\'J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\nH\'J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/chat/roomDB/Dao/OfflineAckDao;", "", "deleteAckById", "", "identifier", "", "exist", "", "getAllAck", "", "Lcom/devbeans/io/chat/models/OfflineAck;", "getOfflineAck", "insert", "offlineAck", "updateAck", "updateOfflineAck", "", "payload", "Lcom/devbeans/io/chat/models/Payload;", "app_debug"})
public abstract interface OfflineAckDao {
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM offlineAck WHERE offlineAckId = :identifier)")
    public abstract boolean exist(@org.jetbrains.annotations.Nullable
    java.lang.String identifier);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.OfflineAck offlineAck);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM offlineAck ")
    public abstract java.util.List<com.devbeans.io.chat.models.OfflineAck> getAllAck();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM offlineAck WHERE offlineAckId LIKE :identifier")
    public abstract com.devbeans.io.chat.models.OfflineAck getOfflineAck(@org.jetbrains.annotations.Nullable
    java.lang.String identifier);
    
    @androidx.room.Query(value = "DELETE FROM offlineAck WHERE offlineAckId = :identifier")
    public abstract void deleteAckById(@org.jetbrains.annotations.NotNull
    java.lang.String identifier);
    
    @androidx.room.Query(value = "UPDATE offlineAck SET payload = :payload WHERE offlineAckId = :identifier")
    @androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.PayloadTypeConverter.class})
    public abstract int updateOfflineAck(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload payload);
    
    @androidx.room.Update
    public abstract void updateAck(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.OfflineAck offlineAck);
}