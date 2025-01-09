package com.devbeans.io.chat.utils.views;

import java.lang.System;

/**
 * Handles the setup and display of actions shown in a context menu.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f*\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/chat/utils/views/ContextMenuList;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onItemClick", "Lkotlin/Function0;", "", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;)V", "mappingAdapter", "Lcom/devbeans/io/chat/adapters/MappingAdapter;", "setItems", "items", "", "Lcom/devbeans/io/chat/utils/views/ActionItem;", "toAdapterItems", "Lcom/devbeans/io/chat/utils/views/ContextMenuList$DisplayItem;", "DisplayItem", "DisplayType", "ItemViewHolder", "app_debug"})
public final class ContextMenuList {
    private final com.devbeans.io.chat.adapters.MappingAdapter mappingAdapter = null;
    
    public ContextMenuList(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onItemClick) {
        super();
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.utils.views.ActionItem> items) {
    }
    
    private final java.util.List<com.devbeans.io.chat.utils.views.ContextMenuList.DisplayItem> toAdapterItems(java.util.List<com.devbeans.io.chat.utils.views.ActionItem> $this$toAdapterItems) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0016J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/devbeans/io/chat/utils/views/ContextMenuList$DisplayItem;", "Lcom/devbeans/io/chat/callBacks/MappingModel;", "item", "Lcom/devbeans/io/chat/utils/views/ActionItem;", "displayType", "Lcom/devbeans/io/chat/utils/views/ContextMenuList$DisplayType;", "(Lcom/devbeans/io/chat/utils/views/ActionItem;Lcom/devbeans/io/chat/utils/views/ContextMenuList$DisplayType;)V", "getDisplayType", "()Lcom/devbeans/io/chat/utils/views/ContextMenuList$DisplayType;", "getItem", "()Lcom/devbeans/io/chat/utils/views/ActionItem;", "areContentsTheSame", "", "newItem", "areItemsTheSame", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_debug"})
    static final class DisplayItem implements com.devbeans.io.chat.callBacks.MappingModel<com.devbeans.io.chat.utils.views.ContextMenuList.DisplayItem> {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "item")
        private final com.devbeans.io.chat.utils.views.ActionItem item = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "displayType")
        private final com.devbeans.io.chat.utils.views.ContextMenuList.DisplayType displayType = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.views.ContextMenuList.DisplayItem copy(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.ActionItem item, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.ContextMenuList.DisplayType displayType) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public DisplayItem(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.ActionItem item, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.ContextMenuList.DisplayType displayType) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.views.ActionItem component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.views.ActionItem getItem() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.views.ContextMenuList.DisplayType component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.views.ContextMenuList.DisplayType getDisplayType() {
            return null;
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.ContextMenuList.DisplayItem newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.ContextMenuList.DisplayItem newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/utils/views/ContextMenuList$DisplayType;", "", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "MIDDLE", "ONLY", "app_debug"})
    static enum DisplayType {
        /*public static final*/ TOP /* = new TOP() */,
        /*public static final*/ BOTTOM /* = new BOTTOM() */,
        /*public static final*/ MIDDLE /* = new MIDDLE() */,
        /*public static final*/ ONLY /* = new ONLY() */;
        
        DisplayType() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/chat/utils/views/ContextMenuList$ItemViewHolder;", "Lcom/devbeans/io/chat/adapters/viewholders/MappingViewHolder;", "Lcom/devbeans/io/chat/utils/views/ContextMenuList$DisplayItem;", "itemView", "Landroid/view/View;", "onItemClick", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "bind", "model", "app_debug"})
    static final class ItemViewHolder extends com.devbeans.io.chat.adapters.viewholders.MappingViewHolder<com.devbeans.io.chat.utils.views.ContextMenuList.DisplayItem> {
        private final kotlin.jvm.functions.Function0<kotlin.Unit> onItemClick = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView icon = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView title = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function0<kotlin.Unit> onItemClick) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIcon() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @java.lang.Override
        public void bind(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.ContextMenuList.DisplayItem model) {
        }
    }
}