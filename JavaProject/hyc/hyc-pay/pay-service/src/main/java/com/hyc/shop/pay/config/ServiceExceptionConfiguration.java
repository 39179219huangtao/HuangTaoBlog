package com.hyc.shop.pay.config;


import com.hyc.shop.common.util.ServiceExceptionUtil;
import com.hyc.shop.pay.constant.PayErrorCodeEnum;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ServiceExceptionConfiguration {

    @EventListener(ApplicationReadyEvent.class) // 可参考 https://www.cnblogs.com/ssslinppp/p/7607509.html
    public void initMessages() {
        for (PayErrorCodeEnum item : PayErrorCodeEnum.values()) {
            ServiceExceptionUtil.put(item.getCode(), item.getMessage());
        }
    }

}
