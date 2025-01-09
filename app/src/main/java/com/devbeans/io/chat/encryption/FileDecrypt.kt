package com.devbeans.io.chat.encryption

import android.os.Build
import androidx.annotation.RequiresApi
import com.devbeans.io.chat.crypto.encryptor.EncryptorAesGcmPasswordFile
import com.devbeans.io.chat.utils.EncryptionUtils
import com.devbeans.io.chat.utils.logging.Log
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class FileDecrypt {

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(java.lang.Exception::class)
     fun decryptFile(fromFile: String, avRatchetKeyMaterial: String): Boolean {

        var isDecrypted = false
        try {       // read a normal txt file
            val fileEncryptedContent: ByteArray =
                Files.readAllBytes(Paths.get(File(fromFile).toURI()))

            val password: javax.crypto.SecretKey =
                EncryptionUtils.getSecretKey(avRatchetKeyMaterial)!!
            val filesDecrypt = EncryptorAesGcmPasswordFile()
            val encryptedText = EncryptorAesGcmPasswordFile.decryptFile(fromFile, password)


            // save a file
            val path: Path = Paths.get(fromFile)

            Files.write(path, encryptedText)

            isDecrypted = true
        } catch (e: Exception) {
            isDecrypted = false
            Log.e(
                EncryptionUtils.TAG,
                "Error in Decrypting a file ${e.message} error trace ${e.printStackTrace()}"
            )

        }

        return isDecrypted
    }

}