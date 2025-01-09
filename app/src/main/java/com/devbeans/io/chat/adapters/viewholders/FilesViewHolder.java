package com.devbeans.io.chat.adapters.viewholders;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devbeans.io.chat.databinding.ItemFilesBinding;
import com.devbeans.io.chat.models.ChatRoom;

//************************************************************
public class FilesViewHolder
        extends RecyclerView.ViewHolder
//************************************************************
{
    public ItemFilesBinding mBinding;

    //************************************************************
    public FilesViewHolder(@NonNull ItemFilesBinding mBinding)
    //************************************************************
    {
        super(mBinding.getRoot());
        this.mBinding = mBinding;
    }

    //************************************************************
    public void setData(ChatRoom chatRoom)
    //************************************************************
    {
        mBinding.tvFolderName.setText(chatRoom.getChatName());
    }
}
