package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.OneShotPreDrawListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.ContactChoiceAdapter
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.databinding.ExportFragmentBinding
import com.devbeans.io.chat.databinding.ImportFragmentBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.ContactChoice
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.components.ShapeScrim
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.utils.qr.QrScannerView
import com.devbeans.io.chat.utils.qr.kitkat.ScanListener
import com.devbeans.io.chat.utils.views.ViewUtil
import com.devbeans.io.chat.viewmodels.ContactChoiceViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.io.File
import java.lang.Exception
import java.util.*

/**
 * A Fragment class responsible for importing contacts and handling user choices.
 */
class ImportFragment : Fragment(),ContactChoiceBottomSheet.OnImportCompletedListener {

    private var selectedFile: File? = null
    private var _binding: ImportFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ContactChoiceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ImportFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedFile = arguments?.getString(Constants.KEYS.INTENT_SELECTED_FILE)?.let { File(it) }
        val adapter = ContactChoiceAdapter(viewModel::onContactChoiceSelected)
        viewModel.contactChoices.observe(viewLifecycleOwner) { choices ->
            adapter.submitList(choices)
        }
        viewModel.selectedContacts.observe(viewLifecycleOwner) { selectedContacts ->
            // Handle selectedContacts
        }

        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Initializes the views and starts the import process.
     */
    private fun initViews() {
        selectedFile?.let { file ->
            val (existingContacts, importedContacts) =
                Utills.importTableData(file, MainApp.appContext?.contactsDao!!)

            if (existingContacts.isNotEmpty() && importedContacts.isNotEmpty()) {
                val bottomSheet = ContactChoiceBottomSheet(viewModel)
                bottomSheet.isCancelable = false
                bottomSheet.setOnImportCompletedListener(this)
                bottomSheet.show(parentFragmentManager, "contact_choice_bottom_sheet")
                viewModel.loadContactChoices(existingContacts, importedContacts)
            } else {
                importContactsProgress()
            }
        }
    }

    /**
     * Displays the progress of importing contacts.
     */
    private fun importContactsProgress() {
        val progressHandler = Handler(Looper.getMainLooper())

        val progressRunnable = object : Runnable {
            var progress = 0
            override fun run() {
                if (progress < 100) {
                    progress += 1
                    runOnUiThread {
                        binding.setupProgress.progress = progress
                        binding.tvProgress.text =
                            String.format(Locale.getDefault(), "%s", "$progress%")
                    }
                    progressHandler.postDelayed(this, 100)
                } else {
                    onImportCompletedUi()
                }
            }
        }

        progressHandler.post(progressRunnable)
    }

    /**
     * Handles the completion of the import process.
     */
    private fun onImportCompletedUi() {
        runOnUiThread {
            binding.apply {
                tvExportNote.visibility = View.GONE
                ivImportExport.setImageResource(R.drawable.ic_export_done)
                tvTitle.setText(R.string.contacts_imported)
            }
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                runOnUiThread { requireActivity().finish() }
            },
            500
        )
    }

    override fun onImportCompleted() {
        onImportCompletedUi()
    }
}
