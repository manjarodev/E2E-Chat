package com.devbeans.io.chat.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import com.devbeans.io.chat.models.Messages;
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppSession {

    public static final String BLANK_STRING_KEY = "";
    public static final String WRONG_PAIR = "Key-Value pair cannot be blank or null";
    private static final String SHARED_PREFERENCE_NAME = "SMRT";
    private static Location userLocation;
    private static AppSession INSTANCE = null;
    public static SharedPreferences.Editor editor;
    private static SharedPreferences savedSession;

    public AppSession(Context context) {
        try {

            MasterKey masterKey = new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).setRequestStrongBoxBacked(true).build();
            SharedPreferences sharedPreferences = EncryptedSharedPreferences.create(context, SHARED_PREFERENCE_NAME, masterKey, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);

            // use the shared preferences and editor as you normally would
            editor = sharedPreferences.edit();
            savedSession = sharedPreferences;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AppSession with() {
        if (INSTANCE == null) {
            INSTANCE = new AppSession(MainApp.Companion.getAppContext());
        }
        return INSTANCE;
    }

    public static boolean put(final String key, final String value) {
        if (key == null || value == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static boolean clearSharedPref() {
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.clear();
        return editor.commit();
    }

    public static boolean put(final String key, final int value) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static boolean put(final String key, final boolean value) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static boolean put(final String key, final long value) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public static boolean put(final String key, final boolean value, final String sharedPreferenceName) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static String get(final String key) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getString(key, BLANK_STRING_KEY);
    }

    public static String get(final String key, final String defaultValue) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getString(key, defaultValue);
    }

    public static int getInt(final String key) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getInt(key, 0);
    }

    public static long getLong(final String key) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getLong(key, 0);
    }

    public static Boolean getBoolean(final String key) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getBoolean(key, false);
    }

    public static Boolean getBoolean(final String key, final boolean defaultValue) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getBoolean(key, defaultValue);
    }

    public static void remove(final String key) {
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.remove(key);
        editor.commit();
    }

    public static boolean removeRememberMe() {
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences("Constants.REMEMBER_ME", Context.MODE_PRIVATE).edit();
        editor.clear();
        return editor.commit();
    }

    public static Location getUserLocation() {
        if (userLocation == null) {
            Location location = new Location("N/A");
            location.setLatitude(0);
            location.setLongitude(0);
            return location;
        } else return userLocation;
    }

    public static String getDeviceId() {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getString("deviceId", BLANK_STRING_KEY);
    }

    public static void setUserLocation(Location location) {
        userLocation = location;
    }

    public static int getInt(String key, int defaultValue) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getInt(key, defaultValue);
    }

    public static boolean hasKey(String key) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.contains(key);
    }

    public static boolean put(final String key, final Double value) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, value.toString());
        return editor.commit();
    }

    public static Double getDouble(String key) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return Double.parseDouble(savedSession.getString(key, "0.0"));
    }

    public static boolean put(String key, ArrayList<Integer> value) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
        String string = "";
        for (Integer inte : value) {
            string = string + inte + ",";
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, string);
        return editor.commit();
    }

    public static boolean putRequest(String key, ArrayList<String> value) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
        String string = "";
        for (String req : value) {
            string = string + req + ",";
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, string);
        return editor.commit();
    }

    public static ArrayList<String> getStringArrayList(String key) {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        String[] list = savedSession.getString(key, "").split(",");
        ArrayList<String> request = new ArrayList<>();
        for (String item : list) {
            try {
                request.add(item);
            } catch (Exception e) {

            }
        }
        return request;
    }


    public static String getLastMessageId() {
//        SharedPreferences savedSession = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return savedSession.getString("messageId", BLANK_STRING_KEY);
    }


    public static void saveUser(User user) {
        if (user.getMoniker() == null) user.setMoniker(user.getChatUserId());

        Gson gson = new Gson();
        String data = gson.toJson(user);
        AppSession.put("user", data);
    }

    public static void saveMQTT(String password) {
        AppSession.put("mqttPass", password);
    }

    public static String getMQTTPass() {
        return AppSession.get("mqttPass", "");

    }

    public static User getUser() {
        Gson gson = new Gson();
        User user = gson.fromJson(AppSession.get("user", ""), User.class);
        return user;
    }

    public static void keysUploaded(boolean uploaded) {
        AppSession.put("keysUploaded", uploaded);
    }

    public static boolean keysUploaded() {
        return AppSession.getBoolean("keysUploaded", false);
    }

    public static void saveProfile(User user) {
        Gson gson = new Gson();
        String data = gson.toJson(user);
        AppSession.put("userprofile", data);
    }


    public static User getProfile() {
        Gson gson = new Gson();
        User user = gson.fromJson(AppSession.get("userprofile", ""), User.class);
        return user;
    }


    public static List<Messages> getDownloadingFiles() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Messages>>() {
        }.getType();
        return gson.fromJson(AppSession.get("downloading", ""), type);
    }

    public static void saveDownloadingFiles(List<Messages> messages) {
        Gson gson = new Gson();
        String data = gson.toJson(messages);
        put("downloading", data);
    }

    public static List<Payload> getOfflineAcknowledgments() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Payload>>() {
        }.getType();

        return gson.fromJson(AppSession.get("offlineAcknowledgments", ""), type);
    }

    public static void saveOfflineAcknowledgments(List<Payload> offlineAcknowledgments) {
        Gson gson = new Gson();
        String data = gson.toJson(offlineAcknowledgments);
        put("offlineAcknowledgments", data);
    }


    public static void setPrevMessage(Messages message) {
        Gson gson = new Gson();
//        String data = gson.toJson(message);
//        put("preMessage", data);
    }

    public static Messages getPrevMessage() {
        Gson gson = new Gson();
        Messages user = gson.fromJson(AppSession.get("preMessage", ""), Messages.class);
        return user;
    }

    public void putTaskList(String key, HashMap<Integer, Boolean> Taskmap) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
//        SharedPreferences.Editor editor = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME + "HashMap", Context.MODE_PRIVATE).edit();
        for (Integer s : Taskmap.keySet()) {
            editor.putBoolean(key + s, Taskmap.get(s));
        }
        editor.commit();
    }

    public HashMap<String, Boolean> getTaskList(String key) {

//        SharedPreferences saved = MainApp.Companion.getAppContext().getSharedPreferences(SHARED_PREFERENCE_NAME + "HashMap", Context.MODE_PRIVATE);
        HashMap<String, Boolean> map = (HashMap<String, Boolean>) savedSession.getAll();
        HashMap<String, Boolean> Taskap = new HashMap<String, Boolean>();
        for (String s : map.keySet()) {
            boolean value = map.get(s);
            String KEY = s.substring(key.length());
            Taskap.put(KEY, value);
        }
        return Taskap;
    }


}
