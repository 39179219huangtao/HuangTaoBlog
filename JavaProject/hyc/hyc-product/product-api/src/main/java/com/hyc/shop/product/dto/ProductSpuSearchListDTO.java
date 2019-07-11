package com.hyc.shop.product.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 商品 Spu 搜索列表 DTO
 */
@Data
@Accessors(chain = true)
public class ProductSpuSearchListDTO implements Serializable {

    /**
     * 商品名
     *
     * 模糊匹配
     */
    private String name;

}
