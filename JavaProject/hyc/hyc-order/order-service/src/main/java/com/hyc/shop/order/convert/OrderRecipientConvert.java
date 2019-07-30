package com.hyc.shop.order.convert;


import com.hyc.shop.admin.bo.UserAddressBO;
import com.hyc.shop.order.bo.OrderInfoBO;
import com.hyc.shop.order.bo.OrderRecipientBO;
import com.hyc.shop.order.domain.dataobject.OrderRecipientDO;
import com.hyc.shop.order.dto.OrderCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 订单收件人信息
 *
 * @author Sin
 * @time 2019-03-31 12:50
 */
@Mapper
public interface OrderRecipientConvert {

    OrderRecipientConvert INSTANCE = Mappers.getMapper(OrderRecipientConvert.class);

    @Mappings({})
    OrderRecipientDO convert(OrderCreateDTO orderCreateDTO);

    @Mappings({})
    OrderRecipientDO convert(UserAddressBO userAddressBO);

    @Mappings({})
    OrderRecipientBO convert(OrderRecipientDO orderRecipientDO);

    @Mappings({})
    List<OrderRecipientBO> convert(List<OrderRecipientDO> orderRecipientDOList);

    @Mappings({})
    OrderInfoBO.Recipient convertOrderInfoRecipient(OrderRecipientDO orderRecipientDO);
}
