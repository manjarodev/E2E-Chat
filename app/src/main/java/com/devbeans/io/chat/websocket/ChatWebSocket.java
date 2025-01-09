package com.devbeans.io.chat.websocket;

import com.devbeans.io.chat.activities.MainActivity;
import com.devbeans.io.chat.utils.ThreadUtil;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.logging.Log;

import okhttp3.WebSocket;

public class ChatWebSocket {

    private WebSocket webSocket;
    private WebSocketConnectionState state;


    public ChatWebSocket(WebSocket webSocket, WebSocketConnectionState state) {
        this.webSocket = webSocket;
        this.state = state;
    }

    public void setWebSocket(WebSocket webSocket) {
        this.webSocket = webSocket;
    }

    public void setState(WebSocketConnectionState state) {
        this.state = state;
    }

    public boolean sendMessage(String message) {
        try {
            Log.e(Utills.INSTANCE.getTAG(), "State " + state + "Message " + message);
            if (state == WebSocketConnectionState.CONNECTED && webSocket != null) {
                Log.e(Utills.INSTANCE.getTAG(), "Sending State " + state + "Message " + message);
                webSocket.send(message);
                return true;
            }

            ThreadUtil.runOnMain(() -> {
                if (MainActivity.isSocketConnected != null) {
                    MainActivity.isSocketConnected.postValue(false);

                }
            });
        } catch (Exception e) {
            Log.e(Utills.INSTANCE.getTAG(), "Error in sending" + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }

    public WebSocketConnectionState getState() {
        return state;
    }
}
