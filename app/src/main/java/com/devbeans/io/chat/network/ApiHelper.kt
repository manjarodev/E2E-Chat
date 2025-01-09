package com.devbeans.io.chat.network

import android.app.Activity
import android.util.Log
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.serializers.requestbody.*
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.Utills.getLoading
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineExceptionHandler
import okhttp3.RequestBody
import java.io.File
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ApiHelper {
    val gson = Gson()

    /**
     * For validation of user is in system or not
     *
     * @param userId
     * @param activity
     * @param callback
     */
    fun verifyUser(userId: String?, activity: Activity?, callback: OnNetworkResponse?) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.VERIFY_USER)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(Network.apis().verifyUser(userId))
            .execute()
    }

    /**
     * @param callback
     */
    fun registerUser(callback: OnNetworkResponse?) {

        val mqttKey = Utills.getRandomString(128)
        AppSession.saveMQTT(mqttKey)
        Log.e(TAG, "MQTT KEY ${AppSession.getMQTTPass()}")
        Log.e(TAG, "MQTT KEY ${mqttKey}")
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.GET_USER_ID)
            .enque(Network.apis().registerDevice(RegisterUserRequest("", AppSession.getMQTTPass())))
            .execute()
    }

    /**
     * Renewing the [User] on the basis of [generatedDeviceId]
     * this method will only be called after every Fresh install
     *
     * @param generatedDeviceId
     * @param callback
     */
    fun renewUser(generatedDeviceId: String?, callback: OnNetworkResponse?) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.RENEW_USER_CHAT_ID)
            .enque(
                Network.apis().renewUserChatId(RenewUserRequest(generatedDeviceId))
            )
            .execute()
    }

    /**
     * Get Conversation when it is not locally cached
     *
     * @param conversationId
     * @param callback
     */
    fun getConversation(conversationId: String?, callback: OnNetworkResponse?) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.GET_CONVERSATION)
            .enque(Network.apis().getConversation(conversationId, AppSession.getUser().chatUserId))
            .execute()
    }

    /**
     * Get Updated conversation when member is added
     *
     * @param conversationId
     * @param callback
     */
    fun getUpdatedConversation(conversationId: String?, callback: OnNetworkResponse?) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATED_CONVERSATION)
            .enque(Network.apis().getConversation(conversationId, AppSession.getUser().chatUserId))
            .execute()
    }

    /**
     * Get Link to download image when ever it is changed of a Conversation
     *
     * @param conversationId
     */
    fun getChangedIconConversationLink(conversationId: String?, callback: OnNetworkResponse?) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.GET_GROUP_ICON)
            .enque(
                Network.apis().getConversation(
                    conversationId,
                    AppSession.getUser().chatUserId
                )
            )
            .execute()
    }

    /**
     * For adding member and also changing admin
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun addMember(
        conversationId: String?,
        request: AddMembersConversationRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.ADD_MEMBER)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().addMemberConversation(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    encryptedBody
                )
            )
            .execute()
    }

    /**
     * For adding member in Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun addMemberGroup(
        conversationId: String?,
        request: AddMembersConversationRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {

        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.ADD_MEMBER_GROUP)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().addMemberConversation(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    encryptedBody
                )
            )
            .execute()
    }

    /**
     * For adding member in Anonymous Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun addMemberAnonymous(
        conversationId: String?,
        request: AddMembersConversationRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.ADD_MEMBER_ANONYMOUS)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().addMemberConversation(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    encryptedBody
                )
            )
            .execute()
    }

    /**
     * For assigning admin in Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun adminAssignedGroup(
        conversationId: String?,
        request: AddMembersConversationRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {

        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.ADMIN_ASSIGNED_GROUP)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().addMemberConversation(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    encryptedBody
                )
            )
            .execute()
    }

    /**
     * For assigning admin in Anonymous Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun adminAssignedAnonymous(
        conversationId: String?,
        request: AddMembersConversationRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.ADMIN_ASSIGNED_ANONYMOUS)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().addMemberConversation(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    encryptedBody
                )
            )
            .execute()
    }

    /**
     * For removing admin in Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun adminRemoveGroup(
        conversationId: String?,
        request: AddMembersConversationRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.ADMIN_REMOVED_GROUP)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().addMemberConversation(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    encryptedBody
                )
            )
            .execute()
    }

    /**
     * For removing admin in Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun adminRemoveAnonymous(
        conversationId: String?,
        request: AddMembersConversationRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.ADMIN_REMOVED_ANONYMOUS)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().addMemberConversation(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    encryptedBody
                )
            )
            .execute()
    }

    /**
     * For removing members from public group
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun removeMember(
        conversationId: String?,
        request: RemoveMembersConversationRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.REMOVE_MEMBER)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().removeMemberConversation(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    encryptedBody
                )
            )
            .execute()
    }

    /**
     * For removing member from anonymous group
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun removeAnonymousMember(
        conversationId: String?,
        request: RemoveAnonymousMembersRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.REMOVE_ANONYMOUS_MEMBER)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().removeAnonymousMemberConversation(
                    AppSession.getUser().chatUserId, conversationId, encryptedBody
                )
            )
            .execute()
    }

    /**
     * Getting the profile from server
     *
     * @param userChatId
     * @param profileId
     * @param callback
     */
    fun profileData(userChatId: String?, profileId: String?, callback: OnNetworkResponse?) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.GET_PROFILE)
            .enque(Network.apis().getProfile(userChatId, profileId))
            .execute()
    }

    /**
     * For updating own profile name
     *
     * @param userChatId
     * @param request
     * @param callback
     * @param activity
     */
    fun updateNickName(
        userChatId: String?,
        request: UpdateProfileRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATE_PROFILE)
            .autoLoadingCancel(getLoading(activity, "Uploading..."))
            .enque(
                Network.apis().updateProfile(
                    userChatId, encryptedBody
                )
            )
            .execute()
    }

    /**
     * For updating group name
     *
     * @param request
     * @param callback
     */
    fun updateGroupName(request: UpdateConversationNameRequest?, callback: OnNetworkResponse?) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall
            .make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATE_CONVERSATION_NAME)
            .enque(
                Network.apis()
                    .updateConversationName(AppSession.getUser().chatUserId, encryptedBody)
            )
            .execute()
    }

    /**
     * for updating group description
     *
     * @param request
     * @param callback
     * @param activity
     */
    fun updateGroupDescription(
        request: UpdateConversationDesRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {

        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall
            .make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATE_CONVERSATION_DESCRIPTION)
            .autoLoadingCancel(getLoading(activity, "Updating"))
            .enque(
                Network.apis()
                    .updateConversationDescription(AppSession.getUser().chatUserId, encryptedBody)
            )
            .execute()
    }

    /**
     * For blocking any user in chat app to restrict it to send message in one-to-one chat
     *
     * @param blockId
     * @param callback
     * @param activity
     */
    fun blockUser(blockId: String?, callback: OnNetworkResponse?, activity: Activity?) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.BLOCK_USER)
            .autoLoadingCancel(getLoading(activity, "Blocking Please wait"))
            .enque(Network.apis().blockUser(AppSession.getUser().chatUserId, blockId))
            .execute()
        if (MainApp.appContext != null) {
            MainApp.appContext?.contactsDao?.updateBlock(blockId, true)
        }
    }

    /**
     * For unblocking any user in chat app
     *
     * @param unblockId
     * @param callback
     * @param activity
     */
    fun unBlockUser(unblockId: String?, callback: OnNetworkResponse?, activity: Activity?) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UNBLOCK_USER)
            .autoLoadingCancel(getLoading(activity, "unBlocking Please wait"))
            .enque(Network.apis().unblockUser(AppSession.getUser().chatUserId, unblockId))
            .execute()
        if (MainApp.appContext != null) {
            MainApp.appContext?.contactsDao?.updateBlock(unblockId, false)
        }
    }

    /**
     * For creating conversation with a image as it's conversation image
     *
     * @param map
     * @param file
     * @param callback
     * @param activity
     */
    fun createNewConversation(
        map: Map<String?, RequestBody?>?,
        file: File?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        run {
            val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
                com.devbeans.io.chat.utils.logging.Log.e(
                    TAG,
                    "CoroutineExceptionHandler got $exception"
                )
            }
//            CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler)
//            {
            NetworkCall.make()
                .setCallback(callback)
                .setTag(RequestCodes.API.CREATE_NEW_CONV)
                .autoLoadingCancel(getLoading(activity, "Please wait"))
                .enque(
                    Network.apis()
                        .createNewConversationMedia(
                            map,
                            FileUpload.requestBodyPDF("media", file)
                        )
                )
                .execute()
//            }
        }
    }

    /**
     * For creating conversation without media in server
     *
     * @param type
     * @param member
     * @param userChatId
     * @param description
     * @param name
     * @param selectedTime
     * @param callback
     * @param activity
     */
    fun createNewConversation(
        type: String?,
        member: String?,
        userChatId: String?,
        description: String?,
        name: String?,
        selectedTime: Long?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            com.devbeans.io.chat.utils.logging.Log.e(
                TAG,
                "CoroutineExceptionHandler got $exception"
            )
        }
        Log.e(TAG, " request $selectedTime")
