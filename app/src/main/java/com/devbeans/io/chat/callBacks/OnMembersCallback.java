package com.devbeans.io.chat.callBacks;

import com.devbeans.io.chat.models.ConversationMember;

public interface OnMembersCallback {
    void onMemberCallback(ConversationMember id, String name);
}
