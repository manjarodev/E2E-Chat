package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010$\u001a\u00020%J \u0010&\u001a\u00020%2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\n0\'j\b\u0012\u0004\u0012\u00020\n`(H\u0007J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020%H\u0007J\u0018\u0010,\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010-\u001a\u00020*H\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020*H\u0016J\u0010\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010\nJ\u0016\u00104\u001a\u00020%2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007J\b\u00106\u001a\u00020%H\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00067"}, d2 = {"Lcom/devbeans/io/chat/adapters/NewMessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/viewholders/ContactViewHolder;", "mContext", "Landroid/content/Context;", "callback", "Lcom/devbeans/io/chat/callBacks/ContactsCallback;", "(Landroid/content/Context;Lcom/devbeans/io/chat/callBacks/ContactsCallback;)V", "contacts", "", "Lcom/devbeans/io/chat/models/Contact;", "(Landroid/content/Context;Lcom/devbeans/io/chat/callBacks/ContactsCallback;Ljava/util/List;)V", "getCallback", "()Lcom/devbeans/io/chat/callBacks/ContactsCallback;", "setCallback", "(Lcom/devbeans/io/chat/callBacks/ContactsCallback;)V", "holder", "getHolder", "()Lcom/devbeans/io/chat/adapters/viewholders/ContactViewHolder;", "setHolder", "(Lcom/devbeans/io/chat/adapters/viewholders/ContactViewHolder;)V", "itemList", "getItemList", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "mCheck", "", "getMCheck", "()Z", "setMCheck", "(Z)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "clear", "", "filteredList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "hideCheckBox", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "contact", "setChatRoomList", "chatRoomList", "showCheckBox", "app_debug"})
public final class NewMessageAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.viewholders.ContactViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.devbeans.io.chat.models.Contact> itemList;
    @org.jetbrains.annotations.NotNull
    private android.content.Context mContext;
    private boolean mCheck = false;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.ContactsCallback callback;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.adapters.viewholders.ContactViewHolder holder;
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.Contact> getItemList() {
        return null;
    }
    
    public final void setItemList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    public final boolean getMCheck() {
        return false;
    }
    
    public final void setMCheck(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.ContactsCallback getCallback() {
        return null;
    }
    
    public final void setCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ContactsCallback p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.adapters.viewholders.ContactViewHolder getHolder() {
        return null;
    }
    
    public final void setHolder(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.adapters.viewholders.ContactViewHolder p0) {
    }
    
    public NewMessageAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ContactsCallback callback) {
        super();
    }
    
    public NewMessageAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ContactsCallback callback, @org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> contacts) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.viewholders.ContactViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.ContactViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void showCheckBox() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void hideCheckBox() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setChatRoomList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> chatRoomList) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void filteredList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.devbeans.io.chat.models.Contact> filteredList) {
    }
    
    public final void clear() {
    }
    
    public final void removeItem(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Contact contact) {
    }
}