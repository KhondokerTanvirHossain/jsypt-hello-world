package com.tanvir.features;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class JasyptEncryptor {

    public String encrypt(String plainText, String key) {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(key); // Set your encryption key here
        String myEncryptedPassword = textEncryptor.encrypt(plainText);
        System.out.println("Encrypted data: " + myEncryptedPassword);
        return myEncryptedPassword;
    }
}
