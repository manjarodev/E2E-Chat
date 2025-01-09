package com.devbeans.io.chat.models;

import java.lang.System;

@androidx.annotation.Keep
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/devbeans/io/chat/models/KeyPairModel;", "", "keyPair", "Lcom/virgilsecurity/sdk/crypto/VirgilKeyPair;", "publicIdentifier", "", "(Lcom/virgilsecurity/sdk/crypto/VirgilKeyPair;[B)V", "getKeyPair", "()Lcom/virgilsecurity/sdk/crypto/VirgilKeyPair;", "setKeyPair", "(Lcom/virgilsecurity/sdk/crypto/VirgilKeyPair;)V", "getPublicIdentifier", "()[B", "setPublicIdentifier", "([B)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class KeyPairModel {
    @org.jetbrains.annotations.NotNull
    private com.virgilsecurity.sdk.crypto.VirgilKeyPair keyPair;
    @org.jetbrains.annotations.NotNull
    private byte[] publicIdentifier;
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.models.KeyPairModel copy(@org.jetbrains.annotations.NotNull
    com.virgilsecurity.sdk.crypto.VirgilKeyPair keyPair, @org.jetbrains.annotations.NotNull
    byte[] publicIdentifier) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public KeyPairModel(@org.jetbrains.annotations.NotNull
    com.virgilsecurity.sdk.crypto.VirgilKeyPair keyPair, @org.jetbrains.annotations.NotNull
    byte[] publicIdentifier) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.virgilsecurity.sdk.crypto.VirgilKeyPair component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.virgilsecurity.sdk.crypto.VirgilKeyPair getKeyPair() {
        return null;
    }
    
    public final void setKeyPair(@org.jetbrains.annotations.NotNull
    com.virgilsecurity.sdk.crypto.VirgilKeyPair p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getPublicIdentifier() {
        return null;
    }
    
    public final void setPublicIdentifier(@org.jetbrains.annotations.NotNull
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