package encryption

import java.nio.charset.Charset
import java.util.Base64
import java.util.Scanner
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

fun main() {
    val aesEncryption = AESEncryption()
    val secretKey = aesEncryption.generateEncryptionKey()
    println("Hello please enter the data you want to be encrypted below---")
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine()
    println("do you want to see the encrypted input? Y/N")
    val shouldShowEncryptedData = scanner.nextLine()
    val encryptedData = aesEncryption.encryptData(input, secretKey)
    if (shouldShowEncryptedData == "Y") println(encryptedData)
    val decryptedData = aesEncryption.decryptData(encryptedData, secretKey)
    println("Do you want to see the decrypted data? Y/N")
    val shouldShowDecryptedData = scanner.nextLine()
    if (shouldShowDecryptedData == "Y") println(decryptedData)

}

class AESEncryption {
    private val cipher = Cipher.getInstance(KEY_TYPE)
    fun generateEncryptionKey(): SecretKey {
        val keyGenerator = KeyGenerator.getInstance(KEY_TYPE)
        keyGenerator.init(KEY_SIZE)
        return keyGenerator.generateKey()
    }

    fun encryptData(data: String, secretKey: SecretKey): String {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encryptedData = cipher.doFinal(data.toByteArray(Charset.defaultCharset()))

        return Base64.getEncoder().encodeToString(encryptedData)
    }

    fun decryptData(encryptedData: String, secretKey: SecretKey): String {
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        val encryptedByteArray = Base64.getDecoder().decode(encryptedData)
        val decryptedData = cipher.doFinal(encryptedByteArray)
        return String(decryptedData, Charset.defaultCharset())
    }

    companion object {
        const val KEY_TYPE = "AES"
        const val KEY_SIZE = 256
    }
}



