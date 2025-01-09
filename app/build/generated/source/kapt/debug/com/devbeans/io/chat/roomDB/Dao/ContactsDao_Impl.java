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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.devbeans.io.chat.models.Contact;
import com.devbeans.io.chat.utils.avatar.AvatarColor;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ContactsDao_Impl implements ContactsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Contact> __insertionAdapterOfContact;

  private final EntityDeletionOrUpdateAdapter<Contact> __deletionAdapterOfContact;

  private final SharedSQLiteStatement __preparedStmtOfUpdateContactName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBlock;

  private final SharedSQLiteStatement __preparedStmtOfDeleteContactByChatUserId;

  public ContactsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContact = new EntityInsertionAdapter<Contact>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Contact` (`id`,`name`,`chatUserId`,`image`,`color`,`isChecked`,`avatarColor`,`alias`,`isBlocked`,`isQrAdded`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Contact value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getChatUserId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getChatUserId());
        }
        if (value.getImage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImage());
        }
        if (value.getColor() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getColor());
        }
        final int _tmp = value.isChecked() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getAvatarColor() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, __AvatarColor_enumToString(value.getAvatarColor()));
        }
        if (value.getAlias() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAlias());
        }
        final int _tmp_1 = value.isBlocked() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
        final int _tmp_2 = value.isQrAdded() ? 1 : 0;
        stmt.bindLong(10, _tmp_2);
      }
    };
    this.__deletionAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Contact` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Contact value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfUpdateContactName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update contact set name=? where chatUserId=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBlock = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update contact set isBlocked= ? where chatUserId like ? ";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteContactByChatUserId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Contact WHERE chatUserId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Contact contact) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfContact.insert(contact);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Contact contact) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfContact.handle(contact);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateContactName(final String chatUserId, final String contactName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateContactName.acquire();
    int _argIndex = 1;
    if (contactName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, contactName);
    }
    _argIndex = 2;
    if (chatUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatUserId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateContactName.release(_stmt);
    }
  }

  @Override
  public void updateBlock(final String chatUserId, final boolean check) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBlock.acquire();
    int _argIndex = 1;
    final int _tmp = check ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    if (chatUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatUserId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBlock.release(_stmt);
    }
  }

  @Override
  public void deleteContactByChatUserId(final String chatUserId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteContactByChatUserId.acquire();
    int _argIndex = 1;
    if (chatUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatUserId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteContactByChatUserId.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Contact>> getLiveContacts() {
    final String _sql = "SELECT * FROM contact";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"contact"}, false, new Callable<List<Contact>>() {
      @Override
      public List<Contact> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfChatUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatUserId");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
          final int _cursorIndexOfAvatarColor = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarColor");
          final int _cursorIndexOfAlias = CursorUtil.getColumnIndexOrThrow(_cursor, "alias");
          final int _cursorIndexOfIsBlocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBlocked");
          final int _cursorIndexOfIsQrAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "isQrAdded");
          final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Contact _item;
            _item = new Contact();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item.setName(_tmpName);
            final String _tmpChatUserId;
            if (_cursor.isNull(_cursorIndexOfChatUserId)) {
              _tmpChatUserId = null;
            } else {
              _tmpChatUserId = _cursor.getString(_cursorIndexOfChatUserId);
            }
            _item.setChatUserId(_tmpChatUserId);
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            _item.setImage(_tmpImage);
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            _item.setColor(_tmpColor);
            final boolean _tmpIsChecked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp != 0;
            _item.setChecked(_tmpIsChecked);
            final AvatarColor _tmpAvatarColor;
            _tmpAvatarColor = __AvatarColor_stringToEnum(_cursor.getString(_cursorIndexOfAvatarColor));
            _item.setAvatarColor(_tmpAvatarColor);
            final String _tmpAlias;
            if (_cursor.isNull(_cursorIndexOfAlias)) {
              _tmpAlias = null;
            } else {
              _tmpAlias = _cursor.getString(_cursorIndexOfAlias);
            }
            _item.setAlias(_tmpAlias);
            final boolean _tmpIsBlocked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsBlocked);
            _tmpIsBlocked = _tmp_1 != 0;
            _item.setBlocked(_tmpIsBlocked);
            final boolean _tmpIsQrAdded;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsQrAdded);
            _tmpIsQrAdded = _tmp_2 != 0;
            _item.setQrAdded(_tmpIsQrAdded);
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
  public List<Contact> getAllContacts() {
    final String _sql = "SELECT * FROM contact";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfChatUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatUserId");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfAvatarColor = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarColor");
      final int _cursorIndexOfAlias = CursorUtil.getColumnIndexOrThrow(_cursor, "alias");
      final int _cursorIndexOfIsBlocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBlocked");
      final int _cursorIndexOfIsQrAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "isQrAdded");
      final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Contact _item;
        _item = new Contact();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpChatUserId;
        if (_cursor.isNull(_cursorIndexOfChatUserId)) {
          _tmpChatUserId = null;
        } else {
          _tmpChatUserId = _cursor.getString(_cursorIndexOfChatUserId);
        }
        _item.setChatUserId(_tmpChatUserId);
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        _item.setImage(_tmpImage);
        final String _tmpColor;
        if (_cursor.isNull(_cursorIndexOfColor)) {
          _tmpColor = null;
        } else {
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
        }
        _item.setColor(_tmpColor);
        final boolean _tmpIsChecked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp != 0;
        _item.setChecked(_tmpIsChecked);
        final AvatarColor _tmpAvatarColor;
        _tmpAvatarColor = __AvatarColor_stringToEnum(_cursor.getString(_cursorIndexOfAvatarColor));
        _item.setAvatarColor(_tmpAvatarColor);
        final String _tmpAlias;
        if (_cursor.isNull(_cursorIndexOfAlias)) {
          _tmpAlias = null;
        } else {
          _tmpAlias = _cursor.getString(_cursorIndexOfAlias);
        }
        _item.setAlias(_tmpAlias);
        final boolean _tmpIsBlocked;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsBlocked);
        _tmpIsBlocked = _tmp_1 != 0;
        _item.setBlocked(_tmpIsBlocked);
        final boolean _tmpIsQrAdded;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsQrAdded);
        _tmpIsQrAdded = _tmp_2 != 0;
        _item.setQrAdded(_tmpIsQrAdded);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Contact> getAllUnBlockedContacts() {
    final String _sql = "SELECT * FROM contact where isBlocked=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfChatUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatUserId");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfAvatarColor = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarColor");
      final int _cursorIndexOfAlias = CursorUtil.getColumnIndexOrThrow(_cursor, "alias");
      final int _cursorIndexOfIsBlocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBlocked");
      final int _cursorIndexOfIsQrAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "isQrAdded");
      final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Contact _item;
        _item = new Contact();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpChatUserId;
        if (_cursor.isNull(_cursorIndexOfChatUserId)) {
          _tmpChatUserId = null;
        } else {
          _tmpChatUserId = _cursor.getString(_cursorIndexOfChatUserId);
        }
        _item.setChatUserId(_tmpChatUserId);
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        _item.setImage(_tmpImage);
        final String _tmpColor;
        if (_cursor.isNull(_cursorIndexOfColor)) {
          _tmpColor = null;
        } else {
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
        }
        _item.setColor(_tmpColor);
        final boolean _tmpIsChecked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp != 0;
        _item.setChecked(_tmpIsChecked);
        final AvatarColor _tmpAvatarColor;
        _tmpAvatarColor = __AvatarColor_stringToEnum(_cursor.getString(_cursorIndexOfAvatarColor));
        _item.setAvatarColor(_tmpAvatarColor);
        final String _tmpAlias;
        if (_cursor.isNull(_cursorIndexOfAlias)) {
          _tmpAlias = null;
        } else {
          _tmpAlias = _cursor.getString(_cursorIndexOfAlias);
        }
        _item.setAlias(_tmpAlias);
        final boolean _tmpIsBlocked;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsBlocked);
        _tmpIsBlocked = _tmp_1 != 0;
        _item.setBlocked(_tmpIsBlocked);
        final boolean _tmpIsQrAdded;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsQrAdded);
        _tmpIsQrAdded = _tmp_2 != 0;
        _item.setQrAdded(_tmpIsQrAdded);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Contact getContact(final String chatUserId) {
    final String _sql = "SELECT * FROM contact WHERE chatuserid LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatUserId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfChatUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatUserId");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfAvatarColor = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarColor");
      final int _cursorIndexOfAlias = CursorUtil.getColumnIndexOrThrow(_cursor, "alias");
      final int _cursorIndexOfIsBlocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBlocked");
      final int _cursorIndexOfIsQrAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "isQrAdded");
      final Contact _result;
      if(_cursor.moveToFirst()) {
        _result = new Contact();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpChatUserId;
        if (_cursor.isNull(_cursorIndexOfChatUserId)) {
          _tmpChatUserId = null;
        } else {
          _tmpChatUserId = _cursor.getString(_cursorIndexOfChatUserId);
        }
        _result.setChatUserId(_tmpChatUserId);
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        _result.setImage(_tmpImage);
        final String _tmpColor;
        if (_cursor.isNull(_cursorIndexOfColor)) {
          _tmpColor = null;
        } else {
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
        }
        _result.setColor(_tmpColor);
        final boolean _tmpIsChecked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp != 0;
        _result.setChecked(_tmpIsChecked);
        final AvatarColor _tmpAvatarColor;
        _tmpAvatarColor = __AvatarColor_stringToEnum(_cursor.getString(_cursorIndexOfAvatarColor));
        _result.setAvatarColor(_tmpAvatarColor);
        final String _tmpAlias;
        if (_cursor.isNull(_cursorIndexOfAlias)) {
          _tmpAlias = null;
        } else {
          _tmpAlias = _cursor.getString(_cursorIndexOfAlias);
        }
        _result.setAlias(_tmpAlias);
        final boolean _tmpIsBlocked;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsBlocked);
        _tmpIsBlocked = _tmp_1 != 0;
        _result.setBlocked(_tmpIsBlocked);
        final boolean _tmpIsQrAdded;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsQrAdded);
        _tmpIsQrAdded = _tmp_2 != 0;
        _result.setQrAdded(_tmpIsQrAdded);
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
  public void deleteContactsByChatUserIds(final List<String> chatUserIds) {
    __db.assertNotSuspendingTransaction();
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("DELETE FROM Contact WHERE chatUserId IN (");
    final int _inputSize = chatUserIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
    int _argIndex = 1;
    for (String _item : chatUserIds) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __AvatarColor_enumToString(final AvatarColor _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case A100: return "A100";
      case A110: return "A110";
      case A120: return "A120";
      case A130: return "A130";
      case A140: return "A140";
      case A150: return "A150";
      case A160: return "A160";
      case A170: return "A170";
      case A180: return "A180";
      case A190: return "A190";
      case A200: return "A200";
      case A210: return "A210";
      case A212: return "A212";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private AvatarColor __AvatarColor_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "A100": return AvatarColor.A100;
      case "A110": return AvatarColor.A110;
      case "A120": return AvatarColor.A120;
      case "A130": return AvatarColor.A130;
      case "A140": return AvatarColor.A140;
      case "A150": return AvatarColor.A150;
      case "A160": return AvatarColor.A160;
      case "A170": return AvatarColor.A170;
      case "A180": return AvatarColor.A180;
      case "A190": return AvatarColor.A190;
      case "A200": return AvatarColor.A200;
      case "A210": return AvatarColor.A210;
      case "A212": return AvatarColor.A212;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