//        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler)
//        {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.CREATE_NEW_CONV)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis()
                    .createNewConversationWithoutMedia(
                        type, member, userChatId, description, name,
                        selectedTime!!, SettingsValues.getConfidentialMessageCheck(), false
                    )
            )
            .execute()
//        }
    }


    /**
     * For creating conversation without media in server
     *
     * @param type
     * @param member
     * @param userChatId
     * @param description
     * @param name
     * @param selectedTime
     * @param callback
     * @param activity
     */
    fun createNewConversationWithChecks(
        type: String?,
        member: String?,
        userChatId: String?,
        description: String?,
        name: String?,
        selectedTime: Long?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            com.devbeans.io.chat.utils.logging.Log.e(
                TAG,
                "CoroutineExceptionHandler got $exception"
            )
        }
//        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler)
//        {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.CREATE_NEW_CONV)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis()
                    .createNewConversationWithChecks(
                        type, member, userChatId, description, name,
                        selectedTime!!, SettingsValues.getConfidentialMessageCheck(), false
                    )
            )
            .execute()
//        }
    }

    /**
     * For creating anonymous conversation with a image as it's conversation image
     *
     * @param map
     * @param file
     * @param callback
     * @param activity
     */
    fun createAnonymousNewConversation(
        map: Map<String?, RequestBody?>?, file: File?, callback: OnNetworkResponse?,
        activity: Activity?
    ) {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            com.devbeans.io.chat.utils.logging.Log.e(
                TAG,
                "CoroutineExceptionHandler got $exception"
            )
        }
