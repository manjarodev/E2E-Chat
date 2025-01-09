package com.devbeans.io.chat.adapters.viewholders

import android.content.ContentValues
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.devbeans.io.chat.R
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.utils.Utills.getDisappearingOptions
import com.stfalcon.chatkit.messages.MessageHolders
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.logging.Log
import java.lang.Exception
import java.lang.NullPointerException
import java.util.*

class NotifyIncomingViewHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingTextMessageViewHolder<Messages>(itemView, payload) {
    private val textMessage: TextView? = null
    var notification: String? = null
    var name: String? = null
    private var sender: String? = null
    private var action: String? = null
    private var actionOn: String? = null
    private var disappearTime: String? = null
    private var senderId: String? = null
    var disappearTimeInInt: Long = -1
    var tvNotificationName: TextView? = null
    var tvNotificationAction: TextView? = null
    var tvNotificationActionOn: TextView? = null
    var tvAdmin: TextView? = null
    var ivNotificationImage: ImageView? = null
    var layoutActionOn: LinearLayout? = null

    init {
        initView(itemView)
    }

    override fun onBind(message: Messages) {
        super.onBind(message)
        try {
            val conversation =
                appContext!!.conversationsDao.getConversation(message.payload.conversationId)
            if (conversation != null) {
                val my_sender_id: String?
                my_sender_id = if (conversation.conversationType.equals(
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                        ignoreCase = true
                    )
                ) {
                    conversation.myMoniker
                } else {
                    AppSession.getUser().chatUserId
                }
                handleSenderOwner(conversation, message, my_sender_id)
                handlePayloadCon(message, my_sender_id)
                tvNotificationName!!.text = sender
                tvNotificationActionOn!!.text = actionOn
                tvNotificationAction!!.text = action
            } else {
                Log.e(ContentValues.TAG, "onBind: Conversation no FOUND")
            }
        } catch (e: Exception) {
            Log.e("TAG", "onBind: ", e)
        }

//        textMessage.setText(!TextUtils.isEmpty(notification) ? notification : message.getPayload().getData());
    }

    private fun handleSenderOwner(
        conversation: Conversation,
        message: Messages,
        my_sender_id: String?
    ) {
        if (conversation.owner != null && conversation.owner.equals(
                message.payload.userChatId,
                ignoreCase = true
            ) && !conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
            )
        ) {
            sender = if (message.payload.userChatId.equals(
                    my_sender_id,
                    ignoreCase = true
                )
            ) "You" else "Owner"
            ivNotificationImage!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_owner))
        } else {
            ivNotificationImage!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_info))
            sender = if (message.payload.userChatId.equals(
                    my_sender_id,
                    ignoreCase = true
                )
            ) "You" else if (checkContactNull(message.payload.userChatId) != null) checkContactNull(
                message.payload.userChatId
            )!!.name else if (message.payload.chatNickUserChatId != null &&
                !message.payload.chatNickUserChatId!!.trim { it <= ' ' }
                    .isEmpty()
            ) "~" + message.payload.chatNickUserChatId else message.payload.userChatId
        }
    }

    private fun handlePayloadCon(
        message: Messages,
        my_sender_id: String?
    ) {
        if (message.payload.type.equals(Constants.TYPES.EXPIRE_MSG, ignoreCase = true)) {
            tvNotificationAction!!.maxLines = 2
            try {
                val splits = message.payload.data!!.split("&&").toTypedArray()
                senderId = message.payload.userChatId
                disappearTimeInInt = splits[0].toLong()
                disappearTime = getDisappearingOptions(disappearTimeInInt)
                if (senderId.equals(my_sender_id, ignoreCase = true)) {
                    sender = "You"
                } else {
                    handleContact(message)
                }
            } catch (e: Exception) {
                Log.e(ContentValues.TAG, "onMessage: ", e)
            }
            ivNotificationImage!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_disappear_notify))
            tvAdmin!!.visibility = View.GONE
            layoutActionOn!!.visibility = View.GONE
            action =
                if (disappearTimeInInt == 0L) "turned on disappearing messages to burn on read and all new messages will disappear right after receiver reads" else if (disappearTimeInInt < 0) "turned off disappearing messages" else String.format(
                    Locale.ROOT, "turned on disappearing messages to %s", disappearTime
                )
            tvNotificationAction!!.maxLines = if (disappearTimeInInt == 0L) 2 else 1
        } else {
            handleOthers(message, my_sender_id)
        }
    }

    private fun handleContact(message: Messages) {
        try {
            sender = getSender(message)
        } catch (e: NullPointerException) {
            e.printStackTrace()
            Log.e(ContentValues.TAG, "onMessage: Null pointer", e)
        }
    }

    private fun getSender(message: Messages): String? {
        return if (checkContactNull(senderId) != null) Objects.requireNonNull(
            checkContactNull(
                senderId
            )
        )?.name else if (message.payload.chatNickUserChatId != null &&
            !message.payload.chatNickUserChatId!!.trim { it <= ' ' }.isEmpty()
        ) "~" + message.payload.chatNickUserChatId else senderId
    }

    private fun handleOthers(message: Messages, my_sender_id: String?) {
        if (message.payload.type.equals(Constants.TYPES.EXPIRE_MSG_SELF, ignoreCase = true)) {
            try {
                val splits = message.payload.data!!.split("&&").toTypedArray()
                senderId = ""
                disappearTimeInInt = splits[0].toInt().toLong()
                disappearTime = getDisappearingOptions(disappearTimeInInt)
                sender = ""
            } catch (e: Exception) {
                Log.e(ContentValues.TAG, "onMessage: ", e)
            }
            ivNotificationImage!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_disappear_notify))

