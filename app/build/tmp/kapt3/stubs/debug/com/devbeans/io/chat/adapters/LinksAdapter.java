package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002&\'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\tH\u0016J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tJ\u001c\u0010\u001c\u001a\u00020\u00182\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u001c\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\tH\u0016J\u0014\u0010#\u001a\u00020\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0%R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/devbeans/io/chat/adapters/LinksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/LinksAdapter$LinksViewHolder;", "mLinksCallback", "Lcom/devbeans/io/chat/callBacks/LinksCallback;", "onMediaSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "(Lcom/devbeans/io/chat/callBacks/LinksCallback;Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;)V", "count", "", "linksList", "", "Lcom/devbeans/io/chat/models/Payload;", "getMLinksCallback", "()Lcom/devbeans/io/chat/callBacks/LinksCallback;", "setMLinksCallback", "(Lcom/devbeans/io/chat/callBacks/LinksCallback;)V", "getOnMediaSelectCallback", "()Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "setOnMediaSelectCallback", "(Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;)V", "selectionMode", "", "decreaseCount", "", "bindingAdapterPosition", "getItemCount", "increaseCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitMedia", "media", "", "Callback", "LinksViewHolder", "app_debug"})
public final class LinksAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.LinksAdapter.LinksViewHolder> {
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.LinksCallback mLinksCallback;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback;
    private final java.util.List<com.devbeans.io.chat.models.Payload> linksList = null;
    private boolean selectionMode = false;
    private int count = -1;
    
    public LinksAdapter(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.LinksCallback mLinksCallback, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.LinksCallback getMLinksCallback() {
        return null;
    }
    
    public final void setMLinksCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.LinksCallback p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.callBacks.OnMediaSelectCallback getOnMediaSelectCallback() {
        return null;
    }
    
    public final void setOnMediaSelectCallback(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.callBacks.OnMediaSelectCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.LinksAdapter.LinksViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.LinksAdapter.LinksViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void increaseCount(int bindingAdapterPosition) {
    }
    
    public final void decreaseCount(int bindingAdapterPosition) {
    }
    
    public final void submitMedia(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Payload> media) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/adapters/LinksAdapter$Callback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/devbeans/io/chat/models/Payload;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_debug"})
    static final class Callback extends androidx.recyclerview.widget.DiffUtil.Callback {
        private final java.util.List<com.devbeans.io.chat.models.Payload> oldList = null;
        private final java.util.List<com.devbeans.io.chat.models.Payload> newList = null;
        
        public Callback(@org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.Payload> oldList, @org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.Payload> newList) {
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
    
    /**
     * LinksViewHolder is responsible for providing the views which represent items in a data set.
     * Each item is a link with its select state.
     *
     * @property mBinding binding object of the layout 'ItemLinksBinding'
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/adapters/LinksAdapter$LinksViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ItemLinksBinding;", "(Lcom/devbeans/io/chat/adapters/LinksAdapter;Lcom/devbeans/io/chat/databinding/ItemLinksBinding;)V", "handleOnClick", "", "payload", "Lcom/devbeans/io/chat/models/Payload;", "handleOnLongClick", "", "setData", "app_debug"})
    public final class LinksViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.devbeans.io.chat.databinding.ItemLinksBinding mBinding = null;
        
        public LinksViewHolder(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ItemLinksBinding mBinding) {
            super(null);
        }
        
        /**
         * Binds link data to UI and sets click listeners.
         *
         * @param payload the link data and select state
         */
        public final void setData(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.Payload payload) {
        }
        
        /**
         * Handles item's click event. If selectionMode is enabled, toggle the item's select state.
         * Otherwise, make the link clickable.
         *
         * @param payload the link data and select state
         */
        private final void handleOnClick(com.devbeans.io.chat.models.Payload payload) {
        }
        
        /**
         * Handles item's long click event. If the item is not selected, enables selectionMode,
         * select the item, and stop the pager.
         *
         * @param payload the link data and select state
         * @return Boolean
         */
        private final boolean handleOnLongClick(com.devbeans.io.chat.models.Payload payload) {
            return false;
        }
    }
}