package com.devbeans.io.chat.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/devbeans/io/chat/models/DeleteKeyStoreModel;", "", "()V", "code", "", "Ljava/lang/Integer;", "key", "Lcom/devbeans/io/chat/models/DeleteKeyStoreModel$Key;", "getCode", "()Ljava/lang/Integer;", "getKey", "setCode", "", "(Ljava/lang/Integer;)V", "setKey", "Key", "app_debug"})
public final class DeleteKeyStoreModel {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "code")
    private java.lang.Integer code;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "key")
    private com.devbeans.io.chat.models.DeleteKeyStoreModel.Key key;
    
    public DeleteKeyStoreModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getCode() {
        return null;
    }
    
    public final void setCode(@org.jetbrains.annotations.Nullable
    java.lang.Integer code) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.DeleteKeyStoreModel.Key getKey() {
        return null;
    }
    
    public final void setKey(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.DeleteKeyStoreModel.Key key) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/models/DeleteKeyStoreModel$Key;", "", "()V", "acknowledged", "", "getAcknowledged", "()Ljava/lang/Boolean;", "setAcknowledged", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "deletedCount", "", "getDeletedCount", "()Ljava/lang/Integer;", "setDeletedCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_debug"})
    public static final class Key {
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.Expose
        @com.google.gson.annotations.SerializedName(value = "acknowledged")
        private java.lang.Boolean acknowledged;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.Expose
        @com.google.gson.annotations.SerializedName(value = "deletedCount")
        private java.lang.Integer deletedCount;
        
        public Key() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Boolean getAcknowledged() {
            return null;
        }
        
        public final void setAcknowledged(@org.jetbrains.annotations.Nullable
        java.lang.Boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Integer getDeletedCount() {
            return null;
        }
        
        public final void setDeletedCount(@org.jetbrains.annotations.Nullable
        java.lang.Integer p0) {
        }
    }
}