package com.devbeans.io.chat.verifypin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * This Receiver is used to if there is any Dialog
 * in previously showing then dismiss it
 */
class DialogReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

    }

    companion object {
        val TAG = DialogReceiver::class.java.simpleName
    }
}