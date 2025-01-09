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
import com.devbeans.io.chat.models.Conversation;
import com.devbeans.io.chat.models.ConversationMember;
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.roomDB.TypeConverters.ConversationMemberListConverter;
import com.devbeans.io.chat.roomDB.TypeConverters.DeliverListConverter;
import com.devbeans.io.chat.roomDB.TypeConverters.MessagesListConverter;
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
public final class ConversationsDao_Impl implements ConversationsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Conversation> __insertionAdapterOfConversation;

  private final EntityDeletionOrUpdateAdapter<Conversation> __deletionAdapterOfConversation;

  private final EntityDeletionOrUpdateAdapter<Conversation> __updateAdapterOfConversation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTour;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFilePath;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMyMoniker;

  private final SharedSQLiteStatement __preparedStmtOfUpdateConversationName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateConversationDes;

  private final SharedSQLiteStatement __preparedStmtOfUpdateConversationIcon;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMember;

  private final SharedSQLiteStatement __preparedStmtOfUpdateName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateKeepChatTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateConversationSequenceTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateExpireTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCanShareForward;

  private final SharedSQLiteStatement __preparedStmtOfUpdateIsConfidential;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReadReceipts;

  private final SharedSQLiteStatement __preparedStmtOfUpdateHasSentMessage;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAutoSaveToVault;

  private final SharedSQLiteStatement __preparedStmtOfUpdateConversationArchive;

  private final SharedSQLiteStatement __preparedStmtOfUpdateInConversation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateConversationUnread;

  private final SharedSQLiteStatement __preparedStmtOfUpdateOtherInConversation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLeftConversation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateViewOnce;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRemovedConversation;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePinnedConversation;

  public ConversationsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConversation = new EntityInsertionAdapter<Conversation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Conversation` (`uid`,`name`,`description`,`_conversation_id`,`_conversation_type`,`_conversationMembers`,`messages`,`owner`,`con_createdAt`,`keepChatDate`,`isRemoved`,`isArchived`,`isInConversation`,`_isViewOnce`,`photo`,`conversationPhoto`,`myMoniker`,`conversationExpiryTime`,`isCanShareForward`,`isAutoSaveVault`,`_isConfidential`,`_isMediaShareRestrict`,`sequenceOfConversation`,`isPinned`,`hasSentMessage`,`conReadReceipts`,`unreadCount`,`id`,`data`,`type`,`messageId`,`senderId`,`createdAt`,`ack_id`,`conversationId`,`conversationType`,`userChatId`,`filePath`,`status`,`isEdited`,`isDeleted`,`deliveredList`,`readList`,`openedList`,`isExpire`,`isForwarded`,`isConfidential`,`isViewOnce`,`isViewed`,`isDownloading`,`readReceipts`,`isOpened`,`msgExpiryTime`,`expireStarted`,`public_key_list`,`received_at`,`payloadCanShareForward`,`chatNickUserChatId`,`chatNickData`,`senderPubKey`,`recipientPubKeyFingerprint`,`nextDHKey`,`messageCounter`,`chainIndex`,`aVRatchetKeyMaterial`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Conversation value) {
        stmt.bindLong(1, value.getUid());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getConversationId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getConversationId());
        }
        if (value.getConversationType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getConversationType());
        }
        final String _tmp = ConversationMemberListConverter.ListToJson(value.getConversationMembers());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp);
        }
        final String _tmp_1 = MessagesListConverter.ListToJson(value.getMessages());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_1);
        }
        if (value.getOwner() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOwner());
        }
        if (value.getCon_createdAt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCon_createdAt());
        }
        if (value.getKeepChatDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getKeepChatDate());
        }
        final int _tmp_2 = value.isRemoved() ? 1 : 0;
        stmt.bindLong(11, _tmp_2);
        final int _tmp_3 = value.isArchived() ? 1 : 0;
        stmt.bindLong(12, _tmp_3);
        final int _tmp_4 = value.isInConversation() ? 1 : 0;
        stmt.bindLong(13, _tmp_4);
        final int _tmp_5 = value.isViewOnce() ? 1 : 0;
        stmt.bindLong(14, _tmp_5);
        if (value.getPhoto() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPhoto());
        }
        if (value.getConversationPhoto() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getConversationPhoto());
        }
        if (value.getMyMoniker() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getMyMoniker());
        }
        stmt.bindLong(18, value.getConversationExpiryTime());
        final int _tmp_6 = value.isCanShareForward() ? 1 : 0;
        stmt.bindLong(19, _tmp_6);
        final int _tmp_7 = value.isAutoSaveVault() ? 1 : 0;
        stmt.bindLong(20, _tmp_7);
        final int _tmp_8 = value.isConfidential() ? 1 : 0;
        stmt.bindLong(21, _tmp_8);
        final int _tmp_9 = value.isMediaShareRestrict() ? 1 : 0;
        stmt.bindLong(22, _tmp_9);
        stmt.bindLong(23, value.getSequenceOfConversation());
        final int _tmp_10 = value.isPinned() ? 1 : 0;
        stmt.bindLong(24, _tmp_10);
        final int _tmp_11 = value.getHasSentMessage() ? 1 : 0;
        stmt.bindLong(25, _tmp_11);
        final int _tmp_12 = value.getConReadReceipts() ? 1 : 0;
        stmt.bindLong(26, _tmp_12);
        stmt.bindLong(27, value.getUnreadCount());
        final Payload _tmpLastMessage = value.getLastMessage();
        if(_tmpLastMessage != null) {
          stmt.bindLong(28, _tmpLastMessage.getId());
          if (_tmpLastMessage.getData() == null) {
            stmt.bindNull(29);
          } else {
            stmt.bindString(29, _tmpLastMessage.getData());
          }
          if (_tmpLastMessage.getType() == null) {
            stmt.bindNull(30);
          } else {
            stmt.bindString(30, _tmpLastMessage.getType());
          }
          if (_tmpLastMessage.getMessageId() == null) {
            stmt.bindNull(31);
          } else {
            stmt.bindString(31, _tmpLastMessage.getMessageId());
          }
          if (_tmpLastMessage.getSenderId() == null) {
            stmt.bindNull(32);
          } else {
            stmt.bindString(32, _tmpLastMessage.getSenderId());
          }
          if (_tmpLastMessage.getCreatedAt() == null) {
            stmt.bindNull(33);
          } else {
            stmt.bindString(33, _tmpLastMessage.getCreatedAt());
          }
          if (_tmpLastMessage.getAck_id() == null) {
            stmt.bindNull(34);
          } else {
            stmt.bindString(34, _tmpLastMessage.getAck_id());
          }
          if (_tmpLastMessage.getConversationId() == null) {
            stmt.bindNull(35);
          } else {
            stmt.bindString(35, _tmpLastMessage.getConversationId());
          }
          if (_tmpLastMessage.getConversationType() == null) {
            stmt.bindNull(36);
          } else {
            stmt.bindString(36, _tmpLastMessage.getConversationType());
          }
          if (_tmpLastMessage.getUserChatId() == null) {
            stmt.bindNull(37);
          } else {
            stmt.bindString(37, _tmpLastMessage.getUserChatId());
          }
          if (_tmpLastMessage.getFilePath() == null) {
            stmt.bindNull(38);
          } else {
            stmt.bindString(38, _tmpLastMessage.getFilePath());
          }
          if (_tmpLastMessage.getStatus() == null) {
            stmt.bindNull(39);
          } else {
            stmt.bindString(39, _tmpLastMessage.getStatus());
          }
          final int _tmp_13 = _tmpLastMessage.isEdited() ? 1 : 0;
          stmt.bindLong(40, _tmp_13);
          final int _tmp_14 = _tmpLastMessage.isDeleted() ? 1 : 0;
          stmt.bindLong(41, _tmp_14);
          final String _tmp_15 = DeliverListConverter.ListToJson(_tmpLastMessage.getDeliveredList());
          if (_tmp_15 == null) {
            stmt.bindNull(42);
          } else {
            stmt.bindString(42, _tmp_15);
          }
          final String _tmp_16 = DeliverListConverter.ListToJson(_tmpLastMessage.getReadList());
          if (_tmp_16 == null) {
            stmt.bindNull(43);
          } else {
            stmt.bindString(43, _tmp_16);
          }
          final String _tmp_17 = DeliverListConverter.ListToJson(_tmpLastMessage.getOpenedList());
          if (_tmp_17 == null) {
            stmt.bindNull(44);
          } else {
            stmt.bindString(44, _tmp_17);
          }
          final int _tmp_18 = _tmpLastMessage.isExpire() ? 1 : 0;
          stmt.bindLong(45, _tmp_18);
          final int _tmp_19 = _tmpLastMessage.isForwarded() ? 1 : 0;
          stmt.bindLong(46, _tmp_19);
          final int _tmp_20 = _tmpLastMessage.isConfidential() ? 1 : 0;
          stmt.bindLong(47, _tmp_20);
          final int _tmp_21 = _tmpLastMessage.isViewOnce() ? 1 : 0;
          stmt.bindLong(48, _tmp_21);
          final int _tmp_22 = _tmpLastMessage.isViewed() ? 1 : 0;
          stmt.bindLong(49, _tmp_22);
          final int _tmp_23 = _tmpLastMessage.isDownloading() ? 1 : 0;
          stmt.bindLong(50, _tmp_23);
          final int _tmp_24 = _tmpLastMessage.getReadReceipts() ? 1 : 0;
          stmt.bindLong(51, _tmp_24);
          final int _tmp_25 = _tmpLastMessage.isOpened() ? 1 : 0;
          stmt.bindLong(52, _tmp_25);
          stmt.bindLong(53, _tmpLastMessage.getMsgExpiryTime());
          stmt.bindLong(54, _tmpLastMessage.getExpireStarted());
          final String _tmp_26 = DeliverListConverter.ListToJson(_tmpLastMessage.getPublic_key_list());
          if (_tmp_26 == null) {
            stmt.bindNull(55);
          } else {
            stmt.bindString(55, _tmp_26);
          }
          if (_tmpLastMessage.getReceived_at() == null) {
            stmt.bindNull(56);
          } else {
            stmt.bindString(56, _tmpLastMessage.getReceived_at());
          }
          final int _tmp_27 = _tmpLastMessage.isCanShareForward() ? 1 : 0;
          stmt.bindLong(57, _tmp_27);
          if (_tmpLastMessage.getChatNickUserChatId() == null) {
            stmt.bindNull(58);
          } else {
            stmt.bindString(58, _tmpLastMessage.getChatNickUserChatId());
          }
          if (_tmpLastMessage.getChatNickData() == null) {
            stmt.bindNull(59);
          } else {
            stmt.bindString(59, _tmpLastMessage.getChatNickData());
          }
          if (_tmpLastMessage.getSenderPubKey() == null) {
            stmt.bindNull(60);
          } else {
            stmt.bindString(60, _tmpLastMessage.getSenderPubKey());
          }
          if (_tmpLastMessage.getRecipientPubKeyFingerprint() == null) {
            stmt.bindNull(61);
          } else {
            stmt.bindString(61, _tmpLastMessage.getRecipientPubKeyFingerprint());
          }
          if (_tmpLastMessage.getNextDHKey() == null) {
            stmt.bindNull(62);
          } else {
            stmt.bindString(62, _tmpLastMessage.getNextDHKey());
          }
          stmt.bindLong(63, _tmpLastMessage.getMessageCounter());
          stmt.bindLong(64, _tmpLastMessage.getChainIndex());
          if (_tmpLastMessage.getAVRatchetKeyMaterial() == null) {
            stmt.bindNull(65);
          } else {
            stmt.bindString(65, _tmpLastMessage.getAVRatchetKeyMaterial());
          }
        } else {
          stmt.bindNull(28);
          stmt.bindNull(29);
          stmt.bindNull(30);
          stmt.bindNull(31);
          stmt.bindNull(32);
          stmt.bindNull(33);
          stmt.bindNull(34);
          stmt.bindNull(35);
          stmt.bindNull(36);
          stmt.bindNull(37);
          stmt.bindNull(38);
          stmt.bindNull(39);
          stmt.bindNull(40);
          stmt.bindNull(41);
          stmt.bindNull(42);
          stmt.bindNull(43);
          stmt.bindNull(44);
          stmt.bindNull(45);
          stmt.bindNull(46);
          stmt.bindNull(47);
          stmt.bindNull(48);
          stmt.bindNull(49);
          stmt.bindNull(50);
          stmt.bindNull(51);
          stmt.bindNull(52);
          stmt.bindNull(53);
          stmt.bindNull(54);
          stmt.bindNull(55);
          stmt.bindNull(56);
          stmt.bindNull(57);
          stmt.bindNull(58);
          stmt.bindNull(59);
          stmt.bindNull(60);
          stmt.bindNull(61);
          stmt.bindNull(62);
          stmt.bindNull(63);
          stmt.bindNull(64);
          stmt.bindNull(65);
        }
      }
    };
    this.__deletionAdapterOfConversation = new EntityDeletionOrUpdateAdapter<Conversation>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Conversation` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Conversation value) {
        stmt.bindLong(1, value.getUid());
      }
    };
    this.__updateAdapterOfConversation = new EntityDeletionOrUpdateAdapter<Conversation>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Conversation` SET `uid` = ?,`name` = ?,`description` = ?,`_conversation_id` = ?,`_conversation_type` = ?,`_conversationMembers` = ?,`messages` = ?,`owner` = ?,`con_createdAt` = ?,`keepChatDate` = ?,`isRemoved` = ?,`isArchived` = ?,`isInConversation` = ?,`_isViewOnce` = ?,`photo` = ?,`conversationPhoto` = ?,`myMoniker` = ?,`conversationExpiryTime` = ?,`isCanShareForward` = ?,`isAutoSaveVault` = ?,`_isConfidential` = ?,`_isMediaShareRestrict` = ?,`sequenceOfConversation` = ?,`isPinned` = ?,`hasSentMessage` = ?,`conReadReceipts` = ?,`unreadCount` = ?,`id` = ?,`data` = ?,`type` = ?,`messageId` = ?,`senderId` = ?,`createdAt` = ?,`ack_id` = ?,`conversationId` = ?,`conversationType` = ?,`userChatId` = ?,`filePath` = ?,`status` = ?,`isEdited` = ?,`isDeleted` = ?,`deliveredList` = ?,`readList` = ?,`openedList` = ?,`isExpire` = ?,`isForwarded` = ?,`isConfidential` = ?,`isViewOnce` = ?,`isViewed` = ?,`isDownloading` = ?,`readReceipts` = ?,`isOpened` = ?,`msgExpiryTime` = ?,`expireStarted` = ?,`public_key_list` = ?,`received_at` = ?,`payloadCanShareForward` = ?,`chatNickUserChatId` = ?,`chatNickData` = ?,`senderPubKey` = ?,`recipientPubKeyFingerprint` = ?,`nextDHKey` = ?,`messageCounter` = ?,`chainIndex` = ?,`aVRatchetKeyMaterial` = ? WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Conversation value) {
        stmt.bindLong(1, value.getUid());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getConversationId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getConversationId());
        }
        if (value.getConversationType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getConversationType());
        }
        final String _tmp = ConversationMemberListConverter.ListToJson(value.getConversationMembers());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp);
        }
        final String _tmp_1 = MessagesListConverter.ListToJson(value.getMessages());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_1);
        }
        if (value.getOwner() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOwner());
        }
        if (value.getCon_createdAt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCon_createdAt());
        }
        if (value.getKeepChatDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getKeepChatDate());
        }
        final int _tmp_2 = value.isRemoved() ? 1 : 0;
        stmt.bindLong(11, _tmp_2);
        final int _tmp_3 = value.isArchived() ? 1 : 0;
        stmt.bindLong(12, _tmp_3);
        final int _tmp_4 = value.isInConversation() ? 1 : 0;
        stmt.bindLong(13, _tmp_4);
        final int _tmp_5 = value.isViewOnce() ? 1 : 0;
        stmt.bindLong(14, _tmp_5);
        if (value.getPhoto() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPhoto());
        }
        if (value.getConversationPhoto() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getConversationPhoto());
        }
        if (value.getMyMoniker() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getMyMoniker());
        }
        stmt.bindLong(18, value.getConversationExpiryTime());
        final int _tmp_6 = value.isCanShareForward() ? 1 : 0;
        stmt.bindLong(19, _tmp_6);
        final int _tmp_7 = value.isAutoSaveVault() ? 1 : 0;
        stmt.bindLong(20, _tmp_7);
        final int _tmp_8 = value.isConfidential() ? 1 : 0;
        stmt.bindLong(21, _tmp_8);
        final int _tmp_9 = value.isMediaShareRestrict() ? 1 : 0;
        stmt.bindLong(22, _tmp_9);
        stmt.bindLong(23, value.getSequenceOfConversation());
        final int _tmp_10 = value.isPinned() ? 1 : 0;
        stmt.bindLong(24, _tmp_10);
        final int _tmp_11 = value.getHasSentMessage() ? 1 : 0;
        stmt.bindLong(25, _tmp_11);
        final int _tmp_12 = value.getConReadReceipts() ? 1 : 0;
        stmt.bindLong(26, _tmp_12);
        stmt.bindLong(27, value.getUnreadCount());
        final Payload _tmpLastMessage = value.getLastMessage();
        if(_tmpLastMessage != null) {
          stmt.bindLong(28, _tmpLastMessage.getId());
          if (_tmpLastMessage.getData() == null) {
            stmt.bindNull(29);
          } else {
            stmt.bindString(29, _tmpLastMessage.getData());
          }
          if (_tmpLastMessage.getType() == null) {
            stmt.bindNull(30);
          } else {
            stmt.bindString(30, _tmpLastMessage.getType());
          }
          if (_tmpLastMessage.getMessageId() == null) {
            stmt.bindNull(31);
          } else {
            stmt.bindString(31, _tmpLastMessage.getMessageId());
          }
          if (_tmpLastMessage.getSenderId() == null) {
            stmt.bindNull(32);
          } else {
            stmt.bindString(32, _tmpLastMessage.getSenderId());
          }
          if (_tmpLastMessage.getCreatedAt() == null) {
            stmt.bindNull(33);
          } else {
            stmt.bindString(33, _tmpLastMessage.getCreatedAt());
          }
          if (_tmpLastMessage.getAck_id() == null) {
            stmt.bindNull(34);
          } else {
            stmt.bindString(34, _tmpLastMessage.getAck_id());
          }
          if (_tmpLastMessage.getConversationId() == null) {
            stmt.bindNull(35);
          } else {
            stmt.bindString(35, _tmpLastMessage.getConversationId());
          }
          if (_tmpLastMessage.getConversationType() == null) {
            stmt.bindNull(36);
          } else {
            stmt.bindString(36, _tmpLastMessage.getConversationType());
          }
          if (_tmpLastMessage.getUserChatId() == null) {
            stmt.bindNull(37);
          } else {
            stmt.bindString(37, _tmpLastMessage.getUserChatId());
          }
          if (_tmpLastMessage.getFilePath() == null) {
            stmt.bindNull(38);
          } else {
            stmt.bindString(38, _tmpLastMessage.getFilePath());
          }
          if (_tmpLastMessage.getStatus() == null) {
            stmt.bindNull(39);
          } else {
            stmt.bindString(39, _tmpLastMessage.getStatus());
          }
          final int _tmp_13 = _tmpLastMessage.isEdited() ? 1 : 0;
          stmt.bindLong(40, _tmp_13);
          final int _tmp_14 = _tmpLastMessage.isDeleted() ? 1 : 0;
          stmt.bindLong(41, _tmp_14);
          final String _tmp_15 = DeliverListConverter.ListToJson(_tmpLastMessage.getDeliveredList());
          if (_tmp_15 == null) {
            stmt.bindNull(42);
          } else {
            stmt.bindString(42, _tmp_15);
          }
          final String _tmp_16 = DeliverListConverter.ListToJson(_tmpLastMessage.getReadList());
          if (_tmp_16 == null) {
            stmt.bindNull(43);
          } else {
            stmt.bindString(43, _tmp_16);
          }
          final String _tmp_17 = DeliverListConverter.ListToJson(_tmpLastMessage.getOpenedList());
          if (_tmp_17 == null) {
            stmt.bindNull(44);
          } else {
            stmt.bindString(44, _tmp_17);
          }
          final int _tmp_18 = _tmpLastMessage.isExpire() ? 1 : 0;
          stmt.bindLong(45, _tmp_18);
          final int _tmp_19 = _tmpLastMessage.isForwarded() ? 1 : 0;
          stmt.bindLong(46, _tmp_19);
          final int _tmp_20 = _tmpLastMessage.isConfidential() ? 1 : 0;
          stmt.bindLong(47, _tmp_20);
          final int _tmp_21 = _tmpLastMessage.isViewOnce() ? 1 : 0;
          stmt.bindLong(48, _tmp_21);
          final int _tmp_22 = _tmpLastMessage.isViewed() ? 1 : 0;
          stmt.bindLong(49, _tmp_22);
          final int _tmp_23 = _tmpLastMessage.isDownloading() ? 1 : 0;
          stmt.bindLong(50, _tmp_23);
          final int _tmp_24 = _tmpLastMessage.getReadReceipts() ? 1 : 0;
          stmt.bindLong(51, _tmp_24);
          final int _tmp_25 = _tmpLastMessage.isOpened() ? 1 : 0;
          stmt.bindLong(52, _tmp_25);
          stmt.bindLong(53, _tmpLastMessage.getMsgExpiryTime());
          stmt.bindLong(54, _tmpLastMessage.getExpireStarted());
          final String _tmp_26 = DeliverListConverter.ListToJson(_tmpLastMessage.getPublic_key_list());
          if (_tmp_26 == null) {
            stmt.bindNull(55);
          } else {
            stmt.bindString(55, _tmp_26);
          }
          if (_tmpLastMessage.getReceived_at() == null) {
            stmt.bindNull(56);
          } else {
            stmt.bindString(56, _tmpLastMessage.getReceived_at());
          }
          final int _tmp_27 = _tmpLastMessage.isCanShareForward() ? 1 : 0;
          stmt.bindLong(57, _tmp_27);
          if (_tmpLastMessage.getChatNickUserChatId() == null) {
            stmt.bindNull(58);
          } else {
            stmt.bindString(58, _tmpLastMessage.getChatNickUserChatId());
          }
          if (_tmpLastMessage.getChatNickData() == null) {
            stmt.bindNull(59);
          } else {
            stmt.bindString(59, _tmpLastMessage.getChatNickData());
          }
          if (_tmpLastMessage.getSenderPubKey() == null) {
            stmt.bindNull(60);
          } else {
            stmt.bindString(60, _tmpLastMessage.getSenderPubKey());
          }
          if (_tmpLastMessage.getRecipientPubKeyFingerprint() == null) {
            stmt.bindNull(61);
          } else {
            stmt.bindString(61, _tmpLastMessage.getRecipientPubKeyFingerprint());
          }
          if (_tmpLastMessage.getNextDHKey() == null) {
            stmt.bindNull(62);
          } else {
            stmt.bindString(62, _tmpLastMessage.getNextDHKey());
          }
          stmt.bindLong(63, _tmpLastMessage.getMessageCounter());
          stmt.bindLong(64, _tmpLastMessage.getChainIndex());
          if (_tmpLastMessage.getAVRatchetKeyMaterial() == null) {
            stmt.bindNull(65);
          } else {
            stmt.bindString(65, _tmpLastMessage.getAVRatchetKeyMaterial());
          }
        } else {
          stmt.bindNull(28);
          stmt.bindNull(29);
          stmt.bindNull(30);
          stmt.bindNull(31);
          stmt.bindNull(32);
          stmt.bindNull(33);
          stmt.bindNull(34);
          stmt.bindNull(35);
          stmt.bindNull(36);
          stmt.bindNull(37);
          stmt.bindNull(38);
          stmt.bindNull(39);
          stmt.bindNull(40);
          stmt.bindNull(41);
          stmt.bindNull(42);
          stmt.bindNull(43);
          stmt.bindNull(44);
          stmt.bindNull(45);
          stmt.bindNull(46);
          stmt.bindNull(47);
          stmt.bindNull(48);
          stmt.bindNull(49);
          stmt.bindNull(50);
          stmt.bindNull(51);
          stmt.bindNull(52);
          stmt.bindNull(53);
          stmt.bindNull(54);
          stmt.bindNull(55);
          stmt.bindNull(56);
          stmt.bindNull(57);
          stmt.bindNull(58);
          stmt.bindNull(59);
          stmt.bindNull(60);
          stmt.bindNull(61);
          stmt.bindNull(62);
          stmt.bindNull(63);
          stmt.bindNull(64);
          stmt.bindNull(65);
        }
        stmt.bindLong(66, value.getUid());
      }
    };
    this.__preparedStmtOfUpdateTour = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET messages = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFilePath = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET conversationPhoto = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMyMoniker = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET myMoniker = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateConversationName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET name = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateConversationDes = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET description = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateConversationIcon = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET conversationPhoto = ? , photo=?  WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMember = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET _conversationMembers = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET name = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateKeepChatTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET keepChatDate = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateConversationSequenceTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET sequenceOfConversation = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateExpireTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET conversationExpiryTime = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCanShareForward = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET isCanShareForward = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateIsConfidential = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET _isConfidential = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateReadReceipts = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET conReadReceipts = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateHasSentMessage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET hasSentMessage = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAutoSaveToVault = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET isAutoSaveVault = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateConversationArchive = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET isArchived = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateInConversation = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update conversation set isInConversation= 1 where _conversation_id like ? ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateConversationUnread = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET unreadCount = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateOtherInConversation = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update conversation set isInConversation = 0 where _conversation_id not like ? ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLeftConversation = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update conversation set isInConversation = 0 where _conversation_id like ? ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateViewOnce = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update conversation set isViewOnce= ? where _conversation_id like ? ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRemovedConversation = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update conversation set isRemoved= 1 where _conversation_id like ? ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePinnedConversation = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE conversation SET isPinned = ? WHERE _conversation_id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Conversation conversation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfConversation.insert(conversation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Conversation conversation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfConversation.handle(conversation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Conversation conversation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfConversation.handle(conversation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateTour(final long conId, final String messages) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTour.acquire();
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
      __preparedStmtOfUpdateTour.release(_stmt);
    }
  }

  @Override
  public void updateFilePath(final String id, final String conversation_photo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFilePath.acquire();
    int _argIndex = 1;
    if (conversation_photo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, conversation_photo);
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
  public void updateMyMoniker(final String id, final String my_moniker) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMyMoniker.acquire();
    int _argIndex = 1;
    if (my_moniker == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, my_moniker);
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
      __preparedStmtOfUpdateMyMoniker.release(_stmt);
    }
  }

  @Override
  public void updateConversationName(final String id, final String conversation_name) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateConversationName.acquire();
    int _argIndex = 1;
    if (conversation_name == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, conversation_name);
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
      __preparedStmtOfUpdateConversationName.release(_stmt);
    }
  }

  @Override
  public void updateConversationDes(final String id, final String description) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateConversationDes.acquire();
    int _argIndex = 1;
    if (description == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, description);
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
      __preparedStmtOfUpdateConversationDes.release(_stmt);
    }
  }

  @Override
  public void updateConversationIcon(final String id, final String path, final String image_name) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateConversationIcon.acquire();
    int _argIndex = 1;
    if (path == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, path);
    }
    _argIndex = 2;
    if (image_name == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, image_name);
    }
    _argIndex = 3;
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
      __preparedStmtOfUpdateConversationIcon.release(_stmt);
    }
  }

  @Override
  public void updateMember(final String conId, final String conversationMembers) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMember.acquire();
    int _argIndex = 1;
    if (conversationMembers == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, conversationMembers);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateMember.release(_stmt);
    }
  }

  @Override
  public void updateName(final String conId, final String conversationName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateName.acquire();
    int _argIndex = 1;
    if (conversationName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, conversationName);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateName.release(_stmt);
    }
  }

  @Override
  public void updateKeepChatTime(final String conId, final String keepChatTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateKeepChatTime.acquire();
    int _argIndex = 1;
    if (keepChatTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, keepChatTime);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateKeepChatTime.release(_stmt);
    }
  }

  @Override
  public void updateConversationSequenceTime(final String conId,
      final long sequenceOfConversation) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateConversationSequenceTime.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, sequenceOfConversation);
    _argIndex = 2;
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
      __preparedStmtOfUpdateConversationSequenceTime.release(_stmt);
    }
  }

  @Override
  public void updateExpireTime(final String conId, final long expireTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateExpireTime.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, expireTime);
    _argIndex = 2;
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
      __preparedStmtOfUpdateExpireTime.release(_stmt);
    }
  }

  @Override
  public void updateCanShareForward(final String conId, final boolean canShareForward) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCanShareForward.acquire();
    int _argIndex = 1;
    final int _tmp = canShareForward ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdateCanShareForward.release(_stmt);
    }
  }

  @Override
  public void updateIsConfidential(final String conId, final boolean isConfidential) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateIsConfidential.acquire();
    int _argIndex = 1;
    final int _tmp = isConfidential ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdateIsConfidential.release(_stmt);
    }
  }

  @Override
  public void updateReadReceipts(final String conId, final boolean conReadReceipts) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReadReceipts.acquire();
    int _argIndex = 1;
    final int _tmp = conReadReceipts ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdateReadReceipts.release(_stmt);
    }
  }

  @Override
  public void updateHasSentMessage(final String conId, final boolean hasSentMessage) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateHasSentMessage.acquire();
    int _argIndex = 1;
    final int _tmp = hasSentMessage ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdateHasSentMessage.release(_stmt);
    }
  }

  @Override
  public void updateAutoSaveToVault(final String conId, final boolean autoSaveToVault) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAutoSaveToVault.acquire();
    int _argIndex = 1;
    final int _tmp = autoSaveToVault ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdateAutoSaveToVault.release(_stmt);
    }
  }

  @Override
  public void updateConversationArchive(final String conId, final boolean isArchive) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateConversationArchive.acquire();
    int _argIndex = 1;
    final int _tmp = isArchive ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdateConversationArchive.release(_stmt);
    }
  }

  @Override
  public void updateInConversation(final String conId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateInConversation.acquire();
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
      __preparedStmtOfUpdateInConversation.release(_stmt);
    }
  }

  @Override
  public void updateConversationUnread(final String id, final Integer unreadCount) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateConversationUnread.acquire();
    int _argIndex = 1;
    if (unreadCount == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, unreadCount);
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
      __preparedStmtOfUpdateConversationUnread.release(_stmt);
    }
  }

  @Override
  public void updateOtherInConversation(final String conId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateOtherInConversation.acquire();
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
      __preparedStmtOfUpdateOtherInConversation.release(_stmt);
    }
  }

  @Override
  public void updateLeftConversation(final String conId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLeftConversation.acquire();
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
      __preparedStmtOfUpdateLeftConversation.release(_stmt);
    }
  }

  @Override
  public void updateViewOnce(final String conId, final boolean viewOnce) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateViewOnce.acquire();
    int _argIndex = 1;
    final int _tmp = viewOnce ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdateViewOnce.release(_stmt);
    }
  }

  @Override
  public void updateRemovedConversation(final String conId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRemovedConversation.acquire();
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
      __preparedStmtOfUpdateRemovedConversation.release(_stmt);
    }
  }

  @Override
  public void updatePinnedConversation(final String conId, final boolean isPinned) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePinnedConversation.acquire();
    int _argIndex = 1;
    final int _tmp = isPinned ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdatePinnedConversation.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Conversation>> getLiveConversations() {
    final String _sql = "SELECT * FROM conversation where isArchived like 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"conversation"}, false, new Callable<List<Conversation>>() {
      @Override
      public List<Conversation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
          final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
          final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
          final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
          final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
          final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
          final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
          final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
          final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
          final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
          final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
          final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
          final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
          final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
          final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
          final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
          final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
          final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
          final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
          final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
          final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
          final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
          final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
          final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
          final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
          final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
          final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Conversation _item;
            final Payload _tmpLastMessage;
            if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
              _tmpLastMessage = new Payload();
              final int _tmpId;
              _tmpId = _cursor.getInt(_cursorIndexOfId);
              _tmpLastMessage.setId(_tmpId);
              final String _tmpData;
              if (_cursor.isNull(_cursorIndexOfData)) {
                _tmpData = null;
              } else {
                _tmpData = _cursor.getString(_cursorIndexOfData);
              }
              _tmpLastMessage.setData(_tmpData);
              final String _tmpType;
              if (_cursor.isNull(_cursorIndexOfType)) {
                _tmpType = null;
              } else {
                _tmpType = _cursor.getString(_cursorIndexOfType);
              }
              _tmpLastMessage.setType(_tmpType);
              final String _tmpMessageId;
              if (_cursor.isNull(_cursorIndexOfMessageId)) {
                _tmpMessageId = null;
              } else {
                _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
              }
              _tmpLastMessage.setMessageId(_tmpMessageId);
              final String _tmpSenderId;
              if (_cursor.isNull(_cursorIndexOfSenderId)) {
                _tmpSenderId = null;
              } else {
                _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
              }
              _tmpLastMessage.setSenderId(_tmpSenderId);
              final String _tmpCreatedAt;
              if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
                _tmpCreatedAt = null;
              } else {
                _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
              }
              _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
              final String _tmpAck_id;
              if (_cursor.isNull(_cursorIndexOfAckId)) {
                _tmpAck_id = null;
              } else {
                _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
              }
              _tmpLastMessage.setAck_id(_tmpAck_id);
              final String _tmpConversationId;
              if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
                _tmpConversationId = null;
              } else {
                _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
              }
              _tmpLastMessage.setConversationId(_tmpConversationId);
              final String _tmpConversationType;
              if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
                _tmpConversationType = null;
              } else {
                _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
              }
              _tmpLastMessage.setConversationType(_tmpConversationType);
              final String _tmpUserChatId;
              if (_cursor.isNull(_cursorIndexOfUserChatId)) {
                _tmpUserChatId = null;
              } else {
                _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
              }
              _tmpLastMessage.setUserChatId(_tmpUserChatId);
              final String _tmpFilePath;
              if (_cursor.isNull(_cursorIndexOfFilePath)) {
                _tmpFilePath = null;
              } else {
                _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
              }
              _tmpLastMessage.setFilePath(_tmpFilePath);
              final String _tmpStatus;
              if (_cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
              }
              _tmpLastMessage.setStatus(_tmpStatus);
              final boolean _tmpIsEdited;
              final int _tmp;
              _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
              _tmpIsEdited = _tmp != 0;
              _tmpLastMessage.setEdited(_tmpIsEdited);
              final boolean _tmpIsDeleted;
              final int _tmp_1;
              _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
              _tmpIsDeleted = _tmp_1 != 0;
              _tmpLastMessage.setDeleted(_tmpIsDeleted);
              final List<String> _tmpDeliveredList;
              final String _tmp_2;
              if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
                _tmp_2 = null;
              } else {
                _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
              }
              _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
              _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
              final List<String> _tmpReadList;
              final String _tmp_3;
              if (_cursor.isNull(_cursorIndexOfReadList)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
              }
              _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
              _tmpLastMessage.setReadList(_tmpReadList);
              final List<String> _tmpOpenedList;
              final String _tmp_4;
              if (_cursor.isNull(_cursorIndexOfOpenedList)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
              }
              _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
              _tmpLastMessage.setOpenedList(_tmpOpenedList);
              final boolean _tmpIsExpire;
              final int _tmp_5;
              _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
              _tmpIsExpire = _tmp_5 != 0;
              _tmpLastMessage.setExpire(_tmpIsExpire);
              final boolean _tmpIsForwarded;
              final int _tmp_6;
              _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
              _tmpIsForwarded = _tmp_6 != 0;
              _tmpLastMessage.setForwarded(_tmpIsForwarded);
              final boolean _tmpIsConfidential;
              final int _tmp_7;
              _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
              _tmpIsConfidential = _tmp_7 != 0;
              _tmpLastMessage.setConfidential(_tmpIsConfidential);
              final boolean _tmpIsViewOnce;
              final int _tmp_8;
              _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
              _tmpIsViewOnce = _tmp_8 != 0;
              _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
              final boolean _tmpIsViewed;
              final int _tmp_9;
              _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
              _tmpIsViewed = _tmp_9 != 0;
              _tmpLastMessage.setViewed(_tmpIsViewed);
              final boolean _tmpIsDownloading;
              final int _tmp_10;
              _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
              _tmpIsDownloading = _tmp_10 != 0;
              _tmpLastMessage.setDownloading(_tmpIsDownloading);
              final boolean _tmpReadReceipts;
              final int _tmp_11;
              _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
              _tmpReadReceipts = _tmp_11 != 0;
              _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
              final boolean _tmpIsOpened;
              final int _tmp_12;
              _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
              _tmpIsOpened = _tmp_12 != 0;
              _tmpLastMessage.setOpened(_tmpIsOpened);
              final long _tmpMsgExpiryTime;
              _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
              _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
              final long _tmpExpireStarted;
              _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
              _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
              final List<String> _tmpPublic_key_list;
              final String _tmp_13;
              if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
                _tmp_13 = null;
              } else {
                _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
              }
              _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
              _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
              final String _tmpReceived_at;
              if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
                _tmpReceived_at = null;
              } else {
                _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
              }
              _tmpLastMessage.setReceived_at(_tmpReceived_at);
              final boolean _tmpIsCanShareForward;
              final int _tmp_14;
              _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
              _tmpIsCanShareForward = _tmp_14 != 0;
              _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
              final String _tmpChatNickUserChatId;
              if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
                _tmpChatNickUserChatId = null;
              } else {
                _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
              }
              _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
              final String _tmpChatNickData;
              if (_cursor.isNull(_cursorIndexOfChatNickData)) {
                _tmpChatNickData = null;
              } else {
                _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
              }
              _tmpLastMessage.setChatNickData(_tmpChatNickData);
              final String _tmpSenderPubKey;
              if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
                _tmpSenderPubKey = null;
              } else {
                _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
              }
              _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
              final String _tmpRecipientPubKeyFingerprint;
              if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
                _tmpRecipientPubKeyFingerprint = null;
              } else {
                _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
              }
              _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
              final String _tmpNextDHKey;
              if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
                _tmpNextDHKey = null;
              } else {
                _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
              }
              _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
              final int _tmpMessageCounter;
              _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
              _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
              final int _tmpChainIndex;
              _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
              _tmpLastMessage.setChainIndex(_tmpChainIndex);
              final String _tmpAVRatchetKeyMaterial;
              if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
                _tmpAVRatchetKeyMaterial = null;
              } else {
                _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
              }
              _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
            }  else  {
              _tmpLastMessage = null;
            }
            _item = new Conversation();
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _item.setUid(_tmpUid);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item.setName(_tmpName);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item.setDescription(_tmpDescription);
            final String _tmpConversationId_1;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId_1 = null;
            } else {
              _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId_1);
            final String _tmpConversationType_1;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversationType_1 = null;
            } else {
              _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversationType(_tmpConversationType_1);
            final List<ConversationMember> _tmpConversationMembers;
            final String _tmp_15;
            if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
              _tmp_15 = null;
            } else {
              _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
            }
            _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
            _item.setConversationMembers(_tmpConversationMembers);
            final List<Payload> _tmpMessages;
            final String _tmp_16;
            if (_cursor.isNull(_cursorIndexOfMessages)) {
              _tmp_16 = null;
            } else {
              _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
            }
            _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
            _item.setMessages(_tmpMessages);
            final String _tmpOwner;
            if (_cursor.isNull(_cursorIndexOfOwner)) {
              _tmpOwner = null;
            } else {
              _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
            }
            _item.setOwner(_tmpOwner);
            final String _tmpCon_createdAt;
            if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
              _tmpCon_createdAt = null;
            } else {
              _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
            }
            _item.setCon_createdAt(_tmpCon_createdAt);
            final String _tmpKeepChatDate;
            if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
              _tmpKeepChatDate = null;
            } else {
              _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
            }
            _item.setKeepChatDate(_tmpKeepChatDate);
            final boolean _tmpIsRemoved;
            final int _tmp_17;
            _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
            _tmpIsRemoved = _tmp_17 != 0;
            _item.setRemoved(_tmpIsRemoved);
            final boolean _tmpIsArchived;
            final int _tmp_18;
            _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
            _tmpIsArchived = _tmp_18 != 0;
            _item.setArchived(_tmpIsArchived);
            final boolean _tmpIsInConversation;
            final int _tmp_19;
            _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
            _tmpIsInConversation = _tmp_19 != 0;
            _item.setInConversation(_tmpIsInConversation);
            final boolean _tmpIsViewOnce_1;
            final int _tmp_20;
            _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
            _tmpIsViewOnce_1 = _tmp_20 != 0;
            _item.setViewOnce(_tmpIsViewOnce_1);
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            _item.setPhoto(_tmpPhoto);
            final String _tmpConversationPhoto;
            if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
              _tmpConversationPhoto = null;
            } else {
              _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
            }
            _item.setConversationPhoto(_tmpConversationPhoto);
            final String _tmpMyMoniker;
            if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
              _tmpMyMoniker = null;
            } else {
              _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
            }
            _item.setMyMoniker(_tmpMyMoniker);
            final long _tmpConversationExpiryTime;
            _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
            _item.setConversationExpiryTime(_tmpConversationExpiryTime);
            final boolean _tmpIsCanShareForward_1;
            final int _tmp_21;
            _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward_1 = _tmp_21 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward_1);
            final boolean _tmpIsAutoSaveVault;
            final int _tmp_22;
            _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
            _tmpIsAutoSaveVault = _tmp_22 != 0;
            _item.setAutoSaveVault(_tmpIsAutoSaveVault);
            final boolean _tmpIsConfidential_1;
            final int _tmp_23;
            _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
            _tmpIsConfidential_1 = _tmp_23 != 0;
            _item.setConfidential(_tmpIsConfidential_1);
            final boolean _tmpIsMediaShareRestrict;
            final int _tmp_24;
            _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
            _tmpIsMediaShareRestrict = _tmp_24 != 0;
            _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
            final long _tmpSequenceOfConversation;
            _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
            _item.setSequenceOfConversation(_tmpSequenceOfConversation);
            final boolean _tmpIsPinned;
            final int _tmp_25;
            _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
            _tmpIsPinned = _tmp_25 != 0;
            _item.setPinned(_tmpIsPinned);
            final boolean _tmpHasSentMessage;
            final int _tmp_26;
            _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
            _tmpHasSentMessage = _tmp_26 != 0;
            _item.setHasSentMessage(_tmpHasSentMessage);
            final boolean _tmpConReadReceipts;
            final int _tmp_27;
            _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
            _tmpConReadReceipts = _tmp_27 != 0;
            _item.setConReadReceipts(_tmpConReadReceipts);
            final int _tmpUnreadCount;
            _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
            _item.setUnreadCount(_tmpUnreadCount);
            _item.setLastMessage(_tmpLastMessage);
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
  public LiveData<List<Conversation>> getLiveConversationsNotRemoved() {
    final String _sql = "SELECT * FROM conversation where isArchived like 0 and isRemoved=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"conversation"}, false, new Callable<List<Conversation>>() {
      @Override
      public List<Conversation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
          final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
          final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
          final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
          final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
          final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
          final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
          final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
          final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
          final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
          final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
          final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
          final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
          final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
          final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
          final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
          final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
          final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
          final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
          final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
          final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
          final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
          final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
          final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
          final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
          final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
          final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Conversation _item;
            final Payload _tmpLastMessage;
            if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
              _tmpLastMessage = new Payload();
              final int _tmpId;
              _tmpId = _cursor.getInt(_cursorIndexOfId);
              _tmpLastMessage.setId(_tmpId);
              final String _tmpData;
              if (_cursor.isNull(_cursorIndexOfData)) {
                _tmpData = null;
              } else {
                _tmpData = _cursor.getString(_cursorIndexOfData);
              }
              _tmpLastMessage.setData(_tmpData);
              final String _tmpType;
              if (_cursor.isNull(_cursorIndexOfType)) {
                _tmpType = null;
              } else {
                _tmpType = _cursor.getString(_cursorIndexOfType);
              }
              _tmpLastMessage.setType(_tmpType);
              final String _tmpMessageId;
              if (_cursor.isNull(_cursorIndexOfMessageId)) {
                _tmpMessageId = null;
              } else {
                _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
              }
              _tmpLastMessage.setMessageId(_tmpMessageId);
              final String _tmpSenderId;
              if (_cursor.isNull(_cursorIndexOfSenderId)) {
                _tmpSenderId = null;
              } else {
                _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
              }
              _tmpLastMessage.setSenderId(_tmpSenderId);
              final String _tmpCreatedAt;
              if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
                _tmpCreatedAt = null;
              } else {
                _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
              }
              _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
              final String _tmpAck_id;
              if (_cursor.isNull(_cursorIndexOfAckId)) {
                _tmpAck_id = null;
              } else {
                _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
              }
              _tmpLastMessage.setAck_id(_tmpAck_id);
              final String _tmpConversationId;
              if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
                _tmpConversationId = null;
              } else {
                _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
              }
              _tmpLastMessage.setConversationId(_tmpConversationId);
              final String _tmpConversationType;
              if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
                _tmpConversationType = null;
              } else {
                _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
              }
              _tmpLastMessage.setConversationType(_tmpConversationType);
              final String _tmpUserChatId;
              if (_cursor.isNull(_cursorIndexOfUserChatId)) {
                _tmpUserChatId = null;
              } else {
                _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
              }
              _tmpLastMessage.setUserChatId(_tmpUserChatId);
              final String _tmpFilePath;
              if (_cursor.isNull(_cursorIndexOfFilePath)) {
                _tmpFilePath = null;
              } else {
                _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
              }
              _tmpLastMessage.setFilePath(_tmpFilePath);
              final String _tmpStatus;
              if (_cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
              }
              _tmpLastMessage.setStatus(_tmpStatus);
              final boolean _tmpIsEdited;
              final int _tmp;
              _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
              _tmpIsEdited = _tmp != 0;
              _tmpLastMessage.setEdited(_tmpIsEdited);
              final boolean _tmpIsDeleted;
              final int _tmp_1;
              _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
              _tmpIsDeleted = _tmp_1 != 0;
              _tmpLastMessage.setDeleted(_tmpIsDeleted);
              final List<String> _tmpDeliveredList;
              final String _tmp_2;
              if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
                _tmp_2 = null;
              } else {
                _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
              }
              _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
              _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
              final List<String> _tmpReadList;
              final String _tmp_3;
              if (_cursor.isNull(_cursorIndexOfReadList)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
              }
              _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
              _tmpLastMessage.setReadList(_tmpReadList);
              final List<String> _tmpOpenedList;
              final String _tmp_4;
              if (_cursor.isNull(_cursorIndexOfOpenedList)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
              }
              _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
              _tmpLastMessage.setOpenedList(_tmpOpenedList);
              final boolean _tmpIsExpire;
              final int _tmp_5;
              _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
              _tmpIsExpire = _tmp_5 != 0;
              _tmpLastMessage.setExpire(_tmpIsExpire);
              final boolean _tmpIsForwarded;
              final int _tmp_6;
              _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
              _tmpIsForwarded = _tmp_6 != 0;
              _tmpLastMessage.setForwarded(_tmpIsForwarded);
              final boolean _tmpIsConfidential;
              final int _tmp_7;
              _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
              _tmpIsConfidential = _tmp_7 != 0;
              _tmpLastMessage.setConfidential(_tmpIsConfidential);
              final boolean _tmpIsViewOnce;
              final int _tmp_8;
              _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
              _tmpIsViewOnce = _tmp_8 != 0;
              _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
              final boolean _tmpIsViewed;
              final int _tmp_9;
              _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
              _tmpIsViewed = _tmp_9 != 0;
              _tmpLastMessage.setViewed(_tmpIsViewed);
              final boolean _tmpIsDownloading;
              final int _tmp_10;
              _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
              _tmpIsDownloading = _tmp_10 != 0;
              _tmpLastMessage.setDownloading(_tmpIsDownloading);
              final boolean _tmpReadReceipts;
              final int _tmp_11;
              _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
              _tmpReadReceipts = _tmp_11 != 0;
              _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
              final boolean _tmpIsOpened;
              final int _tmp_12;
              _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
              _tmpIsOpened = _tmp_12 != 0;
              _tmpLastMessage.setOpened(_tmpIsOpened);
              final long _tmpMsgExpiryTime;
              _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
              _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
              final long _tmpExpireStarted;
              _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
              _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
              final List<String> _tmpPublic_key_list;
              final String _tmp_13;
              if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
                _tmp_13 = null;
              } else {
                _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
              }
              _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
              _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
              final String _tmpReceived_at;
              if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
                _tmpReceived_at = null;
              } else {
                _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
              }
              _tmpLastMessage.setReceived_at(_tmpReceived_at);
              final boolean _tmpIsCanShareForward;
              final int _tmp_14;
              _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
              _tmpIsCanShareForward = _tmp_14 != 0;
              _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
              final String _tmpChatNickUserChatId;
              if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
                _tmpChatNickUserChatId = null;
              } else {
                _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
              }
              _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
              final String _tmpChatNickData;
              if (_cursor.isNull(_cursorIndexOfChatNickData)) {
                _tmpChatNickData = null;
              } else {
                _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
              }
              _tmpLastMessage.setChatNickData(_tmpChatNickData);
              final String _tmpSenderPubKey;
              if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
                _tmpSenderPubKey = null;
              } else {
                _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
              }
              _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
              final String _tmpRecipientPubKeyFingerprint;
              if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
                _tmpRecipientPubKeyFingerprint = null;
              } else {
                _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
              }
              _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
              final String _tmpNextDHKey;
              if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
                _tmpNextDHKey = null;
              } else {
                _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
              }
              _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
              final int _tmpMessageCounter;
              _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
              _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
              final int _tmpChainIndex;
              _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
              _tmpLastMessage.setChainIndex(_tmpChainIndex);
              final String _tmpAVRatchetKeyMaterial;
              if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
                _tmpAVRatchetKeyMaterial = null;
              } else {
                _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
              }
              _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
            }  else  {
              _tmpLastMessage = null;
            }
            _item = new Conversation();
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _item.setUid(_tmpUid);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item.setName(_tmpName);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item.setDescription(_tmpDescription);
            final String _tmpConversationId_1;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId_1 = null;
            } else {
              _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId_1);
            final String _tmpConversationType_1;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversationType_1 = null;
            } else {
              _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversationType(_tmpConversationType_1);
            final List<ConversationMember> _tmpConversationMembers;
            final String _tmp_15;
            if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
              _tmp_15 = null;
            } else {
              _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
            }
            _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
            _item.setConversationMembers(_tmpConversationMembers);
            final List<Payload> _tmpMessages;
            final String _tmp_16;
            if (_cursor.isNull(_cursorIndexOfMessages)) {
              _tmp_16 = null;
            } else {
              _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
            }
            _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
            _item.setMessages(_tmpMessages);
            final String _tmpOwner;
            if (_cursor.isNull(_cursorIndexOfOwner)) {
              _tmpOwner = null;
            } else {
              _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
            }
            _item.setOwner(_tmpOwner);
            final String _tmpCon_createdAt;
            if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
              _tmpCon_createdAt = null;
            } else {
              _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
            }
            _item.setCon_createdAt(_tmpCon_createdAt);
            final String _tmpKeepChatDate;
            if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
              _tmpKeepChatDate = null;
            } else {
              _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
            }
            _item.setKeepChatDate(_tmpKeepChatDate);
            final boolean _tmpIsRemoved;
            final int _tmp_17;
            _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
            _tmpIsRemoved = _tmp_17 != 0;
            _item.setRemoved(_tmpIsRemoved);
            final boolean _tmpIsArchived;
            final int _tmp_18;
            _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
            _tmpIsArchived = _tmp_18 != 0;
            _item.setArchived(_tmpIsArchived);
            final boolean _tmpIsInConversation;
            final int _tmp_19;
            _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
            _tmpIsInConversation = _tmp_19 != 0;
            _item.setInConversation(_tmpIsInConversation);
            final boolean _tmpIsViewOnce_1;
            final int _tmp_20;
            _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
            _tmpIsViewOnce_1 = _tmp_20 != 0;
            _item.setViewOnce(_tmpIsViewOnce_1);
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            _item.setPhoto(_tmpPhoto);
            final String _tmpConversationPhoto;
            if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
              _tmpConversationPhoto = null;
            } else {
              _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
            }
            _item.setConversationPhoto(_tmpConversationPhoto);
            final String _tmpMyMoniker;
            if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
              _tmpMyMoniker = null;
            } else {
              _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
            }
            _item.setMyMoniker(_tmpMyMoniker);
            final long _tmpConversationExpiryTime;
            _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
            _item.setConversationExpiryTime(_tmpConversationExpiryTime);
            final boolean _tmpIsCanShareForward_1;
            final int _tmp_21;
            _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward_1 = _tmp_21 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward_1);
            final boolean _tmpIsAutoSaveVault;
            final int _tmp_22;
            _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
            _tmpIsAutoSaveVault = _tmp_22 != 0;
            _item.setAutoSaveVault(_tmpIsAutoSaveVault);
            final boolean _tmpIsConfidential_1;
            final int _tmp_23;
            _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
            _tmpIsConfidential_1 = _tmp_23 != 0;
            _item.setConfidential(_tmpIsConfidential_1);
            final boolean _tmpIsMediaShareRestrict;
            final int _tmp_24;
            _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
            _tmpIsMediaShareRestrict = _tmp_24 != 0;
            _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
            final long _tmpSequenceOfConversation;
            _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
            _item.setSequenceOfConversation(_tmpSequenceOfConversation);
            final boolean _tmpIsPinned;
            final int _tmp_25;
            _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
            _tmpIsPinned = _tmp_25 != 0;
            _item.setPinned(_tmpIsPinned);
            final boolean _tmpHasSentMessage;
            final int _tmp_26;
            _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
            _tmpHasSentMessage = _tmp_26 != 0;
            _item.setHasSentMessage(_tmpHasSentMessage);
            final boolean _tmpConReadReceipts;
            final int _tmp_27;
            _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
            _tmpConReadReceipts = _tmp_27 != 0;
            _item.setConReadReceipts(_tmpConReadReceipts);
            final int _tmpUnreadCount;
            _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
            _item.setUnreadCount(_tmpUnreadCount);
            _item.setLastMessage(_tmpLastMessage);
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
  public LiveData<List<Conversation>> getLiveArchiveConversations() {
    final String _sql = "SELECT * FROM conversation where isArchived like 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"conversation"}, false, new Callable<List<Conversation>>() {
      @Override
      public List<Conversation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
          final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
          final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
          final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
          final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
          final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
          final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
          final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
          final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
          final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
          final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
          final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
          final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
          final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
          final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
          final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
          final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
          final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
          final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
          final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
          final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
          final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
          final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
          final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
          final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
          final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
          final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
          final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
          final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
          final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
          final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
          final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
          final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
          final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
          final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
          final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
          final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
          final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
          final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
          final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
          final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
          final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
          final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
          final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Conversation _item;
            final Payload _tmpLastMessage;
            if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
              _tmpLastMessage = new Payload();
              final int _tmpId;
              _tmpId = _cursor.getInt(_cursorIndexOfId);
              _tmpLastMessage.setId(_tmpId);
              final String _tmpData;
              if (_cursor.isNull(_cursorIndexOfData)) {
                _tmpData = null;
              } else {
                _tmpData = _cursor.getString(_cursorIndexOfData);
              }
              _tmpLastMessage.setData(_tmpData);
              final String _tmpType;
              if (_cursor.isNull(_cursorIndexOfType)) {
                _tmpType = null;
              } else {
                _tmpType = _cursor.getString(_cursorIndexOfType);
              }
              _tmpLastMessage.setType(_tmpType);
              final String _tmpMessageId;
              if (_cursor.isNull(_cursorIndexOfMessageId)) {
                _tmpMessageId = null;
              } else {
                _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
              }
              _tmpLastMessage.setMessageId(_tmpMessageId);
              final String _tmpSenderId;
              if (_cursor.isNull(_cursorIndexOfSenderId)) {
                _tmpSenderId = null;
              } else {
                _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
              }
              _tmpLastMessage.setSenderId(_tmpSenderId);
              final String _tmpCreatedAt;
              if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
                _tmpCreatedAt = null;
              } else {
                _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
              }
              _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
              final String _tmpAck_id;
              if (_cursor.isNull(_cursorIndexOfAckId)) {
                _tmpAck_id = null;
              } else {
                _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
              }
              _tmpLastMessage.setAck_id(_tmpAck_id);
              final String _tmpConversationId;
              if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
                _tmpConversationId = null;
              } else {
                _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
              }
              _tmpLastMessage.setConversationId(_tmpConversationId);
              final String _tmpConversationType;
              if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
                _tmpConversationType = null;
              } else {
                _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
              }
              _tmpLastMessage.setConversationType(_tmpConversationType);
              final String _tmpUserChatId;
              if (_cursor.isNull(_cursorIndexOfUserChatId)) {
                _tmpUserChatId = null;
              } else {
                _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
              }
              _tmpLastMessage.setUserChatId(_tmpUserChatId);
              final String _tmpFilePath;
              if (_cursor.isNull(_cursorIndexOfFilePath)) {
                _tmpFilePath = null;
              } else {
                _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
              }
              _tmpLastMessage.setFilePath(_tmpFilePath);
              final String _tmpStatus;
              if (_cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
              }
              _tmpLastMessage.setStatus(_tmpStatus);
              final boolean _tmpIsEdited;
              final int _tmp;
              _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
              _tmpIsEdited = _tmp != 0;
              _tmpLastMessage.setEdited(_tmpIsEdited);
              final boolean _tmpIsDeleted;
              final int _tmp_1;
              _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
              _tmpIsDeleted = _tmp_1 != 0;
              _tmpLastMessage.setDeleted(_tmpIsDeleted);
              final List<String> _tmpDeliveredList;
              final String _tmp_2;
              if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
                _tmp_2 = null;
              } else {
                _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
              }
              _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
              _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
              final List<String> _tmpReadList;
              final String _tmp_3;
              if (_cursor.isNull(_cursorIndexOfReadList)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
              }
              _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
              _tmpLastMessage.setReadList(_tmpReadList);
              final List<String> _tmpOpenedList;
              final String _tmp_4;
              if (_cursor.isNull(_cursorIndexOfOpenedList)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
              }
              _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
              _tmpLastMessage.setOpenedList(_tmpOpenedList);
              final boolean _tmpIsExpire;
              final int _tmp_5;
              _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
              _tmpIsExpire = _tmp_5 != 0;
              _tmpLastMessage.setExpire(_tmpIsExpire);
              final boolean _tmpIsForwarded;
              final int _tmp_6;
              _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
              _tmpIsForwarded = _tmp_6 != 0;
              _tmpLastMessage.setForwarded(_tmpIsForwarded);
              final boolean _tmpIsConfidential;
              final int _tmp_7;
              _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
              _tmpIsConfidential = _tmp_7 != 0;
              _tmpLastMessage.setConfidential(_tmpIsConfidential);
              final boolean _tmpIsViewOnce;
              final int _tmp_8;
              _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
              _tmpIsViewOnce = _tmp_8 != 0;
              _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
              final boolean _tmpIsViewed;
              final int _tmp_9;
              _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
              _tmpIsViewed = _tmp_9 != 0;
              _tmpLastMessage.setViewed(_tmpIsViewed);
              final boolean _tmpIsDownloading;
              final int _tmp_10;
              _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
              _tmpIsDownloading = _tmp_10 != 0;
              _tmpLastMessage.setDownloading(_tmpIsDownloading);
              final boolean _tmpReadReceipts;
              final int _tmp_11;
              _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
              _tmpReadReceipts = _tmp_11 != 0;
              _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
              final boolean _tmpIsOpened;
              final int _tmp_12;
              _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
              _tmpIsOpened = _tmp_12 != 0;
              _tmpLastMessage.setOpened(_tmpIsOpened);
              final long _tmpMsgExpiryTime;
              _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
              _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
              final long _tmpExpireStarted;
              _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
              _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
              final List<String> _tmpPublic_key_list;
              final String _tmp_13;
              if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
                _tmp_13 = null;
              } else {
                _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
              }
              _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
              _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
              final String _tmpReceived_at;
              if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
                _tmpReceived_at = null;
              } else {
                _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
              }
              _tmpLastMessage.setReceived_at(_tmpReceived_at);
              final boolean _tmpIsCanShareForward;
              final int _tmp_14;
              _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
              _tmpIsCanShareForward = _tmp_14 != 0;
              _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
              final String _tmpChatNickUserChatId;
              if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
                _tmpChatNickUserChatId = null;
              } else {
                _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
              }
              _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
              final String _tmpChatNickData;
              if (_cursor.isNull(_cursorIndexOfChatNickData)) {
                _tmpChatNickData = null;
              } else {
                _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
              }
              _tmpLastMessage.setChatNickData(_tmpChatNickData);
              final String _tmpSenderPubKey;
              if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
                _tmpSenderPubKey = null;
              } else {
                _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
              }
              _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
              final String _tmpRecipientPubKeyFingerprint;
              if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
                _tmpRecipientPubKeyFingerprint = null;
              } else {
                _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
              }
              _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
              final String _tmpNextDHKey;
              if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
                _tmpNextDHKey = null;
              } else {
                _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
              }
              _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
              final int _tmpMessageCounter;
              _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
              _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
              final int _tmpChainIndex;
              _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
              _tmpLastMessage.setChainIndex(_tmpChainIndex);
              final String _tmpAVRatchetKeyMaterial;
              if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
                _tmpAVRatchetKeyMaterial = null;
              } else {
                _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
              }
              _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
            }  else  {
              _tmpLastMessage = null;
            }
            _item = new Conversation();
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _item.setUid(_tmpUid);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item.setName(_tmpName);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item.setDescription(_tmpDescription);
            final String _tmpConversationId_1;
            if (_cursor.isNull(_cursorIndexOfConversationId)) {
              _tmpConversationId_1 = null;
            } else {
              _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
            }
            _item.setConversationId(_tmpConversationId_1);
            final String _tmpConversationType_1;
            if (_cursor.isNull(_cursorIndexOfConversationType)) {
              _tmpConversationType_1 = null;
            } else {
              _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
            }
            _item.setConversationType(_tmpConversationType_1);
            final List<ConversationMember> _tmpConversationMembers;
            final String _tmp_15;
            if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
              _tmp_15 = null;
            } else {
              _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
            }
            _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
            _item.setConversationMembers(_tmpConversationMembers);
            final List<Payload> _tmpMessages;
            final String _tmp_16;
            if (_cursor.isNull(_cursorIndexOfMessages)) {
              _tmp_16 = null;
            } else {
              _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
            }
            _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
            _item.setMessages(_tmpMessages);
            final String _tmpOwner;
            if (_cursor.isNull(_cursorIndexOfOwner)) {
              _tmpOwner = null;
            } else {
              _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
            }
            _item.setOwner(_tmpOwner);
            final String _tmpCon_createdAt;
            if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
              _tmpCon_createdAt = null;
            } else {
              _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
            }
            _item.setCon_createdAt(_tmpCon_createdAt);
            final String _tmpKeepChatDate;
            if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
              _tmpKeepChatDate = null;
            } else {
              _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
            }
            _item.setKeepChatDate(_tmpKeepChatDate);
            final boolean _tmpIsRemoved;
            final int _tmp_17;
            _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
            _tmpIsRemoved = _tmp_17 != 0;
            _item.setRemoved(_tmpIsRemoved);
            final boolean _tmpIsArchived;
            final int _tmp_18;
            _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
            _tmpIsArchived = _tmp_18 != 0;
            _item.setArchived(_tmpIsArchived);
            final boolean _tmpIsInConversation;
            final int _tmp_19;
            _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
            _tmpIsInConversation = _tmp_19 != 0;
            _item.setInConversation(_tmpIsInConversation);
            final boolean _tmpIsViewOnce_1;
            final int _tmp_20;
            _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
            _tmpIsViewOnce_1 = _tmp_20 != 0;
            _item.setViewOnce(_tmpIsViewOnce_1);
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            _item.setPhoto(_tmpPhoto);
            final String _tmpConversationPhoto;
            if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
              _tmpConversationPhoto = null;
            } else {
              _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
            }
            _item.setConversationPhoto(_tmpConversationPhoto);
            final String _tmpMyMoniker;
            if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
              _tmpMyMoniker = null;
            } else {
              _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
            }
            _item.setMyMoniker(_tmpMyMoniker);
            final long _tmpConversationExpiryTime;
            _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
            _item.setConversationExpiryTime(_tmpConversationExpiryTime);
            final boolean _tmpIsCanShareForward_1;
            final int _tmp_21;
            _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
            _tmpIsCanShareForward_1 = _tmp_21 != 0;
            _item.setCanShareForward(_tmpIsCanShareForward_1);
            final boolean _tmpIsAutoSaveVault;
            final int _tmp_22;
            _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
            _tmpIsAutoSaveVault = _tmp_22 != 0;
            _item.setAutoSaveVault(_tmpIsAutoSaveVault);
            final boolean _tmpIsConfidential_1;
            final int _tmp_23;
            _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
            _tmpIsConfidential_1 = _tmp_23 != 0;
            _item.setConfidential(_tmpIsConfidential_1);
            final boolean _tmpIsMediaShareRestrict;
            final int _tmp_24;
            _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
            _tmpIsMediaShareRestrict = _tmp_24 != 0;
            _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
            final long _tmpSequenceOfConversation;
            _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
            _item.setSequenceOfConversation(_tmpSequenceOfConversation);
            final boolean _tmpIsPinned;
            final int _tmp_25;
            _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
            _tmpIsPinned = _tmp_25 != 0;
            _item.setPinned(_tmpIsPinned);
            final boolean _tmpHasSentMessage;
            final int _tmp_26;
            _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
            _tmpHasSentMessage = _tmp_26 != 0;
            _item.setHasSentMessage(_tmpHasSentMessage);
            final boolean _tmpConReadReceipts;
            final int _tmp_27;
            _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
            _tmpConReadReceipts = _tmp_27 != 0;
            _item.setConReadReceipts(_tmpConReadReceipts);
            final int _tmpUnreadCount;
            _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
            _item.setUnreadCount(_tmpUnreadCount);
            _item.setLastMessage(_tmpLastMessage);
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
  public List<Conversation> getArchiveConversations() {
    final String _sql = "SELECT * FROM conversation where isArchived like 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Conversation> getAllConversations() {
    final String _sql = "SELECT * FROM conversation";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Conversation> getAllConversationsNotRemoved() {
    final String _sql = "SELECT * FROM conversation where isArchived like 0 and isRemoved=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Conversation> getAllConversationsNotRemoved(final String conType) {
    final String _sql = "SELECT * FROM conversation where _conversation_type like ? and isRemoved =0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conType);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Conversation> getAllConversation() {
    final String _sql = "SELECT * FROM conversation where isArchived like 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Conversation> getAllSpecificConversations(final String conType) {
    final String _sql = "SELECT * FROM conversation where _conversation_type like ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conType);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Conversation> getAllViewOnce() {
    final String _sql = "SELECT * FROM conversation where isInConversation =0 and isViewOnce=1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Conversation getConversation(final String conversationId) {
    final String _sql = "SELECT * FROM conversation WHERE _conversation_id LIKE ?";
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
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final Conversation _result;
      if(_cursor.moveToFirst()) {
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _result = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _result.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _result.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _result.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _result.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _result.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _result.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _result.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _result.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _result.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _result.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _result.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _result.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _result.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _result.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _result.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _result.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _result.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _result.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _result.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _result.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _result.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _result.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _result.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _result.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _result.setUnreadCount(_tmpUnreadCount);
        _result.setLastMessage(_tmpLastMessage);
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
  public LiveData<String> getConversationName(final String conId) {
    final String _sql = "Select name from conversation where _conversation_id like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"conversation"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getString(0);
            }
          } else {
            _result = null;
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
  public LiveData<String> getConversationDescription(final String conId) {
    final String _sql = "Select description from conversation where _conversation_id like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (conId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, conId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"conversation"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getString(0);
            }
          } else {
            _result = null;
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
  public List<Conversation> getAllExpiryConversations() {
    final String _sql = "SELECT * FROM conversation where conversationExpiryTime>0 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Conversation> getAllBurningConversations() {
    final String _sql = "SELECT * FROM conversation where conversationExpiryTime=0 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_id");
      final int _cursorIndexOfConversationType = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversation_type");
      final int _cursorIndexOfConversationMembers = CursorUtil.getColumnIndexOrThrow(_cursor, "_conversationMembers");
      final int _cursorIndexOfMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "messages");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfConCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "con_createdAt");
      final int _cursorIndexOfKeepChatDate = CursorUtil.getColumnIndexOrThrow(_cursor, "keepChatDate");
      final int _cursorIndexOfIsRemoved = CursorUtil.getColumnIndexOrThrow(_cursor, "isRemoved");
      final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
      final int _cursorIndexOfIsInConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "isInConversation");
      final int _cursorIndexOfIsViewOnce = CursorUtil.getColumnIndexOrThrow(_cursor, "_isViewOnce");
      final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
      final int _cursorIndexOfConversationPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationPhoto");
      final int _cursorIndexOfMyMoniker = CursorUtil.getColumnIndexOrThrow(_cursor, "myMoniker");
      final int _cursorIndexOfConversationExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationExpiryTime");
      final int _cursorIndexOfIsCanShareForward = CursorUtil.getColumnIndexOrThrow(_cursor, "isCanShareForward");
      final int _cursorIndexOfIsAutoSaveVault = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSaveVault");
      final int _cursorIndexOfIsConfidential = CursorUtil.getColumnIndexOrThrow(_cursor, "_isConfidential");
      final int _cursorIndexOfIsMediaShareRestrict = CursorUtil.getColumnIndexOrThrow(_cursor, "_isMediaShareRestrict");
      final int _cursorIndexOfSequenceOfConversation = CursorUtil.getColumnIndexOrThrow(_cursor, "sequenceOfConversation");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfHasSentMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "hasSentMessage");
      final int _cursorIndexOfConReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "conReadReceipts");
      final int _cursorIndexOfUnreadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unreadCount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfAckId = CursorUtil.getColumnIndexOrThrow(_cursor, "ack_id");
      final int _cursorIndexOfConversationId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfConversationType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationType");
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
      final int _cursorIndexOfIsConfidential_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isConfidential");
      final int _cursorIndexOfIsViewOnce_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewOnce");
      final int _cursorIndexOfIsViewed = CursorUtil.getColumnIndexOrThrow(_cursor, "isViewed");
      final int _cursorIndexOfIsDownloading = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloading");
      final int _cursorIndexOfReadReceipts = CursorUtil.getColumnIndexOrThrow(_cursor, "readReceipts");
      final int _cursorIndexOfIsOpened = CursorUtil.getColumnIndexOrThrow(_cursor, "isOpened");
      final int _cursorIndexOfMsgExpiryTime = CursorUtil.getColumnIndexOrThrow(_cursor, "msgExpiryTime");
      final int _cursorIndexOfExpireStarted = CursorUtil.getColumnIndexOrThrow(_cursor, "expireStarted");
      final int _cursorIndexOfPublicKeyList = CursorUtil.getColumnIndexOrThrow(_cursor, "public_key_list");
      final int _cursorIndexOfReceivedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "received_at");
      final int _cursorIndexOfIsCanShareForward_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "payloadCanShareForward");
      final int _cursorIndexOfChatNickUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickUserChatId");
      final int _cursorIndexOfChatNickData = CursorUtil.getColumnIndexOrThrow(_cursor, "chatNickData");
      final int _cursorIndexOfSenderPubKey = CursorUtil.getColumnIndexOrThrow(_cursor, "senderPubKey");
      final int _cursorIndexOfRecipientPubKeyFingerprint = CursorUtil.getColumnIndexOrThrow(_cursor, "recipientPubKeyFingerprint");
      final int _cursorIndexOfNextDHKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDHKey");
      final int _cursorIndexOfMessageCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "messageCounter");
      final int _cursorIndexOfChainIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "chainIndex");
      final int _cursorIndexOfAVRatchetKeyMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "aVRatchetKeyMaterial");
      final List<Conversation> _result = new ArrayList<Conversation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Conversation _item;
        final Payload _tmpLastMessage;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfData) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfMessageId) && _cursor.isNull(_cursorIndexOfSenderId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfAckId) && _cursor.isNull(_cursorIndexOfConversationId_1) && _cursor.isNull(_cursorIndexOfConversationType_1) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfFilePath) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfIsEdited) && _cursor.isNull(_cursorIndexOfIsDeleted) && _cursor.isNull(_cursorIndexOfDeliveredList) && _cursor.isNull(_cursorIndexOfReadList) && _cursor.isNull(_cursorIndexOfOpenedList) && _cursor.isNull(_cursorIndexOfIsExpire) && _cursor.isNull(_cursorIndexOfIsForwarded) && _cursor.isNull(_cursorIndexOfIsConfidential_1) && _cursor.isNull(_cursorIndexOfIsViewOnce_1) && _cursor.isNull(_cursorIndexOfIsViewed) && _cursor.isNull(_cursorIndexOfIsDownloading) && _cursor.isNull(_cursorIndexOfReadReceipts) && _cursor.isNull(_cursorIndexOfIsOpened) && _cursor.isNull(_cursorIndexOfMsgExpiryTime) && _cursor.isNull(_cursorIndexOfExpireStarted) && _cursor.isNull(_cursorIndexOfPublicKeyList) && _cursor.isNull(_cursorIndexOfReceivedAt) && _cursor.isNull(_cursorIndexOfIsCanShareForward_1) && _cursor.isNull(_cursorIndexOfChatNickUserChatId) && _cursor.isNull(_cursorIndexOfChatNickData) && _cursor.isNull(_cursorIndexOfSenderPubKey) && _cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint) && _cursor.isNull(_cursorIndexOfNextDHKey) && _cursor.isNull(_cursorIndexOfMessageCounter) && _cursor.isNull(_cursorIndexOfChainIndex) && _cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial))) {
          _tmpLastMessage = new Payload();
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpLastMessage.setId(_tmpId);
          final String _tmpData;
          if (_cursor.isNull(_cursorIndexOfData)) {
            _tmpData = null;
          } else {
            _tmpData = _cursor.getString(_cursorIndexOfData);
          }
          _tmpLastMessage.setData(_tmpData);
          final String _tmpType;
          if (_cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = _cursor.getString(_cursorIndexOfType);
          }
          _tmpLastMessage.setType(_tmpType);
          final String _tmpMessageId;
          if (_cursor.isNull(_cursorIndexOfMessageId)) {
            _tmpMessageId = null;
          } else {
            _tmpMessageId = _cursor.getString(_cursorIndexOfMessageId);
          }
          _tmpLastMessage.setMessageId(_tmpMessageId);
          final String _tmpSenderId;
          if (_cursor.isNull(_cursorIndexOfSenderId)) {
            _tmpSenderId = null;
          } else {
            _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
          }
          _tmpLastMessage.setSenderId(_tmpSenderId);
          final String _tmpCreatedAt;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          _tmpLastMessage.setCreatedAt(_tmpCreatedAt);
          final String _tmpAck_id;
          if (_cursor.isNull(_cursorIndexOfAckId)) {
            _tmpAck_id = null;
          } else {
            _tmpAck_id = _cursor.getString(_cursorIndexOfAckId);
          }
          _tmpLastMessage.setAck_id(_tmpAck_id);
          final String _tmpConversationId;
          if (_cursor.isNull(_cursorIndexOfConversationId_1)) {
            _tmpConversationId = null;
          } else {
            _tmpConversationId = _cursor.getString(_cursorIndexOfConversationId_1);
          }
          _tmpLastMessage.setConversationId(_tmpConversationId);
          final String _tmpConversationType;
          if (_cursor.isNull(_cursorIndexOfConversationType_1)) {
            _tmpConversationType = null;
          } else {
            _tmpConversationType = _cursor.getString(_cursorIndexOfConversationType_1);
          }
          _tmpLastMessage.setConversationType(_tmpConversationType);
          final String _tmpUserChatId;
          if (_cursor.isNull(_cursorIndexOfUserChatId)) {
            _tmpUserChatId = null;
          } else {
            _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
          }
          _tmpLastMessage.setUserChatId(_tmpUserChatId);
          final String _tmpFilePath;
          if (_cursor.isNull(_cursorIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
          }
          _tmpLastMessage.setFilePath(_tmpFilePath);
          final String _tmpStatus;
          if (_cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
          }
          _tmpLastMessage.setStatus(_tmpStatus);
          final boolean _tmpIsEdited;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEdited);
          _tmpIsEdited = _tmp != 0;
          _tmpLastMessage.setEdited(_tmpIsEdited);
          final boolean _tmpIsDeleted;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
          _tmpIsDeleted = _tmp_1 != 0;
          _tmpLastMessage.setDeleted(_tmpIsDeleted);
          final List<String> _tmpDeliveredList;
          final String _tmp_2;
          if (_cursor.isNull(_cursorIndexOfDeliveredList)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getString(_cursorIndexOfDeliveredList);
          }
          _tmpDeliveredList = DeliverListConverter.JsonToList(_tmp_2);
          _tmpLastMessage.setDeliveredList(_tmpDeliveredList);
          final List<String> _tmpReadList;
          final String _tmp_3;
          if (_cursor.isNull(_cursorIndexOfReadList)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getString(_cursorIndexOfReadList);
          }
          _tmpReadList = DeliverListConverter.JsonToList(_tmp_3);
          _tmpLastMessage.setReadList(_tmpReadList);
          final List<String> _tmpOpenedList;
          final String _tmp_4;
          if (_cursor.isNull(_cursorIndexOfOpenedList)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getString(_cursorIndexOfOpenedList);
          }
          _tmpOpenedList = DeliverListConverter.JsonToList(_tmp_4);
          _tmpLastMessage.setOpenedList(_tmpOpenedList);
          final boolean _tmpIsExpire;
          final int _tmp_5;
          _tmp_5 = _cursor.getInt(_cursorIndexOfIsExpire);
          _tmpIsExpire = _tmp_5 != 0;
          _tmpLastMessage.setExpire(_tmpIsExpire);
          final boolean _tmpIsForwarded;
          final int _tmp_6;
          _tmp_6 = _cursor.getInt(_cursorIndexOfIsForwarded);
          _tmpIsForwarded = _tmp_6 != 0;
          _tmpLastMessage.setForwarded(_tmpIsForwarded);
          final boolean _tmpIsConfidential;
          final int _tmp_7;
          _tmp_7 = _cursor.getInt(_cursorIndexOfIsConfidential_1);
          _tmpIsConfidential = _tmp_7 != 0;
          _tmpLastMessage.setConfidential(_tmpIsConfidential);
          final boolean _tmpIsViewOnce;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfIsViewOnce_1);
          _tmpIsViewOnce = _tmp_8 != 0;
          _tmpLastMessage.setViewOnce(_tmpIsViewOnce);
          final boolean _tmpIsViewed;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfIsViewed);
          _tmpIsViewed = _tmp_9 != 0;
          _tmpLastMessage.setViewed(_tmpIsViewed);
          final boolean _tmpIsDownloading;
          final int _tmp_10;
          _tmp_10 = _cursor.getInt(_cursorIndexOfIsDownloading);
          _tmpIsDownloading = _tmp_10 != 0;
          _tmpLastMessage.setDownloading(_tmpIsDownloading);
          final boolean _tmpReadReceipts;
          final int _tmp_11;
          _tmp_11 = _cursor.getInt(_cursorIndexOfReadReceipts);
          _tmpReadReceipts = _tmp_11 != 0;
          _tmpLastMessage.setReadReceipts(_tmpReadReceipts);
          final boolean _tmpIsOpened;
          final int _tmp_12;
          _tmp_12 = _cursor.getInt(_cursorIndexOfIsOpened);
          _tmpIsOpened = _tmp_12 != 0;
          _tmpLastMessage.setOpened(_tmpIsOpened);
          final long _tmpMsgExpiryTime;
          _tmpMsgExpiryTime = _cursor.getLong(_cursorIndexOfMsgExpiryTime);
          _tmpLastMessage.setMsgExpiryTime(_tmpMsgExpiryTime);
          final long _tmpExpireStarted;
          _tmpExpireStarted = _cursor.getLong(_cursorIndexOfExpireStarted);
          _tmpLastMessage.setExpireStarted(_tmpExpireStarted);
          final List<String> _tmpPublic_key_list;
          final String _tmp_13;
          if (_cursor.isNull(_cursorIndexOfPublicKeyList)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = _cursor.getString(_cursorIndexOfPublicKeyList);
          }
          _tmpPublic_key_list = DeliverListConverter.JsonToList(_tmp_13);
          _tmpLastMessage.setPublic_key_list(_tmpPublic_key_list);
          final String _tmpReceived_at;
          if (_cursor.isNull(_cursorIndexOfReceivedAt)) {
            _tmpReceived_at = null;
          } else {
            _tmpReceived_at = _cursor.getString(_cursorIndexOfReceivedAt);
          }
          _tmpLastMessage.setReceived_at(_tmpReceived_at);
          final boolean _tmpIsCanShareForward;
          final int _tmp_14;
          _tmp_14 = _cursor.getInt(_cursorIndexOfIsCanShareForward_1);
          _tmpIsCanShareForward = _tmp_14 != 0;
          _tmpLastMessage.setCanShareForward(_tmpIsCanShareForward);
          final String _tmpChatNickUserChatId;
          if (_cursor.isNull(_cursorIndexOfChatNickUserChatId)) {
            _tmpChatNickUserChatId = null;
          } else {
            _tmpChatNickUserChatId = _cursor.getString(_cursorIndexOfChatNickUserChatId);
          }
          _tmpLastMessage.setChatNickUserChatId(_tmpChatNickUserChatId);
          final String _tmpChatNickData;
          if (_cursor.isNull(_cursorIndexOfChatNickData)) {
            _tmpChatNickData = null;
          } else {
            _tmpChatNickData = _cursor.getString(_cursorIndexOfChatNickData);
          }
          _tmpLastMessage.setChatNickData(_tmpChatNickData);
          final String _tmpSenderPubKey;
          if (_cursor.isNull(_cursorIndexOfSenderPubKey)) {
            _tmpSenderPubKey = null;
          } else {
            _tmpSenderPubKey = _cursor.getString(_cursorIndexOfSenderPubKey);
          }
          _tmpLastMessage.setSenderPubKey(_tmpSenderPubKey);
          final String _tmpRecipientPubKeyFingerprint;
          if (_cursor.isNull(_cursorIndexOfRecipientPubKeyFingerprint)) {
            _tmpRecipientPubKeyFingerprint = null;
          } else {
            _tmpRecipientPubKeyFingerprint = _cursor.getString(_cursorIndexOfRecipientPubKeyFingerprint);
          }
          _tmpLastMessage.setRecipientPubKeyFingerprint(_tmpRecipientPubKeyFingerprint);
          final String _tmpNextDHKey;
          if (_cursor.isNull(_cursorIndexOfNextDHKey)) {
            _tmpNextDHKey = null;
          } else {
            _tmpNextDHKey = _cursor.getString(_cursorIndexOfNextDHKey);
          }
          _tmpLastMessage.setNextDHKey(_tmpNextDHKey);
          final int _tmpMessageCounter;
          _tmpMessageCounter = _cursor.getInt(_cursorIndexOfMessageCounter);
          _tmpLastMessage.setMessageCounter(_tmpMessageCounter);
          final int _tmpChainIndex;
          _tmpChainIndex = _cursor.getInt(_cursorIndexOfChainIndex);
          _tmpLastMessage.setChainIndex(_tmpChainIndex);
          final String _tmpAVRatchetKeyMaterial;
          if (_cursor.isNull(_cursorIndexOfAVRatchetKeyMaterial)) {
            _tmpAVRatchetKeyMaterial = null;
          } else {
            _tmpAVRatchetKeyMaterial = _cursor.getString(_cursorIndexOfAVRatchetKeyMaterial);
          }
          _tmpLastMessage.setAVRatchetKeyMaterial(_tmpAVRatchetKeyMaterial);
        }  else  {
          _tmpLastMessage = null;
        }
        _item = new Conversation();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpConversationId_1;
        if (_cursor.isNull(_cursorIndexOfConversationId)) {
          _tmpConversationId_1 = null;
        } else {
          _tmpConversationId_1 = _cursor.getString(_cursorIndexOfConversationId);
        }
        _item.setConversationId(_tmpConversationId_1);
        final String _tmpConversationType_1;
        if (_cursor.isNull(_cursorIndexOfConversationType)) {
          _tmpConversationType_1 = null;
        } else {
          _tmpConversationType_1 = _cursor.getString(_cursorIndexOfConversationType);
        }
        _item.setConversationType(_tmpConversationType_1);
        final List<ConversationMember> _tmpConversationMembers;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfConversationMembers)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfConversationMembers);
        }
        _tmpConversationMembers = ConversationMemberListConverter.JsonToList(_tmp_15);
        _item.setConversationMembers(_tmpConversationMembers);
        final List<Payload> _tmpMessages;
        final String _tmp_16;
        if (_cursor.isNull(_cursorIndexOfMessages)) {
          _tmp_16 = null;
        } else {
          _tmp_16 = _cursor.getString(_cursorIndexOfMessages);
        }
        _tmpMessages = MessagesListConverter.JsonToList(_tmp_16);
        _item.setMessages(_tmpMessages);
        final String _tmpOwner;
        if (_cursor.isNull(_cursorIndexOfOwner)) {
          _tmpOwner = null;
        } else {
          _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        }
        _item.setOwner(_tmpOwner);
        final String _tmpCon_createdAt;
        if (_cursor.isNull(_cursorIndexOfConCreatedAt)) {
          _tmpCon_createdAt = null;
        } else {
          _tmpCon_createdAt = _cursor.getString(_cursorIndexOfConCreatedAt);
        }
        _item.setCon_createdAt(_tmpCon_createdAt);
        final String _tmpKeepChatDate;
        if (_cursor.isNull(_cursorIndexOfKeepChatDate)) {
          _tmpKeepChatDate = null;
        } else {
          _tmpKeepChatDate = _cursor.getString(_cursorIndexOfKeepChatDate);
        }
        _item.setKeepChatDate(_tmpKeepChatDate);
        final boolean _tmpIsRemoved;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsRemoved);
        _tmpIsRemoved = _tmp_17 != 0;
        _item.setRemoved(_tmpIsRemoved);
        final boolean _tmpIsArchived;
        final int _tmp_18;
        _tmp_18 = _cursor.getInt(_cursorIndexOfIsArchived);
        _tmpIsArchived = _tmp_18 != 0;
        _item.setArchived(_tmpIsArchived);
        final boolean _tmpIsInConversation;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsInConversation);
        _tmpIsInConversation = _tmp_19 != 0;
        _item.setInConversation(_tmpIsInConversation);
        final boolean _tmpIsViewOnce_1;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsViewOnce);
        _tmpIsViewOnce_1 = _tmp_20 != 0;
        _item.setViewOnce(_tmpIsViewOnce_1);
        final String _tmpPhoto;
        if (_cursor.isNull(_cursorIndexOfPhoto)) {
          _tmpPhoto = null;
        } else {
          _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        }
        _item.setPhoto(_tmpPhoto);
        final String _tmpConversationPhoto;
        if (_cursor.isNull(_cursorIndexOfConversationPhoto)) {
          _tmpConversationPhoto = null;
        } else {
          _tmpConversationPhoto = _cursor.getString(_cursorIndexOfConversationPhoto);
        }
        _item.setConversationPhoto(_tmpConversationPhoto);
        final String _tmpMyMoniker;
        if (_cursor.isNull(_cursorIndexOfMyMoniker)) {
          _tmpMyMoniker = null;
        } else {
          _tmpMyMoniker = _cursor.getString(_cursorIndexOfMyMoniker);
        }
        _item.setMyMoniker(_tmpMyMoniker);
        final long _tmpConversationExpiryTime;
        _tmpConversationExpiryTime = _cursor.getLong(_cursorIndexOfConversationExpiryTime);
        _item.setConversationExpiryTime(_tmpConversationExpiryTime);
        final boolean _tmpIsCanShareForward_1;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsCanShareForward);
        _tmpIsCanShareForward_1 = _tmp_21 != 0;
        _item.setCanShareForward(_tmpIsCanShareForward_1);
        final boolean _tmpIsAutoSaveVault;
        final int _tmp_22;
        _tmp_22 = _cursor.getInt(_cursorIndexOfIsAutoSaveVault);
        _tmpIsAutoSaveVault = _tmp_22 != 0;
        _item.setAutoSaveVault(_tmpIsAutoSaveVault);
        final boolean _tmpIsConfidential_1;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsConfidential);
        _tmpIsConfidential_1 = _tmp_23 != 0;
        _item.setConfidential(_tmpIsConfidential_1);
        final boolean _tmpIsMediaShareRestrict;
        final int _tmp_24;
        _tmp_24 = _cursor.getInt(_cursorIndexOfIsMediaShareRestrict);
        _tmpIsMediaShareRestrict = _tmp_24 != 0;
        _item.setMediaShareRestrict(_tmpIsMediaShareRestrict);
        final long _tmpSequenceOfConversation;
        _tmpSequenceOfConversation = _cursor.getLong(_cursorIndexOfSequenceOfConversation);
        _item.setSequenceOfConversation(_tmpSequenceOfConversation);
        final boolean _tmpIsPinned;
        final int _tmp_25;
        _tmp_25 = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp_25 != 0;
        _item.setPinned(_tmpIsPinned);
        final boolean _tmpHasSentMessage;
        final int _tmp_26;
        _tmp_26 = _cursor.getInt(_cursorIndexOfHasSentMessage);
        _tmpHasSentMessage = _tmp_26 != 0;
        _item.setHasSentMessage(_tmpHasSentMessage);
        final boolean _tmpConReadReceipts;
        final int _tmp_27;
        _tmp_27 = _cursor.getInt(_cursorIndexOfConReadReceipts);
        _tmpConReadReceipts = _tmp_27 != 0;
        _item.setConReadReceipts(_tmpConReadReceipts);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        _item.setUnreadCount(_tmpUnreadCount);
        _item.setLastMessage(_tmpLastMessage);
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
