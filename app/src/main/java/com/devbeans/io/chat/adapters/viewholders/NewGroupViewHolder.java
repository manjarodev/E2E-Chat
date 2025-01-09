package com.devbeans.io.chat.adapters.viewholders;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devbeans.io.chat.callBacks.ContactsCallback;
import com.devbeans.io.chat.callBacks.MemberAddCallback;
import com.devbeans.io.chat.databinding.ItemGroupMemberBinding;
import com.devbeans.io.chat.models.Contact;

public class NewGroupViewHolder extends RecyclerView.ViewHolder {

    public ItemGroupMemberBinding mBinding;
    private final RequestManager mRequestManager;
    private final MemberAddCallback memberAddCallback;

    //************************************************************
    public NewGroupViewHolder(@NonNull ItemGroupMemberBinding mBinding, RequestManager with, MemberAddCallback memberAddCallback)
    //************************************************************
    {
        super(mBinding.getRoot());
        this.mBinding = mBinding;
        this.mRequestManager = with;
        this.memberAddCallback = memberAddCallback;

    }

    public void setData(Contact contact, ContactsCallback callback, NewGroupViewHolder holder, int position, Context mContext) {
        mBinding.tvSelectedMember.setText(contact.getName());

        mBinding.layoutMember.setOnClickListener(view -> memberAddCallback.onMemberAddClick(contact, holder, position, true, true));
    }
}
