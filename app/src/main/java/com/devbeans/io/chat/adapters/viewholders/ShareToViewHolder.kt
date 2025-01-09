package com.devbeans.io.chat.adapters.viewholders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import com.devbeans.io.chat.callBacks.ShareRoomsListCallback
import com.bumptech.glide.RequestManager
import com.devbeans.io.chat.models.Contact
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.databinding.ItemSharetoMemberBinding
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import java.io.File
import java.util.*

//************************************************************
class ShareToViewHolder(
    var mBinding: ItemSharetoMemberBinding,
    var callback: ShareRoomsListCallback,
    var context: Context
) : RecyclerView.ViewHolder(
    mBinding.root
) //************************************************************
{
    private val mRequestManager: RequestManager
    var name: String? = "null"
    var mContact: Contact? = null
    var color: String? = "null"
    var isContact = false
    private var id: String? = null
    private val sender = ""
    private val action = ""
    private val actionOn = ""

    //************************************************************
    init  //************************************************************
    {
        mRequestManager = Glide.with(context)
    }

    fun setData(conversation: Conversation) {

        val senderId: String?
        senderId = getConversationSender(conversation)
        if (conversation.conversationType.equals("one-to-one", ignoreCase = true)) {
            var memberId: String? = null
            val member = conversation.conversationMembers?.find { conversationMember ->
                !conversationMember.memberId.equals(
                    senderId,
                    ignoreCase = true
                )
            }
            member?.let {
                memberId = member.memberId
            }
            mContact = MainApp.database!!.contactsDao()!!.getContact(memberId)
            mContact?.let {
                mBinding.tvChatName.text = mContact!!.name
                name = mContact!!.name
                id = mContact!!.chatUserId
                mContact!!.color?.let {

                    mRequestManager.load(
                        getNameDrawable(
                            mContact?.name,
                            mContact!!.avatarColor!!
                        )
                    ).into(
                        mBinding.ivChatImage
                    )
                    color = mContact!!.color
                    isContact = true
                }
            } ?: run {
                mBinding.tvChatName.text = conversation.name
                name = conversation.name
                isContact = false
                mRequestManager.load(R.drawable.ic_unknown).into(mBinding.ivChatImage)
                color = "0D6EFD"
            }

        } else {
            handleGroupIcon(conversation)

        }
        if (conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) {
            mBinding.ivDisappearIcon.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_group_anonymous_indicator_new))
            mBinding.ivDisappearIcon.visibility = View.VISIBLE
        } else {
            mBinding.ivDisappearIcon.visibility = View.GONE
        }

