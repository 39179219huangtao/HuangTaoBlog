package com.hyc.shop.pay.domain.convert;


import com.hyc.shop.pay.bo.refund.PayRefundBO;
import com.hyc.shop.pay.domain.dataobject.PayRefundDO;
import com.hyc.shop.pay.dto.refund.PayRefundSubmitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PayRefundConvert {

    PayRefundConvert INSTANCE = Mappers.getMapper(PayRefundConvert.class);

    @Mappings({})
    PayRefundDO convert(PayRefundSubmitDTO payRefundSubmitDTO);

    @Mappings({})
    PayRefundBO convert(PayRefundDO refund);

    @Mappings({})
    List<PayRefundBO> convertList(List<PayRefundDO> refunds);

}
