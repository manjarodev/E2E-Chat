package com.devbeans.io.chat.roomDB.Dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.devbeans.io.chat.encryption.EK;
import com.devbeans.io.chat.encryption.SymmRatchet;
import com.devbeans.io.chat.models.ConversationChannels;
import com.devbeans.io.chat.models.SecretKey;
import com.devbeans.io.chat.roomDB.TypeConverters.EKConverterSimple;
import com.devbeans.io.chat.roomDB.TypeConverters.HashMapTypeConverter;
import com.devbeans.io.chat.roomDB.TypeConverters.SecretKeyConverterSimple;
import com.devbeans.io.chat.roomDB.TypeConverters.SymmRatchetConverterSimple;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ConversationChannelsDao_Impl implements ConversationChannelsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ConversationChannels> __insertionAdapterOfConversationChannels;

  private final SecretKeyConverterSimple __secretKeyConverterSimple = new SecretKeyConverterSimple();

  private final SymmRatchetConverterSimple __symmRatchetConverterSimple = new SymmRatchetConverterSimple();

  private final HashMapTypeConverter __hashMapTypeConverter = new HashMapTypeConverter();

  private final EKConverterSimple __eKConverterSimple = new EKConverterSimple();

  private final EntityDeletionOrUpdateAdapter<ConversationChannels> __updateAdapterOfConversationChannels;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSecretKey;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSenderRatchet;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReceiverRatchet;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRootRatchet;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRecipientPubKey;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFriendDHKey;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChannelDecrypting;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDhRatchet;

  private final SharedSQLiteStatement __preparedStmtOfIncrementSenderCount;

  private final SharedSQLiteStatement __preparedStmtOfIncrementReceiveCount;

  private final SharedSQLiteStatement __preparedStmtOfFlipRatchetDirection;

  private final SharedSQLiteStatement __preparedStmtOfDeleteConversationChannel;

  public ConversationChannelsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConversationChannels = new EntityInsertionAdapter<ConversationChannels>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `conversation_channels` (`channelId`,`channelIdentifier`,`channelWith`,`SK`,`RootRatchet`,`SendRatchet`,`RecvRatchet`,`cacheRatchet`,`RecipientPubKey`,`FriendDHKey`,`CacheFriendDHKey`,`DHRatchet`,`CacheRachet`,`EK`,`SendCounter`,`ReceiveCounter`,`FlipRatchetDirection`,`isDHRacthetEnable`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConversationChannels value) {
        stmt.bindLong(1, value.getChannelId());
        if (value.getChannelIdentifier() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChannelIdentifier());
        }
        if (value.getChannelWith() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getChannelWith());
        }
        final String _tmp = __secretKeyConverterSimple.KeyToJson(value.getSK());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        final String _tmp_1 = __symmRatchetConverterSimple.RachetToJson(value.getRootRatchet());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_1);
        }
        final String _tmp_2 = __symmRatchetConverterSimple.RachetToJson(value.getSendRatchet());
        if (_tmp_2 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_2);
        }
        final String _tmp_3 = __symmRatchetConverterSimple.RachetToJson(value.getRecvRatchet());
        if (_tmp_3 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_3);
        }
        final String _tmp_4 = __symmRatchetConverterSimple.RachetToJson(value.getCacheRatchet());
        if (_tmp_4 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_4);
        }
        if (value.getRecipientPubKey() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRecipientPubKey());
        }
        if (value.getFriendDHKey() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFriendDHKey());
        }
        final String _tmp_5 = __hashMapTypeConverter.fromStringMap(value.getCacheFriendDHKey());
        if (_tmp_5 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_5);
        }
        final String _tmp_6 = __eKConverterSimple.EkToJson(value.getDHRatchet());
        if (_tmp_6 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp_6);
        }
        final String _tmp_7 = __eKConverterSimple.EkToJson(value.getCacheRachet());
        if (_tmp_7 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_7);
        }
        final String _tmp_8 = __eKConverterSimple.EkToJson(value.getEK());
        if (_tmp_8 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, _tmp_8);
        }
        stmt.bindLong(15, value.getSendCounter());
        stmt.bindLong(16, value.getReceiveCounter());
        stmt.bindLong(17, value.getFlipRatchetDirection());
        final int _tmp_9 = value.isDHRacthetEnable() ? 1 : 0;
        stmt.bindLong(18, _tmp_9);
      }
    };
    this.__updateAdapterOfConversationChannels = new EntityDeletionOrUpdateAdapter<ConversationChannels>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `conversation_channels` SET `channelId` = ?,`channelIdentifier` = ?,`channelWith` = ?,`SK` = ?,`RootRatchet` = ?,`SendRatchet` = ?,`RecvRatchet` = ?,`cacheRatchet` = ?,`RecipientPubKey` = ?,`FriendDHKey` = ?,`CacheFriendDHKey` = ?,`DHRatchet` = ?,`CacheRachet` = ?,`EK` = ?,`SendCounter` = ?,`ReceiveCounter` = ?,`FlipRatchetDirection` = ?,`isDHRacthetEnable` = ? WHERE `channelId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConversationChannels value) {
        stmt.bindLong(1, value.getChannelId());
        if (value.getChannelIdentifier() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChannelIdentifier());
        }
        if (value.getChannelWith() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getChannelWith());
        }
        final String _tmp = __secretKeyConverterSimple.KeyToJson(value.getSK());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        final String _tmp_1 = __symmRatchetConverterSimple.RachetToJson(value.getRootRatchet());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_1);
        }
        final String _tmp_2 = __symmRatchetConverterSimple.RachetToJson(value.getSendRatchet());
        if (_tmp_2 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_2);
        }
        final String _tmp_3 = __symmRatchetConverterSimple.RachetToJson(value.getRecvRatchet());
        if (_tmp_3 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_3);
        }
        final String _tmp_4 = __symmRatchetConverterSimple.RachetToJson(value.getCacheRatchet());
        if (_tmp_4 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_4);
        }
        if (value.getRecipientPubKey() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRecipientPubKey());
        }
        if (value.getFriendDHKey() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFriendDHKey());
        }
        final String _tmp_5 = __hashMapTypeConverter.fromStringMap(value.getCacheFriendDHKey());
        if (_tmp_5 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_5);
        }
        final String _tmp_6 = __eKConverterSimple.EkToJson(value.getDHRatchet());
        if (_tmp_6 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp_6);
        }
        final String _tmp_7 = __eKConverterSimple.EkToJson(value.getCacheRachet());
        if (_tmp_7 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_7);
        }
        final String _tmp_8 = __eKConverterSimple.EkToJson(value.getEK());
        if (_tmp_8 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, _tmp_8);
        }
        stmt.bindLong(15, value.getSendCounter());
        stmt.bindLong(16, value.getReceiveCounter());
        stmt.bindLong(17, value.getFlipRatchetDirection());
        final int _tmp_9 = value.isDHRacthetEnable() ? 1 : 0;
        stmt.bindLong(18, _tmp_9);
        stmt.bindLong(19, value.getChannelId());
      }
    };
    this.__preparedStmtOfUpdateSecretKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET sk = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSenderRatchet = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET SendRatchet = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateReceiverRatchet = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET RecvRatchet = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRootRatchet = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET RootRatchet = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRecipientPubKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET RecipientPubKey = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFriendDHKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET FriendDHKey = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateChannelDecrypting = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET isDHRacthetEnable = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDhRatchet = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET DHRatchet = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfIncrementSenderCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET SendCounter = SendCounter + 1 WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfIncrementReceiveCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET ReceiveCounter = ReceiveCounter + 1 WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfFlipRatchetDirection = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation_channels SET FlipRatchetDirection = ? WHERE channelIdentifier = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteConversationChannel = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from conversation_channels WHERE channelIdentifier = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ConversationChannels conversationchannel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfConversationChannels.insert(conversationchannel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ConversationChannels channel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfConversationChannels.handle(channel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSecretKey(final String identifier, final SecretKey secretKey) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSecretKey.acquire();
    int _argIndex = 1;
    final String _tmp = __secretKeyConverterSimple.KeyToJson(secretKey);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSecretKey.release(_stmt);
    }
  }

  @Override
  public void updateSenderRatchet(final String identifier, final SymmRatchet sendRatchet) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSenderRatchet.acquire();
    int _argIndex = 1;
    final String _tmp = __symmRatchetConverterSimple.RachetToJson(sendRatchet);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSenderRatchet.release(_stmt);
    }
  }

  @Override
  public void updateReceiverRatchet(final String identifier, final SymmRatchet receiverRatchet) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReceiverRatchet.acquire();
    int _argIndex = 1;
    final String _tmp = __symmRatchetConverterSimple.RachetToJson(receiverRatchet);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateReceiverRatchet.release(_stmt);
    }
  }

  @Override
  public void updateRootRatchet(final String identifier, final SymmRatchet rootRatchet) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRootRatchet.acquire();
    int _argIndex = 1;
    final String _tmp = __symmRatchetConverterSimple.RachetToJson(rootRatchet);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateRootRatchet.release(_stmt);
    }
  }

  @Override
  public void updateRecipientPubKey(final String identifier, final String recipientPubKey) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRecipientPubKey.acquire();
    int _argIndex = 1;
    if (recipientPubKey == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, recipientPubKey);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateRecipientPubKey.release(_stmt);
    }
  }

  @Override
  public void updateFriendDHKey(final String identifier, final String friendDHKey) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFriendDHKey.acquire();
    int _argIndex = 1;
    if (friendDHKey == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, friendDHKey);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFriendDHKey.release(_stmt);
    }
  }

  @Override
  public void updateChannelDecrypting(final String identifier, final boolean isDHRacthetEnable) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateChannelDecrypting.acquire();
    int _argIndex = 1;
    final int _tmp = isDHRacthetEnable ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateChannelDecrypting.release(_stmt);
    }
  }

  @Override
  public void updateDhRatchet(final String identifier, final EK dHRatchet) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDhRatchet.acquire();
    int _argIndex = 1;
    final String _tmp = __eKConverterSimple.EkToJson(dHRatchet);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateDhRatchet.release(_stmt);
    }
  }

  @Override
  public void incrementSenderCount(final String identifier) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfIncrementSenderCount.acquire();
    int _argIndex = 1;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfIncrementSenderCount.release(_stmt);
    }
  }

  @Override
  public void incrementReceiveCount(final String identifier) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfIncrementReceiveCount.acquire();
    int _argIndex = 1;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfIncrementReceiveCount.release(_stmt);
    }
  }

  @Override
  public void flipRatchetDirection(final String identifier, final int direction) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfFlipRatchetDirection.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, direction);
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfFlipRatchetDirection.release(_stmt);
    }
  }

  @Override
  public void deleteConversationChannel(final String identifier) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteConversationChannel.acquire();
    int _argIndex = 1;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteConversationChannel.release(_stmt);
    }
  }

  @Override
  public boolean exist(final String identifier) {
    final String _sql = "SELECT EXISTS(SELECT * FROM conversation_channels WHERE channelIdentifier = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (identifier == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, identifier);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ConversationChannels> countChannels(final String identifier) {
    final String _sql = "SELECT * FROM conversation_channels WHERE channelIdentifier LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (identifier == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, identifier);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChannelId = CursorUtil.getColumnIndexOrThrow(_cursor, "channelId");
      final int _cursorIndexOfChannelIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "channelIdentifier");
      final int _cursorIndexOfChannelWith = CursorUtil.getColumnIndexOrThrow(_cursor, "channelWith");
      final int _cursorIndexOfSK = CursorUtil.getColumnIndexOrThrow(_cursor, "SK");
      final int _cursorIndexOfRootRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "RootRatchet");
      final int _cursorIndexOfSendRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "SendRatchet");
      final int _cursorIndexOfRecvRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "RecvRatchet");
      final int _cursorIndexOfCacheRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "cacheRatchet");
      final int _cursorIndexOfRecipientPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "RecipientPubKey");
      final int _cursorIndexOfFriendDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "FriendDHKey");
      final int _cursorIndexOfCacheFriendDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "CacheFriendDHKey");
      final int _cursorIndexOfDHRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "DHRatchet");
      final int _cursorIndexOfCacheRachet = CursorUtil.getColumnIndexOrThrow(_cursor, "CacheRachet");
      final int _cursorIndexOfEK = CursorUtil.getColumnIndexOrThrow(_cursor, "EK");
      final int _cursorIndexOfSendCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "SendCounter");
      final int _cursorIndexOfReceiveCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "ReceiveCounter");
      final int _cursorIndexOfFlipRatchetDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "FlipRatchetDirection");
      final int _cursorIndexOfIsDHRacthetEnable = CursorUtil.getColumnIndexOrThrow(_cursor, "isDHRacthetEnable");
      final List<ConversationChannels> _result = new ArrayList<ConversationChannels>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ConversationChannels _item;
        final String _tmpChannelIdentifier;
        if (_cursor.isNull(_cursorIndexOfChannelIdentifier)) {
          _tmpChannelIdentifier = null;
        } else {
          _tmpChannelIdentifier = _cursor.getString(_cursorIndexOfChannelIdentifier);
        }
        final int _tmpFlipRatchetDirection;
        _tmpFlipRatchetDirection = _cursor.getInt(_cursorIndexOfFlipRatchetDirection);
        _item = new ConversationChannels(_tmpChannelIdentifier,_tmpFlipRatchetDirection);
        final int _tmpChannelId;
        _tmpChannelId = _cursor.getInt(_cursorIndexOfChannelId);
        _item.setChannelId(_tmpChannelId);
        final String _tmpChannelWith;
        if (_cursor.isNull(_cursorIndexOfChannelWith)) {
          _tmpChannelWith = null;
        } else {
          _tmpChannelWith = _cursor.getString(_cursorIndexOfChannelWith);
        }
        _item.setChannelWith(_tmpChannelWith);
        final SecretKey _tmpSK;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfSK)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfSK);
        }
        _tmpSK = __secretKeyConverterSimple.JsonToKey(_tmp);
        _item.setSK(_tmpSK);
        final SymmRatchet _tmpRootRatchet;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfRootRatchet)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfRootRatchet);
        }
        _tmpRootRatchet = __symmRatchetConverterSimple.JsonToRacthet(_tmp_1);
        _item.setRootRatchet(_tmpRootRatchet);
        final SymmRatchet _tmpSendRatchet;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfSendRatchet)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfSendRatchet);
        }
        _tmpSendRatchet = __symmRatchetConverterSimple.JsonToRacthet(_tmp_2);
        _item.setSendRatchet(_tmpSendRatchet);
        final SymmRatchet _tmpRecvRatchet;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfRecvRatchet)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfRecvRatchet);
        }
        _tmpRecvRatchet = __symmRatchetConverterSimple.JsonToRacthet(_tmp_3);
        _item.setRecvRatchet(_tmpRecvRatchet);
        final SymmRatchet _tmpCacheRatchet;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfCacheRatchet)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfCacheRatchet);
        }
        _tmpCacheRatchet = __symmRatchetConverterSimple.JsonToRacthet(_tmp_4);
        _item.setCacheRatchet(_tmpCacheRatchet);
        final String _tmpRecipientPubKey;
        if (_cursor.isNull(_cursorIndexOfRecipientPubKey)) {
          _tmpRecipientPubKey = null;
        } else {
          _tmpRecipientPubKey = _cursor.getString(_cursorIndexOfRecipientPubKey);
        }
        _item.setRecipientPubKey(_tmpRecipientPubKey);
        final String _tmpFriendDHKey;
        if (_cursor.isNull(_cursorIndexOfFriendDHKey)) {
          _tmpFriendDHKey = null;
        } else {
          _tmpFriendDHKey = _cursor.getString(_cursorIndexOfFriendDHKey);
        }
        _item.setFriendDHKey(_tmpFriendDHKey);
        final HashMap<String, String> _tmpCacheFriendDHKey;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfCacheFriendDHKey)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfCacheFriendDHKey);
        }
        _tmpCacheFriendDHKey = __hashMapTypeConverter.fromString(_tmp_5);
        _item.setCacheFriendDHKey(_tmpCacheFriendDHKey);
        final EK _tmpDHRatchet;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfDHRatchet)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfDHRatchet);
        }
        _tmpDHRatchet = __eKConverterSimple.JsonToEK(_tmp_6);
        _item.setDHRatchet(_tmpDHRatchet);
        final EK _tmpCacheRachet;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfCacheRachet)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfCacheRachet);
        }
        _tmpCacheRachet = __eKConverterSimple.JsonToEK(_tmp_7);
        _item.setCacheRachet(_tmpCacheRachet);
        final EK _tmpEK;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfEK)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfEK);
        }
        _tmpEK = __eKConverterSimple.JsonToEK(_tmp_8);
        _item.setEK(_tmpEK);
        final int _tmpSendCounter;
        _tmpSendCounter = _cursor.getInt(_cursorIndexOfSendCounter);
        _item.setSendCounter(_tmpSendCounter);
        final int _tmpReceiveCounter;
        _tmpReceiveCounter = _cursor.getInt(_cursorIndexOfReceiveCounter);
        _item.setReceiveCounter(_tmpReceiveCounter);
        final boolean _tmpIsDHRacthetEnable;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsDHRacthetEnable);
        _tmpIsDHRacthetEnable = _tmp_9 != 0;
        _item.setDHRacthetEnable(_tmpIsDHRacthetEnable);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ConversationChannels getConversationChannel(final String identifier) {
    final String _sql = "SELECT * FROM conversation_channels WHERE channelIdentifier LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (identifier == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, identifier);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChannelId = CursorUtil.getColumnIndexOrThrow(_cursor, "channelId");
      final int _cursorIndexOfChannelIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "channelIdentifier");
      final int _cursorIndexOfChannelWith = CursorUtil.getColumnIndexOrThrow(_cursor, "channelWith");
      final int _cursorIndexOfSK = CursorUtil.getColumnIndexOrThrow(_cursor, "SK");
      final int _cursorIndexOfRootRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "RootRatchet");
      final int _cursorIndexOfSendRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "SendRatchet");
      final int _cursorIndexOfRecvRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "RecvRatchet");
      final int _cursorIndexOfCacheRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "cacheRatchet");
      final int _cursorIndexOfRecipientPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "RecipientPubKey");
      final int _cursorIndexOfFriendDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "FriendDHKey");
      final int _cursorIndexOfCacheFriendDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "CacheFriendDHKey");
      final int _cursorIndexOfDHRatchet = CursorUtil.getColumnIndexOrThrow(_cursor, "DHRatchet");
      final int _cursorIndexOfCacheRachet = CursorUtil.getColumnIndexOrThrow(_cursor, "CacheRachet");
      final int _cursorIndexOfEK = CursorUtil.getColumnIndexOrThrow(_cursor, "EK");
      final int _cursorIndexOfSendCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "SendCounter");
      final int _cursorIndexOfReceiveCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "ReceiveCounter");
      final int _cursorIndexOfFlipRatchetDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "FlipRatchetDirection");
      final int _cursorIndexOfIsDHRacthetEnable = CursorUtil.getColumnIndexOrThrow(_cursor, "isDHRacthetEnable");
      final ConversationChannels _result;
      if(_cursor.moveToFirst()) {
        final String _tmpChannelIdentifier;
        if (_cursor.isNull(_cursorIndexOfChannelIdentifier)) {
          _tmpChannelIdentifier = null;
        } else {
          _tmpChannelIdentifier = _cursor.getString(_cursorIndexOfChannelIdentifier);
        }
        final int _tmpFlipRatchetDirection;
        _tmpFlipRatchetDirection = _cursor.getInt(_cursorIndexOfFlipRatchetDirection);
        _result = new ConversationChannels(_tmpChannelIdentifier,_tmpFlipRatchetDirection);
        final int _tmpChannelId;
        _tmpChannelId = _cursor.getInt(_cursorIndexOfChannelId);
        _result.setChannelId(_tmpChannelId);
        final String _tmpChannelWith;
        if (_cursor.isNull(_cursorIndexOfChannelWith)) {
          _tmpChannelWith = null;
        } else {
          _tmpChannelWith = _cursor.getString(_cursorIndexOfChannelWith);
        }
        _result.setChannelWith(_tmpChannelWith);
        final SecretKey _tmpSK;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfSK)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfSK);
        }
        _tmpSK = __secretKeyConverterSimple.JsonToKey(_tmp);
        _result.setSK(_tmpSK);
        final SymmRatchet _tmpRootRatchet;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfRootRatchet)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfRootRatchet);
        }
        _tmpRootRatchet = __symmRatchetConverterSimple.JsonToRacthet(_tmp_1);
        _result.setRootRatchet(_tmpRootRatchet);
        final SymmRatchet _tmpSendRatchet;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfSendRatchet)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfSendRatchet);
        }
        _tmpSendRatchet = __symmRatchetConverterSimple.JsonToRacthet(_tmp_2);
        _result.setSendRatchet(_tmpSendRatchet);
        final SymmRatchet _tmpRecvRatchet;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfRecvRatchet)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfRecvRatchet);
        }
        _tmpRecvRatchet = __symmRatchetConverterSimple.JsonToRacthet(_tmp_3);
        _result.setRecvRatchet(_tmpRecvRatchet);
        final SymmRatchet _tmpCacheRatchet;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfCacheRatchet)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfCacheRatchet);
        }
        _tmpCacheRatchet = __symmRatchetConverterSimple.JsonToRacthet(_tmp_4);
        _result.setCacheRatchet(_tmpCacheRatchet);
        final String _tmpRecipientPubKey;
        if (_cursor.isNull(_cursorIndexOfRecipientPubKey)) {
          _tmpRecipientPubKey = null;
        } else {
          _tmpRecipientPubKey = _cursor.getString(_cursorIndexOfRecipientPubKey);
        }
        _result.setRecipientPubKey(_tmpRecipientPubKey);
        final String _tmpFriendDHKey;
        if (_cursor.isNull(_cursorIndexOfFriendDHKey)) {
          _tmpFriendDHKey = null;
        } else {
          _tmpFriendDHKey = _cursor.getString(_cursorIndexOfFriendDHKey);
        }
        _result.setFriendDHKey(_tmpFriendDHKey);
        final HashMap<String, String> _tmpCacheFriendDHKey;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfCacheFriendDHKey)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfCacheFriendDHKey);
        }
        _tmpCacheFriendDHKey = __hashMapTypeConverter.fromString(_tmp_5);
        _result.setCacheFriendDHKey(_tmpCacheFriendDHKey);
        final EK _tmpDHRatchet;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfDHRatchet)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfDHRatchet);
        }
        _tmpDHRatchet = __eKConverterSimple.JsonToEK(_tmp_6);
        _result.setDHRatchet(_tmpDHRatchet);
        final EK _tmpCacheRachet;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfCacheRachet)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfCacheRachet);
        }
        _tmpCacheRachet = __eKConverterSimple.JsonToEK(_tmp_7);
        _result.setCacheRachet(_tmpCacheRachet);
        final EK _tmpEK;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfEK)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfEK);
        }
        _tmpEK = __eKConverterSimple.JsonToEK(_tmp_8);
        _result.setEK(_tmpEK);
        final int _tmpSendCounter;
        _tmpSendCounter = _cursor.getInt(_cursorIndexOfSendCounter);
        _result.setSendCounter(_tmpSendCounter);
        final int _tmpReceiveCounter;
        _tmpReceiveCounter = _cursor.getInt(_cursorIndexOfReceiveCounter);
        _result.setReceiveCounter(_tmpReceiveCounter);
        final boolean _tmpIsDHRacthetEnable;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsDHRacthetEnable);
        _tmpIsDHRacthetEnable = _tmp_9 != 0;
        _result.setDHRacthetEnable(_tmpIsDHRacthetEnable);
      } else {
        _result = null;
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
