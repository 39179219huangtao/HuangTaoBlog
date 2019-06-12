package com.hyc.shop.lock.handler;

/**
 * @description:
 * @author: huangtao
 * @date: 2019/6/12
 */
public class MicroLockInvocationException extends RuntimeException {

    public MicroLockInvocationException() {
    }

    public MicroLockInvocationException(String message) {
        super(message);
    }

    public MicroLockInvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
