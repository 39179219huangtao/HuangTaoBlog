package com.hyc.shop.promotion.convert;


import com.hyc.shop.promotion.bo.CouponTemplateBO;
import com.hyc.shop.promotion.domain.dataobject.CouponTemplateDO;
import com.hyc.shop.promotion.dto.CouponCardTemplateAddDTO;
import com.hyc.shop.promotion.dto.CouponCardTemplateUpdateDTO;
import com.hyc.shop.promotion.dto.CouponCodeTemplateAddDTO;
import com.hyc.shop.promotion.dto.CouponCodeTemplateUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CouponTemplateConvert {

    CouponTemplateConvert INSTANCE = Mappers.getMapper(CouponTemplateConvert.class);

//    @Mappings({})
//    CouponTemplateBO convertToBO(CouponTemplateDO banner);
//
    @Mappings({})
    List<CouponTemplateBO> convertToBO(List<CouponTemplateDO> templateList);

    @Mappings({})
    CouponTemplateDO convert(CouponCodeTemplateUpdateDTO template);

    @Mappings({})
    CouponTemplateDO convert(CouponCardTemplateAddDTO template);

    @Mappings({})
    CouponTemplateDO convert(CouponCardTemplateUpdateDTO template);

    @Mappings({})
    CouponTemplateDO convert(CouponCodeTemplateAddDTO template);

    @Mappings({})
    CouponTemplateBO convert(CouponTemplateDO template);

}
