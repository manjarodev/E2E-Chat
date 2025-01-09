package com.devbeans.io.chat.callBacks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rH&JP\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/devbeans/io/chat/callBacks/ArchiveRoomsListCallback;", "", "onRoomClick", "", "room", "Lcom/devbeans/io/chat/models/Conversation;", "name", "", "id", "i", "", "color", "isContact", "", "onRoomLongClick", "view", "Landroid/view/View;", "anchor", "app_debug"})
public abstract interface ArchiveRoomsListCallback {
    
    public abstract void onRoomClick(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation room, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String id, int i, @org.jetbrains.annotations.Nullable
    java.lang.String color, boolean isContact);
    
    public abstract void onRoomLongClick(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation room, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String id, int i, @org.jetbrains.annotations.Nullable
    java.lang.String color, boolean isContact, @org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.NotNull
    android.view.View anchor);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
        
        public static void onRoomLongClick(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback $this, @org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.models.Conversation room, @org.jetbrains.annotations.Nullable
        java.lang.String name, @org.jetbrains.annotations.Nullable
        java.lang.String id, int i, @org.jetbrains.annotations.Nullable
        java.lang.String color, boolean isContact, @org.jetbrains.annotations.NotNull
        android.view.View view, @org.jetbrains.annotations.NotNull
        android.view.View anchor) {
        }
    }
}