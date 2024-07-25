/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author Dell
 */
public class shadata {
    
    public static void main(String[] args) throws Exception {
      String store = "1234";  // Example password to encrypt
        String private_key = "q2L4hm2lNzAaOIWeXtlxsDXS5VOOsSwt6DoW4nQJ2O8=";  // Example Base64 encoded key

 byte[] decodedKey = Base64.getDecoder().decode(private_key);

            // Create a SecretKey from the decoded bytes
            String algorithm = "AES";
            SecretKey originalKey = new SecretKeySpec(decodedKey, algorithm);

     /*   // Encrypt
        String encryptedString = encrypt(originalString, secretKey);
        System.out.println("Encrypted: " + encryptedString);

        // Decrypt
        String decryptedString = decrypt(encryptedString, secretKey);
        System.out.println("Decrypted: " + decryptedString);*/
        //verify
          String verifyString = aesEncrypt(store, originalKey);
        System.out.println("Decrypted: " + verifyString);
        System.out.println("Original Text: " + store);
            System.out.println("Encrypted Text: " + verifyString);

    }

  public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // AES key size can be 128, 192, or 256 bits
        return keyGenerator.generateKey();
    }

    public static String encrypt(String strToEncrypt, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String strToDecrypt, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
        return new String(decryptedBytes);
    }
        public static String aesEncrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
