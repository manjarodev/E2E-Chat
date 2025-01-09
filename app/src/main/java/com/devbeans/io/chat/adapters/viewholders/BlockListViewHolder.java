package com.devbeans.io.chat.adapters.viewholders;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.callBacks.BlockListCallback;
import com.devbeans.io.chat.databinding.ItemBlocklistBinding;
import com.devbeans.io.chat.models.Contact;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.logging.Log;

public class BlockListViewHolder extends RecyclerView.ViewHolder {
    public final ItemBlocklistBinding mBinding;
    private final BlockListCallback onBockListCallback;
    private RequestManager mRequestManager;
    Contact mContact;
    private String name;
    private boolean isContact;

    public BlockListViewHolder(@NonNull ItemBlocklistBinding mBinding, RequestManager mRequestManager, BlockListCallback onBockListCallback) {
        super(mBinding.getRoot());
        this.mBinding = mBinding;
        this.mRequestManager = mRequestManager;
        this.onBockListCallback = onBockListCallback;
    }


    public void setData(Contact contact) {

//        mContact = MainApp.database.contactsDao().getContact(memberId);
//        boolean isContact = mContact != null;
        mBinding.layoutBlock.setOnClickListener(view -> {
            onBockListCallback.onBlockClick(contact);
        });
        setViews(contact);

    }

    private void setViews(Contact contact) {

        try {
            this.isContact = !(contact.getName().equalsIgnoreCase(contact.getChatUserId()));
            mBinding.tvContactName.setVisibility(View.VISIBLE);
            mBinding.ivContact.setVisibility(View.VISIBLE);
            mBinding.tvContactId.setVisibility(isContact ? View.VISIBLE : View.GONE);
            if (isContact) {
                mBinding.tvContactId.setText(contact.getChatUserId());
                mBinding.tvContactName.setText(contact.getName());
            } else {
                mBinding.tvContactName.setText(contact.getName());
            }

            mRequestManager.load(isContact ? Utills.INSTANCE.getNameDrawable(contact.getName(), contact.getAvatarColor()) : R.drawable.ic_unknown).into(mBinding.ivContact);
        } catch (Exception exception) {
            mBinding.tvContactName.setVisibility(View.GONE);
            mBinding.tvContactId.setVisibility(View.GONE);
            mBinding.ivContact.setVisibility(View.GONE);
            Log.e("TAG", "checkContact: ", exception);
        }
    }

    //************************************************************
    private String checkContact(String memberID)
    //************************************************************
    {
        try {
            String name;
            Contact contact = MainApp.database.contactsDao().getContact(memberID);
            this.isContact = contact != null;
            mBinding.tvContactName.setVisibility(View.VISIBLE);
            mBinding.ivContact.setVisibility(View.VISIBLE);
            mBinding.tvContactId.setVisibility(isContact ? View.VISIBLE : View.GONE);
            if (contact != null) {
                name = contact.getName();
                this.name = name;
                mBinding.tvContactId.setText(contact.getChatUserId());
                mBinding.tvContactName.setText(contact.getName());
            } else {
                name = memberID;
                this.name = memberID;
                mBinding.tvContactName.setText(memberID);
            }

            mRequestManager.load(contact != null ? Utills.INSTANCE.customImageIcon(contact.getName(), contact.getColor()) : R.drawable.ic_unknown).into(mBinding.ivContact);

            return name;
        } catch (Exception exception) {
            mBinding.tvContactName.setVisibility(View.GONE);
            mBinding.tvContactId.setVisibility(View.GONE);
            mBinding.ivContact.setVisibility(View.GONE);
            Log.e("TAG", "checkContact: ", exception);
            return null;
        }
    }
}
