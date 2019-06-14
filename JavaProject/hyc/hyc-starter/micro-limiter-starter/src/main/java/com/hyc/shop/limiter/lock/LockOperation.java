package com.hyc.shop.limiter.lock;

import com.hyc.shop.limiter.LimiterManager;
import com.hyc.shop.limiter.interceptor.LimiterOperation;

/**
 * Created by caocg on 2018/9/21.
 */
public class LockOperation extends LimiterOperation<Lock> {

    public LockOperation(Builder b) {
        super(b);
    }


    @Override
    public Class<? extends LimiterManager<Lock>> getDefaultLimiterManagerClass() {

        return LockManager.class;
    }

    public static class Builder extends LimiterOperation.Builder {


        @Override
        public LockOperation build() {
            return new LockOperation(this);
        }
    }

}
