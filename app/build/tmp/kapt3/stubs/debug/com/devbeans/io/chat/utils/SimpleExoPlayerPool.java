package com.devbeans.io.chat.utils;

import java.lang.System;

/**
 * ExoPlayerPool concrete instance which helps to manage a pool of SimpleExoPlayer objects
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0015J\b\u0010\u0007\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/utils/SimpleExoPlayerPool;", "Lcom/devbeans/io/chat/utils/ExoPlayerPool;", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createPlayer", "getMaxSimultaneousPlayback", "", "Companion", "app_debug"})
public final class SimpleExoPlayerPool extends com.devbeans.io.chat.utils.ExoPlayerPool<com.google.android.exoplayer2.SimpleExoPlayer> {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.SimpleExoPlayerPool.Companion Companion = null;
    private static final int MAXIMUM_RESERVED_PLAYERS = 1;
    private static final int MAXIMUM_SUPPORTED_PLAYBACK_PRE_23 = 6;
    private static final int MAXIMUM_SUPPORTED_PLAYBACK_PRE_23_LOW_MEM = 3;
    
    public SimpleExoPlayerPool(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(0);
    }
    
    /**
     * Tries to get the max number of instances that can be played back on the screen at a time, based off of
     * the device API level and decoder info.
     */
    @java.lang.Override
    protected int getMaxSimultaneousPlayback() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.annotation.MainThread
    @java.lang.Override
    protected com.google.android.exoplayer2.SimpleExoPlayer createPlayer() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/utils/SimpleExoPlayerPool$Companion;", "", "()V", "MAXIMUM_RESERVED_PLAYERS", "", "MAXIMUM_SUPPORTED_PLAYBACK_PRE_23", "MAXIMUM_SUPPORTED_PLAYBACK_PRE_23_LOW_MEM", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}