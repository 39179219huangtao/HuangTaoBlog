package com.hyc.shop.lock.model;


/**
 * @description: 锁基本信息
 * @author: huangtao
 * @date: 2019/6/12
 */
public class LockInfo {

    private LockType type;
    private String name;
    private long waitTime;
    private long leaseTime;

    public LockInfo() {
    }

    public LockInfo(LockType type, String name, long waitTime, long leaseTime) {
        this.type = type;
        this.name = name;
        this.waitTime = waitTime;
        this.leaseTime = leaseTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public long getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(long leaseTime) {
        this.leaseTime = leaseTime;
    }

    public LockType getType() {
        return type;
    }

    public void setType(LockType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LockInfo{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", waitTime=" + waitTime +
                ", leaseTime=" + leaseTime +
                '}';
    }
}