//        if (conversation.getLastMessage() != null) {
//            mBinding.tvLastMessage.setText(conversation.getLastMessage().getData());
//            mBinding.tvTime.setText(DateTime.getFormattedTimeOnly(conversation.getLastMessage().getCreatedAt()));
//            if (conversation.getLastMessage().getType().equalsIgnoreCase("image")) {
//                mBinding.tvLastMessage.setText(conversation.getLastMessage().getType());
//            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("video")) {
//                mBinding.tvLastMessage.setText(conversation.getLastMessage().getType());
//            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("audio")) {
//                mBinding.tvLastMessage.setText(conversation.getLastMessage().getType());
//            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("file")) {
//                mBinding.tvLastMessage.setText(conversation.getLastMessage().getType());
//            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("text")) {
//                mBinding.tvLastMessage.setText(conversation.getLastMessage().getData());
//            }
//            if (conversation.getLastMessage().getData().contains("&&")) {
//                try {
//
//                    if (conversation.getOwner().equalsIgnoreCase(conversation.getLastMessage().getUserChatId())) {
//                        sender = conversation.getLastMessage().getUserChatId().equalsIgnoreCase(senderId) ? "You" : "Owner";
//                    } else {
//                        sender = conversation.getLastMessage().getUserChatId().equalsIgnoreCase(senderId) ? "You" : checkContact(conversation.getLastMessage().getUserChatId());
//                    }
//                    if (!conversation.getLastMessage().getData().equalsIgnoreCase("You left")) {
//                        if (conversation.getLastMessage().getData().contains("&&")) {
//                            String[] splits = conversation.getLastMessage().getData().split("&&");
//                            actionOn = splits[1].equalsIgnoreCase(senderId) ? "You" : checkContact(splits[1]);
//                            if (conversation.getLastMessage().getType().equalsIgnoreCase("member_added")) {
//                                action = "added";
//                            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("admin_assigned")) {
//                                action = "made";
//                            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("admin_removed")) {
//                                action = "removed";
//                            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("member_removed")) {
//                                action = "removed";
//                            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("member_leave")) {
//                                action = "left";
//                                actionOn = "";
//                            } else if (conversation.getLastMessage().getType().equalsIgnoreCase("change_owner")) {
//                                action = sender.equalsIgnoreCase("You") ? "are the new owner of the group" : "is the new owner of the group";
//                                actionOn = "";
//                            }
//
//
//                        }
//                    } else {
////                            tvAdmin.setVisibility(View.GONE);
////                            layoutActionOn.setVisibility(View.GONE);
//                        action = "left";
//                    }
//                    mBinding.tvLastMessage.setText(sender + " " + action + " " + actionOn);
////                    tvNotificationName.setText(sender);
////                    tvNotificationActionOn.setText(actionOn);
////                    tvNotificationAction.setText(action);
//
//
////            if (message.getPayload().getData().contains("&&")) {
////                String[] splits = message.getPayload().getData().split("&&");
////
////                if (splits[1].equalsIgnoreCase(AppSession.getUser().getChatUserId())) {
////                    name = "You";
////                } else {
////                    name = checkContact(splits[1]);
////                }
////                if (message.getPayload().getUserChatId().equalsIgnoreCase(AppSession.getUser().getChatUserId())) {
////                    sender = "You";
////                } else {
////                    sender = checkContact(message.getPayload().getUserChatId());
////                }
////                if (message.getPayload().getType().equalsIgnoreCase("member_added")) {
////                    notification = sender + " Added \n " + name;
////                } else if (message.getPayload().getType().equalsIgnoreCase("admin_assigned")) {
////                    if (name.equalsIgnoreCase("You")) {
////                        notification = name + "  are \nassigned as Admin ";
////                    } else
////                        notification = name + "  is \nassigned as Admin ";
////                } else if (message.getPayload().getType().equalsIgnoreCase("admin_removed")) {
////                    if (name.equalsIgnoreCase("You")) {
////                        notification = name + "  are \nremoved as Admin ";
////                    } else
////                        notification = name + "  is \nremoved as Admin ";
////                } else if (message.getPayload().getType().equalsIgnoreCase("member_removed")) {
////                    notification = sender + " Removed \n " + name;
////                } else if (message.getPayload().getType().equalsIgnoreCase("member_leave")) {
////                    notification = name + " left";
////                } else if (message.getPayload().getType().equalsIgnoreCase("change_owner")) {
////
////                    if (name.equalsIgnoreCase("You")) {
////                        notification = name + " are \nassigned as Owner";
////                    } else {
////                        notification = "Owner Changed\n to " + name;
////                    }
////                }
////            }
//
//                } catch (Exception e) {
//                    Log.e("TAG", "onBind: ", e);
//                }
//            }
//        } else {
//            mBinding.tvLastMessage.setText("Tap to Message");
//        }
//        MainApp.database.messagesDao().getNotReadMessages(conversation.getConversationId(), Constants.DELIVERED, conversation.getMyMoniker()).observe(MainActivity.getInstance(), messages -> {
//            assert messages != null;
//            if (messages.size() > 0) {
//                mBinding.tvLastMessage.setTypeface(null, Typeface.BOLD);
//                mBinding.tvLastMessage.setTextColor(AndroidUtil.getColor(R.color.blue));
//                mBinding.messageCount.setVisibility(View.VISIBLE);
//                mBinding.messageCount.setText(String.valueOf(messages.size()));
//            } else {
//                mBinding.messageCount.setVisibility(View.GONE);
//                mBinding.tvLastMessage.setTextColor(AndroidUtil.getColor(R.color.faded_black));
//                mBinding.tvLastMessage.setTypeface(null, Typeface.NORMAL);
//            }
//        });



        //item click listener with attached callback for sending message
        mBinding.rowFG.setOnClickListener {
            callback.onShareRoomClick(
                conversation,
                name,
                if (isContact) id else "null",
                if (isContact) mContact!!.id else 0,
                color,
                isContact
            )
        }
        //        mBinding.deleteTask.setOnClickListener(view -> {
//            MainApp.database.conversationsDao().delete(conversation);
//            MainApp.database.messagesDao().deleteConversationMessages(conversation.getConversationId());
//        });
    }

    private fun handleGroupIcon(conversation: Conversation) {
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

    private fun getConversationSender(conversation: Conversation): String? {
        return if (conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) {
            conversation.myMoniker
        } else {
            AppSession.getUser().chatUserId
        }
    }


    companion object {
        var counter = 0
    }
}