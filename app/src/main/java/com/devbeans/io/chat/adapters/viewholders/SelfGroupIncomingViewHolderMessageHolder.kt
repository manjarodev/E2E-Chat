package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import android.widget.TextView
import com.devbeans.io.chat.R
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Utills.getDisappearingOptions
import com.stfalcon.chatkit.messages.MessageHolders

class SelfGroupIncomingViewHolderMessageHolder(itemView: View, payload: Any?) :
    MessageHolders.IncomingTextMessageViewHolder<Messages>(itemView, payload) {
    private lateinit var lvMediaRestrict: LinearLayout
    private lateinit var tvMediaRestrict: TextView
    private lateinit var lvTapToReveal: LinearLayout
    private lateinit var tvTapToReveal: TextView
    private lateinit var lvDisappear: LinearLayout
    private lateinit var tvDisappear: TextView
    private lateinit var tvGroupSettings: TextView
    private var disappearTimeInInt: Long = -1
    private var disappearTime: String = ""

    override fun onBind(message: Messages) {
        super.onBind(message)
        message.payload?.let { it ->

            try {
                val splits = it.data!!.split("&&").toTypedArray()
                it.conversationType?.let { type ->
                    tvGroupSettings.text=AndroidUtil.getString(if (type.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE)) R.string.conversation_settings else R.string.group_settings)
                }
                disappearTimeInInt = splits[0].toLong()
                disappearTime = getDisappearingOptions(disappearTimeInInt)
                val isDisappearing = disappearTimeInInt > 0
                val isConfidential = it.isConfidential
                val isCanShareForward = it.isCanShareForward
                lvDisappear.visibility = if (isDisappearing) VISIBLE else GONE
                lvTapToReveal.visibility = if (isConfidential) VISIBLE else GONE
                lvMediaRestrict.visibility = if (isCanShareForward) VISIBLE else GONE

                tvTapToReveal.text = AndroidUtil.getString(
                    R.string.tap_to_reveal_settings_enabled,
                    AndroidUtil.getString(if (isConfidential) R.string.enabled else R.string.disabled)
                )

                tvMediaRestrict.text = AndroidUtil.getString(
                    R.string.media_restrictions_enabled,
                    AndroidUtil.getString(if (isCanShareForward) R.string.enabled else R.string.disabled)
                )

                tvDisappear.text = AndroidUtil.getString(
                    R.string.disappearing_settings_are_enabled_and_all_messages_will_disappear_after_7_days,
                    disappearTime
                )

            } catch (e: Exception) {

            }

        }


    }

    private fun init(itemView: View) {
        lvMediaRestrict = itemView.findViewById(R.id.lv_media_restrict)
        tvMediaRestrict = itemView.findViewById(R.id.tv_media_restrict)
        lvTapToReveal = itemView.findViewById(R.id.lv_tap_to_reveal)
        tvTapToReveal = itemView.findViewById(R.id.tv_tap_to_reveal)
        lvDisappear = itemView.findViewById(R.id.lv_group_disappearing)
        tvDisappear = itemView.findViewById(R.id.tv_group_disappearing)
        tvGroupSettings = itemView.findViewById(R.id.tv_group_setting_title)

    }

    init {
        init(itemView)
    }
}