package com.devbeans.io.chat.roomDB.TypeConverters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/roomDB/TypeConverters/SecretKeyConverter;", "", "()V", "JsonToKey", "Lcom/devbeans/io/chat/models/SecretKey;", "encryptedJson", "", "KeyToJson", "secretKey", "app_debug"})
public final class SecretKeyConverter {
    
    public SecretKeyConverter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final java.lang.String KeyToJson(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.SecretKey secretKey) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final com.devbeans.io.chat.models.SecretKey JsonToKey(@org.jetbrains.annotations.NotNull
    java.lang.String encryptedJson) {
        return null;
    }
}