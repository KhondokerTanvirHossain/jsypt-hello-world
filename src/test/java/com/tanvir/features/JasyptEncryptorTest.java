package com.tanvir.features;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JasyptEncryptorTest {

        private JasyptEncryptor jasyptEncryptor;

        @BeforeEach
        void setUp() {
            jasyptEncryptor = new JasyptEncryptor();
        }

        @Test
        void encryptWithValidKeyShouldReturnNonNullEncryptedText() {
            String plainText = "developer";
            String key = "yourEncryptionKey";
            assertNotNull(jasyptEncryptor.encrypt(plainText, key));
        }

        @Test
        void encryptWithDifferentKeysShouldReturnDifferentEncryptedTexts() {
            String plainText = "HelloWorld";
            String key1 = "SecretKey1";
            String key2 = "SecretKey2";
            String encryptedText1 = jasyptEncryptor.encrypt(plainText, key1);
            String encryptedText2 = jasyptEncryptor.encrypt(plainText, key2);
            assertNotEquals(encryptedText1, encryptedText2);
        }

        @Test
        void encryptWithEmptyStringShouldNotThrowException() {
            assertDoesNotThrow(() -> jasyptEncryptor.encrypt("", "SecretKey"));
        }

        @Test
        void encryptWithNullKeyShouldThrowIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> jasyptEncryptor.encrypt("HelloWorld", null));
        }

        @Test
        void encryptWithNullPlainTextShouldThrowIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> jasyptEncryptor.encrypt(null, "SecretKey"));
        }

}
