package com.devbeans.io.chat.app;

import java.lang.System;

@kotlinx.coroutines.DelicateCoroutinesApi
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/app/testKey;", "", "()V", "getOLDKey", "Ljavax/crypto/SecretKey;", "loadSecureKey", "context", "Landroid/content/Context;", "CallBackKey", "app_debug"})
public final class testKey {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.app.testKey INSTANCE = null;
    
    private testKey() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.P)
    public final javax.crypto.SecretKey loadSecureKey(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final javax.crypto.SecretKey getOLDKey() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/app/testKey$CallBackKey;", "", "returnKeyValue", "", "value", "", "app_debug"})
    public static abstract interface CallBackKey {
        
        public abstract void returnKeyValue(@org.jetbrains.annotations.NotNull
        java.lang.String value);
    }
}