package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import com.devbeans.io.chat.models.Messages
import com.stfalcon.chatkit.messages.MessageHolders

class SelfGroupOutgoingViewHolderMessageHolder(itemView: View, payload: Any?) :
    MessageHolders.OutcomingTextMessageViewHolder<Messages>(itemView, payload) {



    override fun onBind(message: Messages) {
        super.onBind(message)

    }

    private fun init(itemView: View) {


        // was essential to over ride


    }

    init {
        init(itemView)
    }
}