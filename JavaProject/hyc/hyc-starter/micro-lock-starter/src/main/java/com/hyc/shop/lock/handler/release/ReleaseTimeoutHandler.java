package com.hyc.shop.lock.handler.release;

import com.hyc.shop.lock.model.LockInfo;


/**
 * @description: 获取锁超时的处理逻辑接口
 * @author: huangtao
 * @date: 2019/6/12
 */
public interface ReleaseTimeoutHandler {

    void handle(LockInfo lockInfo);
}
