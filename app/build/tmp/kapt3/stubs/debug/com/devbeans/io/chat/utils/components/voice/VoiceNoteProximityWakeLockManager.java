package com.devbeans.io.chat.utils.components.voice;

import java.lang.System;

/**
 * Manages the WakeLock while a VoiceNote is playing back in the target activity.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\"#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteProximityWakeLockManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "mediaController", "Landroid/support/v4/media/session/MediaControllerCompat;", "(Landroidx/fragment/app/FragmentActivity;Landroid/support/v4/media/session/MediaControllerCompat;)V", "hardwareSensorEventListener", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteProximityWakeLockManager$HardwareSensorEventListener;", "mediaControllerCallback", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteProximityWakeLockManager$MediaControllerCallback;", "proximitySensor", "Landroid/hardware/Sensor;", "sensorManager", "Landroid/hardware/SensorManager;", "startTime", "", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "cleanUpWakeLock", "", "isActivityResumed", "", "isPlayerActive", "onPause", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "sendNewStreamTypeToPlayer", "newStreamType", "", "unregisterCallbacksAndRelease", "unregisterFromLifecycle", "HardwareSensorEventListener", "MediaControllerCallback", "app_debug"})
public final class VoiceNoteProximityWakeLockManager implements androidx.lifecycle.DefaultLifecycleObserver {
    private final androidx.fragment.app.FragmentActivity activity = null;
    private final android.support.v4.media.session.MediaControllerCompat mediaController = null;
    private final android.os.PowerManager.WakeLock wakeLock = null;
    private final android.hardware.SensorManager sensorManager = null;
    private final android.hardware.Sensor proximitySensor = null;
    private final com.devbeans.io.chat.utils.components.voice.VoiceNoteProximityWakeLockManager.MediaControllerCallback mediaControllerCallback = null;
    private final com.devbeans.io.chat.utils.components.voice.VoiceNoteProximityWakeLockManager.HardwareSensorEventListener hardwareSensorEventListener = null;
    private long startTime = -1L;
    
    public VoiceNoteProximityWakeLockManager(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull
    android.support.v4.media.session.MediaControllerCompat mediaController) {
        super();
    }
    
    @java.lang.Override
    public void onResume(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner owner) {
    }
    
    @java.lang.Override
    public void onPause(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner owner) {
    }
    
    public final void unregisterCallbacksAndRelease() {
    }
    
    public final void unregisterFromLifecycle() {
    }
    
    private final boolean isActivityResumed() {
        return false;
    }
    
    private final boolean isPlayerActive() {
        return false;
    }
    
    private final void cleanUpWakeLock() {
    }
    
    private final void sendNewStreamTypeToPlayer(int newStreamType) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteProximityWakeLockManager$MediaControllerCallback;", "Landroid/support/v4/media/session/MediaControllerCompat$Callback;", "(Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteProximityWakeLockManager;)V", "onPlaybackStateChanged", "", "state", "Landroid/support/v4/media/session/PlaybackStateCompat;", "app_debug"})
    public final class MediaControllerCallback extends android.support.v4.media.session.MediaControllerCompat.Callback {
        
        public MediaControllerCallback() {
            super();
        }
        
        @java.lang.Override
        public void onPlaybackStateChanged(@org.jetbrains.annotations.NotNull
        android.support.v4.media.session.PlaybackStateCompat state) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteProximityWakeLockManager$HardwareSensorEventListener;", "Landroid/hardware/SensorEventListener;", "(Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteProximityWakeLockManager;)V", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "app_debug"})
    public final class HardwareSensorEventListener implements android.hardware.SensorEventListener {
        
        public HardwareSensorEventListener() {
            super();
        }
        
        @java.lang.Override
        public void onSensorChanged(@org.jetbrains.annotations.NotNull
        android.hardware.SensorEvent event) {
        }
        
        @java.lang.Override
        public void onAccuracyChanged(@org.jetbrains.annotations.Nullable
        android.hardware.Sensor sensor, int accuracy) {
        }
    }
}