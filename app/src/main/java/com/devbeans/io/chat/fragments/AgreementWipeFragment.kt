package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatSettingsActivity
import com.devbeans.io.chat.databinding.FragmentAgreementWipeBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.extensions.runOnUiThread


/**
 * This fragment is responsible for wiping out agreement-related data.
 * It has a checkbox that enables or disables the home button on the action bar and sets the 'Proceed' button's visibility.
 * Also, it has functionality to navigate to delete settings when the 'Proceed' button is clicked.
 * It listens for the back button press event and performs appropriate action.
 */
class AgreementWipeFragment : Fragment() {
    // Nullable ViewBinding variable
    private var mBinding: FragmentAgreementWipeBinding? = null

    // Inflating the view in onCreateView method
    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        // Inflate the view using ViewBinding
        mBinding = FragmentAgreementWipeBinding.inflate(inflater, viewGroup, false)

        // Safely cast activity to ChatSettingsActivity and set the action bar title
        (activity as? ChatSettingsActivity)?.supportActionBar?.title = ""

        // Return the root view
        return mBinding?.root
    }

    // Setting up listeners in onViewCreated method
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listeners()
        handleBackPressed()
    }

    /**
     * Initialize listeners for UI elements
     */
    private fun listeners() {
        mBinding?.apply {
            // Set on checked change listener for checkbox
            checkAgree.setOnCheckedChangeListener { _, isChecked ->
                // Safely cast activity to ChatSettingsActivity and apply the configurations
                (activity as? ChatSettingsActivity)?.supportActionBar?.apply {
                    // disable the button
                    setHomeButtonEnabled(!isChecked)
                    // remove the left caret
                    setDisplayHomeAsUpEnabled(!isChecked)
                    // remove the icon
                    setDisplayShowHomeEnabled(!isChecked)
                }

                // Set alpha and clickable status for lvProceed1 based on checkbox state
                lvProceed1.alpha = if (isChecked) 1F else 0.4F
                lvProceed1.isClickable = isChecked
            }

            // Set on click listener for lvProceed1
            lvProceed1.setOnClickListener {

                runOnUiThread {

                    // Navigate to delete settings
                    requireActivity().findNavController(R.id.fragment_container_settings)
                        .navigate(R.id.action_agreementSettings_to_deleteSettings)
                }
            }
        }
    }

    /**
     * Handle back press action
     */
    private fun handleBackPressed() {
        // Create OnBackPressedCallback
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    // Handle the back button event
                }
            }

        // Register the callback to the activity's onBackPressedDispatcher
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), callback)
    }
}
