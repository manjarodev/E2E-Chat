package com.devbeans.io.chat.roomDB.TypeConverters;

import androidx.room.TypeConverter;

import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.utils.logging.Log;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class PayloadTypeConverter {

    @TypeConverter
    public static String PayloadToJson(Payload payload) {
        if (payload == null) return null;
        Type type = new TypeToken<Payload>() {
        }.getType();
        String json = new Gson().toJson(payload, type);
        Log.i("JSON", "toJson: " + json);
        return json;
    }

    @TypeConverter
    public static Payload JsonToPayload(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Payload>() {
        }.getType();
        try {
            return gson.fromJson(json, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;

        }
    }

}
