package com.proxy.cache_proxy.service;

import java.net.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ProxyService {
    

    @Autowired
    private CacheService cacheService;

    @Cacheable (value = "proxycache" , key="#url")
    public ResponseEntity<?> forwareRequest(String url){

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, String.class);
    }

    @Cacheable(value = "proxycache" , key = "#url")
    public String getproducts (String url){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);

        return result.getBody();

    }
}
