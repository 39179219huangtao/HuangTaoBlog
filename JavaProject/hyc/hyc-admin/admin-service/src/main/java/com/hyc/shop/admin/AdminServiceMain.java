/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.hyc.shop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@ServletComponentScan
public class AdminServiceMain {


    public static void main(String[] args) throws IOException {
        //pid 方便 用kill关闭
        String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        FileWriter writer = new FileWriter(new File("main.pid"));
        writer.write(name);
        writer.close();

        System.out.println("=================>taurus-admin-service is starting");
        SpringApplication.run(AdminServiceMain.class);
    }


}
