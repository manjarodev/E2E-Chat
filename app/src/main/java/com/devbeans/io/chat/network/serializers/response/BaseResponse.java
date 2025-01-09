package com.devbeans.io.chat.network.serializers.response;


import com.devbeans.io.chat.network.ResponseCode;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Field;

import retrofit2.Response;

public class BaseResponse implements Serializable {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("user")
    @Expose
    private boolean isUser;

    public BaseResponse() {
    }

    public BaseResponse(String message) {
        setMessage(message);
    }

    public static boolean isSuccess(Response response) {
        try {
            return ResponseCode.isBetweenSuccessRange(response.code());
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUnAuthorized(Response response) {
        try {
            return response.code() == ResponseCode.FORBIDDEN
                    || response.code() == ResponseCode.UN_AUTHORIZED;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isSessionExpired(Response response) {
        try {
            return response.code() == ResponseCode.FORBIDDEN;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean appNotUpdated(Response response) {
        try {
            return ((BaseResponse) response.body()).getCode() == ResponseCode.APP_NOT_UPDATED;
        } catch (Exception e) {
            return false;
        }
    }


    private String ggetMessage(Object object) {
        String message = "";
        try {
            Field[] fields = object.getClass().getFields();

            for (int i = 0; i < fields.length; i++) {

                // get value of the fields
                Object value = null;

                value = fields[i].get(message);


                // print result
                System.out.println("Value of Field "
                        + fields[i].getName()
                        + " is " + value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", isUser=" + isUser +
                '}';
    }
}