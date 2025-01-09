package com.devbeans.io.chat.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatSettingsActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.databinding.FragmentDeleteBinding
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.services.ChatClearBackgroundService
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.logging.Log
import java.util.*


class DeleteFragment : Fragment() {
    private var mBinding: FragmentDeleteBinding? = null
    private var progress = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = FragmentDeleteBinding.inflate(inflater, viewGroup, false)
        (activity as ChatSettingsActivity).supportActionBar?.title = ""
        (activity as ChatSettingsActivity).supportActionBar?.apply {
            setHomeButtonEnabled(false) // disable the button
            setDisplayHomeAsUpEnabled(false) // remove the left caret
            setDisplayShowHomeEnabled(false) // remove the icon
        }
        handleBackPressed()
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        val bundle = arguments
        val fromWipeData =
            bundle != null && bundle.containsKey(Constants.KEYS.INTENT_FROM_WIPE_DATA)
        mBinding?.apply {
            tvProgressNote.text = AndroidUtil.getString(
                if (fromWipeData) R.string.chat_s_wiping_note else R.string.app_is_wiping_note
            )
        }

        Thread {

            if (fromWipeData) {
                handleFromWipeData()
            }
            //show progress
            while (progress < 100) {
                progress += 1
                runOnUiThread {
                    mBinding?.setupProgress?.progress = progress
                    mBinding?.tvProgress?.text =
                        String.format(Locale.getDefault(), "%s", "$progress%")
                }
                try {
                    Thread.sleep(100)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                whenProgressIsHundred(fromWipeData)
            }
        }.start()
    }

    private fun whenProgressIsHundred(fromWipeData: Boolean) {
        if (progress == 100) {
            runOnUiThread {

//                        mBinding?.tvAppDeleted?.visibility = View.VISIBLE
                if (!fromWipeData) {
                    handleNotFromWipe()
                } else {
                    Notify.Toast(AndroidUtil.getString(R.string.chats_deleted))
                    requireActivity().finish()
                }
            }
        }
    }

    private fun handleNotFromWipe() {
        Handler(Looper.getMainLooper()).postDelayed({

            val sendMessage = Intent()
            sendMessage.putExtra("message", MainApp.appContext!!.packageName)
            sendMessage.action = "com.destroy.chat.app"
            sendMessage.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            MainApp.appContext!!.sendBroadcast(sendMessage)
            Log.e("APP", "Deleted")
            mBinding?.lvSetup?.visibility = View.GONE
            mBinding?.ivLoader?.visibility = View.GONE
        }, 500)
    }

    private fun handleFromWipeData() {
        if (MainApp.appContext?.conversationsDao!!.allConversations != null && MainApp.appContext?.conversationsDao!!
                .allConversations.size > 0
        ) {
            requireActivity().startService(
                Intent(
                    MainApp.appContext,
                    ChatClearBackgroundService::class.java
                )
            )
        }
    }


    private fun handleBackPressed() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    // Handle the back button even

                }
            }

        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), callback);
    }


}