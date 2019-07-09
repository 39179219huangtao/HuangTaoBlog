package com.hyc.shop.product.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.hyc.shop.product"})
@EnableAsync(proxyTargetClass = true)
public class ProductApplicationWeb {

	public static void main(String[] args) {
	    SpringApplication.run(ProductApplicationWeb.class, args);
	}

}
