package com.devbeans.io.chat.adapters.viewholders

import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.OnLongMemberCallback
import com.devbeans.io.chat.databinding.ItemMemberBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import com.devbeans.io.chat.utils.avatar.AvatarColor
import java.util.*


//************************************************************
class GroupMemberViewHolder
    (
    var mBinding: ItemMemberBinding,
    var conversation: Conversation,
    var requestManager: RequestManager,
    var isChatDetails: Boolean,
    var onLongMemberCallback: OnLongMemberCallback
) : RecyclerView.ViewHolder(mBinding.root)
//************************************************************
{


    var name: String? = null
    var id: String? = null
    var conversationMember: ConversationMember? = null


    fun setData(s: ConversationMember, position: Int, changeOwner: Boolean) {
        val my_sender_id: String

        setNickName(conversation, s)

        my_sender_id = getSenderFromConv(conversation)
        if (!changeOwner) {
            val isOwner = s.memberId.equals(conversation.owner, ignoreCase = true)
            for (member in conversation.conversationMembers!!) {
                if (my_sender_id.equals(member.memberId, ignoreCase = true)) {
                    conversationMember = member
                    break
                }
            }
            if (isChatDetails) {
                handleClickChatDetails(conversation, my_sender_id, s)
            }
            mBinding.ivCrown.visibility = getVisibilityOwner(s, isOwner)
            mBinding.tvAdmin.visibility = getVisibilityAdmin(s, isOwner)
            mBinding.tvAdmin.text = if (isOwner) "Owner" else "Admin"


//        mBinding.tvChatName.setText(s);
            if (s.memberId.equals(my_sender_id, ignoreCase = true)) {
                mBinding.tvChatName.text = "You"
                requestManager.load(getNameDrawable("You", AvatarColor.GROUP))
                    .into(mBinding.ivChatImage)
                Log.d("TAG", "checkContact: ")
            } else {
                handleNickName(conversation, s)

            }
        } else {
            handleNickNameNotOwner(conversation, s)
        }
    }

    private fun handleNickNameNotOwner(conversation: Conversation, s: ConversationMember) {
        val name1 = checkContact(s.memberId)
        if (!conversation.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS)) {
            if (name1.equals(s.memberId, ignoreCase = true)) {
                if (!s.chatNickName.isNullOrEmpty()) {
                    if (s.chatNickName!!.trim().isNotEmpty()) {
                        mBinding.tvChatName.text = s.chatNickName
                        name = s.chatNickName
                    } else {
                        mBinding.tvChatName.text = name1
                        name = name1
                    }
                } else {
                    mBinding.tvChatName.text = name1
                    name = name1
                }
            } else {
                mBinding.tvChatName.text = name1
                name = name1
            }
        } else {
            mBinding.tvChatName.text = name1
            name = name1
        }
    }

    private fun handleNickName(conversation: Conversation, s: ConversationMember) {
        val name1 = checkContact(s.memberId)
        if (!conversation.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS)) {
            if (name1.equals(s.memberId, ignoreCase = true)) {
                if (!s.chatNickName.isNullOrEmpty()) {
                    if (s.chatNickName!!.trim().isNotEmpty()) {
                        mBinding.tvChatName.text = s.chatNickName
                        name = s.chatNickName
                    } else {
                        mBinding.tvChatName.text = name1
                        name = name1
                    }
                } else {
                    mBinding.tvChatName.text = name1
                    name = name1
                }
            } else {
                mBinding.tvChatName.text = name1
                name = name1
            }
        } else {
            mBinding.tvChatName.text = name1
            name = name1
        }
    }

    private fun getVisibilityAdmin(s: ConversationMember, isOwner: Boolean): Int {
        return if (isOwner || !s.type.equals(
                "member",
                ignoreCase = true
            )
        ) View.VISIBLE else View.GONE
    }

    private fun getVisibilityOwner(
        s: ConversationMember,
        isOwner: Boolean
    ): Int {
        return if (isOwner || s.type.equals(
                "owner",
                ignoreCase = true
            )
        ) View.VISIBLE else View.GONE
    }

    private fun handleClickChatDetails(
        conversation: Conversation,
        my_sender_id: String,
        s: ConversationMember
    ) {
        mBinding.layoutMember.setOnLongClickListener {
            if (!s.memberId.equals(my_sender_id, ignoreCase = true)) {
                if (my_sender_id.equals(conversation.owner, ignoreCase = true)) {
                    onLongMemberCallback.onLongMemberCallback(s, name)
                } else if (conversationMember != null && conversationMember!!.type.equals(
                        "admin",
                        ignoreCase = true
                    )
                ) {
                    onLongMemberCallback.onLongMemberCallback(s, name)
                }
            }


            true
        }
    }

    private fun getSenderFromConv(conversation: Conversation): String {
        return if (conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) {
            conversation.myMoniker!!
        } else {
            AppSession.getUser().chatUserId!!
        }
    }

    private fun setNickName(conversation: Conversation, s: ConversationMember) {
        if (conversation.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS) && !s.memberChatId.isNullOrEmpty() && !s.memberChatId.equals(
                AppSession.getUser().chatUserId
            )
        ) {
            val contact = MainApp.appContext?.contactsDao?.getContact(s.memberChatId)
            if (contact != null) {
                mBinding.tvChatNickName.text =
                    String.format(Locale.getDefault(), "( %s )", contact.name!!.trim())
                mBinding.tvChatNickName.visibility = VISIBLE
            } else if (!s.chatNickName.isNullOrEmpty() && s.chatNickName!!.trim().isNotEmpty()) {

                mBinding.tvChatNickName.text =
                    String.format(Locale.getDefault(), "( %s )", s.chatNickName!!.trim())
                mBinding.tvChatNickName.visibility = VISIBLE
            } else {
                mBinding.tvChatNickName.visibility = GONE
            }
        } else {
            mBinding.tvChatNickName.visibility = GONE
        }
    }


    //************************************************************
    private fun checkContact(memberID: String?): String?
    //************************************************************
    {
        val name: String?
        val contact = MainApp.appContext?.contactsDao?.getContact(memberID)
        if (contact != null) {
            name = contact.name
            this.name = name
        } else {
            name = memberID
            this.name = memberID
        }
        requestManager.load(
            if (contact != null) getNameDrawable(
                contact.name,
                contact.avatarColor!!
            ) else R.drawable.ic_unknown
        ).into(mBinding.ivChatImage)
        return name
    }

}