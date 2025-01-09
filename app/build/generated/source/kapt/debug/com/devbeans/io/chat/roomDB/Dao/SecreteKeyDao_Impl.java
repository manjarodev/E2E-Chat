package com.devbeans.io.chat.roomDB.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.devbeans.io.chat.models.SecreteKeyModel;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SecreteKeyDao_Impl implements SecreteKeyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SecreteKeyModel> __insertionAdapterOfSecreteKeyModel;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePreviousSIR;

  private final SharedSQLiteStatement __preparedStmtOfDeleteKey;

  public SecreteKeyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSecreteKeyModel = new EntityInsertionAdapter<SecreteKeyModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `SecreteKeyModel` (`id`,`secreteKey`,`expiry`,`isExpired`,`identifier`,`conversation_id`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SecreteKeyModel value) {
        stmt.bindLong(1, value.id);
        if (value.getSecreteKey() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindBlob(2, value.getSecreteKey());
        }
        stmt.bindLong(3, value.getExpiry());
        final int _tmp = value.getIsExpired() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getIdentifier() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIdentifier());
        }
        if (value.getConversation_id() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getConversation_id());
        }
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE SecreteKeyModel SET isExpired = 1 WHERE secreteKey = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePreviousSIR = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE SecreteKeyModel SET isExpired = 1 WHERE conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from SecreteKeyModel where secreteKey=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final SecreteKeyModel SecreteKeyModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSecreteKeyModel.insert(SecreteKeyModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final byte[] secreteKey) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    if (secreteKey == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, secreteKey);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public void updatePreviousSIR(final String conId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePreviousSIR.acquire();
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
      __preparedStmtOfUpdatePreviousSIR.release(_stmt);
    }
  }

  @Override
  public void deleteKey(final byte[] secreteKey) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteKey.acquire();
    int _argIndex = 1;
    if (secreteKey == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, secreteKey);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteKey.release(_stmt);
    }
  }

  @Override
  public SecreteKeyModel getByte(final byte[] secreteKey) {
    final String _sql = "Select * From SecreteKeyModel where secreteKey=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (secreteKey == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindBlob(_argIndex, secreteKey);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSecreteKey = CursorUtil.getColumnIndexOrThrow(_cursor, "secreteKey");
      final int _cursorIndexOfExpiry = CursorUtil.getColumnIndexOrThrow(_cursor, "expiry");
      final int _cursorIndexOfIsExpired = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpired");
      final int _cursorIndexOfIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "identifier");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversation_id");
      final SecreteKeyModel _result;
      if(_cursor.moveToFirst()) {
        _result = new SecreteKeyModel();
        _result.id = _cursor.getInt(_cursorIndexOfId);
        final byte[] _tmpSecreteKey;
        if (_cursor.isNull(_cursorIndexOfSecreteKey)) {
          _tmpSecreteKey = null;
        } else {
          _tmpSecreteKey = _cursor.getBlob(_cursorIndexOfSecreteKey);
        }
        _result.setSecreteKey(_tmpSecreteKey);
        final long _tmpExpiry;
        _tmpExpiry = _cursor.getLong(_cursorIndexOfExpiry);
        _result.setExpiry(_tmpExpiry);
        final boolean _tmpIsExpired;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsExpired);
        _tmpIsExpired = _tmp != 0;
        _result.setIsExpired(_tmpIsExpired);
        final String _tmpIdentifier;
        if (_cursor.isNull(_cursorIndexOfIdentifier)) {
          _tmpIdentifier = null;
        } else {
          _tmpIdentifier = _cursor.getString(_cursorIndexOfIdentifier);
        }
        _result.setIdentifier(_tmpIdentifier);
        final String _tmpConversation_id;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversation_id = null;
        } else {
          _tmpConversation_id = _cursor.getString(_cursorIndexOfConversationId);
        }
        _result.setConversation_id(_tmpConversation_id);
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
  public List<SecreteKeyModel> allKeysforConversation(final String conId) {
    final String _sql = "SELECT * FROM SecreteKeyModel where isExpired LIKE 0 and conversation_id like ?";
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
      final int _cursorIndexOfSecreteKey = CursorUtil.getColumnIndexOrThrow(_cursor, "secreteKey");
      final int _cursorIndexOfExpiry = CursorUtil.getColumnIndexOrThrow(_cursor, "expiry");
      final int _cursorIndexOfIsExpired = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpired");
      final int _cursorIndexOfIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "identifier");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversation_id");
      final List<SecreteKeyModel> _result = new ArrayList<SecreteKeyModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SecreteKeyModel _item;
        _item = new SecreteKeyModel();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        final byte[] _tmpSecreteKey;
        if (_cursor.isNull(_cursorIndexOfSecreteKey)) {
          _tmpSecreteKey = null;
        } else {
          _tmpSecreteKey = _cursor.getBlob(_cursorIndexOfSecreteKey);
        }
        _item.setSecreteKey(_tmpSecreteKey);
        final long _tmpExpiry;
        _tmpExpiry = _cursor.getLong(_cursorIndexOfExpiry);
        _item.setExpiry(_tmpExpiry);
        final boolean _tmpIsExpired;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsExpired);
        _tmpIsExpired = _tmp != 0;
        _item.setIsExpired(_tmpIsExpired);
        final String _tmpIdentifier;
        if (_cursor.isNull(_cursorIndexOfIdentifier)) {
          _tmpIdentifier = null;
        } else {
          _tmpIdentifier = _cursor.getString(_cursorIndexOfIdentifier);
        }
        _item.setIdentifier(_tmpIdentifier);
        final String _tmpConversation_id;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversation_id = null;
        } else {
          _tmpConversation_id = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversation_id(_tmpConversation_id);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SecreteKeyModel> getAllKeys() {
    final String _sql = "SELECT * FROM SecreteKeyModel where isExpired LIKE 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSecreteKey = CursorUtil.getColumnIndexOrThrow(_cursor, "secreteKey");
      final int _cursorIndexOfExpiry = CursorUtil.getColumnIndexOrThrow(_cursor, "expiry");
      final int _cursorIndexOfIsExpired = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpired");
      final int _cursorIndexOfIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "identifier");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversation_id");
      final List<SecreteKeyModel> _result = new ArrayList<SecreteKeyModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SecreteKeyModel _item;
        _item = new SecreteKeyModel();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        final byte[] _tmpSecreteKey;
        if (_cursor.isNull(_cursorIndexOfSecreteKey)) {
          _tmpSecreteKey = null;
        } else {
          _tmpSecreteKey = _cursor.getBlob(_cursorIndexOfSecreteKey);
        }
        _item.setSecreteKey(_tmpSecreteKey);
        final long _tmpExpiry;
        _tmpExpiry = _cursor.getLong(_cursorIndexOfExpiry);
        _item.setExpiry(_tmpExpiry);
        final boolean _tmpIsExpired;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsExpired);
        _tmpIsExpired = _tmp != 0;
        _item.setIsExpired(_tmpIsExpired);
        final String _tmpIdentifier;
        if (_cursor.isNull(_cursorIndexOfIdentifier)) {
          _tmpIdentifier = null;
        } else {
          _tmpIdentifier = _cursor.getString(_cursorIndexOfIdentifier);
        }
        _item.setIdentifier(_tmpIdentifier);
        final String _tmpConversation_id;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversation_id = null;
        } else {
          _tmpConversation_id = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversation_id(_tmpConversation_id);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SecreteKeyModel getKey(final String identifier) {
    final String _sql = "SELECT * FROM SecreteKeyModel where identifier LIKE ?";
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
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSecreteKey = CursorUtil.getColumnIndexOrThrow(_cursor, "secreteKey");
      final int _cursorIndexOfExpiry = CursorUtil.getColumnIndexOrThrow(_cursor, "expiry");
      final int _cursorIndexOfIsExpired = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpired");
      final int _cursorIndexOfIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "identifier");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversation_id");
      final SecreteKeyModel _result;
      if(_cursor.moveToFirst()) {
        _result = new SecreteKeyModel();
        _result.id = _cursor.getInt(_cursorIndexOfId);
        final byte[] _tmpSecreteKey;
        if (_cursor.isNull(_cursorIndexOfSecreteKey)) {
          _tmpSecreteKey = null;
        } else {
          _tmpSecreteKey = _cursor.getBlob(_cursorIndexOfSecreteKey);
        }
        _result.setSecreteKey(_tmpSecreteKey);
        final long _tmpExpiry;
        _tmpExpiry = _cursor.getLong(_cursorIndexOfExpiry);
        _result.setExpiry(_tmpExpiry);
        final boolean _tmpIsExpired;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsExpired);
        _tmpIsExpired = _tmp != 0;
        _result.setIsExpired(_tmpIsExpired);
        final String _tmpIdentifier;
        if (_cursor.isNull(_cursorIndexOfIdentifier)) {
          _tmpIdentifier = null;
        } else {
          _tmpIdentifier = _cursor.getString(_cursorIndexOfIdentifier);
        }
        _result.setIdentifier(_tmpIdentifier);
        final String _tmpConversation_id;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversation_id = null;
        } else {
          _tmpConversation_id = _cursor.getString(_cursorIndexOfConversationId);
        }
        _result.setConversation_id(_tmpConversation_id);
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
