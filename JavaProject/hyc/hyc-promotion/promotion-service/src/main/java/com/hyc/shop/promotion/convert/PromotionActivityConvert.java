package com.hyc.shop.promotion.convert;


import com.hyc.shop.promotion.bo.PromotionActivityBO;
import com.hyc.shop.promotion.domain.dataobject.PromotionActivityDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PromotionActivityConvert {

    PromotionActivityConvert INSTANCE = Mappers.getMapper(PromotionActivityConvert.class);

    @Mappings({})
    PromotionActivityBO convertToBO(PromotionActivityDO activity);

    @Mappings({})
    List<PromotionActivityBO> convertToBO(List<PromotionActivityDO> activityList);

//    @Mappings({})
//    PromotionActivityDO convert(PromotionActivityAddDTO activityAddDTO);
//
//    @Mappings({})
//    PromotionActivityDO convert(PromotionActivityUpdateDTO activityUpdateDTO);

}
