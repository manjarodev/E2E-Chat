package com.devbeans.io.chat.adapters


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.viewholders.GroupMemberViewHolder
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.OnLongMemberCallback
import com.devbeans.io.chat.callBacks.OnMembersCallback
import com.devbeans.io.chat.databinding.ItemMemberBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


class GroupMemberAdapter(
    var conversation: Conversation,
    var context: Context,
    isChatDetails: Boolean,
    onLongMemberCallback: OnLongMemberCallback,
    onMembersCallback: OnMembersCallback
) : RecyclerView.Adapter<GroupMemberViewHolder>(), Filterable {
    var memberList: MutableList<ConversationMember> = ArrayList()
    private var filteredMemberList: MutableList<ConversationMember> = ArrayList()
    private var contactCache = HashMap<String, Contact?>()
    var isLimited = false
    var isChatDetails = false
    var onLongMemberCallback: OnLongMemberCallback
    var onMembersCallback: OnMembersCallback
    private var changeOwner = false
    var selected_pos = -1
    var haveLoaded = false

    //************************************************************
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroupMemberViewHolder
    //************************************************************
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMemberBinding.inflate(layoutInflater, parent, false)
        return GroupMemberViewHolder(
            binding,
            conversation,
            Glide.with(context),
            isChatDetails,
            onLongMemberCallback
        )
    }

    /**
     * Method to bind data to the RecyclerView's ViewHolder.
     *
     * @param holder GroupMemberViewHolder instance to populate with data.
     * @param position Position of the data in the list.
     */
    override fun onBindViewHolder(
        holder: GroupMemberViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        // Set the visibility of the check off image view.
        holder.mBinding.ivCheckOff.visibility =
            if (changeOwner && !isChatDetails) View.VISIBLE else View.GONE

        // Set the checked state of the check off image view.
        holder.mBinding.ivCheckOff.isChecked = memberList[position].isSelected

        if (changeOwner) {
            // Handle the data setting when owner is being changed.
            handleOwnerChangeData(holder, position)
        } else {
            // Normal data binding when owner is not being changed.
            holder.setData(memberList[position], position, changeOwner)
        }
    }


    /**
     * Handle the data setting when owner is being changed.
     *
     * @param holder GroupMemberViewHolder instance to populate with data.
     * @param position Position of the member in the list.
     */
    private fun handleOwnerChangeData(holder: GroupMemberViewHolder, position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val member = memberList[position]
            val contact = MainApp.appContext?.contactsDao?.getContact(member.memberId)

            withContext(Dispatchers.Main) {
                Glide.with(context).load(
                    if (contact != null) getNameDrawable(contact.name, contact.avatarColor!!)
                    else R.drawable.ic_unknown
                ).into(holder.mBinding.ivChatImage)

                holder.mBinding.tvChatName.text = getChatName(contact, member)
                val isOwner = member.memberId.equals(conversation.owner, ignoreCase = true)

                holder.mBinding.tvAdmin.visibility =
                    if (isOwner || !member.type.equals("member", ignoreCase = true))
                        View.VISIBLE else View.GONE
                holder.mBinding.tvAdmin.text = if (isOwner) "Owner" else "Admin"
                handleCheckOffClick(holder, member, position)
            }
        }
    }

    private fun getChatName(contact: Contact?, member: ConversationMember): String {
        if (contact != null) return contact.name!!
        if (!conversation.conversationType.equals(
                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            ) &&
            member.chatNickName != null && member.chatNickName!!.trim().isNotEmpty()
        ) return member.chatNickName!!
        return member.memberId!!
    }

    private fun handleCheckOffClick(
        holder: GroupMemberViewHolder,
        member: ConversationMember,
        position: Int
    ) {
        val checkOffClick = View.OnClickListener {
            if (!member.isSelected) {
                deselectOtherMember(memberList, position)
                holder.mBinding.ivCheckOff.isChecked = true
            } else {
                member.isSelected = false
                holder.mBinding.ivCheckOff.isChecked = false
            }
            onMembersCallback.onMemberCallback(member, member.memberId)
        }

        holder.mBinding.layoutMember.setOnClickListener(checkOffClick)
        holder.mBinding.ivCheckOff.setOnClickListener(checkOffClick)
    }


    /**
     * Deselects all members except the one at the given position.
     *
     * @param memberList The list of members.
     * @param position The position of the member to remain selected.
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun deselectOtherMember(memberList: List<ConversationMember>, position: Int) {
        // Store the indices of previously selected and currently selected members.
        var previous = -1

        // Iterate over the member list to find and deselect the previously selected member.
        for ((index, member) in memberList.withIndex()) {
            if (member.isSelected) {
                member.isSelected = false
                previous = index
            }
        }

        // Select the member at the given position and store its index.
        memberList[position].isSelected = true

        // Notify the changes for the previously selected and currently selected members.
        if (previous != -1) notifyItemChanged(previous)
        notifyItemChanged(position)
    }


    fun setMemberList(memberList: MutableList<ConversationMember>, isLimited: Boolean) {
        this.memberList = memberList
        this.isLimited = isLimited
    }

    override fun getItemCount(): Int {
        val limit = 4
        return if (isLimited) Math.min(limit, memberList.size) else memberList.size
        //        return limit;
    }


    fun filteredList(filteredList: MutableList<ConversationMember>) {
        if (filteredList.isNotEmpty()) {
            memberList = filteredList
            notifyDataSetChanged()
        }
    }


    @SuppressLint("NotifyDataSetChanged")
            /**
             * This method sets the changeOwner value and, if isChangeOwner is true,
             * removes the member who matches the current chatUserId from memberList.
             * It then notifies that the data set has changed.
             *
             * @param isChangeOwner flag to determine if the owner is to be changed
             */
    fun isChangeOwner(isChangeOwner: Boolean) {
        // Set the changeOwner value
        changeOwner = isChangeOwner

        if (isChangeOwner) {
            // If the owner is to be changed, get the current user's chat user id
            val currentChatUserId = AppSession.getUser().chatUserId

            // Remove the member from memberList who matches the current user's chat user id
            memberList.removeIf { it.memberId.equals(currentChatUserId, ignoreCase = true) }
        }

        // Notify that the data set has changed
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString().toLowerCase(Locale.ROOT)
                val filteringList = ArrayList<ConversationMember>()

                if (charString.isEmpty()) {
                    filteredMemberList = memberList
                } else {
                    // Perform filtering off the UI thread
                    for (row in memberList) {
                        val contact = contactCache[row.memberId]

                        // Check if row should be included in the filtered list based on the conversation type
                        when(conversation.conversationType){
                            Constants.TYPES.CONVERSATION_GROUP -> {
                                if (row.memberId!!.lowercase(Locale.ROOT).contains(charString) ||
                                    (contact?.name?.lowercase(Locale.ROOT)?.contains(charString) == true)) {
                                    filteringList.add(row)
                                }
                            }
                            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                                if (row.moniker!!.lowercase(Locale.ROOT).contains(charString)) {
                                    filteringList.add(row)
                                }
                            }
                        }
                    }
                    filteredMemberList = filteringList
                }

                val filterResults = FilterResults()
                filterResults.values = filteredMemberList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                filteredMemberList = filterResults.values as ArrayList<ConversationMember>
                notifyDataSetChanged()
            }
        }
    }

    init {
        this.isChatDetails = isChatDetails
        this.onLongMemberCallback = onLongMemberCallback
        this.onMembersCallback = onMembersCallback
        loadContactsIntoCache()

    }


    /**
     * Load all contacts into cache.
     *
     * Note: Ideally, this operation should be moved to a ViewModel or another class
     *       responsible for database operations. Adapter should not interact with database directly.
     */
    private fun loadContactsIntoCache() {
        CoroutineScope(Dispatchers.IO).launch {
            val contacts = MainApp.appContext?.contactsDao?.allContacts
            withContext(Dispatchers.Main) {
                contacts?.forEach { contact ->
                    contactCache[contact.chatUserId!!] = contact
                }
            }
        }
    }
}