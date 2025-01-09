package com.devbeans.io.chat.fragments


import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.views.CustomExpireTimerSelectorView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Dialog for selecting a custom expire timer value.
 */
class CustomExpireTimerSelectDialog : DialogFragment() {

    //    private lateinit var viewModel: ExpireTimerSettingsViewModel
    private lateinit var selector: CustomExpireTimerSelectorView

    override fun onStart() {
        super.onStart()
        val dialog = dialog as AlertDialog

        val marginSize = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._10sdp) // Replace with your actual margin size
        val marginMinusSize = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._minus10sdp) // Replace with your actual margin size
        val cancelMargin = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._20sdp) // Replace with your actual margin size
        val bottomMargin = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._5sdp) // Replace with your actual margin size
        val typeface = Typeface.createFromAsset(requireContext().assets, "fonts/astronomus_regular.ttf")

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).apply {
            val params = layoutParams as LinearLayout.LayoutParams
            params.weight = 1f
            params.setMargins(marginSize, 0, marginSize, bottomMargin)
            layoutParams = params
            isAllCaps = false
            textSize = 15f
            setTypeface(typeface)
            setTextColor(ContextCompat.getColor(context, R.color.deep_black))
            background = ContextCompat.getDrawable(context, R.drawable.bg_button_add)
        }

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).apply {
            val params = layoutParams as LinearLayout.LayoutParams
            params.weight = 1f
            params.setMargins(marginMinusSize, 0, 0, bottomMargin)
            layoutParams = params
            isAllCaps = false
            textSize = 15f
            setTypeface(typeface)
            setTextColor(ContextCompat.getColor(context, R.color.white))
            background = ContextCompat.getDrawable(context, R.drawable.bg_button_cancel)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView: View = LayoutInflater.from(context)
            .inflate(R.layout.custom_expire_timer_select_dialog, null, false)
        selector = dialogView.findViewById(R.id.custom_expire_timer_select_dialog_selector)

        val builder =
            MaterialAlertDialogBuilder(requireContext(), R.style.Chat_ThemeOverlay_Dialog_Rounded)

        return builder.setTitle(Html.fromHtml(String.format("<font color='#FFFFFF'>%s</font>",AndroidUtil.getString(R.string.ExpireTimerSettingsFragment__custom_time))))
            .setView(dialogView)
            .setPositiveButton(R.string.ExpireTimerSettingsFragment__set) { _, _ ->
                selector.getTimer()
                sendCommand(selector.getTimer())
            }
            .setNegativeButton(android.R.string.cancel, null)
            .create()

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

    }

    private fun sendCommand(command: Int) {

//        Log.d("sender", "Broadcasting message")
        val intent = Intent("disappearing_command_receive")
        // You can also include some extra data.
        intent.putExtra("command", command)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

    }

    @Suppress("DEPRECATION")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(
//            NavHostFragment.findNavController(this)
//                .getViewModelStoreOwner(R.id.app_settings_expire_timer)
//        )
//            .get(ExpireTimerSettingsViewModel::class.java)
//
//        viewModel.state.observe(this) { selector.setTimer(it.currentTimer) }
        if (!requireConversationExpireTime().equals(0) && !requireConversationExpireTime().equals(
                -1
            )
        ) {
            selector.setTimer((requireConversationExpireTime() / 1000).toInt())
        }

    }

    private fun requireConversationExpireTime(): Long = requireNotNull(
        requireArguments()!!.getLong(
            ARG_EXPIRE_TIME
        )
    )

    companion object {
        private const val DIALOG_TAG = "CustomTimerSelectDialog"
        private const val ARG_EXPIRE_TIME = "arg.expire.time"

        fun show(fragmentManager: FragmentManager, expiryTime: Long) {
            CustomExpireTimerSelectDialog().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_EXPIRE_TIME, expiryTime)
                }
                show(fragmentManager, DIALOG_TAG)
            }

        }
    }
}