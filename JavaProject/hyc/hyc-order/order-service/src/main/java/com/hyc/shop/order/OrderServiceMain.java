package com.hyc.shop.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.hyc.shop"})
@EnableAsync(proxyTargetClass = true)
public class OrderServiceMain {

	public static void main(String[] args) {
	    SpringApplication.run(OrderServiceMain.class, args);
	}

}
