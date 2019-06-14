package com.hyc.shop.limiter.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import com.hyc.shop.limiter.interceptor.BeanFactoryLimiterOperationSourceAdvisor;
import com.hyc.shop.limiter.interceptor.LimiterInterceptor;
import com.hyc.shop.limiter.interceptor.LimiterOperationSource;
import com.hyc.shop.limiter.lock.LockAnnotationParser;
import com.hyc.shop.limiter.ratelimiter.RateLimiterAnnotationParser;
import com.hyc.shop.limiter.semaphore.SemaphoreAnnotationParser;

import java.util.*;


@Configuration
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class ProxyLimiterConfiguration extends AbstractLimiterConfiguration {

    @Bean(name = "com.hyc.shop.limiter.config.internalLimiterAdvisor")
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public BeanFactoryLimiterOperationSourceAdvisor limiterAdvisor() {
        BeanFactoryLimiterOperationSourceAdvisor advisor =
                new BeanFactoryLimiterOperationSourceAdvisor(limiterOperationSource());
        advisor.setAdvice(limiterInterceptor());
        if (this.enableLimiter != null) {
            advisor.setOrder(this.enableLimiter.<Integer>getNumber("order"));
        }
        return advisor;
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public LimiterOperationSource limiterOperationSource() {
        String[] modules = this.enableLimiter.getStringArray("modules");
        if (modules == null || modules.length == 0) {
            return new AnnotationCacheOperationSource(new LockAnnotationParser(), new RateLimiterAnnotationParser(), new SemaphoreAnnotationParser());
        }
        Set<LimiterAnnotationParser> selected = new HashSet<>();
        for (String m : modules) {
            if ("lock".equals(m)) {
                selected.add(new LockAnnotationParser());
            }
            if ("rateLimiter".equals(m)) {
                selected.add(new RateLimiterAnnotationParser());
            }
            if ("semaphore".equals(m)) {
                selected.add(new SemaphoreAnnotationParser());
            }
        }

        return new AnnotationCacheOperationSource(selected);
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public LimiterInterceptor limiterInterceptor() {
        LimiterInterceptor interceptor = new LimiterInterceptor();
        interceptor.setLimiterOperationSource(limiterOperationSource());
        return interceptor;
    }

}
