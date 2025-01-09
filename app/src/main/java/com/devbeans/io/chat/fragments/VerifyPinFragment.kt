package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.AutoLockSettingActivity
import com.devbeans.io.chat.activities.ChatSettingsActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.databinding.FragmentVerifyPinSettingsBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.views.ViewUtil
import com.devbeans.io.chat.verifypin.CreatePinActivity

class VerifyPinFragment : Fragment() {
    private var isFromAutoLock: Boolean = false
    private var mBinding: FragmentVerifyPinSettingsBinding? = null
    private val TAG = VerifyPinFragment::class.java.simpleName
    lateinit var editTexts: Array<EditText>

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = FragmentVerifyPinSettingsBinding.inflate(inflater, viewGroup, false)
        if (host is ChatSettingsActivity) {
            isFromAutoLock = false
            (activity as ChatSettingsActivity).supportActionBar?.title = ""
            (activity as ChatSettingsActivity).supportActionBar?.apply {
                setHomeButtonEnabled(true) // disable the button
                setDisplayHomeAsUpEnabled(true) // remove the left caret
                setDisplayShowHomeEnabled(true) // remove the icon
            }
        } else if (host is AutoLockSettingActivity) {
            isFromAutoLock = true
            (activity as AutoLockSettingActivity).supportActionBar?.apply {
                title = ""
                setHomeButtonEnabled(true) // disable the button
                setDisplayHomeAsUpEnabled(true) // remove the left caret
                setDisplayShowHomeEnabled(true) // remove the icon
            }
        }
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding?.apply {
            setUpPinView()
//            ViewUtil.focusAndShowKeyboard(pinView)


            listeners()
        }
    }

    private fun setUpPinView() {

        ViewUtil.focusAndShowKeyboard(mBinding?.pinView?.pinDigit1!!)
        mBinding?.tvVerifyPinNote?.visibility = if (isFromAutoLock) GONE else VISIBLE
        setupEditTexts()


    }



    private fun listeners() {
        mBinding?.apply {
            lvProceed1.setOnClickListener {
                performVerifyPin()
            }

//            pinView.setOnFocusChangeListener { _, hasFocus ->
//                setBackgroundResource(if (hasFocus || text.isNotEmpty()) pinEntryFocusedOutline else pinEntryUnfocusedOutline)
//            }
        }
    }

    private fun performVerifyPin() {
        mBinding?.apply {
            val enteredPin = getPin()
            val finalPin = AppSession.get(CreatePinActivity.KEY_PIN)
            if (enteredPin.length == 4) {

                if (enteredPin == finalPin) {
                    requireActivity().findNavController(R.id.fragment_container_settings)
                        .navigate(
                            if (isFromAutoLock) R.id.action_VerifyPinFragment_to_CreatePinFragment
                            else R.id.action_verifyPinSettingsFragment_to_agreementSettings
                        )
                } else {

                    Notify.Toast(AndroidUtil.getString(R.string.pin_did_not_match))
                }
                clearText()
            } else {
                showError()
            }
        }
    }

    private fun setupEditTexts() {
        editTexts = arrayOf(
            mBinding?.pinView?.pinDigit1!!,
            mBinding?.pinView?.pinDigit2!!,
            mBinding?.pinView?.pinDigit3!!,
            mBinding?.pinView?.pinDigit4!!
        )

        for (i in editTexts.indices) {

            editTexts[i].apply {
                setBackgroundResource( R.drawable.ic_bg_edit_unselect)

                addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable) {
                        setBackgroundResource(if (s.isNotEmpty() || hasFocus()) R.drawable.ic_bg_edit_select else R.drawable.ic_bg_edit_unselect)
                        if (s.isNotEmpty() && i < editTexts.size - 1) {
                            editTexts[i + 1].requestFocus()
                        }
                    }

                    override fun beforeTextChanged(
                        s: CharSequence,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {

                        mBinding?.lvProceed1?.isClickable = getPin().length == 4
                        mBinding?.lvProceed1?.alpha = if (getPin().length == 4) 1F else 0.4F
                    }
                })

                setOnKeyListener { _, keyCode, event ->
                    if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                        if (text.isEmpty() && i > 0) {
                            editTexts[i - 1].requestFocus()
                        }
                    }
                    false
                }

                setOnFocusChangeListener { _, hasFocus ->
                    if (hasFocus || text.isNotEmpty()) {
                        setBackgroundResource(R.drawable.ic_bg_edit_select)
                    } else {
                        setBackgroundResource(R.drawable.ic_bg_edit_unselect)
                    }
                }

                setOnEditorActionListener { v, actionId, event ->
                    return@setOnEditorActionListener when (actionId) {
                        EditorInfo.IME_ACTION_DONE -> {
                            performVerifyPin()
                            true
                        }

                        else -> false
                    }
                }
            }
        }
    }

    fun clearText() {
        for (i in editTexts.indices) {
            editTexts[i].apply {
                setText("")
            }
        }
        editTexts.first().requestFocus()
    }

    fun showError() {
        editTexts.last().setError("Required...")
    }

    fun getPin(): String {
        return editTexts.joinToString(separator = "") { it.text.toString() }
    }
}