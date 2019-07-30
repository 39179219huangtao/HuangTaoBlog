package com.hyc.shop.promotion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hyc.shop"})
public class PromotionApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(PromotionApplicationMain.class, args);
    }

}
