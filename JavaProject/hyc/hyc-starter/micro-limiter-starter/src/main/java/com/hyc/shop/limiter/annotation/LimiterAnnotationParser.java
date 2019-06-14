package com.hyc.shop.limiter.annotation;

import com.hyc.shop.limiter.Limiter;
import com.hyc.shop.limiter.interceptor.LimiterOperation;
import java.lang.reflect.Method;
import java.util.Collection;


public interface LimiterAnnotationParser<T extends Limiter> {


    Collection<LimiterOperation<T>> parseLimiterAnnotations(Class<?> clazz);

    Collection<LimiterOperation<T>> parseLimiterAnnotations(Method method);

}
