package com.devbeans.io.chat.websocket

interface WebSocketStateChangeListener {
    fun onStateChange(state: WebSocketConnectionState)
}