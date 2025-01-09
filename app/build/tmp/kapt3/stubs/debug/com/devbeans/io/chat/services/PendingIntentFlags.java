package com.devbeans.io.chat.services;

import java.lang.System;

/**
 * Wrapper class for lower level API compatibility with the new Pending Intents flags.
 *
 * This is meant to be a replacement to using PendingIntent flags independently, and should
 * end up being the only place in our codebase that accesses these values.
 *
 * The "default" value is FLAG_MUTABLE
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/services/PendingIntentFlags;", "", "()V", "cancelCurrent", "", "immutable", "mutable", "oneShot", "updateCurrent", "app_debug"})
public final class PendingIntentFlags {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.services.PendingIntentFlags INSTANCE = null;
    
    private PendingIntentFlags() {
        super();
    }
    
    @kotlin.jvm.JvmStatic
    public static final int updateCurrent() {
        return 0;
    }
    
    @kotlin.jvm.JvmStatic
    public static final int cancelCurrent() {
        return 0;
    }
    
    @kotlin.jvm.JvmStatic
    public static final int oneShot() {
        return 0;
    }
    
    /**
     * The backwards compatible "default" value for pending intent flags.
     */
    @kotlin.jvm.JvmStatic
    public static final int mutable() {
        return 0;
    }
    
    @kotlin.jvm.JvmStatic
    public static final int immutable() {
        return 0;
    }
}