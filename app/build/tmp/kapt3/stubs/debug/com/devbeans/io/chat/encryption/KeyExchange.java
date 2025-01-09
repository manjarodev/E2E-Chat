package com.devbeans.io.chat.encryption;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/devbeans/io/chat/encryption/KeyExchange;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "dh", "Lcom/goterl/lazysodium/interfaces/DiffieHellman$Lazy;", "ls", "Lcom/goterl/lazysodium/LazySodiumAndroid;", "exchange", "", "priv", "pub", "app_debug"})
public final class KeyExchange {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.encryption.KeyExchange INSTANCE = null;
    private static final java.lang.String TAG = null;
    private static final com.goterl.lazysodium.LazySodiumAndroid ls = null;
    private static final com.goterl.lazysodium.interfaces.DiffieHellman.Lazy dh = null;
    
    private KeyExchange() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.Throws(exceptionClasses = {})
    public final byte[] exchange(@org.jetbrains.annotations.NotNull
    java.lang.String priv, @org.jetbrains.annotations.NotNull
    java.lang.String pub) {
        return null;
    }
}