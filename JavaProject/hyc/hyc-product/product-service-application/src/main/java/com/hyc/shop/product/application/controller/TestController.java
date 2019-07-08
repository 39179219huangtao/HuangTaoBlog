package com.hyc.shop.product.application.controller;

import com.hyc.shop.product.service.IHelloService;
import com.hyc.shop.product.service.IHelloService;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program hyc
 * @description:
 * @author: huangtao
 * @create: 2019/07/02 16:16
 */

@RestController
public class TestController {
//    @Reference(validation = "true", version = "${dubbo.provider.ProductAttrService.version}")
//    private IHelloService helloService;
//
//    @GetMapping("/test")
//    @ApiOperation(value = "测试dubbo调用", notes = "测试dubbo调用")
//    public String test() {
//        helloService.hello();
//
//        return "";
//    }

}
