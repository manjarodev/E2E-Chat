package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002-.B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u001c\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u001c\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0016J\u0014\u0010\'\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0)J\u0014\u0010*\u001a\u00020 *\u00020+2\b\b\u0001\u0010,\u001a\u00020\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/devbeans/io/chat/adapters/ChatColorsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/ChatColorsAdapter$ChatViewHolder;", "onColorSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;", "context", "Landroid/content/Context;", "(Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;Landroid/content/Context;)V", "colorList", "", "Lcom/devbeans/io/chat/models/ChatColor;", "getColorList", "()Ljava/util/List;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "count", "", "getOnColorSelectCallback", "()Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;", "setOnColorSelectCallback", "(Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;)V", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "selectionMode", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitColors", "colors", "", "setTint", "Landroid/widget/ImageView;", "colorRes", "Callback", "ChatViewHolder", "app_debug"})
public final class ChatColorsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.ChatColorsAdapter.ChatViewHolder> {
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.OnColorSelectCallback onColorSelectCallback;
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.devbeans.io.chat.models.ChatColor> colorList = null;
    private int selectedPosition = -1;
    private boolean selectionMode = false;
    private int count = -1;
    
    public ChatColorsAdapter(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnColorSelectCallback onColorSelectCallback, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.OnColorSelectCallback getOnColorSelectCallback() {
        return null;
    }
    
    public final void setOnColorSelectCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnColorSelectCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.ChatColor> getColorList() {
        return null;
    }
    
    public final int getSelectedPosition() {
        return 0;
    }
    
    public final void setSelectedPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.ChatColorsAdapter.ChatViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.ChatColorsAdapter.ChatViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void submitColors(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.ChatColor> colors) {
    }
    
    public final void setTint(@org.jetbrains.annotations.NotNull
    android.widget.ImageView $this$setTint, @androidx.annotation.ColorRes
    int colorRes) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/adapters/ChatColorsAdapter$Callback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/devbeans/io/chat/models/ChatColor;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_debug"})
    static final class Callback extends androidx.recyclerview.widget.DiffUtil.Callback {
        private final java.util.List<com.devbeans.io.chat.models.ChatColor> oldList = null;
        private final java.util.List<com.devbeans.io.chat.models.ChatColor> newList = null;
        
        public Callback(@org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.ChatColor> oldList, @org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.ChatColor> newList) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/devbeans/io/chat/adapters/ChatColorsAdapter$ChatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ChatColorSelectionAdapterItemBinding;", "onColorSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;", "context", "Landroid/content/Context;", "(Lcom/devbeans/io/chat/adapters/ChatColorsAdapter;Lcom/devbeans/io/chat/databinding/ChatColorSelectionAdapterItemBinding;Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ChatColorSelectionAdapterItemBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ChatColorSelectionAdapterItemBinding;)V", "getOnColorSelectCallback", "()Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;", "setOnColorSelectCallback", "(Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;)V", "setData", "", "color", "Lcom/devbeans/io/chat/models/ChatColor;", "position", "", "app_debug"})
    public final class ChatViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.devbeans.io.chat.databinding.ChatColorSelectionAdapterItemBinding mBinding;
        @org.jetbrains.annotations.NotNull
        private com.devbeans.io.chat.callBacks.OnColorSelectCallback onColorSelectCallback;
        @org.jetbrains.annotations.NotNull
        private android.content.Context context;
        
        public ChatViewHolder(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ChatColorSelectionAdapterItemBinding mBinding, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.OnColorSelectCallback onColorSelectCallback, @org.jetbrains.annotations.NotNull
        android.content.Context context) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.databinding.ChatColorSelectionAdapterItemBinding getMBinding() {
            return null;
        }
        
        public final void setMBinding(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ChatColorSelectionAdapterItemBinding p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.callBacks.OnColorSelectCallback getOnColorSelectCallback() {
            return null;
        }
        
        public final void setOnColorSelectCallback(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.OnColorSelectCallback p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Context getContext() {
            return null;
        }
        
        public final void setContext(@org.jetbrains.annotations.NotNull
        android.content.Context p0) {
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.ChatColor color, int position) {
        }
    }
}