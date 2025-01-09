package com.devbeans.io.chat.services;


import android.content.Context;

import com.devbeans.io.chat.activities.ChatActivity;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.extensions.ContextKt;
import com.devbeans.io.chat.models.Conversation;
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.roomDB.Dao.ConversationsDao;
import com.devbeans.io.chat.roomDB.Dao.MessagesDao;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.logging.Log;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExpiringMessageManager {

    private static final String TAG = Log.tag(ExpiringMessageManager.class);

    private final TreeSet<ExpiringMessageReference> expiringMessageReferences = new TreeSet<>(new ExpiringMessageComparator());
    private final Executor executor = Executors.newSingleThreadExecutor();

    private final MessagesDao smsDatabase;
    private final ConversationsDao conversationDao;
    private final Context context;

    public ExpiringMessageManager(Context context) {
        this.context = context;
        this.smsDatabase = ContextKt.getMessagesDao(context);
        this.conversationDao = ContextKt.getConversationsDao(context);
        executor.execute(new LoadTask());
        executor.execute(new ProcessTask());
    }

    public void scheduleDeletion(long id, String messageId, boolean mms, long expiresInMillis, String type, String filePath, String conversationId) {
        scheduleDeletion(id, messageId, mms, System.currentTimeMillis(), expiresInMillis, type, filePath, conversationId);
    }

    public void scheduleDeletion(@NotNull Payload payload) {
        scheduleDeletion(payload.getId(), payload.getMessageId(), false, payload.getExpireStarted(), payload.getMsgExpiryTime(), payload.getType(), payload.getFilePath(), payload.getConversationId());
    }

    public void scheduleDeletion(long id, String messageId, boolean mms, long startedAtTimestamp, long expiresInMillis, String type, String filePath, String conversationId) {
        long expiresAtMillis = startedAtTimestamp + expiresInMillis;

        synchronized (expiringMessageReferences) {
            expiringMessageReferences.add(new ExpiringMessageReference(id, messageId, mms, expiresAtMillis, type, filePath, conversationId));
            expiringMessageReferences.notifyAll();
        }
    }

    public void checkSchedule() {
        synchronized (expiringMessageReferences) {
            expiringMessageReferences.notifyAll();
        }
    }

    public void runTask() {
        executor.execute(new LoadTask());
        executor.execute(new ProcessTask());
    }


    private class LoadTask implements Runnable {
        public void run() {
            List<Payload> smsReader = smsDatabase.getAllExpiryMessage();

            Payload messageRecord;

            while ((messageRecord = (smsReader.listIterator().hasNext() ? smsReader.listIterator().next() : null)) != null) {
                expiringMessageReferences.add(new ExpiringMessageReference(messageRecord.getId(),
                        messageRecord.getMessageId(),
                        false,
                        messageRecord.getExpireStarted() + messageRecord.getMsgExpiryTime(),
                        messageRecord.getType(),
                        messageRecord.getFilePath(),
                        messageRecord.getConversationId())
                );
                smsReader.remove(messageRecord);
            }

        }
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private class ProcessTask implements Runnable {
        public void run() {
            while (true) {
                ExpiringMessageReference expiredMessage = null;

                synchronized (expiringMessageReferences) {
                    try {
                        while (expiringMessageReferences.isEmpty())
                            expiringMessageReferences.wait();

                        ExpiringMessageReference nextReference = expiringMessageReferences.first();
                        long waitTime = nextReference.expiresAtMillis - System.currentTimeMillis();

                        if (waitTime > 0) {
                            ExpirationListener.setAlarm(context, waitTime);
                            expiringMessageReferences.wait(waitTime);
                        } else {
                            expiredMessage = nextReference;
                            expiringMessageReferences.remove(nextReference);
                        }

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        Log.w(TAG, e);
                    } catch (Exception e) {
                        Log.w(TAG, e);
                    }
                }

                if (expiredMessage != null) {
                    try {
                        handleDeleting(expiredMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void handleDeleting(ExpiringMessageReference expiredMessage) {
        smsDatabase.deleteByMessageId(expiredMessage.getMessageId());
        try {
            if (!expiredMessage.getType().equalsIgnoreCase("text") && expiredMessage.getFilePath() != null) {
                File file = new File(expiredMessage.getFilePath());
                if (file.exists()) {
                    boolean deleted = file.delete();
                    Utills.INSTANCE.handleFileDelete(TAG, deleted);
                }
            }
        } catch (Exception e) {
            Log.w(TAG, e);
        }

        try {

            Conversation conversation = conversationDao.getConversation(expiredMessage.conversationId);
            if (conversation != null && conversation.getLastMessage() != null) {
                if (conversation.getLastMessage().getMessageId().equalsIgnoreCase(expiredMessage.getMessageId())) {
                    conversation.setLastMessage(null);
                    conversationDao.update(conversation);
                }
            }
        } catch (Exception e) {
            Log.w(TAG, e);

        }


        if (MainApp.Companion.getAppContext().getCurrentActivity() != null) {
            ExpiringMessageReference finalExpiredMessage = expiredMessage;
            MainApp.Companion.getAppContext().getCurrentActivity().runOnUiThread(() -> {
                if (ChatActivity.getChatInstance() != null) {
                    ChatActivity.getInstance().deleteExpiryMessage(finalExpiredMessage.getMessageId());
                }
            });
        }
//


    }

    private static class ExpiringMessageReference {
        private final long id;
        private final boolean mms;
        private final long expiresAtMillis;
        private final String messageId;
        private final String type;
        private final String filePath;
        private final String conversationId;


        public String getConversationId() {
            return conversationId;
        }

        public String getType() {
            return type;
        }

        public String getFilePath() {
            return filePath;
        }

        public String getMessageId() {
            return messageId;
        }

        private ExpiringMessageReference(long id, String messageId, boolean mms, long expiresAtMillis, String type, String filePath, String conversationId) {
            this.id = id;
            this.mms = mms;
            this.expiresAtMillis = expiresAtMillis;
            this.messageId = messageId;
            this.type = type;
            this.filePath = filePath;
            this.conversationId = conversationId;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) return false;
            if (!(other instanceof ExpiringMessageReference)) return false;

            ExpiringMessageReference that = (ExpiringMessageReference) other;
            return Objects.equals(this.messageId, that.messageId) && this.mms == that.mms && this.expiresAtMillis == that.expiresAtMillis;
        }

        @Override
        public int hashCode() {
            return (int) this.id ^ (mms ? 1 : 0) ^ (int) expiresAtMillis;
        }
    }

    private static class ExpiringMessageComparator implements Comparator<ExpiringMessageReference> {
        @Override
        public int compare(ExpiringMessageReference lhs, ExpiringMessageReference rhs) {
            if (lhs.expiresAtMillis < rhs.expiresAtMillis) return -1;
            else if (lhs.expiresAtMillis > rhs.expiresAtMillis) return 1;
            else if (lhs.id < rhs.id) return -1;
            else if (lhs.id > rhs.id) return 1;
            else if (!lhs.mms && rhs.mms) return -1;
            else if (lhs.mms && !rhs.mms) return 1;
            else return 0;
        }
    }

}
