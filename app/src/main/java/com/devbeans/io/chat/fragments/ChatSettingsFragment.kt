package com.devbeans.io.chat.fragments

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatSettingsActivity
import com.devbeans.io.chat.adapters.DialogSettingsAdapter
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ChatSettingsCallback
import com.devbeans.io.chat.databinding.CustomDeleteMessageBinding
import com.devbeans.io.chat.databinding.CustomSelectorDailogBinding
import com.devbeans.io.chat.databinding.FragmentChatSettingsBinding
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.services.ChatClearBackgroundService
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.SettingsValues
import com.devbeans.io.chat.utils.ThreadUtil
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.viewmodels.ChatSettingsViewModel

class ChatSettingsFragment : Fragment(), ChatSettingsCallback {

    private var mBinding: FragmentChatSettingsBinding? = null
    private var mViewModel: ChatSettingsViewModel? = null
    private var adapter: DialogSettingsAdapter? = null
    private var mKeepChatOptions = AndroidUtil.getStringArray(R.array.keep_chat)
    private var mFontSizeOptions = AndroidUtil.getStringArray(R.array.font_size)
    private var mEmojiSizeptions = AndroidUtil.getStringArray(R.array.emoji_size)
    private var keepChatOption: List<String>? = null
    private var fontEmojiSizeOption: MutableList<String>? = null
    private var mCreateDialog: AlertDialog? = null
    private val TAG = Log.tag(ChatSettingsFragment::class.java)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        bundle: Bundle?
    ): View {
        (activity as ChatSettingsActivity).supportActionBar?.title = "Chat"
        mBinding = FragmentChatSettingsBinding.inflate(inflater, container, false)
        this.mViewModel =
            ViewModelProvider(
                requireActivity(),
                ChatSettingsViewModel.Factory() as ViewModelProvider.Factory
            ).get(
                ChatSettingsViewModel::class.java
            )
        keepChatOption = ArrayList(mutableListOf(*mKeepChatOptions))
        fontEmojiSizeOption = ArrayList(mutableListOf(*mFontSizeOptions))
        (fontEmojiSizeOption as ArrayList<String>).addAll(mutableListOf(*mEmojiSizeptions))


        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        listeners()
    }

    /**
     * This method sets up the click listeners for the chat settings options.
     */
    private fun listeners() {
        mBinding?.let { binding ->
            binding.layoutKeepChat.setOnClickListener { showCustomDialog(0) }
            binding.lvWipe.setOnClickListener {
                requireActivity().findNavController(R.id.fragment_container_settings)
                    .navigate(R.id.action_ChatSettingsFragment_to_wipeChatDataFragment)
//                showDeleteDialog()
            }
            binding.checkEnterToSendMessages.setOnCheckedChangeListener { _, check ->
                SettingsValues.setEnterKeySends(check)
            }
            binding.layoutFontEmoji.setOnClickListener {
                showCustomDialog(7)
            }

            binding.checkReadReceipts.setOnCheckedChangeListener { _, check ->
                SettingsValues.setMessageReadReceipts(check)
                handleOtherReceipts(binding, check)
            }


            binding.checkReadReceiptsUnknown.setOnCheckedChangeListener { _, check ->
                SettingsValues.setMessageReadReceiptsUnknown(check)
            }

            binding.checkReadReceiptsPrivacy.setOnCheckedChangeListener { _, check ->
                SettingsValues.setMessageReadReceiptsPrivacy(check)
            }


            binding.layoutWallpaperColor.setOnClickListener {

                requireActivity().findNavController(R.id.fragment_container_settings)
                    .navigate(R.id.action_ChatSettingsFragment_to_wallpaperChatFragment)
            }


            binding.layoutImportExport.setOnClickListener {
                handeShowImportExport()
            }
        }

    }


    /**
     * This method is used for handling the events that are used in import/export
     *
     */
    private fun handeShowImportExport() {
        runOnUiThread {
            // Inflate the custom dialog layout
            val dialogView =
                LayoutInflater.from(requireContext()).inflate(R.layout.custom_delete_message, null)
            val deleteDialogBinding = CustomDeleteMessageBinding.bind(dialogView)

            // Initialize the alert dialog builder and set the custom layout to it
            val alertBuilder = AlertDialog.Builder(requireActivity())
                .setView(deleteDialogBinding.root)

            initViewsDialog(deleteDialogBinding)

            // Create the dialog and make it transparent with no app bar
            val dialog = alertBuilder.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            // Display the dialog
            dialog.show()


            //this button btnDeleteForMe is used for import event handling
            deleteDialogBinding.btnDeleteForMe.setOnClickListener {
                ImportBottomSheetFragment.show(parentFragmentManager)
                dialog.dismiss()
            }


            //this button btnDeleteForEveryone is used for export event handling
            deleteDialogBinding.btnDeleteForEveryone.setOnClickListener {
                ExportBottomSheetFragment.show(parentFragmentManager)
                dialog.dismiss()
            }

            // Set a click listener for the "Cancel" button
            deleteDialogBinding.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    /**
     * Initializes the views of the custom delete message dialog.
     *
     * @param deleteDialogBinding the binding object for the dialog views
     */
    private fun initViewsDialog(deleteDialogBinding: CustomDeleteMessageBinding) {
        deleteDialogBinding.apply {
            tvTitle.text = AndroidUtil.getString(R.string.import_dialog)
            tvDeleteNotification.text = AndroidUtil.getString(R.string.export_dialog)
            btnDeleteForEveryone.text = AndroidUtil.getString(R.string.export_button)
            btnDeleteForMe.text = AndroidUtil.getString(R.string.import_button)
        }
    }



    /**
     * This method handles the visibility of read receipts options based on the value of check.
     * If check is true, it will fadeIn the read receipt options, otherwise it will fadeOut the options.
     *
     * @param binding the FragmentChatSettingsBinding object
     * @param check the boolean value which determines the visibility of read receipts options
     */
    private fun handleOtherReceipts(binding: FragmentChatSettingsBinding, check: Boolean) {
        // Disable the click event of the read receipt options when check is false
        arrayOf(binding.checkReadReceiptsPrivacy, binding.checkReadReceiptsUnknown).forEach {
            it.isClickable = check
            if (!check) {
                it.isChecked = false
            }
        }

        // Fade in or fade out the read receipt options based on the value of check
        if (check) {
            Utills.fadeInTV(binding.tvReadReceiptsUnknown)
            Utills.fadeInTV(binding.tvReadReceiptsPrivacy)
            Utills.fadeInNote(binding.tvReadReceiptsNoteUnknown)
            Utills.fadeInNote(binding.tvReadReceiptsNotePrivacy)
        } else {
            Utills.fadeOutTV(binding.tvReadReceiptsUnknown)
            Utills.fadeOutTV(binding.tvReadReceiptsPrivacy)
            Utills.fadeOutNote(binding.tvReadReceiptsNoteUnknown)
            Utills.fadeOutNote(binding.tvReadReceiptsNotePrivacy)
        }
    }


    /**
     * Shows a custom dialog based on the given type.
     *
     * @param type The type of dialog to show.
     */
    private fun showCustomDialog(type: Int) {
        val adapter = DialogSettingsAdapter(requireActivity(), this, type)

        val alertCustomDialog = LayoutInflater.from(requireActivity())
            .inflate(R.layout.custom_selector_dailog, null)
        val dialogBinding = CustomSelectorDailogBinding.bind(alertCustomDialog)

        val alert = AlertDialog.Builder(requireActivity())
            .setView(dialogBinding.root)
            .setCancelable(false)

        var titleResId: Int = R.string.keep_chats
        when (type) {
            0 -> {
                titleResId = R.string.keep_chats
                adapter.setSettingsList(keepChatOption!!)
            }
            1, 2, 4, 5, 6 -> {
                // Do nothing
            }
            7 -> {
                titleResId = R.string.select_font_size
                adapter.setSettingsList(fontEmojiSizeOption!!)
            }
            else -> {
                titleResId = R.string.keep_chats
            }
        }

        dialogBinding.tvTitle.text = AndroidUtil.getString(titleResId)
        dialogBinding.rvSelector.adapter = adapter
        dialogBinding.rvSelector.setHasFixedSize(true)

        val createDialog = alert.create()
        createDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        createDialog.show()

        dialogBinding.ivClose.setOnClickListener {
            createDialog.dismiss()
        }
    }


    /**
     * Initializes the chat settings views with their corresponding values.
     */
    private fun initViews() {
        mBinding?.let { binding ->
            binding.tvKeepChatNote.text =
                Utills.getKeepChatOptions(SettingsValues.getKeepChatTime())
            binding.checkEnterToSendMessages.isChecked = SettingsValues.getEnterKeySends()
            binding.checkReadReceipts.isChecked = SettingsValues.getMessageReadReceipts()
            binding.checkReadReceiptsUnknown.isChecked =
                SettingsValues.getMessageReadReceiptsUnknown()
            binding.checkReadReceiptsPrivacy.isChecked =
                SettingsValues.getMessageReadReceiptsPrivacy()

            val messageFontSize = SettingsValues.getMessageFontSize()
            val fontSizeStringRes = if (messageFontSize <= 22) {
                R.string.small
            } else {
                R.string.large
            }
            binding.tvFontEmojiNote.text = AndroidUtil.getString(fontSizeStringRes)
        }
    }


    override fun onSettingsClick(option: String, dataOff: Int) {}
    override fun onSettingsClick(position: Int, dataOff: Int) {
        when (dataOff) {
            0 -> {
                if (keepChatOption!![position].equals(
                        AndroidUtil.getString(R.string._1_day),
                        ignoreCase = true
                    )
                ) {
                    SettingsValues.setKeepChatTime(1)
                } else if (keepChatOption!![position].equals(
                        AndroidUtil.getString(R.string._30_day),
                        ignoreCase = true
                    )
                ) {
                    SettingsValues.setKeepChatTime(30)
                } else if (keepChatOption!![position].equals(
                        AndroidUtil.getString(R.string._60_day),
                        ignoreCase = true
                    )
                ) {
                    SettingsValues.setKeepChatTime(60)
                } else if (keepChatOption!![position].equals(
                        AndroidUtil.getString(R.string._90_day),
                        ignoreCase = true
                    )
                ) {
                    SettingsValues.setKeepChatTime(90)
                }


            }
            7 -> {
                if (position < 2) {
                    SettingsValues.setMessageFontSize(
                        when (position) {
                            0 -> {
                                22
                            }
                            else -> {
                                44
                            }
                        }
                    )
                } else {
                    SettingsValues.setEmojiFontSize(
                        when (position) {
                            2 -> {
                                22
                            }
                            3 -> {
                                42
                            }
                            else -> {
                                62
                            }
                        }
                    )
                }
            }

        }
        initViews()
        ThreadUtil.runOnMainDelayed({ mCreateDialog?.dismiss() }, 100)
    }


}