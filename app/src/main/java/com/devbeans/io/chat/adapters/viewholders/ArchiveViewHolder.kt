package com.devbeans.io.chat.adapters.viewholders

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.view.View.GONE
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback
import com.devbeans.io.chat.callBacks.RoomsListCallback
import com.devbeans.io.chat.databinding.ItemArchiveBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.DateTime.getConversationTimeStampFromMillis
import com.devbeans.io.chat.utils.DateTime.getTimeStampFromMillis
import com.devbeans.io.chat.utils.SettingsValues
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.util.*

//************************************************************
class ArchiveViewHolder
    (
    val mBinding: ItemArchiveBinding,
    private val mRequestManager: RequestManager,
    private val callback: ArchiveRoomsListCallback
) : RecyclerView.ViewHolder(mBinding.root)
//************************************************************
{
    private var name: String? = "null"
    private var mContact: Contact? = null
    private var color: String? = "null"
    var isContact = false
    private var id: String? = null
    private var sender = ""
    private var action = ""
    private var actionOn = ""

    //************************************************************
    fun setData(
        mContext: Context?, conversation: Conversation,
        position: Int, holder: ArchiveViewHolder?
    ) //************************************************************
    {
        val senderId: String
        senderId = getConversationSender(conversation)

        mBinding.ivPin.visibility = when (conversation.isPinned) {
            true -> {
                View.VISIBLE
            }
            else -> {
                View.GONE
            }
        }

        handleKeepChatAndDisappear(conversation)
        if (conversation.conversationType.equals("one-to-one", ignoreCase = true)) {
            handleOneToOne(conversation, senderId)
        } else {
            handleGroups(conversation)

        }

        handleConversationIcon(conversation)

        checkAndHandleHide(conversation, senderId)

        handleUnread(conversation)

        showLastMessageContent(conversation)

        mBinding.rowFG.setOnClickListener {
            handleRowClick(conversation)
        }

        //for deleting the conversation
        mBinding.deleteTask.setOnClickListener { view: View? ->
            handleDeleteClick(conversation)
        }

        //for unArchiving the conversation
        mBinding.archiveTask.setOnClickListener { v: View? ->
            MainApp.appContext?.conversationsDao?.updateConversationArchive(
                conversation.conversationId,
                false
            )
        }

        //Handle row  long press
        mBinding.rowFG.setOnLongClickListener {
            handleLongPress(callback, conversation)
            true
        }


    }

    //for initiating callback of long press to activity
    private fun handleLongPress(callback: ArchiveRoomsListCallback, conversation: Conversation) {
        callback.onRoomLongClick(
            conversation,
            name!!,
            if (isContact) id!! else "null",
            if (isContact) mContact!!.id else 0,
            color!!,
            isContact,
            mBinding.root,
            mBinding.tvChatName
        )

    }

    private fun handleDeleteClick(conversation: Conversation) {
        MainApp.appContext?.conversationsDao?.delete(conversation)
        val mediaMessage =
            MainApp.appContext?.messagesDao?.getAllMediaMessages(conversation.conversationId)
        //Getting all the media files of the conversation for them to delete
        if (mediaMessage != null && mediaMessage.size > 0) {
            //If there are any media files delete them one by one
            for (payload in mediaMessage) {
                if (payload.filePath != null) {
                    val file = File(payload.filePath)
                    //if the file exist delete it from the file path
                    if (file.exists()) {
                        file.delete()
                        MainApp.appContext?.messagesDao?.deleteByMessageId(payload.messageId)
                    }
                }
            }
        }
        MainApp.appContext?.messagesDao?.deleteConversationMessages(conversation.conversationId)
    }

    private fun handleRowClick(conversation: Conversation) {
        callback.onRoomClick(
            conversation,
            name,
            if (isContact) id else "null",
            if (isContact) mContact!!.id else 0,
            color,
            isContact
        )
    }

    private fun showLastMessageContent(conversation: Conversation) {
        if (conversation.messages != null && conversation.messages!!.isNotEmpty()) {
            if (conversation.messages!![conversation.messages!!.size - 1].type.equals(
                    "text",
                    ignoreCase = true
                )
            ) {
                mBinding.tvLastMessage.text =
                    conversation.messages!![conversation.messages!!.size - 1].data
            } else {
                mBinding.tvLastMessage.text =
                    conversation.messages!![conversation.messages!!.size - 1].type
            }
        }
    }

    private fun checkAndHandleHide(conversation: Conversation, senderId: String) {
        if (!SettingsValues.getHideAll()) {
            handleHideLastMessage(conversation, senderId)

        } else {
            mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
        }
    }

    private fun handleConversationIcon(conversation: Conversation) {
        if (conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) {
            mBinding.ivDisappearIcon.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_group_anonymous_indicator_new))
            mBinding.ivDisappearIcon.visibility = View.VISIBLE
        } else {
            mBinding.ivDisappearIcon.visibility = GONE
            mBinding.ivDisappearIcon.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_disappear_clock))
        }
    }

    private fun getConversationSender(conversation: Conversation): String {
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

    private fun handleKeepChatAndDisappear(conversation: Conversation) {
        conversation.keepChatDate?.let {
            //Checking the Date of the conversation to which it was created in local DB for it to Track Keep Chat Time in not null
        } ?: run {
            //Setting the Date of the conversation to which it was created in local DB for it to Track Keep Chat Time
            MainApp.appContext?.conversationsDao?.updateKeepChatTime(
                conversation.conversationId,
                getTimeStampFromMillis(System.currentTimeMillis())
            )
        }

        if (conversation.sequenceOfConversation > 0) {
            mBinding.tvTime.text =
                getConversationTimeStampFromMillis(conversation.sequenceOfConversation)
        }
    }

    private fun handleUnread(conversation: Conversation) {
        val messages = MainApp.appContext?.messagesDao?.getUnReadMessages(
            conversation.conversationId,
            Constants.DELIVERED,
            conversation.myMoniker
        )
        if (messages != null && messages.size > 0) {
            mBinding.tvLastMessage.setTypeface(null, Typeface.BOLD)
            mBinding.tvLastMessage.setTextColor(AndroidUtil.getColor(R.color.blue))
            mBinding.messageCount.visibility = View.VISIBLE
            mBinding.messageCount.text = messages.size.toString()
        } else {
            mBinding.messageCount.visibility = View.GONE
            mBinding.tvLastMessage.setTextColor(AndroidUtil.getColor(R.color.gray_variant_40))
            mBinding.tvLastMessage.setTypeface(null, Typeface.NORMAL)
        }
    }

    private fun handleHideLastMessage(conversation: Conversation, senderId: String) {
        when {
            conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                ignoreCase = true
            ) && !SettingsValues.getHideDirect() -> showLastMessage(
                conversation,
                senderId
            )
            conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP,
                ignoreCase = true
            ) && !SettingsValues.getHideGroup() -> showLastMessage(
                conversation,
                senderId
            )
            conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            ) && !SettingsValues.getHideAnonymousGroup() -> showLastMessage(
                conversation,
                senderId
            )
            else -> mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
        }
    }

    private fun handleGroups(conversation: Conversation) {
        name = conversation.name
        color = "0D6EFD"
        isContact = false
        if (conversation.photo != null && conversation.conversationPhoto != null) {
            if (conversation.photo.equals(
                    "image_test_092.jpg",
                    ignoreCase = true
                )
            )
                mRequestManager.load(getNameDrawable(name, AvatarColor.GROUP))
                    .into(mBinding.ivChatImage) else {
                val file = File(conversation.conversationPhoto)
                mRequestManager.load(file).into(mBinding.ivChatImage)
            }
        } else {
            mRequestManager.load(getNameDrawable(name, AvatarColor.GROUP))
                .into(mBinding.ivChatImage)
        }
        mBinding.tvChatName.text = conversation.name
    }

    private fun handleOneToOne(conversation: Conversation, senderId: String) {
        var memberId: String? = null
        var member: ConversationMember? = null
        member = conversation.conversationMembers?.find { conversationMember ->
            !conversationMember.memberId.equals(
                senderId,
                ignoreCase = true
            )
        }

        member?.let {
            memberId = member?.memberId
        } ?: run {
            memberId = null
        }
        mContact = MainApp.appContext?.contactsDao?.getContact(memberId)
        mContact?.let {
            mBinding.tvChatName.text = mContact!!.name
            name = mContact!!.name
            id = mContact!!.chatUserId
            if (mContact!!.color != null) {
                mRequestManager.load(
                    getNameDrawable(
                        mContact!!.name,
                        mContact!!.avatarColor!!
                    )
                ).into(
                    mBinding.ivChatImage
                )
                color = mContact!!.color
                isContact = true
            }
        } ?: run {
            if (member!!.chatNickName != null && !member.chatNickName!!.trim { it <= ' ' }
                    .isEmpty()) {
                mBinding.tvChatName.text = member.chatNickName
                name = member.chatNickName
                isContact = false
                mRequestManager.load(R.drawable.ic_unknown).into(mBinding.ivChatImage)
                color = "0D6EFD"
            } else {
                mBinding.tvChatName.text = memberId
                name = memberId
                isContact = false
                mRequestManager.load(R.drawable.ic_unknown).into(mBinding.ivChatImage)
                color = "0D6EFD"
            }
        }

        if (!conversation.name.equals(name, ignoreCase = true)) {
            MainApp.appContext?.conversationsDao?.updateName(conversation.conversationId, name)
        }
    }

    //************************************************************
    private fun checkContact(memberID: String): String? //************************************************************
    {
        val name: String
        val contact = MainApp.appContext?.contactsDao?.getContact(memberID)
        if (contact != null) {
            name = contact.name!!
        } else name = memberID.uppercase(Locale.getDefault())
        return name
    }

    //************************************************************
    private fun checkContactNull(memberID: String): Contact? //************************************************************
    {
        var name: String
        return MainApp.appContext?.contactsDao?.getContact(memberID)
    }

    @SuppressLint("SetTextI18n")
    private fun showLastMessage(conversation: Conversation, senderId: String) {
        conversation.lastMessage?.let {
            mBinding.tvLastMessage.text = conversation.lastMessage!!.data
            try {
                handleSimpleLastMessage(conversation)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (conversation.lastMessage!!.data!!.contains("&&")) {
                try {
                    sender = getSender(conversation, senderId)
                    if (!conversation.lastMessage!!.data.equals("You left", ignoreCase = true)) {
                        handleGroupLastMessage(conversation, senderId)
                    } else {
                        action = "left"
                    }
                    mBinding.tvLastMessage.text = "$sender $action $actionOn"

                } catch (e: Exception) {
                    Log.e("TAG", "onBind: ", e)
                }
            }
        } ?: run {
            mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
        }


    }

    private fun getSender(conversation: Conversation, senderId: String): String {
        return if (conversation.owner.equals(
                conversation.lastMessage!!.userChatId,
                ignoreCase = true
            )
        ) {
            if (conversation.lastMessage!!.userChatId.equals(
                    senderId,
                    ignoreCase = true
                )
            ) "You" else "Owner"
        } else {
            if (conversation.lastMessage!!.userChatId.equals(
                    senderId,
                    ignoreCase = true
                )
            ) "You" else (if (checkContactNull(conversation.lastMessage!!.userChatId!!) != null) checkContactNull(
                conversation.lastMessage!!.userChatId!!
            )!!.name else if (conversation.lastMessage!!.chatNickUserChatId!! != null && !conversation.lastMessage!!.chatNickUserChatId!!
                    .trim { it <= ' ' }
                    .isEmpty()
            ) "~" + conversation.lastMessage!!.chatNickUserChatId!! else conversation.lastMessage!!.userChatId)!!
        }
    }

    private fun handleSimpleLastMessage(conversation: Conversation) {
        if (conversation.lastMessage!!.type.equals("image", ignoreCase = true)) {
            mBinding.tvLastMessage.text = conversation.lastMessage!!.type
        } else if (conversation.lastMessage!!.type.equals("video", ignoreCase = true)) {
            mBinding.tvLastMessage.text = conversation.lastMessage!!.type
        } else if (conversation.lastMessage!!.type.equals("audio", ignoreCase = true)) {
            mBinding.tvLastMessage.text = conversation.lastMessage!!.type
        } else if (conversation.lastMessage!!.type.equals("file", ignoreCase = true)) {
            mBinding.tvLastMessage.text = conversation.lastMessage!!.type
        } else if (conversation.lastMessage!!.type.equals("text", ignoreCase = true)) {
            mBinding.tvLastMessage.text = conversation.lastMessage!!.data
        }
    }

    private fun handleGroupLastMessage(conversation: Conversation, senderId: String) {
        if (conversation.lastMessage!!.data!!.contains("&&")) {
            val splits =
                conversation.lastMessage!!.data!!.split("&&").toTypedArray()
            actionOn = getActionOn(conversation, splits[1], senderId)

            if (conversation.lastMessage!!.type.equals(
                    "member_added",
                    ignoreCase = true
                )
            ) {
                action = "added"
            } else if (conversation.lastMessage!!.type.equals(
                    "admin_assigned",
                    ignoreCase = true
                )
            ) {
                action = "made"
            } else if (conversation.lastMessage!!.type.equals(
                    "admin_removed",
                    ignoreCase = true
                )
            ) {
                action = "removed"
            } else if (conversation.lastMessage!!.type.equals(
                    "member_removed",
                    ignoreCase = true
                )
            ) {
                action = "removed"
            } else if (conversation.lastMessage!!.type.equals(
                    "member_leave",
                    ignoreCase = true
                )
            ) {
                action = "left"
                actionOn = ""
            } else if (conversation.lastMessage!!.type.equals(
                    "change_owner",
                    ignoreCase = true
                )
            ) {
                action = if (sender.equals(
                        "You",
                        ignoreCase = true
                    )
                ) "are the new owner of the group" else "is the new owner of the group"
                actionOn = ""
            }
        }
    }

    private fun getActionOn(conversation: Conversation, splits: String, senderId: String): String {
        return if (splits.equals(
                senderId,
                ignoreCase = true
            )
        ) "You" else (if (checkContactNull(
                splits
            ) != null
        ) checkContactNull(splits)!!.name else if (conversation.lastMessage!!.chatNickData != null && !conversation.lastMessage!!.chatNickData!!
                .trim { it <= ' ' }
                .isEmpty()
        ) "~" + conversation.lastMessage!!.chatNickData else splits)!!
    }

    companion object {
        private val TAG = Log.tag(
            HomeFragmentViewHolder::class.java
        )
    }
}