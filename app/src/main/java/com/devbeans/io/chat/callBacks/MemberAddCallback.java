package com.devbeans.io.chat.callBacks;

import androidx.recyclerview.widget.RecyclerView;

import com.devbeans.io.chat.models.Contact;

public interface MemberAddCallback {
    void onMemberAddClick(Contact contact, RecyclerView.ViewHolder holder, int position, boolean isFromMember, boolean isChecked);
}
