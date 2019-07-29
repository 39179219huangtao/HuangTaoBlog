package com.hyc.shop.pay.convert;


import com.hyc.shop.pay.admins.AdminsPayRefundDetailVO;
import com.hyc.shop.pay.bo.refund.PayRefundBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PayRefundConvert {

    PayRefundConvert INSTANCE = Mappers.getMapper(PayRefundConvert.class);

    @Mappings({})
    List<AdminsPayRefundDetailVO> convertList(List<PayRefundBO> refunds);

}
