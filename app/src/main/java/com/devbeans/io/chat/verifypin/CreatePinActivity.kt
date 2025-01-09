package com.devbeans.io.chat.verifypin

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.AutoLockSettingActivity
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.databinding.ActivityCreatePinBinding
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.WindowUtil
import com.devbeans.io.chat.utils.views.ViewUtil
import java.util.*

/**
 * This class is responsible for creating and verifying pins for the application.
 * It supports two different activities: [MainActivity] and [AutoLockSettingActivity]
 */
class CreatePinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatePinBinding
    private var pinOne = ""
    private var pinTwo = ""
    private var isFromSettings = false
    private var toggle = false
    private var atPage = 0
    lateinit var editTexts: Array<EditText>
    lateinit var editTextsTwo: Array<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowUtil.setStatusBarColor(window, AndroidUtil.getColor(R.color.bg_window_fill_color))
        binding = ActivityCreatePinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkFromSettings()
        if (isFromSettings) {
            initViews()
        }

        setupListeners()
    }

    /**
     * Sets up the necessary listeners for the views in the activity.
     */
    private fun setupListeners() {
        // Request focus for the first pin view
        ViewUtil.focusAndShowKeyboard(binding.pinView.pinDigit1)
        setupEditTexts()
        clearTextFirst()


        // Set click listeners for buttons
        binding.buttonNext.setOnClickListener {
            performNext()
        }
        binding.buttonVerify.setOnClickListener {
            performVerify()
        }
        binding.ivBack.setOnClickListener {
            atPage--
            initViews()
            clearTextFirst()
        }
    }

    /**
     * Verifies the second pin entered by the user.
     * If the pins match, save the pin and move to the main activity.
     */
    private fun performVerify() {
        val pin2 = getPinTwo() ?: ""

        if (pin2.isNotEmpty() && pin2.length >= 4) {
            pinTwo = pin2
            if (pinOne == pinTwo) {
                toggle = false
                val check = AppSession.put(KEY_PIN, pinTwo)
                if (check) {
                    pinOne = ""
                    pinTwo = ""
                    clearTextFirst()
                    clearTextTwo()
                }
                startActivity(Intent(this@CreatePinActivity, MainActivity::class.java))
                finish()
            } else {
                Notify.Toast("Pin not matched!")
            }
        } else {
            showErrorTwo()
        }
    }

    /**
     * Handles the next action based on the current state of the application.
     * If the activity is launched from settings, verify the pin.
     * Otherwise, set up the views for pin creation.
     */
    private fun performNext() {
        if (isFromSettings) {
            verifyPinFromSettings()
        } else {
            val pin1 = getPinFirst() ?: ""
            if (pin1.isNotEmpty() && pin1.length >= 4) {
                pinOne = pin1
                setupPinCreationViews()
            } else {
               showErrorFirst()
            }
        }
    }

    /**
     * Verifies the pin entered by the user when the activity is launched from settings.
     */
    private fun verifyPinFromSettings() {
        val verifyPin = getPinFirst() ?: ""
        if (verifyPin.isNotEmpty() && verifyPin.length >= 4) {
            handlePages(verifyPin)
        } else {
            showErrorFirst()
        }
    }

    /**
     * Handles the different pages/states for the pin verification process.
     * @param verifyPin The entered pin to be verified.
     */
    private fun handlePages(verifyPin: String) {
        when (atPage) {
            0 -> if (verifyPin.equals(AppSession.get(KEY_PIN), ignoreCase = true)) {
                atPage++
                clearTextFirst()
                initViews()
            } else {
                Notify.Toast("Wrong pin Entered")
                clearTextFirst()
            }

            1 -> {
                pinOne = verifyPin
                atPage++
                clearTextFirst()
                initViews()
            }

            2 -> {
                pinTwo = verifyPin
                clearTextFirst()
                initViews()
                if (pinOne == pinTwo) {
                    atPage++
                    val check = AppSession.put(KEY_PIN, pinTwo)
                    if (check) {
                        pinOne = ""
                        pinTwo = ""
                        clearTextFirst()
                        clearTextTwo()
                        finish()
                        Notify.Toast("Pin Changed")
                    }
                } else {
                    clearTextFirst()
                    Notify.Toast("Pin Don't Match")
                }
            }
        }
    }

    /**
     * Sets up the views for pin creation process.
     */
    private fun setupPinCreationViews() {
        binding.pinLayout1.visibility = View.GONE
        toggle = true

        binding.pinLayout2.visibility = View.VISIBLE
        if (toggle) {
            ViewUtil.focusAndShowKeyboard(binding.pinView2.pinDigit1)
            binding.tvTitleToolbar.text = AndroidUtil.getString(R.string.confirm_new_pin)
        }
    }

    /**
     * Initializes the views based on the current state of the activity.
     */
    private fun initViews() {
        binding.ivBack.visibility = if (isFromSettings) View.VISIBLE else View.GONE
        setupEditTexts()
        clearTextFirst()
        when (atPage) {
            -1 -> onBackPressed()
            0 -> {
                binding.tvTitleToolbar.text = ""
                binding.tvCreatePinTitle.text = AndroidUtil.getString(R.string.verify_pin)
                binding.tvCreatePin.text = AndroidUtil.getString(R.string.veryfy_pin_note)
                binding.buttonNext.text = AndroidUtil.getString(R.string.verify)
            }

            1 -> {
                binding.tvTitleToolbar.text = ""
                binding.tvCreatePinTitle.text = AndroidUtil.getString(R.string.create_new_pin)
                binding.tvCreatePin.text = ""
                binding.buttonNext.text = AndroidUtil.getString(R.string.next)
            }

            2 -> {
                binding.tvTitleToolbar.text = ""
                binding.tvCreatePinTitle.text = AndroidUtil.getString(R.string.confirm_new_pin)
                binding.tvCreatePin.text = ""
                binding.buttonNext.text = AndroidUtil.getString(R.string.change_pin)
            }
        }
    }

    private fun setupEditTexts() {


        editTexts = arrayOf(
            binding.pinView.pinDigit1,
            binding.pinView.pinDigit2,
            binding.pinView.pinDigit3,
            binding.pinView.pinDigit4
        )

        editTextsTwo = arrayOf(
            binding.pinView2.pinDigit1,
            binding.pinView2.pinDigit2,
            binding.pinView2.pinDigit3,
            binding.pinView2.pinDigit4
        )

        for (i in editTexts.indices) {

            editTexts[i].apply {
                setBackgroundResource(R.drawable.ic_bg_edit_unselect)

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
                            performNext()
                            true
                        }

                        else -> false
                    }
                }
            }
        }


        for (i in editTextsTwo.indices) {

            editTextsTwo[i].apply {
                setBackgroundResource(R.drawable.ic_bg_edit_unselect)

                addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable) {
                        setBackgroundResource(if (s.isNotEmpty() || hasFocus()) R.drawable.ic_bg_edit_select else R.drawable.ic_bg_edit_unselect)
                        if (s.isNotEmpty() && i < editTextsTwo.size - 1) {
                            editTextsTwo[i + 1].requestFocus()
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

                    }
                })

                setOnKeyListener { _, keyCode, event ->
                    if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                        if (text.isEmpty() && i > 0) {
                            editTextsTwo[i - 1].requestFocus()
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
                            performVerify()
                            true
                        }

                        else -> false
                    }
                }
            }
        }
    }


    fun clearTextFirst() {
        for (i in editTexts.indices) {
            editTexts[i].apply {
                setText("")
            }
        }
    }

    fun clearTextTwo() {
        for (i in editTextsTwo.indices) {
            editTextsTwo[i].apply {
                setText("")
            }
        }
    }

    fun showErrorFirst() {
        editTexts.last().setError("Required...")
    }
    fun showErrorTwo() {
        editTextsTwo.last().setError("Required...")
    }

    fun getPinFirst(): String {
        return editTexts.joinToString(separator = "") { it.text.toString() }
    }

    fun getPinTwo(): String {
        return editTextsTwo.joinToString(separator = "") { it.text.toString() }
    }

    /**
     * Determines if the activity was launched from the settings.
     */
    private fun checkFromSettings() {
        if (intent != null) {
            isFromSettings = intent.hasExtra(AutoLockSettingActivity.FROM_SETTINGS)
            atPage = 0
        }
    }

    override fun onBackPressed() {
        if (isFromSettings) {
            if (atPage == -1) super.onBackPressed()
        } else {
            if (toggle) {
                toggle = false
                binding.tvTitleToolbar.text = AndroidUtil.getString(R.string.create_new_pin)
                binding.pinLayout1.visibility = View.VISIBLE
                binding.pinLayout2.visibility = View.GONE
            }
        }
    }

    companion object {
        const val KEY_PIN = "com.chat.pin"
    }
}


