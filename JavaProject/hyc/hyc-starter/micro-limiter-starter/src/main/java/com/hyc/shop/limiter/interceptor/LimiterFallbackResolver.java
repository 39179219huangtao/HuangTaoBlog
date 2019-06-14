package com.hyc.shop.limiter.interceptor;

import java.lang.reflect.Method;


/**
 * 降级
 * @param <T>
 */
public interface LimiterFallbackResolver<T> {

    T resolve(Method method, Class<?> clazz, Object[] args, String key);
}
