package com.devbeans.io.chat.utils

import android.Manifest
import android.net.Uri
import android.os.Build
import android.os.Looper
import androidx.annotation.ChecksSdkIntAtLeast
import java.nio.charset.StandardCharsets

object Constants {


    @JvmField
    var NICK_NAME: String? = null
    const val NOT_DELIVERED = "0"
    const val SENT = "1"
    const val DELIVERED = "2"
    const val SEEN = "3"
    const val PCAPITAL = "(?=.*[A-Z])"
    const val PPATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,24})"
    const val END_POINT = "End Point:"
    const val RESPONSE = " Response: "
    const val REQUEST = " Request: "
    const val GRANT_PERMISSION = "Grant permissions to use gallery"
    const val FILE_NOT_EXIST = "File does not exist"
    const val NO_DATA_FOUND = "No data found"
    const val PROVIDER = ".provider"
    const val CONTACTS_DETAILS_ACTIVITY = "ContactDetailActivity blockUser: "
    const val CHAT_DETAILS_ADD_MEMBER = "Chat Details Activity AddMember: "
    const val MESSAGE = "onMessage: "
    const val ON_SUCCESS = "onSuccess: "
    const val CONVERSATION_ID = "conversation_id="
    const val MEMBERS_COUNT = "%d of %d"
    const val DOWNLOADER_ONE_TO_ONE = "Downloader One to One"
    const val CHANGE_OWNER = "Change Owner"
    const val LEAVE_GROUP = "Leave Group"

    @JvmField
    var URI: Uri? = null
    const val CAMERA_PERMISSIONS = Manifest.permission.CAMERA
    var TITLE: String? = null

    //    public static byte[] SALT_SYMMETRIC_PARAM_ = "My unique byte array for encryption and decryption".getBytes();
    var SALT_SYMMETRIC_PARAM = shorten(12)
    var NONCE = "########################".toByteArray(StandardCharsets.UTF_8)
    var IVSALT = "spspspspsp".toByteArray(StandardCharsets.UTF_8)
    var ImageBucketLink = "imageBucketLink"
    fun shorten(length: Int): ByteArray {
        val SALT_SYMMETRIC_PARAM_ =
            "My unique byte array for encryption and decryption".toByteArray()
        if (length == SALT_SYMMETRIC_PARAM_.size) {
            return SALT_SYMMETRIC_PARAM_
        }
        val result = ByteArray(length)
        System.arraycopy(SALT_SYMMETRIC_PARAM_, 0, result, 0, length)
        return result
    }

    val byte: ByteArray
        get() {
            val dest = ByteArray(12)
            var SALT_SYMMETRIC_PARAM_ =
                "My unique byte array for encryption and decryption".toByteArray()
            for (index in 0..11) {
                val b1 = SALT_SYMMETRIC_PARAM_[index]
                dest[index] = b1
            }
            SALT_SYMMETRIC_PARAM_ = dest
            return dest
        }
    var MESSAGE_TYPE = arrayOf(
        "text",
        "image",
        "video",
        "audio",
        "file"
    )
    var mimeTypes = arrayOf(
        "application/msword",
        "application/pdf",
        "text/plain",
        "audio/*",
        "video/mp4",
        "image/*"
    )
    var image = arrayOf(
        "image/*",
        "video/mp4"
    )
    var video = arrayOf("video/mp4")
    var file = arrayOf("application/pdf")
    var audio = arrayOf("audio/*")
    const val FIRST_RUN = "FIRST_RUN"
    const val isDialog = "isDialogShown"
    const val isDialogAppLock = "isDialogDeviceShown"
    const val isThemeSwitch = "theme.switch"
    const val isTimerSet = "auto.lock.timer"

    object KEYS {
        const val INTENT_FROM_SPLASH = "com.From.SplashFragment"
        const val WAS_SHOWING: String = "com.wasShowing.dialog"
        const val INTENT_FROM_AUTO_LOCK = "settings.from.auto.lock"
        const val INTENT_FROM_WIPE_DATA = "settings.from.wipe.data"
        const val INTENT_DRAWABLE = "wallpaper.drawable"
        const val INTENT_FILE = "wallpaper.file"
        const val INTENT_SIK = "SIK"
        const val INTENT_SIK_X = "SIK.X"
        const val INTENT_IK = "IK"
        const val USER_CHAT_ID = "userChatId"
        const val CHAT_USER_ID = "chatUserId"
        const val CONVERSATION_ID = "conversationId"
        const val IS_VIEW_ONCE = "isViewOnce"
        const val CONVERSATION_DESCRIPTION = "description"
        const val CONVERSATION_NAME = "name"
        const val CONVERSATION_EXPIRY_TIME = "conversationExpiryTime"
        const val CONVERSATION_IS_CONFIDENTIAL = "isConfidential"
        const val CONVERSATION_IS_MEDIA_SHARE_RESTRICT = "isMediaShareRestrict"
        const val STATUS = "status"
        const val MESSAGE = "message"
        const val IMAGE_BUCKET_LINK = "imageBucketLink"
        const val MEDIA = "media"
        const val MEDIA_TYPE = "mediaType"
        const val MEMBER = "member"
        const val MEMBERS = "members"
        const val REMOVE_MEMBER = "Remove member"
        const val INTENT_FILE_PATH = "filePath"
        const val INTENT_VIEW_ONCE = "intent_view_once"
        const val INTENT_VIEW_ONCE_CHAT = "intent_view_once_chat"
        const val INTENT_BUNDLE = "intent_bundle"
        const val INTENT_NEW_CONVERSATION = "new conversation"
        const val INTENT_CONTACT = "contact"
        const val INTENT_NO_CONTACT = "no contact"
        const val INTENT_CONVERSATION = "conversation"
        const val INTENT_FROM_FORWARD = "from_forward"
        const val INTENT_URI_FROM_VAULT = "uriFromVault"
        const val INTENT_IS_FROM_VAULT = "isFromVault"
        const val INTENT_TYPE = "type"
        const val INTENT_FROM_REMOVE_VIEW_ACTIVITY = "remove_view_activity"
        const val DUMMY_IMAGE = "image_test_092.jpg"
        const val EXPIRY_TIME = "expiryTime"
        const val INTENT_MEMBER_ID = "member_id"
        const val INTENT_FILE_SELECTED = "file_selected"
        const val INTENT_MEMBER_NAME = "member_name"
        const val INTENT_MEMBER_LIST = "member_list"
        const val INTENT_MEDIA_URI = "uri"
        const val INTENT_MEDIA_PATH = "path"
        const val INTENT_DISAPPEARING = "disapearing"
        const val INTENT_DISAPPEAR_TIME = "dispear_time"
        const val INTENT_DISAPPEAR_TIME_RESULT = "dispear_time_result"
        const val INTENT_CONVERSATION_EXPIRY = "conversation_expiry_time"
        const val INTENT_PAYLOAD = "message.payload"
        const val BLOCK = "Block"
        const val UNBLOCK = "Unblock"
        const val IMAGEBUCKETLINK = "imageBucketLink"
        const val CONVERSATION_OBJ = "conversationObj"
        const val INTENT_SENDER_ID = "chat.senderId"
        const val INTENT_FROM_CAMERA = "chat.camera"
        const val INTENT_SELECTED_FILE = "chat.selected.File"
        const val INTENT_CONTACT_FILE = "chat.contacts.exported"
    }

    object DISAPPEARING_STRINGS {
        const val _off = "Off"
        const val _f = -1
        const val _ds = 0
        const val _s = 1
        const val _m = 2
        const val _h = 3
        const val _d = 4
        const val _burn_on_read = "View Once"
        const val _10_seconds = "10 seconds"
        const val _30_seconds = "30 seconds"
        const val _1_minute = "1 minute"
        const val _5_minutes = "5 minutes"
        const val _10_minutes = "10 minutes"
        const val _30_minutes = "30 minutes"
        const val _1_hour = "1 hour"
        const val _2_hours = "2 hours"
        const val _3_hours = "3 hours"
        const val _8_hours = "8 hours"
        const val _12_hours = "12 hours"
        const val _1_day = "1 day"
        const val _5_days = "5 days"
        const val _10_days = "10 days"
        const val _seconds = "seconds"
        const val _minutes = "minutes"
        const val _hours = "hours"
        const val _days = "days"
        const val _week = "weeks"
    }

    object TYPES {
        const val PONG: String = "pong"
        const val PING: String = "ping"
        const val CONVERSATION_ONE_TO_ONE = "one-to-one"
        const val CONVERSATION_GROUP = "group"
        const val CONVERSATION_GROUP_ANONYMOUS = "anonymous"
        const val MEDIA = "media"

        //Payload Types
        const val SIR = "SIR"
        const val TEXT = "text"
        const val FILE = "file"
        const val IMAGE = "image"
        const val AUDIO = "audio"
        const val VIDEO = "video"
        const val EDIT = "edit"
        const val DELETE = "delete"
        const val MEMBER_ADDED = "member_added"
        const val MEMBER_REMOVED = "member_removed"
        const val ADMIN_ASSIGNED = "admin_assigned"
        const val ADMIN_REMOVED = "admin_removed"
        const val MEMBER_LEAVE = "member_leave"
        const val CHANGE_OWNER = "change_owner"
        const val EXPIRE_MSG = "conv_expiry"
        const val EXPIRE_MSG_SELF = "conv_expiry_self"
        const val GROUP_NAME_CHANGE = "group_name_change"
        const val ANONYMOUS_GROUP_CONV_CREATED = "annonymouns_conv_created"
        const val VIEW_ONCE = "view_once"
        const val GROUP_CONV_CREATED = "conv_created"
        const val GROUP_ICON_CHANGE = "group_icon_change"
        const val GROUP_DES_CHANGE = "group_description_change"
        const val GROUP_IS_CONFIDENTIAL_CHANGE = "group_is_confidential_change"
        const val GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE = "group_is_media_share_restrict_change"
        const val DESTROY_GROUP = "destroy_group"
        const val BLOCK = "block"
        const val UNBLOCK = "unblock"
        const val KEY_DEFICIENCY = "key_deficiency"
        const val ACK_EDIT = "ack_edit"
        const val ACK_DELETE = "ack_delete"
        const val ACK_READ = "ack_read"
        const val ACK_IS_VIEW_ONCE = "ack_is_view_once"
        const val ACK_DELIVER = "ack_deliver"
        const val CONFIRM_ACK_READ = "confirm_ack_read"
        const val CONFIRM_ACK_IS_VIEW_ONCE = "confirm_ack_is_view_once"
        const val CONFIRM_ACK_DELIVER = "confirm_ack_deliver"
        const val CONFIRM_ACK_EDIT = "confirm_ack_edit"
        const val CONFIRM_ACK_DELETE = "confirm_ack_delete"
        const val CONFIRM_ACK_MEMBER_ADD = "confirm_ack_member_add"
        const val CONFIRM_ACK_MEMBER_REMOVE = "confirm_ack_member_remove"
        const val CONFIRM_ACK_MEMBER_LEAVE = "confirm_ack_member_leave"
        const val CONFIRM_ACK_ADMIN_ASSIGNED = "confirm_ack_admin_assigned"
        const val CONFIRM_ACK_ADMIN_REMOVED = "confirm_ack_admin_removed"
        const val CONFIRM_ACK_GROUP_ICON_CHANGE = "confirm_ack_group_icon_change"
        const val CONFIRM_ACK_GROUP_NAME_CHANGE = "confirm_ack_group_name_change"
        const val CONFIRM_ACK_GROUP_DES_CHANGE = "confirm_ack_group_description_change"
        const val CONFIRM_ACK_GROUP_CONV_CREATED = "confirm_ack_conv_created"
        const val CONFIRM_ANONYMOUS_GROUP_CONV_CREATED = "confirm_ack_annonymouns_conv_created"
        const val CONFIRM_ACK_KEY_DEFICIENCY = "confirm_ack_key_deficiency"
        const val ACK_CON_EX_CHANGE = "confirm_ack_conv_expiry"
        const val CONFIRM_ACK_LEAVE_GROUP = "confirm_ack_leave_group"
        const val CONFIRM_ACK_VIEW_ONCE = "confirm_ack_view_once"
        const val CONFIRM_ACK_DESTROY_GROUP = "confirm_ack_destroy_group"
        const val CONFIRM_ACK_BLOCK_UNKNOWN = "confirm_block_unknown"
        const val CONFIRM_ACK_BLOCK = "confirm_ack_block"
        const val CONFIRM_ACK_UNBLOCK = "confirm_ack_unblock"
        const val CONFIRM_ACK_IS_CONFIDENTIAL_CHANGE = "confirm_ack_is_confidential_change"
        const val CONFIRM_ACK_IS_MEDIA_SHARE_RESTRICT_CHANGE =
            "confirm_ack_is_media_share_restrict_change"
    }

    fun isOnMainThread() = Looper.myLooper() == Looper.getMainLooper()


