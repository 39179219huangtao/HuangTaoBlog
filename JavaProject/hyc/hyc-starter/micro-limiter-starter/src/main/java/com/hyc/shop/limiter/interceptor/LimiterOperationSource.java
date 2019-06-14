package com.hyc.shop.limiter.interceptor;

import java.lang.reflect.Method;
import java.util.Collection;


/**
 * 定义limiter的来源
 */
public interface LimiterOperationSource {

    /**
     *
     * @param method
     * @param clazz
     * @return
     */
    Collection<LimiterOperation> getLimiterOperations(Method method, Class<?> clazz);
}
