package com.devbeans.io.chat.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.devbeans.io.chat.R
import com.devbeans.io.chat.databinding.ItemImageBinding
import com.devbeans.io.chat.models.Payload
import java.io.File

class ImageViewHolder(
    private val mBinding: ItemImageBinding,
    private val mRequestManager: RequestManager
) : RecyclerView.ViewHolder(mBinding.root) {

    /**
     * Populates the ViewHolder with data from the provided payload.
     *
     * @param payload The payload containing the data.
     */
    fun setData(payload: Payload) {
        // Define the frame interval for video and image types.
        val interval = 2 * 1000L
        val options = RequestOptions().frame(interval)

        // Use the payload type to determine how to load the image.
        when (payload.type) {
            "audio" -> {
                // Load an audio placeholder image.
                mRequestManager.load(R.drawable.ic_audio_img)
                    .into(mBinding.ivChatImage)
            }
            "video" -> {
                // Load a video thumbnail and show the play button.
                mBinding.cvPlay.visibility = View.VISIBLE
                mRequestManager.load(File(payload.filePath))
                    .into(mBinding.ivChatImage)
            }
            "image" -> {
                // Load the image from the file path.
                mRequestManager.asBitmap()
                    .load(payload.filePath)
                    .apply(options)
                    .into(mBinding.ivChatImage)
            }
            // For the "file" type and any other types, no action is needed.
            else -> {}
        }
    }
}
