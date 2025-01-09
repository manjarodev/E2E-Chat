package com.devbeans.io.chat.roomDB.Dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\'J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\'J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fH\'J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\fH\'J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\'J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\'R\u001e\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/devbeans/io/chat/roomDB/Dao/IdentityKeyPairDao;", "", "allKeys", "", "Lcom/devbeans/io/chat/models/IdentityKeyPair;", "getAllKeys", "()Ljava/util/List;", "getKeyID", "id", "", "getKeys", "identifier", "", "insertKey", "", "privateKey", "insertKeys", "identityKeyPair", "insertidentiferKey", "identifer", "insertpubKey", "pub", "updatePrivateKey", "updatePublicKey", "publicKeys", "app_debug"})
public abstract interface IdentityKeyPairDao {
    
    @androidx.room.Insert
    public abstract void insertKeys(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.IdentityKeyPair identityKeyPair);
    
    @androidx.room.Query(value = "insert into identityKeyPair (privateKeyByte) values (:privateKey) ")
    public abstract void insertKey(@org.jetbrains.annotations.NotNull
    byte[] privateKey);
    
    @androidx.room.Query(value = "insert into identityKeyPair (identifier) values (:identifer) ")
    public abstract void insertidentiferKey(@org.jetbrains.annotations.NotNull
    byte[] identifer);
    
    @androidx.room.Query(value = "insert into identityKeyPair (pubPrivateKeyByte) values (:pub) ")
    public abstract void insertpubKey(@org.jetbrains.annotations.NotNull
    byte[] pub);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "select * from identityKeyPair where identifier=:identifier")
    public abstract com.devbeans.io.chat.models.IdentityKeyPair getKeys(@org.jetbrains.annotations.NotNull
    byte[] identifier);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM identityKeyPair")
    public abstract java.util.List<com.devbeans.io.chat.models.IdentityKeyPair> getAllKeys();
    
    @androidx.room.Query(value = "update identityKeyPair set privateKeyByte=:privateKey where identifier=:identifier")
    public abstract void updatePrivateKey(@org.jetbrains.annotations.NotNull
    byte[] identifier, @org.jetbrains.annotations.NotNull
    byte[] privateKey);
    
    @androidx.room.Query(value = "update identityKeyPair set pubPrivateKeyByte=:publicKeys where identifier=:identifier")
    public abstract void updatePublicKey(@org.jetbrains.annotations.NotNull
    byte[] identifier, @org.jetbrains.annotations.NotNull
    byte[] publicKeys);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "Select * from identityKeyPair where id =:id")
    public abstract com.devbeans.io.chat.models.IdentityKeyPair getKeyID(int id);
}