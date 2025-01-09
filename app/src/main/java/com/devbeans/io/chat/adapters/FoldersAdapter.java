package com.devbeans.io.chat.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devbeans.io.chat.adapters.viewholders.FoldersViewHolder;
import com.devbeans.io.chat.callBacks.OnItemTouchCallBack;
import com.devbeans.io.chat.databinding.ItemFoldersBinding;
import com.devbeans.io.chat.models.ChatRoom;

import java.util.ArrayList;
import java.util.List;

//************************************************************
public class FoldersAdapter
        extends RecyclerView.Adapter<FoldersViewHolder>
//************************************************************
{
    List<ChatRoom> mChatRoomList = new ArrayList<>();
    OnItemTouchCallBack mItemTouchListener;

    //************************************************************
    public FoldersAdapter(OnItemTouchCallBack mItemTouchListener)
    //************************************************************
    {
        this.mItemTouchListener = mItemTouchListener;
    }

    //************************************************************
    @NonNull
    @Override
    public FoldersViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                int viewType)
    //************************************************************
    {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ItemFoldersBinding binding = ItemFoldersBinding.inflate(layoutInflater, parent, false);
        return new FoldersViewHolder(binding, mItemTouchListener);
    }


    //************************************************************
    @Override
    public void onBindViewHolder(@NonNull FoldersViewHolder holder,
                                 int position)
    //************************************************************
    {
        holder.setData(mChatRoomList.get(position));
        if (position == mChatRoomList.size() - 1)
            holder.mBinding.separator.setVisibility(View.GONE);
    }

    //************************************************************
    @Override
    public int getItemCount()
    //************************************************************
    {
        return mChatRoomList.size();
    }

    //************************************************************
    @SuppressLint("NotifyDataSetChanged")
    public void setChatRoomList(List<ChatRoom> mChatRoomList)
    //************************************************************
    {
        this.mChatRoomList = mChatRoomList;
        notifyDataSetChanged();
    }
}
