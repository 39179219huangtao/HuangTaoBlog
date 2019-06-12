package lock.annotation;

import lock.model.LockTimeoutStrategy;
import lock.model.LockType;
import lock.model.ReleaseTimeoutStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: huangtao
 * @date: 2019/6/12
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MicroLock {
    /**
     * 锁的名称
     * @return name
     */
    String name() default "";
    /**
     * 锁类型，默认可重入锁
     * @return lockType
     */
    LockType lockType() default LockType.Reentrant;
    /**
     * 尝试加锁，最多等待时间
     * @return waitTime
     */
    long waitTime() default Long.MIN_VALUE;
    /**
     *上锁以后xxx秒自动解锁
     * @return leaseTime
     */
    long leaseTime() default Long.MIN_VALUE;

    /**
     * 自定义业务key
     * @return keys
     */
     String [] keys() default {};

     /**
     * 加锁超时的处理策略
     * @return lockTimeoutStrategy
     */
     LockTimeoutStrategy lockTimeoutStrategy() default LockTimeoutStrategy.NO_OPERATION;

    /**
     * 自定义加锁超时的处理策略
     * @return customLockTimeoutStrategy
     */
     String customLockTimeoutStrategy() default "";

     /**
     * 释放锁时已超时的处理策略
     * @return releaseTimeoutStrategy
     */
     ReleaseTimeoutStrategy releaseTimeoutStrategy() default ReleaseTimeoutStrategy.NO_OPERATION;

    /**
     * 自定义释放锁时已超时的处理策略
     * @return customReleaseTimeoutStrategy
     */
     String customReleaseTimeoutStrategy() default "";

}
