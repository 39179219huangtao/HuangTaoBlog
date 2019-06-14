package com.hyc.shop.lock.core;

import com.hyc.shop.lock.annotation.MicroLock;
import com.hyc.shop.lock.handler.MicroLockInvocationException;
import com.hyc.shop.lock.lock.Lock;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.hyc.shop.lock.lock.LockFactory;
import com.hyc.shop.lock.model.LockInfo;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @description: 给添加@microLock切面加锁处理
 * @author: huangtao
 * @date: 2019/6/12
 */
@Aspect
@Component
@Order(0)
public class MicroLockAspectHandler {

    private static final Logger logger = LoggerFactory.getLogger(MicroLockAspectHandler.class);

    @Autowired
    LockFactory lockFactory;

    @Autowired
    private LockInfoProvider lockInfoProvider;

    private ThreadLocal<Lock> currentThreadLock = new ThreadLocal<>();
    private ThreadLocal<LockRes> currentThreadLockRes = new ThreadLocal<>();

    @Around(value = "@annotation(microLock)")
    public Object around(ProceedingJoinPoint joinPoint, MicroLock microLock) throws Throwable {
        System.out.println("around  enter");
        LockInfo lockInfo = lockInfoProvider.get(joinPoint,microLock);
        currentThreadLockRes.set(new LockRes(lockInfo, false));
        Lock lock = lockFactory.getLock(lockInfo);
        boolean lockRes = lock.acquire();

        if(!lockRes) {
            if(logger.isWarnEnabled()) {
                logger.warn("Timeout while acquiring Lock({})", lockInfo.getName());
            }

            if(!StringUtils.isEmpty(microLock.customLockTimeoutStrategy())) {

                return handleCustomLockTimeout(microLock.customLockTimeoutStrategy(), joinPoint);

            } else {
                microLock.lockTimeoutStrategy().handle(lockInfo, lock, joinPoint);
            }
        }

        currentThreadLock.set(lock);
        currentThreadLockRes.get().setRes(true);
        final Object proceed = joinPoint.proceed();
        System.out.println("around end");
        return proceed;
    }
    @Before(value = "@annotation(microLock)")
    public void before(JoinPoint joinPoint, MicroLock microLock) throws Throwable {
        System.out.println("before");
    }


    @AfterReturning(value = "@annotation(microLock)")
    public void afterReturning(JoinPoint joinPoint, MicroLock microLock) throws Throwable {

        releaseLock(microLock, joinPoint);
        cleanUpThreadLocal();
    }

    @AfterThrowing(value = "@annotation(microLock)", throwing = "ex")
    public void afterThrowing (JoinPoint joinPoint, MicroLock microLock, Throwable ex) throws Throwable {

        releaseLock(microLock, joinPoint);
        cleanUpThreadLocal();
        throw ex;
    }

    /**
     * 处理自定义加锁超时
     */
    private Object handleCustomLockTimeout(String lockTimeoutHandler, JoinPoint joinPoint) throws Throwable {

        // prepare invocation context
        Method currentMethod = ((MethodSignature)joinPoint.getSignature()).getMethod();
        Object target = joinPoint.getTarget();
        Method handleMethod = null;
        try {
            handleMethod = joinPoint.getTarget().getClass().getDeclaredMethod(lockTimeoutHandler, currentMethod.getParameterTypes());
            handleMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Illegal annotation param customLockTimeoutStrategy",e);
        }
        Object[] args = joinPoint.getArgs();

        // invoke
        Object res = null;
        try {
            res = handleMethod.invoke(target, args);
        } catch (IllegalAccessException e) {
            throw new MicroLockInvocationException("Fail to invoke custom lock timeout handler: " + lockTimeoutHandler ,e);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }

        return res;
    }

    /**
     *  释放锁
     */
    private void releaseLock(MicroLock microLock, JoinPoint joinPoint) throws Throwable {
        LockRes lockRes = currentThreadLockRes.get();
        if (lockRes.getRes()) {
            boolean releaseRes = currentThreadLock.get().release();
            // avoid release lock twice when exception happens below
            lockRes.setRes(false);
            if (!releaseRes) {
                handleReleaseTimeout(microLock, lockRes.getLockInfo(), joinPoint);
            }
        }
    }


    /**
     *  处理释放锁时已超时
     */
    private void handleReleaseTimeout(MicroLock microLock, LockInfo lockInfo, JoinPoint joinPoint) throws Throwable {

        if(logger.isWarnEnabled()) {
            logger.warn("Timeout while release Lock({})", lockInfo.getName());
        }

        if(!StringUtils.isEmpty(microLock.customReleaseTimeoutStrategy())) {

            handleCustomReleaseTimeout(microLock.customReleaseTimeoutStrategy(), joinPoint);

        } else {
            microLock.releaseTimeoutStrategy().handle(lockInfo);
        }

    }

    /**
     * 处理自定义释放锁时已超时
     */
    private void handleCustomReleaseTimeout(String releaseTimeoutHandler, JoinPoint joinPoint) throws Throwable {

        Method currentMethod = ((MethodSignature)joinPoint.getSignature()).getMethod();
        Object target = joinPoint.getTarget();
        Method handleMethod = null;
        try {
            handleMethod = joinPoint.getTarget().getClass().getDeclaredMethod(releaseTimeoutHandler, currentMethod.getParameterTypes());
            handleMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Illegal annotation param customReleaseTimeoutStrategy",e);
        }
        Object[] args = joinPoint.getArgs();

        try {
            handleMethod.invoke(target, args);
        } catch (IllegalAccessException e) {
            throw new MicroLockInvocationException("Fail to invoke custom release timeout handler: " + releaseTimeoutHandler, e);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    private class LockRes {

        private LockInfo lockInfo;

        private Boolean res;

        LockRes(LockInfo lockInfo, Boolean res) {
            this.lockInfo = lockInfo;
            this.res = res;
        }

        LockInfo getLockInfo() {
            return lockInfo;
        }

        Boolean getRes() {
            return res;
        }

        void setRes(Boolean res) {
            this.res = res;
        }

        void setLockInfo(LockInfo lockInfo) {
            this.lockInfo = lockInfo;
        }
    }

    // avoid memory leak
    private void cleanUpThreadLocal() {

        currentThreadLockRes.remove();
        currentThreadLock.remove();
    }
}
