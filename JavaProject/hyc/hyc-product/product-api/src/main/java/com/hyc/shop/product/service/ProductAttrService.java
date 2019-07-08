package com.hyc.shop.product.service;

import com.hyc.shop.common.constant.CommonStatusEnum;
import com.hyc.shop.common.validator.InEnum;
import com.hyc.shop.product.bo.ProductAttrBO;
import com.hyc.shop.product.bo.ProductAttrPageBO;
import com.hyc.shop.product.bo.ProductAttrSimpleBO;
import com.hyc.shop.product.bo.ProductAttrValueBO;
import com.hyc.shop.product.dto.*;

import java.util.List;

public interface ProductAttrService {

    ProductAttrPageBO getProductAttrPage(ProductAttrPageDTO productAttrPageDTO);

    /**
     * 获得规格属性数组
     *
     * 注意，该方法过滤了禁用的规格
     *
     * @return 规格属性数组
     */
    List<ProductAttrSimpleBO> getProductAttrList();

    ProductAttrBO addProductAttr(Integer adminId, ProductAttrAddDTO productAttrAddDTO);

    Boolean updateProductAttr(Integer adminId, ProductAttrUpdateDTO productAttrUpdateDTO);

    Boolean updateProductAttrStatus(Integer adminId, Integer productAttrId,
                                    @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}") Integer status);

    ProductAttrValueBO addProductAttrValue(Integer adminId, ProductAttrValueAddDTO productAttrValueAddDTO);

    Boolean updateProductAttrValue(Integer adminId, ProductAttrValueUpdateDTO productAttrValueUpdateDTO);

    Boolean updateProductAttrValueStatus(Integer adminId, Integer productAttrValueId,
                                         @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}") Integer status);

}
