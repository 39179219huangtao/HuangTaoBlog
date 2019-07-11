package com.hyc.shop.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;


@Configuration
@MapperScan("com.hyc.shop.admin.domain.dao")
@EnableTransactionManagement
public class JdbcConfig implements  TransactionManagementConfigurer {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
		return new DruidDataSource();
    }
	
	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		
		return new DataSourceTransactionManager(dataSource());
	}


}
