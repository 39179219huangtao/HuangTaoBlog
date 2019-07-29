package com.hyc.shop.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.hyc.shop.pay"})
@EnableAsync(proxyTargetClass = true)
public class PayApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(PayApplicationMain.class, args);
    }

}
