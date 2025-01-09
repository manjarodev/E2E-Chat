package com.devbeans.io.chat.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u0003678B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020 H\u0016J\b\u0010/\u001a\u00020 H\u0016J\"\u00100\u001a\u0002012\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0016J\b\u00104\u001a\u00020 H\u0002J\b\u00105\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u001b\u001a\u00060\u001cR\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u00069"}, d2 = {"Lcom/devbeans/io/chat/services/BackgroundService;", "Landroid/app/Service;", "()V", "REQUEST_WEBSOCKET_STAY_OPEN_DELAY", "", "expiryReceiver", "Lcom/devbeans/io/chat/receiver/ExpiryReceiver;", "getExpiryReceiver", "()Lcom/devbeans/io/chat/receiver/ExpiryReceiver;", "mBurnOnRead", "Ljava/util/Timer;", "mDownloaderAnonymousTask", "mDownloaderGroupTask", "mDownloaderOneToOneTask", "mReceiver", "mReceiverViewOnce", "mSenderTask", "mSenderViewOnce", "mTimer", "receiverNew", "Landroid/content/BroadcastReceiver;", "getReceiverNew", "()Landroid/content/BroadcastReceiver;", "setReceiverNew", "(Landroid/content/BroadcastReceiver;)V", "webSocketKeepAliveTask", "Lcom/devbeans/io/chat/services/BackgroundService$WebSocketKeepAliveTask;", "webSocketStateCheckListener", "Lcom/devbeans/io/chat/services/BackgroundService$WebSocketStateCheckTask;", "getWebSocketStateCheckListener", "()Lcom/devbeans/io/chat/services/BackgroundService$WebSocketStateCheckTask;", "connectMQTT", "", "initConnection", "emqx", "Lcom/devbeans/io/chat/network/mqtt/EmqxHelper;", "connection", "Lcom/devbeans/io/chat/network/mqtt/Connection;", "isAppOnForeground", "", "context", "Landroid/content/Context;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "setupReceivers", "unRegisterReceivers", "Companion", "WebSocketKeepAliveTask", "WebSocketStateCheckTask", "app_debug"})
public final class BackgroundService extends android.app.Service {
    private final java.util.Timer mTimer = null;
    private final java.util.Timer mBurnOnRead = null;
    private java.util.Timer mSenderTask;
    private java.util.Timer mReceiver;
    private final java.util.Timer mSenderViewOnce = null;
    private final java.util.Timer mReceiverViewOnce = null;
    private java.util.Timer mDownloaderOneToOneTask;
    private java.util.Timer mDownloaderGroupTask;
    private java.util.Timer mDownloaderAnonymousTask;
    private final long REQUEST_WEBSOCKET_STAY_OPEN_DELAY = 0L;
    private final com.devbeans.io.chat.services.BackgroundService.WebSocketKeepAliveTask webSocketKeepAliveTask = null;
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.services.BackgroundService.WebSocketStateCheckTask webSocketStateCheckListener = null;
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.receiver.ExpiryReceiver expiryReceiver = null;
    @org.jetbrains.annotations.NotNull
    private android.content.BroadcastReceiver receiverNew;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.services.BackgroundService.Companion Companion = null;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.services.BackgroundService context;
    public static final int notify = 1000;
    public static final int notifySocket = 4000;
    public static final int notifyDownload = 2000;
    private static boolean isRunning = false;
    private static java.util.Timer timerConnect;
    
    public BackgroundService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.services.BackgroundService.WebSocketStateCheckTask getWebSocketStateCheckListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.receiver.ExpiryReceiver getExpiryReceiver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.BroadcastReceiver getReceiverNew() {
        return null;
    }
    
    public final void setReceiverNew(@org.jetbrains.annotations.NotNull
    android.content.BroadcastReceiver p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    /**
     * Setting up our local receivers essential for in application actions
     */
    private final void setupReceivers() {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class, java.lang.Exception.class})
    private final void connectMQTT() throws org.eclipse.paho.client.mqttv3.MqttException, java.lang.Exception {
    }
    
    public final boolean isAppOnForeground(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    public final void initConnection(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.mqtt.EmqxHelper emqx, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.mqtt.Connection connection) {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final void unRegisterReceivers() {
    }
    
    /**
     * Periodically request the web socket stay open if we are doing anything call related.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/services/BackgroundService$WebSocketKeepAliveTask;", "Ljava/lang/Runnable;", "(Lcom/devbeans/io/chat/services/BackgroundService;)V", "keepRunning", "", "run", "", "start", "stop", "app_debug"})
    final class WebSocketKeepAliveTask implements java.lang.Runnable {
        private boolean keepRunning = false;
        
        public WebSocketKeepAliveTask() {
            super();
        }
        
        @androidx.annotation.MainThread
        public final void start() {
        }
        
        @androidx.annotation.MainThread
        public final void stop() {
        }
        
        @androidx.annotation.MainThread
        @java.lang.Override
        public void run() {
        }
    }
    
    /**
     * Periodically request the web socket stay open if we are doing anything call related.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/services/BackgroundService$WebSocketStateCheckTask;", "Ljava/lang/Runnable;", "(Lcom/devbeans/io/chat/services/BackgroundService;)V", "keepRunning", "", "run", "", "start", "stop", "app_debug"})
    public final class WebSocketStateCheckTask implements java.lang.Runnable {
        private boolean keepRunning = false;
        
        public WebSocketStateCheckTask() {
            super();
        }
        
        @androidx.annotation.MainThread
        public final void start() {
        }
        
        @androidx.annotation.MainThread
        public final void stop() {
        }
        
        @androidx.annotation.MainThread
        @java.lang.Override
        public void run() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001aJ\u0006\u0010#\u001a\u00020\u001aR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/devbeans/io/chat/services/BackgroundService$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "context", "Lcom/devbeans/io/chat/services/BackgroundService;", "getContext", "()Lcom/devbeans/io/chat/services/BackgroundService;", "setContext", "(Lcom/devbeans/io/chat/services/BackgroundService;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "notify", "", "notifyDownload", "notifySocket", "timerConnect", "Ljava/util/Timer;", "checkConnectMqtt", "", "checkDisconnectMqtt", "createNotificationChannel", "notificationManager", "Landroid/app/NotificationManager;", "installPackage", "file", "Ljava/io/File;", "restart", "stop", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.services.BackgroundService getContext() {
            return null;
        }
        
        public final void setContext(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.services.BackgroundService p0) {
        }
        
        public final boolean isRunning() {
            return false;
        }
        
        public final void setRunning(boolean p0) {
        }
        
        public final void checkConnectMqtt() {
        }
        
        public final void checkDisconnectMqtt() {
        }
        
        @org.jetbrains.annotations.NotNull
        @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
        public final java.lang.String createNotificationChannel(@org.jetbrains.annotations.NotNull
        android.app.NotificationManager notificationManager) {
            return null;
        }
        
        public final void stop() {
        }
        
        public final void restart() {
        }
        
        public final void installPackage(@org.jetbrains.annotations.NotNull
        java.io.File file) {
        }
    }
}