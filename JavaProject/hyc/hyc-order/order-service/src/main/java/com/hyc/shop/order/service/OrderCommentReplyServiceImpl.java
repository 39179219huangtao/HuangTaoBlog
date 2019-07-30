package com.hyc.shop.order.service;


import com.hyc.shop.order.OrderCommentReplyService;
import com.hyc.shop.order.bo.OrderCommentMerchantReplyBO;
import com.hyc.shop.order.bo.OrderCommentReplyCreateBO;
import com.hyc.shop.order.bo.OrderCommentReplyPageBO;
import com.hyc.shop.order.constant.OrderCommentRelpyTypeEnum;
import com.hyc.shop.order.constant.OrderReplyUserTypeEnum;
import com.hyc.shop.order.convert.OrderCommentReplyConvert;
import com.hyc.shop.order.domain.dao.OrderCommentReplayMapper;
import com.hyc.shop.order.domain.dataobject.OrderCommentReplyDO;
import com.hyc.shop.order.dto.OrderCommentReplyCreateDTO;
import com.hyc.shop.order.dto.OrderCommentReplyPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * 订单评论回复 service impl
 *
 * @author wtz
 * @time 2019-05-31 18:30
 */
@Service
@org.apache.dubbo.config.annotation.Service(validation = "true",version = "${dubbo.provider.OrderCommentReplyService.version}")
public class OrderCommentReplyServiceImpl implements OrderCommentReplyService {

    @Autowired
    private OrderCommentReplayMapper orderCommentReplayMapper;

    /**
     * 分页获取评论回复
     * @param orderCommentReplyPageDTO
     * @return
     */
    @Override
    public OrderCommentReplyPageBO getOrderCommentReplyPage(OrderCommentReplyPageDTO orderCommentReplyPageDTO) {
        OrderCommentReplyPageBO orderCommentReplyPageBO=new OrderCommentReplyPageBO();
        //评论回复总数
        Integer totalCount=orderCommentReplayMapper.selectCommentReplyTotalCountByCommentId(orderCommentReplyPageDTO.getCommentId(),
                orderCommentReplyPageDTO.getUserType());
        //分页获取评论回复
        List<OrderCommentReplyDO> orderCommentReplyDOList=orderCommentReplayMapper.selectCommentReplyPage(orderCommentReplyPageDTO);
        orderCommentReplyPageBO.setTotal(totalCount);
        orderCommentReplyPageBO.setOrderCommentReplayItems(OrderCommentReplyConvert.INSTANCE.convertOrderCommentReplayItem(orderCommentReplyDOList));
        return orderCommentReplyPageBO;
    }


    /**
     * 创建评论回复
     * @param orderCommentReplyCreateDTO
     * @return
     */
    @Override
    public OrderCommentReplyCreateBO createOrderCommentReply(OrderCommentReplyCreateDTO orderCommentReplyCreateDTO) {
        OrderCommentReplyDO orderCommentReplyDO=OrderCommentReplyConvert.INSTANCE.convert(orderCommentReplyCreateDTO);
        orderCommentReplyDO.setCreateTime(new Date());

        Integer replyType=orderCommentReplyCreateDTO.getCommentId()==orderCommentReplyCreateDTO.getParentId()?
                OrderCommentRelpyTypeEnum.COMMENT_REPLY.getValue():OrderCommentRelpyTypeEnum.REPLY_REPLY.getValue();

        orderCommentReplyDO.setReplyType(replyType);

        orderCommentReplayMapper.insert(orderCommentReplyDO);

        return OrderCommentReplyConvert.INSTANCE.convert(orderCommentReplyDO);
    }

    /**
     * 获取商家评论回复
     * @param commentId
     * @return
     */
    @Override
    public List<OrderCommentMerchantReplyBO> getOrderCommentMerchantReply(Integer commentId) {
        List<OrderCommentReplyDO> orderCommentReplyDOList=orderCommentReplayMapper.selectCommentMerchantReplyByCommentIdAndUserType(commentId,
                OrderReplyUserTypeEnum.MERCHANT.getValue());
        return OrderCommentReplyConvert.INSTANCE.convert(orderCommentReplyDOList);
    }
}
