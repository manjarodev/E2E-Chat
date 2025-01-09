package com.devbeans.io.chat.utils;

import android.text.format.DateUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

import com.devbeans.io.chat.activities.ChatActivity;
import com.devbeans.io.chat.utils.logging.Log;
import com.devbeans.io.chat.utils.views.ViewUtil;

import java.util.concurrent.TimeUnit;

public class RecordTime implements Runnable {

    static final long QUOTE_REVEAL_DURATION_MILLIS = 150;
    static final int FADE_TIME = 150;
    final @NonNull
    TextView recordTimeView;
    final @NonNull
    View microphone;
    final @NonNull
    Runnable onLimitHit;
    final long limitSeconds;
    long startTime;

    public RecordTime(@NonNull TextView recordTimeView, @NonNull View microphone, long limitSeconds, @NonNull Runnable onLimitHit) {
        this.recordTimeView = recordTimeView;
        this.microphone = microphone;
        this.limitSeconds = limitSeconds;
        this.onLimitHit = onLimitHit;
    }

    @MainThread
    public void display() {
        this.startTime = System.currentTimeMillis();
        Log.e(ChatActivity.class.getSimpleName(),"Display Time: "+ this.startTime);
        this.recordTimeView.setText(DateUtils.formatElapsedTime(0));
        ViewUtil.fadeIn(this.recordTimeView, FADE_TIME);
        ThreadUtil.runOnMainDelayed(this, TimeUnit.SECONDS.toMillis(1));
        microphone.setVisibility(View.VISIBLE);
        microphone.startAnimation(pulseAnimation());
    }

    @MainThread
    public long hide() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        this.startTime = 0;
        ViewUtil.fadeOut(this.recordTimeView, FADE_TIME, View.INVISIBLE);
        microphone.clearAnimation();
        ViewUtil.fadeOut(this.microphone, FADE_TIME, View.INVISIBLE);
        Log.e(ChatActivity.class.getSimpleName(),"Start Time: "+ this.startTime +"Elapsed Time: "+elapsedTime);
        return elapsedTime;
    }

    @Override
    @MainThread
    public void run() {
        long localStartTime = startTime;
        if (localStartTime > 0) {
            long elapsedTime = System.currentTimeMillis() - localStartTime;
            long elapsedSeconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime);
            if (elapsedSeconds >= limitSeconds) {
                onLimitHit.run();
            } else {
                recordTimeView.setText(DateUtils.formatElapsedTime(elapsedSeconds));
                ThreadUtil.runOnMainDelayed(this, TimeUnit.SECONDS.toMillis(1));
            }
        }
    }

    static Animation pulseAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0, 1);

        animation.setInterpolator(pulseInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(1000);

        return animation;
    }

    static Interpolator pulseInterpolator() {
        return input -> {
            input *= 5;
            if (input > 1) {
                input = 4 - input;
            }
            return Math.max(0, Math.min(1, input));
        };
    }
}