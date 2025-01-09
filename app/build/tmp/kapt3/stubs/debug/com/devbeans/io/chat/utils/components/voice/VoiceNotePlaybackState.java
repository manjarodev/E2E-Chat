package com.devbeans.io.chat.utils.components.voice;

import java.lang.System;

/**
 * Domain-level state object representing the state of the currently playing voice note.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u0000J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\'H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState;", "", "uri", "Landroid/net/Uri;", "playheadPositionMillis", "", "trackDuration", "isAutoReset", "", "speed", "", "isPlaying", "clipType", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType;", "(Landroid/net/Uri;JJZFZLcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType;)V", "getClipType", "()Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType;", "()Z", "getPlayheadPositionMillis", "()J", "getSpeed", "()F", "getTrackDuration", "getUri", "()Landroid/net/Uri;", "asPaused", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "ClipType", "Companion", "app_debug"})
public final class VoiceNotePlaybackState {
    
    /**
     * @return Uri of the currently playing AudioSlide
     */
    @org.jetbrains.annotations.NotNull
    private final android.net.Uri uri = null;
    
    /**
     * @return The last known playhead position
     */
    private final long playheadPositionMillis = 0L;
    
    /**
     * @return The track duration in ms
     */
    private final long trackDuration = 0L;
    
    /**
     * @return true if we should reset the currently playing clip.
     */
    private final boolean isAutoReset = false;
    
    /**
     * @return The current playback speed factor
     */
    private final float speed = 0.0F;
    
    /**
     * @return Whether we are playing or paused
     */
    private final boolean isPlaying = false;
    
    /**
     * @return Information about the type this clip represents.
     */
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType clipType = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmField
    public static final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState NONE = null;
    
    /**
     * Domain-level state object representing the state of the currently playing voice note.
     */
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState copy(@org.jetbrains.annotations.NotNull
    android.net.Uri uri, long playheadPositionMillis, long trackDuration, boolean isAutoReset, float speed, boolean isPlaying, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType clipType) {
        return null;
    }
    
    /**
     * Domain-level state object representing the state of the currently playing voice note.
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Domain-level state object representing the state of the currently playing voice note.
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Domain-level state object representing the state of the currently playing voice note.
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public VoiceNotePlaybackState(@org.jetbrains.annotations.NotNull
    android.net.Uri uri, long playheadPositionMillis, long trackDuration, boolean isAutoReset, float speed, boolean isPlaying, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType clipType) {
        super();
    }
    
    /**
     * @return Uri of the currently playing AudioSlide
     */
    @org.jetbrains.annotations.NotNull
    public final android.net.Uri component1() {
        return null;
    }
    
    /**
     * @return Uri of the currently playing AudioSlide
     */
    @org.jetbrains.annotations.NotNull
    public final android.net.Uri getUri() {
        return null;
    }
    
    /**
     * @return The last known playhead position
     */
    public final long component2() {
        return 0L;
    }
    
    /**
     * @return The last known playhead position
     */
    public final long getPlayheadPositionMillis() {
        return 0L;
    }
    
    /**
     * @return The track duration in ms
     */
    public final long component3() {
        return 0L;
    }
    
    /**
     * @return The track duration in ms
     */
    public final long getTrackDuration() {
        return 0L;
    }
    
    /**
     * @return true if we should reset the currently playing clip.
     */
    public final boolean component4() {
        return false;
    }
    
    /**
     * @return true if we should reset the currently playing clip.
     */
    public final boolean isAutoReset() {
        return false;
    }
    
    /**
     * @return The current playback speed factor
     */
    public final float component5() {
        return 0.0F;
    }
    
    /**
     * @return The current playback speed factor
     */
    public final float getSpeed() {
        return 0.0F;
    }
    
    /**
     * @return Whether we are playing or paused
     */
    public final boolean component6() {
        return false;
    }
    
    /**
     * @return Whether we are playing or paused
     */
    public final boolean isPlaying() {
        return false;
    }
    
    /**
     * @return Information about the type this clip represents.
     */
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType component7() {
        return null;
    }
    
    /**
     * @return Information about the type this clip represents.
     */
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType getClipType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState asPaused() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType;", "", "()V", "Draft", "Idle", "Message", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType$Draft;", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType$Idle;", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType$Message;", "app_debug"})
    public static abstract class ClipType {
        
        private ClipType() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType$Message;", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType;", "messageId", "", "senderId", "", "threadRecipientId", "messagePosition", "threadId", "timestamp", "(JLjava/lang/String;Ljava/lang/String;JJJ)V", "getMessageId", "()J", "getMessagePosition", "getSenderId", "()Ljava/lang/String;", "getThreadId", "getThreadRecipientId", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Message extends com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType {
            private final long messageId = 0L;
            @org.jetbrains.annotations.NotNull
            private final java.lang.String senderId = null;
            @org.jetbrains.annotations.NotNull
            private final java.lang.String threadRecipientId = null;
            private final long messagePosition = 0L;
            private final long threadId = 0L;
            private final long timestamp = 0L;
            
            @org.jetbrains.annotations.NotNull
            public final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType.Message copy(long messageId, @org.jetbrains.annotations.NotNull
            java.lang.String senderId, @org.jetbrains.annotations.NotNull
            java.lang.String threadRecipientId, long messagePosition, long threadId, long timestamp) {
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
            
            public Message(long messageId, @org.jetbrains.annotations.NotNull
            java.lang.String senderId, @org.jetbrains.annotations.NotNull
            java.lang.String threadRecipientId, long messagePosition, long threadId, long timestamp) {
                super();
            }
            
            public final long component1() {
                return 0L;
            }
            
            public final long getMessageId() {
                return 0L;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getSenderId() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component3() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getThreadRecipientId() {
                return null;
            }
            
            public final long component4() {
                return 0L;
            }
            
            public final long getMessagePosition() {
                return 0L;
            }
            
            public final long component5() {
                return 0L;
            }
            
            public final long getThreadId() {
                return 0L;
            }
            
            public final long component6() {
                return 0L;
            }
            
            public final long getTimestamp() {
                return 0L;
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType$Draft;", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType;", "()V", "app_debug"})
        public static final class Draft extends com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType {
            @org.jetbrains.annotations.NotNull
            public static final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType.Draft INSTANCE = null;
            
            private Draft() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType$Idle;", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$ClipType;", "()V", "app_debug"})
        public static final class Idle extends com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType {
            @org.jetbrains.annotations.NotNull
            public static final com.devbeans.io.chat.utils.components.voice.VoiceNotePlaybackState.ClipType.Idle INSTANCE = null;
            
            private Idle() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState$Companion;", "", "()V", "NONE", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNotePlaybackState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}