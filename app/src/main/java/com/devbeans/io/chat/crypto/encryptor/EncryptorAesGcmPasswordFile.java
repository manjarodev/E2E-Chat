package com.devbeans.io.chat.crypto.encryptor;


import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.devbeans.io.chat.crypto.utils.CryptoUtils;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class EncryptorAesGcmPasswordFile {

    public static final String TAG = EncryptorAesGcmPasswordFile.class.getSimpleName();
    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128; // must be one of {128, 120, 112, 104, 96}
    private static final int IV_LENGTH_BYTE = 12;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    //    public static byte[] encrypt(byte[] pText, String password) throws Exception {
    public static byte[] encrypt(byte[] pText, SecretKey secretKey) throws Exception {

        // 16 bytes salt
        byte[] salt = CryptoUtils.getRandomNonce(SALT_LENGTH_BYTE);

        // GCM recommended 12 bytes iv?
        byte[] iv = CryptoUtils.getRandomNonce(IV_LENGTH_BYTE);

        // secret key from password
//        SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(), salt);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

        // ASE-GCM needs GCMParameterSpec
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

        byte[] cipherText = cipher.doFinal(pText);

        // prefix IV and Salt to cipher text
        byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length)
                .put(iv)
                .put(salt)
                .put(cipherText)
                .array();

        return cipherTextWithIvSalt;

    }

    // we need the same password, salt and iv to decrypt it
    private static byte[] decrypt(byte[] cText, SecretKey password) throws Exception {

        // get back the iv and salt that was prefixed in the cipher text
        ByteBuffer bb = ByteBuffer.wrap(cText);

        byte[] iv = new byte[12];
        bb.get(iv);

        byte[] salt = new byte[16];
        bb.get(salt);

        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);

        // get back the aes key from the same password and salt
//        SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(), salt);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

        cipher.init(Cipher.DECRYPT_MODE, password, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

        byte[] plainText = cipher.doFinal(cipherText);

        return plainText;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
//    public static void encryptFile(String fromFile, String toFile, String password) throws Exception {
    public static void encryptFile(String fromFile, String toFile, SecretKey password) throws Exception {

        // read a normal txt file
        byte[] fileContent = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(fromFile).toURI()));

        // encrypt with a password
        byte[] encryptedText = EncryptorAesGcmPasswordFile.encrypt(fileContent, password);

        // save a file
        Path path = Paths.get(toFile);

        Path output = Files.write(path, encryptedText);

        Log.e(TAG, "encryptFile: " + output.toFile().getAbsolutePath());

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
//    public static byte[] decryptFile(String fromEncryptedFile, String password) throws Exception {
    public static byte[] decryptFile(String fromEncryptedFile, SecretKey secretKey) throws Exception {

        // read a file
        byte[] fileContent = Files.readAllBytes(Paths.get(fromEncryptedFile));

        return EncryptorAesGcmPasswordFile.decrypt(fileContent, secretKey);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws Exception {

        String password = "password123";
        String fromFile = "readme.txt"; // from resources folder
        String toFile = "c:\\test\\readme.encrypted.txt";

        // encrypt file
        //EncryptorAesGcmPasswordFile.encryptFile(fromFile, toFile, password);

        // decrypt file
//        byte[] decryptedText = EncryptorAesGcmPasswordFile.decryptFile(toFile, password);
//        String pText = new String(decryptedText, UTF_8);
//        System.out.println(pText);

    }

}
