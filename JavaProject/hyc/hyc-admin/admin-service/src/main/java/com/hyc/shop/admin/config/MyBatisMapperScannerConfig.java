package com.hyc.shop.admin.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisMapperScannerConfig {
	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer config= new MapperScannerConfigurer();
		config.setBasePackage("com.hyc.shop.admin.domain.dao");
		return config;
    }
}
