package com.proxy.cache_proxy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Autowired
    private CacheManager cachemanager;

    public String ClearCache(){
        cachemanager.getCacheNames().forEach(cachename-> {
            cachemanager.getCache(cachename).clear();
        });

        return "Cache is cleared";
    }

    public String ClearProductCache(String url){
        cachemanager.getCache(url).clear();
        return "Product Cache is cleared";
    }

    public String get(String cachename ,String url){
        Cache cache= cachemanager.getCache(cachename);
        String cachedData;
        if(cache!=null){
            cachedData = cache.get(url, String.class);
            if(cachedData !=null){
                System.out.println("gg");
                return cachedData;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public void put(String cachename, String url , String data){
        Cache cache = cachemanager.getCache(cachename);
        cache.put(url, data);
    }

}
