package com.devbeans.io.chat.callBacks;

import com.devbeans.io.chat.models.SettingsModel;

public interface OnSettingsClick {
    void onSettingsClick(SettingsModel settingsModel);
    void onSettingsClick(int position);
}
