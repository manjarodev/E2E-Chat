package com.devbeans.io.chat.encryption

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MappedPayload(

    @SerializedName("messageCipher")
    val messageCipher: String = "",
    @SerializedName("senderPubKey")
    val senderPubKey: String = "",
    @SerializedName("recipientPubKeyFingerprint")
    val recipientPubKeyFingerprint: String = "",
    @SerializedName("chainIndex")
    val chainIndex: Int = 0,
    @SerializedName("nextDHKey")
    val nextDHKey: String = "",
    @SerializedName("aVRatchetKeyMaterial")
    val aVRatchetKeyMaterial: String = "",
    @SerializedName("recipientId")
    val recipientId: String = ""
) : Serializable