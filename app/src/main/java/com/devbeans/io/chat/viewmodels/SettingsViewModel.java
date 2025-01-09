package com.devbeans.io.chat.viewmodels;


import static com.devbeans.io.chat.utils.AndroidUtil.getString;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.models.SettingsModel;

import java.util.ArrayList;
import java.util.List;

public class SettingsViewModel extends ViewModel {

    private static SettingsViewModel instance = null;
    private final MutableLiveData<List<SettingsModel>> settingsLiveData = new MutableLiveData<>();

    public SettingsViewModel() {
        initSettingsData();
    }

    public static SettingsViewModel with(Context context) {
        if (instance == null) {
            instance = new ViewModelProvider((ViewModelStoreOwner) context).get(SettingsViewModel.class);
        }
        return instance;
    }

    private void initSettingsData() {
        List<SettingsModel> settingsList = new ArrayList<>();
        settingsList.add(new SettingsModel(R.drawable.ic_privacy, getString(R.string.privacy), getString(R.string.privacy_message)));
        settingsList.add(new SettingsModel(R.drawable.ic_chat_palette, getString(R.string.chat), getString(R.string.chat_message)));
        settingsList.add(new SettingsModel(R.drawable.ic_notification, getString(R.string.notifications), getString(R.string.notifications_message)));
        settingsList.add(new SettingsModel(R.drawable.ic_lock, getString(R.string.autolock_settings), getString(R.string.autolock_settings_message)));
        settingsList.add(new SettingsModel(R.drawable.ic_import_export_chat_settings, getString(R.string.import_export), getString(R.string.import_export_note)));
        setSettingsLiveData(settingsList);
    }

    public MutableLiveData<List<SettingsModel>> getSettingsLiveData() {
        return settingsLiveData;
    }

    public void setSettingsLiveData(List<SettingsModel> settingsList) {
        settingsLiveData.setValue(settingsList);
    }
}
