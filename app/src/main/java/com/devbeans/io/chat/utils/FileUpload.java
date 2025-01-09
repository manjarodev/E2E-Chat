package com.devbeans.io.chat.utils;


import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_IS_CONFIDENTIAL;
import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_IS_MEDIA_SHARE_RESTRICT;

import com.devbeans.io.chat.app.AppSession;
import com.devbeans.io.chat.utils.logging.Log;

import org.apache.commons.compress.utils.FileNameUtils;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class FileUpload {
    public static MultipartBody.Part requestBody(String key, File file) {
        MultipartBody.Part body;
        if (file != null) {
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            body = MultipartBody.Part.createFormData(key, file.getName(), requestFile);
        } else {
            RequestBody requestFile = RequestBody.create(MediaType.parse("text/plain"), "");
            body = MultipartBody.Part.createFormData(key, "", requestFile);
        }
        return body;
    }

    public static MultipartBody.Part requestBodyPDF(String key, File file) {
        MultipartBody.Part body;
        if (file != null) {
            String fileName = file.getName();
            String extension = FileNameUtils.getExtension(fileName);
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/" + extension), file);
            body = MultipartBody.Part.createFormData(key, file.getName(), requestFile);
        } else {
            RequestBody requestFile = RequestBody.create(MediaType.parse("text/plain"), "");
            body = MultipartBody.Part.createFormData(key, "", requestFile);
        }


        return body;
    }

    public static RequestBody uploadVoiceBuilder(String key, File file) {
        RequestBody body = RequestBody.create(MediaType.parse("audio/mp3"), file);
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart(key, file.getAbsolutePath(), body);
        return builder.build();
    }

    public static List<MultipartBody.Part> requestBody(String key, List<File> fileList) {

        List<MultipartBody.Part> imageParts = Arrays.asList(new MultipartBody.Part[fileList.size()]);

        for (int index = 0; index < fileList.size(); index++) {
            Log.d("TAG",
                    "requestUploadSurvey: survey image " + index + "  " + fileList.get(index).getPath());
            File file = new File(fileList.get(index).getPath());
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"),
                    file);
            imageParts.set(index, MultipartBody.Part.createFormData(key,
                    file.getName(),
                    requestBody));
        }
        return imageParts;
    }

    public static MultipartBody.Part requestBody(String key, File file, boolean isVideo) {
        MultipartBody.Part body;
        RequestBody requestFile = RequestBody.create(MediaType.parse("video/mp4"), file);
        body = MultipartBody.Part.createFormData(key, file.getName(), requestFile);
        return body;
    }

    public static RequestBody requestBody(String param) {
//        return RequestBody.create(okhttp3.MultipartBody.FORM, param);
        return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
    }

    public static RequestBody requestBody(double param) {
//        return RequestBody.create(okhttp3.MultipartBody.FORM, String.valueOf(param));
        return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
    }

    public static RequestBody requestBody(Boolean param) {
//        return RequestBody.create(okhttp3.MultipartBody.FORM, String.valueOf(param));
        return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
    }

    public static RequestBody requestBody(Integer param) {
//        return RequestBody.create(okhttp3.MultipartBody.FORM, String.valueOf(param));
        return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
    }

    public static Map<String, RequestBody> uploadMedia(String conId, String members) {
        Map<String, RequestBody> map = new HashMap();
        Log.e("FileUpload", "conversation_id:" + conId + "members" + members + "chatUserId" + AppSession.getUser().getChatUserId());
        map.put("conversationId", requestBody(conId));
        map.put("members", requestBody(members));
        map.put("chatUserId", requestBody(AppSession.getUser().getChatUserId()));
        Log.e("FileUpload", map.toString());
        return map;
    }


    public static Map<String, RequestBody> uploadCreateConversationMedia(String type, String members, String userChatId, String conDescription, String conName, long expiry_time) {
        Map<String, RequestBody> map = new HashMap();
        map.put("type", requestBody(type));
        map.put("members", requestBody(members));
        map.put("userChatId", requestBody(userChatId));
        map.put("description", requestBody(conDescription));
        map.put("name", requestBody(conName));
        map.put("conversationExpiryTime", requestBody(expiry_time));
        map.put(CONVERSATION_IS_CONFIDENTIAL, requestBody(SettingsValues.getConfidentialMessageCheck()));
        map.put(CONVERSATION_IS_MEDIA_SHARE_RESTRICT, requestBody(SettingsValues.getMediaShareRestrict()));

        return map;
    }

    public static Map<String, RequestBody> uploadProfileImage(String userChatId) {
        Map<String, RequestBody> map = new HashMap();
        map.put(Constants.KEYS.USER_CHAT_ID, requestBody(userChatId));
        return map;
    }


    public static Map<String, RequestBody> uploadConversationImage(String userChatId,
                                                                   String conversationId,
                                                                   String mediaType) {
        Map<String, RequestBody> map = new HashMap();
        map.put(Constants.KEYS.USER_CHAT_ID, requestBody(userChatId));
        map.put(Constants.KEYS.CONVERSATION_ID, requestBody(conversationId));
        map.put(Constants.KEYS.MEDIA_TYPE, requestBody(mediaType));
        return map;
    }

}
