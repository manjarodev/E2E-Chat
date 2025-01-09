package com.devbeans.io.chat.app;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.devbeans.io.chat.roomDB.Dao.ChatKeyPairDao;
import com.devbeans.io.chat.roomDB.Dao.ChatKeyPairDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.ContactsDao;
import com.devbeans.io.chat.roomDB.Dao.ContactsDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.ConversationChannelsDao;
import com.devbeans.io.chat.roomDB.Dao.ConversationChannelsDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.ConversationsDao;
import com.devbeans.io.chat.roomDB.Dao.ConversationsDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.GeneratedDao;
import com.devbeans.io.chat.roomDB.Dao.GeneratedDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.IdentityKeyPairDao;
import com.devbeans.io.chat.roomDB.Dao.IdentityKeyPairDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.KeyPairDao;
import com.devbeans.io.chat.roomDB.Dao.KeyPairDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.MessagesDao;
import com.devbeans.io.chat.roomDB.Dao.MessagesDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.OfflineAckDao;
import com.devbeans.io.chat.roomDB.Dao.OfflineAckDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.OfflineMessagesDao;
import com.devbeans.io.chat.roomDB.Dao.OfflineMessagesDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.SecretEKDao;
import com.devbeans.io.chat.roomDB.Dao.SecretEKDao_Impl;
import com.devbeans.io.chat.roomDB.Dao.SecreteKeyDao;
import com.devbeans.io.chat.roomDB.Dao.SecreteKeyDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ContactsDao _contactsDao;

  private volatile ConversationsDao _conversationsDao;

  private volatile MessagesDao _messagesDao;

  private volatile OfflineMessagesDao _offlineMessagesDao;

  private volatile KeyPairDao _keyPairDao;

  private volatile SecreteKeyDao _secreteKeyDao;

  private volatile GeneratedDao _generatedDao;

  private volatile IdentityKeyPairDao _identityKeyPairDao;

  private volatile ChatKeyPairDao _chatKeyPairDao;

  private volatile ConversationChannelsDao _conversationChannelsDao;

  private volatile SecretEKDao _secretEKDao;

  private volatile OfflineAckDao _offlineAckDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Contact` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `chatUserId` TEXT, `image` TEXT, `color` TEXT, `isChecked` INTEGER NOT NULL, `avatarColor` TEXT, `alias` TEXT, `isBlocked` INTEGER NOT NULL, `isQrAdded` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Conversation` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `description` TEXT, `_conversation_id` TEXT, `_conversation_type` TEXT, `_conversationMembers` TEXT, `messages` TEXT, `owner` TEXT, `con_createdAt` TEXT, `keepChatDate` TEXT, `isRemoved` INTEGER NOT NULL, `isArchived` INTEGER NOT NULL, `isInConversation` INTEGER NOT NULL, `_isViewOnce` INTEGER NOT NULL, `photo` TEXT, `conversationPhoto` TEXT, `myMoniker` TEXT, `conversationExpiryTime` INTEGER NOT NULL, `isCanShareForward` INTEGER NOT NULL, `isAutoSaveVault` INTEGER NOT NULL, `_isConfidential` INTEGER NOT NULL, `_isMediaShareRestrict` INTEGER NOT NULL, `sequenceOfConversation` INTEGER NOT NULL, `isPinned` INTEGER NOT NULL, `hasSentMessage` INTEGER NOT NULL, `conReadReceipts` INTEGER NOT NULL, `unreadCount` INTEGER NOT NULL, `id` INTEGER, `data` TEXT, `type` TEXT, `messageId` TEXT, `senderId` TEXT, `createdAt` TEXT, `ack_id` TEXT, `conversationId` TEXT, `conversationType` TEXT, `userChatId` TEXT, `filePath` TEXT, `status` TEXT, `isEdited` INTEGER, `isDeleted` INTEGER, `deliveredList` TEXT, `readList` TEXT, `openedList` TEXT, `isExpire` INTEGER, `isForwarded` INTEGER, `isConfidential` INTEGER, `isViewOnce` INTEGER, `isViewed` INTEGER, `isDownloading` INTEGER, `readReceipts` INTEGER, `isOpened` INTEGER, `msgExpiryTime` INTEGER, `expireStarted` INTEGER, `public_key_list` TEXT, `received_at` TEXT, `payloadCanShareForward` INTEGER, `chatNickUserChatId` TEXT, `chatNickData` TEXT, `senderPubKey` TEXT, `recipientPubKeyFingerprint` TEXT, `nextDHKey` TEXT, `messageCounter` INTEGER, `chainIndex` INTEGER, `aVRatchetKeyMaterial` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Payload` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `data` TEXT, `type` TEXT, `messageId` TEXT, `senderId` TEXT, `createdAt` TEXT, `ack_id` TEXT, `conversationId` TEXT, `conversationType` TEXT, `userChatId` TEXT, `filePath` TEXT, `status` TEXT, `isEdited` INTEGER NOT NULL, `isDeleted` INTEGER NOT NULL, `deliveredList` TEXT, `readList` TEXT, `openedList` TEXT, `isExpire` INTEGER NOT NULL, `isForwarded` INTEGER NOT NULL, `isConfidential` INTEGER NOT NULL, `isViewOnce` INTEGER NOT NULL, `isViewed` INTEGER NOT NULL, `isDownloading` INTEGER NOT NULL, `readReceipts` INTEGER NOT NULL, `isOpened` INTEGER NOT NULL, `msgExpiryTime` INTEGER NOT NULL, `expireStarted` INTEGER NOT NULL, `public_key_list` TEXT, `received_at` TEXT, `payloadCanShareForward` INTEGER NOT NULL, `chatNickUserChatId` TEXT, `chatNickData` TEXT, `senderPubKey` TEXT, `recipientPubKeyFingerprint` TEXT, `nextDHKey` TEXT, `messageCounter` INTEGER NOT NULL, `chainIndex` INTEGER NOT NULL, `aVRatchetKeyMaterial` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `OfflineMessage` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ack_id` TEXT, `conversation_Type` TEXT, `isEdited` INTEGER NOT NULL, `isDeleted` INTEGER NOT NULL, `readList` TEXT, `fingerprint` TEXT, `public_key_list` TEXT, `secretModel` TEXT, `received_at` TEXT, `chat_nick_user_chat_id` TEXT, `chat_nick_data` TEXT, `senderPubKey` TEXT, `recipientPubKeyFingerprint` TEXT, `NextDHKey` TEXT, `messageCounter` INTEGER NOT NULL, `chainIndex` INTEGER NOT NULL, `data` TEXT, `type` TEXT, `messageId` TEXT, `createdAt` TEXT, `conversationId` TEXT, `conversationType` TEXT, `userChatId` TEXT, `file_path` TEXT, `status` TEXT, `deliveredList` TEXT, `isExpire` INTEGER NOT NULL, `isForwarded` INTEGER NOT NULL, `senderId` TEXT, `msg_expiry_time` INTEGER NOT NULL, `payload_canShareForward` INTEGER NOT NULL, `fingerprint2` TEXT, `aVRatchetKeyMaterial` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `KeyModel` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fingerprint` TEXT, `publicKeyPath` TEXT, `privateKeyPath` TEXT, `identifer` BLOB)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SecreteKeyModel` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `secreteKey` BLOB, `expiry` INTEGER NOT NULL, `isExpired` INTEGER NOT NULL, `identifier` TEXT, `conversation_id` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `GeneratedPrivateKeyByte` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `privateKeyByte` BLOB, `identifier` BLOB, `pubPrivateKeyByte` BLOB)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `IdentityKeyPair` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `privateKeyByte` BLOB, `identifier` BLOB, `pubPrivateKeyByte` BLOB)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ChatKeyPair` (`identifier` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `conversation_channels` (`channelId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `channelIdentifier` TEXT, `channelWith` TEXT, `SK` TEXT, `RootRatchet` TEXT, `SendRatchet` TEXT, `RecvRatchet` TEXT, `cacheRatchet` TEXT, `RecipientPubKey` TEXT, `FriendDHKey` TEXT, `CacheFriendDHKey` TEXT NOT NULL, `DHRatchet` TEXT NOT NULL, `CacheRachet` TEXT NOT NULL, `EK` TEXT, `SendCounter` INTEGER NOT NULL, `ReceiveCounter` INTEGER NOT NULL, `FlipRatchetDirection` INTEGER NOT NULL, `isDHRacthetEnable` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `secret_e_k` (`secret_key_identifier` TEXT NOT NULL, `channel_identifier` TEXT NOT NULL, `ek` TEXT, `type` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `offlineAck` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `offlineAckId` TEXT, `payload` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8bf7f1bca5149837f3fd115ef425f613')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Contact`");
        _db.execSQL("DROP TABLE IF EXISTS `Conversation`");
        _db.execSQL("DROP TABLE IF EXISTS `Payload`");
        _db.execSQL("DROP TABLE IF EXISTS `OfflineMessage`");
        _db.execSQL("DROP TABLE IF EXISTS `KeyModel`");
        _db.execSQL("DROP TABLE IF EXISTS `SecreteKeyModel`");
        _db.execSQL("DROP TABLE IF EXISTS `GeneratedPrivateKeyByte`");
        _db.execSQL("DROP TABLE IF EXISTS `IdentityKeyPair`");
        _db.execSQL("DROP TABLE IF EXISTS `ChatKeyPair`");
        _db.execSQL("DROP TABLE IF EXISTS `conversation_channels`");
        _db.execSQL("DROP TABLE IF EXISTS `secret_e_k`");
        _db.execSQL("DROP TABLE IF EXISTS `offlineAck`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsContact = new HashMap<String, TableInfo.Column>(10);
        _columnsContact.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("chatUserId", new TableInfo.Column("chatUserId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("color", new TableInfo.Column("color", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("isChecked", new TableInfo.Column("isChecked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("avatarColor", new TableInfo.Column("avatarColor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("alias", new TableInfo.Column("alias", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("isBlocked", new TableInfo.Column("isBlocked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("isQrAdded", new TableInfo.Column("isQrAdded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContact = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContact = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContact = new TableInfo("Contact", _columnsContact, _foreignKeysContact, _indicesContact);
        final TableInfo _existingContact = TableInfo.read(_db, "Contact");
        if (! _infoContact.equals(_existingContact)) {
          return new RoomOpenHelper.ValidationResult(false, "Contact(com.devbeans.io.chat.models.Contact).\n"
                  + " Expected:\n" + _infoContact + "\n"
                  + " Found:\n" + _existingContact);
        }
        final HashMap<String, TableInfo.Column> _columnsConversation = new HashMap<String, TableInfo.Column>(65);
        _columnsConversation.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("_conversation_id", new TableInfo.Column("_conversation_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("_conversation_type", new TableInfo.Column("_conversation_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("_conversationMembers", new TableInfo.Column("_conversationMembers", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("messages", new TableInfo.Column("messages", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("owner", new TableInfo.Column("owner", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("con_createdAt", new TableInfo.Column("con_createdAt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("keepChatDate", new TableInfo.Column("keepChatDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isRemoved", new TableInfo.Column("isRemoved", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isArchived", new TableInfo.Column("isArchived", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isInConversation", new TableInfo.Column("isInConversation", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("_isViewOnce", new TableInfo.Column("_isViewOnce", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("photo", new TableInfo.Column("photo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("conversationPhoto", new TableInfo.Column("conversationPhoto", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("myMoniker", new TableInfo.Column("myMoniker", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("conversationExpiryTime", new TableInfo.Column("conversationExpiryTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isCanShareForward", new TableInfo.Column("isCanShareForward", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isAutoSaveVault", new TableInfo.Column("isAutoSaveVault", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("_isConfidential", new TableInfo.Column("_isConfidential", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("_isMediaShareRestrict", new TableInfo.Column("_isMediaShareRestrict", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("sequenceOfConversation", new TableInfo.Column("sequenceOfConversation", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isPinned", new TableInfo.Column("isPinned", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("hasSentMessage", new TableInfo.Column("hasSentMessage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("conReadReceipts", new TableInfo.Column("conReadReceipts", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("unreadCount", new TableInfo.Column("unreadCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("id", new TableInfo.Column("id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("messageId", new TableInfo.Column("messageId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("senderId", new TableInfo.Column("senderId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("ack_id", new TableInfo.Column("ack_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("conversationId", new TableInfo.Column("conversationId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("conversationType", new TableInfo.Column("conversationType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("userChatId", new TableInfo.Column("userChatId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("filePath", new TableInfo.Column("filePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isEdited", new TableInfo.Column("isEdited", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("deliveredList", new TableInfo.Column("deliveredList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("readList", new TableInfo.Column("readList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("openedList", new TableInfo.Column("openedList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isExpire", new TableInfo.Column("isExpire", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isForwarded", new TableInfo.Column("isForwarded", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isConfidential", new TableInfo.Column("isConfidential", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isViewOnce", new TableInfo.Column("isViewOnce", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isViewed", new TableInfo.Column("isViewed", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isDownloading", new TableInfo.Column("isDownloading", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("readReceipts", new TableInfo.Column("readReceipts", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("isOpened", new TableInfo.Column("isOpened", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("msgExpiryTime", new TableInfo.Column("msgExpiryTime", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("expireStarted", new TableInfo.Column("expireStarted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("public_key_list", new TableInfo.Column("public_key_list", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("received_at", new TableInfo.Column("received_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("payloadCanShareForward", new TableInfo.Column("payloadCanShareForward", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("chatNickUserChatId", new TableInfo.Column("chatNickUserChatId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("chatNickData", new TableInfo.Column("chatNickData", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("senderPubKey", new TableInfo.Column("senderPubKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("recipientPubKeyFingerprint", new TableInfo.Column("recipientPubKeyFingerprint", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("nextDHKey", new TableInfo.Column("nextDHKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("messageCounter", new TableInfo.Column("messageCounter", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("chainIndex", new TableInfo.Column("chainIndex", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversation.put("aVRatchetKeyMaterial", new TableInfo.Column("aVRatchetKeyMaterial", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConversation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConversation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConversation = new TableInfo("Conversation", _columnsConversation, _foreignKeysConversation, _indicesConversation);
        final TableInfo _existingConversation = TableInfo.read(_db, "Conversation");
        if (! _infoConversation.equals(_existingConversation)) {
          return new RoomOpenHelper.ValidationResult(false, "Conversation(com.devbeans.io.chat.models.Conversation).\n"
                  + " Expected:\n" + _infoConversation + "\n"
                  + " Found:\n" + _existingConversation);
        }
        final HashMap<String, TableInfo.Column> _columnsPayload = new HashMap<String, TableInfo.Column>(38);
        _columnsPayload.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("messageId", new TableInfo.Column("messageId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("senderId", new TableInfo.Column("senderId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("ack_id", new TableInfo.Column("ack_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("conversationId", new TableInfo.Column("conversationId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("conversationType", new TableInfo.Column("conversationType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("userChatId", new TableInfo.Column("userChatId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("filePath", new TableInfo.Column("filePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isEdited", new TableInfo.Column("isEdited", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("deliveredList", new TableInfo.Column("deliveredList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("readList", new TableInfo.Column("readList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("openedList", new TableInfo.Column("openedList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isExpire", new TableInfo.Column("isExpire", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isForwarded", new TableInfo.Column("isForwarded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isConfidential", new TableInfo.Column("isConfidential", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isViewOnce", new TableInfo.Column("isViewOnce", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isViewed", new TableInfo.Column("isViewed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isDownloading", new TableInfo.Column("isDownloading", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("readReceipts", new TableInfo.Column("readReceipts", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("isOpened", new TableInfo.Column("isOpened", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("msgExpiryTime", new TableInfo.Column("msgExpiryTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("expireStarted", new TableInfo.Column("expireStarted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("public_key_list", new TableInfo.Column("public_key_list", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("received_at", new TableInfo.Column("received_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("payloadCanShareForward", new TableInfo.Column("payloadCanShareForward", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("chatNickUserChatId", new TableInfo.Column("chatNickUserChatId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("chatNickData", new TableInfo.Column("chatNickData", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("senderPubKey", new TableInfo.Column("senderPubKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("recipientPubKeyFingerprint", new TableInfo.Column("recipientPubKeyFingerprint", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("nextDHKey", new TableInfo.Column("nextDHKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("messageCounter", new TableInfo.Column("messageCounter", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("chainIndex", new TableInfo.Column("chainIndex", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayload.put("aVRatchetKeyMaterial", new TableInfo.Column("aVRatchetKeyMaterial", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPayload = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPayload = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPayload = new TableInfo("Payload", _columnsPayload, _foreignKeysPayload, _indicesPayload);
        final TableInfo _existingPayload = TableInfo.read(_db, "Payload");
        if (! _infoPayload.equals(_existingPayload)) {
          return new RoomOpenHelper.ValidationResult(false, "Payload(com.devbeans.io.chat.models.Payload).\n"
                  + " Expected:\n" + _infoPayload + "\n"
                  + " Found:\n" + _existingPayload);
        }
        final HashMap<String, TableInfo.Column> _columnsOfflineMessage = new HashMap<String, TableInfo.Column>(34);
        _columnsOfflineMessage.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("ack_id", new TableInfo.Column("ack_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("conversation_Type", new TableInfo.Column("conversation_Type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("isEdited", new TableInfo.Column("isEdited", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("readList", new TableInfo.Column("readList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("fingerprint", new TableInfo.Column("fingerprint", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("public_key_list", new TableInfo.Column("public_key_list", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("secretModel", new TableInfo.Column("secretModel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("received_at", new TableInfo.Column("received_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("chat_nick_user_chat_id", new TableInfo.Column("chat_nick_user_chat_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("chat_nick_data", new TableInfo.Column("chat_nick_data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("senderPubKey", new TableInfo.Column("senderPubKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("recipientPubKeyFingerprint", new TableInfo.Column("recipientPubKeyFingerprint", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("NextDHKey", new TableInfo.Column("NextDHKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("messageCounter", new TableInfo.Column("messageCounter", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("chainIndex", new TableInfo.Column("chainIndex", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("messageId", new TableInfo.Column("messageId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("conversationId", new TableInfo.Column("conversationId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("conversationType", new TableInfo.Column("conversationType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("userChatId", new TableInfo.Column("userChatId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("file_path", new TableInfo.Column("file_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("deliveredList", new TableInfo.Column("deliveredList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("isExpire", new TableInfo.Column("isExpire", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("isForwarded", new TableInfo.Column("isForwarded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("senderId", new TableInfo.Column("senderId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("msg_expiry_time", new TableInfo.Column("msg_expiry_time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("payload_canShareForward", new TableInfo.Column("payload_canShareForward", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("fingerprint2", new TableInfo.Column("fingerprint2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineMessage.put("aVRatchetKeyMaterial", new TableInfo.Column("aVRatchetKeyMaterial", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOfflineMessage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOfflineMessage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOfflineMessage = new TableInfo("OfflineMessage", _columnsOfflineMessage, _foreignKeysOfflineMessage, _indicesOfflineMessage);
        final TableInfo _existingOfflineMessage = TableInfo.read(_db, "OfflineMessage");
        if (! _infoOfflineMessage.equals(_existingOfflineMessage)) {
          return new RoomOpenHelper.ValidationResult(false, "OfflineMessage(com.devbeans.io.chat.models.OfflineMessage).\n"
                  + " Expected:\n" + _infoOfflineMessage + "\n"
                  + " Found:\n" + _existingOfflineMessage);
        }
        final HashMap<String, TableInfo.Column> _columnsKeyModel = new HashMap<String, TableInfo.Column>(5);
        _columnsKeyModel.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKeyModel.put("fingerprint", new TableInfo.Column("fingerprint", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKeyModel.put("publicKeyPath", new TableInfo.Column("publicKeyPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKeyModel.put("privateKeyPath", new TableInfo.Column("privateKeyPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKeyModel.put("identifer", new TableInfo.Column("identifer", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKeyModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKeyModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKeyModel = new TableInfo("KeyModel", _columnsKeyModel, _foreignKeysKeyModel, _indicesKeyModel);
        final TableInfo _existingKeyModel = TableInfo.read(_db, "KeyModel");
        if (! _infoKeyModel.equals(_existingKeyModel)) {
          return new RoomOpenHelper.ValidationResult(false, "KeyModel(com.devbeans.io.chat.models.KeyModel).\n"
                  + " Expected:\n" + _infoKeyModel + "\n"
                  + " Found:\n" + _existingKeyModel);
        }
        final HashMap<String, TableInfo.Column> _columnsSecreteKeyModel = new HashMap<String, TableInfo.Column>(6);
        _columnsSecreteKeyModel.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecreteKeyModel.put("secreteKey", new TableInfo.Column("secreteKey", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecreteKeyModel.put("expiry", new TableInfo.Column("expiry", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecreteKeyModel.put("isExpired", new TableInfo.Column("isExpired", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecreteKeyModel.put("identifier", new TableInfo.Column("identifier", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecreteKeyModel.put("conversation_id", new TableInfo.Column("conversation_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSecreteKeyModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSecreteKeyModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSecreteKeyModel = new TableInfo("SecreteKeyModel", _columnsSecreteKeyModel, _foreignKeysSecreteKeyModel, _indicesSecreteKeyModel);
        final TableInfo _existingSecreteKeyModel = TableInfo.read(_db, "SecreteKeyModel");
        if (! _infoSecreteKeyModel.equals(_existingSecreteKeyModel)) {
          return new RoomOpenHelper.ValidationResult(false, "SecreteKeyModel(com.devbeans.io.chat.models.SecreteKeyModel).\n"
                  + " Expected:\n" + _infoSecreteKeyModel + "\n"
                  + " Found:\n" + _existingSecreteKeyModel);
        }
        final HashMap<String, TableInfo.Column> _columnsGeneratedPrivateKeyByte = new HashMap<String, TableInfo.Column>(4);
        _columnsGeneratedPrivateKeyByte.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeneratedPrivateKeyByte.put("privateKeyByte", new TableInfo.Column("privateKeyByte", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeneratedPrivateKeyByte.put("identifier", new TableInfo.Column("identifier", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeneratedPrivateKeyByte.put("pubPrivateKeyByte", new TableInfo.Column("pubPrivateKeyByte", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGeneratedPrivateKeyByte = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGeneratedPrivateKeyByte = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGeneratedPrivateKeyByte = new TableInfo("GeneratedPrivateKeyByte", _columnsGeneratedPrivateKeyByte, _foreignKeysGeneratedPrivateKeyByte, _indicesGeneratedPrivateKeyByte);
        final TableInfo _existingGeneratedPrivateKeyByte = TableInfo.read(_db, "GeneratedPrivateKeyByte");
        if (! _infoGeneratedPrivateKeyByte.equals(_existingGeneratedPrivateKeyByte)) {
          return new RoomOpenHelper.ValidationResult(false, "GeneratedPrivateKeyByte(com.devbeans.io.chat.models.GeneratedPrivateKeyByte).\n"
                  + " Expected:\n" + _infoGeneratedPrivateKeyByte + "\n"
                  + " Found:\n" + _existingGeneratedPrivateKeyByte);
        }
        final HashMap<String, TableInfo.Column> _columnsIdentityKeyPair = new HashMap<String, TableInfo.Column>(4);
        _columnsIdentityKeyPair.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIdentityKeyPair.put("privateKeyByte", new TableInfo.Column("privateKeyByte", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIdentityKeyPair.put("identifier", new TableInfo.Column("identifier", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIdentityKeyPair.put("pubPrivateKeyByte", new TableInfo.Column("pubPrivateKeyByte", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIdentityKeyPair = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIdentityKeyPair = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIdentityKeyPair = new TableInfo("IdentityKeyPair", _columnsIdentityKeyPair, _foreignKeysIdentityKeyPair, _indicesIdentityKeyPair);
        final TableInfo _existingIdentityKeyPair = TableInfo.read(_db, "IdentityKeyPair");
        if (! _infoIdentityKeyPair.equals(_existingIdentityKeyPair)) {
          return new RoomOpenHelper.ValidationResult(false, "IdentityKeyPair(com.devbeans.io.chat.models.IdentityKeyPair).\n"
                  + " Expected:\n" + _infoIdentityKeyPair + "\n"
                  + " Found:\n" + _existingIdentityKeyPair);
        }
        final HashMap<String, TableInfo.Column> _columnsChatKeyPair = new HashMap<String, TableInfo.Column>(2);
        _columnsChatKeyPair.put("identifier", new TableInfo.Column("identifier", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatKeyPair.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChatKeyPair = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChatKeyPair = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChatKeyPair = new TableInfo("ChatKeyPair", _columnsChatKeyPair, _foreignKeysChatKeyPair, _indicesChatKeyPair);
        final TableInfo _existingChatKeyPair = TableInfo.read(_db, "ChatKeyPair");
        if (! _infoChatKeyPair.equals(_existingChatKeyPair)) {
          return new RoomOpenHelper.ValidationResult(false, "ChatKeyPair(com.devbeans.io.chat.models.ChatKeyPair).\n"
                  + " Expected:\n" + _infoChatKeyPair + "\n"
                  + " Found:\n" + _existingChatKeyPair);
        }
        final HashMap<String, TableInfo.Column> _columnsConversationChannels = new HashMap<String, TableInfo.Column>(18);
        _columnsConversationChannels.put("channelId", new TableInfo.Column("channelId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("channelIdentifier", new TableInfo.Column("channelIdentifier", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("channelWith", new TableInfo.Column("channelWith", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("SK", new TableInfo.Column("SK", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("RootRatchet", new TableInfo.Column("RootRatchet", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("SendRatchet", new TableInfo.Column("SendRatchet", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("RecvRatchet", new TableInfo.Column("RecvRatchet", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("cacheRatchet", new TableInfo.Column("cacheRatchet", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("RecipientPubKey", new TableInfo.Column("RecipientPubKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("FriendDHKey", new TableInfo.Column("FriendDHKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("CacheFriendDHKey", new TableInfo.Column("CacheFriendDHKey", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("DHRatchet", new TableInfo.Column("DHRatchet", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("CacheRachet", new TableInfo.Column("CacheRachet", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("EK", new TableInfo.Column("EK", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("SendCounter", new TableInfo.Column("SendCounter", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("ReceiveCounter", new TableInfo.Column("ReceiveCounter", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("FlipRatchetDirection", new TableInfo.Column("FlipRatchetDirection", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConversationChannels.put("isDHRacthetEnable", new TableInfo.Column("isDHRacthetEnable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConversationChannels = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConversationChannels = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConversationChannels = new TableInfo("conversation_channels", _columnsConversationChannels, _foreignKeysConversationChannels, _indicesConversationChannels);
        final TableInfo _existingConversationChannels = TableInfo.read(_db, "conversation_channels");
        if (! _infoConversationChannels.equals(_existingConversationChannels)) {
          return new RoomOpenHelper.ValidationResult(false, "conversation_channels(com.devbeans.io.chat.models.ConversationChannels).\n"
                  + " Expected:\n" + _infoConversationChannels + "\n"
                  + " Found:\n" + _existingConversationChannels);
        }
        final HashMap<String, TableInfo.Column> _columnsSecretEK = new HashMap<String, TableInfo.Column>(5);
        _columnsSecretEK.put("secret_key_identifier", new TableInfo.Column("secret_key_identifier", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecretEK.put("channel_identifier", new TableInfo.Column("channel_identifier", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecretEK.put("ek", new TableInfo.Column("ek", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecretEK.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSecretEK.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSecretEK = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSecretEK = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSecretEK = new TableInfo("secret_e_k", _columnsSecretEK, _foreignKeysSecretEK, _indicesSecretEK);
        final TableInfo _existingSecretEK = TableInfo.read(_db, "secret_e_k");
        if (! _infoSecretEK.equals(_existingSecretEK)) {
          return new RoomOpenHelper.ValidationResult(false, "secret_e_k(com.devbeans.io.chat.encryption.SecretEk).\n"
                  + " Expected:\n" + _infoSecretEK + "\n"
                  + " Found:\n" + _existingSecretEK);
        }
        final HashMap<String, TableInfo.Column> _columnsOfflineAck = new HashMap<String, TableInfo.Column>(3);
        _columnsOfflineAck.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineAck.put("offlineAckId", new TableInfo.Column("offlineAckId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOfflineAck.put("payload", new TableInfo.Column("payload", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOfflineAck = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOfflineAck = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOfflineAck = new TableInfo("offlineAck", _columnsOfflineAck, _foreignKeysOfflineAck, _indicesOfflineAck);
        final TableInfo _existingOfflineAck = TableInfo.read(_db, "offlineAck");
        if (! _infoOfflineAck.equals(_existingOfflineAck)) {
          return new RoomOpenHelper.ValidationResult(false, "offlineAck(com.devbeans.io.chat.models.OfflineAck).\n"
                  + " Expected:\n" + _infoOfflineAck + "\n"
                  + " Found:\n" + _existingOfflineAck);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8bf7f1bca5149837f3fd115ef425f613", "f37bc5bd47fb31b3b12277db910c2c8d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Contact","Conversation","Payload","OfflineMessage","KeyModel","SecreteKeyModel","GeneratedPrivateKeyByte","IdentityKeyPair","ChatKeyPair","conversation_channels","secret_e_k","offlineAck");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Contact`");
      _db.execSQL("DELETE FROM `Conversation`");
      _db.execSQL("DELETE FROM `Payload`");
      _db.execSQL("DELETE FROM `OfflineMessage`");
      _db.execSQL("DELETE FROM `KeyModel`");
      _db.execSQL("DELETE FROM `SecreteKeyModel`");
      _db.execSQL("DELETE FROM `GeneratedPrivateKeyByte`");
      _db.execSQL("DELETE FROM `IdentityKeyPair`");
      _db.execSQL("DELETE FROM `ChatKeyPair`");
      _db.execSQL("DELETE FROM `conversation_channels`");
      _db.execSQL("DELETE FROM `secret_e_k`");
      _db.execSQL("DELETE FROM `offlineAck`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ContactsDao.class, ContactsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ConversationsDao.class, ConversationsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MessagesDao.class, MessagesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OfflineMessagesDao.class, OfflineMessagesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(KeyPairDao.class, KeyPairDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SecreteKeyDao.class, SecreteKeyDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GeneratedDao.class, GeneratedDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IdentityKeyPairDao.class, IdentityKeyPairDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChatKeyPairDao.class, ChatKeyPairDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ConversationChannelsDao.class, ConversationChannelsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SecretEKDao.class, SecretEKDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OfflineAckDao.class, OfflineAckDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public ContactsDao contactsDao() {
    if (_contactsDao != null) {
      return _contactsDao;
    } else {
      synchronized(this) {
        if(_contactsDao == null) {
          _contactsDao = new ContactsDao_Impl(this);
        }
        return _contactsDao;
      }
    }
  }

  @Override
  public ConversationsDao conversationsDao() {
    if (_conversationsDao != null) {
      return _conversationsDao;
    } else {
      synchronized(this) {
        if(_conversationsDao == null) {
          _conversationsDao = new ConversationsDao_Impl(this);
        }
        return _conversationsDao;
      }
    }
  }

  @Override
  public MessagesDao messagesDao() {
    if (_messagesDao != null) {
      return _messagesDao;
    } else {
      synchronized(this) {
        if(_messagesDao == null) {
          _messagesDao = new MessagesDao_Impl(this);
        }
        return _messagesDao;
      }
    }
  }

  @Override
  public OfflineMessagesDao offlineMessagesDao() {
    if (_offlineMessagesDao != null) {
      return _offlineMessagesDao;
    } else {
      synchronized(this) {
        if(_offlineMessagesDao == null) {
          _offlineMessagesDao = new OfflineMessagesDao_Impl(this);
        }
        return _offlineMessagesDao;
      }
    }
  }

  @Override
  public KeyPairDao keyPairDao() {
    if (_keyPairDao != null) {
      return _keyPairDao;
    } else {
      synchronized(this) {
        if(_keyPairDao == null) {
          _keyPairDao = new KeyPairDao_Impl(this);
        }
        return _keyPairDao;
      }
    }
  }

  @Override
  public SecreteKeyDao SecreteKeyDao() {
    if (_secreteKeyDao != null) {
      return _secreteKeyDao;
    } else {
      synchronized(this) {
        if(_secreteKeyDao == null) {
          _secreteKeyDao = new SecreteKeyDao_Impl(this);
        }
        return _secreteKeyDao;
      }
    }
  }

  @Override
  public GeneratedDao GeneratedDao() {
    if (_generatedDao != null) {
      return _generatedDao;
    } else {
      synchronized(this) {
        if(_generatedDao == null) {
          _generatedDao = new GeneratedDao_Impl(this);
        }
        return _generatedDao;
      }
    }
  }

  @Override
  public IdentityKeyPairDao IdentityKeyPairDao() {
    if (_identityKeyPairDao != null) {
      return _identityKeyPairDao;
    } else {
      synchronized(this) {
        if(_identityKeyPairDao == null) {
          _identityKeyPairDao = new IdentityKeyPairDao_Impl(this);
        }
        return _identityKeyPairDao;
      }
    }
  }

  @Override
  public ChatKeyPairDao ChatKeyPairDao() {
    if (_chatKeyPairDao != null) {
      return _chatKeyPairDao;
    } else {
      synchronized(this) {
        if(_chatKeyPairDao == null) {
          _chatKeyPairDao = new ChatKeyPairDao_Impl(this);
        }
        return _chatKeyPairDao;
      }
    }
  }

  @Override
  public ConversationChannelsDao ConversationChannelsDao() {
    if (_conversationChannelsDao != null) {
      return _conversationChannelsDao;
    } else {
      synchronized(this) {
        if(_conversationChannelsDao == null) {
          _conversationChannelsDao = new ConversationChannelsDao_Impl(this);
        }
        return _conversationChannelsDao;
      }
    }
  }

  @Override
  public SecretEKDao EKDao() {
    if (_secretEKDao != null) {
      return _secretEKDao;
    } else {
      synchronized(this) {
        if(_secretEKDao == null) {
          _secretEKDao = new SecretEKDao_Impl(this);
        }
        return _secretEKDao;
      }
    }
  }

  @Override
  public OfflineAckDao offlineAckDao() {
    if (_offlineAckDao != null) {
      return _offlineAckDao;
    } else {
      synchronized(this) {
        if(_offlineAckDao == null) {
          _offlineAckDao = new OfflineAckDao_Impl(this);
        }
        return _offlineAckDao;
      }
    }
  }
}
