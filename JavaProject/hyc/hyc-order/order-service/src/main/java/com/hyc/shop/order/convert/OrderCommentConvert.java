package com.hyc.shop.order.convert;


import com.hyc.shop.order.bo.OrderCommentCreateBO;
import com.hyc.shop.order.bo.OrderCommentInfoBO;
import com.hyc.shop.order.bo.OrderCommentStateInfoPageBO;
import com.hyc.shop.order.bo.OrderCommentTimeOutBO;
import com.hyc.shop.order.domain.dataobject.OrderCommentDO;
import com.hyc.shop.order.dto.OrderCommentCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 *
 * 订单评论 convert
 *
 * @author wtz
 * @time 2019-05-31 18:30
 */
@Mapper
public interface OrderCommentConvert {

    OrderCommentConvert INSTANCE = Mappers.getMapper(OrderCommentConvert.class);

    @Mappings({})
    OrderCommentStateInfoPageBO.OrderCommentStateInfoItem convertOrderCommentStateInfoItem(OrderCommentDO orderCommentDO);

    @Mappings({})
    List<OrderCommentStateInfoPageBO.OrderCommentStateInfoItem> convertOrderCommentStateInfoItems(List<OrderCommentDO> orderCommentDOList);

    @Mappings({})
    OrderCommentDO convertOrderCommentDO(OrderCommentCreateDTO orderCommentCreateDTO);

    @Mappings({})
    OrderCommentCreateBO convertOrderCommentCreateBO(OrderCommentDO orderCommentDO);

    @Mappings({})
    OrderCommentInfoBO convertOrderCommentInfoBO(OrderCommentDO orderCommentDO);

    @Mappings({})
    OrderCommentTimeOutBO convertOrderCommentTimeOutBO(OrderCommentDO orderCommentDO);

    @Mappings({})
    List<OrderCommentTimeOutBO> convertOrderCommentTimeOutBOList(List<OrderCommentDO> orderCommentDOList);



}
