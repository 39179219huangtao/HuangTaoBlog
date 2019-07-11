package com.hyc.shop.pay.service;



import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.pay.bo.transaction.PayTransactionBO;
import com.hyc.shop.pay.bo.transaction.PayTransactionPageBO;
import com.hyc.shop.pay.bo.transaction.PayTransactionSubmitBO;
import com.hyc.shop.pay.dto.transaction.PayTransactionCreateDTO;
import com.hyc.shop.pay.dto.transaction.PayTransactionGetDTO;
import com.hyc.shop.pay.dto.transaction.PayTransactionPageDTO;
import com.hyc.shop.pay.dto.transaction.PayTransactionSubmitDTO;

import java.util.Collection;
import java.util.List;

public interface PayTransactionService {

    PayTransactionBO getTransaction(PayTransactionGetDTO payTransactionGetDTO);

    PayTransactionBO createTransaction(PayTransactionCreateDTO payTransactionCreateDTO);

    PayTransactionSubmitBO submitTransaction(PayTransactionSubmitDTO payTransactionSubmitDTO);

    /**
     * 更新交易支付成功
     *
     * 该接口用于不同支付平台，支付成功后，回调该接口
     *
     * @param payChannel 支付渠道
     * @param params 回调参数。
     *               因为不同平台，能够提供的参数不同，所以使用 String 类型统一接收，然后在使用不同的 AbstractPaySDK 进行处理。
     * @return 是否支付成功
     */
    Boolean updateTransactionPaySuccess(Integer payChannel, String params);

    List<PayTransactionBO> getTransactionList(Collection<Integer> ids);

    PayTransactionPageBO getTransactionPage(PayTransactionPageDTO payTransactionPageDTO);

    CommonResult cancelTransaction(); // TODO 1. params 2. result

}
