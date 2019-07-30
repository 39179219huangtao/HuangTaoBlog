package com.hyc.shop.promotion.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.hyc.shop.promotion.domain.dao") // 扫描对应的 Mapper 接口
@EnableTransactionManagement(proxyTargetClass = true)
public class DatabaseConfiguration {

    // 数据源，使用 HikariCP
//
//    @Value("${spring.application.name}")
//    private String applicationId;


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /*   *//**
     * 注册一个StatViewServlet
     *
     * @return global transaction scanner
     *//*
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner(applicationId, "my_test_tx_group");
        // TODO 芋艿，txServiceGroup 后续要编辑下
    }*/

}
