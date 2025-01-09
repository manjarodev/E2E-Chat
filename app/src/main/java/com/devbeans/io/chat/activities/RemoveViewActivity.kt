package com.devbeans.io.chat.activities

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.ImageAdapter
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityRemoveViewBinding
import com.devbeans.io.chat.databinding.CustomBlockDailogBinding
import com.devbeans.io.chat.databinding.CustomDailogAddContactBinding
import com.devbeans.io.chat.databinding.CustomUpdateNicknameDailogBinding
import com.devbeans.io.chat.models.*
import com.devbeans.io.chat.network.ApiHelper.Companion.with
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.requestbody.RemoveMembersConversationRequest
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.GetProfileResponse
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.Constants.KEYS.BLOCK
import com.devbeans.io.chat.utils.Constants.KEYS.INTENT_CONVERSATION
import com.devbeans.io.chat.utils.Constants.KEYS.INTENT_MEMBER_ID
import com.devbeans.io.chat.utils.Constants.KEYS.MEMBER
import com.devbeans.io.chat.utils.Constants.KEYS.REMOVE_MEMBER
import com.devbeans.io.chat.utils.Constants.KEYS.UNBLOCK
import com.devbeans.io.chat.utils.Utills.colors
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import com.devbeans.io.chat.utils.Utills.rnd
import com.devbeans.io.chat.utils.Utills.showSubscriptionBanner
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.ParseException

