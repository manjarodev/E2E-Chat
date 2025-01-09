package com.devbeans.io.chat.adapters.viewholders


import android.graphics.Typeface
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.RoomsListCallback
import com.devbeans.io.chat.databinding.ItemChatsBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.AndroidUtil.getResources
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.DateTime.getConversationTimeStampFromMillis
import com.devbeans.io.chat.utils.DateTime.getTimeStampFromMillis
import com.devbeans.io.chat.utils.SettingsValues
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.util.*

//**********************************************
class HomeFragmentViewHolder
    (
    val mBinding: ItemChatsBinding, private val mRequestManager: RequestManager
) : RecyclerView.ViewHolder(mBinding.root)
//**********************************************
{
    private var name: String? = "null"
    private var mContact: Contact? = null
    private var color: String? = "null"
    var isContact = false
    private var id: String? = null
    private var sender = ""
    private var action = ""
    private var actionOn = ""
    var fromAdmin = ""

    fun setData(conversation: Conversation, callback: RoomsListCallback) {
        // Load the chat image using Glide or other image loading library
        // mRequestManager.load(chatRoom.getImg()).into(mBinding.ivChatImage)

        val senderId = getSenderByConv(conversation)

        mBinding.ivPin.visibility = when (conversation.isPinned) {
            true -> {
                View.VISIBLE
            }

            else -> {
                View.GONE
            }
        }

        // Handle keeping the chat and disappear
        handleKeepChatAndDisappear(conversation)

        if (conversation.conversationType.equals("one-to-one", ignoreCase = true)) {
            // Handle one-to-one conversation
            handleOneToOne(conversation, senderId)
        } else {
            // Handle group name
            handleGroupName(conversation)
        }

        // Handle icon disappear
        handleIconDisappear(conversation)

        // Handle hiding messages
        handleHideMessages(conversation, senderId)

        // Handle unread message count
        handleUnreadCount(conversation)

        // Handle last message content
        handleLastMessageContent(conversation)

        // Handle row click event
        mBinding.rowFG.setOnClickListener {
            handleRowClick(callback, conversation)
        }


        //Handle row  long press
        mBinding.rowFG.setOnLongClickListener {
            handleLongPress(callback, conversation)
            true
        }


        // Handle delete conversation event
        mBinding.deleteTask.setOnClickListener {
            handleDeleteClick(conversation)
        }

        // Handle archive conversation event
        mBinding.archiveTask.setOnClickListener {
            // Update conversation archive status using the conversationsDao object
            val conversationsDao = MainApp.appContext?.conversationsDao
            conversationsDao?.updateConversationArchive(conversation.conversationId, true)
        }
    }

    private fun handleLongPress(callback: RoomsListCallback, conversation: Conversation) {
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

    // This function handles the delete click event for a conversation
// and deletes the conversation and its media files from the device storage
    private fun handleDeleteClick(conversation: Conversation) {
        // Retrieve the application context using the MainApp.appContext property
        val appContext = MainApp.appContext

        // Perform null-check on the appContext variable using the let function
        appContext?.let {
            // Extract the conversationsDao and messagesDao properties from the appContext variable
            val conversationsDao = appContext.conversationsDao
            val messagesDao = appContext.messagesDao

            // Call the delete method on the conversationsDao object to delete the conversation
            conversationsDao?.delete(conversation)

            // Retrieve all the media messages for the conversation using the getAllMediaMessages method
            // of the messagesDao object and loop through them using the forEach function
            messagesDao?.getAllMediaMessages(conversation.conversationId)?.forEach { mediaMessage ->
                // Perform null-check on the filePath property of the mediaMessage object using the let function
                mediaMessage.filePath?.let { filePath ->
                    // Create a File object using the filePath and check if it exists using the exists method
                    val file = File(filePath)
                    if (file.exists()) {
                        // If the file exists, delete it using the delete method of the File class
                        // and delete the message from the database using the deleteByMessageId method of the messagesDao object
                        file.delete()
                        messagesDao.deleteByMessageId(mediaMessage.messageId)
                    }
                }
            }

            // Call the deleteConversationMessages method of the messagesDao object to delete all the messages
            // associated with the conversation
            messagesDao?.deleteConversationMessages(conversation.conversationId)
        }
    }

    private fun handleRowClick(
        callback: RoomsListCallback,
        conversation: Conversation
    ) {
        callback.onRoomClick(
            conversation,
            name!!,
            if (isContact) id!! else "null",
            if (isContact) mContact!!.id else 0,
            color!!,
            isContact
        )
    }

    private fun handleLastMessageContent(conversation: Conversation) {
        if (conversation.messages != null && conversation.messages!!.isNotEmpty()) {
            if (conversation.messages!![conversation.messages!!.size - 1].type.equals(
                    "text", ignoreCase = true
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

    private fun handleUnreadCount(conversation: Conversation) {
        val messages = MainApp.appContext?.messagesDao?.getUnReadMessages(
            conversation.conversationId, Constants.DELIVERED, conversation.myMoniker
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

    private fun handleHideMessages(conversation: Conversation, senderId: String) {
        val hideAll = SettingsValues.getHideAll()
        when (conversation.conversationType) {
            Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                if (!hideAll && !SettingsValues.getHideDirect()) {
                    showLastMessage(conversation, senderId)
                } else {
                    mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
                }
            }

            Constants.TYPES.CONVERSATION_GROUP -> {
                if (!hideAll && !SettingsValues.getHideGroup()) {
                    showLastMessage(conversation, senderId)
                } else {
                    mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
                }
            }

            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                if (!hideAll && !SettingsValues.getHideAnonymousGroup()) {
                    showLastMessage(conversation, senderId)
                } else {
                    mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
                }
            }

            else -> {
                mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
            }
        }
    }


    private fun handleIconDisappear(conversation: Conversation) {
        if (conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
            )
        ) {
            mBinding.ivDisappearIcon.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_group_anonymous_indicator_new))
            mBinding.ivDisappearIcon.visibility = View.VISIBLE
        } else {
            mBinding.ivDisappearIcon.visibility = View.GONE
            mBinding.ivDisappearIcon.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_disappear_clock))
        }
    }

    private fun handleGroupName(conversation: Conversation) {
        name = conversation.name
        color = "F7C908"
        isContact = false
        if (conversation.photo != null && conversation.conversationPhoto != null) {
            if (conversation.photo.equals(
                    "image_test_092.jpg", ignoreCase = true
                )
            ) mRequestManager.load(getNameDrawable(name, AvatarColor.GROUP))
                .into(mBinding.ivChatImage) else {
                conversation.conversationPhoto?.let {
                    if (it.isNotEmpty()) {
                        val file = File(it)
                        if (file.exists()) mRequestManager.load(file).into(mBinding.ivChatImage)
                    }
                }

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
        for (conversationMember in conversation.conversationMembers!!) {
            if (!conversationMember.memberId.equals(senderId, ignoreCase = true)) {
                memberId = conversationMember.memberId
                member = conversationMember
                break
            }
        }
        mContact = MainApp.appContext?.contactsDao?.getContact(memberId)
        if (mContact != null) {
            mBinding.tvChatName.text = mContact!!.name
            name = mContact!!.name
            id = mContact!!.chatUserId
            if (mContact!!.color != null) {
//                    mRequestManager.load(Utills.customImageIcon(Objects.requireNonNull(mContact).getName(), mContact.getColor())).into(mBinding.ivChatImage);
                mRequestManager.load(
                    getNameDrawable(
                        mContact!!.name, mContact!!.avatarColor!!
                    )
                ).into(
                    mBinding.ivChatImage
                )
                color = mContact!!.color
                //                    mBinding.ivChatImage.setBackground(Utills.getNameDrawable(Objects.requireNonNull(mContact).getName()));
                isContact = true
            }
        } else if (member!!.chatNickName != null && !member.chatNickName!!.trim { it <= ' ' }
                .isEmpty()) {
            mBinding.tvChatName.text = member.chatNickName
            name = member.chatNickName
            isContact = false
            mRequestManager.load(R.drawable.ic_unknown).into(mBinding.ivChatImage)
            color = "343437"
        } else {
            mBinding.tvChatName.text = memberId
            name = memberId
            isContact = false
            mRequestManager.load(R.drawable.ic_unknown).into(mBinding.ivChatImage)
            color = "343437"
        }
        if (!conversation.name.equals(name, ignoreCase = true)) {
            MainApp.appContext?.conversationsDao?.updateName(conversation.conversationId, name)
            conversation.name = name
        }

    }

    private fun handleKeepChatAndDisappear(conversation: Conversation) {
        val conversationsDao = MainApp.appContext?.conversationsDao
        if (conversation.keepChatDate == null) {
            // Setting the Date of the conversation to which it was created in local DB for it to Track Keep Chat Time
            conversationsDao?.updateKeepChatTime(
                conversation.conversationId, getTimeStampFromMillis(System.currentTimeMillis())
            )
            conversation.keepChatDate = getTimeStampFromMillis(System.currentTimeMillis())
        }
        if (conversation.sequenceOfConversation > 0) {
            mBinding.tvTime.text =
                getConversationTimeStampFromMillis(conversation.sequenceOfConversation)
        }
    }

    private fun getSenderByConv(conversation: Conversation): String {
        return if (conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
            )
        ) {
            conversation.myMoniker!!
        } else {
            AppSession.getUser().chatUserId!!
        }
    }

    private fun showLastMessage(conversation: Conversation, senderId: String) {
        try {
            if (conversation.lastMessage != null && !conversation.lastMessage!!.isConfidential && !conversation.lastMessage!!.isViewOnce) {
                handleSimpleLastMessage(conversation, senderId)
            } else if (conversation.lastMessage != null && conversation.lastMessage!!.isConfidential) {
                handleConfidentialLastMessage(conversation)
            } else if (conversation.lastMessage != null && conversation.lastMessage!!.isViewOnce) {
                handleViewOnceLastMessage(conversation)
            } else {
                mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Message ${e.message}")
            mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
        }


    }

    private fun handleSimpleLastMessage(conversation: Conversation, senderId: String) {
        var drawable: Int = 0

        mBinding.tvLastMessage.text = conversation.lastMessage!!.data
        try {
            if (conversation.lastMessage!!.type.equals("image", ignoreCase = true)) {
                drawable = R.drawable.ic_image_home_fragment_sec
                mBinding.tvLastMessage.text = conversation.lastMessage!!.type
            } else if (conversation.lastMessage!!.type.equals("video", ignoreCase = true)) {
                drawable = R.drawable.ic_video_home_fragment
                mBinding.tvLastMessage.text = conversation.lastMessage!!.type
            } else if (conversation.lastMessage!!.type.equals("audio", ignoreCase = true)) {
                drawable = R.drawable.ic_audio_chat_home_fragment_sec
                mBinding.tvLastMessage.text = conversation.lastMessage!!.type
            } else if (conversation.lastMessage!!.type.equals("file", ignoreCase = true)) {
                drawable = R.drawable.ic_file_home_fragment
                mBinding.tvLastMessage.text = conversation.lastMessage!!.type
            } else if (conversation.lastMessage!!.type.equals("text", ignoreCase = true)) {
                drawable = 0
                mBinding.tvLastMessage.text = conversation.lastMessage!!.data
            }
            mBinding.tvLastMessage.setCompoundDrawablesWithIntrinsicBounds(
                drawable, 0, 0, 0
            )
            mBinding.tvLastMessage.compoundDrawablePadding =
                getResources().getDimensionPixelSize(R.dimen.view_once_padding);
        } catch (e: Exception) {
            e.printStackTrace()
        }
        conversation.lastMessage?.data?.let {
            if (conversation.lastMessage!!.data!!.contains(
                    "&&"
                )
            ) {
                handleMessage(conversation, senderId)
            }
        }
    }

    private fun handleMessage(conversation: Conversation, senderId: String) {
        try {
            sender = getSender(conversation, senderId)
            if (!conversation.lastMessage!!.data.equals(
                    "You left", ignoreCase = true
                )
            ) {
                if (conversation.lastMessage!!.data!!.contains("&&")) {
                    val splits =
                        conversation.lastMessage!!.data!!.split("&&").toTypedArray()
                    actionOn = getActionOn(conversation, senderId, splits[1])
                    handleGroupActions(conversation)
                }
            } else {
                action = "left"
            }
            mBinding.tvLastMessage.text =
                String.format("%s", "$sender $action $actionOn $fromAdmin")
        } catch (e: Exception) {
            Log.e("TAG", "onBind: ", e)
        }
    }

    private fun handleViewOnceLastMessage(conversation: Conversation) {
        val payload =
            MainApp.appContext!!.messagesDao.getMessage(conversation.lastMessage?.messageId)
        if (payload != null) {
            mBinding.tvLastMessage.text =
                AndroidUtil.getString(if (payload.isOpened) R.string.opened else R.string.view_once)
            mBinding.tvLastMessage.setCompoundDrawablesWithIntrinsicBounds(
                if (payload.isOpened) R.drawable.ic_view_once_opened_receive else R.drawable.ic_view_once_receive,
                0,
                0,
                0
            )
            mBinding.tvLastMessage.compoundDrawablePadding =
                getResources().getDimensionPixelSize(R.dimen.view_once_padding);
        } else {
            mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
        }
    }

    private fun handleConfidentialLastMessage(conversation: Conversation) {
        val payload =
            MainApp.appContext!!.messagesDao.getMessage(conversation.lastMessage?.messageId)
        if (payload != null) {
            mBinding.tvLastMessage.text =
                AndroidUtil.getString(if (payload.isViewOnce && payload.isOpened) R.string.opened else R.string.tap_to_reveal)
            mBinding.tvLastMessage.setCompoundDrawablesWithIntrinsicBounds(
                if (payload.isViewOnce && payload.isOpened) R.drawable.ic_view_once_opened_receive else if (payload.isViewOnce) R.drawable.ic_view_once_receive else R.drawable.ic_confidentiality_receive,
                0,
                0,
                0
            )
            mBinding.tvLastMessage.compoundDrawablePadding =
                getResources().getDimensionPixelSize(R.dimen.view_once_padding);
        } else {
            try {
                mBinding.tvLastMessage.setCompoundDrawablesWithIntrinsicBounds(
                    0, 0, 0, 0
                )
                mBinding.tvLastMessage.text = AndroidUtil.getString(R.string.tap_to_message)
            } catch (e: Exception) {
                Log.e(TAG, "Exception $e")
            }
        }

    }

    private fun handleGroupActions(conversation: Conversation) {

        when (conversation.lastMessage?.type?.lowercase(Locale.getDefault())) {
            "member_added" -> {
                action = "added"
            }

            "admin_assigned" -> {
                action = "made"
                fromAdmin = "Admin"
            }

            "admin_removed" -> {
                action = "removed"
                fromAdmin = "from Admin"
            }

            "member_removed" -> {
                action = "removed"
            }

            "member_leave" -> {
                action = "left"
                actionOn = ""
            }

            "change_owner" -> {
                action = if (sender.equals(
                        "You", ignoreCase = true
                    )
                ) "are the new owner of the group" else "is the new owner of the group"
                actionOn = ""
            }

            Constants.TYPES.GROUP_NAME_CHANGE -> {
                sender = ""
                action = "Group name changed"
                actionOn = ""
            }

            Constants.TYPES.GROUP_DES_CHANGE -> {
                sender = ""
                action = "Group description changed"
                actionOn = ""
            }

            Constants.TYPES.GROUP_ICON_CHANGE -> {
                sender = ""
                action = "Group image changed"
                actionOn = ""
            }
        }
    }


    private fun getActionOn(conversation: Conversation, senderId: String, splits: String): String {
        return if (splits.equals(senderId, ignoreCase = true)) {
            "You"
        } else {
            checkContactNull(splits)?.name ?: conversation.lastMessage?.chatNickData?.let { "~$it" }
            ?: splits
        }
    }


    private fun getSender(conversation: Conversation, senderId: String): String {
        val lastMessage = conversation.lastMessage ?: return ""

        return when {
            conversation.owner.equals(lastMessage.userChatId, ignoreCase = true) -> {
                if (lastMessage.userChatId.equals(senderId, ignoreCase = true)) "You" else "Owner"
            }

            else -> {
                if (lastMessage.userChatId.equals(senderId, ignoreCase = true)) {
                    "You"
                } else {
                    checkContactNull(lastMessage.userChatId!!)?.name
                        ?: (lastMessage.chatNickUserChatId?.let { "~$it" }
                            ?: lastMessage.userChatId) ?: ""
                }
            }
        }
    }


    //************************************************************
    private fun checkContact(memberID: String): String?
    //************************************************************
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

    companion object {
        private val TAG = Log.tag(
            HomeFragmentViewHolder::class.java
        )
    }
}