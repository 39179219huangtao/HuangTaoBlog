package com.hyc.shop.product.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Product 规格修改 DTO
 */
@Data
@Accessors(chain = true)
public class ProductAttrUpdateDTO implements Serializable {

    /**
     * 规格编号
     */
    @NotNull(message = "规格编号不能为空")
    private Integer id;
    /**
     * 名称
     */
    @NotEmpty(message = "规格名不能为空")
    private String name;


}
