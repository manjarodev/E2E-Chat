package com.devbeans.io.chat.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/devbeans/io/chat/models/ManifestModel;", "", "()V", "chatKeyClass", "Ljava/util/ArrayList;", "Lcom/devbeans/io/chat/models/ManifestModel$ChatKeyClass;", "getChatKeyClass", "()Ljava/util/ArrayList;", "setChatKeyClass", "(Ljava/util/ArrayList;)V", "expiry", "", "getExpiry", "()I", "setExpiry", "(I)V", "fingerprintPubKey", "", "getFingerprintPubKey", "()Ljava/lang/String;", "setFingerprintPubKey", "(Ljava/lang/String;)V", "identityPriKey", "getIdentityPriKey", "setIdentityPriKey", "identityPubKey", "getIdentityPubKey", "setIdentityPubKey", "ChatKeyClass", "SIKClass", "app_debug"})
public final class ManifestModel {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "identityPubKey")
    private java.lang.String identityPubKey;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "identityPriKey")
    private java.lang.String identityPriKey;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "fingerprintPubKey")
    private java.lang.String fingerprintPubKey;
    @com.google.gson.annotations.SerializedName(value = "expiry")
    private int expiry = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "chatKeyClass")
    private java.util.ArrayList<com.devbeans.io.chat.models.ManifestModel.ChatKeyClass> chatKeyClass;
    
    public ManifestModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getIdentityPubKey() {
        return null;
    }
    
    public final void setIdentityPubKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getIdentityPriKey() {
        return null;
    }
    
    public final void setIdentityPriKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFingerprintPubKey() {
        return null;
    }
    
    public final void setFingerprintPubKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final int getExpiry() {
        return 0;
    }
    
    public final void setExpiry(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.devbeans.io.chat.models.ManifestModel.ChatKeyClass> getChatKeyClass() {
        return null;
    }
    
    public final void setChatKeyClass(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.devbeans.io.chat.models.ManifestModel.ChatKeyClass> p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/devbeans/io/chat/models/ManifestModel$ChatKeyClass;", "", "fingerprint", "", "pubkeys", "expiry", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getExpiry", "()I", "setExpiry", "(I)V", "getFingerprint", "()Ljava/lang/String;", "setFingerprint", "(Ljava/lang/String;)V", "getPubkeys", "setPubkeys", "app_debug"})
    public static final class ChatKeyClass {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "fingerprint")
        @com.google.gson.annotations.Expose
        private java.lang.String fingerprint;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "pubkeys")
        @com.google.gson.annotations.Expose
        private java.lang.String pubkeys;
        @com.google.gson.annotations.SerializedName(value = "expiry")
        @com.google.gson.annotations.Expose
        private int expiry;
        
        public ChatKeyClass(@org.jetbrains.annotations.NotNull
        java.lang.String fingerprint, @org.jetbrains.annotations.NotNull
        java.lang.String pubkeys, int expiry) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getFingerprint() {
            return null;
        }
        
        public final void setFingerprint(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPubkeys() {
            return null;
        }
        
        public final void setPubkeys(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        public final int getExpiry() {
            return 0;
        }
        
        public final void setExpiry(int p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/models/ManifestModel$SIKClass;", "", "serverIdentityPubKey", "", "serverIdentityPubKeyX", "serverFingerprintPubKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getServerFingerprintPubKey", "()Ljava/lang/String;", "setServerFingerprintPubKey", "(Ljava/lang/String;)V", "getServerIdentityPubKey", "setServerIdentityPubKey", "getServerIdentityPubKeyX", "setServerIdentityPubKeyX", "app_debug"})
    public static final class SIKClass {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "serverIdentityPubKey")
        @com.google.gson.annotations.Expose
        private java.lang.String serverIdentityPubKey;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "serverIdentityPubKeyX")
        @com.google.gson.annotations.Expose
        private java.lang.String serverIdentityPubKeyX;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "serverFingerprintPubKey")
        @com.google.gson.annotations.Expose
        private java.lang.String serverFingerprintPubKey;
        
        public SIKClass(@org.jetbrains.annotations.NotNull
        java.lang.String serverIdentityPubKey, @org.jetbrains.annotations.NotNull
        java.lang.String serverIdentityPubKeyX, @org.jetbrains.annotations.NotNull
        java.lang.String serverFingerprintPubKey) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getServerIdentityPubKey() {
            return null;
        }
        
        public final void setServerIdentityPubKey(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getServerIdentityPubKeyX() {
            return null;
        }
        
        public final void setServerIdentityPubKeyX(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getServerFingerprintPubKey() {
            return null;
        }
        
        public final void setServerFingerprintPubKey(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
    }
}