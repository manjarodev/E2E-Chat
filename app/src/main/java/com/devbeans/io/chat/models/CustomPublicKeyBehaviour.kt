package com.devbeans.io.chat.models

import com.google.gson.annotations.SerializedName

data class CustomPublicKeyBehaviour(
    @SerializedName("publicKey")
    var publicKey: ByteArray,
    @SerializedName("fingerPrint")
    var fingerPrint: ByteArray,
    @SerializedName("membersId")
    var membersId: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CustomPublicKeyBehaviour

        if (!publicKey.contentEquals(other.publicKey)) return false
        if (!fingerPrint.contentEquals(other.fingerPrint)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = publicKey.contentHashCode()
        result = 31 * result + fingerPrint.contentHashCode()
        return result
    }
}

