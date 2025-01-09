package com.devbeans.io.chat.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u00b4\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002\u001a\f\u00108\u001a\u000209*\u00020\u0002H\u0007\u001a\u0012\u0010:\u001a\u000202*\u00020\u00022\u0006\u0010;\u001a\u000205\u001a\f\u0010<\u001a\u0004\u0018\u000105*\u00020\u0002\u001a\u0012\u0010=\u001a\u000205*\u00020\u00022\u0006\u0010>\u001a\u000207\u001a\n\u0010?\u001a\u000209*\u00020\u0002\u001a\u0012\u0010@\u001a\u000209*\u00020\u00022\u0006\u0010A\u001a\u000207\u001a\u0012\u0010B\u001a\u000202*\u00020\u00022\u0006\u0010C\u001a\u00020D\u001a|\u0010E\u001a\u000202*\u00020\u00022\u0006\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002050I2\n\b\u0002\u0010J\u001a\u0004\u0018\u0001052\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010I2\n\b\u0002\u0010L\u001a\u0004\u0018\u0001052\b\b\u0002\u0010M\u001a\u0002092!\u0010N\u001a\u001d\u0012\u0013\u0012\u00110P\u00a2\u0006\f\bQ\u0012\b\bR\u0012\u0004\b\b(S\u0012\u0004\u0012\u0002020O\u00a2\u0006\u0002\u0010T\u001a9\u0010U\u001a\u0004\u0018\u00010P*\u00020\u00022\u0006\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002050I2\u0006\u0010V\u001a\u0002052\u0006\u0010W\u001a\u000207H\u0002\u00a2\u0006\u0002\u0010X\u001a \u0010Y\u001a\u000202*\u00020\u00022\n\u0010Z\u001a\u00060[j\u0002`\\2\b\b\u0002\u00106\u001a\u000207\u001a\u001c\u0010Y\u001a\u000202*\u00020\u00022\u0006\u0010]\u001a\u0002052\b\b\u0002\u00106\u001a\u000207\u001a\u001c\u0010^\u001a\u000202*\u00020\u00022\u0006\u0010>\u001a\u0002072\b\b\u0002\u00106\u001a\u000207\u001a\u001c\u0010^\u001a\u000202*\u00020\u00022\u0006\u0010]\u001a\u0002052\b\b\u0002\u00106\u001a\u000207\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0015\u0010!\u001a\u00020\"*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\"\u0015\u0010%\u001a\u00020&*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\'\u0010(\"\u0015\u0010)\u001a\u00020**\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\"\u0015\u0010-\u001a\u00020.*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b/\u00100\u00a8\u0006_"}, d2 = {"EkDao", "Lcom/devbeans/io/chat/roomDB/Dao/SecretEKDao;", "Landroid/content/Context;", "getEkDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/SecretEKDao;", "chatKeyPairDao", "Lcom/devbeans/io/chat/roomDB/Dao/ChatKeyPairDao;", "getChatKeyPairDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/ChatKeyPairDao;", "contactsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ContactsDao;", "getContactsDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/ContactsDao;", "conversationChannelsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ConversationChannelsDao;", "getConversationChannelsDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/ConversationChannelsDao;", "conversationsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ConversationsDao;", "getConversationsDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/ConversationsDao;", "generateDao", "Lcom/devbeans/io/chat/roomDB/Dao/GeneratedDao;", "getGenerateDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/GeneratedDao;", "identityKeyPairDao", "Lcom/devbeans/io/chat/roomDB/Dao/IdentityKeyPairDao;", "getIdentityKeyPairDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/IdentityKeyPairDao;", "keyPairDao", "Lcom/devbeans/io/chat/roomDB/Dao/KeyPairDao;", "getKeyPairDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/KeyPairDao;", "messagesDao", "Lcom/devbeans/io/chat/roomDB/Dao/MessagesDao;", "getMessagesDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/MessagesDao;", "offlineAckDao", "Lcom/devbeans/io/chat/roomDB/Dao/OfflineAckDao;", "getOfflineAckDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/OfflineAckDao;", "offlineMessagesDao", "Lcom/devbeans/io/chat/roomDB/Dao/OfflineMessagesDao;", "getOfflineMessagesDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/OfflineMessagesDao;", "secreteDao", "Lcom/devbeans/io/chat/roomDB/Dao/SecreteKeyDao;", "getSecreteDao", "(Landroid/content/Context;)Lcom/devbeans/io/chat/roomDB/Dao/SecreteKeyDao;", "doToast", "", "context", "message", "", "length", "", "checkExternalPermissionLegacy", "", "copyToClipboard", "text", "getCurrentClip", "getPermissionString", "id", "hasDrawOverlay", "hasPermission", "permId", "launchActivityIntent", "intent", "Landroid/content/Intent;", "queryCursor", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "showErrors", "callback", "Lkotlin/Function1;", "Landroid/database/Cursor;", "Lkotlin/ParameterName;", "name", "cursor", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "queryCursorDesc", "sortColumn", "limit", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;", "showErrorToast", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "toast", "app_debug"})
public final class ContextKt {
    
    public static final void toast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$toast, int id, int length) {
    }
    
    public static final void toast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$toast, @org.jetbrains.annotations.NotNull
    java.lang.String msg, int length) {
    }
    
    private static final void doToast(android.content.Context context, java.lang.String message, int length) {
    }
    
    public static final void showErrorToast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$showErrorToast, @org.jetbrains.annotations.NotNull
    java.lang.String msg, int length) {
    }
    
    public static final void showErrorToast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$showErrorToast, @org.jetbrains.annotations.NotNull
    java.lang.Exception exception, int length) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.ContactsDao getContactsDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$contactsDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.ConversationsDao getConversationsDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$conversationsDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.MessagesDao getMessagesDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$messagesDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.OfflineMessagesDao getOfflineMessagesDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$offlineMessagesDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.KeyPairDao getKeyPairDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$keyPairDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.SecreteKeyDao getSecreteDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$secreteDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.GeneratedDao getGenerateDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$generateDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.IdentityKeyPairDao getIdentityKeyPairDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$identityKeyPairDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.ChatKeyPairDao getChatKeyPairDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$chatKeyPairDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.ConversationChannelsDao getConversationChannelsDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$conversationChannelsDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.SecretEKDao getEkDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$EkDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.roomDB.Dao.OfflineAckDao getOfflineAckDao(@org.jetbrains.annotations.NotNull
    android.content.Context $this$offlineAckDao) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String getCurrentClip(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getCurrentClip) {
        return null;
    }
    
    private static final android.database.Cursor queryCursorDesc(android.content.Context $this$queryCursorDesc, android.net.Uri uri, java.lang.String[] projection, java.lang.String sortColumn, int limit) {
        return null;
    }
    
    public static final boolean hasPermission(@org.jetbrains.annotations.NotNull
    android.content.Context $this$hasPermission, int permId) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getPermissionString(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getPermissionString, int id) {
        return null;
    }
    
    public static final boolean hasDrawOverlay(@org.jetbrains.annotations.NotNull
    android.content.Context $this$hasDrawOverlay) {
        return false;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.R)
    public static final boolean checkExternalPermissionLegacy(@org.jetbrains.annotations.NotNull
    android.content.Context $this$checkExternalPermissionLegacy) {
        return false;
    }
    
    public static final void launchActivityIntent(@org.jetbrains.annotations.NotNull
    android.content.Context $this$launchActivityIntent, @org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
    }
    
    public static final void queryCursor(@org.jetbrains.annotations.NotNull
    android.content.Context $this$queryCursor, @org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    java.lang.String[] projection, @org.jetbrains.annotations.Nullable
    java.lang.String selection, @org.jetbrains.annotations.Nullable
    java.lang.String[] selectionArgs, @org.jetbrains.annotations.Nullable
    java.lang.String sortOrder, boolean showErrors, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.database.Cursor, kotlin.Unit> callback) {
    }
    
    public static final void copyToClipboard(@org.jetbrains.annotations.NotNull
    android.content.Context $this$copyToClipboard, @org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
}