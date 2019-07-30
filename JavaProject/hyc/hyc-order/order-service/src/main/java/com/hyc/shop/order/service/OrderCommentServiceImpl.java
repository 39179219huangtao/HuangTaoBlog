package com.hyc.shop.order.service;


import com.hyc.shop.order.OrderCommentService;
import com.hyc.shop.order.bo.*;
import com.hyc.shop.order.constant.OrderCommentStatusEnum;
import com.hyc.shop.order.constant.OrderReplyUserTypeEnum;
import com.hyc.shop.order.convert.OrderCommentConvert;
import com.hyc.shop.order.domain.dao.OrderCommentMapper;
import com.hyc.shop.order.domain.dao.OrderCommentReplayMapper;
import com.hyc.shop.order.domain.dataobject.OrderCommentDO;
import com.hyc.shop.order.domain.dataobject.OrderCommentReplyDO;
import com.hyc.shop.order.dto.OrderCommentCreateDTO;
import com.hyc.shop.order.dto.OrderCommentPageDTO;
import com.hyc.shop.order.dto.OrderCommentStateInfoPageDTO;
import com.hyc.shop.order.dto.OrderCommentTimeOutPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 订单评论 service impl
 *
 * @author wtz
 * @time 2019
 */
@Service
@org.apache.dubbo.config.annotation.Service(validation = "true", version = "${dubbo.provider.OrderCommentService.version}")
public class OrderCommentServiceImpl implements OrderCommentService {

    @Autowired
    private OrderCommentMapper orderCommentMapper;

    @Autowired
    private OrderCommentReplayMapper orderCommentReplayMapper;


    @Override
    public OrderCommentCreateBO createOrderComment(OrderCommentCreateDTO orderCommentCreateDTO) {
        OrderCommentDO orderCommentDO= OrderCommentConvert.INSTANCE.convertOrderCommentDO(orderCommentCreateDTO);
        orderCommentDO.setCreateTime(new Date());
        orderCommentMapper.insert(orderCommentDO);
        return OrderCommentConvert.INSTANCE.convertOrderCommentCreateBO(orderCommentDO);
    }

    @Override
    public OrderCommentPageBO getOrderCommentPage(OrderCommentPageDTO orderCommentPageDTO) {
        OrderCommentPageBO orderCommentPageBO=new OrderCommentPageBO();
        //分页内容
        List<OrderCommentDO> orderCommentDOList=orderCommentMapper.selectCommentPage(orderCommentPageDTO);
        //分页评论的 id
        List<Integer> commentIds=orderCommentDOList.stream().map(x->x.getId()).collect(Collectors.toList());
        //获取商家最新的评论回复
        List<OrderCommentReplyDO> orderCommentReplyDOList=orderCommentReplayMapper.selectCommentNewMerchantReplyByCommentIds(commentIds,
                OrderReplyUserTypeEnum.MERCHANT.getValue());
        //评论组装
        List<OrderCommentPageBO.OrderCommentItem> orderCommentItemList=orderCommentDOList.stream()
                .flatMap(x->orderCommentReplyDOList.stream()
                        .filter(y->x.getId()==y.getCommentId())
                        .map(y->new OrderCommentPageBO.OrderCommentItem(x.getId(),x.getUserAvatar(),x.getUserNickName(),x.getStar(),
                                x.getCommentContent(),x.getCommentPics(),x.getReplayCount(),x.getLikeCount(),x.getCreateTime(),y.getReplyContent()))
                ).collect(Collectors.toList());
        //总数
        int totalCount=orderCommentMapper.selectCommentTotalCountByProductSkuId(orderCommentPageDTO.getProductSkuId());
        orderCommentPageBO.setOrderCommentItems(orderCommentItemList);
        orderCommentPageBO.setTotal(totalCount);
        return orderCommentPageBO;
    }


    @Override
    public OrderCommentInfoBO getOrderCommentInfo(Integer commentId) {
        //查询评论详情
        OrderCommentDO orderCommentDO=orderCommentMapper.selectCommentInfoByCommentId(commentId);
        return OrderCommentConvert.INSTANCE.convertOrderCommentInfoBO(orderCommentDO);
    }

    @Override
    public OrderCommentStateInfoPageBO getOrderCommentStateInfoPage(OrderCommentStateInfoPageDTO orderCommentStateInfoPageDTO) {
        OrderCommentStateInfoPageBO orderCommentStateInfoPageBO=new OrderCommentStateInfoPageBO();
        //总数
        int total=orderCommentMapper.selectOrderCommentStateInfoTotal(orderCommentStateInfoPageDTO.getUserId(),
                orderCommentStateInfoPageDTO.getCommentState());
        //查询评论状态详情
        List<OrderCommentDO> orderCommentDOList=orderCommentMapper.selectOrderCommentStateInfoPage(orderCommentStateInfoPageDTO);
        //转化评论状态详情
        List<OrderCommentStateInfoPageBO.OrderCommentStateInfoItem> orderCommentStateInfoItemList=
                OrderCommentConvert.INSTANCE.convertOrderCommentStateInfoItems(orderCommentDOList);
        orderCommentStateInfoPageBO.setTotal(total);
        orderCommentStateInfoPageBO.setOrderCommentStateInfoItems(orderCommentStateInfoItemList);
        return orderCommentStateInfoPageBO;
    }

    @Override
    public List<OrderCommentTimeOutBO> getOrderCommentTimeOutPage(OrderCommentTimeOutPageDTO orderCommentTimeOutPageDTO) {
        List<OrderCommentDO> orderCommentDOList=orderCommentMapper.selectOrderCommentTimeOutPage(orderCommentTimeOutPageDTO);
        return OrderCommentConvert.INSTANCE.convertOrderCommentTimeOutBOList(orderCommentDOList);
    }

    @Override
    public void updateBatchOrderCommentState(List<OrderCommentTimeOutBO> orderCommentTimeOutBOList) {
        orderCommentMapper.updateBatchOrderCommentState(OrderCommentStatusEnum.SUCCESS_COMMENT.getValue(),orderCommentTimeOutBOList);
    }
}