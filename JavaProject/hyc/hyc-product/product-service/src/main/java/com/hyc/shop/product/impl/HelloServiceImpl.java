package com.hyc.shop.product.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hyc.shop.product.service.IHelloService;
import com.hyc.shop.product.service.IHelloService;
import org.springframework.stereotype.Component;

/**
 * @program hyc
 * @description:
 * @author: huangtao
 * @create: 2019/05/16 17:22
 */

@Component
@Service
public class HelloServiceImpl implements IHelloService {


    @Override
    public void hello() {
        System.out.println("hello");
    }
}
