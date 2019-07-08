package com.hyc.shop.product.impl;

import com.hyc.shop.product.service.IHelloService;
import com.hyc.shop.product.service.IHelloService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program hyc
 * @description:
 * @author: huangtao
 * @create: 2019/05/16 17:22
 */

@Service
@org.apache.dubbo.config.annotation.Service(validation = "true", version = "${dubbo.provider.ProductAttrService.version}")
public class HelloServiceImpl implements IHelloService {


    @Override
    public void hello() {
        System.out.println("hello");
    }
}
