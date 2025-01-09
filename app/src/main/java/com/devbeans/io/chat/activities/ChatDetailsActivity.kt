package com.devbeans.io.chat.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.GroupMemberAdapter
import com.devbeans.io.chat.adapters.ImageAdapter
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.callBacks.OnLongMemberCallback
import com.devbeans.io.chat.callBacks.OnMembersCallback
import com.devbeans.io.chat.databinding.*
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.conversationChannelsDao
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.ConversationMember
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest
import com.devbeans.io.chat.network.serializers.requestbody.LeaveGroupRequest
import com.devbeans.io.chat.network.serializers.requestbody.RemoveAnonymousMembersRequest
import com.devbeans.io.chat.network.serializers.requestbody.RemoveMembersConversationRequest
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.Constants.TYPES
import com.devbeans.io.chat.utils.DateTime.getFormattedDateOnly
import com.devbeans.io.chat.utils.Utills.colors
import com.devbeans.io.chat.utils.Utills.getDisappearingOptions
import com.devbeans.io.chat.utils.Utills.getNameDrawable
import com.devbeans.io.chat.utils.Utills.rnd
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.text.ParseException
import java.util.*


class ChatDetailsActivity() : BaseActivity(), OnNetworkResponse, OnLongMemberCallback,
    OnMembersCallback, ExpiryCallback {
    var mBinding: ActivityChatDetailsBinding? = null
    private var mImageAdapter: ImageAdapter? = null
    private var mMembersAdapter: GroupMemberAdapter? = null
    private var mCancel: AppCompatButton? = null
    private var mAddContact: AppCompatButton? = null
    private var mDialog: AlertDialog? = null
    var mConversation: Conversation? = null
    var NewConversation: Conversation? = null
    private var mContact: Contact? = null
    private var mIsContact = false
    private var isOwner = false
    var isAdmin = false
    private var mIsOneToOne = false
    private var memberAdded = false
    private var payload: Payload? = null
    var userIdEdit: TextInputEditText? = null
    var nameEdit: TextInputEditText? = null
    var memberList = ArrayList<String?>()
    private val UNBLOCK = "Unblock"
    private val BLOCK = "Block"
    private val DELETE = "Delete"
    private val CLEAR = "Clear"
    private val LEAVE_GROUP = "Leave Group"
    private val DELETE_GROUP = "Delete Group"
    private val CHANGE_OWNER = "Change Owner"
    val isCleared = MutableLiveData<Boolean>()
    private var mDialogViewRemove: AlertDialog? = null
    private var mCreateDialog: AlertDialog? = null
    private var conversation_pk = 0
    private var addedByQr: Boolean = false


    override fun onDestroy() {
        super.onDestroy()
    }


    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat_details)
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        setToolBar(mBinding!!.toolbar)
        if (Build.VERSION.SDK_INT >= 21) {
            postponeEnterTransition()
            val inflater = TransitionInflater.from(this)
            window.sharedElementEnterTransition =
                inflater.inflateTransition(R.transition.avatar_enter_transition)
            window.sharedElementReturnTransition =
                inflater.inflateTransition(R.transition.avatar_enter_transition)
            ActivityCompat.startPostponedEnterTransition(this)
        }
        appContext!!.currentActivity = this
        chatDetails
        checkAdmin()
