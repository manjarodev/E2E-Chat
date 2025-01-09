package com.devbeans.io.chat.adapters.viewholders

import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.DateTime
import com.devbeans.io.chat.utils.SettingsValues
import com.stfalcon.chatkit.messages.MessageHolders
import com.vanniktech.emoji.EmojiTextView

class IncomingTextMessageViewHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingTextMessageViewHolder<Messages>(itemView, payload) {
    var textMessage: EmojiTextView? = null
    var tvTime: TextView? = null
    var name: TextView? = null
    var edited: TextView? = null
    var backgroundLayout: RelativeLayout? = null
    var messages: Messages? = null
    var disappearIcon: ImageView? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
        disappearIcon!!.visibility =
            if (message.payload.isExpire) View.VISIBLE else View.GONE
        forwardLayout!!.visibility = if (message.payload.isForwarded) View.VISIBLE else View.GONE




        textMessage!!.text = message.payload.data
        if (message.payload.isEdited) {
            edited!!.visibility = View.VISIBLE
        } else edited!!.visibility = View.GONE
        if (message.payload.isDeleted) {
            textMessage!!.setTypeface(textMessage!!.typeface, Typeface.ITALIC)
            textMessage!!.setTextColor(appContext!!.resources.getColor(R.color.faded_black_30))
        } else {
            textMessage!!.setTypeface(textMessage!!.typeface, Typeface.NORMAL)
        }
        tvTime!!.text =
            DateTime.getFormattedTimeOnly(message.payload.createdAt)
        var con: Conversation? = null
        var me: ConversationMember? = null

        if (!message.payload.conversationId.isNullOrEmpty())

            appContext?.conversationsDao?.getConversation(message.payload.conversationId)
                ?.let { con ->
                    me = con.conversationMembers?.find { members ->
                        message.payload.senderId.equals(members.memberId)
                    }
                }

        handleNickName(message, me)
    }

    private fun handleNickName(message: Messages, me: ConversationMember?) {
        message.payload.conversationType?.let {
            when {
                (message.payload.conversationType.equals("one-to-one", ignoreCase = true)) -> {
                    name!!.visibility = View.GONE
                }
                (message.payload.conversationType.equals(
                    Constants
                        .TYPES.CONVERSATION_GROUP,
                    ignoreCase = true
                )
                        ) -> {
                    appContext?.contactsDao?.getContact(message.payload.senderId)?.let { contact ->
                        name!!.text = contact.name
                    } ?: run {
                        me?.let {
                            if (!me!!.chatNickName.isNullOrEmpty()) {
                                if (me!!.chatNickName!!.trim().isNotEmpty()) {
                                    name!!.text = "~${me!!.chatNickName}"
                                } else {
                                    name!!.text = message.payload.senderId
                                }
                            } else {
                                name!!.text = message.payload.senderId
                            }
                        } ?: run {
                            name!!.text = message.payload.senderId
                        }
                    }
                }
                else -> {
                    name!!.text = message.payload.senderId
                }
            }
        }
    }

    private fun init(itemView: View) {
        textMessage = itemView.findViewById(R.id.messageText1)

        val checkFontSize = SettingsValues.getMessageFontSize()
        val checkEmojiSize = SettingsValues.getMessageEmojiSize()
        val fontSize = when {
            checkFontSize <= 22 -> {
                com.intuit.ssp.R.dimen._12ssp
            }
            else -> {
                com.intuit.ssp.R.dimen._42ssp
            }
        }
        val emojiSize = when {
            checkEmojiSize <= 22 -> {
                com.intuit.sdp.R.dimen._22sdp
            }
            checkEmojiSize <= 42 -> {
                com.intuit.sdp.R.dimen._42sdp
            }

            else -> {
                com.intuit.sdp.R.dimen._62sdp
            }
        }

        textMessage!!.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            appContext!!.resources.getDimension(fontSize)
        )
        textMessage!!.setEmojiSize(appContext!!.resources.getDimensionPixelSize(emojiSize))


        tvTime = itemView.findViewById(R.id.text_textview_time_received)
        name = itemView.findViewById(R.id.text_tv_group_member_name)
        edited = itemView.findViewById(R.id.editedText)
        backgroundLayout = itemView.findViewById(R.id.mainlayout)
        disappearIcon = itemView.findViewById(R.id.text_disappear_receive)
        bubbleView = itemView.findViewById(R.id.text_incoming_layout_bubble_receive)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_receive_text)

        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            false
        })
    }

    init {
        init(itemView)
    }
}