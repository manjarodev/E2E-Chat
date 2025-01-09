package com.devbeans.io.chat.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatSettingsActivity
import com.devbeans.io.chat.adapters.ChatColorsAdapter
import com.devbeans.io.chat.adapters.ChatWallpaperAdapter
import com.devbeans.io.chat.callBacks.OnColorSelectCallback
import com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback
import com.devbeans.io.chat.databinding.FragmentChatWallpaperBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.viewmodels.ChatSettingsViewModel
import com.github.dhaval2404.imagepicker.ImagePicker
import java.io.File

class WallpaperChatFragment : Fragment(), OnColorSelectCallback, OnWallpaperSelectCallback {

    private var mBinding: FragmentChatWallpaperBinding? = null
    private lateinit var adapter: ChatColorsAdapter
    private lateinit var wallpaperAdapter: ChatWallpaperAdapter
    private var mViewModel: ChatSettingsViewModel? = null
    private val TAG = Log.tag(WallpaperChatFragment::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        (activity as ChatSettingsActivity).supportActionBar?.title = "Color and Wallpaper"
        (activity as ChatSettingsActivity).getToolbar().setNavigationIcon(R.drawable.ic_back)
        mBinding = FragmentChatWallpaperBinding.inflate(inflater, viewGroup, false)
        adapter = ChatColorsAdapter(this, requireContext())
        wallpaperAdapter = ChatWallpaperAdapter(this, requireContext())
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mViewModel = ViewModelProvider(
            requireActivity(),
            ChatSettingsViewModel.Factory() as ViewModelProvider.Factory
        ).get(
            ChatSettingsViewModel::class.java
        )
        initViews()
        listeners()
        mViewModel?.chatColorsLiveData?.observe(requireActivity()) { colorsList ->
            if (colorsList.isNotEmpty()) {
                colorsList.forEach {
                    if (SettingsValues.getDefaultChatColorsSet() && SettingsValues.getDefaultChatColor() == AndroidUtil.getColor(
                            it.chatColor
                        )
                    ) {
                        it.isSelected = true
                    }
                }
                adapter.submitColors(colorsList.toList())
            }
        }

        mViewModel?.chatWallpaperLiveData?.observe(requireActivity()) { wallpaperList ->
            if (wallpaperList.isNotEmpty()) {
                wallpaperList.forEach {
                    if (SettingsValues.getDefaultChatWallpaperSet() && SettingsValues.getDefaultChatWallpaper() ==
                        it.chatWallpaper

                    ) {
                        it.isSelected = true
                    }
                }

                wallpaperAdapter.submitWallpapers(wallpaperList)
            }
        }

    }

    private fun listeners() {
        mBinding?.apply {
            tvSelectFromDevice.setOnClickListener {
                ImagePicker.with(this@WallpaperChatFragment)
                    .compress(200)
                    .maxResultSize(640, 640)
                    .crop()
                    .start(RequestCodes.GROUP_IMAGE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == RequestCodes.GROUP_IMAGE) {
            data?.let {
                data.data?.let {
                    Log.e(TAG, "Data $data")
                    val extension = AndroidUtil.getMimeType(requireContext(), data.data)
                    val uri = data.data
                    val file = File(uri?.path.toString())
                    if (file.exists()) {
                        handleWallpaper(file, extension)
                    } else Log.e(TAG, "File does not exist")
                } ?: run {
                    Log.e(TAG, "Uri Data was null")

                }
            } ?: run {
                Log.e(TAG, "Data was null")
            }
        }

    }

    private fun handleWallpaper(file: File, extension: String) {
        val internalFile =
            FilePath.fileFromContentUriDelete(requireContext(), file.toUri())
        internalFile?.let {
            if (internalFile.exists()) {
                Utills.handleFileDelete(TAG, file.delete())
                var path: String? = ""
                when (extension) {
                    "png", "jpg", "jpeg" -> {
                        val bundle = Bundle()
                        bundle.putString(
                            Constants.KEYS.INTENT_FILE,
                            internalFile.path
                        )
                        requireActivity().findNavController(R.id.fragment_container_settings)
                            .navigate(
                                R.id.action_wallpaperChatFragment_to_wallpaperPreviewFragment,
                                bundle
                            )
                    }
                }
            }
        } ?: run { Log.e(TAG, "Internal File does not exist") }
    }

    private fun initViews() {
        mBinding?.apply {
            recycler.adapter = adapter
            recyclerWallpaper.adapter = wallpaperAdapter

        }
    }

    override fun onColorSelected(color: Int) {
        //essential for over ride
    }

    override fun onWallpaperSelected(drawable: Int) {
        val bundle = Bundle()
        bundle.putInt(
            Constants.KEYS.INTENT_DRAWABLE,
            drawable
        )
        requireActivity().findNavController(R.id.fragment_container_settings)
            .navigate(
                R.id.action_wallpaperChatFragment_to_wallpaperPreviewFragment,
                bundle
            )
    }
}