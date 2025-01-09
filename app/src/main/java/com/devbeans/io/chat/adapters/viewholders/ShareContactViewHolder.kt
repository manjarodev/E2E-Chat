package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.callBacks.ShareContactsCallback
import com.devbeans.io.chat.databinding.ItemContactBinding
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.utils.Utills

class ShareContactViewHolder(
    var mBinding: ItemContactBinding,
    private val mRequestManager: RequestManager
) :
    RecyclerView.ViewHolder(
        mBinding.root
    ) {

    //************************************************************
    fun setData(
        contact: Contact,
        callback: ShareContactsCallback?,
        holder: ShareContactViewHolder?,
        position: Int
    )
    //************************************************************
    {
        mBinding.ivQr.visibility = View.GONE
        mRequestManager.load(Utills.getNameDrawable(contact.name, (contact.avatarColor)!!))
            .into(mBinding.ivContact)
        mBinding.tvContactName.text = contact.name
        if (contact.alias != null && contact.alias!!.trim { it <= ' ' }
                .isNotEmpty() && contact.alias!!.trim() != contact.name!!.trim()) {
            mBinding.tvContactNickName.visibility = View.VISIBLE
            mBinding.tvContactNickName.text = String.format("~%s", contact.alias)
        } else {
            mBinding.tvContactNickName.visibility = View.GONE
        }
        mBinding.root.setOnClickListener {
            callback?.onContactClick(
                contact,
                holder,
                position
            )
        }
    }


}
