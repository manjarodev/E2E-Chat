package com.devbeans.io.chat.adapters

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.adapters.viewholders.ArchiveViewHolder
import com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback
import com.devbeans.io.chat.databinding.ItemArchiveBinding
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.utils.logging.Log
import java.util.*

//************************************************************
class ArchiveAdapters
    (
    private val mContext: Context,
    private val callback: ArchiveRoomsListCallback
) :
    RecyclerView.Adapter<ArchiveViewHolder>()
//************************************************************
{
    private var mChatRoomList: List<Conversation> = ArrayList()
    private var mRequestManager: RequestManager? = null

    //************************************************************
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArchiveViewHolder
    //************************************************************
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemArchiveBinding.inflate(layoutInflater, parent, false)
        mRequestManager = Glide.with(mContext)
        return ArchiveViewHolder(binding, Glide.with(mContext), callback)
    }

    //************************************************************
    override fun onBindViewHolder(
        holder: ArchiveViewHolder,
        position: Int
    )
    //************************************************************
    {
        holder.setData(mContext, mChatRoomList[position], position, holder)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setChatRoomList(chatRoomList: MutableList<Conversation>) {
        mChatRoomList = if (chatRoomList.isNotEmpty()) {
            val pinnedList = chatRoomList.filter { it.isPinned }
                .sortedByDescending { it.sequenceOfConversation }
            val unpinnedList = chatRoomList.filter { !it.isPinned }
                .sortedByDescending { it.sequenceOfConversation }


            pinnedList + unpinnedList
        } else {
            chatRoomList
        }

        notifyDataSetChanged()
    }

    //************************************************************
    override fun getItemCount(): Int
    //************************************************************
    {
        return mChatRoomList.size
    }
}