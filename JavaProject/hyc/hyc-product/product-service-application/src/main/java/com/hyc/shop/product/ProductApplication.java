package com.hyc.shop.product;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.hyc.shop.product"})
@EnableAsync(proxyTargetClass = true)
@EnableDubboConfiguration
public class ProductApplication {

	public static void main(String[] args) {
	    SpringApplication.run(ProductApplication.class, args);
	}

}
