package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\n\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand;", "", "()V", "CloseEmojiSearch", "EmojiInsert", "EmojiKeyEvent", "GoToCapture", "GoToText", "OpenEmojiSearch", "ResumeEntryTransition", "SaveMedia", "StartCropAndRotate", "StartDraw", "Lcom/devbeans/io/chat/utils/HudCommand$CloseEmojiSearch;", "Lcom/devbeans/io/chat/utils/HudCommand$EmojiInsert;", "Lcom/devbeans/io/chat/utils/HudCommand$EmojiKeyEvent;", "Lcom/devbeans/io/chat/utils/HudCommand$GoToCapture;", "Lcom/devbeans/io/chat/utils/HudCommand$GoToText;", "Lcom/devbeans/io/chat/utils/HudCommand$OpenEmojiSearch;", "Lcom/devbeans/io/chat/utils/HudCommand$ResumeEntryTransition;", "Lcom/devbeans/io/chat/utils/HudCommand$SaveMedia;", "Lcom/devbeans/io/chat/utils/HudCommand$StartCropAndRotate;", "Lcom/devbeans/io/chat/utils/HudCommand$StartDraw;", "app_debug"})
public abstract class HudCommand {
    
    private HudCommand() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$StartDraw;", "Lcom/devbeans/io/chat/utils/HudCommand;", "()V", "app_debug"})
    public static final class StartDraw extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.HudCommand.StartDraw INSTANCE = null;
        
        private StartDraw() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$StartCropAndRotate;", "Lcom/devbeans/io/chat/utils/HudCommand;", "()V", "app_debug"})
    public static final class StartCropAndRotate extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.HudCommand.StartCropAndRotate INSTANCE = null;
        
        private StartCropAndRotate() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$SaveMedia;", "Lcom/devbeans/io/chat/utils/HudCommand;", "()V", "app_debug"})
    public static final class SaveMedia extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.HudCommand.SaveMedia INSTANCE = null;
        
        private SaveMedia() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$GoToText;", "Lcom/devbeans/io/chat/utils/HudCommand;", "()V", "app_debug"})
    public static final class GoToText extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.HudCommand.GoToText INSTANCE = null;
        
        private GoToText() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$GoToCapture;", "Lcom/devbeans/io/chat/utils/HudCommand;", "()V", "app_debug"})
    public static final class GoToCapture extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.HudCommand.GoToCapture INSTANCE = null;
        
        private GoToCapture() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$ResumeEntryTransition;", "Lcom/devbeans/io/chat/utils/HudCommand;", "()V", "app_debug"})
    public static final class ResumeEntryTransition extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.HudCommand.ResumeEntryTransition INSTANCE = null;
        
        private ResumeEntryTransition() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$OpenEmojiSearch;", "Lcom/devbeans/io/chat/utils/HudCommand;", "()V", "app_debug"})
    public static final class OpenEmojiSearch extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.HudCommand.OpenEmojiSearch INSTANCE = null;
        
        private OpenEmojiSearch() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$CloseEmojiSearch;", "Lcom/devbeans/io/chat/utils/HudCommand;", "()V", "app_debug"})
    public static final class CloseEmojiSearch extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.HudCommand.CloseEmojiSearch INSTANCE = null;
        
        private CloseEmojiSearch() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$EmojiInsert;", "Lcom/devbeans/io/chat/utils/HudCommand;", "emoji", "", "(Ljava/lang/String;)V", "getEmoji", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class EmojiInsert extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "emoji")
        private final java.lang.String emoji = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.HudCommand.EmojiInsert copy(@org.jetbrains.annotations.Nullable
        java.lang.String emoji) {
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
        
        public EmojiInsert(@org.jetbrains.annotations.Nullable
        java.lang.String emoji) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getEmoji() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/utils/HudCommand$EmojiKeyEvent;", "Lcom/devbeans/io/chat/utils/HudCommand;", "keyEvent", "Landroid/view/KeyEvent;", "(Landroid/view/KeyEvent;)V", "getKeyEvent", "()Landroid/view/KeyEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class EmojiKeyEvent extends com.devbeans.io.chat.utils.HudCommand {
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "keyEvent")
        private final android.view.KeyEvent keyEvent = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.HudCommand.EmojiKeyEvent copy(@org.jetbrains.annotations.Nullable
        android.view.KeyEvent keyEvent) {
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
        
        public EmojiKeyEvent(@org.jetbrains.annotations.Nullable
        android.view.KeyEvent keyEvent) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.view.KeyEvent component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.view.KeyEvent getKeyEvent() {
            return null;
        }
    }
}