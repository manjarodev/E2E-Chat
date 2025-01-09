package com.devbeans.io.chat.verifypin;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.devbeans.io.chat.utils.logging.Log;

import java.util.concurrent.TimeUnit;

public class VerifyPinWorker extends Worker {

    private final Context context;
    private long startTime = 0;
    int count = 0;


    public VerifyPinWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        startTime = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
        doSomeWork();
        return Result.success();
    }


    private void doSomeWork() {

        count = count + 1;
        Log.e("SomeWorker", "-------> working " + count);

        long currentTime = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
        long difference = currentTime - startTime;

        if (difference < 12) {
            try {

                Intent intent = new Intent("com.chat.verify.pin");
                intent.putExtra("showDialog", true);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

                Thread.sleep(900000);      //new interval

                doSomeWork();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}