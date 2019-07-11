/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.hyc.shop.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

@SpringBootApplication(scanBasePackages = {"com.hyc.shop.pay"})
@EnableAsync(proxyTargetClass = true)
public class PayServiceMain {


    public static void main(String[] args) throws IOException {
        //pid 方便 用kill关闭
        String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        FileWriter writer = new FileWriter(new File("main.pid"));
        writer.write(name);
        writer.close();

        System.out.println("=================>PayServiceMain is starting");
        SpringApplication.run(PayServiceMain.class);
    }


}
