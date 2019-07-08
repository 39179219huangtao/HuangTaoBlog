package com.hyc.shop.product.application.controller.convert;


import com.hyc.shop.product.application.controller.vo.admins.AdminsProductAttrPageVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductAttrSimpleVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductAttrVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductAttrValueVO;
import com.hyc.shop.product.bo.ProductAttrBO;
import com.hyc.shop.product.bo.ProductAttrPageBO;
import com.hyc.shop.product.bo.ProductAttrSimpleBO;
import com.hyc.shop.product.bo.ProductAttrValueBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductAttrConvert {

    ProductAttrConvert INSTANCE = Mappers.getMapper(ProductAttrConvert.class);

    @Mappings({})
    AdminsProductAttrPageVO convert2(ProductAttrPageBO result);

    @Mappings({})
    List<AdminsProductAttrSimpleVO> convert(List<ProductAttrSimpleBO> result);

    @Mappings({})
    AdminsProductAttrVO convert3(ProductAttrBO productAttrBO);

    @Mappings({})
    AdminsProductAttrValueVO convert4(ProductAttrValueBO productAttrValueBO);

}
