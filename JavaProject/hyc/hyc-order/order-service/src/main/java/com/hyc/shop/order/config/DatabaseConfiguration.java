package com.hyc.shop.order.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.proxy.jdbc.DataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.hyc.shop.order.domain.dao") // 扫描对应的 Mapper 接口
@EnableTransactionManagement(proxyTargetClass = true) // 启动事务管理。为什么使用 proxyTargetClass 参数，参见 https://blog.csdn.net/huang_550/article/details/76492600
public class DatabaseConfiguration {

    @Value("${spring.application.name}")
    private String applicationId;
    @Value("${seata.tx-service-group}")
    private String txServiceGroup;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }


//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//
//        return new DataSourceTransactionManager(dataSource());
//    }

 /*   @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner(applicationId, txServiceGroup);
    }*/

}
