package com.devbeans.io.chat.roomDB.TypeConverters;


import androidx.room.TypeConverter;

import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.utils.logging.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MessagesListConverter {
    @TypeConverter
    public static String ListToJson(List<Payload> list) {
        if (list == null) return null;
        Type type = new TypeToken<List<Payload>>() {
        }.getType();
        String json = new Gson().toJson(list, type);
        Log.i("JSON", "toJson: " + json);
        return list.isEmpty() ? null : json;
    }

    @TypeConverter
    public static List<Payload> JsonToList(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Payload>>() {
        }.getType();
        List<Payload> list = gson.fromJson(json, type);
        return list;
    }
}
