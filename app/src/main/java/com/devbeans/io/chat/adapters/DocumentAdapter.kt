package com.devbeans.io.chat.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.callBacks.OnDocsCallback
import com.devbeans.io.chat.callBacks.OnMediaSelectCallback
import com.devbeans.io.chat.databinding.ItemDocumentBinding
import com.devbeans.io.chat.models.MetaData
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.DateTime
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import java.io.File
import java.lang.Long
import java.util.*
import kotlin.Boolean
import kotlin.Exception
import kotlin.Int

//************************************************************
class DocumentAdapter
    (
    var mClickCallBack: OnDocsCallback,
    var onMediaSelectCallback: OnMediaSelectCallback?
) :
    RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder?>()
//************************************************************
{
    private val docList: MutableList<Payload> = mutableListOf()
    private var selectionMode: Boolean = false
    private var count: Int = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DocumentViewHolder {
        return DocumentViewHolder(
            ItemDocumentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            mClickCallBack
        )
    }

    //************************************************************
    override fun onBindViewHolder(
        holder: DocumentViewHolder,
        position: Int
    ) //************************************************************
    {

        holder.setData(docList[position])
    }

    //************************************************************
    override fun getItemCount(): Int
    //************************************************************
    {
        return docList.size
    }

    fun submitMedia(media: List<Payload>) {
        val oldMedia: List<Payload> = LinkedList(docList)
        docList.clear()
        docList.addAll(media)
        count = -1
        selectionMode = false
        DiffUtil
            .calculateDiff(Callback(oldMedia, docList))
            .dispatchUpdatesTo(this)
    }

    fun increaseCount(bindingAdapterPosition: Int) {
        count++
        onMediaSelectCallback!!.getCount(count)
        onMediaSelectCallback!!.addMedia(docList[bindingAdapterPosition])
    }

    fun decreaseCount(bindingAdapterPosition: Int) {
        count--
        onMediaSelectCallback!!.getCount(count)
        onMediaSelectCallback!!.removeMedia(docList[bindingAdapterPosition])
        if (count < 0) {
            selectionMode = false
        }
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
     * DocumentViewHolder is responsible for providing the views which represent items in a data set.
     * Each item is a file with its meta-data and select state.
     *
     * @property mBinding binding object of the layout 'ItemDocumentBinding'
     * @property callback interface to handle item click event.
     */
    inner class DocumentViewHolder(
        private val mBinding: ItemDocumentBinding,
        private val callback: OnDocsCallback
    ) :
        RecyclerView.ViewHolder(mBinding.root) {

        private val TAG = Log.tag(DocumentViewHolder::class.java)

        /**
         * Binds file's meta-data to UI and sets click listeners.
         *
         * @param payload the file's meta-data and select state
         */
        fun setData(payload: Payload?) {
            val isSelected = payload?.isSelected ?: false
            mBinding.viewSelection.visibility = if (isSelected) View.VISIBLE else View.GONE

            payload?.filePath?.let { filePath ->
                val file = File(filePath)
                if (file.exists()) {
                    populateFileData(file, payload)
                }
            }

            mBinding.root.apply {
                setOnClickListener { handleOnClick(payload) }
                setOnLongClickListener { handleOnLongClick(payload) }
            }
        }

        /**
         * Populates UI with file's meta-data.
         *
         * @param file the file
         * @param payload the file's meta-data and select state
         */
        private fun populateFileData(file: File, payload: Payload) {
            try {
                val currentString = payload.data
                val separated = currentString?.split("@@")?.toTypedArray()
                val metaData = Gson().fromJson(separated?.get(1), MetaData::class.java)

                mBinding.apply {
                    tvFileName.text = file.name
                    tvFileTime.text = DateTime.getFormattedTimeOnly(payload.createdAt)
                    tvFileSizeType.text = String.format(
                        "%s",
                        "${Utills.getSize(metaData.size.toLong())} - ${metaData.extention}"
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        /**
         * Handles item's click event. If selectionMode is enabled, toggle the item's select state.
         * Otherwise, call the item's click callback.
         *
         * @param payload the file's meta-data and select state
         */
        private fun handleOnClick(payload: Payload?) {
            val position =
                bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            if (selectionMode) {
                docList[position].isSelected = !payload!!.isSelected
                if (docList[position].isSelected) {
                    increaseCount(position)
                } else {
                    decreaseCount(position)
                }
                Log.e(TAG, "$count")
                notifyItemChanged(position)
            } else {
                callback.onDocsCallback(payload)
            }
        }

        /**
         * Handles item's long click event. If the item is not selected, enables selectionMode,
         * select the item, and stop the pager.
         *
         * @param payload the file's meta-data and select state
         * @return Boolean
         */
        private fun handleOnLongClick(payload: Payload?): Boolean {
            if (!payload!!.isSelected) {
                selectionMode = true
                docList[bindingAdapterPosition].isSelected = true
                increaseCount(bindingAdapterPosition)
                Log.e(TAG, "$count")
                onMediaSelectCallback?.stopPager(true)
                notifyDataSetChanged()
            }
            return true
        }
    }

}