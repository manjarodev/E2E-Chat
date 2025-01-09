package com.devbeans.io.chat.utils.avatar

import android.net.Uri
import com.devbeans.io.chat.R
import com.google.gson.annotations.SerializedName

/**
 * Represents an Avatar which the user can choose, edit, and render into a bitmap via the renderer.
 */
sealed class Avatar(
    @SerializedName("databaseId")
    open val databaseId: DatabaseId
) {
    data class Resource(
        @SerializedName("resourceId")
        val resourceId: Int,
        @SerializedName("color")
        val color: Avatars.ColorPair
    ) : Avatar(DatabaseId.DoNotPersist) {
        override fun isSameAs(other: Avatar): Boolean {
            return other is Resource && other.resourceId == resourceId
        }
    }

    data class Text(
        @SerializedName("text")
        val text: String,
        @SerializedName("color")
        val color: Avatars.ColorPair,
        @SerializedName("databaseId")
        override val databaseId: DatabaseId,
    ) : Avatar(databaseId) {
        override fun withDatabaseId(databaseId: DatabaseId): Avatar {
            return copy(databaseId = databaseId)
        }

        override fun isSameAs(other: Avatar): Boolean {
            return other is Text && other.databaseId == databaseId
        }
    }

    data class Vector(
        @SerializedName("key")
        val key: String,
        @SerializedName("color")
        val color: Avatars.ColorPair,
        @SerializedName("databaseId")
        override val databaseId: DatabaseId,
    ) : Avatar(databaseId) {
        override fun withDatabaseId(databaseId: DatabaseId): Avatar {
            return copy(databaseId = databaseId)
        }

        override fun isSameAs(other: Avatar): Boolean {
            return other is Vector && other.key == key
        }
    }

    data class Photo(
        @SerializedName("uri")
        val uri: Uri,
        @SerializedName("size")
        val size: Long,
        @SerializedName("databaseId")
        override val databaseId: DatabaseId
    ) : Avatar(databaseId) {
        override fun withDatabaseId(databaseId: DatabaseId): Avatar {
            return copy(databaseId = databaseId)
        }

        override fun isSameAs(other: Avatar): Boolean {
            return other is Photo && databaseId == other.databaseId
        }
    }

    open fun withDatabaseId(databaseId: DatabaseId): Avatar {
        throw UnsupportedOperationException()
    }

    abstract fun isSameAs(other: Avatar): Boolean

    companion object {
        fun getDefaultForSelf(): Resource =
            Resource(R.drawable.ic_profile_outline_40, Avatars.colors.random())

        fun getDefaultForGroup(): Resource =
            Resource(R.drawable.ic_group_outline_40, Avatars.colors.random())
    }

    sealed class DatabaseId {
        object DoNotPersist : DatabaseId()
        object NotSet : DatabaseId()
        data class Saved(val id: Long) : DatabaseId()
    }
}
