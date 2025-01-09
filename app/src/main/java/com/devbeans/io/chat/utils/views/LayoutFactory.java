package com.devbeans.io.chat.utils.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.devbeans.io.chat.adapters.viewholders.MappingViewHolder;
import com.devbeans.io.chat.callBacks.Factory;
import com.devbeans.io.chat.callBacks.MappingModel;

import java.util.function.Function;


public class LayoutFactory<T extends MappingModel<T>> implements Factory<T> {
    private       Function<View, MappingViewHolder<T>> creator;
    private final int                                  layout;

    public LayoutFactory(@NonNull Function<View, MappingViewHolder<T>> creator, @LayoutRes int layout) {
        this.creator = creator;
        this.layout  = layout;
    }

    @Override
    public @NonNull MappingViewHolder<T> createViewHolder(@NonNull ViewGroup parent) {
        return creator.apply(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
    }
}