package com.devbeans.io.chat.callBacks;

import com.devbeans.io.chat.adapters.MessageAdapter;
import com.devbeans.io.chat.models.Message;


public interface SentMessageCallback {
    void onSentMessageClick(Message message, MessageAdapter.SentMessageViewHolder viewHolder, int position);
    void onSentMessageLongClick(Message message, MessageAdapter.SentMessageViewHolder viewHolder,int position);
    void onReceivedMessageClick(Message message, MessageAdapter.ReceivedMessageHolder viewHolder, int position);
    void onReceivedMessageLongClick(Message message,MessageAdapter.ReceivedMessageHolder viewHolder,int position);
}
