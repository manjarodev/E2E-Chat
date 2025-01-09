package com.devbeans.io.chat.encryption;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0004R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/devbeans/io/chat/encryption/EK;", "", "identifier", "", "(Ljava/lang/String;)V", "id", "", "getId", "()I", "setId", "(I)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "privKey", "getPrivKey", "setPrivKey", "pubKey", "getPubKey", "setPubKey", "app_debug"})
public final class EK {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "EKpubKey")
    private java.lang.String pubKey;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "key_identifier")
    private java.lang.String identifier;
    private int id = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "EKprivKey")
    private java.lang.String privKey;
    
    public EK(@org.jetbrains.annotations.NotNull
    java.lang.String identifier) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPubKey() {
        return null;
    }
    
    public final void setPubKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIdentifier() {
        return null;
    }
    
    public final void setIdentifier(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrivKey() {
        return null;
    }
    
    public final void setPrivKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}