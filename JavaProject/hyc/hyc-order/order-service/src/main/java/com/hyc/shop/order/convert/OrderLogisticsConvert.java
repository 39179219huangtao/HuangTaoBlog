package com.hyc.shop.order.convert;


import com.hyc.shop.order.bo.OrderLastLogisticsInfoBO;
import com.hyc.shop.order.bo.OrderLogisticsInfoBO;
import com.hyc.shop.order.bo.OrderLogisticsInfoWithOrderBO;
import com.hyc.shop.order.domain.dataobject.OrderLogisticsDO;
import com.hyc.shop.order.domain.dataobject.OrderLogisticsDetailDO;
import com.hyc.shop.order.domain.dataobject.OrderRecipientDO;
import com.hyc.shop.order.dto.OrderDeliveryDTO;
import com.hyc.shop.order.dto.OrderLogisticsUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 订单物流 convert
 *
 * @author Sin
 * @time 2019-03-23 14:39
 */
@Mapper
public interface OrderLogisticsConvert {

    OrderLogisticsConvert INSTANCE = Mappers.getMapper(OrderLogisticsConvert.class);

    @Mappings({})
    OrderLogisticsDO convert(OrderDeliveryDTO orderDelivery);

    @Mappings({})
    OrderLogisticsDO convert(OrderLogisticsUpdateDTO orderLogisticsDTO);

    @Mappings({})
    OrderLogisticsDO convert(OrderRecipientDO orderRecipientDO);

    @Mappings({})
    List<OrderLogisticsInfoWithOrderBO.Logistics> convertLogistics(List<OrderLogisticsDO> orderLogisticsDOList);

    @Mappings({})
    List<OrderLogisticsInfoWithOrderBO.LogisticsDetail> convertLogisticsDetail(List<OrderLogisticsDetailDO> orderLogisticsDOList);

    @Mappings({})
    OrderLogisticsInfoBO convert(OrderLogisticsDO orderLogisticsDO);

    @Mappings({})
    List<OrderLogisticsInfoBO.LogisticsDetail> convert(List<OrderLogisticsDetailDO> orderLogisticsDetailDOList);

    @Mappings({})
    @Named(value = "orderLastLogisticsInfoBO")
    OrderLastLogisticsInfoBO convertOrderLastLogisticsInfoBO(OrderLogisticsDO orderLogisticsDO);

    @Mappings({})
    OrderLastLogisticsInfoBO.LogisticsDetail convertLastLogisticsDetail(OrderLogisticsDetailDO orderLogisticsDetailDO);
}
