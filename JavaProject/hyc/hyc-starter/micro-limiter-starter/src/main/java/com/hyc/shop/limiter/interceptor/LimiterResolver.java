package com.hyc.shop.limiter.interceptor;


import com.hyc.shop.limiter.Limiter;


public interface LimiterResolver<T extends LimiterOperation> {

    Limiter resolveLimiter(LimiterOperationInvocationContext<T> limiterOperationInvocationContext);

}
