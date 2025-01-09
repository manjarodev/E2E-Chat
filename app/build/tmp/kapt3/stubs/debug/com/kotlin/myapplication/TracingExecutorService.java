package com.kotlin.myapplication;

import java.lang.System;

/**
 * An executor that will keep track of the stack trace at the time of calling [execute] and use that to build a more useful stack trace in the event of a crash.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016J\u00dd\u0001\u0010\u001b\u001a^\u0012(\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\u001d0\u001d \u0017*.\u0012(\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\u001d0\u001d\u0018\u00010\u001f0\u001c\"\u0010\b\u0000\u0010\u001e*\n \u0017*\u0004\u0018\u00010 0 2d\u0010\u0013\u001a`\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\" \u0017*.\u0012(\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\"\u0018\u00010#0!H\u0096\u0001J\u00f5\u0001\u0010\u001b\u001a^\u0012(\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\u001d0\u001d \u0017*.\u0012(\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\u001d0\u001d\u0018\u00010\u001f0\u001c\"\u0010\b\u0000\u0010\u001e*\n \u0017*\u0004\u0018\u00010 0 2d\u0010\u0013\u001a`\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\" \u0017*.\u0012(\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\"\u0018\u00010#0!2\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010$\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J\u008e\u0001\u0010%\u001a\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\"\u0010\b\u0000\u0010\u001e*\n \u0017*\u0004\u0018\u00010 0 2d\u0010\u0013\u001a`\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\" \u0017*.\u0012(\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\"\u0018\u00010#0!H\u0096\u0001\u00a2\u0006\u0002\u0010&J\u00a6\u0001\u0010%\u001a\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\"\u0010\b\u0000\u0010\u001e*\n \u0017*\u0004\u0018\u00010 0 2d\u0010\u0013\u001a`\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\" \u0017*.\u0012(\u0012&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\"\u0018\u00010#0!2\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010$\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001\u00a2\u0006\u0002\u0010\'J\t\u0010(\u001a\u00020\u0012H\u0096\u0001J\t\u0010)\u001a\u00020\u0012H\u0096\u0001J\t\u0010*\u001a\u00020\u0019H\u0096\u0001J-\u0010+\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\f0\f \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\f0\f\u0018\u00010\u001f0\u001cH\u0096\u0001J)\u0010,\u001a\u0012\u0012\u0002\b\u0003 \u0017*\b\u0012\u0002\b\u0003\u0018\u00010\u001d0\u001d2\u000e\u0010\u0013\u001a\n \u0017*\u0004\u0018\u00010\f0\fH\u0096\u0001Jd\u0010,\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\u001d0\u001d\"\u0010\b\u0000\u0010\u001e*\n \u0017*\u0004\u0018\u00010 0 2\u000e\u0010\u0013\u001a\n \u0017*\u0004\u0018\u00010\f0\f2\u000e\u0010\u0015\u001a\n \u0017*\u0004\u0018\u0001H\u001eH\u001eH\u0096\u0001\u00a2\u0006\u0002\u0010-Jk\u0010,\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\u001d0\u001d\"\u0010\b\u0000\u0010\u001e*\n \u0017*\u0004\u0018\u00010 0 2*\u0010\u0013\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H\u001eH\u001e\u0018\u00010\"0\"H\u0096\u0001R\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006."}, d2 = {"Lcom/kotlin/myapplication/TracingExecutorService;", "Ljava/util/concurrent/ExecutorService;", "wrapped", "(Ljava/util/concurrent/ExecutorService;)V", "activeCount", "", "getActiveCount", "()I", "maximumPoolSize", "getMaximumPoolSize", "queue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "getQueue", "()Ljava/util/Queue;", "getWrapped", "()Ljava/util/concurrent/ExecutorService;", "awaitTermination", "", "p0", "", "p1", "Ljava/util/concurrent/TimeUnit;", "kotlin.jvm.PlatformType", "execute", "", "command", "invokeAll", "", "Ljava/util/concurrent/Future;", "T", "", "", "", "Ljava/util/concurrent/Callable;", "", "p2", "invokeAny", "(Ljava/util/Collection;)Ljava/lang/Object;", "(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isShutdown", "isTerminated", "shutdown", "shutdownNow", "submit", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "app_debug"})
public final class TracingExecutorService implements java.util.concurrent.ExecutorService {
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.ExecutorService wrapped = null;
    
    public TracingExecutorService(@org.jetbrains.annotations.NotNull
    java.util.concurrent.ExecutorService wrapped) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.ExecutorService getWrapped() {
        return null;
    }
    
    @java.lang.Override
    public void execute(@org.jetbrains.annotations.Nullable
    java.lang.Runnable command) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Queue<java.lang.Runnable> getQueue() {
        return null;
    }
    
    public final int getActiveCount() {
        return 0;
    }
    
    public final int getMaximumPoolSize() {
        return 0;
    }
    
    @java.lang.Override
    public boolean awaitTermination(long p0, java.util.concurrent.TimeUnit p1) {
        return false;
    }
    
    @java.lang.Override
    public <T extends java.lang.Object>java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> p0) {
        return null;
    }
    
    @java.lang.Override
    public <T extends java.lang.Object>java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> p0, long p1, java.util.concurrent.TimeUnit p2) {
        return null;
    }
    
    @java.lang.Override
    public <T extends java.lang.Object>T invokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> p0) {
        return null;
    }
    
    @java.lang.Override
    public <T extends java.lang.Object>T invokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> p0, long p1, java.util.concurrent.TimeUnit p2) {
        return null;
    }
    
    @java.lang.Override
    public boolean isShutdown() {
        return false;
    }
    
    @java.lang.Override
    public boolean isTerminated() {
        return false;
    }
    
    @java.lang.Override
    public void shutdown() {
    }
    
    @java.lang.Override
    public java.util.List<java.lang.Runnable> shutdownNow() {
        return null;
    }
    
    @java.lang.Override
    public java.util.concurrent.Future<?> submit(java.lang.Runnable p0) {
        return null;
    }
    
    @java.lang.Override
    public <T extends java.lang.Object>java.util.concurrent.Future<T> submit(java.lang.Runnable p0, T p1) {
        return null;
    }
    
    @java.lang.Override
    public <T extends java.lang.Object>java.util.concurrent.Future<T> submit(java.util.concurrent.Callable<T> p0) {
        return null;
    }
}