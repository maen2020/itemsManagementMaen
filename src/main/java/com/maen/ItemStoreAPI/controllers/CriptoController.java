package com.maen.ItemStoreAPI.controllers;

import com.maen.ItemStoreAPI.service.AESService;
import com.maen.ItemStoreAPI.service.EncryptionResponseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CriptoController {

    private final AESService aesService;

    public CriptoController(AESService aesService) {
        this.aesService = aesService;
    }

    @GetMapping("/encrypt")
    public EncryptionResponseService getEncryptionResponseService(String text) {
        String response = aesService.encrypted(text);
        return new EncryptionResponseService(response);
    }
}