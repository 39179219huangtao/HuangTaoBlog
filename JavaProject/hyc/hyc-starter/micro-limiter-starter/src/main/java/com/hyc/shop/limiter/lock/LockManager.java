package com.hyc.shop.limiter.lock;

import com.hyc.shop.limiter.LimiterManager;

import java.util.Collection;

/**
 * Created by caocg on 2018/9/21.
 */
public abstract class LockManager implements LimiterManager<Lock> {

    @Override
    public Lock getLimiter(String name) {
        return getLock(name);
    }

    @Override
    public Collection<String> getLimiterNames() {
        return getLockNames();
    }

    public abstract Lock getLock(String name);

    public abstract Collection<String> getLockNames();
}
