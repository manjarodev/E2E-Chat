package com.devbeans.io.chat.roomDB.Dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.devbeans.io.chat.models.KeyModel;
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
public final class KeyPairDao_Impl implements KeyPairDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<KeyModel> __insertionAdapterOfKeyModel;

  private final EntityDeletionOrUpdateAdapter<KeyModel> __deletionAdapterOfKeyModel;

  public KeyPairDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKeyModel = new EntityInsertionAdapter<KeyModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `KeyModel` (`id`,`fingerprint`,`publicKeyPath`,`privateKeyPath`,`identifer`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KeyModel value) {
        stmt.bindLong(1, value.id);
        if (value.getFingerprint() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFingerprint());
        }
        if (value.getPublicKeyPath() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPublicKeyPath());
        }
        if (value.getPrivateKeyPath() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPrivateKeyPath());
        }
        if (value.getIdentifer() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindBlob(5, value.getIdentifer());
        }
      }
    };
    this.__deletionAdapterOfKeyModel = new EntityDeletionOrUpdateAdapter<KeyModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `KeyModel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KeyModel value) {
        stmt.bindLong(1, value.id);
      }
    };
  }

  @Override
  public void insert(final KeyModel keymodel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfKeyModel.insert(keymodel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final ArrayList<KeyModel> arrayList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfKeyModel.insert(arrayList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final KeyModel keymodel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfKeyModel.handle(keymodel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<KeyModel>> getLiveALLKeys() {
    final String _sql = "SELECT * FROM keymodel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"keymodel"}, false, new Callable<List<KeyModel>>() {
      @Override
      public List<KeyModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint");
          final int _cursorIndexOfPublicKeyPath = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKeyPath");
          final int _cursorIndexOfPrivateKeyPath = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKeyPath");
          final int _cursorIndexOfIdentifer = CursorUtil.getColumnIndexOrThrow(_cursor, "identifer");
          final List<KeyModel> _result = new ArrayList<KeyModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final KeyModel _item;
            _item = new KeyModel();
            _item.id = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFingerprint;
            if (_cursor.isNull(_cursorIndexOfFingerprint)) {
              _tmpFingerprint = null;
            } else {
              _tmpFingerprint = _cursor.getString(_cursorIndexOfFingerprint);
            }
            _item.setFingerprint(_tmpFingerprint);
            final String _tmpPublicKeyPath;
            if (_cursor.isNull(_cursorIndexOfPublicKeyPath)) {
              _tmpPublicKeyPath = null;
            } else {
              _tmpPublicKeyPath = _cursor.getString(_cursorIndexOfPublicKeyPath);
            }
            _item.setPublicKeyPath(_tmpPublicKeyPath);
            final String _tmpPrivateKeyPath;
            if (_cursor.isNull(_cursorIndexOfPrivateKeyPath)) {
              _tmpPrivateKeyPath = null;
            } else {
              _tmpPrivateKeyPath = _cursor.getString(_cursorIndexOfPrivateKeyPath);
            }
            _item.setPrivateKeyPath(_tmpPrivateKeyPath);
            final byte[] _tmpIdentifer;
            if (_cursor.isNull(_cursorIndexOfIdentifer)) {
              _tmpIdentifer = null;
            } else {
              _tmpIdentifer = _cursor.getBlob(_cursorIndexOfIdentifer);
            }
            _item.setIdentifer(_tmpIdentifer);
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
  public List<KeyModel> getAllKeys() {
    final String _sql = "SELECT * FROM keymodel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint");
      final int _cursorIndexOfPublicKeyPath = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKeyPath");
      final int _cursorIndexOfPrivateKeyPath = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKeyPath");
      final int _cursorIndexOfIdentifer = CursorUtil.getColumnIndexOrThrow(_cursor, "identifer");
      final List<KeyModel> _result = new ArrayList<KeyModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KeyModel _item;
        _item = new KeyModel();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        final String _tmpFingerprint;
        if (_cursor.isNull(_cursorIndexOfFingerprint)) {
          _tmpFingerprint = null;
        } else {
          _tmpFingerprint = _cursor.getString(_cursorIndexOfFingerprint);
        }
        _item.setFingerprint(_tmpFingerprint);
        final String _tmpPublicKeyPath;
        if (_cursor.isNull(_cursorIndexOfPublicKeyPath)) {
          _tmpPublicKeyPath = null;
        } else {
          _tmpPublicKeyPath = _cursor.getString(_cursorIndexOfPublicKeyPath);
        }
        _item.setPublicKeyPath(_tmpPublicKeyPath);
        final String _tmpPrivateKeyPath;
        if (_cursor.isNull(_cursorIndexOfPrivateKeyPath)) {
          _tmpPrivateKeyPath = null;
        } else {
          _tmpPrivateKeyPath = _cursor.getString(_cursorIndexOfPrivateKeyPath);
        }
        _item.setPrivateKeyPath(_tmpPrivateKeyPath);
        final byte[] _tmpIdentifer;
        if (_cursor.isNull(_cursorIndexOfIdentifer)) {
          _tmpIdentifer = null;
        } else {
          _tmpIdentifer = _cursor.getBlob(_cursorIndexOfIdentifer);
        }
        _item.setIdentifer(_tmpIdentifer);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public KeyModel getContact(final byte[] identifier) {
    final String _sql = "SELECT * FROM keymodel WHERE identifer LIKE ?";
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
      final int _cursorIndexOfFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "fingerprint");
      final int _cursorIndexOfPublicKeyPath = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKeyPath");
      final int _cursorIndexOfPrivateKeyPath = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKeyPath");
      final int _cursorIndexOfIdentifer = CursorUtil.getColumnIndexOrThrow(_cursor, "identifer");
      final KeyModel _result;
      if(_cursor.moveToFirst()) {
        _result = new KeyModel();
        _result.id = _cursor.getInt(_cursorIndexOfId);
        final String _tmpFingerprint;
        if (_cursor.isNull(_cursorIndexOfFingerprint)) {
          _tmpFingerprint = null;
        } else {
          _tmpFingerprint = _cursor.getString(_cursorIndexOfFingerprint);
        }
        _result.setFingerprint(_tmpFingerprint);
        final String _tmpPublicKeyPath;
        if (_cursor.isNull(_cursorIndexOfPublicKeyPath)) {
          _tmpPublicKeyPath = null;
        } else {
          _tmpPublicKeyPath = _cursor.getString(_cursorIndexOfPublicKeyPath);
        }
        _result.setPublicKeyPath(_tmpPublicKeyPath);
        final String _tmpPrivateKeyPath;
        if (_cursor.isNull(_cursorIndexOfPrivateKeyPath)) {
          _tmpPrivateKeyPath = null;
        } else {
          _tmpPrivateKeyPath = _cursor.getString(_cursorIndexOfPrivateKeyPath);
        }
        _result.setPrivateKeyPath(_tmpPrivateKeyPath);
        final byte[] _tmpIdentifer;
        if (_cursor.isNull(_cursorIndexOfIdentifer)) {
          _tmpIdentifer = null;
        } else {
          _tmpIdentifer = _cursor.getBlob(_cursorIndexOfIdentifer);
        }
        _result.setIdentifer(_tmpIdentifer);
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
