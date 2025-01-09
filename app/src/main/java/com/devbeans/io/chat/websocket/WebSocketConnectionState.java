package com.devbeans.io.chat.websocket;

/**
 * Represent the state of a single WebSocketConnection in chat application.
 */
public enum WebSocketConnectionState {
    DISCONNECTED,
    CONNECTING,
    CONNECTED,
    RECONNECTING,
    DISCONNECTING,
    AUTHENTICATION_FAILED,
    FAILED;

    public boolean isFailure() {
        return this == AUTHENTICATION_FAILED || this == FAILED;
    }
}
