package com.hyc.shop.admin.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.hyc.shop.admin.service.IHelloService;
import sun.tools.tree.ThisExpression;

import java.io.IOException;
import java.util.*;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @program hyc
 * @description:
 * @author: huangtao
 * @create: 2019/05/16 17:22
 */
@Service(version = "1.0.0")
public class HelloServiceImpl implements IHelloService {


    @Override
    public void hello() {
        System.out.println("hello");
    }
}
