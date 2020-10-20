package com.pratyush.giftservice;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableResourceServer
public class GiftServiceApplication {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(GiftServiceApplication.class);
		SpringApplication.run(GiftServiceApplication.class, args);
		logger.info("Just Enterd Gift Service");
		SpringApplication.run(GiftServiceApplication.class, args);
	}

}
