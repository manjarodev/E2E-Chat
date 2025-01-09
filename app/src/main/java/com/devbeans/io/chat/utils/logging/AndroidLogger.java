package com.devbeans.io.chat.utils.logging;

import android.annotation.SuppressLint;

import com.devbeans.io.chat.utils.SettingsValues;

@SuppressLint("LogNotSignal")
public final class AndroidLogger extends Log.Logger {

    @Override
    public void v(String tag, String message, Throwable t, boolean keepLonger) {
        if (SettingsValues.getSystemLog())
            android.util.Log.v(tag, message, t);
    }

    @Override
    public void d(String tag, String message, Throwable t, boolean keepLonger) {
        if (SettingsValues.getSystemLog())
            android.util.Log.d(tag, message, t);
    }

    @Override
    public void i(String tag, String message, Throwable t, boolean keepLonger) {
        if (SettingsValues.getSystemLog())
            android.util.Log.i(tag, message, t);
    }

    @Override
    public void w(String tag, String message, Throwable t, boolean keepLonger) {
        if (SettingsValues.getSystemLog())
            android.util.Log.w(tag, message, t);
    }

    @Override
    public void e(String tag, String message, Throwable t, boolean keepLonger) {
        if (SettingsValues.getSystemLog())
            android.util.Log.e(tag, message, t);
    }

    @Override
    public void flush() {

        // was essential to over ride

    }
}