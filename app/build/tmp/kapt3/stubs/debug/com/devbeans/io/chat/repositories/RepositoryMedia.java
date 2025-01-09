package com.devbeans.io.chat.repositories;

import java.lang.System;

/**
 * Data Class Live Data
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/repositories/RepositoryMedia;", "", "()V", "currentProgress", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveProgress", "Companion", "app_debug"})
public final class RepositoryMedia {
    @com.google.gson.annotations.SerializedName(value = "currentProgress")
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> currentProgress;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.repositories.RepositoryMedia.Companion Companion = null;
    private static final com.devbeans.io.chat.repositories.RepositoryMedia mInstance = null;
    
    private RepositoryMedia() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLiveProgress() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/repositories/RepositoryMedia$Companion;", "", "()V", "mInstance", "Lcom/devbeans/io/chat/repositories/RepositoryMedia;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.Synchronized
        public final synchronized com.devbeans.io.chat.repositories.RepositoryMedia getInstance() {
            return null;
        }
    }
}