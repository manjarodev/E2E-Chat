package com.devbeans.io.chat.fragments

import android.Manifest
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.ImportFileListAdapter
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.OnImportFileSelected
import com.devbeans.io.chat.databinding.CustomDeleteMessageBinding
import com.devbeans.io.chat.databinding.ImportListFragmentBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.util.*

class ImportListFragment : Fragment(), OnImportFileSelected {
    // Instance variables
    private var position: Int = -1
    private var notSelected: Boolean = false
    private var mBinding: ImportListFragmentBinding? = null
    private val adapter = ImportFileListAdapter(this)
    private var file: File? = null
    private val MANAGE_DATA_PERMISSION_REQUEST_CODE = 2296

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = ImportListFragmentBinding.inflate(inflater, viewGroup, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        manageDataPermission()

        setListeners()
    }

    /**
     * Requests the user's permission to access the app's data on external storage.
     * If the permission is already granted, checks for read external storage permission.
     * If the permission is not granted, starts the system settings activity to grant the permission.
     */
    private fun manageDataPermission() {
        try {
            if (!Environment.isExternalStorageManager()) {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                intent.addCategory("android.intent.category.DEFAULT")
                intent.data =
                    Uri.parse(String.format("package:%s", MainApp.appContext?.packageName))
                startActivityForResult(intent, MANAGE_DATA_PERMISSION_REQUEST_CODE)
            } else {
                checkReadExternalPermission()
            }
        } catch (e: Exception) {
            Log.e(
                javaClass.simpleName,
                "Error while requesting manage data permission: ${e.message}"
            )
            val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
            startActivityForResult(intent, MANAGE_DATA_PERMISSION_REQUEST_CODE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MANAGE_DATA_PERMISSION_REQUEST_CODE && Environment.isExternalStorageManager()) {
            checkReadExternalPermission()
        } else {
            handlePermissionPermanentlyDenied()
        }
    }


    /**
     * Returns a list of all files in the "Chat" folder of the downloads directory that match the given pattern.
     * The pattern should be a regular expression that matches the file names.
     * This function assumes that the "Chat" folder exists in the downloads directory.
     * If the folder does not exist, an empty list will be returned.
     */
    fun getChatFiles(pattern: String): List<File> {
        val chatFiles = mutableListOf<File>()

        // Get the path to the downloads folder
        val downloadsDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        // Get the path to the "Chat" folder in the downloads directory
        val chatDir = File(downloadsDir, "Chat")

        // If the "Chat" folder does not exist, return an empty list
        if (!chatDir.exists() || !chatDir.isDirectory) {
            return chatFiles
        }

        // Get a list of all the files in the "Chat" folder that match the pattern
        val files = chatDir.listFiles { dir, name ->
            name.matches(Regex("Contact_.*\\.csv"))
        }

        if (files != null) {
            // Add each file to the list
            chatFiles.addAll(files)
        }

        return chatFiles
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    /**
     * Initializes the views.
     */
    private fun initViews() {
        mBinding?.let { binding ->
            notSelected = false
            binding.rvFilesList.adapter = adapter
            getAllFiles()
        }
    }

    /**
     * Sets the listeners.
     */
    private fun setListeners() {
        mBinding?.let { binding ->
            binding.buttonDelete.setOnClickListener {
                showDeleteFileDialog()
            }

            binding.buttonImport.setOnClickListener {
                navigateToImportFileFragment()
            }
        }
    }

    private fun navigateToImportFileFragment() {
        mBinding?.let {
            file?.let {
                runOnUiThread {
                    val bundle = Bundle().apply {
                        putString(Constants.KEYS.INTENT_SELECTED_FILE, it.path)
                    }

                    requireActivity().findNavController(R.id.fragment_container_settings)
                        .navigate(R.id.action_ImportListFragment_to_ImportFragment, bundle)
                }
            }
        }
    }

    /**
     * Checks for permission and deletes the selected file.
     */
    private fun checkPermissionAndDelete() {
        Permissions.with(this@ImportListFragment).request(
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).ifNecessary()
            .onAllGranted {
                file?.let {
//                    val file = File(requireContext().getExternalFilesDir(null), it.name)
//                    if (file.exists()) {
//                        file.delete()
//                        getAllFiles()
//                    }

                    try {
                        Utills.deleteFileFromDownloads(requireContext(), it.name)
                        getAllFiles()
                    } catch (e: Exception) {
                        Log.e(
                            javaClass.simpleName,
                            "Error in deleting File from External ${e.message}"
                        )
                    }
                }
            }.onAnyDenied {
                handlePermissionDenied()
            }.onAnyPermanentlyDenied {
                handlePermissionPermanentlyDenied()
            }.execute()
    }

    /**
     * Handles the permission denied.
     */
    private fun handlePermissionDenied() {
        try {
            requireActivity().finish()
        } catch (e: IllegalStateException) {
            Log.e(javaClass.simpleName, "Illegal State Exception ${e.message}")
        }
    }

    /**
     * Handles the permanently denied permission.
     */
    private fun handlePermissionPermanentlyDenied() {
        try {
            Notify.Toast(AndroidUtil.getString(R.string.do_not_have_permission))
            requireActivity().finish()
        } catch (e: IllegalStateException) {
            Log.e(javaClass.simpleName, "Illegal State Exception ${e.message}")
        }
    }

    /**
     * Checks for read external storage permission.
     */
    private fun checkReadExternalPermission() {
        Permissions.with(this@ImportListFragment).request(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).ifNecessary()
            .onAllGranted {
                initViews()
            }.onAnyDenied {
                handlePermissionDenied()
            }.onAnyPermanentlyDenied {
                handlePermissionPermanentlyDenied()
            }.execute()
    }

    /**
     * This method is used for handling the events that are used in import/export
     *
     */
    private fun showDeleteFileDialog() {
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
                checkPermissionAndDelete()
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
            tvTitle.text = AndroidUtil.getString(
                R.string.delete_file_exported,
                String.format(
                    "%s %d",
                    AndroidUtil.getString(R.string.contacts),
                    this@ImportListFragment.position
                )
            )
            tvDeleteNotification.text = AndroidUtil.getString(R.string.delete_file_exported_prompt)
            btnDeleteForMe.text = AndroidUtil.getString(R.string.delete)
            btnDeleteForEveryone.visibility = View.GONE
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        Permissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
    }


    /**
     * Retrieves all exported files and displays them in the RecyclerView.
     * Note: This method should be called after the RecyclerView adapter has been initialized.
     */
    private fun getAllFiles() {
        // Retrieve all exported files from the device
//        val files = Utills.getAllExportedFilesExternal(requireContext())

        var files = mapOf<Date, File>()
        try {
            files = Utills.getAllContactFilesSecond(requireContext())
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, "Error ${e.message}")
        }

        // Sort the files by date, from newest to oldest
        val sortedFiles = files.toList().sortedByDescending { it.first }

        // Map the files to a list of pairs containing the date and file object
        val fileList = sortedFiles.map { Pair(it.first, it.second) }

        // Submit the list of file pairs to the RecyclerView adapter
        adapter.submitList(fileList)

        //if the list is empty initialize the file object with null and notSelected with false
        if (fileList.isEmpty()) {
            notSelected = false

            mBinding?.lvSelection?.visibility = View.GONE

            // Update the selected file, or set it to null
            this.file = null
        }
    }


    /**
     * Called when a file is selected in the list.
     * Updates the selected file and position, and toggles the visibility of the selection view.
     *
     * @param file The selected file.
     * @param position The position of the selected file in the list.
     */
    override fun onFileSelected(file: File, position: Int) {
        // Check if a file is selected or not
        notSelected = position < 0

        // Update the selected file position
        this.position = position + 1

        // Toggle the visibility of the selection view
        mBinding?.lvSelection?.visibility = if (notSelected) View.GONE else View.VISIBLE

        // Update the selected file, or set it to null if no file is selected
        this.file = if (!notSelected) file else null
    }


}