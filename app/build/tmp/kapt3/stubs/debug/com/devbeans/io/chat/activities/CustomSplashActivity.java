package com.devbeans.io.chat.activities;

import java.lang.System;

/**
 * Custom Splash Responsible for First ever launch server time check
 */
@android.annotation.SuppressLint(value = {"CustomSplashScreen"})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\"\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0015J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J&\u0010\"\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(H\u0016J-\u0010)\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00072\u000e\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0+2\u0006\u0010,\u001a\u00020-H\u0016\u00a2\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0015H\u0014J\b\u00100\u001a\u00020\u0015H\u0014J*\u00101\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010$2\n\u0010%\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010\'\u001a\u00020(H\u0017J\b\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0015H\u0002J;\u00105\u001a\u00020\u00152\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u000208H\u0003\u00a2\u0006\u0002\b=J*\u0010>\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u000208H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006@"}, d2 = {"Lcom/devbeans/io/chat/activities/CustomSplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "()V", "check", "", "i", "", "isAppInitialized", "()Z", "setAppInitialized", "(Z)V", "public_key", "", "splashBinding", "Lcom/devbeans/io/chat/databinding/ActivitySplashBinding;", "getSplashBinding", "()Lcom/devbeans/io/chat/databinding/ActivitySplashBinding;", "setSplashBinding", "(Lcom/devbeans/io/chat/databinding/ActivitySplashBinding;)V", "callNextProcedure", "", "connectMQTT", "generateSik", "chatId", "initViews", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onSuccess", "Lretrofit2/Response;", "proceedData", "registerUser", "saveAllKeys", "allKeys", "Ljava/util/ArrayList;", "Lcom/devbeans/io/chat/models/ChatKeyPair;", "chat_id", "sik", "sikX", "ikCurve", "saveAllKeys1", "uploadSik", "Companion", "app_debug"})
public final class CustomSplashActivity extends androidx.appcompat.app.AppCompatActivity implements com.devbeans.io.chat.network.OnNetworkResponse {
    private boolean check = false;
    private java.lang.String public_key;
    public com.devbeans.io.chat.databinding.ActivitySplashBinding splashBinding;
    private int i = 0;
    private boolean isAppInitialized = false;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.CustomSplashActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.activities.CustomSplashActivity INSTANCE;
    
    public CustomSplashActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.databinding.ActivitySplashBinding getSplashBinding() {
        return null;
    }
    
    public final void setSplashBinding(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.databinding.ActivitySplashBinding p0) {
    }
    
    public final boolean isAppInitialized() {
        return false;
    }
    
    public final void setAppInitialized(boolean p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void connectMQTT() {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    /**
     * Checking the server time in [proceedData]
     * if the time is not correct the App will always prompt for setting time of device (Android)
     */
    private final void proceedData() {
    }
    
    @java.lang.Override
    @java.lang.Deprecated
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    /**
     * If the server time is correct [proceedData] this is the next procedure of registering [User] on Chat Server ]
     */
    private final void callNextProcedure() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void initViews() {
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
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.CustomSplashActivity getInstance() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    public static final void runService() {
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
    
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/devbeans/io/chat/activities/CustomSplashActivity$Companion;", "", "()V", "INSTANCE", "Lcom/devbeans/io/chat/activities/CustomSplashActivity;", "getINSTANCE", "()Lcom/devbeans/io/chat/activities/CustomSplashActivity;", "setINSTANCE", "(Lcom/devbeans/io/chat/activities/CustomSplashActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "getInstance$annotations", "getInstance", "runService", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.activities.CustomSplashActivity getINSTANCE() {
            return null;
        }
        
        public final void setINSTANCE(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.activities.CustomSplashActivity p0) {
        }
        
        @kotlin.jvm.JvmStatic
        @java.lang.Deprecated
        public static void getInstance$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.activities.CustomSplashActivity getInstance() {
            return null;
        }
        
        @kotlin.jvm.JvmStatic
        public final void runService() {
        }
    }
}