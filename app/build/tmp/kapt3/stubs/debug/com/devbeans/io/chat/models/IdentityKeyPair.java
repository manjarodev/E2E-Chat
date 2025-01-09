package com.devbeans.io.chat.models;

import java.lang.System;

@androidx.room.Entity
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/devbeans/io/chat/models/IdentityKeyPair;", "", "id", "", "privateKeyByte", "", "identifier", "pubPrivateKeyByte", "(I[B[B[B)V", "getId", "()I", "setId", "(I)V", "getIdentifier", "()[B", "setIdentifier", "([B)V", "getPrivateKeyByte", "setPrivateKeyByte", "getPubPrivateKeyByte", "setPubPrivateKeyByte", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class IdentityKeyPair {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "privateKeyByte")
    private byte[] privateKeyByte;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "identifier")
    private byte[] identifier;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "pubPrivateKeyByte")
    private byte[] pubPrivateKeyByte;
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.models.IdentityKeyPair copy(int id, @org.jetbrains.annotations.Nullable
    byte[] privateKeyByte, @org.jetbrains.annotations.Nullable
    byte[] identifier, @org.jetbrains.annotations.Nullable
    byte[] pubPrivateKeyByte) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public IdentityKeyPair() {
        super();
    }
    
    public IdentityKeyPair(int id, @org.jetbrains.annotations.Nullable
    byte[] privateKeyByte, @org.jetbrains.annotations.Nullable
    byte[] identifier, @org.jetbrains.annotations.Nullable
    byte[] pubPrivateKeyByte) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] getPrivateKeyByte() {
        return null;
    }
    
    public final void setPrivateKeyByte(@org.jetbrains.annotations.Nullable
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] getIdentifier() {
        return null;
    }
    
    public final void setIdentifier(@org.jetbrains.annotations.Nullable
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] getPubPrivateKeyByte() {
        return null;
    }
    
    public final void setPubPrivateKeyByte(@org.jetbrains.annotations.Nullable
    byte[] p0) {
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
}