package com.devbeans.io.chat.roomDB.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devbeans.io.chat.models.KeyModel

@Dao
interface KeyPairDao {
    @get:Query("SELECT * FROM keymodel")
    val liveALLKeys: LiveData<List<KeyModel?>?>?

    @get:Query("SELECT * FROM keymodel")
    val allKeys: List<KeyModel?>?

    @Query("SELECT * FROM keymodel WHERE identifer LIKE :identifier")
    fun getContact(identifier: ByteArray?): KeyModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(keymodel: KeyModel?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(arrayList: ArrayList<KeyModel?>?)

    @Delete
    fun delete(keymodel: KeyModel?)
}