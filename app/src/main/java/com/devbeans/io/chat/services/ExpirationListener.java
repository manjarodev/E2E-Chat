package com.devbeans.io.chat.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.devbeans.io.chat.dependencies.ApplicationDependencies;

public class ExpirationListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ApplicationDependencies.getExpiringMessageManager().checkSchedule();
    }

    public static void setAlarm(Context context, long waitTimeMillis) {
        Intent        intent        = new Intent(context, ExpirationListener.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntentFlags.mutable());
        AlarmManager alarmManager  = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

        alarmManager.cancel(pendingIntent);
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + waitTimeMillis, pendingIntent);
    }
}
