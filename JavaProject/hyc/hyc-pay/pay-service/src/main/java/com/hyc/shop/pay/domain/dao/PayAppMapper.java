package com.hyc.shop.pay.domain.dao;

import com.hyc.shop.pay.domain.dataobject.PayAppDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayAppMapper {

    PayAppDO selectById(@Param("id") String id);

}