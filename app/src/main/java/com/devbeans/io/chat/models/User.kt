package com.devbeans.io.chat.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.stfalcon.chatkit.commons.models.IUser
import java.io.Serializable

//public class User implements IUser {
//    @SerializedName("id")
//    @Expose
class User : IUser, Serializable {
    @SerializedName("id")
    private var id: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("avatar")
    @Expose
    private var avatar: String? = null

    @SerializedName("online")
    @Expose
    var isOnline = false

    @SerializedName("profile_image")
    @Expose
    var profileImage: String? = null

    @SerializedName("chatNickName")
    @Expose
    var chatNickName: String? = null

    @SerializedName("chatUserId")
    @Expose
    var chatUserId: String? = null

    @SerializedName("blockUsers")
    @Expose
    var blockUsers: List<String>? = null

    @SerializedName("profileImageLink")
    @Expose
    var profileImageLink: String? = null

    @SerializedName("moniker")
    @Expose
    var moniker: String? = null

    @SerializedName("publicKey")
    @Expose
    var publicKey: String? = null
    var profile_path: String? = null

    constructor(id: String?, name: String?, avatar: String?, online: Boolean) {
        this.id = id
        this.name = name
        this.avatar = avatar
        isOnline = online
    }

    constructor() {}

    fun setAvatar(avatar: String?) {
        this.avatar = avatar
    }

    override fun getId(): String {
        return chatUserId!!
    }

    override fun getName(): String {
        return name!!
    }

    override fun getAvatar(): String {
        return profileImage!!
    }

    override fun toString(): String {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", online=" + isOnline +
                ", profileImage='" + profileImage + '\'' +
                ", chatNickName='" + chatNickName + '\'' +
                ", chatUserId='" + chatUserId + '\'' +
                ", blockUsers=" + blockUsers +
                ", profileImageLink='" + profileImageLink + '\'' +
                ", profile_path='" + profile_path + '\'' +
                '}'
    }
}