package com.hyc.shop.product.domain.converter;


import com.hyc.shop.product.bo.ProductCategoryBO;
import com.hyc.shop.product.domain.dataobject.ProductCategoryDO;
import com.hyc.shop.product.dto.ProductCategoryAddDTO;
import com.hyc.shop.product.dto.ProductCategoryUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductCategoryConvert {

    ProductCategoryConvert INSTANCE = Mappers.getMapper(ProductCategoryConvert.class);

    @Mappings({})
    ProductCategoryBO convertToBO(ProductCategoryDO category);

    @Mappings({})
    List<ProductCategoryBO> convertToBO(List<ProductCategoryDO> categoryList);

    @Mappings({})
    ProductCategoryDO convert(ProductCategoryAddDTO productCategoryAddDTO);

    @Mappings({})
    ProductCategoryDO convert(ProductCategoryUpdateDTO productCategoryUpdateDTO);

}