package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010\'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/devbeans/io/chat/fragments/DocsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/callBacks/OnDocsCallback;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "list", "", "Lcom/devbeans/io/chat/models/Payload;", "mAdapter", "Lcom/devbeans/io/chat/adapters/DocumentAdapter;", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentDocsBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/FragmentDocsBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/FragmentDocsBinding;)V", "mConversation", "Lcom/devbeans/io/chat/models/Conversation;", "observer", "Landroidx/lifecycle/Observer;", "onMediaSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDocsCallback", "payload", "onResume", "onStop", "populateRecyclerView", "requireConversation", "setCallback", "Companion", "app_debug"})
public final class DocsFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.callBacks.OnDocsCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.FragmentDocsBinding mBinding;
    private com.devbeans.io.chat.adapters.DocumentAdapter mAdapter;
    private com.devbeans.io.chat.models.Conversation mConversation;
    private final java.lang.String TAG = null;
    private java.util.List<com.devbeans.io.chat.models.Payload> list;
    private com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback;
    
    /**
     * Observer for monitoring the changes in the database. Whenever data changes, this updates the UI.
     * This observer is responsible for updating the UI in real time as the data changes in Room database.
     */
    private final androidx.lifecycle.Observer<java.util.List<com.devbeans.io.chat.models.Payload>> observer = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.DocsFragment.Companion Companion = null;
    private static final java.lang.String ARG_CONVERSATION = "arg.conversation";
    
    public DocsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.FragmentDocsBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.FragmentDocsBinding p0) {
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
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    private final void populateRecyclerView() {
    }
    
    private final com.devbeans.io.chat.models.Conversation requireConversation() {
        return null;
    }
    
    private final void setCallback(com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback) {
    }
    
    @java.lang.Override
    public void onDocsCallback(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/fragments/DocsFragment$Companion;", "", "()V", "ARG_CONVERSATION", "", "newInstance", "Lcom/devbeans/io/chat/fragments/DocsFragment;", "Landroidx/fragment/app/Fragment;", "uri", "Lcom/devbeans/io/chat/models/Conversation;", "onMediaSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.fragments.DocsFragment newInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.fragment.app.Fragment newInstance(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.Conversation uri, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback) {
            return null;
        }
    }
}