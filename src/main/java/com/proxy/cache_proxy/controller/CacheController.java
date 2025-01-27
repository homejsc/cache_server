package com.proxy.cache_proxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.proxy.cache_proxy.service.CacheService;

@Component
public class CacheController {

    @Autowired
    private CacheService cacheService;

    public String ClearCache(){
        return cacheService.ClearCache();
    }

    public String ClearProductCache(String url){
        return cacheService.ClearProductCache(url);
    }
    
}
