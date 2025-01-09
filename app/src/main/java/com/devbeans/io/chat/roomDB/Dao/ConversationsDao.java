package com.devbeans.io.chat.roomDB.Dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.devbeans.io.chat.models.Conversation;

import java.util.List;

@Dao
public interface ConversationsDao {
    //Menu
    @Query("SELECT * FROM conversation where isArchived like 0")
    LiveData<List<Conversation>> getLiveConversations();

    @Query("SELECT * FROM conversation where isArchived like 0 and isRemoved=0")
    LiveData<List<Conversation>> getLiveConversationsNotRemoved();

    @Query("SELECT * FROM conversation where isArchived like 1")
    LiveData<List<Conversation>> getLiveArchiveConversations();

    @Query("SELECT * FROM conversation where isArchived like 1")
    List<Conversation> getArchiveConversations();

    @Query("SELECT * FROM conversation")
    List<Conversation> getAllConversations();

    @Query("SELECT * FROM conversation where isArchived like 0 and isRemoved=0")
    List<Conversation> getAllConversationsNotRemoved();

    @Query("SELECT * FROM conversation where isArchived like 0")
    List<Conversation> getAllConversation();

    @Query("SELECT * FROM conversation where _conversation_type like :conType ")
    List<Conversation> getAllSpecificConversations(String conType);

    @Query("SELECT * FROM conversation where _conversation_type like :conType and isRemoved =0")
    List<Conversation> getAllConversationsNotRemoved(String conType);

    @Query("SELECT * FROM conversation where isInConversation =0 and isViewOnce=1")
    List<Conversation> getAllViewOnce();

    @Query("SELECT * FROM conversation WHERE _conversation_id LIKE :conversationId")
    Conversation getConversation(String conversationId);

    @Query("Select name from conversation where _conversation_id like :conId")
    LiveData<String> getConversationName(String conId);

    @Query("Select description from conversation where _conversation_id like :conId")
    LiveData<String> getConversationDescription(String conId);

    @Insert(onConflict = REPLACE)
    void insert(Conversation conversation);

    @Update()
    void update(Conversation conversation);

    @Query("UPDATE conversation SET messages = :messages WHERE _conversation_id = :conId")
    int updateTour(long conId, String messages);

    @Query("UPDATE conversation SET conversationPhoto = :conversation_photo WHERE _conversation_id = :id")
    void updateFilePath(String id, String conversation_photo);

    @Query("UPDATE conversation SET myMoniker = :my_moniker WHERE _conversation_id = :id")
    void updateMyMoniker(String id, String my_moniker);


    @Query("UPDATE conversation SET name = :conversation_name WHERE _conversation_id = :id")
    void updateConversationName(String id, String conversation_name);


    @Query("UPDATE conversation SET description = :description WHERE _conversation_id = :id")
    void updateConversationDes(String id, String description);

    @Query("UPDATE conversation SET conversationPhoto = :path , photo=:image_name  WHERE _conversation_id = :id")
    void updateConversationIcon(String id, String path, String image_name);


    @Query("UPDATE conversation SET _conversationMembers = :conversationMembers WHERE _conversation_id = :conId")
    void updateMember(String conId, String conversationMembers);

    @Query("UPDATE conversation SET name = :conversationName WHERE _conversation_id = :conId")
    void updateName(String conId, String conversationName);

    @Query("UPDATE conversation SET keepChatDate = :keepChatTime WHERE _conversation_id = :conId")
    void updateKeepChatTime(String conId, String keepChatTime);

    @Query("UPDATE conversation SET sequenceOfConversation = :sequenceOfConversation WHERE _conversation_id = :conId")
    void updateConversationSequenceTime(String conId, long sequenceOfConversation);

    @Query("UPDATE conversation SET conversationExpiryTime = :expireTime WHERE _conversation_id = :conId")
    void updateExpireTime(String conId, long expireTime);

    @Query("UPDATE conversation SET isCanShareForward = :canShareForward WHERE _conversation_id = :conId")
    void updateCanShareForward(String conId, boolean canShareForward);

    @Query("UPDATE conversation SET _isConfidential = :isConfidential WHERE _conversation_id = :conId")
    void updateIsConfidential(String conId, boolean isConfidential);

    @Query("UPDATE conversation SET conReadReceipts = :conReadReceipts WHERE _conversation_id = :conId")
    void updateReadReceipts(String conId, boolean conReadReceipts);

    @Query("UPDATE conversation SET hasSentMessage = :hasSentMessage WHERE _conversation_id = :conId")
    void updateHasSentMessage(String conId, boolean hasSentMessage);

    @Query("UPDATE conversation SET isAutoSaveVault = :autoSaveToVault WHERE _conversation_id = :conId")
    void updateAutoSaveToVault(String conId, boolean autoSaveToVault);

    @Query("UPDATE conversation SET isArchived = :isArchive WHERE _conversation_id = :conId")
    void updateConversationArchive(String conId, boolean isArchive);

    @Query("Update conversation set isInConversation= 1 where _conversation_id like :conId ")
    void updateInConversation(String conId);

    @Query("UPDATE conversation SET unreadCount = :unreadCount WHERE _conversation_id = :id")
    void updateConversationUnread(String id, Integer unreadCount);

    @Query("Update conversation set isInConversation = 0 where _conversation_id not like :conId ")
    void updateOtherInConversation(String conId);

    @Query("Update conversation set isInConversation = 0 where _conversation_id like :conId ")
    void updateLeftConversation(String conId);

    @Query("Update conversation set isViewOnce= :viewOnce where _conversation_id like :conId ")
    void updateViewOnce(String conId, boolean viewOnce);

    @Query("Update conversation set isRemoved= 1 where _conversation_id like :conId ")
    void updateRemovedConversation(String conId);

    @Query("UPDATE conversation SET isPinned = :isPinned WHERE _conversation_id = :conId")
    void updatePinnedConversation(String conId, boolean isPinned);

    @Query("SELECT * FROM conversation where conversationExpiryTime>0 ")
    List<Conversation> getAllExpiryConversations();

    @Query("SELECT * FROM conversation where conversationExpiryTime=0 ")
    List<Conversation> getAllBurningConversations();


    @Delete
    void delete(Conversation conversation);


//    @Query("SELECT * FROM event WHERE uniqueID LIKE :uid")
//    Event getEvent(String uid);

}
