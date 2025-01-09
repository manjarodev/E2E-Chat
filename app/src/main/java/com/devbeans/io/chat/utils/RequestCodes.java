package com.devbeans.io.chat.utils;

public class RequestCodes {

    public static final int WRITE_PERMISSION = 1;
    public static final int GROUP_IMAGE = 2;
    public static final int GROUP_IMAGE_CAM = 3;
    public static final int ADD_NEW_LEAD = 4;
    public static final int SCAN_QR = 5;
    public static final int GET_MEMBER_ID = 20;
    public static final int GET_DISAPPEAR_TIME = 21;
    public static final int MEDIA_EDIT_SHOW = 23;
    public static final int PICKFILE_RESULT_CODE = 6;
    public static final int ATTACH_LOGO_GROUP = 7;
    public static final int ATTACH_LOGO_GROUP_CAM = 8;
    public static final int REQUEST_PHONE_CALL = 8;
    public static final int BUFFER_SIZE = 9;
    public static final int AUDIO_PERMISSION_CODE = 10;
    public static final int PICK_PHOTO_GALLERY = 11;
    public static final int PICK_PHOTO_CAMERA = 12;
    public static final int LOCATIONS = 13;
    public static final int TWO_MINUTES = 1000 * 60 * 2;
    public static final int VIDEO_TRIMMER = 14;
    public static final int MIC_PERMISSION_REQUEST_CODE = 15;
    public static final int CREATE_NEW_POS_PROFILE = 16;
    public static final int CREATE_NEW_POS_OPENING = 17;
    public static final int CAMERA_ACTIVITY = 24;


    public class API {
        public static final int SIGNUP = -1;
        public static final int FB_SIGNUP = -2;
        public static final int LOGIN = 1;
        public static final int UPLOAD_MEDIA = 2;
        public static final int GET_POLICES = 3;
        public static final int GET_CONVERSATION = 4;
        public static final int GET_USER_ID = 5;
        public static final int CREATE_NEW_CONV = 6;
        public static final int VERIFY_USER = 7;
        public static final int GET_PROFILE = 8;
        public static final int UPDATE_PROFILE = 9;
        public static final int UPDATE_PROFILE_IMAGE = 17;
        public static final int ADD_MEMBER = 10;
        public static final int REMOVE_MEMBER = 11;
        public static final int BLOCK_USER = 12;
        public static final int UNBLOCK_USER = 13;
        public static final int UPDATED_CONVERSATION = 14;
        public static final int LEAVE_GROUP = 15;
        public static final int OWNER_LEAVE_GROUP = 16;
        public static final int UPDATE_CONVERSATION_NAME = 20;
        public static final int UPDATE_CONVERSATION_DESCRIPTION = 21;
        public static final int UPLOAD_MEDIA_CONVERSATION_IMAGE = 19;
        public static final int GET_GROUP_ICON = 30;
        public static final int UPDATE_CONVERSATION_EXPIRY_TIME = 31;
        public static final int CREATE_ANONYMOUS_NEW_CONV = 32;
        public static final int REMOVE_ANONYMOUS_MEMBER = 33;
        public static final int RENEW_USER_CHAT_ID = 34;
        public static final int UPLOAD_FORWARD_MEDIA_ONLY = 35;
        public static final int UPDATE_VIEW_ONCE = 36;
        public static final int DESTROY_CONVERSATION = 37;
        public static final int ADD_MEMBER_GROUP = 38;
        public static final int ADD_MEMBER_ANONYMOUS = 39;
        public static final int ADMIN_ASSIGNED_GROUP = 40;
        public static final int ADMIN_ASSIGNED_ANONYMOUS = 41;
        public static final int ADMIN_REMOVED_GROUP = 42;
        public static final int ADMIN_REMOVED_ANONYMOUS = 43;
        public static final int UPLOAD_MEDIA_ONLY = 2;
        public static final int GET_SERVER_TIME = 44;
        public static final int UPLOAD_KDS_KEYS = 45;
        public static final int UPDATE_CONFIDENTIAL = 46;
        public static final int UPDATE_MEDIA_SHARE_RESTRICT = 47;

    }

    public class API_END_POINTS {
        public static final String VERIFY_USER = "user/user_validation";
        public static final String REGISTER_DEVICE = "user/register";
        public static final String RENEW_REGISTER_DEVICE = "user/renew_user_chat_id";
        public static final String CREATE_NEW_CONVERSATION = "conversation/register";
        public static final String CREATE_ANONYMOUS_NEW_CONVERSATION = "conversation/register_anonymous";
        public static final String GET_CONVERSATION = "conversation/get_by_convId";
        public static final String ADD_MEMBER_CONVERSATION = "conversation/add_conversation_members";
        public static final String REMOVE_MEMBER_CONVERSATION = "conversation/remove_conversation_members";
        public static final String REMOVE_ANONYMOUS_MEMBER_CONVERSATION = "conversation/remove_member_anonymous";
        public static final String UPLOAD_MEDIA = "media/upload_media_convId";
        public static final String GET_PROFILE = "user/get_user_profile";
        public static final String UPDATE_PROFILE = "user/profile_update";
        public static final String UPDATE_PROFILE_IMAGE = "media/upload_profile_image";
        public static final String UPLOAD_MEDIA_ONLY = "media/upload_media";
        public static final String UPLOAD_MEDIA_CONVERSATION_IMAGE = "media/upload_conv_image";
        public static final String BLOCK_USER = "user/block_chat_user";
        public static final String UNBLOCK_USER = "user/un_block_chat_user";
        public static final String LEAVE_GROUP = "conversation/leave_group";
        public static final String OWNER_LEAVE_GROUP = "conversation/leave_group_owner";
        public static final String UPDATE_CONVERSATION_NAME = "conversation/update_conversation_name";
        public static final String UPDATE_CONVERSATION_DESCRIPTION = "conversation/update_conversation_description";
        public static final String UPDATE_CONVERSATION_EXPIRY_TIME = "conversation/update_conversation_expiry_time";
        public static final String DESTROY_CONVERSATION = "conversation/destroy_conversation";

        public static final String UPLOAD_PUBLIC_KEYS = "keyStore";
        public static final String UPLOAD_SIK = "keyStore/uploadKeyInitial";
        public static final String UPLOADS_KEYS_ON_DEFICIENCY = "keyStore/uploads_keys_on_deficiency";
        public static final String USER = "user";
        public static final String KEYSTORES = "/keyStore/";
        public static final String MONIKER_KEYSTORES = "/keyStore/request_moniker_ephemeral_keys";
        public static final String MONIKER_IK = "/keyStore/identity_key_moniker";
        public static final String SENDER_IK = "/keyStore/identity_key/";
        public static final String SERVER_TIME = "app/server_time";
        public static final String UPDATE_USER_KDS = "user/update_chat_id";
        public static final String VIEW_ONCE = "conversation/view_once";
        public static final String UPDATE_CONFIDENTIAL = "conversation/update_conversation_is_confidential";
        public static final String UPDATE_MEDIA_SHARE_RESTRICT = "conversation/update_is_media_share_restrict";
    }

    public class INTENT {
        public static final int POLICE_REPORT_EVIDENCE = 8;
    }
}