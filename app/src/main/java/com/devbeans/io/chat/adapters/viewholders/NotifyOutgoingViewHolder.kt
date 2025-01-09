package com.devbeans.io.chat.adapters.viewholders

import android.content.ContentValues
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.devbeans.io.chat.R
import com.devbeans.io.chat.utils.Utills.getDisappearingOptions
import com.stfalcon.chatkit.messages.MessageHolders
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.logging.Log
import java.lang.Exception
import java.util.*

class NotifyOutgoingViewHolder(itemView: View, payload: Any?) :
    MessageHolders.OutcomingTextMessageViewHolder<Messages>(itemView, payload) {
    private val textMessage: TextView? = null
    private var sender: String? = null
    private var action: String? = null
    private var actionOn: String? = null
    private var disappearTime: String? = null
    private var senderId: String? = null
    var tvNotificationName: TextView? = null
    var tvNotificationAction: TextView? = null
    var tvNotificationActionOn: TextView? = null
    var tvAdmin: TextView? = null
    var ivNotificationImage: ImageView? = null
    var layoutActionOn: LinearLayout? = null
    var isContact = false
    private var disappearTimeInInt: Long = -1

    init {
        initNotifyViewHolder(itemView)
    }

    override fun onBind(message: Messages) {
        super.onBind(message)
        try {
            MainApp.database!!.conversationsDao()!!.getConversation(message.payload.conversationId)
                ?.let { conversation ->
                    val my_sender_id: String?
                    my_sender_id = getMySenderId(conversation)
                    handleOwnerSender(conversation,message,my_sender_id)
                    when {
                        (message.payload.type.equals(
                            Constants.TYPES.EXPIRE_MSG, ignoreCase = true
                        )) -> {
                            tvNotificationAction!!.maxLines = 2
                            try {
                                val splits = message.payload.data!!.split("&&").toTypedArray()
                                senderId = message.payload.userChatId
                                disappearTimeInInt = splits[0].toLong()
                                disappearTime = getDisappearingOptions(disappearTimeInInt)
                                sender = getActionSender(my_sender_id, message)
                            } catch (e: Exception) {
                                Log.e(ContentValues.TAG, "onMessage: ", e)
                            }
                            ivNotificationImage!!.setImageDrawable(
                                AndroidUtil.getDrawable(
                                    when {
                                        (conversation.conversationType.equals(
                                            Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                                            ignoreCase = true
                                        )) -> R.drawable.ic_info
                                        conversation.owner.equals(
                                            senderId,
                                            ignoreCase = true
                                        ) -> R.drawable.ic_owner
                                        else -> R.drawable.ic_info
                                    }
                                )
                            )

//                    sender = message.getPayload().getUserChatId().equalsIgnoreCase(AppSession.getUser().getChatUserId()) ? "You" : checkContact(message.getPayload().getUserChatId());
                            tvAdmin!!.visibility = View.GONE
                            layoutActionOn!!.visibility = View.GONE
                            action =
                                when {
                                    (disappearTimeInInt == 0L) -> "turned on disappearing messages to burn on read and all new messages will disappear right after receiver reads"
                                    (disappearTimeInInt < 0) -> "turned off disappearing messages"
                                    else -> String.format(
                                        Locale.ROOT,
                                        "turned on disappearing messages to %s",
                                        disappearTime
                                    )
                                }
                            tvNotificationAction!!.maxLines = if (disappearTimeInInt == 0L) 2 else 1

                        }
                        (!message.payload.data.equals("You left", ignoreCase = true)) -> {
                            handleGroupActions(message, my_sender_id)
                        }
                        else -> {
                            tvAdmin!!.visibility = View.GONE
                            layoutActionOn!!.visibility = View.GONE
                            action = "left"
                        }
                    }
                    tvNotificationName!!.text = sender
                    tvNotificationActionOn!!.text = actionOn
                    tvNotificationAction!!.text = action
                } ?: run {
                Log.e(ContentValues.TAG, "onBind: Conversation no FOUND")
            }

        } catch (e: Exception) {
            Log.e("TAG", "onBind: ", e)
        }

    }

    private fun handleOwnerSender(
        conversation: Conversation,
        message: Messages,
        my_sender_id: String?
    ) {
        when {
            checkConversation(conversation, message) -> {
                sender = if (message.payload.userChatId.equals(
                        my_sender_id, ignoreCase = true
                    )
                ) "You" else "Owner"
                ivNotificationImage!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_owner))
            }
            else -> {
                ivNotificationImage!!.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_info))
                //                    sender = message.getPayload().getUserChatId().equalsIgnoreCase(my_sender_id) ? "You" : checkContact(message.getPayload().getUserChatId());
