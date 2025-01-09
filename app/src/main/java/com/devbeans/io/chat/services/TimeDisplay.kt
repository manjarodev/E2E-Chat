package com.devbeans.io.chat.services

import com.devbeans.io.chat.utils.Notify
import java.util.*


class TimeDisplay : TimerTask() {

    override fun run() {
//        Log.e(TAG, "run: 5 minutes interval")

//        ApiHelper.with().checkDeviceBackup()
            Notify.Toast("Helllloooo")
//        CoroutineScope(Dispatchers.IO).launch {
//
//        }
    }

    companion object {
        val TAG = TimeDisplay::class.java.simpleName
    }
}