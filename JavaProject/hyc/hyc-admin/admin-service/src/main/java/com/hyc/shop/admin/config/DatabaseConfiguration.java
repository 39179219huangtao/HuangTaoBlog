package com.hyc.shop.admin.config;

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true) // 启动事务管理。为什么使用 proxyTargetClass 参数，参见 https://blog.csdn.net/huang_550/article/details/76492600
public class DatabaseConfiguration {

    // 数据库连接池 Druid

    @Bean
    public ISqlInjector sqlInjector() {
        return new DefaultSqlInjector(); // MyBatis Plus 逻辑删除
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor(); // MyBatis Plus 分页插件
    }

}
