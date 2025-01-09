package com.devbeans.io.chat.utils.logging;

/**
 * A logger that does nothing.
 */
class NoopLogger extends Log.Logger {
    @Override
    public void v(String tag, String message, Throwable t, boolean keepLonger) {
        // was essential to over ride
    }

    @Override
    public void d(String tag, String message, Throwable t, boolean keepLonger) {
        // was essential to over ride
    }

    @Override
    public void i(String tag, String message, Throwable t, boolean keepLonger) {
        // was essential to over ride
    }

    @Override
    public void w(String tag, String message, Throwable t, boolean keepLonger) {
        // was essential to over ride
    }

    @Override
    public void e(String tag, String message, Throwable t, boolean keepLonger) {
        // was essential to over ride
    }

    @Override
    public void flush() {
        // was essential to over ride
    }
}