package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import android.view.View.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity.Companion.getInstance
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.DateTime
import com.devbeans.io.chat.utils.Utills
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.stfalcon.chatkit.messages.MessageHolders.OutcomingImageMessageViewHolder

class OutgoingVideoMessageViewHolder(itemView: View, payload: Any?) :
    OutcomingImageMessageViewHolder<Messages>(itemView, payload) {
    var imageView: ShapeableImageView? = null
    var tick: ImageView? = null
    var disappearIcon: ImageView? = null
    var time: TextView? = null
    var duration: TextView? = null
    var name: TextView? = null
    var backgroundLayout: RelativeLayout? = null
    var messages: Messages? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        val interval = (2 * 1000).toLong()
        val options = RequestOptions().frame(interval)
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
        time.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)
        disappearIcon!!.visibility =
            if (message.payload.isExpire) View.VISIBLE else View.GONE
        forwardLayout!!.visibility = if (message.payload.isForwarded) VISIBLE else GONE

        if (message.payload.isForwarded) {
            imageView!!.shapeAppearanceModel = imageView!!.shapeAppearanceModel
                .toBuilder()
                .setAllCorners(CornerFamily.ROUNDED, 48f)
                .setTopLeftCornerSize(0f)
                .setTopRightCornerSize(0f)
                .build()
        } else {

        }

        duration!!.text = Utills.getDuration(appContext, message.payload.filePath)
        Glide.with(appContext!!)
            .asBitmap()
            .load(message.payload.filePath)
            .apply(options)
            .into(imageView!!)
        if (message.payload.status != null && message.payload.status.equals(
                Constants.NOT_DELIVERED,
                ignoreCase = true
            )
        ) {
            tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_not_sent))
            tick!!.setPadding(8, 8, 8, 8)
        } else if (message.payload.status != null && message.payload.status.equals(
                Constants.SENT,
                ignoreCase = true
            )
        ) {
            tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_tick))
            tick!!.setPadding(10, 10, 10, 10)
        } else if (message.payload.status != null && message.payload.status.equals(
                Constants.DELIVERED,
                ignoreCase = true
            )
        ) {
            tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_delivered))
            tick!!.setPadding(3, 0, 0, 3)
        } else if (message.payload.status != null && message.payload.status.equals(
                Constants.SEEN,
                ignoreCase = true
            )
        ) {
            tick!!.setImageDrawable(getInstance()!!.resources.getDrawable(R.drawable.ic_seen))
            tick!!.setPadding(3, 0, 0, 3)
        }
    }

    private fun init(itemView: View) {
        imageView = itemView.findViewById(R.id.sentTxt)
        time = itemView.findViewById(R.id.textview_time_sent)
        //        name = itemView.findViewById(R.id.tv_group_member_name);
        duration = itemView.findViewById(R.id.textview_time_video)
        tick = itemView.findViewById(R.id.text_sendTick)
        backgroundLayout = itemView.findViewById(R.id.sendingImageMessageLayout)
        disappearIcon = itemView.findViewById(R.id.video_disappear_sent)
        bubbleView = itemView.findViewById(R.id.outgoing_image_layout_bubble)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_sent_video)
        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
//            backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.blue_10))
            getInstance()!!.onLongClick(messages!!, adapterPosition, bubbleView!!)
            true
        })
        backgroundLayout!!.setOnClickListener(View.OnClickListener {
            getInstance()!!.onMessageViewClick(
                itemView,
                messages!!
            )
        })
    }

    init {
        init(itemView)
    }
}