//                    sender = message.getPayload().getUserChatId().equalsIgnoreCase(my_sender_id) ? "You" : checkContact(message.getPayload().getUserChatId());
                sender = getSender(message, my_sender_id)
            }
        }
    }

    private fun getActionSender(mySenderId: String?, message: Messages): String? {
        return if (senderId.equals(mySenderId, ignoreCase = true)) {
            "You"
        } else {
            val contact = checkContactNull(senderId)
            if (contact != null) contact.name else if (message.payload.chatNickUserChatId != null && !message.payload.chatNickUserChatId!!.trim { it <= ' ' }
                    .isEmpty()) "~" + message.payload.chatNickUserChatId else senderId
        }
    }

    private fun handleGroupActions(
        message: Messages, my_sender_id: String?
    ) {
        if (message.payload.data!!.contains("&&")) {
            tvNotificationAction!!.maxLines = 1
            val splits = message.payload.data!!.split("&&").toTypedArray()
            //                        actionOn = splits[1].equalsIgnoreCase(my_sender_id) ? "You" : checkContact(splits[1]);
            actionOn = getActionOn(splits[1], message, my_sender_id)
            when {
                (message.payload.type.equals(
                    "member_added", ignoreCase = true
                )) -> {
                    action = "added"
                    tvAdmin!!.visibility = View.GONE
                    //                        notification = sender + " Added \n " + name;
                }
                (message.payload.type.equals(
                    "admin_assigned", ignoreCase = true
                )) -> {
                    action = "made"
                    tvAdmin!!.visibility = View.VISIBLE

                }
                (message.payload.type.equals(
                    "admin_removed", ignoreCase = true
                )) -> {
                    action = "removed"
                    tvAdmin!!.visibility = View.VISIBLE

                }
                (message.payload.type.equals(
                    "member_removed", ignoreCase = true
                )) -> {
                    action = "removed"
                    tvAdmin!!.visibility = View.GONE
                    //                        notification = sender + " Removed \n " + name;
                }
                (message.payload.type.equals(
                    "member_leave", ignoreCase = true
                )) -> {
                    action = "left"
                    tvAdmin!!.visibility = View.GONE
                    layoutActionOn!!.visibility = View.GONE
                    //                        notification = name + " left";
                }
                (message.payload.type.equals(
                    "change_owner", ignoreCase = true
                )) -> {
                    tvAdmin!!.visibility = View.GONE
                    layoutActionOn!!.visibility = View.GONE
                    action = if (sender.equals(
                            "You", ignoreCase = true
                        )
                    ) "are the new owner of the group" else "is the new owner of the group"

                }
                (message.payload.type.equals(
                    Constants.TYPES.GROUP_NAME_CHANGE, ignoreCase = true
                )) -> {
                    tvAdmin!!.visibility = View.GONE
                    layoutActionOn!!.visibility = View.VISIBLE
                    action = "changed group title to"
                    actionOn = splits[0]

                }
                (message.payload.type.equals(
                    Constants.TYPES.GROUP_DES_CHANGE, ignoreCase = true
                )) -> {
                    tvAdmin!!.visibility = View.GONE
                    layoutActionOn!!.visibility = View.GONE
                    action = "changed group description"
                    actionOn = splits[0]

                }
                (message.payload.type.equals(
                    Constants.TYPES.GROUP_ICON_CHANGE, ignoreCase = true
                )) -> {
                    tvAdmin!!.visibility = View.GONE
                    layoutActionOn!!.visibility = View.GONE
                    action = "changed group image"
                    actionOn = splits[0]

                }
                (message.payload.type.equals(
                    Constants.TYPES.GROUP_IS_CONFIDENTIAL_CHANGE, ignoreCase = true
                )) -> {
                    tvAdmin!!.visibility = View.GONE
                    layoutActionOn!!.visibility = View.GONE
                    val check = if (splits[0].equals(
                            "true", ignoreCase = true
                        )
                    ) "on " else "off "
                    action =
                        "turned " + check + AndroidUtil.getString(R.string.confidential_message)
                    actionOn = splits[0]
                }
                (message.payload.type.equals(
                    Constants.TYPES.GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE, ignoreCase = true
                )) -> {
                    tvAdmin!!.visibility = View.GONE
                    layoutActionOn!!.visibility = View.GONE
                    val check = if (splits[0].equals(
                            "true", ignoreCase = true
                        )
                    ) "on " else "off "
                    action = "turned " + check + AndroidUtil.getString(R.string.media_sharing)
                    actionOn = splits[0]
                }
            }
        }
    }

    private fun getSender(message: Messages, my_sender_id: String?): String? {
        return if (message.payload.userChatId.equals(
                my_sender_id, ignoreCase = true
            )
        ) "You" else if (checkContactNull(message.payload.userChatId) != null) checkContactNull(
            message.payload.userChatId
        )!!.name else if (message.payload.chatNickUserChatId != null && !message.payload.chatNickUserChatId!!.trim { it <= ' ' }
                .isEmpty()) "~" + message.payload.chatNickUserChatId else message.payload.userChatId
    }

    private fun checkConversation(conversation: Conversation, message: Messages): Boolean {
        return (conversation.owner != null && conversation.owner.equals(
            message.payload.userChatId, ignoreCase = true
        ) && !conversation.conversationType.equals(
            Constants.TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true
        ))
    }

    private fun getMySenderId(conversation: Conversation): String? {
        return if (conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
            )
        ) {
            conversation.myMoniker
        } else {
            AppSession.getUser().chatUserId
        }
    }

    private fun getActionOn(splits: String, message: Messages, my_sender_id: String?): String? {
        return if (splits.equals(
                my_sender_id, ignoreCase = true
            )
        ) "You" else if (checkContactNull(
                splits
            ) != null
        ) checkContactNull(splits)!!.name else if (message.payload.chatNickData != null && !message.payload.chatNickData!!.trim { it <= ' ' }
                .isEmpty()) "~" + message.payload.chatNickData else splits

    }

    private fun initNotifyViewHolder(itemView: View) {
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