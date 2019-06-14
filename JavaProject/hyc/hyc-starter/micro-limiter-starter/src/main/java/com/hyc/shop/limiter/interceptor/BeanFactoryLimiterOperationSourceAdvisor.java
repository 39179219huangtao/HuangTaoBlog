package com.hyc.shop.limiter.interceptor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;


/**
 * 实际的切面
 */
public class BeanFactoryLimiterOperationSourceAdvisor extends AbstractBeanFactoryPointcutAdvisor {


    private LimiterOperationSource limiterOperationSource;

    /**
     * 切点
     */
    private final LimiterOperationSourcePointcut pointcut = new LimiterOperationSourcePointcut() {
        @Override
        protected LimiterOperationSource getLimiterOperationSource() {
            return BeanFactoryLimiterOperationSourceAdvisor.this.limiterOperationSource;
        }
    };

    public BeanFactoryLimiterOperationSourceAdvisor(LimiterOperationSource limiterOperationSource) {
        this.limiterOperationSource = limiterOperationSource;
    }



    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }
}
