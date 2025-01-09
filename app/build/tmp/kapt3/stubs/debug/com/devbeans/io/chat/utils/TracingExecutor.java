package com.devbeans.io.chat.utils;

import java.lang.System;

/**
 * An executor that will keep track of the stack trace at the time of calling [execute] and use that to build a more useful stack trace in the event of a crash.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/utils/TracingExecutor;", "Ljava/util/concurrent/Executor;", "wrapped", "(Ljava/util/concurrent/Executor;)V", "getWrapped", "()Ljava/util/concurrent/Executor;", "execute", "", "command", "Ljava/lang/Runnable;", "app_debug"})
public final class TracingExecutor implements java.util.concurrent.Executor {
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.Executor wrapped = null;
    
    public TracingExecutor(@org.jetbrains.annotations.NotNull
    java.util.concurrent.Executor wrapped) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.Executor getWrapped() {
        return null;
    }
    
    @java.lang.Override
    public void execute(@org.jetbrains.annotations.Nullable
    java.lang.Runnable command) {
    }
}