package com.maen.ItemStoreAPI.controllers;

import com.maen.ItemStoreAPI.service.ExternalApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/external")
public class ExternalApiController {

    private final ExternalApiService externalApiService;

    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/data")
    public ResponseEntity<Object> getExternalData() {
        Object data = externalApiService.getExternalData();
        return ResponseEntity.ok(data);
    }
}