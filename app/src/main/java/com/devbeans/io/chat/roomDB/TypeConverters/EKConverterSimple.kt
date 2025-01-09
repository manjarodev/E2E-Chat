package com.devbeans.io.chat.roomDB.TypeConverters

import androidx.room.TypeConverter
import com.devbeans.io.chat.encryption.EK
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EKConverterSimple {
    @TypeConverter
    fun EkToJson(ek: EK?): String? {
//        val stopwatch = Stopwatch("EkToJson")
//        stopwatch.split("object to string start")
        if (ek == null) return null
        val type = object : TypeToken<EK?>() {}.type

        val json = Gson().toJson(ek, type)
//        stopwatch.split("object to string done")
//        stopwatch.stop(Stopwatch.TAG)
        return json
    }

    @TypeConverter
    fun JsonToEK(encryptedJson: String?): EK? {
//        val stopwatch = Stopwatch("JsonToEK")
//        stopwatch.split("cipher to string start")
        val gson = Gson()
        val type = object :
            TypeToken<EK?>() {}.type
//        stopwatch.split("string to object done")
//        stopwatch.stop(Stopwatch.TAG)
        return if (encryptedJson != null) {
            gson.fromJson(encryptedJson, type)
        } else
            null
    }


}