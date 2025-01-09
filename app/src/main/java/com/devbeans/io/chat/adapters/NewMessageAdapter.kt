package com.devbeans.io.chat.adapters


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.adapters.viewholders.ContactViewHolder
import com.devbeans.io.chat.callBacks.ContactsCallback
import com.devbeans.io.chat.databinding.ItemContactBinding
import com.devbeans.io.chat.models.Contact

//************************************************************
class NewMessageAdapter :
    RecyclerView.Adapter<ContactViewHolder>
//************************************************************
{
    var itemList: MutableList<Contact> = ArrayList()
    var mContext: Context
    var mCheck = false
    var callback: ContactsCallback
    var holder: ContactViewHolder? = null


    constructor(
        mContext: Context,
        callback: ContactsCallback
    ) {
        this.mContext = mContext
        this.callback = callback
    }

    constructor(
        mContext: Context,
        callback: ContactsCallback,
        contacts: MutableList<Contact>
    ) {
        this.mContext = mContext
        this.callback = callback
        itemList = contacts
    }

    //************************************************************
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder
    //************************************************************
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(layoutInflater, parent, false)
        return ContactViewHolder(binding, Glide.with(mContext))
    }

    //************************************************************
    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) //************************************************************
    {
        if (mCheck) holder.mBinding.ivQr.visibility = View.VISIBLE
        if (!mCheck) holder.mBinding.ivQr.visibility = View.GONE
        this.holder = holder
        holder.setData(itemList[position], callback, holder, position)
        if (mCheck) {
            holder.mBinding.ivQr.isChecked = itemList[position].isChecked
        }
    }

    //************************************************************
    @SuppressLint("NotifyDataSetChanged")
    fun showCheckBox() //************************************************************
    {
        mCheck = true
        notifyDataSetChanged()
    }

    //************************************************************
    @SuppressLint("NotifyDataSetChanged")
    fun hideCheckBox() //************************************************************
    {
        mCheck = false
        notifyDataSetChanged()
    }

    //*********************************************************
    @SuppressLint("NotifyDataSetChanged")
    fun setChatRoomList(chatRoomList: MutableList<Contact>) //*********************************************************
    {
        itemList = chatRoomList
        notifyDataSetChanged()
    }

    //************************************************************
    override fun getItemCount(): Int //************************************************************
    {
        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filteredList(filteredList: ArrayList<Contact>) {

        filteredList.forEach {
            itemList.filter { item -> item.chatUserId == it.chatUserId }
                .forEach { itemNew -> it.isChecked = itemNew.isChecked }

        }

        itemList = filteredList
        notifyDataSetChanged()
    }

    fun clear() {
        itemList.clear()
        notifyDataSetChanged()
    }

    fun removeItem(contact: Contact?) {
        var position = 0
        for (i in itemList.indices) {
            if (contact != null && contact.chatUserId.equals(
                    itemList[i].chatUserId,
                    ignoreCase = true
                )
            ) {
                position = i
                itemList[position].isChecked = false
                break
            }
        }
        //        this.itemList.get(position).setChecked(false);
        notifyItemChanged(position)
    }
}