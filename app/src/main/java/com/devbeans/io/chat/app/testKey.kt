package com.devbeans.io.chat.app

import android.content.Context
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.annotation.RequiresApi
import kotlinx.coroutines.DelicateCoroutinesApi
import java.security.*
import java.util.*
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey


@DelicateCoroutinesApi
object testKey {

    @RequiresApi(Build.VERSION_CODES.P)
    fun loadSecureKey(context:Context): SecretKey? {
//        GlobalScope.launch {
//            context?.let { it1 ->
////            val abc =KeyGenParameterSpec.Builder(string, KeyProperties.PURPOSE_ENCRYPT).build()
//                val mainKey = MasterKey.Builder(it1)
////                    .setKeyGenParameterSpec(abc)
//                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
//                    .setRequestStrongBoxBacked(true)
//                    .build()
//
//             val abca=   mainKey.toString()
//                Log.e("error", abca)
////                checkObserver.returnKeyValue(mainKey.)
//
//            }
//        }

//        if (getOLDKey()!= null){
//            return getOLDKey()
//        }else {
            val kgen: KeyGenerator = KeyGenerator.getInstance("AES")
            kgen.init(128)
            val keyGenerator = KeyGenerator
                .getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");

            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                "id_key",
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setIsStrongBoxBacked(true)
                .build()

            keyGenerator.init(keyGenParameterSpec);
            val secretKey = keyGenerator.generateKey();
            return secretKey
//        }

    }

    fun getOLDKey():SecretKey{
      val  keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);

        val secretKeyEntry = keyStore
            .getEntry("id_key", null) as KeyStore.SecretKeyEntry

        val secretKey = secretKeyEntry.secretKey
        return secretKey
    }

    interface  CallBackKey{
        fun returnKeyValue(value:String)
    }
}