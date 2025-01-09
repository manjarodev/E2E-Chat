package com.devbeans.io.chat.activities;

import static com.devbeans.io.chat.utils.AndroidUtil.getContext;
import static com.devbeans.io.chat.utils.Constants.KEYS.INTENT_CONVERSATION;
import static com.devbeans.io.chat.utils.Constants.KEYS.INTENT_PAYLOAD;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.app.AppSession;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.callBacks.ExpiryCallback;
import com.devbeans.io.chat.databinding.ActivityScreenShowingBinding;
import com.devbeans.io.chat.models.Conversation;
import com.devbeans.io.chat.models.Messages;
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.utils.AndroidUtil;
import com.devbeans.io.chat.utils.DateTimeUtil;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.VideoPlayer;
import com.devbeans.io.chat.utils.logging.Log;
import com.devbeans.io.chat.utils.views.VideoControlsDelegate;
import com.devbeans.io.chat.verifypin.BaseActivity;

import java.io.File;
import java.util.Objects;

//************************************************************
public class ScreenShowingActivity
        extends BaseActivity implements ExpiryCallback
//************************************************************
{
    private static final String TAG = "ScreenShowingActivity";
    private ActivityScreenShowingBinding mBinding;
    private boolean toolbarHide = false;
    private boolean isFromMediaActivity = false;
    private View mView;
    private ImageView imageView;
    private ViewGroup playbackControlsContainer;
    private Payload payload = null;
    private Conversation mConversation = null;

    //For Audio Data
    private ImageView mPausePlayBtn;
    private MediaPlayer mPlayer;
    private TextView mTime;
    private SeekBar mAudioPrgs;
    private Handler seekBarHandler;
    private VideoPlayer player;

    //For Video Data
    private ImageView mPausePlayVideo;
    private VideoView mVideoView;
    private TextView mVideoTime;
    private SeekBar mVideoPrgs;
    private MediaController mVideoPlayer;
    private final Handler videoSeekBarHandler = new Handler();
    private Runnable runnable = this::updateSeekBar;
    private boolean isSender = false;
    private int mDuration, curPos;
    private Messages mMessages;
    protected Events events;


    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            if (player.isPlaying())
                player.pause();
        }
    }


    //************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    //************************************************************
    {
        super.onCreate(savedInstanceState);
        hideNavigationBar();
        changeStatusBarColor();
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_screen_showing);
        setToolBar(mBinding.toolbar);


        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);

        getDataFromChat();
        checkItemType();

//        hideToolBar();
        listeners();
