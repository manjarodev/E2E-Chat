package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000201B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\b\u0010$\u001a\u00020\u0013H\u0016J\u001c\u0010%\u001a\u00020&2\n\u0010\'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020\u0013H\u0016J\u001c\u0010)\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0013H\u0016J\u0014\u0010-\u001a\u00020&2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020!0/R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 \u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00062"}, d2 = {"Lcom/devbeans/io/chat/adapters/ChatWallpaperAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/ChatWallpaperAdapter$WallpaperViewHolder;", "onWallpaperSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;", "context", "Landroid/content/Context;", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "(Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;Landroid/content/Context;Lcom/devbeans/io/chat/models/Conversation;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getConversation", "()Lcom/devbeans/io/chat/models/Conversation;", "setConversation", "(Lcom/devbeans/io/chat/models/Conversation;)V", "count", "", "getOnWallpaperSelectCallback", "()Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;", "setOnWallpaperSelectCallback", "(Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;)V", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "selectionMode", "", "wallpaperList", "", "Lcom/devbeans/io/chat/models/ChatWallpaper;", "getWallpaperList", "()Ljava/util/List;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitWallpapers", "colors", "", "Callback", "WallpaperViewHolder", "app_debug"})
public final class ChatWallpaperAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.ChatWallpaperAdapter.WallpaperViewHolder> {
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback onWallpaperSelectCallback;
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Conversation conversation;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.devbeans.io.chat.models.ChatWallpaper> wallpaperList = null;
    private int selectedPosition = -1;
    private boolean selectionMode = false;
    private int count = -1;
    
    public ChatWallpaperAdapter(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback onWallpaperSelectCallback, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation conversation) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback getOnWallpaperSelectCallback() {
        return null;
    }
    
    public final void setOnWallpaperSelectCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getConversation() {
        return null;
    }
    
    public final void setConversation(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.ChatWallpaper> getWallpaperList() {
        return null;
    }
    
    public final int getSelectedPosition() {
        return 0;
    }
    
    public final void setSelectedPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.ChatWallpaperAdapter.WallpaperViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.ChatWallpaperAdapter.WallpaperViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void submitWallpapers(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.ChatWallpaper> colors) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/adapters/ChatWallpaperAdapter$Callback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/devbeans/io/chat/models/ChatWallpaper;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_debug"})
    static final class Callback extends androidx.recyclerview.widget.DiffUtil.Callback {
        private final java.util.List<com.devbeans.io.chat.models.ChatWallpaper> oldList = null;
        private final java.util.List<com.devbeans.io.chat.models.ChatWallpaper> newList = null;
        
        public Callback(@org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.ChatWallpaper> oldList, @org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.ChatWallpaper> newList) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/devbeans/io/chat/adapters/ChatWallpaperAdapter$WallpaperViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ChatWallpaperSelectionAdapterItemBinding;", "onWallpaperSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;", "context", "Landroid/content/Context;", "(Lcom/devbeans/io/chat/adapters/ChatWallpaperAdapter;Lcom/devbeans/io/chat/databinding/ChatWallpaperSelectionAdapterItemBinding;Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ChatWallpaperSelectionAdapterItemBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ChatWallpaperSelectionAdapterItemBinding;)V", "getOnWallpaperSelectCallback", "()Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;", "setOnWallpaperSelectCallback", "(Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;)V", "setData", "", "wallpaper", "Lcom/devbeans/io/chat/models/ChatWallpaper;", "position", "", "app_debug"})
    public final class WallpaperViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.devbeans.io.chat.databinding.ChatWallpaperSelectionAdapterItemBinding mBinding;
        @org.jetbrains.annotations.NotNull
        private com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback onWallpaperSelectCallback;
        @org.jetbrains.annotations.NotNull
        private android.content.Context context;
        
        public WallpaperViewHolder(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ChatWallpaperSelectionAdapterItemBinding mBinding, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback onWallpaperSelectCallback, @org.jetbrains.annotations.NotNull
        android.content.Context context) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.databinding.ChatWallpaperSelectionAdapterItemBinding getMBinding() {
            return null;
        }
        
        public final void setMBinding(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ChatWallpaperSelectionAdapterItemBinding p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback getOnWallpaperSelectCallback() {
            return null;
        }
        
        public final void setOnWallpaperSelectCallback(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Context getContext() {
            return null;
        }
        
        public final void setContext(@org.jetbrains.annotations.NotNull
        android.content.Context p0) {
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.ChatWallpaper wallpaper, int position) {
        }
    }
}