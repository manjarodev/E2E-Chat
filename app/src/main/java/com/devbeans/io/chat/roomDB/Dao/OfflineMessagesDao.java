package com.devbeans.io.chat.roomDB.Dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.devbeans.io.chat.models.OfflineMessage;

import java.util.List;

@Dao
public interface OfflineMessagesDao {
    //Menu
    @Query("SELECT * FROM offlinemessage")
    LiveData<List<OfflineMessage>> getLiveMessages();

    @Query("SELECT * FROM OfflineMessage")
    List<OfflineMessage> getAllMessages();

    @Query("SELECT * FROM OfflineMessage WHERE conversationId LIKE :conversationId")
    List<OfflineMessage> getMessages(String conversationId);

    @Insert(onConflict = REPLACE)
    void insert(OfflineMessage offlineMessage);

    @Update()
    void update(OfflineMessage offlineMessage);

    @Query("UPDATE OfflineMessage SET deliveredList = :messages WHERE id = :conId")
    int updateMessage(long conId, String messages);

    @Delete
    void delete(OfflineMessage offlineMessgae);

    @Query("DELETE FROM OfflineMessage WHERE messageId = :id")
    void deleteById(String id);

    @Query("DELETE FROM OfflineMessage WHERE messageId = :messageId")
    void deleteByMessageId(String messageId);
    @Delete
     void delete(List<OfflineMessage> offlineMessages);

    @Query("DELETE FROM OfflineMessage")
     void deleteAll();
}
