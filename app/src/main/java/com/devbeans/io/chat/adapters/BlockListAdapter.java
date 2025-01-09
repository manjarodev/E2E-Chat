package com.devbeans.io.chat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.devbeans.io.chat.adapters.viewholders.BlockListViewHolder;
import com.devbeans.io.chat.callBacks.BlockListCallback;
import com.devbeans.io.chat.databinding.ItemBlocklistBinding;
import com.devbeans.io.chat.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class BlockListAdapter extends RecyclerView.Adapter<BlockListViewHolder> {


    public void setBlockList(List<Contact> blockList) {
        this.blockList = blockList;
    }

    List<Contact> blockList=new ArrayList<>();
    private RequestManager mRequestManager;
    Context mContext;
    BlockListCallback blockListCallback;

    public BlockListAdapter( Context mContext, BlockListCallback blockListCallback) {
        this.mContext = mContext;
        this.blockListCallback = blockListCallback;
    }

    @NonNull
    @Override
    public BlockListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBlocklistBinding binding=ItemBlocklistBinding.inflate(layoutInflater, parent, false);
        return new BlockListViewHolder(binding, Glide.with(mContext),blockListCallback);
    }


    @Override
    public void onBindViewHolder(@NonNull BlockListViewHolder holder, int position) {
            holder.setData(blockList.get(position));
    }

    @Override
    public int getItemCount() {
        return blockList.size();
    }

    public void filteredList(ArrayList<Contact> filteredList) {
        this.blockList = filteredList;
        notifyDataSetChanged();
    }
}
