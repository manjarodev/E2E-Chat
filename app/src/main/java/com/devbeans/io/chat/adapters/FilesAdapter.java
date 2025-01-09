package com.devbeans.io.chat.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devbeans.io.chat.adapters.viewholders.FilesViewHolder;
import com.devbeans.io.chat.databinding.ItemFilesBinding;
import com.devbeans.io.chat.models.ChatRoom;

import java.util.ArrayList;
import java.util.List;

//************************************************************
public class FilesAdapter
        extends RecyclerView.Adapter<FilesViewHolder>
//************************************************************
{

    List<ChatRoom> mChatRoomLists = new ArrayList<>();

    //************************************************************
    @NonNull
    @Override
    public FilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                              int viewType)
    //************************************************************
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFilesBinding binding = ItemFilesBinding.inflate(layoutInflater, parent, false);
        return new FilesViewHolder(binding);
    }


    //************************************************************
    @Override
    public void onBindViewHolder(@NonNull FilesViewHolder holder,
                                 int position)
    //************************************************************
    {
        holder.setData(mChatRoomLists.get(position));
        if (position == mChatRoomLists.size() - 1)
            holder.mBinding.separator.setVisibility(View.GONE);

    }

    //************************************************************
    @Override
    public int getItemCount()
    //************************************************************
    {
        return mChatRoomLists.size();
    }

    //************************************************************
    @SuppressLint("NotifyDataSetChanged")
    public void setChatRoomLists(List<ChatRoom> mChatRoomLists)
    //************************************************************
    {
        this.mChatRoomLists = mChatRoomLists;
        notifyDataSetChanged();
    }

}
