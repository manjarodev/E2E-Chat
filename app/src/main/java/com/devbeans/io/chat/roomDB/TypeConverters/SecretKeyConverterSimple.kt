package com.devbeans.io.chat.roomDB.TypeConverters

import androidx.room.TypeConverter
import com.devbeans.io.chat.models.SecretKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SecretKeyConverterSimple {

    @TypeConverter
    fun KeyToJson(secretKey: SecretKey?): String? {
//        val stopwatch = Stopwatch("Secret Key to JSON")
//        stopwatch.split("Secret Key to Json Start")
        if (secretKey == null) return null
        val type = object : TypeToken<SecretKey>() {}.type
        val json = Gson().toJson(secretKey, type)
//        stopwatch.split("Returtning to DB ")
//        stopwatch.stop(Stopwatch.TAG)
        return json
    }

    @TypeConverter
    fun JsonToKey(encryptedJson: String): SecretKey? {
//        val stopwatch = Stopwatch("JSON to Secret Key")
//        stopwatch.split("CIPHER to JSON Start")
        val gson = Gson()
        val type = object :
            TypeToken<SecretKey>() {}.type

//        stopwatch.split("JSON to Object Done")
//        stopwatch.stop(Stopwatch.TAG)
//        Log.e("Tag","JSON $encryptedJson")
        return if (encryptedJson.isNotEmpty()) gson.fromJson(encryptedJson, type) else null
    }

}