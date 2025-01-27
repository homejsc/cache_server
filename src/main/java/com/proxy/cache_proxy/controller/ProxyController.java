package com.proxy.cache_proxy.controller;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.proxy.cache_proxy.repository.ProxyServerConfig;
import com.proxy.cache_proxy.service.ProxyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProxyController {
    @Autowired
    private ProxyService service;

    @Autowired
    private CacheController cachecontroller;
    @GetMapping("/products")
    public String products(@RequestParam String url) {

        return service.getproducts(url);
    }

}
