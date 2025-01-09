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
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.roomDB.TypeConverters.DeliverListConverter;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MessagesDao_Impl implements MessagesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Payload> __insertionAdapterOfPayload;

  private final EntityDeletionOrUpdateAdapter<Payload> __deletionAdapterOfPayload;

  private final EntityDeletionOrUpdateAdapter<Payload> __updateAdapterOfPayload;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessage;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessage_1;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessageData;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessageDownloading;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessageOpened;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessageViewed;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFilePath;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMsgExpiryTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateExpireInTime;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByMessageId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByMessageId_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteConversationMessages;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public MessagesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPayload = new EntityInsertionAdapter<Payload>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Payload` (`id`,`data`,`type`,`messageId`,`senderId`,`createdAt`,`ack_id`,`conversationId`,`conversationType`,`userChatId`,`filePath`,`status`,`isEdited`,`isDeleted`,`deliveredList`,`readList`,`openedList`,`isExpire`,`isForwarded`,`isConfidential`,`isViewOnce`,`isViewed`,`isDownloading`,`readReceipts`,`isOpened`,`msgExpiryTime`,`expireStarted`,`public_key_list`,`received_at`,`payloadCanShareForward`,`chatNickUserChatId`,`chatNickData`,`senderPubKey`,`recipientPubKeyFingerprint`,`nextDHKey`,`messageCounter`,`chainIndex`,`aVRatchetKeyMaterial`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payload value) {
        stmt.bindLong(1, value.getId());
        if (value.getData() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getData());
        }
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getMessageId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMessageId());
        }
        if (value.getSenderId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSenderId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatedAt());
        }
        if (value.getAck_id() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAck_id());
        }
        if (value.getConversationId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getConversationId());
        }
        if (value.getConversationType() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getConversationType());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserChatId());
        }
        if (value.getFilePath() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFilePath());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getStatus());
        }
        final int _tmp = value.isEdited() ? 1 : 0;
        stmt.bindLong(13, _tmp);
        final int _tmp_1 = value.isDeleted() ? 1 : 0;
        stmt.bindLong(14, _tmp_1);
        final String _tmp_2 = DeliverListConverter.ListToJson(value.getDeliveredList());
        if (_tmp_2 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_2);
        }
        final String _tmp_3 = DeliverListConverter.ListToJson(value.getReadList());
        if (_tmp_3 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp_3);
        }
        final String _tmp_4 = DeliverListConverter.ListToJson(value.getOpenedList());
        if (_tmp_4 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_4);
        }
        final int _tmp_5 = value.isExpire() ? 1 : 0;
        stmt.bindLong(18, _tmp_5);
        final int _tmp_6 = value.isForwarded() ? 1 : 0;
        stmt.bindLong(19, _tmp_6);
        final int _tmp_7 = value.isConfidential() ? 1 : 0;
        stmt.bindLong(20, _tmp_7);
        final int _tmp_8 = value.isViewOnce() ? 1 : 0;
        stmt.bindLong(21, _tmp_8);
        final int _tmp_9 = value.isViewed() ? 1 : 0;
        stmt.bindLong(22, _tmp_9);
        final int _tmp_10 = value.isDownloading() ? 1 : 0;
        stmt.bindLong(23, _tmp_10);
        final int _tmp_11 = value.getReadReceipts() ? 1 : 0;
        stmt.bindLong(24, _tmp_11);
        final int _tmp_12 = value.isOpened() ? 1 : 0;
        stmt.bindLong(25, _tmp_12);
        stmt.bindLong(26, value.getMsgExpiryTime());
        stmt.bindLong(27, value.getExpireStarted());
        final String _tmp_13 = DeliverListConverter.ListToJson(value.getPublic_key_list());
        if (_tmp_13 == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, _tmp_13);
        }
        if (value.getReceived_at() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getReceived_at());
        }
        final int _tmp_14 = value.isCanShareForward() ? 1 : 0;
        stmt.bindLong(30, _tmp_14);
        if (value.getChatNickUserChatId() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getChatNickUserChatId());
        }
        if (value.getChatNickData() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getChatNickData());
        }
        if (value.getSenderPubKey() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getSenderPubKey());
        }
        if (value.getRecipientPubKeyFingerprint() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getRecipientPubKeyFingerprint());
        }
        if (value.getNextDHKey() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getNextDHKey());
        }
        stmt.bindLong(36, value.getMessageCounter());
        stmt.bindLong(37, value.getChainIndex());
        if (value.getAVRatchetKeyMaterial() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getAVRatchetKeyMaterial());
        }
      }
    };
    this.__deletionAdapterOfPayload = new EntityDeletionOrUpdateAdapter<Payload>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Payload` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payload value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPayload = new EntityDeletionOrUpdateAdapter<Payload>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Payload` SET `id` = ?,`data` = ?,`type` = ?,`messageId` = ?,`senderId` = ?,`createdAt` = ?,`ack_id` = ?,`conversationId` = ?,`conversationType` = ?,`userChatId` = ?,`filePath` = ?,`status` = ?,`isEdited` = ?,`isDeleted` = ?,`deliveredList` = ?,`readList` = ?,`openedList` = ?,`isExpire` = ?,`isForwarded` = ?,`isConfidential` = ?,`isViewOnce` = ?,`isViewed` = ?,`isDownloading` = ?,`readReceipts` = ?,`isOpened` = ?,`msgExpiryTime` = ?,`expireStarted` = ?,`public_key_list` = ?,`received_at` = ?,`payloadCanShareForward` = ?,`chatNickUserChatId` = ?,`chatNickData` = ?,`senderPubKey` = ?,`recipientPubKeyFingerprint` = ?,`nextDHKey` = ?,`messageCounter` = ?,`chainIndex` = ?,`aVRatchetKeyMaterial` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payload value) {
        stmt.bindLong(1, value.getId());
        if (value.getData() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getData());
        }
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getMessageId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMessageId());
        }
        if (value.getSenderId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSenderId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatedAt());
        }
        if (value.getAck_id() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAck_id());
        }
        if (value.getConversationId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getConversationId());
        }
        if (value.getConversationType() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getConversationType());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserChatId());
        }
        if (value.getFilePath() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFilePath());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getStatus());
        }
        final int _tmp = value.isEdited() ? 1 : 0;
        stmt.bindLong(13, _tmp);
        final int _tmp_1 = value.isDeleted() ? 1 : 0;
        stmt.bindLong(14, _tmp_1);
        final String _tmp_2 = DeliverListConverter.ListToJson(value.getDeliveredList());
        if (_tmp_2 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_2);
        }
        final String _tmp_3 = DeliverListConverter.ListToJson(value.getReadList());
        if (_tmp_3 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp_3);
        }
        final String _tmp_4 = DeliverListConverter.ListToJson(value.getOpenedList());
        if (_tmp_4 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_4);
        }
        final int _tmp_5 = value.isExpire() ? 1 : 0;
        stmt.bindLong(18, _tmp_5);
        final int _tmp_6 = value.isForwarded() ? 1 : 0;
        stmt.bindLong(19, _tmp_6);
        final int _tmp_7 = value.isConfidential() ? 1 : 0;
        stmt.bindLong(20, _tmp_7);
        final int _tmp_8 = value.isViewOnce() ? 1 : 0;
        stmt.bindLong(21, _tmp_8);
        final int _tmp_9 = value.isViewed() ? 1 : 0;
        stmt.bindLong(22, _tmp_9);
        final int _tmp_10 = value.isDownloading() ? 1 : 0;
        stmt.bindLong(23, _tmp_10);
        final int _tmp_11 = value.getReadReceipts() ? 1 : 0;
        stmt.bindLong(24, _tmp_11);
        final int _tmp_12 = value.isOpened() ? 1 : 0;
        stmt.bindLong(25, _tmp_12);
        stmt.bindLong(26, value.getMsgExpiryTime());
        stmt.bindLong(27, value.getExpireStarted());
        final String _tmp_13 = DeliverListConverter.ListToJson(value.getPublic_key_list());
        if (_tmp_13 == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, _tmp_13);
        }
        if (value.getReceived_at() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getReceived_at());
        }
        final int _tmp_14 = value.isCanShareForward() ? 1 : 0;
        stmt.bindLong(30, _tmp_14);
        if (value.getChatNickUserChatId() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getChatNickUserChatId());
        }
        if (value.getChatNickData() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getChatNickData());
        }
        if (value.getSenderPubKey() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getSenderPubKey());
        }
        if (value.getRecipientPubKeyFingerprint() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getRecipientPubKeyFingerprint());
        }
        if (value.getNextDHKey() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getNextDHKey());
        }
        stmt.bindLong(36, value.getMessageCounter());
        stmt.bindLong(37, value.getChainIndex());
        if (value.getAVRatchetKeyMaterial() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getAVRatchetKeyMaterial());
        }
        stmt.bindLong(39, value.getId());
      }
    };
    this.__preparedStmtOfUpdateMessage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET deliveredList = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMessage_1 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET status=? WHERE messageId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMessageData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET data = ?  WHERE messageId like ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMessageDownloading = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET isDownloading = ?  WHERE messageId like ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMessageOpened = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET isOpened = ?  WHERE messageId like ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMessageViewed = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET isViewed = ?  WHERE messageId like ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM payload WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFilePath = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET filePath = ? WHERE messageId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMsgExpiryTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET msgExpiryTime = ? WHERE messageId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateExpireInTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE payload SET expireStarted = ? WHERE messageId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByMessageId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM payload WHERE messageId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByMessageId_1 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM payload WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteConversationMessages = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from payload where conversationId= ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM payload";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Payload payload) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPayload.insert(payload);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Payload payload) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPayload.handle(payload);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<Payload> payloads) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPayload.handleMultiple(payloads);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMessage(final Payload payload) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPayload.handle(payload);
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
  public int updateMessage(final String status, final String messageId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMessage_1.acquire();
    int _argIndex = 1;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 2;
    if (messageId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, messageId);
    }
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateMessage_1.release(_stmt);
    }
  }

  @Override
  public void updateMessageData(final String messageId, final String data) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMessageData.acquire();
    int _argIndex = 1;
    if (data == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, data);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateMessageData.release(_stmt);
    }
  }

  @Override
  public void updateMessageDownloading(final String messageId, final Boolean isDownloading) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMessageDownloading.acquire();
    int _argIndex = 1;
    final Integer _tmp = isDownloading == null ? null : (isDownloading ? 1 : 0);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, _tmp);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateMessageDownloading.release(_stmt);
    }
  }

  @Override
  public void updateMessageOpened(final String messageId, final Boolean opened) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMessageOpened.acquire();
    int _argIndex = 1;
    final Integer _tmp = opened == null ? null : (opened ? 1 : 0);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, _tmp);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateMessageOpened.release(_stmt);
    }
  }

  @Override
  public void updateMessageViewed(final String messageId, final Boolean isViewed) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMessageViewed.acquire();
    int _argIndex = 1;
    final Integer _tmp = isViewed == null ? null : (isViewed ? 1 : 0);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, _tmp);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateMessageViewed.release(_stmt);
    }
  }

  @Override
  public void deleteById(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
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
  public void updateFilePath(final String id, final String file_path) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFilePath.acquire();
    int _argIndex = 1;
    if (file_path == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, file_path);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateFilePath.release(_stmt);
    }
  }

  @Override
  public void updateMsgExpiryTime(final String id, final long expiryTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMsgExpiryTime.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, expiryTime);
    _argIndex = 2;
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
      __preparedStmtOfUpdateMsgExpiryTime.release(_stmt);
    }
  }

  @Override
  public void updateExpireInTime(final String id, final long expireStarted) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateExpireInTime.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, expireStarted);
    _argIndex = 2;
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
      __preparedStmtOfUpdateExpireInTime.release(_stmt);
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
  public void deleteByMessageId(final long messageId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByMessageId_1.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, messageId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByMessageId_1.release(_stmt);
    }
  }

  @Override
  public void deleteConversationMessages(final String conId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteConversationMessages.acquire();
    int _argIndex = 1;
    if (conId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, conId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteConversationMessages.release(_stmt);
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
  public LiveData<List<Payload>> getLiveMessages() {
    final String _sql = "SELECT * FROM payload";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"payload"}, false, new Callable<List<Payload>>() {
      @Override
      public List<Payload> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
          final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
          final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
          final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
          final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
          final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
          final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
          final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
          final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
          final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
          final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
          final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
          final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Payload _item;
            _item = new Payload();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
            final String _tmpSenderId;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmpSenderId = null;
            } else {
              _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
            }
            _item.setSenderId(_tmpSenderId);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item.setCreatedAt(_tmpCreatedAt);
            final String _tmpAck_id;
            if (_cursor.isNull(_cursorIndexOfAckId)) {
              _tmpAck_id = null;
            } else {
              _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
            }
            _item.setAck_id(_tmpAck_id);
            final String _tmpConversationId;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId = null;
            } else {
              _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId);
            final String _tmpConversationType;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversationType = null;
            } else {
              _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversationType(_tmpConversationType);
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            _item.setUserChatId(_tmpUserChatId);
            final String _tmpFilePath;
            if (_cursor.isNull(_cursorIndexOfFilePath)) {
              _tmpFilePath = null;
            } else {
              _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
            }
            _item.setFilePath(_tmpFilePath);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
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
            final List<String> _tmpDeliveredList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
            }
            _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
            _item.setDeliveredList(_tmpDeliveredList);
            final List<String> _tmpReadList;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfReadList)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
            }
            _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
            _item.setReadList(_tmpReadList);
            final List<String> _tmpOpenedList;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfOpenedList)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
            }
            _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
            _item.setOpenedList(_tmpOpenedList);
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
            final boolean _tmpIsConfidential;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
            _tmpIsConfidential = _tmp_7 != 0;
            _item.setConfidential(_tmpIsConfidential);
            final boolean _tmpIsViewOnce;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
            _tmpIsViewOnce = _tmp_8 != 0;
            _item.setViewOnce(_tmpIsViewOnce);
            final boolean _tmpIsViewed;
            final int _tmp_9;
            _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
            _tmpIsViewed = _tmp_9 != 0;
            _item.setViewed(_tmpIsViewed);
            final boolean _tmpIsDownloading;
            final int _tmp_10;
            _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
            _tmpIsDownloading = _tmp_10 != 0;
            _item.setDownloading(_tmpIsDownloading);
            final boolean _tmpReadReceipts;
            final int _tmp_11;
            _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
            _tmpReadReceipts = _tmp_11 != 0;
            _item.setReadReceipts(_tmpReadReceipts);
            final boolean _tmpIsOpened;
            final int _tmp_12;
            _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
            _tmpIsOpened = _tmp_12 != 0;
            _item.setOpened(_tmpIsOpened);
            final long _tmpMsgExpiryTime;
            _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
            _item.setMsgExpiryTime(_tmpMsgExpiryTime);
            final long _tmpExpireStarted;
            _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
            _item.setExpireStarted(_tmpExpireStarted);
            final List<String> _tmpPublic_key_list;
            final String _tmp_13;
            if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
              _tmp_13 = null;
            } else {
              _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
            }
            _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
            _item.setPublic_key_list(_tmpPublic_key_list);
            final String _tmpReceived_at;
            if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
              _tmpReceived_at = null;
            } else {
              _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
            }
            _item.setReceived_at(_tmpReceived_at);
            final boolean _tmpIsCanShareForward;
            final int _tmp_14;
            _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward = _tmp_14 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward);
            final String _tmpChatNickUserChatId;
            if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
              _tmpChatNickUserChatId = null;
            } else {
              _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
            }
            _item.setChatNickUserChatId(_tmpChatNickUserChatId);
            final String _tmpChatNickData;
            if (_cursor.isNull(_cursorIndexOfChatNickData)) {
              _tmpChatNickData = null;
            } else {
              _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
            }
            _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getAllMessages() {
    final String _sql = "SELECT * FROM payload";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getMessages(final String conversationId) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ?";
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
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public LiveData<List<Payload>> getNotReadMessages(final String conversationId,
      final String status, final String userID) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND  status LIKE ? AND  senderId NOT LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    _argIndex = 3;
    if (userID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"payload"}, false, new Callable<List<Payload>>() {
      @Override
      public List<Payload> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
          final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
          final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
          final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
          final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
          final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
          final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
          final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
          final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
          final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
          final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
          final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
          final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Payload _item;
            _item = new Payload();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
            final String _tmpSenderId;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmpSenderId = null;
            } else {
              _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
            }
            _item.setSenderId(_tmpSenderId);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item.setCreatedAt(_tmpCreatedAt);
            final String _tmpAck_id;
            if (_cursor.isNull(_cursorIndexOfAckId)) {
              _tmpAck_id = null;
            } else {
              _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
            }
            _item.setAck_id(_tmpAck_id);
            final String _tmpConversationId;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId = null;
            } else {
              _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId);
            final String _tmpConversationType;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversationType = null;
            } else {
              _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversationType(_tmpConversationType);
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            _item.setUserChatId(_tmpUserChatId);
            final String _tmpFilePath;
            if (_cursor.isNull(_cursorIndexOfFilePath)) {
              _tmpFilePath = null;
            } else {
              _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
            }
            _item.setFilePath(_tmpFilePath);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
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
            final List<String> _tmpDeliveredList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
            }
            _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
            _item.setDeliveredList(_tmpDeliveredList);
            final List<String> _tmpReadList;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfReadList)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
            }
            _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
            _item.setReadList(_tmpReadList);
            final List<String> _tmpOpenedList;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfOpenedList)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
            }
            _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
            _item.setOpenedList(_tmpOpenedList);
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
            final boolean _tmpIsConfidential;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
            _tmpIsConfidential = _tmp_7 != 0;
            _item.setConfidential(_tmpIsConfidential);
            final boolean _tmpIsViewOnce;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
            _tmpIsViewOnce = _tmp_8 != 0;
            _item.setViewOnce(_tmpIsViewOnce);
            final boolean _tmpIsViewed;
            final int _tmp_9;
            _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
            _tmpIsViewed = _tmp_9 != 0;
            _item.setViewed(_tmpIsViewed);
            final boolean _tmpIsDownloading;
            final int _tmp_10;
            _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
            _tmpIsDownloading = _tmp_10 != 0;
            _item.setDownloading(_tmpIsDownloading);
            final boolean _tmpReadReceipts;
            final int _tmp_11;
            _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
            _tmpReadReceipts = _tmp_11 != 0;
            _item.setReadReceipts(_tmpReadReceipts);
            final boolean _tmpIsOpened;
            final int _tmp_12;
            _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
            _tmpIsOpened = _tmp_12 != 0;
            _item.setOpened(_tmpIsOpened);
            final long _tmpMsgExpiryTime;
            _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
            _item.setMsgExpiryTime(_tmpMsgExpiryTime);
            final long _tmpExpireStarted;
            _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
            _item.setExpireStarted(_tmpExpireStarted);
            final List<String> _tmpPublic_key_list;
            final String _tmp_13;
            if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
              _tmp_13 = null;
            } else {
              _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
            }
            _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
            _item.setPublic_key_list(_tmpPublic_key_list);
            final String _tmpReceived_at;
            if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
              _tmpReceived_at = null;
            } else {
              _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
            }
            _item.setReceived_at(_tmpReceived_at);
            final boolean _tmpIsCanShareForward;
            final int _tmp_14;
            _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward = _tmp_14 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward);
            final String _tmpChatNickUserChatId;
            if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
              _tmpChatNickUserChatId = null;
            } else {
              _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
            }
            _item.setChatNickUserChatId(_tmpChatNickUserChatId);
            final String _tmpChatNickData;
            if (_cursor.isNull(_cursorIndexOfChatNickData)) {
              _tmpChatNickData = null;
            } else {
              _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
            }
            _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getUnReadMessages(final String conversationId, final String status,
      final String userID) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND  status LIKE ? AND  senderId NOT LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    _argIndex = 3;
    if (userID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getNotReadMessagesExpire(final String conversationId, final String status,
      final String userID) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND  status LIKE ? AND  senderId NOT LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    _argIndex = 3;
    if (userID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public LiveData<List<Payload>> getMediaData(final String conversationId) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND filePath IS NOT NULL and  type LIKE 'image' or  type LIKE 'video' or type like 'audio'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"payload"}, false, new Callable<List<Payload>>() {
      @Override
      public List<Payload> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
          final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
          final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
          final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
          final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
          final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
          final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
          final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
          final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
          final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
          final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
          final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
          final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Payload _item;
            _item = new Payload();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
            final String _tmpSenderId;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmpSenderId = null;
            } else {
              _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
            }
            _item.setSenderId(_tmpSenderId);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item.setCreatedAt(_tmpCreatedAt);
            final String _tmpAck_id;
            if (_cursor.isNull(_cursorIndexOfAckId)) {
              _tmpAck_id = null;
            } else {
              _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
            }
            _item.setAck_id(_tmpAck_id);
            final String _tmpConversationId;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId = null;
            } else {
              _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId);
            final String _tmpConversationType;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversationType = null;
            } else {
              _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversationType(_tmpConversationType);
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            _item.setUserChatId(_tmpUserChatId);
            final String _tmpFilePath;
            if (_cursor.isNull(_cursorIndexOfFilePath)) {
              _tmpFilePath = null;
            } else {
              _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
            }
            _item.setFilePath(_tmpFilePath);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
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
            final List<String> _tmpDeliveredList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
            }
            _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
            _item.setDeliveredList(_tmpDeliveredList);
            final List<String> _tmpReadList;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfReadList)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
            }
            _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
            _item.setReadList(_tmpReadList);
            final List<String> _tmpOpenedList;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfOpenedList)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
            }
            _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
            _item.setOpenedList(_tmpOpenedList);
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
            final boolean _tmpIsConfidential;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
            _tmpIsConfidential = _tmp_7 != 0;
            _item.setConfidential(_tmpIsConfidential);
            final boolean _tmpIsViewOnce;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
            _tmpIsViewOnce = _tmp_8 != 0;
            _item.setViewOnce(_tmpIsViewOnce);
            final boolean _tmpIsViewed;
            final int _tmp_9;
            _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
            _tmpIsViewed = _tmp_9 != 0;
            _item.setViewed(_tmpIsViewed);
            final boolean _tmpIsDownloading;
            final int _tmp_10;
            _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
            _tmpIsDownloading = _tmp_10 != 0;
            _item.setDownloading(_tmpIsDownloading);
            final boolean _tmpReadReceipts;
            final int _tmp_11;
            _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
            _tmpReadReceipts = _tmp_11 != 0;
            _item.setReadReceipts(_tmpReadReceipts);
            final boolean _tmpIsOpened;
            final int _tmp_12;
            _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
            _tmpIsOpened = _tmp_12 != 0;
            _item.setOpened(_tmpIsOpened);
            final long _tmpMsgExpiryTime;
            _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
            _item.setMsgExpiryTime(_tmpMsgExpiryTime);
            final long _tmpExpireStarted;
            _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
            _item.setExpireStarted(_tmpExpireStarted);
            final List<String> _tmpPublic_key_list;
            final String _tmp_13;
            if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
              _tmp_13 = null;
            } else {
              _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
            }
            _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
            _item.setPublic_key_list(_tmpPublic_key_list);
            final String _tmpReceived_at;
            if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
              _tmpReceived_at = null;
            } else {
              _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
            }
            _item.setReceived_at(_tmpReceived_at);
            final boolean _tmpIsCanShareForward;
            final int _tmp_14;
            _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward = _tmp_14 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward);
            final String _tmpChatNickUserChatId;
            if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
              _tmpChatNickUserChatId = null;
            } else {
              _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
            }
            _item.setChatNickUserChatId(_tmpChatNickUserChatId);
            final String _tmpChatNickData;
            if (_cursor.isNull(_cursorIndexOfChatNickData)) {
              _tmpChatNickData = null;
            } else {
              _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
            }
            _item.setChatNickData(_tmpChatNickData);
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
  public LiveData<List<Payload>> getDocsData(final String conversationId) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND filePath IS NOT NULL and  type LIKE 'file'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"payload"}, false, new Callable<List<Payload>>() {
      @Override
      public List<Payload> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
          final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
          final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
          final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
          final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
          final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
          final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
          final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
          final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
          final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
          final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
          final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
          final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Payload _item;
            _item = new Payload();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
            final String _tmpSenderId;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmpSenderId = null;
            } else {
              _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
            }
            _item.setSenderId(_tmpSenderId);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item.setCreatedAt(_tmpCreatedAt);
            final String _tmpAck_id;
            if (_cursor.isNull(_cursorIndexOfAckId)) {
              _tmpAck_id = null;
            } else {
              _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
            }
            _item.setAck_id(_tmpAck_id);
            final String _tmpConversationId;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId = null;
            } else {
              _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId);
            final String _tmpConversationType;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversationType = null;
            } else {
              _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversationType(_tmpConversationType);
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            _item.setUserChatId(_tmpUserChatId);
            final String _tmpFilePath;
            if (_cursor.isNull(_cursorIndexOfFilePath)) {
              _tmpFilePath = null;
            } else {
              _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
            }
            _item.setFilePath(_tmpFilePath);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
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
            final List<String> _tmpDeliveredList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
            }
            _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
            _item.setDeliveredList(_tmpDeliveredList);
            final List<String> _tmpReadList;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfReadList)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
            }
            _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
            _item.setReadList(_tmpReadList);
            final List<String> _tmpOpenedList;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfOpenedList)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
            }
            _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
            _item.setOpenedList(_tmpOpenedList);
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
            final boolean _tmpIsConfidential;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
            _tmpIsConfidential = _tmp_7 != 0;
            _item.setConfidential(_tmpIsConfidential);
            final boolean _tmpIsViewOnce;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
            _tmpIsViewOnce = _tmp_8 != 0;
            _item.setViewOnce(_tmpIsViewOnce);
            final boolean _tmpIsViewed;
            final int _tmp_9;
            _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
            _tmpIsViewed = _tmp_9 != 0;
            _item.setViewed(_tmpIsViewed);
            final boolean _tmpIsDownloading;
            final int _tmp_10;
            _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
            _tmpIsDownloading = _tmp_10 != 0;
            _item.setDownloading(_tmpIsDownloading);
            final boolean _tmpReadReceipts;
            final int _tmp_11;
            _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
            _tmpReadReceipts = _tmp_11 != 0;
            _item.setReadReceipts(_tmpReadReceipts);
            final boolean _tmpIsOpened;
            final int _tmp_12;
            _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
            _tmpIsOpened = _tmp_12 != 0;
            _item.setOpened(_tmpIsOpened);
            final long _tmpMsgExpiryTime;
            _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
            _item.setMsgExpiryTime(_tmpMsgExpiryTime);
            final long _tmpExpireStarted;
            _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
            _item.setExpireStarted(_tmpExpireStarted);
            final List<String> _tmpPublic_key_list;
            final String _tmp_13;
            if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
              _tmp_13 = null;
            } else {
              _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
            }
            _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
            _item.setPublic_key_list(_tmpPublic_key_list);
            final String _tmpReceived_at;
            if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
              _tmpReceived_at = null;
            } else {
              _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
            }
            _item.setReceived_at(_tmpReceived_at);
            final boolean _tmpIsCanShareForward;
            final int _tmp_14;
            _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward = _tmp_14 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward);
            final String _tmpChatNickUserChatId;
            if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
              _tmpChatNickUserChatId = null;
            } else {
              _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
            }
            _item.setChatNickUserChatId(_tmpChatNickUserChatId);
            final String _tmpChatNickData;
            if (_cursor.isNull(_cursorIndexOfChatNickData)) {
              _tmpChatNickData = null;
            } else {
              _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
            }
            _item.setChatNickData(_tmpChatNickData);
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
  public LiveData<List<Payload>> getLinksData(final String conversationId) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND  type LIKE 'text'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"payload"}, false, new Callable<List<Payload>>() {
      @Override
      public List<Payload> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
          final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
          final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
          final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
          final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
          final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
          final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
          final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
          final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
          final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
          final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
          final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
          final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Payload _item;
            _item = new Payload();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
            final String _tmpSenderId;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmpSenderId = null;
            } else {
              _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
            }
            _item.setSenderId(_tmpSenderId);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item.setCreatedAt(_tmpCreatedAt);
            final String _tmpAck_id;
            if (_cursor.isNull(_cursorIndexOfAckId)) {
              _tmpAck_id = null;
            } else {
              _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
            }
            _item.setAck_id(_tmpAck_id);
            final String _tmpConversationId;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId = null;
            } else {
              _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId);
            final String _tmpConversationType;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversationType = null;
            } else {
              _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversationType(_tmpConversationType);
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            _item.setUserChatId(_tmpUserChatId);
            final String _tmpFilePath;
            if (_cursor.isNull(_cursorIndexOfFilePath)) {
              _tmpFilePath = null;
            } else {
              _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
            }
            _item.setFilePath(_tmpFilePath);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
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
            final List<String> _tmpDeliveredList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
            }
            _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
            _item.setDeliveredList(_tmpDeliveredList);
            final List<String> _tmpReadList;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfReadList)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
            }
            _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
            _item.setReadList(_tmpReadList);
            final List<String> _tmpOpenedList;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfOpenedList)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
            }
            _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
            _item.setOpenedList(_tmpOpenedList);
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
            final boolean _tmpIsConfidential;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
            _tmpIsConfidential = _tmp_7 != 0;
            _item.setConfidential(_tmpIsConfidential);
            final boolean _tmpIsViewOnce;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
            _tmpIsViewOnce = _tmp_8 != 0;
            _item.setViewOnce(_tmpIsViewOnce);
            final boolean _tmpIsViewed;
            final int _tmp_9;
            _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
            _tmpIsViewed = _tmp_9 != 0;
            _item.setViewed(_tmpIsViewed);
            final boolean _tmpIsDownloading;
            final int _tmp_10;
            _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
            _tmpIsDownloading = _tmp_10 != 0;
            _item.setDownloading(_tmpIsDownloading);
            final boolean _tmpReadReceipts;
            final int _tmp_11;
            _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
            _tmpReadReceipts = _tmp_11 != 0;
            _item.setReadReceipts(_tmpReadReceipts);
            final boolean _tmpIsOpened;
            final int _tmp_12;
            _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
            _tmpIsOpened = _tmp_12 != 0;
            _item.setOpened(_tmpIsOpened);
            final long _tmpMsgExpiryTime;
            _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
            _item.setMsgExpiryTime(_tmpMsgExpiryTime);
            final long _tmpExpireStarted;
            _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
            _item.setExpireStarted(_tmpExpireStarted);
            final List<String> _tmpPublic_key_list;
            final String _tmp_13;
            if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
              _tmp_13 = null;
            } else {
              _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
            }
            _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
            _item.setPublic_key_list(_tmpPublic_key_list);
            final String _tmpReceived_at;
            if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
              _tmpReceived_at = null;
            } else {
              _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
            }
            _item.setReceived_at(_tmpReceived_at);
            final boolean _tmpIsCanShareForward;
            final int _tmp_14;
            _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward = _tmp_14 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward);
            final String _tmpChatNickUserChatId;
            if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
              _tmpChatNickUserChatId = null;
            } else {
              _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
            }
            _item.setChatNickUserChatId(_tmpChatNickUserChatId);
            final String _tmpChatNickData;
            if (_cursor.isNull(_cursorIndexOfChatNickData)) {
              _tmpChatNickData = null;
            } else {
              _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
            }
            _item.setChatNickData(_tmpChatNickData);
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
  public Payload getLastMessage(final String conId) {
    final String _sql = "SELECT * FROM payload WHERE id = (SELECT MAX(id) FROM payload) AND  conversationId LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final Payload _result;
      if(_cursor.moveToFirst()) {
        _result = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpData;
        if (_cursor.isNull(_cursorIndexOfData)) {
          _tmpData = null;
        } else {
          _tmpData = _cursor.getString(_cursorIndexOfData);
        }
        _result.setData(_tmpData);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _result.setType(_tmpType);
        final String _tmpMessageId;
        if (_cursor.isNull(_cursorIndexOfMessageId)) {
          _tmpMessageId = null;
        } else {
          _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
        }
        _result.setMessageId(_tmpMessageId);
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _result.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _result.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _result.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _result.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _result.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _result.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _result.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final boolean _tmpIsEdited;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
        _tmpIsEdited = _tmp != 0;
        _result.setEdited(_tmpIsEdited);
        final boolean _tmpIsDeleted;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
        _tmpIsDeleted = _tmp_1 != 0;
        _result.setDeleted(_tmpIsDeleted);
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _result.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _result.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _result.setOpenedList(_tmpOpenedList);
        final boolean _tmpIsExpire;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
        _tmpIsExpire = _tmp_5 != 0;
        _result.setExpire(_tmpIsExpire);
        final boolean _tmpIsForwarded;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
        _tmpIsForwarded = _tmp_6 != 0;
        _result.setForwarded(_tmpIsForwarded);
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _result.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _result.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _result.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _result.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _result.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _result.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _result.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _result.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _result.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _result.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _result.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _result.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _result.setChatNickData(_tmpChatNickData);
        final String _tmpSenderPubKey;
        if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
          _tmpSenderPubKey = null;
        } else {
          _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
        }
        _result.setSenderPubKey(_tmpSenderPubKey);
        final String _tmpRecipientPubKeyFingerprint;
        if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
          _tmpRecipientPubKeyFingerprint = null;
        } else {
          _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
        }
        _result.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
        final String _tmpNextDHKey;
        if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
          _tmpNextDHKey = null;
        } else {
          _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
        }
        _result.setNextDHKey(_tmpNextDHKey);
        final int _tmpMessageCounter;
        _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
        _result.setMessageCounter(_tmpMessageCounter);
        final int _tmpChainIndex;
        _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
        _result.setChainIndex(_tmpChainIndex);
        final String _tmpAVRatchetKeyMaterial;
        if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
          _tmpAVRatchetKeyMaterial = null;
        } else {
          _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
        }
        _result.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Payload getMessage(final String messageId) {
    final String _sql = "SELECT * FROM payload WHERE messageId LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (messageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, messageId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final Payload _result;
      if(_cursor.moveToFirst()) {
        _result = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpData;
        if (_cursor.isNull(_cursorIndexOfData)) {
          _tmpData = null;
        } else {
          _tmpData = _cursor.getString(_cursorIndexOfData);
        }
        _result.setData(_tmpData);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _result.setType(_tmpType);
        final String _tmpMessageId;
        if (_cursor.isNull(_cursorIndexOfMessageId)) {
          _tmpMessageId = null;
        } else {
          _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
        }
        _result.setMessageId(_tmpMessageId);
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _result.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _result.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _result.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _result.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _result.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _result.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _result.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final boolean _tmpIsEdited;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
        _tmpIsEdited = _tmp != 0;
        _result.setEdited(_tmpIsEdited);
        final boolean _tmpIsDeleted;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
        _tmpIsDeleted = _tmp_1 != 0;
        _result.setDeleted(_tmpIsDeleted);
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _result.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _result.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _result.setOpenedList(_tmpOpenedList);
        final boolean _tmpIsExpire;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
        _tmpIsExpire = _tmp_5 != 0;
        _result.setExpire(_tmpIsExpire);
        final boolean _tmpIsForwarded;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
        _tmpIsForwarded = _tmp_6 != 0;
        _result.setForwarded(_tmpIsForwarded);
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _result.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _result.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _result.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _result.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _result.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _result.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _result.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _result.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _result.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _result.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _result.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _result.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _result.setChatNickData(_tmpChatNickData);
        final String _tmpSenderPubKey;
        if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
          _tmpSenderPubKey = null;
        } else {
          _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
        }
        _result.setSenderPubKey(_tmpSenderPubKey);
        final String _tmpRecipientPubKeyFingerprint;
        if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
          _tmpRecipientPubKeyFingerprint = null;
        } else {
          _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
        }
        _result.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
        final String _tmpNextDHKey;
        if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
          _tmpNextDHKey = null;
        } else {
          _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
        }
        _result.setNextDHKey(_tmpNextDHKey);
        final int _tmpMessageCounter;
        _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
        _result.setMessageCounter(_tmpMessageCounter);
        final int _tmpChainIndex;
        _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
        _result.setChainIndex(_tmpChainIndex);
        final String _tmpAVRatchetKeyMaterial;
        if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
          _tmpAVRatchetKeyMaterial = null;
        } else {
          _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
        }
        _result.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Payload> getAllMessagesViewed() {
    final String _sql = "SELECT * FROM payload WHERE filePath IS NOT NULL and  isViewOnce like 1 and isOpened like 1 and isViewed like 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getAllMediaMessages(final String conId) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND type NOT LIKE 'text' ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getAllDownloadedMediaMessages(final String conId) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? and filePath IS NOT NULL AND type NOT LIKE 'text' ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getExpirySelfMessages(final String conId) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND type LIKE 'conv_expiry_self' ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getExpiryMessages(final String conId) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND type LIKE 'conv_expiry' ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getAllExpiryMessages(final String conId, final String status) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND isExpire LIKE 1 AND status like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getAllExpiryMessage() {
    final String _sql = "SELECT * FROM payload WHERE isExpire LIKE 1 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getReceiverDownloadedMediaData(final String conversationId,
      final String senderID) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND filePath IS NOT NULL  and senderId not like ? and  type LIKE 'image' or  type LIKE 'video' or type like 'audio' or type like 'file'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    _argIndex = 2;
    if (senderID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, senderID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getSenderDownloadedMediaData(final String conversationId,
      final String senderID) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND filePath IS NOT NULL  and senderId like ? and  type LIKE 'image' or  type LIKE 'video' or type like 'audio' or type like 'file'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (conversationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conversationId);
    }
    _argIndex = 2;
    if (senderID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, senderID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getAllSenderExpiryMessages(final String conId, final String status,
      final String senderID) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND isExpire LIKE 1 AND status not like ? AND senderId like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    _argIndex = 3;
    if (senderID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, senderID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getAllReceiverExpiryMessages(final String conId, final String status,
      final String senderID) {
    final String _sql = "SELECT * FROM payload WHERE conversationId LIKE ? AND isExpire LIKE 1 AND status like ? AND senderId not like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    _argIndex = 3;
    if (senderID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, senderID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
  public List<Payload> getConSpecificAllMediaMessages(final String senderID, final String conType) {
    final String _sql = "SELECT * FROM payload WHERE senderId not like ? and conversationType like ? and filePath IS NULL AND type NOT LIKE 'text' and isDownloading like 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (senderID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, senderID);
    }
    _argIndex = 2;
    if (conType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conType);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "userChatId");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filePath");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "isEdited");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfDeliveredList = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredList");
      final int _cursorIndexOfReadList = CursorUtil.getColumnIndexOrThrow(_cursor, "readList");
      final int _cursorIndexOfOpenedList = CursorUtil.getColumnIndexOrThrow(_cursor, "openedList");
      final int _cursorIndexOfIsExpire = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpire");
      final int _cursorIndexOfIsForwarded = CursorUtil.getColumnIndexOrThrow(_cursor, "isForwarded");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Payload> _result = new ArrayList<Payload>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payload _item;
        _item = new Payload();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        _item.setSenderId(_tmpSenderId);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        final String _tmpAck_id;
        if (_cursor.isNull(_cursorIndexOfAckId)) {
          _tmpAck_id = null;
        } else {
          _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
        }
        _item.setAck_id(_tmpAck_id);
        final String _tmpConversationId;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId = null;
        } else {
          _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId);
        final String _tmpConversationType;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType = null;
        } else {
          _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType);
        final String _tmpUserChatId;
        if (_cursor.isNull(_cursorIndexOfUserChatId)) {
          _tmpUserChatId = null;
        } else {
          _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
        }
        _item.setUserChatId(_tmpUserChatId);
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        _item.setFilePath(_tmpFilePath);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
        final List<String> _tmpDeliveredList;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
        }
        _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
        _item.setDeliveredList(_tmpDeliveredList);
        final List<String> _tmpReadList;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfReadList)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
        }
        _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
        _item.setReadList(_tmpReadList);
        final List<String> _tmpOpenedList;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfOpenedList)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
        }
        _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
        _item.setOpenedList(_tmpOpenedList);
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
        final boolean _tmpIsConfidential;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential = _tmp_7 != 0;
        _item.setConfidential(_tmpIsConfidential);
        final boolean _tmpIsViewOnce;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce = _tmp_8 != 0;
        _item.setViewOnce(_tmpIsViewOnce);
        final boolean _tmpIsViewed;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
        _tmpIsViewed = _tmp_9 != 0;
        _item.setViewed(_tmpIsViewed);
        final boolean _tmpIsDownloading;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
        _tmpIsDownloading = _tmp_10 != 0;
        _item.setDownloading(_tmpIsDownloading);
        final boolean _tmpReadReceipts;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
        _tmpReadReceipts = _tmp_11 != 0;
        _item.setReadReceipts(_tmpReadReceipts);
        final boolean _tmpIsOpened;
        final int _tmp_12;
        _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
        _tmpIsOpened = _tmp_12 != 0;
        _item.setOpened(_tmpIsOpened);
        final long _tmpMsgExpiryTime;
        _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
        _item.setMsgExpiryTime(_tmpMsgExpiryTime);
        final long _tmpExpireStarted;
        _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
        _item.setExpireStarted(_tmpExpireStarted);
        final List<String> _tmpPublic_key_list;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
        }
        _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
        _item.setPublic_key_list(_tmpPublic_key_list);
        final String _tmpReceived_at;
        if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
          _tmpReceived_at = null;
        } else {
          _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
        }
        _item.setReceived_at(_tmpReceived_at);
        final boolean _tmpIsCanShareForward;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward = _tmp_14 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward);
        final String _tmpChatNickUserChatId;
        if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
          _tmpChatNickUserChatId = null;
        } else {
          _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
        }
        _item.setChatNickUserChatId(_tmpChatNickUserChatId);
        final String _tmpChatNickData;
        if (_cursor.isNull(_cursorIndexOfChatNickData)) {
          _tmpChatNickData = null;
        } else {
          _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
        }
        _item.setChatNickData(_tmpChatNickData);
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
