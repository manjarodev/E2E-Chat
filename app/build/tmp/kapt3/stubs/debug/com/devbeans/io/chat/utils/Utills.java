package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u00ae\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0012\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u00010\u0006J\u000e\u00105\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0010\u00106\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u00010\u0006J\u000e\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020/2\u0006\u00100\u001a\u000201J\u000e\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020/2\u0006\u0010=\u001a\u00020>J\u001a\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010\u00062\u0006\u0010C\u001a\u00020\u0006J\u0016\u0010D\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020>2\u0006\u0010E\u001a\u00020\u0006J\u0006\u0010F\u001a\u00020/J\u0010\u0010G\u001a\u0004\u0018\u00010A2\u0006\u0010H\u001a\u00020IJ\u0018\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00062\u0006\u0010=\u001a\u00020>J\u0016\u0010M\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u00062\u0006\u0010=\u001a\u00020>J\u000e\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020/2\u0006\u0010O\u001a\u00020PJ\u000e\u0010R\u001a\u00020/2\u0006\u0010O\u001a\u00020PJ\u000e\u0010S\u001a\u00020/2\u0006\u0010O\u001a\u00020PJ\u000e\u0010T\u001a\u00020/2\u0006\u0010O\u001a\u00020PJ\u000e\u0010U\u001a\u00020/2\u0006\u0010O\u001a\u00020PJ\u001e\u0010V\u001a\u00020I2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020[J\u001a\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020K0]2\u0006\u0010=\u001a\u00020>J\u001a\u0010_\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020K0]2\u0006\u0010=\u001a\u00020>J\u001a\u0010`\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020K0]2\u0006\u0010=\u001a\u00020>J\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020K0]2\u0006\u0010=\u001a\u00020>J\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020K0c2\u0006\u0010d\u001a\u00020eH\u0002J\u0012\u0010f\u001a\u0004\u0018\u00010\u00062\u0006\u0010g\u001a\u00020hH\u0002J\u000e\u0010i\u001a\u00020\u00062\u0006\u0010g\u001a\u00020hJ\u0010\u0010j\u001a\u00020h2\b\u0010g\u001a\u0004\u0018\u00010\u0006J\u000e\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020mJ\u001a\u0010n\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010o\u001a\u0004\u0018\u00010\u0006J\u0018\u0010p\u001a\u0004\u0018\u00010\u00062\u0006\u0010=\u001a\u00020>2\u0006\u0010o\u001a\u00020\u0006J\u0010\u0010q\u001a\u0004\u0018\u00010\u00062\u0006\u0010r\u001a\u00020\u0006J\u0010\u0010s\u001a\u0004\u0018\u00010\u00062\u0006\u0010g\u001a\u00020mJ\u001a\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010\u0006J\u001a\u0010y\u001a\u00020m2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010z\u001a\u0004\u0018\u00010{J\u001a\u0010|\u001a\u00020I2\b\u0010B\u001a\u0004\u0018\u00010\u00062\u0006\u0010Z\u001a\u00020[H\u0007J\u000e\u0010}\u001a\u00020\u00062\u0006\u0010~\u001a\u00020mJ\u000f\u0010\u007f\u001a\u00020\u00062\u0007\u0010\u0080\u0001\u001a\u00020hJ\u0010\u0010\u0081\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020mJ\u0019\u0010\u0083\u0001\u001a\u00020/2\u0007\u0010\u0084\u0001\u001a\u00020\u00062\u0007\u0010\u0085\u0001\u001a\u00020\u000fJ\u0011\u0010\u0086\u0001\u001a\u00020/2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001J3\u0010\u0089\u0001\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002030c\u0012\n\u0012\b\u0012\u0004\u0012\u0002030c0\u008a\u00012\u0007\u0010\u008b\u0001\u001a\u00020K2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J(\u0010\u008e\u0001\u001a\u00020\u000f2\u0013\u0010\u008f\u0001\u001a\u000e\u0012\t\b\u0001\u0012\u0005\u0018\u00010\u0091\u00010\u0090\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u0001J\u0007\u0010\u0093\u0001\u001a\u00020\u000fJ\u0007\u0010\u0094\u0001\u001a\u00020\u000fJ\u0011\u0010\u0095\u0001\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020>H\u0002J\u0007\u0010\u0096\u0001\u001a\u00020\u000fJ\u0007\u0010\u0097\u0001\u001a\u00020\u000fJ\u0007\u0010\u0098\u0001\u001a\u00020\u000fJ\u0007\u0010\u0099\u0001\u001a\u00020\u000fJ\u0007\u0010\u009a\u0001\u001a\u00020\u000fJ\u0013\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0007\u0010\u009d\u0001\u001a\u00020mJ\u0007\u0010\u009e\u0001\u001a\u00020/J\u0007\u0010\u009f\u0001\u001a\u00020/J\u0013\u0010\u00a0\u0001\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0007\u0010\u00a1\u0001\u001a\u00020/J\u0011\u0010\u00a2\u0001\u001a\u00020/2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001J\u0012\u0010\u00a3\u0001\u001a\u00020/2\t\u0010\u00a4\u0001\u001a\u0004\u0018\u00010PJ\u0013\u0010\u00a3\u0001\u001a\u00020/2\n\u0010\u00a5\u0001\u001a\u0005\u0018\u00010\u00a6\u0001J\u0007\u0010\u00a7\u0001\u001a\u00020/J\u0010\u0010\u00a8\u0001\u001a\u00020m2\u0007\u0010\u00a9\u0001\u001a\u00020\u0006J0\u0010\u00aa\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00ab\u00010)\"\u0005\b\u0000\u0010\u00ab\u0001*\t\u0012\u0005\u0012\u0003H\u00ab\u00010)2\b\u0010\u00ac\u0001\u001a\u0003H\u00ab\u0001\u00a2\u0006\u0003\u0010\u00ad\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u0006\u00af\u0001"}, d2 = {"Lcom/devbeans/io/chat/utils/Utills;", "", "()V", "ALLOWED_CHARACTERS", "", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "TextColors", "Ljava/util/ArrayList;", "getTextColors", "()Ljava/util/ArrayList;", "check", "", "getCheck", "()Z", "setCheck", "(Z)V", "checkChat", "getCheckChat", "setCheckChat", "checkKds", "getCheckKds", "setCheckKds", "colors", "getColors", "setColors", "(Ljava/util/ArrayList;)V", "expirytoolTip", "Lcom/devbeans/io/chat/utils/ExpiryTooltipPopup;", "expirytoolTipList", "", "rnd", "Ljava/security/SecureRandom;", "getRnd", "()Ljava/security/SecureRandom;", "setRnd", "(Ljava/security/SecureRandom;)V", "serverAvailable", "Landroidx/lifecycle/MutableLiveData;", "getServerAvailable", "()Landroidx/lifecycle/MutableLiveData;", "setServerAvailable", "(Landroidx/lifecycle/MutableLiveData;)V", "checkChatServerConnected", "", "network", "Lcom/devbeans/io/chat/callBacks/NetworkCallback;", "checkContactNull", "Lcom/devbeans/io/chat/models/Contact;", "memberID", "checkKDSServerConnected", "checkMediaPayload", "type", "checkPayloadRead", "payload", "Lcom/devbeans/io/chat/models/Payload;", "checkServerConnected", "checkUser", "context", "Landroid/content/Context;", "clearCacheDir", "customImageIcon", "Landroid/graphics/Bitmap;", "name", "colorUser", "deleteFileFromDownloads", "fileName", "dismiss", "drawableToBitmap", "drawable", "Landroid/graphics/drawable/Drawable;", "exportTableData", "Ljava/io/File;", "tableName", "exportTableDataDownloads", "fadeInDrawable", "v", "Landroid/view/View;", "fadeInNote", "fadeInTV", "fadeOutDrawable", "fadeOutNote", "fadeOutTV", "geSingleDrawable", "layerDrawable", "Landroid/graphics/drawable/LayerDrawable;", "character", "colorss", "Lcom/devbeans/io/chat/utils/avatar/AvatarColor;", "getAllContactFiles", "", "Ljava/util/Date;", "getAllContactFilesSecond", "getAllExportedFiles", "getAllExportedFilesExternal", "getChatFiles", "", "fileFilter", "Ljava/io/FileFilter;", "getDisappearValues", "i", "", "getDisappearingOptions", "getDisappearingOptionsString", "getDisappearingTime", "timer", "", "getDuration", "path", "getFileDuration", "getHash", "stringToConvert", "getKeepChatOptions", "getLoading", "Lcom/devbeans/io/chat/utils/Loading;", "activity", "Landroid/app/Activity;", "mesage", "getMediaDuration", "uriOfFile", "Landroid/net/Uri;", "getNameDrawable", "getRandomString", "sizeOfRandomString", "getSize", "size", "getString", "id", "handleFileDelete", "tag", "deleted", "hideSoftKeyBoard", "editBox", "Landroid/widget/EditText;", "importTableData", "Lkotlin/Pair;", "file", "dao", "Lcom/devbeans/io/chat/roomDB/Dao/ContactsDao;", "isCause", "expected", "Ljava/lang/Class;", "", "exc", "isConnectedChat", "isConnectedKds", "isCurrentUserOwner", "isInternetAvailable", "isNetworkAvailable", "isOnline", "isSubscriptionExpired", "isSubscriptionGrace", "numToBytes", "", "num", "sendOfflineAcknowledgements", "sendOfflineMessages", "sendPayload", "sendPing", "showSoftKeyBoard", "showSubscriptionBanner", "root", "textView", "Landroid/widget/TextView;", "showSubscriptionEnd", "userID", "userName", "default", "T", "initialValue", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "TimerUnit", "app_debug"})
public final class Utills {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.Utills INSTANCE = null;
    private static com.devbeans.io.chat.utils.ExpiryTooltipPopup expirytoolTip;
    private static java.util.List<com.devbeans.io.chat.utils.ExpiryTooltipPopup> expirytoolTipList;
    @org.jetbrains.annotations.Nullable
    private static androidx.lifecycle.MutableLiveData<java.lang.Boolean> serverAvailable;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull
    private static java.security.SecureRandom rnd;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<java.lang.String> colors;
    @org.jetbrains.annotations.NotNull
    private static final java.util.ArrayList<java.lang.String> TextColors = null;
    private static final java.lang.CharSequence ALLOWED_CHARACTERS = "qwertyuiopasdfghjklzxcvbnm1234567890";
    private static boolean checkKds = false;
    private static boolean checkChat = false;
    private static boolean check = false;
    
    private Utills() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getServerAvailable() {
        return null;
    }
    
    public final void setServerAvailable(@org.jetbrains.annotations.Nullable
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.security.SecureRandom getRnd() {
        return null;
    }
    
    public final void setRnd(@org.jetbrains.annotations.NotNull
    java.security.SecureRandom p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getColors() {
        return null;
    }
    
    public final void setColors(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.util.ArrayList<java.lang.String> getTextColors() {
        return null;
    }
    
    public final boolean isCause(@org.jetbrains.annotations.NotNull
    java.lang.Class<? extends java.lang.Throwable> expected, @org.jetbrains.annotations.Nullable
    java.lang.Throwable exc) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getString(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.Loading getLoading(@org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    java.lang.String mesage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRandomString(int sizeOfRandomString) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] numToBytes(int num) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.Throws(exceptionClasses = {})
    public final java.lang.String getDuration(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String path) {
        return null;
    }
    
    public final int getMediaDuration(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.net.Uri uriOfFile) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFileDuration(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.graphics.Bitmap customImageIcon(@org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String colorUser) {
        return null;
    }
    
    /**
     * Returns a drawable for the given name and avatar color.
     *
     * @param name The name to use for the drawable.
     * @param colorss The avatar color to use for the drawable.
     * @return A drawable for the given name and avatar color.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final android.graphics.drawable.Drawable getNameDrawable(@org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.AvatarColor colorss) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.drawable.Drawable geSingleDrawable(@org.jetbrains.annotations.NotNull
    android.graphics.drawable.LayerDrawable layerDrawable, @org.jetbrains.annotations.NotNull
    java.lang.String character, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.AvatarColor colorss) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.graphics.Bitmap drawableToBitmap(@org.jetbrains.annotations.NotNull
    android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    public final boolean isNetworkAvailable() {
        return false;
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.InterruptedException.class, java.io.IOException.class, java.lang.Exception.class})
    public final boolean isConnectedChat() throws java.lang.InterruptedException, java.io.IOException, java.lang.Exception {
        return false;
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.InterruptedException.class, java.io.IOException.class, java.lang.Exception.class})
    public final boolean isConnectedKds() throws java.lang.InterruptedException, java.io.IOException, java.lang.Exception {
        return false;
    }
    
    public final boolean isOnline() {
        return false;
    }
    
    public final boolean isInternetAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSize(long size) {
        return null;
    }
    
    public final void hideSoftKeyBoard(@org.jetbrains.annotations.NotNull
    android.widget.EditText editBox) {
    }
    
    public final void showSoftKeyBoard(@org.jetbrains.annotations.NotNull
    android.widget.EditText editBox) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisappearingOptions(long i) {
        return null;
    }
    
    private final java.lang.String getDisappearValues(long i) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisappearingTime(int timer) {
        return null;
    }
    
    public final long getDisappearingOptionsString(@org.jetbrains.annotations.Nullable
    java.lang.String i) {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getKeepChatOptions(int i) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
    public final java.lang.String getHash(@org.jetbrains.annotations.NotNull
    java.lang.String stringToConvert) throws java.lang.Exception {
        return null;
    }
    
    public final boolean checkMediaPayload(@org.jetbrains.annotations.Nullable
    java.lang.String type) {
        return false;
    }
    
    public final void checkChatServerConnected(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.NetworkCallback network) {
    }
    
    public final boolean getCheckKds() {
        return false;
    }
    
    public final void setCheckKds(boolean p0) {
    }
    
    public final boolean getCheckChat() {
        return false;
    }
    
    public final void setCheckChat(boolean p0) {
    }
    
    public final boolean getCheck() {
        return false;
    }
    
    public final void setCheck(boolean p0) {
    }
    
    public final void checkKDSServerConnected(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.NetworkCallback network) {
    }
    
    public final void checkServerConnected(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.NetworkCallback network) {
    }
    
    public final int userID(@org.jetbrains.annotations.NotNull
    java.lang.String userName) {
        return 0;
    }
    
    private final boolean isCurrentUserOwner(android.content.Context context) {
        return false;
    }
    
    public final boolean checkUser(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Contact checkContactNull(@org.jetbrains.annotations.Nullable
    java.lang.String memberID) {
        return null;
    }
    
    /**
     * Sends all offline acknowledgements from the database.
     */
    public final void sendOfflineAcknowledgements() {
    }
    
    public final boolean isSubscriptionExpired() {
        return false;
    }
    
    public final boolean isSubscriptionGrace() {
        return false;
    }
    
    public final void showSubscriptionEnd() {
    }
    
    public final void dismiss() {
    }
    
    public final void showSubscriptionBanner(@org.jetbrains.annotations.Nullable
    android.widget.TextView textView) {
    }
    
    public final void showSubscriptionBanner(@org.jetbrains.annotations.Nullable
    android.view.View root) {
    }
    
    public final void sendPing() {
    }
    
    public final void sendOfflineMessages() {
    }
    
    private final void sendPayload(com.devbeans.io.chat.models.Payload payload) {
    }
    
    public final void handleFileDelete(@org.jetbrains.annotations.NotNull
    java.lang.String tag, boolean deleted) {
    }
    
    public final boolean checkPayloadRead(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
        return false;
    }
    
    public final void fadeOutDrawable(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    public final void fadeInDrawable(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    public final void fadeInTV(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    public final void fadeOutTV(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    public final void fadeInNote(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    public final void fadeOutNote(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    public final boolean exportTableDataDownloads(@org.jetbrains.annotations.NotNull
    java.lang.String tableName, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    /**
     * Exports data from the specified database table to a CSV file in the app's internal cache directory.
     *
     * @param tableName The name of the database table to export.
     * @param context The context in which the method is called.
     * @return The exported file, or null if the export failed.
     */
    @org.jetbrains.annotations.Nullable
    public final java.io.File exportTableData(@org.jetbrains.annotations.NotNull
    java.lang.String tableName, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<java.util.List<com.devbeans.io.chat.models.Contact>, java.util.List<com.devbeans.io.chat.models.Contact>> importTableData(@org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.roomDB.Dao.ContactsDao dao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.util.Date, java.io.File> getAllExportedFiles(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.util.Date, java.io.File> getAllExportedFilesExternal(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.util.Date, java.io.File> getAllContactFiles(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final boolean deleteFileFromDownloads(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.util.Date, java.io.File> getAllContactFilesSecond(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    private final java.util.List<java.io.File> getChatFiles(java.io.FileFilter fileFilter) {
        return null;
    }
    
    /**
     * Clears the cache directory of any files with a specific naming pattern.
     *
     * @param context The application context.
     */
    public final void clearCacheDir(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/devbeans/io/chat/utils/Utills$TimerUnit;", "", "minValue", "", "maxValue", "valueMultiplier", "", "(Ljava/lang/String;IIIJ)V", "getMaxValue", "()I", "getMinValue", "getValueMultiplier", "()J", "SECONDS", "MINUTES", "HOURS", "DAYS", "WEEKS", "MONTH", "Companion", "app_debug"})
    public static enum TimerUnit {
        /*public static final*/ SECONDS /* = new SECONDS(0, 0, 0L) */,
        /*public static final*/ MINUTES /* = new MINUTES(0, 0, 0L) */,
        /*public static final*/ HOURS /* = new HOURS(0, 0, 0L) */,
        /*public static final*/ DAYS /* = new DAYS(0, 0, 0L) */,
        /*public static final*/ WEEKS /* = new WEEKS(0, 0, 0L) */,
        /*public static final*/ MONTH /* = new MONTH(0, 0, 0L) */;
        private final int minValue = 0;
        private final int maxValue = 0;
        private final long valueMultiplier = 0L;
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.Utills.TimerUnit.Companion Companion = null;
        
        TimerUnit(int minValue, int maxValue, long valueMultiplier) {
        }
        
        public final int getMinValue() {
            return 0;
        }
        
        public final int getMaxValue() {
            return 0;
        }
        
        public final long getValueMultiplier() {
            return 0L;
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/utils/Utills$TimerUnit$Companion;", "", "()V", "get", "Lcom/devbeans/io/chat/utils/Utills$TimerUnit;", "value", "", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.devbeans.io.chat.utils.Utills.TimerUnit get(int value) {
                return null;
            }
        }
    }
}