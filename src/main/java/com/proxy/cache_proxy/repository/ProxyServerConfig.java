package com.proxy.cache_proxy.repository;

import org.springframework.stereotype.Component;

@Component
public class ProxyServerConfig {

    private int port;
    private String url;

    public void setPort(int port){
        this.port = port;
    }
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }



}
