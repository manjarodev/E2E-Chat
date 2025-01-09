package com.devbeans.io.chat.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.OnMediaClickCallBack
import com.devbeans.io.chat.callBacks.OnMediaSelectCallback
import com.devbeans.io.chat.databinding.ItemMediaBinding
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.util.*

//************************************************************
class MediaAdapter(
    var mClickCallBack: OnMediaClickCallBack,
    var context: Context,
    var onMediaSelectCallback: OnMediaSelectCallback?
) :
    RecyclerView.Adapter<MediaAdapter.MediaViewHolder>()
//************************************************************
{
    private val mediaList: MutableList<Payload> = mutableListOf()
    private var selectionMode: Boolean = false
    private var count: Int = -1

    //************************************************************
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MediaViewHolder
    //************************************************************
    {
        return MediaViewHolder(
            ItemMediaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), mClickCallBack, context
        )
    }

    //************************************************************
    override fun onBindViewHolder(
        holder: MediaViewHolder,
        position: Int
    )
    //************************************************************
    {
        holder.setData(mediaList[position])
    }

    //************************************************************
    override fun getItemCount(): Int
    //************************************************************
    {
        return mediaList.size
    }

    fun increaseCount(bindingAdapterPosition: Int) {
        count++
        onMediaSelectCallback!!.getCount(count)
        onMediaSelectCallback!!.addMedia(mediaList[bindingAdapterPosition])
    }

    fun decreaseCount(bindingAdapterPosition: Int) {
        count--
        onMediaSelectCallback!!.getCount(count)
        onMediaSelectCallback!!.removeMedia(mediaList[bindingAdapterPosition])
        if (count < 0) {
            selectionMode = false
        }
    }

    fun getSelectionMode(): Boolean {
        return selectionMode
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deselectAll() {
        for (e in mediaList) {
            e.isSelected = false
        }
        count = -1
        selectionMode = false
        notifyDataSetChanged()
    }

    fun submitMedia(media: List<Payload>) {
        val oldMedia: List<Payload> = LinkedList(mediaList)
        mediaList.clear()
        mediaList.addAll(media)
        count = -1
        selectionMode = false
        DiffUtil
            .calculateDiff(Callback(oldMedia, mediaList))
            .dispatchUpdatesTo(this)
    }

    private class Callback(
        private val oldList: List<Payload>,
        private val newList: List<Payload>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].messageId == newList[newItemPosition].messageId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }


    /**
     * MediaViewHolder is responsible for providing the views which represent items in a data set.
     * Each item is a media with its select state and media type.
     *
     * @property mBinding binding object of the layout 'ItemMediaBinding'
     * @property mMediaClickCallBack callback to handle media click event
     * @property context context to be used with Glide
     */
    inner class MediaViewHolder(
        private val mBinding: ItemMediaBinding,
        private val mMediaClickCallBack: OnMediaClickCallBack,
        private val context: Context
    ) : RecyclerView.ViewHolder(mBinding.root) {

        private var file: File? = null
        private val TAG = Log.tag(MediaViewHolder::class.java)

        /**
         * Binds media data to UI and sets click listeners.
         *
         * @param payload the media data, select state, and media type
         */
        fun setData(payload: Payload) {
            val interval = (2 * 1000).toLong()
            val options = RequestOptions().frame(interval)
            val isSelected = payload.isSelected
            arrayOf(mBinding.viewOpacity75, mBinding.ivPlay).forEach {
                it.visibility = if (isSelected) VISIBLE else GONE
            }

            when (payload.type) {
                "audio" -> handleAudio()
                "video" -> handleVideo(payload, options)
                "image" -> handleImage(payload)
                // "file" does nothing currently
            }

            mBinding.cvImage.apply {
                setOnClickListener { handleOnClick(payload) }
                setOnLongClickListener { handleOnLongClick(payload) }
            }
        }

        /**
         * Handles audio type. It hides the video time and loads the audio icon.
         */
        private fun handleAudio() {
            mBinding.videoTimeMedia.visibility = GONE
            Glide.with(context).load(R.drawable.ic_audio_img).into(mBinding.ivImage)
        }

        /**
         * Handles video type. It makes the video time visible and loads the video thumbnail.
         *
         * @param payload the media data, select state, and media type
         * @param options Glide RequestOptions to select the frame at a certain time
         */
        private fun handleVideo(payload: Payload, options: RequestOptions) {
            mBinding.videoTimeMedia.visibility = VISIBLE
            file = File(payload.filePath)
            if (file!!.exists()) {
                Glide.with(context).asBitmap().load(file).apply(options).into(mBinding.ivImage)
                mBinding.textviewTimeVideoMedia.text = Utills.getDuration(MainApp.appContext, file!!.path)
            }
        }

        /**
         * Handles image type. It hides the video time and loads the image.
         *
         * @param payload the media data, select state, and media type
         */
        private fun handleImage(payload: Payload) {
            mBinding.videoTimeMedia.visibility = GONE
            file = File(payload.filePath)
            Glide.with(context).load(payload.filePath).into(mBinding.ivImage)
        }

        /**
         * Handles item's click event. If selectionMode is enabled, toggle the item's select state.
         * Otherwise, perform the media click callback.
         *
         * @param payload the media data, select state, and media type
         */
        private fun handleOnClick(payload: Payload) {
            val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            if (selectionMode) {
                mediaList[position].isSelected = !payload.isSelected
                if (mediaList[position].isSelected) {
                    increaseCount(position)
                } else {
                    decreaseCount(position)
                }
                Log.e(TAG, "$count")
                notifyItemChanged(position)
            } else {
                mMediaClickCallBack.onMediaClick(payload)
            }
        }

        /**
         * Handles item's long click event. If the item is not selected, enables selectionMode,
         * select the item, and stop the pager.
         *
         * @param payload the media data, select state, and media type
         * @return Boolean
         */
        private fun handleOnLongClick(payload: Payload): Boolean {
            if (!payload.isSelected) {
                selectionMode = true
                mediaList[bindingAdapterPosition].isSelected = true
                increaseCount(bindingAdapterPosition)
                Log.e(TAG, "$count")
                onMediaSelectCallback?.stopPager(true)
                notifyDataSetChanged()
            }
            return true
        }
    }

}