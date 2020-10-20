package com.pratyush.productservice;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.apache.logging.log4j.Logger;

@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication
public class ProductServiceApplication {

	private static Logger logger= LogManager.getLogger(ProductServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		logger.info("----> Product Service Application started");
	}

}
