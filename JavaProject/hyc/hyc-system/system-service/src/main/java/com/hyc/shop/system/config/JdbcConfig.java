package com.hyc.shop.system.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
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
@MapperScan("com.hyc.shop.system.domain.dao")
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

	@Bean
	public ISqlInjector sqlInjector() {
		return new DefaultSqlInjector(); // MyBatis Plus 逻辑删除
	}

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor(); // MyBatis Plus 分页插件
	}

}
