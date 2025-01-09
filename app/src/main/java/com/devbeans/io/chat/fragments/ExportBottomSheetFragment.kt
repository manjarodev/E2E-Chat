package com.devbeans.io.chat.fragments

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.databinding.FragmentBottomExportProgressDialogBinding
import com.devbeans.io.chat.utils.BottomSheetUtil.show
import com.devbeans.io.chat.utils.BottomSheetUtil
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.fragments.ExportBottomSheetFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.Exception
import java.util.*

/**
 * A BottomSheetDialogFragment used for showing a progress dialog while exporting contacts.
 */
class ExportBottomSheetFragment : BottomSheetDialogFragment() {

    // View binding for the fragment
    private var binding: FragmentBottomExportProgressDialogBinding? = null

    /**
     * Called to create the dialog displayed by this fragment.
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireActivity(), R.style.MyTransparentBottomSheetDialogTheme)
    }

    /**
     * Called to create the view hierarchy associated with the fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the view using view binding
        if (binding == null) {
            binding = FragmentBottomExportProgressDialogBinding.inflate(inflater, container, false)
        }
        return binding!!.root
    }

    /**
     * Shows the fragment.
     */
    override fun show(manager: FragmentManager, tag: String?) {
        // Call the show method on the fragment passing the tag and this instance of the fragment
        show(manager, tag, this)
    }

    /**
     * Called after the view has been created.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Thread {
            var progress = 0
            // Show progress
            while (progress < 100) {
                progress += 1
                val finalProgress = progress
                // Update progress on the UI thread
                requireActivity().runOnUiThread {
                    binding!!.setupProgress.progress = finalProgress
                    binding!!.tvProgress.text = String.format(Locale.getDefault(), "%s", "$finalProgress%")
                }
                try {
                    // Sleep for 100ms to slow down the progress update
                    Thread.sleep(100)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            if (progress == 100) {
                requireActivity().runOnUiThread {
                    // Hide the export note
                    binding!!.tvExportNote.visibility = View.GONE
                    // Set the export done image
                    binding!!.ivImage.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_export_done))
                    // Set the title to "Contacts exported"
                    binding!!.tvTitle.text = AndroidUtil.getString(R.string.contacts_exported)
                    // Use a Handler to post a Runnable after a delay of 500ms
                    Handler(Looper.getMainLooper()).postDelayed(Runnable { dismiss() }, 500)
                }
            }
        }.start()
    }

    /**
     * Called when the view associated with the fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        /**
         * Shows the fragment.
         *
         * @param manager The FragmentManager to use for showing the fragment.
         */
        fun show(manager: FragmentManager) {
            val fragment = ExportBottomSheetFragment()
            fragment.show(manager, BottomSheetUtil.STANDARD_BOTTOM_SHEET_FRAGMENT_TAG)
        }

        /**
         * Dismisses the fragment.
         *
         * @param manager The FragmentManager to use for dismissing the fragment.
         */
        fun dismiss(manager: FragmentManager) {
            val fragment = manager.findFragmentByTag(BottomSheetUtil.STANDARD_BOTTOM_SHEET_FRAGMENT_TAG)
            if (fragment is ExportBottomSheetFragment) {
                fragment.dismissAllowingStateLoss()
            }
        }
    }
}
