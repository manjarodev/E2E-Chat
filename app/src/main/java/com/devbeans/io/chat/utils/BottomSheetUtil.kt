package com.devbeans.io.chat.utils

import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.FragmentManager
import com.devbeans.io.chat.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

object BottomSheetUtil {
    const val STANDARD_BOTTOM_SHEET_FRAGMENT_TAG = "BOTTOM"

    /**
     * Show preventing a possible IllegalStateException.
     */
    @JvmStatic
    fun show(
        manager: FragmentManager,
        tag: String?,
        dialog: BottomSheetDialogFragment
    ) {
        manager.beginTransaction().apply {
            add(dialog, tag)
            commitAllowingStateLoss()
        }
    }

//    fun BottomSheetDialogFragment.requireCoordinatorLayout(): CoordinatorLayout {
//        return requireDialog().findViewById(R.id.coordinator)
//    }
}