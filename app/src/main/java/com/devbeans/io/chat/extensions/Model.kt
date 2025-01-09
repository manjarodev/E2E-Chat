package com.devbeans.io.chat.extensions

import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.models.ChatKeyPair
import com.devbeans.io.chat.utils.JsonUtils
import com.devbeans.io.chat.utils.logging.Log
import java.io.IOException

fun ChatKeyPair.fromString(value: String): ChatKeyPair? {
    return try {
        JsonUtils.fromJson(value, ChatKeyPair::class.java)
    } catch (e: IOException) {
        Log.e(MainApp.TAG, "Exception in Extension of Models $e")
        return null
    }
}