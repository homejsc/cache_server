package com.proxy.cache_proxy.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

public class CustomCache implements Cache {
    private final Cache delegate;
    private final String name;

    private Logger logger = LoggerFactory.getLogger(CustomCacheManager.class);
    private final ConcurrentHashMap<String, Integer> hits = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> misses = new ConcurrentHashMap<>();


    public CustomCache(Cache delegate, String name) {
        this.delegate = delegate;
        this.name = name;
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public Object getNativeCache() {
        return delegate.getNativeCache();
    }

    @Override
    public ValueWrapper get(Object key) {
        ValueWrapper value = delegate.get(key);
        if (value != null) {
            System.out.println("Cache hit!!");
            logger.info("Cache Hit-Data fetched from the cache");
            hits.merge(name, 1, Integer::sum);
        } else {
            System.out.println("Cache miss!!");
            logger.info("Cache miss - Data fetched from the API");
            misses.merge(name, 1, Integer::sum);
        }
        return value;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        ValueWrapper wrapper = get(key);
        return wrapper == null ? null : (T) wrapper.get();
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return delegate.get(key, valueLoader);
    }

    @Override
    public void put(Object key, Object value) {
        delegate.put(key, value);
    }

    @Override
    public void evict(Object key) {
        delegate.evict(key);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    
    public int getCacheHits(String cacheName) {
        return hits.getOrDefault(cacheName, 0);
    }

    public int getCacheMisses(String cacheName) {
        return misses.getOrDefault(cacheName, 0);
    }
}