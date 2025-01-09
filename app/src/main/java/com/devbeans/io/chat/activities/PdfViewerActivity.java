package com.devbeans.io.chat.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.callBacks.ExpiryCallback;
import com.devbeans.io.chat.databinding.ActivityPdfViewerBinding;
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.utils.Constants;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.verifypin.BaseActivity;

import java.io.File;

public class PdfViewerActivity extends BaseActivity implements ExpiryCallback {

    private ActivityPdfViewerBinding binding;
    private File selectedFile;
    private Payload payload;
    private int pageNumber;
    private boolean isFromOthers = false;
    private String TAG = PdfViewerActivity.class.getSimpleName();

    @Override
    protected void onResume() {
        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfViewerBinding.inflate(getLayoutInflater());
        MainApp.Companion.getAppContext().setExpiryListener(this);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (getIntent().getSerializableExtra(Constants.KEYS.INTENT_PAYLOAD) != null) {
            payload = (Payload) getIntent().getSerializableExtra(Constants.KEYS.INTENT_PAYLOAD);
        }

        if (payload != null && payload.getFilePath() != null) {
            selectedFile = new File(payload.getFilePath());
            if (selectedFile.exists()) {

                binding.activityMainPdfView.fromFile(selectedFile).show();
//                getSupportActionBar().setTitle(selectedFile.getName());
//                binding.pdfView.fromFile(selectedFile)
//                        .defaultPage(0)
//                        .onPageChange(PdfViewerActivity.this)
//                        .enableAnnotationRendering(true)
//                        .onLoad(PdfViewerActivity.this)
//                        .scrollHandle(new DefaultScrollHandle(PdfViewerActivity.this))
//                        .spacing(10) // in dp
//                        .onPageError(PdfViewerActivity.this)
////                .pageFitPolicy(FitPolicy.BOTH)
//                        .load();
            }
        }

    }


    //****************************************************************
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    //****************************************************************
    {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void notifyExpiry() {
        if (binding != null) {
            Utills.INSTANCE.showSubscriptionBanner(binding.tvSubs);
        }
    }
}