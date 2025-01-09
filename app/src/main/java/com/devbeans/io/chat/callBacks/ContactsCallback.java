package com.devbeans.io.chat.callBacks;

import com.devbeans.io.chat.adapters.viewholders.ContactViewHolder;
import com.devbeans.io.chat.models.Contact;

//************************************************************
public interface ContactsCallback
//************************************************************
{
    void onContactClick(Contact contact, ContactViewHolder viewHolder,int position);
    void onCheckBoxClick(Contact contact, ContactViewHolder viewHolder, int position, boolean isFromGroupAdapter, boolean isChecked);
}
