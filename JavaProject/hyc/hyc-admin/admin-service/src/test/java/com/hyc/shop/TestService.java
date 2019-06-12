package com.hyc.shop;

import com.hyc.shop.lock.annotation.MicroLock;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: huangtao
 * @date: 2019/6/12
 */
@Service
public class TestService {

    @MicroLock(waitTime = Long.MAX_VALUE, leaseTime = 60, keys = {"#param"})
    public String getValue(String param) throws Exception {
        System.out.println("进入方法  获取到了锁");
        //  if ("sleep".equals(param)) {//线程休眠或者断点阻塞，达到一直占用锁的测试效果
        Thread.sleep(1000 * 60);
        //}
        return "success";
    }

    @MicroLock(keys = {"#user.name", "#user.id"})
    public String getValue(User user) throws Exception {
        Thread.sleep(60 * 1000);
        return "success";
    }

}
