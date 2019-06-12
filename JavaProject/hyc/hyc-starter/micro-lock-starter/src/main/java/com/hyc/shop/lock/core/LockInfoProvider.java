package com.hyc.shop.lock.core;

import com.hyc.shop.lock.annotation.MicroLock;
import com.hyc.shop.lock.config.MicroLockConfig;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.hyc.shop.lock.model.LockInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import com.hyc.shop.lock.model.LockType;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: huangtao
 * @date: 2019/6/12
 */
public class LockInfoProvider {

    public static final String LOCK_NAME_PREFIX = "com/hyc/shop/lock";
    public static final String LOCK_NAME_SEPARATOR = ".";


    @Autowired
    private MicroLockConfig microLockConfig;

    @Autowired
    private BusinessKeyProvider businessKeyProvider;

    private static final Logger logger = LoggerFactory.getLogger(LockInfoProvider.class);

    public LockInfo get(ProceedingJoinPoint joinPoint, MicroLock microLock) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LockType type= microLock.lockType();
        String businessKeyName=businessKeyProvider.getKeyName(joinPoint,microLock);
        String lockName = LOCK_NAME_PREFIX+LOCK_NAME_SEPARATOR+getName(microLock.name(), signature)+businessKeyName;
        long waitTime = getWaitTime(microLock);
        long leaseTime = getLeaseTime(microLock);

        if(leaseTime == -1 && logger.isWarnEnabled()) {
            logger.warn("Trying to acquire Lock({}) with no expiration, " +
                        "MicroLock will keep prolong the lock expiration while the lock is still holding by current thread. " +
                        "This may cause dead lock in some circumstances.", lockName);
        }

        return new LockInfo(type,lockName,waitTime,leaseTime);
    }

    private String getName(String annotationName, MethodSignature signature) {
        if (annotationName.isEmpty()) {
            return String.format("%s.%s", signature.getDeclaringTypeName(), signature.getMethod().getName());
        } else {
            return annotationName;
        }
    }


    private long getWaitTime(MicroLock lock) {
        return lock.waitTime() == Long.MIN_VALUE ?
                microLockConfig.getWaitTime() : lock.waitTime();
    }

    private long getLeaseTime(MicroLock lock) {
        return lock.leaseTime() == Long.MIN_VALUE ?
                microLockConfig.getLeaseTime() : lock.leaseTime();
    }
}
