package com.devbeans.io.chat.adapters;


import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.devbeans.io.chat.callBacks.MappingModel;

class MappingDiffCallback extends DiffUtil.ItemCallback<MappingModel<?>> {
    @Override
    public boolean areItemsTheSame(@NonNull MappingModel oldItem, @NonNull MappingModel newItem) {
        if (oldItem.getClass() == newItem.getClass()) {
            //noinspection unchecked
            return oldItem.areItemsTheSame(newItem);
        }
        return false;
    }

    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(@NonNull MappingModel oldItem, @NonNull MappingModel newItem) {
        if (oldItem.getClass() == newItem.getClass()) {
            //noinspection unchecked
            return oldItem.areContentsTheSame(newItem);
        }
        return false;
    }

    @Override
    public @Nullable Object getChangePayload(@NonNull MappingModel oldItem, @NonNull MappingModel newItem) {
        if (oldItem.getClass() == newItem.getClass()) {
            //noinspection unchecked
            return oldItem.getChangePayload(newItem);
        }

        return null;
    }
}
