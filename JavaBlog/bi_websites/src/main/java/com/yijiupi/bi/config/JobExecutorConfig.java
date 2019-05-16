package com.yijiupi.bi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 当前job的执行配置文件
 * 之所以存在这个文件，是为了避免job被初始化两次
 */
@Configuration
@EnableScheduling
public class JobExecutorConfig {
}
