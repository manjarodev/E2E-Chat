package com.devbeans.io.chat.network.mqtt;

import android.content.Context;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.MqttException;

import info.mqtt.android.service.MqttAndroidClient;

//import info.mqtt.android.service.MqttAndroidClient;

public class EmqxHelper {

    public static final String TAG = EmqxHelper.class.getSimpleName();
    private static EmqxHelper instance = null;
    private final Context context;
    private MqttAndroidClient mClient;

    public EmqxHelper(MqttAndroidClient mClient, Context context) {
        this.mClient = mClient;
        this.context = context;
    }

    public EmqxHelper(Context context) {
        this.context = context;
    }

    public static EmqxHelper with(Context context) {
        if (instance == null) {
            instance = new EmqxHelper(context);
        }
        return instance;
    }

    public static EmqxHelper with(MqttAndroidClient mClient, Context context) {
        if (instance == null) {
            instance = new EmqxHelper(mClient, context);
        }
        return instance;
    }

    public MqttAndroidClient getClient() {
        return mClient;
    }

    public void connect(Connection connection, IMqttActionListener listener) {
        try {
            mClient = connection.getMqttAndroidClient(context);
            mClient.connect(connection.getMqttConnectOptions(), null, listener);
            mClient.setCallback(new OnMessageCallback());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() throws MqttException {
        if (notConnected(true)) {
            return;
        }
        mClient.disconnect();
    }

    public void subscribe(Subscription subscription, IMqttActionListener listener) throws MqttException {
        if (notConnected(true)) {
            return;
        }
        mClient.subscribe(subscription.getTopic(), subscription.getQos(), null, listener);
    }

    public void publish(Publish publish, IMqttActionListener callback) throws MqttException {
        if (notConnected(true)) {
            return;
        }
        mClient.publish(publish.getTopic(), publish.getPayload().getBytes(), publish.getQos(), publish.isRetained(), null, callback);
    }

    public boolean notConnected(boolean showNotify) {
        if (mClient == null || !mClient.isConnected()) {
            if (showNotify) {
//                Toast.makeText(context, "Client is not connected", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return false;
    }
}
