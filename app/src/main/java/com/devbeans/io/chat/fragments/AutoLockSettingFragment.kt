package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.AutoLockSettingActivity
import com.devbeans.io.chat.databinding.AutoLockSettingFragmentBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants

class AutoLockSettingFragment : Fragment() {
    var mBinding: AutoLockSettingFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = AutoLockSettingFragmentBinding.inflate(inflater, viewGroup, false)
        (activity as AutoLockSettingActivity).supportActionBar?.title =
            AndroidUtil.getString(R.string.autolock_settings)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listeners()
    }

    private fun listeners() {
        mBinding?.apply {
            changePinLayout.setOnClickListener {
                activity?.findNavController(R.id.fragment_container_settings)
                    ?.navigate(R.id.action_AutoLockSettingFragment_to_VerifyPinFragment)
            }

            autoLockTimerLayout.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(
                    Constants.KEYS.INTENT_FROM_AUTO_LOCK,
                    Constants.KEYS.INTENT_FROM_AUTO_LOCK
                )
                activity?.findNavController(R.id.fragment_container_settings)
                    ?.navigate(R.id.action_AutoLockSettingFragment_to_ChangePinTimer, bundle)
            }
        }
    }
}