package com.devbeans.io.chat.network.mqtt;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/devbeans/io/chat/network/mqtt/OnMessageCallback;", "Lorg/eclipse/paho/client/mqttv3/MqttCallback;", "()V", "connectionLost", "", "cause", "", "deliveryComplete", "token", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "handleMessage", "context", "Landroid/content/Context;", "data", "", "id", "action", "actualData", "messageArrived", "topic", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "Companion", "app_debug"})
public final class OnMessageCallback implements org.eclipse.paho.client.mqttv3.MqttCallback {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.network.mqtt.OnMessageCallback.Companion Companion = null;
    private static boolean isInBackGround = false;
    private static final java.lang.String TAG = null;
    
    public OnMessageCallback() {
        super();
    }
    
    @java.lang.Override
    public void connectionLost(@org.jetbrains.annotations.NotNull
    java.lang.Throwable cause) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
    @java.lang.Override
    public void messageArrived(@org.jetbrains.annotations.NotNull
    java.lang.String topic, @org.jetbrains.annotations.NotNull
    org.eclipse.paho.client.mqttv3.MqttMessage message) throws java.lang.Exception {
    }
    
    @java.lang.Override
    public void deliveryComplete(@org.jetbrains.annotations.NotNull
    org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token) {
    }
    
    private final void handleMessage(android.content.Context context, java.lang.String data, java.lang.String id, java.lang.String action, java.lang.String actualData) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/network/mqtt/OnMessageCallback$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "isInBackGround", "", "()Z", "setInBackGround", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isInBackGround() {
            return false;
        }
        
        public final void setInBackGround(boolean p0) {
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
    }
}