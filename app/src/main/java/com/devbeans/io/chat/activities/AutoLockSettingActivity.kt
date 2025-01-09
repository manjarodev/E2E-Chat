package com.devbeans.io.chat.activities


import android.graphics.PorterDuff
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.annotation.MainThread
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityAutoLockSettingBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.WindowUtil
import com.devbeans.io.chat.verifypin.BaseActivity

class AutoLockSettingActivity : BaseActivity(), ExpiryCallback {

    var mBinding: ActivityAutoLockSettingBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_auto_lock_setting)
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        WindowUtil.setStatusBarColor(window,AndroidUtil.getColor(R.color.bg_window_fill_color))
        onBackPressedDispatcher.addCallback(this, OnBackPressed())
        setToolBar(mBinding?.toolbar!!)
        listeners()
    }

    private fun setToolBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(AndroidUtil.getColor(R.color.white))
        supportActionBar?.setDisplayShowTitleEnabled(true)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(
                ContextCompat.getDrawable(this@AutoLockSettingActivity, R.drawable.ic_back_white)
                    ?.apply {
                        setColorFilter(
                            ContextCompat.getColor(this@AutoLockSettingActivity, R.color.white),
                            PorterDuff.Mode.SRC_ATOP
                        )
                    }
            )
        }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        super.onResume()
    }

    private fun listeners() {
        //this is a function which will be used for all listeners in this activity
    }

    private inner class OnBackPressed : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (!findNavController(
                    R.id.fragment_container_settings
                ).popBackStack()
            ) {
                finish()
            }
        }
    }


    companion object {
        var FROM_SETTINGS = "settings"
    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}