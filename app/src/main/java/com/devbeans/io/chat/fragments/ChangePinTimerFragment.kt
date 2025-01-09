package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.AutoLockSettingActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.databinding.ChangePinTimerFragmentBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.verifypin.LogOutTimerUtil

class ChangePinTimerFragment : Fragment(), OnClickListener {

    var mBinding: ChangePinTimerFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = ChangePinTimerFragmentBinding.inflate(inflater, viewGroup, false)
        (activity as AutoLockSettingActivity).supportActionBar?.title =
            AndroidUtil.getString(R.string.autolock_timer)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        listeners()
    }

    private fun listeners() {
        mBinding?.lvPinOption15Seconds?.setOnClickListener(this@ChangePinTimerFragment)
        mBinding?.lvPinOption30Seconds?.setOnClickListener(this@ChangePinTimerFragment)
        mBinding?.lvPinOption1Minute?.setOnClickListener(this@ChangePinTimerFragment)
        mBinding?.lvPinOption5Minute?.setOnClickListener(this@ChangePinTimerFragment)
        mBinding?.lvPinOption10Minutes?.setOnClickListener(this@ChangePinTimerFragment)
        mBinding?.lvPinOption15Minutes?.setOnClickListener(this@ChangePinTimerFragment)
    }

    private fun initViews() {
        mBinding?.apply {
            when (AppSession.getInt(LogOutTimerUtil.LOGOUT_KEY)) {
                15000 -> {
                    changeUI(lvPinOption15Seconds)
                }
                30000 -> {
                    changeUI(lvPinOption30Seconds)
                }
                60000 -> {
                    changeUI(lvPinOption1Minute)
                }
                300000 -> {
                    changeUI(lvPinOption5Minute)
                }
                600000 -> {
                    changeUI(lvPinOption10Minutes)
                }
                900000 -> {
                    changeUI(lvPinOption15Minutes)
                }
            }
        }
    }

    private fun changeUI(selectedUI: LinearLayout) {
        mBinding?.apply {
            arrayOf(
                lvPinOption15Seconds,
                lvPinOption30Seconds,
                lvPinOption1Minute,
                lvPinOption5Minute,
                lvPinOption10Minutes,
                lvPinOption15Minutes
            ).forEach { view ->
                view.background = AndroidUtil.getDrawable(
                    if (view == selectedUI) {
                        R.drawable.bg_disappearing_option_selected
                    } else {
                        R.drawable.bg_disappearing_option_unselected
                    }
                )
            }
        }
    }

    override fun onClick(v: View?) {

        changeUI(
            v as LinearLayout
        )
        when(v?.id)
        {
            R.id.lv_pin_option_15_seconds -> setPinTime(15000)
            R.id.lv_pin_option_30_seconds -> setPinTime(30000)
            R.id.lv_pin_option_1_minute -> setPinTime(60000)
            R.id.lv_pin_option_5_minute -> setPinTime(300000)
            R.id.lv_pin_option_10_minutes -> setPinTime(600000)
            R.id.lv_pin_option_15_minutes -> setPinTime(900000)
        }
        activity?.findNavController(R.id.fragment_container_settings)
            ?.navigateUp()

    }

    private fun setPinTime(timeInMilliSeconds: Int) {
        LogOutTimerUtil.LOGOUT_TIME = timeInMilliSeconds
        AppSession.put(LogOutTimerUtil.LOGOUT_KEY, timeInMilliSeconds)
    }
}