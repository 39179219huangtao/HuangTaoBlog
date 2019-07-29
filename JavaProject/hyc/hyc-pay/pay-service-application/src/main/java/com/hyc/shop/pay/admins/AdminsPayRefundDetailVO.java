package com.hyc.shop.pay.admins;


import com.hyc.shop.pay.bo.refund.PayRefundBO;
import com.hyc.shop.pay.bo.transaction.PayTransactionBO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 支付退款详细 VO
 */
@Data
@Accessors(chain = true)
public class AdminsPayRefundDetailVO extends PayRefundBO { // TODO 芋艿，暂时偷懒下

    /**
     * 支付交易
     */
    private PayTransactionBO transaction;

}

