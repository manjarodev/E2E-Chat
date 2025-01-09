package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/devbeans/io/chat/adapters/ArchiveAdapters;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/viewholders/ArchiveViewHolder;", "mContext", "Landroid/content/Context;", "callback", "Lcom/devbeans/io/chat/callBacks/ArchiveRoomsListCallback;", "(Landroid/content/Context;Lcom/devbeans/io/chat/callBacks/ArchiveRoomsListCallback;)V", "mChatRoomList", "", "Lcom/devbeans/io/chat/models/Conversation;", "mRequestManager", "Lcom/bumptech/glide/RequestManager;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setChatRoomList", "chatRoomList", "", "app_debug"})
public final class ArchiveAdapters extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.viewholders.ArchiveViewHolder> {
    private final android.content.Context mContext = null;
    private final com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback callback = null;
    private java.util.List<com.devbeans.io.chat.models.Conversation> mChatRoomList;
    private com.bumptech.glide.RequestManager mRequestManager;
    
    public ArchiveAdapters(@org.jetbrains.annotations.NotNull
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback callback) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.viewholders.ArchiveViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.ArchiveViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setChatRoomList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Conversation> chatRoomList) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
}