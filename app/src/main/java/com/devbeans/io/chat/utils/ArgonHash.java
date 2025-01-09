package com.devbeans.io.chat.utils;

import com.lambdapioneer.argon2kt.Argon2Kt;
import com.lambdapioneer.argon2kt.Argon2KtResult;
import com.lambdapioneer.argon2kt.Argon2Mode;

public class ArgonHash {

    public static final String TAG = ArgonHash.class.getSimpleName();

    public static String generateHash(String password, String salt) {
        Argon2Kt argon2Kt = new Argon2Kt();
        Argon2KtResult hashResult = argon2Kt.hash(Argon2Mode.ARGON2_I, password.getBytes(), salt.getBytes());
        String encodedOutput = hashResult.encodedOutputAsString();
        boolean verificationResult = argon2Kt.verify(Argon2Mode.ARGON2_I, encodedOutput, password.getBytes());
        if (verificationResult) {
            return encodedOutput.split("p=")[1];
        } else {
            return "";
        }
    }

}
