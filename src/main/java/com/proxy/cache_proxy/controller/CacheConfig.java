package com.proxy.cache_proxy.controller;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proxy.cache_proxy.service.CustomCacheManager;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new CustomCacheManager(new ConcurrentMapCacheManager());
    }
}
