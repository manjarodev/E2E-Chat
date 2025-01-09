package com.devbeans.io.chat.encryption;

import android.util.Log;

import com.devbeans.io.chat.utils.ArgonHash;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    public static final int AES_KEY_SIZE = 256;
    public static final int GCM_IV_LENGTH = 12;
    public static final int GCM_TAG_LENGTH = 16;
    public static final String TAG = AES.class.getSimpleName();
    private static final String transmission = "AES/GCM/NoPadding";
    static String plainText = "This is a plain text which need to be encrypted by Java AES 256 GCM Encryption Algorithm";
    private static byte[] encodedBytes;
    private static byte[] decodedBytes;
//    private static final String algo = "PBKDF2WithHmacSHA1";

    public static byte[] encrypt(byte[] plaintext, String key, String IV) throws Exception {
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance(transmission);

        //todo:: start
        //Generate Argon2 Hash
        String hash = ArgonHash.generateHash(key, IV);

        PBEKeySpec spec = new PBEKeySpec(hash.toCharArray(), IV.getBytes(), 1000, AES.AES_KEY_SIZE);
        SecretKey secKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(spec);
        //todo:: end

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(secKey.getEncoded(), "AES");

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV.getBytes(StandardCharsets.UTF_8));

        // Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext);

        return cipherText;
    }

    public static String decrypt(byte[] cipherText, String key, String IV) throws Exception {
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance(transmission);

        //todo:: start
        //Generate Argon2 Hash
        String hash = ArgonHash.generateHash(key, IV);
        PBEKeySpec spec = new PBEKeySpec(hash.toCharArray(), IV.getBytes(), 1000, AES.AES_KEY_SIZE);
        SecretKey secKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(spec);
        //todo:: end

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(secKey.getEncoded(), "AES");

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV.getBytes(StandardCharsets.UTF_8));

        // Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Decryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);
    }


    /**
     * encrypt plain text with AES GCM-256 with IV in bytes
     *
     * @param plaintext
     * @param key
     * @param IV
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] plaintext, SecretKey key, byte[] IV) throws Exception {
        Cipher cipher = Cipher.getInstance(transmission);
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
        return cipher.doFinal(plaintext);
    }


    //    public static byte[] encrypt(byte[] fileData, SecretKey key) throws Exception {
    public static byte[] encrypt(String sourcePath, SecretKey key) {
//        Executor executors = Executors.newSingleThreadExecutor();
//        executors.execute(() -> { }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
            Log.e(TAG, "encryptKeyHSM: " + encodedKey);
        }

        try {

            byte[] fileData = FileUtils.readFile(sourcePath);
            Cipher cipher = Cipher.getInstance(transmission);
            SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, "Constants.argonSalt".getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
            encodedBytes = cipher.doFinal(fileData);

        } catch (Exception e) {
            Log.e(TAG, "encrypt: " + e);
            encodedBytes = null;
        }
        return encodedBytes;
    }

    /**
     * decrypt cipher text with AES GCM-256 with IV in bytes
     *
     * @param cipherText
     * @param key
     * @param IV
     * @return
     * @throws Exception
     */
    public static String decrypt(byte[] cipherText, SecretKey key, byte[] IV) throws Exception {
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance(transmission);

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);

        // Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Decryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);
    }

    //    public static byte[] decrypt(byte[] cipherText, SecretKey key) throws Exception {
    public static byte[] decrypt(String sourcePath, SecretKey key) {
//        Executor executors = Executors.newSingleThreadExecutor();
//        executors.execute(() -> {
        try {

            byte[] fileData = FileUtils.readFile(sourcePath);
            Cipher cipher = Cipher.getInstance(transmission);
            SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, "Constants.argonSalt".getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
            decodedBytes = cipher.doFinal(fileData);

        } catch (Exception e) {
            decodedBytes = null;
            Log.e(TAG, "decrypt: " + e);
        }

//        });
        return decodedBytes;
    }




}
