package com.devbeans.io.chat.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u0007\b\u0016\u00a2\u0006\u0002\u0010\nJ\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\u0010\u0010/\u001a\u0002002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\b\u00101\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R \u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R \u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u001c\u0010&\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0013\"\u0004\b(\u0010\u0015R \u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015\u00a8\u00062"}, d2 = {"Lcom/devbeans/io/chat/models/User;", "Lcom/stfalcon/chatkit/commons/models/IUser;", "Ljava/io/Serializable;", "id", "", "name", "avatar", "online", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()V", "blockUsers", "", "getBlockUsers", "()Ljava/util/List;", "setBlockUsers", "(Ljava/util/List;)V", "chatNickName", "getChatNickName", "()Ljava/lang/String;", "setChatNickName", "(Ljava/lang/String;)V", "chatUserId", "getChatUserId", "setChatUserId", "isOnline", "()Z", "setOnline", "(Z)V", "moniker", "getMoniker", "setMoniker", "profileImage", "getProfileImage", "setProfileImage", "profileImageLink", "getProfileImageLink", "setProfileImageLink", "profile_path", "getProfile_path", "setProfile_path", "publicKey", "getPublicKey", "setPublicKey", "getAvatar", "getId", "getName", "setAvatar", "", "toString", "app_debug"})
public final class User implements com.stfalcon.chatkit.commons.models.IUser, java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.String id;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String name;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "avatar")
    private java.lang.String avatar;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "online")
    private boolean isOnline = false;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "profile_image")
    private java.lang.String profileImage;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chatNickName")
    private java.lang.String chatNickName;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chatUserId")
    private java.lang.String chatUserId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "blockUsers")
    private java.util.List<java.lang.String> blockUsers;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "profileImageLink")
    private java.lang.String profileImageLink;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "moniker")
    private java.lang.String moniker;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "publicKey")
    private java.lang.String publicKey;
    @org.jetbrains.annotations.Nullable
    private java.lang.String profile_path;
    
    public final boolean isOnline() {
        return false;
    }
    
    public final void setOnline(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getProfileImage() {
        return null;
    }
    
    public final void setProfileImage(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChatNickName() {
        return null;
    }
    
    public final void setChatNickName(@org.jetbrains.annotations.Nullable
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
    public final java.util.List<java.lang.String> getBlockUsers() {
        return null;
    }
    
    public final void setBlockUsers(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getProfileImageLink() {
        return null;
    }
    
    public final void setProfileImageLink(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMoniker() {
        return null;
    }
    
    public final void setMoniker(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPublicKey() {
        return null;
    }
    
    public final void setPublicKey(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getProfile_path() {
        return null;
    }
    
    public final void setProfile_path(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public User(@org.jetbrains.annotations.Nullable
    java.lang.String id, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String avatar, boolean online) {
        super();
    }
    
    public User() {
        super();
    }
    
    public final void setAvatar(@org.jetbrains.annotations.Nullable
    java.lang.String avatar) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}