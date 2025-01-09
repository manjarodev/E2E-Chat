package com.devbeans.io.chat.utils.revealable;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ$\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "conversationDatabase", "Lcom/devbeans/io/chat/roomDB/Dao/ConversationsDao;", "conversationId", "", "mmsDatabase", "Lcom/devbeans/io/chat/roomDB/Dao/MessagesDao;", "deleteMessageData", "", "messageId", "getConversation", "Lcom/devbeans/io/chat/models/Conversation;", "getMessage", "callback", "Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository$Callback;", "Ljava/util/Optional;", "Lcom/devbeans/io/chat/models/Payload;", "getMessageToSendAck", "Callback", "Companion", "app_debug"})
public final class ViewOnceMessageRepository {
    private final com.devbeans.io.chat.roomDB.Dao.MessagesDao mmsDatabase = null;
    private final com.devbeans.io.chat.roomDB.Dao.ConversationsDao conversationDatabase = null;
    private java.lang.String conversationId;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.revealable.ViewOnceMessageRepository.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public ViewOnceMessageRepository(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void getMessage(@org.jetbrains.annotations.Nullable
    java.lang.String messageId, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.revealable.ViewOnceMessageRepository.Callback<java.util.Optional<com.devbeans.io.chat.models.Payload>> callback) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getConversation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Payload getMessageToSendAck(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
        return null;
    }
    
    public final void deleteMessageData(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository$Callback;", "T", "", "onComplete", "", "result", "(Ljava/lang/Object;)V", "app_debug"})
    public static abstract interface Callback<T extends java.lang.Object> {
        
        public abstract void onComplete(T result);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/revealable/ViewOnceMessageRepository$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}