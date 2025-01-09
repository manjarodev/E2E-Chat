package com.devbeans.io.chat.roomDB.Dao

import androidx.room.*
import com.devbeans.io.chat.models.OfflineAck
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.roomDB.TypeConverters.PayloadTypeConverter

@Dao
interface OfflineAckDao {

    @Query("SELECT EXISTS(SELECT * FROM offlineAck WHERE offlineAckId = :identifier)")
    fun exist(identifier: String?): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(offlineAck: OfflineAck)

    @Query("SELECT * FROM offlineAck ")
    fun getAllAck(): List<OfflineAck>

    @Query("SELECT * FROM offlineAck WHERE offlineAckId LIKE :identifier")
    fun getOfflineAck(identifier: String?): OfflineAck?


    @Query("DELETE FROM offlineAck WHERE offlineAckId = :identifier")
    fun deleteAckById(identifier: String)

    @TypeConverters(PayloadTypeConverter::class)
    @Query("UPDATE offlineAck SET payload = :payload WHERE offlineAckId = :identifier")
    fun updateOfflineAck(identifier: String, payload: Payload?): Int

    @Update
    fun updateAck(offlineAck: OfflineAck?)




}