//        initViews()
        populateRecyclerView()
        observers()
        initDialog()
        listeners()
    }


    /**
     * Checks if the current user is an admin or owner of the conversation.
     */
    private fun checkAdmin() {
        val conversationType = mConversation?.conversationType
        val owner = mConversation?.owner
        val myMoniker = mConversation?.myMoniker
        val chatUserId = AppSession.getUser().chatUserId

        // Check if the conversation type is a group anonymous conversation
        if (conversationType.equals(TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true)) {
            // Check if the current user is the owner of the conversation
            isOwner = owner.equals(myMoniker, ignoreCase = true)
        } else {
            // Check if the current user is the owner of the conversation
            isOwner = owner.equals(chatUserId, ignoreCase = true)
        }

        // Find the current user in the list of conversation members
        val conversationMember = mConversation?.conversationMembers?.find { member ->
            if (conversationType.equals(TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true)) {
                myMoniker != null && myMoniker.equals(member.memberId, ignoreCase = true)
            } else {
                chatUserId.equals(member.memberId, ignoreCase = true)
            }
        }

        // Check if the current user is an admin
        isAdmin = !conversationMember?.type.equals("member", ignoreCase = true)

        initViews()
    }


    /**
     * Initializes the views for the conversation screen.
     */
    fun initViews() {
        mBinding?.let { binding ->
            // Set visibility of views to GONE
            arrayOf(
                binding.ivVaultSave,
                binding.tvAutoSaveVault,
                binding.checkAutoSave,
                binding.tvAutoSaveVaultNote,
                binding.seperator9
            ).forEach { it.visibility = GONE }

            // Set checked state of checkMessageConfidential and checkMediaSharing
            binding.apply {
                checkMessageConfidential.isChecked = mConversation?.isConfidential ?: false
                checkMediaSharing.isChecked = mConversation?.isCanShareForward ?: false
                handleGroupOptions(this)
                handleFadeOptions(this)
            }

            handleVisibilityOptions()
            handleConversationIcon()

            // Set text of tvChatId based on contact alias
            binding.tvChatId.text = mContact?.alias?.trim()?.takeIf { it.isNotEmpty() }
                ?.let { String.format(Locale.getDefault(), "( %s )", it) } ?: ""

            // Set text and color of tvDescription based on conversation description and owner
            binding.tvDescription.apply {
                if (mConversation?.description.equals(
                        TYPES.CONVERSATION_GROUP,
                        ignoreCase = true
                    ) &&
                    mConversation?.owner.equals(AppSession.getUser().chatUserId, ignoreCase = true)
                ) {
                    text = AndroidUtil.getString(R.string.add_group_description)
                } else {
                    text = if (mConversation?.description.equals(
                            TYPES.CONVERSATION_GROUP,
                            ignoreCase = true
                        )
                    ) {
                        ""
                    } else {
                        mConversation?.description ?: ""
                    }

                }
            }

            handleGroupVisibilityOptions()

            // Set checked state of checkAutoSave, checkMediaSharing and checkMediaVisibility
            binding.checkAutoSave.isChecked = mConversation?.isAutoSaveVault ?: false
            binding.checkMediaSharing.isChecked = mConversation?.isCanShareForward ?: false
            binding.checkMediaVisibility.isChecked = mConversation?.isViewOnce ?: false

            // Set text of tvChatName based on whether conversation is one-to-one or group
            binding.tvChatName.text = if (mIsOneToOne) mContact?.name else mConversation?.name


            handleReadReceiptsViews(binding)
        }
    }

    /**
     * Handles the read receipts views based on the user's settings.
     *
     * @param binding The binding for the chat details activity.
     */
    private fun handleReadReceiptsViews(binding: ActivityChatDetailsBinding) {
        binding.apply {
            // Check if message read receipts are enabled in the user's settings
            if (SettingsValues.getMessageReadReceipts()) {
                checkReadReceipts.isChecked = mConversation?.conReadReceipts ?: false
                // Show the read receipts views
                Utills.fadeInTV(tvReadReceipts)
                Utills.fadeInNote(tvReadReceiptsNote)
                Utills.fadeInDrawable(ivReadReceipts)
            } else {
                // Disable the read receipts checkbox and hide the read receipts views
                checkReadReceipts.isClickable = false
                checkReadReceipts.isChecked = false
                Utills.fadeOutTV(tvReadReceipts)
                Utills.fadeOutNote(tvReadReceiptsNote)
                Utills.fadeOutDrawable(ivReadReceipts)
            }
        }
    }

    /**
     * This method handles the visibility options for a group chat.
     * It sets the visibility of various views based on whether the chat is one-to-one or not.
     * It also sets the text for the group created date if the chat is not one-to-one.
     */
    private fun handleGroupVisibilityOptions() {
        mBinding?.apply {
            // Set visibility of clear chat options based on whether the chat is one-to-one or not
            val visibility = if (mIsOneToOne) View.VISIBLE else GONE
            tvClearChat.visibility = visibility
            tvClearChatLayout.visibility = visibility

            // Set text for group created date if the chat is not one-to-one
            if (!mIsOneToOne) {
                tvGroupCreatedAt.text = String.format(
                    AndroidUtil.getString(R.string.created_on_group),
                    getFormattedDateOnly(mConversation!!.con_createdAt)
                )
            }

            // Set visibility of group members layout and separator based on whether the chat is one-to-one or not
            val groupVisibility = if (mIsOneToOne) GONE else View.VISIBLE
            layoutGroupMembers.visibility = groupVisibility
            separator2.visibility = groupVisibility

            // Clear and leave group
            clearAndLeaveGroup(this)
        }
    }

    private fun clearAndLeaveGroup(binding: ActivityChatDetailsBinding) {
        binding.apply {
            tvClearGroup.visibility = if (mIsOneToOne) GONE else View.VISIBLE
            tvClearGroupLayout.visibility = if (mIsOneToOne) GONE else View.VISIBLE
            tvLeaveGroup.visibility = if (mIsOneToOne) GONE else View.VISIBLE
            tvDestroyGroup.visibility =
                if (!mIsOneToOne && isOwner && !mConversation!!.isRemoved) View.VISIBLE else GONE

            handleLeaveText(this)
        }
    }

    /**
     * Handles the leave group text view based on the conversation type and owner.
     *
     * @param binding The binding for the chat details activity.
     */
    private fun handleLeaveText(binding: ActivityChatDetailsBinding) {
        binding.apply {
            val conversationType = mConversation?.conversationType
            val owner = mConversation?.owner
            val myMoniker = mConversation?.myMoniker
            val isRemoved = mConversation?.isRemoved ?: false

            // Check if the conversation type is a group anonymous conversation
            if (conversationType.equals(TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true)) {
                // Show or hide the leave group text view based on whether the current user is the owner of the conversation
                tvLeaveGroup.visibility =
                    if (owner.equals(myMoniker, ignoreCase = true)) GONE else View.VISIBLE
            } else {
                // Show or hide the leave group text view based on whether the conversation is one-to-one
                tvLeaveGroup.visibility = if (mIsOneToOne) GONE else View.VISIBLE
            }

            // Set the leave group text and icon based on whether the user has been removed from the conversation
            tvLeaveGroup.text =
                if (isRemoved) AndroidUtil.getString(R.string.delete_group_chat_details) else AndroidUtil.getString(
                    R.string.leave_group_chat_details
                )
            tvLeaveGroup.setCompoundDrawablesWithIntrinsicBounds(
                if (isRemoved) R.drawable.ic_delete else R.drawable.ic_logout,
                0,
                0,
                0
            )
        }
    }

    /**
     * Handles the conversation icon based on the conversation type and photo.
     */
    private fun handleConversationIcon() {
        val conversationPhoto = mConversation?.conversationPhoto
        val conversationType = mConversation?.conversationType
        val photo = mConversation?.photo

        // Check if the conversation is not one-to-one and has a valid photo
        if (!mIsOneToOne && photo != null && !photo.equals(
                Constants.KEYS.DUMMY_IMAGE,
                ignoreCase = true
            ) && conversationPhoto != null && conversationPhoto.isNotEmpty()
        ) {
            val file = File(conversationPhoto)
            // Load the conversation photo if it exists, otherwise load a default unknown image
            loadConversationIcon(if (file.exists()) conversationPhoto else R.drawable.ic_unknown)
        } else {
            // Check if the conversation is one-to-one
            if (conversationType.equals(TYPES.CONVERSATION_ONE_TO_ONE, ignoreCase = true)) {
                // Load the contact name drawable if it's a contact, otherwise load a default unknown image
                loadConversationIcon(
                    if (mIsContact) getNameDrawable(
                        mContact!!.name,
                        mContact!!.avatarColor!!
                    ) else R.drawable.ic_unknown
                )
            } else {
                // Load the group name drawable
                loadConversationIcon(getNameDrawable(mConversation!!.name, AvatarColor.GROUP))
            }
        }
    }

    /**
     * Loads the conversation icon using Glide.
     *
     * @param icon The icon to load. Can be a String or an Int.
     */
    private fun loadConversationIcon(icon: Any) {
        Glide.with(appContext!!).load(icon).into(mBinding!!.ivChatImage)
    }

    /**
     * Handles the visibility options for the conversation screen.
     */
    private fun handleVisibilityOptions() {
        mBinding?.let { binding ->
            // Set visibility of addMembersLayout based on whether user is owner or admin and conversation is not removed
            binding.addMembersLayout.visibility =
                if (!mConversation?.isRemoved!! && (isOwner || isAdmin)) View.VISIBLE else GONE

            // Set text of disappearOption based on conversation expiry time
            binding.disappearOption.text =
                getDisappearingOptions(mConversation?.conversationExpiryTime!!)

            handleDetailsEditOption(binding)

            // Set visibility of tvDescription based on whether conversation is one-to-one or group
            binding.tvDescription.visibility = if (mIsContact || mIsOneToOne) GONE else View.VISIBLE

            // Set visibility of tvChatId based on whether conversation is with a contact
            binding.tvChatId.visibility = if (mIsContact) View.VISIBLE else GONE

            // Set visibility of ivEditNickName based on whether conversation is one-to-one with a contact
            binding.ivEditNickName.visibility =
                if (mIsContact && mIsOneToOne) View.VISIBLE else GONE
        }
    }

    /**
     * Handles the visibility of the edit option for the conversation details screen.
     *
     * @param binding The binding object for the conversation details screen.
     */
    private fun handleDetailsEditOption(binding: ActivityChatDetailsBinding?) {
        binding?.ivEdit?.visibility = when {
            // Set visibility to GONE if conversation is with a contact or one-to-one or if user is not owner or if conversation is removed
            mIsContact || mIsOneToOne || mConversation?.isRemoved == true -> GONE
            mConversation?.conversationType.equals(
                TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            ) ->
                if (mConversation?.owner.equals(
                        mConversation?.myMoniker,
                        ignoreCase = true
                    )
                ) View.VISIBLE else GONE

            else ->
                if (mConversation?.owner.equals(
                        AppSession.getUser().chatUserId,
                        ignoreCase = true
                    )
                ) View.VISIBLE else GONE
        }
    }

    private fun handleFadeOptions(binding: ActivityChatDetailsBinding) {
        binding.apply {

            when (!mConversation?.isRemoved!! && (isOwner || isAdmin || mConversation?.conversationType?.equals(
                Constants.TYPES.CONVERSATION_ONE_TO_ONE,
                ignoreCase = true
            )!!)) {
                true -> {
                    Utills.fadeInTV(tvMessageConfidential)
                    Utills.fadeInTV(tvMediaSharing)
                    Utills.fadeInTV(titleDisappear)
                    Utills.fadeInNote(tvMessageConfidentialNote)
                    Utills.fadeInNote(tvMediaSharingNote)
                    Utills.fadeInDrawable(ivMediaSharing)
                    Utills.fadeInDrawable(ivMessageConfidential)

                }

                false -> {
                    Utills.fadeOutTV(tvMessageConfidential)
                    Utills.fadeOutTV(tvMediaSharing)
                    Utills.fadeOutNote(tvMessageConfidentialNote)
                    Utills.fadeOutNote(tvMediaSharingNote)
                    Utills.fadeOutNote(titleDisappear)
                    Utills.fadeOutDrawable(ivMediaSharing)
                    Utills.fadeOutDrawable(ivMessageConfidential)
                }

            }

        }

    }

    private fun handleGroupOptions(binding: ActivityChatDetailsBinding) {
        binding.apply {
            arrayOf(
                tvMessageConfidential,
                tvMessageConfidentialNote,
                ivMessageConfidential,
                checkMessageConfidential,
                seperator13,
                tvMediaSharing,
                tvMediaSharingNote,
                checkMediaSharing,
                ivMediaSharing,
                seperator10,
                separatorDis,
                titleDisappear,
                disappearOption
            )
                .forEach {
                    it.isClickable = if (mConversation?.conversationType?.equals(
                            TYPES.CONVERSATION_ONE_TO_ONE,
                            ignoreCase = true
                        )!!
                    ) {
                        true
                    } else {

                        !mConversation?.isRemoved!! && (isOwner || isAdmin)
                    }
                }
        }
    }


    private val chatDetails: Unit
        get() {
            if (intent.extras != null) {
                try {
                    if (intent.hasExtra("conversation")) {
                        mConversation = intent.getSerializableExtra("conversation") as Conversation?
                        conversation_pk = mConversation!!.uid
                        mIsOneToOne =
                            mConversation!!.conversationType.equals("one-to-one", ignoreCase = true)
                    }
                    if (intent.hasExtra("contact")) {
                        mContact = intent.getSerializableExtra("contact") as Contact?
                    }
                    if (intent.hasExtra("isContact")) {
                        mIsContact = intent.getBooleanExtra("isContact", false)
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception in Getting intent ${e.message}")
                }
            }
        }

    //************************************************************
    private fun observers() //************************************************************
    {
//        MainApp.database.conversationsDao().getConversationName(mConversation.getConversationId()).observe(this, name -> {
//            assert name != null;
//            if (!TextUtils.isEmpty(name)) {
//                mBinding.tvChatName.setText(name);
//            }
//        });

//        MainApp.database.conversationsDao().getConversationDescription(mConversation.getConversationId()).observe(this, name -> {
//            assert name != null;
//            if (!TextUtils.isEmpty(name.trim())) {
//                if (!mConversation.getDescription().equalsIgnoreCase(CONVERSATION_GROUP)) {
//                    mBinding.tvDescription.setTextColor(AndroidUtil.getColor(R.color.faded_black));
//                    mBinding.tvDescription.setText(name);
//                } else {
//                    mBinding.tvDescription.setTextColor(AndroidUtil.getColor(R.color.blue));
//                    mBinding.tvDescription.setText(AndroidUtil.getString(R.string.add_group_description));
//                }
//            }
//        });
    }


    /**
     * This method sets up the listeners for the various views in the ChatDetailsActivity
     */
    private fun listeners() {
        // Add members button
        mBinding!!.addMembersLayout.setOnClickListener {
            handleAddMember()
        }

        // Cancel button in add contact dialog
        mCancel?.let {
            mCancel!!.setOnClickListener {
                mDialog!!.dismiss()
            }
        }

        // Add contact button in add contact dialog
        mAddContact?.let {
            handleAddContactClick()
        }

        // Clear group button
        mBinding!!.tvClearGroup.setOnClickListener { showCustomDialog(4) }

        // Total label
        mBinding!!.tvTotal.setOnClickListener {
            handTvTotalClick()
        }

        // Total count label
        mBinding!!.tvTotalCount.setOnClickListener {
            handleTvTotalCountClick()
        }


        // Description label
        mBinding!!.tvDescription.setOnClickListener {
            handleTvDescriptionClick()
        }

        // Media, docs and links title
        mBinding!!.titleMediaDocsLinks.setOnClickListener { startMediaDetailsActivity() }

        // Media count label
        mBinding!!.tvMediaCount.setOnClickListener { startMediaDetailsActivity() }

        // Forward button
        mBinding!!.ivForward.setOnClickListener { startMediaDetailsActivity() }

        mBinding!!.rvImages.setOnClickListener { startMediaDetailsActivity() }

        // Edit button
        mBinding!!.ivEdit.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }
            startDetailsEditActivity()
        }

        // Clear chat button
        mBinding!!.tvClearChat.setOnClickListener { showCustomDialog(4) }

        // Disappear title
        mBinding!!.titleDisappear.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            startDisappearingActivity(
                mBinding!!.disappearOption.text.toString()
            )
        }

        // Edit nickname button
        mBinding!!.ivEditNickName.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }
            showChangeNickNameDialog()
        }

        // Leave group button
        mBinding!!.tvLeaveGroup.setOnClickListener {
            handleLeaveGroup()
        }

        // Destroy group button
        mBinding!!.tvDestroyGroup.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }
            showDeleteGroupDialog()
        }

        mBinding!!.checkMediaSharing.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }
            updateMediaShareRestrict(mBinding!!.checkMediaSharing.isChecked)
        }

        mBinding!!.checkMessageConfidential.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }
            updateConfidential(mBinding!!.checkMessageConfidential.isChecked)
        }

        mBinding!!.checkAutoSave.setOnCheckedChangeListener { _, b ->
            mConversation!!.isAutoSaveVault = b
            updateAutoSaveToVault(b)
        }

        mBinding!!.checkMediaVisibility.setOnCheckedChangeListener { _, b ->
            mConversation!!.isViewOnce = b
            updateViewOnce(b)
        }

        mBinding!!.checkReadReceipts.setOnClickListener {
            val isChecked = mBinding!!.checkReadReceipts.isChecked
            updateReadReceipts(isChecked)
        }

    }

    private fun updateReadReceipts(isChecked: Boolean) {
        mConversation?.conReadReceipts = isChecked

        // Update the chat activity's conversation readReceipts
        ChatActivity.getInstance()?.conversation?.conReadReceipts = isChecked


        // Update the conversation ReadReceipts on a background thread
        ChatExecutors.SERIAL.execute {
            conversationsDao.updateReadReceipts(mConversation?.conversationId, isChecked)
        }
    }

    private fun updateMediaShareRestrict(isChecked: Boolean) {
        mConversation!!.isCanShareForward = isChecked
        ChatExecutors.SERIAL.execute {
            ApiHelper.with()?.updateMediaShareRestrict(
                mConversation!!.conversationId,
                isChecked,
                mConversation!!.conversationType,
                this@ChatDetailsActivity
            )
            conversationsDao.updateCanShareForward(mConversation!!.conversationId, isChecked)
        }
    }

    private fun updateConfidential(isChecked: Boolean) {
        mConversation!!.isConfidential = isChecked
        ChatActivity.getInstance()?.conversation?.isConfidential = isChecked
        ChatActivity.getInstance()?.handleSendConfidentialMessage()
        ChatExecutors.SERIAL.execute {
            ApiHelper.with()?.updateConfidential(
                mConversation!!.conversationId,
                isChecked,
                mConversation!!.conversationType,
                this@ChatDetailsActivity
            )
            conversationsDao.updateIsConfidential(mConversation!!.conversationId, isChecked)
        }
    }

    private fun updateAutoSaveToVault(isChecked: Boolean) {
        ChatExecutors.SERIAL.execute {
            conversationsDao.updateAutoSaveToVault(mConversation!!.conversationId, isChecked)
        }
    }

    private fun updateViewOnce(isChecked: Boolean) {
        ChatExecutors.SERIAL.execute {
            conversationsDao.updateViewOnce(mConversation!!.conversationId, isChecked)
            updateConversationViewOnce(isChecked)
        }
    }


    private fun handleTvDescriptionClick() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }

        if (mConversation!!.owner.equals(
                AppSession.getUser().chatUserId,
                ignoreCase = true
            ) && !mConversation!!.isRemoved && mConversation!!.description
                .equals(TYPES.CONVERSATION_GROUP, ignoreCase = true)
        ) startDetailsEditActivity()
    }

    private fun handleTvTotalCountClick() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        openMembersActivity()
    }

    private fun handTvTotalClick() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        openMembersActivity()
    }

    private fun handleAddContactClick() {
        mAddContact!!.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            handleAddContact()
        }
    }

    private fun handleAddMember() {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
            return
        }
        showLoadingDialog()
    }

    private fun handleLeaveGroup() {
        if (mConversation!!.isRemoved) {
            showCustomDialog(6)
        } else {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
            } else {
                showCustomDialog(5)
            }
        }
    }

    private fun handleAddContact() {
        if (userIdEdit!!.getText().toString().isNotEmpty()
        ) {
            if (nameEdit!!.getText().toString().isNotEmpty()
            ) {
                var isMember = false
                if (memberList.contains(userIdEdit!!.getText().toString())) isMember = true
                if (!isMember) verifyUser(
                    userIdEdit!!.getText().toString()
                ) else Notify.Toast("Already member")
            } else Notify.Toast("Please add name to continue")
        } else Notify.Toast("Please add user id")
    }

    //updating isViewOnce on Server
    private fun updateConversationViewOnce(viewOnce: Boolean) {
        if (mConversation != null && !Utills.isSubscriptionExpired()) {
            Log.d(
                TAG,
                ("updateConversationViewOnce: " + Constants.END_POINT + RequestCodes.API_END_POINTS.VIEW_ONCE +
                        " Request: " +
                        "conversation_id=" + mConversation!!.conversationId +
                        "is_view_once=" + viewOnce)
            )
            ApiHelper.with()?.updateViewOnce(
                mConversation!!.conversationId,
                viewOnce, this
            )
        }
    }


    /**
     * Shows a dialog to change the nickname of a contact in the conversation.
     * This function creates and shows an AlertDialog with a custom layout, and sets click listeners for the update and cancel buttons.
     */
    private fun showChangeNickNameDialog() {
        // Inflate the custom layout for the update nickname dialog
        val alertCustomDialog =
            LayoutInflater.from(this).inflate(R.layout.custom_update_nickname_dailog, null)

        // Bind the custom layout to a binding object
        val bindingUpdateNickName = CustomUpdateNicknameDailogBinding.bind(alertCustomDialog)

        // Create an AlertDialog builder
        val alert = AlertDialog.Builder(this)

        // Set the custom layout for the AlertDialog
        alert.setView(bindingUpdateNickName.root)

        // Create the AlertDialog
        mCreateDialog = alert.create()

        // Make the dialog background transparent
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Set the current nickname in the EditText field
        val name = mContact!!.name
        bindingUpdateNickName.etNickname.setText(name)

        // Show the dialog
        mCreateDialog!!.show()

        // Set the click listener for the update button
        bindingUpdateNickName.btnUpdateNickname.setOnClickListener {
            // Check if subscription has expired
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            // Check if the nickname is not null or empty
            if (!bindingUpdateNickName.etNickname.text.isNullOrEmpty()) {
                // Delete the old profile image file
                val nam = NameUtil.getAbbreviation(name!!)
                if (nam != null) {
                    val file =
                        File(MainApp.imagesPathConv + "/" + nam + mContact!!.avatarColor!!.serialize() + ".jpg")
                    if (file.exists()) {
                        file.delete()
                    }
                }

                // Update the contact's nickname
                mContact!!.name = bindingUpdateNickName.etNickname.text.toString()
                contactsDao.insert(mContact)

                // Dismiss the dialog and update the UI
                mCreateDialog!!.dismiss()
                initViews()
            }
        }

        // Set the click listener for the cancel button
        bindingUpdateNickName.btnCancel.setOnClickListener {
            mCreateDialog!!.dismiss()
        }
    }


    private fun verifyUser(userId: String) {
        Log.d(
            TAG,
            ("Chat Details Activity verifyUser: " + Constants.END_POINT + RequestCodes.API_END_POINTS.VERIFY_USER +
                    " Request: " +
                    "chat_user_id=" + userId)
        )

        ApiHelper.with()?.verifyUser(userId, this, this);

    }

    //************************************************************
    private fun showCustomDialog(i: Int)
    //************************************************************
    {
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

            4 -> {
                dialogBinding.tvTitle.text =
                    String.format("Clear chat of %s ?", mConversation!!.name)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.clear_alert)
                dialogBinding.btnBlock.text = CLEAR
            }

            5 -> if (mConversation != null && mConversation!!.owner.equals(
                    AppSession.getUser().chatUserId,
                    ignoreCase = true
                )
            ) {
                dialogBinding.tvTitle.text = String.format("Leave %s ?", mConversation!!.name)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.owner_change_alert)
                dialogBinding.btnBlock.text = CHANGE_OWNER
            } else {
                dialogBinding.tvTitle.text = String.format("Leave  %s ?", mConversation!!.name)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.leave_group_alert)
                dialogBinding.btnBlock.text = LEAVE_GROUP
            }

            6 -> {
                dialogBinding.tvTitle.text = String.format("Delete %s ?", mConversation!!.name)
                dialogBinding.tvDeleteNotification.text =
                    AndroidUtil.getString(R.string.delete_group_alert)
                dialogBinding.btnBlock.text = DELETE_GROUP
            }
        }
        mCreateDialog!!.show()
        dialogBinding.btnBlock.setOnClickListener {
            when (i) {
                4 -> {
                    mCreateDialog!!.dismiss()
                    clearChat()
                }

                5 -> if (mConversation != null && mConversation!!.owner
                        .equals(AppSession.getUser().chatUserId, ignoreCase = true)
                ) leaveGroup(0) else leaveGroup(1)

                6 -> {
                    clearChat()
                    conversationsDao.delete(mConversation)
                    val intent = Intent(appContext, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    appContext!!.startActivity(intent)
                    finish()
                }
            }
        }
        dialogBinding.btnCancel.setOnClickListener { mCreateDialog!!.dismiss() }
    }

    /**
     * Shows a dialog to delete the group in the conversation.
     * This function creates and shows an AlertDialog with a custom layout, and sets click listeners for the delete and cancel buttons.
     */
    private fun showDeleteGroupDialog() {
        // Inflate the custom layout for the delete message dialog
        val alertCustomDialog =
            LayoutInflater.from(this).inflate(R.layout.custom_delete_message, null)

        // Bind the custom layout to a binding object
        val deleteDialogBinding = CustomDeleteMessageBinding.bind(alertCustomDialog)

        // Create an AlertDialog builder
        val alert = AlertDialog.Builder(this)

        // Set the custom layout for the AlertDialog
        alert.setView(deleteDialogBinding.root)

        // Create the AlertDialog
        mCreateDialog = alert.create()

        // Show the close and alert icons
        deleteDialogBinding.ivClose.visibility = View.VISIBLE
        deleteDialogBinding.ivAlert.visibility = View.VISIBLE

        // Set the title, notification, and button text for the dialog
        deleteDialogBinding.tvTitle.text = AndroidUtil.getString(R.string.destroy_group)
        deleteDialogBinding.tvDeleteNotification.text =
            AndroidUtil.getString(R.string.destroy_group_notification_dialog)
        deleteDialogBinding.btnDeleteForMe.text = AndroidUtil.getString(R.string.destroy)
        deleteDialogBinding.btnCancel.text = AndroidUtil.getString(R.string.cancel)

        // Set the background for the delete and cancel buttons
        deleteDialogBinding.btnDeleteForMe.background =
            AndroidUtil.getDrawable(R.drawable.bg_button_backup_red)
        deleteDialogBinding.btnCancel.background =
            AndroidUtil.getDrawable(R.drawable.bg_button_cancel_delete_dark)



        // Make the dialog background transparent
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Show the dialog
        mCreateDialog!!.show()

        // Hide the delete for everyone button
        deleteDialogBinding.btnDeleteForEveryone.visibility = GONE

        // Set the click listener for the delete for me button
        deleteDialogBinding.btnDeleteForMe.setOnClickListener {
            // Send a request to destroy the conversation
            ApiHelper.with()?.destroyConversation(
                mConversation!!.conversationId,
                this,
                this@ChatDetailsActivity
            )

            // Dismiss the dialog
            mCreateDialog!!.dismiss()
        }

        // Set the click listener for the cancel button
        deleteDialogBinding.btnCancel.setOnClickListener {
            mCreateDialog!!.dismiss()
        }

        // Set the click listener for the close icon
        deleteDialogBinding.ivClose.setOnClickListener {
            mCreateDialog!!.dismiss()
        }
    }

    /**
     * Leaves the group in the conversation.
     * This function starts the MembersActivity if `i` is 0, and sends a leave group request to the API if `i` is 1.
     */
    private fun leaveGroup(i: Int) {
        // Store the last message in the payload if the conversation and its last message are not null
        payload = mConversation?.lastMessage

        when (i) {
            0 -> {
                // Start the MembersActivity if i is 0
                startActivity(
                    Intent(this, MembersActivity::class.java)
                        .putExtra("conversation", mConversation)
                        .putExtra("fromChangeOwner", "fromChangeOwner")
                )
            }

            1 -> {
                // Send a leave group request to the API if i is 1
                val request = LeaveGroupRequest()
                request.user_chat_id = AppSession.getUser().chatUserId
                ApiHelper.with()?.leaveGroup(
                    mConversation?.conversationId!!,
                    request,
                    this,
                    this@ChatDetailsActivity
                )
            }
        }
    }


    private fun startDisappearingActivity(option: String) {
        startActivity(
            Intent(this@ChatDetailsActivity, DisappearingMsgActivity::class.java).putExtra(
                "option",
                option
            )
                .putExtra(Constants.KEYS.INTENT_CONVERSATION, mConversation)
        )
        finish()
    }

    private fun startMediaDetailsActivity() {
        startActivity(
            Intent(
                this,
                MediaDetailsActivity::class.java
            ).putExtra(Constants.KEYS.INTENT_CONVERSATION, mConversation)
        )
    }


    private fun startDetailsEditActivity() {
        startActivity(
            Intent(this, DetailsEditActivity::class.java)
                .putExtra(Constants.KEYS.INTENT_CONVERSATION, mConversation)
        )
    }


    private fun openMembersActivity() {
        startActivity(
            Intent(this, MembersActivity::class.java).putExtra(
                "conversation",
                mConversation
            )
        )
    }


    private fun setToolBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    /**
     * Populates the images in the conversation.
     * This function sets the layout manager for the images RecyclerView, sets the images adapter,
     * shows the media, populates the members in the conversation, and sets the text for the group creation time.
     */
    private fun populateRecyclerView() {
        // Check if the binding is not null
        mBinding?.let { binding ->
            // Set the layout manager for the images RecyclerView
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.rvImages.layoutManager = layoutManager

            // Set the images adapter
            mImageAdapter = ImageAdapter()
            binding.rvImages.adapter = mImageAdapter

            // Show the media
            showMedia()

            // Populate the members in the conversation
            populateMembers()

            // Set the text for the group creation time
//            val createdAt = "Created on ${DateTime.getFormattedTimeOnly(mConversation!!.createdAt)}"
//            binding.tvGroupCreatedAt.text = createdAt
        }
    }


    /**
     * Populates the members in the conversation.
     * This function sets the layout manager for the members RecyclerView, sets the members adapter,
     * sets the members name, and logs the conversation owner.
     */
    private fun populateMembers() {
        // Check if the binding is not null
        mBinding?.let { binding ->
            // Set the layout manager for the members RecyclerView
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvMembers.layoutManager = layoutManager

            // Set the members adapter
            mMembersAdapter = GroupMemberAdapter(mConversation!!, this, true, this, this)
            binding.rvMembers.adapter = mMembersAdapter

            // Set the members name
            setMembersName()

            // Log the conversation owner
            Log.d("TAG", "populateRecyclerView: ${mConversation?.owner}")
        }
    }


    /**
     * Handles the change of admin status for the members in the conversation.
     * This function checks the admin status, sets the layout manager for the members RecyclerView,
     * sets the members adapter, sets the members name, and logs the conversation owner.
     */
    fun adminMemberChange() {
        // Check if the binding is not null
        mBinding?.let { binding ->
            // Check the admin status
            checkAdmin()

            // Set the layout manager for the members RecyclerView
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvMembers.layoutManager = layoutManager

            // Set the members adapter
            mMembersAdapter = GroupMemberAdapter(mConversation!!, this, true, this, this)
            binding.rvMembers.adapter = mMembersAdapter

            // Set the members name
            setMembersName()

            // Log the conversation owner
            Log.d("TAG", "populateRecyclerView: ${mConversation?.owner}")
        }
    }


    /**
     * Sets the members name in the conversation.
     * This function updates the total count of members in the conversation, sets the member list in the adapter,
     * updates the visibility of the total count and total view, and stores the member IDs in a list.
     */
    private fun setMembersName() {
        // Check if the conversation and its members are not null
        mConversation?.conversationMembers?.let { members ->

            val sortedList = members.sortedByDescending {
                when
                { mConversation?.conversationType.equals(Constants.TYPES.CONVERSATION_GROUP_ANONYMOUS) -> it.isMe else -> it.memberId.equals(AppSession.getUser().chatUserId) } }.toMutableList()

            // Update the total count of members in the conversation
            mBinding?.tvTotalCount?.text = members.size.toString()

            // Set the member list in the adapter
            mMembersAdapter?.setMemberList(sortedList, true)

            // Update the visibility of the total count and total view
            mBinding?.tvTotal?.visibility = if (members.size > 4) View.VISIBLE else View.GONE
            mBinding?.tvTotalCount?.visibility = if (members.size > 4) View.VISIBLE else View.GONE

            // Store the member IDs in a list
            memberList.clear()
            for (member in members) {
                memberList.add(member.memberId)
            }
        }

        // Log the member list
        Log.d("TAG", "setMembersName: $memberList")
    }


    /**
     * This function is used to display media related to a conversation.
     * It first checks if any media message exists for the conversation.
     * If yes, it fetches all media messages and filters out the downloaded ones
     * which are not view-once and confidential.
     * Finally, it updates the UI based on whether any downloaded media is present.
     */
    private fun showMedia() {
        // Safety checks for nullable variables
        val conversation = mConversation ?: return
        val imageAdapter = mImageAdapter ?: return
        val binding = mBinding ?: return

        // Fetching all media messages once to avoid multiple DB queries
        val allMediaMessages = messagesDao.getAllMediaMessages(conversation.conversationId)

        // Check if media is shared
        if (!allMediaMessages.isNullOrEmpty()) {
            // Create a list to store downloaded media messages
            val downloadedList: MutableList<Payload> = ArrayList()

            // Loop through all media messages
            allMediaMessages.forEach { payload ->
                // Check if filePath is present, media is not view-once and confidential
                payload.filePath?.takeIf { !payload.isViewOnce && !payload.isConfidential }?.let {
                    // Check if the file exists, if so add to downloaded list
                    if (File(it).exists()) {
                        downloadedList.add(payload)
                    }
                }
            }

            // If there are any downloaded media, update adapter and UI
            if (downloadedList.isNotEmpty()) {
                imageAdapter.setMSharedList(downloadedList)
                binding.tvMediaCount.text = downloadedList.size.toString()
            } else {
                hideMediaUI(binding)
            }
        } else {
            hideMediaUI(binding)
        }
    }

    /**
     * This function is used to hide media related UI elements.
     * @param binding: The reference to the view binding
     */
    private fun hideMediaUI(binding: ActivityChatDetailsBinding) {
        // No media to display, hide relevant UI
        binding.MediaDocsLinksLayout.visibility = GONE
        binding.separator.visibility = GONE
    }



    private fun initDialog() {
        val alertCustomdialog =
            LayoutInflater.from(this).inflate(R.layout.custom_dailog_new_contact, null)
        //initialize alert builder.
        val alert = AlertDialog.Builder(this)

        //set our custom alert dialog to tha alertdialog builder
        alert.setView(alertCustomdialog)
        mDialog = alert.create()
        mCancel = alertCustomdialog.findViewById(R.id.btn_cancel_one)
        mAddContact = alertCustomdialog.findViewById(R.id.btn_add_contact_one)
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
        val scanQr = alertCustomdialog.findViewById<ImageView>(R.id.layout_scan_qr_one)
        val tvOr = alertCustomdialog.findViewById<TextView>(R.id.tv_or)
        val ivSub = alertCustomdialog.findViewById<ImageView>(R.id.iv_subtract)
        val btnAddExisting: AppCompatButton =
            alertCustomdialog.findViewById(R.id.btn_add_exist_contact)
        btnAddExisting.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }
            startActivityForResult(
                Intent(this@ChatDetailsActivity, AddMemberActivity::class.java).putExtra(
                    Constants.KEYS.INTENT_MEMBER_LIST, memberList
                ), RequestCodes.GET_MEMBER_ID
            )
            mDialog!!.dismiss()
        }
        tvOr.visibility = View.VISIBLE
        ivSub.visibility = View.VISIBLE
        btnAddExisting.visibility = View.VISIBLE
        scanQr.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            startActivityForResult(
                Intent(
                    this@ChatDetailsActivity,
                    QRScannerActivity::class.java
                ), RequestCodes.SCAN_QR
            )
        }
    }

    //************************************************************
    @Deprecated("Deprecated in Java")
    public override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) //************************************************************
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == RequestCodes.SCAN_QR && !Utills.isSubscriptionExpired()) {
            data?.let {
                data.extras?.let {
                    val userId = data.getStringExtra("userId")
                    userIdEdit?.let {
                        userIdEdit!!.setText(userId)
                    }
                    addedByQr = true;
                }
            }
        }
        if (resultCode == RESULT_OK && requestCode == RequestCodes.GET_MEMBER_ID && !Utills.isSubscriptionExpired()) {
            data?.let {
                data.extras?.let {
                    val userId =
                        data.getSerializableExtra(Constants.KEYS.INTENT_MEMBER_ID) as Contact?
                    //                String userName = data.getStringExtra(Constants.KEYS.INTENT_MEMBER_NAME);
                    userId?.let {
                        val isMember = memberList.contains(userId.chatUserId)
                        if (!isMember) {
                            addMember(userId)
                        } else {
                            Notify.Toast("Already member")
                        }
                    }
                }
            }
        }
    }

    //********************************************************************
    protected fun showLoadingDialog() //********************************************************************
    {
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //finally show the dialog box in android all
        mDialog!!.show()
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


    //************************************************************
    private fun clearChat()
    //************************************************************
    {
        val mediaMessage = messagesDao
            .getAllMediaMessages(mConversation!!.conversationId)
        //Getting all the media files of the conversation for them to delete
        mediaMessage?.let {
            mediaMessage.forEach { payload ->
                //If there are any media files delete them one by one
                payload.filePath?.let {
                    val file = File(payload.filePath!!)
                    //if the file exist delete it from the file path
                    if (file.exists()) {
                        Utills.handleFileDelete(TAG, file.delete())
                        messagesDao.deleteByMessageId(payload.messageId)
                    }
                }

            }
        }
        //Delete all messages of the conversation from local Database
        messagesDao
            .deleteConversationMessages(mConversation!!.conversationId)

        //Removing View of shared Media
        showMedia()

        //Removing last message of the conversation
        mConversation!!.lastMessage?.let {
            mConversation!!.lastMessage = null
            try {
                conversationsDao.update(mConversation)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        ChatActivity.getInstance()?.let {
            ChatActivity.getInstance()!!.conversation?.let {
                if (ChatActivity.getInstance()!!.conversation!!.conversationId.equals(
                        mConversation!!.conversationId, ignoreCase = true
                    )
                ) {
                    ChatActivity.getInstance()!!.clearChat()
                }
            }
        }

    }


    /**
     * Adds a new member to the conversation.
     *
     * @param contact the [Contact] to add as a member
     */
    private fun addMember(contact: Contact) {
        // Check if conversation has fewer than 20 members
        if ((mConversation?.conversationMembers?.size ?: 0) < 20) {
            // Create a new request to add the member
            val request = AddMembersConversationRequest().apply {
                members = contact.chatUserId // Add the member's ID
                userChatId = AppSession.getUser().chatUserId // Set the user's ID
                type = "new_member" // Set the type of the request
            }

            // Attempt to add the member to the conversation
            memberAdded = true // Set the flag to indicate that a member was added
            when (mConversation?.conversationType?.lowercase(Locale.getDefault())) {
                TYPES.CONVERSATION_GROUP -> {
                    ApiHelper.with()?.addMemberGroup(
                        mConversation!!.conversationId,
                        request,
                        this@ChatDetailsActivity,
                        this@ChatDetailsActivity
                    )
                }

                TYPES.CONVERSATION_GROUP_ANONYMOUS -> {
                    ApiHelper.with()?.addMemberAnonymous(
                        mConversation!!.conversationId,
                        request,
                        this@ChatDetailsActivity,
                        this@ChatDetailsActivity
                    )
                }
            }
        } else {
            // Display an error message if the conversation already has 20 members
            Notify.Toast(AndroidUtil.getString(R.string.error_member_add))
        }
    }


    //************************************************************
    private fun addRemoveAdmin(
        member: ConversationMember,
        i: Int
    ) //************************************************************
    {
        if (mConversation!!.conversationMembers!!.size < 20) {
            val request = AddMembersConversationRequest()
            //            List<String> members = new ArrayList<>();
//            members.add(contact.getChatUserId());
            request.members = member.memberId
            request.userChatId = AppSession.getUser().chatUserId
            request.type = if (i == 0) "admin" else "member"
            memberAdded = false

            handleGroupAddApi(request)


        } else {
            Notify.Toast("Group can have maximum 20 members Only")
        }
    }

    /**
     * This method handles adding members to a group conversation.
     *
     * @param request The AddMembersConversationRequest object containing the request information.
     */
    private fun handleGroupAddApi(request: AddMembersConversationRequest) {
        val admin = "admin"
        val member = "member"

        // Check if the conversation type is anonymous group
        if (mConversation?.conversationType.equals(
                TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) {

            // If the request type is admin, assign admin anonymous
            if (request.type.equals(admin, ignoreCase = true)) {
                ApiHelper.with()?.adminAssignedAnonymous(
                    mConversation!!.conversationId,
                    request,
                    this,
                    this@ChatDetailsActivity
                )
            }

            // If the request type is member, remove member from anonymous group
            if (request.type.equals(member, ignoreCase = true)) {
                ApiHelper.with()?.adminRemoveAnonymous(
                    mConversation!!.conversationId,
                    request,
                    this,
                    this@ChatDetailsActivity
                )
            }
        }

        // Check if the conversation type is regular group
        if (mConversation?.conversationType.equals(TYPES.CONVERSATION_GROUP, ignoreCase = true)) {

            // If the request type is admin, assign admin to group
            if (request.type.equals(admin, ignoreCase = true)) {
                ApiHelper.with()?.adminAssignedGroup(
                    mConversation!!.conversationId,
                    request,
                    this,
                    this@ChatDetailsActivity
                )
            }

            // If the request type is member, remove member from group
            if (request.type.equals(member, ignoreCase = true)) {
                ApiHelper.with()?.adminRemoveGroup(
                    mConversation!!.conversationId,
                    request,
                    this,
                    this@ChatDetailsActivity
                )
            }
        }
    }

    /**
     * Handles successful API responses based on the request tag.
     *
     * @param call The original call object.
     * @param response The successful response object.
     * @param tag The request code representing the API call made.
     * @throws ParseException if there is an error parsing the response.
     */
    @Throws(ParseException::class)
    override fun onSuccess(
        call: Call<*>?,
        response: Response<*>,
        tag: Any
    ) {
        // Cast tag to Int and use when expression to match against various request codes
        when (tag as Int) {
            RequestCodes.API.VERIFY_USER -> handleVerifyUserResponse(response)
            RequestCodes.API.ADD_MEMBER -> handleResponse(response, ::handleMemberAddedResponse)
            RequestCodes.API.ADD_MEMBER_GROUP -> handleResponse(
                response,
                ::handleMemberAddedGroupResponse
            )

            RequestCodes.API.ADD_MEMBER_ANONYMOUS -> handleResponse(
                response,
                ::handleMemberAddedAnonymousResponse
            )

            RequestCodes.API.ADMIN_ASSIGNED_GROUP -> handleResponse(
                response,
                ::handleAdminAssignedGroupResponse
            )

            RequestCodes.API.ADMIN_ASSIGNED_ANONYMOUS -> handleResponse(
                response,
                ::handleAdminAssignedAnonymousResponse
            )

            RequestCodes.API.ADMIN_REMOVED_GROUP -> handleResponse(
                response,
                ::handleAdminRemovedGroupResponse
            )

            RequestCodes.API.ADMIN_REMOVED_ANONYMOUS -> handleResponse(
                response,
                ::handleAdminRemovedAnonymousResponse
            )

            RequestCodes.API.REMOVE_MEMBER -> handleResponse(
                response,
                ::handleRemoveMemberGroupResponse
            )

            RequestCodes.API.REMOVE_ANONYMOUS_MEMBER -> handleResponse(
                response,
                ::handleRemoveMemberAnonymousResponse
            )

            RequestCodes.API.LEAVE_GROUP -> handleResponse(response, ::handleLeaveGroupResponse)
            RequestCodes.API.UPDATE_VIEW_ONCE -> handleResponse(
                response,
                ::handleUpdateViewOnceResponse
            )

            RequestCodes.API.DESTROY_CONVERSATION -> handleResponse(
                response,
                ::handleDestroyConversationResponse
            )

            RequestCodes.API.UPDATE_CONFIDENTIAL -> handleResponse(
                response,
                ::handleUpdateConfidentialResponse
            )

            RequestCodes.API.UPDATE_MEDIA_SHARE_RESTRICT -> handleResponse(
                response,
                ::handleUpdateMediaRestrictResponse
            )
        }
    }

    /**
     * Helper function to handle API responses with onSuccess and onFailure cases.
     *
     * @param response The response object.
     * @param onSuccessHandler The success handler function.
     */
    private fun handleResponse(
        response: Response<*>,
        onSuccessHandler: (NewConversationResponse?) -> Unit
    ) {
        if (response.isSuccessful) {
            // Use safe cast operator to cast response body to expected class
            val res = response.body() as? NewConversationResponse
            onSuccessHandler(res)
        } else {
            handleFailure(response)
        }
    }

    /**
     * Handles failed API responses by displaying a toast and logging the error message.
     *
     * @param response The failed response object.
     */
    private fun handleFailure(response: Response<*>) {
        Notify.Toast(response.message())
        Log.e(TAG, "${Constants.ON_SUCCESS}${response.message()}")
    }

    /**
     * Handles the response from the server for updating the media sharing restriction setting of the conversation.
     *
     * @param res The response object containing the updated conversation details.
     */
    private fun handleUpdateMediaRestrictResponse(res: NewConversationResponse?) {
        res?.let { response ->
            dismissDialogs()
            response.conversation?.let { conversation ->
                logUpdateMediaRestrictResponse(conversation)
            } ?: run {
                Notify.Toast(Constants.NO_DATA_FOUND)
            }
        }
    }


    /**
     * Logs the update media sharing restriction response.
     */
    private fun logUpdateMediaRestrictResponse(conversation: Conversation) {
        Log.d(
            TAG,
            "Update UPDATE_MEDIA_SHARE_RESTRICT: ${Constants.END_POINT}${RequestCodes.API_END_POINTS.VIEW_ONCE}" +
                    Constants.RESPONSE +
                    conversation.toString()
        )
    }


    /**
     * Handles the response from the server for updating the confidentiality setting of the conversation.
     *
     * @param res The response object containing the updated conversation details.
     */
    private fun handleUpdateConfidentialResponse(res: NewConversationResponse?) {
        res?.let { response ->
            dismissDialogs()
            response.conversation?.let { conversation ->
                logUpdateConfidentialResponse(conversation)
                // Uncomment the following lines if you want to update the local database and UI
                // based on the response.
                // updateConfidentialSetting(conversation)
                // initViews()
                // populateMembers()
            } ?: run {
                Notify.Toast(Constants.NO_DATA_FOUND)
            }
        }
    }

    /**
     * Logs the update confidentiality response.
     */
    private fun logUpdateConfidentialResponse(conversation: Conversation) {
        Log.d(
            TAG,
            "Update UPDATE_CONFIDENTIAL: ${Constants.END_POINT}${RequestCodes.API_END_POINTS.VIEW_ONCE}" +
                    Constants.RESPONSE +
                    conversation.toString()
        )
    }

    /**
     * Updates the confidentiality setting of the conversation in the local database.
     */
    private fun updateConfidentialSetting(conversation: Conversation) {
        // Update the confidentiality setting of the conversation in the local database.
        conversationsDao.updateViewOnce(
            mConversation?.conversationId,
            conversation.isViewOnce
        )
    }

    /**
     * Handles the response from the server for destroying the conversation.
     *
     * @param res The response object containing the conversation details.
     */
    private fun handleDestroyConversationResponse(res: NewConversationResponse?) {
        res?.let {
            dismissDialogs()
            updateLocalConversationData()
            updateUIAfterDestroyingConversation()
        } ?: run {
            Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }


    /**
     * Updates the local conversation data after the conversation has been destroyed.
     */
    private fun updateLocalConversationData() {
        mConversation?.let {
            it.isRemoved = true
            conversationsDao.update(it)
        }
    }

    /**
     * Updates the UI and removes the conversation from the chat activity after the conversation has been destroyed.
     */
    private fun updateUIAfterDestroyingConversation() {
        ChatActivity.getInstance()?.let { chatActivity ->
            chatActivity.conversation?.takeIf {
                it.conversationId.equals(
                    mConversation?.conversationId,
                    ignoreCase = true
                )
            }?.let {
                chatActivity.removedFromConvo(mConversation?.conversationId!!)
            }
        }
        initViews()
        populateMembers()
    }


    /**
     * Handles the response from the server for updating the view once setting of the conversation.
     *
     * @param res The response object containing the updated conversation details.
     */
    private fun handleUpdateViewOnceResponse(res: NewConversationResponse?) {
        res?.let { response ->
            dismissDialogs()
            response.conversation?.let { conversation ->
                logUpdateViewOnceResponse(conversation)
                // Uncomment the following lines if you want to update the local database and UI
                // based on the response.
                // updateViewOnceSetting(conversation)
                // initViews()
                // populateMembers()
            } ?: run {
                Notify.Toast(Constants.NO_DATA_FOUND)
            }
        }
    }


    /**
     * Logs the update view once response.
     */
    private fun logUpdateViewOnceResponse(conversation: Conversation) {
        Log.d(
            TAG,
            "Update View Once: ${Constants.END_POINT}${RequestCodes.API_END_POINTS.VIEW_ONCE}" +
                    Constants.RESPONSE +
                    conversation.toString()
        )
    }

    /**
     * Updates the view once setting of the conversation in the local database.
     */
    private fun updateViewOnceSetting(conversation: Conversation) {
        // Update the view once setting of the conversation in the local database.
        conversationsDao.updateViewOnce(
            mConversation?.conversationId,
            conversation.isViewOnce
        )
    }


    /**
     * Handles the leave group response from the server, updates the local database, and updates UI accordingly.
     *
     * @param res The response object containing the conversation details after leaving the group.
     */
    private fun handleLeaveGroupResponse(res: NewConversationResponse?) {
        res?.let { response ->
            dismissDialogs()
            response.conversation?.let { conversation ->
                logResponse(conversation)

                val moniker = getMoniker(conversation)
                val conversationPhotoPath = getConversationPhotoPath(conversation)

                updateConversation(conversation, moniker, conversationPhotoPath)
                handleUIUpdates(conversation, moniker, conversationPhotoPath)
            } ?: run {
                Notify.Toast(Constants.NO_DATA_FOUND)
            }
        }
    }


    /**
     * Logs the leave group response.
     */
    private fun logResponse(conversation: Conversation) {
        Log.d(
            TAG,
            "Chat Details Activity Leave Group: ${Constants.END_POINT}${RequestCodes.API_END_POINTS.LEAVE_GROUP}" +
                    Constants.RESPONSE +
                    conversation.toString()
        )
    }

    /**
     * Determines the appropriate moniker to use for the current user.
     */
    private fun getMoniker(conversation: Conversation): String {
        return mConversation?.takeIf {
            it.myMoniker != null && it.conversationType.equals(
                TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        }
            ?.myMoniker ?: AppSession.getUser().chatUserId!!
    }

    /**
     * Gets the conversation photo path if it exists.
     */
    private fun getConversationPhotoPath(conversation: Conversation): String? {
        return conversation.conversationPhoto?.takeIf { it.isNotEmpty() && File(it).exists() }
    }

    /**
     * Updates the local conversation data with the new conversation data from the response.
     */
    private fun updateConversation(
        conversation: Conversation,
        moniker: String,
        conversationPhotoPath: String?
    ) {
        mConversation = conversation.apply {
            uid = conversation_pk
            isRemoved = true
            myMoniker = moniker
            sequenceOfConversation = System.currentTimeMillis()
            conversationPhoto = conversationPhotoPath
        }
        conversationsDao.update(mConversation)
    }

    /**
     * Handles updating the UI after leaving the group.
     */
    private fun handleUIUpdates(
        conversation: Conversation,
        moniker: String,
        conversationPhotoPath: String?
    ) {
        if (conversation.conversationType.equals(
                TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) {
            deleteAndResetChannels(conversation, moniker)
        } else {
            conversationsDao.updateMyMoniker(
                conversation.conversationId,
                AppSession.getUser().chatUserId
            )
        }

        ChatActivity.getInstance()?.let { chatActivity ->
            chatActivity.conversation?.takeIf {
                it.conversationId.equals(
                    conversation.conversationId,
                    ignoreCase = true
                )
            }?.let {
                chatActivity.conversation = mConversation

                if (payload != null) {
                    mConversation!!.lastMessage = payload
                    chatActivity.removedFromConvo(payload!!)
                } else {
                    chatActivity.removedFromConvo(mConversation!!.conversationId!!)
                }

                chatActivity.setMembersName()
            }
        }
        initViews()
        populateMembers()
    }

    /**
     * Deletes and resets the channels for the anonymous group conversation.
     */
    private fun deleteAndResetChannels(conversation: Conversation, moniker: String) {
        conversation.conversationMembers?.forEach { member ->
            member.moniker?.takeIf { it.isNotEmpty() }?.let { moniker ->
                conversationChannelsDao.deleteConversationChannel(
                    Utills.getHash("${conversation.conversationId}&&${moniker}")!!
                )
            }
        }
        conversationsDao.updateMyMoniker(conversation.conversationId, moniker)
    }


    /**
     * Handles the response for removing a member from an anonymous conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleRemoveMemberAnonymousResponse(res: NewConversationResponse?) {
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logRemoveMemberDetails(conversation)

                val moniker = mConversation?.myMoniker
                // Retrieve the path to the conversation photo if it exists
                val path = getConversationPhotoPath()

                // Update the conversation object with new data and persist it
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update the user's moniker and fetch the updated conversation
                updateMyMoniker(moniker)
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Set the conversation object in the ChatActivity, update member names, and populate members
                updateChatActivityInstance()
                ChatActivity.getInstance()?.setMembersName()
                populateMembers()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }

    /**
     * Updates the user's moniker based on the conversation type.
     *
     * @param moniker The moniker to be updated in the case of an anonymous conversation.
     */
    private fun updateMyMoniker(moniker: String?) {
        if (mConversation?.conversationType.equals(
                TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) {
            moniker?.let {
                conversationsDao.updateMyMoniker(mConversation!!.conversationId, it)
            }
        } else {
            conversationsDao.updateMyMoniker(
                mConversation!!.conversationId,
                AppSession.getUser().chatUserId
            )
        }
    }


    /**
     * Handles the response for removing a member from a group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleRemoveMemberGroupResponse(res: NewConversationResponse?) {
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logRemoveMemberDetails(conversation)

                // Retrieve the path to the conversation photo if it exists
                val path = getConversationPhotoPath()

                // Update the conversation object with new data and persist it
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update the user's moniker and fetch the updated conversation
                updateMyMoniker()
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Set the conversation object in the ChatActivity, update member names, and populate members
                updateChatActivityInstance()
                ChatActivity.getInstance()?.setMembersName()
                populateMembers()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }

    /**
     * Logs the details of a removed member in a group conversation.
     *
     * @param conversation The conversation object containing the removed member's details.
     */
    private fun logRemoveMemberDetails(conversation: Conversation) {
        Log.d(
            TAG,
            "Chat Details Activity Remove Member: ${Constants.END_POINT}${RequestCodes.API_END_POINTS.ADD_MEMBER_CONVERSATION}" +
                    "${Constants.RESPONSE}$conversation"
        )
    }

    /**
     * Handles the response for removing admin role from a member in an anonymous group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleAdminRemovedAnonymousResponse(res: NewConversationResponse?) {
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logConversationDetails(conversation)

                // Retrieve the path to the conversation photo if it exists
                val path = getConversationPhotoPath()

                // Update the conversation object with new data and persist it
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update the user's moniker and fetch the updated conversation
                updateMyMoniker()
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Set the conversation object in the ChatActivity and populate members
                updateChatActivityInstance()
                populateMembers()

                // Create a symmetric handshake if a new member was added
                createSymmetricHandshakeIfNeeded()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }


    /**
     * Handles the response for removing admin role from a member in a group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleAdminRemovedGroupResponse(res: NewConversationResponse?) {
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logConversationDetails(conversation)

                // Retrieve the path to the conversation photo if it exists
                val path = getConversationPhotoPath()

                // Update the conversation object with new data and persist it
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update the user's moniker and fetch the updated conversation
                updateMyMoniker()
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Set the conversation object in the ChatActivity and populate members
                updateChatActivityInstance()
                populateMembers()

                // Create a symmetric handshake if a new member was added
                createSymmetricHandshakeIfNeeded()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }

    /**
     * Handles the response for assigning admin role to a member in an anonymous group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleAdminAssignedAnonymousResponse(res: NewConversationResponse?) {
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logConversationDetails(conversation)

                // Retrieve the path to the conversation photo if it exists
                val path = getConversationPhotoPath()

                // Update the conversation object with new data and persist it
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update the user's moniker and fetch the updated conversation
                updateMyMoniker()
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Set the conversation object in the ChatActivity and populate members
                updateChatActivityInstance()
                populateMembers()

                // Create a symmetric handshake if a new member was added
                createSymmetricHandshakeIfNeeded()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }


    /**
     * Handles the response for assigning admin role to a member in a group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleAdminAssignedGroupResponse(res: NewConversationResponse?) {
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logConversationDetails(conversation)

                // Retrieve the path to the conversation photo if it exists
                val path = getConversationPhotoPath()

                // Update the conversation object with new data and persist it
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update the user's moniker and fetch the updated conversation
                updateMyMoniker()
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Set the conversation object in the ChatActivity and populate members
                updateChatActivityInstance()
                populateMembers()

                // Create a symmetric handshake if a new member was added
                createSymmetricHandshakeIfNeeded()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }


    /**
     * Handles the response for adding a member to an anonymous conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleMemberAddedAnonymousResponse(res: NewConversationResponse?) {
        // Check if the response is not null
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logConversationDetails(conversation)

                // Update the conversation object with new data and persist it
                val path = getConversationPhotoPath()
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update the user's moniker and fetch the updated conversation
                updateMyMoniker()
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Set the conversation object in the ChatActivity and populate members
                updateChatActivityInstance()
                populateMembers()

                // Create a symmetric handshake if a new member was added
                createSymmetricHandshakeIfNeeded()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }


    /**
     * Handles the response for adding a member to a group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleMemberAddedGroupResponse(res: NewConversationResponse?) {
        // Check if the response is not null
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logConversationDetails(conversation)

                // Retrieve the path to the conversation photo if it exists
                val path = getConversationPhotoPath()

                // Update the conversation object with new data and persist it
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update the user's moniker and fetch the updated conversation
                updateMyMoniker()
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Set the conversation object in the ChatActivity and populate members
                updateChatActivityInstance()
                populateMembers()

                // Create a symmetric handshake if a new member was added
                createSymmetricHandshakeIfNeeded()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }


    /**
     * Handles the response for adding a member to a conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private fun handleMemberAddedResponse(res: NewConversationResponse?) {
        // Check if the response is not null
        res?.let {
            // Dismiss dialogs if they are showing
            dismissDialogs()

            it.conversation?.let { conversation ->
                logConversationDetails(conversation)

                // Update conversation's photo path if it exists
                val path = getConversationPhotoPath()

                // Update conversation properties and persist it
                updateConversationProperties(conversation, path)
                conversationsDao.update(mConversation)

                // Update my moniker and fetch the updated conversation
                updateMyMoniker()
                mConversation = conversationsDao.getConversation(conversation.conversationId)

                // Update the ChatActivity instance and populate members
                updateChatActivityInstance()
                populateMembers()

                // Create a symmetric handshake if a new member was added
                createSymmetricHandshakeIfNeeded()
            } ?: Notify.Toast(Constants.NO_DATA_FOUND)
        }
    }

    private fun dismissDialogs() {
        mDialogViewRemove?.takeIf { it.isShowing }?.dismiss()
        mCreateDialog?.takeIf { it.isShowing }?.dismiss()
    }

    private fun logConversationDetails(conversation: Conversation) {
        Log.d(
            TAG,
            "${Constants.CHAT_DETAILS_ADD_MEMBER}${Constants.END_POINT}${RequestCodes.API_END_POINTS.ADD_MEMBER_CONVERSATION}${Constants.RESPONSE}${conversation}"
        )
    }

    private fun getConversationPhotoPath(): String? {
        mConversation?.let { con ->
            if (!con.conversationPhoto.isNullOrEmpty() && File(con.conversationPhoto!!).exists()) {
                return con.conversationPhoto
            }
        }
        return null
    }

    private fun updateConversationProperties(conversation: Conversation, path: String?) {
        mConversation = conversation
        mConversation!!.uid = conversation_pk
        mConversation!!.sequenceOfConversation = System.currentTimeMillis()
        path?.let { mConversation?.conversationPhoto = it }
    }

    private fun updateMyMoniker() {
        if (mConversation!!.conversationType.equals(
                TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) {
            mConversation!!.conversationMembers?.forEach { conversationMember ->
                if (conversationMember.isMe) {
                    conversationsDao.updateMyMoniker(
                        mConversation!!.conversationId,
                        conversationMember.moniker
                    )
                    return@forEach
                }
            }
        } else {
            conversationsDao.updateMyMoniker(
                mConversation!!.conversationId,
                AppSession.getUser().chatUserId
            )
        }
    }

    private fun updateChatActivityInstance() {
        ChatActivity.getInstance()?.conversation = mConversation
    }

    private fun createSymmetricHandshakeIfNeeded() {
        if (memberAdded && ChatActivity.getInstance() != null) {
            ChatActivity.getInstance()!!.CreateMainSymmeticHandshake(
                mConversation!!.conversationId!!,
                null,
                null
            )
        }
    }


    private fun handleVerifyUserResponse(response: Response<*>) {

        val res = response.body() as BaseResponse?
        res?.let {
            Log.d(
                TAG,
                ("Chat Details Activity verifyUser: " + Constants.END_POINT + RequestCodes.API_END_POINTS.VERIFY_USER +
                        Constants.RESPONSE +
                        res.toString())
            )
            if (res.status.equals("Success", ignoreCase = true) && res.isUser) {
                val contact = Contact()
                contact.chatUserId = userIdEdit!!.text.toString()
                contact.name = nameEdit!!.text.toString()
                contact.color = colors[rnd.nextInt(colors.size)]
                contact.avatarColor = AvatarColor.random()
                contact.isQrAdded = addedByQr
                val contacts: List<Contact> = contactsDao
                    .allContacts as List<Contact>
                var hasContact = false
                var existedContact = Contact()
                if (contacts.isNotEmpty()) {
                    contacts.forEach { contact1 ->
                        if (contact1.chatUserId.equals(
                                contact.chatUserId,
                                ignoreCase = true
                            )
                        ) {
                            hasContact = true
                            existedContact = contact1
                        }
                    }
                    handleUpdatingContacts(hasContact, existedContact, contact)
                } else {
                    contactsDao.insert(contact)
                    addMember(contact)
                    Notify.Toast("New contact added")
                }
                nameEdit!!.setText("")
                userIdEdit!!.setText("")
                mDialog!!.dismiss()
            }
        } ?: run {
            Notify.Toast(Constants.NO_DATA_FOUND)
        }

    }

    private fun handleUpdatingContacts(
        hasContact: Boolean,
        existedContact: Contact,
        contact: Contact
    ) {
        if (hasContact) {
            existedContact.name = nameEdit!!.text.toString()
            contactsDao.insert(existedContact)
            addMember(existedContact)
            Notify.Toast("Contact updated")
        } else {
            contactsDao.insert(contact)
            addMember(contact)
            Notify.Toast("New contact added")
        }
    }

    //************************************************************
    override fun onFailure(
        call: Call<*>?,
        response: BaseResponse,
        tag: Any
    ) //************************************************************
    {
        Log.e(TAG, "Response $response")
    }

    //************************************************************
    override fun onLongMemberCallback(
        member: ConversationMember,
        name: String
    ) //************************************************************
    {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
        } else {
            showViewRemoveDialog(member, name)
        }
    }

    //************************************************************
    override fun onResume() //************************************************************
    {
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        mConversation =
            conversationsDao.getConversation(mConversation!!.conversationId)
        initViews()
        populateMembers()
        super.onResume()
    }

    //************************************************************
    @SuppressLint("SetTextI18n")
    private fun showViewRemoveDialog(
        member: ConversationMember,
        name: String
    ) //************************************************************
    {
        val alertCustomdialog = LayoutInflater.from(this).inflate(R.layout.custom_dailog_view, null)
        //initialize alert builder
        val dialogBinding = CustomDailogViewBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(this)
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(dialogBinding.root)
        mDialogViewRemove = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mDialogViewRemove!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogBinding.tvView.text = "View $name"
        dialogBinding.tvView.visibility = if (mConversation!!.conversationType.equals(
                TYPES.CONVERSATION_GROUP_ANONYMOUS,
                ignoreCase = true
            )
        ) GONE else View.VISIBLE
        dialogBinding.tvRemove.text = "Remove from the group"
        dialogBinding.tvAddRemoveAdmin.setTextColor(
            AndroidUtil.getColor(
                if (!member.type.equals(
                        "admin",
                        ignoreCase = true
                    )
                ) R.color.blue else R.color.dark_red
            )
        )
        dialogBinding.tvAddRemoveAdmin.text =
            if (!member.type.equals("admin", ignoreCase = true)) "Make Admin" else "Remove Admin"
        //finally show the dialog box in android all
        mDialogViewRemove!!.show()
        dialogBinding.tvView.setOnClickListener {
            startActivity(
                Intent(this@ChatDetailsActivity, RemoveViewActivity::class.java)
                    .putExtra(Constants.KEYS.INTENT_MEMBER_ID, member)
                    .putExtra(
                        Constants.KEYS.INTENT_CONVERSATION,
                        mConversation!!.conversationId
                    )
            )
            mDialogViewRemove!!.dismiss()
        }
        dialogBinding.tvRemove.setOnClickListener {
            if (!member.memberId.equals(
                    mConversation!!.owner, ignoreCase = true
                )
            ) {
                removeMember(member)
            } else {
                Notify.Toast("Can not Remove Owner")
            }
        }
        dialogBinding.tvAddRemoveAdmin.setOnClickListener {
            if (!member.memberId.equals(
                    mConversation!!.owner, ignoreCase = true
                )
            ) {
                val choose: Int = if (dialogBinding.tvAddRemoveAdmin.getText().toString()
                        .equals("Make Admin", ignoreCase = true)
                ) 0 else 1
                addRemoveAdmin(member, choose)
            } else {
                Notify.Toast("Owner to Admin not allowed")
            }
        }
    }

    //************************************************************
    private fun removeMember(id: ConversationMember) //************************************************************
    {
        val request = RemoveMembersConversationRequest()
        val requestAnonymousRemove = RemoveAnonymousMembersRequest()
        if (mConversation!!.conversationMembers!!.size > 2) {
            if (mConversation!!.conversationType.equals(
                    TYPES.CONVERSATION_GROUP_ANONYMOUS, ignoreCase = true
                )
            ) {
                requestAnonymousRemove.members = id.memberId
                requestAnonymousRemove.userChatId = AppSession.getUser().chatUserId
                ApiHelper.with()?.removeAnonymousMember(
                    mConversation!!.conversationId,
                    requestAnonymousRemove,
                    this,
                    this@ChatDetailsActivity
                )
//                NetworkCall.make()
//                    .setCallback(this)
//                    .setTag(RequestCodes.API.REMOVE_ANONYMOUS_MEMBER)
//                    .autoLoadingCancel(getLoading(this, "Please wait"))
//                    .enque(
//                        Network.apis().removeAnonymousMemberConversation(
//                            mConversation!!.conversationId, requestAnonymousRemove
//                        )
//                    )
//                    .execute()
            } else {
                request.members = id.memberId
                request.userChatId = AppSession.getUser().chatUserId

                ApiHelper.with()?.removeMember(
                    mConversation!!.conversationId,
                    request,
                    this,
                    this@ChatDetailsActivity
                )
//                NetworkCall.make()
//                    .setCallback(this)
//                    .setTag(RequestCodes.API.REMOVE_MEMBER)
//                    .autoLoadingCancel(getLoading(this, "Please wait"))
//                    .enque(
//                        Network.apis().removeMemberConversation(
//                            mConversation!!.conversationId, request
//                        )
//                    )
//                    .execute()
            }
        } else {
            Notify.Toast("Group can have at least 2 members")
        }
    }

    override fun onMemberCallback(id: ConversationMember, name: String) {
        //this callback is being used in another activity
    }

    fun startObserver(img_file: File?) {
        DownloaderImage.fileImageMutableLiveData.observe(
            (this@ChatDetailsActivity as LifecycleOwner)
        ) { file ->
            if (file != null) {
                if (img_file != null) {
                    if (img_file.absolutePath.equals(
                            file.absolutePath,
                            ignoreCase = true
                        )
                    ) {
                        conversationsDao
                            .updateFilePath(mConversation!!.conversationId, file.path)
                        conversationsDao.updateConversationIcon(
                            mConversation!!.conversationId, file.path, mConversation!!.photo
                        )
                        mConversation = conversationsDao
                            .getConversation(mConversation!!.conversationId)
                        initViews()
                        DownloaderImage.fileImageMutableLiveData.removeObservers(
                            this@ChatDetailsActivity
                        )
                    }
                }
            }
        }
    }

    companion object {
        var instance: ChatDetailsActivity? = null
        val TAG = Log.tag(ChatDetailsActivity::class.java)

        //************************************************************
        fun getDetailsInstance(): ChatDetailsActivity?
        //************************************************************
        {
            if (instance == null) {
                instance = ChatDetailsActivity()
            }
            return instance
        }

        fun createTransitionBundle(context: Context?, avatar: View): Bundle? {
            return if (context is Activity) {
                val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (context as Activity?)!!,
                    Pair.create(avatar, "avatar")
                )
                optionsCompat.toBundle()
            } else {
                null
            }
        }
    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }
}