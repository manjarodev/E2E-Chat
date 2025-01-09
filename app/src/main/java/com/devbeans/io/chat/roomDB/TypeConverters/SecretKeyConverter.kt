package com.devbeans.io.chat.roomDB.TypeConverters

import androidx.room.TypeConverter
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.models.ChatKeyPair
import com.devbeans.io.chat.models.SecretKey
import com.devbeans.io.chat.utils.HSM
import com.devbeans.io.chat.utils.Stopwatch
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.goterl.lazysodium.exceptions.SodiumException
import com.goterl.lazysodium.utils.Key
import com.goterl.lazysodium.utils.KeyPair
import java.io.IOException
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException

class SecretKeyConverter {

    @TypeConverter
    fun KeyToJson(secretKey: SecretKey?): String? {
        val stopwatch = Stopwatch("Secret Key to JSON")
        stopwatch.split("Secret Key to Json Start")
        if (secretKey == null) return null
        val type = object : TypeToken<SecretKey>() {}.type
        val json = Gson().toJson(secretKey, type)
        stopwatch.split("Secret Key to Json Done")
        val hsm = HSM.with()
        var encryptedString: String? = null
        try {
            stopwatch.split("JSON to Cipher start")
            encryptedString = MainApp.box.cryptoBoxSealEasy(
                json,
                Key.fromBase64String(hsm.secretIdentityKeyPair().pubKey)
            )
            stopwatch.split("JSON to Cipher Done")
        } catch (e: SodiumException) {
            e.printStackTrace()
        } catch (e: CertificateException) {
            e.printStackTrace()
        } catch (e: KeyStoreException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        stopwatch.split("Returtning to DB ")
        stopwatch.stop(Stopwatch.TAG)
        return encryptedString
    }

    @TypeConverter
    fun JsonToKey(encryptedJson: String): SecretKey? {
        val stopwatch = Stopwatch("JSON to Secret Key")
        stopwatch.split("CIPHER to JSON Start")
        val gson = Gson()
        val type = object :
            TypeToken<SecretKey>() {}.type

        val hsm = HSM.with()
        var key: ChatKeyPair? = null
        try {
            key = hsm.secretIdentityKeyPair()
        } catch (e: CertificateException) {
            e.printStackTrace()
        } catch (e: KeyStoreException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        var json: String? = null
        assert(key != null)
        try {

            json = MainApp.box.cryptoBoxSealOpenEasy(
                encryptedJson, KeyPair(
                    Key.fromBase64String(
                        key!!.pubKey
                    ), Key.fromBase64String(key.privKey)
                )
            )
            stopwatch.split("Cipher to JSON Done")
        } catch (e: SodiumException) {
            e.printStackTrace()
        }
        stopwatch.split("JSON to Object Done")
        stopwatch.stop(Stopwatch.TAG)
        return gson.fromJson(json, type)
    }
}