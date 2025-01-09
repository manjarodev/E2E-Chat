package com.devbeans.io.chat.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Y2\u00020\u0001:\u0003YZ[B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J.\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J.\u0010\u0012\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J.\u0010\u0013\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J.\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J.\u0010\u0015\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J.\u0010\u0016\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J$\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J[\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010!J>\u0010\u0019\u001a\u00020\b2\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J[\u0010\'\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010!J[\u0010(\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010!J>\u0010(\u001a\u00020\b2\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J[\u0010)\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010!J$\u0010*\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J8\u0010+\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010-\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010.\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010/\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u000202H\u0002J.\u00103\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u0001042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J.\u00105\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u0001062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J$\u00107\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u00108\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u00109\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ.\u0010:\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010;2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J.\u0010<\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010=2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010>\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ$\u0010@\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J3\u0010B\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010EJ$\u0010F\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010G2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J$\u0010H\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010I2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010J\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010K2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ8\u0010L\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010M\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J3\u0010N\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010O\u001a\u0004\u0018\u00010D2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010EJ.\u0010P\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010Q2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J$\u0010R\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J)\u0010S\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010T\u001a\u0004\u0018\u00010D2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010UJ8\u0010V\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J$\u0010W\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\\"}, d2 = {"Lcom/devbeans/io/chat/network/ApiHelper;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "addMember", "", "conversationId", "", "request", "Lcom/devbeans/io/chat/network/serializers/requestbody/AddMembersConversationRequest;", "callback", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "activity", "Landroid/app/Activity;", "addMemberAnonymous", "addMemberGroup", "adminAssignedAnonymous", "adminAssignedGroup", "adminRemoveAnonymous", "adminRemoveGroup", "blockUser", "blockId", "createAnonymousNewConversation", "type", "member", "userChatId", "description", "name", "selectedTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/devbeans/io/chat/network/OnNetworkResponse;Landroid/app/Activity;)V", "map", "", "Lokhttp3/RequestBody;", "file", "Ljava/io/File;", "createAnonymousNewConversationWithChecks", "createNewConversation", "createNewConversationWithChecks", "destroyConversation", "forwardMediaInConversation", "members", "getChangedIconConversationLink", "getConversation", "getUpdatedConversation", "handleException", "throwable", "", "leaveGroup", "Lcom/devbeans/io/chat/network/serializers/requestbody/LeaveGroupRequest;", "ownerLeaveGroup", "Lcom/devbeans/io/chat/network/serializers/requestbody/LeaveOwnerGroupRequest;", "profileData", "profileId", "registerUser", "removeAnonymousMember", "Lcom/devbeans/io/chat/network/serializers/requestbody/RemoveAnonymousMembersRequest;", "removeMember", "Lcom/devbeans/io/chat/network/serializers/requestbody/RemoveMembersConversationRequest;", "renewUser", "generatedDeviceId", "unBlockUser", "unblockId", "updateConfidential", "confidential", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/devbeans/io/chat/network/OnNetworkResponse;)V", "updateConversationExpiry", "Lcom/devbeans/io/chat/network/serializers/requestbody/UpdateConversationExpiry;", "updateGroupDescription", "Lcom/devbeans/io/chat/network/serializers/requestbody/UpdateConversationDesRequest;", "updateGroupName", "Lcom/devbeans/io/chat/network/serializers/requestbody/UpdateConversationNameRequest;", "updateGroupProfile", "_extension", "updateMediaShareRestrict", "mediaShareRestrict", "updateNickName", "Lcom/devbeans/io/chat/network/serializers/requestbody/UpdateProfileRequest;", "updateProfileImage", "updateViewOnce", "viewOnce", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/devbeans/io/chat/network/OnNetworkResponse;)V", "uploadMediaInConversation", "verifyUser", "userId", "Companion", "IsExecuted", "OnFetchBackup", "app_debug"})
public final class ApiHelper {
    @org.jetbrains.annotations.NotNull
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.network.ApiHelper.Companion Companion = null;
    private static final java.lang.String TAG = null;
    private static com.devbeans.io.chat.network.ApiHelper INSTANCE;
    
    public ApiHelper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    /**
     * For validation of user is in system or not
     *
     * @param userId
     * @param activity
     * @param callback
     */
    public final void verifyUser(@org.jetbrains.annotations.Nullable
    java.lang.String userId, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * @param callback
     */
    public final void registerUser(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * Renewing the [User] on the basis of [generatedDeviceId]
     * this method will only be called after every Fresh install
     *
     * @param generatedDeviceId
     * @param callback
     */
    public final void renewUser(@org.jetbrains.annotations.Nullable
    java.lang.String generatedDeviceId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * Get Conversation when it is not locally cached
     *
     * @param conversationId
     * @param callback
     */
    public final void getConversation(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * Get Updated conversation when member is added
     *
     * @param conversationId
     * @param callback
     */
    public final void getUpdatedConversation(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * Get Link to download image when ever it is changed of a Conversation
     *
     * @param conversationId
     */
    public final void getChangedIconConversationLink(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * For adding member and also changing admin
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void addMember(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For adding member in Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void addMemberGroup(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For adding member in Anonymous Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void addMemberAnonymous(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For assigning admin in Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void adminAssignedGroup(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For assigning admin in Anonymous Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void adminAssignedAnonymous(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For removing admin in Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void adminRemoveGroup(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For removing admin in Group Chat
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void adminRemoveAnonymous(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For removing members from public group
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void removeMember(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.RemoveMembersConversationRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For removing member from anonymous group
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void removeAnonymousMember(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.RemoveAnonymousMembersRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * Getting the profile from server
     *
     * @param userChatId
     * @param profileId
     * @param callback
     */
    public final void profileData(@org.jetbrains.annotations.Nullable
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable
    java.lang.String profileId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * For updating own profile name
     *
     * @param userChatId
     * @param request
     * @param callback
     * @param activity
     */
    public final void updateNickName(@org.jetbrains.annotations.Nullable
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.UpdateProfileRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For updating group name
     *
     * @param request
     * @param callback
     */
    public final void updateGroupName(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.UpdateConversationNameRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * for updating group description
     *
     * @param request
     * @param callback
     * @param activity
     */
    public final void updateGroupDescription(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.UpdateConversationDesRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For blocking any user in chat app to restrict it to send message in one-to-one chat
     *
     * @param blockId
     * @param callback
     * @param activity
     */
    public final void blockUser(@org.jetbrains.annotations.Nullable
    java.lang.String blockId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For unblocking any user in chat app
     *
     * @param unblockId
     * @param callback
     * @param activity
     */
    public final void unBlockUser(@org.jetbrains.annotations.Nullable
    java.lang.String unblockId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For creating conversation with a image as it's conversation image
     *
     * @param map
     * @param file
     * @param callback
     * @param activity
     */
    public final void createNewConversation(@org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> map, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
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
    public final void createNewConversation(@org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String member, @org.jetbrains.annotations.Nullable
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.Long selectedTime, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
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
    public final void createNewConversationWithChecks(@org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String member, @org.jetbrains.annotations.Nullable
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.Long selectedTime, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For creating anonymous conversation with a image as it's conversation image
     *
     * @param map
     * @param file
     * @param callback
     * @param activity
     */
    public final void createAnonymousNewConversation(@org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> map, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
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
    public final void createAnonymousNewConversation(@org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String member, @org.jetbrains.annotations.Nullable
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.Long selectedTime, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
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
    public final void createAnonymousNewConversationWithChecks(@org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String member, @org.jetbrains.annotations.Nullable
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.Long selectedTime, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
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
    public final void uploadMediaInConversation(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    java.lang.String members, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
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
    public final void forwardMediaInConversation(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    java.lang.String members, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For Uploading image of user's own chat
     *
     * @param file
     * @param callback
     * @param activity
     */
    public final void updateProfileImage(@org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
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
    public final void updateGroupProfile(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    java.lang.String _extension, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For leaving Group conversation
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void leaveGroup(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.LeaveGroupRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For owner to leave the group after selecting a member as a member
     *
     * @param conversationId
     * @param request
     * @param callback
     * @param activity
     */
    public final void ownerLeaveGroup(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.LeaveOwnerGroupRequest request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For updating disappearing time of conversation messages
     *
     * @param request
     * @param callback
     * @param activity
     */
    public final void updateConversationExpiry(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.serializers.requestbody.UpdateConversationExpiry request, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For Destroying group conversations
     *
     * @param conversationId
     * @param callback
     * @param activity
     */
    public final void destroyConversation(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * For updating view once property of conversation
     *
     * @param conversationId
     * @param viewOnce
     * @param callback
     */
    public final void updateViewOnce(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    java.lang.Boolean viewOnce, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * For updating confidential message property of conversation
     *
     * @param conversationId
     * @param confidential
     * @param callback
     */
    public final void updateConfidential(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    java.lang.Boolean confidential, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    /**
     * For updating confidential message property of conversation
     *
     * @param conversationId
     * @param confidential
     * @param callback
     */
    public final void updateMediaShareRestrict(@org.jetbrains.annotations.Nullable
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable
    java.lang.Boolean mediaShareRestrict, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.network.OnNetworkResponse callback) {
    }
    
    private final void handleException(java.lang.Throwable throwable) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/network/ApiHelper$IsExecuted;", "", "isExecuted", "", "executed", "", "app_debug"})
    public static abstract interface IsExecuted {
        
        public abstract void isExecuted(boolean executed);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/network/ApiHelper$OnFetchBackup;", "", "onFetchBack", "", "downloadList", "", "", "app_debug"})
    public static abstract interface OnFetchBackup {
        
        public abstract void onFetchBack(@org.jetbrains.annotations.Nullable
        java.util.List<java.lang.String> downloadList);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/chat/network/ApiHelper$Companion;", "", "()V", "INSTANCE", "Lcom/devbeans/io/chat/network/ApiHelper;", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "with", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.Synchronized
        public final synchronized com.devbeans.io.chat.network.ApiHelper with() {
            return null;
        }
    }
}