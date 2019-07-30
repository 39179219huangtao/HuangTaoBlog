package com.hyc.shop.order.convert;


import com.hyc.shop.order.bo.CalcOrderPriceBO;
import com.hyc.shop.order.bo.CartItemBO;
import com.hyc.shop.order.domain.dataobject.CartItemDO;
import com.hyc.shop.product.bo.ProductSkuDetailBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartConvert {

    CartConvert INSTANCE = Mappers.getMapper(CartConvert.class);

    CalcOrderPriceBO.Item convert(ProductSkuDetailBO sku);

    List<CartItemBO> convert(List<CartItemDO> items);

}
