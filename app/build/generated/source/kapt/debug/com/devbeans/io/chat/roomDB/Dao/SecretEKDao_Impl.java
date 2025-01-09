package com.devbeans.io.chat.roomDB.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.devbeans.io.chat.encryption.EK;
import com.devbeans.io.chat.encryption.SecretEk;
import com.devbeans.io.chat.roomDB.TypeConverters.EKConverter;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SecretEKDao_Impl implements SecretEKDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SecretEk> __insertionAdapterOfSecretEk;

  private final EKConverter __eKConverter = new EKConverter();

  public SecretEKDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSecretEk = new EntityInsertionAdapter<SecretEk>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `secret_e_k` (`secret_key_identifier`,`channel_identifier`,`ek`,`type`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SecretEk value) {
        if (value.getSecret_key_identifier() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSecret_key_identifier());
        }
        if (value.getChannel_identifier() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChannel_identifier());
        }
        final String _tmp = __eKConverter.EkToJson(value.getEk());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        if (value.getType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insert(final SecretEk ek) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSecretEk.insert(ek);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public boolean exist(final String identifier) {
    final String _sql = "SELECT EXISTS(SELECT * FROM secret_e_k WHERE secret_key_identifier = ?)";
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
  public List<SecretEk> getAllDhKeys(final String identifier) {
    final String _sql = "SELECT * FROM secret_e_k WHERE channel_identifier = ? and type like 'DH'";
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
      final int _cursorIndexOfSecretKeyIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "secret_key_identifier");
      final int _cursorIndexOfChannelIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "channel_identifier");
      final int _cursorIndexOfEk = CursorUtil.getColumnIndexOrThrow(_cursor, "ek");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<SecretEk> _result = new ArrayList<SecretEk>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SecretEk _item;
        final String _tmpSecret_key_identifier;
        if (_cursor.isNull(_cursorIndexOfSecretKeyIdentifier)) {
          _tmpSecret_key_identifier = null;
        } else {
          _tmpSecret_key_identifier = _cursor.getString(_cursorIndexOfSecretKeyIdentifier);
        }
        final String _tmpChannel_identifier;
        if (_cursor.isNull(_cursorIndexOfChannelIdentifier)) {
          _tmpChannel_identifier = null;
        } else {
          _tmpChannel_identifier = _cursor.getString(_cursorIndexOfChannelIdentifier);
        }
        final EK _tmpEk;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfEk)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfEk);
        }
        _tmpEk = __eKConverter.JsonToEK(_tmp);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _item = new SecretEk(_tmpSecret_key_identifier,_tmpChannel_identifier,_tmpEk,_tmpType);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SecretEk getEk(final String identifier) {
    final String _sql = "SELECT * FROM secret_e_k WHERE secret_key_identifier LIKE ?";
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
      final int _cursorIndexOfSecretKeyIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "secret_key_identifier");
      final int _cursorIndexOfChannelIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "channel_identifier");
      final int _cursorIndexOfEk = CursorUtil.getColumnIndexOrThrow(_cursor, "ek");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final SecretEk _result;
      if(_cursor.moveToFirst()) {
        final String _tmpSecret_key_identifier;
        if (_cursor.isNull(_cursorIndexOfSecretKeyIdentifier)) {
          _tmpSecret_key_identifier = null;
        } else {
          _tmpSecret_key_identifier = _cursor.getString(_cursorIndexOfSecretKeyIdentifier);
        }
        final String _tmpChannel_identifier;
        if (_cursor.isNull(_cursorIndexOfChannelIdentifier)) {
          _tmpChannel_identifier = null;
        } else {
          _tmpChannel_identifier = _cursor.getString(_cursorIndexOfChannelIdentifier);
        }
        final EK _tmpEk;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfEk)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfEk);
        }
        _tmpEk = __eKConverter.JsonToEK(_tmp);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _result = new SecretEk(_tmpSecret_key_identifier,_tmpChannel_identifier,_tmpEk,_tmpType);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
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
