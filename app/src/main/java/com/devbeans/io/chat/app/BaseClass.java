package com.devbeans.io.chat.app;


public class BaseClass {
    public String string(int id) {
        return MainApp.Companion.getAppContext().getString(id);
    }
}
