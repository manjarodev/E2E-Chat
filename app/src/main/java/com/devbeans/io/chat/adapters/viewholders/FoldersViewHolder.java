package com.devbeans.io.chat.adapters.viewholders;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devbeans.io.chat.callBacks.OnItemTouchCallBack;
import com.devbeans.io.chat.databinding.ItemFoldersBinding;
import com.devbeans.io.chat.models.ChatRoom;

//************************************************************
public class FoldersViewHolder
        extends RecyclerView.ViewHolder
//************************************************************
{
    public ItemFoldersBinding mBinding;
    private OnItemTouchCallBack mOnItemTouchCallBack;
    private int position;
    private ChatRoom chatRoom;

    //************************************************************
    public FoldersViewHolder(@NonNull ItemFoldersBinding binding, OnItemTouchCallBack mItemTouchListener)
    //************************************************************
    {
        super(binding.getRoot());
        this.mOnItemTouchCallBack = mItemTouchListener;
        this.mBinding = binding;
        listeners();
    }

    //************************************************************
    private void listeners()
    //************************************************************
    {
        mBinding.folderLayout.setOnClickListener(view -> mOnItemTouchCallBack.onTouch(chatRoom.getChatName()));

    }

    //************************************************************
    public void setData(ChatRoom chatRoom)
    //************************************************************
    {
        this.chatRoom = chatRoom;
        mBinding.tvFolderName.setText(chatRoom.getChatName());
    }

}
