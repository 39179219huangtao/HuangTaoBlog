package com.hyc.shop.lock.handler.lock;

import com.hyc.shop.lock.lock.Lock;
import org.aspectj.lang.JoinPoint;
import com.hyc.shop.lock.model.LockInfo;


/**
 * @description: 获取锁超时的处理逻辑接口
 * @author: huangtao
 * @date: 2019/6/12
 */
public interface LockTimeoutHandler {

    void handle(LockInfo lockInfo, Lock lock, JoinPoint joinPoint);
}
