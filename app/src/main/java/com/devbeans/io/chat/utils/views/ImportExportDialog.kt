package com.devbeans.io.chat.utils.views

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.databinding.ImportExportDialogOptionBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ImportExportDialog : DialogFragment() {

    private var listener: ImportExportDialogListener? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.import_export_dialog_option, null)
        val dialogBinding = ImportExportDialogOptionBinding.bind(dialogView)
        val builder = AlertDialog.Builder(requireContext())

        builder.setView(dialogBinding.root)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogBinding.lvExternal.setOnClickListener {
            val isImport = requireArguments().getBoolean(ARG_IS_IMPORT)
            listener?.onImportExportOptionSelected(isImport, false)
            dialog.dismiss()
        }

        dialogBinding.lvVault.setOnClickListener {
            val isImport = requireArguments().getBoolean(ARG_IS_IMPORT)
            listener?.onImportExportOptionSelected(isImport, true)

            dialog.dismiss()
        }

        return dialog
    }


    interface ImportExportDialogListener {
        fun onImportExportOptionSelected(isImport: Boolean, isInternal: Boolean)
    }

    companion object {
        private const val DIALOG_TAG = "ImportExportDialog"
        private const val ARG_IS_IMPORT = "arg.is_import"

        fun show(fragmentManager: FragmentManager, isImport: Boolean, listener: ImportExportDialogListener) {
            ImportExportDialog().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_IS_IMPORT, isImport)
                }
                this.listener = listener
                show(fragmentManager, DIALOG_TAG)
            }
        }
    }
}
