package com.hyc.shop.promotion.convert;


import com.hyc.shop.promotion.bo.BannerBO;
import com.hyc.shop.promotion.domain.dataobject.BannerDO;
import com.hyc.shop.promotion.dto.BannerAddDTO;
import com.hyc.shop.promotion.dto.BannerUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BannerConvert {

    BannerConvert INSTANCE = Mappers.getMapper(BannerConvert.class);

    @Mappings({})
    BannerBO convertToBO(BannerDO banner);

    @Mappings({})
    List<BannerBO> convertToBO(List<BannerDO> bannerList);

    @Mappings({})
    BannerDO convert(BannerAddDTO bannerAddDTO);

    @Mappings({})
    BannerDO convert(BannerUpdateDTO bannerUpdateDTO);

}