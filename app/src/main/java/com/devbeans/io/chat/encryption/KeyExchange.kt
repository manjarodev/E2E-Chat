package com.devbeans.io.chat.encryption

import com.goterl.lazysodium.LazySodiumAndroid
import com.goterl.lazysodium.SodiumAndroid
import com.goterl.lazysodium.interfaces.DiffieHellman
import com.goterl.lazysodium.utils.Key

object KeyExchange {
    private val TAG = KeyExchange::class.java.simpleName
    private val ls = LazySodiumAndroid(SodiumAndroid())
    private val dh = ls as DiffieHellman.Lazy


    @Throws
    fun exchange(priv: String, pub: String): ByteArray {
        // Create the shared secret:
        val secretKey = Key.fromBase64String(priv)
        val publicKey = Key.fromBase64String(pub)

        val sharedKey = dh.cryptoScalarMult(secretKey, publicKey)

        return sharedKey.asBytes
    }

}