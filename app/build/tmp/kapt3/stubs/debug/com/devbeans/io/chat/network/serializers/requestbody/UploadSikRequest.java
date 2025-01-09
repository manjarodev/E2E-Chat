package com.devbeans.io.chat.network.serializers.requestbody;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/chat/network/serializers/requestbody/UploadSikRequest;", "", "()V", "chatAppId", "", "getChatAppId", "()Ljava/lang/String;", "setChatAppId", "(Ljava/lang/String;)V", "keyObject", "Lcom/devbeans/io/chat/models/ManifestModel$SIKClass;", "getKeyObject", "()Lcom/devbeans/io/chat/models/ManifestModel$SIKClass;", "setKeyObject", "(Lcom/devbeans/io/chat/models/ManifestModel$SIKClass;)V", "app_debug"})
public final class UploadSikRequest {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "keyObject")
    private com.devbeans.io.chat.models.ManifestModel.SIKClass keyObject;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName(value = "chatAppId")
    private java.lang.String chatAppId;
    
    public UploadSikRequest() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.ManifestModel.SIKClass getKeyObject() {
        return null;
    }
    
    public final void setKeyObject(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.ManifestModel.SIKClass p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChatAppId() {
        return null;
    }
    
    public final void setChatAppId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}