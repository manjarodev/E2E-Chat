package com.devbeans.io.chat.extensions

import android.Manifest
import android.app.Activity
import android.content.*
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.*
import android.provider.MediaStore.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import com.bumptech.glide.util.Util.isOnMainThread
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.roomDB.Dao.*
import com.devbeans.io.chat.utils.Constants.PERMISSION_CAMERA
import com.devbeans.io.chat.utils.Constants.PERMISSION_MEDIA_LOCATION
import com.devbeans.io.chat.utils.Constants.PERMISSION_READ_PHONE_STATE
import com.devbeans.io.chat.utils.Constants.PERMISSION_READ_STORAGE
import com.devbeans.io.chat.utils.Constants.PERMISSION_RECORD_AUDIO
import com.devbeans.io.chat.utils.Constants.PERMISSION_WRITE_STORAGE
import com.devbeans.io.chat.utils.Constants.isQPlus
import com.devbeans.io.chat.utils.Constants.isRPlus
import java.util.*


fun Context.toast(id: Int, length: Int = Toast.LENGTH_SHORT) {
    toast(getString(id), length)
}

fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    try {
        if (isOnMainThread()) {
            doToast(this, msg, length)
        } else {
            Handler(Looper.getMainLooper()).post {
                doToast(this, msg, length)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun doToast(context: Context, message: String, length: Int) {
    if (context is Activity) {
        if (!context.isFinishing && !context.isDestroyed) {
            Toast.makeText(context, message, length).show()
        }
    } else {
        Toast.makeText(context, message, length).show()
    }
}

fun Context.showErrorToast(msg: String, length: Int = Toast.LENGTH_LONG) {
    toast(String.format(getString(R.string.error), msg), length)
}

fun Context.showErrorToast(exception: Exception, length: Int = Toast.LENGTH_LONG) {
    showErrorToast(exception.toString(), length)
}

//val Context.Preferences: Config get()
val Context.contactsDao: ContactsDao
    get() = MainApp.database!!.contactsDao()!!
val Context.conversationsDao: ConversationsDao
    get() = MainApp.database!!.conversationsDao()!!
val Context.messagesDao: MessagesDao
    get() = MainApp.database!!.messagesDao()!!
val Context.offlineMessagesDao: OfflineMessagesDao
    get() = MainApp.database!!.offlineMessagesDao()!!
val Context.keyPairDao: KeyPairDao
    get() = MainApp.database!!.keyPairDao()!!
val Context.secreteDao: SecreteKeyDao
    get() = MainApp.database!!.SecreteKeyDao()!!
val Context.generateDao: GeneratedDao
    get() = MainApp.database!!.GeneratedDao()!!
val Context.identityKeyPairDao: IdentityKeyPairDao
    get() = MainApp.database!!.IdentityKeyPairDao()!!
val Context.chatKeyPairDao: ChatKeyPairDao
    get() = MainApp.database!!.ChatKeyPairDao()!!
val Context.conversationChannelsDao: ConversationChannelsDao
    get() = MainApp.database!!.ConversationChannelsDao()!!
val Context.EkDao: SecretEKDao
    get() = MainApp.database!!.EKDao()!!
val Context.offlineAckDao: OfflineAckDao
    get() = MainApp.database!!.offlineAckDao()!!


//val Context.generatedDeviceId: String get() = Constants.GenerateDeviceId(applicationContext)
//fun Context.getSharedPrefs(): SharedPreferences =
//    getSharedPreferences("Prefs", Context.MODE_PRIVATE)

//val Context.preferences: AppSession get() = AppSession(applicationContext)

fun Context.getCurrentClip(): String? {
    val clipboardManager = (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
    return clipboardManager.primaryClip?.getItemAt(0)?.text?.trim()?.toString()
}


private fun Context.queryCursorDesc(
    uri: Uri,
    projection: Array<String>,
    sortColumn: String,
    limit: Int,
): Cursor? {
    return if (isRPlus()) {
        val queryArgs = bundleOf(
            ContentResolver.QUERY_ARG_LIMIT to limit,
            ContentResolver.QUERY_ARG_SORT_DIRECTION to ContentResolver.QUERY_SORT_DIRECTION_DESCENDING,
            ContentResolver.QUERY_ARG_SORT_COLUMNS to arrayOf(sortColumn),
        )
        contentResolver.query(uri, projection, queryArgs, null)
    } else {
        val sortOrder = "$sortColumn DESC LIMIT $limit"
        contentResolver.query(uri, projection, null, null, sortOrder)
    }
}

fun Context.hasPermission(permId: Int) = ContextCompat.checkSelfPermission(
    this,
    getPermissionString(permId)
) == PackageManager.PERMISSION_GRANTED

fun Context.getPermissionString(id: Int) = when (id) {
    PERMISSION_READ_STORAGE -> Manifest.permission.READ_EXTERNAL_STORAGE
    PERMISSION_WRITE_STORAGE -> Manifest.permission.WRITE_EXTERNAL_STORAGE
    PERMISSION_CAMERA -> Manifest.permission.CAMERA
    PERMISSION_RECORD_AUDIO -> Manifest.permission.RECORD_AUDIO
    PERMISSION_READ_PHONE_STATE -> Manifest.permission.READ_PHONE_STATE
    PERMISSION_MEDIA_LOCATION -> if (isQPlus()) Manifest.permission.ACCESS_MEDIA_LOCATION else ""
//    PERMISSION_POST_NOTIFICATIONS -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//        android.Manifest.permission.CAMERA
//    } else {
//        ""
//    }
//    PERMISSION_READ_MEDIA_IMAGES -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//        android.Manifest.permission.READ_
//        android.Manifest.permission.READ_MEDIA_IMAGES
//    } else {
//        ""
//    }
//    PERMISSION_READ_MEDIA_VIDEO -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//        Manifest.permission.READ_MEDIA_VIDEO
//    } else {
//        ""
//    }
//    PERMISSION_READ_MEDIA_AUDIO -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//        Manifest.permission.READ_MEDIA_AUDIO
//    } else {
//        ""
//    }
    else -> ""
}

fun Context.hasDrawOverlay(): Boolean {
    return Settings.canDrawOverlays(this)
}


@RequiresApi(Build.VERSION_CODES.R)
fun Context.checkExternalPermissionLegacy(): Boolean {
    return Environment.isExternalStorageManager()
}


fun Context.launchActivityIntent(intent: Intent) {
    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        toast(R.string.no_app_found)
    } catch (e: Exception) {
        showErrorToast(e)
    }
}

fun Context.queryCursor(
    uri: Uri,
    projection: Array<String>,
    selection: String? = null,
    selectionArgs: Array<String>? = null,
    sortOrder: String? = null,
    showErrors: Boolean = false,
    callback: (cursor: Cursor) -> Unit
) {
    try {
        val cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
        cursor?.use {
            if (cursor.moveToFirst()) {
                do {
                    callback(cursor)
                } while (cursor.moveToNext())
            }
        }
    } catch (e: Exception) {
        if (showErrors) {
            showErrorToast(e)
        }
    }
}

fun Context.copyToClipboard(text: String) {
    val clip = ClipData.newPlainText(getString(R.string.app_name), text)
    (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).setPrimaryClip(clip)
    val toastText = String.format(getString(R.string.value_copied_to_clipboard_show), text)
    toast(toastText)
}


