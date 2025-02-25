package com.devbeans.io.chat.utils;


import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/**
 * Easy access to various properties of the device, typically to make performance-related decisions.
 */
public final class DeviceProperties {

    /**
     * Whether or not we believe the device has the performance capabilities to efficiently render
     * large numbers of APNGs simultaneously.
     */
    public static boolean shouldAllowApngStickerAnimation(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }

        MemoryInfo memoryInfo = getMemoryInfo(context);
        int        memoryMb   = (int) ByteUnit.BYTES.toMegabytes(memoryInfo.totalMem);

        return !isLowMemoryDevice(context) &&
                !memoryInfo.lowMemory       &&
                (memoryMb                >= ByteUnit.GIGABYTES.toMegabytes(3) ||
                        getMemoryClass(context) >= 193);
    }

    public static boolean isLowMemoryDevice(@NonNull Context context) {
        ActivityManager activityManager = ServiceUtil.getActivityManager(context);
        return activityManager.isLowRamDevice();
    }

    public static int getMemoryClass(@NonNull Context context) {
        ActivityManager activityManager = ServiceUtil.getActivityManager(context);
        return activityManager.getMemoryClass();
    }

    public static @NonNull MemoryInfo getMemoryInfo(@NonNull Context context) {
        MemoryInfo      info            = new MemoryInfo();
        ActivityManager activityManager = ServiceUtil.getActivityManager(context);

        activityManager.getMemoryInfo(info);

        return info;
    }

    @RequiresApi(28)
    public static boolean isBackgroundRestricted(@NonNull Context context) {
        ActivityManager activityManager = ServiceUtil.getActivityManager(context);
        return activityManager.isBackgroundRestricted();
    }
}