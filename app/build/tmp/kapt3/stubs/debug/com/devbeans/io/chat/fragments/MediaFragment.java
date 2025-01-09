package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/devbeans/io/chat/fragments/MediaFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/callBacks/OnMediaClickCallBack;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "list", "", "Lcom/devbeans/io/chat/models/Payload;", "mAdapter", "Lcom/devbeans/io/chat/adapters/MediaAdapter;", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentMediaBinding;", "mConversation", "Lcom/devbeans/io/chat/models/Conversation;", "observer", "Landroidx/lifecycle/Observer;", "onMediaSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onMediaClick", "paylod", "onResume", "onStop", "populateRecyclerView", "requireConversation", "setCallback", "Companion", "app_debug"})
public final class MediaFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.callBacks.OnMediaClickCallBack {
    private final java.lang.String TAG = null;
    private com.devbeans.io.chat.databinding.FragmentMediaBinding mBinding;
    private com.devbeans.io.chat.adapters.MediaAdapter mAdapter;
    private com.devbeans.io.chat.models.Conversation mConversation;
    private com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback;
    private java.util.List<com.devbeans.io.chat.models.Payload> list;
    
    /**
     * Observer that monitors changes in the database. Whenever the data changes, it updates the UI accordingly.
     * This observer is used to update the UI in real time as data changes in the Room database.
     */
    private final androidx.lifecycle.Observer<java.util.List<com.devbeans.io.chat.models.Payload>> observer = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.MediaFragment.Companion Companion = null;
    private static final java.lang.String ARG_CONVERSATION = "arg.conversation";
    
    public MediaFragment() {
        super();
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void populateRecyclerView() {
    }
    
    @java.lang.Override
    public void onMediaClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload paylod) {
    }
    
    private final void setCallback(com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    private final com.devbeans.io.chat.models.Conversation requireConversation() {
        return null;
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/devbeans/io/chat/fragments/MediaFragment$Companion;", "", "()V", "ARG_CONVERSATION", "", "calculateNoOfColumns", "", "context", "Landroid/content/Context;", "columnWidthDp", "", "newInstance", "Lcom/devbeans/io/chat/fragments/MediaFragment;", "Landroidx/fragment/app/Fragment;", "uri", "Lcom/devbeans/io/chat/models/Conversation;", "onMediaSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.fragments.MediaFragment newInstance() {
            return null;
        }
        
        public final int calculateNoOfColumns(@org.jetbrains.annotations.NotNull
        android.content.Context context, float columnWidthDp) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.fragment.app.Fragment newInstance(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.Conversation uri, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback) {
            return null;
        }
    }
}