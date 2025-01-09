package com.devbeans.io.chat.roomDB.Dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tH\'J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\'J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\'R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/chat/roomDB/Dao/SecreteKeyDao;", "", "allKeys", "", "Lcom/devbeans/io/chat/models/SecreteKeyModel;", "getAllKeys", "()Ljava/util/List;", "allKeysforConversation", "conId", "", "deleteKey", "", "secreteKey", "", "getByte", "getKey", "identifier", "insert", "SecreteKeyModel", "update", "updatePreviousSIR", "app_debug"})
public abstract interface SecreteKeyDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.SecreteKeyModel SecreteKeyModel);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "Select * From SecreteKeyModel where secreteKey=:secreteKey")
    public abstract com.devbeans.io.chat.models.SecreteKeyModel getByte(@org.jetbrains.annotations.NotNull
    byte[] secreteKey);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM SecreteKeyModel where isExpired LIKE 0 and conversation_id like :conId")
    public abstract java.util.List<com.devbeans.io.chat.models.SecreteKeyModel> allKeysforConversation(@org.jetbrains.annotations.NotNull
    java.lang.String conId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM SecreteKeyModel where isExpired LIKE 0")
    public abstract java.util.List<com.devbeans.io.chat.models.SecreteKeyModel> getAllKeys();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM SecreteKeyModel where identifier LIKE :identifier")
    public abstract com.devbeans.io.chat.models.SecreteKeyModel getKey(@org.jetbrains.annotations.NotNull
    java.lang.String identifier);
    
    @androidx.room.Query(value = "UPDATE SecreteKeyModel SET isExpired = 1 WHERE secreteKey = :secreteKey")
    public abstract void update(@org.jetbrains.annotations.NotNull
    byte[] secreteKey);
    
    @androidx.room.Query(value = "UPDATE SecreteKeyModel SET isExpired = 1 WHERE conversation_id = :conId")
    public abstract void updatePreviousSIR(@org.jetbrains.annotations.NotNull
    java.lang.String conId);
    
    @androidx.room.Query(value = "Delete from SecreteKeyModel where secreteKey=:secreteKey")
    public abstract void deleteKey(@org.jetbrains.annotations.NotNull
    byte[] secreteKey);
}