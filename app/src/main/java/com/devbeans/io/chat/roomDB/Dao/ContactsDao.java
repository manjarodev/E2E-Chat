package com.devbeans.io.chat.roomDB.Dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.devbeans.io.chat.models.Contact;

import java.util.List;

@Dao
public interface ContactsDao {
    //Menu
    @Query("SELECT * FROM contact")
    LiveData<List<Contact>> getLiveContacts();

    @Query("SELECT * FROM contact")
    List<Contact> getAllContacts();

    @Query("SELECT * FROM contact where isBlocked=0")
    List<Contact> getAllUnBlockedContacts();

    @Query("SELECT * FROM contact WHERE chatuserid LIKE :chatUserId")
    Contact getContact(String chatUserId);

    @Query("update contact set name=:contactName where chatUserId=:chatUserId")
    void updateContactName(String chatUserId, String contactName);

    @Query("Update contact set isBlocked= :check where chatUserId like :chatUserId ")
    void updateBlock(String chatUserId, boolean check);


    @Query("DELETE FROM Contact WHERE chatUserId IN (:chatUserIds)")
    void deleteContactsByChatUserIds(List<String> chatUserIds);

    @Query("DELETE FROM Contact WHERE chatUserId = :chatUserId")
    void deleteContactByChatUserId(String chatUserId);

    @Insert(onConflict = REPLACE)
    void insert(Contact contact);

    @Delete
    void delete(Contact contact);


//    @Query("SELECT * FROM event WHERE uniqueID LIKE :uid")
//    Event getEvent(String uid);

}
