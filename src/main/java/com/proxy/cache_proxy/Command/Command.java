package com.proxy.cache_proxy.Command;

import org.springframework.boot.SpringApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.proxy.cache_proxy.CacheProxyApplication;
import com.proxy.cache_proxy.repository.ProxyServerConfig;

@ShellComponent
public class Command {

    private ProxyServerConfig proxyserverconfig;

    public Command(ProxyServerConfig config){
        this.proxyserverconfig=config;
    }

    @ShellMethod(key = "cache-proxy" , value="cache-proxy server commands")
    public void Start(@ShellOption (value = "--port") int port, @ShellOption(value = "--origin")String origin){
        System.setProperty("server.port", String.valueOf(port));
        System.out.println("Starting Cache Proxy Application on port: " + port);
        SpringApplication.run(CacheProxyApplication.class); 
        
    }
}
