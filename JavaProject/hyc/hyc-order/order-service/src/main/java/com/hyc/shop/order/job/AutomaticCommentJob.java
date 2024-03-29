//package com.hyc.shop.order.job;
//
//
//import com.hyc.shop.order.OrderCommentService;
//import com.hyc.shop.order.bo.OrderCommentTimeOutBO;
//import com.hyc.shop.order.constant.OrderCommentStatusEnum;
//import com.hyc.shop.order.dto.OrderCommentTimeOutPageDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * 超时以后自动生成评论
// *
// * @author wtz
// * @time 2019-06-15 10:26
// */
//@Component
//@JobHandler("automaticCommentJob")
//public class AutomaticCommentJob extends IJobHandler {
//
//    /**
//     * 默认生成订单7天以后的自动生成订单评论
//     */
//    private static final Integer OVERDAYCOUNT=7;
//
//    private static final Integer PAGESIZE=1000;
//
//    @Autowired
//    private OrderCommentService orderCommentService;
//
//    @Override
//    public ReturnT<String> execute(String param) throws Exception {
//        Integer overDayCount=OVERDAYCOUNT;
//
//        if (param.isEmpty()){
//            overDayCount=Integer.parseInt(param);
//        }
//
//        for (int i=0;;i++){
//
//            OrderCommentTimeOutPageDTO orderCommentTimeOutPageDTO=new OrderCommentTimeOutPageDTO();
//            orderCommentTimeOutPageDTO.setOverDay(overDayCount);
//            orderCommentTimeOutPageDTO.setCommentState(OrderCommentStatusEnum.WAIT_COMMENT.getValue());
//            orderCommentTimeOutPageDTO.setPageNo(i);
//            orderCommentTimeOutPageDTO.setPageSize(PAGESIZE);
//
//            List<OrderCommentTimeOutBO> orderCommentTimeOutBOList=orderCommentService.getOrderCommentTimeOutPage(orderCommentTimeOutPageDTO);
//
//            //为空时候跳出循环
//            if (orderCommentTimeOutBOList.isEmpty()){
//                break;
//            }
//            //批量更新
//            orderCommentService.updateBatchOrderCommentState(orderCommentTimeOutBOList);
//
//        }
//        return null;
//    }
//
//
//}
