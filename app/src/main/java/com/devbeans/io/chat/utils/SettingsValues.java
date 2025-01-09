package com.devbeans.io.chat.utils;

import androidx.annotation.NonNull;

import com.devbeans.io.chat.BuildConfig;
import com.devbeans.io.chat.app.AppSession;
import com.devbeans.io.chat.utils.editor.ImageEditorValues;
import com.devbeans.io.chat.utils.logging.Log;

import org.jetbrains.annotations.NotNull;

public final class SettingsValues {
    private static final String TAG = Log.tag(SettingsValues.class);

    public static final String THEME = "settings.theme";
    public static final String MESSAGE_FONT_SIZE = "settings.message.font.size";
    public static final String MESSAGE_EMOJI_SIZE = "settings.message.emoji.size";
    public static final String MESSAGE_READ_RECEIPTS = "settings.message.read.receipts";
    public static final String MESSAGE_READ_RECEIPTS_UNKNOWN = "settings.message.read.receipts.unknown";
    public static final String MESSAGE_READ_RECEIPTS_PRIVACY = "settings.message.read.receipts.privacy";
    public static final String LANGUAGE = "settings.language";
    public static final String PREFER_SYSTEM_EMOJI = "settings.use.system.emoji";
    public static final String ENTER_KEY_SENDS = "settings.enter.key.sends";
    public static final String BACKUPS_ENABLED = "settings.backups.enabled";
    public static final String SMS_DELIVERY_REPORTS_ENABLED = "settings.sms.delivery.reports.enabled";
    public static final String MESSAGE_NOTIFICATIONS_ENABLED = "settings.message.notifications.enabled";
    public static final String MESSAGE_NOTIFICATION_SOUND = "settings.message.notifications.sound";
    public static final String MESSAGE_VIBRATE_ENABLED = "settings.message.vibrate.enabled";
    public static final String MESSAGE_LED_COLOR = "settings.message.led.color";
    public static final String MESSAGE_LED_BLINK_PATTERN = "settings.message.led.blink";
    public static final String MESSAGE_IN_CHAT_SOUNDS_ENABLED = "settings.message.in.chats.sounds.enabled";
    public static final String MESSAGE_REPEAT_ALERTS = "settings.message.repeat.alerts";
    public static final String MESSAGE_NOTIFICATION_PRIVACY = "settings.message.notification.privacy";
    public static final String CALL_NOTIFICATIONS_ENABLED = "settings.call.notifications.enabled";
    public static final String CALL_RINGTONE = "settings.call.ringtone";
    public static final String CALL_VIBRATE_ENABLED = "settings.call.vibrate.enabled";
    public static final String NOTIFY_WHEN_CONTACT_JOINS_SIGNAL = "settings.notify.when.contact.joins.signal";
    private static final String UNIVERSAL_EXPIRE_TIMER = "settings.universal.expire.timer";
    private static final String BLOCK_UNKNOWN_CONTACT = "settings.block.unknown.contact";
    private static final String SENT_MEDIA_QUALITY = "settings.sentMediaQuality";
    private static final String CONFIDENTIAL_MESSAGES = "settings.confidentialMessages";
    private static final String KEEP_CHAT_TIME = "settings.keepChatTime";
    private static final String HIDE_ALL = "settings.privacy.hideAll";
    private static final String HIDE_DIRECT = "settings.privacy.hideDirect";
    private static final String HIDE_GROUP = "settings.privacy.hideGroup";
    private static final String HIDE_ANONYMOUS_GROUP = "settings.privacy.hideAnonymousGroup";
    private static final String AUTO_SAVE_VAULT = "settings.autoSaveVault";
    private static final String AUTO_DOWNLOAD = "settings.autoDownload";
    private static final String PASS_CODE_SHOWING = "settings.passcode";
    private static final String PASS_ALREADY_CODE_SHOWING = "settings.passcode.already.showing";
    private static final String DEFAULT_CHAT_COLOR = "settings.chat.default_chat_color";
    private static final String DEFAULT_CHAT_COLORS_SET = "settings.chat.default_chat_colors_set";
    private static final String DEFAULT_CHAT_WALLPAPER_DRAWABLE = "settings.chat.default_chat_wallpaper_drawable";
    private static final String DEFAULT_CHAT_WALLPAPER_DRAWABLE_SET = "settings.chat.default_chat_wallpaper_drawable_set";
    private static final String DEFAULT_CHAT_WALLPAPER_FILE = "settings.chat.default_chat_wallpaper_file";
    private static final String DEFAULT_CHAT_WALLPAPER_FILE_SET = "settings.chat.default_chat_wallpaper_file_set";
    private static final String KEY_UPLOADED = "encrypted.keyPairs.uploaded";
    private static final String KEY_UPLOAD_REQUEST = "encrypted.keyPairs.upload.request";
    private static final String INCOGNITO_KEYBOARD = "settings.privacy.incognito_keyboard";
    private static final String CLIPBOARD_DATA_STRING = "settings.privacy.clipboard_data_string";
    private static final String CLIPBOARD_DATA_STRING_SET = "settings.privacy.clipboard_data_string_set";
    private static final String CLIPBOARD_DATA_IMAGE = "settings.privacy.clipboard_data_image";
    private static final String CLIPBOARD_DATA_IMAGE_SET = "settings.privacy.clipboard_data_image_set";
    private static final String MEDIA_SHARE_RESTRICT = "settings.privacy.media_share_restrict";
    private static final String SYSTEM_LOG = "system.privacy.log";
    private static final String SYSTEM_PRIVACY_SUBSCRIPTION_END = "system.privacy.subscription.end";
    private static final String SYSTEM_PRIVACY_SUBSCRIPTION_GRACE = "system.privacy.subscription.grace";
    private static volatile SettingsValues instance;
    private final ImageEditorValues imageEditorValues;