//        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler)
//        {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.CREATE_ANONYMOUS_NEW_CONV)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis()
                    .createNewAnonymousConversationMedia(
                        map,
                        FileUpload.requestBodyPDF("media", file)
                    )
            )
            .execute()
//        }
    }

    /**
     * For creating anonymous conversation without a image as it's conversation image
     *
     * @param type
     * @param member
     * @param userChatId
     * @param description
     * @param name
     * @param selectedTime
     * @param callback
     * @param activity
     */
    fun createAnonymousNewConversation(
        type: String?,
        member: String?,
        userChatId: String?,
        description: String?,
        name: String?,
        selectedTime: Long?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            com.devbeans.io.chat.utils.logging.Log.e(
                TAG,
                "CoroutineExceptionHandler got $exception"
            )
        }
//        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler)
//        {

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.CREATE_ANONYMOUS_NEW_CONV)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis()
                    .createNewAnonymousConversationWithoutMedia(
                        type,
                        member,
                        userChatId,
                        description,
                        name,
                        selectedTime!!,
                        SettingsValues.getConfidentialMessageCheck(),
                        SettingsValues.getMediaShareRestrict()
                    )
            )
            .execute()
//        }
    }


    /**
     * For creating anonymous conversation without a image as it's conversation image
     *
     * @param type
     * @param member
     * @param userChatId
     * @param description
     * @param name
     * @param selectedTime
     * @param callback
     * @param activity
     */
    fun createAnonymousNewConversationWithChecks(
        type: String?,
        member: String?,
        userChatId: String?,
        description: String?,
        name: String?,
        selectedTime: Long?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            com.devbeans.io.chat.utils.logging.Log.e(
                TAG,
                "CoroutineExceptionHandler got $exception"
            )
        }
