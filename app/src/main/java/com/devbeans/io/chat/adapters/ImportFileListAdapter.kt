package com.devbeans.io.chat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.callBacks.OnImportFileSelected
import com.devbeans.io.chat.databinding.ItemListFragmentBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class ImportFileListAdapter(private val callback: OnImportFileSelected) :
    RecyclerView.Adapter<ImportFileListAdapter.FileViewHolder>() {

    private val items = mutableListOf<Pair<Date, File>>()
    private var selectedPosition: Int = RecyclerView.NO_POSITION


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImportFileListAdapter.FileViewHolder {
        return FileViewHolder(
            ItemListFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(
        holder: ImportFileListAdapter.FileViewHolder,
        position: Int
    ) {
        val item = items[position]
        val counter = position + 1
        holder.setData(item,counter)
    }


    override fun getItemCount() = items.size


    fun submitList(newItems: List<Pair<Date, File>>) {
        val diffResult = DiffUtil.calculateDiff(FileDiffCallback(items, newItems))
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }


    inner class FileViewHolder
        (var mBinding: ItemListFragmentBinding) : RecyclerView.ViewHolder(
        mBinding.root
    ) {


        fun setData(item: Pair<Date, File>, counter: Int) {

            val dateFormat = SimpleDateFormat("MMM d, yyyy h:mm a", Locale.US)
            val fileName = item.second.name.substringBefore("_")
            mBinding.tvImportFileName.text = String.format("%s %d", fileName, counter)
            mBinding.tvImportFileDateTime.text = dateFormat.format(item.first)

            mBinding.root.isSelected = selectedPosition == position
            mBinding.root.setOnClickListener {
                val previousSelectedPosition = selectedPosition
                selectedPosition = if (previousSelectedPosition == adapterPosition) {
                    RecyclerView.NO_POSITION // deselect item
                } else {
                    adapterPosition
                }
                notifyItemChanged(previousSelectedPosition)
                notifyItemChanged(selectedPosition)
                callback.onFileSelected(item.second,selectedPosition)
            }

        }
    }


    class FileDiffCallback(
        private val oldList: List<Pair<Date, File>>,
        private val newList: List<Pair<Date, File>>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].second.path == newList[newItemPosition].second.path
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }


    }
}