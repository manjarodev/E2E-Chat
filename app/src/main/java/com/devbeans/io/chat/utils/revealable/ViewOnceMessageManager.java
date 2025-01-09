package com.devbeans.io.chat.utils.revealable;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import com.devbeans.io.chat.dependencies.ApplicationDependencies;
import com.devbeans.io.chat.extensions.ContextKt;
import com.devbeans.io.chat.models.OfflineAck;
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.roomDB.Dao.MessagesDao;
import com.devbeans.io.chat.roomDB.Dao.OfflineAckDao;
import com.devbeans.io.chat.services.TimedEventManager;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.logging.Log;

import java.io.File;
import java.util.List;


/**
 * Manages clearing removable message content after they're opened.
 */
public class ViewOnceMessageManager extends TimedEventManager<ViewOnceExpirationInfo> {

    private static final String TAG = Log.tag(ViewOnceMessageManager.class);
    private final MessagesDao mmsDatabase;
    private final OfflineAckDao offlineAckDao;
    private ViewOnceExpirationInfo expirationInfo;


    public ViewOnceMessageManager(@NonNull Application application) {
        super(application, "RevealableMessageManager");
        expirationInfo = new ViewOnceExpirationInfo(
                "sdcsdc",
                0
        );
        this.mmsDatabase = ContextKt.getMessagesDao(application.getApplicationContext());
        this.offlineAckDao = ContextKt.getOfflineAckDao(application.getApplicationContext());

        scheduleIfNecessary();
    }

    public void setNextClosestEvent() {
        expirationInfo = new ViewOnceExpirationInfo(
                Utills.INSTANCE.getRandomString(10),
                0
        );
        if (mmsDatabase != null && offlineAckDao != null)
            scheduleIfNecessary();
    }

    @WorkerThread
    @Override
    protected @Nullable
    ViewOnceExpirationInfo getNextClosestEvent() {


//    ViewOnceExpirationInfo expirationInfo = mmsDatabase.getNearestExpiringViewOnceMessage();

        if (expirationInfo != null) {
            Log.i(TAG, "Next closest expiration is in " + getDelayForEvent(expirationInfo) + " ms for messsage " + expirationInfo.getMessageId() + ".");
        } else {
            Log.i(TAG, "No messages to schedule.");
        }

        return expirationInfo;
    }

    @WorkerThread
    @Override
    protected void executeEvent(@NonNull ViewOnceExpirationInfo event) {
//        Log.i(TAG, "Deleting attachments for message " + event.getMessageId());


        List<Payload> payloadList = mmsDatabase.getAllMessagesViewed();
        Log.e(TAG, "Data " + payloadList);
        expirationInfo = null;
        if (!payloadList.isEmpty()) {
            for (Payload payload : payloadList) {
                if (payload.getFilePath() != null) {
                    handleDeleteMedia(payload);
                }

            }
        }

        handleOfflineAcks();

//    attachmentDatabase.deleteAttachmentFilesForViewOnceMessage(event.getMessageId());
    }

    private void handleDeleteMedia(Payload payload) {
        try {

            File file = new File(payload.getFilePath());
            if (file.exists()) {
                boolean fileDeleted = file.delete();
                if (fileDeleted) {
                    mmsDatabase.updateFilePath(payload.getMessageId(), null);
                }
            } else {
                mmsDatabase.updateFilePath(payload.getMessageId(), null);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleOfflineAcks() {
        try {
            List<OfflineAck> ackList = offlineAckDao.getAllAck();
            if (!ackList.isEmpty()) {
                Utills.INSTANCE.sendOfflineAcknowledgements();
            } else {
                Log.e(TAG, "Did not had acks");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @WorkerThread
    @Override
    protected long getDelayForEvent(@NonNull ViewOnceExpirationInfo event) {
        long expiresAt = event.getReceiveTime() + ViewOnceUtil.MAX_LIFESPAN;
        long timeLeft = expiresAt - System.currentTimeMillis();

        return Math.max(0, 0);
    }

    @AnyThread
    @Override
    protected void scheduleAlarm(@NonNull Application application, long delay) {
        setAlarm(application, delay, ViewOnceAlarm.class);
    }

    public static class ViewOnceAlarm extends BroadcastReceiver {

        private static final String TAG = Log.tag(ViewOnceAlarm.class);

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive()");

            ApplicationDependencies.getViewOnceMessageManager().scheduleIfNecessary();
        }
    }
}
