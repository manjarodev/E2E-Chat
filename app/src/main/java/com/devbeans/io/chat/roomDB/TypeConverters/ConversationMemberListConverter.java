package com.devbeans.io.chat.roomDB.TypeConverters;


import androidx.room.TypeConverter;

import com.devbeans.io.chat.models.ConversationMember;
import com.devbeans.io.chat.utils.logging.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ConversationMemberListConverter {
    @TypeConverter
    public static String ListToJson(List<ConversationMember> list) {
        if (list == null) return null;
        Type type = new TypeToken<List<ConversationMember>>() {
        }.getType();
        String json = new Gson().toJson(list, type);
        Log.i("JSON", "toJson: " + json);
        return list.isEmpty() ? null : json;
    }

    @TypeConverter
    public static List<ConversationMember> JsonToList(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<ConversationMember>>() {
        }.getType();
        List<ConversationMember> list = gson.fromJson(json, type);
        return list;
    }
}
