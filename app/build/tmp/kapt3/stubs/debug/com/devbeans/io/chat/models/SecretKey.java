package com.devbeans.io.chat.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/chat/models/SecretKey;", "", "secretKeyId", "", "(Ljava/lang/String;)V", "secretKey", "getSecretKey", "()Ljava/lang/String;", "setSecretKey", "getSecretKeyId", "setSecretKeyId", "app_debug"})
public final class SecretKey {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "secretKeyId")
    private java.lang.String secretKeyId;
    @org.jetbrains.annotations.Nullable
    @androidx.room.ColumnInfo(name = "secret_key")
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "secretKey")
    private java.lang.String secretKey;
    
    public SecretKey(@org.jetbrains.annotations.NotNull
    java.lang.String secretKeyId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSecretKeyId() {
        return null;
    }
    
    public final void setSecretKeyId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSecretKey() {
        return null;
    }
    
    public final void setSecretKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}