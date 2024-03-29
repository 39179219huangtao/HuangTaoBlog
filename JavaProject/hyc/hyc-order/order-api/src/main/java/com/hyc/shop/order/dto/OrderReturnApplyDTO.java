package com.hyc.shop.order.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Sin
 * @time 2019-04-25 21:06
 */
@Data
@Accessors(chain = true)
public class OrderReturnApplyDTO implements Serializable {

    /**
     * 订单编号
     */
    private Integer orderId;
    /**
     * 退货原因(字典值)
     */
    private Integer reason;
    /**
     * 问题描述
     */
    private String describe;
    /**
     * 退款类型
     *
     * - 1、退货退款
     * - 2、退款
     */
    private Integer returnType;

}
