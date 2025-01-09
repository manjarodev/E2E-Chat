package com.devbeans.io.chat.network.serializers.response

import com.devbeans.io.chat.models.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterUserResponse {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("user")
    @Expose
    var user: User? = null
}