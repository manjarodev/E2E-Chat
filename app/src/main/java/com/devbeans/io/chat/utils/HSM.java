package com.devbeans.io.chat.utils;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import com.devbeans.io.chat.app.AppSession;
import com.devbeans.io.chat.encryption.KeyStoreHelper;
import com.devbeans.io.chat.models.ChatKeyPair;
import com.devbeans.io.chat.utils.logging.Log;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.NoSuchPaddingException;

@Keep
public class HSM {

    public static final String TAG = HSM.class.getSimpleName();
    private static HSM INSTANCE = null;


    public HSM() {
        // was essential to over ride


    }

    public static HSM with() {
        if (INSTANCE == null) {
            INSTANCE = new HSM();
        }
        return INSTANCE;
    }


    public ChatKeyPair secretKeyPair(String fingerPrintIdentifier) {
        String serializedEncryptedSecret = AppSession.get(fingerPrintIdentifier, "");
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.SealedData.fromString(serializedEncryptedSecret);
        return fromString(new String(KeyStoreHelper.unseal(encryptedSecret)));
    }


    public ChatKeyPair secretIdentityKeyPair() {
        String serializedEncryptedSecret = AppSession.get("IK", "");
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.SealedData.fromString(serializedEncryptedSecret);
        return fromString(new String(KeyStoreHelper.unseal(encryptedSecret)));
    }


    public void storeIdentityKey(ChatKeyPair secretKey) throws IOException {
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.seal(JsonUtils.toJson(secretKey).getBytes());
        AppSession.put("IK", encryptedSecret.serialize());
    }

    public void storeServerIdentityKey(ChatKeyPair secretKey) throws InvalidAlgorithmParameterException, NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IOException {
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.seal(JsonUtils.toJson(secretKey).getBytes());
        AppSession.put("SIK", encryptedSecret.serialize());
    }


    public void storeX25519ServerIdentityKey(ChatKeyPair secretKey) throws IOException {
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.seal(JsonUtils.toJson(secretKey).getBytes());
        AppSession.put("x25519SIK", encryptedSecret.serialize());
    }

    public void storeMQTTKey(String secretKey) throws IOException {
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.seal(secretKey.getBytes());
        AppSession.put("mqttKey", encryptedSecret.serialize());
    }


    public String getStoreMQTTKey() {
        String serializedEncryptedSecret = AppSession.get("mqttKey", "");
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.SealedData.fromString(serializedEncryptedSecret);
        return new String(KeyStoreHelper.unseal(encryptedSecret));
    }

    public ChatKeyPair secretServerIdentityKeyPair() {
        String serializedEncryptedSecret = AppSession.get("SIK", "");
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.SealedData.fromString(serializedEncryptedSecret);
        return fromString(new String(KeyStoreHelper.unseal(encryptedSecret)));
    }


    public ChatKeyPair secretX25519ServerIdentityKeyPair() {
        String serializedEncryptedSecret = AppSession.get("x25519SIK", "");
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.SealedData.fromString(serializedEncryptedSecret);
        return fromString(new String(KeyStoreHelper.unseal(encryptedSecret)));
    }

    public void storeKey(ChatKeyPair secretKey, String fingerPrint) throws IOException {
        KeyStoreHelper.SealedData encryptedSecret = KeyStoreHelper.seal(JsonUtils.toJson(secretKey).getBytes());
        AppSession.put(fingerPrint, encryptedSecret.serialize());
    }

    ChatKeyPair fromString(@NonNull String value) {
        try {
            return JsonUtils.fromJson(value, ChatKeyPair.class);
        } catch (IOException e) {
//            throw new AssertionError(e);
            Log.e(TAG, "Exception " + e.getMessage());
            return null;
        }
    }

}
