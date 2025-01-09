package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003L\u008f\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u00101\u001a\u0004\u0018\u00010\u00042\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u00010\u0004J \u00106\u001a\u0004\u0018\u00010\u00042\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00107\u001a\u00020\u0004J6\u00108\u001a\u00020\'2\u0006\u00109\u001a\u00020\u00042\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\'J(\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.H\u0002J:\u0010F\u001a\u00020@2\b\u0010G\u001a\u0004\u0018\u00010\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0018\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u000e\u0010P\u001a\u00020@2\u0006\u0010K\u001a\u00020.J\u000e\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u00020SJ\u000e\u0010T\u001a\u00020B2\u0006\u0010U\u001a\u00020.J\u0018\u0010V\u001a\u00020B2\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0004H\u0007J\u0016\u0010Y\u001a\u00020@2\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010L\u001a\u00020MJ\u001a\u0010[\u001a\u0004\u0018\u00010.2\u0006\u0010O\u001a\u00020.2\b\u0010\\\u001a\u0004\u0018\u00010MJ\u0010\u0010]\u001a\u0004\u0018\u00010\u00042\u0006\u0010Z\u001a\u00020^J\u0010\u0010]\u001a\u0004\u0018\u00010\u00042\u0006\u0010Z\u001a\u00020\u0004J\u000e\u0010_\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004J&\u0010`\u001a\u00020@2\b\u0010W\u001a\u0004\u0018\u00010\u00042\b\u0010a\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010b\u001a\u00020@2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010K\u001a\u00020.2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010fJ\u0010\u0010g\u001a\u0004\u0018\u00010\u00042\u0006\u0010h\u001a\u00020iJ\u0010\u0010j\u001a\u0004\u0018\u00010\u00042\u0006\u0010h\u001a\u00020.J\u0010\u0010k\u001a\u0004\u0018\u00010\u00042\u0006\u0010l\u001a\u00020\u0004J\u000e\u0010m\u001a\u0002032\u0006\u0010n\u001a\u00020\u0004J\u000e\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u000203J\u0012\u0010q\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010\u0004J\'\u0010t\u001a\u0002032\u0006\u0010u\u001a\u00020\u00042\b\u0010v\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010w\u001a\u00020\u0004\u00a2\u0006\u0002\u0010xJ\u0016\u0010y\u001a\u00020@2\u0006\u0010K\u001a\u00020.2\u0006\u0010z\u001a\u00020{J&\u0010|\u001a\u00020@2\u0006\u0010c\u001a\u00020d2\u0006\u0010K\u001a\u00020.2\u0006\u0010}\u001a\u00020i2\u0006\u0010e\u001a\u00020fJ\u000e\u0010~\u001a\u00020B2\u0006\u0010O\u001a\u00020.J\u0018\u0010\u007f\u001a\u00020.2\u0006\u0010>\u001a\u00020\'2\u0006\u0010K\u001a\u00020.H\u0002J\u001a\u0010\u0080\u0001\u001a\u00020@2\u0006\u0010K\u001a\u00020.2\u0007\u0010\u0081\u0001\u001a\u00020\u0004H\u0002J\u000f\u0010\u0082\u0001\u001a\u00020@2\u0006\u0010K\u001a\u00020.J\u001a\u0010\u0083\u0001\u001a\u00020@2\u0006\u0010K\u001a\u00020.2\u0007\u0010\u0081\u0001\u001a\u00020\u0004H\u0002J\u000f\u0010\u0084\u0001\u001a\u00020@2\u0006\u0010K\u001a\u00020.J%\u0010\u0085\u0001\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\'2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0004H\u0002J\u000f\u0010\u0086\u0001\u001a\u00020@2\u0006\u0010K\u001a\u00020.J\u001b\u0010\u0087\u0001\u001a\u00020@2\b\u0010D\u001a\u0004\u0018\u00010.2\b\u0010R\u001a\u0004\u0018\u00010SJ%\u0010\u0088\u0001\u001a\u00020@2\u0006\u0010>\u001a\u00020\'2\u0006\u0010D\u001a\u00020\u00042\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0004H\u0002J\u0019\u0010\u0089\u0001\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001J\"\u0010\u008c\u0001\u001a\u00020B2\u0006\u00107\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008b\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\'\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&0%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100\u00a8\u0006\u0090\u0001"}, d2 = {"Lcom/devbeans/io/chat/utils/EncryptionUtils;", "", "()V", "ENCRYPT_ALGO", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "ackDao", "Lcom/devbeans/io/chat/roomDB/Dao/OfflineAckDao;", "getAckDao", "()Lcom/devbeans/io/chat/roomDB/Dao/OfflineAckDao;", "arrayListForSending", "Ljava/util/ArrayList;", "Lcom/devbeans/io/chat/encryption/MappedPayload;", "getArrayListForSending", "()Ljava/util/ArrayList;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "setExecutor", "(Ljava/util/concurrent/Executor;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "mutableChannels", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/devbeans/io/chat/models/ConversationChannels;", "getMutableChannels", "()Landroidx/lifecycle/MutableLiveData;", "mutableChannels$delegate", "Lkotlin/Lazy;", "payloadList", "", "Lcom/devbeans/io/chat/models/Payload;", "getPayloadList", "()Ljava/util/List;", "AESDecrypt", "key", "", "iv", "ciphertext", "AESEncrypt", "data", "DHKX", "username", "EP", "EK", "recipient", "Lcom/devbeans/io/chat/network/serializers/response/KeyResponse;", "channel", "checkAndSend", "", "isContact", "", "isOneToOne", "message", "payload1", "checkChannel", "channel_identifier", "channel_with", "conversation_type", "conversation_id", "payload", "ReceiverCallback", "Lcom/devbeans/io/chat/utils/EncryptionUtils$ReceiverCallback;", "checkChannelEstablished", "decryptedPayload", "checkInternetAndSend", "checkSentMessage", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "checkTextPayload", "actualPayload", "decryptFile", "fromFile", "avRatchetKeyMaterial", "decryptPayload", "encryptedPayload", "decryptPayloadWithChannel", "callback", "decryptRequest", "Lcom/devbeans/io/chat/models/EncryptedPayload;", "encryptDataDownload", "encryptFile", "toFile", "encryptMessage", "input", "", "context", "Landroid/content/Context;", "encryptOfflinePayload", "payloadToEncrypt", "Lcom/devbeans/io/chat/models/OfflineMessage;", "encryptPayload", "encryptRequest", "requestToEncrypt", "getDecodedBytes", "encodedString", "getEncodedString", "decodedBytes", "getSecretKey", "Ljavax/crypto/SecretKey;", "secretKey", "hkdf", "inp", "length", "salt", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)[B", "makeChannels", "senderCallback", "Lcom/devbeans/io/chat/utils/EncryptionUtils$SenderCallback;", "offlineMessageConcept", "offlineMessage", "payloadCheckChannelMaterial", "receivePreKeyMessage", "removeFromDB", "method", "saveAcknowledgment", "saveInDB", "sendDeletePayload", "sendMessage", "sendOfflineAcks", "sendOpenedAck", "sendPreKeyMessage", "signSignature", "secret", "Lcom/goterl/lazysodium/utils/Key;", "verifySignSignature", "signature", "pubKey", "SenderCallback", "app_debug"})
public final class EncryptionUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.EncryptionUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static java.util.concurrent.Executor executor;
    @org.jetbrains.annotations.NotNull
    private static android.os.Handler handler;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy mutableChannels$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> arrayListForSending = null;
    private static final java.lang.String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<com.devbeans.io.chat.models.Payload> payloadList = null;
    private static int counter = 0;
    @org.jetbrains.annotations.NotNull
    private static final com.devbeans.io.chat.roomDB.Dao.OfflineAckDao ackDao = null;
    
    private EncryptionUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.Executor getExecutor() {
        return null;
    }
    
    public final void setExecutor(@org.jetbrains.annotations.NotNull
    java.util.concurrent.Executor p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.os.Handler getHandler() {
        return null;
    }
    
    public final void setHandler(@org.jetbrains.annotations.NotNull
    android.os.Handler p0) {
    }
    
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.devbeans.io.chat.models.ConversationChannels>> getMutableChannels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> getArrayListForSending() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.Payload> getPayloadList() {
        return null;
    }
    
    /**
     * Method which is used to Assymetric encrypt every message and send it to the server
     * and will be decrypted by the receiver only by #SIR (Session Initiation Request)
     */
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
    public final void encryptMessage(@org.jetbrains.annotations.Nullable
    java.lang.CharSequence input, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload, @org.jetbrains.annotations.Nullable
    android.content.Context context) {
    }
    
    private final void sendMessage(java.lang.String message, com.devbeans.io.chat.models.ConversationChannels channel, java.lang.String avRatchetKeyMaterial) {
    }
    
    private final void sendPreKeyMessage(com.devbeans.io.chat.models.ConversationChannels channel, java.lang.String message, java.lang.String avRatchetKeyMaterial) {
    }
    
    /**
     * The Method for encrypting plain text into cipher text
     */
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.Throws(exceptionClasses = {java.security.NoSuchAlgorithmException.class, javax.crypto.NoSuchPaddingException.class, java.security.InvalidKeyException.class, java.security.spec.InvalidParameterSpecException.class, javax.crypto.IllegalBlockSizeException.class, javax.crypto.BadPaddingException.class, java.io.UnsupportedEncodingException.class, com.goterl.lazysodium.exceptions.SodiumException.class})
    public final java.lang.String AESEncrypt(@org.jetbrains.annotations.NotNull
    byte[] key, @org.jetbrains.annotations.NotNull
    byte[] iv, @org.jetbrains.annotations.NotNull
    java.lang.String data) throws java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidParameterSpecException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, java.io.UnsupportedEncodingException, com.goterl.lazysodium.exceptions.SodiumException {
        return null;
    }
    
    public final void makeChannels(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.EncryptionUtils.SenderCallback senderCallback) {
    }
    
    public final void offlineMessageConcept(@org.jetbrains.annotations.NotNull
    java.lang.CharSequence input, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.OfflineMessage offlineMessage, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getDecodedBytes(@org.jetbrains.annotations.NotNull
    java.lang.String encodedString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEncodedString(@org.jetbrains.annotations.NotNull
    byte[] decodedBytes) {
        return null;
    }
    
    /**
     * Will encrypt the payload [payloadToEncrypt] to sent to server
     * which is given top the user on the time of register user in [com.devbeans.io.chat.activities.CustomSplashActivity]
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String encryptPayload(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payloadToEncrypt) {
        return null;
    }
    
    /**
     * Will encrypt the payload [requestToEncrypt] to sent to server
     * which is given top the user on the time of API call [com.devbeans.io.chat.network.ApiHelper]
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String encryptRequest(@org.jetbrains.annotations.NotNull
    java.lang.String requestToEncrypt) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String decryptRequest(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.EncryptedPayload encryptedPayload) {
        return null;
    }
    
    /**
     * Will encrypt the payload [payloadToEncrypt] to sent to server
     * which is given top the user on the time of register user in [com.devbeans.io.chat.activities.CustomSplashActivity]
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String encryptOfflinePayload(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.OfflineMessage payloadToEncrypt) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.Throws(exceptionClasses = {java.security.GeneralSecurityException.class, java.lang.IllegalArgumentException.class, java.lang.Exception.class})
    public final byte[] hkdf(@org.jetbrains.annotations.NotNull
    java.lang.String inp, @org.jetbrains.annotations.Nullable
    java.lang.Integer length, @org.jetbrains.annotations.NotNull
    java.lang.String salt) throws java.security.GeneralSecurityException, java.lang.IllegalArgumentException, java.lang.Exception {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String signSignature(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    com.goterl.lazysodium.utils.Key secret) {
        return null;
    }
    
    public final boolean verifySignSignature(@org.jetbrains.annotations.NotNull
    java.lang.String data, @org.jetbrains.annotations.NotNull
    java.lang.String signature, @org.jetbrains.annotations.NotNull
    com.goterl.lazysodium.utils.Key pubKey) {
        return false;
    }
    
    /**
     * Will decrypt the payload[encryptedPayload] given from Server
     * on the basis of identity key
     */
    public final void decryptPayload(@org.jetbrains.annotations.NotNull
    java.lang.String encryptedPayload, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.EncryptionUtils.ReceiverCallback ReceiverCallback) {
    }
    
    private final void checkChannelEstablished(com.devbeans.io.chat.models.Payload decryptedPayload, com.devbeans.io.chat.utils.EncryptionUtils.ReceiverCallback ReceiverCallback) {
    }
    
    public final boolean checkTextPayload(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload actualPayload) {
        return false;
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void encryptFile(@org.jetbrains.annotations.Nullable
    java.lang.String fromFile, @org.jetbrains.annotations.Nullable
    java.lang.String toFile, @org.jetbrains.annotations.Nullable
    java.lang.String key) throws java.lang.Exception {
    }
    
    @org.jetbrains.annotations.Nullable
    public final javax.crypto.SecretKey getSecretKey(@org.jetbrains.annotations.Nullable
    java.lang.String secretKey) {
        return null;
    }
    
    private final void checkChannel(java.lang.String channel_identifier, java.lang.String channel_with, java.lang.String conversation_type, java.lang.String conversation_id, com.devbeans.io.chat.models.Payload payload, com.devbeans.io.chat.utils.EncryptionUtils.ReceiverCallback ReceiverCallback) {
    }
    
    /**
     * Will decrypt the payload[encryptedPayload] given from Server
     * on the basis of identity key
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String decryptRequest(@org.jetbrains.annotations.NotNull
    java.lang.String encryptedPayload) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.models.ConversationChannels DHKX(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.Nullable
    java.lang.String EP, @org.jetbrains.annotations.Nullable
    java.lang.String EK, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.KeyResponse recipient, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.ConversationChannels channel) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Payload decryptPayloadWithChannel(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload decryptedPayload, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.EncryptionUtils.ReceiverCallback callback) {
        return null;
    }
    
    public final boolean payloadCheckChannelMaterial(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload decryptedPayload) {
        return false;
    }
    
    private final com.devbeans.io.chat.models.Payload receivePreKeyMessage(com.devbeans.io.chat.models.ConversationChannels channel, com.devbeans.io.chat.models.Payload payload) {
        return null;
    }
    
    /**
     * Method for decrypting ciphertext ByteArray into Plaintext String
     */
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.Throws(exceptionClasses = {javax.crypto.NoSuchPaddingException.class, java.security.NoSuchAlgorithmException.class, java.security.spec.InvalidParameterSpecException.class, java.security.InvalidAlgorithmParameterException.class, java.security.InvalidKeyException.class, javax.crypto.BadPaddingException.class, javax.crypto.IllegalBlockSizeException.class, java.io.UnsupportedEncodingException.class})
    public final java.lang.String AESDecrypt(@org.jetbrains.annotations.NotNull
    byte[] key, @org.jetbrains.annotations.NotNull
    byte[] iv, @org.jetbrains.annotations.Nullable
    java.lang.String ciphertext) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.spec.InvalidParameterSpecException, java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.io.UnsupportedEncodingException {
        return null;
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final boolean decryptFile(@org.jetbrains.annotations.NotNull
    java.lang.String fromFile, @org.jetbrains.annotations.NotNull
    java.lang.String avRatchetKeyMaterial) throws java.lang.Exception {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String encryptDataDownload(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
        return null;
    }
    
    public final void sendDeletePayload(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    public final void sendOpenedAck(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload message, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void checkAndSend(boolean isContact, boolean isOneToOne, com.devbeans.io.chat.models.Payload message, com.devbeans.io.chat.models.Payload payload1) {
    }
    
    public final int getCounter() {
        return 0;
    }
    
    public final void setCounter(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.roomDB.Dao.OfflineAckDao getAckDao() {
        return null;
    }
    
    public final void sendOfflineAcks(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    /**
     * Checks the internet connection and sends the given payload.
     *
     * @param payload The payload to send.
     */
    public final void checkInternetAndSend(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    /**
     * Saves the given payload in the database if it doesn't already exist.
     *
     * @param payload The payload to save in the database.
     * @param method The method that called this function.
     */
    private final void saveInDB(com.devbeans.io.chat.models.Payload payload, java.lang.String method) {
    }
    
    /**
     * Removes the given payload from the database if it exists.
     *
     * @param payload The payload to remove from the database.
     * @param method The method that called this function.
     */
    private final void removeFromDB(com.devbeans.io.chat.models.Payload payload, java.lang.String method) {
    }
    
    /**
     * Checks if any member of a conversation has a non-zero send counter value and updates the hasSentMessage property accordingly.
     *
     * @param conversation The conversation to check and update.
     * @return True if any member has a non-zero send counter value or if the conversation has a sent message, false otherwise.
     */
    public final boolean checkSentMessage(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation conversation) {
        return false;
    }
    
    public final void saveAcknowledgment(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/EncryptionUtils$ReceiverCallback;", "", "returnPayload", "", "decryptedPayload", "Lcom/devbeans/io/chat/models/Payload;", "app_debug"})
    public static abstract interface ReceiverCallback {
        
        public abstract void returnPayload(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.models.Payload decryptedPayload);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/utils/EncryptionUtils$SenderCallback;", "", "returnChannels", "", "channels", "", "Lcom/devbeans/io/chat/models/ConversationChannels;", "app_debug"})
    public static abstract interface SenderCallback {
        
        public abstract void returnChannels(@org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.ConversationChannels> channels);
    }
}