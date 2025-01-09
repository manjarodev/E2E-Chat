package com.devbeans.io.chat.network;


import com.devbeans.io.chat.network.serializers.response.BaseResponse;

import java.text.ParseException;

import retrofit2.Call;
import retrofit2.Response;


public interface OnNetworkResponse {

    void onSuccess(Call call, Response response, Object tag) throws ParseException;

    void onFailure(Call call, BaseResponse response, Object tag);

    //default void statusCode(Call call, Response response, Object tag , int statusCode){}
}
