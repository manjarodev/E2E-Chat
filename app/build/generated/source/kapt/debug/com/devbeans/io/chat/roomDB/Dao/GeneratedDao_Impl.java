package com.devbeans.io.chat.roomDB.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.devbeans.io.chat.models.GeneratedPrivateKeyByte;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GeneratedDao_Impl implements GeneratedDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GeneratedPrivateKeyByte> __insertionAdapterOfGeneratedPrivateKeyByte;

  private final SharedSQLiteStatement __preparedStmtOfInsertKey;

  private final SharedSQLiteStatement __preparedStmtOfInsertidentiferKey;

  private final SharedSQLiteStatement __preparedStmtOfInsertpubKey;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePrivateKey;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePublicKey;

  public GeneratedDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGeneratedPrivateKeyByte = new EntityInsertionAdapter<GeneratedPrivateKeyByte>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `GeneratedPrivateKeyByte` (`id`,`privateKeyByte`,`identifier`,`pubPrivateKeyByte`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GeneratedPrivateKeyByte value) {
        stmt.bindLong(1, value.getId());
        if (value.getPrivateKeyByte() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindBlob(2, value.getPrivateKeyByte());
        }
        if (value.getIdentifier() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindBlob(3, value.getIdentifier());
        }
        if (value.getPubPrivateKeyByte() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindBlob(4, value.getPubPrivateKeyByte());
        }
      }
    };
    this.__preparedStmtOfInsertKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "insert into generatedprivatekeybyte (privateKeyByte) values (?) ";
        return _query;
      }
    };
    this.__preparedStmtOfInsertidentiferKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "insert into generatedprivatekeybyte (identifier) values (?) ";
        return _query;
      }
    };
    this.__preparedStmtOfInsertpubKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "insert into generatedprivatekeybyte (pubPrivateKeyByte) values (?) ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePrivateKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update generatedprivatekeybyte set privateKeyByte=? where identifier=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePublicKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update generatedprivatekeybyte set pubPrivateKeyByte=? where identifier=?";
        return _query;
      }
    };
  }

  @Override
  public void insertKeys(final GeneratedPrivateKeyByte generatedPrivateKeyByte) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGeneratedPrivateKeyByte.insert(generatedPrivateKeyByte);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertKey(final byte[] privateKey) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertKey.acquire();
    int _argIndex = 1;
    if (privateKey == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, privateKey);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertKey.release(_stmt);
    }
  }

  @Override
  public void insertidentiferKey(final byte[] identifer) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertidentiferKey.acquire();
    int _argIndex = 1;
    if (identifer == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, identifer);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertidentiferKey.release(_stmt);
    }
  }

  @Override
  public void insertpubKey(final byte[] pub) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertpubKey.acquire();
    int _argIndex = 1;
    if (pub == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, pub);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertpubKey.release(_stmt);
    }
  }

  @Override
  public void updatePrivateKey(final byte[] identifier, final byte[] privateKey) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePrivateKey.acquire();
    int _argIndex = 1;
    if (privateKey == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, privateKey);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdatePrivateKey.release(_stmt);
    }
  }

  @Override
  public void updatePublicKey(final byte[] identifier, final byte[] publicKeys) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePublicKey.acquire();
    int _argIndex = 1;
    if (publicKeys == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, publicKeys);
    }
    _argIndex = 2;
    if (identifier == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindBlob(_argIndex, identifier);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdatePublicKey.release(_stmt);
    }
  }

  @Override
  public GeneratedPrivateKeyByte getKeys(final byte[] identifier) {
    final String _sql = "select * from generatedprivatekeybyte where identifier=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (identifier == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindBlob(_argIndex, identifier);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrivateKeyByte = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKeyByte");
      final int _cursorIndexOfIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "identifier");
      final int _cursorIndexOfPubPrivateKeyByte = CursorUtil.getColumnIndexOrThrow(_cursor, "pubPrivateKeyByte");
      final GeneratedPrivateKeyByte _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final byte[] _tmpPrivateKeyByte;
        if (_cursor.isNull(_cursorIndexOfPrivateKeyByte)) {
          _tmpPrivateKeyByte = null;
        } else {
          _tmpPrivateKeyByte = _cursor.getBlob(_cursorIndexOfPrivateKeyByte);
        }
        final byte[] _tmpIdentifier;
        if (_cursor.isNull(_cursorIndexOfIdentifier)) {
          _tmpIdentifier = null;
        } else {
          _tmpIdentifier = _cursor.getBlob(_cursorIndexOfIdentifier);
        }
        final byte[] _tmpPubPrivateKeyByte;
        if (_cursor.isNull(_cursorIndexOfPubPrivateKeyByte)) {
          _tmpPubPrivateKeyByte = null;
        } else {
          _tmpPubPrivateKeyByte = _cursor.getBlob(_cursorIndexOfPubPrivateKeyByte);
        }
        _result = new GeneratedPrivateKeyByte(_tmpId,_tmpPrivateKeyByte,_tmpIdentifier,_tmpPubPrivateKeyByte);
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
  public List<GeneratedPrivateKeyByte> getAllKeys() {
    final String _sql = "SELECT * FROM generatedprivatekeybyte";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrivateKeyByte = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKeyByte");
      final int _cursorIndexOfIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "identifier");
      final int _cursorIndexOfPubPrivateKeyByte = CursorUtil.getColumnIndexOrThrow(_cursor, "pubPrivateKeyByte");
      final List<GeneratedPrivateKeyByte> _result = new ArrayList<GeneratedPrivateKeyByte>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final GeneratedPrivateKeyByte _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final byte[] _tmpPrivateKeyByte;
        if (_cursor.isNull(_cursorIndexOfPrivateKeyByte)) {
          _tmpPrivateKeyByte = null;
        } else {
          _tmpPrivateKeyByte = _cursor.getBlob(_cursorIndexOfPrivateKeyByte);
        }
        final byte[] _tmpIdentifier;
        if (_cursor.isNull(_cursorIndexOfIdentifier)) {
          _tmpIdentifier = null;
        } else {
          _tmpIdentifier = _cursor.getBlob(_cursorIndexOfIdentifier);
        }
        final byte[] _tmpPubPrivateKeyByte;
        if (_cursor.isNull(_cursorIndexOfPubPrivateKeyByte)) {
          _tmpPubPrivateKeyByte = null;
        } else {
          _tmpPubPrivateKeyByte = _cursor.getBlob(_cursorIndexOfPubPrivateKeyByte);
        }
        _item = new GeneratedPrivateKeyByte(_tmpId,_tmpPrivateKeyByte,_tmpIdentifier,_tmpPubPrivateKeyByte);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GeneratedPrivateKeyByte getKeyID(final int id) {
    final String _sql = "Select * from generatedprivatekeybyte where id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrivateKeyByte = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKeyByte");
      final int _cursorIndexOfIdentifier = CursorUtil.getColumnIndexOrThrow(_cursor, "identifier");
      final int _cursorIndexOfPubPrivateKeyByte = CursorUtil.getColumnIndexOrThrow(_cursor, "pubPrivateKeyByte");
      final GeneratedPrivateKeyByte _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final byte[] _tmpPrivateKeyByte;
        if (_cursor.isNull(_cursorIndexOfPrivateKeyByte)) {
          _tmpPrivateKeyByte = null;
        } else {
          _tmpPrivateKeyByte = _cursor.getBlob(_cursorIndexOfPrivateKeyByte);
        }
        final byte[] _tmpIdentifier;
        if (_cursor.isNull(_cursorIndexOfIdentifier)) {
          _tmpIdentifier = null;
        } else {
          _tmpIdentifier = _cursor.getBlob(_cursorIndexOfIdentifier);
        }
        final byte[] _tmpPubPrivateKeyByte;
        if (_cursor.isNull(_cursorIndexOfPubPrivateKeyByte)) {
          _tmpPubPrivateKeyByte = null;
        } else {
          _tmpPubPrivateKeyByte = _cursor.getBlob(_cursorIndexOfPubPrivateKeyByte);
        }
        _result = new GeneratedPrivateKeyByte(_tmpId,_tmpPrivateKeyByte,_tmpIdentifier,_tmpPubPrivateKeyByte);
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
