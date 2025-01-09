package com.devbeans.io.chat.app;

import java.lang.System;

@androidx.room.Database(entities = {com.devbeans.io.chat.models.Contact.class, com.devbeans.io.chat.models.Conversation.class, com.devbeans.io.chat.models.Payload.class, com.devbeans.io.chat.models.OfflineMessage.class, com.devbeans.io.chat.models.KeyModel.class, com.devbeans.io.chat.models.SecreteKeyModel.class, com.devbeans.io.chat.models.GeneratedPrivateKeyByte.class, com.devbeans.io.chat.models.IdentityKeyPair.class, com.devbeans.io.chat.models.ChatKeyPair.class, com.devbeans.io.chat.models.ConversationChannels.class, com.devbeans.io.chat.encryption.SecretEk.class, com.devbeans.io.chat.models.OfflineAck.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&\u00a8\u0006\u001c"}, d2 = {"Lcom/devbeans/io/chat/app/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "ChatKeyPairDao", "Lcom/devbeans/io/chat/roomDB/Dao/ChatKeyPairDao;", "ConversationChannelsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ConversationChannelsDao;", "EKDao", "Lcom/devbeans/io/chat/roomDB/Dao/SecretEKDao;", "GeneratedDao", "Lcom/devbeans/io/chat/roomDB/Dao/GeneratedDao;", "IdentityKeyPairDao", "Lcom/devbeans/io/chat/roomDB/Dao/IdentityKeyPairDao;", "SecreteKeyDao", "Lcom/devbeans/io/chat/roomDB/Dao/SecreteKeyDao;", "contactsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ContactsDao;", "conversationsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ConversationsDao;", "keyPairDao", "Lcom/devbeans/io/chat/roomDB/Dao/KeyPairDao;", "messagesDao", "Lcom/devbeans/io/chat/roomDB/Dao/MessagesDao;", "offlineAckDao", "Lcom/devbeans/io/chat/roomDB/Dao/OfflineAckDao;", "offlineMessagesDao", "Lcom/devbeans/io/chat/roomDB/Dao/OfflineMessagesDao;", "Companion", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.app.AppDatabase.Companion Companion = null;
    private static com.devbeans.io.chat.app.AppDatabase INSTANCE;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.ContactsDao contactsDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.ConversationsDao conversationsDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.MessagesDao messagesDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.OfflineMessagesDao offlineMessagesDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.KeyPairDao keyPairDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.SecreteKeyDao SecreteKeyDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.GeneratedDao GeneratedDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.IdentityKeyPairDao IdentityKeyPairDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.ChatKeyPairDao ChatKeyPairDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.ConversationChannelsDao ConversationChannelsDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.SecretEKDao EKDao();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.devbeans.io.chat.roomDB.Dao.OfflineAckDao offlineAckDao();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/app/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/devbeans/io/chat/app/AppDatabase;", "destroyInstance", "", "getAppDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.P)
        public final com.devbeans.io.chat.app.AppDatabase getAppDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        public final void destroyInstance() {
        }
    }
}