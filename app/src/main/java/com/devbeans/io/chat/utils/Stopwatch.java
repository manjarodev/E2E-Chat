package com.devbeans.io.chat.utils;

import androidx.annotation.NonNull;

import com.devbeans.io.chat.utils.logging.Log;

import java.util.LinkedList;
import java.util.List;

public class Stopwatch {

    private final long startTime;
    private final String title;
    private final List<Split> splits;
    public static final String TAG = Stopwatch.class.getSimpleName();

    public Stopwatch(@NonNull String title) {
        this.startTime = System.currentTimeMillis();
        this.title = title;
        this.splits = new LinkedList<>();
    }

    public void split(@NonNull String label) {
        splits.add(new Split(System.currentTimeMillis(), label));
    }

    public void stop(@NonNull String tag) {
        StringBuilder out = new StringBuilder();
        out.append("[").append(title).append("] ");

        if (splits.size() > 0) {
            out.append(splits.get(0).label).append(": ");
            out.append(splits.get(0).time - startTime);
            out.append("  ");
        }

        if (splits.size() > 1) {
            for (int i = 1; i < splits.size(); i++) {
                out.append(splits.get(i).label).append(": ");
                out.append(splits.get(i).time - splits.get(i - 1).time);
                out.append(" time stamp: ").append(splits.get(i).time);
                out.append("  ||");
            }
            out.append("  ");
            out.append("total: ").append(splits.get(splits.size() - 1).time - startTime);
        }

        Log.e(tag, out.toString());
    }

    private static class Split {
        final long time;
        final String label;

        Split(long time, String label) {
            this.time = time;
            this.label = label;
        }
    }
}
