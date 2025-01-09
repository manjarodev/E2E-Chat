package com.devbeans.io.chat.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.devbeans.io.chat.utils.logging.Log;

public class WebSocketConnectReceiver extends BroadcastReceiver {
    public static String TAG = Log.tag(WebSocketConnectReceiver.class);

    @Override
    public void onReceive(Context context, Intent intent) {


        Log.e(TAG, "SOCKET listened");
    }

}
