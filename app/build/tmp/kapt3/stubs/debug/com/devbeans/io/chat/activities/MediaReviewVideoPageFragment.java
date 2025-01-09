package com.devbeans.io.chat.activities;

import java.lang.System;

/**
 * Page fragment which displays a single editable video (non-gif) to the user. Has an embedded MediaSendVideoFragment
 * and adds some extra support for saving and restoring state, as well as saving a video to disk.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \'2\u00020\u00012\u00020\u0002:\u0001\'B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/devbeans/io/chat/activities/MediaReviewVideoPageFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/fragments/VideoEditorFragment$Controller;", "()V", "videoEditorFragment", "Lcom/devbeans/io/chat/fragments/VideoEditorFragment;", "ensureVideoEditorFragment", "onAttach", "", "context", "Landroid/content/Context;", "onPlayerError", "onPlayerReady", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "onTouchEventsNeeded", "needed", "", "onVideoBeginEdit", "uri", "Landroid/net/Uri;", "onVideoEditComplete", "data", "Lcom/devbeans/io/chat/fragments/VideoEditorFragment$Data;", "onVideoEndEdit", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "onViewStateRestored", "requireIsVideoGif", "requireMaxAttachmentSize", "", "requireMaxCompressedVideoSize", "requireMaxVideoDuration", "requireUri", "restoreVideoEditorState", "saveEditorState", "Companion", "app_debug"})
public final class MediaReviewVideoPageFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.fragments.VideoEditorFragment.Controller {
    private com.devbeans.io.chat.fragments.VideoEditorFragment videoEditorFragment;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.MediaReviewVideoPageFragment.Companion Companion = null;
    private static final java.lang.String ARG_URI = "arg.uri";
    private static final java.lang.String ARG_IS_VIDEO_GIF = "arg.is.video.gif";
    
    public MediaReviewVideoPageFragment() {
        super();
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onViewStateRestored(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull
    android.os.Bundle outState) {
    }
    
    private final void saveEditorState() {
    }
    
    @java.lang.Override
    public void onPlayerReady() {
    }
    
    @java.lang.Override
    public void onPlayerError() {
    }
    
    @java.lang.Override
    public void onTouchEventsNeeded(boolean needed) {
    }
    
    @java.lang.Override
    public void onVideoBeginEdit(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    @java.lang.Override
    public void onVideoEndEdit(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onVideoEditComplete(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.fragments.VideoEditorFragment.Data data) {
    }
    
    private final void restoreVideoEditorState() {
    }
    
    private final com.devbeans.io.chat.fragments.VideoEditorFragment ensureVideoEditorFragment() {
        return null;
    }
    
    private final android.net.Uri requireUri() {
        return null;
    }
    
    private final long requireMaxCompressedVideoSize() {
        return 0L;
    }
    
    private final long requireMaxAttachmentSize() {
        return 0L;
    }
    
    private final boolean requireIsVideoGif() {
        return false;
    }
    
    private final long requireMaxVideoDuration() {
        return 0L;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/activities/MediaReviewVideoPageFragment$Companion;", "", "()V", "ARG_IS_VIDEO_GIF", "", "ARG_URI", "newInstance", "Landroidx/fragment/app/Fragment;", "uri", "Landroid/net/Uri;", "isVideoGif", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.fragment.app.Fragment newInstance(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, boolean isVideoGif) {
            return null;
        }
    }
}