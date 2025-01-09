package com.devbeans.io.chat.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class GeneratedPrivateKeyByte(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("privateKeyByte") var privateKeyByte: ByteArray? = null,
    @SerializedName("identifier") var identifier: ByteArray? = null,
    @SerializedName("pubPrivateKeyByte") var pubPrivateKeyByte: ByteArray? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GeneratedPrivateKeyByte

        if (privateKeyByte != null) {
            if (other.privateKeyByte == null) return false
            if (!privateKeyByte.contentEquals(other.privateKeyByte)) return false
        } else if (other.privateKeyByte != null) return false

        return true
    }

    override fun hashCode(): Int {
        return privateKeyByte?.contentHashCode() ?: 0
    }
}