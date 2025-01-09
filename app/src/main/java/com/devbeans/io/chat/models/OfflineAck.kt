package com.devbeans.io.chat.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.devbeans.io.chat.roomDB.TypeConverters.PayloadTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "offlineAck")
@TypeConverters(PayloadTypeConverter::class)
data class OfflineAck(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id: Int = 0,
    @SerializedName("offlineAckId") var offlineAckId: String? = null,
    @SerializedName("payload") var payload: Payload? = null,
)
