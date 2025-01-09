package com.devbeans.io.chat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.adapters.viewholders.ShareContactViewHolder
import com.devbeans.io.chat.callBacks.ShareContactsCallback
import com.devbeans.io.chat.databinding.ItemContactBinding
import com.devbeans.io.chat.models.Contact
import java.util.*

class ShareContactAdapter :
    RecyclerView.Adapter<ShareContactViewHolder> {

    //    var itemList: MutableList<Contact> = ArrayList()
    private var contactList: MutableList<Contact> = mutableListOf()
    var mContext: Context
    var callback: ShareContactsCallback
    var holder: ShareContactViewHolder? = null

    constructor(
        mContext: Context,
        callback: ShareContactsCallback
    ) {
        this.mContext = mContext
        this.callback = callback
    }


    //************************************************************
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShareContactViewHolder
    //************************************************************
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(layoutInflater, parent, false)
        return ShareContactViewHolder(binding, Glide.with(mContext))
    }

    //************************************************************
    override fun onBindViewHolder(
        holder: ShareContactViewHolder,
        position: Int
    ) //************************************************************
    {

        this.holder = holder
        holder.setData(contactList[position], callback, holder, position)

    }


    //************************************************************
    override fun getItemCount(): Int
    //************************************************************
    {
        return contactList.size
    }

//    @SuppressLint("NotifyDataSetChanged")
    fun filteredList(filteredList: MutableList<Contact>) {
        val oldContacts: List<Contact> = LinkedList(contactList)
        contactList.clear()
        contactList.addAll(filteredList)
        DiffUtil
            .calculateDiff(Callback(oldContacts, contactList))
            .dispatchUpdatesTo(this)
//        contactList = filteredList
//        notifyDataSetChanged()
    }

    //*********************************************************
//    @SuppressLint("NotifyDataSetChanged")
    fun setContactList(contacts: MutableList<Contact>)
    //*********************************************************
    {
        val oldContacts: List<Contact> = LinkedList(contactList)
        contactList.clear()
        contactList.addAll(contacts)
        DiffUtil
            .calculateDiff(Callback(oldContacts, contactList))
            .dispatchUpdatesTo(this)
//        contactList = contacts
//        notifyDataSetChanged()
    }


    private class Callback(
        private val oldList: List<Contact>,
        private val newList: List<Contact>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].chatUserId == newList[newItemPosition].chatUserId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

}