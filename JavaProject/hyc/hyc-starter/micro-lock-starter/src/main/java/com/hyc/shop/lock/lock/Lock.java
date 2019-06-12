package com.hyc.shop.lock.lock;

/**
 * @description:
 * @author: huangtao
 * @date: 2019/6/12
 */
public interface Lock {

    boolean acquire();

    boolean release();
}

