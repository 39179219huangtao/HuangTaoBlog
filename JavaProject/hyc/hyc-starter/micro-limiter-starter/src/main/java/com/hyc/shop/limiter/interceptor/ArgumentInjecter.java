package com.hyc.shop.limiter.interceptor;

import java.util.Map;


public interface ArgumentInjecter {

    Map<String,Object> inject(Object... args);
}
