package com.devbeans.io.chat.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'J,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H\'J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u0006H\'J4\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00062\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\'J4\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00062\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\'J\u001c\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00032\b\b\u0001\u0010!\u001a\u00020\"H\'\u00a8\u0006#"}, d2 = {"Lcom/devbeans/io/chat/network/APIInterface;", "", "createNewUser", "Lretrofit2/Call;", "Lcom/devbeans/io/chat/models/RegisterNewKDSUser;", "name", "", "generatedDeviceId", "chat_id", "deleteKeyStore", "Lcom/devbeans/io/chat/models/DeleteKeyStoreModel;", "device_id", "getEK", "Lcom/devbeans/io/chat/network/EncryptedModel;", "chatAppId", "members", "conversationId", "getIK", "getMonikerEK", "getMonikerIK", "getServerTime", "Lcom/devbeans/io/chat/models/ServerTime;", "updateChatId", "Lcom/devbeans/io/chat/network/serializers/response/RenewChatIdResponse;", "deviceId", "ikPubKey", "uploadKeys", "Lcom/devbeans/io/chat/network/serializers/response/UploadKeysModel;", "encryptedString", "deviceBody", "signature", "uploadOnKeyDeficiency", "uploadSIK", "uploadSikRequest", "Lcom/devbeans/io/chat/network/serializers/requestbody/UploadSikRequest;", "app_debug"})
public abstract interface APIInterface {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "keyStore")
    @retrofit2.http.FormUrlEncoded
    public abstract retrofit2.Call<com.devbeans.io.chat.network.serializers.response.UploadKeysModel> uploadKeys(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Field(value = "encryptedString")
    java.lang.String encryptedString, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Field(value = "chatAppId")
    java.lang.String deviceBody, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Field(value = "signature")
    java.lang.String signature);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "keyStore/uploadKeyInitial")
    public abstract retrofit2.Call<com.devbeans.io.chat.network.serializers.response.UploadKeysModel> uploadSIK(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.devbeans.io.chat.network.serializers.requestbody.UploadSikRequest uploadSikRequest);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "keyStore/uploads_keys_on_deficiency")
    @retrofit2.http.FormUrlEncoded
    public abstract retrofit2.Call<com.devbeans.io.chat.network.serializers.response.UploadKeysModel> uploadOnKeyDeficiency(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Field(value = "encryptedString")
    java.lang.String encryptedString, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Field(value = "chatAppId")
    java.lang.String deviceBody, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Field(value = "signature")
    java.lang.String signature);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "user")
    @retrofit2.http.FormUrlEncoded
    public abstract retrofit2.Call<com.devbeans.io.chat.models.RegisterNewKDSUser> createNewUser(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Field(value = "name")
    java.lang.String name, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Field(value = "deviceId")
    java.lang.String generatedDeviceId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Field(value = "chatAppId")
    java.lang.String chat_id);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.GET(value = "/keyStore/")
    public abstract retrofit2.Call<com.devbeans.io.chat.network.EncryptedModel> getEK(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "chatAppId")
    java.lang.String chatAppId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "requestedIDs")
    java.lang.String members, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "conversationId")
    java.lang.String conversationId);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.GET(value = "/keyStore/identity_key/")
    public abstract retrofit2.Call<com.devbeans.io.chat.network.EncryptedModel> getIK(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "chatAppId")
    java.lang.String chatAppId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "requestedIDs")
    java.lang.String members, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "conversationId")
    java.lang.String conversationId);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.GET(value = "/keyStore/request_moniker_ephemeral_keys")
    public abstract retrofit2.Call<com.devbeans.io.chat.network.EncryptedModel> getMonikerEK(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "chatAppId")
    java.lang.String chatAppId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "requestedMonikers")
    java.lang.String members, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "conversationId")
    java.lang.String conversationId);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.GET(value = "/keyStore/identity_key_moniker")
    public abstract retrofit2.Call<com.devbeans.io.chat.network.EncryptedModel> getMonikerIK(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "chatAppId")
    java.lang.String chatAppId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "requestedMonikers")
    java.lang.String members, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "conversationId")
    java.lang.String conversationId);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.GET(value = "app/server_time")
    public abstract retrofit2.Call<com.devbeans.io.chat.models.ServerTime> getServerTime();
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.DELETE(value = "KeyStore/")
    public abstract retrofit2.Call<com.devbeans.io.chat.models.DeleteKeyStoreModel> deleteKeyStore(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "deviceId")
    java.lang.String device_id);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.PUT(value = "user/update_chat_id")
    public abstract retrofit2.Call<com.devbeans.io.chat.network.serializers.response.RenewChatIdResponse> updateChatId(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "deviceId")
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "chatAppId")
    java.lang.String generatedDeviceId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "ikPubKey")
    java.lang.String ikPubKey);
}