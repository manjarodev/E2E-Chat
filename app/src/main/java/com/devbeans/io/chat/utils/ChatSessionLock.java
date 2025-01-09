package com.devbeans.io.chat.utils;

import java.io.Closeable;

public interface ChatSessionLock {

    Lock acquire();

    interface Lock extends Closeable {
        @Override
        void close();
    }
}
