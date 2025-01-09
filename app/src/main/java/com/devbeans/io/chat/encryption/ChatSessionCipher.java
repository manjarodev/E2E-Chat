package com.devbeans.io.chat.encryption;

import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.extensions.ContextKt;
import com.devbeans.io.chat.models.ConversationChannels;
import com.devbeans.io.chat.roomDB.Dao.ConversationChannelsDao;
import com.devbeans.io.chat.utils.ChatSessionLock;
import com.devbeans.io.chat.utils.logging.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChatSessionCipher {
    private final ChatSessionLock lock;
    private final ConversationChannels conversationChannel;
    public static final String TAG = ChatSessionCipher.class.getSimpleName();
    public final ConversationChannelsDao database;

    public ChatSessionCipher(ChatSessionLock lock, ConversationChannels conversationChannel) {
        this.lock = lock;
        this.conversationChannel = conversationChannel;
        this.database = ContextKt.getConversationChannelsDao(MainApp.Companion.getAppContext());

    }

    public ConversationChannels encrypt() throws Exception {
        try (ChatSessionLock.Lock unused = lock.acquire()) {
            if (conversationChannel.getFriendDHKey() != null && !conversationChannel.getFriendDHKey().isEmpty()) {
                Log.e(TAG, "[${channel.channelWith}]:\t Ticking DHRatchet");
                conversationChannel.setCacheRachet(conversationChannel.getDHRatchet());
                conversationChannel.DHRatchetNext();
                database.update(conversationChannel);
            }

            return conversationChannel;
        }
    }

    public @Nullable ConversationChannels decrypt(@NotNull String nextDHKey) {
        try (ChatSessionLock.Lock unused = lock.acquire()) {

            if (conversationChannel.getFriendDHKey() == null || !nextDHKey.equals(
                    conversationChannel.getFriendDHKey()
            )
            ) {

                Log.e(TAG, "Friend DH Key ${channel.FriendDHKey}");
                Log.e(TAG, "Next DH Key Recieved ${decryptedPayload.nextDHKey}");

                conversationChannel.setFriendDHKey(nextDHKey);
                conversationChannel.preDHRatchet();
                database.updateFriendDHKey(
                        conversationChannel.getChannelIdentifier(),
                        conversationChannel.getFriendDHKey());
                Log.e(TAG, "DH Key");
            }
            return conversationChannel;
        }


    }


}
