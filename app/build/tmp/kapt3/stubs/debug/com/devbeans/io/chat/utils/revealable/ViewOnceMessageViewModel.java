package com.devbeans.io.chat.utils.revealable;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0012J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0006\u0010\u0016\u001a\u00020\u0010R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageViewModel;", "Landroidx/lifecycle/ViewModel;", "messageId", "", "repository", "Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository;", "(Ljava/lang/String;Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository;)V", "message", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/Optional;", "Lcom/devbeans/io/chat/models/Payload;", "getMessageId", "()Ljava/lang/String;", "getRepository", "()Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository;", "deleteMessageData", "", "getMessage", "Landroidx/lifecycle/LiveData;", "onCleared", "onMessageRetrieved", "optionalMessage", "sendOpenedAck", "Companion", "Factory", "app_debug"})
public final class ViewOnceMessageViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String messageId = null;
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.utils.revealable.ViewOnceMessageRepository repository = null;
    private final androidx.lifecycle.MutableLiveData<java.util.Optional<com.devbeans.io.chat.models.Payload>> message = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.revealable.ViewOnceMessageViewModel.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    private ViewOnceMessageViewModel(java.lang.String messageId, com.devbeans.io.chat.utils.revealable.ViewOnceMessageRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessageId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.revealable.ViewOnceMessageRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.Optional<com.devbeans.io.chat.models.Payload>> getMessage() {
        return null;
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
    
    private final void onMessageRetrieved(java.util.Optional<com.devbeans.io.chat.models.Payload> optionalMessage) {
    }
    
    public final void sendOpenedAck() {
    }
    
    public final void deleteMessageData() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "messageId", "", "repository", "Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository;", "(Ljava/lang/String;Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory extends androidx.lifecycle.ViewModelProvider.NewInstanceFactory {
        private final java.lang.String messageId = null;
        private final com.devbeans.io.chat.utils.revealable.ViewOnceMessageRepository repository = null;
        
        public Factory(@org.jetbrains.annotations.NotNull
        java.lang.String messageId, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.revealable.ViewOnceMessageRepository repository) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}