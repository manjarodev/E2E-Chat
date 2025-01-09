package com.devbeans.io.chat.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ManifestModel {
    @SerializedName("identityPubKey")
    var identityPubKey: String? = null

    @SerializedName("identityPriKey")
    var identityPriKey: String? = null

    @SerializedName("fingerprintPubKey")
    var fingerprintPubKey: String? = null

    @SerializedName("expiry")
    var expiry: Int = 0

    @SerializedName("chatKeyClass")
    var chatKeyClass = ArrayList<ChatKeyClass>()

    class ChatKeyClass(
        @field:Expose @field:SerializedName("fingerprint") var fingerprint: String,
        @field:Expose @field:SerializedName("pubkeys") var pubkeys: String,
        @field:Expose @field:SerializedName("expiry") var expiry: Int
    )

    class SIKClass(
        @field:Expose @field:SerializedName("serverIdentityPubKey") var serverIdentityPubKey: String,
        @field:Expose @field:SerializedName("serverIdentityPubKeyX") var serverIdentityPubKeyX: String,
        @field:Expose @field:SerializedName("serverFingerprintPubKey") var serverFingerprintPubKey: String,
    )
}