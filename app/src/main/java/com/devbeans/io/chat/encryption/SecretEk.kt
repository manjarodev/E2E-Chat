package com.devbeans.io.chat.encryption

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.devbeans.io.chat.roomDB.TypeConverters.EKConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "secret_e_k")
@TypeConverters(EKConverter::class)
class SecretEk(
    @SerializedName("secret_key_identifier")
    var secret_key_identifier: String = "",
    var channel_identifier: String = "",
    var ek: EK? = null,
    var type: String = ""
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}