    private static @NonNull
    SettingsValues getInstance() {
        if (instance == null) {
            synchronized (SettingsValues.class) {
                if (instance == null) {
                    instance = new SettingsValues();
                }
            }
        }

        return instance;
    }


    public SettingsValues() {
        this.imageEditorValues = new ImageEditorValues();
    }

    //for setting the initial values of all the data which is essential for Application settings
    public static void onFirstEverAppLaunch() {
        setKeepChatTime(30);
        setPassCodeShowing(false);
        setPassCodeAlreadyShowing(false);
        setBlockUnknownContact(false);
        //1 Day
        setUniversalExpireTimer(24 * 60 * 60 * (long) 1000);
        setAutoSaveVault(false);

        //settings for privacy settings of message showing in listing
        setHideAll(false);
        setHideDirect(false);
        setHideGroup(false);
        setHideAnonymousGroup(false);
        setEnterKeySends(false);
        setEmojiFontSize(22);
        setMessageFontSize(22);
        setConfidentialMessageCheck(false);

        setDefaultChatColorsSet(false);
        setDefaultChatWallpaperSet(false);
        setDefaultChatWallpaperFileSet(false);
        setIncognitoKeyboard(true);
        setSystemLog(true);
        setMediaShareRestrict(false);

        //for plan expired
        setSubscriptionEndSet(false);
        setSubscriptionGraceSet(false);


        //read receipts
        setMessageReadReceipts(true);
        setMessageReadReceiptsUnknown(false);
        setMessageReadReceiptsPrivacy(true);


    }

    public static int getKeepChatTime() {
        return AppSession.getInt(KEEP_CHAT_TIME);
    }

    public static int getMessageFontSize() {
        return AppSession.getInt(MESSAGE_FONT_SIZE);
    }

    public static int getMessageEmojiSize() {
        return AppSession.getInt(MESSAGE_EMOJI_SIZE);
    }

    public static void setSystemLog(boolean systemLog) {
        AppSession.put(SYSTEM_LOG, systemLog);
    }

    public static boolean getSystemLog() {
//        return AppSession.getBoolean(SYSTEM_LOG, false);
        return BuildConfig.DEBUG;
    }

    public static void setPassCodeShowing(boolean passCodeShowing) {
        AppSession.put(PASS_CODE_SHOWING, passCodeShowing);
    }

    public static void setEnterKeySends(boolean passCodeShowing) {
        AppSession.put(ENTER_KEY_SENDS, passCodeShowing);
    }


    public static boolean getEnterKeySends() {
        return AppSession.getBoolean(ENTER_KEY_SENDS, false);
    }

    public static void setClipboardDataStringSet(boolean clipboardDataStringSet) {
        AppSession.put(CLIPBOARD_DATA_STRING_SET, clipboardDataStringSet);
    }


    public static boolean getClipboardDataStringSet() {
        return AppSession.getBoolean(CLIPBOARD_DATA_STRING_SET, false);
    }

    public static void setSubscriptionEndSet(boolean subscriptionEndSet) {
        AppSession.put(SYSTEM_PRIVACY_SUBSCRIPTION_END, subscriptionEndSet);
    }


    public static boolean getSubscriptionEndSet() {
        return AppSession.getBoolean(SYSTEM_PRIVACY_SUBSCRIPTION_END, false);
    }


    public static void setSubscriptionGraceSet(boolean subscriptionGraceSet) {
        AppSession.put(SYSTEM_PRIVACY_SUBSCRIPTION_GRACE, subscriptionGraceSet);
    }


    public static boolean getSubscriptionGraceSet() {
        return AppSession.getBoolean(SYSTEM_PRIVACY_SUBSCRIPTION_GRACE, false);
    }