class RemoveViewActivity : BaseActivity(), OnNetworkResponse, ExpiryCallback {
    private var mBinding: ActivityRemoveViewBinding? = null
    private var memberId: String? = null
    private var con_id: String? = null
    private var member: ConversationMember? = null
    private var isContact = false
    private var isConversationAvailable = false
    private var currConNotNull = false
    private var isAdminOwner = false
    private var isBlocked = false
    private var contactAdded = false
    private var mContact: Contact? = null
    private var mConversation: Conversation? = null
    private var con: Conversation? = null
    private var mImageAdapter: ImageAdapter? = null
    private var mCreateDialog: AlertDialog? = null
    private val apkFile: File? = null
    private val mFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_remove_view)
        appContext!!.currentActivity = this
        appContext!!.expiryListener = this
        intentData
        dataFromDB
        checkisBlocked()
        initViews()
        populateRecyclerView()
        listeners()
    }

    override fun onResume() {
        appContext!!.currentActivity = this
        appContext!!.expiryListener = this
        super.onResume()
    }

    private fun listeners() {
        mBinding!!.ivEditNickName.setOnClickListener { view: View? -> showChangeNickNameDialog() }
        mBinding!!.tvAddContact.setOnClickListener { v: View? -> showAddContactDialog() }
        mBinding!!.tvBlock.setOnClickListener { view: View? ->
            if (mBinding!!.tvBlock.getText().toString()
                    .equals(UNBLOCK, ignoreCase = true)
            ) showCustomDialog(2) else showCustomDialog(1)
        }
        mBinding!!.tvRemoveMember.setOnClickListener { v: View? -> showCustomDialog(3) }
        mBinding!!.tvStartConversation.setOnClickListener { v: View? ->
            if (isConversationAvailable) {
                handleConversationAvailable()
            } else {

                //moving file from Mobile to internal storage
                moveOwnAssetsToInternal()
                if (isContact) {
                    handleConversationForContact()
                } else {
                    handleConversationForUnknown()
                }
            }
        }
    }

    private fun handleConversationForUnknown() {
        if (mFile != null && mFile.exists()) {
            val intent: Intent = Intent(this, ChatActivity::class.java)
                .putExtra(Constants.KEYS.INTENT_NEW_CONVERSATION, true)
                .putExtra(Constants.KEYS.INTENT_NO_CONTACT, memberId)
                .putExtra("type", Constants.TYPES.CONVERSATION_ONE_TO_ONE)
                .putExtra(Constants.KEYS.INTENT_FILE_PATH, mFile.getAbsolutePath())
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    private fun handleConversationForContact() {
        if (mFile != null && mFile.exists()) {
            run {
                val intent: Intent = Intent(this, ChatActivity::class.java)
                    .putExtra(Constants.KEYS.INTENT_NEW_CONVERSATION, true)
                    .putExtra(Constants.KEYS.INTENT_CONTACT, mContact)
                    .putExtra("type", Constants.TYPES.CONVERSATION_ONE_TO_ONE)
                    .putExtra(
                        Constants.KEYS.INTENT_FILE_PATH,
                        mFile!!.getAbsolutePath()
                    )
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }

    private fun handleConversationAvailable() {
        val intent: Intent
        if (isContact) {
            intent = Intent(this, ChatActivity::class.java).putExtra("conversation", con)
                .putExtra("contact", mContact)
                .putExtra("type", "one-to-one")
        } else {
            intent = Intent(this, ChatActivity::class.java).putExtra("conversation", con)
                .putExtra("name", memberId)
                .putExtra("type", con!!.conversationType)
                .putExtra("color", "0D6EFD")
                .putExtra("isContact", isContact)
                .putExtra("chatID", memberId)
                .putExtra("ContactID", memberId)
            //                    callback.onRoomClick(conversation, name, isContact ? id : "null", isContact ? mContact.getId() : 0, color, isContact);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun moveOwnAssetsToInternal() {
        val destPath = filesDir.absolutePath
        try {
            assets.use { assetManager ->
                var files: Array<String>? = null
                files = assetManager.list("")
                for (filename: String in files!!) {
                    if (filename.contains(".jpg")) {
                        val outFile = File(destPath, filename)
                        assetManager.open(filename).use { inputStream ->
                            FileOutputStream(outFile).use { outputStream ->
                                val buffer = ByteArray(1024)
                                var read: Int
                                while ((inputStream.read(buffer).also { read = it }) != -1) {
                                    outputStream.write(buffer, 0, read)
                                }
                            }
                        }
                    }
                }
                Log.e("mTAG", "moveAssetsToInternal: ")
            }
        } catch (e: IOException) {
            Log.e("mTAG", "Failed to get asset file list.", e)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        Log.e("mTAG", "moveAssetsToInternal: already assets exists")
    }

    //************************************************************
    private fun populateRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mBinding!!.rvImages.layoutManager = layoutManager
        mImageAdapter = ImageAdapter()
        mBinding!!.rvImages.adapter = mImageAdapter
        showMedia()

//        String createdAt = "Created on " + DateTime.getFormattedTimeOnly(mConversation.getCreatedAt());
//        mBinding.tvGroupCreatedAt.setText(createdAt);
    }

    private val dataFromDB: Unit
        get() {
            if (con_id != null && memberId != null) {
                isContact = checkContact(memberId)
                isConversationAvailable = checkConversation(memberId!!)
                mConversation = getGroupConversation(con_id!!)
                if (currConNotNull && mConversation != null && mConversation!!.conversationMembers != null) {
                    for (conversationMember in mConversation!!.conversationMembers!!) {
                        if (conversationMember.type != null && conversationMember.memberId != null && !conversationMember.type.equals(
                                MEMBER,
                                ignoreCase = true
                            ) &&
                            conversationMember.memberId.equals(
                                AppSession.getUser().chatUserId,
                                ignoreCase = true
                            )
                        ) {
                            isAdminOwner = true
                            break
                        }
                    }
                }
            } else {
                Notify.Toast("Data not found")
            }
        }

    private fun checkisBlocked() {
        isBlocked = AppSession.getUser().blockUsers!!.contains(memberId!!)
    }

    //initializing al the views according to the checked conditions
    private fun initViews() {
        mBinding?.apply {
            tvAddContact.visibility = if (isContact) View.GONE else View.VISIBLE
            separator.visibility = getVisibility()
            MediaDocsLinksLayout.visibility = getVisibility()
            separatorDis.visibility = getVisibility()
            ivDisappear.visibility = getVisibility()
            titleDisappear.visibility = getVisibility()
            disappearOption.visibility = getVisibility()
            separator1.visibility = getVisibility()
            tvRemoveMember.visibility = if (isAdminOwner) View.VISIBLE else View.GONE
            tvBlock.setText(if (isBlocked) UNBLOCK else BLOCK)
            tvChatId.visibility = if (isContact) View.VISIBLE else View.GONE
            tvChatId.text = memberId
            tvChatName.text = if (isContact) mContact!!.name else memberId
            ivEditNickName.visibility = if (isContact) View.VISIBLE else View.GONE
            showMedia()
            Glide.with(appContext!!).load(
                if (isContact) getNameDrawable(
                    mContact!!.name,
                    mContact!!.avatarColor!!
                ) else R.drawable.ic_unknown
            ).into(mBinding!!.ivChatImage)
        }
    }

    private fun getVisibility(): Int {
        return if (isConversationAvailable) View.VISIBLE else View.GONE
    }

    private val intentData: Unit
        get() {
            if (intent != null) {
                if (intent.hasExtra(INTENT_MEMBER_ID)) {
                    member = intent.getSerializableExtra(INTENT_MEMBER_ID) as ConversationMember
                    if (!checkContact(member!!.memberId) && (member != null) && (member!!.chatNickName != null) && !member!!.chatNickName!!.trim { it <= ' ' }
                            .isEmpty()) {
                        memberId = member!!.chatNickName
                    } else {
                        memberId = member!!.memberId
                    }
                }
                if (intent.hasExtra(INTENT_CONVERSATION)) {
                    con_id = intent.getStringExtra(INTENT_CONVERSATION)
                }
            }
        }

    private fun getGroupConversation(con_id: String): Conversation? {
        try {
            val con = MainApp.database!!.conversationsDao()!!.getConversation(con_id)
            currConNotNull = con != null
            return con
        } catch (e: Exception) {
            Log.e(TAG, "getGroupConversation: Conversation is null")
        }
        return null
    }

    //checking if conversation is available with this Member
    private fun checkConversation(memberId: String): Boolean {
        con = null
        val conversations = MainApp.database!!.conversationsDao()!!
            .allConversations
        if (!conversations.isNullOrEmpty()) {
            val oneToOneCons = conversations.filter { conversation ->
                conversation.conversationType.equals(Constants.TYPES.CONVERSATION_ONE_TO_ONE) && conversation.conversationMembers?.any { conversationMember ->
                    conversationMember.memberId.equals(
                        memberId,
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
        return con != null
    }

    //checking if the member is in contact
    private fun checkContact(memberId: String?): Boolean {
        mContact = MainApp.database!!.contactsDao()!!.getContact(memberId)
        return mContact != null
    }

    //************************************************************
    private fun showMedia() //************************************************************
    {
        if (isConversationAvailable) {
            val isMediaShared = checkIsMediaShared()
            if (isMediaShared) {
                val list = MainApp.database!!.messagesDao()!!
                    .getAllMediaMessages(mConversation!!.conversationId)
                val downloadedList: MutableList<Payload> = ArrayList()
                var file: File?
                list.forEach { payload ->
                    payload.filePath?.let { path ->
                        file = File(path)
                        if (file?.exists() ?: false) {
                            downloadedList.add(payload)
                        }
                    }
                }

                if (!downloadedList.isNullOrEmpty()) {
                    mImageAdapter?.let {
                        mImageAdapter!!.setMSharedList(downloadedList)
                    }
                    mBinding!!.tvMediaCount.text = downloadedList.size.toString()
                } else {
                    mBinding!!.MediaDocsLinksLayout.visibility = View.GONE
                    mBinding!!.separator.visibility = View.GONE
                }
            } else {
                mBinding!!.MediaDocsLinksLayout.visibility = View.GONE
                mBinding!!.separator.visibility = View.GONE
            }
        } else {
            mBinding!!.MediaDocsLinksLayout.visibility = View.GONE
            mBinding!!.separator.visibility = View.GONE
        }
    }

    private fun checkIsMediaShared(): Boolean {
        return (MainApp.database!!.messagesDao()!!
            .getAllMediaMessages(con!!.conversationId) != null
                && MainApp.database!!.messagesDao()!!.getAllMediaMessages(con!!.conversationId)
            .isNotEmpty())
    }

    private fun showCustomDialog(i: Int) {
        val alertCustomdialog =
            LayoutInflater.from(this).inflate(R.layout.custom_block_dailog, null)
        //initialize alert builder
        val dialogBinding = CustomBlockDailogBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(this)
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(dialogBinding.root)
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        when (i) {
            0 -> {}
            1 -> {
                dialogBinding.tvTitle.text =
                    String.format("Block %s ?", if (isContact) mContact!!.name else memberId)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.block_alert)
                dialogBinding.btnBlock.setText(BLOCK)
            }
            2 -> {
                dialogBinding.tvTitle.text =
                    String.format("Unblock %s ?", if (isContact) mContact!!.name else memberId)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.unblock_alert)
                dialogBinding.btnBlock.setText(UNBLOCK)
            }
            3 -> {
                dialogBinding.tvTitle.text = AndroidUtil.getString(R.string.remove_from_group)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.remove_member_alert)
                dialogBinding.btnBlock.setText(REMOVE_MEMBER)
            }
        }
        mCreateDialog!!.show()
        dialogBinding.btnBlock.setOnClickListener {
            when (i) {
                0 -> {}
                1 -> {
                    mCreateDialog!!.dismiss()
                    blockUser()
                }
                2 -> {
                    mCreateDialog!!.dismiss()
                    unblock()
                }
                3 -> {
                    mCreateDialog!!.dismiss()
                    //                        unblock();
                    removeMember()
                }
            }
            initViews()
        }
        dialogBinding.btnCancel.setOnClickListener { view: View? -> mCreateDialog!!.dismiss() }
    }


    private fun showChangeNickNameDialog() {
        val alertCustomdialog =
            LayoutInflater.from(this).inflate(R.layout.custom_update_nickname_dailog, null)
        //initialize alert builder
        val bindingUpdateNickName = CustomUpdateNicknameDailogBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(this)
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(bindingUpdateNickName.root)
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val name = mContact!!.name
        bindingUpdateNickName.etNickname.setText(name)
        //finally show the dialog box in android all
        mCreateDialog!!.show()
        bindingUpdateNickName.btnUpdateNickname.setOnClickListener { view: View? ->
            if (bindingUpdateNickName.etNickname.getText() != null && !bindingUpdateNickName.etNickname.getText()
                    .toString().trim { it <= ' ' }
                    .isEmpty()
            ) {
//                    if (!name.equalsIgnoreCase(bindingUpdateNickName.etNickname.getText().toString())) {
                mContact!!.name = bindingUpdateNickName.etNickname.getText().toString()
                MainApp.database!!.contactsDao()!!.updateContactName(memberId, mContact!!.name)
                mCreateDialog!!.dismiss()
                initViews()
                changeOtherActivitiesData()
                //                    } else {
//                        Notify.Toast("Can not set same name again");
//                    }
            }
        }
        bindingUpdateNickName.btnCancel.setOnClickListener(View.OnClickListener { mCreateDialog!!.dismiss() })
    }


    private fun showAddContactDialog() {
        val alertCustomdialog =
            LayoutInflater.from(this).inflate(R.layout.custom_dailog_add_contact, null)
        //initialize alert builder
        val mCreateDialogBinding = CustomDailogAddContactBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(this)
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(mCreateDialogBinding.root)
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mCreateDialogBinding.tvPriveId.text = member!!.memberId
        mCreateDialogBinding.etNewContact1.requestFocus()
        //        mBinding.tvAddContact.setVisibility(View.GONE);
        //finally show the dialog box in android all
        mCreateDialog!!.show()
        mCreateDialog!!.setOnDismissListener(object : DialogInterface.OnDismissListener {
            override fun onDismiss(dialogInterface: DialogInterface) {
                if (!contactAdded) mBinding!!.tvAddContact.visibility = View.VISIBLE
            }
        })
        mCreateDialogBinding.btnCancel.setOnClickListener { view: View? -> mCreateDialog!!.dismiss() }
        mCreateDialogBinding.btnAddContact.setOnClickListener { view: View? ->
            if (!TextUtils.isEmpty(
                    mCreateDialogBinding.etNewContact1.getText().toString().trim { it <= ' ' })
            ) {
                handleAfterNickName(mCreateDialogBinding)
            } else {
                Notify.Toast("Please Enter NickName ")
                isContact = false
                mContact = null
            }
        }
    }

    /**
     * This function handles the event after nickname is set.
     * @param mCreateDialogBinding is the dialog binding used to fetch the name for the new contact.
     */
    private fun handleAfterNickName(mCreateDialogBinding: CustomDailogAddContactBinding) {

        // Initialize the contact with the required values.
        val contact = Contact().apply {
            chatUserId = member?.memberId
            name = mCreateDialogBinding.etNewContact1.text.toString()
            color = colors[rnd.nextInt(colors.size)]
            avatarColor = AvatarColor.random()
            member?.chatNickName.takeIf { !it.isNullOrEmpty() }?.let { alias = it.trim() }
        }

        // Fetch all the contacts from the database.
        val contacts = MainApp.database?.contactsDao()?.allContacts

        // Check if a contact already exists with the same chatUserId in the database.
        val existingContact = contacts?.find { it.chatUserId.equals(contact.chatUserId, true) }

        // if the existing contact is not null, update the name of the existing contact,
        // else insert the new contact.
        existingContact?.apply {
            name = mCreateDialogBinding.etNewContact1.text.toString()
            MainApp.database?.contactsDao()?.insert(this)
        } ?: run { MainApp.database?.contactsDao()?.insert(contact) }

        // update the local contact reference.
        mContact = Contact().apply {
            name = contact.name
            chatUserId = contact.chatUserId
            color = contact.color
            avatarColor = contact.avatarColor
        }

        // update the status flags.
        isContact = true
        contactAdded = true

        // Hide the add contact view.
        mBinding?.tvAddContact?.visibility = View.GONE

        // Refresh the view and close the dialog.
        initViews()
        mCreateDialog?.dismiss()
    }


    private fun removeMember() {
        //there maybe be issue here when there are multiple admins removing same person
        val request = RemoveMembersConversationRequest()
        if (mConversation!!.conversationMembers!!.size > 2) {
            request.members = member!!.memberId
            request.userChatId = AppSession.getUser().chatUserId
            with()?.removeMember(
                mConversation!!.conversationId,
                request,
                this,
                this@RemoveViewActivity
            )
        } else {
            Notify.Toast("Group can have at least 2 members")
        }
    }

    private fun unblock() {
        with()?.unBlockUser(member!!.memberId, this, this@RemoveViewActivity)
        Log.d(
            TAG, "un blockUser: " + "End Point: " + RequestCodes.API_END_POINTS.UNBLOCK_USER +
                    " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + "un block id=" + memberId
        )
    }

    private fun blockUser() {
        with()?.blockUser(member!!.memberId, this, this@RemoveViewActivity)
        Log.d(
            TAG, " blockUser: " + Constants.END_POINT + RequestCodes.API_END_POINTS.BLOCK_USER +
                    " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + "block id=" + memberId
        )
    }

    private fun changeOtherActivitiesData() {
        //used for changing previous activities data
    }

    /**
     * Handles the success response for different API requests.
     * @param call The original call.
     * @param response The successful response.
     * @param tag The tag identifying the type of the request.
     * @throws ParseException if there is an error parsing the response.
     */
    @Throws(ParseException::class)
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {

        // Check if the response code is 200 (HTTP_OK)
        if (response.code() == 200) {
            // Handle based on the tag
            when (tag as Int) {
                RequestCodes.API.BLOCK_USER, RequestCodes.API.UNBLOCK_USER -> {

                    // Log message formatting based on the tag.
                    val action = if (tag == RequestCodes.API.BLOCK_USER) "blockUser" else "unBlock"

                    // Process the response
                    (response.body() as? GetProfileResponse)?.user?.let { user ->

                        // Log the success response.
                        Log.d(
                            TAG,
                            "ContactDetailActivity $action: " + Constants.END_POINT + RequestCodes.API_END_POINTS.BLOCK_USER +
                                    Constants.RESPONSE +
                                    response.body().toString()
                        )

                        // Save the updated user in the app session.
                        AppSession.saveUser(user)

                        // Check if the user is blocked and update the views.
                        checkisBlocked()
                        initViews()
                    } ?: Notify.Toast(Constants.NO_DATA_FOUND)
                }

                RequestCodes.API.REMOVE_MEMBER -> {
                    // Process the response
                    (response.body() as? NewConversationResponse)?.conversation?.let {

                        // Log the success response.
                        Log.d(
                            TAG,
                            "Remove Member: " + Constants.END_POINT + RequestCodes.API_END_POINTS.REMOVE_MEMBER_CONVERSATION +
                                    Constants.RESPONSE +
                                    response.body().toString()
                        )

                        // Finish the activity if the member is successfully removed.
                        finish()
                    } ?: Notify.Toast(Constants.NO_DATA_FOUND)
                }
            }
        }
    }


    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        //is essential to override
    }

    override fun notifyExpiry() {
        if (mBinding != null) {
            showSubscriptionBanner(mBinding!!.tvSubs)
        }
    }

    companion object {
        val TAG = RemoveViewActivity::class.java.simpleName
    }
}