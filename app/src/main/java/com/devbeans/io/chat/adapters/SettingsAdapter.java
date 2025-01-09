package com.devbeans.io.chat.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.callBacks.OnSettingsClick;
import com.devbeans.io.chat.databinding.ItemSettingsBinding;
import com.devbeans.io.chat.models.SettingsModel;
import com.devbeans.io.chat.utils.AndroidUtil;
import com.devbeans.io.chat.utils.views.ViewUtil;

import java.util.ArrayList;
import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {

    private List<SettingsModel> settingsList = new ArrayList<>();
    private final Context context;
    private final OnSettingsClick onSettingsClick;

    public SettingsAdapter(Context context, OnSettingsClick onSettingsClick) {
        this.context = context;
        this.onSettingsClick = onSettingsClick;
    }

    public void setSettingsList(List<SettingsModel> settingsList) {
        this.settingsList = settingsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSettingsBinding binding = ItemSettingsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(settingsList.get(position));
        holder.itemView.setOnClickListener(v -> {
            onSettingsClick.onSettingsClick(settingsList.get(position));
            onSettingsClick.onSettingsClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return settingsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemSettingsBinding binding;

        public ViewHolder(@NonNull ItemSettingsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(SettingsModel settingsModel) {
            if (settingsModel.getHeading().equalsIgnoreCase(AndroidUtil.getString(R.string.autolock_settings)) || settingsModel.getHeading().equalsIgnoreCase(AndroidUtil.getString(R.string.import_export))) {
                binding.tvMessage.setMaxLines(1);
                binding.tvMessage.setMinLines(1);
                if (settingsModel.getHeading().equalsIgnoreCase(AndroidUtil.getString(R.string.import_export)))
                    ViewUtil.setTopMargin(binding.separator1, 0);

            } else {
                binding.tvMessage.setMaxLines(2);
                binding.tvMessage.setMinLines(2);
            }
            binding.ivIcon.setImageResource(settingsModel.getIcon());
            binding.tvHeading.setText(settingsModel.getHeading());
            binding.tvMessage.setText(settingsModel.getMessage());
        }

    }
}
