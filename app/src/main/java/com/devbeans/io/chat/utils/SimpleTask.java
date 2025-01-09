package com.devbeans.io.chat.utils;

import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

import java.util.concurrent.Executor;

public class SimpleTask {

    /**
     * Runs a task in the background and passes the result of the computation to a task that is run
     * on the main thread. Will only invoke the {@code foregroundTask} if the provided {@link Lifecycle}
     * is in a valid (i.e. visible) state at that time. In this way, it is very similar to
     * {@link AsyncTask}, but is safe in that you can guarantee your task won't be called when your
     * view is in an invalid state.
     */
    public static <E> void run(@NonNull Lifecycle lifecycle, @NonNull BackgroundTask<E> backgroundTask, @NonNull ForegroundTask<E> foregroundTask) {
        if (!isValid(lifecycle)) {
            return;
        }

        ChatExecutors.BOUNDED.execute(() -> {
             E result = null;
            try {
                result = backgroundTask.run();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (isValid(lifecycle)) {
                E finalResult = result;
                ThreadUtil.runOnMain(() -> {
                    if (isValid(lifecycle)) {
                        foregroundTask.run(finalResult);
                    }
                });
            }
        });
    }

    /**
     * Runs a task in the background and passes the result of the computation to a task that is run on
     * the main thread. Essentially {@link AsyncTask}, but lambda-compatible.
     */
    public static <E> void run(@NonNull BackgroundTask<E> backgroundTask, @NonNull ForegroundTask<E> foregroundTask) {
        run(ChatExecutors.BOUNDED, backgroundTask, foregroundTask);
    }

    /**
     * Runs a task on the specified {@link Executor} and passes the result of the computation to a
     * task that is run on the main thread. Essentially {@link AsyncTask}, but lambda-compatible.
     */
    public static <E> void run(@NonNull Executor executor, @NonNull BackgroundTask<E> backgroundTask, @NonNull ForegroundTask<E> foregroundTask) {
        executor.execute(() -> {
            E result=null;
            try {
                result = backgroundTask.run();
            } catch (Exception e) {
                e.printStackTrace();
            }

            E finalResult = result;
            ThreadUtil.runOnMain(() -> foregroundTask.run(finalResult));
        });
    }

    private static boolean isValid(@NonNull Lifecycle lifecycle) {
        return lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED);
    }

    public interface BackgroundTask<E> {
        E run() throws Exception;
    }

    public interface ForegroundTask<E> {
        void run(E result);
    }
}
