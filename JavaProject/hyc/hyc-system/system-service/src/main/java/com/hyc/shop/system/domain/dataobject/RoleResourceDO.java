package com.hyc.shop.system.domain.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hyc.shop.common.dataobject.DeletableDO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * {@link RoleDO} 和 {@link ResourceDO} 的关联表
 */
@TableName("role_resource")
@Data
@Accessors(chain = true)
public class RoleResourceDO extends DeletableDO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 角色编号(外键：{@link RoleDO}
     */
    private Integer roleId;
    /**
     * 资源编号(外键：{@link ResourceDO}
     */
    private Integer resourceId;

}
