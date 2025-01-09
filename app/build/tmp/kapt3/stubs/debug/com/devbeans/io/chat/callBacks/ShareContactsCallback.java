package com.devbeans.io.chat.callBacks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/callBacks/ShareContactsCallback;", "", "onContactClick", "", "contact", "Lcom/devbeans/io/chat/models/Contact;", "viewHolder", "Lcom/devbeans/io/chat/adapters/viewholders/ShareContactViewHolder;", "position", "", "app_debug"})
public abstract interface ShareContactsCallback {
    
    public abstract void onContactClick(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Contact contact, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.adapters.viewholders.ShareContactViewHolder viewHolder, int position);
}