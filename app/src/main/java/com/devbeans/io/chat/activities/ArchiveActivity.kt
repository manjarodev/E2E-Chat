package com.devbeans.io.chat.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.ArchiveAdapters
import com.devbeans.io.chat.adapters.RecyclerCallBack
import com.devbeans.io.chat.adapters.RecyclerCallBack.OnRowClickListener
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityArchiveBinding
import com.devbeans.io.chat.databinding.CustomBlockDailogBinding
import com.devbeans.io.chat.databinding.CustomDailogAddContactBinding
import com.devbeans.io.chat.extensions.*
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.User
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.requestbody.LeaveGroupRequest
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.GetProfileResponse
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.components.menu.ChatContextMenu
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.utils.views.ActionItem
import com.devbeans.io.chat.utils.views.ViewUtil
import com.devbeans.io.chat.verifypin.BaseActivity
import com.devbeans.io.chat.viewmodels.ArchiveActivityViewModel
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.util.*

//************************************************************
class ArchiveActivity :
    BaseActivity(), ArchiveRoomsListCallback, ExpiryCallback
//************************************************************
{
    private var mBinding: ActivityArchiveBinding? = null
    private var mTouchListener: RecyclerCallBack? = null
    private var mViewModel: ArchiveActivityViewModel? = null
    private var mAdapter: ArchiveAdapters? = null
    private var activeContextMenu: ChatContextMenu? = null
    private val LEAVE_GROUP_SHOW_MEMBERS_ACTIVITY = 0
    private val LEAVE_GROUP_LEAVE = 1

    //************************************************************
    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?)
    //************************************************************
    {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_archive)
        WindowUtil.setStatusBarColor(window,AndroidUtil.getColor(R.color.bg_window_fill_color))
        setToolBar(mBinding!!.toolbar)
        mViewModel = ViewModelProvider(this).get(ArchiveActivityViewModel::class.java)
        setContentView(mBinding!!.getRoot())
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        observers()
        populateRecyclerView()
        setSwipeAble()
    }

    //************************************************************
    @RequiresApi(api = Build.VERSION_CODES.N)
    private fun observers()
    //************************************************************
    {
//        mViewModel!!.getmChatRoomList()
//            .observe(this) { chatRooms: List<ChatRoom?>? -> mAdapter!!.setChatRoomList(chatRooms) }

        conversationsDao
            .liveArchiveConversations.observe(this) { chatRooms: List<Conversation?>? ->
                assert(chatRooms != null)
                mBinding!!.tvTextNotification.visibility =
                    if (chatRooms!!.isEmpty()) View.VISIBLE else View.GONE

                if (chatRooms != null) {
                    mAdapter!!.setChatRoomList((chatRooms.toList() as List<Conversation>).toMutableList())
                }
            }

    }

    private fun setSwipeAble() {
        mTouchListener = RecyclerCallBack(this, mBinding!!.rvChats)
        mTouchListener!!
            .setClickable(object : OnRowClickListener {
                override fun onRowClicked(position: Int) {
                    //not being used because we are using binding in viewHolder
                }

                override fun onIndependentViewClicked(independentViewID: Int, position: Int) {
                    //not being used because we are using binding in viewHolder
                }
            })
            .setSwipeOptionViews(R.id.delete_task, R.id.archive_task)
            .setSwipeable(R.id.rowFG, R.id.rowBGRight) { viewID, position ->
                when (viewID) {
                    R.id.delete_task -> {}
                    R.id.archive_task -> {}
                }
            }
        mBinding!!.rvChats.addOnItemTouchListener(mTouchListener!!)
    }

    //************************************************************
    private fun populateRecyclerView()
    //************************************************************
    {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mBinding!!.rvChats.layoutManager = layoutManager
        mAdapter = ArchiveAdapters(this, this)
        mBinding!!.rvChats.adapter = mAdapter
    }

    //************************************************************
    public override fun onResume()
    //************************************************************
    {
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        mBinding!!.rvChats.addOnItemTouchListener(mTouchListener!!)
        super.onResume()
    }

    //************************************************************
    private fun setToolBar(toolbar: Toolbar)
    //************************************************************
    {
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    // ******************************************************************
    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    // ******************************************************************
    {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRoomClick(
        conversation: Conversation?,
        name: String?,
        chatId: String?,
        id: Int,
        color: String?,
        isContact: Boolean
    ) {

        startActivity(
            Intent(this@ArchiveActivity, ChatActivity::class.java)
                .putExtra("conversation", conversation)
                .putExtra("name", name)
                .putExtra("type", conversation!!.conversationType)
                .putExtra("color", color)
                .putExtra("isContact", isContact)
                .putExtra("chatID", chatId)
                .putExtra("ContactID", id)
        )

    }


    override fun onRoomLongClick(
        room: Conversation?,
        name: String?,
        id: String?,
        i: Int,
        color: String?,
        isContact: Boolean,
        view: View,
        anchor: View
    ) {

        // Check if there is already an active context menu
        if (activeContextMenu != null) {
            Log.e(TAG, "Already showing a context menu.")
            return
        }

        // Set the selected state of the view to true
        view.isSelected = true

        // Create a list of action items to show in the context menu
        val items = mutableListOf<ActionItem>()


        // Add the mute notifications option (currently commented out)
        //items.add(
        //    ActionItem(
        //        R.drawable.ic_notification_menu,
        //        AndroidUtil.getString(R.string.mute_notifications)
        //    ) {
        //        handleConversationMute(room)
        //    })


        // Handle the pin/unpin options
        room?.isPinned?.let { isPinned ->
            val actionItem = when (isPinned) {
                true -> ActionItem(
                    R.drawable.ic_unpin_menu,
                    AndroidUtil.getString(
                        R.string.unPin,
                        when (room.conversationType) {
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE -> "chat"
                            else -> "group"
                        }
                    )
                ) { handleConversationUnPinned(room) }
                false -> ActionItem(
                    R.drawable.ic_pin_menu,
                    AndroidUtil.getString(
                        R.string.pin,
                        when (room.conversationType) {
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE -> "chat"
                            else -> "group"
                        }
                    )
                ) { handleConversationPinned(room) }
            }
            items.add(actionItem)
        }

        // Add the archive option
        room?.isArchived?.let { isArchived ->
            if (isArchived) {
                val actionItem = ActionItem(
                    R.drawable.ic_unarchive_menu,
                    AndroidUtil.getString(
                        R.string.unarchive_menu,
                        when (room.conversationType) {
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE -> "chat"
                            else -> "group"
                        }
                    )
                ) { handleConversationUnArchive(room) }
                items.add(actionItem)
            }
        }

        // Add the clear conversation option
        items.add(
            ActionItem(
                R.drawable.ic_empty_chat_menu,
                AndroidUtil.getString(
                    R.string.empty_chat,
                    when (room?.conversationType) {
                        Constants.TYPES.CONVERSATION_ONE_TO_ONE -> "chat"
                        else -> "group"
                    }
                )
            ) { handleConversationClear(room) }
        )


        // Handle options specific to the conversation type
        when (room?.conversationType!!) {
            Constants.TYPES.CONVERSATION_ONE_TO_ONE -> {
                // Add the delete conversation option
                items.add(
                    ActionItem(
                        R.drawable.ic_delete_chat_menu,
                        AndroidUtil.getString(R.string.delete_chat)
                    ) { handleConversationDelete(room) }
                )

                // Add the add to contacts option if the conversation is not with an existing contact
                if (!isContact) {
                    items.add(
                        ActionItem(
                            R.drawable.ic_add_contact_menu,
                            AndroidUtil.getString(R.string.add_to_contacts)
                        ) { handleAddToContact(room) }
                    )
                }
            }
            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                // Handle options for anonymous group conversations
                if (room.isRemoved) {
                    // Add the delete group option if conversation is left or removed
                    items.add(
                        ActionItem(
                            R.drawable.ic_delete_chat_menu,
                            AndroidUtil.getString(R.string.delete_group)
                        ) { handleConversationDelete(room) }
                    )
                } else {
                    // Determine the sender id based on the conversation type
                    val senderId = when (room.conversationType) {
                        Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                            room.conversationMembers?.firstOrNull { it.isMe }?.memberId
                        }
                        else -> {
                            AppSession.getUser().chatUserId
                        }
                    }?.takeIf { it.isNotEmpty() }

                    if (!room.owner?.equals(senderId)!! && room.conversationMembers?.size!! > 3) {
                        // Add the exit (leave group) option if the user is not the owner
                        items.add(
                            ActionItem(
                                R.drawable.ic_exit_group_menu,
                                AndroidUtil.getString(R.string.exit_group)
                            ) { handleConversationExit(room) }
                        )
                    }
                }
            }
            else -> {
                // Handle options for group conversations
                if (room.isRemoved) {
                    // Add the delete group option if conversation is left or removed
                    items.add(
                        ActionItem(
                            R.drawable.ic_delete_chat_menu,
                            AndroidUtil.getString(R.string.delete_group)
                        ) { handleConversationDelete(room) }
                    )
                } else {
                    // Add the exit (leave group) option
                    items.add(
                        ActionItem(
                            R.drawable.ic_exit_group_menu,
                            AndroidUtil.getString(R.string.exit_group)
                        ) { handleConversationExit(room) }
                    )
                }
            }
        }



        // Create a ChatContextMenu and display it
        activeContextMenu = ChatContextMenu.Builder(anchor, mBinding?.rvChats!!)
            .onDismiss {
                // Set activeContextMenu to null and deselect the view when context menu is dismissed
                activeContextMenu = null
                view.isSelected = false
                // Resume layout updates for the chat layout
                mBinding?.rvChats!!.suppressLayout(false)
            }
            .show(items)

// Suspend layout updates for the chat layout
        mBinding?.rvChats!!.suppressLayout(true)

// Call the parent method to handle the long click on a chat room
        super.onRoomLongClick(room, name, id, i, color, isContact, view, anchor)

    }

    private fun handleConversationExit(conversation: Conversation) {
        showCustomDialog(5, conversation)
    }


    private fun showCustomDialog(option: Int, conversation: Conversation) {
        // Determine the sender id based on the conversation type
        val senderId = when (conversation?.conversationType) {
            Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                conversation.conversationMembers?.firstOrNull { it.isMe }?.memberId
            }
            else -> {
                AppSession.getUser().chatUserId
            }
        }?.takeIf { it.isNotEmpty() }

        // Inflate the custom dialog layout
        val alertCustomdialog = LayoutInflater.from(this@ArchiveActivity)
            .inflate(R.layout.custom_block_dailog, null)
        val dialogBinding = CustomBlockDailogBinding.bind(alertCustomdialog)

        // Create the alert dialog with the custom layout
        val alert = AlertDialog.Builder(this@ArchiveActivity)
            .setView(dialogBinding.root)
            .create()

        // Make the dialog's background transparent
        alert.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Handle different options
        when (option) {
            5 -> setLeaveGroupTexts(dialogBinding, conversation, senderId)
        }

        // Show the dialog
        alert.show()

        // Set click listeners for the buttons
        dialogBinding.btnBlock.setOnClickListener(
            getBlockClickListener(
                option,
                conversation,
                alert,
                senderId
            )
        )
        dialogBinding.btnCancel.setOnClickListener { alert.dismiss() }
    }

    // Helper function to create a click listener for the "Block" button
    private fun getBlockClickListener(
        option: Int,
        conversation: Conversation,
        alert: AlertDialog,
        senderId: String?
    ): View.OnClickListener {
        return View.OnClickListener {
            when (option) {
                5 -> {
                    if (!Utills.isSubscriptionExpired()) {
                        if (conversation?.owner.equals(senderId, ignoreCase = true)) {
                            leaveGroup(0, conversation, alert)
                        } else {
                            leaveGroup(1, conversation, alert)
                        }
                    } else {
                        Utills.showSubscriptionEnd()
                    }
                }
            }
        }
    }


    // Method to set the title and notification texts based on whether the user is the owner or not
    private fun setLeaveGroupTexts(
        dialogBinding: CustomBlockDailogBinding,
        conversation: Conversation?,
        senderId: String?
    ) {
        if (conversation != null) {
            if (conversation.owner.equals(senderId, ignoreCase = true)) {
                dialogBinding.tvTitle.text =
                    String.format(getString(R.string.leave_group_title, conversation.name))
                dialogBinding.tvDeleteNotification.text = getString(R.string.owner_change_alert)
                dialogBinding.btnBlock.text = Constants.CHANGE_OWNER
            } else {
                dialogBinding.tvTitle.text =
                    String.format(getString(R.string.leave_group_title, conversation.name))
                dialogBinding.tvDeleteNotification.text = getString(R.string.leave_group_alert)
                dialogBinding.btnBlock.text = Constants.LEAVE_GROUP
            }
        }
    }


    private fun leaveGroup(
        dialogOption: Int,
        conversation: Conversation,
        mCreateDialog: AlertDialog
    ) {
        when (dialogOption) {
            // Show members activity for change owner
            LEAVE_GROUP_SHOW_MEMBERS_ACTIVITY -> {
                val intent = Intent(this@ArchiveActivity, MembersActivity::class.java).apply {
                    putExtra("conversation", conversation)
                    putExtra("fromChangeOwner", "fromChangeOwner")
                }
                startActivity(intent)
            }
            // Leave group
            LEAVE_GROUP_LEAVE -> {
                val request = LeaveGroupRequest().apply {
                    user_chat_id = AppSession.getUser()?.chatUserId.orEmpty()
                }

                ChatExecutors.SERIAL.execute {
                    // Make network call to leave the group
                    ApiHelper.with()?.leaveGroup(
                        conversation.conversationId,
                        request,
                        object : OnNetworkResponse {
                            override fun onSuccess(
                                call: Call<*>?,
                                response: Response<*>?,
                                tag: Any?
                            ) {
                                if (tag == RequestCodes.API.LEAVE_GROUP && response?.code() == 200) {
                                    val res = response.body() as NewConversationResponse?
                                    if (res?.conversation != null) {
                                        if (mCreateDialog.isShowing) mCreateDialog.dismiss()
                                        Log.d(
                                            ChatDetailsActivity.TAG,
                                            ("Chat Details Activity Leave Group: " + Constants.END_POINT + RequestCodes.API_END_POINTS.LEAVE_GROUP + Constants.RESPONSE + res.toString())
                                        )

                                        conversationsDao?.updateConversationSequenceTime(
                                            conversation.conversationId,
                                            System.currentTimeMillis()
                                        )
                                        conversationsDao?.updateRemovedConversation(conversation.conversationId)

                                        if (conversation.conversationType.equals(
                                                Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS,
                                                ignoreCase = true
                                            )
                                        ) {
                                            // Delete conversation channels for anonymous group
                                            conversation.conversationMembers?.forEach { member ->
                                                member.moniker?.let {
                                                    conversationChannelsDao.deleteConversationChannel(
                                                        Utills.getHash("${conversation.conversationId}&&$it")!!
                                                    )
                                                }
                                            }
                                        } else {
                                            conversationsDao?.updateMyMoniker(
                                                conversation.conversationId,
                                                AppSession.getUser()?.chatUserId.orEmpty()
                                            )
                                        }
                                    } else {
                                        Notify.Toast(Constants.NO_DATA_FOUND)
                                    }
                                }
                            }

                            override fun onFailure(
                                call: Call<*>?,
                                response: BaseResponse?,
                                tag: Any?
                            ) {
                                // Handle network failure

                                Log.e(TAG, "Error in response $response")
                            }
                        },
                        this@ArchiveActivity
                    )
                }
            }
        }
    }

    private fun handleAddToContact(conversation: Conversation?) {
        // Get the user ID
        val userId = AppSession.getUser()?.chatUserId
        // Get the member ID of the other person in the conversation
        val memberId = conversation?.conversationMembers.orEmpty()
            .filterNot { it.memberId == userId }
            .firstOrNull()?.memberId

        // If a member ID is found, call the API to get the user profile data
        memberId?.let { it ->

            // Initialize the API helper
            val apiHelper = ApiHelper.with()

            // Call the API to get the profile data for the other person in the conversation
            apiHelper?.profileData(userId, it, object : OnNetworkResponse {
                override fun onSuccess(call: Call<*>?, response: Response<*>?, tag: Any?) {
                    // If the API call is successful, check the tag to see which API call it was
                    if (tag == RequestCodes.API.GET_PROFILE) {
                        // If the response code is 200, parse the response body and show the add contact dialog
                        if (response?.code() == 200) {
                            val res = response.body() as GetProfileResponse?
                            res?.user?.let { user ->
                                showAddContactDialog(user, conversation)
                            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
                        }
                    }
                }

                override fun onFailure(call: Call<*>?, response: BaseResponse?, tag: Any?) {
                    // If the API call fails, log the error response
                    Log.e(TAG, "Error in response $response")
                }
            })
        }
    }


    /**
     * Displays a custom dialog to add a contact.
     *
     * @param user the user to add as a contact
     * @param conversation the conversation the user belongs to
     */
    private fun showAddContactDialog(user: User, conversation: Conversation?) {

        runOnUiThread { // Inflate the custom dialog layout using View Binding
            val binding = CustomDailogAddContactBinding.inflate(layoutInflater)

            // Populate the dialog views with data from the user
            user.apply {
                if (!TextUtils.isEmpty(this.chatNickName?.trim())) {
                    binding.etNewContact1.setText(user.chatNickName)
                }
            }
            binding.tvPriveId.text = user.chatUserId

            // Set focus on the first EditText view and show the keyboard
            ViewUtil.focusAndShowKeyboard(binding.etNewContact1)

            // Create a DialogFragment with the custom dialog layout and set its properties
            val dialog = AlertDialog.Builder(this@ArchiveActivity)
                .setView(binding.root)
                .create()

            // Set the dialog window background to be transparent
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            // Set click listeners for the cancel and add buttons
            binding.btnCancel.setOnClickListener { dialog.dismiss() }
            binding.btnAddContact.setOnClickListener {
                handleAddContactDialogButton(binding, user, conversation, dialog)
            }

            // Show the dialog
            dialog.show()
        }
    }


    /**
     * This function handles the button click for adding a contact.
     * It creates a new contact object with the user details entered by the user.
     * If the contact already exists in the database, it updates it.
     * If not, it adds a new contact.
     * It also updates the conversation name to the user's name.
     */
    private fun handleAddContactDialogButton(
        mCreateDialogBinding: CustomDailogAddContactBinding,
        user: User,
        conversation: Conversation?,
        mCreateDialog: AlertDialog
    ) {
        // Check if the user's subscription has expired
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }

        // Check if the user has entered a nickname for the contact
        if (!TextUtils.isEmpty(mCreateDialogBinding.etNewContact1.text.toString().trim())) {
            val contact = Contact().apply {
                chatUserId = user.chatUserId
                name = mCreateDialogBinding.etNewContact1.text.toString()
                color = Utills.colors.get(Utills.rnd.nextInt(Utills.colors.size))
                avatarColor = AvatarColor.random()
                user.chatNickName?.let {
                    if (it.trim().isNotEmpty()) {
                        alias = user.chatNickName!!
                    }
                }
            }

            val contacts: List<Contact>? = contactsDao.allContacts
            var hasContact = false
            var existedContact = Contact()

            // Check if the contact already exists in the database
            if (contacts != null && contacts.isNotEmpty()) {
                hasContact = contacts.any { contactInDb ->
                    contactInDb.chatUserId.equals(
                        contact.chatUserId, ignoreCase = true
                    )
                }
            }

            // If the contact exists, update it
            if (hasContact) {
//                If contact exist update it
            }
            // If not, add a new contact
            else {
                contactsDao?.insert(contact)
            }

            // Update the conversation name to the user's name
            conversation?.let {
                if (!TextUtils.isEmpty(contact.name)) {
                    conversationsDao?.updateName(
                        conversation.conversationId, conversation.name
                    )
                }
            }

            // Dismiss the dialog
            mCreateDialog.dismiss()
        }
        // If the user has not entered a nickname, show an error message
        else {
            Notify.Toast("Please Enter NickName ")
        }
    }


    private fun handleConversationDelete(conversation: Conversation) {
        handleConversationClear(conversation)
        ChatExecutors.SERIAL.execute {
            conversationsDao?.delete(conversation)
        }
    }

    private fun handleConversationClear(conversation: Conversation?) {
        ChatExecutors.SERIAL.execute {
            val mediaMessage =
                messagesDao?.getAllMediaMessages(conversation!!.conversationId)
            //Getting all the media files of the conversation for them to delete
            mediaMessage?.let {
                mediaMessage.forEach { payload ->
                    //If there are any media files delete them one by one
                    payload.filePath?.let {
                        val file = File(payload.filePath!!)
                        //if the file exist delete it from the file path
                        if (file.exists()) {
                            Utills.handleFileDelete(ChatDetailsActivity.TAG, file.delete())
                            messagesDao?.deleteByMessageId(payload.messageId)
                        }
                    }

                }
            }
            //Delete all messages of the conversation from local Database
            messagesDao?.deleteConversationMessages(conversation?.conversationId)


            //Removing last message of the conversation
            conversation?.lastMessage?.let {
                conversation.lastMessage = null
                try {
                    conversationsDao?.update(conversation)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }


        }
    }

    private fun handleConversationUnPinned(conversation: Conversation) {
        conversationsDao?.updatePinnedConversation(
            conversation.conversationId,
            false
        )
    }

    private fun handleConversationPinned(conversation: Conversation?) {
        conversationsDao?.updatePinnedConversation(
            conversation?.conversationId,
            true
        )
    }

    private fun handleConversationMute(conversation: Conversation?) {
        //this method is currently not being used
    }

    private fun handleConversationUnArchive(conversation: Conversation?) {
        conversationsDao?.updateConversationArchive(
            conversation?.conversationId,
            false
        )
    }


    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}