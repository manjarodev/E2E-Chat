package com.devbeans.io.chat.roomDB.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devbeans.io.chat.models.IdentityKeyPair

@Dao
interface IdentityKeyPairDao {
    @Insert
    fun insertKeys(identityKeyPair: IdentityKeyPair?)

    @Query("insert into identityKeyPair (privateKeyByte) values (:privateKey) ")
    fun insertKey(privateKey: ByteArray)

    @Query("insert into identityKeyPair (identifier) values (:identifer) ")
    fun insertidentiferKey(identifer: ByteArray)

    @Query("insert into identityKeyPair (pubPrivateKeyByte) values (:pub) ")
    fun insertpubKey(pub: ByteArray)

    @Query("select * from identityKeyPair where identifier=:identifier")
    fun getKeys(identifier: ByteArray): IdentityKeyPair

    @get:Query("SELECT * FROM identityKeyPair")
    val allKeys: List<IdentityKeyPair?>?

    @Query("update identityKeyPair set privateKeyByte=:privateKey where identifier=:identifier")
    fun updatePrivateKey(identifier: ByteArray, privateKey: ByteArray)

    @Query("update identityKeyPair set pubPrivateKeyByte=:publicKeys where identifier=:identifier")
    fun updatePublicKey(identifier: ByteArray, publicKeys: ByteArray)

    @Query("Select * from identityKeyPair where id =:id")
    fun getKeyID(id:Int): IdentityKeyPair
}