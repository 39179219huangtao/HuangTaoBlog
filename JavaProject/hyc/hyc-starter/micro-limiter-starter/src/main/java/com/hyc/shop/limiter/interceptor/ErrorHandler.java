package com.hyc.shop.limiter.interceptor;



public interface ErrorHandler {

    boolean handleError(RuntimeException runtimeException);

}
