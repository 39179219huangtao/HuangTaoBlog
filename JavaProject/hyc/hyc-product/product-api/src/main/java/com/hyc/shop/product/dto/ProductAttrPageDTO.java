package com.hyc.shop.product.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品规格分页 DTO
 */
@Data
@Accessors(chain = true)
public class ProductAttrPageDTO implements Serializable {

    private String name;

    @NotNull(message = "页码不能为空")
    private Integer pageNo;
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

}
