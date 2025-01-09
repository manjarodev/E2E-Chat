package com.devbeans.io.chat.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.NewGroupAdapter
import com.devbeans.io.chat.adapters.NewMessageAdapter
import com.devbeans.io.chat.adapters.viewholders.ContactViewHolder
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ContactsCallback
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.callBacks.MemberAddCallback
import com.devbeans.io.chat.databinding.ActivityNewMessageBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.Constants.KEYS
import com.devbeans.io.chat.utils.Utills.colors
import com.devbeans.io.chat.utils.Utills.getDisappearingOptions
import com.devbeans.io.chat.utils.Utills.rnd
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import com.devbeans.io.chat.viewmodels.NewMessageViewModel
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response
import java.io.*
import java.util.*

//************************************************************
class NewMessageActivity() : BaseActivity(),
    ContactsCallback, OnNetworkResponse, MemberAddCallback, ExpiryCallback
//************************************************************
{
    private var addedByQr: Boolean = false
    private var mBinding: ActivityNewMessageBinding? = null
    private var mViewModel: NewMessageViewModel? = null
    private val mCancel: AppCompatButton? = null
    private val mAddContact: AppCompatButton? = null
    private var mDialog: AlertDialog? = null
    private var mAdapter: NewMessageAdapter? = null
    private var mGroupAdapter: NewGroupAdapter? = null
    var userIdEdit: TextInputEditText? = null
    var nameEdit: TextInputEditText? = null
    var contacts: MutableList<Contact> = ArrayList()
    var isMembersSelected = false
    var groupMembers: MutableList<Contact>? = ArrayList()
    var SelectedGroupMembers: MutableList<Contact> = ArrayList()
    private var isGroup = false
    private var isAnonymous = false

    //Default disapear time
    private var selected_time = SettingsValues.getUniversalExpireTimer().toInt()
    private var mFile: File? = null
    private var apkFile: File? = null
    var disappearActivityResultLauncher: ActivityResultLauncher<Intent>? = null


    /**
     * This method initializes the view components and sets up necessary configurations for the activity.
     * It also registers an activity result launcher for fetching the disappearing time of a message.
     * @param savedInstanceState: A bundle object that contains the previously saved instance state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up data binding and view model
        setupDataBindingAndViewModel()

        // Set up UI components
        setupUIComponents()

        // Set up activity result launcher
        setupActivityResultLauncher()

        // Set up application context and notifications
        setupAppContextAndNotifications()

        // Initialize dialog and RecyclerView
        initDialog()
        populateRecyclerView(false)

        // Set up observers and listeners
        observers()
        listeners()

        // Search contacts
        setSearchContacts()
    }

    /**
     * Sets up data binding and view model for the activity.
     */
    private fun setupDataBindingAndViewModel() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_message)
        mViewModel = ViewModelProvider(this).get(NewMessageViewModel::class.java)
        setContentView(mBinding?.root)
    }

    /**
     * Sets up UI components for the activity.
     */
    private fun setupUIComponents() {
        setToolBar(mBinding?.toolbar!!)
        WindowUtil.setStatusBarColor(window,AndroidUtil.getColor(R.color.bg_window_fill_color))
    }

    /**
     * Sets up activity result launcher for fetching the disappearing time of a message.
     */
    private fun setupActivityResultLauncher() {
        disappearActivityResultLauncher = registerForActivityResult(
            StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RequestCodes.GET_DISAPPEAR_TIME) {
                result.data?.let { data ->
                    if (data.hasExtra(KEYS.INTENT_DISAPPEAR_TIME_RESULT)) {
                        selected_time = data.getIntExtra(KEYS.INTENT_DISAPPEAR_TIME_RESULT, -1)
                        mBinding?.tvDisappearOption?.text = getDisappearingOptions(selected_time.toLong())
                    }
                }
            }
        }
    }

    /**
     * Sets up application context and notifications.
     */
    private fun setupAppContextAndNotifications() {
        appContext?.let { context ->
            context.currentActivity = this
            context.setNotifyExpiry(this)
        }
    }


    override fun onResume() {
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        super.onResume()
    }

    //************************************************************
    private fun initDialog() //************************************************************
    {
        val alertCustomdialog =
            LayoutInflater.from(this).inflate(R.layout.custom_dailog_new_contact, null)
        //initialize alert builder.
        val alert = AlertDialog.Builder(this)
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(alertCustomdialog)
        mDialog = alert.create()
        val mCancel = alertCustomdialog.findViewById<View>(R.id.btn_cancel_one) as AppCompatButton
        val scanQr = alertCustomdialog.findViewById<ImageView>(R.id.layout_scan_qr_one)
        val mAddContact =
            alertCustomdialog.findViewById<View>(R.id.btn_add_contact_one) as AppCompatButton
        userIdEdit = alertCustomdialog.findViewById(R.id.user_id_edit)
        nameEdit = alertCustomdialog.findViewById(R.id.nick_name_edit)



        userIdEdit?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                addedByQr = false
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })

        mCancel.setOnClickListener { if (mDialog!!.isShowing) mDialog!!.dismiss() }
        scanQr.setOnClickListener {
            startActivityForResult(
                Intent(
                    applicationContext, QRScannerActivity::class.java
                ), RequestCodes.SCAN_QR
            )
        }
        mAddContact.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (userIdEdit!!.getText().toString() != null && !userIdEdit!!.getText().toString()
                        .isEmpty()
                ) {
                    if (nameEdit!!.getText().toString() != null && !nameEdit!!.getText().toString()
                            .isEmpty()
                    ) {
                        verifyUser(userIdEdit!!.getText().toString())
                    } else Notify.Toast("Please add name to continue")
                } else Notify.Toast("Please add user id")
            }
        })
    }

    //************************************************************
    private fun observers() //************************************************************
    {
        contactsDao.liveContacts.observe(
            this
        ) { list: MutableList<Contact> ->
            var blockedContact: MutableList<Contact> = ArrayList()
            if ((AppSession.getUser() != null) && (AppSession.getUser()
                    .blockUsers != null) && (AppSession.getUser().blockUsers!!.isNotEmpty())
            ) {
                for (contact: Contact in list) {
                    if (AppSession.getUser().blockUsers!!.contains(contact.chatUserId)) {
                        //do not show blocked contact
                    } else {
                        blockedContact.add(contact)
                    }
                }
            } else {
                blockedContact = list
            }
            contacts = blockedContact
            mAdapter!!.setChatRoomList(blockedContact)
        }
    }

    //************************************************************
    private fun listeners() //************************************************************
    {
        mBinding!!.cancel.setOnClickListener { onBackPressed() }
        mBinding!!.ivBack.setOnClickListener { onBackPressed() }
        mBinding!!.etGroupName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                //was essential to override
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                //was essential to override
            }

            override fun afterTextChanged(editable: Editable) {
                mBinding!!.tvTitleCount.text =
                    String.format(Locale.ROOT, "%d", editable.toString().length)
//                mBinding!!.tvIndicatorGroupTitle.setBackgroundColor(AndroidUtil.getColor(if (editable.toString().length > 0) R.color.blue else R.color.faded_black_20))
            }
        })
        mBinding!!.addContactLayout.setOnClickListener { showLoadingDialog() }
        mBinding!!.ivGroupImage.setOnClickListener {
            ImagePicker.with(this@NewMessageActivity)
                .compress(200)
                .maxResultSize(640, 640)
                .galleryOnly()
                .crop()
                .start(RequestCodes.GROUP_IMAGE)
        }
        mBinding!!.layoutNewGroup.setOnClickListener {
            isGroup = true
            isMembersSelected = true
            mBinding!!.titleToolbar.text = "Create Group"
            mBinding!!.layoutNewGroup.visibility = View.GONE
            mBinding!!.addContactLayout.visibility = View.GONE
            mBinding!!.layoutNewAnonymousGroup.visibility = View.GONE
            mBinding!!.tvTotalCount.visibility = View.VISIBLE
            mBinding!!.tvTotalCount.text = String.format(
                Locale.ROOT,
                Constants.MEMBERS_COUNT,
                0,
                contacts.size
            )
            mBinding!!.tvContacts.text = "Contacts"

//            mBinding.btnCreateGroup.setVisibility(View.VISIBLE);
            populateRecyclerView(true)
            mAdapter!!.showCheckBox()
        }
        mBinding!!.layoutNewAnonymousGroup.setOnClickListener {
            isGroup = true
            isMembersSelected = true
            mBinding!!.titleToolbar.text = "Create Anonymous Group"
            mBinding!!.layoutNewGroup.visibility = View.GONE
            mBinding!!.addContactLayout.visibility = View.GONE
            mBinding!!.layoutNewAnonymousGroup.visibility = View.GONE
            mBinding!!.tvTotalCount.visibility = View.VISIBLE
            isAnonymous = true
            mBinding!!.tvTotalCount.text = String.format(
                Locale.ROOT,
                Constants.MEMBERS_COUNT,
                0,
                contacts.size
            )
            mBinding!!.tvContacts.text = "Contacts"
            //            mBinding.btnCreateGroup.setVisibility(View.VISIBLE);
            populateRecyclerView(true)
            mAdapter!!.showCheckBox()
        }
        mBinding!!.btnCreateGroup.setOnClickListener {
            handleBtnCreateGroupClick()
        }
        mBinding!!.etGroupName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                //was essential to override
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                mBinding!!.confirmCreateGroup.visibility =
                    if (!charSequence.toString().trim { it <= ' ' }
                            .isEmpty() && charSequence.length > 0) View.VISIBLE else View.GONE
            }

            override fun afterTextChanged(editable: Editable) {
                //was essential to override
            }
        })
        mBinding!!.confirmCreateGroup.setOnClickListener {
            handleConfirmCreateClick()
        }
        mBinding!!.layoutDisappear.setOnClickListener { v: View? ->
            val intent: Intent =
                Intent(this@NewMessageActivity, DisappearingMsgActivity::class.java)
            intent.putExtra(KEYS.INTENT_DISAPPEARING, KEYS.INTENT_DISAPPEARING)
            intent.putExtra(KEYS.INTENT_DISAPPEAR_TIME, selected_time)
            disappearActivityResultLauncher!!.launch(intent)
        }
    }

    private fun handleConfirmCreateClick() {
        if (!mBinding!!.etGroupName.text.toString().trim { it <= ' ' }
                .isEmpty()) {
            if (mFile != null && mFile!!.exists()) startActivity(
                Intent(this, ChatActivity::class.java)
                    .putExtra("new conversation", true)
                    .putExtra("members", groupMembers as Serializable?)
                    .putExtra("type", if (isAnonymous) "anonymous" else "group")
                    .putExtra(
                        "groupName",
                        mBinding!!.etGroupName.getText().toString().trim { it <= ' ' })
                    .putExtra(KEYS.INTENT_FILE_PATH, mFile!!.getAbsolutePath())
                    .putExtra(KEYS.INTENT_FILE_SELECTED, true)
                    .putExtra(KEYS.INTENT_CONVERSATION_EXPIRY, selected_time)
            ) else {
                startActivity(
                    Intent(this, ChatActivity::class.java)
                        .putExtra("new conversation", true)
                        .putExtra("members", groupMembers as Serializable?)
                        .putExtra("type", if (isAnonymous) "anonymous" else "group")
                        .putExtra("groupName", mBinding!!.etGroupName.getText().toString())
                        .putExtra(KEYS.INTENT_FILE_SELECTED, false)
                        .putExtra(KEYS.INTENT_CONVERSATION_EXPIRY, selected_time)
                )
            }
            finish()
        } else {
//            mBinding!!.tvIndicatorGroupTitle.setBackgroundColor(AndroidUtil.getColor(R.color.dark_red))
            //                mBinding.tvIndicatorGroupTitle
            Notify.Toast("Please enter group name to continue")
        }
    }

    private fun handleBtnCreateGroupClick() {
        if (groupMembers != null && !groupMembers!!.isEmpty()) {
            isMembersSelected = true
            populateRecyclerViewGroup(true)
            mBinding!!.layoutTop.visibility = View.GONE
            mBinding!!.layoutCreateGroup.visibility = View.VISIBLE
            mAdapter!!.hideCheckBox()
            mBinding!!.cancel.visibility = View.GONE
            mBinding!!.tvTotalCount.visibility = View.GONE
            mBinding!!.ivBack.visibility = View.VISIBLE
            mBinding!!.titleToolbar.text =
                if (isAnonymous) "Create Anonymous Group" else "Create Group"
            //                mBinding.tvContacts.setText("Members");
            mBinding!!.searchBar.hint = "Group name"
            mBinding!!.tvContacts.text = String.format(
                Locale.ROOT,
                "Members: %d",
                groupMembers!!.size
            )
            mBinding!!.searchBar.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            mBinding!!.btnCreateGroup.visibility = View.GONE
            mBinding!!.layoutMember.visibility = View.GONE
            mBinding!!.confirmCreateGroup.visibility = View.GONE
            mBinding!!.tvDisappearOption.text = Utills.getDisappearingOptions(SettingsValues.getUniversalExpireTimer())
        }
    }

    private fun setSearchContacts() {
        mBinding!!.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //was essential to override
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //was essential to override
            }

            override fun afterTextChanged(s: Editable) {
                if (!isMembersSelected) {
                    filter(s.toString())
                }
            }
        })
    }

    /**
     * This function filters contacts based on the provided text.
     * It populates a list with contacts whose names contain the provided text.
     * @param text: The text to filter contacts by.
     */
    private fun filter(text: String) {
        val filteredList = ArrayList<Contact>()
        // Null check and empty check for allContacts list
        contactsDao.allContacts?.let { contacts ->
            if (contacts.isNotEmpty()) {
                for (item: Contact in contacts) {
                    // Null check for item.name, and case-insensitive contains check
                    item.name?.lowercase(Locale.ROOT)?.let { name ->
                        if (name.contains(text.lowercase(Locale.ROOT))) {
                            filteredList.add(item)
                        }
                    }
                }
                mAdapter?.filteredList(filteredList)
            }
        }
        updateGroupUI()
    }

    /**
     * This function updates the UI based on the selected group members.
     */
    private fun updateGroupUI() {
        mBinding?.let { binding ->
            if (isGroup) {
                val visibility = if (SelectedGroupMembers?.size == 0) View.GONE else View.VISIBLE
                binding.layoutMember.visibility = visibility
                binding.btnCreateGroup.visibility = visibility
            }
        }
    }



    private fun setToolBar(toolbar: Toolbar)
    {
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }


    override fun onBackPressed()
    {
        super.onBackPressed()
        finish()
    }


    protected fun showLoadingDialog()
    {

        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (!userIdEdit?.getText().isNullOrEmpty()) {
            userIdEdit!!.setText("")
        }

        if (!nameEdit?.getText().isNullOrEmpty()) {
            nameEdit!!.setText("")
        }

        //finally show the dialog box in android all
        mDialog!!.show()
    }


    private fun populateRecyclerView(isGroup: Boolean)
    {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mBinding!!.rvContacts.layoutManager = layoutManager
        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mBinding!!.rvMembers.layoutManager = layoutManager2
        //        mBinding.layoutMember.setVisibility(isGroup ? View.VISIBLE : View.GONE);
        if (isGroup) {
            mAdapter = NewMessageAdapter(this, this, contacts)
            mGroupAdapter = NewGroupAdapter(this, this, this, SelectedGroupMembers)
        } else {
            mAdapter = NewMessageAdapter(this, this)
            mGroupAdapter = NewGroupAdapter(this, this, this, SelectedGroupMembers)
        }
        mBinding!!.rvContacts.adapter = mAdapter
        mBinding!!.rvMembers.adapter = mGroupAdapter
    }

    private fun populateRecyclerViewGroup(isGroup: Boolean) //************************************************************
    {
        mAdapter!!.clear()
        mGroupAdapter!!.clear()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mBinding!!.rvContacts.layoutManager = layoutManager
        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mBinding!!.rvMembers.layoutManager = layoutManager2
        if (isGroup) {
            mAdapter = NewMessageAdapter(this, this, groupMembers!!)
            mGroupAdapter = NewGroupAdapter(this, this, this, SelectedGroupMembers)
        } else {
            mAdapter = NewMessageAdapter(this, this)
            mGroupAdapter = NewGroupAdapter(this, this, this, SelectedGroupMembers)
        }
        mBinding!!.rvContacts.adapter = mAdapter
        mBinding!!.rvMembers.adapter = mGroupAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == RequestCodes.SCAN_QR) {
            if (data!!.extras != null) {
                val userId = data.getStringExtra("userId")
                userIdEdit!!.setText(userId)
                addedByQr = true;
            }
        }
        if (resultCode == RESULT_OK && requestCode == RequestCodes.GROUP_IMAGE) {
            assert(data != null)
            if (!(data!!.data == null)) {
                val extension = AndroidUtil.getMimeType(this, data.data)
                val uri = data.data
                var path: String? = ""
                when (extension) {
                    "png", "jpg", "jpeg" -> {
                        path = FilePath.getPath(this, uri)
                        val file = File(path.toString())
                        if (file.exists()) {
//                        uploadFile(file);
                            mFile = file
                            Glide.with(this).load(file).into(mBinding!!.ivGroupImage)
                        }
                    }
                }
            }
        }
    }

    private fun moveAssetsToInternal() {
        val destPath = filesDir.absolutePath
        val movedFilesList = File(destPath).listFiles()
        val assetManager = assets
        var files: Array<String>? = null
        try {
            files = assetManager.list("")
            for (filename: String in files!!) {
                if (filename.contains(".jpg")) {
                    var inputStream: InputStream? = null
                    var outputStream: OutputStream? = null
                    inputStream = assetManager.open(filename)
                    val outFile = File(destPath, filename)
                    outputStream = FileOutputStream(outFile)
                    val buffer = ByteArray(1024)
                    var read: Int
                    while ((inputStream.read(buffer).also { read = it }) != -1) {
                        outputStream.write(buffer, 0, read)
                    }
                    inputStream.close()
                    outputStream.flush()
                    outputStream.close()
                    apkFile = File(destPath)
                    for (file: File in Objects.requireNonNull(
                        apkFile!!.listFiles()
                    )) {
                        if (file.name.contains(".jpg")) {
//                                Log.e("mTAG", "moveAssetsToInternal: " + file.getAbsolutePath());
//                                Process p = Runtime.getRuntime().exec("pm install " + file.getAbsolutePath());
//                                p.waitFor();
                            mFile = file
                        }
                    }
                }
            }
            Log.e("mTAG", "moveAssetsToInternal: ")
        } catch (e: IOException) {
            Log.e("mTAG", "Failed to get asset file list.", e)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        Log.e("mTAG", "moveAssetsToInternal: already assets exists")
    }

    override fun onContactClick(contact: Contact, viewHolder: ContactViewHolder, position: Int) {
        if (!isGroup) {
//        MainApp.database.conversationsDao().getConversation()
            val conversation = checkConversation(contact)
            if (conversation != null) {
                startActivity(
                    Intent(this, ChatActivity::class.java)
                        .putExtra("conversation", conversation)
                        .putExtra("contact", contact)
                        .putExtra("type", "one-to-one")
                )
            } else {
                //moving file from Mobile to internal storage
                moveAssetsToInternal()
                startActivity(
                    Intent(this, ChatActivity::class.java)
                        .putExtra(KEYS.INTENT_NEW_CONVERSATION, true)
                        .putExtra(KEYS.INTENT_CONTACT, contact)
                        .putExtra("type", Constants.TYPES.CONVERSATION_ONE_TO_ONE)
                        .putExtra(KEYS.INTENT_FILE_PATH, mFile!!.absolutePath)
                        .putExtra(KEYS.INTENT_CONVERSATION_EXPIRY, selected_time)
                )
            }
            finish()
        }
    }

    override fun onCheckBoxClick(
        contact: Contact,
        viewHolder: ContactViewHolder,
        position: Int,
        isFromGroupAdapter: Boolean,
        isChecked: Boolean
    ) {
        if (isChecked) {
            if (groupMembers != null && !containMember(groupMembers!!, contact.chatUserId)) {
//                groupMembers.add(contact);
                SelectedGroupMembers!!.add(contact)
                groupMembers!!.add(contact)
                mGroupAdapter!!.notifyItemInserted(mGroupAdapter!!.itemCount)
                mBinding!!.rvMembers.scrollToPosition(groupMembers!!.size - 1)
                if (mBinding != null) {
                    mBinding!!.layoutMember.visibility = View.VISIBLE
                    mBinding!!.btnCreateGroup.visibility = View.VISIBLE
                    mBinding!!.tvTotalCount.text =
                        String.format(
                            Locale.ROOT,
                            Constants.MEMBERS_COUNT,
                            groupMembers!!.size,
                            contacts.size
                        )
                }
            }
        } else {
            if ((groupMembers != null) && !groupMembers!!.isEmpty() && containMember(
                    groupMembers!!, contact.chatUserId
                )
            ) {
                groupMembers!!.remove(contact)
                mGroupAdapter!!.removeItem(contact)
                mBinding!!.tvTotalCount.text =
                    String.format(
                        Locale.ROOT,
                        Constants.MEMBERS_COUNT,
                        groupMembers!!.size,
                        contacts.size
                    )
                if (mBinding != null && groupMembers!!.size == 0) {
                    mBinding!!.layoutMember.visibility = View.GONE
                    mBinding!!.btnCreateGroup.visibility = View.GONE
                }
                SelectedGroupMembers!!.remove(contact)
                //                mGroupAdapter.notifyItemRemoved(mGroupAdapter.getItemCount());
            }
        }
    }

    override fun onMemberAddClick(
        contact: Contact,
        holder: RecyclerView.ViewHolder,
        position: Int,
        isFromMember: Boolean,
        isChecked: Boolean
    ) {
        if ((SelectedGroupMembers != null) && !SelectedGroupMembers!!.isEmpty() && containMember(
                SelectedGroupMembers!!, contact.chatUserId
            )
        ) {
            mBinding!!.btnCreateGroup.visibility = View.VISIBLE
            groupMembers!!.remove(contact)
            mGroupAdapter!!.removeItem(contact)
            SelectedGroupMembers!!.remove(contact)
            mBinding!!.tvTotalCount.text =
                String.format(
                    Locale.ROOT,
                    Constants.MEMBERS_COUNT,
                    groupMembers!!.size,
                    contacts.size
                )
            if (mBinding != null && SelectedGroupMembers!!.size == 0) {
                mBinding!!.layoutMember.visibility = View.GONE
                mBinding!!.btnCreateGroup.visibility = View.GONE
            }
            mAdapter!!.removeItem(contact)
            //                mGroupAdapter.notifyItemRemoved(mGroupAdapter.getItemCount());
        }
    }

    private fun checkConversation(contact: Contact): Conversation? {
        var con: Conversation? = null
        val conversations = conversationsDao
            .allConversations


        if (!conversations.isNullOrEmpty()) {
            val oneToOneCons = conversations.filter { conversation ->
                conversation.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE) && conversation.conversationMembers?.any { conversationMember ->
                    conversationMember.memberId.equals(
                        contact.chatUserId,
                        ignoreCase = true
                    )
                } ?: false
            }

            if (oneToOneCons.isNotEmpty()) {
                con = oneToOneCons.first()
            }
        } else {
            Log.e(TAG, "checkConversation: No conversation Found")
            //            Notify.Toast("No conversations found");
        }
        return con
    }

    private fun verifyUser(userId: String) {
        Log.d(
            TAG,
            ("New Message Activity verifyUser: " + "End Point: " + RequestCodes.API_END_POINTS.VERIFY_USER +
                    " Request: " +
                    "chat_user_id=" + userId)
        )
        ApiHelper.with()?.verifyUser(userId, this, this)
//        NetworkCall.make()
//            .setCallback(this)
//            .setTag(RequestCodes.API.VERIFY_USER)
//            .autoLoadingCancel(getLoading(this, "Please wait"))
//            .enque(Network.apis().verifyUser(userId))
//            .execute()
    }

    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag as Int == RequestCodes.API.VERIFY_USER) {
            if (response.code() == 200) {
                val res = response.body() as BaseResponse?
                res?.let {
                    Log.d(
                        TAG,
                        ("New Message Activity verifyUser: " + "End Point: " + RequestCodes.API_END_POINTS.VERIFY_USER +
                                " Response: " +
                                res.toString())
                    )
                    if (res.status.equals("Success", ignoreCase = true) && res.isUser) {
                        handleAddContact(res)
                    } else {
                        nameEdit!!.setText("")
                        userIdEdit!!.setText("")
                        Notify.Toast("Invalid contact")
                    }
                } ?: Notify.Toast("No data found")
            }
        }
    }

    private fun handleAddContact(res: BaseResponse) {
        val contact = Contact()
        contact.chatUserId = userIdEdit!!.text.toString()
        contact.name = nameEdit!!.text.toString()
        contact.color = colors[rnd.nextInt(colors.size)]
        contact.avatarColor = AvatarColor.random()
        contact.isQrAdded = addedByQr
        val contacts: List<Contact>? = contactsDao
            .allContacts as List<Contact>
        var hasContact = false
        var existedContact = Contact()
        if (!contacts.isNullOrEmpty()) {
            val contact1 = contacts.find { contact1 ->
                contact1.chatUserId.equals(
                    contact.chatUserId,
                    ignoreCase = true
                )
            }

            contact1?.let {
                hasContact = true
                existedContact = contact1
            } ?: run {
                hasContact = false
            }
            if (hasContact) {
                existedContact.name = nameEdit!!.text.toString()
                contactsDao.insert(existedContact)
                Notify.Toast("Contact updated")
            } else {
                contactsDao.insert(contact)
                Notify.Toast("New contact added")
            }
        } else {
            contactsDao.insert(contact)
            Notify.Toast("New contact added")
        }
        nameEdit!!.setText("")
        userIdEdit!!.setText("")
        mDialog!!.dismiss()
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        Notify.Toast(response.message)
    }

    companion object {
        fun containMember(list: List<Contact>, userid: String?): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                list.stream().anyMatch { o: Contact ->
                    o.chatUserId!!.contains(
                        (userid)!!
                    )
                }
            } else false
        }
    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}