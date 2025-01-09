package com.devbeans.io.chat.network.serializers.response

import com.devbeans.io.chat.models.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetProfileResponse {
    @SerializedName("status")
    @Expose
    var status: String = ""

    @SerializedName("user")
    @Expose
    var user: User? = null

    @SerializedName("data")
    var endData: String = ""

    @SerializedName("profileImageBucketLink")
    @Expose
    var profileImageBucketLink: String? = null

    @SerializedName("decData")
    @Expose
    val decData: String? = null



    override fun toString(): String {
        return "GetProfileResponse{" +
                "status='" + status + '\'' +
                ", user=" + user +
                ", profileImageBucketLink='" + profileImageBucketLink + '\'' +
                '}'
    }
}