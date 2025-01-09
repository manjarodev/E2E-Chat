package com.devbeans.io.chat.roomDB.Dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\'\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/roomDB/Dao/SecretEKDao;", "", "exist", "", "identifier", "", "getAllDhKeys", "", "Lcom/devbeans/io/chat/encryption/SecretEk;", "getEk", "insert", "", "ek", "app_debug"})
public abstract interface SecretEKDao {
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM secret_e_k WHERE secret_key_identifier = :identifier)")
    public abstract boolean exist(@org.jetbrains.annotations.Nullable
    java.lang.String identifier);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM secret_e_k WHERE channel_identifier = :identifier and type like \'DH\'")
    public abstract java.util.List<com.devbeans.io.chat.encryption.SecretEk> getAllDhKeys(@org.jetbrains.annotations.Nullable
    java.lang.String identifier);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.encryption.SecretEk ek);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM secret_e_k WHERE secret_key_identifier LIKE :identifier")
    public abstract com.devbeans.io.chat.encryption.SecretEk getEk(@org.jetbrains.annotations.Nullable
    java.lang.String identifier);
}