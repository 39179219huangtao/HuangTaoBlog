package com.yijiupi.bi.dto;

import java.io.Serializable;

/**
 * 城市设置
 *
 * @author ZhouXin
 */
public class CitySetting implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1825254490138637936L;
    /**
     * 是否开启多设备登陆
     */
    private Boolean mutilDeviceLogin;

    public Boolean getMutilDeviceLogin() {
        return mutilDeviceLogin;
    }

    public void setMutilDeviceLogin(Boolean mutilDeviceLogin) {
        this.mutilDeviceLogin = mutilDeviceLogin;
    }

}
