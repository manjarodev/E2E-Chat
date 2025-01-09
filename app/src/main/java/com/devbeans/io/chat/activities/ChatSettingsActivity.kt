package com.devbeans.io.chat.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.annotation.MainThread
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityChatSettingsBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.WindowUtil
import com.devbeans.io.chat.verifypin.BaseActivity
import java.util.*

class ChatSettingsActivity : BaseActivity(), ExpiryCallback {
    private var mBinding: ActivityChatSettingsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat_settings)
        onBackPressedDispatcher.addCallback(this, OnBackPressed())
        WindowUtil.setStatusBarColor(window,AndroidUtil.getColor(R.color.bg_window_fill_color))
        setToolBar(mBinding?.toolbar!!)

    }


   private fun setToolBar(toolbar: Toolbar)
    {
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)!!.setDisplayShowTitleEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    fun getToolbar(): Toolbar {
        return mBinding?.toolbar!!
    }


    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        MainApp.appContext?.setNotifyExpiry(this)
        super.onResume()
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

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}