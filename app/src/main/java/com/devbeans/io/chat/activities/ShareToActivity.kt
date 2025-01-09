package com.devbeans.io.chat.activities


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import androidx.annotation.MainThread
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.ShareContactAdapter
import com.devbeans.io.chat.adapters.ShareToAdapter
import com.devbeans.io.chat.adapters.viewholders.ShareContactViewHolder
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.callBacks.ShareContactsCallback
import com.devbeans.io.chat.callBacks.ShareRoomsListCallback
import com.devbeans.io.chat.databinding.ActivityShareToBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.FilePath
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import com.devbeans.io.chat.verifypin.CreatePinActivity
import com.devbeans.io.chat.verifypin.LogOutTimerUtil
import java.util.*

//************************************************************
class ShareToActivity : BaseActivity(),
    ShareRoomsListCallback, ShareContactsCallback, ExpiryCallback
//************************************************************
{
    private var listOfContact: MutableList<Contact> = mutableListOf()
    private var isFromVault: Boolean = false
    private var mBinding: ActivityShareToBinding? = null
    private var payload: Payload? = null
    private var conversation: Conversation? = null
    private var mAdapter: ShareToAdapter? = null
    private var mShareAdapter: ShareContactAdapter? = null
    private val chatRoomToSend: MutableList<Conversation> = ArrayList()
    private var selectedTime = 1800000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_share_to)
        //        mViewModel = new ViewModelProvider(this).get(ShareToViewModel.class);
        roomData
        setToolBar(mBinding!!.toolbar)
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)

        initViews();
        observers()
        populateRecyclerView()
        setSearchConversations()
    }

    private fun initViews() {
        mBinding?.let {
            it.tvTitle.text =
                if (isFromVault) AndroidUtil.getString(R.string.share) else AndroidUtil.getString(R.string.forward_to)
            if (isFromVault)
                showContactsUI()
            else
                hideContactsUI()

        }
    }



    private fun hideContactsUI() {
        arrayOf(
            mBinding!!.tvLabelContact,
            mBinding!!.rvContactsShare
        ).forEach {
            it.visibility = View.GONE
        }
    }

    private fun showContactsUI() {
        arrayOf(
            mBinding!!.tvLabelContact,
            mBinding!!.rvContactsShare
        ).forEach {
            it.visibility = View.VISIBLE
        }
    }

    private fun hideRecentChatsUI() {
        arrayOf(
            mBinding!!.tvLabelRecent,
            mBinding!!.rvMembersShare
        ).forEach {
            it.visibility = View.GONE
        }
    }

    private fun checkRecentChatsUI(): Boolean {

        return mBinding!!.tvLabelRecent.visibility == View.GONE &&
                mBinding!!.rvMembersShare.visibility == View.GONE

    }

    private fun showRecentChatsUI() {
        arrayOf(
            mBinding!!.tvLabelRecent,
            mBinding!!.rvMembersShare
        ).forEach {
            it.visibility = View.VISIBLE
        }
    }


    private fun observers() {
        conversationsDao
            .liveConversationsNotRemoved.observe(this) { chatRooms: List<Conversation>? ->
                if (chatRooms != null) {
                    if (chatRoomToSend.isNotEmpty()) {
                        chatRoomToSend.clear()
                    }
                    getChatRooms(chatRooms)
                    if (isFromVault) {
                        setContactToShow()
                    }
                    if (chatRoomToSend.isEmpty()) {
                        hideRecentChatsUI()
                    } else {
                        showRecentChatsUI()
                    }
                    mAdapter!!.setChatRoomList(chatRoomToSend)
                }
            }
    }

    private fun getChatRooms(conversations: List<Conversation>) {
        conversations.forEach { c ->
            if (!c.conversationType.equals(
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                    ignoreCase = true
                )
            ) {
                if (!c.isRemoved) {
                    chatRoomToSend.add(c)
                }
            } else if (c.conversationType.equals(
                    Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                    ignoreCase = true
                )
            ) {
                handleOneToOneWithBlock(c)
            }
        }

    }

    private fun handleOneToOneWithBlock(c: Conversation) {
        if (!AppSession.getUser().blockUsers!!.isNullOrEmpty()) {
            for (m in c.conversationMembers!!) {
                if (!AppSession.getUser().blockUsers!!.contains(m.memberId!!)) {
                    chatRoomToSend.add(c)
                    break
                }
            }
        } else {
            chatRoomToSend.add(c)
        }
    }

    private fun setContactToShow() {
        val listOfContact = contactsDao.allUnBlockedContacts;
        if (!listOfContact.isNullOrEmpty()) {
            val listOfConversation = conversationsDao
                .getAllSpecificConversations(Constants.TYPES.CONVERSATION_ONE_TO_ONE)
            if (!listOfConversation.isNullOrEmpty()
            ) {
                for (conversation in listOfConversation) {
                    listOfContact.removeIf { contact ->
                        conversation.conversationMembers!!.any {
                            it.memberId!!.equals(contact.chatUserId, ignoreCase = true)
                        }
                    }
                }
            }
            if (listOfContact.isNotEmpty()) {
                setContactsForRecycler(listOfContact)
            } else {
                hideContactsUI()
            }

        } else {
            hideContactsUI()
        }
    }

    private fun setContactsForRecycler(listOfContact: MutableList<Contact>) {

        mShareAdapter!!.setContactList(listOfContact)
        this@ShareToActivity.listOfContact = listOfContact
    }

    private val roomData: Unit
        get() {
            if (intent != null) {
                if (intent.hasExtra(Constants.KEYS.INTENT_URI_FROM_VAULT)) {
                    isFromVault = true
                    if (AppSession.getUser() != null && AppSession.getUser().chatUserId != null) {
                        val intent: Intent
                        if (AppSession.getInt(LogOutTimerUtil.LOGOUT_KEY) == 0) {
                            AppSession.put(LogOutTimerUtil.LOGOUT_KEY, 15000)
                        }
                        if (AppSession.get(CreatePinActivity.KEY_PIN).isEmpty()) {
                            intent = Intent(this@ShareToActivity, CreatePinActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val uri =
                                this@ShareToActivity.intent.getStringExtra(Constants.KEYS.INTENT_URI_FROM_VAULT)
                            val parsedUri = Uri.parse(uri)
                            val file = FilePath.fileFromContentUri(this@ShareToActivity, parsedUri)

                            file?.let {
                                payload = Payload()
                                payload!!.filePath = it.path

                                //getting message type accordingly
                                val extension =
                                    AndroidUtil.getMimeType(this@ShareToActivity, parsedUri)

                                //Setting Payload type to File Extension
                                if (extension.equals(
                                        "jpeg",
                                        ignoreCase = true
                                    ) || extension.equals(
                                        "jpg",
                                        ignoreCase = true
                                    ) || extension.equals(
                                        "png",
                                        ignoreCase = true
                                    )
                                ) {
                                    payload!!.type = Constants.TYPES.IMAGE
                                } else if (extension.equals("mp3", ignoreCase = true)) {
                                    payload!!.type = Constants.TYPES.AUDIO
                                } else if (extension.equals("mp4", ignoreCase = true)) {
                                    payload!!.type = Constants.TYPES.VIDEO
                                } else {
                                    payload!!.type = Constants.TYPES.FILE
                                }

                            }
                            if (file == null) {
                                Log.e(TAG, "File was null which got from Vault")
                            }

                        }

                    } else {
                        val intent = Intent(this@ShareToActivity, CustomSplashActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                }
                if (intent.hasExtra("payload")) {
                    payload = intent.getSerializableExtra("payload") as Payload?
                }
                if (intent.hasExtra("conversation")) {
                    conversation = intent.getSerializableExtra("conversation") as Conversation?
                }
            }
        }

    override fun onResume() {
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        super.onResume()
    }

    //************************************************************
    private fun setToolBar(toolbar: Toolbar) //************************************************************
    {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(!isFromVault)
    }

    //************************************************************
    private fun populateRecyclerView()
    //************************************************************
    {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mBinding!!.rvMembersShare.layoutManager = layoutManager
        mAdapter = ShareToAdapter(this, this)
        mBinding!!.rvMembersShare.adapter = mAdapter

        if (isFromVault) {
            val contactLayoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            mBinding!!.rvContactsShare.layoutManager = contactLayoutManager
            mShareAdapter = ShareContactAdapter(this, this)
            mBinding!!.rvContactsShare.adapter = mShareAdapter
        }
    }

    private fun setSearchConversations() {
        mBinding!!.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //was essential for over ride
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //was essential for over ride
            }

            override fun afterTextChanged(s: Editable) {
                filterRecentChat(s.toString())
                filterContacts(s.toString())
            }
        })
    }

    private fun filterContacts(text: String) {
        if (isFromVault) {
            val filteredList = mutableListOf<Contact>()
            if (listOfContact.isNotEmpty()
            ) {
                this@ShareToActivity.listOfContact.forEach { item ->
                    if (item.name!!.lowercase(Locale.getDefault())
                            .contains(text.lowercase(Locale.getDefault()))
                    ) {
                        filteredList.add(item)
                    }
                }

                handleUis(text, filteredList)


            } else {
                hideContactsUI()
            }
        }

        if (text.isBlank() && this@ShareToActivity.listOfContact.isNotEmpty()) {
            if (checkContactsUI())
                showContactsUI()
            mShareAdapter!!.setContactList(this@ShareToActivity.listOfContact)
        }

    }

    private fun handleUis(text: String, filteredList: MutableList<Contact>) {
        if (filteredList.isEmpty()) {
            hideContactsUI()
        } else {
            handleUi(text, filteredList)
        }
    }

    private fun handleUi(text: String, filteredList: MutableList<Contact>) {
        if (text.isNotBlank()) {
            if (checkContactsUI())
                showContactsUI()
            mShareAdapter!!.filteredList(filteredList)
        }
    }

    private fun checkContactsUI(): Boolean {
        return mBinding!!.tvLabelContact.visibility == View.GONE &&
                mBinding!!.rvContactsShare.visibility == View.GONE
    }

    private fun filterRecentChat(text: String) {
        val filteredList = mutableListOf<Conversation>()
        if (!conversationsDao.allConversations.isNullOrEmpty()
        ) {
            for (item in conversationsDao.allConversationsNotRemoved) {
                if (item.name!!.lowercase(Locale.getDefault())
                        .contains(text.lowercase(Locale.getDefault()))
                ) {
                    filteredList.add(item)
                }
            }
            handleRecentUis(text, filteredList)


        } else {
            hideRecentChatsUI()
        }

        if (text.isBlank() && chatRoomToSend.isNotEmpty()) {
            if (checkRecentChatsUI())
                showRecentChatsUI()
            mAdapter!!.setChatRoomList(chatRoomToSend)
        }

    }

    private fun handleRecentUis(text: String, filteredList: MutableList<Conversation>) {
        if (filteredList.isEmpty()) {
            hideRecentChatsUI()
        } else {
            if (text.isNotBlank()) {
                if (checkRecentChatsUI())
                    showRecentChatsUI()
                mAdapter!!.filteredList(filteredList)
            }
        }
    }


    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun checkConversation(contact: Contact): Conversation? {
        var con: Conversation? = null
        val conversations = conversationsDao
            .getAllSpecificConversations(Constants.TYPES.CONVERSATION_ONE_TO_ONE)
        if (!conversations.isNullOrEmpty()) {
            con = conversations.find { conversation ->
                conversation.conversationMembers!!.any {
                    it.memberId.equals(
                        contact.chatUserId,
                        ignoreCase = true
                    )
                }
            }
        } else {
            Log.e(TAG, "checkConversation: No conversation Found")
        }
        return con
    }

    override fun onShareRoomClick(
        conversation: Conversation,
        name: String,
        chatId: String,
        id: Int,
        color: String,
        isContact: Boolean
    ) {
        if (payload != null) {
            val intent = Intent(this@ShareToActivity, ChatActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            if (!isFromVault) {
                intent
                    .putExtra("conversation", conversation)
                    .putExtra("name", name)
                    .putExtra("type", conversation.conversationType)
                    .putExtra("color", color)
                    .putExtra("isContact", isContact)
                    .putExtra("chatID", chatId)
                    .putExtra("ContactID", id)
                    .putExtra(
                        Constants.KEYS.INTENT_FROM_FORWARD,
                        Constants.KEYS.INTENT_FROM_FORWARD
                    )
                    .putExtra("payload", payload).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    }

            } else {
                intent
                    .putExtra("conversation", conversation)
                    .putExtra("name", name)
                    .putExtra("type", conversation.conversationType)
                    .putExtra("color", color)
                    .putExtra("isContact", isContact)
                    .putExtra("chatID", chatId)
                    .putExtra("ContactID", id)
                    .putExtra(
                        Constants.KEYS.INTENT_FROM_FORWARD,
                        Constants.KEYS.INTENT_FROM_FORWARD
                    )
                    .putExtra("payload", payload)
                    .putExtra(Constants.KEYS.INTENT_IS_FROM_VAULT, "true")
                    .apply { flags = Intent.FLAG_ACTIVITY_CLEAR_TOP }

            }
            startActivity(intent)
            finish()
        } else {
            Log.e(TAG, "Payload was null")
        }
    }

    override fun onContactClick(
        contact: Contact?,
        viewHolder: ShareContactViewHolder?,
        position: Int
    ) {

        if (payload != null) {
            val conversation = checkConversation(contact!!)
            if (conversation != null) {
                startActivity(
                    Intent(this, ChatActivity::class.java)
                        .putExtra("conversation", conversation)
                        .putExtra("contact", contact)
                        .putExtra("type", "one-to-one").apply {
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        }
                )
            } else {
                //moving file from Mobile to internal storage
                startActivity(
                    Intent(this, ChatActivity::class.java)
                        .putExtra(Constants.KEYS.INTENT_NEW_CONVERSATION, true)
                        .putExtra(Constants.KEYS.INTENT_CONTACT, contact)
                        .putExtra("type", Constants.TYPES.CONVERSATION_ONE_TO_ONE)
                        //                    .putExtra(Constants.KEYS.INTENT_FILE_PATH, mFile!!.absolutePath)
                        .putExtra(Constants.KEYS.INTENT_CONVERSATION_EXPIRY, selectedTime)
                        .putExtra("payload", payload)
                        .putExtra(Constants.KEYS.INTENT_IS_FROM_VAULT, "true").apply {
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        }
                )

            }
            finish()

        } else {
            Log.e(TAG, "Payload was null")
        }

    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}