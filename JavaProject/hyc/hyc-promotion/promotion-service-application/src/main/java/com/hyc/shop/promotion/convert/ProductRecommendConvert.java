package com.hyc.shop.promotion.convert;


import com.hyc.shop.product.bo.ProductSpuBO;
import com.hyc.shop.promotion.bo.ProductRecommendBO;
import com.hyc.shop.promotion.bo.ProductRecommendPageBO;
import com.hyc.shop.promotion.vo.admins.AdminsProductRecommendPageVO;
import com.hyc.shop.promotion.vo.admins.AdminsProductRecommendVO;
import com.hyc.shop.promotion.vo.users.UsersProductRecommendVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductRecommendConvert {

    ProductRecommendConvert INSTANCE = Mappers.getMapper(ProductRecommendConvert.class);

    @Mappings({})
    AdminsProductRecommendVO convert(ProductRecommendBO bannerBO);

    @Mappings({})
    AdminsProductRecommendPageVO convert(ProductRecommendPageBO result);

    @Mappings({})
    UsersProductRecommendVO convert(ProductSpuBO productSpu);

    //    @Mappings({})
    //    List<UsersProductRecommendVO> convertList(List<ProductRecommendBO> banners);

}
