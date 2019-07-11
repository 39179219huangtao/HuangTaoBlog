//package com.hyc.shop.pay.mq;
//
//
//import com.alibaba.fastjson.JSON;
//import com.hyc.shop.common.util.DateUtil;
//import com.hyc.shop.common.util.ExceptionUtil;
//import com.hyc.shop.pay.component.DubboReferencePool;
//import com.hyc.shop.pay.constant.PayTransactionNotifyStatusEnum;
//import com.hyc.shop.pay.domain.dao.PayNotifyLogMapper;
//import com.hyc.shop.pay.domain.dao.PayNotifyTaskMapper;
//import com.hyc.shop.pay.domain.dataobject.PayNotifyLogDO;
//import com.hyc.shop.pay.domain.dataobject.PayNotifyTaskDO;
//import com.hyc.shop.pay.message.AbstractPayNotifySuccessMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Calendar;
//import java.util.Date;
//
//public abstract class AbstractPayNotifySuccessConsumer<T extends AbstractPayNotifySuccessMessage> implements RocketMQListener<T> {
//
//    @Autowired
//    private DubboReferencePool dubboReferencePool;
//
//    @Autowired
//    private PayNotifyTaskMapper payTransactionNotifyTaskMapper;
//    @Autowired
//    private PayNotifyLogMapper payTransactionNotifyLogMapper;
//
//    @Override
//    @Transactional
//    public void onMessage(T message) {
//        // 获得 ReferenceMeta 对象
//        DubboReferencePool.ReferenceMeta referenceMeta = dubboReferencePool.getReferenceMeta(message.getNotifyUrl());
//        // 发起调用
//        String response = null; // RPC / HTTP 调用的响应
//        PayNotifyTaskDO updateTask = new PayNotifyTaskDO() // 更新 PayTransactionNotifyTaskDO 对象
//                .setId(message.getId())
//                .setLastExecuteTime(new Date())
//                .setNotifyTimes(message.getNotifyTimes() + 1);
//        try {
//            response = invoke(message, referenceMeta);
//            if ("success".equals(response)) { // 情况一，请求成功且返回成功
//                // 更新通知成功
//                updateTask.setStatus(PayTransactionNotifyStatusEnum.SUCCESS.getValue());
//                payTransactionNotifyTaskMapper.update(updateTask);
//                // 需要更新支付交易单通知应用成功
//                afterInvokeSuccess(message);
//            } else { // 情况二，请求成功且返回失败
//                // 更新通知请求成功，但是结果失败
//                handleFailure(updateTask, PayTransactionNotifyStatusEnum.REQUEST_SUCCESS.getValue());
//                payTransactionNotifyTaskMapper.update(updateTask);
//            }
//        } catch (Throwable e) { // 请求失败
//            // 更新通知请求失败
//            response = ExceptionUtil.getRootCauseMessage(e);
//            handleFailure(updateTask, PayTransactionNotifyStatusEnum.REQUEST_FAILURE.getValue());
//            payTransactionNotifyTaskMapper.update(updateTask);
//            // 抛出异常，回滚事务
//            throw e; // TODO 芋艿，此处不能抛出异常。因为，会导致 MQ + 定时任务多重试。此处的目标是，事务回滚 + 吃掉事务。另外，最后的 finally 的日志，要插入成功。
//        } finally {
//            // 插入 PayTransactionNotifyLogDO 日志
//            PayNotifyLogDO notifyLog = new PayNotifyLogDO().setNotifyId(message.getId())
//                    .setRequest(JSON.toJSONString(message)).setResponse(response).setStatus(updateTask.getStatus());
//            payTransactionNotifyLogMapper.insert(notifyLog);
//        }
//    }
//
//    private void handleFailure(PayNotifyTaskDO updateTask, Integer defaultStatus) {
//        if (updateTask.getNotifyTimes() >= PayNotifyTaskDO.NOTIFY_FREQUENCY.length) {
//            updateTask.setStatus(PayTransactionNotifyStatusEnum.FAILURE.getValue());
//        } else {
//            updateTask.setNextNotifyTime(DateUtil.addDate(Calendar.SECOND, PayNotifyTaskDO.NOTIFY_FREQUENCY[updateTask.getNotifyTimes()]));
//            updateTask.setStatus(defaultStatus);
//        }
//    }
//
//    protected abstract String invoke(T message, DubboReferencePool.ReferenceMeta referenceMeta);
//
//    protected abstract void afterInvokeSuccess(T message);
//
//}
