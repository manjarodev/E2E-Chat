package com.devbeans.io.chat.models;

import java.lang.System;

@androidx.room.Entity
@lombok.Data
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0007BS\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000fR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001d8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001e\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010*\"\u0004\b/\u0010,R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013\u00a8\u00062"}, d2 = {"Lcom/devbeans/io/chat/models/Contact;", "Ljava/io/Serializable;", "name", "", "chatUserId", "image", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "color", "avatarColor", "Lcom/devbeans/io/chat/utils/avatar/AvatarColor;", "alias", "isBlocked", "", "isQrAdded", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/devbeans/io/chat/utils/avatar/AvatarColor;Ljava/lang/String;ZZ)V", "getAlias", "()Ljava/lang/String;", "setAlias", "(Ljava/lang/String;)V", "getAvatarColor", "()Lcom/devbeans/io/chat/utils/avatar/AvatarColor;", "setAvatarColor", "(Lcom/devbeans/io/chat/utils/avatar/AvatarColor;)V", "getChatUserId", "setChatUserId", "getColor", "setColor", "columnNames", "", "getColumnNames", "()Ljava/util/List;", "columnValues", "getColumnValues", "id", "", "getId", "()I", "setId", "(I)V", "getImage", "setImage", "()Z", "setBlocked", "(Z)V", "isChecked", "setChecked", "setQrAdded", "getName", "setName", "app_debug"})
public final class Contact implements java.io.Serializable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chatUserId")
    private java.lang.String chatUserId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "image")
    private java.lang.String image;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "color")
    private java.lang.String color;
    private boolean isChecked = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "Avatar_color")
    private com.devbeans.io.chat.utils.avatar.AvatarColor avatarColor;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "alias")
    private java.lang.String alias;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isBlocked")
    private boolean isBlocked = false;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "isQrAdded")
    private boolean isQrAdded = false;
    @org.jetbrains.annotations.NotNull
    @androidx.room.Ignore
    private final java.util.List<java.lang.String> columnNames = null;
    @org.jetbrains.annotations.NotNull
    @androidx.room.Ignore
    private final java.util.List<java.lang.String> columnValues = null;
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChatUserId() {
        return null;
    }
    
    public final void setChatUserId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getColor() {
        return null;
    }
    
    public final void setColor(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isChecked() {
        return false;
    }
    
    public final void setChecked(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.utils.avatar.AvatarColor getAvatarColor() {
        return null;
    }
    
    public final void setAvatarColor(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.avatar.AvatarColor p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAlias() {
        return null;
    }
    
    public final void setAlias(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isBlocked() {
        return false;
    }
    
    public final void setBlocked(boolean p0) {
    }
    
    public final boolean isQrAdded() {
        return false;
    }
    
    public final void setQrAdded(boolean p0) {
    }
    
    public Contact(@org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String chatUserId, @org.jetbrains.annotations.Nullable
    java.lang.String image) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getColumnNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getColumnValues() {
        return null;
    }
    
    public Contact() {
        super();
    }
    
    public Contact(@org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String chatUserId, @org.jetbrains.annotations.Nullable
    java.lang.String image, @org.jetbrains.annotations.Nullable
    java.lang.String color, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.avatar.AvatarColor avatarColor, @org.jetbrains.annotations.Nullable
    java.lang.String alias, boolean isBlocked, boolean isQrAdded) {
        super();
    }
}