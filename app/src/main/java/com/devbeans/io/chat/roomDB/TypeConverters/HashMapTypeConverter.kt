package com.devbeans.io.chat.roomDB.TypeConverters

import androidx.room.TypeConverter
import com.devbeans.io.chat.utils.Stopwatch
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class HashMapTypeConverter {

    @TypeConverter
    fun fromString(value: String): HashMap<String, String> {
        val stopwatch = Stopwatch("HashMap fromString")
        stopwatch.split("object to string start")
        val mapType: Type = object : TypeToken<HashMap<String, String>>() {}.type
        stopwatch.split("object to string start")
        stopwatch.stop(Stopwatch.TAG)
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromStringMap(map: HashMap<String, String>): String {
        val stopwatch = Stopwatch("fromStringMap")
        stopwatch.split("string to object")
        val gson = Gson()
        stopwatch.split("string to object done")
        stopwatch.stop(Stopwatch.TAG)
        return gson.toJson(map)
    }
}