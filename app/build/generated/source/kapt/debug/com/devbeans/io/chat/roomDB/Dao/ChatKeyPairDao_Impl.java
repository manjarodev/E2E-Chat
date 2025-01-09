package com.devbeans.io.chat.roomDB.Dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.devbeans.io.chat.models.ChatKeyPair;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatKeyPairDao_Impl implements ChatKeyPairDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChatKeyPair> __insertionAdapterOfChatKeyPair;

  private final EntityDeletionOrUpdateAdapter<ChatKeyPair> __deletionAdapterOfChatKeyPair;

  public ChatKeyPairDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChatKeyPair = new EntityInsertionAdapter<ChatKeyPair>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ChatKeyPair` (`identifier`,`id`) VALUES (?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatKeyPair value) {
        if (value.getIdentifier() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getIdentifier());
        }
        stmt.bindLong(2, value.getId());
      }
    };
    this.__deletionAdapterOfChatKeyPair = new EntityDeletionOrUpdateAdapter<ChatKeyPair>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ChatKeyPair` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatKeyPair value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insert(final ChatKeyPair chatKeyPair) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatKeyPair.insert(chatKeyPair);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final ArrayList<ChatKeyPair> arrayList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatKeyPair.insert(arrayList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ChatKeyPair chatKeyPair) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChatKeyPair.handle(chatKeyPair);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public boolean exist(final String identifier) {
    final String _sql = "SELECT EXISTS(SELECT * FROM chatkeypair WHERE identifier = ?)";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
