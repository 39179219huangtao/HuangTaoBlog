package com.hyc.shop.product.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品品牌分页 DTO
 */
@Data
@Accessors(chain = true)
public class ProductBrandPageDTO implements Serializable {

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态 1-开启 2-禁用
     */
    private Integer status;

    @NotNull(message = "页码不能为空")
    private Integer pageNo;

    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

}
