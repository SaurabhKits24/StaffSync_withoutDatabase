/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionExample {

    public static void main(String[] args) {
        // Mocking the selecting object and values (replace with actual retrieval logic)
        String store = "1234";  // Example password to encrypt
        String private_key = "q2L4hm2lNzAaOIWeXtlxsDXS5VOOsSwt6DoW4nQJ2O8=";  // Example Base64 encoded key

        try {
            // Decode the private_key from Base64
            byte[] decodedKey = Base64.getDecoder().decode(private_key);

            // Create a SecretKey from the decoded bytes
            String algorithm = "AES";
            SecretKey originalKey = new SecretKeySpec(decodedKey, algorithm);

            // Assuming you have an aes.encrypt method defined somewhere:
            String encryptedString = aesEncrypt(store, originalKey);
            System.out.println("Original Text: " + store);
            System.out.println("Encrypted Text: " + encryptedString);

        } catch (IllegalArgumentException e) {
            System.err.println("Error decoding private_key: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error encrypting: " + e.getMessage());
        }
    }

    // Mock implementation of AES encryption
    public static String aesEncrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
