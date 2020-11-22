package ru.mail.migus_nikita.dealerstat.service;

public interface CryptoService {

    String encrypt(String unencryptedString);

    String decrypt(String encryptedString);

}
