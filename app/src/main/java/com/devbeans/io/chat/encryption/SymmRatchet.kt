package com.devbeans.io.chat.encryption

import com.devbeans.io.chat.utils.EncryptionUtils.getEncodedString
import com.devbeans.io.chat.utils.EncryptionUtils.hkdf
import com.devbeans.io.chat.utils.Stopwatch

class SymmRatchet(
    key: ByteArray, ratchet_name: String = ""
) {
    var chain_key: ByteArray
    var ratchet_name: String
    var chain_index: Int

    init {
        this@SymmRatchet.chain_key = key
        this@SymmRatchet.ratchet_name = ratchet_name
        this@SymmRatchet.chain_index = 0
    }

    fun nextKey(inp: String = ""): Pair<ByteArray, ByteArray> {
        val stopwatch=Stopwatch("Getting Next Key")
        stopwatch.split("Getting next key start")
        var output = hkdf(getEncodedString(chain_key) + inp, 88)
        chain_key = output.sliceArray(0..31)
        val (message_key, iv) = Pair(output.sliceArray(32..63), output.sliceArray(64..87))
        this@SymmRatchet.chain_index += 1
        output = "".toByteArray()
        stopwatch.split("Getting next key done")
        stopwatch.stop(Stopwatch.TAG)
        return Pair(message_key, iv)
    }

    fun emptyKey(): Pair<ByteArray, ByteArray> {

        return Pair("".toByteArray(), "".toByteArray())
    }
}