package com.hyc.shop.system.bo.datadict;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典 BO
 */
@Data
@Accessors(chain = true)
public class DataDictBO implements Serializable {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 大类枚举值
     */
    private String enumValue;
    /**
     * 小类数值
     */
    private String value;
    /**
     * 展示名
     */
    private String displayName;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 备注
     */
    private String memo;
    /**
     * 创建时间
     */
    private Date createTime;

}
