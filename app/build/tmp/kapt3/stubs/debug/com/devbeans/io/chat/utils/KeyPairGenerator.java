package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002!\'B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`%J\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00160\tj\b\u0012\u0004\u0012\u00020\u0016`%R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f\u00a8\u0006("}, d2 = {"Lcom/devbeans/io/chat/utils/KeyPairGenerator;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "arrayList", "Ljava/util/ArrayList;", "Lcom/devbeans/io/chat/models/KeyPairModel;", "getArrayList", "()Ljava/util/ArrayList;", "setArrayList", "(Ljava/util/ArrayList;)V", "crypto", "Lcom/virgilsecurity/sdk/crypto/VirgilCrypto;", "getCrypto", "()Lcom/virgilsecurity/sdk/crypto/VirgilCrypto;", "setCrypto", "(Lcom/virgilsecurity/sdk/crypto/VirgilCrypto;)V", "keyPairList", "Lcom/devbeans/io/chat/models/ChatKeyPair;", "getKeyPairList", "convertCurveToX25519", "key", "generateDHNextKeyPair", "Lcom/devbeans/io/chat/encryption/EK;", "channelIdentifier", "generateKeyPair", "generateKeyPairs", "generateKeys", "", "keysGenerated", "Lcom/devbeans/io/chat/utils/KeyPairGenerator$keysGenerated;", "getAVSecretKey", "getAllKeys", "Lkotlin/collections/ArrayList;", "getChatKeyList", "sikGenerated", "app_debug"})
public final class KeyPairGenerator {
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.devbeans.io.chat.models.KeyPairModel> arrayList;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.devbeans.io.chat.models.ChatKeyPair> keyPairList = null;
    @org.jetbrains.annotations.NotNull
    private com.virgilsecurity.sdk.crypto.VirgilCrypto crypto;
    private final java.lang.String TAG = null;
    
    public KeyPairGenerator() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.devbeans.io.chat.models.KeyPairModel> getArrayList() {
        return null;
    }
    
    public final void setArrayList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.devbeans.io.chat.models.KeyPairModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.devbeans.io.chat.models.ChatKeyPair> getKeyPairList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.virgilsecurity.sdk.crypto.VirgilCrypto getCrypto() {
        return null;
    }
    
    public final void setCrypto(@org.jetbrains.annotations.NotNull
    com.virgilsecurity.sdk.crypto.VirgilCrypto p0) {
    }
    
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final void generateKeys(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.KeyPairGenerator.keysGenerated keysGenerated) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.ChatKeyPair generateKeyPairs() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.ChatKeyPair convertCurveToX25519(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.ChatKeyPair key) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.devbeans.io.chat.models.KeyPairModel> getAllKeys() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.devbeans.io.chat.models.ChatKeyPair> getChatKeyList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.models.ChatKeyPair generateKeyPair(@org.jetbrains.annotations.NotNull
    java.lang.String channelIdentifier) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.encryption.EK generateDHNextKeyPair(@org.jetbrains.annotations.NotNull
    java.lang.String channelIdentifier) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAVSecretKey() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/chat/utils/KeyPairGenerator$keysGenerated;", "", "onKeysGenerated", "", "app_debug"})
    public static abstract interface keysGenerated {
        
        public abstract void onKeysGenerated();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/chat/utils/KeyPairGenerator$sikGenerated;", "", "onSikGenerated", "", "app_debug"})
    public static abstract interface sikGenerated {
        
        public abstract void onSikGenerated();
    }
}