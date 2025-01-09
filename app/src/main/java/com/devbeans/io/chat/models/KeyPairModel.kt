package com.devbeans.io.chat.models

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.utils.JsonUtils
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.annotations.SerializedName
import com.virgilsecurity.sdk.crypto.VirgilKeyPair
import java.io.IOException

@Keep
data class KeyPairModel(
    var keyPair: VirgilKeyPair,
    var publicIdentifier: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KeyPairModel

        if (keyPair != other.keyPair) return false
        if (!publicIdentifier.contentEquals(other.publicIdentifier)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = keyPair.hashCode()
        result = 31 * result + publicIdentifier.contentHashCode()
        return result
    }
}

@Entity
@Keep
data class ChatKeyPair(
    @Ignore
    @SerializedName("privKey")
    var privKey: String = "",
    @Ignore
    @SerializedName("pubKey")
    var pubKey: String = "",

    @SerializedName("key_identifier")
    var identifier: String = "",
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)

fun ChatKeyPair.fromString(value: String): ChatKeyPair? {
    return try {
        JsonUtils.fromJson(value, ChatKeyPair::class.java)
    } catch (e: IOException) {
        Log.e(MainApp.TAG, "Exception in Extension of Models $e")
        return null
    }
}
