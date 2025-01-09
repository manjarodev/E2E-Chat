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
import com.devbeans.io.chat.models.OfflineAck;
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.roomDB.TypeConverters.PayloadTypeConverter;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OfflineAckDao_Impl implements OfflineAckDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OfflineAck> __insertionAdapterOfOfflineAck;

  private final EntityDeletionOrUpdateAdapter<OfflineAck> __updateAdapterOfOfflineAck;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAckById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateOfflineAck;

  public OfflineAckDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOfflineAck = new EntityInsertionAdapter<OfflineAck>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `offlineAck` (`id`,`offlineAckId`,`payload`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OfflineAck value) {
        stmt.bindLong(1, value.getId());
        if (value.getOfflineAckId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOfflineAckId());
        }
        final String _tmp = PayloadTypeConverter.PayloadToJson(value.getPayload());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
      }
    };
    this.__updateAdapterOfOfflineAck = new EntityDeletionOrUpdateAdapter<OfflineAck>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `offlineAck` SET `id` = ?,`offlineAckId` = ?,`payload` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OfflineAck value) {
        stmt.bindLong(1, value.getId());
        if (value.getOfflineAckId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOfflineAckId());
        }
        final String _tmp = PayloadTypeConverter.PayloadToJson(value.getPayload());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        stmt.bindLong(4, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAckById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM offlineAck WHERE offlineAckId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateOfflineAck = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE offlineAck SET payload = ? WHERE offlineAckId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final OfflineAck offlineAck) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOfflineAck.insert(offlineAck);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAck(final OfflineAck offlineAck) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfOfflineAck.handle(offlineAck);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAckById(final String identifier) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAckById.acquire();
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
      __preparedStmtOfDeleteAckById.release(_stmt);
    }
  }

  @Override
  public int updateOfflineAck(final String identifier, final Payload payload) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateOfflineAck.acquire();
    int _argIndex = 1;
    final String _tmp = PayloadTypeConverter.PayloadToJson(payload);
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
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateOfflineAck.release(_stmt);
    }
  }

  @Override
  public boolean exist(final String identifier) {
    final String _sql = "SELECT EXISTS(SELECT * FROM offlineAck WHERE offlineAckId = ?)";
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
  public List<OfflineAck> getAllAck() {
    final String _sql = "SELECT * FROM offlineAck ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOfflineAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "offlineAckId");
      final int _cursorIndexOfPayload = CursorUtil.getColumnIndexOrThrow(_cursor, "payload");
      final List<OfflineAck> _result = new ArrayList<OfflineAck>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OfflineAck _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpOfflineAckId;
        if (_cursor.isNull(_cursorIndexOfOfflineAckId)) {
          _tmpOfflineAckId = null;
        } else {
          _tmpOfflineAckId = _cursor.getString(_cursorIndexOfOfflineAckId);
        }
        final Payload _tmpPayload;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfPayload)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfPayload);
        }
        _tmpPayload = PayloadTypeConverter.JsonToPayload(_tmp);
        _item = new OfflineAck(_tmpId,_tmpOfflineAckId,_tmpPayload);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public OfflineAck getOfflineAck(final String identifier) {
    final String _sql = "SELECT * FROM offlineAck WHERE offlineAckId LIKE ?";
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
      final int _cursorIndexOfOfflineAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "offlineAckId");
      final int _cursorIndexOfPayload = CursorUtil.getColumnIndexOrThrow(_cursor, "payload");
      final OfflineAck _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpOfflineAckId;
        if (_cursor.isNull(_cursorIndexOfOfflineAckId)) {
          _tmpOfflineAckId = null;
        } else {
          _tmpOfflineAckId = _cursor.getString(_cursorIndexOfOfflineAckId);
        }
        final Payload _tmpPayload;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfPayload)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfPayload);
        }
        _tmpPayload = PayloadTypeConverter.JsonToPayload(_tmp);
        _result = new OfflineAck(_tmpId,_tmpOfflineAckId,_tmpPayload);
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
