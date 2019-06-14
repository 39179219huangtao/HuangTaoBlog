package com.hyc.shop.limiter.config;

import com.hyc.shop.limiter.interceptor.ArgumentInjecter;
import com.hyc.shop.limiter.interceptor.ErrorHandler;
import com.hyc.shop.limiter.interceptor.LimiterFallbackResolver;

import java.util.Collection;



public class LimiterGlobalConfig implements GlobalConfig {

    private ErrorHandler errorHandler;

    private LimiterFallbackResolver limiterFallbackResolver;

    private Collection<ArgumentInjecter> argumentInjecterCollection;

    @Override
    public Collection<ArgumentInjecter> globalArgumentInjecters() {
        return this.argumentInjecterCollection;
    }

    @Override
    public LimiterFallbackResolver fallbackResolver() {
        return this.limiterFallbackResolver;
    }

    @Override
    public ErrorHandler errorHandler() {
        return this.errorHandler;
    }


    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public void setLimiterFallbackResolver(LimiterFallbackResolver limiterFallbackResolver) {
        this.limiterFallbackResolver = limiterFallbackResolver;
    }

    public void setArgumentInjecterCollection(Collection<ArgumentInjecter> argumentInjecterCollection) {
        this.argumentInjecterCollection = argumentInjecterCollection;
    }
}
