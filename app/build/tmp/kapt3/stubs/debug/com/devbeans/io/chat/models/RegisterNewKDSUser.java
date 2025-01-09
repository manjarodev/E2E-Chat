package com.devbeans.io.chat.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/devbeans/io/chat/models/RegisterNewKDSUser;", "", "()V", "message", "", "status", "user", "Lcom/devbeans/io/chat/models/RegisterNewKDSUser$User;", "getMessage", "getStatus", "getUser", "setMessage", "", "setStatus", "setUser", "User", "app_debug"})
public final class RegisterNewKDSUser {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "user")
    private com.devbeans.io.chat.models.RegisterNewKDSUser.User user;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "message")
    private java.lang.String message;
    
    public RegisterNewKDSUser() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable
    java.lang.String status) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.RegisterNewKDSUser.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.RegisterNewKDSUser.User user) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/models/RegisterNewKDSUser$User;", "", "()V", "chatAppId", "", "createdAt", "deviceId", "name", "getChatAppId", "getCreatedAt", "getDeviceId", "getName", "setChatAppId", "", "setCreatedAt", "setDeviceId", "setName", "app_debug"})
    public static final class User {
        @com.google.gson.annotations.Expose
        @com.google.gson.annotations.SerializedName(value = "deviceId")
        private java.lang.String deviceId;
        @com.google.gson.annotations.Expose
        @com.google.gson.annotations.SerializedName(value = "createdAt")
        private java.lang.String createdAt;
        @com.google.gson.annotations.Expose
        @com.google.gson.annotations.SerializedName(value = "name")
        private java.lang.String name;
        @com.google.gson.annotations.Expose
        @com.google.gson.annotations.SerializedName(value = "chatAppId")
        private java.lang.String chatAppId;
        
        public User() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getDeviceId() {
            return null;
        }
        
        public final void setDeviceId(@org.jetbrains.annotations.Nullable
        java.lang.String deviceId) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getCreatedAt() {
            return null;
        }
        
        public final void setCreatedAt(@org.jetbrains.annotations.Nullable
        java.lang.String createdAt) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.Nullable
        java.lang.String name) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getChatAppId() {
            return null;
        }
        
        public final void setChatAppId(@org.jetbrains.annotations.Nullable
        java.lang.String chatAppId) {
        }
    }
}