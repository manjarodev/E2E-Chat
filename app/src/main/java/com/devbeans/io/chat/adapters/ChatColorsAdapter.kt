package com.devbeans.io.chat.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.callBacks.OnColorSelectCallback
import com.devbeans.io.chat.databinding.ChatColorSelectionAdapterItemBinding
import com.devbeans.io.chat.models.ChatColor
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.SettingsValues
import java.util.*

class ChatColorsAdapter
    (
    var onColorSelectCallback: OnColorSelectCallback, var context: Context
) : RecyclerView.Adapter<ChatColorsAdapter.ChatViewHolder>() {


    val colorList: MutableList<ChatColor> = mutableListOf()
    var selectedPosition: Int = -1
    private var selectionMode: Boolean = false
    private var count: Int = -1

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ChatColorsAdapter.ChatViewHolder {
        return ChatViewHolder(
            ChatColorSelectionAdapterItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), onColorSelectCallback, context
        )
    }


    override fun onBindViewHolder(
        holder: ChatColorsAdapter.ChatViewHolder, position: Int
    ) {
        holder.setData(colorList[position], position)
    }


    override fun getItemCount(): Int {
        return colorList.size
    }


    fun submitColors(colors: List<ChatColor>) {
        val oldMedia: List<ChatColor> = LinkedList(colorList)
        colorList.clear()
        colorList.addAll(colors)
        count = -1
        selectionMode = false
        DiffUtil.calculateDiff(Callback(oldMedia, colorList)).dispatchUpdatesTo(this)
    }

    private class Callback(
        private val oldList: List<ChatColor>, private val newList: List<ChatColor>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].chatColor == newList[newItemPosition].chatColor
        }
    }

    inner class ChatViewHolder
//************************************************************
        (
        var mBinding: ChatColorSelectionAdapterItemBinding,
        var onColorSelectCallback: OnColorSelectCallback,
        var context: Context
    ) : RecyclerView.ViewHolder(
        mBinding.root
    ) //************************************************************
    {

        public fun setData(color: ChatColor, position: Int) {
            mBinding.chatColor.setColorFilter(
                AndroidUtil.getColor(color.chatColor)
            )

            mBinding.select.visibility = if (color.isSelected) View.VISIBLE else View.GONE
            mBinding.chatColor.setOnClickListener {
                SettingsValues.setDefaultChatColorsSet(true)
                SettingsValues.setDefaultChatColor(AndroidUtil.getColor(color.chatColor))
                colorList.forEach {
                    it.isSelected = it.chatColor == color.chatColor
                }
                notifyItemRangeChanged(0, colorList.size)
            }
        }
    }

    fun ImageView.setTint(@ColorRes colorRes: Int) {
        ImageViewCompat.setImageTintList(
            this, ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
        )
    }
}