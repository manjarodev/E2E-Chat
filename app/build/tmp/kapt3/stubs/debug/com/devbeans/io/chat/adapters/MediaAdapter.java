package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002./B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fJ\b\u0010 \u001a\u00020\u001eH\u0007J\b\u0010!\u001a\u00020\u000fH\u0016J\u0006\u0010\"\u001a\u00020\u001cJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fJ\u001c\u0010$\u001a\u00020\u001e2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u000fH\u0016J\u001c\u0010\'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0016J\u0014\u0010+\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160-R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/devbeans/io/chat/adapters/MediaAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/MediaAdapter$MediaViewHolder;", "mClickCallBack", "Lcom/devbeans/io/chat/callBacks/OnMediaClickCallBack;", "context", "Landroid/content/Context;", "onMediaSelectCallback", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "(Lcom/devbeans/io/chat/callBacks/OnMediaClickCallBack;Landroid/content/Context;Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "count", "", "getMClickCallBack", "()Lcom/devbeans/io/chat/callBacks/OnMediaClickCallBack;", "setMClickCallBack", "(Lcom/devbeans/io/chat/callBacks/OnMediaClickCallBack;)V", "mediaList", "", "Lcom/devbeans/io/chat/models/Payload;", "getOnMediaSelectCallback", "()Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "setOnMediaSelectCallback", "(Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;)V", "selectionMode", "", "decreaseCount", "", "bindingAdapterPosition", "deselectAll", "getItemCount", "getSelectionMode", "increaseCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitMedia", "media", "", "Callback", "MediaViewHolder", "app_debug"})
public final class MediaAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.MediaAdapter.MediaViewHolder> {
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.OnMediaClickCallBack mClickCallBack;
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback;
    private final java.util.List<com.devbeans.io.chat.models.Payload> mediaList = null;
    private boolean selectionMode = false;
    private int count = -1;
    
    public MediaAdapter(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnMediaClickCallBack mClickCallBack, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.callBacks.OnMediaSelectCallback onMediaSelectCallback) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.OnMediaClickCallBack getMClickCallBack() {
        return null;
    }
    
    public final void setMClickCallBack(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnMediaClickCallBack p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
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
    public com.devbeans.io.chat.adapters.MediaAdapter.MediaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.MediaAdapter.MediaViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void increaseCount(int bindingAdapterPosition) {
    }
    
    public final void decreaseCount(int bindingAdapterPosition) {
    }
    
    public final boolean getSelectionMode() {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void deselectAll() {
    }
    
    public final void submitMedia(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Payload> media) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/adapters/MediaAdapter$Callback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/devbeans/io/chat/models/Payload;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_debug"})
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
     * MediaViewHolder is responsible for providing the views which represent items in a data set.
     * Each item is a media with its select state and media type.
     *
     * @property mBinding binding object of the layout 'ItemMediaBinding'
     * @property mMediaClickCallBack callback to handle media click event
     * @property context context to be used with Glide
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/devbeans/io/chat/adapters/MediaAdapter$MediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ItemMediaBinding;", "mMediaClickCallBack", "Lcom/devbeans/io/chat/callBacks/OnMediaClickCallBack;", "context", "Landroid/content/Context;", "(Lcom/devbeans/io/chat/adapters/MediaAdapter;Lcom/devbeans/io/chat/databinding/ItemMediaBinding;Lcom/devbeans/io/chat/callBacks/OnMediaClickCallBack;Landroid/content/Context;)V", "TAG", "", "kotlin.jvm.PlatformType", "file", "Ljava/io/File;", "handleAudio", "", "handleImage", "payload", "Lcom/devbeans/io/chat/models/Payload;", "handleOnClick", "handleOnLongClick", "", "handleVideo", "options", "Lcom/bumptech/glide/request/RequestOptions;", "setData", "app_debug"})
    public final class MediaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.devbeans.io.chat.databinding.ItemMediaBinding mBinding = null;
        private final com.devbeans.io.chat.callBacks.OnMediaClickCallBack mMediaClickCallBack = null;
        private final android.content.Context context = null;
        private java.io.File file;
        private final java.lang.String TAG = null;
        
        public MediaViewHolder(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ItemMediaBinding mBinding, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.OnMediaClickCallBack mMediaClickCallBack, @org.jetbrains.annotations.NotNull
        android.content.Context context) {
            super(null);
        }
        
        /**
         * Binds media data to UI and sets click listeners.
         *
         * @param payload the media data, select state, and media type
         */
        public final void setData(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.Payload payload) {
        }
        
        /**
         * Handles audio type. It hides the video time and loads the audio icon.
         */
        private final void handleAudio() {
        }
        
        /**
         * Handles video type. It makes the video time visible and loads the video thumbnail.
         *
         * @param payload the media data, select state, and media type
         * @param options Glide RequestOptions to select the frame at a certain time
         */
        private final void handleVideo(com.devbeans.io.chat.models.Payload payload, com.bumptech.glide.request.RequestOptions options) {
        }
        
        /**
         * Handles image type. It hides the video time and loads the image.
         *
         * @param payload the media data, select state, and media type
         */
        private final void handleImage(com.devbeans.io.chat.models.Payload payload) {
        }
        
        /**
         * Handles item's click event. If selectionMode is enabled, toggle the item's select state.
         * Otherwise, perform the media click callback.
         *
         * @param payload the media data, select state, and media type
         */
        private final void handleOnClick(com.devbeans.io.chat.models.Payload payload) {
        }
        
        /**
         * Handles item's long click event. If the item is not selected, enables selectionMode,
         * select the item, and stop the pager.
         *
         * @param payload the media data, select state, and media type
         * @return Boolean
         */
        private final boolean handleOnLongClick(com.devbeans.io.chat.models.Payload payload) {
            return false;
        }
    }
}