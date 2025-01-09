package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tH\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J*\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J*\u0010(\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030)2\u0006\u0010&\u001a\u00020\'H\u0016J\u001a\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010 H\u0016J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\b\u0010/\u001a\u00020\u0015H\u0002J\u0018\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u0002022\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/devbeans/io/chat/fragments/BlockedContactsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/callBacks/BlockListCallback;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "()V", "UNBLOCK", "", "blockList", "", "Lcom/devbeans/io/chat/models/Contact;", "mAdapter", "Lcom/devbeans/io/chat/adapters/BlockListAdapter;", "mBinding", "Lcom/devbeans/io/chat/databinding/BlockedContactFragmentBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/BlockedContactFragmentBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/BlockedContactFragmentBinding;)V", "mCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "filter", "", "text", "onBlockClick", "contact", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onSuccess", "Lretrofit2/Response;", "onViewCreated", "view", "savedInstanceState", "populateRecyclerView", "setBlockList", "setSearchBlockList", "showCustomDialog", "i", "", "unblock", "app_debug"})
public final class BlockedContactsFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.callBacks.BlockListCallback, com.devbeans.io.chat.network.OnNetworkResponse {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.BlockedContactFragmentBinding mBinding;
    private com.devbeans.io.chat.adapters.BlockListAdapter mAdapter;
    private java.util.List<com.devbeans.io.chat.models.Contact> blockList;
    private androidx.appcompat.app.AlertDialog mCreateDialog;
    private final java.lang.String UNBLOCK = "Unblock";
    
    public BlockedContactsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.BlockedContactFragmentBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.BlockedContactFragmentBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup viewGroup, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setBlockList() {
    }
    
    private final void populateRecyclerView() {
    }
    
    private final void setSearchBlockList() {
    }
    
    private final void filter(java.lang.String text) {
    }
    
    private final void showCustomDialog(int i, com.devbeans.io.chat.models.Contact contact) {
    }
    
    private final void unblock(com.devbeans.io.chat.models.Contact contact) {
    }
    
    @java.lang.Override
    public void onBlockClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Contact contact) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.Nullable
    java.lang.Object tag) {
    }
}