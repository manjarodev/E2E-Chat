package com.devbeans.io.chat.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import androidx.annotation.MainThread
import androidx.appcompat.widget.Toolbar
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.network.ApiHelper.Companion.with
import com.devbeans.io.chat.utils.Utills.showSubscriptionBanner
import com.devbeans.io.chat.verifypin.BaseActivity
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.models.Conversation
import androidx.databinding.DataBindingUtil
import com.devbeans.io.chat.app.MainApp
import com.github.dhaval2404.imagepicker.ImagePicker
import com.devbeans.io.chat.network.serializers.requestbody.UpdateConversationDesRequest
import com.devbeans.io.chat.network.serializers.requestbody.UpdateConversationNameRequest
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.databinding.ActivityDetailsEditBinding
import kotlin.Throws
import com.devbeans.io.chat.network.serializers.response.GetUpdateConversationImageResponse
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.Constants.KEYS.INTENT_CONVERSATION
import com.devbeans.io.chat.utils.Constants.TYPES.CONVERSATION_GROUP
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.text.ParseException
import java.util.*

//************************************************************
class DetailsEditActivity : BaseActivity(), OnNetworkResponse,
    ExpiryCallback //************************************************************
{
    var mBinding: ActivityDetailsEditBinding? = null
    var mConversation: Conversation? = null
    var BINDING_NOT_NULL = false
    var _nameChanged = false
    var _descriptionChange = false
    var _profileChange = false
    private var mFile: File? = null
    var _extension: String? = null
    var mFileName: String? = null


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_edit)
        setToolBar(mBinding?.toolbar!!)
        BINDING_NOT_NULL = mBinding != null
        appContext!!.currentActivity = this
        appContext!!.expiryListener = this
        intentData
        initViews()
        setupListeners()
    }

    /**
     * This method sets up listeners for the view elements.
     */
    private fun setupListeners() {
        // Set up a listener for the save info button.
        mBinding?.btnSaveInfo?.setOnClickListener {
            // Check if the chat name has changed.
            checkChatNameChange()

            // Check if the chat description has changed.
            checkChatDescriptionChange()

            // Check if the profile picture has changed.
            checkProfileChange()

            // Update the group info.
            updateGroupInfo()
        }

        // Set up a listener for the chat image view.
        mBinding?.ivChatImage?.setOnClickListener {
            // Open the image picker when the chat image view is clicked.
            ImagePicker.with(this@DetailsEditActivity)
                .compress(200)
                .maxResultSize(640, 640)
                .galleryOnly()
                .crop()
                .start(RequestCodes.GROUP_IMAGE)
        }
    }

    /**
     * Checks if the chat name has changed and sets _nameChanged accordingly.
     */
    private fun checkChatNameChange() {
        mBinding?.etChatName?.text?.toString()?.trim()?.let { chatName ->
            if (chatName.isNotEmpty() && chatName != mConversation?.name) {
                _nameChanged = true
            }
        }
    }

    /**
     * Checks if the chat description has changed and sets _descriptionChange accordingly.
     */
    private fun checkChatDescriptionChange() {
        mBinding?.etChatDescription?.text?.toString()?.trim()?.let { chatDescription ->
            if (chatDescription.isNotEmpty() && chatDescription != mConversation?.description) {
                _descriptionChange = true
            }
        }
    }

    /**
     * Checks if the profile picture has changed and sets _profileChange accordingly.
     */
    private fun checkProfileChange() {
        if (mFile?.exists() == true) {
            _profileChange = true
        }
    }


    private fun updateGroupInfo() {
        if (_profileChange) {

            //updating database with file path
            MainApp.database!!.conversationsDao()!!
                .updateFilePath(mConversation!!.conversationId, mFile!!.path)
            updateGroupProfile()
            //in result of this will check if ohter options needs to be updated of group
        } else if (_nameChanged) {
            updateGroupName()
            //in result will check only for description check and update
        } else if (_descriptionChange) {
            updateGroupDescription()
            //will only update description of group
        }
        mConversation =
            MainApp.database!!.conversationsDao()!!.getConversation(mConversation!!.conversationId)
    }

    private fun updateGroupProfile() {
        if (with() != null) with()!!
            .updateGroupProfile(
                mConversation!!.conversationId,
                _extension,
                mFile,
                this,
                this@DetailsEditActivity
            )
        //        NetworkCall
//                .make()
//                .setCallback(DetailsEditActivity.this)
//                .setTag(RequestCodes.API.UPLOAD_MEDIA_CONVERSATION_IMAGE)
//                .autoLoadingCancel(Utills.INSTANCE.getLoading(DetailsEditActivity.this, "Updating"))
//                .enque(Network.apis().updateConversationImage(FileUpload.requestBodyPDF(Constants.KEYS.MEDIA, mFile),
//                        FileUpload.uploadConversationImage(AppSession.getUser().getChatUserId(), mConversation.getConversationId(), _extension)))
//                .execute();
    }

    private fun updateGroupDescription() {
        val request = UpdateConversationDesRequest()
        request.conversation_id = mConversation!!.conversationId
        request.description = mBinding!!.etChatDescription.text.toString()
        if (with() != null) with()!!
            .updateGroupDescription(request, this, this@DetailsEditActivity)
        //        NetworkCall
//                .make()
//                .setCallback(this)
//                .setTag(RequestCodes.API.UPDATE_CONVERSATION_DESCRIPTION)
//                .autoLoadingCancel(Utills.INSTANCE.getLoading(this, "Updating"))
//                .enque(Network.apis().updateConversationDescription(AppSession.getUser().getChatUserId(), request))
//                .execute();
    }

    private fun updateGroupName() {
        val request = UpdateConversationNameRequest()
        request.conversation_id = mConversation!!.conversationId
        request.name = mBinding!!.etChatName.text.toString()
        if (with() != null) with()!!
            .updateGroupName(request, this)
        //        NetworkCall
//                .make()
//                .setCallback(DetailsEditActivity.this)
//                .setTag(RequestCodes.API.UPDATE_CONVERSATION_NAME)
//                .enque(Network.apis().updateConversationName(AppSession.getUser().getChatUserId(), request))
//                .execute();
    }

    /**
     * Initializes the view elements with data from the conversation.
     */
    private fun initViews() {
        // Safe calls are used to avoid null pointer exceptions.
        mBinding?.let { binding ->
            mConversation?.let { conversation ->
                // Extract the conversation name and description to avoid repetitive calls.
                val conversationName = conversation.name
                val conversationDescription = conversation.description

                // Set the chat name text.
                binding.etChatName.setText(conversationName)

                // Set the chat description text.
                binding.etChatDescription.setText(
                    if (conversationDescription.equals(CONVERSATION_GROUP, ignoreCase = true))
                        "" else conversationDescription
                )

                // Set the camera icon visibility.
                binding.ivCamera.visibility = if (mFile != null) View.GONE else View.VISIBLE

                // Set the conversation description.
                conversation.description =
                    if (conversationDescription == CONVERSATION_GROUP) "" else conversationDescription
            }
        }
    }


    private val intentData: Unit
        private get() {
            if (intent.hasExtra(INTENT_CONVERSATION)) {
                mConversation =
                    intent.getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation
            }
        }

    override fun onResume() {
        appContext!!.currentActivity = this
        appContext!!.expiryListener = this
        super.onResume()
    }

    //************************************************************
    private fun setToolBar(toolbar: Toolbar) //************************************************************
    {
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    // ******************************************************************
    @MainThread
    override fun onOptionsItemSelected(item: MenuItem): Boolean // ******************************************************************
    {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == RequestCodes.GROUP_IMAGE) {
            data?.let {
                data.data?.let {
                    val extension = AndroidUtil.getMimeType(this, data.data)
                    val uri = data.data
                    var path: String? = ""
                    when (extension) {
                        "png", "jpg", "jpeg" -> {
                            _extension = extension
                            path = FilePath.getPath(this, uri)
                            assert(path != null)
                            val file = File(path!!)
                            if (file.exists()) {
                                handleFileToUpload(file)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun handleFileToUpload(file: File) {
        mFile = file
        mFileName = file.name
        mBinding!!.ivCamera.visibility =
            if (mFile!!.exists()) View.GONE else View.VISIBLE
        Glide.with(this).load(file).into(mBinding!!.ivChatImage)
    }

    @Throws(ParseException::class)
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag as Int == RequestCodes.API.UPLOAD_MEDIA_CONVERSATION_IMAGE) {
            if (response.code() == 200) {
                _profileChange = false
                val res = response.body() as GetUpdateConversationImageResponse?
                handleGroupIconResponse(res)
            }
        }
        if (tag == RequestCodes.API.UPDATE_CONVERSATION_NAME) {
            if (response.code() == 200) {
                _nameChanged = false
                val res = response.body() as NewConversationResponse?
                res?.let {


                    //update database room
                    MainApp.database!!.conversationsDao()!!
                        .updateConversationName(
                            mConversation!!.conversationId,
                            mBinding!!.etChatName.text.toString()
                        )
                    if (_descriptionChange) updateGroupDescription() else finish()
                    //will go to update description here
                }
            }
        }
        if (tag == RequestCodes.API.UPDATE_CONVERSATION_DESCRIPTION) {
            if (response.code() == 200) {
                _descriptionChange = false
                val res = response.body() as NewConversationResponse?
                res?.let {


                    //update database room
                    MainApp.database!!.conversationsDao()!!
                        .updateConversationDes(
                            mConversation!!.conversationId,
                            mBinding!!.etChatDescription.text.toString()
                        )
                    finish()
                    //will go back to Details Activity
                }
            }
        }
    }

    private fun handleGroupIconResponse(res: GetUpdateConversationImageResponse?) {
        if (res != null && res.status.equals("Success", ignoreCase = true)) {


            //update database room
            MainApp.database!!.conversationsDao()!!.updateConversationIcon(
                mConversation!!.conversationId,
                mFile!!.path,
                mFileName
            )
            if (_nameChanged) updateGroupName() else if (_descriptionChange) updateGroupDescription() else finish()
            //will go to update description here
        }
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        //is used for API failure
    }
    override fun notifyExpiry() {
        if (mBinding != null) {
            showSubscriptionBanner(mBinding!!.tvSubs)
        }
    }
}