package com.devbeans.io.chat.app

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devbeans.io.chat.BuildConfig
import com.devbeans.io.chat.encryption.SecretEk
import com.devbeans.io.chat.models.*
import com.devbeans.io.chat.roomDB.Dao.*
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import java.util.*

@Database(
    entities = [Contact::class, Conversation::class, Payload::class, OfflineMessage::class, KeyModel::class, SecreteKeyModel::class, GeneratedPrivateKeyByte::class, IdentityKeyPair::class, ChatKeyPair::class, ConversationChannels::class, SecretEk::class, OfflineAck::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao?
    abstract fun conversationsDao(): ConversationsDao?
    abstract fun messagesDao(): MessagesDao?
    abstract fun offlineMessagesDao(): OfflineMessagesDao?
    abstract fun keyPairDao(): KeyPairDao?
    abstract fun SecreteKeyDao(): SecreteKeyDao?
    abstract fun GeneratedDao(): GeneratedDao?
    abstract fun IdentityKeyPairDao(): IdentityKeyPairDao?
    abstract fun ChatKeyPairDao(): ChatKeyPairDao?
    abstract fun ConversationChannelsDao(): ConversationChannelsDao?
    abstract fun EKDao(): SecretEKDao?
    abstract fun offlineAckDao(): OfflineAckDao?

    companion object {
        private var INSTANCE: AppDatabase? = null

        @RequiresApi(Build.VERSION_CODES.P)
        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {

//                val factory =
//                    SupportFactory(Objects.requireNonNull(testKey.loadSecureKey(context))?.encoded);

                val factory = SupportFactory(SQLiteDatabase.getBytes("########################".toCharArray()))
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    BuildConfig.APPLICATION_ID + "_DATABASE"
                )
                    .fallbackToDestructiveMigration()
                    .openHelperFactory(factory)
                    .allowMainThreadQueries() //                            .setJournalMode(JournalMode.TRUNCATE)
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}