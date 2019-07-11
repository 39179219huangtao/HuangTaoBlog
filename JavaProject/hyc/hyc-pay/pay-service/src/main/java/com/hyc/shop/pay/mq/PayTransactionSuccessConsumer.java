//package com.hyc.shop.pay.mq;
//
//import com.hyc.shop.pay.component.DubboReferencePool;
//import com.hyc.shop.pay.domain.dao.PayTransactionMapper;
//import com.hyc.shop.pay.domain.dataobject.PayTransactionDO;
//import com.hyc.shop.pay.message.PayTransactionSuccessMessage;
//import org.apache.dubbo.rpc.service.GenericService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.Assert;
//
//import java.util.Date;
//
//@Service
//@RocketMQMessageListener(
//        topic = PayTransactionSuccessMessage.TOPIC,
//        consumerGroup = "pay-consumer-group-" + PayTransactionSuccessMessage.TOPIC
//)
//public class PayTransactionSuccessConsumer extends AbstractPayNotifySuccessConsumer<PayTransactionSuccessMessage>
//        implements RocketMQListener<PayTransactionSuccessMessage> {
//
//    @Autowired
//    private PayTransactionMapper payTransactionMapper;
//
//    @Override
//    protected String invoke(PayTransactionSuccessMessage message, DubboReferencePool.ReferenceMeta referenceMeta) {
//        // 查询支付交易
//        PayTransactionDO transaction = payTransactionMapper.selectById(message.getTransactionId());
//        Assert.notNull(transaction, String.format("回调消息(%s) 订单交易不能为空", message.toString()));
//        // 执行调用
//        GenericService genericService = referenceMeta.getService();
//        String methodName = referenceMeta.getMethodName();
//        return (String) genericService.$invoke(methodName, new String[]{String.class.getName(), Integer.class.getName()},
//                new Object[]{message.getOrderId(), transaction.getPrice()});
//    }
//
//    @Override
//    protected void afterInvokeSuccess(PayTransactionSuccessMessage message) {
//        PayTransactionDO updateTransaction = new PayTransactionDO().setId(message.getTransactionId()).setFinishTime(new Date());
//        payTransactionMapper.update(updateTransaction, null);
//    }
//
//}