    public static void setClipboardDataImageSet(boolean clipboardDataImageSet) {
        AppSession.put(CLIPBOARD_DATA_IMAGE_SET, clipboardDataImageSet);
    }


    public static boolean getClipboardDataImageSet() {
        return AppSession.getBoolean(CLIPBOARD_DATA_IMAGE_SET, false);
    }

    public static void setIncognitoKeyboard(boolean incognitoKeyboard) {
        AppSession.put(INCOGNITO_KEYBOARD, incognitoKeyboard);
    }


    public static boolean getIncognitoKeyboard() {
        return AppSession.getBoolean(INCOGNITO_KEYBOARD, false);
    }


    public static void setClipboardDataString(String clipboardDataString) {
        AppSession.put(CLIPBOARD_DATA_STRING, clipboardDataString);
    }

    public static boolean getMediaShareRestrict() {
        return AppSession.getBoolean(MEDIA_SHARE_RESTRICT, false);
    }


    public static void setMediaShareRestrict(Boolean mediaShareRestrict) {
        AppSession.put(MEDIA_SHARE_RESTRICT, mediaShareRestrict);
    }

    public static String getClipboardDataString() {
        return AppSession.get(CLIPBOARD_DATA_STRING);
    }

    public static void setClipboardDataImage(String clipboardDataImage) {
        AppSession.put(CLIPBOARD_DATA_IMAGE, clipboardDataImage);
    }

    public static String getClipboardDataImage() {
        return AppSession.get(CLIPBOARD_DATA_IMAGE);
    }


    public static void setDefaultChatColorsSet(boolean defaultChatColorsSet) {
        AppSession.put(DEFAULT_CHAT_COLORS_SET, defaultChatColorsSet);
    }

    public static boolean getDefaultChatColorsSet() {
        return AppSession.getBoolean(DEFAULT_CHAT_COLORS_SET, false);
    }

    public static void setDefaultChatWallpaperSet(boolean defaultChatWallpaperSet) {
        AppSession.put(DEFAULT_CHAT_WALLPAPER_DRAWABLE_SET, defaultChatWallpaperSet);
    }

    public static boolean getDefaultChatWallpaperSet() {
        return AppSession.getBoolean(DEFAULT_CHAT_WALLPAPER_DRAWABLE_SET, false);
    }


    public static void setDefaultChatWallpaperFileSet(boolean defaultChatWallpaperFileSet) {
        AppSession.put(DEFAULT_CHAT_WALLPAPER_FILE_SET, defaultChatWallpaperFileSet);
    }

    public static boolean getDefaultChatWallpaperFileSet() {
        return AppSession.getBoolean(DEFAULT_CHAT_WALLPAPER_FILE_SET, false);
    }

    public static void setDefaultChatColor(int defaultChatColor) {
        AppSession.put(DEFAULT_CHAT_COLOR, defaultChatColor);
    }

    public static int getDefaultChatColor() {
        return AppSession.getInt(DEFAULT_CHAT_COLOR);
    }

    public static void setDefaultChatWallpaper(int defaultChatWallpaper) {
        AppSession.put(DEFAULT_CHAT_WALLPAPER_DRAWABLE, defaultChatWallpaper);
    }

    public static int getDefaultChatWallpaper() {
        return AppSession.getInt(DEFAULT_CHAT_WALLPAPER_DRAWABLE);
    }


    public static void setDefaultChatWallpaperFile(String defaultChatWallpaperFile) {
        AppSession.put(DEFAULT_CHAT_WALLPAPER_FILE, defaultChatWallpaperFile);
    }

    public static String getDefaultChatWallpaperFile() {
        return AppSession.get(DEFAULT_CHAT_WALLPAPER_FILE);
    }

    public static boolean getPassCodeShowing() {
        return AppSession.getBoolean(PASS_CODE_SHOWING, false);
    }

    public static void setPassCodeAlreadyShowing(boolean passCodeShowing) {
        AppSession.put(PASS_ALREADY_CODE_SHOWING, passCodeShowing);
    }

    public static boolean getPassAlreadyCodeShowing() {
        return AppSession.getBoolean(PASS_ALREADY_CODE_SHOWING, false);
    }

    public static void setKeepChatTime(int keepChatTime) {
        AppSession.put(KEEP_CHAT_TIME, keepChatTime);
    }

    public static void setMessageFontSize(int messageFontSize) {
        AppSession.put(MESSAGE_FONT_SIZE, messageFontSize);
    }


    public static void setEmojiFontSize(int emojiFontSize) {
        AppSession.put(MESSAGE_EMOJI_SIZE, emojiFontSize);
    }


