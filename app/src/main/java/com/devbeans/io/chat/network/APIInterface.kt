package com.devbeans.io.chat.network

import com.devbeans.io.chat.models.DeleteKeyStoreModel
import com.devbeans.io.chat.models.RegisterNewKDSUser
import com.devbeans.io.chat.models.ServerTime
import com.devbeans.io.chat.network.serializers.requestbody.UploadSikRequest
import com.devbeans.io.chat.network.serializers.response.RenewChatIdResponse
import com.devbeans.io.chat.network.serializers.response.UploadKeysModel
import com.devbeans.io.chat.utils.RequestCodes
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @FormUrlEncoded
    @POST(RequestCodes.API_END_POINTS.UPLOAD_PUBLIC_KEYS)
    fun uploadKeys(
        @Field("encryptedString") encryptedString: String,
        @Field("chatAppId") deviceBody: String?,
        @Field("signature") signature: String?,
    ): Call<UploadKeysModel?>?


    @POST(RequestCodes.API_END_POINTS.UPLOAD_SIK)
    fun uploadSIK(
        @Body uploadSikRequest: UploadSikRequest
    ): Call<UploadKeysModel?>?

    @FormUrlEncoded
    @POST(RequestCodes.API_END_POINTS.UPLOADS_KEYS_ON_DEFICIENCY)
    fun uploadOnKeyDeficiency(
        @Field("encryptedString") encryptedString: String,
        @Field("chatAppId") deviceBody: String?,
        @Field("signature") signature: String?,
    ): Call<UploadKeysModel?>?

    @FormUrlEncoded
    @POST(RequestCodes.API_END_POINTS.USER)
    fun createNewUser(
        @Field("name") name: String,
        @Field("deviceId") generatedDeviceId: String,
        @Field("chatAppId") chat_id: String
    ): Call<RegisterNewKDSUser>


    @GET(RequestCodes.API_END_POINTS.KEYSTORES)
    fun getEK(
        @Query("chatAppId") chatAppId: String,
        @Query("requestedIDs") members: String,
        @Query("conversationId") conversationId: String
    ): Call<EncryptedModel>

    @GET(RequestCodes.API_END_POINTS.SENDER_IK)
    fun getIK(
        @Query("chatAppId") chatAppId: String,
        @Query("requestedIDs") members: String,
        @Query("conversationId") conversationId: String
    ): Call<EncryptedModel>


    @GET(RequestCodes.API_END_POINTS.MONIKER_KEYSTORES)
    fun getMonikerEK(
        @Query("chatAppId") chatAppId: String,
        @Query("requestedMonikers") members: String,
        @Query("conversationId") conversationId: String
    ): Call<EncryptedModel>

    @GET(RequestCodes.API_END_POINTS.MONIKER_IK)
    fun getMonikerIK(
        @Query("chatAppId") chatAppId: String,
        @Query("requestedMonikers") members: String,
        @Query("conversationId") conversationId: String
    ): Call<EncryptedModel>


    @GET(RequestCodes.API_END_POINTS.SERVER_TIME)
    fun getServerTime(): Call<ServerTime>


    @DELETE("KeyStore/")
    fun deleteKeyStore(@Query("deviceId") device_id: String): Call<DeleteKeyStoreModel>


    @PUT(RequestCodes.API_END_POINTS.UPDATE_USER_KDS)
    fun updateChatId(
        @Query("deviceId") deviceId: String,
        @Query("chatAppId") generatedDeviceId: String,
        @Query("ikPubKey") ikPubKey: String
    ): Call<RenewChatIdResponse>

}