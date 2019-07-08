package com.hyc.shop.product.application.controller.convert;


import com.hyc.shop.product.application.controller.vo.admins.AdminsProductCategoryTreeNodeVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductCategoryVO;
import com.hyc.shop.product.application.controller.vo.users.UsersProductCategoryVO;
import com.hyc.shop.product.bo.ProductCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ProductCategoryConvert {

    @Mapper
    interface Users {

        Users INSTANCE = Mappers.getMapper(Users.class);

        @Mappings({})
        UsersProductCategoryVO convertToVO(ProductCategoryBO category);

        @Mappings({})
        List<UsersProductCategoryVO> convertToVO(List<ProductCategoryBO> categoryList);

    }

    @Mapper
    interface Admins {

        Admins INSTANCE = Mappers.getMapper(Admins.class);

        @Mappings({})
        AdminsProductCategoryTreeNodeVO convert(ProductCategoryBO category);

        @Mappings({})
        AdminsProductCategoryVO convert2(ProductCategoryBO result);

    }

}
