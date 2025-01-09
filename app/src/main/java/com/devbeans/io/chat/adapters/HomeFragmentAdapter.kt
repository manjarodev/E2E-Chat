package com.devbeans.io.chat.adapters


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.adapters.viewholders.HomeFragmentViewHolder
import com.devbeans.io.chat.callBacks.RoomsListCallback
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.utils.logging.Log
import java.util.*

//**********************************************
class HomeFragmentAdapter(var mContext: Context, var mCallback: RoomsListCallback) :
    RecyclerView.Adapter<HomeFragmentViewHolder>() //**********************************************
{
    var mChatRoomList: List<Conversation?> = ArrayList()

    //***********************************************************
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeFragmentViewHolder //***********************************************************
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = com.devbeans.io.chat.databinding.ItemChatsBinding.inflate(layoutInflater, parent, false)
        return HomeFragmentViewHolder(binding, Glide.with(mContext))
    }

    //***********************************************************
    override fun onBindViewHolder(
        holder: HomeFragmentViewHolder,
        position: Int
    ) //***********************************************************
    {
        holder.setData(mChatRoomList[position]!!, mCallback)
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setChatRoomList(chatRoomList: MutableList<Conversation?>) {
        mChatRoomList = if (chatRoomList.isNotEmpty()) {
            val pinnedList = chatRoomList.filter { it?.isPinned!! }
                .sortedByDescending { it?.sequenceOfConversation }
            val unpinnedList = chatRoomList.filter { !it?.isPinned!! }
                .sortedByDescending { it?.sequenceOfConversation }


            pinnedList + unpinnedList
        } else {
            chatRoomList
        }

        notifyDataSetChanged()
    }

    //***********************************************************
    override fun getItemCount(): Int
    //***********************************************************
    {
        return mChatRoomList.size
    }

    fun filteredList(filteredList: MutableList<Conversation?>) {
        if (filteredList.isNotEmpty()) {
            val pinnedList = filteredList.filter { it?.isPinned!! }
                .sortedByDescending { it?.sequenceOfConversation }
            val unpinnedList = filteredList.filter { !it?.isPinned!! }
                .sortedByDescending { it?.sequenceOfConversation }
            mChatRoomList = pinnedList + unpinnedList
            notifyDataSetChanged()
        }
    }
}