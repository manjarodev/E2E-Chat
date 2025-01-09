package com.devbeans.io.chat.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.annotation.MainThread
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityContactDetailBinding
import com.devbeans.io.chat.databinding.CustomBlockDailogBinding
import com.devbeans.io.chat.databinding.CustomUpdateNicknameDailogBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.User
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.GetProfileResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import retrofit2.Call
import retrofit2.Response
import java.io.*
import java.text.ParseException
import java.util.*

class ContactDetailActivity : BaseActivity(), OnNetworkResponse, ExpiryCallback {
    var mBinding: ActivityContactDetailBinding? = null
    private var mContact: Contact? = null
    private var mCreateDialog: AlertDialog? = null
    private val UNBLOCK = "Unblock"
    private val BLOCK = "Block"
    private val DELETE = "Delete"
    private var apkFile: File? = null
    private var mFile: File? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_contact_detail)
        setToolBar(mBinding!!.toolbar)
        WindowUtil.setStatusBarColor(window, AndroidUtil.getColor(R.color.bg_window_fill_color))
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        contactDetails
        listeners()
        initViews()
    }

    override fun onResume() {
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        super.onResume()
    }

    /**
     * This method is used to initialize views with contact data.
     * It handles null safety and possible exceptions in the process.
     */
    private fun initViews() {
        try {
            // Null check on mContact
            mContact?.let { contact ->

                // Set contact name
                mBinding?.tvChatName?.text = contact.name ?: ""

                // Set contact alias if exists and it's not equal to contact name
                mBinding?.tvChatId?.text = contact.alias
                    ?.takeIf { alias ->
                        alias.trim().isNotEmpty() && alias.trim() != contact.name?.trim()
                    }
                    ?.let { alias ->
                        String.format(Locale.getDefault(), "( %s )", alias)
                    } ?: ""

                // Check if user has chatUserId and if contact is in user's block list
                val user = AppSession.getUser()
                user.chatUserId?.takeIf { it.isNotEmpty() }?.let {
                    val blockStatus =
                        if (user.blockUsers?.contains(contact.chatUserId) == true) UNBLOCK else BLOCK
                    mBinding?.tvBlock?.text = blockStatus
                }

                // Load contact image into ImageView using Glide
                Glide.with(this).load(getNameDrawable(contact.name, contact.avatarColor!!)).into(
                    mBinding?.ivChatImage!!
                )
            }
        } catch (e: Exception) {
            // Handle any unexpected exceptions to prevent app crash
            Log.e("Error", "Error initializing views: ${e.message}")
        }
    }


    private fun listeners() {
        mBinding!!.tvStartConversation.setOnClickListener { view: View? ->
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            val conversation = checkConversation(mContact)
            if (conversation != null) {
                startActivity(
                    Intent(this, ChatActivity::class.java)
                        .putExtra(Constants.KEYS.INTENT_CONVERSATION, conversation)
                        .putExtra(Constants.KEYS.INTENT_CONTACT, mContact)
                        .putExtra(
                            Constants.KEYS.INTENT_TYPE,
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE
                        )
                )
            } else {
                moveAssetsToInternal()
                startActivity(
                    Intent(this, ChatActivity::class.java)
                        .putExtra(Constants.KEYS.INTENT_NEW_CONVERSATION, true)
                        .putExtra(Constants.KEYS.INTENT_CONTACT, mContact)
                        .putExtra(
                            Constants.KEYS.INTENT_TYPE,
                            Constants.TYPES.CONVERSATION_ONE_TO_ONE
                        )
                        .putExtra(Constants.KEYS.INTENT_FILE_PATH, mFile!!.absolutePath)
                )
            }
        }
        mBinding!!.ivEditNickName.setOnClickListener { showChangeNickNameDialog() }
        mBinding!!.tvBlock.setOnClickListener { }
        mBinding!!.tvDeleteContact.setOnClickListener { showCustomDialog(0) }
        mBinding!!.tvBlock.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            if (mBinding!!.tvBlock.text.toString()
                    .equals(UNBLOCK, ignoreCase = true)
            ) showCustomDialog(2) else showCustomDialog(1)
        }
    }

    private fun moveAssetsToInternal() {
        val destPath = filesDir.absolutePath
        val movedFilesList = File(destPath).listFiles()
        val assetManager = assets
        var files: Array<String>? = null
        try {
            files = assetManager.list("")
            for (filename in files!!) {
                if (filename.contains(".jpg")) {
                    var inputStream: InputStream? = null
                    var outputStream: OutputStream? = null
                    inputStream = assetManager.open(filename)
                    val outFile = File(destPath, filename)
                    outputStream = FileOutputStream(outFile)
                    val buffer = ByteArray(1024)
                    var read: Int
                    while (inputStream.read(buffer).also { read = it } != -1) {
                        outputStream.write(buffer, 0, read)
                    }
                    inputStream.close()
                    outputStream.flush()
                    outputStream.close()
                    apkFile = File(destPath)
                    for (file in Objects.requireNonNull(
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
            0 -> {
                dialogBinding.tvTitle.text = String.format("Delete contact %s ?", mContact!!.name)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.delete_alert)
                dialogBinding.btnBlock.text = DELETE
            }

            1 -> {
                dialogBinding.tvTitle.text = String.format("Block %s ?", mContact!!.name)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.block_alert)
                dialogBinding.btnBlock.text = BLOCK
            }

            2 -> {
                dialogBinding.tvTitle.text = String.format("Unblock %s ?", mContact!!.name)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.unblock_alert)
                dialogBinding.btnBlock.text = UNBLOCK
            }
        }
        mCreateDialog!!.show()
        dialogBinding.btnBlock.setOnClickListener {
            when (i) {
                0 -> {

                    val character = NameUtil.getAbbreviation(mContact!!.name!!)
                    if (character != null) {
                        val file =
                            File(MainApp.imagesPathConv + "/" + character + mContact!!.avatarColor!!.serialize() + ".jpg")
                        if (file.exists()) {
                            file.delete()
                        }
                    }
                    contactsDao.delete(mContact)
                    finish()
                }

                1 -> {
                    mCreateDialog!!.dismiss()
                    blockUser()
                }

                2 -> {
                    mCreateDialog!!.dismiss()
                    unblock()
                }
            }
        }
        dialogBinding.btnCancel.setOnClickListener { mCreateDialog!!.dismiss() }
    }

    private fun unblock() {

        ApiHelper.with()?.unBlockUser(mContact!!.chatUserId, this, this@ContactDetailActivity)
//        NetworkCall.make()
//            .setCallback(this)
//            .setTag(RequestCodes.API.UNBLOCK_USER)
//            .autoLoadingCancel(getLoading(this, "unBlocking Please wait"))
//            .enque(
//                Network.apis().unblockUser(AppSession.getUser().chatUserId, mContact!!.chatUserId)
//            )
//            .execute()
        Log.d(
            TAG,
            Constants.CONTACTS_DETAILS_ACTIVITY + Constants.END_POINT + RequestCodes.API_END_POINTS.UNBLOCK_USER +
                    " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + "block id=" + mContact!!.chatUserId
        )
    }

    private fun blockUser() {

        ApiHelper.with()?.blockUser(mContact!!.chatUserId, this, this@ContactDetailActivity)
//        NetworkCall.make()
//            .setCallback(this)
//            .setTag(RequestCodes.API.BLOCK_USER)
//            .autoLoadingCancel(getLoading(this, "Blocking Please wait"))
//            .enque(Network.apis().blockUser(AppSession.getUser().chatUserId, mContact!!.chatUserId))
//            .execute()
        Log.d(
            TAG,
            Constants.CONTACTS_DETAILS_ACTIVITY + Constants.END_POINT + RequestCodes.API_END_POINTS.BLOCK_USER +
                    " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + "block id=" + mContact!!.chatUserId
        )
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
        bindingUpdateNickName.btnUpdateNickname.setOnClickListener {
            if (bindingUpdateNickName.etNickname.text != null && !bindingUpdateNickName.etNickname.text.toString()
                    .trim { it <= ' ' }
                    .isEmpty()
            ) {
//                    if (!name.equalsIgnoreCase(bindingUpdateNickName.etNickname.getText().toString())) {
                val nam = NameUtil.getAbbreviation(name!!)
                if (nam != null) {
                    val file =
                        File(MainApp.imagesPathConv + "/" + nam + mContact!!.avatarColor!!.serialize() + ".jpg")
                    if (file.exists()) {
                        file.delete()
                    }
                }
                mContact!!.name = bindingUpdateNickName.etNickname.text.toString()
                contactsDao.insert(mContact)
                mCreateDialog!!.dismiss()
                initViews()
                //                    } else {
//                        Notify.Toast("Can not set same name again");
//                    }
            }
        }
        bindingUpdateNickName.btnCancel.setOnClickListener { mCreateDialog!!.dismiss() }
    }

    //************************************************************
    //************************************************************
    private val contactDetails: Unit
        get() {
            if (intent.extras != null) {
                mContact = intent.getSerializableExtra("contact") as Contact?
            }
        }

    private fun checkConversation(contact: Contact?): Conversation? {
        var con: Conversation? = null
        val conversations = conversationsDao
            .allConversations
        if (!conversations.isNullOrEmpty()) {
            conversations.forEach { conversation ->
                if (conversation.conversationType.equals(
                        Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                        ignoreCase = true
                    )
                ) {
                    conversation.conversationMembers?.forEach { conversationMember ->

                        if (conversationMember.memberId.equals(
                                contact!!.chatUserId,
                                ignoreCase = true
                            )
                        ) {
                            con = conversation
                        }
                    }
                }

            }

        }
        return con
    }

    //************************************************************
    private fun setToolBar(toolbar: Toolbar) //************************************************************
    {
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    // ******************************************************************
    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean // ******************************************************************
    {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    @Throws(ParseException::class)
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag as Int == RequestCodes.API.BLOCK_USER) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                if (res != null && res.user != null) {
                    Log.d(
                        TAG,
                        Constants.CONTACTS_DETAILS_ACTIVITY + Constants.END_POINT + RequestCodes.API_END_POINTS.BLOCK_USER +
                                " Response: " +
                                res.toString()
                    )
                    var mUser: User? = User()
                    mUser = res.user
                    AppSession.saveUser(mUser)
                    initViews()
                } else Notify.Toast("No data found")
            }
        }
        if (tag == RequestCodes.API.UNBLOCK_USER) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                if (res != null && res.user != null) {
                    Log.d(
                        TAG,
                        "ContactDetailActivity unBlock: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UNBLOCK_USER +
                                " Response: " +
                                res.toString()
                    )
                    var mUser: User? = User()
                    mUser = res.user
                    AppSession.saveUser(mUser)
                    initViews()
                } else Notify.Toast("No data found")
            }
        }
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        //is used when API is failed
    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}