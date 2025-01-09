package com.devbeans.io.chat.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityDisappearingMsgBinding
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.fragments.CustomExpireTimerSelectDialog
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.requestbody.UpdateConversationExpiry
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.Constants.DISAPPEARING_STRINGS
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import retrofit2.Call
import retrofit2.Response
import java.text.ParseException
import java.util.concurrent.TimeUnit


//************************************************************
class DisappearingMsgActivity : BaseActivity(), View.OnClickListener,
    OnNetworkResponse, ExpiryCallback
//************************************************************
{
    var time: Long = -1
    private var mBinding: ActivityDisappearingMsgBinding? = null
    private var mSelectedOption = MutableLiveData<String>()
    private var mOption: String? = null
    private var mConversation: Conversation? = null
    private var isFromCreateConversation = false
    private var isFromGeneralSettings = false
    override fun onResume() {
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        super.onResume()
    }

    //************************************************************
    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?)
    //************************************************************
    {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(
            this,
            com.devbeans.io.chat.R.layout.activity_disappearing_msg
        )
        WindowUtil.setStatusBarColor(window,AndroidUtil.getColor(R.color.bg_window_fill_color))


        roomData
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        Log.e(TAG, "onCreate: $mOption")
        checkConversation


        // Create the Bundle to pass, you can put String, Integer, or serializable object
        // Create the Bundle to pass, you can put String, Integer, or serializable object

//        mBinding?.radioOptions?.setOnClickListener {
//            when (it.id) {
//                R.id.dis_off -> Notify.Toast("Off")
//                R.id.dis_30_seconds -> Notify.Toast("Off")
//                R.id.dis_5_min -> Notify.Toast("Off")
//                R.id.dis_1_hour -> Notify.Toast("Off")
//                R.id.dis_1_week -> Notify.Toast("Off")
//                R.id.dis_custom -> CustomExpireTimerSelectDialog.show(supportFragmentManager)
//            }
//        }
        mBinding?.apply {
            disOff.setOnClickListener(this@DisappearingMsgActivity)
            disView.setOnClickListener(this@DisappearingMsgActivity)
            dis30Seconds.setOnClickListener(this@DisappearingMsgActivity)
            dis5Min.setOnClickListener(this@DisappearingMsgActivity)
            dis1Hour.setOnClickListener(this@DisappearingMsgActivity)
            dis1Day.setOnClickListener(this@DisappearingMsgActivity)
            dis1Week.setOnClickListener(this@DisappearingMsgActivity)
            disCustom.setOnClickListener(this@DisappearingMsgActivity)

        }
        setToolbar()
    }

    @get:RequiresApi(api = Build.VERSION_CODES.N)
    private val roomData: Unit
        get() {
            if (intent.hasExtra(Constants.KEYS.INTENT_CONVERSATION)) {
                mConversation =
                    intent.getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation?
                Log.e(
                    TAG, "getRoomData: " + Utills.getDisappearingOptions(
                        mConversation!!.conversationExpiryTime
                    )
                )
            }
            if (intent.hasExtra(Constants.KEYS.INTENT_DISAPPEARING)) {
                if (intent.hasExtra(Constants.KEYS.INTENT_DISAPPEAR_TIME)) {
                    time = intent.getIntExtra(
                        Constants.KEYS.INTENT_DISAPPEAR_TIME,
                        -1
                    ).toLong()

                    mOption = Utills.getDisappearingOptions(
                        time
                    )
                    isFromCreateConversation = true
                }
            }

            if (intent.hasExtra("isFromGeneral")) {
                isFromGeneralSettings = true
            }

        }

    fun getConversation(): Conversation? = mConversation

    private val checkConversation: Unit
        get() {
            if (mConversation != null && mConversation!!.conversationExpiryTime > 0) {
                TimerUnit.values()
                    .find { ((mConversation!!.conversationExpiryTime / 1000) / it.valueMultiplier) < it.maxValue }
                    ?.let { timerUnit ->
                        val index = TimerUnit.values().indexOf(timerUnit)
                        when (index) {
                            0 -> {
                                if (((mConversation!!.conversationExpiryTime / 1000)) == 30L) {
                                    mBinding!!.dis30Seconds.isChecked =
                                        ((mConversation!!.conversationExpiryTime / 1000)) == 30L
                                } else {
                                    mBinding!!.disCustom.isChecked = true
                                }
                            }

                            1 -> {
                                if (((mConversation!!.conversationExpiryTime / 1000) / 60) == 5L) {
                                    mBinding!!.dis5Min.isChecked =
                                        ((mConversation!!.conversationExpiryTime / 1000) / 60) == 5L
                                } else {
                                    mBinding!!.disCustom.isChecked = true
                                }
                            }

                            2 -> {
                                if ((((mConversation!!.conversationExpiryTime / 1000) / 60) / 60) == 1L) {
                                    mBinding!!.dis1Hour.isChecked =
                                        (((mConversation!!.conversationExpiryTime / 1000) / 60) / 60) == 1L
                                } else {
                                    mBinding!!.disCustom.isChecked = true
                                }
                            }

                            3 -> {

                                if (((((mConversation!!.conversationExpiryTime / 1000) / 60) / 60) / 24) == 1L
                                ) {
                                    mBinding!!.dis1Day.isChecked =
                                        ((((mConversation!!.conversationExpiryTime / 1000) / 60) / 60) / 24) == 1L
                                } else {
                                    mBinding!!.disCustom.isChecked = true
                                }

                            }

                            4 -> {

                                if ((((((mConversation!!.conversationExpiryTime / 1000) / 60) / 60) / 24) / 7) == 1L
                                ) {
                                    mBinding!!.dis1Day.isChecked =
                                        (((((mConversation!!.conversationExpiryTime / 1000) / 60) / 60) / 24) / 7) == 1L
                                } else {
                                    mBinding!!.disCustom.isChecked = true
                                }
                            }

                            5 -> {
                                mBinding!!.disCustom.isChecked = true
                            }
                        }
                    }
            } else if (isFromGeneralSettings) {
                if (SettingsValues.getUniversalExpireTimer() > 0) {
                    TimerUnit.values()
                        .find { ((SettingsValues.getUniversalExpireTimer() / 1000) / it.valueMultiplier) < it.maxValue }
                        ?.let { timerUnit ->
                            val index = TimerUnit.values().indexOf(timerUnit)
                            when (index) {
                                0 -> {
                                    if (((SettingsValues.getUniversalExpireTimer() / 1000)) == 30L) {
                                        mBinding!!.dis30Seconds.isChecked =
                                            ((SettingsValues.getUniversalExpireTimer() / 1000)) == 30L
                                    } else {
                                        mBinding!!.disCustom.isChecked = true
                                    }
                                }

                                1 -> {
                                    if (((SettingsValues.getUniversalExpireTimer() / 1000) / 60) == 5L) {
                                        mBinding!!.dis5Min.isChecked =
                                            ((SettingsValues.getUniversalExpireTimer() / 1000) / 60) == 5L
                                    } else {
                                        mBinding!!.disCustom.isChecked = true
                                    }
                                }

                                2 -> {
                                    if ((((SettingsValues.getUniversalExpireTimer() / 1000) / 60) / 60) == 1L) {
                                        mBinding!!.dis1Hour.isChecked =
                                            (((SettingsValues.getUniversalExpireTimer() / 1000) / 60) / 60) == 1L
                                    } else {
                                        mBinding!!.disCustom.isChecked = true
                                    }
                                }

                                3 -> {

                                    if (((((SettingsValues.getUniversalExpireTimer() / 1000) / 60) / 60) / 24) == 1L
                                    ) {
                                        mBinding!!.dis1Day.isChecked =
                                            ((((SettingsValues.getUniversalExpireTimer() / 1000) / 60) / 60) / 24) == 1L
                                    } else {
                                        mBinding!!.disCustom.isChecked = true
                                    }

                                }

                                4 -> {

                                    if ((((((SettingsValues.getUniversalExpireTimer() / 1000) / 60) / 60) / 24) / 7) == 1L
                                    ) {
                                        mBinding!!.dis1Day.isChecked =
                                            (((((SettingsValues.getUniversalExpireTimer() / 1000) / 60) / 60) / 24) / 7) == 1L
                                    } else {
                                        mBinding!!.disCustom.isChecked = true
                                    }
                                }

                                5 -> {
                                    mBinding!!.disCustom.isChecked = true
                                }
                            }
                        }
                } else {
                    mBinding!!.disOff.isChecked = true
                }
            } else if (isFromCreateConversation) {
                //check if it is from create conversation
            } else {

            }
        }

    //************************************************************
    private fun setToolbar()
    //************************************************************
    {
        mBinding!!.ivBack.setOnClickListener { onBackPressed() }
    }


    override fun onClick(view: View) {

        when (view.id) {
            R.id.dis_off -> setExpiryTime(0, DISAPPEARING_STRINGS._f)
            R.id.dis_view -> setExpiryTime(0, DISAPPEARING_STRINGS._ds)
            R.id.dis_30_seconds -> setExpiryTime(30, DISAPPEARING_STRINGS._s)
            R.id.dis_5_min -> setExpiryTime(5, DISAPPEARING_STRINGS._m)
            R.id.dis_1_hour -> setExpiryTime(1, DISAPPEARING_STRINGS._h)
            R.id.dis_1_day -> setExpiryTime(1, DISAPPEARING_STRINGS._d)
            R.id.dis_1_week -> setExpiryTime(7, DISAPPEARING_STRINGS._d)
            R.id.dis_custom -> {
                if (mConversation != null && mConversation!!.conversationExpiryTime > 0) {
                    CustomExpireTimerSelectDialog.show(
                        supportFragmentManager,
                        mConversation!!.conversationExpiryTime
                    )
                } else {
                    CustomExpireTimerSelectDialog.show(
                        supportFragmentManager,
                        SettingsValues.getUniversalExpireTimer()
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    private fun setExpiryTime(i: Long, _unit: Int) {
        val timeInMillis =
            when (_unit) {
                1 -> TimeUnit.SECONDS.toMillis(i)
                2 -> TimeUnit.MINUTES.toMillis(i)
                3 -> TimeUnit.HOURS.toMillis(i)
                4 -> TimeUnit.DAYS.toMillis(i)
                0 -> 0
                else -> -1
            }
        if (isFromCreateConversation) {
            val intent = intent
            intent.putExtra(Constants.KEYS.INTENT_DISAPPEAR_TIME_RESULT, timeInMillis.toInt())
            setResult(RequestCodes.GET_DISAPPEAR_TIME, intent)
            finish()
        } else if (isFromGeneralSettings) {
            SettingsValues.setUniversalExpireTimer(timeInMillis)
            finish()
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
            ApiHelper.with()?.updateConversationExpiry(request, this, this@DisappearingMsgActivity)
//            NetworkCall
//                .make()
//                .setCallback(this@DisappearingMsgActivity)
//                .setTag(RequestCodes.API.UPDATE_CONVERSATION_EXPIRY_TIME)
//                .autoLoadingCancel(Utills.getLoading(this, "Updating"))
//                .enque(Network.apis().updateExpiryTime(AppSession.getUser().chatUserId, request))
//                .execute()
            Log.d(
                TAG,
                " updateExpiryTime: " + "End Point: " + RequestCodes.API_END_POINTS.UPDATE_CONVERSATION_EXPIRY_TIME +
                        " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + " request" + request.toString()
            )
        } else {
            Notify.Toast("Internet not available ")
        }
    }

    @Throws(ParseException::class)
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag as Int == RequestCodes.API.UPDATE_CONVERSATION_EXPIRY_TIME) {
            if (response.code() == 200) {
                val res = response.body() as NewConversationResponse?
                if (res != null && res.conversation != null) {
                    Log.d(
                        TAG,
                        " updateExpiryTime: " + "End Point: " + RequestCodes.API_END_POINTS.UPDATE_CONVERSATION_EXPIRY_TIME +
                                " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + " response" + res.toString()
                    )
                    conversationsDao
                        .updateExpireTime(
                            mConversation!!.conversationId,
                            res.conversation!!.conversationExpiryTime
                        )
                    finish()
                }
            }
        }
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        //this function is used for API failure
    }

    companion object {
        private var disappearingMsgActivity: DisappearingMsgActivity? = null
        val TAG: String = DisappearingMsgActivity::class.java.simpleName

        @get:Synchronized
        val instance: DisappearingMsgActivity?
            get() {
                if (disappearingMsgActivity == null) {
                    disappearingMsgActivity = DisappearingMsgActivity()
                }
                return disappearingMsgActivity
            }
    }

    enum class TimerUnit(val minValue: Int, val maxValue: Int, val valueMultiplier: Long) {
        SECONDS(1, 59, TimeUnit.SECONDS.toSeconds(1)),
        MINUTES(1, 59, TimeUnit.MINUTES.toSeconds(1)),
        HOURS(1, 23, TimeUnit.HOURS.toSeconds(1)),
        DAYS(1, 6, TimeUnit.DAYS.toSeconds(1)),
        WEEKS(1, 4, TimeUnit.DAYS.toSeconds(7)),
        MONTH(1, 30, TimeUnit.DAYS.toSeconds(30));

        companion object {
            fun get(value: Int) = values()[value]
        }
    }

    fun isFromCreateConversation(): Boolean {
        return isFromCreateConversation
    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}