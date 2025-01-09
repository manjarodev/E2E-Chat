package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\tR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\tR\u0011\u0010\u001f\u001a\u00020 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\tR\u0013\u0010%\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\tR\u0013\u0010\'\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\tR\u0013\u0010)\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\t\u00a8\u0006,"}, d2 = {"Lcom/devbeans/io/chat/utils/Configurations;", "", "()V", "DB_VERSION", "", "PIN", "", "baseUploadsUrl", "getBaseUploadsUrl", "()Ljava/lang/String;", "baseUrl", "getBaseUrl", "certPinner", "Lokhttp3/CertificatePinner;", "getCertPinner", "()Lokhttp3/CertificatePinner;", "envName", "getEnvName", "environment", "Lcom/devbeans/io/chat/utils/Configurations$Environments;", "getEnvironment", "()Lcom/devbeans/io/chat/utils/Configurations$Environments;", "isDevelopment", "", "()Z", "isLocal", "isProduction", "kDSBaseUrl", "getKDSBaseUrl", "mqttBroker", "getMqttBroker", "mqttPort", "", "getMqttPort", "()I", "pingDevelopmentUrl", "getPingDevelopmentUrl", "pingKDSUrl", "getPingKDSUrl", "uploadsUrl", "getUploadsUrl", "webSocketURL", "getWebSocketURL", "Environments", "app_debug"})
public final class Configurations {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.Configurations INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final com.devbeans.io.chat.utils.Configurations.Environments environment = com.devbeans.io.chat.utils.Configurations.Environments.Development;
    public static final long DB_VERSION = 1L;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PIN = "sha256/t1UYWLBeg+bdSqKQBRGxB6yIg+dAwyXSdWkStwJ6JWU=";
    
    private Configurations() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.Configurations.Environments getEnvironment() {
        return null;
    }
    
    public final boolean isProduction() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final okhttp3.CertificatePinner getCertPinner() {
        return null;
    }
    
    public final boolean isDevelopment() {
        return false;
    }
    
    public final boolean isLocal() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBaseUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getKDSBaseUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPingKDSUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPingDevelopmentUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMqttBroker() {
        return null;
    }
    
    public final int getMqttPort() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUploadsUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getWebSocketURL() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBaseUploadsUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEnvName() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/Configurations$Environments;", "", "(Ljava/lang/String;I)V", "Development", "Production", "Local", "app_debug"})
    public static enum Environments {
        /*public static final*/ Development /* = new Development() */,
        /*public static final*/ Production /* = new Production() */,
        /*public static final*/ Local /* = new Local() */;
        
        Environments() {
        }
    }
}