//    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.TIRAMISU)
//    fun isTiramisuPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU


    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.M)
    fun isMarshmallowPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N)
    fun isNougatPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N_MR1)
    fun isNougatMR1Plus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O)
    fun isOreoPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O_MR1)
    fun isOreoMr1Plus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.P)
    fun isPiePlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.Q)
    fun isQPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.R)
    fun isRPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
    fun isSPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    fun ensureBackgroundThread(callback: () -> Unit) {
        if (isOnMainThread()) {
            Thread {
                callback()
            }.start()
        } else {
            callback()
        }
    }

    // permissions
    const val PERMISSION_READ_STORAGE = 1
    const val PERMISSION_WRITE_STORAGE = 2
    const val PERMISSION_CAMERA = 3
    const val PERMISSION_RECORD_AUDIO = 4
    const val PERMISSION_READ_CONTACTS = 5
    const val PERMISSION_WRITE_CONTACTS = 6
    const val PERMISSION_READ_CALENDAR = 7
    const val PERMISSION_WRITE_CALENDAR = 8
    const val PERMISSION_CALL_PHONE = 9
    const val PERMISSION_READ_CALL_LOG = 10
    const val PERMISSION_WRITE_CALL_LOG = 11
    const val PERMISSION_GET_ACCOUNTS = 12
    const val PERMISSION_READ_SMS = 13
    const val PERMISSION_SEND_SMS = 14
    const val PERMISSION_READ_PHONE_STATE = 15
    const val PERMISSION_MEDIA_LOCATION = 16
    const val PERMISSION_POST_NOTIFICATIONS = 17
    const val PERMISSION_READ_MEDIA_IMAGES = 18
    const val PERMISSION_READ_MEDIA_VIDEO = 19
    const val PERMISSION_READ_MEDIA_AUDIO = 20
    const val NOMEDIA = ".nomedia"
    const val MD5 = "MD5"


    object SETTINGS {
        const val ACTION_RECYCLE_BIN = "chat.settings.enable.recyclebin"
        const val ACTION_AUTO_DELETE = "chat.settings.delete.notes"
        const val ACTION_AUTO_BACKUP = "chat.settings.auto.backup"
        const val ACTION_MAX_ATTEMPTS = "chat.settings.max.attempts"
    }

    object LOCK {
        const val KEY_KEEP_LOCK = "chat.keep.lock"
    }
}