package com.devbeans.io.chat.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.adapters.viewholders.ContactFragmentViewHolder
import com.devbeans.io.chat.callBacks.ContactsCallback
import com.devbeans.io.chat.databinding.ItemContactViewBinding
import com.devbeans.io.chat.models.Contact

class ContactFragmentAdapter(private val mContext: Context, private val callback: ContactsCallback) : RecyclerView.Adapter<ContactFragmentViewHolder>() {
    private var itemList: List<Contact> = ArrayList()
    private lateinit var mRequestManager: RequestManager
    private var header = ' '

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactFragmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemContactViewBinding.inflate(layoutInflater, parent, false)
        mRequestManager = Glide.with(mContext)
        return ContactFragmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactFragmentViewHolder, position: Int) {
        checkCharOfName(holder, position)
        holder.setData(itemList[position], callback, holder, position, mRequestManager)
    }

    private fun checkCharOfName(holder: ContactFragmentViewHolder, position: Int) {
        if (itemList[position].name?.get(0)?.uppercaseChar() != header) {
            holder.mBinding.tvLabel.visibility = View.VISIBLE
            holder.mBinding.tvLabel.text = itemList[position].name?.get(0)?.uppercase().toString()
            header = itemList[position].name?.get(0)?.uppercaseChar()!!
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setContactList(contactList: List<Contact>) {
        itemList = contactList.sortedBy { it.name }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size

    fun getAllItems(): List<Contact> = itemList

    @SuppressLint("NotifyDataSetChanged")
    fun filteredList(filteredList: ArrayList<Contact>) {
        itemList = filteredList
        notifyDataSetChanged()
    }
}
