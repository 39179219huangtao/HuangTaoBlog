package com.hyc.shop.lock.handler;

/**
 * @description:
 * @author: huangtao
 * @date: 2019/6/12
 */
public class MicroLockTimeoutException extends RuntimeException {

    public MicroLockTimeoutException() {
    }

    public MicroLockTimeoutException(String message) {
        super(message);
    }

    public MicroLockTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
