package com.devbeans.io.chat.utils;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDelegate;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.utils.logging.Log;

public class DynamicTheme {

    private static final String TAG = Log.tag(DynamicTheme.class);

    private static int globalNightModeConfiguration;

    private int onCreateNightModeConfiguration;

    public void onCreate(@NonNull Activity activity) {
        int previousGlobalConfiguration = globalNightModeConfiguration;

        onCreateNightModeConfiguration = ConfigurationUtil.getNightModeConfiguration(activity);
        globalNightModeConfiguration   = onCreateNightModeConfiguration;

        activity.setTheme(getTheme());

        if (previousGlobalConfiguration != globalNightModeConfiguration) {
            Log.d(TAG, "Previous night mode has changed previous: " + previousGlobalConfiguration + " now: " + globalNightModeConfiguration);
            CachedInflater.from(activity).clear();
        }
    }

    public void onResume(@NonNull Activity activity) {
        if (onCreateNightModeConfiguration != ConfigurationUtil.getNightModeConfiguration(activity)) {
            Log.d(TAG, "Create configuration different from current previous: " + onCreateNightModeConfiguration + " now: " +  ConfigurationUtil.getNightModeConfiguration(activity));
            CachedInflater.from(activity).clear();
        }
    }

    protected @StyleRes
    int getTheme() {
        return R.style.Theme_Chat;
    }

    public static boolean systemThemeAvailable() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static void setDefaultDayNightMode(@NonNull Context context) {
        SettingsValues.Theme theme = SettingsValues.getTheme();

        if (theme == SettingsValues.Theme.SYSTEM) {
            Log.d(TAG, "Setting to follow system expecting: " + ConfigurationUtil.getNightModeConfiguration(context.getApplicationContext()));
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        } else if (DynamicTheme.isDarkTheme(context)) {
            Log.d(TAG, "Setting to always night");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            Log.d(TAG, "Setting to always day");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        CachedInflater.from(context).clear();
    }

    /**
     * Takes the system theme into account.
     */
    public static boolean isDarkTheme(@NonNull Context context) {
        SettingsValues.Theme theme = SettingsValues.getTheme();

        if (theme == SettingsValues.Theme.SYSTEM && systemThemeAvailable()) {
            return isSystemInDarkTheme(context);
        } else {
            return theme == SettingsValues.Theme.DARK;
        }
    }

    private static boolean isSystemInDarkTheme(@NonNull Context context) {
        return (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
    }
}
