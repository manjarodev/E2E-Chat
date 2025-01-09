package com.devbeans.io.chat.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\"\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016JJ\u0010\u001b\u001a\u00020\t2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u001dj\b\u0012\u0004\u0012\u00020\u000e`\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010!\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006#"}, d2 = {"Lcom/devbeans/io/chat/services/KeyDeficiencyService;", "Landroid/app/Service;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "callNetworkingAPI", "", "chatId", "model", "Lcom/devbeans/io/chat/models/ManifestModel;", "sik", "Lcom/devbeans/io/chat/models/ChatKeyPair;", "payload", "Lcom/devbeans/io/chat/models/Payload;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "saveAllKeys", "allKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sikX", "ik", "uploadKeys", "Companion", "app_debug"})
public final class KeyDeficiencyService extends android.app.Service {
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.services.KeyDeficiencyService.Companion Companion = null;
    private static boolean isRunning = false;
    
    public KeyDeficiencyService() {
        super();
    }
    
    public final java.lang.String getTAG() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void saveAllKeys(java.util.ArrayList<com.devbeans.io.chat.models.ChatKeyPair> allKeys, java.lang.String chatId, com.devbeans.io.chat.models.ChatKeyPair sik, com.devbeans.io.chat.models.ChatKeyPair sikX, com.devbeans.io.chat.models.ChatKeyPair ik, com.devbeans.io.chat.models.Payload payload) {
    }
    
    private final void callNetworkingAPI(java.lang.String chatId, com.devbeans.io.chat.models.ManifestModel model, com.devbeans.io.chat.models.ChatKeyPair sik, com.devbeans.io.chat.models.Payload payload) {
    }
    
    private final void uploadKeys(com.devbeans.io.chat.models.ManifestModel model, java.lang.String chatId, com.devbeans.io.chat.models.ChatKeyPair sik, com.devbeans.io.chat.models.Payload payload) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/services/KeyDeficiencyService$Companion;", "", "()V", "isRunning", "", "()Z", "setRunning", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isRunning() {
            return false;
        }
        
        public final void setRunning(boolean p0) {
        }
    }
}