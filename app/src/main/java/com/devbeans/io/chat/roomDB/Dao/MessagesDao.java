package com.devbeans.io.chat.roomDB.Dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.devbeans.io.chat.models.Payload;

import java.util.List;

@Dao
public interface MessagesDao {
    //Menu
    @Query("SELECT * FROM payload")
    LiveData<List<Payload>> getLiveMessages();

    @Query("SELECT * FROM payload")
    List<Payload> getAllMessages();

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId")
    List<Payload> getMessages(String conversationId);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId AND  status LIKE :status AND  senderId NOT LIKE :userID")
    LiveData<List<Payload>> getNotReadMessages(String conversationId, String status, String userID);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId AND  status LIKE :status AND  senderId NOT LIKE :userID")
    List<Payload> getUnReadMessages(String conversationId, String status, String userID);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId AND  status LIKE :status AND  senderId NOT LIKE :userID")
    List<Payload> getNotReadMessagesExpire(String conversationId, String status, String userID);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId AND filePath IS NOT NULL and  type LIKE 'image' or  type LIKE 'video' or type like 'audio'")
    LiveData<List<Payload>> getMediaData(String conversationId);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId AND filePath IS NOT NULL and  type LIKE 'file'")
    LiveData<List<Payload>> getDocsData(String conversationId);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId AND  type LIKE 'text'")
    LiveData<List<Payload>> getLinksData(String conversationId);

    @Query("SELECT * FROM payload WHERE id = (SELECT MAX(id) FROM payload) AND  conversationId LIKE :conId")
    Payload getLastMessage(String conId);

    @Query("SELECT * FROM payload WHERE messageId LIKE :messageId")
    Payload getMessage(String messageId);


    @Query("SELECT * FROM payload WHERE filePath IS NOT NULL and  isViewOnce like 1 and isOpened like 1 and isViewed like 1")
    List<Payload> getAllMessagesViewed();

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conId AND type NOT LIKE 'text' ")
    List<Payload> getAllMediaMessages(String conId);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conId and filePath IS NOT NULL AND type NOT LIKE 'text' ")
    List<Payload> getAllDownloadedMediaMessages(String conId);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conId AND type LIKE 'conv_expiry_self' ")
    List<Payload> getExpirySelfMessages(String conId);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conId AND type LIKE 'conv_expiry' ")
    List<Payload> getExpiryMessages(String conId);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conId AND isExpire LIKE 1 AND status like :status")
    List<Payload> getAllExpiryMessages(String conId, String status);

    @Query("SELECT * FROM payload WHERE isExpire LIKE 1 ")
    List<Payload> getAllExpiryMessage();

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId AND filePath IS NOT NULL  and senderId not like :senderID and  type LIKE 'image' or  type LIKE 'video' or type like 'audio' or type like 'file'")
    List<Payload> getReceiverDownloadedMediaData(String conversationId, String senderID);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conversationId AND filePath IS NOT NULL  and senderId like :senderID and  type LIKE 'image' or  type LIKE 'video' or type like 'audio' or type like 'file'")
    List<Payload> getSenderDownloadedMediaData(String conversationId, String senderID);


    @Query("SELECT * FROM payload WHERE conversationId LIKE :conId AND isExpire LIKE 1 AND status not like :status AND senderId like :senderID")
    List<Payload> getAllSenderExpiryMessages(String conId, String status, String senderID);

    @Query("SELECT * FROM payload WHERE conversationId LIKE :conId AND isExpire LIKE 1 AND status like :status AND senderId not like :senderID")
    List<Payload> getAllReceiverExpiryMessages(String conId, String status, String senderID);

    @Query("SELECT * FROM payload WHERE senderId not like :senderID and conversationType like :conType and filePath IS NULL AND type NOT LIKE 'text' and isDownloading like 0")
    List<Payload> getConSpecificAllMediaMessages(String senderID, String conType);

    @Insert(onConflict = REPLACE)
    void insert(Payload payload);

    @Update()
    void updateMessage(Payload payload);

    @Query("UPDATE payload SET deliveredList = :messages WHERE id = :conId")
    int updateMessage(long conId, String messages);

    @Query("UPDATE payload SET status=:status WHERE messageId = :messageId")
    int updateMessage(String status, String messageId);

    @Query("UPDATE payload SET data = :data  WHERE messageId like :messageId")
    void updateMessageData(String messageId, String data);

    @Query("UPDATE payload SET isDownloading = :isDownloading  WHERE messageId like :messageId")
    void updateMessageDownloading(String messageId, Boolean isDownloading);

    @Query("UPDATE payload SET isOpened = :opened  WHERE messageId like :messageId")
    void updateMessageOpened(String messageId, Boolean opened);


    @Query("UPDATE payload SET isViewed = :isViewed  WHERE messageId like :messageId")
    void updateMessageViewed(String messageId, Boolean isViewed);

    @Delete
    void delete(Payload payload);

    @Query("DELETE FROM payload WHERE id = :id")
    void deleteById(int id);

    @Query("UPDATE payload SET filePath = :file_path WHERE messageId = :id")
    void updateFilePath(String id, String file_path);

    @Query("UPDATE payload SET msgExpiryTime = :expiryTime WHERE messageId = :id")
    void updateMsgExpiryTime(String id, long expiryTime);

    @Query("UPDATE payload SET expireStarted = :expireStarted WHERE messageId = :id")
    void updateExpireInTime(String id, long expireStarted);

    @Query("DELETE FROM payload WHERE messageId = :messageId")
    void deleteByMessageId(String messageId);

    @Query("DELETE FROM payload WHERE id = :messageId")
    void deleteByMessageId(long messageId);

    @Query("Delete from payload where conversationId= :conId")
    void deleteConversationMessages(String conId);

    @Delete
    void delete(List<Payload> payloads);


    @Query("DELETE FROM payload")
    void deleteAll();
}
