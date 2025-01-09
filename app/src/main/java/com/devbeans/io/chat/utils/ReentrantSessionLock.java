package com.devbeans.io.chat.utils;

import java.util.concurrent.locks.ReentrantLock;

public enum ReentrantSessionLock implements ChatSessionLock {

    INSTANCE;

    private static final ReentrantLock LOCK = new ReentrantLock();

    @Override
    public Lock acquire() {
        LOCK.lock();
        return LOCK::unlock;
    }
}
