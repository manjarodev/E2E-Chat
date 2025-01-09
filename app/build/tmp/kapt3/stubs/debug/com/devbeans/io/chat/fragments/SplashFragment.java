package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J(\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0012\u0010&\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\'H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\"\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-H\u0017J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u00101\u001a\u000202H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J&\u0010;\u001a\u00020\u00172\f\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016J*\u0010B\u001a\u00020\u00172\f\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010=2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030C2\u0006\u0010@\u001a\u00020AH\u0017J\u001a\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u0002042\b\u0010F\u001a\u0004\u0018\u00010:H\u0016J\b\u0010G\u001a\u00020\u0017H\u0002J\b\u0010H\u001a\u00020\u0017H\u0002J;\u0010I\u001a\u00020\u00172\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001d0K2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0003\u00a2\u0006\u0002\bLJ*\u0010M\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n \u0014*\u0004\u0018\u00010\u000e0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006N"}, d2 = {"Lcom/devbeans/io/chat/fragments/SplashFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "()V", "i", "", "isAppInitialized", "", "()Z", "setAppInitialized", "(Z)V", "mBinding", "Lcom/devbeans/io/chat/databinding/SplashFragmentBinding;", "public_key", "", "getPublic_key", "()Ljava/lang/String;", "setPublic_key", "(Ljava/lang/String;)V", "sTag", "kotlin.jvm.PlatformType", "getSTag", "callNextProcedure", "", "checkTime", "firstLaunch", "generateKeyPairs", "chat_id", "sik", "Lcom/devbeans/io/chat/models/ChatKeyPair;", "sikX", "ikCurve", "generateSik", "chatId", "handleActivities", "handleTimeResponse", "res", "Lcom/devbeans/io/chat/models/ServerTime;", "handleUserResponse", "Lcom/devbeans/io/chat/network/serializers/response/RegisterUserResponse;", "initViews", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onSuccess", "Lretrofit2/Response;", "onViewCreated", "view", "savedInstanceState", "proceedData", "registerUser", "saveAllKeys", "allKeys", "Ljava/util/ArrayList;", "saveAllKeys1", "uploadSik", "app_debug"})
public final class SplashFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.network.OnNetworkResponse {
    public java.lang.String public_key;
    private com.devbeans.io.chat.databinding.SplashFragmentBinding mBinding;
    private int i = 0;
    private boolean isAppInitialized = false;
    private final java.lang.String sTag = null;
    
    public SplashFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPublic_key() {
        return null;
    }
    
    public final void setPublic_key(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean isAppInitialized() {
        return false;
    }
    
    public final void setAppInitialized(boolean p0) {
    }
    
    public final java.lang.String getSTag() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup viewGroup, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle) {
        return null;
    }
    
    private final void initViews() {
    }
    
    /**
     * Checking the server time in [proceedData]
     * if the time is not correct the App will always prompt for setting time of device (Android)
     */
    private final void proceedData() {
    }
    
    /**
     * If the server time is correct [proceedData] this is the next procedure of registering [User] on Chat Server ]
     */
    private final void callNextProcedure() {
    }
    
    /**
     * Registering the [User] on chat server
     */
    private final void registerUser() {
    }
    
    private final void generateSik(java.lang.String chatId) {
    }
    
    private final void uploadSik(java.lang.String chatId, com.devbeans.io.chat.models.ChatKeyPair sik, com.devbeans.io.chat.models.ChatKeyPair sikX, com.devbeans.io.chat.models.ChatKeyPair ikCurve) {
    }
    
    /**
     * Will generate Key pair from [KeyPairGenerator]
     */
    private final void generateKeyPairs(java.lang.String chat_id, com.devbeans.io.chat.models.ChatKeyPair sik, com.devbeans.io.chat.models.ChatKeyPair sikX, com.devbeans.io.chat.models.ChatKeyPair ikCurve) {
    }
    
    @java.lang.Override
    @java.lang.Deprecated
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    /**
     * Will save All keyPair generated in [generateKeyPairs] and
     * saves in [GeneratedPrivateKeyByte] table in Encrypted Database
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.security.cert.CertificateException.class, java.io.IOException.class, java.security.NoSuchAlgorithmException.class, java.security.KeyStoreException.class})
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    @kotlin.jvm.JvmName(name = "saveAllKeys1")
    private final void saveAllKeys1(java.util.ArrayList<com.devbeans.io.chat.models.ChatKeyPair> allKeys, java.lang.String chat_id, com.devbeans.io.chat.models.ChatKeyPair sik, com.devbeans.io.chat.models.ChatKeyPair sikX, com.devbeans.io.chat.models.ChatKeyPair ikCurve) {
    }
    
    private final void checkTime(boolean firstLaunch) {
    }
    
    private final void handleTimeResponse(com.devbeans.io.chat.models.ServerTime res, boolean firstLaunch) {
    }
    
    private final void handleActivities() {
    }
    
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    private final void handleUserResponse(com.devbeans.io.chat.network.serializers.response.RegisterUserResponse res) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
}