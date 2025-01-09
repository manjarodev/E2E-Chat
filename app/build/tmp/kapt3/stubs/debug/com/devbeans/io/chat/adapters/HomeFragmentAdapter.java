package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0018\u0010#\u001a\u00020\u00182\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0019H\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/devbeans/io/chat/adapters/HomeFragmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/viewholders/HomeFragmentViewHolder;", "mContext", "Landroid/content/Context;", "mCallback", "Lcom/devbeans/io/chat/callBacks/RoomsListCallback;", "(Landroid/content/Context;Lcom/devbeans/io/chat/callBacks/RoomsListCallback;)V", "getMCallback", "()Lcom/devbeans/io/chat/callBacks/RoomsListCallback;", "setMCallback", "(Lcom/devbeans/io/chat/callBacks/RoomsListCallback;)V", "mChatRoomList", "", "Lcom/devbeans/io/chat/models/Conversation;", "getMChatRoomList", "()Ljava/util/List;", "setMChatRoomList", "(Ljava/util/List;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "filteredList", "", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setChatRoomList", "chatRoomList", "app_debug"})
public final class HomeFragmentAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.viewholders.HomeFragmentViewHolder> {
    @org.jetbrains.annotations.NotNull
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.RoomsListCallback mCallback;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.devbeans.io.chat.models.Conversation> mChatRoomList;
    
    public HomeFragmentAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.RoomsListCallback mCallback) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.RoomsListCallback getMCallback() {
        return null;
    }
    
    public final void setMCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.RoomsListCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.Conversation> getMChatRoomList() {
        return null;
    }
    
    public final void setMChatRoomList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Conversation> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.viewholders.HomeFragmentViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.HomeFragmentViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setChatRoomList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Conversation> chatRoomList) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void filteredList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Conversation> filteredList) {
    }
}