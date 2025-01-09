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
import com.devbeans.io.chat.databinding.CreatePinFragmentBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.views.ViewUtil

class CreatePinFragment : Fragment() {
    private var mBinding: CreatePinFragmentBinding? = null
    lateinit var editTexts: Array<EditText>


    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = CreatePinFragmentBinding.inflate(inflater, viewGroup, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        listeners()
    }

    private fun initViews() {
        mBinding?.apply {
            ViewUtil.focusAndShowKeyboard(mBinding?.pinView?.pinDigit1!!)
            setupEditTexts()
        }

    }

    private fun listeners() {


        mBinding?.apply {
            buttonVerify.setOnClickListener {
                createPin()
            }




        }
    }


    private fun createPin() {
        mBinding?.apply {
            val enteredPin = getPin()
            if (enteredPin.length == 4) {
                val bundle = Bundle()
                bundle.putString(Constants.KEYS.INTENT_FROM_AUTO_LOCK, enteredPin)
                requireActivity().findNavController(R.id.fragment_container_settings)
                    .navigate(
                        R.id.action_CreatePinFragment_to_ConfirmPinFragment, bundle
                    )

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
                            createPin()
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