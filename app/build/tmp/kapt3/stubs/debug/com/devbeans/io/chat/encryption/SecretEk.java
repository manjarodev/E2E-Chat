package com.devbeans.io.chat.encryption;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.devbeans.io.chat.roomDB.TypeConverters.EKConverter.class})
@androidx.room.Entity(tableName = "secret_e_k")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/devbeans/io/chat/encryption/SecretEk;", "", "secret_key_identifier", "", "channel_identifier", "ek", "Lcom/devbeans/io/chat/encryption/EK;", "type", "(Ljava/lang/String;Ljava/lang/String;Lcom/devbeans/io/chat/encryption/EK;Ljava/lang/String;)V", "getChannel_identifier", "()Ljava/lang/String;", "setChannel_identifier", "(Ljava/lang/String;)V", "getEk", "()Lcom/devbeans/io/chat/encryption/EK;", "setEk", "(Lcom/devbeans/io/chat/encryption/EK;)V", "id", "", "getId", "()I", "setId", "(I)V", "getSecret_key_identifier", "setSecret_key_identifier", "getType", "setType", "app_debug"})
public final class SecretEk {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "secret_key_identifier")
    private java.lang.String secret_key_identifier;
    @org.jetbrains.annotations.NotNull
    private java.lang.String channel_identifier;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.encryption.EK ek;
    @org.jetbrains.annotations.NotNull
    private java.lang.String type;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    
    public SecretEk() {
        super();
    }
    
    public SecretEk(@org.jetbrains.annotations.NotNull
    java.lang.String secret_key_identifier, @org.jetbrains.annotations.NotNull
    java.lang.String channel_identifier, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.encryption.EK ek, @org.jetbrains.annotations.NotNull
    java.lang.String type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSecret_key_identifier() {
        return null;
    }
    
    public final void setSecret_key_identifier(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChannel_identifier() {
        return null;
    }
    
    public final void setChannel_identifier(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.encryption.EK getEk() {
        return null;
    }
    
    public final void setEk(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.encryption.EK p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
}