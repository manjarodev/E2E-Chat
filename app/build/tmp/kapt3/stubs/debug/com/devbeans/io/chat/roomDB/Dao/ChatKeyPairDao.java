package com.devbeans.io.chat.roomDB.Dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\'J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J \u0010\u000b\u001a\u00020\u00032\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/roomDB/Dao/ChatKeyPairDao;", "", "delete", "", "chatKeyPair", "Lcom/devbeans/io/chat/models/ChatKeyPair;", "exist", "", "identifier", "", "insert", "insertAll", "arrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
public abstract interface ChatKeyPairDao {
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM chatkeypair WHERE identifier = :identifier)")
    public abstract boolean exist(@org.jetbrains.annotations.Nullable
    java.lang.String identifier);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.ChatKeyPair chatKeyPair);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.devbeans.io.chat.models.ChatKeyPair> arrayList);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.ChatKeyPair chatKeyPair);
}