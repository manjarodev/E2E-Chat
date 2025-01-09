package com.devbeans.io.chat.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001b\u001a\u00020\u00192\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001d\u001a\u00020\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001e\u001a\u00020\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001f\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0018\u0010 \u001a\u00020\u00192\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007J\u0010\u0010!\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/devbeans/io/chat/models/PublicKeyModel;", "", "()V", "createdAt", "", "expiry", "keyFingerprint", "", "", "keyFormat", "keyId", "keyType", "ownerId", "publicKey", "state", "getCreatedAt", "getExpiry", "getKeyFingerprint", "getKeyFormat", "getKeyId", "getKeyType", "getOwnerId", "getPublicKey", "getState", "setCreatedAt", "", "setExpiry", "setKeyFingerprint", "setKeyFormat", "setKeyId", "setKeyType", "setOwnerId", "setPublicKey", "setState", "app_debug"})
public final class PublicKeyModel {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "ownerId")
    private java.lang.String ownerId;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    private java.lang.String createdAt;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "keyId")
    private java.lang.String keyId;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "keyType")
    private java.lang.String keyType;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "state")
    private java.lang.String state;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "publicKey")
    private java.util.List<java.lang.Integer> publicKey;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "expiry")
    private java.lang.String expiry;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "keyFingerprint")
    private java.util.List<java.lang.Integer> keyFingerprint;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "keyFormat")
    private java.lang.String keyFormat;
    
    public PublicKeyModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOwnerId() {
        return null;
    }
    
    public final void setOwnerId(@org.jetbrains.annotations.Nullable
    java.lang.String ownerId) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable
    java.lang.String createdAt) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getKeyId() {
        return null;
    }
    
    public final void setKeyId(@org.jetbrains.annotations.Nullable
    java.lang.String keyId) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getKeyType() {
        return null;
    }
    
    public final void setKeyType(@org.jetbrains.annotations.Nullable
    java.lang.String keyType) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.Nullable
    java.lang.String state) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.Integer> getPublicKey() {
        return null;
    }
    
    public final void setPublicKey(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.Integer> publicKey) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getExpiry() {
        return null;
    }
    
    public final void setExpiry(@org.jetbrains.annotations.Nullable
    java.lang.String expiry) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.Integer> getKeyFingerprint() {
        return null;
    }
    
    public final void setKeyFingerprint(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.Integer> keyFingerprint) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getKeyFormat() {
        return null;
    }
    
    public final void setKeyFormat(@org.jetbrains.annotations.Nullable
    java.lang.String keyFormat) {
    }
}