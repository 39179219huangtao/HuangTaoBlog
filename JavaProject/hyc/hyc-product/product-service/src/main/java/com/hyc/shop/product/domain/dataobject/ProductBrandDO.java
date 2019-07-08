package com.hyc.shop.product.domain.dataobject;

import com.hyc.shop.common.dataobject.DeletableDO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Product 品牌
 */
@Data
@Accessors(chain = true)
public class ProductBrandDO extends DeletableDO {

    /**
     * 规格编号
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 状态
     *
     * 1-开启
     * 2-禁用
     */
    private Integer status;

}
