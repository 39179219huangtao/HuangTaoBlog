package com.hyc.shop.pay.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 支付退款成功的消息对象
 */
@Data
@Accessors(chain = true)
public class PayRefundSuccessMessage extends AbstractPayNotifySuccessMessage {

    public static final String TOPIC = "PAY_REFUND_SUCCESS";

    /**
     * 退款单编号
     */
    private Integer refundId;
    /**
     * 交易编号
     */
    private Integer transactionId;
    /**
     * 应用订单编号
     */
    private String orderId;

}
