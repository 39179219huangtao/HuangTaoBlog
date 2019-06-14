package com.hyc.shop.limiter.config;

import com.hyc.shop.limiter.interceptor.ArgumentInjecter;
import com.hyc.shop.limiter.interceptor.ErrorHandler;
import com.hyc.shop.limiter.interceptor.LimiterFallbackResolver;

import java.util.Collection;



public interface GlobalConfig {

    ErrorHandler errorHandler();

    LimiterFallbackResolver fallbackResolver();

    Collection<ArgumentInjecter> globalArgumentInjecters();

}
