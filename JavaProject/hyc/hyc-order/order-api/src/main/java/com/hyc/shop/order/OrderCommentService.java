package com.hyc.shop.order;



import com.hyc.shop.order.bo.*;
import com.hyc.shop.order.dto.OrderCommentCreateDTO;
import com.hyc.shop.order.dto.OrderCommentPageDTO;
import com.hyc.shop.order.dto.OrderCommentStateInfoPageDTO;
import com.hyc.shop.order.dto.OrderCommentTimeOutPageDTO;

import java.util.List;

/**
 * 订单评论模块
 *
 * @author wtz
 * @time 2019-05-14 22:10
 */
public interface OrderCommentService {

    /**
     * 评论创建
     * @param orderCommentCreateDTO
     * @return
     */
    OrderCommentCreateBO createOrderComment(OrderCommentCreateDTO orderCommentCreateDTO);



    /**
     * 获取评论列表的分页
     * @param orderCommentPageDTO
     * @return
     */
    OrderCommentPageBO getOrderCommentPage(OrderCommentPageDTO orderCommentPageDTO);


    /**
     * 获取评论详情
     * @param commentId
     * @return
     */
    OrderCommentInfoBO getOrderCommentInfo(Integer commentId);


    /**
     * 获取订单评论状态详情
     * @param orderCommentStateInfoPageDTO
     * @return
     */
    OrderCommentStateInfoPageBO getOrderCommentStateInfoPage(OrderCommentStateInfoPageDTO orderCommentStateInfoPageDTO);

    /**
     * 获取订单评论超时分页
     * @param orderCommentTimeOutPageDTO
     * @return
     */
    List<OrderCommentTimeOutBO> getOrderCommentTimeOutPage(OrderCommentTimeOutPageDTO orderCommentTimeOutPageDTO);


    /**
     * 批量更新订单评论状态
     * @param orderCommentTimeOutBOList
     */
    void updateBatchOrderCommentState(List<OrderCommentTimeOutBO> orderCommentTimeOutBOList);



}
