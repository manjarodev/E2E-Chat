package com.devbeans.io.chat.roomDB.Dao

import androidx.room.*
import com.devbeans.io.chat.models.ChatKeyPair

@Dao
interface ChatKeyPairDao {


    @Query("SELECT EXISTS(SELECT * FROM chatkeypair WHERE identifier = :identifier)")
    fun exist(identifier: String?): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chatKeyPair: ChatKeyPair?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(arrayList: ArrayList<ChatKeyPair>)

    @Delete
    fun delete(chatKeyPair: ChatKeyPair?)
}