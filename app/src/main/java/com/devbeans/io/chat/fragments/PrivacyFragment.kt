package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.PrivacyActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.databinding.PrivacyFragmentBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.SettingsValues
import com.devbeans.io.chat.utils.Utills
import java.util.*

class PrivacyFragment : Fragment() {
    var mBinding: PrivacyFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = PrivacyFragmentBinding.inflate(inflater, viewGroup, false)
        (activity as PrivacyActivity).supportActionBar?.title = AndroidUtil.getString(R.string.privacy)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        listeners()

    }

    private fun initViews() {
        if (mBinding != null) {
            mBinding?.apply {
                tvBlockedContactsCount.text = String.format(
                    Locale.getDefault(), "%d Users",
                    if (AppSession.getUser().blockUsers != null && AppSession.getUser().blockUsers!!.isNotEmpty()) AppSession.getUser().blockUsers!!.size else 0
                )

                checkBlockUnknownContacts.isChecked = SettingsValues.getBlockUnknownContact()

                //setting the values of privacy hide sensitive messages in chat listings
                checkHideSensitiveChat.isChecked = SettingsValues.getHideAll()
                checkHideSensitiveChatDirect.isChecked = SettingsValues.getHideDirect()
                checkHideSensitiveChatGroup.isChecked = SettingsValues.getHideGroup()
                checkHideSensitiveChatAnonymousGroup.isChecked =
                    SettingsValues.getHideAnonymousGroup()

                checkAutoSave.isChecked =
                    SettingsValues.getAutoDownload()
                optionsMessage.text =
                    Utills.getDisappearingOptions(SettingsValues.getUniversalExpireTimer())

                checkConfidentialMessage.isChecked = SettingsValues.getConfidentialMessageCheck()
                checkPrivateClipboard.isChecked = SettingsValues.getIncognitoKeyboard()
                checkMediaShareRestrict.isChecked = SettingsValues.getMediaShareRestrict()
            }
        }
    }


    private fun listeners() {
        mBinding?.apply {
            layoutBlockedContacts.setOnClickListener {
                runOnUiThread {
                    activity?.findNavController(R.id.fragment_container_settings)
                        ?.navigate(R.id.action_PrivacyFragment_to_BlockedContactFragment)
                }
//                startActivity(
//                    Intent(
//                        requireActivity(),
//                        BlockedContactsActivity::class.java
//                    )
//                )
            }
            checkBlockUnknownContacts.setOnCheckedChangeListener { _, b ->
                SettingsValues.setBlockUnknownContact(b)
            }
            tvDisappearingMessage.setOnClickListener {
                if (Utills.isSubscriptionExpired()) {
                    Utills.showSubscriptionEnd()
                    return@setOnClickListener
                }
                startDisappearingActivity()
            }
            tvDisappearingMessageNote.setOnClickListener {
                if (Utills.isSubscriptionExpired()) {
                    Utills.showSubscriptionEnd()
                    return@setOnClickListener
                }
                startDisappearingActivity()
            }
            optionsMessage.setOnClickListener {
                if (Utills.isSubscriptionExpired()) {
                    Utills.showSubscriptionEnd()
                    return@setOnClickListener
                }
                startDisappearingActivity()
            }

            checkAutoSave.setOnCheckedChangeListener { _, b ->
                SettingsValues.setAutoDownload(b)
            }

            val allHideCheck = arrayOf(
                checkHideSensitiveChatDirect,
                checkHideSensitiveChatGroup,
                checkHideSensitiveChatAnonymousGroup
            )


            checkHideSensitiveChat.setOnClickListener {
                allHideCheck.forEach { it.isChecked = checkHideSensitiveChat.isChecked }
                SettingsValues.setHideAll(checkHideSensitiveChat.isChecked)
                SettingsValues.setHideDirect(checkHideSensitiveChat.isChecked)
                SettingsValues.setHideGroup(checkHideSensitiveChat.isChecked)
                SettingsValues.setHideAnonymousGroup(checkHideSensitiveChat.isChecked)
            }

            checkHideSensitiveChatDirect.setOnClickListener {
                checkAll(allHideCheck, checkHideSensitiveChat)
                SettingsValues.setHideDirect(checkHideSensitiveChatDirect.isChecked)
            }

            checkHideSensitiveChatGroup.setOnClickListener {
                checkAll(allHideCheck, checkHideSensitiveChat)
                SettingsValues.setHideGroup(checkHideSensitiveChatGroup.isChecked)
            }

            checkHideSensitiveChatAnonymousGroup.setOnClickListener {
                checkAll(allHideCheck, checkHideSensitiveChat)
                SettingsValues.setHideAnonymousGroup(checkHideSensitiveChatAnonymousGroup.isChecked)
            }

            checkConfidentialMessage.setOnCheckedChangeListener { _, b ->
                SettingsValues.setConfidentialMessageCheck(
                    b
                )
            }


            checkPrivateClipboard.setOnCheckedChangeListener { _, b ->
                SettingsValues.setIncognitoKeyboard(
                    b
                )
            }

            checkMediaShareRestrict.setOnCheckedChangeListener { _, b ->
                SettingsValues.setMediaShareRestrict(
                    b
                )
            }
        }

    }

    private fun checkAll(allHideCheck: Array<SwitchCompat>, checkHideSensitiveChat: SwitchCompat) {
        checkHideSensitiveChat.isChecked =
            allHideCheck[0].isChecked && allHideCheck[1].isChecked && allHideCheck[2].isChecked
        SettingsValues.setHideAll(checkHideSensitiveChat.isChecked)
    }

    private fun startDisappearingActivity() {

        runOnUiThread {
            activity?.findNavController(R.id.fragment_container_settings)
                ?.navigate(R.id.action_PrivacyFragment_to_ChatDisappearFragment)
        }
//        startActivity(
//            Intent(
//                requireActivity(),
//                DisappearingMsgActivity::class.java
//            ).putExtra("isFromGeneral", "isFromGeneral")
//        )
    }
}