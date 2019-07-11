package com.hyc.shop.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.hyc.shop.system"})
@EnableAsync(proxyTargetClass = true)
public class SystemServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(SystemServiceMain.class, args);
    }

}
