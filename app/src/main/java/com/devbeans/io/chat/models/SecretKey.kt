package com.devbeans.io.chat.models

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SecretKey(secretKeyId: String) {


    @SerializedName("secretKeyId")
    @Expose
    var secretKeyId: String? = "secretKey$secretKeyId"


    @SerializedName("secretKey")
    @Expose
    @ColumnInfo(name = "secret_key")
    var secretKey: String? = null
//        get() {
//            val hsm = HSM.with()
//            return hsm.getData(field!!, "secretKey$secretKeyId")
//        }
//        set(value) {
//            val hsm = HSM.with()
//            field = hsm.storeData(value, "secretKey$secretKeyId")
//        }

}