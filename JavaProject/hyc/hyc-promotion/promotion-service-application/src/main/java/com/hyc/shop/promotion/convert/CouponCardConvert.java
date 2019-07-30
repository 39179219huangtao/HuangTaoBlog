package com.hyc.shop.promotion.convert;

import com.hyc.shop.promotion.bo.CouponCardBO;
import com.hyc.shop.promotion.bo.CouponCardPageBO;
import com.hyc.shop.promotion.vo.users.UsersCouponCardPageVO;
import com.hyc.shop.promotion.vo.users.UsersCouponCardVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CouponCardConvert {

    CouponCardConvert INSTANCE = Mappers.getMapper(CouponCardConvert.class);

    @Mappings({})
    UsersCouponCardVO convert(CouponCardBO result);

    @Mappings({})
    UsersCouponCardPageVO convert2(CouponCardPageBO result);

//
//    @Mappings({})
//    List<UsersCouponTemplateVO> convertList2(List<CouponTemplateBO> banners);



}
