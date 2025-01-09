package com.devbeans.io.chat.utils;

import java.lang.System;

/**
 * Holds on to and manages a wake-lock for the device proximity sensor.
 *
 * This class will register itself as an observe of the given activity's lifecycle and automatically
 * release the lock if it holds one in onPause
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/devbeans/io/chat/utils/VoiceRecorderWakeLock;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;)V", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "acquire", "", "onPause", "owner", "Landroidx/lifecycle/LifecycleOwner;", "release", "app_debug"})
public final class VoiceRecorderWakeLock implements androidx.lifecycle.DefaultLifecycleObserver {
    private final androidx.activity.ComponentActivity activity = null;
    private android.os.PowerManager.WakeLock wakeLock;
    
    public VoiceRecorderWakeLock(@org.jetbrains.annotations.NotNull
    androidx.activity.ComponentActivity activity) {
        super();
    }
    
    public final void acquire() {
    }
    
    public final void release() {
    }
    
    @java.lang.Override
    public void onPause(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner owner) {
    }
}