package com.proxy.cache_proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.proxy.cache_proxy.repository.ProxyServerConfig;
import com.proxy.cache_proxy.service.ProxyService;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
public class CacheProxyApplication {
		public static void main(String[] args) {
			ConfigurableApplicationContext context=SpringApplication.run(CacheProxyApplication.class, args);
			ProxyServerConfig config = context.getBean(ProxyServerConfig.class);
			ProxyService proxyservice = context.getBean(ProxyService.class);

			System.out.println(proxyservice.forwareRequest(config.getUrl()).getBody());
	}
}
