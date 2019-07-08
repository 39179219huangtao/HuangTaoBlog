package com.hyc.shop.product.application.controller.convert;


import com.hyc.shop.product.application.controller.vo.admins.AdminsProductSpuDetailVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductSpuPageVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductSpuVO;
import com.hyc.shop.product.application.controller.vo.users.UsersProductSpuDetailVO;
import com.hyc.shop.product.application.controller.vo.users.UsersProductSpuPageVO;
import com.hyc.shop.product.bo.ProductSpuBO;
import com.hyc.shop.product.bo.ProductSpuDetailBO;
import com.hyc.shop.product.bo.ProductSpuPageBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductSpuConvert {

    ProductSpuConvert INSTANCE = Mappers.getMapper(ProductSpuConvert.class);

    @Mappings({})
    AdminsProductSpuDetailVO convert(ProductSpuDetailBO productSpuDetailBO);

//    @Mappings({})
//    CommonResult<AdminsProductSpuDetailVO> convert(CommonResult<ProductSpuDetailBO> result);

    @Mappings({})
    AdminsProductSpuPageVO convert2(ProductSpuPageBO result);

    @Mappings({})
    List<AdminsProductSpuVO> convert3(List<ProductSpuBO> result);

    @Mappings({})
    UsersProductSpuPageVO convert3(ProductSpuPageBO result);

    @Mappings({})
    UsersProductSpuDetailVO convert4(ProductSpuDetailBO result);

}
