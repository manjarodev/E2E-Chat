package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/devbeans/io/chat/fragments/LinksFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/callBacks/LinksCallback;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "list", "", "Lcom/devbeans/io/chat/models/Payload;", "list2", "mAdapter", "Lcom/devbeans/io/chat/adapters/LinksAdapter;", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentLinksBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/FragmentLinksBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/FragmentLinksBinding;)V", "mConversation", "Lcom/devbeans/io/chat/models/Conversation;", "observer", "Landroidx/lifecycle/Observer;", "onMediaSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "isURL", "", "text", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLinkClick", "link", "onResume", "onStop", "populateRecyclerView", "requireConversation", "setCallback", "Companion", "app_debug"})
public final class LinksFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.callBacks.LinksCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.FragmentLinksBinding mBinding;
    private com.devbeans.io.chat.adapters.LinksAdapter mAdapter;
    private com.devbeans.io.chat.models.Conversation mConversation;
    private final java.lang.String TAG = null;
    private java.util.List<com.devbeans.io.chat.models.Payload> list;
    private java.util.List<com.devbeans.io.chat.models.Payload> list2;
    private com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback;
    
    /**
     * Observer for changes in the Room database.
     * Each time data changes, the observer filters out the payloads with data that isn't a URL,
     * updates the adapter with the new list of payloads, and sets the appropriate visibility for the text notification.
     */
    private final androidx.lifecycle.Observer<java.util.List<com.devbeans.io.chat.models.Payload>> observer = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.LinksFragment.Companion Companion = null;
    private static final java.lang.String ARG_CONVERSATION = "arg.conversation";
    
    public LinksFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.FragmentLinksBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.FragmentLinksBinding p0) {
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
    
    private final com.devbeans.io.chat.models.Conversation requireConversation() {
        return null;
    }
    
    private final void setCallback(com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    @java.lang.Override
    public void onLinkClick(@org.jetbrains.annotations.NotNull
    java.lang.String link) {
    }
    
    /**
     * Validates if the given string is a URL.
     * If the string doesn't start with "http", it appends "https://" to the start.
     * It then tries to create a URL from the string and checks if it matches Android's WEB_URL pattern.
     *
     * @param text the string to validate as URL.
     * @return true if the string is a valid URL, false otherwise.
     */
    public final boolean isURL(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/fragments/LinksFragment$Companion;", "", "()V", "ARG_CONVERSATION", "", "newInstance", "Lcom/devbeans/io/chat/fragments/LinksFragment;", "Landroidx/fragment/app/Fragment;", "uri", "Lcom/devbeans/io/chat/models/Conversation;", "onMediaSelectCallBack", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.fragments.LinksFragment newInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.fragment.app.Fragment newInstance(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.Conversation uri, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallBack) {
            return null;
        }
    }
}