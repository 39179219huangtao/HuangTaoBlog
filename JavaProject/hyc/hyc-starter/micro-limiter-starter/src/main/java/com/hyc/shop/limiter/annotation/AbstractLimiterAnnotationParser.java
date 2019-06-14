package com.hyc.shop.limiter.annotation;

import com.hyc.shop.limiter.Limiter;
import com.hyc.shop.limiter.interceptor.LimiterOperation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Collection;


public abstract class AbstractLimiterAnnotationParser<T extends Limiter> implements LimiterAnnotationParser<T> {



    @Override
    public Collection<LimiterOperation<T>> parseLimiterAnnotations(Class<?> clazz) {
        return parseAnnotations(clazz);
    }


    @Override
    public Collection<LimiterOperation<T>> parseLimiterAnnotations(Method method) {
        return parseAnnotations(method);
    }


    public abstract Collection<LimiterOperation<T>> parseAnnotations(AnnotatedElement ae);

}