//                    sender = message.getPayload().getUserChatId().equalsIgnoreCase(AppSession.getUser().getChatUserId()) ? "You" : checkContact(message.getPayload().getUserChatId());
            tvAdmin!!.visibility = View.GONE
            layoutActionOn!!.visibility = View.GONE
            action = String.format(
                Locale.ROOT,
                "Disappearing is turned on for this conversation for %s",
                disappearTime
            )
            tvNotificationAction!!.maxLines = if (disappearTimeInInt == 0L) 2 else 1
            //
        } else if (!message.payload.data.equals("You left", ignoreCase = true)) {
            handleNotifications(message, my_sender_id)
        } else {
            tvAdmin!!.visibility = View.GONE
            layoutActionOn!!.visibility = View.GONE
            action = "left"
        }
    }

    private fun handleNotifications(
        message: Messages,
        my_sender_id: String?
    ) {
        if (message.payload.data!!.contains("&&")) {
            val splits = message.payload.data!!.split("&&").toTypedArray()
            //                        actionOn = splits[1].equalsIgnoreCase(my_sender_id) ? "You" : checkContact(splits[1]);
            actionOn = getActionOn(message, splits[1], my_sender_id)




            if (message.payload.type.equals("member_added", ignoreCase = true)) {
                action = "added"
                tvAdmin!!.visibility = View.GONE
                //                        notification = sender + " Added \n " + name;
            } else if (message.payload.type.equals("admin_assigned", ignoreCase = true)) {
                action = "made"
                tvAdmin!!.visibility = View.VISIBLE


            } else if (message.payload.type.equals("admin_removed", ignoreCase = true)) {
                action = "removed"
                tvAdmin!!.visibility = View.VISIBLE


            } else if (message.payload.type.equals("member_removed", ignoreCase = true)) {
                action = "removed"
                tvAdmin!!.visibility = View.GONE
                //                        notification = sender + " Removed \n " + name;
            } else if (message.payload.type.equals("member_leave", ignoreCase = true)) {
                action = "left"
                tvAdmin!!.visibility = View.GONE
                layoutActionOn!!.visibility = View.GONE
                //                        notification = name + " left";
            } else if (message.payload.type.equals("change_owner", ignoreCase = true)) {
                tvAdmin!!.visibility = View.GONE
                layoutActionOn!!.visibility = View.GONE
                action = if (sender.equals(
                        "You",
                        ignoreCase = true
                    )
                ) "are the new owner of the group" else "Group owner changed"
                sender = ""


            } else {
                handleTitles(message, splits[0])
            }
        }
    }

    private fun handleTitles(message: Messages, split: String) {
        if (message.payload.type.equals(Constants.TYPES.GROUP_NAME_CHANGE, ignoreCase = true)) {
            tvAdmin!!.visibility = View.GONE
            layoutActionOn!!.visibility = View.VISIBLE
            action = "changed group title to"
            actionOn = split

        } else if (message.payload.type.equals(
                Constants.TYPES.GROUP_DES_CHANGE,
                ignoreCase = true
            )
        ) {
            tvAdmin!!.visibility = View.GONE
            layoutActionOn!!.visibility = View.GONE
            action = "changed group description"
            actionOn = split


        } else if (message.payload.type.equals(
                Constants.TYPES.GROUP_ICON_CHANGE,
                ignoreCase = true
            )
        ) {
            tvAdmin!!.visibility = View.GONE
            layoutActionOn!!.visibility = View.GONE
            action = "changed group image"
            actionOn = split


        } else if (message.payload.type.equals(
                Constants.TYPES.GROUP_IS_CONFIDENTIAL_CHANGE,
                ignoreCase = true
            )
        ) {
            tvAdmin!!.visibility = View.GONE
            layoutActionOn!!.visibility = View.GONE
            val check = if (split.equals("true", ignoreCase = true)) "on " else "off "
            action = "turned " + check + AndroidUtil.getString(R.string.confidential_message)
            actionOn = split
        } else if (message.payload.type.equals(
                Constants.TYPES.GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE,
                ignoreCase = true
            )
        ) {
            tvAdmin!!.visibility = View.GONE
            layoutActionOn!!.visibility = View.GONE
            val check = if (split.equals("true", ignoreCase = true)) "on " else "off "
            action = "turned " + check + AndroidUtil.getString(R.string.media_sharing)
            actionOn = split
        }
    }

    private fun getActionOn(message: Messages, split: String, my_sender_id: String?): String {
        return if (split.equals(my_sender_id, ignoreCase = true)) "You" else (if (checkContactNull(
                split
            ) != null
        ) checkContactNull(split)!!.name else if (message.payload.chatNickData != null &&
            !message.payload.chatNickData!!.trim { it <= ' ' }.isEmpty()
        ) "~" + message.payload.chatNickData else split)!!
    }

    private fun initView(itemView: View) {
//        textMessage = itemView.findViewById(R.id.text_notification);
        tvNotificationName = itemView.findViewById(R.id.text_notification_name)
        tvNotificationAction = itemView.findViewById(R.id.text_notification_action)
        tvNotificationActionOn = itemView.findViewById(R.id.quoted_name)
        tvAdmin = itemView.findViewById(R.id.tv_notification_admin)
        ivNotificationImage = itemView.findViewById(R.id.iv_image_notification)
        layoutActionOn = itemView.findViewById(R.id.layout_action_on)
    }



    //************************************************************
    private fun checkContactNull(memberID: String?): Contact? //************************************************************
    {
        var name: String
        return MainApp.database!!.contactsDao()!!.getContact(memberID)
    }
}