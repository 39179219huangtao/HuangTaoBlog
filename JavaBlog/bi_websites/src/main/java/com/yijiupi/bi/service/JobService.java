package com.yijiupi.bi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.config
 * @Description:
 * @date 2018/8/8  16:40
 * Remark 因为Spring MVC固有的问题，会在LoadApplication时启动两个实例，这就导致了该组建也是两个实例，为了避免同时跑的问题，所以用同步的方法来实现
 * 参考https://stackoverflow.com/questions/14242310/java-spring-scheduled-tasks-executing-twice
 * 参考https://stackoverflow.com/questions/19826228/spring-web-security-web-xml-mvc-dispatcher-bean-is-created-twice/19850897#19850897
 */
@Component
public class JobService {
    private static Logger log = LoggerFactory.getLogger(JobService.class);

    /**
     * 加锁的对象
     */
    private static Object lockObj = new Object();
    /**
     * 是否当前已经在跑了
     */
    private static boolean isRunning = false;
    /**
     * 当前允许跑的线程ID
     */
    private static Long allowRuningThreadID = null;

    @Autowired
    SyncService syncService;

    /**
     * 尝试获取锁
     */
    private static void getRunLock()
    {
        if(!isRunning){
            synchronized (lockObj){
                if(!isRunning){
                    isRunning = true;
                    allowRuningThreadID = Thread.currentThread().getId();
                }
            }
        }
    }

    private static boolean isLockSuccess(){
        return isRunning && Objects.equals(Thread.currentThread().getId(), allowRuningThreadID) ;
    }

    private static void releaseLock(){
        isRunning = false;
        allowRuningThreadID = null;
    }

    /**
     * 同步用户
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void syncUser() {
        getRunLock();
        if(isLockSuccess()){
            syncService.syncAllUser();
            releaseLock();
        }
    }

    /**
     * 同步用户部门
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncUserDepartment() {
        getRunLock();
        if(isLockSuccess()){
            syncService.syncAllDepartment();
            releaseLock();
        }
    }

    /**
     * 同步岗位
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public void syncPost() {
        getRunLock();
        if(isLockSuccess()){
            syncService.syncAllPost();
            releaseLock();
        }
    }
}
