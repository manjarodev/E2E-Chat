package com.devbeans.io.chat.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private final int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry (Map.Entry<K,V> eldest) {
        return size() > maxSize;
    }
}
