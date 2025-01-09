package com.devbeans.io.chat.roomDB.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devbeans.io.chat.models.GeneratedPrivateKeyByte

@Dao
interface GeneratedDao {

    @Insert
    fun insertKeys(generatedPrivateKeyByte: GeneratedPrivateKeyByte?)

    @Query("insert into generatedprivatekeybyte (privateKeyByte) values (:privateKey) ")
    fun insertKey(privateKey: ByteArray)

    @Query("insert into generatedprivatekeybyte (identifier) values (:identifer) ")
    fun insertidentiferKey(identifer: ByteArray)

    @Query("insert into generatedprivatekeybyte (pubPrivateKeyByte) values (:pub) ")
    fun insertpubKey(pub: ByteArray)

    @Query("select * from generatedprivatekeybyte where identifier=:identifier")
    fun getKeys(identifier: ByteArray): GeneratedPrivateKeyByte

    @get:Query("SELECT * FROM generatedprivatekeybyte")
    val allKeys: List<GeneratedPrivateKeyByte?>?

    @Query("update generatedprivatekeybyte set privateKeyByte=:privateKey where identifier=:identifier")
    fun updatePrivateKey(identifier: ByteArray, privateKey: ByteArray)

    @Query("update generatedprivatekeybyte set pubPrivateKeyByte=:publicKeys where identifier=:identifier")
    fun updatePublicKey(identifier: ByteArray, publicKeys: ByteArray)

    @Query("Select * from generatedprivatekeybyte where id =:id")
    fun getKeyID(id:Int):GeneratedPrivateKeyByte

}