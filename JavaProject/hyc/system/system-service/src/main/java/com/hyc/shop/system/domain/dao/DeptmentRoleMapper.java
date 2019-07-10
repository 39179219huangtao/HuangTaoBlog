package com.hyc.shop.system.domain.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyc.shop.system.domain.dataobject.DeptmentRoleDO;

/**
 * Description:
 *
 * @author: zhenxianyimeng
 * @date: 2019-06-14
 * @time: 19:27
 */
public interface DeptmentRoleMapper extends BaseMapper<DeptmentRoleDO> {

    default int deleteByDeptmentId(Integer deptmentId){
        return delete(new QueryWrapper<DeptmentRoleDO>().eq("deptment_id", deptmentId));
    }

    default int deleteByRoleId(Integer roleId){
        return delete(new QueryWrapper<DeptmentRoleDO>().eq("role_id", roleId));
    }

}
