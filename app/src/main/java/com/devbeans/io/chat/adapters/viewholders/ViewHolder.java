package com.devbeans.io.chat.adapters.viewholders;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Base ViewHolder
 */
public abstract class ViewHolder<DATA> extends RecyclerView.ViewHolder {

    public abstract void onBind(DATA data);

    public ViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
    }

}
