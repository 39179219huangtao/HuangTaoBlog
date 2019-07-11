package com.hyc.shop.pay.domain.convert;


import com.hyc.shop.pay.bo.transaction.PayTransactionBO;
import com.hyc.shop.pay.domain.dataobject.PayTransactionDO;
import com.hyc.shop.pay.domain.dataobject.PayTransactionExtensionDO;
import com.hyc.shop.pay.dto.transaction.PayTransactionCreateDTO;
import com.hyc.shop.pay.dto.transaction.PayTransactionSubmitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PayTransactionConvert {

    PayTransactionConvert INSTANCE = Mappers.getMapper(PayTransactionConvert.class);

    @Mappings({})
    PayTransactionDO convert(PayTransactionCreateDTO payTransactionCreateDTO);

    @Mappings({})
    PayTransactionBO convert(PayTransactionDO payTransactionDO);

    @Mappings({})
    List<PayTransactionBO> convertList(List<PayTransactionDO> list);

    @Mappings({})
    PayTransactionExtensionDO convert(PayTransactionSubmitDTO payTransactionSubmitDTO);

}
