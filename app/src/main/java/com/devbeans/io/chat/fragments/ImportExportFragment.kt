package com.devbeans.io.chat.fragments


import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ImportExportActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.databinding.FragmentImportExportBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.FilePath
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.utils.views.ImportExportDialog
import java.io.File


class ImportExportFragment : Fragment(), ImportExportDialog.ImportExportDialogListener {

    private val token: String = "com.example.myapplication.Testing.action"
    private var mBinding: FragmentImportExportBinding? = null

    // Create an ActivityResultLauncher instance
    private lateinit var vaultActivityLauncher: ActivityResultLauncher<Intent>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        bundle: Bundle?
    ): View {
        (activity as ImportExportActivity).supportActionBar?.title =
            AndroidUtil.getString(com.devbeans.io.chat.R.string.import_export)
        mBinding = FragmentImportExportBinding.inflate(inflater, container, false)

        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        listeners()
    }


    /**
     * This method sets up the click listeners for the Import export.
     */
    private fun listeners() {
        mBinding?.let { binding ->
            binding.lvImport.setOnClickListener {
                // Show the custom dialog

                showImportExportDialog(true)
//                showDialog();
//                try {
//
//                    startVaultActivity()
//                } catch (e: Exception) {
//                    Log.e(javaClass.simpleName, "Error ${e.message}")
//                }

//                requireActivity().findNavController(R.id.fragment_container_settings)
//                    .navigate(R.id.action_ImportExportFragment_to_ImportListFragment)
            }

            binding.lvExport.setOnClickListener {


                runOnUiThread {
                    val rows = MainApp.appContext?.contactsDao?.allContacts!!
                    if (rows.isNotEmpty()) {
                        showImportExportDialog(false)
                    } else {
                        Notify.Toast("No contacts to export")
                    }


                }


//                requireActivity().findNavController(R.id.fragment_container_settings)
//                    .navigate(R.id.action_ImportExportFragment_to_ExportFragment)
            }


            // Register for result from the VaultActivity
            vaultActivityLauncher =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    // Check if the result is successful
                    if (result.resultCode == Activity.RESULT_OK) {
                        // Get the intent data
                        val data: Intent? = result.data

                        // Get the value of the "buttonClicked" extra from the intent data
                        val buttonClicked = data?.getBooleanExtra("buttonClicked", false) ?: false

                        // Check if button1 was clicked
                        if (buttonClicked) {
                            // Get the value of the "INTENT_URI_FROM_VAULT" extra from the intent data
                            val uri =
                                data?.getStringExtra(Constants.KEYS.INTENT_URI_FROM_VAULT) ?: ""
                            val parsedUri = Uri.parse(uri)
                            var file: File?

                            // Attempt to create the file from the content URI
                            try {
                                file = FilePath.contactFromContentUri(requireContext(), parsedUri)
                            } catch (e: Exception) {
                                // Log the error message if file creation fails
                                file = null
                                Log.e(
                                    javaClass.simpleName,
                                    "Error in Creating the Vault File ${e.message}"
                                )
                            }

                            // Check if file creation was successful
                            file?.let {
                                // Navigate to the ImportFragment and pass the file path as an argument
                                runOnUiThread {
                                    val bundle = Bundle().apply {
                                        putString(Constants.KEYS.INTENT_SELECTED_FILE, it.path)
                                    }

                                    requireActivity().findNavController(R.id.fragment_container_settings)
                                        .navigate(
                                            R.id.action_ImportExportFragment_to_ImportFragment,
                                            bundle
                                        )
                                }
                            } ?: run {
                                // Finish the activity if file creation failed
                                runOnUiThread {
                                    requireActivity().finish()
                                }
                            }

                        } else {
                            // Handle delete/back button click by finishing the activity
                            runOnUiThread {
                                requireActivity().finish()
                            }
                        }
                    }
                }

        }


    }

    private fun startVaultActivity() {
        // Create an Intent to start the SecondActivity
        val intent = Intent(token)

        // Use the ActivityResultLauncher to start the activity
        vaultActivityLauncher.launch(intent)
    }


    override fun onImportExportOptionSelected(isImport: Boolean, isInternal: Boolean) {
        if (isImport) {


            if (isInternal) {
                Notify.Toast("Coming Soon")
                //                try {
//
//                    startVaultActivity()
//                } catch (e: Exception) {
//                    Log.e(javaClass.simpleName, "Error ${e.message}")
//                }
                // Handle import internal option
            } else {
                requireActivity().findNavController(R.id.fragment_container_settings)
                    .navigate(R.id.action_ImportExportFragment_to_ImportListFragment)
                // Handle import external option
            }
        } else {

            if (isInternal) {
                Notify.Toast("Coming Soon")
                //                val file = Utills.exportTableData("Contact", requireContext())
//                file?.let {
//
//
////                    val uri = FileProvider.getUriForFile(
////                        requireContext(),
////                        BuildConfig.APPLICATION_ID + Constants.PROVIDER,
////                        File(it.path)
////                    )
////                    grantUriPermission(
////                        "com.devbeans.io.vault",
////                        uri,
////                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
////                    )
////                    val intent = Intent("com.export.contacts.chat")
////                    intent.putExtra(Constants.KEYS.INTENT_CONTACT_FILE, uri.toString() + "")
////                    sendBroadcast(intent)
//                }
                // Handle export internal option
            } else {

                requireActivity().findNavController(R.id.fragment_container_settings)
                    .navigate(R.id.action_ImportExportFragment_to_ExportFragment)

//                // Handle export external option
            }
        }
    }

    private fun showImportExportDialog(isImport: Boolean) {
        ImportExportDialog.show(parentFragmentManager, isImport, this)
    }

    /**
     * Initializes the Import export views with their corresponding values.
     */
    private fun initViews() {
        mBinding?.let { binding ->

        }
    }


}