package com.devbeans.io.chat.utils

import android.util.Log
import com.devbeans.io.chat.app.MainApp
import com.virgilsecurity.sdk.crypto.VirgilCrypto
import com.virgilsecurity.sdk.utils.ConvertionUtils
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

object EncryptionChange {

//    @RequiresApi(Build.VERSION_CODES.O)
//    fun PublicDecrypt(byte: ByteArray, identifier: ByteArray): String? {
//        val hsm = HSM.with()
//        return try {
//
//            val crypto = VirgilCrypto()
//
//            val generated = Objects.requireNonNull(MainApp.database!!.GeneratedDao())!!.allKeys
////            val generaterKeyModel =MainApp.database!!.GeneratedDao()!!.getKeys(identifier)
//            val generaterKeyModel = hsm.secretKey(Base64.getEncoder().encodeToString(identifier))
//            val privateKey = android.util.Base64.decode(
//                generaterKeyModel,
//                android.util.Base64.DEFAULT
//            )
//            val keyPair = crypto.importPrivateKey(privateKey)
//            val decrypted = crypto.decrypt(byte, keyPair.privateKey)
//            Arrays.toString(decrypted)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            try {
//                val crypto = VirgilCrypto()
//                val generated = Objects.requireNonNull(MainApp.database!!.GeneratedDao())!!.allKeys
////                val generaterKeyModel = MainApp.database!!.GeneratedDao()!!.getKeys(identifier)
//                val generaterKeyModel = hsm.secretKey(Base64.getEncoder().encodeToString(identifier))
//                val privateKey = android.util.Base64.decode(
//                    generaterKeyModel,
//                    android.util.Base64.DEFAULT
//                )
//                val keyPair = crypto.importPrivateKey(privateKey)
////                val keyPair = crypto.importPrivateKey(generaterKeyModel.privateKeyByte)
//                val decrypted = crypto.decrypt(byte, keyPair.privateKey)
//                ConvertionUtils.toString(decrypted)
//            } catch (e: Exception) {
//                e.printStackTrace()
//                null
//            }
//
//        }
//
//    }


    fun publicDecrypt(byte: ByteArray, id: Int): String? {
        return try {
            val crypto = VirgilCrypto()
            val keyModel = MainApp.database!!.GeneratedDao()!!.getKeyID(id)

            val keyPair = crypto.importPrivateKey(keyModel.privateKeyByte)
            val decrypted = crypto.decrypt(byte, keyPair.privateKey)
            ConvertionUtils.toString(decrypted)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun readLog(path: String?): String? {
        val text = java.lang.StringBuilder()
        try {
            val br = BufferedReader(FileReader(path))
            var line: String?
            while (br.readLine().also { line = it } != null) {
                text.append(line)
                text.append('\n')
            }
            br.close()
        } catch (e: IOException) {
            //You'll need to add proper error handling here
            Log.e("uuuu", "readLog: ", e)
        }
        return text.toString()
    }
}