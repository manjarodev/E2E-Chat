package com.devbeans.io.chat.roomDB.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devbeans.io.chat.models.SecreteKeyModel

@Dao
interface SecreteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(SecreteKeyModel: SecreteKeyModel)

    @Query("Select * From SecreteKeyModel where secreteKey=:secreteKey")
    fun getByte(secreteKey: ByteArray): SecreteKeyModel?


    @Query("SELECT * FROM SecreteKeyModel where isExpired LIKE 0 and conversation_id like :conId")
    fun allKeysforConversation(conId: String): List<SecreteKeyModel>

    @get:Query("SELECT * FROM SecreteKeyModel where isExpired LIKE 0")
    val allKeys: List<SecreteKeyModel>

    @Query("SELECT * FROM SecreteKeyModel where identifier LIKE :identifier")
    fun getKey(identifier: String): SecreteKeyModel


    @Query("UPDATE SecreteKeyModel SET isExpired = 1 WHERE secreteKey = :secreteKey")
    fun update(secreteKey: ByteArray)


    @Query("UPDATE SecreteKeyModel SET isExpired = 1 WHERE conversation_id = :conId")
    fun updatePreviousSIR(conId: String)

    @Query("Delete from SecreteKeyModel where secreteKey=:secreteKey")
    fun deleteKey(secreteKey: ByteArray)
}