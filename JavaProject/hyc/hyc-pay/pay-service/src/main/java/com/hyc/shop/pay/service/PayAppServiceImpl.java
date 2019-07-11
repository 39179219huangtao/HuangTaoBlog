package com.hyc.shop.pay.service;


import com.hyc.shop.common.constant.CommonStatusEnum;
import com.hyc.shop.common.util.ServiceExceptionUtil;
import com.hyc.shop.pay.constant.PayErrorCodeEnum;
import com.hyc.shop.pay.domain.dao.PayAppMapper;
import com.hyc.shop.pay.domain.dataobject.PayAppDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayAppServiceImpl {

    @Autowired
    private PayAppMapper payAppMapper;

    public PayAppDO validPayApp(String appId) {
        PayAppDO payAppDO = payAppMapper.selectById(appId);
        // 校验是否存在
        if (payAppDO == null) {
            throw ServiceExceptionUtil.exception(PayErrorCodeEnum.PAY_APP_NOT_FOUND.getCode());
        }
        // 校验是否禁用
        if (CommonStatusEnum.DISABLE.getValue().equals(payAppDO.getStatus())) {
            throw ServiceExceptionUtil.exception(PayErrorCodeEnum.PAY_APP_IS_DISABLE.getCode());
        }
        return payAppDO;
    }

}
