package com.devbeans.io.chat.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.R
import com.devbeans.io.chat.callBacks.ChatSettingsCallback
import com.devbeans.io.chat.databinding.ItemDailogSettingsBinding
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.SettingsValues
import com.devbeans.io.chat.utils.Utills.getKeepChatOptions
import java.util.*

class DialogSettingsAdapter(
    private val context: Context,
    private val onSettingsClick: ChatSettingsCallback,
    private val dataOff: Int
) : RecyclerView.Adapter<DialogSettingsAdapter.ViewHolder>() {
    //    private var settingsList: List<String?> = ArrayList()
    private val settingsList: MutableList<String> = mutableListOf()
    var checkedPosition = -1
    private var fontCheckedPosition = -1
    private var emojiCheckedPosition = -1
    fun setSettingsList(settingList: List<String>) {

        val oldSettingsList: List<String> = LinkedList(settingsList)
        settingsList.clear()
        settingsList.addAll(settingList)
//        this.settingsList = settingsList
        when (dataOff) {
            0 -> if (settingsList.contains(getKeepChatOptions(SettingsValues.getKeepChatTime()))) {
                checkedPosition =
                    settingsList.indexOf(getKeepChatOptions(SettingsValues.getKeepChatTime()))
            }
            7 -> {
                fontCheckedPosition = when {
                    SettingsValues.getMessageFontSize() <= 22 -> {
                        0
                    }
                    else -> {
                        1
                    }
                }
                emojiCheckedPosition = when {
                    SettingsValues.getMessageEmojiSize() <= 22 -> {
                        2
                    }

                    SettingsValues.getMessageEmojiSize() <= 42 -> {
                        3
                    }
                    else -> {
                        4
                    }
                }

            }
        }

        DiffUtil
            .calculateDiff(Callback(oldSettingsList, settingsList))
            .dispatchUpdatesTo(this)
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDailogSettingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(settingsList[position])

        if (dataOff == 7) {
            holder.binding.option.isChecked =
                emojiCheckedPosition == position || fontCheckedPosition == position

            if (position == 2) {
                holder.binding.tvTitle.visibility = View.VISIBLE
                holder.binding.tvTitle.text = AndroidUtil.getString(R.string.select_emoji_size)

            }
        } else {
            holder.binding.option.isChecked = checkedPosition == position
            holder.binding.tvTitle.visibility = View.GONE
        }
        holder.binding.option.setOnClickListener {
            checkedPosition = position
            if (dataOff == 7) {
                emojiCheckedPosition = if (position >= 2) position else emojiCheckedPosition
                fontCheckedPosition = if (position < 2) position else fontCheckedPosition
            }
//            val settingList = settingsList
            onSettingsClick.onSettingsClick(settingsList[position], dataOff)
            onSettingsClick.onSettingsClick(position, dataOff)

//            val oldSettingsList: List<String> = LinkedList(settingsList)
//            settingsList.clear()
//            settingsList.addAll(settingList)
//
//            DiffUtil
//                .calculateDiff(Callback(oldSettingsList, settingsList))
//                .dispatchUpdatesTo(this)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return settingsList.size
    }

    class ViewHolder(val binding: ItemDailogSettingsBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(settingsModel: String?) {
            binding.option.text = settingsModel
        }
    }


    private class Callback(
        private val oldList: List<String>,
        private val newList: List<String>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}