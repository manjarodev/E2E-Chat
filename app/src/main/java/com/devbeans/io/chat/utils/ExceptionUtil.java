package com.devbeans.io.chat.utils;


import androidx.annotation.NonNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class ExceptionUtil {

    private ExceptionUtil() {}

    /**
     * Joins the stack trace of the inferred call site with the original exception. This is
     * useful for when exceptions are thrown inside of asynchronous systems (like runnables in an
     * executor) where you'd otherwise lose important parts of the stack trace. This lets you save a
     * throwable at the entry point, and then combine it with any caught exceptions later.
     *
     * The resulting stack trace will look like this:
     *
     * Inferred
     * Stack
     * Trace
     * [[ ↑↑ Inferred Trace ↑↑ ]]
     * [[ ↓↓ Original Trace ↓↓ ]]
     * Original
     * Stack
     * Trace
     *
     * @return The provided original exception, for convenience.
     */
    public static <E extends Throwable> E joinStackTrace(@NonNull E original, @NonNull Throwable inferred) {
        StackTraceElement[] combinedTrace = joinStackTrace(original.getStackTrace(), inferred.getStackTrace());
        original.setStackTrace(combinedTrace);
        return original;
    }

    /**
     * See {@link #joinStackTrace(Throwable, Throwable)}
     */
    public static StackTraceElement[] joinStackTrace(@NonNull StackTraceElement[] originalTrace, @NonNull StackTraceElement[] inferredTrace) {
        StackTraceElement[] combinedTrace = new StackTraceElement[originalTrace.length + inferredTrace.length + 2];

        System.arraycopy(originalTrace, 0, combinedTrace, 0, originalTrace.length);

        combinedTrace[originalTrace.length]     = new StackTraceElement("[[ ↑↑ Original Trace ↑↑ ]]", "", "", 0);
        combinedTrace[originalTrace.length + 1] = new StackTraceElement("[[ ↓↓ Inferred Trace ↓↓ ]]", "", "", 0);

        System.arraycopy(inferredTrace, 0, combinedTrace, originalTrace.length + 2, inferredTrace.length);

        return combinedTrace;
    }




    public static @NonNull String convertThrowableToString(@NonNull Throwable throwable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        throwable.printStackTrace(new PrintStream(outputStream));
        return outputStream.toString();
    }
}
