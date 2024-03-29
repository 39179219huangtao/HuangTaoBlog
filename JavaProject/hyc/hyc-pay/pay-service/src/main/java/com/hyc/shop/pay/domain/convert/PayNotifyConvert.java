package com.hyc.shop.pay.domain.convert;


import com.hyc.shop.pay.domain.dataobject.PayNotifyTaskDO;
import com.hyc.shop.pay.message.PayRefundSuccessMessage;
import com.hyc.shop.pay.message.PayTransactionSuccessMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayNotifyConvert {

    PayNotifyConvert INSTANCE = Mappers.getMapper(PayNotifyConvert.class);

    @Mappings({
            @Mapping(source = "transaction.transactionId", target = "transactionId"),
            @Mapping(source = "transaction.orderId", target = "orderId"),
    })
    PayTransactionSuccessMessage convertTransaction(PayNotifyTaskDO payTransactionNotifyTaskDO);

    @Mappings({
            @Mapping(source = "refund.transactionId", target = "transactionId"),
            @Mapping(source = "refund.orderId", target = "orderId"),
            @Mapping(source = "refund.refundId", target = "refundId"),
    })
    PayRefundSuccessMessage convertRefund(PayNotifyTaskDO payTransactionNotifyTaskDO);

}
