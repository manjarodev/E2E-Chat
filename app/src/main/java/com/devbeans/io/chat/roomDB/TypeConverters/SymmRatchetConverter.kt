package com.devbeans.io.chat.roomDB.TypeConverters

import androidx.room.TypeConverter
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.encryption.SymmRatchet
import com.devbeans.io.chat.models.ChatKeyPair
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

class SymmRatchetConverter {
    @TypeConverter
    fun RachetToJson(ratchet: SymmRatchet?): String? {
        val stopwatch = Stopwatch("RachetToJson")
        stopwatch.split("object to string start")
        if (ratchet == null) return null
        val type = object : TypeToken<SymmRatchet?>() {}.type

        val json = Gson().toJson(ratchet, type)
        stopwatch.split("object to string done")
        val hsm = HSM.with()
        var encryptedString: String? = null
        try {
            stopwatch.split("string to cipher start")
            encryptedString = MainApp.box.cryptoBoxSealEasy(
                json,
                Key.fromBase64String(hsm.secretIdentityKeyPair().pubKey)
            )
            stopwatch.split("string to cipher done")
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
        stopwatch.stop(Stopwatch.TAG)
        return encryptedString
    }

    @TypeConverter
    fun JsonToRacthet(encryptedJson: String?): SymmRatchet? {
        val stopwatch = Stopwatch("JsonToRacthet")
        stopwatch.split("cipher to string start")
        val gson = Gson()
        val type = object :
            TypeToken<SymmRatchet?>() {}.type

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
            stopwatch.split("cipher to string done")
        } catch (e: SodiumException) {
            e.printStackTrace()
        }

        stopwatch.split("string to object done")
        stopwatch.stop(Stopwatch.TAG)
        return gson.fromJson(json, type)
    }
}