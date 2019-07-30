package com.hyc.shop.promotion.convert;


import com.hyc.shop.promotion.bo.ProductRecommendBO;
import com.hyc.shop.promotion.domain.dataobject.ProductRecommendDO;
import com.hyc.shop.promotion.dto.ProductRecommendAddDTO;
import com.hyc.shop.promotion.dto.ProductRecommendUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductRecommendConvert {

    ProductRecommendConvert INSTANCE = Mappers.getMapper(ProductRecommendConvert.class);

    @Mappings({})
    ProductRecommendBO convertToBO(ProductRecommendDO recommend);

    @Mappings({})
    List<ProductRecommendBO> convertToBO(List<ProductRecommendDO> recommendList);

    @Mappings({})
    ProductRecommendDO convert(ProductRecommendAddDTO recommendAddDTO);

    @Mappings({})
    ProductRecommendDO convert(ProductRecommendUpdateDTO recommendUpdateDTO);

}
