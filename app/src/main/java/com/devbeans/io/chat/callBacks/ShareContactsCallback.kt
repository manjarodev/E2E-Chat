package com.devbeans.io.chat.callBacks

import com.devbeans.io.chat.adapters.viewholders.ShareContactViewHolder
import com.devbeans.io.chat.models.Contact

interface ShareContactsCallback {
    fun onContactClick(contact: Contact?, viewHolder: ShareContactViewHolder?, position: Int)
}