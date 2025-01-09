package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0002\u001d\u001eB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J0\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/devbeans/io/chat/activities/MediaSelectionActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/OnDataPass;", "()V", "CommandReceiver", "Landroid/content/BroadcastReceiver;", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "filepath", "", "isFromCamera", "", "uri", "Landroid/net/Uri;", "navigateToStartDestination", "navHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDataPass", "isDurationEdited", "totalDurationUs", "", "startTimeUs", "endTimeUs", "viewOnce", "onDestroy", "Companion", "MediaData", "app_debug"})
public final class MediaSelectionActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.OnDataPass {
    private java.lang.String filepath;
    private android.net.Uri uri;
    private com.devbeans.io.chat.models.Conversation conversation;
    private boolean isFromCamera = false;
    private final android.content.BroadcastReceiver CommandReceiver = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.MediaSelectionActivity.Companion Companion = null;
    private static final java.lang.String NAV_HOST_TAG = "NAV_HOST";
    private static final java.lang.String TAG = null;
    private static boolean isFrom = false;
    
    public MediaSelectionActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean navigateToStartDestination(androidx.navigation.fragment.NavHostFragment navHostFragment) {
        return false;
    }
    
    @java.lang.Override
    public void onDataPass(boolean isDurationEdited, long totalDurationUs, long startTimeUs, long endTimeUs, boolean viewOnce) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/devbeans/io/chat/activities/MediaSelectionActivity$MediaData;", "Ljava/io/Serializable;", "filePath", "", "intent_view_once_chat", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getIntent_view_once_chat", "()Ljava/lang/Boolean;", "setIntent_view_once_chat", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/devbeans/io/chat/activities/MediaSelectionActivity$MediaData;", "equals", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class MediaData implements java.io.Serializable {
        @org.jetbrains.annotations.Nullable
        private java.lang.String filePath;
        @org.jetbrains.annotations.Nullable
        private java.lang.Boolean intent_view_once_chat;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.activities.MediaSelectionActivity.MediaData copy(@org.jetbrains.annotations.Nullable
        java.lang.String filePath, @org.jetbrains.annotations.Nullable
        java.lang.Boolean intent_view_once_chat) {
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
        
        public MediaData() {
            super();
        }
        
        public MediaData(@org.jetbrains.annotations.Nullable
        java.lang.String filePath, @org.jetbrains.annotations.Nullable
        java.lang.Boolean intent_view_once_chat) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getFilePath() {
            return null;
        }
        
        public final void setFilePath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Boolean component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Boolean getIntent_view_once_chat() {
            return null;
        }
        
        public final void setIntent_view_once_chat(@org.jetbrains.annotations.Nullable
        java.lang.Boolean p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/activities/MediaSelectionActivity$Companion;", "", "()V", "NAV_HOST_TAG", "", "TAG", "kotlin.jvm.PlatformType", "isFrom", "", "()Z", "setFrom", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isFrom() {
            return false;
        }
        
        public final void setFrom(boolean p0) {
        }
    }
}