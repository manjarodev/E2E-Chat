package com.devbeans.io.chat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback
import com.devbeans.io.chat.databinding.ChatWallpaperSelectionAdapterItemBinding
import com.devbeans.io.chat.models.ChatWallpaper
import com.devbeans.io.chat.models.Conversation
import java.util.*

class ChatWallpaperAdapter(
    var onWallpaperSelectCallback: OnWallpaperSelectCallback,
    var context: Context,
    var conversation: Conversation? = null
) : RecyclerView.Adapter<ChatWallpaperAdapter.WallpaperViewHolder>() {


    val wallpaperList: MutableList<ChatWallpaper> = mutableListOf()
    var selectedPosition: Int = -1
    private var selectionMode: Boolean = false
    private var count: Int = -1

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ChatWallpaperAdapter.WallpaperViewHolder {
        return WallpaperViewHolder(
            ChatWallpaperSelectionAdapterItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), onWallpaperSelectCallback, context
        )
    }


    override fun onBindViewHolder(
        holder: ChatWallpaperAdapter.WallpaperViewHolder, position: Int
    ) {
        holder.setData(wallpaperList[position], position)
    }


    override fun getItemCount(): Int {
        return wallpaperList.size
    }


    fun submitWallpapers(colors: List<ChatWallpaper>) {
        val oldWallpaper: List<ChatWallpaper> = LinkedList(wallpaperList)
        wallpaperList.clear()
        wallpaperList.addAll(colors)
        count = -1
        selectionMode = false
        DiffUtil.calculateDiff(Callback(oldWallpaper, wallpaperList))
            .dispatchUpdatesTo(this)
    }


    private class Callback(
        private val oldList: List<ChatWallpaper>, private val newList: List<ChatWallpaper>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].chatWallpaper == newList[newItemPosition].chatWallpaper
        }
    }

    inner class WallpaperViewHolder
        (
        var mBinding: ChatWallpaperSelectionAdapterItemBinding,
        var onWallpaperSelectCallback: OnWallpaperSelectCallback,
        var context: Context
    ) : RecyclerView.ViewHolder(
        mBinding.root
    ) {

        fun setData(wallpaper: ChatWallpaper, position: Int) {
            Glide.with(context).load(wallpaper.chatWallpaper).into(mBinding.image)

            mBinding.select.visibility = if (wallpaper.isSelected) View.VISIBLE else View.GONE

            mBinding.image.setOnClickListener {

                onWallpaperSelectCallback.onWallpaperSelected(wallpaper.chatWallpaper)
//                SettingsValues.setDefaultChatWallpaperSet(true)
//                SettingsValues.setDefaultChatWallpaper(wallpaper.chatWallpaper)
//                wallpaperList.forEach {
//                    it.isSelected = it.chatWallpaper == wallpaper.chatWallpaper
//                }
//                notifyItemRangeChanged(0, wallpaperList.size)
            }
        }
    }
}