package com.devbeans.io.chat.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.network.ApiHelper.Companion.with
import com.devbeans.io.chat.utils.DateTime.getCurrentDateTime
import com.devbeans.io.chat.utils.Utills.getRandomString
import com.devbeans.io.chat.utils.Utills.showSubscriptionBanner
import com.devbeans.io.chat.verifypin.BaseActivity
import com.devbeans.io.chat.callBacks.OnLongMemberCallback
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.callBacks.OnMembersCallback
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.adapters.GroupMemberAdapter
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.network.serializers.requestbody.LeaveOwnerGroupRequest
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.utils.RequestCodes
import kotlin.Throws
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.databinding.ActivityMembersBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.logging.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.text.ParseException
import java.util.*


class MembersActivity : BaseActivity(), OnLongMemberCallback, OnNetworkResponse, OnMembersCallback,
    ExpiryCallback {
    private lateinit var mBinding: ActivityMembersBinding
    private lateinit var mMembersAdapter: GroupMemberAdapter
    private val memberList: MutableList<ConversationMember> = mutableListOf()
    private var mMember: ConversationMember? = null
    private var conversation_pk = 0
    private val TAG = MembersActivity::class.java.simpleName
    var fromOwnerChange = false
    var mConversation: Conversation? = null
    private var contactCache = HashMap<String, Contact?>()

    init {

        // Cache all contacts
        CoroutineScope(Dispatchers.IO).launch {
            val contacts = contactsDao.allContacts
            contacts?.forEach { contact -> contactCache[contact.chatUserId!!] = contact }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_members)
        setToolBar(mBinding.toolbar)
        appContext!!.currentActivity = this
        appContext!!.expiryListener = this
        getConvoData()
        initViews()
        populateRecyclerView()
        listeners()
    }

    // Initialize the view based on conditions
    private fun initViews() {
        mBinding.btnLeave.visibility = if (fromOwnerChange) View.VISIBLE else View.GONE
        mBinding.tvTitle.text = if (fromOwnerChange) "Choose Owner" else "Members"
    }

    // Handling click listener
    private fun listeners() {
        mBinding.btnLeave.setOnClickListener {
            if (fromOwnerChange && mMember?.isSelected == true) {
                ownerLeaveGroup(mMember!!)
            } else {
                Notify.Toast("Owner is Required")
            }
        }
    }


    private fun ownerLeaveGroup(mMember: ConversationMember) {
        val request = LeaveOwnerGroupRequest()
        request.userChatId = AppSession.getUser().chatUserId
        request.replacedId = mMember.memberId
        Log.d(
            TAG,
            "Members Activity ownerLeaveGroup: " + "End Point: " + RequestCodes.API_END_POINTS.OWNER_LEAVE_GROUP +
                    " Request: " +
                    request.toString()
        )
        conversation_pk = mConversation!!.uid
        if (with() != null) with()!!
            .ownerLeaveGroup(mConversation!!.conversationId, request, this, this@MembersActivity)
        //        NetworkCall.make()
//                .setCallback(this)
//                .setTag(RequestCodes.API.OWNER_LEAVE_GROUP)
//                .autoLoadingCancel(Utills.INSTANCE.getLoading(this, "Please wait"))
//                .enque(Network.apis().leaveOwnerGroup(mConversation.getConversationId(), request))
//                .execute();
    }

    override fun onResume() {
        appContext!!.currentActivity = this
        appContext!!.expiryListener = this
        super.onResume()
    }

    private fun getConvoData() {
        if (intent.hasExtra("conversation")) {
            mConversation = intent.getSerializableExtra("conversation") as? Conversation
        }
        if (intent.hasExtra("fromChangeOwner")) {
            fromOwnerChange = true
        }
    }


    private fun setSearchMembers() {
        mBinding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            @RequiresApi(api = Build.VERSION_CODES.N)
            override fun afterTextChanged(s: Editable) {
                mMembersAdapter.filter.filter(s)
            }
        })
    }


    private fun filter(text: String) {
        val filteredList = mutableListOf<ConversationMember>()

        if (fromOwnerChange) { // If the owner is to be changed, get the current user's chat user id
            val currentChatUserId = AppSession.getUser().chatUserId

            // Remove the member from memberList who matches the current user's chat user id
            memberList.removeIf { it.memberId.equals(currentChatUserId, ignoreCase = true) }
        }

        if (text.trim().isNotEmpty() && memberList.isNotEmpty()
        ) {
            when {
                mConversation?.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP) -> {
                    for (row in memberList) {
                        val contact = contactCache[row.memberId]

                        // If memberId or contact's name contains the filter string, add to the filtering list
                        if (row.memberId!!.lowercase(Locale.ROOT).contains(text) ||
                            (contact?.name?.lowercase(Locale.ROOT)?.contains(text) == true)
                        ) {
                            filteredList.add(row)
                        }
                    }
                }

                mConversation?.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS) -> {
                    for (row in memberList) {
                        // this is kept if a feature comes to search using contact name for owner
                        val contact = contactCache[row.memberId]

                        // If memberId or contact's name contains the filter string, add to the filtering list
                        if (row.moniker!!.lowercase(Locale.ROOT).contains(text)
                        ) {
                            filteredList.add(row)
                        }
                    }
                }

            }

            if (filteredList.isNotEmpty()) {
                mMembersAdapter.filteredList(filteredList)
            }
        } else {
            mMembersAdapter.setMemberList(memberList, false)
            mMembersAdapter.notifyDataSetChanged()
        }
    }

    //************************************************************
    private fun setToolBar(toolbar: Toolbar) //************************************************************
    {
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    fun populateRecyclerView() {
        // Let's use the let function to handle the nullability of mBinding and mConversation
        mBinding.let { binding ->
            mConversation?.let { conversation ->
                val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvMembers.layoutManager = layoutManager
                mMembersAdapter = GroupMemberAdapter(conversation, this, false, this, this)

                // Handle nullability and directly pass non-null members to setMembersName function
                setMembersName(conversation.conversationMembers ?: emptyList())

                val sortedList = conversation.conversationMembers?.sortedByDescending { member ->
                    when {
                        conversation.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS) -> member.isMe
                        else -> member.memberId.equals(AppSession.getUser().chatUserId)
                    }
                } ?: emptyList()

                binding.rvMembers.adapter = mMembersAdapter
                mMembersAdapter.setMemberList(sortedList.toMutableList(), false)
                mMembersAdapter.isChangeOwner(fromOwnerChange)
                setSearchMembers()
            }
        }
    }


    // Avoid null checks by directly passing required non-null members to setMembersName function
    private fun setMembersName(members: List<ConversationMember>) {
        members.forEach { member ->
            if (fromOwnerChange) {
                if (member.memberId.equals(
                        AppSession.getUser().chatUserId,
                        ignoreCase = true
                    )
                ) {
                    // do nothing in case of owner change as the owner can not make itself owner and leave group
                } else {
                    memberList.add(member)
                }
            } else {
                memberList.add(member)
            }
        }
        changeIndexOfMembers()
        Log.d("TAG", "setMembersName: $memberList")
    }

    private fun changeIndexOfMembers() {
        val userChatId = AppSession.getUser().chatUserId
        memberList.let { list ->
            val index = list.indexOfFirst { it.memberId.equals(userChatId, ignoreCase = true) }
            if (index > 0) { // if member is not already first in list
                val member = list.removeAt(index)
                list.add(0, member)
            }
        }
    }


    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onLongMemberCallback(member: ConversationMember, name: String) {
        // was essential to over ride
    }

    /**
     * Callback for successful network calls.
     * @param call The executed call.
     * @param response The response for the executed call.
     * @param tag An object used for identifying the call.
     * @throws ParseException if any error occurs during parsing the response.
     */
    @Throws(ParseException::class)
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag is Int && tag == RequestCodes.API.OWNER_LEAVE_GROUP && response.code() == 200) {
            (response.body() as? NewConversationResponse)?.let { res ->
                res.conversation?.let { conversation ->
                    Log.d(
                        TAG,
                        "Members Activity Owner Leave Group: " + "End Point: " + RequestCodes.API_END_POINTS.OWNER_LEAVE_GROUP +
                                " Response: " + res
                    )
                    val payload = Payload().apply {
                        conversationId = mConversation?.conversationId
                        conversationType = "group"
                        createdAt = getCurrentDateTime()
                        type = "change_owner"
                        messageId = getRandomString(21)
                        userChatId = AppSession.getUser().chatUserId
                        data = "You left"
                    }
                    messagesDao.insert(payload)

                    mConversation = conversation.apply {
                        uid = conversation_pk
                        isRemoved = true
                        sequenceOfConversation = System.currentTimeMillis()
                    }
                    conversationsDao.update(mConversation)

                    ChatActivity.getInstance()?.let { chatActivity ->
                        chatActivity.conversation?.let { chatConversation ->
                            if (chatConversation.conversationId.equals(
                                    mConversation?.conversationId,
                                    ignoreCase = true
                                )
                            ) {
                                chatActivity.conversation = mConversation
                                mConversation?.lastMessage = payload
                                chatActivity.removedFromConvo(payload)
                                chatActivity.setMembersName()
                            }
                        }
                    }

                    initViews()

                    Intent(appContext, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        appContext?.startActivity(this)
                    }

                    finish()
                }
            } ?: Notify.Toast("No data found")
        }
    }


    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        // was essential to over ride
    }

    override fun onMemberCallback(member: ConversationMember, name: String) {
        if (fromOwnerChange) {
            mMember = member
        }
    }

    override fun notifyExpiry() {
        if (mBinding != null) {
            showSubscriptionBanner(mBinding!!.tvSubs)
        }
    }

    companion object {
        var instance: MembersActivity? = null


        @JvmName("getInstance1")
        fun getInstance(): MembersActivity? {
            if (instance == null) {
                instance = MembersActivity()
            }
            return instance
        }
    }
}