    public static long getUniversalExpireTimer() {
        return AppSession.getLong(UNIVERSAL_EXPIRE_TIMER);
    }

    public static void setUniversalExpireTimer(long expireTime) {
        AppSession.put(UNIVERSAL_EXPIRE_TIMER, expireTime);
    }


    public static void setConfidentialMessageCheck(boolean confidentialMessageCheck) {
        AppSession.put(CONFIDENTIAL_MESSAGES, confidentialMessageCheck);
    }

    public static boolean getConfidentialMessageCheck() {
        return AppSession.getBoolean(CONFIDENTIAL_MESSAGES, false);
    }


    public static void setMessageReadReceipts(boolean messageReadReceipts) {
        AppSession.put(MESSAGE_READ_RECEIPTS, messageReadReceipts);
    }

    public static boolean getMessageReadReceipts() {
        return AppSession.getBoolean(MESSAGE_READ_RECEIPTS, false);
    }

    public static void setMessageReadReceiptsUnknown(boolean messageReadReceipts) {
        AppSession.put(MESSAGE_READ_RECEIPTS_UNKNOWN, messageReadReceipts);
    }

    public static boolean getMessageReadReceiptsUnknown() {
        return AppSession.getBoolean(MESSAGE_READ_RECEIPTS_UNKNOWN, false);
    }

    public static void setMessageReadReceiptsPrivacy(boolean messageReadReceipts) {
        AppSession.put(MESSAGE_READ_RECEIPTS_PRIVACY, messageReadReceipts);
    }

    public static boolean getMessageReadReceiptsPrivacy() {
        return AppSession.getBoolean(MESSAGE_READ_RECEIPTS_PRIVACY, false);
    }


    public static void setBlockUnknownContact(boolean field) {
        AppSession.put(BLOCK_UNKNOWN_CONTACT, field);
    }

    public static boolean getBlockUnknownContact() {
        return AppSession.getBoolean(BLOCK_UNKNOWN_CONTACT, false);
    }


    public static void setAutoSaveVault(boolean field) {
        AppSession.put(AUTO_SAVE_VAULT, field);
    }

    public static void setAutoDownload(boolean field) {
        AppSession.put(AUTO_DOWNLOAD, field);
    }

    public static boolean getAutoSaveVault() {
        return AppSession.getBoolean(AUTO_SAVE_VAULT, false);
    }

    public static boolean getAutoDownload() {
        return AppSession.getBoolean(AUTO_DOWNLOAD, false);
    }


    public static void setHideAll(boolean check) {
        AppSession.put(HIDE_ALL, check);
    }

    public static boolean getHideAll() {
        return AppSession.getBoolean(HIDE_ALL, false);
    }

    public static void setHideDirect(boolean check) {
        AppSession.put(HIDE_DIRECT, check);
    }

    public static boolean getHideDirect() {
        return AppSession.getBoolean(HIDE_DIRECT, false);
    }


    public static void setHideGroup(boolean check) {
        AppSession.put(HIDE_GROUP, check);
    }

    public static boolean getHideGroup() {
        return AppSession.getBoolean(HIDE_GROUP, false);
    }

    public static void setHideAnonymousGroup(boolean check) {
        AppSession.put(HIDE_ANONYMOUS_GROUP, check);
    }

    public static boolean getHideAnonymousGroup() {
        return AppSession.getBoolean(HIDE_ANONYMOUS_GROUP, false);
    }


    public static void setKeyUploaded(boolean check) {
        AppSession.put(KEY_UPLOADED, check);
    }

    public static void setKeysUploadRequest(@NotNull String request) {
        AppSession.put(KEY_UPLOAD_REQUEST, request);
    }

    public static String getKeysUploadRequest() {
        return AppSession.get(KEY_UPLOAD_REQUEST);
    }


    public static boolean getKeyUploaded() {
        return AppSession.getBoolean(KEY_UPLOADED, false);
    }

    public static @NonNull
    Theme getTheme() {
        return Theme.deserialize("light");
    }

    public void setTheme(@NonNull Theme theme) {
//        putString(THEME, theme.serialize());
//        onConfigurationSettingChanged.postValue(THEME);
    }


    public static @NonNull
    ImageEditorValues imageEditorValues() {
        return getInstance().imageEditorValues;
    }

    public enum Theme {
        SYSTEM("system"), LIGHT("light"), DARK("dark");

        private final String value;

        Theme(String value) {
            this.value = value;
        }

        public @NonNull
        String serialize() {
            return value;
        }

        public static @NonNull
        Theme deserialize(@NonNull String value) {
            switch (value) {
                case "system":
                    return SYSTEM;
                case "light":
                    return LIGHT;
                case "dark":
                    return DARK;
                default:
                    throw new IllegalArgumentException("Unrecognized value " + value);
            }
        }
    }

}
