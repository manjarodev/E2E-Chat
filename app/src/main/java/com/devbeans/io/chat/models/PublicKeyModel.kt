package com.devbeans.io.chat.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class PublicKeyModel {

    @SerializedName("ownerId")
    @Expose
    private var ownerId: String? = null

    @SerializedName("createdAt")
    @Expose
    private var createdAt: String? = null

    @SerializedName("keyId")
    @Expose
    private var keyId: String? = null

    @SerializedName("keyType")
    @Expose
    private var keyType: String? = null

    @SerializedName("state")
    @Expose
    private var state: String? = null

    @SerializedName("publicKey")
    @Expose
    private var publicKey: List<Int?>? = null

    @SerializedName("expiry")
    @Expose
    private var expiry: String? = null

    @SerializedName("keyFingerprint")
    @Expose
    private var keyFingerprint: List<Int?>? = null

    @SerializedName("keyFormat")
    @Expose
    private var keyFormat: String? = null

    fun getOwnerId(): String? {
        return ownerId
    }

    fun setOwnerId(ownerId: String?) {
        this.ownerId = ownerId
    }

    fun getCreatedAt(): String? {
        return createdAt
    }

    fun setCreatedAt(createdAt: String?) {
        this.createdAt = createdAt
    }

    fun getKeyId(): String? {
        return keyId
    }

    fun setKeyId(keyId: String?) {
        this.keyId = keyId
    }

    fun getKeyType(): String? {
        return keyType
    }

    fun setKeyType(keyType: String?) {
        this.keyType = keyType
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun getPublicKey(): List<Int?>? {
        return publicKey
    }

    fun setPublicKey(publicKey: List<Int?>?) {
        this.publicKey = publicKey
    }

    fun getExpiry(): String? {
        return expiry
    }

    fun setExpiry(expiry: String?) {
        this.expiry = expiry
    }

    fun getKeyFingerprint(): List<Int?>? {
        return keyFingerprint
    }

    fun setKeyFingerprint(keyFingerprint: List<Int?>?) {
        this.keyFingerprint = keyFingerprint
    }

    fun getKeyFormat(): String? {
        return keyFormat
    }

    fun setKeyFormat(keyFormat: String?) {
        this.keyFormat = keyFormat
    }

//    @SerializedName("code")
//    @Expose
//    private var code: Int? = null
//
//    @SerializedName("key")
//    @Expose
//    private var key: Key? = null
//
//    fun getCode(): Int? {
//        return code
//    }
//
//    fun setCode(code: Int?) {
//        this.code = code
//    }
//
//    fun getKey(): Key? {
//        return key
//    }
//
//    fun setKey(key: Key?) {
//        this.key = key
//    }
//
//    class Key {
//
//        @SerializedName("ownerId")
//        @Expose
//        private var ownerId: String? = null
//
//        @SerializedName("createdAt")
//        @Expose
//        private var createdAt: String? = null
//
//        @SerializedName("keyId")
//        @Expose
//        private var keyId: String? = null
//
//        @SerializedName("keyType")
//        @Expose
//        private var keyType: String? = null
//
//        @SerializedName("state")
//        @Expose
//        private var state: String? = null
//
//        @SerializedName("publicKey")
//        @Expose
//        private var publicKey: String? = null
//
//        @SerializedName("expiry")
//        @Expose
//        private var expiry: String? = null
//
//        @SerializedName("keyFingerprint")
//        @Expose
//        private var keyFingerprint: List<Int?>? = null
//
//        @SerializedName("keyFormat")
//        @Expose
//        private var keyFormat: String? = null
//
//        fun getOwnerId(): String? {
//            return ownerId
//        }
//
//        fun setOwnerId(ownerId: String?) {
//            this.ownerId = ownerId
//        }
//
//        fun getCreatedAt(): String? {
//            return createdAt
//        }
//
//        fun setCreatedAt(createdAt: String?) {
//            this.createdAt = createdAt
//        }
//
//        fun getKeyId(): String? {
//            return keyId
//        }
//
//        fun setKeyId(keyId: String?) {
//            this.keyId = keyId
//        }
//
//        fun getKeyType(): String? {
//            return keyType
//        }
//
//        fun setKeyType(keyType: String?) {
//            this.keyType = keyType
//        }
//
//        fun getState(): String? {
//            return state
//        }
//
//        fun setState(state: String?) {
//            this.state = state
//        }
//
//        fun getPublicKey(): String? {
//            return publicKey
//        }
//
//        fun setPublicKey(publicKey: String?) {
//            this.publicKey = publicKey
//        }
//
//        fun getExpiry(): String? {
//            return expiry
//        }
//
//        fun setExpiry(expiry: String?) {
//            this.expiry = expiry
//        }
//
//        fun getKeyFingerprint(): List<Int?>? {
//            return keyFingerprint
//        }
//
//        fun setKeyFingerprint(keyFingerprint: List<Int?>?) {
//            this.keyFingerprint = keyFingerprint
//        }
//
//        fun getKeyFormat(): String? {
//            return keyFormat
//        }
//
//        fun setKeyFormat(keyFormat: String?) {
//            this.keyFormat = keyFormat
//        }
//    }
    }