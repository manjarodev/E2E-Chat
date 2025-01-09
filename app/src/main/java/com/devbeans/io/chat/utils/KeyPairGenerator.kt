package com.devbeans.io.chat.utils

import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.box
import com.devbeans.io.chat.app.MainApp.Companion.ls
import com.devbeans.io.chat.encryption.EK
import com.devbeans.io.chat.encryption.KeyExchange
import com.devbeans.io.chat.encryption.SecretEk
import com.devbeans.io.chat.extensions.EkDao
import com.devbeans.io.chat.models.ChatKeyPair
import com.devbeans.io.chat.models.KeyPairModel
import com.devbeans.io.chat.utils.EncryptionUtils.getEncodedString
import com.devbeans.io.chat.utils.logging.Log
import com.goterl.lazysodium.utils.Key
import com.goterl.lazysodium.utils.KeyPair
import com.virgilsecurity.sdk.crypto.VirgilCrypto
import com.virgilsecurity.sdk.crypto.VirgilKeyPair
import java.security.InvalidAlgorithmParameterException
import java.security.NoSuchAlgorithmException
import kotlin.system.measureTimeMillis


class KeyPairGenerator {


    var arrayList = ArrayList<KeyPairModel>()
    val keyPairList = ArrayList<ChatKeyPair>()
    var crypto = VirgilCrypto()
    val TAG = Log.tag(KeyPairGenerator::class.java)


    //This generates only EK
    fun generateKeys(keysGenerated: keysGenerated) {
        var keys: VirgilKeyPair?
        var identifier: ByteArray?
        var key_identifier: String?
        val time = measureTimeMillis {
            for (i in 0 until 100) {
                try {
                    val keyPair = generateKeyPairs()
                    keyPair?.let {
                        keyPairList.add(keyPair)
                    }


                } catch (e: InvalidAlgorithmParameterException) {
                    e.printStackTrace()
                } catch (e: NoSuchAlgorithmException) {
                    e.printStackTrace()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
            if (keyPairList.size > 99) {
                keysGenerated.onKeysGenerated()
            }
        }
        Log.e("Time", "Time after key Generation $time")
    }


    fun generateKeyPairs(): ChatKeyPair? {
        try {
            val key = ls.cryptoSignKeypair()
            val keyIdentifier = Utills.getRandomString(128)
            return ChatKeyPair(
                getEncodedString(key.secretKey.asBytes),
                getEncodedString(key.publicKey.asBytes),
                keyIdentifier
            )

        } catch (e: InvalidAlgorithmParameterException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun convertCurveToX25519(key: ChatKeyPair): ChatKeyPair? {
        return try {
            val x25519KeyPair = ls.convertKeyPairEd25519ToCurve25519(
                KeyPair(
                    Key.fromBase64String(key.pubKey), Key.fromBase64String(key.privKey)
                )
            )
            ChatKeyPair(
                identifier = key.identifier,
                privKey = getEncodedString(x25519KeyPair.secretKey.asBytes),
                pubKey = getEncodedString(x25519KeyPair.publicKey.asBytes)
            )
        } catch (e: Exception) {
            Log.e(TAG, "Exception in converting Curve to E25519 Exception: ${e.printStackTrace()}")
            null
        }
    }


    //will contain generated fruits
    fun getAllKeys(): ArrayList<KeyPairModel> {
        return arrayList
    }

    fun getChatKeyList(): ArrayList<ChatKeyPair> {
        return keyPairList
    }

    fun generateKeyPair(channelIdentifier: String): ChatKeyPair {
        val key = box.cryptoBoxKeypair()
        val keypair = ChatKeyPair(
            privKey = getEncodedString(key.secretKey.asBytes),
            pubKey = getEncodedString(key.publicKey.asBytes),
            identifier = Utills.getRandomString(128),
        )
        val ek = EK(keypair.identifier)
        ek.pubKey = keypair.pubKey
        ek.privKey = keypair.privKey

        val secreteEk =
            SecretEk(ek.identifier, ek = ek, channel_identifier = channelIdentifier, type = "EK")
        MainApp.appContext!!.EkDao.insert(secreteEk)
        return keypair
    }

    fun generateDHNextKeyPair(channelIdentifier: String): EK {
        val key = box.cryptoBoxKeypair()
        val keypair = ChatKeyPair(
            privKey = getEncodedString(key.secretKey.asBytes),
            pubKey = getEncodedString(key.publicKey.asBytes),
            identifier = Utills.getRandomString(128),
        )
        val ek = EK(keypair.identifier)
        ek.pubKey = keypair.pubKey
        ek.privKey = keypair.privKey

        val secreteEk =
            SecretEk(ek.identifier, ek = ek, channel_identifier = channelIdentifier, type = "DH")
        MainApp.appContext!!.EkDao.insert(secreteEk)
        return ek
    }

    fun getAVSecretKey(): String {
        val key = box.cryptoBoxKeypair()
        val secretKey = KeyExchange.exchange(
            getEncodedString(key.secretKey.asBytes),
            getEncodedString(key.publicKey.asBytes)
        )
        return getEncodedString(secretKey)
    }


    interface keysGenerated {
        fun onKeysGenerated()
    }

    interface sikGenerated {
        fun onSikGenerated()
    }
}