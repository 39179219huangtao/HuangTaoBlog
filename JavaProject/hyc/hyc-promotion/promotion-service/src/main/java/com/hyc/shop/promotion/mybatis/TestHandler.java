package com.hyc.shop.promotion.mybatis;


import com.hyc.shop.common.mybatis.JSONTypeHandler;
import com.hyc.shop.promotion.domain.dataobject.PromotionActivityDO;

public class TestHandler extends JSONTypeHandler<PromotionActivityDO.TimeLimitedDiscount> {

    public TestHandler(Class<PromotionActivityDO.TimeLimitedDiscount> clazz) {
        super(clazz);
    }

}
