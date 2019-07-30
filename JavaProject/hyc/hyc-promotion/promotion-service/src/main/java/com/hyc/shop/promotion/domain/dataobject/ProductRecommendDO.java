package com.hyc.shop.promotion.domain.dataobject;


import com.hyc.shop.common.dataobject.DeletableDO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品推荐 DO
 */
@Data
@Accessors(chain = true)
public class ProductRecommendDO extends DeletableDO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 类型
     *
     * {@link ProductRecommendTypeEnum}
     */
    private Integer type;
    /**
     * 商品 Spu 编号
     */
    private Integer productSpuId;
    // TODO 芋艿，商品 spu 名
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     *
     * {@link cn.iocoder.common.framework.constant.CommonStatusEnum}
     */
    private Integer status;
    /**
     * 备注
     */
    private String memo;

}
