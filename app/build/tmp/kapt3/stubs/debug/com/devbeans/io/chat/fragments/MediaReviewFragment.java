package com.devbeans.io.chat.fragments;

import java.lang.System;

/**
 * Allows the user to view and edit selected media.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u000209H\u0016J\b\u0010@\u001a\u000209H\u0016J-\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020;2\u000e\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0D2\u0006\u0010E\u001a\u00020FH\u0016\u00a2\u0006\u0002\u0010GJ\b\u0010H\u001a\u000209H\u0016J\u001a\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020\u00062\b\u0010K\u001a\u0004\u0018\u00010LH\u0017J\u0010\u0010M\u001a\u0002092\u0006\u0010N\u001a\u00020 H\u0002J\u0018\u0010O\u001a\u0002092\u0006\u0010N\u001a\u00020 2\u0006\u0010P\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006R"}, d2 = {"Lcom/devbeans/io/chat/fragments/MediaReviewFragment;", "Landroidx/fragment/app/Fragment;", "()V", "CommandReceiver", "Landroid/content/BroadcastReceiver;", "addMediaButton", "Landroid/view/View;", "addMessageButton", "Landroid/widget/TextView;", "addMessageEntry", "animatorSet", "Landroid/animation/AnimatorSet;", "controls", "Landroidx/constraintlayout/widget/ConstraintLayout;", "controlsShade", "cropAndRotateButton", "data", "Lcom/devbeans/io/chat/fragments/Data;", "getData", "()Lcom/devbeans/io/chat/fragments/Data;", "setData", "(Lcom/devbeans/io/chat/fragments/Data;)V", "dataPasser", "Lcom/devbeans/io/chat/callBacks/OnDataPass;", "getDataPasser", "()Lcom/devbeans/io/chat/callBacks/OnDataPass;", "setDataPasser", "(Lcom/devbeans/io/chat/callBacks/OnDataPass;)V", "drawToolButton", "editedImage", "Landroid/widget/ImageView;", "file_path", "", "fromImage", "", "isEdit", "layoutCon", "limitLessView", "pager", "Landroidx/viewpager2/widget/ViewPager2;", "parsedUri", "Landroid/net/Uri;", "progress", "Landroid/widget/ProgressBar;", "progressWrapper", "Lcom/devbeans/io/chat/utils/TouchInterceptingFrameLayout;", "qualityButton", "recipientDisplay", "saveButton", "selectionRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "sendButton", "viewOnceButton", "Landroid/widget/ViewSwitcher;", "viewOnceMessage", "viewOnceView", "hideComponenets", "", "visibility", "", "onAttach", "context", "Landroid/content/Context;", "onDestroy", "onDestroyView", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "sendCommand", "command", "sendCommandActivity", "viewOnce", "Companion", "app_debug"})
public final class MediaReviewFragment extends androidx.fragment.app.Fragment {
    public com.devbeans.io.chat.callBacks.OnDataPass dataPasser;
    private android.net.Uri parsedUri;
    private android.view.View drawToolButton;
    private android.view.View cropAndRotateButton;
    private android.widget.ImageView qualityButton;
    private android.widget.ImageView editedImage;
    private android.widget.ImageView limitLessView;
    private android.widget.ImageView viewOnceView;
    private android.view.View saveButton;
    private android.view.View sendButton;
    private android.view.View addMediaButton;
    private android.widget.ViewSwitcher viewOnceButton;
    private android.widget.TextView viewOnceMessage;
    private android.widget.TextView addMessageButton;
    private android.widget.TextView addMessageEntry;
    private android.widget.TextView recipientDisplay;
    private androidx.viewpager2.widget.ViewPager2 pager;
    private androidx.constraintlayout.widget.ConstraintLayout controls;
    private androidx.recyclerview.widget.RecyclerView selectionRecycler;
    private android.view.View controlsShade;
    private android.widget.ProgressBar progress;
    private com.devbeans.io.chat.utils.TouchInterceptingFrameLayout progressWrapper;
    private androidx.constraintlayout.widget.ConstraintLayout layoutCon;
    private boolean isEdit = false;
    private boolean fromImage = false;
    private java.lang.String file_path;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.fragments.Data data;
    private android.animation.AnimatorSet animatorSet;
    private final android.content.BroadcastReceiver CommandReceiver = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.MediaReviewFragment.Companion Companion = null;
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    public static com.devbeans.io.chat.fragments.MediaReviewFragment instance;
    
    public MediaReviewFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.OnDataPass getDataPasser() {
        return null;
    }
    
    public final void setDataPasser(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnDataPass p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.fragments.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.fragments.Data p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void hideComponenets(int visibility) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final void sendCommand(java.lang.String command) {
    }
    
    private final void sendCommandActivity(java.lang.String command, boolean viewOnce) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final com.devbeans.io.chat.fragments.MediaReviewFragment getInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/fragments/MediaReviewFragment$Companion;", "", "()V", "instance", "Lcom/devbeans/io/chat/fragments/MediaReviewFragment;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.JvmStatic
        public final com.devbeans.io.chat.fragments.MediaReviewFragment getInstance() {
            return null;
        }
    }
}