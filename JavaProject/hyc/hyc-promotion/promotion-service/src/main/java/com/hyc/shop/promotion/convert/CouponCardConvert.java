package com.hyc.shop.promotion.convert;


import com.hyc.shop.promotion.bo.CouponCardAvailableBO;
import com.hyc.shop.promotion.bo.CouponCardBO;
import com.hyc.shop.promotion.bo.CouponCardDetailBO;
import com.hyc.shop.promotion.domain.dataobject.CouponCardDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CouponCardConvert {

    CouponCardConvert INSTANCE = Mappers.getMapper(CouponCardConvert.class);

//    @Mappings({})
//    CouponCardBO convertToBO(CouponCardDO banner);
//
    @Mappings({})
    List<CouponCardBO> convertToBO(List<CouponCardDO> cardList);

    @Mappings({})
    CouponCardBO convert(CouponCardDO card);

    @Mappings({})
    CouponCardDetailBO convert2(CouponCardDO card);

    @Mappings({})
    CouponCardAvailableBO convert2(CouponCardDO card, boolean x); // TODO 芋艿，临时用来解决 mapstruct 无法正确匹配方法的问题

}
