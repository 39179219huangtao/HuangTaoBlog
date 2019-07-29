package com.hyc.shop.promotion;



import com.hyc.shop.common.constant.CommonStatusEnum;
import com.hyc.shop.common.exception.ServiceException;
import com.hyc.shop.common.validator.InEnum;
import com.hyc.shop.promotion.bo.ProductRecommendBO;
import com.hyc.shop.promotion.bo.ProductRecommendPageBO;
import com.hyc.shop.promotion.dto.ProductRecommendAddDTO;
import com.hyc.shop.promotion.dto.ProductRecommendPageDTO;
import com.hyc.shop.promotion.dto.ProductRecommendUpdateDTO;

import java.util.List;

public interface ProductRecommendService {

    List<ProductRecommendBO> getProductRecommendList(Integer type, Integer status);

    ProductRecommendPageBO getProductRecommendPage(ProductRecommendPageDTO productRecommendPageDTO);

    ProductRecommendBO addProductRecommend(Integer adminId, ProductRecommendAddDTO productRecommendAddDTO) throws ServiceException;

    Boolean updateProductRecommend(Integer adminId, ProductRecommendUpdateDTO productRecommendUpdateDTO) throws ServiceException;

    Boolean updateProductRecommendStatus(Integer adminId, Integer productRecommendId,
                                         @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}") Integer status) throws ServiceException;

    Boolean deleteProductRecommend(Integer adminId, Integer productRecommendId);

}
