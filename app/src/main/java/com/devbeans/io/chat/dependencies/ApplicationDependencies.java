package com.devbeans.io.chat.dependencies;

import android.app.Application;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.services.ExpiringMessageManager;
import com.devbeans.io.chat.utils.logging.Log;
import com.devbeans.io.chat.utils.revealable.ViewOnceMessageManager;

public class ApplicationDependencies {
    private static final Object LOCK = new Object();
    private static final Object FRAME_RATE_TRACKER_LOCK = new Object();
    private static final Object JOB_MANAGER_LOCK = new Object();
    private static Application application;
    private static volatile ExpiringMessageManager expiringMessageManager;
    private static volatile ViewOnceMessageManager viewOnceMessageManager;


    @MainThread
    public static void init(@NonNull Application application) {
        synchronized (LOCK) {
            if (ApplicationDependencies.application != null) {
                Log.e("ApplicationDependencies", new IllegalStateException("Already initialized!"));
            }

            ApplicationDependencies.application = application;
        }
    }

    public static @NonNull
    Application getApplication() {
        return application;
    }


    public static @NonNull
    ExpiringMessageManager getExpiringMessageManager() {
        if (expiringMessageManager == null) {
            synchronized (LOCK) {
                if (expiringMessageManager == null) {
                    expiringMessageManager = provideExpiringMessageManager();
                }
            }
        }

        return expiringMessageManager;
    }

    public static @NonNull ViewOnceMessageManager getViewOnceMessageManager() {
        if (viewOnceMessageManager == null) {
            synchronized (LOCK) {
                if (viewOnceMessageManager == null) {
                    viewOnceMessageManager = provideViewOnceMessageManager();
                }
            }
        }

        return viewOnceMessageManager;
    }




    public static @NonNull
    ViewOnceMessageManager provideViewOnceMessageManager() {
        return new ViewOnceMessageManager(MainApp.Companion.getAppContext());
    }


    public static @NonNull
    ExpiringMessageManager provideExpiringMessageManager() {
        return new ExpiringMessageManager(MainApp.Companion.getAppContext());
    }


}
