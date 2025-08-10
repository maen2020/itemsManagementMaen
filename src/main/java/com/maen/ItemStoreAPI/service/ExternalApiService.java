package com.maen.ItemStoreAPI.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {

    private final RestTemplate restTemplate;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getExternalData(){
        String url = "https://pokeapi.co/api/v2/pokemon/ditto";
        return restTemplate.getForObject(url, Object.class);
    }
}
