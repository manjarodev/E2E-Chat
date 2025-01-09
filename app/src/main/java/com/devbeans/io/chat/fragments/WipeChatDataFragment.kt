package com.devbeans.io.chat.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatSettingsActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.databinding.CustomDeleteMessageBinding
import com.devbeans.io.chat.databinding.FragmentWipeChatDataBinding
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Notify


class WipeChatDataFragment : Fragment() {

    var mBinding: FragmentWipeChatDataBinding? = null
    private var mCreateDialog: AlertDialog? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = FragmentWipeChatDataBinding.inflate(inflater, viewGroup, false)
        (activity as ChatSettingsActivity).supportActionBar?.title =
            AndroidUtil.getString(R.string.wipe_chat_and_data)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listeners()

    }

    private fun listeners() {
        mBinding?.apply {
            lvClearChatHistory.setOnClickListener {
                if (MainApp.appContext?.conversationsDao!!.allConversations != null && MainApp.appContext?.conversationsDao!!
                        .allConversations.size > 0
                ) {
                    showDeleteDialog()
                } else {
                    Notify.Toast(AndroidUtil.getString(R.string.chats_empty))
                }
            }
            lvWipeEverything.setOnClickListener {
                requireActivity().findNavController(R.id.fragment_container_settings)
                    .navigate(R.id.action_wipeChatDataFragment_to_agreementSettings)
            }
        }
    }

    //************************************************************
    private fun showDeleteDialog()
    //************************************************************
    {
        val alertCustomdialog =
            LayoutInflater.from(requireActivity()).inflate(R.layout.custom_delete_message, null)
        //initialize alert builder
        val deleteDialogBinding = CustomDeleteMessageBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(requireActivity())
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(deleteDialogBinding.root)
        mCreateDialog = alert.create()
        deleteDialogBinding.ivClose.visibility = View.VISIBLE
        deleteDialogBinding.ivAlert.visibility = View.VISIBLE
        deleteDialogBinding.tvTitle.text = AndroidUtil.getString(R.string.wipe_chat)
        deleteDialogBinding.tvDeleteNotification.text =
            AndroidUtil.getString(R.string.wipe_chat_notification_dialog)
        deleteDialogBinding.btnDeleteForMe.text = AndroidUtil.getString(R.string.yes_proceed)
        deleteDialogBinding.btnCancel.text = AndroidUtil.getString(R.string.cancel)
        deleteDialogBinding.btnDeleteForMe.background =
            AndroidUtil.getDrawable(R.drawable.bg_button_backup_red)
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //finally show the dialog box in android all
        mCreateDialog!!.show()
        deleteDialogBinding.btnDeleteForEveryone.visibility = View.GONE
        deleteDialogBinding.btnDeleteForMe.setOnClickListener {

//            if (MainApp.appContext?.conversationsDao!!.allConversations != null && MainApp.appContext?.conversationsDao!!
//                    .allConversations.size > 0
//            ) {
//                requireActivity().startService(
//                    Intent(
//                        MainApp.appContext,
//                        ChatClearBackgroundService::class.java
//                    )
//                )
//            }
            mCreateDialog!!.dismiss()
            val args = Bundle()
            args.putString(
                Constants.KEYS.INTENT_FROM_WIPE_DATA,
                Constants.KEYS.INTENT_FROM_WIPE_DATA
            )
            requireActivity().findNavController(R.id.fragment_container_settings)
                .navigate(R.id.action_wipeChatDataFragment_to_deleteSettings, args)

        }
        deleteDialogBinding.btnDeleteForEveryone.setOnClickListener {

        }
        deleteDialogBinding.btnCancel.setOnClickListener { mCreateDialog!!.dismiss() }

        deleteDialogBinding.ivClose.setOnClickListener {
            mCreateDialog!!.dismiss()
        }
    }
}