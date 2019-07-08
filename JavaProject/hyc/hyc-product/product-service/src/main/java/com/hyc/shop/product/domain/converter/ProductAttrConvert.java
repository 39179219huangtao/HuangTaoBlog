package com.hyc.shop.product.domain.converter;


import com.hyc.shop.product.bo.*;
import com.hyc.shop.product.domain.dataobject.ProductAttrDO;
import com.hyc.shop.product.domain.dataobject.ProductAttrValueDO;
import com.hyc.shop.product.dto.ProductAttrAddDTO;
import com.hyc.shop.product.dto.ProductAttrUpdateDTO;
import com.hyc.shop.product.dto.ProductAttrValueAddDTO;
import com.hyc.shop.product.dto.ProductAttrValueUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductAttrConvert {

    ProductAttrConvert INSTANCE = Mappers.getMapper(ProductAttrConvert.class);

    @Mappings({})
    List<ProductAttrDetailBO> convert(List<ProductAttrDO> attrs);

    @Mappings({})
    ProductAttrValueDetailBO convert(ProductAttrValueDO value);

    @Mappings({})
    List<ProductAttrValueDetailBO> convert2(List<ProductAttrValueDO> values);

    @Mappings({})
    List<ProductAttrSimpleBO> convert3(List<ProductAttrDO> attrs);

    @Mappings({})
    ProductAttrValueSimpleBO convert3(ProductAttrValueDO value); // 保证 convert4 能够映射到这个方法

    @Mappings({})
    List<ProductAttrValueSimpleBO> convert4(List<ProductAttrValueDO> values);

    @Mappings({})
    ProductAttrDO convert(ProductAttrAddDTO productAttrAddDTO);

    @Mappings({})
    ProductAttrDO convert(ProductAttrUpdateDTO productAttrUpdateDTO);

    @Mappings({})
    ProductAttrValueDO convert(ProductAttrValueAddDTO productAttrValueAddDTO);

    @Mappings({})
    ProductAttrValueDO convert(ProductAttrValueUpdateDTO productAttrValueUpdateDTO);

    @Mappings({})
    ProductAttrBO convert(ProductAttrDO productAttrDO);

    @Mappings({})
    ProductAttrValueBO convert2(ProductAttrValueDO productAttrValueDO);


}