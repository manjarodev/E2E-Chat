package com.devbeans.io.chat.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.DisappearingMsgActivity
import com.devbeans.io.chat.activities.PrivacyActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.databinding.DisappearingFragmentBinding
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.requestbody.UpdateConversationExpiry
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import hk.ids.gws.android.sclick.SClick
import retrofit2.Call
import retrofit2.Response
import java.text.ParseException
import java.util.concurrent.TimeUnit


/**
 * Fragment for Disappearing options for updating conversation expiry time
 */
class DisappearingFragment : Fragment(), OnClickListener, OnNetworkResponse {
    private var isFromGeneral: Boolean = false
    var mBinding: DisappearingFragmentBinding? = null
    var mConversation: Conversation? = null
    var isFromCreateConversation: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, viewGroup: ViewGroup?, bundle: Bundle?
    ): View? {
        mBinding = DisappearingFragmentBinding.inflate(inflater, viewGroup, false)

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        when (host) {
            is DisappearingMsgActivity -> {
                isFromGeneral = false
                isFromCreateConversation =
                    (activity as DisappearingMsgActivity).isFromCreateConversation()
                mConversation = (activity as DisappearingMsgActivity).getConversation()
                mConversation?.let { getDisappearingOptions(mConversation?.conversationExpiryTime!!) }
                    ?: getDisappearingOptions((activity as DisappearingMsgActivity).time.toLong())


            }

            is PrivacyActivity -> {
                isFromGeneral = true
                (activity as PrivacyActivity).supportActionBar?.title =
                    AndroidUtil.getString(R.string.disappearing_messages)
                getDisappearingOptions(SettingsValues.getUniversalExpireTimer())
            }
        }
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
            CommandReceiver, IntentFilter("disappearing_command_receive")
        )

        listeners()

    }

    private val CommandReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getIntExtra("command", 0)
            if (message > 0) {
                DisappearingMsgActivity.TimerUnit.values()
                    .find { (message / it.valueMultiplier) < it.maxValue }?.let { timerUnit ->
                        handleExpirySet(timerUnit, message)
                    }
            }
        }
    }

    private fun handleExpirySet(timerUnit: DisappearingMsgActivity.TimerUnit, message: Int) {
        when (DisappearingMsgActivity.TimerUnit.values().indexOf(timerUnit)) {
            0 -> {
                setExpiryTime((message).toLong(), Constants.DISAPPEARING_STRINGS._s)
            }

            1 -> {
                when {
                    (message / 60).toLong() > 0 -> {
                        setExpiryTime(
                            (message / 60).toLong(),
                            Constants.DISAPPEARING_STRINGS._m
                        )
                    }

                    else -> {
                        setExpiryTime(
                            (59).toLong(), Constants.DISAPPEARING_STRINGS._s
                        )
                    }

                }
            }

            2 -> {
                when {
                    ((message / 60) / 60).toLong() > 0 -> {
                        setExpiryTime(
                            ((message / 60) / 60).toLong(),
                            Constants.DISAPPEARING_STRINGS._h
                        )
                    }

                    else -> {
                        setExpiryTime(
                            (59).toLong(), Constants.DISAPPEARING_STRINGS._m
                        )
                    }


                }

            }

            3 -> {
                when {
                    (((message / 60) / 60) / 24).toLong() > 0 -> {
                        setExpiryTime(
                            (((message / 60) / 60) / 24).toLong(),
                            Constants.DISAPPEARING_STRINGS._d
                        )
                    }

                    else -> {
                        setExpiryTime(
                            (23).toLong(), Constants.DISAPPEARING_STRINGS._h
                        )
                    }
                }

            }

            4 -> {
                when {
                    (((message / 60) / 60) / 24).toLong() > 0 -> {
                        setExpiryTime(
                            (((message / 60) / 60) / 24).toLong(),
                            Constants.DISAPPEARING_STRINGS._d
                        )
                    }

                    else -> {
                        setExpiryTime(
                            (30).toLong(), Constants.DISAPPEARING_STRINGS._d
                        )
                    }


                }

            }

            5 -> {
                setExpiryTime(
                    (30).toLong(), Constants.DISAPPEARING_STRINGS._d
                )

            }
        }
    }

    private fun setExpiryTime(i: Long, _unit: Int) {
        val timeInMillis = when (_unit) {
            1 -> TimeUnit.SECONDS.toMillis(i)
            2 -> TimeUnit.MINUTES.toMillis(i)
            3 -> TimeUnit.HOURS.toMillis(i)
            4 -> TimeUnit.DAYS.toMillis(i)
            0 -> 0
            else -> -1
        }
        if (isFromCreateConversation) {
            runOnUiThread {
                val intent = Intent()
                intent.putExtra(Constants.KEYS.INTENT_DISAPPEAR_TIME_RESULT, timeInMillis.toInt())
                requireActivity().setResult(RequestCodes.GET_DISAPPEAR_TIME, intent)
                requireActivity().finish()
            }
        } else if (isFromGeneral) {
            SettingsValues.setUniversalExpireTimer(timeInMillis)
            runOnUiThread {
                activity?.findNavController(
                    R.id.fragment_container_settings
                )?.popBackStack()
            }
        } else {
            mConversation!!.conversationExpiryTime = timeInMillis

            updateExpiryTime(timeInMillis)
        }
    }

    private fun updateExpiryTime(timeInMillis: Long) {
        val request = UpdateConversationExpiry()
        request.conversation_id = mConversation!!.conversationId
        request.expiry_time = timeInMillis
        if (Utills.isNetworkAvailable()) {
            runOnUiThread {
                ApiHelper.with()?.updateConversationExpiry(request, this, activity)

            }
            Log.d(
                DisappearingMsgActivity.TAG,
                " updateExpiryTime: " + "End Point: " + RequestCodes.API_END_POINTS.UPDATE_CONVERSATION_EXPIRY_TIME + " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + " request" + request.toString()
            )
        } else {
            Notify.Toast("Internet not available ")
        }
    }


    override fun onDestroyView() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(CommandReceiver)
        super.onDestroyView()
    }

    private fun listeners() {
        mBinding?.apply {
            lvOptionOff.setOnClickListener(this@DisappearingFragment)
            lvOption30Seconds.setOnClickListener(this@DisappearingFragment)
            lvOption5Minutes.setOnClickListener(this@DisappearingFragment)
            lvOption1Hour.setOnClickListener(this@DisappearingFragment)
            lvOption1Day.setOnClickListener(this@DisappearingFragment)
            lvOption1Week.setOnClickListener(this@DisappearingFragment)
            lvOptionCustom.setOnClickListener(this@DisappearingFragment)
        }
    }

    fun getDisappearingOptions(expiryTime: Long) {
        var disappearingMsg = ""
        mBinding?.apply {
            tvOptionCustomView.visibility = GONE
            when (expiryTime) {
                -1L -> {
                    disappearingMsg = Constants.DISAPPEARING_STRINGS._off
                    changeUI(lvOptionOff, tvOptionOff)
                }

                0L -> {
                    disappearingMsg = Constants.DISAPPEARING_STRINGS._burn_on_read
                }

                30000L -> {
                    disappearingMsg = Constants.DISAPPEARING_STRINGS._30_seconds
                    changeUI(lvOption30Seconds, tvOption30Seconds)
                }

                300000L -> {
                    disappearingMsg = Constants.DISAPPEARING_STRINGS._5_minutes
                    changeUI(lvOption5Minutes, tvOption5Minutes)
                }

                3600000L -> {
                    disappearingMsg = Constants.DISAPPEARING_STRINGS._1_hour
                    changeUI(lvOption1Hour, tvOption1Hour)
                }

                86400000L -> {
                    disappearingMsg = Constants.DISAPPEARING_STRINGS._1_day
                    changeUI(lvOption1Day, tvOption1Day)
                }

                604800000L -> {
                    changeUI(lvOption1Week, tvOption1Week)
                }

                else -> {
                    changeUI(lvOptionCustom, tvOptionCustom)
                    disappearingMsg = getValues(expiryTime) ?: ""
                    tvOptionCustomView.visibility = VISIBLE
                    tvOptionCustomView.text = disappearingMsg
                }
            }


        }

    }

    private fun getValues(expiryTime: Long): String? {
        return Utills.TimerUnit.values()
            .find { ((expiryTime / 1000) / it.valueMultiplier) < it.maxValue }?.let { timerUnit ->
                when (Utills.TimerUnit.values().indexOf(timerUnit)) {
                    0 -> {

                        String.format(
                            "${expiryTime / 1000} %s", Constants.DISAPPEARING_STRINGS._seconds
                        )
                    }

                    1 -> {
                        when {

                            ((expiryTime / 1000) / 60).toLong() > 0 -> {
                                String.format(
                                    "${(expiryTime / 1000) / 60} %s",
                                    Constants.DISAPPEARING_STRINGS._minutes
                                )
                            }

                            else -> {
                                String.format(
                                    "59 %s", Constants.DISAPPEARING_STRINGS._seconds
                                )
                            }

                        }

                    }

                    2 -> {
                        when {
                            (((expiryTime / 1000) / 60) / 60).toLong() > 0 -> {

                                String.format(
                                    "${((expiryTime / 1000) / 60) / 60} %s",
                                    Constants.DISAPPEARING_STRINGS._hours
                                )
                            }

                            else -> {
                                String.format(
                                    "59 %s", Constants.DISAPPEARING_STRINGS._minutes
                                )
                            }


                        }

                    }

                    3 -> {
                        when {
                            ((((expiryTime / 1000) / 60) / 60) / 24).toLong() > 0 -> {
                                String.format(
                                    "${((((expiryTime / 1000) / 60) / 60) / 24)} %s",
                                    Constants.DISAPPEARING_STRINGS._days
                                )
                            }

                            else -> {
                                String.format(
                                    "23 %s", Constants.DISAPPEARING_STRINGS._hours
                                )
                            }

                        }

                    }

                    4 -> {
                        when {
                            ((((expiryTime / 1000) / 60) / 60) / 24).toLong() > 0 -> {
                                String.format(
                                    "${((((expiryTime / 1000) / 60) / 60) / 24)} %s",
                                    Constants.DISAPPEARING_STRINGS._days
                                )
                            }

                            else -> {
                                String.format(
                                    "30 %s", Constants.DISAPPEARING_STRINGS._days
                                )
                            }
                        }


                    }

                    5 -> {
                        String.format(
                            "30 %s", Constants.DISAPPEARING_STRINGS._days
                        )

                    }

                    else -> {
                        ""
                    }
                }
            }
    }

    private fun changeUI(selectedOption: LinearLayout?, tvOptionText: TextView) {

        mBinding?.apply {
            tvOptionCustomView.visibility = if (lvOptionCustom == selectedOption) VISIBLE else GONE
            val optionsViewLayouts = arrayOf(
                lvOptionOff,
                lvOption1Day,
                lvOption1Hour,
                lvOption1Week,
                lvOption30Seconds,
                lvOption5Minutes,
                lvOptionCustom
            )
            optionsViewLayouts.forEach { view ->
                view.background = AndroidUtil.getDrawable(
                    if (view == selectedOption) {
                        R.drawable.bg_disappearing_option_selected
                    } else {
                        R.drawable.bg_disappearing_option_unselected
                    }
                )
            }
            val optionsViewsText = arrayOf(
                tvOptionOff,
                tvOption30Seconds,
                tvOption5Minutes,
                tvOption1Hour,
                tvOption1Day,
                tvOption1Week,
                tvOptionCustom
            )

            optionsViewsText.forEach { view ->
                view.setTextColor(
                    AndroidUtil.getColor(
                        if (view == tvOptionText) {
                            R.color.blue
                        } else {
                            R.color.gray_variant
                        }
                    )
                )

            }


        }
    }

    override fun onClick(v: View?) {
        if (!SClick.check(SClick.BUTTON_CLICK)) return
        changeUI(v as LinearLayout, when (v.id) {
            R.id.lv_option_off -> {
                handleClick(0L)
                mBinding?.tvOptionOff!!
            }

            R.id.lv_option_30_seconds -> {
                handleClick(30000L)
                mBinding?.tvOption30Seconds!!
            }

            R.id.lv_option_5_minutes -> {
                handleClick(300000L)
                mBinding?.tvOption5Minutes!!
            }

            R.id.lv_option_1_hour -> {
                handleClick(3600000L)
                mBinding?.tvOption1Hour!!
            }

            R.id.lv_option_1_day -> {
                handleClick(86400000L)
                mBinding?.tvOption1Day!!
            }

            R.id.lv_option_1_week -> {
                handleClick(604800000L)
                mBinding?.tvOption1Week!!
            }

            R.id.lv_option_custom -> {
                runOnUiThread {
                    if (mConversation != null && mConversation!!.conversationExpiryTime > 0) {
                        CustomExpireTimerSelectDialog.show(
                            requireActivity().supportFragmentManager,
                            mConversation!!.conversationExpiryTime
                        )
                    } else {
                        CustomExpireTimerSelectDialog.show(
                            requireActivity().supportFragmentManager,
                            SettingsValues.getUniversalExpireTimer()
                        )
                    }
                }
                mBinding?.tvOptionCustom!!
            }

            else -> {
                mBinding?.tvOptionCustomView!!
            }
        })
    }

    private fun handleClick(expiryTime: Long) {
        if (isFromGeneral) {
            SettingsValues.setUniversalExpireTimer(if (expiryTime == 0L) -1L else expiryTime)
            runOnUiThread {
                activity?.findNavController(
                    R.id.fragment_container_settings
                )?.popBackStack()
            }
        } else {
            when (expiryTime) {
                0L -> setExpiryTime(0, Constants.DISAPPEARING_STRINGS._f)
                30000L -> setExpiryTime(30, Constants.DISAPPEARING_STRINGS._s)
                300000L -> setExpiryTime(5, Constants.DISAPPEARING_STRINGS._m)
                3600000L -> setExpiryTime(1, Constants.DISAPPEARING_STRINGS._h)
                86400000L -> setExpiryTime(1, Constants.DISAPPEARING_STRINGS._d)
                604800000L -> setExpiryTime(7, Constants.DISAPPEARING_STRINGS._d)
            }
        }
    }


    @Throws(ParseException::class)
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {

        if (tag as Int == RequestCodes.API.UPDATE_CONVERSATION_EXPIRY_TIME && response.code() == 200) {
            val res = response.body() as NewConversationResponse?
            if (res?.conversation != null) {
                Log.d(
                    DisappearingMsgActivity.TAG,
                    " updateExpiryTime: " + "End Point: " + RequestCodes.API_END_POINTS.UPDATE_CONVERSATION_EXPIRY_TIME + " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + " response" + res.toString()
                )
                MainApp.appContext!!.conversationsDao.updateExpireTime(
                    mConversation!!.conversationId,
                    res.conversation!!.conversationExpiryTime
                )
                runOnUiThread {
                    requireActivity().finish()


                }
            }
        }

    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        // for over ride essential

    }
}