//        events = (Events) getContext();


    }

    //************************************************************
    private void getDataFromChat()
    //************************************************************
    {
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            mMessages = (Messages) bundle.getSerializable("message");
            if (getIntent().hasExtra(INTENT_PAYLOAD)) {
                payload = (Payload) getIntent().getSerializableExtra(INTENT_PAYLOAD);
                isFromMediaActivity = true;
                mConversation = (Conversation) getIntent().getSerializableExtra(INTENT_CONVERSATION);
            } else {
                isFromMediaActivity = false;
            }
        }

    }

    @Override
    protected void onResume() {
        MainApp.Companion.getAppContext().setCurrentActivity(this);
        MainApp.Companion.getAppContext().setExpiryListener(this);
        if (player != null) {
            if (player.isPlaying())
                player.play();
        }
        super.onResume();
    }


    //************************************************************
    @SuppressLint("InflateParams")
    private void checkItemType()
    //************************************************************
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (mMessages != null) {
            handleMessage(mMessages, inflater);
        }

        if (payload != null) {
            handlePayload(payload, inflater);


        }
    }

    private void handlePayload(Payload payload, LayoutInflater inflater) {

        if (payload.getType().equalsIgnoreCase("audio")) {
//                if (mMessages.getVoice().getUrl() != null && !mMessages.getVoice().getUrl().isEmpty()) {
            mView = inflater.inflate(R.layout.item_audio_screen, null);
            mBinding.frameLayout.addView(mView);
            initAudioViews();
//                }
        }

        //If the data is of Video type inflate Video Screen
        if (payload.getType().equalsIgnoreCase("video")) {
            if (payload.getData() != null && !payload.getData().isEmpty()) {
                mView = inflater.inflate(R.layout.item_video_screen, null);
                mBinding.frameLayout.addView(mView);
                initVideoViews();
            }
        }

        if (payload.getType().equalsIgnoreCase("image")) {
            if (payload.getData() != null && !payload.getData().isEmpty()) {

                mView = inflater.inflate(R.layout.item_image_screen, null);
                imageView = mView.findViewById(R.id.iv_image_screen);
                mBinding.frameLayout.addView(mView);
                initImage();
            }
        }
    }

    private void handleMessage(Messages mMessages, LayoutInflater inflater) {
        if (mMessages.getUser().getChatUserId().equalsIgnoreCase(AppSession.getUser().getChatUserId())) {
            isSender = true;
        }

//            if (mMessages.getFile().getUrl()!=null)
        //if the data is of Image type inflate Image screen
//        View view = inflater.inflate(R.layout.item_image_screen, null);
//        imageView = view.findViewById(R.id.iv_image_screen);
//        mBinding.frameLayout.addView(view);
        if (mMessages.getPayload().getType().equalsIgnoreCase("audio")) {
//                if (mMessages.getVoice().getUrl() != null && !mMessages.getVoice().getUrl().isEmpty()) {
            mView = inflater.inflate(R.layout.item_audio_screen, null);
            mBinding.frameLayout.addView(mView);
            initAudioViews();
//                }
        }
        //If the data is of Video type inflate Video Screen
        if (mMessages.getPayload().getType().equalsIgnoreCase("video")) {
            if (mMessages.getPayload().getData() != null && !mMessages.getPayload().getData().isEmpty()) {
                mView = inflater.inflate(R.layout.item_video_screen, null);
                mBinding.frameLayout.addView(mView);
                initVideoViews();
            }
        }
        if (mMessages.getPayload().getType().equalsIgnoreCase("image")) {
            if (mMessages.getPayload().getData() != null && !mMessages.getPayload().getData().isEmpty()) {

                mView = inflater.inflate(R.layout.item_image_screen, null);
                imageView = mView.findViewById(R.id.iv_image_screen);
                mBinding.frameLayout.addView(mView);
                initImage();
            }
        }
    }

    private void initImage() {
        if (mMessages != null) {
            imageView = findViewById(R.id.iv_image_screen);
            Glide.with(this)
                    .load(mMessages.getPayload().getFilePath())
                    .into(imageView);
            mBinding.tvFileTitle.setText(mMessages.getPayload().getData());

        }
        if (payload != null && payload.getFilePath() != null) {
            File file = new File(payload.getFilePath());
            if (file.exists()) {
                mBinding.tvFileTitle.setText(file.getName());
                imageView = findViewById(R.id.iv_image_screen);
                Glide.with(this)
                        .load(file)
                        .into(imageView);
            }
        }
    }

    //************************************************************
    private void initVideoViews()
    //************************************************************
    {
//        mVideoView = mView.findViewById(R.id.vv_screen);
//        mVideoPlayer = new MediaController(ScreenShowingActivity.this);
//        mVideoPlayer.setAnchorView(mVideoView);
        player = mView.findViewById(R.id.video_player);
        playbackControlsContainer = findViewById(R.id.media_preview_playback_controls_container);
        player.setWindow(getWindow());
        View playbackControls = player.getControlView();
        if (playbackControls != null) {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            playbackControls.setLayoutParams(params);
            if (playbackControlsContainer != null) {
                playbackControlsContainer.removeAllViews();
                playbackControlsContainer.addView(playbackControls);
            }
        }
        player.setPlayerCallback(new VideoPlayer.PlayerCallback() {

            @Override
            public void onReady() {
//                    controller.onPlayerReady();
            }

            @Override
            public void onPlaying() {
//                    hud.fadePlayButton();
            }

            @Override
            public void onStopped() {

//                    hud.showPlayButton();
            }

            @Override
            public void onError() {
//                    controller.onPlayerError();
            }
        });

//        setDimension();
        playVideo();
    }

    private void playVideo() {
        if (mMessages != null) {
            if (mMessages.getPayload().getFilePath() != null) {
                File file = new File(mMessages.getPayload().getFilePath());
                if (file.exists()) {
                    mBinding.tvFileTitle.setText(file.getName());

                    Uri uri = Uri.parse(mMessages.getPayload().getFilePath());
                    //            mVideoView.setVideoPath(MainApp.Companion.getAppContext().getFilesDir().getPath() + mMessages.getPayload().getData());
                    player.setVideoSource(uri, false);
                    player.play();
                    //            mDuration = getDuration(uri);
                    //            mVideoView.requestFocus();
                    //            mBinding.tvFileTitle.setText(Constants.TITLE);
                    //            mVideoView.setMediaController(mVideoPlayer);
                    //            mVideoView.start();

                }

            }
        }
        if (payload != null) {
            if (payload.getFilePath() != null) {
                File file = new File(payload.getFilePath());
                if (file.exists()) {
                    mBinding.tvFileTitle.setText(file.getName());
                    Uri uri = Uri.parse(payload.getFilePath());
                    player.setVideoSource(uri, false);
                    player.play();


                }

            }
        }

    }

    private void setDimension() {
        // Adjust the size of the video
        // so it fits on the screen
//        float videoProportion = getVideoProportion();
//        int screenWidth = getResources().getDisplayMetrics().widthPixels;
//        int screenHeight = getResources().getDisplayMetrics().heightPixels;
//        float screenProportion = (float) screenHeight / (float) screenWidth;
//        android.view.ViewGroup.LayoutParams lp = mVideoView.getLayoutParams();
//
//        if (videoProportion < screenProportion) {
//            lp.height= screenHeight;
//            lp.width = (int) ((float) screenHeight / videoProportion);
//        } else {
//            lp.width = screenWidth;
//            lp.height = (int) ((float) screenWidth * videoProportion);
//        }
//        mVideoView.setLayoutParams(lp);
    }

    // This method gets the proportion of the video that you want to display.
