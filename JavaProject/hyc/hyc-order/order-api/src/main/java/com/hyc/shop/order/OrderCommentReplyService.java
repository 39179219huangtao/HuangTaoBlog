package com.hyc.shop.order;



import com.hyc.shop.order.bo.OrderCommentMerchantReplyBO;
import com.hyc.shop.order.bo.OrderCommentReplyCreateBO;
import com.hyc.shop.order.bo.OrderCommentReplyPageBO;
import com.hyc.shop.order.dto.OrderCommentReplyCreateDTO;
import com.hyc.shop.order.dto.OrderCommentReplyPageDTO;

import java.util.List;

/**
 *
 * 订单评论回复模块
 *
 * @author wtz
 * @time 2019-05-29 14:30
 *
 */
public interface OrderCommentReplyService {

    /**
     * 分页获取评论回复
     * @param orderCommentReplyPageDTO
     * @return
     */
    OrderCommentReplyPageBO getOrderCommentReplyPage(OrderCommentReplyPageDTO orderCommentReplyPageDTO);


    /**
     * 评论回复创建
     * @param orderCommentReplyCreateDTO
     * @return
     */
    OrderCommentReplyCreateBO createOrderCommentReply(OrderCommentReplyCreateDTO orderCommentReplyCreateDTO);


    /**
     * 获取商家评论回复
     * @param commentId
     * @return
     */
    List<OrderCommentMerchantReplyBO> getOrderCommentMerchantReply(Integer commentId);



}
