package com.devbeans.io.chat.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.*
import com.devbeans.io.chat.adapters.HomeFragmentAdapter
import com.devbeans.io.chat.adapters.RecyclerCallBack
import com.devbeans.io.chat.adapters.RecyclerCallBack.OnRowClickListener
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.RoomsListCallback
import com.devbeans.io.chat.databinding.CustomBlockDailogBinding
import com.devbeans.io.chat.databinding.CustomDailogAddContactBinding
import com.devbeans.io.chat.databinding.FragmentHomeBinding
import com.devbeans.io.chat.extensions.*
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Payload
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
import com.devbeans.io.chat.verifypin.LogOutTimerUtil
import com.devbeans.io.chat.verifypin.PinDialog
import com.devbeans.io.chat.viewmodels.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Response
import java.io.File

//********************************************
class HomeFragment  //********************************************
    : Fragment(), RoomsListCallback //********************************************
{
    private var mBinding: FragmentHomeBinding? = null
    private var mViewModel: HomeFragmentViewModel? = null
    private var mAdapter: HomeFragmentAdapter? = null
    private var mTouchListener: RecyclerCallBack? = null
    private val TAG = Log.tag(HomeFragment::class.java)
    private var activeContextMenu: ChatContextMenu? = null
    private val LEAVE_GROUP_SHOW_MEMBERS_ACTIVITY = 0
    private val LEAVE_GROUP_LEAVE = 1
    private val conversationsDao by lazy {
        MainApp.appContext?.conversationsDao
    }
    private val messagesDao by lazy {
        MainApp.appContext?.messagesDao
    }
    private val contactsDao by lazy {
        MainApp.appContext?.contactsDao
    }
    private val conversationChannelsDao by lazy {
        MainApp.appContext?.conversationChannelsDao
    }

    //*********************************************************
    override fun onAttach(context: Context) //*********************************************************
    {
        super.onAttach(context)
        mViewModel = ViewModelProvider(requireActivity()).get(
            HomeFragmentViewModel::class.java
        )
    }

    //********************************************
    override fun onCreate(savedInstanceState: Bundle?) //********************************************
    {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(
            mMessageReceiver,
            IntentFilter("custom-event-name")
        )
    }

    //********************************************
    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? //********************************************
    {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
//        mBinding!!.toolbar.inflateMenu(R.menu.home_menu)
//        mBinding!!.toolbar.setOnMenuItemClickListener { item: MenuItem ->
//            when (item.itemId) {
//                R.id.action_lock_chat_app -> {
//                    SettingsValues.setPassCodeAlreadyShowing(true)
//                    PinDialog.dialogINSTANCE()!!.createPinDialog(requireContext(), "home")
////                    PinDialog.with().createPinDialog(this, "timeout")
//                    AppSession.put(Constants.LOCK.KEY_KEEP_LOCK, true)
//                    LogOutTimerUtil.stopLogoutTimer()
//                }
//
//                R.id.action_settings -> {
//                    Log.e(TAG, "settings")
//                    NavHostFragment.findNavController(this@HomeFragment)
//                        .navigate(R.id.action_homeFragment_to_profileManageFragment)
//                }
//
//                R.id.action_create_new_group -> {
//                    Log.e(TAG, "settings")
//                    if (Utills.isSubscriptionExpired()) {
//                        Utills.showSubscriptionEnd()
//                    } else {
//                        val intent = Intent(requireActivity(), NewMessageActivity::class.java)
//                        startActivity(intent)
//                    }
//
//                }
//            }
//            true
//        }


        populateRecyclerView()
        observers()
        listeners()
        setSwipeAble()
        setSearchConversations()
        return mBinding!!.getRoot()
    }

    //************************************************************
    private fun listeners() {
        mBinding!!.archiveLayout.setOnClickListener {
            val intent = Intent(requireActivity(), ArchiveActivity::class.java)
            startActivity(intent)
        }
        mBinding!!.fab.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            } else {
                val intent = Intent(requireActivity(), NewMessageActivity::class.java)
                startActivity(intent)
            }
        }
        mBinding!!.archLayout.setOnClickListener {
            startActivity(Intent(requireActivity(), ArchiveActivity::class.java))
        }


        mBinding?.let { binding ->
            binding.ivMenu.setOnClickListener {
                if (activeContextMenu != null) {
                    Log.e(TAG, "Already showing a context menu.")
                    return@setOnClickListener
                }

                val items = mutableListOf<ActionItem>()
                items.add(
                    ActionItem(
                        0,
                        AndroidUtil.getString(
                            R.string.create_new_group
                        )
                    ) {
                        if (Utills.isSubscriptionExpired()) {
                            Utills.showSubscriptionEnd()
                        } else {
                            val intent = Intent(requireActivity(), NewMessageActivity::class.java)
                            startActivity(intent)
                        }
                    }
                )

                items.add(
                    ActionItem(
                        0,
                        AndroidUtil.getString(
                            R.string.settings
                        )
                    ) {
                        NavHostFragment.findNavController(this@HomeFragment)
                            .navigate(R.id.action_homeFragment_to_profileManageFragment)

                    }
                )
                activeContextMenu = ChatContextMenu.Builder(binding.ivMenu, binding.frameLayout)
                    .offsetX(ViewUtil.dpToPx(2))
                    .onDismiss {
                        // Set activeContextMenu to null when context menu is dismissed
                        activeContextMenu = null
                    }.preferredVerticalPosition(ChatContextMenu.VerticalPosition.BELOW)
                    .preferredHorizontalPosition(ChatContextMenu.HorizontalPosition.END)
                    .show(items)

            }

            binding.ivLock.setOnClickListener{
                SettingsValues.setPassCodeAlreadyShowing(true)
                PinDialog.dialogINSTANCE()!!.createPinDialog(requireContext(), "home")
//                    PinDialog.with().createPinDialog(this, "timeout")
                AppSession.put(Constants.LOCK.KEY_KEEP_LOCK, true)
                LogOutTimerUtil.stopLogoutTimer()
            }
        }
    }

    private fun setSwipeAble() {
        mTouchListener = RecyclerCallBack(requireActivity(), mBinding!!.rlChats)
        mTouchListener!!
            .setClickable(object : OnRowClickListener {
                override fun onRowClicked(position: Int) {}
                override fun onIndependentViewClicked(independentViewID: Int, position: Int) {}
            })
            .setSwipeOptionViews(R.id.delete_task, R.id.archive_task, R.id.pin_task)
            .setSwipeable(
                R.id.rowFG,
                R.id.rowBGRight,
                R.id.rowBGLeft
            ) { viewID: Int, position: Int ->
                when (viewID) {
                    R.id.delete_task -> {}
                    R.id.archive_task -> {}
                    R.id.pin_task -> {}
                }
            }
        mBinding!!.rlChats.addOnItemTouchListener(mTouchListener!!)
    }

    //********************************************
    @RequiresApi(api = Build.VERSION_CODES.N)
    private fun observers() //********************************************
    {
        conversationsDao?.liveConversations?.observe(viewLifecycleOwner) { chatRooms: MutableList<Conversation?>? ->
            assert(chatRooms != null)
            mBinding!!.tvTextNotification.visibility =
                if (chatRooms!!.size == 0) View.VISIBLE else View.GONE
            mBinding!!.archiveLayout.visibility = View.GONE
            if (conversationsDao?.archiveConversations != null && conversationsDao?.archiveConversations?.size!! > 0
            ) {
                if (mBinding!!.archLayout.visibility != View.VISIBLE) {
                    mBinding!!.archLayout.visibility = View.VISIBLE
                }
            } else {
                if (mBinding!!.archLayout.visibility != View.GONE) {
                    mBinding!!.archLayout.visibility = View.GONE
                }
            }
            //            Collections.reverse(chatRooms);
//            chatRooms.sort(Comparator.comparing(o-> DateTime.getDateFromString(o.getMessages().get(o.getMessages().size()-1).getCreatedAt())));
//            Collections.sort(chatRooms, new Comparator<Conversation>() {
//
//                @Override
//                public int compare(Conversation o1, Conversation o2) {
//                    try {
//                        return new SimpleDateFormat("MMM dd, yyyy - hh:mm:ss a").parse(o1.getLastMessage().getCreatedAt()).compareTo(new SimpleDateFormat("MMM dd, yyyy - hh:mm:ss a").parse(o2.getLastMessage().getCreatedAt()));
//                    } catch (ParseException e) {
//                        return 0;
//                    }
//                }
//            });

            mAdapter!!.setChatRoomList(chatRooms)
        }
    }

    private fun setSearchConversations() {
        mBinding!!.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            @RequiresApi(api = Build.VERSION_CODES.N)
            override fun afterTextChanged(s: Editable) {
                filter(s.toString())
            }
        })
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private fun filter(text: String) {
        val filteredList = mutableListOf<Conversation?>()
        if (conversationsDao!!
                .allConversations != null && !conversationsDao!!.allConversations.isEmpty()
        ) {
            for (item in conversationsDao!!.allConversations) {
                if (item.name!!.toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item)
                }
            }
            mAdapter!!.filteredList(filteredList)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onResume() {
        super.onResume()
        mBinding!!.rlChats.addOnItemTouchListener(mTouchListener!!)
        try {
//            mBinding.rlChats.setItemAnimator(null);
        } catch (e: Exception) {
            e.printStackTrace()
        }
        observers()
        UIUtils.hideKeyboard(requireActivity())
    }

    override fun onDestroyView() {
        conversationsDao?.liveConversations?.removeObservers(viewLifecycleOwner)
        super.onDestroyView()
    }

    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getSerializableExtra("payload") as Payload?
            Log.e(TAG, message.toString())
        }
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(mMessageReceiver)
        super.onDestroy()
    }

    //************************************************************
    private fun populateRecyclerView() //************************************************************
    {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mBinding!!.rlChats.layoutManager = layoutManager
        mAdapter = HomeFragmentAdapter(requireActivity(), this)
        mBinding!!.rlChats.setHasFixedSize(true)
        mBinding!!.rlChats.adapter = mAdapter
    }

    //************************************************************
    override fun onRoomClick(
        conversation: Conversation,
        name: String,
        chatId: String,
        id: Int,
        color: String,
        isContact: Boolean
    ) //************************************************************
    {
        startActivity(
            Intent(context, ChatActivity::class.java)
                .putExtra("conversation", conversation)
                .putExtra("name", name)
                .putExtra("type", conversation.conversationType)
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
            if (!isArchived) {
                val actionItem = ActionItem(
                    R.drawable.ic_archive_menu,
                    AndroidUtil.getString(
                        R.string.archive_menu,
                        when (room.conversationType) {
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE -> "chat"
                            else -> "group"
                        }
                    )
                ) { handleConversationArchive(room) }
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
                    //get current user
                    val user = AppSession.getUser()

                    val conMembersSize =
                        room.conversationMembers?.filterNot { it.memberId.equals(user?.chatUserId) }?.size
                            ?: 0
                    // check if there are more than two members in conversation
                    if (conMembersSize > 1) {

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
        }


        // Create a ChatContextMenu and display it
        activeContextMenu = ChatContextMenu.Builder(anchor, mBinding?.frameLayout!!)
            .offsetY(ViewUtil.dpToPx(2))
            .onDismiss {
                // Set activeContextMenu to null and deselect the view when context menu is dismissed
                activeContextMenu = null
                view.isSelected = false
                // Resume layout updates for the chat layout
                mBinding?.rlChats!!.suppressLayout(false)
            }.preferredVerticalPosition(ChatContextMenu.VerticalPosition.BELOW)
            .show(items)

// Suspend layout updates for the chat layout
        mBinding?.rlChats!!.suppressLayout(true)

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
        val alertCustomdialog = LayoutInflater.from(requireContext())
            .inflate(R.layout.custom_block_dailog, null)
        val dialogBinding = CustomBlockDailogBinding.bind(alertCustomdialog)

        // Create the alert dialog with the custom layout
        val alert = AlertDialog.Builder(requireContext())
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
                val intent = Intent(requireActivity(), MembersActivity::class.java).apply {
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
                                                    conversationChannelsDao?.deleteConversationChannel(
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
                        requireActivity()
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
            val dialog = AlertDialog.Builder(requireActivity())
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

            val contacts: List<Contact>? = contactsDao?.allContacts
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

    private fun handleConversationArchive(conversation: Conversation?) {
        conversationsDao?.updateConversationArchive(
            conversation?.conversationId,
            true
        )
    }

    companion object {
        //********************************************
        fun newInstance(): HomeFragment
        //********************************************
        {
            return HomeFragment()
        }
    }
}