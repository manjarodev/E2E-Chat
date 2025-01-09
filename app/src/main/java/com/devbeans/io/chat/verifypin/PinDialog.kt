package com.devbeans.io.chat.verifypin

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.chaos.view.PinView
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ResetLogoutTimer
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.WindowUtil
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.utils.views.ViewUtil
import java.util.*

/**
 * Dialog used to inflate dialog screen on
 * @see [LogOutTimerUtil]
 * @see [BaseActivity.onPause] //if screen in locked
 * @see [com.devbeans.io.chat.fragments.HomeFragment] //lock is clicked and chat locked
 */
class PinDialog {
    private var buttonVerify: LinearLayout? = null
    private var tvAttempts: TextView? = null
    private var pinView: PinView? = null
    private var dialog: Dialog? = null
    lateinit var editTexts: Array<EditText>

    /**
     * Create a Dialog upon with given context of Activity
     */
    fun createPinDialog(context: Context?, from: String) {
        Log.e(TAG, "createPinDialog: $from")
        try {
            dialog = Dialog(context!!, R.style.MyPinDialogStyle)
            dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            WindowUtil.setStatusBarColor(
                dialog!!.window!!,
                AndroidUtil.getColor(R.color.bg_window_fill_color)
            )
            dialog!!.window!!.setBackgroundDrawableResource(R.color.bg_window_fill_color)
            val window = dialog!!.window
            val wlp = window!!.attributes
            wlp.gravity = Gravity.CENTER
//            wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
            window.attributes = wlp
            dialog!!.setContentView(R.layout.fragment_verify_pin)
            dialog!!.setCancelable(false)
            dialog!!.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            dialog!!.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
            AppSession.put(Constants.KEYS.WAS_SHOWING, true)
            dialog!!.show()

            //pause player if dialog appear
//            stopPlayerWhenDialogAppear();
            if (playerAction != null) {
                playerAction.pausePlayer(true)
            }


//            Log.e(TAG, "createPinDialogAppSession: " + !dialog.isShowing());
            AppSession.put(Constants.isDialog, !dialog!!.isShowing)
            AppSession.put(Constants.isDialogAppLock, dialog!!.isShowing)
            tvAttempts = dialog!!.findViewById(R.id.tvAttempts)
//            pinView = dialog!!.findViewById<PinView>(R.id.pinView)
            setupEditTexts(dialog!!)
            ViewUtil.focusAndShowKeyboard(editTexts[0])
            //            TextInputEditText pinView = dialog.findViewById(R.id.pinView_2);
//            TextInputLayout pinLayout = dialog.findViewById(R.id.pinLayout);
            buttonVerify = dialog!!.findViewById(R.id.buttonVerify)
//            pinView?.addTextChangedListener(object : TextWatcher {
//                override fun beforeTextChanged(
//                    s: CharSequence?,
//                    start: Int,
//                    count: Int,
//                    after: Int
//                ) {
//
//                }
//
//                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                    pinView?.setLineColor(AndroidUtil.getColor(R.color.blue))
//                    buttonVerify?.isClickable = s?.length == 4
//                    buttonVerify?.alpha = if (s?.length == 4) 1F else 0.4F
//                }
//
//                override fun afterTextChanged(s: Editable?) {
//
//                }
//
//            })
//            pinView?.setOnEditorActionListener { v, actionId, event ->
//                return@setOnEditorActionListener when (actionId) {
//                    EditorInfo.IME_ACTION_DONE -> {
////                    sendMessage()
//                        performVerify()
//                        true
//                    }
//
//                    else -> false
//                }
//            }


            buttonVerify?.setOnClickListener { v: View? ->
                performVerify()
//                Log.e(TAG, "createPinDialog: ");

            }
        } catch (e: Exception) {
//            e.printStackTrace();
            Log.e(TAG, "createPinDialogError: ", e)
        }
    }

    private fun performVerify() {
        val inputPin = getPin()
        val finalPin = AppSession.get(CreatePinActivity.KEY_PIN)

//                Log.e(TAG, "createPinDialog: " + inputPin );
        if (!inputPin.isEmpty()) {
            if (inputPin == finalPin) {
                dialog!!.dismiss()
                if (playerAction != null) {
                    playerAction.pausePlayer(false)
                }
                AppSession.put(Constants.isDialog, true)
                AppSession.put(Constants.isDialogAppLock, true)
                AppSession.put(Constants.LOCK.KEY_KEEP_LOCK, false)
                AppSession.put(Constants.KEYS.WAS_SHOWING, false)
                resetLogoutTimer!!.onResetTimer()
                //                        Notify.Toast("success");
            } else {
                attempts = attempts!! - 1
                clearText()
                if (attempts!! > 0) {
//                    pinView?.setText("")
//                    pinView?.setLineColor(AndroidUtil.getColor(R.color.dark_red))
                    tvAttempts!!.visibility = View.VISIBLE

                    tvAttempts!!.text = String.format(
                        "%s",
                        attempts.toString() + AndroidUtil.getString(R.string.attempts_left)
                    )
                } else {
                    Log.e(TAG, "showPinDialog: destroy")
                    val sendMessage = Intent()
                    sendMessage.putExtra("message", appContext!!.packageName)
                    sendMessage.action = "com.destroy.chat.app"
                    sendMessage.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                    appContext!!.sendBroadcast(sendMessage)
                }
            }
        } else {
//            pinView!!.error = "Required.."
            showError()
        }
    }

    fun destroyDialog() {
        if (dialog != null) {
            dialog!!.dismiss()
            dialog = null
        }
    }

    interface PlayerAction {
        fun pausePlayer(isDialogVisible: Boolean)
    }

    private fun setupEditTexts(dialog: Dialog) {

        val view: LinearLayout = dialog.findViewById(R.id.pinView)
        val ed1: EditText = view.findViewById(R.id.pin_digit_1)
        val ed2: EditText = view.findViewById(R.id.pin_digit_2)
        val ed3: EditText = view.findViewById(R.id.pin_digit_3)
        val ed4: EditText = view.findViewById(R.id.pin_digit_4)

        editTexts = arrayOf(
            ed1,
            ed2,
            ed3,
            ed4
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

                        buttonVerify?.isClickable = getPin().length == 4
                        buttonVerify?.alpha = if (getPin().length == 4) 1F else 0.4F
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
                            performVerify()
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

    companion object {
        val TAG = PinDialog::class.java.simpleName
        private var attempts: Int? = null
        private var resetLogoutTimer: ResetLogoutTimer? = null
        private val playerAction: PlayerAction? = null

        @SuppressLint("StaticFieldLeak")
        private val INSTANCE: PinDialog? = null
        fun dialogINSTANCE(): PinDialog {
            return INSTANCE ?: PinDialog()
        }

        fun with(): PinDialog {
            return PinDialog()
        }

        fun setResetLogoutTimer(resetLogoutTimer: ResetLogoutTimer?) {
            Companion.resetLogoutTimer = resetLogoutTimer
        }
    }

    init {
        attempts = AppSession.getInt(Constants.SETTINGS.ACTION_MAX_ATTEMPTS, 10)
    }


}