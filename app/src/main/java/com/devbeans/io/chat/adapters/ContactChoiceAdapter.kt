package com.devbeans.io.chat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.databinding.ListItemContactChoiceBinding
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.ContactChoice

class ContactChoiceAdapter(private val onContactChoiceSelected: (Contact) -> Unit) :
    ListAdapter<ContactChoice, ContactChoiceAdapter.ContactChoiceViewHolder>(
        ContactChoiceDiffCallback()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactChoiceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemContactChoiceBinding.inflate(inflater, parent, false)
        return ContactChoiceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactChoiceViewHolder, position: Int) {
        holder.bind(getItem(position), onContactChoiceSelected)
    }


    class ContactChoiceViewHolder(private val binding: ListItemContactChoiceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contactChoice: ContactChoice, onContactChoiceSelected: (Contact) -> Unit) {
            binding.tvContactName.text = contactChoice.contactFromFile.name
            binding.tvChatUserId.text = contactChoice.contactFromFile.name
            binding.btnKeepA.setOnClickListener {
                onContactChoiceSelected(contactChoice.contactFromDb)
            }
            binding.btnKeepB.setOnClickListener {
                onContactChoiceSelected(contactChoice.contactFromFile)
            }
        }
    }


    private class ContactChoiceDiffCallback : DiffUtil.ItemCallback<ContactChoice>() {
        override fun areItemsTheSame(oldItem: ContactChoice, newItem: ContactChoice): Boolean {
            return oldItem.contactFromFile.id == newItem.contactFromFile.id
        }

        override fun areContentsTheSame(oldItem: ContactChoice, newItem: ContactChoice): Boolean {
            return oldItem == newItem
        }
    }
}