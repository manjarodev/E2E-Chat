package com.devbeans.io.chat.roomDB.Dao

import androidx.room.*
import com.devbeans.io.chat.encryption.EK
import com.devbeans.io.chat.encryption.SymmRatchet
import com.devbeans.io.chat.models.ConversationChannels
import com.devbeans.io.chat.models.SecretKey
import com.devbeans.io.chat.roomDB.TypeConverters.*


@Dao
interface ConversationChannelsDao {

    @Query("SELECT EXISTS(SELECT * FROM conversation_channels WHERE channelIdentifier = :identifier)")
    fun exist(identifier: String?): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(conversationchannel: ConversationChannels?)

    @Query("SELECT * FROM conversation_channels WHERE channelIdentifier LIKE :identifier")
    fun countChannels(identifier: String): List<ConversationChannels>

    @Query("SELECT * FROM conversation_channels WHERE channelIdentifier LIKE :identifier")
    fun getConversationChannel(identifier: String?): ConversationChannels?

    @TypeConverters(SecretKeyConverterSimple::class)
    @Query("UPDATE conversation_channels SET sk = :secretKey WHERE channelIdentifier = :identifier")
    fun updateSecretKey(identifier: String, secretKey: SecretKey)

    @TypeConverters(SymmRatchetConverterSimple::class)
    @Query("UPDATE conversation_channels SET SendRatchet = :sendRatchet WHERE channelIdentifier = :identifier")
    fun updateSenderRatchet(identifier: String, sendRatchet: SymmRatchet)

    @TypeConverters(SymmRatchetConverterSimple::class)
    @Query("UPDATE conversation_channels SET RecvRatchet = :receiverRatchet WHERE channelIdentifier = :identifier")
    fun updateReceiverRatchet(identifier: String, receiverRatchet: SymmRatchet)

    @TypeConverters(SymmRatchetConverterSimple::class)
    @Query("UPDATE conversation_channels SET RootRatchet = :rootRatchet WHERE channelIdentifier = :identifier")
    fun updateRootRatchet(identifier: String, rootRatchet: SymmRatchet)

    @Query("UPDATE conversation_channels SET RecipientPubKey = :recipientPubKey WHERE channelIdentifier = :identifier")
    fun updateRecipientPubKey(identifier: String, recipientPubKey: String)

    @Query("UPDATE conversation_channels SET FriendDHKey = :friendDHKey WHERE channelIdentifier = :identifier")
    fun updateFriendDHKey(identifier: String, friendDHKey: String)

    @Query("UPDATE conversation_channels SET isDHRacthetEnable = :isDHRacthetEnable WHERE channelIdentifier = :identifier")
    fun updateChannelDecrypting(identifier: String, isDHRacthetEnable: Boolean)

    @TypeConverters(EKConverterSimple::class)
    @Query("UPDATE conversation_channels SET DHRatchet = :dHRatchet WHERE channelIdentifier = :identifier")
    fun updateDhRatchet(identifier: String, dHRatchet: EK)

    @Query("UPDATE conversation_channels SET SendCounter = SendCounter + 1 WHERE channelIdentifier = :identifier")
    fun incrementSenderCount(identifier: String)

    @Query("UPDATE conversation_channels SET ReceiveCounter = ReceiveCounter + 1 WHERE channelIdentifier = :identifier")
    fun incrementReceiveCount(identifier: String)

    @Query("UPDATE conversation_channels SET FlipRatchetDirection = :direction WHERE channelIdentifier = :identifier")
    fun flipRatchetDirection(identifier: String, direction: Int)

    @Query("Delete from conversation_channels WHERE channelIdentifier = :identifier")
    fun deleteConversationChannel(identifier: String)

    @Update
    fun update(channel: ConversationChannels?)


}