package com.devbeans.io.chat.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import lombok.Data
import java.io.Serializable

@Data
@Entity
class Contact : Serializable {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("chatUserId")
    @Expose
    var chatUserId: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("color")
    @Expose
    var color: String? = null
    var isChecked = false

    @SerializedName("Avatar_color")
    @Expose
    var avatarColor: AvatarColor? = null

    @SerializedName("alias")
    @Expose
    var alias: String? = null

    @SerializedName("isBlocked")
    @Expose
    var isBlocked: Boolean = false

    @SerializedName("isQrAdded")
    @Expose
    var isQrAdded: Boolean = false

    constructor(name: String?, chatUserId: String?, image: String?) {
        this.name = name
        this.chatUserId = chatUserId
        this.image = image
    }


    @Ignore
    val columnNames = listOf(
        "id",
        "name",
        "chatUserId",
        "image",
        "color",
        "Avatar_color",
        "alias",
        "isBlocked",
        "isQrAdded"
    )

    @Ignore
    val columnValues = listOf(
        id.toString(),
        name,
        chatUserId,
        image,
        color,
        avatarColor.toString(),
        alias,
        isBlocked.toString().lowercase(),
        isQrAdded.toString().lowercase()
    )


    constructor() {}
    constructor(
        name: String?,
        chatUserId: String?,
        image: String?,
        color: String?,
        avatarColor: AvatarColor?,
        alias: String?,
        isBlocked: Boolean,
        isQrAdded: Boolean
    ) {
        this.name = name
        this.chatUserId = chatUserId
        this.image = image
        this.color = color
        this.avatarColor = avatarColor
        this.alias = alias
        this.isBlocked = isBlocked
        this.isQrAdded = isQrAdded
    }
}