package com.devbeans.io.chat.receiver;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/devbeans/io/chat/receiver/ExpiryReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "MDM_PKG", "", "TAG", "kotlin.jvm.PlatformType", "action", "context", "Landroid/content/Context;", "data", "expire", "grace", "name", "retreat", "handleExpiry", "", "intent", "Landroid/content/Intent;", "handleGracePeriodStart", "handleSubscriptionEnd", "handleSubscriptionRenew", "onReceive", "sendReceivedAck", "app_debug"})
public final class ExpiryReceiver extends android.content.BroadcastReceiver {
    private final java.lang.String TAG = null;
    private final java.lang.String data = "data";
    private final java.lang.String name = "name";
    private final java.lang.String expire = "expire";
    private final java.lang.String grace = "grace";
    private final java.lang.String retreat = "retreat";
    private final java.lang.String MDM_PKG = "com.dev.io.mdm";
    private android.content.Context context;
    private java.lang.String action = "com.devbeans.io.chat.license";
    
    public ExpiryReceiver() {
        super();
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    private final void handleExpiry(android.content.Intent intent) {
    }
    
    private final void sendReceivedAck(java.lang.String data) {
    }
    
    private final void handleSubscriptionEnd() {
    }
    
    private final void handleGracePeriodStart() {
    }
    
    private final void handleSubscriptionRenew() {
    }
}