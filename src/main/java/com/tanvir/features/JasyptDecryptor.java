package com.tanvir.features;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class JasyptDecryptor {
    public String decrypt(String encryptedText, String key) {
//        String encryptedPassword = "ENC(" + encryptedText + ")";

        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(key);

        // Remove the "ENC()" wrapper around your encrypted password
//        String rawEncryptedPassword = encryptedPassword.substring(4, encryptedPassword.length() - 1);

        String decryptedPassword = textEncryptor.decrypt(encryptedText);

        System.out.println("Decrypted Password: " + decryptedPassword);
        return decryptedPassword;
    }
}
