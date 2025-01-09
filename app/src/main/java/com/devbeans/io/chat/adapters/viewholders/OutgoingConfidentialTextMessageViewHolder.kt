package com.devbeans.io.chat.adapters.viewholders

import android.graphics.Typeface
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.View.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.DateTime
import com.devbeans.io.chat.utils.SettingsValues
import com.stfalcon.chatkit.messages.MessageHolders.OutcomingTextMessageViewHolder

class OutgoingConfidentialTextMessageViewHolder(itemView: View, payload: Any?) :
    OutcomingTextMessageViewHolder<Messages>(itemView, payload) {
    var tvTime: TextView? = null

    var edited: TextView? = null
    val tag =
        com.devbeans.io.chat.utils.logging.Log.tag(OutgoingConfidentialTextMessageViewHolder::class.java)


    var messageText: TextView? = null
    var tick: ImageView? = null

    var disappearIcon: ImageView? = null
    var viewOnceIcon: ImageView? = null
    var backgroundLayout: RelativeLayout? = null
    var messages: Messages? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null
    var textTimeAndTickLayout: LinearLayout? = null

    var tvTimeCon: TextView? = null
    var messageTextCon: TextView? = null
    var editedCon: TextView? = null
    var tickCon: ImageView? = null
    var textTimeAndTickLayoutCon: LinearLayout? = null

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        message.payload?.let {
            backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
//            messageText!!.text = message.payload.data
            disappearIcon!!.visibility =
                when {
                    (message.payload.isExpire) -> VISIBLE
                    else -> GONE
                }

            forwardLayout!!.visibility = when {
                (message.payload.isForwarded) -> VISIBLE
                else -> GONE
            }

            when {
                (message.payload.isEdited) -> {
                    edited!!.visibility = VISIBLE
                }
                else -> edited!!.visibility = GONE
            }
            when {
                (message.payload.isDeleted) -> {
                    messageText!!.setTypeface(messageText!!.typeface, Typeface.ITALIC)
                    messageText!!.setTextColor(appContext!!.resources.getColor(R.color.white_70))
                }
                else -> {
                    messageText!!.setTypeface(messageText!!.typeface, Typeface.NORMAL)
                }
            }
            tvTime!!.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)
            handleTicks(message)

            messageText?.text =
                AndroidUtil.getString(
                    if (message.payload.isViewOnce && message.payload.isOpened) R.string.opened else R.string.tap_to_reveal
                )
            messageText?.setCompoundDrawablesWithIntrinsicBounds(
                if (message.payload.isViewOnce && message.payload.isOpened) R.drawable.ic_view_once_opened_sender else if (message.payload.isViewOnce) R.drawable.ic_view_once_sender else R.drawable.ic_confidentiality_sent,
                0,
                0,
                0
            )

        }
    }

    private fun handleTicks(message: Messages) {
        message.payload.status?.let {
            when {
                (message.payload.status.equals(
                    Constants.NOT_DELIVERED,
                    ignoreCase = true
                )
                        ) -> {
                    tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_not_sent))
                    tick!!.setPadding(8, 8, 8, 8)
                }
                (message.payload.status.equals(
                    Constants.SENT,
                    ignoreCase = true
                )
                        ) -> {
                    tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_tick))
                    tick!!.setPadding(10, 10, 10, 10)
                }
                (message.payload.status.equals(
                    Constants.DELIVERED,
                    ignoreCase = true
                )
                        ) -> {
                    tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_delivered))
                    tick!!.setPadding(3, 0, 0, 3)
                }
                (message.payload.status.equals(
                    Constants.SEEN,
                    ignoreCase = true
                )
                        ) -> {
                    tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_seen))
                    tick!!.setPadding(3, 0, 0, 3)
                }
            }
        }
    }

    private fun init(itemView: View) {
        messageText = itemView.findViewById(R.id.messageText0)
        tvTime = itemView.findViewById(R.id.text_textview_time)
        messageText = itemView.findViewById(R.id.messageText0)
        textTimeAndTickLayout = itemView.findViewById(R.id.text_time_and_tick_layout)

        val checkFontSize = SettingsValues.getMessageFontSize()
        val checkEmojiSize = SettingsValues.getMessageEmojiSize()
        val fontSize = when {
            checkFontSize <= 22 -> {
                Log.e(OutgoingTextMessageViewHolder::class.java.simpleName, "12ssp")
                com.intuit.ssp.R.dimen._12ssp
            }
            else -> {
                Log.e(OutgoingTextMessageViewHolder::class.java.simpleName, "42ssp")
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

        messageText!!.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            appContext!!.resources.getDimension(fontSize)
        )

        tvTime = itemView.findViewById(R.id.text_textview_time)

        tick = itemView.findViewById(R.id.text_text_sendTick)

        edited = itemView.findViewById(R.id.editedText)

        backgroundLayout = itemView.findViewById(R.id.text_sendingTextMessageLayout)
        disappearIcon = itemView.findViewById(R.id.text_disappear_sent)
        viewOnceIcon = itemView.findViewById(R.id.text_view_once_sent)
        bubbleView = itemView.findViewById(R.id.text_outgoing_layout_bubble_text)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_text_sent)

        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {

            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            true
        })

        backgroundLayout?.setOnClickListener {
            if (!messages!!.payload.isViewOnce) {
                getInstance()?.onConfidentialClick(messages!!, adapterPosition, bubbleView!!)
            }
        }
    }

    init {
        init(itemView)
    }
}