package com.devbeans.io.chat.network;


import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_DESCRIPTION;
import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_EXPIRY_TIME;
import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_ID;
import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_IS_CONFIDENTIAL;
import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_IS_MEDIA_SHARE_RESTRICT;
import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_NAME;
import static com.devbeans.io.chat.utils.Constants.KEYS.INTENT_TYPE;
import static com.devbeans.io.chat.utils.Constants.KEYS.IS_VIEW_ONCE;
import static com.devbeans.io.chat.utils.Constants.KEYS.MEMBERS;
import static com.devbeans.io.chat.utils.Constants.KEYS.USER_CHAT_ID;

import com.devbeans.io.chat.models.EncryptedPayload;
import com.devbeans.io.chat.network.serializers.requestbody.CreateConversationRequest;
import com.devbeans.io.chat.network.serializers.requestbody.EncryptedRequest;
import com.devbeans.io.chat.network.serializers.requestbody.RegisterUserRequest;
import com.devbeans.io.chat.network.serializers.requestbody.RenewUserRequest;
import com.devbeans.io.chat.network.serializers.response.BaseResponse;
import com.devbeans.io.chat.network.serializers.response.RegisterUserResponse;
import com.devbeans.io.chat.network.serializers.response.UploadMediaResponse;
import com.devbeans.io.chat.utils.RequestCodes;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiServices {

    @GET("")
    Call<ResponseBody> connect(@Url String url);

    @GET(RequestCodes.API_END_POINTS.VERIFY_USER)
    Call<BaseResponse> verifyUser(@Query(USER_CHAT_ID) String userId);

    @GET(RequestCodes.API_END_POINTS.VERIFY_USER)
    Call<BaseResponse> verifyUserEncrypted(@Query("chat_user_id") String userId);

    @POST(RequestCodes.API_END_POINTS.REGISTER_DEVICE)
    Call<RegisterUserResponse> registerDevice(@Body RegisterUserRequest registerUserRequest);

    @GET(RequestCodes.API_END_POINTS.REGISTER_DEVICE)
    Call<RegisterUserResponse> registerDevice();

    @PUT(RequestCodes.API_END_POINTS.RENEW_REGISTER_DEVICE)
    Call<RegisterUserResponse> renewUserChatId(@Body RenewUserRequest renewUserRequest);

    @POST(RequestCodes.API_END_POINTS.CREATE_NEW_CONVERSATION)
    Call<EncryptedPayload> createNewConversation(@Body CreateConversationRequest createConversationRequest);

    @GET(RequestCodes.API_END_POINTS.GET_CONVERSATION)
    Call<EncryptedPayload> getConversation(@Query("conversationId") String conversation_id, @Query(USER_CHAT_ID) String user_chat_id);

    @PUT(RequestCodes.API_END_POINTS.ADD_MEMBER_CONVERSATION)
    Call<EncryptedPayload> addMemberConversation(@Query(USER_CHAT_ID) String userId, @Query("conversationId") String conID, @Body EncryptedRequest encryptedRequest);

    @PUT(RequestCodes.API_END_POINTS.REMOVE_MEMBER_CONVERSATION)
    Call<EncryptedPayload> removeMemberConversation(@Query(USER_CHAT_ID) String userId, @Query("conversationId") String conID, @Body EncryptedRequest encryptedRequest);

    @PUT(RequestCodes.API_END_POINTS.REMOVE_ANONYMOUS_MEMBER_CONVERSATION)
    Call<EncryptedPayload> removeAnonymousMemberConversation(@Query(USER_CHAT_ID) String userId, @Query("conversationId") String conID, @Body EncryptedRequest encryptedRequest);


    @Multipart
    @POST(RequestCodes.API_END_POINTS.CREATE_NEW_CONVERSATION)
    Call<EncryptedPayload> createNewConversationMedia(@PartMap Map<String, RequestBody> params,
                                                      @Part MultipartBody.Part file);


    @FormUrlEncoded
    @POST(RequestCodes.API_END_POINTS.CREATE_NEW_CONVERSATION)
    Call<EncryptedPayload> createNewConversationWithoutMedia(
            @Field(INTENT_TYPE) String type,
            @Field(MEMBERS) String members,
            @Field(USER_CHAT_ID) String user_chat_id,
            @Field(CONVERSATION_DESCRIPTION) String description,
            @Field(CONVERSATION_NAME) String name,
            @Field(CONVERSATION_EXPIRY_TIME) long conversation_expiry_time,
            @Field(CONVERSATION_IS_CONFIDENTIAL) boolean isConfidential,
            @Field(CONVERSATION_IS_MEDIA_SHARE_RESTRICT) boolean isMediaShareRestrict

    );


    @FormUrlEncoded
    @POST(RequestCodes.API_END_POINTS.CREATE_NEW_CONVERSATION)
    Call<EncryptedPayload> createNewConversationWithChecks(
            @Field(INTENT_TYPE) String type,
            @Field(MEMBERS) String members,
            @Field(USER_CHAT_ID) String user_chat_id,
            @Field(CONVERSATION_DESCRIPTION) String description,
            @Field(CONVERSATION_NAME) String name,
            @Field(CONVERSATION_EXPIRY_TIME) long conversation_expiry_time,
            @Field(CONVERSATION_IS_CONFIDENTIAL) boolean isConfidential,
            @Field(CONVERSATION_IS_MEDIA_SHARE_RESTRICT) boolean isMediaShareRestrict

    );

    @Multipart
    @POST(RequestCodes.API_END_POINTS.CREATE_ANONYMOUS_NEW_CONVERSATION)
    Call<EncryptedPayload> createNewAnonymousConversationMedia(@PartMap Map<String, RequestBody> params,
                                                               @Part MultipartBody.Part file);


    @FormUrlEncoded
    @POST(RequestCodes.API_END_POINTS.CREATE_ANONYMOUS_NEW_CONVERSATION)
    Call<EncryptedPayload> createNewAnonymousConversationWithoutMedia(
            @Field(INTENT_TYPE) String type,
            @Field(MEMBERS) String members,
            @Field(USER_CHAT_ID) String user_chat_id,
            @Field(CONVERSATION_DESCRIPTION) String description,
            @Field(CONVERSATION_NAME) String name,
            @Field(CONVERSATION_EXPIRY_TIME) long conversation_expiry_time,
            @Field(CONVERSATION_IS_CONFIDENTIAL) boolean isConfidential,
            @Field(CONVERSATION_IS_MEDIA_SHARE_RESTRICT) boolean isMediaShareRestrict
    );


    @FormUrlEncoded
    @POST(RequestCodes.API_END_POINTS.CREATE_ANONYMOUS_NEW_CONVERSATION)
    Call<EncryptedPayload> createNewAnonymousConversationWithoutMediaChecks(
            @Field(INTENT_TYPE) String type,
            @Field(MEMBERS) String members,
            @Field(USER_CHAT_ID) String user_chat_id,
            @Field(CONVERSATION_DESCRIPTION) String description,
            @Field(CONVERSATION_NAME) String name,
            @Field(CONVERSATION_EXPIRY_TIME) long conversation_expiry_time,
            @Field(CONVERSATION_IS_CONFIDENTIAL) boolean isConfidential,
            @Field(CONVERSATION_IS_MEDIA_SHARE_RESTRICT) boolean isMediaShareRestrict
    );

    @Multipart
    @POST(RequestCodes.API_END_POINTS.UPLOAD_MEDIA)
    Call<EncryptedPayload> uploadMedia(@PartMap Map<String, RequestBody> params,
                                       @Part MultipartBody.Part file);

    @GET(RequestCodes.API_END_POINTS.GET_PROFILE)
    Call<EncryptedPayload> getProfile(@Query("chatUserId") String userId, @Query("profileId") String profileId);

    @GET(RequestCodes.API_END_POINTS.GET_PROFILE)
    Call<EncryptedPayload> getProfileEncrypted(@Query("chatUserId") String userId, @Query("profileId") String profileId);


    @PUT(RequestCodes.API_END_POINTS.UPDATE_PROFILE)
    Call<EncryptedPayload> updateProfile(@Query("userChatId") String userId, @Body EncryptedRequest encryptedRequest);


    @PUT(RequestCodes.API_END_POINTS.UPDATE_CONVERSATION_NAME)
    Call<EncryptedPayload> updateConversationName(@Query(USER_CHAT_ID) String userId, @Body EncryptedRequest encryptedRequest);


    @PUT(RequestCodes.API_END_POINTS.UPDATE_CONVERSATION_DESCRIPTION)
    Call<EncryptedPayload> updateConversationDescription(@Query(USER_CHAT_ID) String userId, @Body EncryptedRequest encryptedRequest);

    @Multipart
    @POST(RequestCodes.API_END_POINTS.UPDATE_PROFILE_IMAGE)
    Call<EncryptedPayload> updateProfileImage(@Part MultipartBody.Part file, @PartMap Map<String, RequestBody> params);

    @Multipart
    @POST(RequestCodes.API_END_POINTS.UPLOAD_MEDIA_CONVERSATION_IMAGE)
    Call<EncryptedPayload> updateConversationImage(@Part MultipartBody.Part file, @PartMap Map<String, RequestBody> params);


    @POST(RequestCodes.API_END_POINTS.BLOCK_USER)
    Call<EncryptedPayload> blockUser(@Query(USER_CHAT_ID) String userId, @Query("blockUserId") String blockUserId);

    @POST(RequestCodes.API_END_POINTS.UNBLOCK_USER)
    Call<EncryptedPayload> unblockUser(@Query(USER_CHAT_ID) String userId, @Query("unBlockUserId") String unblockUserId);


    @PUT(RequestCodes.API_END_POINTS.LEAVE_GROUP)
    Call<EncryptedPayload> leaveGroup(@Query(USER_CHAT_ID) String userId, @Query("conversationId") String conversation_id, @Body EncryptedRequest encryptedRequest);

    @PUT(RequestCodes.API_END_POINTS.OWNER_LEAVE_GROUP)
    Call<EncryptedPayload> leaveOwnerGroup(@Query(USER_CHAT_ID) String userId, @Query("conversationId") String conversation_id, @Body EncryptedRequest encryptedRequest);

    @PUT(RequestCodes.API_END_POINTS.UPDATE_CONVERSATION_EXPIRY_TIME)
    Call<EncryptedPayload> updateExpiryTime(@Query(USER_CHAT_ID) String chat_user_id, @Body EncryptedRequest encryptedRequest);

    @DELETE(RequestCodes.API_END_POINTS.DESTROY_CONVERSATION)
    Call<EncryptedPayload> destroyConversation(@Query("userChatId") String userId, @Query("conversationId") String conversationID);

    @FormUrlEncoded
    @PUT(RequestCodes.API_END_POINTS.VIEW_ONCE)
    Call<EncryptedPayload> updateViewOnce(
            @Query(USER_CHAT_ID) String userChatId,
            @Field(CONVERSATION_ID) String conversation_id,
            @Field(IS_VIEW_ONCE) boolean is_view_once
    );

    @PUT(RequestCodes.API_END_POINTS.UPDATE_CONFIDENTIAL)
    Call<EncryptedPayload> updateConfidential(
            @Query(USER_CHAT_ID) String userChatId,
            @Body EncryptedRequest encryptedRequest);


    @PUT(RequestCodes.API_END_POINTS.UPDATE_MEDIA_SHARE_RESTRICT)
    Call<EncryptedPayload> updateMediaShareRestrict(
            @Query(USER_CHAT_ID) String userChatId,
            @Body EncryptedRequest encryptedRequest);


    @Multipart
    @POST(RequestCodes.API_END_POINTS.UPLOAD_MEDIA_ONLY)
    Call<UploadMediaResponse> uploadMedia(
            @Part MultipartBody.Part file);


}

