package com.devbeans.io.chat.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class DeleteKeyStoreModel {
    @SerializedName("code")
    @Expose
    private var code: Int? = null

    @SerializedName("key")
    @Expose
    private var key: Key? = null

    fun getCode(): Int? {
        return code
    }

    fun setCode(code: Int?) {
        this.code = code
    }

    fun getKey(): Key? {
        return key
    }

    fun setKey(key: Key?) {
        this.key = key
    }
    class Key {
        @SerializedName("acknowledged")
        @Expose
        var acknowledged: Boolean? = null

        @SerializedName("deletedCount")
        @Expose
        var deletedCount: Int? = null
    }
}