package com.hyc.shop.product.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Product 规格添加 DTO
 */
@Data
@Accessors(chain = true)
public class ProductAttrAddDTO  implements Serializable {

    /**
     * 名称
     */
    @NotEmpty(message = "规格名不能为空")
    private String name;

}
