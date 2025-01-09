package com.devbeans.io.chat.adapters.viewholders

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
import com.devbeans.io.chat.models.MetaData
import com.devbeans.io.chat.utils.Configurations
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.DateTime
import com.devbeans.io.chat.utils.Utills
import com.google.gson.Gson
import com.stfalcon.chatkit.messages.MessageHolders.OutcomingTextMessageViewHolder

class OutgoingFileMessageViewHolder(itemView: View, payload: Any?) :
    OutcomingTextMessageViewHolder<Messages>(itemView, payload) {
    var time: TextView? = null
    var fileName: TextView? = null
    var fileSize: TextView? = null
    var tick: ImageView? = null
    var disappearIcon: ImageView? = null
    var messages: Messages? = null
    var backgroundLayout: RelativeLayout? = null
    var bubbleView: ConstraintLayout? = null
    var forwardLayout: LinearLayout? = null

    override fun onBind(message: Messages) {
        super.onBind(message)
        messages = message
        time.text = DateTime.getFormattedTimeOnly(message.payload.createdAt)
        backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.transparent_color))
        disappearIcon!!.visibility =
            if (message.payload.isExpire) View.VISIBLE else View.GONE
        forwardLayout!!.visibility = if (message.payload.isForwarded) VISIBLE else GONE

        val path = Configurations.uploadsUrl + message.payload.data + "&download=false"
        val currentString = message.payload.data
        val separated = currentString!!.split("@@".toRegex()).toTypedArray()
        val data = separated[0] // this will contain "Fruit"
        val gson = Gson()
        val metaData = gson.fromJson(separated[1], MetaData::class.java)
        fileName!!.text = metaData.name
        fileSize!!.visibility = View.VISIBLE
        fileSize!!.text = Utills.getSize(metaData.size.toLong()) + " - " + metaData.extention
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
        time = itemView.findViewById(R.id.textview_time_sent)
        fileName = itemView.findViewById(R.id.tv_file_name)
        fileSize = itemView.findViewById(R.id.tv_file_size)
        tick = itemView.findViewById(R.id.text_sendTick)
        backgroundLayout = itemView.findViewById(R.id.sendingTextMessageLayout)
        disappearIcon = itemView.findViewById(R.id.file_disappear_sent)
        bubbleView = itemView.findViewById(R.id.outgoing_layout_bubble)
        forwardLayout = itemView.findViewById(R.id.layout_forwarded_sent_file)
        backgroundLayout!!.setOnLongClickListener(OnLongClickListener {
//            backgroundLayout!!.setBackgroundColor(appContext!!.resources.getColor(R.color.blue_10))
            getInstance()!!.onLongClick(messages!!, adapterPosition,bubbleView!!)
            false
        })
    }

    init {
        init(itemView)
    }
}