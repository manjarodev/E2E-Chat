package com.devbeans.io.chat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.adapters.viewholders.ShareToViewHolder
import com.devbeans.io.chat.callBacks.ShareRoomsListCallback
import com.devbeans.io.chat.databinding.ItemSharetoMemberBinding
import com.devbeans.io.chat.models.Conversation
import java.util.*


class ShareToAdapter
    (var shareRoomsListCallback: ShareRoomsListCallback, var context: Context) :
    RecyclerView.Adapter<ShareToViewHolder>()
{
    //    var mChatRoomList: List<Conversation?> = ArrayList()
    private var conversationList: MutableList<Conversation> = mutableListOf()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShareToViewHolder
    {
        return ShareToViewHolder(
            ItemSharetoMemberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), shareRoomsListCallback, context
        )
    }


    override fun onBindViewHolder(
        holder: ShareToViewHolder,
        position: Int
    )
    {
        holder.setData(conversationList[position])
    }


    override fun getItemCount(): Int
    {
        return conversationList.size
    }

    fun setChatRoomList(conversationsList: MutableList<Conversation>) {

        val oldConversation: List<Conversation> = LinkedList(conversationsList)
        conversationList.clear()
        conversationList.addAll(conversationsList)
        DiffUtil
            .calculateDiff(Callback(oldConversation, conversationList))
            .dispatchUpdatesTo(this)
    }

//    @RequiresApi(api = Build.VERSION_CODES.N)
    fun filteredList(filteredList: MutableList<Conversation>) {
        try {
            val oldConversations: List<Conversation> = LinkedList(conversationList)
            conversationList.clear()
            conversationList.addAll(filteredList)
            DiffUtil
                .calculateDiff(Callback(oldConversations, conversationList))
                .dispatchUpdatesTo(this)

//            filteredList.sortby(Comparator.comparing { o: Conversation ->
//                getDateFromString(
//                    o.lastMessage!!.createdAt
//                )
//            })
//            Collections.reverse(filteredList)
//            mChatRoomList = filteredList
//            notifyDataSetChanged()
        } catch (e: Exception) {
//            Log.e(TAG, "filteredList: ", e);
        }
    }

    private class Callback(
        private val oldList: List<Conversation>,
        private val newList: List<Conversation>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].conversationId == newList[newItemPosition].conversationId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}