package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.callBacks.ContactsCallback
import com.devbeans.io.chat.databinding.ItemContactBinding
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.utils.Utills.getNameDrawable

//************************************************************
class ContactViewHolder
    (
    var mBinding: ItemContactBinding,
    private val mRequestManager: RequestManager
) :
    RecyclerView.ViewHolder(
        mBinding.root
    )
{
    //************************************************************
    fun setData(
        chatRoom: Contact,
        callback: ContactsCallback?,
        holder: ContactViewHolder?,
        position: Int
    ) //************************************************************
    {
//        mRequestManager.load(Utills.customImageIcon(chatRoom.getName(), chatRoom.getColor())).into(mBinding.ivContact);
        mRequestManager.load(getNameDrawable(chatRoom.name, (chatRoom.avatarColor)!!))
            .into(mBinding.ivContact)
        mBinding.tvContactName.text = chatRoom.name
        if (chatRoom.alias != null && chatRoom.alias!!.trim { it <= ' ' }
                .isNotEmpty() && chatRoom.alias!!.trim() != chatRoom.name!!.trim()) {
            mBinding.tvContactNickName.visibility = View.VISIBLE
            mBinding.tvContactNickName.text = String.format("~%s", chatRoom.alias)
        } else {
            mBinding.tvContactNickName.visibility = View.GONE
        }
        mBinding.root.setOnClickListener {
            callback?.onContactClick(
                chatRoom,
                holder,
                position
            )
        }
        mBinding.ivQr.setOnCheckedChangeListener { _, b ->
            callback!!.onCheckBoxClick(
                chatRoom,
                holder,
                position,
                true,
                b
            )
        }
    }
}