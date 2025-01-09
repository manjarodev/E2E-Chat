package com.kotlin.myapplication;

import java.lang.System;

/**
 * An uncaught exception handler that will combine a caller stack trace with the exception to print a more useful stack trace.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/kotlin/myapplication/TracingUncaughtExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "originalHandler", "callerStackTrace", "", "(Ljava/lang/Thread$UncaughtExceptionHandler;Ljava/lang/Throwable;)V", "getOriginalHandler", "()Ljava/lang/Thread$UncaughtExceptionHandler;", "uncaughtException", "", "thread", "Ljava/lang/Thread;", "exception", "app_debug"})
public final class TracingUncaughtExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {
    @org.jetbrains.annotations.Nullable
    private final java.lang.Thread.UncaughtExceptionHandler originalHandler = null;
    private final java.lang.Throwable callerStackTrace = null;
    
    public TracingUncaughtExceptionHandler(@org.jetbrains.annotations.Nullable
    java.lang.Thread.UncaughtExceptionHandler originalHandler, @org.jetbrains.annotations.NotNull
    java.lang.Throwable callerStackTrace) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Thread.UncaughtExceptionHandler getOriginalHandler() {
        return null;
    }
    
    @java.lang.Override
    public void uncaughtException(@org.jetbrains.annotations.NotNull
    java.lang.Thread thread, @org.jetbrains.annotations.NotNull
    java.lang.Throwable exception) {
    }
}