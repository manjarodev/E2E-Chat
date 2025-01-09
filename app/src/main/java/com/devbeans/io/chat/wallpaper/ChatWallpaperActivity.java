package com.devbeans.io.chat.wallpaper;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.callBacks.ExpiryCallback;
import com.devbeans.io.chat.utils.DynamicNoActionBarTheme;
import com.devbeans.io.chat.utils.DynamicTheme;
import com.devbeans.io.chat.verifypin.BaseActivity;

public final class ChatWallpaperActivity extends BaseActivity implements ExpiryCallback {

    private static final String EXTRA_RECIPIENT_ID = "extra.recipient.id";

    private final DynamicTheme dynamicTheme = new DynamicNoActionBarTheme();

    public static @NonNull
    Intent createIntent(@NonNull Context context) {
        return createIntent(context, null);
    }

    public static @NonNull Intent createIntent(@NonNull Context context, @Nullable String recipientId) {
        Intent intent = new Intent(context, ChatWallpaperActivity.class);
        intent.putExtra(EXTRA_RECIPIENT_ID, recipientId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dynamicTheme.onCreate(this);
        setContentView(R.layout.chat_wallpaper_activity);

        if (savedInstanceState == null) {
            Bundle   extras = getIntent().getExtras();
            NavGraph graph  = Navigation.findNavController(this, R.id.nav_host_fragment).getGraph();

            Navigation.findNavController(this, R.id.nav_host_fragment).setGraph(graph, extras != null ? extras : new Bundle());
        }
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState, boolean ready) {
////        ChatWallpaperViewModel.Factory factory = new ChatWallpaperViewModel.Factory(getIntent().getParcelableExtra(EXTRA_RECIPIENT_ID));
////        new ViewModelProvider(this, factory).get(ChatWallpaperViewModel.class);
//
//
//    }

    @Override
    protected void onResume() {
        dynamicTheme.onResume(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);
        super.onResume();
    }

    @Override
    public void notifyExpiry() {

    }
}
