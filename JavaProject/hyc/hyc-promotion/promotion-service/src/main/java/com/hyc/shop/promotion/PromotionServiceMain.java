package com.hyc.shop.promotion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.hyc.shop.promotion"})
@EnableAsync(proxyTargetClass = true)
public class PromotionServiceMain {

	public static void main(String[] args) {
	    SpringApplication.run(PromotionServiceMain.class, args);
	}

}
