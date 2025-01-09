package com.devbeans.io.chat.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.devbeans.io.chat.activities.MainActivity;
import com.devbeans.io.chat.services.BackgroundService;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.logging.Log;

public class BootReceiver extends BroadcastReceiver {

    public static final String TAG = BootReceiver.class.getSimpleName();

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent serviceIntent = new Intent(context, BackgroundService.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                if (Utills.INSTANCE.isNetworkAvailable()) {
                    if (MainActivity.getInstance() != null)
                        MainActivity.getInstance().initiateSocketConnection("Boot initiatore");
                }
            } catch (Exception e) {
                Log.e(TAG, "Error" + e.getMessage());
                e.printStackTrace();

            }
            context.startForegroundService(serviceIntent);
        } else {
            context.startService(serviceIntent);
        }

    }
}