package com.devbeans.io.chat.services


import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.callBacks.NetworkCallback
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.logging.Log
import java.util.*


class TimerSenderClass : TimerTask() {
    override fun run() {

        try {
//            Utills.checkServerConnected(object : NetworkCallback {
//                override fun onResponse(network: Boolean) {
//                    Log.e(
//                        TimerSenderClass::class.java.simpleName,
//                        "GOT FromGooGle $network"
//                    )
//                }
//
//            })

            if (!Utills.isSubscriptionExpired()) {
                MainActivity.INSTANCE?.reInitiateSocketConnection("TimerSenderClass")
            }
//            //Check if the user is Private
//            if (Utills.checkUser(appContext!!)) {
//                BackgroundService.checkConnectMqtt()
//            } else {
//                BackgroundService.checkDisconnectMqtt()
//            }

//            BackgroundService.checkConnectMqtt()
        } catch (e: Exception) {
            Log.e(
                TimerSenderClass::class.java.simpleName,
                "Got Exception in checking user and starting MQTT ${e.message}"
            )
        }

    }
}