package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.callBacks.ContactsCallback
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.databinding.ItemContactViewBinding

class ContactFragmentViewHolder(var mBinding: ItemContactViewBinding) :
    RecyclerView.ViewHolder(mBinding.root) {


    fun setData(
        item: Contact,
        callback: ContactsCallback,
        holder: ContactFragmentViewHolder?,
        position: Int,
        requestManager: RequestManager
    ) {

        mBinding.tvAddedByQr.visibility = if (item.isQrAdded) View.VISIBLE else View.GONE
        mBinding.tvContactName.text = item.name
        val nick = item.alias?.takeIf {
            it.trim().isNotEmpty() && !it.equals(item.name?.trim(), ignoreCase = true)
        } ?: ""

        mBinding.tvContactId.text = if (nick.isNotEmpty()) String.format("~$nick") else nick
        mBinding.root.setOnClickListener {
            callback.onContactClick(item, null, position)
        }

//        val imageIcon = Utills.customImageIcon(item.name, item.color)
        val nameDrawable = getNameDrawable(item.name, item.avatarColor!!)
        requestManager.load(nameDrawable).into(mBinding.ivContact)
    }

}