package com.hyc.shop.product.application.controller.convert;


import com.hyc.shop.product.application.controller.vo.admins.AdminsProductBrandVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductBrangPageVO;
import com.hyc.shop.product.bo.ProductBrandBO;
import com.hyc.shop.product.bo.ProductBrangPageBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductBrandConvert {

    ProductBrandConvert INSTANCE = Mappers.getMapper(ProductBrandConvert.class);

    @Mappings({})
    AdminsProductBrandVO convert(ProductBrandBO result);

    @Mappings({})
    AdminsProductBrangPageVO convert(ProductBrangPageBO result);

}
