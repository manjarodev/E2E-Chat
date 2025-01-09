package com.devbeans.io.chat.fragments

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.ContactChoiceAdapter
import com.devbeans.io.chat.databinding.FragmentBottomSheetContactChoiceBinding
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.ContactChoice
import com.devbeans.io.chat.utils.BottomSheetUtil
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.viewmodels.ContactChoiceViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A BottomSheetDialogFragment class responsible for presenting contact choices and handling user selection.
 *
 * @param viewModel The ContactChoiceViewModel used to handle contact selections.
 */
class ContactChoiceBottomSheet(private val viewModel: ContactChoiceViewModel) :
    BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetContactChoiceBinding
    private var listener: OnImportCompletedListener? = null
    private var currentChoiceIndex = 0
    private var totalChoices = 0

    fun setOnImportCompletedListener(listener: OnImportCompletedListener) {
        this.listener = listener
    }

    /**
     * Called to create the dialog displayed by this fragment.
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireActivity(), R.style.MyTransparentBottomSheetDialogTheme)
    }


    // Inflates the layout and initializes the binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetContactChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Sets up the view and observes contact choices from the ViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.contactChoices.observe(viewLifecycleOwner) { choices ->
            if (choices.isNotEmpty()) {
                totalChoices = choices.size
                displayNextChoice()
            } else {
                dismiss()
            }
        }
    }

    // Shows the bottom sheet
    override fun show(manager: FragmentManager, tag: String?) {
        BottomSheetUtil.show(manager, tag, this)
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    /**
     * Displays the next contact choice in the list.
     */
    private fun displayNextChoice() {
        val choices = viewModel.contactChoices.value ?: return
        if (currentChoiceIndex >= choices.size) {
            binding.apply {
                lvMain.visibility = View.GONE
                lvDone.visibility = View.VISIBLE
            }
            // Schedule onImportCompleted and dismiss() to be called after 500ms
            Handler(Looper.getMainLooper()).postDelayed({
                listener?.onImportCompleted()
                dismiss()
            }, 500)
            return
        }
        val choice = choices[currentChoiceIndex]
        showChoicePair(choice)
        currentChoiceIndex++
        binding.tvCount.text = "$currentChoiceIndex OF $totalChoices"
    }

    /**
     * Displays the given contact choice pair and sets up click listeners for user selection.
     *
     * @param choicePair The contact choice pair to display.
     */
    private fun showChoicePair(choicePair: ContactChoice) {
        binding.apply {
            tvKeepA.isSelected = false
            tvKeepB.isSelected = false
            tvContactIdDb.text = "ID:${choicePair.contactFromDb.chatUserId?.trim()}"
            tvContactIdFile.text = "ID:${choicePair.contactFromFile.chatUserId?.trim()}"

            tvContactNameDb.text = choicePair.contactFromDb.name?.trim()
            tvContactNameFile.text = choicePair.contactFromFile.name?.trim()

            val clickListener = { selectedView: TextView, selectedContact: Contact ->
                viewModel.onContactChoiceSelected(selectedContact)
                selectedView.isSelected = true
                val otherView = if (selectedView == tvKeepA) tvKeepB else tvKeepA
                otherView.isSelected = false

                tvKeepA.isClickable = false
                tvKeepB.isClickable = false

                selectedView.postDelayed({
                    displayNextChoice()
                    tvKeepA.isClickable = true
                    tvKeepB.isClickable = true
                }, 400)
            }

            tvKeepA.setOnClickListener { clickListener(tvKeepA, choicePair.contactFromDb) }
            tvKeepB.setOnClickListener { clickListener(tvKeepB, choicePair.contactFromFile) }
        }


    }

    interface OnImportCompletedListener {
        fun onImportCompleted()
    }

    /**
     * Used for events when bottom sheet is dismissed
     */
    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        runOnUiThread {
            requireActivity().finish()
        }
    }
}

