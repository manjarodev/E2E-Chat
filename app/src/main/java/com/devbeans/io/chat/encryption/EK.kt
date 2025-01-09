package com.devbeans.io.chat.encryption

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class EK(
    identifier: String
) {

    @SerializedName("EKpubKey")
    var pubKey: String? = null
//        get() {
//            val hsm = HSM.with()
//            return hsm.getData(field!!, "pub$identifier")
//        }
//        set(value) {
//            val hsm = HSM.with()
//            field = hsm.storeData(value, "pub$identifier")
//        }

    @SerializedName("key_identifier")
    var identifier: String = identifier

    var id: Int = 0

    @SerializedName("EKprivKey")
    @Expose
    var privKey: String? = null
//        get() {
//            val hsm = HSM.with()
//            return hsm.getData(field!!, "priv$identifier")
//        }
//        set(value) {
//            val hsm = HSM.with()
//            field = hsm.storeData(value, "priv$identifier")
//        }
}