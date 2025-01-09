package com.devbeans.io.chat.utils.views;

import java.lang.System;

/**
 * Class to manage video playback in preview screen.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J\r\u0010\u0015\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/devbeans/io/chat/utils/views/VideoControlsDelegate;", "", "()V", "playWhenReady", "", "Landroid/net/Uri;", "", "player", "Lcom/devbeans/io/chat/utils/views/VideoControlsDelegate$Player;", "attachPlayer", "", "uri", "videoPlayer", "Lcom/devbeans/io/chat/utils/VideoPlayer;", "isGif", "detachPlayer", "getPlayerState", "Lcom/devbeans/io/chat/utils/views/VideoControlsDelegate$PlayerState;", "onPlayerPositionDiscontinuity", "reason", "", "pause", "()Lkotlin/Unit;", "restart", "resume", "Player", "PlayerState", "app_debug"})
public final class VideoControlsDelegate {
    private final java.util.Map<android.net.Uri, java.lang.Boolean> playWhenReady = null;
    private com.devbeans.io.chat.utils.views.VideoControlsDelegate.Player player;
    
    public VideoControlsDelegate() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.utils.views.VideoControlsDelegate.PlayerState getPlayerState(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlin.Unit pause() {
        return null;
    }
    
    public final void resume(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    public final void restart() {
    }
    
    public final void onPlayerPositionDiscontinuity(int reason) {
    }
    
    public final void attachPlayer(@org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.VideoPlayer videoPlayer, boolean isGif) {
    }
    
    public final void detachPlayer() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\tH\u00c6\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/devbeans/io/chat/utils/views/VideoControlsDelegate$Player;", "", "uri", "Landroid/net/Uri;", "videoPlayer", "Lcom/devbeans/io/chat/utils/VideoPlayer;", "isGif", "", "loopCount", "", "(Landroid/net/Uri;Lcom/devbeans/io/chat/utils/VideoPlayer;ZI)V", "()Z", "getLoopCount", "()I", "getUri", "()Landroid/net/Uri;", "getVideoPlayer", "()Lcom/devbeans/io/chat/utils/VideoPlayer;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
    static final class Player {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "uri")
        private final android.net.Uri uri = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "videoPlayer")
        private final com.devbeans.io.chat.utils.VideoPlayer videoPlayer = null;
        @com.google.gson.annotations.SerializedName(value = "isGif")
        private final boolean isGif = false;
        @com.google.gson.annotations.SerializedName(value = "loopCount")
        private final int loopCount = 0;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.views.VideoControlsDelegate.Player copy(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, @org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.utils.VideoPlayer videoPlayer, boolean isGif, int loopCount) {
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
        
        public Player() {
            super();
        }
        
        public Player(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, @org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.utils.VideoPlayer videoPlayer, boolean isGif, int loopCount) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.net.Uri component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.net.Uri getUri() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.utils.VideoPlayer component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.utils.VideoPlayer getVideoPlayer() {
            return null;
        }
        
        public final boolean component3() {
            return false;
        }
        
        public final boolean isGif() {
            return false;
        }
        
        public final int component4() {
            return 0;
        }
        
        public final int getLoopCount() {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00c6\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/devbeans/io/chat/utils/views/VideoControlsDelegate$PlayerState;", "", "mediaUri", "Landroid/net/Uri;", "position", "", "duration", "isGif", "", "loopCount", "", "(Landroid/net/Uri;JJZI)V", "getDuration", "()J", "()Z", "getLoopCount", "()I", "getMediaUri", "()Landroid/net/Uri;", "getPosition", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
    public static final class PlayerState {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "mediaUri")
        private final android.net.Uri mediaUri = null;
        @com.google.gson.annotations.SerializedName(value = "position")
        private final long position = 0L;
        @com.google.gson.annotations.SerializedName(value = "duration")
        private final long duration = 0L;
        @com.google.gson.annotations.SerializedName(value = "isGif")
        private final boolean isGif = false;
        @com.google.gson.annotations.SerializedName(value = "loopCount")
        private final int loopCount = 0;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.views.VideoControlsDelegate.PlayerState copy(@org.jetbrains.annotations.NotNull
        android.net.Uri mediaUri, long position, long duration, boolean isGif, int loopCount) {
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
        
        public PlayerState(@org.jetbrains.annotations.NotNull
        android.net.Uri mediaUri, long position, long duration, boolean isGif, int loopCount) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.net.Uri component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.net.Uri getMediaUri() {
            return null;
        }
        
        public final long component2() {
            return 0L;
        }
        
        public final long getPosition() {
            return 0L;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final long getDuration() {
            return 0L;
        }
        
        public final boolean component4() {
            return false;
        }
        
        public final boolean isGif() {
            return false;
        }
        
        public final int component5() {
            return 0;
        }
        
        public final int getLoopCount() {
            return 0;
        }
    }
}