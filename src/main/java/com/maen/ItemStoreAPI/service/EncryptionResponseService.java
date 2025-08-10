package com.maen.ItemStoreAPI.service;

public class EncryptionResponseService {

    private String encryptedText;

    public EncryptionResponseService(String encryptedText) {
        this.encryptedText = encryptedText;
    }

    public String getEncryptedText() {
        return encryptedText;
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
    }
}