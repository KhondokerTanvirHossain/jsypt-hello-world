# Jasypt Hello World

This project demonstrates the use of Jasypt (Java Simplified Encryption) for decrypting properties in a Spring Boot application. It includes a custom `EnvironmentPostProcessor` implementation that automatically decrypts properties prefixed with `ENC(` and suffixed with `)` during the application startup.

## Overview

The `DecryptionEnvironmentPostProcessor` class scans all properties loaded into the Spring `Environment` and decrypts those that are encrypted, allowing for secure storage of sensitive information in property files.

## How It Works

The process involves the following steps:

1. **Scanning Properties**: During the application startup, the `DecryptionEnvironmentPostProcessor` scans all properties in the Spring `Environment`.

2. **Detecting Encrypted Properties**: It identifies properties that are encrypted by looking for a specific prefix (`ENC(`) and suffix (`)`).

3. **Decrypting Properties**: The identified encrypted properties are then decrypted. The decryption logic should be implemented in the `decrypt` method of the `DecryptionEnvironmentPostProcessor` class.

4. **Adding Decrypted Properties**: Finally, the decrypted properties are added to the Spring `Environment`, making them available for use throughout the application.

## Setup

To use this in your project, ensure you have the following:

- A Spring Boot application setup.
- The Jasypt library added to your project dependencies.
- The `DecryptionEnvironmentPostProcessor` class added to your project.

### Registering the Post Processor

For Spring Boot to recognize and use the `DecryptionEnvironmentPostProcessor`, you must register it in the `spring.factories` file located under `src/main/resources/META-INF`:

```properties
org.springframework.boot.env.EnvironmentPostProcessor=com.example.DecryptionEnvironmentPostProcessor
```
Replace com.example.DecryptionEnvironmentPostProcessor with the actual package and class name of your post processor.

### Implementing the Decrypt Method
The decrypt method is a placeholder for your decryption logic. You can use Jasypt or any other library/method to decrypt the property values.

Example Usage
Given a property in your application.properties file like so:
```properties
my.secret.property=ENC(encryptedValue)
```
The DecryptionEnvironmentPostProcessor will automatically decrypt this value and make it available as a regular property.

## Security Note
Ensure that the decryption key is securely managed and not hard-coded or stored alongside the application.

## Conclusion
This project provides a simple yet powerful way to manage encrypted properties in a Spring Boot application, enhancing the security of your application configuration.

