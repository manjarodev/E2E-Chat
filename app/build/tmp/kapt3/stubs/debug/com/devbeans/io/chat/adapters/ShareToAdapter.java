package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u0014\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/devbeans/io/chat/adapters/ShareToAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/viewholders/ShareToViewHolder;", "shareRoomsListCallback", "Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;", "context", "Landroid/content/Context;", "(Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "conversationList", "", "Lcom/devbeans/io/chat/models/Conversation;", "getShareRoomsListCallback", "()Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;", "setShareRoomsListCallback", "(Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;)V", "filteredList", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setChatRoomList", "conversationsList", "Callback", "app_debug"})
public final class ShareToAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.viewholders.ShareToViewHolder> {
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.ShareRoomsListCallback shareRoomsListCallback;
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    private java.util.List<com.devbeans.io.chat.models.Conversation> conversationList;
    
    public ShareToAdapter(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ShareRoomsListCallback shareRoomsListCallback, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.ShareRoomsListCallback getShareRoomsListCallback() {
        return null;
    }
    
    public final void setShareRoomsListCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ShareRoomsListCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.viewholders.ShareToViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.ShareToViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void setChatRoomList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Conversation> conversationsList) {
    }
    
    public final void filteredList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Conversation> filteredList) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/adapters/ShareToAdapter$Callback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/devbeans/io/chat/models/Conversation;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_debug"})
    static final class Callback extends androidx.recyclerview.widget.DiffUtil.Callback {
        private final java.util.List<com.devbeans.io.chat.models.Conversation> oldList = null;
        private final java.util.List<com.devbeans.io.chat.models.Conversation> newList = null;
        
        public Callback(@org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.Conversation> oldList, @org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.Conversation> newList) {
            super();
        }
        
        @java.lang.Override
        public int getOldListSize() {
            return 0;
        }
        
        @java.lang.Override
        public int getNewListSize() {
            return 0;
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return false;
        }
    }
}