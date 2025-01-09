package com.devbeans.io.chat.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.adapters.ContactFragmentAdapter;
import com.devbeans.io.chat.adapters.viewholders.ContactViewHolder;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.callBacks.ContactsCallback;
import com.devbeans.io.chat.callBacks.ExpiryCallback;
import com.devbeans.io.chat.databinding.ActivityAddMemberBinding;
import com.devbeans.io.chat.models.Contact;
import com.devbeans.io.chat.utils.Constants;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.verifypin.BaseActivity;

import java.util.ArrayList;
import java.util.Objects;

public class AddMemberActivity extends BaseActivity implements ContactsCallback, ExpiryCallback {

    ActivityAddMemberBinding mBinding;
    private ContactFragmentAdapter mAdapter;
    private ArrayList<String> memberList = new ArrayList<>();
    private ArrayList<Contact> nonMembersList = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);
        if (mBinding == null) {
            mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_member);
        }
        setToolBar(mBinding.toolbar);
        getIntentData();
        populateRecyclerView();
        observers();
        setSearchContacts();


    }

    @Override
    protected void onResume() {
        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);
        super.onResume();
    }

    private void getIntentData() {
        if (getIntent().getExtras() != null) {
            if (getIntent().hasExtra(Constants.KEYS.INTENT_MEMBER_LIST)) {
                memberList = getIntent().getStringArrayListExtra(Constants.KEYS.INTENT_MEMBER_LIST);
            }
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


    //************************************************************
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void observers()
    //************************************************************
    {
        MainApp.database.contactsDao().getLiveContacts().observe(AddMemberActivity.this, list -> {
            if (list != null && list.size() > 0) {
                for (Contact c : list) {
                    if (!memberList.contains(c.getChatUserId())) {
                        nonMembersList.add(c);
                    }
                }
                if (nonMembersList.size() > 0) mAdapter.setContactList(nonMembersList);
                else {
                    mBinding.tvTextNotification.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    //************************************************************
    private void populateRecyclerView()
    //************************************************************
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(AddMemberActivity.this, LinearLayoutManager.VERTICAL, false);
        mBinding.rvContacts.setLayoutManager(layoutManager);
        mAdapter = new ContactFragmentAdapter(AddMemberActivity.this, this);
        mBinding.rvContacts.setAdapter(mAdapter);
    }

    private void setSearchContacts() {
        mBinding.searchBar.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//This method only works before the text is stated to change which is not needed
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//This method only works after the text is stated to change which is not needed
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<Contact> filteredList = new ArrayList<>();
        if (nonMembersList.size() > 0) {
            for (Contact item : nonMembersList) {
                if (item.getName().toLowerCase().contains(text.toLowerCase()) || item.getChatUserId().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            mAdapter.filteredList(filteredList);
        }
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
    public void onContactClick(Contact contact, ContactViewHolder viewHolder, int position) {
        Intent intent = getIntent();
        intent.putExtra(Constants.KEYS.INTENT_MEMBER_ID, contact);
        setResult(RESULT_OK, intent);
        finish();
    }


    @Override
    public void onCheckBoxClick(Contact contact, ContactViewHolder viewHolder, int position, boolean isFromGroupAdapter, boolean isChecked) {
 /*
        Method is for check box selection which is not used here
     */
    }

    @Override
    public void notifyExpiry() {
        if (mBinding != null) {
            Utills.INSTANCE.showSubscriptionBanner(mBinding.tvSubs);
        }
    }
}