//        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler)
//        {

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.CREATE_ANONYMOUS_NEW_CONV)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis()
                    .createNewAnonymousConversationWithoutMediaChecks(
                        type, member, userChatId, description, name,
                        selectedTime!!, false, false
                    )
            )
            .execute()
//        }
    }

    /**
     * For uploading media in conversation
     *
     * @param conversationId
     * @param members
     * @param file
     * @param callback
     * @param activity
     */
    fun uploadMediaInConversation(
        conversationId: String?,
        members: String?,
        file: File?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPLOAD_MEDIA)
            .autoLoadingCancel(getLoading(activity, "Uploading..."))
            .enque(
                Network.apis().uploadMedia(
                    FileUpload.uploadMedia(
                        conversationId, members
                    ),
                    FileUpload.requestBodyPDF("media", file)
                )
            )
            .execute()
    }

    /**
     * For uploading and sending forwarded media in conversation
     *
     * @param conversationId
     * @param members
     * @param file
     * @param callback
     * @param activity
     */
    fun forwardMediaInConversation(
        conversationId: String?,
        members: String?,
        file: File?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPLOAD_FORWARD_MEDIA_ONLY)
            .autoLoadingCancel(getLoading(activity, "Uploading..."))
            .enque(
                Network.apis().uploadMedia(
                    FileUpload.uploadMedia(
                        conversationId, members
                    ),
                    FileUpload.requestBodyPDF("media", file)
                )
            )
            .execute()
    }

    /**
     * For Uploading image of user's own chat
     *
     * @param file
     * @param callback
     * @param activity
     */
    fun updateProfileImage(
        file: File?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATE_PROFILE_IMAGE)
            .autoLoadingCancel(getLoading(activity, "Uploading..."))
            .enque(
                Network.apis().updateProfileImage(
                    FileUpload.requestBodyPDF(Constants.KEYS.MEDIA, file),
                    FileUpload.uploadProfileImage(AppSession.getUser().chatUserId)
                )
            )
            .execute()
    }

    /**
     * For Updating conversation image
     *
     * @param conversationId
     * @param _extension
     * @param file
     * @param callback
     * @param activity
     */
    fun updateGroupProfile(
        conversationId: String?,
        _extension: String?,
        file: File?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        NetworkCall
            .make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPLOAD_MEDIA_CONVERSATION_IMAGE)
            .autoLoadingCancel(getLoading(activity, "Updating..."))
            .enque(
                Network.apis().updateConversationImage(
                    FileUpload.requestBodyPDF(Constants.KEYS.MEDIA, file),
                    FileUpload.uploadConversationImage(
                        AppSession.getUser().chatUserId,
                        conversationId,
                        _extension
                    )
                )
            )
            .execute()
    }

    /**
     * For leaving Group conversation
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun leaveGroup(
        conversationId: String?,
        request: LeaveGroupRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {

        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.LEAVE_GROUP)
            .autoLoadingCancel(getLoading(activity, "Please wait..."))
            .enque(
                Network.apis()
                    .leaveGroup(AppSession.getUser().chatUserId, conversationId, encryptedBody)
            )
            .execute()


    }

    /**
     * For owner to leave the group after selecting a member as a member
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    fun ownerLeaveGroup(
        conversationId: String?,
        request: LeaveOwnerGroupRequest?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.OWNER_LEAVE_GROUP)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis()
                    .leaveOwnerGroup(AppSession.getUser().chatUserId, conversationId, encryptedBody)
            )
            .execute()
    }

    /**
     * For updating disappearing time of conversation messages
     *
     * @param request
     * @param callback
     * @param activity
     */
    fun updateConversationExpiry(
        request: UpdateConversationExpiry?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall
            .make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATE_CONVERSATION_EXPIRY_TIME)
            .autoLoadingCancel(getLoading(activity, "Updating"))
            .enque(Network.apis().updateExpiryTime(AppSession.getUser().chatUserId, encryptedBody))
            .execute()
    }

    /**
     * For Destroying group conversations
     *
     * @param conversationId
     * @param callback
     * @param activity
     */
    fun destroyConversation(
        conversationId: String?,
        callback: OnNetworkResponse?,
        activity: Activity?
    ) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.DESTROY_CONVERSATION)
            .autoLoadingCancel(getLoading(activity, "Please wait"))
            .enque(
                Network.apis().destroyConversation(
                    AppSession.getUser().chatUserId,
                    conversationId
                )
            )
            .execute()
    }

    /**
     * For updating view once property of conversation
     *
     * @param conversationId
     * @param viewOnce
     * @param callback
     */
    fun updateViewOnce(
        conversationId: String?,
        viewOnce: Boolean?,
        callback: OnNetworkResponse?
    ) {
        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATE_VIEW_ONCE)
            .enque(
                Network.apis().updateViewOnce(
                    AppSession.getUser().chatUserId,
                    conversationId,
                    viewOnce!!
                )
            )
            .execute()
    }


    /**
     * For updating confidential message property of conversation
     *
     * @param conversationId
     * @param confidential
     * @param callback
     */
    fun updateConfidential(
        conversationId: String?,
        confidential: Boolean?,
        type: String?,
        callback: OnNetworkResponse?
    ) {
        val request = UpdateConfidentialRequest(
            isConfidential = confidential!!,
            conversationId = conversationId!!,
            type = type!!
        )
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATE_CONFIDENTIAL)
            .enque(
                Network.apis().updateConfidential(
                    AppSession.getUser().chatUserId,
                    encryptedBody
                )
            )
            .execute()
    }


    /**
     * For updating confidential message property of conversation
     *
     * @param conversationId
     * @param confidential
     * @param callback
     */
    fun updateMediaShareRestrict(
        conversationId: String?,
        mediaShareRestrict: Boolean?,
        type: String?,
        callback: OnNetworkResponse?
    ) {
        val request = UpdateRestrictMediaShareRequest(
            isMediaShareRestrict = mediaShareRestrict!!,
            conversationId = conversationId!!,
            type = type!!
        )
        val stringBody = gson.toJson(request)
        val encryptedBody = EncryptedRequest()
        encryptedBody.body = EncryptionUtils.encryptRequest(stringBody)!!

        NetworkCall.make()
            .setCallback(callback)
            .setTag(RequestCodes.API.UPDATE_MEDIA_SHARE_RESTRICT)
            .enque(
                Network.apis().updateMediaShareRestrict(
                    AppSession.getUser().chatUserId,
                    encryptedBody
                )
            )
            .execute()
    }

    private fun handleException(throwable: Throwable) {
        Log.e(TAG, "handleException: $throwable")
        if (throwable is ConnectException) {
            Log.e(TAG, "no internet connection")
        } else if (throwable is SocketTimeoutException) {
            Log.e(TAG, "connection timeout")
        } else if (throwable is UnknownHostException) {
            Log.e(TAG, "failed to reached network")
        }
    }

    interface IsExecuted {
        fun isExecuted(executed: Boolean)
    }

    interface OnFetchBackup {
        fun onFetchBack(downloadList: List<String?>?)
    }

    companion object {
        val TAG = ApiHelper::class.java.simpleName
        private var INSTANCE: ApiHelper? = null

        @Synchronized
        fun with(): ApiHelper? {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return null
            }
            if (INSTANCE == null) {
                INSTANCE = ApiHelper()
            }
            return INSTANCE
        }
    }
}