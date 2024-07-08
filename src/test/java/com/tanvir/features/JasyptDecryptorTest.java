package com.tanvir.features;

import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JasyptDecryptorTest {

    private JasyptDecryptor jasyptDecryptor;

    @BeforeEach
    void setUp() {
        jasyptDecryptor = new JasyptDecryptor();
    }

    @Test
    void decryptWithValidKeyShouldReturnOriginalText() {
        // Assuming "encryptedText" is the result of encrypting "originalText" with "validKey" using the same encryption method
        String originalText = "developer";
        String validKey = "yourEncryptionKey";
        String encryptedText = "u59W/OomqpzMRq7F7GLo2XWXgqOxKIjoiOTVrBUn4T4X8+kdBf9u0lDccwnQYbQq"; // This should be an actual encrypted text for a real test
        assertEquals(originalText, jasyptDecryptor.decrypt(encryptedText, validKey));
    }

    @Test
    void decryptWithInvalidKeyShouldThrowEncryptionOperationNotPossibleException() {
        String invalidKey = "WrongKey";
        String encryptedText = "u59W/OomqpzMRq7F7GLo2XWXgqOxKIjoiOTVrBUn4T4X8+kdBf9u0lDccwnQYbQq";
        assertThrows(EncryptionOperationNotPossibleException.class, () -> jasyptDecryptor.decrypt(encryptedText, invalidKey));
    }

    @Test
    void decryptWithNullKeyShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> jasyptDecryptor.decrypt("EncryptedText", null));
    }
}
