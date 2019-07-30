package com.hyc.shop.order.convert;


import com.hyc.shop.order.bo.OrderReturnInfoBO;
import com.hyc.shop.order.bo.OrderReturnListBO;
import com.hyc.shop.order.domain.dataobject.OrderItemDO;
import com.hyc.shop.order.domain.dataobject.OrderReturnDO;
import com.hyc.shop.order.dto.OrderReturnApplyDTO;
import com.hyc.shop.order.dto.OrderReturnCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 订单 return
 *
 * @author Sin
 * @time 2019-03-30 15:46
 */
@Mapper
public interface OrderReturnConvert {

    OrderReturnConvert INSTANCE = Mappers.getMapper(OrderReturnConvert.class);

    @Mappings({})
    OrderReturnDO convert(OrderReturnCreateDTO orderReturnCreate);

    @Mappings({})
    OrderReturnDO convert(OrderReturnApplyDTO orderReturnApplyDTO);

    @Mappings({})
    OrderReturnInfoBO.ReturnInfo convert(OrderReturnDO orderReturnDO);

    @Mappings({})
    List<OrderReturnInfoBO.OrderItem> convert(List<OrderItemDO> orderItemDOList);

    @Mappings({})
    List<OrderReturnListBO.OrderReturn> convertListBO(List<OrderReturnDO> orderReturnDOList);
}
