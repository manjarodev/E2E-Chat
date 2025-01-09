package com.devbeans.io.chat.network.mqtt

import android.content.Context
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.logging.Log
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage


class OnMessageCallback : MqttCallback {
    override fun connectionLost(cause: Throwable) {
        // After the connection is lost, it usually reconnects here
        Log.e(TAG, "disconnect, you can reconnect")
    }

    @Throws(Exception::class)
    override fun messageArrived(topic: String, message: MqttMessage) {
        // The messages obtained after subscribe will be executed here
        Log.e(TAG, "Received message topic:$topic")
        Log.e(TAG, "Received message QoS:" + message.qos)
        Log.e(TAG, "Received message content:" + String(message.payload))
        if (!MainApp.appContext?.isAppInForground!!)
            Notify.Toast("You Have Unread Messages")
        val data = String(message.payload)


        var textMessage = String(message.payload)

        // Send notification for this text message here
        val notificationId = 124952

        // Create an explicit intent for an Activity in your app
//        val intent = Intent(MainApp.appContext, SplashActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//        val pendingIntent: PendingIntent = PendingIntent.getActivity(MainApp.appContext, 0, intent, PendingIntent.FLAG_IMMUTABLE)
//
//        val builder = NotificationCompat.Builder(MainApp.appContext!!, "124952")
//            .setSmallIcon(R.drawable.ic_chat)
//            .setLargeIcon(BitmapFactory.decodeResource(MainApp.appContext?.resources, R.drawable.ic_chat))
//            .setContentTitle("Chat App")
//            .setContentText("You Have Unread Messages")
//            .setContentIntent(pendingIntent)
//            .setAutoCancel(true)
//
//        val notificationManager: NotificationManager =
//            ServiceUtil.getNotificationManager(MainApp.appContext)
//
//// For Android Oreo and above, you need to create a NotificationChannel
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                "124952",
//                "chat",
//                NotificationManager.IMPORTANCE_HIGH
//            )
//            notificationManager.createNotificationChannel(channel)
//        }
//
//        notificationManager.notify(0, builder.build())


//        NotificationCompat.Builder(
//
//        )
//        Notify
//            .with(this@FcmListenerService)
//            .content { // this: Payload.Content.Default
//                title = textMessage.sender.name
//                text = textMessage.text
//            }
//            .alerting("high_priority_notification") {
//                channelImportance = Notify.IMPORTANCE_HIGH
//            }
//            .show(notificationId)
        //        if (data != null) {
//            String id = "";
//            String action = "";
//            String actualData = "";
//            if (data.length() > 5) {
//                id = data.substring(0, 5);
//            }
//            if (data.length() > 5) {
//                action = data.substring(5, 7);
//            }
//            if (data.length() > 7) {
//                actualData = data.substring(7);
//            }
//
//
//            Log.e(TAG, "messageArrivedId: " + id);
//            Log.e(TAG, "messageArrivedAction: " + action);
//            Log.e(TAG, "messageArrivedActualData: " + actualData);
//
////            if (!isKeyInCache(id)){
//                handleMessage(MainApp.Companion.getAppContext(),  data, id, action, actualData);
////            }
//
//        }
    }

    override fun deliveryComplete(token: IMqttDeliveryToken) {
        Log.e(TAG, "deliveryComplete---------" + token.isComplete)
    }

    //    public boolean isKeyInCache(String id) {
    //        boolean hasKey = false;
    //        List<Key> keys = AppSession.getLastKeys();
    //        if (keys != null && !keys.isEmpty()) {
    //            for (Key key : keys) {
    //                if (key.getId().equalsIgnoreCase(id)) {
    //                    hasKey = true;
    //                }
    //            }
    //        }
    //        if (hasKey) {
    //            return true;
    //        } else {
    //            if (keys != null) {
    //                keys.add(new Key(id, String.valueOf(System.currentTimeMillis())));
    //            } else {
    //                keys = new ArrayList<>();
    //                keys.add(new Key(id, String.valueOf(System.currentTimeMillis())));
    //            }
    //            AppSession.saveKeys(keys);
    //            return false;
    //        }
    //    }
    private fun handleMessage(
        context: Context,
        data: String,
        id: String,
        action: String,
        actualData: String
    ) {
//        String message = convertHexToStringValue(actualData);
        Log.e(TAG, "handleMessage: $actualData")

//        if (message != null && !message.isEmpty()) {
//            String title = "";
//            if (action.equals("01")) {
//                title = "Action";
//            } else if (action.equals("02")) {
//                title = "Flash message";
//            } else if (action.equals("03")) {
//                title = "Notification";
//            }
//            if (title.equalsIgnoreCase("Flash message")) {
//                Notify.Toast(message);
//            } else if (title.equalsIgnoreCase("Action")) {
//                if (message.startsWith("launchApp")) {
//                    String[] separated = message.split("-");
//                    String first = separated[0]; // this will contain "Fruit"
//                    String packageName = separated[1];
//                    if (packageName != null && !packageName.isEmpty()) {
//                        launchApp(packageName, MainApp.getAppContext());
//                        ApiHelper.with(TAG).sendExecutionAction(data);
//                    }
//                } else {
//                    if (message.equalsIgnoreCase("reboot")) {
//                        ApiHelper.with(TAG).sendExecutionAction(data);
//                        reboot();
//                    } else if (message.equalsIgnoreCase("shutdown")) {
//                        ApiHelper.with(TAG).sendExecutionAction(data);
//                        shutdown();
//                    } else if (message.equalsIgnoreCase("syncPolicy")) {
//                        Notify.Toast("Policy syncing");
//                        ApiHelper.with(TAG).sendExecutionAction(data);
//
////                        getPolicy("sync.policy");
//
//                    } else if (message.equalsIgnoreCase("killApp")) {
//                        killApp("com.simplemobiletools.dialer", MainApp.getAppContext());
//                        ApiHelper.with(TAG).sendExecutionAction(data);
//                    } else if (message.equalsIgnoreCase("vpn")) {
////                        if (!vpnStart) Notify.Toast("vpn connecting");
////                        prepareVpn(context);
//                    } else if (message.equalsIgnoreCase("wipe_device")) {
//                        ApiHelper.with(TAG).sendExecutionAction(data);
//                        new Handler(Looper.getMainLooper()).postDelayed(() -> {
//                            CommonActions.wipeDevice();
//                        }, 500);
//                    }
//                }
//            } else if (title.equalsIgnoreCase("Notification")) {
//                NotificationHelper.sendNotification(context, message, title);
//                Notification notification = new Notification();
//                notification.setDeviceId(AppSession.getDeviceId());
//                notification.setNotification(message);
//                notification.setDateTime(DateTime.getCurrentDateTime());
//                MainApp.database.notificationDao().insert(notification);
//                ApiHelper.with(TAG).sendExecutionAction(data);
//            }
//        }
    }

    companion object {
        var isInBackGround: Boolean = false
        val TAG = OnMessageCallback::class.java.simpleName
    }
}