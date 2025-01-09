package com.devbeans.io.chat.roomDB.Dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\'J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\'J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\'J(\u0010\u0012\u001a\u00020\f2\u001e\u0010\u0013\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0015H\'R\u001e\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R&\u0010\u0007\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\b8gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/devbeans/io/chat/roomDB/Dao/KeyPairDao;", "", "allKeys", "", "Lcom/devbeans/io/chat/models/KeyModel;", "getAllKeys", "()Ljava/util/List;", "liveALLKeys", "Landroidx/lifecycle/LiveData;", "getLiveALLKeys", "()Landroidx/lifecycle/LiveData;", "delete", "", "keymodel", "getContact", "identifier", "", "insert", "insertAll", "arrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
public abstract interface KeyPairDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM keymodel")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.devbeans.io.chat.models.KeyModel>> getLiveALLKeys();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM keymodel")
    public abstract java.util.List<com.devbeans.io.chat.models.KeyModel> getAllKeys();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM keymodel WHERE identifer LIKE :identifier")
    public abstract com.devbeans.io.chat.models.KeyModel getContact(@org.jetbrains.annotations.Nullable
    byte[] identifier);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.KeyModel keymodel);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAll(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.devbeans.io.chat.models.KeyModel> arrayList);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.KeyModel keymodel);
}