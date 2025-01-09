package com.devbeans.io.chat.utils;


public final class TranscodingException extends Exception {

    public TranscodingException(String message) {
        super(message);
    }

    TranscodingException(Throwable inner) {
        super(inner);
    }
}
