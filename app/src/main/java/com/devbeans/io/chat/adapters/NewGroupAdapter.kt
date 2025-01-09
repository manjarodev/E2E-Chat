package com.devbeans.io.chat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.adapters.viewholders.NewGroupViewHolder
import com.devbeans.io.chat.callBacks.ContactsCallback
import com.devbeans.io.chat.callBacks.MemberAddCallback
import com.devbeans.io.chat.databinding.ItemGroupMemberBinding
import com.devbeans.io.chat.models.Contact

class NewGroupAdapter(
    var mContext: Context,
    var callback: ContactsCallback,
    memberAddCallback: MemberAddCallback,
    contacts: MutableList<Contact>
) : RecyclerView.Adapter<NewGroupViewHolder>() {
    var itemList: MutableList<Contact> = ArrayList()
    var mCheck = false
    var memberAddCallback: MemberAddCallback

    init {
        itemList = contacts
        this.memberAddCallback = memberAddCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewGroupViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGroupMemberBinding.inflate(layoutInflater, parent, false)
        return NewGroupViewHolder(binding, Glide.with(mContext), memberAddCallback)
    }

    override fun onBindViewHolder(holder: NewGroupViewHolder, position: Int) {
        holder.setData(itemList[position], callback, holder, position, mContext)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun clear() {
        if (itemList.size > 0) {
            itemList.clear()
            notifyDataSetChanged()
        }
    }

    fun removeItem(contact: Contact?) {
        contact ?: return  // return early if contact is null
        val position = itemList.indexOfFirst { it.chatUserId.equals(contact.chatUserId, ignoreCase = true) }
        if (position == -1) return  // return early if contact is not found
        itemList.removeAt(position).also {
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemList.size - position)
        }
    }


}