package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\'H\u0016J\u0018\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\'H\u0016J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\'H\u0016J\u0010\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00061"}, d2 = {"Lcom/devbeans/io/chat/adapters/NewGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/viewholders/NewGroupViewHolder;", "mContext", "Landroid/content/Context;", "callback", "Lcom/devbeans/io/chat/callBacks/ContactsCallback;", "memberAddCallback", "Lcom/devbeans/io/chat/callBacks/MemberAddCallback;", "contacts", "", "Lcom/devbeans/io/chat/models/Contact;", "(Landroid/content/Context;Lcom/devbeans/io/chat/callBacks/ContactsCallback;Lcom/devbeans/io/chat/callBacks/MemberAddCallback;Ljava/util/List;)V", "getCallback", "()Lcom/devbeans/io/chat/callBacks/ContactsCallback;", "setCallback", "(Lcom/devbeans/io/chat/callBacks/ContactsCallback;)V", "itemList", "getItemList", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "mCheck", "", "getMCheck", "()Z", "setMCheck", "(Z)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMemberAddCallback", "()Lcom/devbeans/io/chat/callBacks/MemberAddCallback;", "setMemberAddCallback", "(Lcom/devbeans/io/chat/callBacks/MemberAddCallback;)V", "clear", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "contact", "app_debug"})
public final class NewGroupAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.viewholders.NewGroupViewHolder> {
    @org.jetbrains.annotations.NotNull
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.ContactsCallback callback;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.devbeans.io.chat.models.Contact> itemList;
    private boolean mCheck = false;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.MemberAddCallback memberAddCallback;
    
    public NewGroupAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ContactsCallback callback, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.MemberAddCallback memberAddCallback, @org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> contacts) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.ContactsCallback getCallback() {
        return null;
    }
    
    public final void setCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ContactsCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.Contact> getItemList() {
        return null;
    }
    
    public final void setItemList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> p0) {
    }
    
    public final boolean getMCheck() {
        return false;
    }
    
    public final void setMCheck(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.MemberAddCallback getMemberAddCallback() {
        return null;
    }
    
    public final void setMemberAddCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.MemberAddCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.viewholders.NewGroupViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.NewGroupViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void clear() {
    }
    
    public final void removeItem(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Contact contact) {
    }
}