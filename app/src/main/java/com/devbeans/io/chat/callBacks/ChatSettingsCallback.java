package com.devbeans.io.chat.callBacks;

public interface ChatSettingsCallback {
    void onSettingsClick(String option,int dataOff);

    void onSettingsClick(int position,int dataOff);
}
