package com.hyc.shop.web.controller;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.dubbo.config.annotation.Service;
//import com.hyc.shop.admin.service.IHelloService;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @program hyc
// * @description:
// * @author: huangtao
// * @create: 2019/07/02 16:16
// */
//
//@RestController
//public class TestController {
//    @Reference
//    private IHelloService helloService;
//
//    @GetMapping("/test")
//    @ApiOperation(value = "测试dubbo调用", notes = "测试dubbo调用")
//    public String test() {
//        helloService.hello();
//
//        return "";
//    }
//
//}
