package com.devbeans.io.chat.utils;


import android.content.Context;
import android.os.PowerManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.devbeans.io.chat.utils.logging.Log;

public class WakeLockUtil {

    private static final String TAG = Log.tag(WakeLockUtil.class);

    /**
     * Run a runnable with a wake lock. Ensures that the lock is safely acquired and released.
     *
     * @param tag will be prefixed with "signal:" if it does not already start with it.
     */
    public static void runWithLock(@NonNull Context context, int lockType, long timeout, @NonNull String tag, @NonNull Runnable task) {
        PowerManager.WakeLock wakeLock = null;
        try {
            wakeLock = acquire(context, lockType, timeout, tag);
            task.run();
        } finally {
            if (wakeLock != null) {
                release(wakeLock, tag);
            }
        }
    }

    /**
     * @param tag will be prefixed with "signal:" if it does not already start with it.
     */
    public static PowerManager.WakeLock acquire(@NonNull Context context, int lockType, long timeout, @NonNull String tag) {
        tag = prefixTag(tag);
        try {
            PowerManager powerManager = ServiceUtil.getPowerManager(context);
            PowerManager.WakeLock wakeLock     = powerManager.newWakeLock(lockType, tag);

            wakeLock.acquire(timeout);

            return wakeLock;
        } catch (Exception e) {
            Log.w(TAG, "Failed to acquire wakelock with tag: " + tag, e);
            return null;
        }
    }

    /**
     * @param tag will be prefixed with "signal:" if it does not already start with it.
     */
    public static void release(@Nullable PowerManager.WakeLock wakeLock, @NonNull String tag) {
        tag = prefixTag(tag);
        try {
            if (wakeLock == null) {
                Log.d(TAG, "Wakelock was null. Skipping. Tag: " + tag);
            } else if (wakeLock.isHeld()) {
                wakeLock.release();
            } else {
                Log.d(TAG, "Wakelock wasn't held at time of release: " + tag);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to release wakelock with tag: " + tag, e);
        }
    }

    private static String prefixTag(@NonNull String tag) {
        return tag.startsWith("signal:") ? tag : "signal:" + tag;
    }
}
