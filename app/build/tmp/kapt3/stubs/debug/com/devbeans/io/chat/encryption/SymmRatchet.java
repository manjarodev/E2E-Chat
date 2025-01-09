package com.devbeans.io.chat.encryption;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0017J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0005R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/devbeans/io/chat/encryption/SymmRatchet;", "", "key", "", "ratchet_name", "", "([BLjava/lang/String;)V", "chain_index", "", "getChain_index", "()I", "setChain_index", "(I)V", "chain_key", "getChain_key", "()[B", "setChain_key", "([B)V", "getRatchet_name", "()Ljava/lang/String;", "setRatchet_name", "(Ljava/lang/String;)V", "emptyKey", "Lkotlin/Pair;", "nextKey", "inp", "app_debug"})
public final class SymmRatchet {
    @org.jetbrains.annotations.NotNull
    private byte[] chain_key;
    @org.jetbrains.annotations.NotNull
    private java.lang.String ratchet_name;
    private int chain_index;
    
    public SymmRatchet(@org.jetbrains.annotations.NotNull
    byte[] key, @org.jetbrains.annotations.NotNull
    java.lang.String ratchet_name) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getChain_key() {
        return null;
    }
    
    public final void setChain_key(@org.jetbrains.annotations.NotNull
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRatchet_name() {
        return null;
    }
    
    public final void setRatchet_name(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getChain_index() {
        return 0;
    }
    
    public final void setChain_index(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<byte[], byte[]> nextKey(@org.jetbrains.annotations.NotNull
    java.lang.String inp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<byte[], byte[]> emptyKey() {
        return null;
    }
}