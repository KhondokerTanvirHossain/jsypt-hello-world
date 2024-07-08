package com.tanvir.features;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JsyptEncryptionDecryptionTest {
    private JasyptDecryptor jasyptDecryptor;
    private JasyptEncryptor jasyptEncryptor;

    @BeforeEach
    void setUp() {
        jasyptDecryptor = new JasyptDecryptor();
        jasyptEncryptor = new JasyptEncryptor();
    }

    @Test
    void encryptAndDecryptWithSameKeyShouldReturnOriginalText() {
        JasyptEncryptor jasyptEncryptor = new JasyptEncryptor();
        String plainText = "HelloWorld";
        String key = "SecretKey";
        String encryptedText = jasyptEncryptor.encrypt(plainText, key);

        // Assuming you have a decrypt method in JasyptEncryptor or a corresponding JasyptDecryptor class
        String decryptedText = jasyptDecryptor.decrypt(encryptedText, key); // Adjust this line based on your actual decrypt method

        assertNotEquals(plainText, encryptedText, "Encrypted text should not match the plain text.");
        assertEquals(plainText, decryptedText, "Decrypted text should match the original plain text.");
    }
}
