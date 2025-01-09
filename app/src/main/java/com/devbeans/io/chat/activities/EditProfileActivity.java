package com.devbeans.io.chat.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.callBacks.ExpiryCallback;
import com.devbeans.io.chat.databinding.ActivityEditProfileBinding;
import com.devbeans.io.chat.utils.AndroidUtil;
import com.devbeans.io.chat.utils.Constants;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.logging.Log;
import com.devbeans.io.chat.verifypin.BaseActivity;

import java.util.Objects;

//************************************************************
@java.lang.SuppressWarnings("squid:S2696")
public class EditProfileActivity
        extends BaseActivity implements ExpiryCallback
//************************************************************
{
    ActivityEditProfileBinding mBinding;
    ActivityResultLauncher<String> mGetContent;
    ActivityResultLauncher<Intent> mGetPermission;
    Uri mImgUri;

    //************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    //************************************************************
    {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile);
        setToolBar(mBinding.toolbar);


        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);

        registerForActivityResults();
        listeners();


    }

    @Override
    protected void onResume() {
        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);
        super.onResume();
    }

    //************************************************************

    private void listeners()
    //************************************************************
    {
        mBinding.fabUpload.setOnClickListener(view -> imageChoose());
        mBinding.btnSaveInfo.setOnClickListener(view -> {
            Constants.URI = mImgUri;
            Constants.NICK_NAME = mBinding.etChatName.getText().toString();
            finish();
        });

    }


    private void registerForActivityResults()
    //************************************************************
    {
        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), result -> {
            Glide.with(this)
                    .load(result)
                    .into(mBinding.ivChatImage);
            mImgUri = result;
        });
        mGetPermission = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                AndroidUtil.toast(false, "Permission Granted");

            }
        });


    }

    //************************************************************
    private void imageChoose()
    //************************************************************
    {
        takePermissions();
        mGetContent.launch("image/*");
    }


    //************************************************************
    private void takePermissions()
    //************************************************************
    {
        if (isPermissionGranted())
            Log.d("TAG", "takePermissions: Permission Already Granted");
        else {
            takePermission();
        }
    }

    //************************************************************
    private boolean isPermissionGranted()
    //************************************************************
    {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.R)
            return Environment.isExternalStorageManager();

        else {
            int readExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return readExternalStoragePermission == PackageManager.PERMISSION_GRANTED;
        }
    }

    //************************************************************
    private void takePermission()
    //************************************************************
    {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.R) {
            try {
//this was being used for taking permission
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}
                    , 101);
        }

    }

    //************************************************************
    private void setToolBar(Toolbar toolbar)
    //************************************************************
    {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    // ******************************************************************
    @MainThread
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    // ******************************************************************
    {
        if (item.getItemId() == android.R.id.home) {
            finish();
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