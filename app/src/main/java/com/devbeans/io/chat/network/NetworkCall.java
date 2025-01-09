package com.devbeans.io.chat.network;


import com.devbeans.io.chat.R;
import com.devbeans.io.chat.app.BaseClass;
import com.devbeans.io.chat.models.EncryptedPayload;
import com.devbeans.io.chat.network.serializers.response.BaseResponse;
import com.devbeans.io.chat.network.serializers.response.GetConversationResponse;
import com.devbeans.io.chat.network.serializers.response.GetProfileResponse;
import com.devbeans.io.chat.network.serializers.response.GetUpdateConversationImageResponse;
import com.devbeans.io.chat.network.serializers.response.NewConversationResponse;
import com.devbeans.io.chat.network.serializers.response.UploadMediaResponse;
import com.devbeans.io.chat.utils.Configurations;
import com.devbeans.io.chat.utils.EncryptionUtils;
import com.devbeans.io.chat.utils.Loading;
import com.devbeans.io.chat.utils.Notify;
import com.devbeans.io.chat.utils.RequestCodes;
import com.devbeans.io.chat.utils.Utills;
import com.devbeans.io.chat.utils.logging.Log;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NetworkCall extends BaseClass {
    boolean continueLoading = false;
    private Object taggedObject;
    private OnNetworkResponse callback;
    private Call request;
    private Loading loading;
    public static final String TAG = Log.tag(NetworkCall.class);

    private NetworkCall() {
    }

    public static synchronized NetworkCall make() {
        return new NetworkCall();
    }

    public NetworkCall setCallback(OnNetworkResponse callback) {
        this.callback = callback;
        return this;
    }

    public NetworkCall enque(Call call) {
        this.request = call;
        return this;
    }

    public NetworkCall setTag(Object tag) {
        this.taggedObject = tag;
        return this;
    }

    public NetworkCall autoLoadingCancel(Loading loading) {
        this.loading = loading;
        return this;
    }

    public NetworkCall execute() {

        request.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                cancelLoading();

                if (BaseResponse.isSuccess(response)) {
                    handleAndDecrypt(call,response);
                } else if (BaseResponse.isSessionExpired(response)) {
//                    MainApp.resetApplication();
                    Notify.ToastLong("Your session has been expired, Please login again");
                } else if (response.body() == null || !BaseResponse.isSuccess(response)) {
                    try {
                        callback.onFailure(call, Network.parseErrorResponse(response), taggedObject);
                    } catch (Exception e) {
                        callback.onFailure(call, new BaseResponse(Configurations.INSTANCE.isProduction() ? string(R.string.exceptionInErrorResponse) : string(R.string.invalid_data)), taggedObject);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                cancelLoading();
               handleOnFailure(call,t);
            }
        });
        return this;
    }

    private void handleOnFailure(Call call, Throwable t) {
        BaseResponse response;
        if (t != null) {
            if (Utills.INSTANCE.isCause(SocketTimeoutException.class, t)) {
                response = new BaseResponse(string(R.string.timeout));
            } else if (Utills.INSTANCE.isCause(ConnectException.class, t)) {
                response = new BaseResponse(string(R.string.connectException));
            } else if (Utills.INSTANCE.isCause(MalformedJsonException.class, t)) {
                response = new BaseResponse(string(R.string.invalid_data));
            } else if (t instanceof SSLHandshakeException || t instanceof SSLException) {
                response = new BaseResponse(string(R.string.ssl));
            } else if (t instanceof IOException) {
                response = new BaseResponse(string(R.string.no_internet));
            } else {
                response = new BaseResponse(Configurations.INSTANCE.isDevelopment() ? t.getMessage() : string(R.string.text_somethingwentwrong));
            }
        } else {
            response = new BaseResponse(string(R.string.text_somethingwentwrong));
        }
        callback.onFailure(call, response, taggedObject);
    }

    private void handleAndDecrypt(Call call, Response response) {
        try {
            if (APIWithNoEncryption(taggedObject)) {

                EncryptedPayload res = (EncryptedPayload) response.body();

                if (res != null) {
                    sendResponse(call, res);
                } else {
                    Log.e(TAG, "Data not decrypted");
                }
            } else {
                callback.onSuccess(call, response, taggedObject);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private void sendResponse(Call call, EncryptedPayload res) throws ParseException {
        Gson gson = new Gson();
        try {
            switch ((int) taggedObject) {
                case RequestCodes.API.GET_PROFILE:
                case RequestCodes.API.UPDATE_PROFILE:
                case RequestCodes.API.UPDATE_PROFILE_IMAGE:
                case RequestCodes.API.BLOCK_USER:
                case RequestCodes.API.UNBLOCK_USER:
                    GetProfileResponse getProfileResponse = gson.fromJson(EncryptionUtils.INSTANCE.decryptRequest(res), GetProfileResponse.class);
                    Response<GetProfileResponse> response1 = Response.success(getProfileResponse);
                    callback.onSuccess(call, response1, taggedObject);
                    break;
                case RequestCodes.API.VERIFY_USER:

                    break;
                case RequestCodes.API.GET_USER_ID:

                    break;
                case RequestCodes.API.RENEW_USER_CHAT_ID:

                    break;
                case RequestCodes.API.GET_CONVERSATION:
                case RequestCodes.API.UPDATED_CONVERSATION:
                case RequestCodes.API.GET_GROUP_ICON:
                    //GetConversationResponse
                    GetConversationResponse getConversationResponse = gson.fromJson(EncryptionUtils.INSTANCE.decryptRequest(res), GetConversationResponse.class);
                    Response<GetConversationResponse> getConversationResponseBody = Response.success(getConversationResponse);
                    callback.onSuccess(call, getConversationResponseBody, taggedObject);
                    break;
                case RequestCodes.API.CREATE_NEW_CONV:
                case RequestCodes.API.ADD_MEMBER:
                case RequestCodes.API.ADD_MEMBER_GROUP:
                case RequestCodes.API.ADD_MEMBER_ANONYMOUS:
                case RequestCodes.API.ADMIN_ASSIGNED_GROUP:
                case RequestCodes.API.ADMIN_ASSIGNED_ANONYMOUS:
                case RequestCodes.API.ADMIN_REMOVED_GROUP:
                case RequestCodes.API.ADMIN_REMOVED_ANONYMOUS:
                case RequestCodes.API.REMOVE_MEMBER:
                case RequestCodes.API.REMOVE_ANONYMOUS_MEMBER:
                case RequestCodes.API.CREATE_ANONYMOUS_NEW_CONV:
                case RequestCodes.API.UPDATE_CONVERSATION_NAME:
                case RequestCodes.API.UPDATE_CONVERSATION_DESCRIPTION:
                case RequestCodes.API.LEAVE_GROUP:
                case RequestCodes.API.OWNER_LEAVE_GROUP:
                case RequestCodes.API.UPDATE_CONVERSATION_EXPIRY_TIME:
                case RequestCodes.API.DESTROY_CONVERSATION:
                case RequestCodes.API.UPDATE_VIEW_ONCE:
                case RequestCodes.API.UPDATE_CONFIDENTIAL:
                case RequestCodes.API.UPDATE_MEDIA_SHARE_RESTRICT:
                    //NewConversationResponse
                    NewConversationResponse newConversationResponse = gson.fromJson(EncryptionUtils.INSTANCE.decryptRequest(res), NewConversationResponse.class);
                    Response<NewConversationResponse> newConversationResponseBody = Response.success(newConversationResponse);

                    callback.onSuccess(call, newConversationResponseBody, taggedObject);
                    break;
                case RequestCodes.API.UPLOAD_MEDIA:
                case RequestCodes.API.UPLOAD_FORWARD_MEDIA_ONLY:
                    //UploadMediaResponse
                    UploadMediaResponse uploadMediaResponse = gson.fromJson(EncryptionUtils.INSTANCE.decryptRequest(res), UploadMediaResponse.class);
                    Response<UploadMediaResponse> uploadMediaResponseBody = Response.success(uploadMediaResponse);

                    callback.onSuccess(call, uploadMediaResponseBody, taggedObject);

                    break;
                case RequestCodes.API.UPLOAD_MEDIA_CONVERSATION_IMAGE:
                    //GetUpdateConversationImageResponse
                    GetUpdateConversationImageResponse getUpdateConversationImageResponse = gson.fromJson(EncryptionUtils.INSTANCE.decryptRequest(res), GetUpdateConversationImageResponse.class);
                    Response<GetUpdateConversationImageResponse> getUpdateConversationImageResponseBody = Response.success(getUpdateConversationImageResponse);

                    callback.onSuccess(call, getUpdateConversationImageResponseBody, taggedObject);

                    break;
                default:
                    Log.e(TAG, Integer.toString((Integer) taggedObject));
                    break;
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception:" + e.getMessage());
        }

    }

    private boolean APIWithNoEncryption(Object taggedObject) {
        return !(((int) taggedObject == RequestCodes.API.GET_USER_ID) ||
                ((int) taggedObject == RequestCodes.API.RENEW_USER_CHAT_ID) ||
                ((int) taggedObject == RequestCodes.API.VERIFY_USER)
        );

    }


    public void cancelLoading() {
        if (loading != null && loading.isVisible())
            loading.cancel();
    }
}
