package com.devbeans.io.chat.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.callBacks.LinksCallback
import com.devbeans.io.chat.callBacks.OnMediaSelectCallback
import com.devbeans.io.chat.databinding.ItemLinksBinding
import com.devbeans.io.chat.models.Payload
import java.util.*


class LinksAdapter
    (
    var mLinksCallback: LinksCallback,
    var onMediaSelectCallback: OnMediaSelectCallback?
) :
    RecyclerView.Adapter<LinksAdapter.LinksViewHolder>()
{
    private val linksList: MutableList<Payload> = mutableListOf()
    private var selectionMode: Boolean = false
    private var count: Int = -1

    //************************************************************
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LinksViewHolder
    //************************************************************
    {
        return LinksViewHolder(
            ItemLinksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //************************************************************
    override fun onBindViewHolder(
        holder: LinksViewHolder,
        position: Int
    )
    //************************************************************
    {
        holder.setData(linksList[position])

    }

    //************************************************************
    override fun getItemCount(): Int
    //************************************************************
    {
        return linksList.size
    }

    fun increaseCount(bindingAdapterPosition: Int) {
        count++
        onMediaSelectCallback!!.getCount(count)
        onMediaSelectCallback!!.addMedia(linksList[bindingAdapterPosition])
    }

    fun decreaseCount(bindingAdapterPosition: Int) {
        count--
        onMediaSelectCallback!!.getCount(count)
        onMediaSelectCallback!!.removeMedia(linksList[bindingAdapterPosition])
        if (count < 0) {
            selectionMode = false
        }
    }

    fun submitMedia(media: List<Payload>) {
        val oldMedia: List<Payload> = LinkedList(linksList)
        linksList.clear()
        linksList.addAll(media)
        count = -1
        selectionMode = false

        DiffUtil
            .calculateDiff(Callback(oldMedia, linksList))
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
     * LinksViewHolder is responsible for providing the views which represent items in a data set.
     * Each item is a link with its select state.
     *
     * @property mBinding binding object of the layout 'ItemLinksBinding'
     */
    inner class LinksViewHolder(private val mBinding: ItemLinksBinding) : RecyclerView.ViewHolder(mBinding.root) {

        /**
         * Binds link data to UI and sets click listeners.
         *
         * @param payload the link data and select state
         */
        fun setData(payload: Payload) {
            mBinding.tvLink.text = payload.data

            val isSelected = payload.isSelected
            mBinding.viewSelection.visibility = if (isSelected) View.VISIBLE else View.GONE

            mBinding.tvLink.linksClickable = !selectionMode

            mBinding.root.apply {
                setOnClickListener { handleOnClick(payload) }
                setOnLongClickListener { handleOnLongClick(payload) }
            }
        }

        /**
         * Handles item's click event. If selectionMode is enabled, toggle the item's select state.
         * Otherwise, make the link clickable.
         *
         * @param payload the link data and select state
         */
        private fun handleOnClick(payload: Payload) {
            val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            if (selectionMode) {
                linksList[position].isSelected = !payload.isSelected
                if (linksList[position].isSelected) {
                    increaseCount(position)
                } else {
                    decreaseCount(position)
                }
                notifyItemChanged(position)
            } else {
                mBinding.tvLink.linksClickable = true
            }
        }

        /**
         * Handles item's long click event. If the item is not selected, enables selectionMode,
         * select the item, and stop the pager.
         *
         * @param payload the link data and select state
         * @return Boolean
         */
        private fun handleOnLongClick(payload: Payload): Boolean {
            if (!payload.isSelected) {
                selectionMode = true
                linksList[bindingAdapterPosition].isSelected = true
                increaseCount(bindingAdapterPosition)
                onMediaSelectCallback?.stopPager(true)
                notifyDataSetChanged()
            }
            return true
        }
    }

}