package com.devbeans.io.chat.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\"\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016JB\u0010\u0019\u001a\u00020\t2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u001bj\b\u0012\u0004\u0012\u00020\u000e`\u001c2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J \u0010\u001f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006!"}, d2 = {"Lcom/devbeans/io/chat/services/SavingKeysService;", "Landroid/app/Service;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "callNetworkingAPI", "", "chatId", "model", "Lcom/devbeans/io/chat/models/ManifestModel;", "sik", "Lcom/devbeans/io/chat/models/ChatKeyPair;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "saveAllKeys", "allKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sikX", "ik", "uploadKeys", "Companion", "app_debug"})
public final class SavingKeysService extends android.app.Service {
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.services.SavingKeysService.Companion Companion = null;
    
    public SavingKeysService() {
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
    
    private final void saveAllKeys(java.util.ArrayList<com.devbeans.io.chat.models.ChatKeyPair> allKeys, java.lang.String chatId, com.devbeans.io.chat.models.ChatKeyPair sik, com.devbeans.io.chat.models.ChatKeyPair sikX, com.devbeans.io.chat.models.ChatKeyPair ik) {
    }
    
    private final void callNetworkingAPI(java.lang.String chatId, com.devbeans.io.chat.models.ManifestModel model, com.devbeans.io.chat.models.ChatKeyPair sik) {
    }
    
    private final void uploadKeys(com.devbeans.io.chat.models.ManifestModel model, java.lang.String chatId, com.devbeans.io.chat.models.ChatKeyPair sik) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/services/SavingKeysService$Companion;", "", "()V", "createNotificationChannel", "", "notificationManager", "Landroid/app/NotificationManager;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
        public final java.lang.String createNotificationChannel(@org.jetbrains.annotations.NotNull
        android.app.NotificationManager notificationManager) {
            return null;
        }
    }
}