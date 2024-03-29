package com.hyc.shop.promotion.constant;


import com.hyc.shop.common.core.IntArrayValuable;

import java.util.Arrays;

public enum RangeTypeEnum implements IntArrayValuable {

    ALL(10, "所有可用"),
    PRODUCT_INCLUDE_PART(20, "部分商品可用，或指定商品可用"),
    PRODUCT_EXCLUDE_PART(21, "部分商品不可用，或指定商品可用"),
    CATEGORY_INCLUDE_PART(30, "部分分类可用，或指定分类可用"),
    CATEGORY_EXCLUDE_PART(31, "部分分类不可用，或指定分类可用"),
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(RangeTypeEnum::getValue).toArray();

    /**
     * 值
     */
    private final Integer value;
    /**
     * 名字
     */
    private final String name;

    RangeTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    @Override
    public int[] array() {
        return ARRAYS;
    }

}
