package com.devbeans.io.chat.roomDB.TypeConverters

import androidx.room.TypeConverter
import com.devbeans.io.chat.encryption.SymmRatchet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SymmRatchetConverterSimple {

    @TypeConverter
    fun RachetToJson(ratchet: SymmRatchet?): String? {
//        val stopwatch = Stopwatch("RachetToJson")
//        stopwatch.split("object to string start")
        if (ratchet == null) return null
        val type = object : TypeToken<SymmRatchet?>() {}.type

        val json = Gson().toJson(ratchet, type)
//        stopwatch.stop(Stopwatch.TAG)
        return json
    }

    @TypeConverter
    fun JsonToRacthet(encryptedJson: String?): SymmRatchet? {
//        val stopwatch = Stopwatch("JsonToRacthet")
//        stopwatch.split("cipher to string start")
        val gson = Gson()
        val type = object :
            TypeToken<SymmRatchet?>() {}.type

//        stopwatch.split("string to object done")
//        stopwatch.stop(Stopwatch.TAG)
        return gson.fromJson(encryptedJson, type)
    }

}