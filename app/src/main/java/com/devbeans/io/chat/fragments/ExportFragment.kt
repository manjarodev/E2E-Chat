package com.devbeans.io.chat.fragments

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.core.view.OneShotPreDrawListener
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.databinding.ExportFragmentBinding
import com.devbeans.io.chat.databinding.FragmentDeleteBinding
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.components.ShapeScrim
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.utils.qr.QrScannerView
import com.devbeans.io.chat.utils.qr.kitkat.ScanListener
import com.devbeans.io.chat.utils.views.ViewUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.io.File
import java.lang.Exception
import java.util.*

/**
 * Class used for exporting the file into external storage
 */
class ExportFragment : Fragment() {
    private var mBinding: ExportFragmentBinding? = null
    private val TAG = javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = ExportFragmentBinding.inflate(inflater, viewGroup, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }


    /**
     * Checks if WRITE_EXTERNAL_STORAGE permission is granted, requests permission if necessary, and exports table data to external storage.
     * If permission is permanently denied, shows a toast message and finishes the activity.
     */
    private fun checkPermissionAndWrite() {
        Permissions.with(this@ExportFragment)
            .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .ifNecessary()
            .onAllGranted { exportDataToExternalStorage() }
            .onAnyDenied { finishActivityWithError(R.string.do_not_have_permission) }
            .onAnyPermanentlyDenied { finishActivityWithError(R.string.do_not_have_permission) }
            .execute()
    }

    /**
     * Exports table data to external storage and logs the result.
     */
    private fun exportDataToExternalStorage() {
        try {
            if (Utills.exportTableDataDownloads("Contact", requireContext())) {
                Log.d(TAG, "Exported to external storage")
                Notify.Toast("Exported to Downloads/Chat")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Got Exception in Exporting: ${e.message}")
        }
    }



    /**
     * Shows a toast message and finishes the activity.
     * @param messageResId the resource ID of the string to display in the toast message
     */
    private fun finishActivityWithError(@StringRes messageResId: Int) {
        try {
            runOnUiThread {
                Notify.Toast(AndroidUtil.getString(messageResId))
                requireActivity().finish()
            }
        } catch (e: IllegalStateException) {
            Log.e(TAG, "Illegal State Exception: ${e.message}")
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
     * Initializes views and starts export process.
     * Shows progress while export is ongoing and updates UI accordingly.
     */
    private fun initViews() {
        Thread {
            var progress = 0

            // Show progress
            while (progress < 100) {
                progress += 1

                // Update progress on the UI thread
                runOnUiThread {
                    mBinding?.setupProgress?.progress = progress
                    mBinding?.tvProgress?.text =
                        String.format(Locale.getDefault(), "%s", "$progress%")
                }

                try {// Start export process when progress is at 50%
                    if (progress == 50) {
                        checkPermissionAndWrite()
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception in Exporting file ${e.message}")
                }

                try {
                    // Sleep for 100ms to slow down the progress update
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }

            // Update UI after export is done
            if (progress == 100) {
                runOnUiThread {
                    // Hide the export note
                    mBinding?.tvExportNote?.visibility = View.GONE
                    // Set the export done image
                    mBinding?.ivImportExport?.setImageDrawable(AndroidUtil.getDrawable(R.drawable.ic_export_done))
                    // Set the title to "Contacts exported"
                    mBinding?.tvTitle?.text = getString(R.string.contacts_exported)
                    // Use a Handler to post a Runnable after a delay of 500ms
                    Handler(Looper.getMainLooper()).postDelayed({ requireActivity().finish() }, 500)
                }
            }
        }.start()
    }

}