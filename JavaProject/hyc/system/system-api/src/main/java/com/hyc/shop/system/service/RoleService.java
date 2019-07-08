package com.hyc.shop.system.service;



import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.bo.role.RoleBO;
import com.hyc.shop.system.dto.role.RoleAddDTO;
import com.hyc.shop.system.dto.role.RoleAssignResourceDTO;
import com.hyc.shop.system.dto.role.RolePageDTO;
import com.hyc.shop.system.dto.role.RoleUpdateDTO;

import java.util.Collection;
import java.util.List;

public interface RoleService {

    PageResult<RoleBO> getRolePage(RolePageDTO rolePageDTO);

    /**
     * @return 返回角色列表
     */
    List<RoleBO> getRoleList();

    List<RoleBO> getRoleList(Collection<Integer> ids);

    RoleBO addRole(Integer adminId, RoleAddDTO roleAddDTO);

    Boolean updateRole(Integer adminId, RoleUpdateDTO roleUpdateDTO);

    Boolean deleteRole(Integer adminId, Integer roleId);

    Boolean assignRoleResource(Integer adminId, RoleAssignResourceDTO roleAssignResourceDTO);

}