// I already know this ratio since my video is hardcoded, you can get the
// height and width of your video and appropriately generate  the proportion
//    as :height/width
    private float getVideoProportion() {
        return 1.5f;
    }

    //************************************************************
    private void initAudioViews()
    //************************************************************
    {
        mPlayer = new MediaPlayer();
        mTime = mView.findViewById(R.id.tv_audio_time);
        mAudioPrgs = mView.findViewById(R.id.seekBar_audio);
        mPausePlayBtn = mView.findViewById(R.id.iv_play_pause_audio);

        initPlayer();
        updateSeekBar();

        mPlayer.setOnCompletionListener(mp -> {
            mAudioPrgs.setProgress(0);
            mPausePlayBtn.setImageDrawable(ContextCompat.getDrawable(ScreenShowingActivity.this, R.drawable.ic_play));
            seekBarHandler.removeCallbacksAndMessages(null);
            finish();
        });
        mAudioPrgs.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                // was essential to over ride

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                // was essential to over ride

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    if (mPlayer != null) {
                        mPlayer.seekTo(progress);
                    }
                }
            }
        });

    }

    //************************************************************
    private void initPlayer()
    //************************************************************
    {

        if (payload != null && payload.getFilePath() != null) {
            File file = new File(payload.getFilePath());
            if (file.exists()) {
                mPlayer = MediaPlayer.create(this, Uri.parse(file.getAbsolutePath()));
                mAudioPrgs.setMax(mPlayer.getDuration());
                mPlayer.start();
            }
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null) {
            mPlayer.release();
            seekBarHandler.removeCallbacksAndMessages(null);
        }

//        if (player != null) {
//            player.cleanup();
//        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (player != null) {
            player.cleanup();
        }
    }

    private void updateSeekBar() {
        if (mPlayer != null) {
            try {
                mAudioPrgs.setProgress(mPlayer.getCurrentPosition());
                mTime.setText(DateTimeUtil.milliSecondsToTimer(mPlayer.getCurrentPosition()));
                seekBarHandler = new Handler();
                if (mPlayer.isPlaying())
                    mPausePlayBtn.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_pause_media));

                seekBarHandler.postDelayed(runnable, 100);
            } catch (Exception e) {
                Log.d(TAG, "updateSeekBar: " + e.getMessage());
            }


        } else {
            mPausePlayBtn.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_play));
            mAudioPrgs.setProgress(0);
//            mPlayer.release();
        }
    }


    //************************************************************
    private void listeners()
    //************************************************************
    {
//        if (imageView != null)
//            imageView.setOnClickListener(view -> hideToolBar());

//        mBinding.frameLayout.setOnClickListener(view -> hideToolBar());

        if (mPausePlayBtn != null)
            mPausePlayBtn.setOnClickListener(view -> {

                if (mPlayer != null) {
                    if (mPlayer.isPlaying()) {
                        mPlayer.pause();
                        mPausePlayBtn.setImageDrawable(ContextCompat.getDrawable(ScreenShowingActivity.this, R.drawable.ic_play));
                        updateSeekBar();
                        return;
                    }
                    if (!mPlayer.isPlaying())
                        mPlayer.start();
                    mPausePlayBtn.setImageDrawable(ContextCompat.getDrawable(ScreenShowingActivity.this, R.drawable.ic_pause_media));
                    updateSeekBar();
                }

            });


        mBinding.ivDelete.setOnClickListener(view -> showDeleteDialog());
    }

    //************************************************************
    private void hideToolBar()
    //************************************************************
    {
        if (!toolbarHide) {
            Objects.requireNonNull(getSupportActionBar()).hide();
            toolbarHide = true;
            return;
        }
        Objects.requireNonNull(getSupportActionBar()).show();
        toolbarHide = false;
    }

    //************************************************************
    @SuppressLint("ObsoleteSdkInt")
    private void changeStatusBarColor()
    //************************************************************
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
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

    //*************************************************
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    //*************************************************
    {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideNavigationBar();
        }
    }

    //*************************************************
    private void hideNavigationBar()
    //*************************************************
    {
        getWindow().getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
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

    //************************************************************
    private void showDeleteDialog()
    //************************************************************
    {

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Delete ‘’" + "Company chat group" + "’’?");

        builder.setPositiveButton("Delete", (dialogInterface, i) -> {


        });

        builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

        });
        builder.show();

    }

    public static int getDuration(Uri url) {
        try (MediaMetadataRetriever retriever = new MediaMetadataRetriever()) {
            retriever.setDataSource(getContext(), url);
            String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            return Integer.parseInt(time);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();

    }

    @Override
    public void notifyExpiry() {
        if (mBinding != null) {
            Utills.INSTANCE.showSubscriptionBanner(mBinding.tvSubs);
        }
    }

    public interface Events {
        boolean singleTapOnMedia();

        void mediaNotAvailable();

        void onMediaReady();

        default @Nullable
        VideoControlsDelegate getVideoControlsDelegate() {
            return null;
        }
    }
}