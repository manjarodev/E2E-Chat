package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J \u0010\u0016\u001a\u00020\u000f2\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/devbeans/io/chat/adapters/ImportFileListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/ImportFileListAdapter$FileViewHolder;", "callback", "Lcom/devbeans/io/chat/callBacks/OnImportFileSelected;", "(Lcom/devbeans/io/chat/callBacks/OnImportFileSelected;)V", "items", "", "Lkotlin/Pair;", "Ljava/util/Date;", "Ljava/io/File;", "selectedPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newItems", "", "FileDiffCallback", "FileViewHolder", "app_debug"})
public final class ImportFileListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.ImportFileListAdapter.FileViewHolder> {
    private final com.devbeans.io.chat.callBacks.OnImportFileSelected callback = null;
    private final java.util.List<kotlin.Pair<java.util.Date, java.io.File>> items = null;
    private int selectedPosition = androidx.recyclerview.widget.RecyclerView.NO_POSITION;
    
    public ImportFileListAdapter(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnImportFileSelected callback) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.ImportFileListAdapter.FileViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.ImportFileListAdapter.FileViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull
    java.util.List<? extends kotlin.Pair<? extends java.util.Date, ? extends java.io.File>> newItems) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/adapters/ImportFileListAdapter$FileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ItemListFragmentBinding;", "(Lcom/devbeans/io/chat/adapters/ImportFileListAdapter;Lcom/devbeans/io/chat/databinding/ItemListFragmentBinding;)V", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ItemListFragmentBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ItemListFragmentBinding;)V", "setData", "", "item", "Lkotlin/Pair;", "Ljava/util/Date;", "Ljava/io/File;", "counter", "", "app_debug"})
    public final class FileViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.devbeans.io.chat.databinding.ItemListFragmentBinding mBinding;
        
        public FileViewHolder(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ItemListFragmentBinding mBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.databinding.ItemListFragmentBinding getMBinding() {
            return null;
        }
        
        public final void setMBinding(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ItemListFragmentBinding p0) {
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull
        kotlin.Pair<? extends java.util.Date, ? extends java.io.File> item, int counter) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/adapters/ImportFileListAdapter$FileDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lkotlin/Pair;", "Ljava/util/Date;", "Ljava/io/File;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_debug"})
    public static final class FileDiffCallback extends androidx.recyclerview.widget.DiffUtil.Callback {
        private final java.util.List<kotlin.Pair<java.util.Date, java.io.File>> oldList = null;
        private final java.util.List<kotlin.Pair<java.util.Date, java.io.File>> newList = null;
        
        public FileDiffCallback(@org.jetbrains.annotations.NotNull
        java.util.List<? extends kotlin.Pair<? extends java.util.Date, ? extends java.io.File>> oldList, @org.jetbrains.annotations.NotNull
        java.util.List<? extends kotlin.Pair<? extends java.util.Date, ? extends java.io.File>> newList) {
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