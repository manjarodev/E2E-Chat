package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatSettingsActivity
import com.devbeans.io.chat.databinding.FragmentWallpaperPreviewBinding
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.SettingsValues
import com.devbeans.io.chat.utils.WindowUtil
import java.io.File

class PreviewWallpaperFragment : Fragment() {
    private var isFile: Boolean = false
    private var mBinding: FragmentWallpaperPreviewBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        (activity as ChatSettingsActivity).supportActionBar?.title = "Preview"
        (activity as ChatSettingsActivity).getToolbar().setNavigationIcon(R.drawable.ic_back_white)
        mBinding = FragmentWallpaperPreviewBinding.inflate(inflater, viewGroup, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            if (arguments?.get(Constants.KEYS.INTENT_FILE) != null) {
                val file = File(arguments?.get(Constants.KEYS.INTENT_FILE).toString())
                Glide.with(requireContext()).load(file)
                    .into(mBinding?.ivImage!!)
                isFile = true
            }

            if (arguments?.get(Constants.KEYS.INTENT_DRAWABLE) != null) {
                Glide.with(requireContext())
                    .load(AndroidUtil.getDrawable(arguments?.getInt(Constants.KEYS.INTENT_DRAWABLE)!!))
                    .into(mBinding?.ivImage!!)
                isFile = false
            }
            listeners()
        }

    }

    private fun listeners() {
        mBinding?.apply {
            tvSetWallpaper.setOnClickListener {
                SettingsValues.setDefaultChatWallpaperSet(!isFile)
                SettingsValues.setDefaultChatWallpaperFileSet(isFile)
                if (isFile) {
                    SettingsValues.setDefaultChatWallpaperFile(
                        arguments?.get(Constants.KEYS.INTENT_FILE).toString()
                    )
                } else {
                    SettingsValues.setDefaultChatWallpaper(arguments?.getInt(Constants.KEYS.INTENT_DRAWABLE)!!)
                }
                requireActivity().finish()
            }
        }
    }
}