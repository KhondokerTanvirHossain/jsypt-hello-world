package com.tanvir.processor;

import org.jasypt.util.text.AES256TextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

//@Slf4j
public class DecryptionEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(DecryptionEnvironmentPostProcessor.class);
    private static final String PREFIX = "ENC(";
    private static final String SUFFIX = ")";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources sources = environment.getPropertySources();
        Map<String, Object> decryptedProperties = new HashMap<>();
        sources.forEach(propertySource -> {
            if (propertySource instanceof MapPropertySource mapPropertySource) {
                for (String propertyName : mapPropertySource.getPropertyNames()) {
                    Object value = mapPropertySource.getProperty(propertyName);
                    if (value instanceof String && ((String) value).startsWith(PREFIX) && ((String) value).endsWith(SUFFIX)) {
                        String encryptedValue = ((String) value).substring(PREFIX.length(), ((String) value).length() - SUFFIX.length());
                        String decryptedValue = decrypt(encryptedValue); // Implement this method
                        decryptedProperties.put(propertyName, decryptedValue);
                    }
                }
            }
        });
        if (!decryptedProperties.isEmpty()) {
            sources.addFirst(new MapPropertySource("decryptedProperties", decryptedProperties));
        }
        System.out.println("JSYPT PROCESSOR | Decrypted properties: " + decryptedProperties);
        logger.info("JSYPT PROCESSOR | Decrypted properties: {}", decryptedProperties);
    }

    private String decrypt(String encryptedValue) {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword("yourEncryptionKey"); // Set the decryption key here
        return textEncryptor.decrypt(encryptedValue);
    }
}
