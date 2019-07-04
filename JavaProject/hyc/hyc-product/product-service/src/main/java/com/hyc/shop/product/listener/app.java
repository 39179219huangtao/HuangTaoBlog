package com.hyc.shop.product.listener;

import com.hyc.shop.lock.annotation.MicroLock;
import org.springframework.beans.factory.annotation.Value;

/**
 * @program hyc
 * @description:
 * @author: huangtao
 * @create: 2019/05/16 17:22
 */

public class app {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @MicroLock(waitTime = 2, leaseTime = 100,customLockTimeoutStrategy="testTimeOut", keys = {"#param"})
    public String getValue(String param) throws Exception {
        System.out.println("进入方法  获取到了锁");
        //  if ("sleep".equals(param)) {//线程休眠或者断点阻塞，达到一直占用锁的测试效果
        Thread.sleep(1000 * 10);
        //}
        return "success";
    }

    private String testTimeOut(String param) {

        throw new IllegalStateException("customReleaseTimeout");
    }
}
