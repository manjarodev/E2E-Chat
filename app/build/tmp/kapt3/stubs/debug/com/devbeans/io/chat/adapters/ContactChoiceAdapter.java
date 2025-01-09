package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/chat/adapters/ContactChoiceAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/devbeans/io/chat/models/ContactChoice;", "Lcom/devbeans/io/chat/adapters/ContactChoiceAdapter$ContactChoiceViewHolder;", "onContactChoiceSelected", "Lkotlin/Function1;", "Lcom/devbeans/io/chat/models/Contact;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ContactChoiceDiffCallback", "ContactChoiceViewHolder", "app_debug"})
public final class ContactChoiceAdapter extends androidx.recyclerview.widget.ListAdapter<com.devbeans.io.chat.models.ContactChoice, com.devbeans.io.chat.adapters.ContactChoiceAdapter.ContactChoiceViewHolder> {
    private final kotlin.jvm.functions.Function1<com.devbeans.io.chat.models.Contact, kotlin.Unit> onContactChoiceSelected = null;
    
    public ContactChoiceAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.models.Contact, kotlin.Unit> onContactChoiceSelected) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.ContactChoiceAdapter.ContactChoiceViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.ContactChoiceAdapter.ContactChoiceViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/adapters/ContactChoiceAdapter$ContactChoiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/devbeans/io/chat/databinding/ListItemContactChoiceBinding;", "(Lcom/devbeans/io/chat/databinding/ListItemContactChoiceBinding;)V", "bind", "", "contactChoice", "Lcom/devbeans/io/chat/models/ContactChoice;", "onContactChoiceSelected", "Lkotlin/Function1;", "Lcom/devbeans/io/chat/models/Contact;", "app_debug"})
    public static final class ContactChoiceViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.devbeans.io.chat.databinding.ListItemContactChoiceBinding binding = null;
        
        public ContactChoiceViewHolder(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.databinding.ListItemContactChoiceBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.ContactChoice contactChoice, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.models.Contact, kotlin.Unit> onContactChoiceSelected) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/adapters/ContactChoiceAdapter$ContactChoiceDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/devbeans/io/chat/models/ContactChoice;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    static final class ContactChoiceDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.devbeans.io.chat.models.ContactChoice> {
        
        public ContactChoiceDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.ContactChoice oldItem, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.ContactChoice newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.ContactChoice oldItem, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.ContactChoice newItem) {
            return false;
        }
    }
}