package com.devbeans.io.chat.models;

import com.google.gson.annotations.SerializedName;

public class Pair<T1, T2> {
    @SerializedName("v1")
    private final T1 v1;
    @SerializedName("v2")
    private final T2 v2;

    public Pair(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public T1 first() {
        return v1;
    }

    public T2 second() {
        return v2;
    }

    public boolean equals(Object o) {
        return o instanceof Pair &&
                equalPair(((Pair) o).first(), first()) &&
                equalPair(((Pair) o).second(), second());
    }

    public int hashCode() {
        return first().hashCode() ^ second().hashCode();
    }

    private boolean equalPair(Object first, Object second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        return first.equals(second);
    }
}