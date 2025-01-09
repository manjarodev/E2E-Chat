package com.devbeans.io.chat.utils;

import java.lang.System;

/**
 * ExoPlayer pool which allows for the quick and efficient reuse of ExoPlayer instances instead of creating and destroying them
 * as needed. This class will, if added as an AppForegroundObserver.Listener, evict players when the app is backgrounded to try to
 * make sure it is a good citizen on the device.
 *
 * This class also supports reserving a number of players, which count against its total specified by getMaxSimultaneousPlayback. These
 * players will be returned first when a player is requested via require.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\r\u0010\n\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0002\u00a2\u0006\u0002\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0003\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0014\u001a\u00020\u0005H$J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\u0015\u0010\u0007\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0007\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\r\u0010\u001c\u001a\u00028\u0000H\u0007\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/devbeans/io/chat/utils/ExoPlayerPool;", "T", "Lcom/google/android/exoplayer2/ExoPlayer;", "Lcom/devbeans/io/chat/utils/AppForegroundObserver$Listener;", "maximumReservedPlayers", "", "(I)V", "pool", "", "Lcom/devbeans/io/chat/utils/ExoPlayerPool$PoolState;", "createPlayer", "()Lcom/google/android/exoplayer2/ExoPlayer;", "createPoolStateForNewEntry", "allowReserved", "", "findAvailablePlayer", "(Z)Lcom/google/android/exoplayer2/ExoPlayer;", "findFirstReservedAndAvailablePlayer", "findFirstUnreservedAndAvailablePlayer", "get", "getMaxSimultaneousPlayback", "getMaximumAllowed", "onBackground", "", "exoPlayer", "(Lcom/google/android/exoplayer2/ExoPlayer;)V", "poolStats", "", "require", "PoolState", "PoolStats", "app_debug"})
public abstract class ExoPlayerPool<T extends com.google.android.exoplayer2.ExoPlayer> implements com.devbeans.io.chat.utils.AppForegroundObserver.Listener {
    private final int maximumReservedPlayers = 0;
    private final java.util.Map<T, com.devbeans.io.chat.utils.ExoPlayerPool.PoolState> pool = null;
    
    public ExoPlayerPool(int maximumReservedPlayers) {
        super();
    }
    
    /**
     * Try to get a player from the non-reserved pool.
     *
     * @return A player if one is available, otherwise null
     */
    @org.jetbrains.annotations.Nullable
    @androidx.annotation.MainThread
    public final T get() {
        return null;
    }
    
    /**
     * Get a player, preferring reserved players.
     *
     * @return A non-null player instance. If one is not available, an exception is thrown.
     * @throws IllegalStateException if no player is available.
     */
    @org.jetbrains.annotations.NotNull
    @androidx.annotation.MainThread
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    public final T require() {
        return null;
    }
    
    /**
     * Returns a player to the pool. If the player is not from the pool, an exception is thrown.
     *
     * @throws IllegalArgumentException if the player passed is not in the pool
     */
    @androidx.annotation.MainThread
    public final void pool(@org.jetbrains.annotations.NotNull
    T exoPlayer) {
    }
    
    @androidx.annotation.MainThread
    private final T get(boolean allowReserved) {
        return null;
    }
    
    private final int getMaximumAllowed(boolean allowReserved) {
        return 0;
    }
    
    private final com.devbeans.io.chat.utils.ExoPlayerPool.PoolState createPoolStateForNewEntry(boolean allowReserved) {
        return null;
    }
    
    private final T findAvailablePlayer(boolean allowReserved) {
        return null;
    }
    
    private final T findFirstReservedAndAvailablePlayer() {
        return null;
    }
    
    private final T findFirstUnreservedAndAvailablePlayer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    protected abstract T createPlayer();
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public void onBackground() {
    }
    
    private final java.lang.String poolStats() {
        return null;
    }
    
    protected abstract int getMaxSimultaneousPlayback();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/devbeans/io/chat/utils/ExoPlayerPool$PoolStats;", "", "created", "", "maxUnreserved", "maxReserved", "unreservedAndAvailable", "reservedAndAvailable", "unreserved", "reserved", "(IIIIIII)V", "getCreated", "()I", "getMaxReserved", "getMaxUnreserved", "getReserved", "getReservedAndAvailable", "getUnreserved", "getUnreservedAndAvailable", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    static final class PoolStats {
        private final int created = 0;
        private final int maxUnreserved = 0;
        private final int maxReserved = 0;
        private final int unreservedAndAvailable = 0;
        private final int reservedAndAvailable = 0;
        private final int unreserved = 0;
        private final int reserved = 0;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.ExoPlayerPool.PoolStats copy(int created, int maxUnreserved, int maxReserved, int unreservedAndAvailable, int reservedAndAvailable, int unreserved, int reserved) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public PoolStats() {
            super();
        }
        
        public PoolStats(int created, int maxUnreserved, int maxReserved, int unreservedAndAvailable, int reservedAndAvailable, int unreserved, int reserved) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getCreated() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int getMaxUnreserved() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int getMaxReserved() {
            return 0;
        }
        
        public final int component4() {
            return 0;
        }
        
        public final int getUnreservedAndAvailable() {
            return 0;
        }
        
        public final int component5() {
            return 0;
        }
        
        public final int getReservedAndAvailable() {
            return 0;
        }
        
        public final int component6() {
            return 0;
        }
        
        public final int getUnreserved() {
            return 0;
        }
        
        public final int component7() {
            return 0;
        }
        
        public final int getReserved() {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/devbeans/io/chat/utils/ExoPlayerPool$PoolState;", "", "available", "", "reserved", "(ZZ)V", "getAvailable", "()Z", "getReserved", "reservedAndAvailable", "getReservedAndAvailable", "unreservedAndAvailable", "getUnreservedAndAvailable", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
    static final class PoolState {
        private final boolean available = false;
        private final boolean reserved = false;
        private final boolean unreservedAndAvailable = false;
        private final boolean reservedAndAvailable = false;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.ExoPlayerPool.PoolState copy(boolean available, boolean reserved) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public PoolState(boolean available, boolean reserved) {
            super();
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean getAvailable() {
            return false;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean getReserved() {
            return false;
        }
        
        public final boolean getUnreservedAndAvailable() {
            return false;
        }
        
        public final boolean getReservedAndAvailable() {
            return false;
        }
    }
}