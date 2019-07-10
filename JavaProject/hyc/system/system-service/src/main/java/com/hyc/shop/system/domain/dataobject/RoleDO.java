package com.hyc.shop.system.domain.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hyc.shop.common.dataobject.DeletableDO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色实体
 */
@TableName("role")
@Data
@Accessors(chain = true)
public class RoleDO extends DeletableDO {

    /**
     * 角色编号
     */
    private Integer id;
    /**
     * 角色名
     */
    private String name;

}
