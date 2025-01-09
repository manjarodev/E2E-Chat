package com.devbeans.io.chat.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.adapters.viewholders.ImageViewHolder
import com.devbeans.io.chat.databinding.ItemImageBinding
import com.devbeans.io.chat.models.ChatRoom
import com.devbeans.io.chat.models.Payload

class ImageAdapter : RecyclerView.Adapter<ImageViewHolder>() {

    /**
     * The list of payloads to display in the RecyclerView.
     */
    private var mSharedList: List<Payload> = emptyList()

    /**
     * Replaces the current list of payloads with a new one.
     *
     * @param mSharedList The new list of payloads.
     */
    fun setMSharedList(mSharedList: List<Payload>) {
        this.mSharedList = mSharedList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        // Inflate the layout in a more idiomatic way.
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding, Glide.with(parent.context))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.setData(mSharedList[position])
    }

    override fun getItemCount(): Int {
        // Use Kotlin's `coerceAtMost` function instead of `Math.min`.
        val limit = 10
        return mSharedList.size.coerceAtMost(limit)
    }

    /**
     * Clears the list of payloads and optionally notifies that the data set has changed.
     *
     * @param notifyDataSetChanged Whether to notify that the data set has changed.
     */
    @SuppressLint("NotifyDataSetChanged")
    fun clear(notifyDataSetChanged: Boolean = true) {
        mSharedList = emptyList()
        if (notifyDataSetChanged) {
            notifyDataSetChanged()
        }
    }
}
