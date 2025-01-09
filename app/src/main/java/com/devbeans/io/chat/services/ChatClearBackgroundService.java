package com.devbeans.io.chat.services;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.models.Conversation;
import com.devbeans.io.chat.models.Payload;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.logging.Log;

import java.io.File;
import java.util.List;

/**
 * Works with {@link com.devbeans.io.chat.activities.ChatSettingsActivity} to exists as a service that will keep the app process running in the background while we clear messages.
 */
public class ChatClearBackgroundService extends Service {

    private static final String TAG = Log.tag(ChatClearBackgroundService.class);

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startDeleteConversation();
        if (MainApp.database.conversationsDao().getAllConversations() != null && MainApp.database.conversationsDao().getAllConversations().size() == 0) {
            Log.e(TAG, "All chats cleared");
            stopSelf();
        } else {
            startDeleteConversation();
        }
        return START_STICKY;

    }

    private void startDeleteConversation() {
        try {
            for (Conversation conversation :
                    MainApp.database.conversationsDao().getAllConversations()) {
                clearChat(conversation);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error deleting conversations");
            e.printStackTrace();
        }
    }

    //************************************************************
    private void clearChat(Conversation conversation)
    //************************************************************
    {

        try {
            List<Payload> mediaMessage = MainApp.database.messagesDao().getAllMediaMessages(conversation.getConversationId());
            //Getting all the media files of the conversation for them to delete
            if (mediaMessage != null && mediaMessage.size() > 0) {
                //If there are any media files delete them one by one
                for (Payload payload : mediaMessage) {
                    if (payload.getFilePath() != null) {
                        File file = new File(payload.getFilePath());
                        //if the file exist delete it from the file path
                        if (file.exists()) {
                            boolean delete = file.delete();
                            Utills.INSTANCE.handleFileDelete(TAG,delete);

                            MainApp.database.messagesDao().deleteByMessageId(payload.getMessageId());
                        }
                    }
                }
            }
            //Delete all messages of the conversation from local Database
            MainApp.database.messagesDao().deleteConversationMessages(conversation.getConversationId());

            //Delete conversation
            MainApp.database.conversationsDao().delete(conversation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public @Nullable
    IBinder onBind(Intent intent) {
        return null;
    }
}

