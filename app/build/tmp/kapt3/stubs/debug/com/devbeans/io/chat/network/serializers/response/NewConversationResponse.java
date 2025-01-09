package com.devbeans.io.chat.network.serializers.response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\nH\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\n8\u0002X\u0083D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/devbeans/io/chat/network/serializers/response/NewConversationResponse;", "", "()V", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "getConversation", "()Lcom/devbeans/io/chat/models/Conversation;", "setConversation", "(Lcom/devbeans/io/chat/models/Conversation;)V", "encData", "", "imageBucketLink", "getImageBucketLink", "()Ljava/lang/String;", "setImageBucketLink", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "status", "getStatus", "setStatus", "toString", "app_debug"})
public final class NewConversationResponse {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "message")
    private java.lang.String message = "";
    @org.jetbrains.annotations.Nullable
    @androidx.room.Embedded
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "conversation")
    private com.devbeans.io.chat.models.Conversation conversation;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "imageBucketLink")
    private java.lang.String imageBucketLink = "";
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "data")
    private final java.lang.String encData = "";
    
    public NewConversationResponse() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getConversation() {
        return null;
    }
    
    public final void setConversation(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getImageBucketLink() {
        return null;
    }
    
    public final void setImageBucketLink(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}