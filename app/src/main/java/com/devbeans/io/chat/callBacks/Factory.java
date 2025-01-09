package com.devbeans.io.chat.callBacks;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.devbeans.io.chat.adapters.viewholders.MappingViewHolder;

public interface Factory<T extends MappingModel<T>> {
    @NonNull
    MappingViewHolder<T> createViewHolder(@NonNull ViewGroup parent);
}