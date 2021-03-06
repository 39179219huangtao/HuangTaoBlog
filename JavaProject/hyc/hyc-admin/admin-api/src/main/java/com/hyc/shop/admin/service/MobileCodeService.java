package com.hyc.shop.admin.service;


import com.hyc.shop.common.exception.ServiceException;

public interface MobileCodeService {

    /**
     * 发送验证码
     *
     * @param mobile 手机号
     */
    void send(String mobile) throws ServiceException;

}
