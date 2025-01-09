package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import android.view.View.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.Configurations
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.DateTime
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.stfalcon.chatkit.messages.MessageHolders.OutcomingImageMessageViewHolder
import java.io.File

class OutgoingImageMessageViewHolder(itemView: View, payload: Any?) :
    OutcomingImageMessageViewHolder<Messages>(itemView, payload) {
    var imageView: ShapeableImageView? = null
    var tick: ImageView? = null
    var disappearIcon: ImageView? = null
    var time: TextView? = null
    var file: File? = null
    var backgroundLayout: RelativeLayout? = null
    var messages: Messages? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null
    var timeTickLayout: LinearLayout? = null

    var tvTimeCon: TextView? = null
    var messageTextCon: TextView? = null
    var editedCon: TextView? = null
    var tickCon: ImageView? = null
    var textTimeAndTickLayoutCon: LinearLayout? = null

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        message.payload?.let { payload ->
            payload.status?.let { status ->
                val imageAndPadding = mapOf(
                    Constants.NOT_DELIVERED to Pair(R.drawable.ic_not_sent, Pair(8, 8)),
                    Constants.SENT to Pair(R.drawable.ic_tick, Pair(10, 10)),
                    Constants.DELIVERED to Pair(R.drawable.ic_delivered, Pair(3, 0)),
                    Constants.SEEN to Pair(R.drawable.ic_seen, Pair(3, 0))
                )

                imageAndPadding[status]?.let { (imageRes, padding) ->
                    tick?.apply {
                        setImageDrawable(ContextCompat.getDrawable(context, imageRes))
                        setPadding(padding.first, padding.second, padding.first, padding.second)
                    }
                }
            }

            if (!payload.isConfidential) {
                handleWhenNotConfidential(message)
            } else {
                imageView?.visibility = GONE
                forwardLayout?.visibility = GONE
                timeTickLayout?.visibility = GONE
                messageTextCon?.visibility = VISIBLE
                textTimeAndTickLayoutCon?.visibility = VISIBLE
                tvTimeCon?.text = DateTime.getFormattedTimeOnly(payload.createdAt)
            }
        }
    }


    private fun handleWhenNotConfidential(message: Messages) {
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
        disappearIcon!!.visibility =
            when {
                (message.payload.isExpire) -> VISIBLE
                else -> GONE
            }

        forwardLayout!!.visibility =
            when {
                (message.payload.isForwarded) -> VISIBLE
                else -> GONE
            }

        when {
            (message.payload.isForwarded) -> {
                imageView!!.shapeAppearanceModel =
                    imageView!!.shapeAppearanceModel.toBuilder()
                        .setAllCorners(CornerFamily.ROUNDED, 40f)
                        .setTopLeftCornerSize(0f)
                        .setTopRightCornerSize(0f).build();
            }
            else -> {
                imageView!!.shapeAppearanceModel =
                    imageView!!.shapeAppearanceModel.toBuilder()
                        .setAllCorners(CornerFamily.ROUNDED, 40f).build();
            }
        }

        time.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)

        message.payload.filePath?.let {
            file = File(message.payload.filePath!!)
        }
        if (file != null && file!!.exists()) {
            Glide.with(appContext!!).load(file).into(imageView!!)
        } else {
            Glide.with(appContext!!)
                .load(Configurations.uploadsUrl + message.payload.data + "&download=false")
                .into(
                    imageView!!
                )
        }
    }

    private fun init(itemView: View) {
        imageView = itemView.findViewById(R.id.image)
        time = itemView.findViewById(R.id.textview_time_sent)
        tick = itemView.findViewById(R.id.text_sendTick)
        backgroundLayout = itemView.findViewById(R.id.sendingImageMessageLayout)
        disappearIcon = itemView.findViewById(R.id.image_disappear_sent)
        bubbleView = itemView.findViewById(R.id.outgoing_image_layout_bubble)

        tvTimeCon = itemView.findViewById(R.id.text_textview_time_con)
        tickCon = itemView.findViewById(R.id.text_text_sendTick_con)
        editedCon = itemView.findViewById(R.id.editedText_con)
        messageTextCon = itemView.findViewById(R.id.messageText0_con)
        textTimeAndTickLayoutCon = itemView.findViewById(R.id.text_time_and_tick_layout_con)

        forwardLayout = itemView.findViewById(R.id.layout_forwarded_sent_image)
        timeTickLayout = itemView.findViewById(R.id.time_and_tick_layout)
        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            true
        })
        backgroundLayout!!.setOnClickListener(View.OnClickListener {
            getInstance()!!.onMessageViewClick(
                itemView, messages!!
            )
        })
    }

    init {
        init(itemView)
    }
}