package com.hyc.shop.limiter.annotation;

import org.springframework.util.Assert;
import com.hyc.shop.limiter.interceptor.AbstractLimiterOperationSource;
import com.hyc.shop.limiter.interceptor.LimiterOperation;
import com.hyc.shop.limiter.lock.LockAnnotationParser;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;


/**
 * 从注解中获取定义
 * 参考cache模块
 */
public class AnnotationCacheOperationSource extends AbstractLimiterOperationSource implements Serializable {

    private final boolean publicMethodsOnly;

    private final Set<LimiterAnnotationParser> annotationParsers;



    public AnnotationCacheOperationSource(LimiterAnnotationParser... annotationParsers) {
        this.publicMethodsOnly = true;
        Assert.notEmpty(annotationParsers, "At least one LimiterAnnotationParser needs to be specified");
        Set<LimiterAnnotationParser> parsers = new LinkedHashSet<>(annotationParsers.length);
        Collections.addAll(parsers, annotationParsers);
        this.annotationParsers = parsers;
    }


    public AnnotationCacheOperationSource(Set<LimiterAnnotationParser> annotationParsers) {
        this.publicMethodsOnly = true;
        Assert.notEmpty(annotationParsers, "At least one LimiterAnnotationParser needs to be specified");
        this.annotationParsers = annotationParsers;
    }


    @Override
    protected Collection<LimiterOperation> findLimiterOperations(final Class<?> clazz) {
        return determineCacheOperations(parser -> parser.parseLimiterAnnotations(clazz));
    }

    @Override
    protected Collection<LimiterOperation> findLimiterOperations(final Method method) {
        return determineCacheOperations(parser -> parser.parseLimiterAnnotations(method));
    }



    protected Collection<LimiterOperation> determineCacheOperations(LimiterOperationProvider provider) {
        Collection<LimiterOperation> ops = null;
        for (LimiterAnnotationParser annotationParser : this.annotationParsers) {
            Collection<LimiterOperation> annOps = provider.getLimiterOperations(annotationParser);
            if (annOps != null) {
                if (ops == null) {
                    ops = new ArrayList<>();
                }
                ops.addAll(annOps);
            }
        }
        return ops;
    }

    @Override
    protected boolean allowPublicMethodsOnly() {
        return this.publicMethodsOnly;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationCacheOperationSource)) {
            return false;
        }
        AnnotationCacheOperationSource otherCos = (AnnotationCacheOperationSource) other;
        return (this.annotationParsers.equals(otherCos.annotationParsers) &&
                this.publicMethodsOnly == otherCos.publicMethodsOnly);
    }

    @Override
    public int hashCode() {
        return this.annotationParsers.hashCode();
    }


    @FunctionalInterface
    protected interface LimiterOperationProvider {

        Collection<LimiterOperation> getLimiterOperations(LimiterAnnotationParser parser);
    }

}
