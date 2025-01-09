package com.devbeans.io.chat.callBacks;

import com.devbeans.io.chat.models.Conversation;

public interface ShareRoomsListCallback {

    void onShareRoomClick(Conversation conversation, String name, String s, int i, String color, boolean isContact);
}
