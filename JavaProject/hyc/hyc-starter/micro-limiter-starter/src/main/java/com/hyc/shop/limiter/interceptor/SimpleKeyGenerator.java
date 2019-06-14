package com.hyc.shop.limiter.interceptor;

import java.lang.reflect.Method;


public class SimpleKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return generateKey(params);
    }


    public static Object generateKey(Object... params) {
        if (params.length == 0) {
            return com.hyc.shop.limiter.interceptor.SimpleKey.EMPTY;
        }
        if (params.length == 1) {
            Object param = params[0];
            if (param != null && !param.getClass().isArray()) {
                return param;
            }
        }
        return new com.hyc.shop.limiter.interceptor.SimpleKey(params);
    }

}
