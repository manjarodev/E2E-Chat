package com.devbeans.io.chat.roomDB.Dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.devbeans.io.chat.models.OfflineMessage;
import com.devbeans.io.chat.roomDB.TypeConverters.DeliverListConverter;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OfflineMessagesDao_Impl implements OfflineMessagesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OfflineMessage> __insertionAdapterOfOfflineMessage;

  private final EntityDeletionOrUpdateAdapter<OfflineMessage> __deletionAdapterOfOfflineMessage;

  private final EntityDeletionOrUpdateAdapter<OfflineMessage> __updateAdapterOfOfflineMessage;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessage;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByMessageId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public OfflineMessagesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOfflineMessage = new EntityInsertionAdapter<OfflineMessage>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `OfflineMessage` (`id`,`ack_id`,`conversation_Type`,`isEdited`,`isDeleted`,`readList`,`fingerprint`,`public_key_list`,`secretModel`,`received_at`,`chat_nick_user_chat_id`,`chat_nick_data`,`senderPubKey`,`recipientPubKeyFingerprint`,`NextDHKey`,`messageCounter`,`chainIndex`,`data`,`type`,`messageId`,`createdAt`,`conversationId`,`conversationType`,`userChatId`,`file_path`,`status`,`deliveredList`,`isExpire`,`isForwarded`,`senderId`,`msg_expiry_time`,`payload_canShareForward`,`fingerprint2`,`aVRatchetKeyMaterial`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OfflineMessage value) {
        stmt.bindLong(1, value.getId());
        if (value.getAck_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAck_id());
        }
        if (value.getConversation_Type() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getConversation_Type());
        }
        final int _tmp = value.isEdited() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final int _tmp_1 = value.isDeleted() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        final String _tmp_2 = DeliverListConverter.ListToJson(value.getReadList());
        if (_tmp_2 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_2);
        }
        if (value.getFingerprint() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFingerprint());
        }
        final String _tmp_3 = DeliverListConverter.ListToJson(value.getPublic_key_list());
        if (_tmp_3 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_3);
        }
        if (value.getSecretModel() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSecretModel());
        }
        if (value.getReceived_at() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getReceived_at());
        }
        if (value.getChat_nick_user_chat_id() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getChat_nick_user_chat_id());
        }
        if (value.getChat_nick_data() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getChat_nick_data());
        }
        if (value.getSenderPubKey() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSenderPubKey());
        }
        if (value.getRecipientPubKeyFingerprint() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRecipientPubKeyFingerprint());
        }
        if (value.getNextDHKey() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getNextDHKey());
        }
        stmt.bindLong(16, value.getMessageCounter());
        stmt.bindLong(17, value.getChainIndex());
        if (value.getData() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getData());
        }
        if (value.getType() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getType());
        }
        if (value.getMessageId() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMessageId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getCreatedAt());
        }
        if (value.getConversationId() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getConversationId());
        }
        if (value.getConversationType() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getConversationType());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getUserChatId());
        }
        if (value.getFile_path() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getFile_path());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getStatus());
        }
        final String _tmp_4 = DeliverListConverter.ListToJson(value.getDeliveredList());
        if (_tmp_4 == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, _tmp_4);
        }
        final int _tmp_5 = value.isExpire() ? 1 : 0;
        stmt.bindLong(28, _tmp_5);
        final int _tmp_6 = value.isForwarded() ? 1 : 0;
        stmt.bindLong(29, _tmp_6);
        if (value.getSenderId() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getSenderId());
        }
        stmt.bindLong(31, value.getMsg_expiry_time());
        final int _tmp_7 = value.isCanShareForward() ? 1 : 0;
        stmt.bindLong(32, _tmp_7);
        if (value.getFingerprint2() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getFingerprint2());
        }
        if (value.getAVRatchetKeyMaterial() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getAVRatchetKeyMaterial());
        }
      }
    };
    this.__deletionAdapterOfOfflineMessage = new EntityDeletionOrUpdateAdapter<OfflineMessage>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `OfflineMessage` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OfflineMessage value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfOfflineMessage = new EntityDeletionOrUpdateAdapter<OfflineMessage>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `OfflineMessage` SET `id` = ?,`ack_id` = ?,`conversation_Type` = ?,`isEdited` = ?,`isDeleted` = ?,`readList` = ?,`fingerprint` = ?,`public_key_list` = ?,`secretModel` = ?,`received_at` = ?,`chat_nick_user_chat_id` = ?,`chat_nick_data` = ?,`senderPubKey` = ?,`recipientPubKeyFingerprint` = ?,`NextDHKey` = ?,`messageCounter` = ?,`chainIndex` = ?,`data` = ?,`type` = ?,`messageId` = ?,`createdAt` = ?,`conversationId` = ?,`conversationType` = ?,`userChatId` = ?,`file_path` = ?,`status` = ?,`deliveredList` = ?,`isExpire` = ?,`isForwarded` = ?,`senderId` = ?,`msg_expiry_time` = ?,`payload_canShareForward` = ?,`fingerprint2` = ?,`aVRatchetKeyMaterial` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OfflineMessage value) {
        stmt.bindLong(1, value.getId());
        if (value.getAck_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAck_id());
        }
        if (value.getConversation_Type() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getConversation_Type());
        }
        final int _tmp = value.isEdited() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final int _tmp_1 = value.isDeleted() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        final String _tmp_2 = DeliverListConverter.ListToJson(value.getReadList());
        if (_tmp_2 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_2);
        }
        if (value.getFingerprint() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFingerprint());
        }
        final String _tmp_3 = DeliverListConverter.ListToJson(value.getPublic_key_list());
        if (_tmp_3 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_3);
        }
        if (value.getSecretModel() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSecretModel());
        }
        if (value.getReceived_at() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getReceived_at());
        }
        if (value.getChat_nick_user_chat_id() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getChat_nick_user_chat_id());
        }
        if (value.getChat_nick_data() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getChat_nick_data());
        }
        if (value.getSenderPubKey() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSenderPubKey());
        }
        if (value.getRecipientPubKeyFingerprint() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRecipientPubKeyFingerprint());
        }
        if (value.getNextDHKey() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getNextDHKey());
        }
        stmt.bindLong(16, value.getMessageCounter());
        stmt.bindLong(17, value.getChainIndex());
        if (value.getData() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getData());
        }
        if (value.getType() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getType());
        }
        if (value.getMessageId() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMessageId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getCreatedAt());
        }
        if (value.getConversationId() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getConversationId());
        }
        if (value.getConversationType() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getConversationType());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getUserChatId());
        }
        if (value.getFile_path() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getFile_path());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getStatus());
        }
        final String _tmp_4 = DeliverListConverter.ListToJson(value.getDeliveredList());
        if (_tmp_4 == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, _tmp_4);
        }
        final int _tmp_5 = value.isExpire() ? 1 : 0;
        stmt.bindLong(28, _tmp_5);
        final int _tmp_6 = value.isForwarded() ? 1 : 0;
        stmt.bindLong(29, _tmp_6);
        if (value.getSenderId() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getSenderId());
        }
        stmt.bindLong(31, value.getMsg_expiry_time());
        final int _tmp_7 = value.isCanShareForward() ? 1 : 0;
        stmt.bindLong(32, _tmp_7);
        if (value.getFingerprint2() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getFingerprint2());
        }
        if (value.getAVRatchetKeyMaterial() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getAVRatchetKeyMaterial());
        }
        stmt.bindLong(35, value.getId());
      }
    };
    this.__preparedStmtOfUpdateMessage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE OfflineMessage SET deliveredList = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM OfflineMessage WHERE messageId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByMessageId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM OfflineMessage WHERE messageId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM OfflineMessage";
        return _query;
      }
    };
  }

  @Override
  public void insert(final OfflineMessage offlineMessage) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOfflineMessage.insert(offlineMessage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final OfflineMessage offlineMessgae) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfOfflineMessage.handle(offlineMessgae);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<OfflineMessage> offlineMessages) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfOfflineMessage.handleMultiple(offlineMessages);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final OfflineMessage offlineMessage) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfOfflineMessage.handle(offlineMessage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateMessage(final long conId, final String messages) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMessage.acquire();
    int _argIndex = 1;
    if (messages == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, messages);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, conId);
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateMessage.release(_stmt);
    }
  }

  @Override
  public void deleteById(final String id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
    if (id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, id);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  public void deleteByMessageId(final String messageId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByMessageId.acquire();
    int _argIndex = 1;
    if (messageId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, messageId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByMessageId.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<OfflineMessage>> getLiveMessages() {
    final String _sql = "SELECT * FROM offlinemessage";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"offlinemessage"}, false, new Callable<List<OfflineMessage>>() {
      @Override
      public List<OfflineMessage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversation_Type");
          final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
          final int _cursorIndexOfFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfSecretModel = CursorUtil.getColumnIndexOrThrow(_cursor, "secretModel");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_nick_user_chat_id");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_nick_data");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "NextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
          final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "file_path");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
          final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
          final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_expiry_time");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payload_canShareForward");
          final int _cursorIndexOfFingerprint2 = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint2");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<OfflineMessage> _result = new ArrayList<OfflineMessage>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final OfflineMessage _item;
            _item = new OfflineMessage();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpAck_id;
            if (_cursor.isNull(_cursorIndexOfAckId)) {
              _tmpAck_id = null;
            } else {
              _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
            }
            _item.setAck_id(_tmpAck_id);
            final String _tmpConversation_Type;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversation_Type = null;
            } else {
              _tmpConversation_Type = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversation_Type(_tmpConversation_Type);
            final boolean _tmpIsEdited;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
            _tmpIsEdited = _tmp != 0;
            _item.setEdited(_tmpIsEdited);
            final boolean _tmpIsDeleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_1 != 0;
            _item.setDeleted(_tmpIsDeleted);
            final List<String> _tmpReadList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfReadList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfReadList);
            }
            _tmpReadList = DeliverListConverter.JsonToList(_tmp_2);
            _item.setReadList(_tmpReadList);
            final String _tmpFingerprint;
            if (_cursor.isNull(_cursorIndexOfFingerprint)) {
              _tmpFingerprint = null;
            } else {
              _tmpFingerprint = _cursor.getString(_cursorIndexOfFingerprint);
            }
            _item.setFingerprint(_tmpFingerprint);
            final List<String> _tmpPublic_key_list;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfPublicKeyList);
            }
            _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_3);
            _item.setPublic_key_list(_tmpPublic_key_list);
            final String _tmpSecretModel;
            if (_cursor.isNull(_cursorIndexOfSecretModel)) {
              _tmpSecretModel = null;
            } else {
              _tmpSecretModel = _cursor.getString(_cursorIndexOfSecretModel);
            }
            _item.setSecretModel(_tmpSecretModel);
            final String _tmpReceived_at;
            if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
              _tmpReceived_at = null;
            } else {
              _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
            }
            _item.setReceived_at(_tmpReceived_at);
            final String _tmpChat_nick_user_chat_id;
            if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
              _tmpChat_nick_user_chat_id = null;
            } else {
              _tmpChat_nick_user_chat_id = _cursor.getString(_cursorIndexOfChatNickUserChatId);
            }
            _item.setChat_nick_user_chat_id(_tmpChat_nick_user_chat_id);
            final String _tmpChat_nick_data;
            if (_cursor.isNull(_cursorIndexOfChatNickData)) {
              _tmpChat_nick_data = null;
            } else {
              _tmpChat_nick_data = _cursor.getString(_cursorIndexOfChatNickData);
            }
            _item.setChat_nick_data(_tmpChat_nick_data);
            final String _tmpSenderPubKey;
            if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
              _tmpSenderPubKey = null;
            } else {
              _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
            }
            _item.setSenderPubKey(_tmpSenderPubKey);
            final String _tmpRecipientPubKeyFingerprint;
            if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
              _tmpRecipientPubKeyFingerprint = null;
            } else {
              _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
            }
            _item.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
            final String _tmpNextDHKey;
            if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
              _tmpNextDHKey = null;
            } else {
              _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
            }
            _item.setNextDHKey(_tmpNextDHKey);
            final int _tmpMessageCounter;
            _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
            _item.setMessageCounter(_tmpMessageCounter);
            final int _tmpChainIndex;
            _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
            _item.setChainIndex(_tmpChainIndex);
            final String _tmpData;
            if (_cursor.isNull(_cursorIndexOfData)) {
              _tmpData = null;
            } else {
              _tmpData = _cursor.getString(_cursorIndexOfData);
            }
            _item.setData(_tmpData);
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            _item.setType(_tmpType);
            final String _tmpMessageId;
            if (_cursor.isNull(_cursorIndexOfMessageId)) {
              _tmpMessageId = null;
            } else {
              _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
            }
            _item.setMessageId(_tmpMessageId);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item.setCreatedAt(_tmpCreatedAt);
            final String _tmpConversationId;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId = null;
            } else {
              _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId);
            final String _tmpConversationType;
            if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
              _tmpConversationType = null;
            } else {
              _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
            }
            _item.setConversationType(_tmpConversationType);
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            _item.setUserChatId(_tmpUserChatId);
            final String _tmpFile_path;
            if (_cursor.isNull(_cursorIndexOfFilePath)) {
              _tmpFile_path = null;
            } else {
              _tmpFile_path = _cursor.getString(_cursorIndexOfFilePath);
            }
            _item.setFile_path(_tmpFile_path);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
            final List<String> _tmpDeliveredList;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfDeliveredList);
            }
            _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_4);
            _item.setDeliveredList(_tmpDeliveredList);
            final boolean _tmpIsExpire;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
            _tmpIsExpire = _tmp_5 != 0;
            _item.setExpire(_tmpIsExpire);
            final boolean _tmpIsForwarded;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
            _tmpIsForwarded = _tmp_6 != 0;
            _item.setForwarded(_tmpIsForwarded);
            final String _tmpSenderId;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmpSenderId = null;
            } else {
              _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
            }
            _item.setSenderId(_tmpSenderId);
            final long _tmpMsg_expiry_time;
            _tmpMsg_expiry_time = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
            _item.setMsg_expiry_time(_tmpMsg_expiry_time);
            final boolean _tmpIsCanShareForward;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward = _tmp_7 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward);
            final String _tmpFingerprint2;
            if (_cursor.isNull(_cursorIndexOfFingerprint2)) {
              _tmpFingerprint2 = null;
            } else {
              _tmpFingerprint2 = _cursor.getString(_cursorIndexOfFingerprint2);
            }
            _item.setFingerprint2(_tmpFingerprint2);
            final String _tmpAVRatchetKeyMaterial;
            if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
              _tmpAVRatchetKeyMaterial = null;
            } else {
              _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
            }
            _item.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<OfflineMessage> getAllMessages() {
    final String _sql = "SELECT * FROM OfflineMessage";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversation_Type");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfSecretModel = CursorUtil.getColumnIndexOrThrow(_cursor, "secretModel");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_nick_user_chat_id");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_nick_data");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "NextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "file_path");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_expiry_time");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payload_canShareForward");
      final int _cursorIndexOfFingerprint2 = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint2");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<OfflineMessage> _result = new ArrayList<OfflineMessage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OfflineMessage _item;
        _item = new OfflineMessage();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversation_Type;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversation_Type = null;
        } else {
          _tmpConversation_Type = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversation_Type(_tmpConversation_Type);
        final boolean _tmpIsEdited;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
        _tmpIsEdited = _tmp != 0;
        _item.setEdited(_tmpIsEdited);
        final boolean _tmpIsDeleted;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
        _tmpIsDeleted = _tmp_1 != 0;
        _item.setDeleted(_tmpIsDeleted);
        final List<String> _tmpReadList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setReadList(_tmpReadList);
        final String _tmpFingerprint;
        if (_cursor.isNull(_cursorIndexOfFingerprint)) {
          _tmpFingerprint = null;
        } else {
          _tmpFingerprint = _cursor.getString(_cursorIndexOfFingerprint);
        }
        _item.setFingerprint(_tmpFingerprint);
        final List<String> _tmpPublic_key_list;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_3);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpSecretModel;
        if (_cursor.isNull(_cursorIndexOfSecretModel)) {
          _tmpSecretModel = null;
        } else {
          _tmpSecretModel = _cursor.getString(_cursorIndexOfSecretModel);
        }
        _item.setSecretModel(_tmpSecretModel);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final String _tmpChat_nick_user_chat_id;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChat_nick_user_chat_id = null;
        } else {
          _tmpChat_nick_user_chat_id = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChat_nick_user_chat_id(_tmpChat_nick_user_chat_id);
        final String _tmpChat_nick_data;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChat_nick_data = null;
        } else {
          _tmpChat_nick_data = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChat_nick_data(_tmpChat_nick_data);
        final String _tmpSenderPubKey;
        if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
          _tmpSenderPubKey = null;
        } else {
          _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
        }
        _item.setSenderPubKey(_tmpSenderPubKey);
        final String _tmpRecipientPubKeyFingerprint;
        if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
          _tmpRecipientPubKeyFingerprint = null;
        } else {
          _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
        }
        _item.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
        final String _tmpNextDHKey;
        if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
          _tmpNextDHKey = null;
        } else {
          _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
        }
        _item.setNextDHKey(_tmpNextDHKey);
        final int _tmpMessageCounter;
        _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
        _item.setMessageCounter(_tmpMessageCounter);
        final int _tmpChainIndex;
        _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
        _item.setChainIndex(_tmpChainIndex);
        final String _tmpData;
        if (_cursor.isNull(_cursorIndexOfData)) {
          _tmpData = null;
        } else {
          _tmpData = _cursor.getString(_cursorIndexOfData);
        }
        _item.setData(_tmpData);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _item.setType(_tmpType);
        final String _tmpMessageId;
        if (_cursor.isNull(_cursorIndexOfMessageId)) {
          _tmpMessageId = null;
        } else {
          _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
        }
        _item.setMessageId(_tmpMessageId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFile_path;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFile_path = null;
        } else {
          _tmpFile_path = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFile_path(_tmpFile_path);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final List<String> _tmpDeliveredList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setDeliveredList(_tmpDeliveredList);
        final boolean _tmpIsExpire;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
        _tmpIsExpire = _tmp_5 != 0;
        _item.setExpire(_tmpIsExpire);
        final boolean _tmpIsForwarded;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
        _tmpIsForwarded = _tmp_6 != 0;
        _item.setForwarded(_tmpIsForwarded);
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final long _tmpMsg_expiry_time;
        _tmpMsg_expiry_time = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsg_expiry_time(_tmpMsg_expiry_time);
        final boolean _tmpIsCanShareForward;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_7 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpFingerprint2;
        if (_cursor.isNull(_cursorIndexOfFingerprint2)) {
          _tmpFingerprint2 = null;
        } else {
          _tmpFingerprint2 = _cursor.getString(_cursorIndexOfFingerprint2);
        }
        _item.setFingerprint2(_tmpFingerprint2);
        final String _tmpAVRatchetKeyMaterial;
        if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
          _tmpAVRatchetKeyMaterial = null;
        } else {
          _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
        }
        _item.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<OfflineMessage> getMessages(final String conversationId) {
    final String _sql = "SELECT * FROM OfflineMessage WHERE conversationId LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversation_Type");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfSecretModel = CursorUtil.getColumnIndexOrThrow(_cursor, "secretModel");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_nick_user_chat_id");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_nick_data");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "NextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "file_path");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_expiry_time");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payload_canShareForward");
      final int _cursorIndexOfFingerprint2 = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint2");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<OfflineMessage> _result = new ArrayList<OfflineMessage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OfflineMessage _item;
        _item = new OfflineMessage();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversation_Type;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversation_Type = null;
        } else {
          _tmpConversation_Type = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversation_Type(_tmpConversation_Type);
        final boolean _tmpIsEdited;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
        _tmpIsEdited = _tmp != 0;
        _item.setEdited(_tmpIsEdited);
        final boolean _tmpIsDeleted;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
        _tmpIsDeleted = _tmp_1 != 0;
        _item.setDeleted(_tmpIsDeleted);
        final List<String> _tmpReadList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setReadList(_tmpReadList);
        final String _tmpFingerprint;
        if (_cursor.isNull(_cursorIndexOfFingerprint)) {
          _tmpFingerprint = null;
        } else {
          _tmpFingerprint = _cursor.getString(_cursorIndexOfFingerprint);
        }
        _item.setFingerprint(_tmpFingerprint);
        final List<String> _tmpPublic_key_list;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_3);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpSecretModel;
        if (_cursor.isNull(_cursorIndexOfSecretModel)) {
          _tmpSecretModel = null;
        } else {
          _tmpSecretModel = _cursor.getString(_cursorIndexOfSecretModel);
        }
        _item.setSecretModel(_tmpSecretModel);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final String _tmpChat_nick_user_chat_id;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChat_nick_user_chat_id = null;
        } else {
          _tmpChat_nick_user_chat_id = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChat_nick_user_chat_id(_tmpChat_nick_user_chat_id);
        final String _tmpChat_nick_data;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChat_nick_data = null;
        } else {
          _tmpChat_nick_data = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChat_nick_data(_tmpChat_nick_data);
        final String _tmpSenderPubKey;
        if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
          _tmpSenderPubKey = null;
        } else {
          _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
        }
        _item.setSenderPubKey(_tmpSenderPubKey);
        final String _tmpRecipientPubKeyFingerprint;
        if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
          _tmpRecipientPubKeyFingerprint = null;
        } else {
          _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
        }
        _item.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
        final String _tmpNextDHKey;
        if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
          _tmpNextDHKey = null;
        } else {
          _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
        }
        _item.setNextDHKey(_tmpNextDHKey);
        final int _tmpMessageCounter;
        _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
        _item.setMessageCounter(_tmpMessageCounter);
        final int _tmpChainIndex;
        _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
        _item.setChainIndex(_tmpChainIndex);
        final String _tmpData;
        if (_cursor.isNull(_cursorIndexOfData)) {
          _tmpData = null;
        } else {
          _tmpData = _cursor.getString(_cursorIndexOfData);
        }
        _item.setData(_tmpData);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _item.setType(_tmpType);
        final String _tmpMessageId;
        if (_cursor.isNull(_cursorIndexOfMessageId)) {
          _tmpMessageId = null;
        } else {
          _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
        }
        _item.setMessageId(_tmpMessageId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFile_path;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFile_path = null;
        } else {
          _tmpFile_path = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFile_path(_tmpFile_path);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final List<String> _tmpDeliveredList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setDeliveredList(_tmpDeliveredList);
        final boolean _tmpIsExpire;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
        _tmpIsExpire = _tmp_5 != 0;
        _item.setExpire(_tmpIsExpire);
        final boolean _tmpIsForwarded;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
        _tmpIsForwarded = _tmp_6 != 0;
        _item.setForwarded(_tmpIsForwarded);
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final long _tmpMsg_expiry_time;
        _tmpMsg_expiry_time = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsg_expiry_time(_tmpMsg_expiry_time);
        final boolean _tmpIsCanShareForward;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_7 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpFingerprint2;
        if (_cursor.isNull(_cursorIndexOfFingerprint2)) {
          _tmpFingerprint2 = null;
        } else {
          _tmpFingerprint2 = _cursor.getString(_cursorIndexOfFingerprint2);
        }
        _item.setFingerprint2(_tmpFingerprint2);
        final String _tmpAVRatchetKeyMaterial;
        if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
          _tmpAVRatchetKeyMaterial = null;
        } else {
          _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
        }
        _item.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
