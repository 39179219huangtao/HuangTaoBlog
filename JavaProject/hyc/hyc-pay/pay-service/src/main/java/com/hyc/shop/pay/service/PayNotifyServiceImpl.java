package com.hyc.shop.pay.service;


import com.hyc.shop.common.util.DateUtil;
import com.hyc.shop.pay.constant.PayNotifyType;
import com.hyc.shop.pay.constant.PayTransactionNotifyStatusEnum;
import com.hyc.shop.pay.domain.convert.PayNotifyConvert;
import com.hyc.shop.pay.domain.dao.PayNotifyTaskMapper;
import com.hyc.shop.pay.domain.dataobject.PayNotifyTaskDO;
import com.hyc.shop.pay.domain.dataobject.PayRefundDO;
import com.hyc.shop.pay.domain.dataobject.PayTransactionDO;
import com.hyc.shop.pay.domain.dataobject.PayTransactionExtensionDO;
import com.hyc.shop.pay.message.PayRefundSuccessMessage;
import com.hyc.shop.pay.message.PayTransactionSuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;

@Service
public class PayNotifyServiceImpl {

    @Autowired
    private PayNotifyTaskMapper payTransactionNotifyTaskMapper;

//    @Resource
//    private RocketMQTemplate rocketMQTemplate;

    @Deprecated // 参见 PayRefundSuccessConsumer 类的说明
    public void addRefundNotifyTask(PayRefundDO refund) {
        PayNotifyTaskDO payTransactionNotifyTask = this.createBasePayNotifyTaskDO(refund.getAppId(), refund.getNotifyUrl())
                .setType(PayNotifyType.REFUND.getValue());
        // 设置 Refund 属性
        payTransactionNotifyTask.setRefund(new PayNotifyTaskDO.Refund().setRefundId(refund.getId())
                .setTransactionId(refund.getTransactionId()).setOrderId(refund.getOrderId()));
        // 保存到数据库
        payTransactionNotifyTaskMapper.insert(payTransactionNotifyTask);
        // 发送 MQ 消息
        sendNotifyMessage(payTransactionNotifyTask);
    }

    public void addTransactionNotifyTask(PayTransactionDO transaction, PayTransactionExtensionDO extension) {
        PayNotifyTaskDO payTransactionNotifyTask = this.createBasePayNotifyTaskDO(transaction.getAppId(), transaction.getNotifyUrl())
                .setType(PayNotifyType.TRANSACTION.getValue());
        // 设置 Transaction 属性
        payTransactionNotifyTask.setTransaction(new PayNotifyTaskDO.Transaction().setOrderId(transaction.getOrderId())
                .setTransactionId(extension.getTransactionId()).setTransactionExtensionId(extension.getId()));
        payTransactionNotifyTaskMapper.insert(payTransactionNotifyTask);
        // 3.2 发送 MQ
        sendNotifyMessage(payTransactionNotifyTask);
    }

    private PayNotifyTaskDO createBasePayNotifyTaskDO(String appId, String notifyUrl) {
        return new PayNotifyTaskDO()
                .setAppId(appId)
                .setStatus(PayTransactionNotifyStatusEnum.WAITING.getValue())
                .setNotifyTimes(0).setMaxNotifyTimes(PayNotifyTaskDO.NOTIFY_FREQUENCY.length + 1)
                .setNextNotifyTime(DateUtil.addDate(Calendar.SECOND, PayNotifyTaskDO.NOTIFY_FREQUENCY[0]))
                .setNotifyUrl(notifyUrl);
    }

    public void sendNotifyMessage(PayNotifyTaskDO notifyTask) {
        if (PayNotifyType.TRANSACTION.getValue().equals(notifyTask.getType())) {
//            rocketMQTemplate.convertAndSend(PayTransactionSuccessMessage.TOPIC,
//                    PayNotifyConvert.INSTANCE.convertTransaction(notifyTask));
        } else if (PayNotifyType.REFUND.getValue().equals(notifyTask.getType())) {
//            rocketMQTemplate.convertAndSend(PayRefundSuccessMessage.TOPIC,
//                    PayNotifyConvert.INSTANCE.convertRefund(notifyTask));
        } else {
            throw new IllegalArgumentException(String.format("通知任务(%s) 无法发送通知消息", notifyTask.toString()));
        }
    }

}
