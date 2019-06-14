package com.hyc.shop.limiter.interceptor;

import com.hyc.shop.limiter.LimiterManager;



public class SimpleLimiterResolver<T extends LimiterOperation> extends AbstractLimiterResolver {

    @Override
    protected String getLimiterName(LimiterOperationInvocationContext context) {
        return context.getLimiterOperation().getLimiterName();

    }

    public SimpleLimiterResolver() {
    }

    public SimpleLimiterResolver(LimiterManager limiterManager) {
        super(limiterManager);
    }

}
