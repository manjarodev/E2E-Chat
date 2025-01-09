package com.devbeans.io.chat.callBacks;

import java.lang.System;

/**
 * Callback methods which are to be used when longClick is initiated
 * in [MediaFragment] , [DocsFragment] , [LinksFragment]
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "", "addDoc", "", "payload", "Lcom/devbeans/io/chat/models/Payload;", "addLink", "addMedia", "getCount", "count", "", "removeDoc", "removeLink", "removeMedia", "stopPager", "selection", "", "app_debug"})
public abstract interface OnMediaSelectCallback {
    
    public abstract void addMedia(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload);
    
    public abstract void removeMedia(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload);
    
    public abstract void addDoc(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload);
    
    public abstract void removeDoc(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload);
    
    public abstract void addLink(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload);
    
    public abstract void removeLink(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload);
    
    public abstract void stopPager(boolean selection);
    
    public abstract void getCount(int count);
}