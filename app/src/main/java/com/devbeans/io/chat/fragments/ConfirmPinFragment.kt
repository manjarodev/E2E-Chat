package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.databinding.ConfirmPinFragmentBinding
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.views.ViewUtil
import com.devbeans.io.chat.verifypin.CreatePinActivity

class ConfirmPinFragment : Fragment() {
    private var mBinding: ConfirmPinFragmentBinding? = null
    private var enteredPin: String = ""
    lateinit var editTexts: Array<EditText>

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {

        mBinding = ConfirmPinFragmentBinding.inflate(inflater, viewGroup, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        listeners()
    }

    private fun initViews() {
        enteredPin = ""
        val bundle = arguments
        if (bundle != null && bundle.containsKey(Constants.KEYS.INTENT_FROM_AUTO_LOCK)) {
            enteredPin = bundle.getString(Constants.KEYS.INTENT_FROM_AUTO_LOCK, "")
        }
        setupEditTexts()
        ViewUtil.focusAndShowKeyboard(mBinding?.pinView!!.pinDigit1)
    }

    private fun listeners() {
        mBinding?.apply {
            buttonVerify.setOnClickListener {
                savePin()
            }


        }


    }

    private fun savePin() {
        mBinding?.apply {
            val confirmPin = getPin()
            if (confirmPin == enteredPin) {
                val check = AppSession.put(CreatePinActivity.KEY_PIN, confirmPin)
                if (check) {
                    runOnUiThread {
                        Notify.Toast("Pin Changed")
                        requireActivity().finish()
                    }
                }

            } else {
                showError()
                Notify.Toast(AndroidUtil.getString(R.string.pin_did_not_match))
            }

            clearText()

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

                        mBinding?.buttonVerify?.isClickable = getPin().length == 4
                        mBinding?.buttonVerify?.alpha = if (getPin().length == 4) 1F else 0.4F
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
                            savePin()
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
        editTexts.last().setError("Pin Didn't match...")
    }

    fun getPin(): String {
        return editTexts.joinToString(separator = "") { it.text.toString() }
    }
}