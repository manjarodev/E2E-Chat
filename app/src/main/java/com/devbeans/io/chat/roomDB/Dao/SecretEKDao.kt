package com.devbeans.io.chat.roomDB.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devbeans.io.chat.encryption.SecretEk

@Dao
interface SecretEKDao {

    @Query("SELECT EXISTS(SELECT * FROM secret_e_k WHERE secret_key_identifier = :identifier)")
    fun exist(identifier: String?): Boolean


    @Query("SELECT * FROM secret_e_k WHERE channel_identifier = :identifier and type like 'DH'")
    fun getAllDhKeys(identifier: String?): List<SecretEk>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ek: SecretEk?)

    @Query("SELECT * FROM secret_e_k WHERE secret_key_identifier LIKE :identifier")
    fun getEk(identifier: String?): SecretEk?


}