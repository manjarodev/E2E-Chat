package com.devbeans.io.chat.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.callBacks.ExpiryCallback;
import com.devbeans.io.chat.databinding.ActivityNotificationBinding;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.verifypin.BaseActivity;

import java.util.Objects;

//************************************************************
public class NotificationActivity
        extends BaseActivity implements ExpiryCallback
//************************************************************
{
    private ActivityNotificationBinding mBinding;

    //************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    //************************************************************
    {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_notification);
        setToolBar(mBinding.toolbar);


        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);

    }


    //************************************************************
    private void setToolBar(Toolbar toolbar)
    //************************************************************
    {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);
        super.onResume();
    }


    // ******************************************************************
    @MainThread
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    // ******************************************************************
    {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void notifyExpiry() {
        if (mBinding != null) {
            Utills.INSTANCE.showSubscriptionBanner(mBinding.tvSubs);
        }
    }
}