package com.devbeans.io.chat.network.mqtt;

import android.content.Context;

import com.devbeans.io.chat.utils.logging.Log;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import info.mqtt.android.service.Ack;
import info.mqtt.android.service.MqttAndroidClient;

//import info.mqtt.android.service.Ack;
//import info.mqtt.android.service.MqttAndroidClient;

public class Connection {

    private String host;

    private int port;

    private String clientId;

    private String username;

    private String password;

    private final boolean tls;

    private final Context context;

    private static MqttAndroidClient mqttAndroidClient;


    public Connection(Context context, String host, int port, String clientId, String username, String password, boolean tls) {
        this.context = context;
        this.host = host;
        this.port = port;
        this.clientId = clientId;
        this.username = username;
        this.password = password;
        this.tls = tls;
    }

    public MqttAndroidClient getMqttAndroidClient(Context context) throws MqttException {
        String uri;
        if (tls) {
            uri = "ssl://" + host + ":" + port;
        } else {
            uri = "tcp://" + host + ":" + port;
        }

        if (mqttAndroidClient == null) {
            mqttAndroidClient = new MqttAndroidClient(context, uri, clientId, Ack.AUTO_ACK);
            return mqttAndroidClient;
        }

        return mqttAndroidClient;

    }

    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        if (tls) {
            try {
                Log.e(Log.tag(Connection.class),"Did not set SSL socket factory");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (!getUsername().isEmpty()) {
            options.setUserName(getUsername());
        }

        if (!getPassword().isEmpty()) {
            options.setPassword(getPassword().toCharArray());
        }


        return options;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
