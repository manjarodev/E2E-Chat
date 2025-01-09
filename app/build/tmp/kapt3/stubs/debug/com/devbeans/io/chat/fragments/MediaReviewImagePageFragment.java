package com.devbeans.io.chat.fragments;

import java.lang.System;

/**
 * Displays the chosen image within the image editor. Also manages the "touch enabled" state of the shared
 * view model. We utilize delays here to help with Animation choreography.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/devbeans/io/chat/fragments/MediaReviewImagePageFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/fragments/ImageEditorFragment$Controller;", "()V", "CommandReceiver", "Landroid/content/BroadcastReceiver;", "imageEditorFragment", "Lcom/devbeans/io/chat/fragments/ImageEditorFragment;", "ensureImageEditorFragment", "getEditorState", "", "uri", "Landroid/net/Uri;", "onCancelEditing", "", "onDestroy", "onDoneEditing", "onMainImageFailedToLoad", "onMainImageLoaded", "onPause", "onRequestFullScreen", "fullScreen", "", "hideKeyboard", "onResume", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "onTouchEventsNeeded", "needed", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "onViewStateRestored", "requireUri", "restoreImageEditorState", "sendCommand", "command", "", "Companion", "app_debug"})
public final class MediaReviewImagePageFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.fragments.ImageEditorFragment.Controller {
    private com.devbeans.io.chat.fragments.ImageEditorFragment imageEditorFragment;
    private final android.content.BroadcastReceiver CommandReceiver = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.MediaReviewImagePageFragment.Companion Companion = null;
    private static final java.lang.String ARG_URI = "arg.uri";
    private static final java.lang.String TAG = null;
    
    public MediaReviewImagePageFragment() {
        super();
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onPause() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onViewStateRestored(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull
    android.os.Bundle outState) {
    }
    
    private final com.devbeans.io.chat.fragments.ImageEditorFragment ensureImageEditorFragment() {
        return null;
    }
    
    private final android.net.Uri requireUri() {
        return null;
    }
    
    @java.lang.Override
    public void onTouchEventsNeeded(boolean needed) {
    }
    
    @java.lang.Override
    public void onRequestFullScreen(boolean fullScreen, boolean hideKeyboard) {
    }
    
    @java.lang.Override
    public void onDoneEditing() {
    }
    
    @java.lang.Override
    public void onCancelEditing() {
    }
    
    @java.lang.Override
    public void onMainImageLoaded() {
    }
    
    @java.lang.Override
    public void onMainImageFailedToLoad() {
    }
    
    private final void restoreImageEditorState() {
    }
    
    private final java.lang.Object getEditorState(android.net.Uri uri) {
        return null;
    }
    
    private final void sendCommand(java.lang.String command) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/chat/fragments/MediaReviewImagePageFragment$Companion;", "", "()V", "ARG_URI", "", "TAG", "kotlin.jvm.PlatformType", "newInstance", "Landroidx/fragment/app/Fragment;", "uri", "Landroid/net/Uri;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.fragment.app.Fragment newInstance(@org.jetbrains.annotations.NotNull
        android.net.Uri uri) {
            return null;
        }
    }
}