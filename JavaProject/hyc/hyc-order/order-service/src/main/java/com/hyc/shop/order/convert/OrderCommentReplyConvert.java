package com.hyc.shop.order.convert;


import com.hyc.shop.order.bo.OrderCommentMerchantReplyBO;
import com.hyc.shop.order.bo.OrderCommentReplyCreateBO;
import com.hyc.shop.order.bo.OrderCommentReplyPageBO;
import com.hyc.shop.order.domain.dataobject.OrderCommentReplyDO;
import com.hyc.shop.order.dto.OrderCommentReplyCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 *
 * 评论回复 convert
 *
 * @author wtz
 * @time 2019-05-31 18:30
 */
@Mapper
public interface OrderCommentReplyConvert {

    OrderCommentReplyConvert INSTANCE = Mappers.getMapper(OrderCommentReplyConvert.class);

    @Mappings({})
    OrderCommentReplyDO convert(OrderCommentReplyCreateDTO orderCommentReplyCreateDTO);

    @Mappings({})
    OrderCommentReplyCreateBO convert(OrderCommentReplyDO orderCommentReplyDO);

    @Mappings({})
    List<OrderCommentMerchantReplyBO> convert(List<OrderCommentReplyDO> orderCommentReplyDOList);

    @Mappings({})
    List<OrderCommentReplyPageBO.OrderCommentReplayItem> convertOrderCommentReplayItem(List<OrderCommentReplyDO> orderCommentReplyDOList);
}
