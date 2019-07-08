package com.hyc.shop.product.domain.converter;


import com.hyc.shop.product.bo.ProductBrandBO;
import com.hyc.shop.product.domain.dataobject.ProductBrandDO;
import com.hyc.shop.product.dto.ProductBrandAddDTO;
import com.hyc.shop.product.dto.ProductBrandUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductBrandConvert {

    ProductBrandConvert INSTANCE = Mappers.getMapper(ProductBrandConvert.class);

    @Mappings({})
    List<ProductBrandBO> convert(List<ProductBrandDO> brands);

    @Mappings({})
    ProductBrandBO convert(ProductBrandDO brand);

    @Mappings({})
    ProductBrandDO convert(ProductBrandUpdateDTO brand);

    @Mappings({})
    ProductBrandDO convert(ProductBrandAddDTO brand);

}