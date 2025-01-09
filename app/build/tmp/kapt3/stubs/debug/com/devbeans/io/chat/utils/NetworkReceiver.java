package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/utils/NetworkReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "checkAndUploadKeys", "", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "sendOfflineMessages", "CheckOnlineStatus", "Companion", "app_debug"})
public final class NetworkReceiver extends android.content.BroadcastReceiver {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.NetworkReceiver.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public NetworkReceiver() {
        super();
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
    }
    
    private final void checkAndUploadKeys() {
    }
    
    private final void sendOfflineMessages() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J%\u0010\b\u001a\u00020\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\n\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0014R\u0011\u0010\u0006\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/utils/NetworkReceiver$CheckOnlineStatus;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "(Lcom/devbeans/io/chat/utils/NetworkReceiver;)V", "isOnline", "()Z", "doInBackground", "p0", "", "([Ljava/lang/Void;)Ljava/lang/Boolean;", "onPostExecute", "", "result", "app_debug"})
    final class CheckOnlineStatus extends android.os.AsyncTask<java.lang.Void, java.lang.Integer, java.lang.Boolean> {
        
        public CheckOnlineStatus() {
            super();
        }
        
        @java.lang.Override
        protected void onPostExecute(boolean result) {
        }
        
        public final boolean isOnline() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        protected java.lang.Boolean doInBackground(@org.jetbrains.annotations.NotNull
        java.lang.Void... p0) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/utils/NetworkReceiver$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
    }
}