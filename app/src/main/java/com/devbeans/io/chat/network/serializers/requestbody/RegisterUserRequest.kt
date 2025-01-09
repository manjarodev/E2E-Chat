package com.devbeans.io.chat.network.serializers.requestbody

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterUserRequest(
    @SerializedName("chatNickName")
    @Expose var chatNickName: String,
     @SerializedName("password")
    @Expose var password: String,
) {

    override fun toString(): String {
        return "RegisterUserRequest{" +
                "chatNickName='" + chatNickName + '\'' +
                '}'
    }
}