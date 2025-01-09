package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u00015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010/\u001a\u0004\u0018\u00010\n2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00100\u001a\u000201H\u0002J\u000e\u00104\u001a\u0002032\u0006\u00100\u001a\u000201R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014R\u000e\u0010.\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/ShareToViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Lcom/devbeans/io/chat/databinding/ItemSharetoMemberBinding;", "callback", "Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;", "context", "Landroid/content/Context;", "(Lcom/devbeans/io/chat/databinding/ItemSharetoMemberBinding;Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;Landroid/content/Context;)V", "action", "", "actionOn", "getCallback", "()Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;", "setCallback", "(Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;)V", "color", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "id", "isContact", "", "()Z", "setContact", "(Z)V", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ItemSharetoMemberBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ItemSharetoMemberBinding;)V", "mContact", "Lcom/devbeans/io/chat/models/Contact;", "getMContact", "()Lcom/devbeans/io/chat/models/Contact;", "setMContact", "(Lcom/devbeans/io/chat/models/Contact;)V", "mRequestManager", "Lcom/bumptech/glide/RequestManager;", "name", "getName", "setName", "sender", "getConversationSender", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "handleGroupIcon", "", "setData", "Companion", "app_debug"})
public final class ShareToViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.databinding.ItemSharetoMemberBinding mBinding;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.ShareRoomsListCallback callback;
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    private final com.bumptech.glide.RequestManager mRequestManager = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String name = "null";
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Contact mContact;
    @org.jetbrains.annotations.Nullable
    private java.lang.String color = "null";
    private boolean isContact = false;
    private java.lang.String id;
    private final java.lang.String sender = "";
    private final java.lang.String action = "";
    private final java.lang.String actionOn = "";
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.adapters.viewholders.ShareToViewHolder.Companion Companion = null;
    private static int counter = 0;
    
    public ShareToViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.databinding.ItemSharetoMemberBinding mBinding, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ShareRoomsListCallback callback, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.databinding.ItemSharetoMemberBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.databinding.ItemSharetoMemberBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.ShareRoomsListCallback getCallback() {
        return null;
    }
    
    public final void setCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ShareRoomsListCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Contact getMContact() {
        return null;
    }
    
    public final void setMContact(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Contact p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getColor() {
        return null;
    }
    
    public final void setColor(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isContact() {
        return false;
    }
    
    public final void setContact(boolean p0) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleGroupIcon(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final java.lang.String getConversationSender(com.devbeans.io.chat.models.Conversation conversation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/ShareToViewHolder$Companion;", "", "()V", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getCounter() {
            return 0;
        }
        
        public final void setCounter(int p0) {
        }
    }
}