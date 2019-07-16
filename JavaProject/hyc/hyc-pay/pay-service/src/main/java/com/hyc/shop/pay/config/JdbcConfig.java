package com.hyc.shop.pay.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;


@Configuration
@MapperScan("com.hyc.shop.pay.domain.dao")
@EnableTransactionManagement
public class JdbcConfig implements  TransactionManagementConfigurer {
	@Value("${spring.application.name}")
	private String applicationId;
	@Value("${seata.tx-service-group}")
	private String txServiceGroup;
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
		return new DruidDataSource();
    }
	
	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public GlobalTransactionScanner globalTransactionScanner() {
		return new GlobalTransactionScanner(applicationId, txServiceGroup);
	}
}
