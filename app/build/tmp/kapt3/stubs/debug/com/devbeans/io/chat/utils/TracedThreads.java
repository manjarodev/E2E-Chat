package com.devbeans.io.chat.utils;

import java.lang.System;

/**
 * A container for keeping track of the caller stack traces of the threads we care about.
 *
 * Note: This should only be used for debugging. To keep overhead minimal, not much effort has been put into ensuring this map is 100% accurate.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/utils/TracedThreads;", "", "()V", "callerStackTraces", "", "", "", "getCallerStackTraces", "()Ljava/util/Map;", "app_debug"})
public final class TracedThreads {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.TracedThreads INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.Map<java.lang.Long, java.lang.Throwable> callerStackTraces = null;
    
    private TracedThreads() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.Long, java.lang.Throwable> getCallerStackTraces() {
        return null;
    }
}