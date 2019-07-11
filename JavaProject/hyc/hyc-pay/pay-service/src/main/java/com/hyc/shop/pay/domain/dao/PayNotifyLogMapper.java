package com.hyc.shop.pay.domain.dao;

import com.hyc.shop.pay.domain.dataobject.PayNotifyLogDO;
import org.springframework.stereotype.Repository;

@Repository
public interface PayNotifyLogMapper {

    void insert(PayNotifyLogDO entity);

}
