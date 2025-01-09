package com.devbeans.io.chat.network.serializers.requestbody

import com.devbeans.io.chat.models.ManifestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UploadSikRequest {
    @SerializedName("keyObject")
    @Expose
    var keyObject: ManifestModel.SIKClass? = null

    @SerializedName("chatAppId")
    @Expose
    var chatAppId: String? = null

}