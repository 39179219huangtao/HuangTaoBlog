package com.hyc.shop.limiter.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.MethodClassKey;
import org.springframework.util.ClassUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



public abstract class AbstractLimiterOperationSource implements LimiterOperationSource {

    /**
     * 空集合，应用于没有定义的切点
     */
    private static final Collection<LimiterOperation> NULL_CACHING_ATTRIBUTE = Collections.emptyList();
    protected final Log logger = LogFactory.getLog(this.getClass());
    private final Map<Object, Collection<LimiterOperation>> attributeCache = new ConcurrentHashMap(1024);

    public AbstractLimiterOperationSource() {
    }

    @Override
    public Collection<LimiterOperation> getLimiterOperations(Method method, Class<?> targetClass) {
        if (method.getDeclaringClass() == Object.class) {
            return null;
        } else {
            Object cacheKey = this.getLimiterKey(method, targetClass);
            Collection<LimiterOperation> cached = (Collection) this.attributeCache.get(cacheKey);
            if (cached != null) {
                return cached != NULL_CACHING_ATTRIBUTE ? cached : null;
            } else {
                Collection<LimiterOperation> cacheOps = this.computeLimiterOperations(method, targetClass);
                if (cacheOps != null) {
                    this.attributeCache.put(cacheKey, cacheOps);
                } else {
                    this.attributeCache.put(cacheKey, NULL_CACHING_ATTRIBUTE);
                }

                return cacheOps;
            }
        }
    }

    private Collection<LimiterOperation> computeLimiterOperations(Method method,  Class<?> targetClass) {
        if (this.allowPublicMethodsOnly() && !Modifier.isPublic(method.getModifiers())) {
            return null;
        } else {
            // 对于代理对象 需要获取其实际的方法
            Method specificMethod = AopUtils.getMostSpecificMethod(method, targetClass);
            Collection<LimiterOperation> opDef = this.findLimiterOperations(specificMethod);
            if (opDef != null) {
                return opDef;
            } else {
                opDef = this.findLimiterOperations(specificMethod.getDeclaringClass());
                if (opDef != null && ClassUtils.isUserLevelMethod(method)) {
                    return opDef;
                } else {
                    if (specificMethod != method) {
                        opDef = this.findLimiterOperations(method);
                        if (opDef != null) {
                            return opDef;
                        }

                        opDef = this.findLimiterOperations(method.getDeclaringClass());
                        if (opDef != null && ClassUtils.isUserLevelMethod(method)) {
                            return opDef;
                        }
                    }

                    return null;
                }
            }
        }
    }

    protected Object getLimiterKey(Method method,  Class<?> targetClass) {
        return new MethodClassKey(method, targetClass);
    }

    protected boolean allowPublicMethodsOnly() {
        return false;
    }


    protected abstract Collection<LimiterOperation> findLimiterOperations(Method method);


    protected abstract Collection<LimiterOperation> findLimiterOperations(Class<?> clazz);

}
